package org.jupnp.registry;

import defpackage.j02;
import defpackage.n02;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.jupnp.model.ExpirationDetails;
import org.jupnp.model.gena.CancelReason;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.resource.Resource;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class RemoteItems extends RegistryItems<RemoteDevice, RemoteGENASubscription> {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteItems(RegistryImpl registryImpl) {
        super(registryImpl);
        this.logger = n02.k(Registry.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: add(Lorg/jupnp/model/meta/Device;)V */
    @Override // org.jupnp.registry.RegistryItems
    public void add(final RemoteDevice remoteDevice) {
        if (update(remoteDevice.getIdentity())) {
            this.logger.h("Ignoring addition, device already registered: {}", remoteDevice);
            return;
        }
        Resource[] resources = getResources(remoteDevice);
        for (Resource resource : resources) {
            this.logger.h("Validating remote device resource; {}", resource);
            if (this.registry.getResource(resource.getPathQuery()) != null) {
                throw new RegistrationException("URI namespace conflict with already registered resource: ".concat(String.valueOf(resource)));
            }
        }
        for (Resource resource2 : resources) {
            this.registry.addResource(resource2);
            this.logger.h("Added remote device resource: {}", resource2);
        }
        Integer remoteDeviceMaxAgeSeconds = this.registry.getConfiguration() != null ? this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() : null;
        if (remoteDeviceMaxAgeSeconds == null) {
            remoteDeviceMaxAgeSeconds = remoteDevice.getIdentity().getMaxAgeSeconds();
        }
        RegistryItem<UDN, RemoteDevice> registryItem = new RegistryItem<>(remoteDevice.getIdentity().getUdn(), remoteDevice, remoteDeviceMaxAgeSeconds.intValue());
        this.logger.i("Adding hydrated remote device to registry with {} seconds expiration: {}", Integer.valueOf(registryItem.getExpirationDetails().getMaxAgeSeconds()), remoteDevice);
        getDeviceItems().add(registryItem);
        if (this.logger.n()) {
            StringBuilder sb = new StringBuilder("\n-------------------------- START Registry Namespace -----------------------------------\n");
            Iterator<Resource> it = this.registry.getResources().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
            sb.append("-------------------------- END Registry Namespace -----------------------------------");
            this.logger.y(sb.toString());
        }
        this.logger.h("Completely hydrated remote device graph available, calling listeners: {}", remoteDevice);
        for (final RegistryListener registryListener : this.registry.getListeners()) {
            this.registry.getConfiguration().getRemoteListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.f
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    registryListener.remoteDeviceAdded(this.f.registry, remoteDevice);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.RegistryItems
    public void maintain() {
        if (getDeviceItems().isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        for (RegistryItem<UDN, RemoteDevice> registryItem : getDeviceItems()) {
            this.logger.i("Device '{}' expires in seconds: {}", registryItem.getItem(), Long.valueOf(registryItem.getExpirationDetails().getSecondsUntilExpiration()));
            if (registryItem.getExpirationDetails().hasExpired(false)) {
                map.put(registryItem.getKey(), registryItem.getItem());
            }
        }
        for (RemoteDevice remoteDevice : map.values()) {
            this.logger.h("Removing expired: {}", remoteDevice);
            remove(remoteDevice);
        }
        HashSet<RemoteGENASubscription> hashSet = new HashSet();
        for (RegistryItem<String, RemoteGENASubscription> registryItem2 : getSubscriptionItems()) {
            ExpirationDetails expirationDetails = registryItem2.getExpirationDetails();
            if (expirationDetails.getRenewAttempts() < 1 && expirationDetails.hasExpired(true)) {
                hashSet.add(registryItem2.getItem());
                expirationDetails.renewAttempted();
            }
        }
        for (RemoteGENASubscription remoteGENASubscription : hashSet) {
            this.logger.h("Renewing outgoing subscription: {}", remoteGENASubscription);
            renewOutgoingSubscription(remoteGENASubscription);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean remove(RemoteDevice remoteDevice, boolean z) {
        final RemoteDevice remoteDevice2 = (RemoteDevice) get(remoteDevice.getIdentity().getUdn(), true);
        if (remoteDevice2 == null) {
            return false;
        }
        this.logger.h("Removing remote device from registry: {}", remoteDevice);
        for (Resource resource : getResources(remoteDevice2)) {
            if (this.registry.removeResource(resource)) {
                this.logger.h("Unregistered resource: {}", resource);
            }
        }
        Iterator it = getSubscriptionItems().iterator();
        while (it.hasNext()) {
            final RegistryItem registryItem = (RegistryItem) it.next();
            if (((RemoteGENASubscription) registryItem.getItem()).getService().getDevice().getIdentity().getUdn().equals(remoteDevice2.getIdentity().getUdn())) {
                this.logger.h("Removing outgoing subscription: {}", registryItem.getKey());
                it.remove();
                if (!z) {
                    this.registry.getConfiguration().getRemoteListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.g
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((RemoteGENASubscription) registryItem.getItem()).end(CancelReason.DEVICE_WAS_REMOVED, null);
                        }
                    });
                }
            }
        }
        if (!z) {
            for (final RegistryListener registryListener : this.registry.getListeners()) {
                this.registry.getConfiguration().getRemoteListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.h
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        registryListener.remoteDeviceRemoved(this.f.registry, remoteDevice2);
                    }
                });
            }
        }
        getDeviceItems().remove(new RegistryItem(remoteDevice2.getIdentity().getUdn()));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void removeAll(boolean z) {
        for (RemoteDevice remoteDevice : (RemoteDevice[]) get().toArray(new RemoteDevice[get().size()])) {
            remove(remoteDevice, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void renewOutgoingSubscription(RemoteGENASubscription remoteGENASubscription) {
        RegistryImpl registryImpl = this.registry;
        registryImpl.executeAsyncProtocol(registryImpl.getProtocolFactory().createSendingRenewal(remoteGENASubscription));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void resume() {
        this.logger.y("Updating remote device expiration timestamps on resume");
        ArrayList arrayList = new ArrayList();
        Iterator<RegistryItem<UDN, RemoteDevice>> it = getDeviceItems().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getItem().getIdentity());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            update((RemoteDeviceIdentity) it2.next());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.RegistryItems
    public void shutdown() {
        this.logger.y("Cancelling all outgoing subscriptions to remote devices during shutdown");
        ArrayList arrayList = new ArrayList();
        Iterator<RegistryItem<String, RemoteGENASubscription>> it = getSubscriptionItems().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getItem());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.registry.getProtocolFactory().createSendingUnsubscribe((RemoteGENASubscription) it2.next()).run();
        }
        this.logger.y("Removing all remote devices from registry during shutdown");
        removeAll(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void start() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean update(RemoteDeviceIdentity remoteDeviceIdentity) {
        Iterator<LocalDevice> it = this.registry.getLocalDevices().iterator();
        while (it.hasNext()) {
            if (it.next().findDevice(remoteDeviceIdentity.getUdn()) != null) {
                this.logger.y("Ignoring update, a local device graph contains UDN");
                return true;
            }
        }
        RemoteDevice root = get(remoteDeviceIdentity.getUdn(), false);
        if (root == null) {
            return false;
        }
        RemoteDeviceIdentity identity = root.getIdentity();
        if (identity != null) {
            URL descriptorURL = remoteDeviceIdentity.getDescriptorURL();
            URL descriptorURL2 = identity.getDescriptorURL();
            if (((descriptorURL != null) & (descriptorURL2 != null)) && !descriptorURL.getHost().equals(descriptorURL2.getHost())) {
                this.logger.y("IP adress has changed - removing the registered device");
                remove(root);
                return false;
            }
        }
        if (!root.isRoot()) {
            this.logger.h("Updating root device of embedded: {}", root);
            root = root.getRoot();
        }
        final RegistryItem<UDN, RemoteDevice> registryItem = new RegistryItem<>(root.getIdentity().getUdn(), root, (this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() != null ? this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() : remoteDeviceIdentity.getMaxAgeSeconds()).intValue());
        this.logger.h("Updating expiration of: {}", root);
        getDeviceItems().remove(registryItem);
        getDeviceItems().add(registryItem);
        this.logger.h("Remote device updated, calling listeners: {}", root);
        for (final RegistryListener registryListener : this.registry.getListeners()) {
            this.registry.getConfiguration().getRemoteListenerExecutor().execute(new Runnable() { // from class: org.jupnp.registry.e
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    registryListener.remoteDeviceUpdated(this.f.registry, (RemoteDevice) registryItem.getItem());
                }
            });
        }
        return true;
    }

    @Override // org.jupnp.registry.RegistryItems
    public void removeAll() {
        removeAll(false);
    }

    /* JADX DEBUG: Method merged with bridge method: remove(Lorg/jupnp/model/meta/Device;)Z */
    @Override // org.jupnp.registry.RegistryItems
    public boolean remove(RemoteDevice remoteDevice) {
        return remove(remoteDevice, false);
    }
}
