package org.jupnp.registry;

import defpackage.j02;
import defpackage.n02;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.jupnp.model.DiscoveryOptions;
import org.jupnp.model.gena.CancelReason;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.resource.Resource;
import org.jupnp.model.types.UDN;
import org.jupnp.protocol.async.SendingNotificationByebye;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class LocalItems extends RegistryItems<LocalDevice, LocalGENASubscription> {
    protected Map<UDN, DiscoveryOptions> discoveryOptions;
    protected long lastAliveIntervalTimestamp;
    private final j02 logger;
    protected Random randomGenerator;

    public LocalItems(RegistryImpl registryImpl) {
        super(registryImpl);
        this.logger = n02.k(Registry.class);
        this.discoveryOptions = new HashMap();
        this.lastAliveIntervalTimestamp = 0L;
        this.randomGenerator = new Random();
    }

    public static /* synthetic */ void d(LocalItems localItems, LocalDevice localDevice) {
        localItems.getClass();
        try {
            localItems.logger.y("Sleeping some milliseconds to avoid flooding the network with ALIVE msgs");
            Thread.sleep(localItems.randomGenerator.nextInt(100));
        } catch (InterruptedException e) {
            localItems.logger.a("Background execution interrupted", e);
        }
        localItems.registry.getProtocolFactory().createSendingNotificationAlive(localDevice).run();
    }

    public void add(final LocalDevice localDevice, DiscoveryOptions discoveryOptions) {
        setDiscoveryOptions(localDevice.getIdentity().getUdn(), discoveryOptions);
        Device device = this.registry.getDevice(localDevice.getIdentity().getUdn(), false);
        j02 j02Var = this.logger;
        if (device != null) {
            j02Var.h("Ignoring addition, device already registered: {}", localDevice);
            return;
        }
        j02Var.h("Adding local device to registry: {}", localDevice);
        for (Resource resource : getResources(localDevice)) {
            if (this.registry.getResource(resource.getPathQuery()) != null) {
                throw new RegistrationException("URI namespace conflict with already registered resource: ".concat(String.valueOf(resource)));
            }
            this.registry.addResource(resource);
            this.logger.h("Registered resource: {}", resource);
        }
        this.logger.h("Adding item to registry with expiration in seconds: {}", localDevice.getIdentity().getMaxAgeSeconds());
        RegistryItem<UDN, LocalDevice> registryItem = new RegistryItem<>(localDevice.getIdentity().getUdn(), localDevice, localDevice.getIdentity().getMaxAgeSeconds().intValue());
        getDeviceItems().add(registryItem);
        this.logger.h("Registered local device: {}", registryItem);
        if (isByeByeBeforeFirstAlive(registryItem.getKey())) {
            advertiseByebye(localDevice, true);
        }
        if (isAdvertised(registryItem.getKey())) {
            advertiseAlive(localDevice);
        }
        for (final RegistryListener registryListener : this.registry.getListeners()) {
            this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.a
                @Override // java.lang.Runnable
                public final void run() {
                    registryListener.localDeviceAdded(this.f.registry, localDevice);
                }
            });
        }
    }

    public void advertiseAlive(final LocalDevice localDevice) {
        this.registry.executeAsyncProtocol(new Runnable() { // from class: org.jupnp.registry.b
            @Override // java.lang.Runnable
            public final void run() {
                LocalItems.d(this.f, localDevice);
            }
        });
    }

    public void advertiseByebye(LocalDevice localDevice, boolean z) {
        SendingNotificationByebye sendingNotificationByebyeCreateSendingNotificationByebye = this.registry.getProtocolFactory().createSendingNotificationByebye(localDevice);
        if (z) {
            this.registry.executeAsyncProtocol(sendingNotificationByebyeCreateSendingNotificationByebye);
        } else {
            sendingNotificationByebyeCreateSendingNotificationByebye.run();
        }
    }

    public void advertiseLocalDevices() {
        Iterator it = this.deviceItems.iterator();
        while (it.hasNext()) {
            RegistryItem registryItem = (RegistryItem) it.next();
            if (isAdvertised((UDN) registryItem.getKey())) {
                advertiseAlive((LocalDevice) registryItem.getItem());
            }
        }
    }

    @Override // org.jupnp.registry.RegistryItems
    public Collection<LocalDevice> get() {
        HashSet hashSet = new HashSet();
        Iterator<RegistryItem<UDN, LocalDevice>> it = getDeviceItems().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getItem());
        }
        return Collections.unmodifiableCollection(hashSet);
    }

    public DiscoveryOptions getDiscoveryOptions(UDN udn) {
        return this.discoveryOptions.get(udn);
    }

    public boolean isAdvertised(UDN udn) {
        return getDiscoveryOptions(udn) == null || getDiscoveryOptions(udn).isAdvertised();
    }

    public boolean isByeByeBeforeFirstAlive(UDN udn) {
        return getDiscoveryOptions(udn) != null && getDiscoveryOptions(udn).isByeByeBeforeFirstAlive();
    }

    @Override // org.jupnp.registry.RegistryItems
    public void maintain() {
        if (getDeviceItems().isEmpty()) {
            return;
        }
        HashSet<RegistryItem> hashSet = new HashSet();
        int aliveIntervalMillis = this.registry.getConfiguration().getAliveIntervalMillis();
        if (aliveIntervalMillis > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastAliveIntervalTimestamp > aliveIntervalMillis) {
                this.lastAliveIntervalTimestamp = jCurrentTimeMillis;
                for (RegistryItem<UDN, LocalDevice> registryItem : getDeviceItems()) {
                    if (isAdvertised(registryItem.getKey())) {
                        this.logger.h("Flooding advertisement of local item: {}", registryItem);
                        hashSet.add(registryItem);
                    }
                }
            }
        } else {
            this.lastAliveIntervalTimestamp = 0L;
            for (RegistryItem<UDN, LocalDevice> registryItem2 : getDeviceItems()) {
                if (isAdvertised(registryItem2.getKey()) && registryItem2.getExpirationDetails().hasExpired(true)) {
                    this.logger.h("Local item has expired: {}", registryItem2);
                    hashSet.add(registryItem2);
                }
            }
        }
        for (RegistryItem registryItem3 : hashSet) {
            this.logger.h("Refreshing local device advertisement: {}", registryItem3.getItem());
            advertiseAlive((LocalDevice) registryItem3.getItem());
            registryItem3.getExpirationDetails().stampLastRefresh();
        }
        HashSet<RegistryItem> hashSet2 = new HashSet();
        for (RegistryItem<String, LocalGENASubscription> registryItem4 : getSubscriptionItems()) {
            if (registryItem4.getExpirationDetails().hasExpired(false)) {
                hashSet2.add(registryItem4);
            }
        }
        for (RegistryItem registryItem5 : hashSet2) {
            this.logger.h("Removing expired: {}", registryItem5);
            removeSubscription((LocalGENASubscription) registryItem5.getItem());
            ((LocalGENASubscription) registryItem5.getItem()).end(CancelReason.EXPIRED);
        }
    }

    public boolean remove(final LocalDevice localDevice, boolean z) {
        LocalDevice localDevice2 = get(localDevice.getIdentity().getUdn(), true);
        if (localDevice2 == null) {
            return false;
        }
        this.logger.h("Removing local device from registry: {}", localDevice);
        setDiscoveryOptions(localDevice.getIdentity().getUdn(), null);
        getDeviceItems().remove(new RegistryItem(localDevice.getIdentity().getUdn()));
        for (Resource resource : getResources(localDevice)) {
            if (this.registry.removeResource(resource)) {
                this.logger.h("Unregistered resource: {}", resource);
            }
        }
        Iterator<RegistryItem<String, LocalGENASubscription>> it = getSubscriptionItems().iterator();
        while (it.hasNext()) {
            final RegistryItem<String, LocalGENASubscription> next = it.next();
            if (next.getItem().getService().getDevice().getIdentity().getUdn().equals(localDevice2.getIdentity().getUdn())) {
                this.logger.h("Removing incoming subscription: {}", next.getKey());
                it.remove();
                if (!z) {
                    this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((LocalGENASubscription) next.getItem()).end(CancelReason.DEVICE_WAS_REMOVED);
                        }
                    });
                }
            }
        }
        if (isAdvertised(localDevice.getIdentity().getUdn())) {
            advertiseByebye(localDevice, !z);
        }
        if (!z) {
            for (final RegistryListener registryListener : this.registry.getListeners()) {
                this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        registryListener.localDeviceRemoved(this.f.registry, localDevice);
                    }
                });
            }
        }
        return true;
    }

    public void removeAll(boolean z) {
        for (LocalDevice localDevice : (LocalDevice[]) get().toArray(new LocalDevice[get().size()])) {
            remove(localDevice, z);
        }
    }

    public void setDiscoveryOptions(UDN udn, DiscoveryOptions discoveryOptions) {
        Map<UDN, DiscoveryOptions> map = this.discoveryOptions;
        if (discoveryOptions != null) {
            map.put(udn, discoveryOptions);
        } else {
            map.remove(udn);
        }
    }

    @Override // org.jupnp.registry.RegistryItems
    public void shutdown() {
        this.logger.y("Clearing all registered subscriptions to local devices during shutdown");
        getSubscriptionItems().clear();
        this.logger.y("Removing all local devices from registry during shutdown");
        removeAll(true);
    }

    @Override // org.jupnp.registry.RegistryItems
    public void removeAll() {
        removeAll(false);
    }

    @Override // org.jupnp.registry.RegistryItems
    public void add(LocalDevice localDevice) {
        add(localDevice, null);
    }

    @Override // org.jupnp.registry.RegistryItems
    public boolean remove(LocalDevice localDevice) {
        return remove(localDevice, false);
    }
}
