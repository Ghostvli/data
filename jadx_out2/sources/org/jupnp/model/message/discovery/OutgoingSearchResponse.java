package org.jupnp.model.message.discovery;

import org.jupnp.model.Constants;
import org.jupnp.model.Location;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.EXTHeader;
import org.jupnp.model.message.header.InterfaceMacHeader;
import org.jupnp.model.message.header.LocationHeader;
import org.jupnp.model.message.header.MaxAgeHeader;
import org.jupnp.model.message.header.ServerHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingSearchResponse extends OutgoingDatagramMessage<UpnpResponse> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingSearchResponse(IncomingDatagramMessage incomingDatagramMessage, Location location, LocalDevice localDevice) {
        super(new UpnpResponse(UpnpResponse.Status.OK), incomingDatagramMessage.getSourceAddress(), incomingDatagramMessage.getSourcePort());
        getHeaders().add(UpnpHeader.Type.MAX_AGE, new MaxAgeHeader(localDevice.getIdentity().getMaxAgeSeconds()));
        getHeaders().add(UpnpHeader.Type.LOCATION, new LocationHeader(location.getURL()));
        getHeaders().add(UpnpHeader.Type.SERVER, new ServerHeader());
        getHeaders().add(UpnpHeader.Type.EXT, new EXTHeader());
        if (!"true".equals(System.getProperty(Constants.SYSTEM_PROPERTY_ANNOUNCE_MAC_ADDRESS)) || location.getNetworkAddress().getHardwareAddress() == null) {
            return;
        }
        getHeaders().add(UpnpHeader.Type.EXT_IFACE_MAC, new InterfaceMacHeader(location.getNetworkAddress().getHardwareAddress()));
    }
}
