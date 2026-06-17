package org.jupnp.transport;

import defpackage.j02;
import defpackage.n02;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.NetworkAddress;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.protocol.ProtocolCreationException;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.protocol.ReceivingAsync;
import org.jupnp.transport.spi.DatagramIO;
import org.jupnp.transport.spi.InitializationException;
import org.jupnp.transport.spi.MulticastReceiver;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.NoNetworkException;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamServer;
import org.jupnp.transport.spi.UpnpStream;
import org.jupnp.util.Exceptions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RouterImpl implements Router {
    protected UpnpServiceConfiguration configuration;
    protected final Map<InetAddress, DatagramIO> datagramIOs;
    protected volatile boolean enabled;
    private final j02 logger = n02.k(Router.class);
    protected final Map<NetworkInterface, MulticastReceiver> multicastReceivers;
    protected NetworkAddressFactory networkAddressFactory;
    protected ProtocolFactory protocolFactory;
    protected Lock readLock;
    protected ReentrantReadWriteLock routerLock;
    protected StreamClient streamClient;
    protected final Map<InetAddress, StreamServer> streamServers;
    protected Lock writeLock;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RouterImpl(UpnpServiceConfiguration upnpServiceConfiguration, ProtocolFactory protocolFactory) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        this.routerLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.routerLock.writeLock();
        this.multicastReceivers = new HashMap();
        this.datagramIOs = new HashMap();
        this.streamServers = new HashMap();
        this.configuration = upnpServiceConfiguration;
        this.protocolFactory = protocolFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public void broadcast(byte[] bArr) {
        lock(this.readLock);
        try {
            if (this.enabled) {
                for (Map.Entry<InetAddress, DatagramIO> entry : this.datagramIOs.entrySet()) {
                    InetAddress broadcastAddress = this.networkAddressFactory.getBroadcastAddress(entry.getKey());
                    if (broadcastAddress != null) {
                        this.logger.q("Sending UDP datagram to broadcast address: {}", broadcastAddress.getHostAddress());
                        entry.getValue().send(new DatagramPacket(bArr, bArr.length, broadcastAddress, 9));
                    }
                }
            } else {
                this.logger.q("Router disabled, not broadcasting bytes: {}", Integer.valueOf(bArr.length));
            }
            unlock(this.readLock);
        } catch (Throwable th) {
            unlock(this.readLock);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public boolean disable() {
        lock(this.writeLock);
        try {
            if (!this.enabled) {
                unlock(this.writeLock);
                return false;
            }
            this.logger.b("Disabling network services...");
            if (this.streamClient != null) {
                this.logger.b("Stopping stream client connection management/pool");
                this.streamClient.stop();
                this.streamClient = null;
            }
            for (Map.Entry<InetAddress, StreamServer> entry : this.streamServers.entrySet()) {
                this.logger.q("Stopping stream server on address: {}", entry.getKey());
                entry.getValue().stop();
            }
            this.streamServers.clear();
            for (Map.Entry<NetworkInterface, MulticastReceiver> entry2 : this.multicastReceivers.entrySet()) {
                this.logger.q("Stopping multicast receiver on interface: {}", entry2.getKey().getDisplayName());
                entry2.getValue().stop();
            }
            this.multicastReceivers.clear();
            for (Map.Entry<InetAddress, DatagramIO> entry3 : this.datagramIOs.entrySet()) {
                this.logger.q("Stopping datagram I/O on address: {}", entry3.getKey());
                entry3.getValue().stop();
            }
            this.datagramIOs.clear();
            this.networkAddressFactory = null;
            this.enabled = false;
            unlock(this.writeLock);
            return true;
        } catch (Throwable th) {
            unlock(this.writeLock);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public boolean enable() {
        lock(this.writeLock);
        try {
            if (!this.enabled) {
                try {
                    this.logger.b("Starting networking services...");
                    NetworkAddressFactory networkAddressFactoryCreateNetworkAddressFactory = getConfiguration().createNetworkAddressFactory();
                    this.networkAddressFactory = networkAddressFactoryCreateNetworkAddressFactory;
                    startInterfaceBasedTransports(networkAddressFactoryCreateNetworkAddressFactory.getNetworkInterfaces());
                    startAddressBasedTransports(this.networkAddressFactory.getBindAddresses());
                    if (!this.networkAddressFactory.hasUsableNetwork()) {
                        throw new NoNetworkException("No usable network interface and/or addresses available, check the log for errors.");
                    }
                    this.streamClient = getConfiguration().createStreamClient();
                    this.enabled = true;
                    return true;
                } catch (InitializationException e) {
                    handleStartFailure(e);
                }
            }
            unlock(this.writeLock);
            return false;
        } finally {
            unlock(this.writeLock);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public List<NetworkAddress> getActiveStreamServers(InetAddress inetAddress) {
        StreamServer streamServer;
        lock(this.readLock);
        try {
            if (!this.enabled || this.streamServers.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (inetAddress == null || (streamServer = this.streamServers.get(inetAddress)) == null) {
                for (Map.Entry<InetAddress, StreamServer> entry : this.streamServers.entrySet()) {
                    arrayList.add(new NetworkAddress(entry.getKey(), entry.getValue().getPort(), this.networkAddressFactory.getHardwareAddress(entry.getKey())));
                }
            } else {
                arrayList.add(new NetworkAddress(inetAddress, streamServer.getPort(), this.networkAddressFactory.getHardwareAddress(inetAddress)));
            }
            return arrayList;
        } finally {
            unlock(this.readLock);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public UpnpServiceConfiguration getConfiguration() {
        return this.configuration;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLockTimeoutMillis() {
        return 6000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public void handleStartFailure(InitializationException initializationException) {
        boolean z = initializationException instanceof NoNetworkException;
        j02 j02Var = this.logger;
        if (z) {
            j02Var.info("Unable to initialize network router, no network found.");
        } else {
            j02Var.a("Unable to initialize network router", initializationException);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public boolean isEnabled() {
        return this.enabled;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void lock(Lock lock, int i) throws RouterException {
        try {
            this.logger.i("Trying to obtain lock with timeout milliseconds '{}': {}", Integer.valueOf(i), lock.getClass().getSimpleName());
            if (lock.tryLock(i, TimeUnit.MILLISECONDS)) {
                this.logger.h("Acquired router lock: {}", lock.getClass().getSimpleName());
                return;
            }
            throw new RouterException("Router wasn't available exclusively after waiting " + i + "ms, lock failed: " + lock.getClass().getSimpleName());
        } catch (InterruptedException e) {
            throw new RouterException("Interruption while waiting for exclusive access: ".concat(lock.getClass().getSimpleName()), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public void received(IncomingDatagramMessage incomingDatagramMessage) {
        if (!this.enabled) {
            this.logger.q("Router disabled, ignoring incoming message: {}", incomingDatagramMessage);
            return;
        }
        try {
            ReceivingAsync receivingAsyncCreateReceivingAsync = getProtocolFactory().createReceivingAsync(incomingDatagramMessage);
            j02 j02Var = this.logger;
            if (receivingAsyncCreateReceivingAsync == null) {
                j02Var.h("No protocol, ignoring received message: {}", incomingDatagramMessage);
            } else {
                j02Var.q("Received asynchronous message: {}", incomingDatagramMessage);
                getConfiguration().getRemoteListenerExecutor().execute(receivingAsyncCreateReceivingAsync);
            }
        } catch (ProtocolCreationException e) {
            this.logger.u("Handling received datagram failed", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public StreamResponseMessage send(StreamRequestMessage streamRequestMessage) {
        lock(this.readLock);
        try {
            if (this.enabled) {
                StreamClient streamClient = this.streamClient;
                j02 j02Var = this.logger;
                if (streamClient != null) {
                    j02Var.q("Sending via TCP unicast stream: {}", streamRequestMessage);
                    try {
                        return this.streamClient.sendRequest(streamRequestMessage);
                    } catch (InterruptedException e) {
                        throw new RouterException("Sending stream request was interrupted", e);
                    }
                }
                j02Var.q("No StreamClient available, not sending: {}", streamRequestMessage);
            } else {
                this.logger.q("Router disabled, not sending stream request: {}", streamRequestMessage);
            }
            return null;
        } finally {
            unlock(this.readLock);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.Router
    public void shutdown() {
        disable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void startAddressBasedTransports(Iterator<InetAddress> it) {
        while (it.hasNext()) {
            InetAddress next = it.next();
            StreamServer streamServerCreateStreamServer = getConfiguration().createStreamServer(this.networkAddressFactory);
            j02 j02Var = this.logger;
            if (streamServerCreateStreamServer == null) {
                j02Var.c("Configuration did not create a StreamServer for: {}", next);
            } else {
                try {
                    j02Var.q("Init stream server on address: {}", next);
                    streamServerCreateStreamServer.init(next, this);
                    this.streamServers.put(next, streamServerCreateStreamServer);
                } catch (InitializationException e) {
                    Throwable thUnwrap = Exceptions.unwrap(e);
                    if (!(thUnwrap instanceof BindException)) {
                        throw e;
                    }
                    this.logger.m("Failed to init StreamServer. Removing unusable address: {}", next, thUnwrap);
                    it.remove();
                }
            }
            DatagramIO datagramIOCreateDatagramIO = getConfiguration().createDatagramIO(this.networkAddressFactory);
            j02 j02Var2 = this.logger;
            if (datagramIOCreateDatagramIO == null) {
                j02Var2.c("Configuration did not create a StreamServer for: {}", next);
            } else {
                j02Var2.q("Init datagram I/O on address: {}", next);
                datagramIOCreateDatagramIO.init(next, this.networkAddressFactory.getMulticastResponsePort(), this, getConfiguration().getDatagramProcessor());
                this.datagramIOs.put(next, datagramIOCreateDatagramIO);
            }
        }
        for (Map.Entry<InetAddress, StreamServer> entry : this.streamServers.entrySet()) {
            this.logger.q("Starting stream server on address: {}", entry.getKey());
            getConfiguration().getStreamServerExecutorService().execute(entry.getValue());
        }
        for (Map.Entry<InetAddress, DatagramIO> entry2 : this.datagramIOs.entrySet()) {
            this.logger.q("Starting datagram I/O on address: {}", entry2.getKey());
            getConfiguration().getDatagramIOExecutor().execute(entry2.getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void startInterfaceBasedTransports(Iterator<NetworkInterface> it) {
        while (it.hasNext()) {
            NetworkInterface next = it.next();
            MulticastReceiver multicastReceiverCreateMulticastReceiver = getConfiguration().createMulticastReceiver(this.networkAddressFactory);
            j02 j02Var = this.logger;
            if (multicastReceiverCreateMulticastReceiver == null) {
                j02Var.c("Configuration did not create a MulticastReceiver for: {}", next);
            } else {
                j02Var.q("Init multicast receiver on interface: {}", next.getDisplayName());
                multicastReceiverCreateMulticastReceiver.init(next, this, this.networkAddressFactory, getConfiguration().getDatagramProcessor());
                this.multicastReceivers.put(next, multicastReceiverCreateMulticastReceiver);
            }
        }
        for (Map.Entry<NetworkInterface, MulticastReceiver> entry : this.multicastReceivers.entrySet()) {
            this.logger.q("Starting multicast receiver on interface: {}", entry.getKey().getDisplayName());
            getConfiguration().getMulticastReceiverExecutor().execute(entry.getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void unlock(Lock lock) {
        this.logger.h("Releasing router lock: {}", lock.getClass().getSimpleName());
        lock.unlock();
    }

    @Override // org.jupnp.transport.Router
    public void received(UpnpStream upnpStream) {
        boolean z = this.enabled;
        j02 j02Var = this.logger;
        if (!z) {
            j02Var.q("Router disabled, ignoring incoming: {}", upnpStream);
        } else {
            j02Var.q("Received synchronous stream: {}", upnpStream);
            getConfiguration().getSyncProtocolExecutorService().execute(upnpStream);
        }
    }

    public RouterImpl() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        this.routerLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.routerLock.writeLock();
        this.multicastReceivers = new HashMap();
        this.datagramIOs = new HashMap();
        this.streamServers = new HashMap();
    }

    @Override // org.jupnp.transport.Router
    public void send(OutgoingDatagramMessage outgoingDatagramMessage) {
        lock(this.readLock);
        try {
            if (this.enabled) {
                Iterator<DatagramIO> it = this.datagramIOs.values().iterator();
                while (it.hasNext()) {
                    it.next().send(outgoingDatagramMessage);
                }
            } else {
                this.logger.q("Router disabled, not sending datagram: {}", outgoingDatagramMessage);
            }
            unlock(this.readLock);
        } catch (Throwable th) {
            unlock(this.readLock);
            throw th;
        }
    }

    public boolean enable(EnableRouter enableRouter) {
        return enable();
    }

    public void lock(Lock lock) {
        lock(lock, getLockTimeoutMillis());
    }

    public boolean disable(DisableRouter disableRouter) {
        return disable();
    }
}
