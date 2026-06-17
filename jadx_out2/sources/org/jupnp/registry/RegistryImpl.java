package org.jupnp.registry;

import defpackage.j02;
import defpackage.jl;
import defpackage.n02;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.DiscoveryOptions;
import org.jupnp.model.ServiceReference;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.meta.Service;
import org.jupnp.model.resource.Resource;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.registry.RegistryImpl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RegistryImpl implements Registry {
    protected final LocalItems localItems;
    protected final ReentrantReadWriteLock localItemsLock;
    protected Object lock;
    private final j02 logger;
    protected final List<Runnable> pendingExecutions;
    protected final Set<RemoteGENASubscription> pendingSubscriptionsLock;
    protected final Set<RegistryListener> registryListeners;
    protected RegistryMaintainer registryMaintainer;
    protected final RemoteItems remoteItems;
    protected final ReentrantReadWriteLock remoteItemsLock;
    protected final Set<RegistryItem<URI, Resource>> resourceItems;
    protected UpnpService upnpService;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RegistryImpl(UpnpService upnpService) {
        j02 j02VarK = n02.k(Registry.class);
        this.logger = j02VarK;
        this.pendingSubscriptionsLock = new HashSet();
        this.lock = new Object();
        this.registryListeners = new CopyOnWriteArraySet();
        this.resourceItems = Collections.newSetFromMap(new ConcurrentHashMap());
        this.pendingExecutions = new LinkedList();
        this.remoteItemsLock = new ReentrantReadWriteLock(true);
        this.localItemsLock = new ReentrantReadWriteLock(true);
        this.remoteItems = new RemoteItems(this);
        this.localItems = new LocalItems(this);
        j02VarK.h("Creating Registry: {}", getClass().getName());
        this.upnpService = upnpService;
        j02VarK.y("Starting registry background maintenance...");
        synchronized (this.lock) {
            try {
                RegistryMaintainer registryMaintainerCreateRegistryMaintainer = createRegistryMaintainer();
                this.registryMaintainer = registryMaintainerCreateRegistryMaintainer;
                if (registryMaintainerCreateRegistryMaintainer != null) {
                    getConfiguration().getRegistryMaintainerExecutor().execute(this.registryMaintainer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(RegistryImpl registryImpl, RegistryListener registryListener, RemoteDevice remoteDevice, Exception exc) {
        registryImpl.getClass();
        registryListener.remoteDeviceDiscoveryFailed(registryImpl, remoteDevice, exc);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(RegistryImpl registryImpl, RegistryListener registryListener, RemoteDevice remoteDevice) {
        registryImpl.getClass();
        registryListener.remoteDeviceDiscoveryStarted(registryImpl, remoteDevice);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void addDevice(LocalDevice localDevice) {
        this.remoteItemsLock.readLock().lock();
        try {
            this.localItemsLock.writeLock().lock();
            try {
                this.localItems.add(localDevice);
            } finally {
                this.localItemsLock.writeLock().unlock();
            }
        } finally {
            this.remoteItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void addListener(RegistryListener registryListener) {
        this.registryListeners.add(registryListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void addLocalSubscription(LocalGENASubscription localGENASubscription) {
        this.localItemsLock.writeLock().lock();
        try {
            this.localItems.addSubscription(localGENASubscription);
        } finally {
            this.localItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void addRemoteSubscription(RemoteGENASubscription remoteGENASubscription) {
        this.remoteItemsLock.writeLock().lock();
        try {
            this.remoteItems.addSubscription(remoteGENASubscription);
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void addResource(Resource resource, int i) {
        RegistryItem<URI, Resource> registryItem = new RegistryItem<>(resource.getPathQuery(), resource, i);
        this.resourceItems.remove(registryItem);
        this.resourceItems.add(registryItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void advertiseLocalDevices() {
        this.localItemsLock.readLock().lock();
        try {
            this.localItems.advertiseLocalDevices();
        } finally {
            this.localItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RegistryMaintainer createRegistryMaintainer() {
        return new RegistryMaintainer(this, getConfiguration().getRegistryMaintenanceIntervalMillis());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void executeAsyncProtocol(Runnable runnable) {
        synchronized (this.pendingExecutions) {
            this.pendingExecutions.add(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public UpnpServiceConfiguration getConfiguration() {
        return getUpnpService().getConfiguration();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Device getDevice(UDN udn, boolean z) {
        LocalDevice localDevice = getLocalDevice(udn, z);
        if (localDevice != null) {
            return localDevice;
        }
        RemoteDevice remoteDevice = getRemoteDevice(udn, z);
        if (remoteDevice != null) {
            return remoteDevice;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Collection<Device> getDevices() {
        HashSet hashSet = new HashSet();
        this.remoteItemsLock.readLock().lock();
        try {
            hashSet.addAll(this.remoteItems.get());
            this.remoteItemsLock.readLock().unlock();
            this.localItemsLock.readLock().lock();
            try {
                hashSet.addAll(this.localItems.get());
                this.localItemsLock.readLock().unlock();
                return Collections.unmodifiableCollection(hashSet);
            } catch (Throwable th) {
                this.localItemsLock.readLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.remoteItemsLock.readLock().unlock();
            throw th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public DiscoveryOptions getDiscoveryOptions(UDN udn) {
        this.localItemsLock.readLock().lock();
        try {
            return this.localItems.getDiscoveryOptions(udn);
        } finally {
            this.localItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Collection<RegistryListener> getListeners() {
        return Collections.unmodifiableCollection(this.registryListeners);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public LocalDevice getLocalDevice(UDN udn, boolean z) {
        this.localItemsLock.readLock().lock();
        try {
            return this.localItems.get(udn, z);
        } finally {
            this.localItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Collection<LocalDevice> getLocalDevices() {
        this.localItemsLock.readLock().lock();
        try {
            return Collections.unmodifiableCollection(this.localItems.get());
        } finally {
            this.localItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public LocalGENASubscription getLocalSubscription(String str) {
        this.localItemsLock.readLock().lock();
        try {
            return this.localItems.getSubscription(str);
        } finally {
            this.localItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public ProtocolFactory getProtocolFactory() {
        return getUpnpService().getProtocolFactory();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public RemoteDevice getRemoteDevice(UDN udn, boolean z) {
        this.remoteItemsLock.readLock().lock();
        try {
            return this.remoteItems.get(udn, z);
        } finally {
            this.remoteItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Collection<RemoteDevice> getRemoteDevices() {
        this.remoteItemsLock.readLock().lock();
        try {
            return Collections.unmodifiableCollection(this.remoteItems.get());
        } finally {
            this.remoteItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public RemoteGENASubscription getRemoteSubscription(String str) {
        this.remoteItemsLock.readLock().lock();
        try {
            return this.remoteItems.getSubscription(str);
        } finally {
            this.remoteItemsLock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Resource getResource(URI uri) {
        if (uri.isAbsolute()) {
            jl.a("Resource URI can not be absolute, only path and query:".concat(String.valueOf(uri)));
            return null;
        }
        Iterator<RegistryItem<URI, Resource>> it = this.resourceItems.iterator();
        while (it.hasNext()) {
            Resource item = it.next().getItem();
            if (item.matches(uri)) {
                return item;
            }
        }
        if (uri.getPath().endsWith(ServiceReference.DELIMITER)) {
            URI uriCreate = URI.create(uri.toString().substring(0, uri.toString().length() - 1));
            Iterator<RegistryItem<URI, Resource>> it2 = this.resourceItems.iterator();
            while (it2.hasNext()) {
                Resource item2 = it2.next().getItem();
                if (item2.matches(uriCreate)) {
                    return item2;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public <T extends Resource> Collection<T> getResources(Class<T> cls) {
        HashSet hashSet = new HashSet(this.resourceItems.size());
        for (RegistryItem<URI, Resource> registryItem : this.resourceItems) {
            if (cls.isAssignableFrom(registryItem.getItem().getClass())) {
                hashSet.add(registryItem.getItem());
            }
        }
        return hashSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public Service getService(ServiceReference serviceReference) {
        Device device = getDevice(serviceReference.getUdn(), false);
        if (device != null) {
            return device.findService(serviceReference.getServiceId());
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public RemoteGENASubscription getWaitRemoteSubscription(String str) {
        synchronized (this.pendingSubscriptionsLock) {
            do {
                try {
                    RemoteGENASubscription remoteSubscription = getRemoteSubscription(str);
                    if (remoteSubscription != null) {
                        return remoteSubscription;
                    }
                    if (!this.pendingSubscriptionsLock.isEmpty()) {
                        try {
                            this.logger.y("Subscription not found, waiting for pending subscription procedure to terminate.");
                            this.pendingSubscriptionsLock.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } while (!this.pendingSubscriptionsLock.isEmpty());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean isPaused() {
        boolean z;
        synchronized (this.lock) {
            z = this.registryMaintainer == null;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void maintain() {
        this.logger.y("Maintaining registry...");
        Iterator<RegistryItem<URI, Resource>> it = this.resourceItems.iterator();
        while (it.hasNext()) {
            RegistryItem<URI, Resource> next = it.next();
            if (next.getExpirationDetails().hasExpired()) {
                this.logger.h("Removing expired resource: {}", next);
                it.remove();
            }
        }
        synchronized (this.pendingExecutions) {
            try {
                for (RegistryItem<URI, Resource> registryItem : this.resourceItems) {
                    registryItem.getItem().maintain(this.pendingExecutions, registryItem.getExpirationDetails());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.remoteItemsLock.writeLock().lock();
        try {
            this.remoteItems.maintain();
            this.remoteItemsLock.writeLock().unlock();
            this.localItemsLock.writeLock().lock();
            try {
                this.localItems.maintain();
                this.localItemsLock.writeLock().unlock();
                runPendingExecutions(true);
            } catch (Throwable th2) {
                this.localItemsLock.writeLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            this.remoteItemsLock.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void notifyDiscoveryFailure(final RemoteDevice remoteDevice, final Exception exc) {
        for (final RegistryListener registryListener : getListeners()) {
            getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: vp3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    RegistryImpl.a(this.f, registryListener, remoteDevice, exc);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean notifyDiscoveryStart(final RemoteDevice remoteDevice) {
        if (getRemoteDevice(remoteDevice.getIdentity().getUdn(), true) != null) {
            this.logger.h("Not notifying listeners, already registered: {}", remoteDevice);
            return false;
        }
        for (final RegistryListener registryListener : getListeners()) {
            getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: wp3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    RegistryImpl.b(this.f, registryListener, remoteDevice);
                }
            });
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void pause() {
        synchronized (this.lock) {
            try {
                if (this.registryMaintainer != null) {
                    this.logger.y("Pausing registry maintenance");
                    runPendingExecutions(true);
                    this.registryMaintainer.stop();
                    this.registryMaintainer = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void printDebugLog() {
        if (this.logger.n()) {
            this.logger.y("====================================    REMOTE   ================================================");
            this.remoteItemsLock.readLock().lock();
            try {
                Iterator<RemoteDevice> it = this.remoteItems.get().iterator();
                while (it.hasNext()) {
                    this.logger.y(it.next().toString());
                }
                this.remoteItemsLock.readLock().unlock();
                this.logger.y("====================================    LOCAL    ================================================");
                this.localItemsLock.readLock().lock();
                try {
                    Iterator<LocalDevice> it2 = this.localItems.get().iterator();
                    while (it2.hasNext()) {
                        this.logger.y(it2.next().toString());
                    }
                    this.localItemsLock.readLock().unlock();
                    this.logger.y("====================================  RESOURCES  ================================================");
                    Iterator<RegistryItem<URI, Resource>> it3 = this.resourceItems.iterator();
                    while (it3.hasNext()) {
                        this.logger.y(it3.next().toString());
                    }
                    this.logger.y("=================================================================================================");
                } catch (Throwable th) {
                    this.localItemsLock.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                this.remoteItemsLock.readLock().unlock();
                throw th2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void registerPendingRemoteSubscription(RemoteGENASubscription remoteGENASubscription) {
        synchronized (this.pendingSubscriptionsLock) {
            this.pendingSubscriptionsLock.add(remoteGENASubscription);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void removeAllLocalDevices() {
        this.localItemsLock.writeLock().lock();
        try {
            this.localItems.removeAll();
        } finally {
            this.localItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void removeAllRemoteDevices() {
        this.remoteItemsLock.writeLock().lock();
        try {
            this.remoteItems.removeAll();
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean removeDevice(LocalDevice localDevice) {
        this.localItemsLock.writeLock().lock();
        try {
            return this.localItems.remove(localDevice);
        } finally {
            this.localItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void removeListener(RegistryListener registryListener) {
        this.registryListeners.remove(registryListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean removeLocalSubscription(LocalGENASubscription localGENASubscription) {
        this.localItemsLock.writeLock().lock();
        try {
            return this.localItems.removeSubscription(localGENASubscription);
        } finally {
            this.localItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void removeRemoteSubscription(RemoteGENASubscription remoteGENASubscription) {
        this.remoteItemsLock.writeLock().lock();
        try {
            this.remoteItems.removeSubscription(remoteGENASubscription);
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean removeResource(Resource resource) {
        return this.resourceItems.remove(new RegistryItem(resource.getPathQuery()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void resume() {
        synchronized (this.lock) {
            if (this.registryMaintainer == null) {
                this.logger.y("Resuming registry maintenance");
                this.remoteItemsLock.writeLock().lock();
                try {
                    this.localItemsLock.readLock().lock();
                    try {
                        this.remoteItems.resume();
                        this.remoteItemsLock.writeLock().unlock();
                        RegistryMaintainer registryMaintainerCreateRegistryMaintainer = createRegistryMaintainer();
                        this.registryMaintainer = registryMaintainerCreateRegistryMaintainer;
                        if (registryMaintainerCreateRegistryMaintainer != null) {
                            getConfiguration().getRegistryMaintainerExecutor().execute(this.registryMaintainer);
                        }
                    } finally {
                        this.localItemsLock.readLock().unlock();
                    }
                } catch (Throwable th) {
                    this.remoteItemsLock.writeLock().unlock();
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void runPendingExecutions(boolean z) {
        synchronized (this.pendingExecutions) {
            try {
                this.logger.h("Executing pending operations: {}", Integer.valueOf(this.pendingExecutions.size()));
                for (Runnable runnable : this.pendingExecutions) {
                    if (z) {
                        getConfiguration().getAsyncProtocolExecutor().execute(runnable);
                    } else {
                        runnable.run();
                    }
                }
                if (!this.pendingExecutions.isEmpty()) {
                    this.pendingExecutions.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void setDiscoveryOptions(UDN udn, DiscoveryOptions discoveryOptions) {
        this.localItemsLock.writeLock().lock();
        try {
            this.localItems.setDiscoveryOptions(udn, discoveryOptions);
        } finally {
            this.localItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void shutdown() {
        this.logger.y("Shutting down registry...");
        synchronized (this.lock) {
            try {
                RegistryMaintainer registryMaintainer = this.registryMaintainer;
                if (registryMaintainer != null) {
                    registryMaintainer.stop();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.pendingExecutions) {
            this.logger.h("Executing final pending operations on shutdown: {}", Integer.valueOf(this.pendingExecutions.size()));
            runPendingExecutions(false);
        }
        Iterator<RegistryListener> it = this.registryListeners.iterator();
        while (it.hasNext()) {
            it.next().beforeShutdown(this);
        }
        Iterator<RegistryItem<URI, Resource>> it2 = this.resourceItems.iterator();
        while (it2.hasNext()) {
            it2.next().getItem().shutdown();
        }
        this.remoteItemsLock.writeLock().lock();
        try {
            this.remoteItems.shutdown();
            this.remoteItemsLock.writeLock().unlock();
            this.localItemsLock.writeLock().lock();
            try {
                this.localItems.shutdown();
                this.localItemsLock.writeLock().unlock();
                Iterator<RegistryListener> it3 = this.registryListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().afterShutdown();
                }
            } catch (Throwable th2) {
                this.localItemsLock.writeLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            this.remoteItemsLock.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void unregisterPendingRemoteSubscription(RemoteGENASubscription remoteGENASubscription) {
        synchronized (this.pendingSubscriptionsLock) {
            try {
                if (this.pendingSubscriptionsLock.remove(remoteGENASubscription)) {
                    this.pendingSubscriptionsLock.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean update(RemoteDeviceIdentity remoteDeviceIdentity) {
        this.remoteItemsLock.writeLock().lock();
        try {
            this.localItemsLock.readLock().lock();
            try {
                return this.remoteItems.update(remoteDeviceIdentity);
            } finally {
                this.localItemsLock.readLock().unlock();
            }
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public boolean updateLocalSubscription(LocalGENASubscription localGENASubscription) {
        this.localItemsLock.writeLock().lock();
        try {
            return this.localItems.updateSubscription(localGENASubscription);
        } finally {
            this.localItemsLock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.Registry
    public void updateRemoteSubscription(RemoteGENASubscription remoteGENASubscription) {
        this.remoteItemsLock.writeLock().lock();
        try {
            this.remoteItems.updateSubscription(remoteGENASubscription);
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    @Override // org.jupnp.registry.Registry
    public void addResource(Resource resource) {
        addResource(resource, 0);
    }

    @Override // org.jupnp.registry.Registry
    public boolean removeDevice(RemoteDevice remoteDevice) {
        this.remoteItemsLock.writeLock().lock();
        try {
            return this.remoteItems.remove(remoteDevice);
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    @Override // org.jupnp.registry.Registry
    public boolean removeDevice(UDN udn) {
        Device device = getDevice(udn, true);
        if (device != null && (device instanceof LocalDevice)) {
            return removeDevice((LocalDevice) device);
        }
        if (device == null || !(device instanceof RemoteDevice)) {
            return false;
        }
        return removeDevice((RemoteDevice) device);
    }

    @Override // org.jupnp.registry.Registry
    public Collection<Resource> getResources() {
        HashSet hashSet = new HashSet(this.resourceItems.size());
        Iterator<RegistryItem<URI, Resource>> it = this.resourceItems.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getItem());
        }
        return hashSet;
    }

    @Override // org.jupnp.registry.Registry
    public void addDevice(LocalDevice localDevice, DiscoveryOptions discoveryOptions) {
        this.remoteItemsLock.readLock().lock();
        try {
            this.localItemsLock.writeLock().lock();
            try {
                this.localItems.add(localDevice, discoveryOptions);
            } finally {
                this.localItemsLock.writeLock().unlock();
            }
        } finally {
            this.remoteItemsLock.readLock().unlock();
        }
    }

    @Override // org.jupnp.registry.Registry
    public void addDevice(RemoteDevice remoteDevice) {
        this.remoteItemsLock.writeLock().lock();
        try {
            this.localItemsLock.readLock().lock();
            try {
                this.remoteItems.add(remoteDevice);
            } finally {
                this.localItemsLock.readLock().unlock();
            }
        } finally {
            this.remoteItemsLock.writeLock().unlock();
        }
    }

    @Override // org.jupnp.registry.Registry
    public Collection<Device> getDevices(DeviceType deviceType) {
        HashSet hashSet = new HashSet();
        this.remoteItemsLock.readLock().lock();
        try {
            hashSet.addAll(this.remoteItems.get(deviceType));
            this.remoteItemsLock.readLock().unlock();
            this.localItemsLock.readLock().lock();
            try {
                hashSet.addAll(this.localItems.get(deviceType));
                this.localItemsLock.readLock().unlock();
                return Collections.unmodifiableCollection(hashSet);
            } catch (Throwable th) {
                this.localItemsLock.readLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.remoteItemsLock.readLock().unlock();
            throw th2;
        }
    }

    @Override // org.jupnp.registry.Registry
    public Collection<Device> getDevices(ServiceType serviceType) {
        HashSet hashSet = new HashSet();
        this.remoteItemsLock.readLock().lock();
        try {
            hashSet.addAll(this.remoteItems.get(serviceType));
            this.remoteItemsLock.readLock().unlock();
            this.localItemsLock.readLock().lock();
            try {
                hashSet.addAll(this.localItems.get(serviceType));
                this.localItemsLock.readLock().unlock();
                return Collections.unmodifiableCollection(hashSet);
            } catch (Throwable th) {
                this.localItemsLock.readLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.remoteItemsLock.readLock().unlock();
            throw th2;
        }
    }

    @Override // org.jupnp.registry.Registry
    public <T extends Resource> T getResource(Class<T> cls, URI uri) {
        T t = (T) getResource(uri);
        if (t == null || !cls.isAssignableFrom(t.getClass())) {
            return null;
        }
        return t;
    }

    public RegistryImpl() {
        this.logger = n02.k(Registry.class);
        this.pendingSubscriptionsLock = new HashSet();
        this.lock = new Object();
        this.registryListeners = new CopyOnWriteArraySet();
        this.resourceItems = Collections.newSetFromMap(new ConcurrentHashMap());
        this.pendingExecutions = new LinkedList();
        this.remoteItemsLock = new ReentrantReadWriteLock(true);
        this.localItemsLock = new ReentrantReadWriteLock(true);
        this.remoteItems = new RemoteItems(this);
        this.localItems = new LocalItems(this);
    }
}
