package org.jupnp.registry;

import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.RemoteDevice;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultRegistryListener implements RegistryListener {
    @Override // org.jupnp.registry.RegistryListener
    public void afterShutdown() {
    }

    @Override // org.jupnp.registry.RegistryListener
    public void beforeShutdown(Registry registry) {
    }

    public void deviceAdded(Registry registry, Device device) {
    }

    public void deviceRemoved(Registry registry, Device device) {
    }

    @Override // org.jupnp.registry.RegistryListener
    public void localDeviceAdded(Registry registry, LocalDevice localDevice) {
        deviceAdded(registry, localDevice);
    }

    @Override // org.jupnp.registry.RegistryListener
    public void localDeviceRemoved(Registry registry, LocalDevice localDevice) {
        deviceRemoved(registry, localDevice);
    }

    @Override // org.jupnp.registry.RegistryListener
    public void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice) {
        deviceAdded(registry, remoteDevice);
    }

    @Override // org.jupnp.registry.RegistryListener
    public void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice remoteDevice, Exception exc) {
    }

    @Override // org.jupnp.registry.RegistryListener
    public void remoteDeviceDiscoveryStarted(Registry registry, RemoteDevice remoteDevice) {
    }

    @Override // org.jupnp.registry.RegistryListener
    public void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice) {
        deviceRemoved(registry, remoteDevice);
    }

    @Override // org.jupnp.registry.RegistryListener
    public void remoteDeviceUpdated(Registry registry, RemoteDevice remoteDevice) {
    }
}
