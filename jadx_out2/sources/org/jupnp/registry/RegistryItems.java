package org.jupnp.registry;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.ValidationException;
import org.jupnp.model.gena.GENASubscription;
import org.jupnp.model.meta.Device;
import org.jupnp.model.resource.Resource;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
abstract class RegistryItems<D extends Device, S extends GENASubscription> {
    protected final RegistryImpl registry;
    protected final Set<RegistryItem<UDN, D>> deviceItems = new HashSet();
    protected final Set<RegistryItem<String, S>> subscriptionItems = new HashSet();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RegistryItems(RegistryImpl registryImpl) {
        this.registry = registryImpl;
    }

    public abstract void add(D d);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addSubscription(S s) {
        this.subscriptionItems.add(new RegistryItem<>(s.getSubscriptionId(), s, s.getActualDurationSeconds()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean contains(D d) {
        return contains(d.getIdentity().getUdn());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public D get(UDN udn, boolean z) {
        D d;
        for (RegistryItem<UDN, D> registryItem : this.deviceItems) {
            D item = registryItem.getItem();
            if (item.getIdentity().getUdn().equals(udn)) {
                return item;
            }
            if (!z && (d = (D) registryItem.getItem().findDevice(udn)) != null) {
                return d;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<RegistryItem<UDN, D>> getDeviceItems() {
        return this.deviceItems;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Resource[] getResources(Device device) {
        UpnpServiceConfiguration configuration = this.registry.getConfiguration();
        if (configuration == null) {
            return new Resource[0];
        }
        try {
            return configuration.getNamespace().getResources(device);
        } catch (ValidationException e) {
            throw new RegistrationException("Resource discover error", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public S getSubscription(String str) {
        for (RegistryItem<String, S> registryItem : this.subscriptionItems) {
            if (registryItem.getKey().equals(str)) {
                return registryItem.getItem();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<RegistryItem<String, S>> getSubscriptionItems() {
        return this.subscriptionItems;
    }

    public abstract void maintain();

    public abstract boolean remove(D d);

    public abstract void removeAll();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean removeSubscription(S s) {
        return this.subscriptionItems.remove(new RegistryItem(s.getSubscriptionId()));
    }

    public abstract void shutdown();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean updateSubscription(S s) {
        if (!removeSubscription(s)) {
            return false;
        }
        addSubscription(s);
        return true;
    }

    public boolean contains(UDN udn) {
        return this.deviceItems.contains(new RegistryItem(udn));
    }

    public Collection<D> get(DeviceType deviceType) {
        HashSet hashSet = new HashSet();
        Iterator<RegistryItem<UDN, D>> it = this.deviceItems.iterator();
        while (it.hasNext()) {
            Device[] deviceArrFindDevices = it.next().getItem().findDevices(deviceType);
            if (deviceArrFindDevices != null) {
                hashSet.addAll(Arrays.asList(deviceArrFindDevices));
            }
        }
        return hashSet;
    }

    public Collection<D> get(ServiceType serviceType) {
        HashSet hashSet = new HashSet();
        Iterator<RegistryItem<UDN, D>> it = this.deviceItems.iterator();
        while (it.hasNext()) {
            Device[] deviceArrFindDevices = it.next().getItem().findDevices(serviceType);
            if (deviceArrFindDevices != null) {
                hashSet.addAll(Arrays.asList(deviceArrFindDevices));
            }
        }
        return hashSet;
    }

    public Collection<D> get() {
        HashSet hashSet = new HashSet();
        Iterator<RegistryItem<UDN, D>> it = this.deviceItems.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getItem());
        }
        return hashSet;
    }
}
