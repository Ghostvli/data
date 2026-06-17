package org.jupnp.model.message.discovery;

import org.jupnp.model.Location;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.header.ServiceTypeHeader;
import org.jupnp.model.message.header.ServiceUSNHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.ServiceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingSearchResponseServiceType extends OutgoingSearchResponse {
    public OutgoingSearchResponseServiceType(IncomingDatagramMessage incomingDatagramMessage, Location location, LocalDevice localDevice, ServiceType serviceType) {
        super(incomingDatagramMessage, location, localDevice);
        getHeaders().add(UpnpHeader.Type.ST, new ServiceTypeHeader(serviceType));
        getHeaders().add(UpnpHeader.Type.USN, new ServiceUSNHeader(localDevice.getIdentity().getUdn(), serviceType));
    }
}
