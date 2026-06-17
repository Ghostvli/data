package org.jupnp.transport.impl;

import defpackage.d;
import defpackage.j02;
import defpackage.n02;
import defpackage.q23;
import defpackage.wg1;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.jupnp.model.Constants;
import org.jupnp.transport.spi.InitializationException;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.NoNetworkException;
import org.jupnp.util.Iterators;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NetworkAddressFactoryImpl implements NetworkAddressFactory {
    public static final int DEFAULT_MULTICAST_RESPONSE_LISTEN_PORT = 0;
    public static final int DEFAULT_TCP_HTTP_LISTEN_PORT = 0;
    protected final List<InetAddress> bindAddresses;
    private final j02 logger;
    protected int multicastResponsePort;
    protected final List<NetworkInterface> networkInterfaces;
    protected int streamListenPort;
    protected final Set<String> useAddresses;
    protected final Set<String> useInterfaces;

    public NetworkAddressFactoryImpl(int i, int i2, String str) {
        j02 j02VarK = n02.k(NetworkAddressFactoryImpl.class);
        this.logger = j02VarK;
        HashSet hashSet = new HashSet();
        this.useInterfaces = hashSet;
        HashSet hashSet2 = new HashSet();
        this.useAddresses = hashSet2;
        ArrayList arrayList = new ArrayList();
        this.networkInterfaces = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.bindAddresses = arrayList2;
        str = (str == null || q23.a(str)) ? System.getProperty(NetworkAddressFactory.SYSTEM_PROPERTY_NET_IFACES) : str;
        if (str != null) {
            hashSet.addAll(Arrays.asList(str.split(",")));
        }
        String property = System.getProperty(NetworkAddressFactory.SYSTEM_PROPERTY_NET_ADDRESSES);
        if (property != null) {
            hashSet2.addAll(Arrays.asList(property.split(",")));
        }
        discoverNetworkInterfaces();
        discoverBindAddresses();
        if (arrayList.isEmpty() || arrayList2.isEmpty()) {
            j02VarK.warn("No usable network interface or addresses found");
            if (requiresNetworkInterface()) {
                throw new NoNetworkException("Could not discover any usable network interfaces and/or addresses");
            }
        }
        this.streamListenPort = i;
        this.multicastResponsePort = i2;
    }

    public void discoverBindAddresses() {
        try {
            synchronized (this.networkInterfaces) {
                try {
                    Iterator<NetworkInterface> it = this.networkInterfaces.iterator();
                    while (it.hasNext()) {
                        NetworkInterface next = it.next();
                        this.logger.h("Discovering addresses of interface: {}", next.getDisplayName());
                        int i = 0;
                        for (InetAddress inetAddress : getInetAddresses(next)) {
                            if (inetAddress == null) {
                                this.logger.d("Network has a null address: {}", next.getDisplayName());
                            } else {
                                boolean zIsUsableAddress = isUsableAddress(next, inetAddress);
                                j02 j02Var = this.logger;
                                if (zIsUsableAddress) {
                                    j02Var.h("Discovered usable network interface address: {}", inetAddress.getHostAddress());
                                    i++;
                                    synchronized (this.bindAddresses) {
                                        this.bindAddresses.add(inetAddress);
                                    }
                                } else {
                                    j02Var.h("Ignoring non-usable network interface address: {}", inetAddress.getHostAddress());
                                }
                            }
                        }
                        if (i == 0) {
                            this.logger.h("Network interface has no usable addresses, removing: {}", next.getDisplayName());
                            it.remove();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            throw new InitializationException("Could not not analyze local network interfaces", e);
        }
    }

    public void discoverNetworkInterfaces() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                this.logger.h("Analyzing network interface: {}", networkInterface.getDisplayName());
                boolean zIsUsableNetworkInterface = isUsableNetworkInterface(networkInterface);
                j02 j02Var = this.logger;
                if (zIsUsableNetworkInterface) {
                    j02Var.h("Discovered usable network interface: {}", networkInterface.getDisplayName());
                    synchronized (this.networkInterfaces) {
                        this.networkInterfaces.add(networkInterface);
                    }
                } else {
                    j02Var.h("Ignoring non-usable network interface: {}", networkInterface.getDisplayName());
                }
            }
        } catch (Exception e) {
            throw new InitializationException("Could not not analyze local network interfaces", e);
        }
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public Short getAddressNetworkPrefixLength(InetAddress inetAddress) {
        synchronized (this.networkInterfaces) {
            try {
                Iterator<NetworkInterface> it = this.networkInterfaces.iterator();
                while (it.hasNext()) {
                    for (InterfaceAddress interfaceAddress : getInterfaceAddresses(it.next())) {
                        if (interfaceAddress != null && interfaceAddress.getAddress().equals(inetAddress)) {
                            short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                            if (networkPrefixLength <= 0 || networkPrefixLength >= 32) {
                                return null;
                            }
                            return Short.valueOf(networkPrefixLength);
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public InetAddress getBindAddressInSubnetOf(InetAddress inetAddress) {
        synchronized (this.networkInterfaces) {
            Iterator<NetworkInterface> it = this.networkInterfaces.iterator();
            while (it.hasNext()) {
                for (InterfaceAddress interfaceAddress : getInterfaceAddresses(it.next())) {
                    synchronized (this.bindAddresses) {
                        if (interfaceAddress != null) {
                            if (this.bindAddresses.contains(interfaceAddress.getAddress())) {
                                if (isInSubnet(inetAddress.getAddress(), interfaceAddress.getAddress().getAddress(), interfaceAddress.getNetworkPrefixLength())) {
                                    return interfaceAddress.getAddress();
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public Iterator<InetAddress> getBindAddresses() {
        return new Iterators.Synchronized<InetAddress>(this.bindAddresses) { // from class: org.jupnp.transport.impl.NetworkAddressFactoryImpl.2
            @Override // org.jupnp.util.Iterators.Synchronized
            public void synchronizedRemove(int i) {
                synchronized (NetworkAddressFactoryImpl.this.bindAddresses) {
                    NetworkAddressFactoryImpl.this.bindAddresses.remove(i);
                }
            }
        };
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public InetAddress getBroadcastAddress(InetAddress inetAddress) {
        synchronized (this.networkInterfaces) {
            try {
                Iterator<NetworkInterface> it = this.networkInterfaces.iterator();
                while (it.hasNext()) {
                    for (InterfaceAddress interfaceAddress : getInterfaceAddresses(it.next())) {
                        if (interfaceAddress != null && interfaceAddress.getAddress().equals(inetAddress)) {
                            return interfaceAddress.getBroadcast();
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public byte[] getHardwareAddress(InetAddress inetAddress) {
        try {
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
            if (byInetAddress != null) {
                return byInetAddress.getHardwareAddress();
            }
            return null;
        } catch (Exception e) {
            this.logger.m("Cannot get hardware address for: {}", inetAddress, e);
            return null;
        }
    }

    public List<InetAddress> getInetAddresses(NetworkInterface networkInterface) {
        return Collections.list(networkInterface.getInetAddresses());
    }

    public List<InterfaceAddress> getInterfaceAddresses(NetworkInterface networkInterface) {
        return networkInterface.getInterfaceAddresses();
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public InetAddress getLocalAddress(NetworkInterface networkInterface, boolean z, InetAddress inetAddress) {
        InetAddress bindAddressInSubnetOf = getBindAddressInSubnetOf(inetAddress);
        if (bindAddressInSubnetOf != null) {
            return bindAddressInSubnetOf;
        }
        this.logger.h("Could not find local bind address in same subnet as: {}", inetAddress.getHostAddress());
        for (InetAddress inetAddress2 : getInetAddresses(networkInterface)) {
            if (z && (inetAddress2 instanceof Inet6Address)) {
                return inetAddress2;
            }
            if (!z && (inetAddress2 instanceof Inet4Address)) {
                return inetAddress2;
            }
        }
        d.a("Can't find any IPv4 or IPv6 address on interface: ", networkInterface.getDisplayName());
        return null;
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public InetAddress getMulticastGroup() {
        try {
            return InetAddress.getByName(Constants.IPV4_UPNP_MULTICAST_GROUP);
        } catch (UnknownHostException e) {
            wg1.a(e);
            return null;
        }
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public int getMulticastPort() {
        return Constants.UPNP_MULTICAST_PORT;
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public int getMulticastResponsePort() {
        int i = this.multicastResponsePort;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public Iterator<NetworkInterface> getNetworkInterfaces() {
        return new Iterators.Synchronized<NetworkInterface>(this.networkInterfaces) { // from class: org.jupnp.transport.impl.NetworkAddressFactoryImpl.1
            @Override // org.jupnp.util.Iterators.Synchronized
            public void synchronizedRemove(int i) {
                synchronized (NetworkAddressFactoryImpl.this.networkInterfaces) {
                    NetworkAddressFactoryImpl.this.networkInterfaces.remove(i);
                }
            }
        };
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public int getStreamListenPort() {
        return this.streamListenPort;
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public boolean hasUsableNetwork() {
        return (this.networkInterfaces.isEmpty() || this.bindAddresses.isEmpty()) ? false : true;
    }

    public boolean isInSubnet(byte[] bArr, byte[] bArr2, short s) {
        if (bArr.length != bArr2.length || s / 8 > bArr.length) {
            return false;
        }
        int i = 0;
        while (s >= 8 && i < bArr.length) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
            s = (short) (s - 8);
        }
        if (i == bArr.length) {
            return true;
        }
        byte b = (byte) (~((1 << (8 - s)) - 1));
        return (bArr[i] & b) == (bArr2[i] & b);
    }

    public boolean isUsableAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet4Address)) {
            this.logger.h("Skipping unsupported non-IPv4 address: {}", inetAddress);
            return false;
        }
        if (inetAddress.isLoopbackAddress()) {
            this.logger.h("Skipping loopback address: {}", inetAddress);
            return false;
        }
        if (this.useAddresses.isEmpty() || this.useAddresses.contains(inetAddress.getHostAddress())) {
            return true;
        }
        this.logger.h("Skipping unwanted address: {}", inetAddress);
        return false;
    }

    public boolean isUsableNetworkInterface(NetworkInterface networkInterface) {
        if (!networkInterface.isUp()) {
            this.logger.h("Skipping network interface (down): {}", networkInterface.getDisplayName());
            return false;
        }
        if (getInetAddresses(networkInterface).isEmpty()) {
            this.logger.h("Skipping network interface without bound IP addresses: {}", networkInterface.getDisplayName());
            return false;
        }
        if (networkInterface.isPointToPoint()) {
            this.logger.h("Skipping point-to-point network interface: {}", networkInterface.getDisplayName());
            return false;
        }
        String name = networkInterface.getName();
        Locale locale = Locale.ENGLISH;
        if (name.toLowerCase(locale).startsWith("vmnet") || (networkInterface.getDisplayName() != null && networkInterface.getDisplayName().toLowerCase(locale).contains("vmnet"))) {
            this.logger.h("Skipping network interface (VMWare): {}", networkInterface.getDisplayName());
            return false;
        }
        if (networkInterface.getName().toLowerCase(locale).startsWith("vnic")) {
            this.logger.h("Skipping network interface (Parallels): {}", networkInterface.getDisplayName());
            return false;
        }
        if (networkInterface.getName().toLowerCase(locale).startsWith("vboxnet")) {
            this.logger.h("Skipping network interface (Virtual Box): {}", networkInterface.getDisplayName());
            return false;
        }
        if (networkInterface.getName().toLowerCase(locale).contains("virtual")) {
            this.logger.h("Skipping network interface (named '*virtual*'): {}", networkInterface.getDisplayName());
            return false;
        }
        if (networkInterface.getName().toLowerCase(locale).startsWith("ppp")) {
            this.logger.h("Skipping network interface (PPP): {}", networkInterface.getDisplayName());
            return false;
        }
        if (networkInterface.isLoopback()) {
            this.logger.h("Skipping network interface (ignoring loopback): {}", networkInterface.getDisplayName());
            return false;
        }
        if (!this.useInterfaces.isEmpty() && !this.useInterfaces.contains(networkInterface.getName())) {
            this.logger.i("Skipping unwanted network interface (OSGi parameter 'interfaces' or -D {}): {}", NetworkAddressFactory.SYSTEM_PROPERTY_NET_IFACES, networkInterface.getName());
            return false;
        }
        if (networkInterface.supportsMulticast()) {
            return true;
        }
        this.logger.d("Network interface may not be multicast capable: {}", networkInterface.getDisplayName());
        return true;
    }

    public void logInterfaceInformation(NetworkInterface networkInterface) {
        this.logger.info("---------------------------------------------------------------------------------");
        this.logger.c("Interface display name: {}", networkInterface.getDisplayName());
        if (networkInterface.getParent() != null) {
            this.logger.c("Parent Info: {}", networkInterface.getParent());
        }
        this.logger.c("Name: {}", networkInterface.getName());
        Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
        while (it.hasNext()) {
            this.logger.c("InetAddress: {}", (InetAddress) it.next());
        }
        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
            j02 j02Var = this.logger;
            if (interfaceAddress == null) {
                j02Var.warn("Skipping null InterfaceAddress!");
            } else {
                j02Var.info(" Interface Address");
                this.logger.c("  Address: {}", interfaceAddress.getAddress());
                this.logger.c("  Broadcast: {}", interfaceAddress.getBroadcast());
                this.logger.c("  Prefix length: {}", Short.valueOf(interfaceAddress.getNetworkPrefixLength()));
            }
        }
        for (NetworkInterface networkInterface2 : Collections.list(networkInterface.getSubInterfaces())) {
            j02 j02Var2 = this.logger;
            if (networkInterface2 == null) {
                j02Var2.warn("Skipping null NetworkInterface sub-interface");
            } else {
                j02Var2.c("\tSub Interface Display name: {}", networkInterface2.getDisplayName());
                this.logger.c("\tSub Interface Name: {}", networkInterface2.getName());
            }
        }
        this.logger.c("Up? {}", Boolean.valueOf(networkInterface.isUp()));
        this.logger.c("Loopback? {}", Boolean.valueOf(networkInterface.isLoopback()));
        this.logger.c("PointToPoint? {}", Boolean.valueOf(networkInterface.isPointToPoint()));
        this.logger.c("Supports multicast? {}", Boolean.valueOf(networkInterface.supportsMulticast()));
        this.logger.c("Virtual? {}", Boolean.valueOf(networkInterface.isVirtual()));
        this.logger.c("Hardware address: {}", Arrays.toString(networkInterface.getHardwareAddress()));
        this.logger.c("MTU: {}", Integer.valueOf(networkInterface.getMTU()));
    }

    public boolean requiresNetworkInterface() {
        return true;
    }

    public NetworkAddressFactoryImpl(int i, int i2) {
        this(i, i2, null);
    }

    public NetworkAddressFactoryImpl() {
        this(0, 0);
    }

    @Override // org.jupnp.transport.spi.NetworkAddressFactory
    public void logInterfaceInformation() {
        synchronized (this.networkInterfaces) {
            try {
                if (this.networkInterfaces.isEmpty()) {
                    this.logger.info("No network interface to display!");
                    return;
                }
                Iterator<NetworkInterface> it = this.networkInterfaces.iterator();
                while (it.hasNext()) {
                    try {
                        logInterfaceInformation(it.next());
                    } catch (SocketException e) {
                        this.logger.u("Exception while logging network interface information", e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
