package org.jupnp.registry.event;

import org.jupnp.model.meta.Device;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceDiscovery<D extends Device> {
    protected D device;

    public DeviceDiscovery(D d) {
        this.device = d;
    }

    public D getDevice() {
        return this.device;
    }
}
