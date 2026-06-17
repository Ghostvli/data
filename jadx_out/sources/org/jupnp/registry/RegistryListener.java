package org.jupnp.registry;

import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.RemoteDevice;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface RegistryListener {
    void afterShutdown();

    void beforeShutdown(Registry registry);

    void localDeviceAdded(Registry registry, LocalDevice localDevice);

    void localDeviceRemoved(Registry registry, LocalDevice localDevice);

    void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice);

    void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice remoteDevice, Exception exc);

    void remoteDeviceDiscoveryStarted(Registry registry, RemoteDevice remoteDevice);

    void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice);

    void remoteDeviceUpdated(Registry registry, RemoteDevice remoteDevice);
}
