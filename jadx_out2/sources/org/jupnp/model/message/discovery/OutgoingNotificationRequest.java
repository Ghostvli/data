package org.jupnp.model.message.discovery;

import org.jupnp.model.Constants;
import org.jupnp.model.Location;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.HostHeader;
import org.jupnp.model.message.header.LocationHeader;
import org.jupnp.model.message.header.MaxAgeHeader;
import org.jupnp.model.message.header.NTSHeader;
import org.jupnp.model.message.header.ServerHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OutgoingNotificationRequest extends OutgoingDatagramMessage<UpnpRequest> {
    private NotificationSubtype type;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingNotificationRequest(Location location, LocalDevice localDevice, NotificationSubtype notificationSubtype) {
        super(new UpnpRequest(UpnpRequest.Method.NOTIFY), ModelUtil.getInetAddressByName(Constants.IPV4_UPNP_MULTICAST_GROUP), Constants.UPNP_MULTICAST_PORT);
        this.type = notificationSubtype;
        getHeaders().add(UpnpHeader.Type.MAX_AGE, new MaxAgeHeader(localDevice.getIdentity().getMaxAgeSeconds()));
        getHeaders().add(UpnpHeader.Type.LOCATION, new LocationHeader(location.getURL()));
        getHeaders().add(UpnpHeader.Type.SERVER, new ServerHeader());
        getHeaders().add(UpnpHeader.Type.HOST, new HostHeader());
        getHeaders().add(UpnpHeader.Type.NTS, new NTSHeader(notificationSubtype));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NotificationSubtype getType() {
        return this.type;
    }
}
