package org.jupnp.android;

import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.registry.Registry;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface AndroidUpnpService {
    UpnpService get();

    UpnpServiceConfiguration getConfiguration();

    ControlPoint getControlPoint();

    Registry getRegistry();
}
