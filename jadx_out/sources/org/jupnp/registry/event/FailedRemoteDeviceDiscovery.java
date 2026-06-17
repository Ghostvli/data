package org.jupnp.registry.event;

import org.jupnp.model.meta.RemoteDevice;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FailedRemoteDeviceDiscovery extends DeviceDiscovery<RemoteDevice> {
    protected Exception exception;

    public FailedRemoteDeviceDiscovery(RemoteDevice remoteDevice, Exception exc) {
        super(remoteDevice);
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }
}
