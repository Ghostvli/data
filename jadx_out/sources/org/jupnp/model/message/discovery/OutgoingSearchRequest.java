package org.jupnp.model.message.discovery;

import org.jupnp.model.Constants;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.HostHeader;
import org.jupnp.model.message.header.MANHeader;
import org.jupnp.model.message.header.MXHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingSearchRequest extends OutgoingDatagramMessage<UpnpRequest> {
    private UpnpHeader searchTarget;

    public OutgoingSearchRequest(UpnpHeader upnpHeader, int i) {
        super(new UpnpRequest(UpnpRequest.Method.MSEARCH), ModelUtil.getInetAddressByName(Constants.IPV4_UPNP_MULTICAST_GROUP), Constants.UPNP_MULTICAST_PORT);
        this.searchTarget = upnpHeader;
        getHeaders().add(UpnpHeader.Type.MAN, new MANHeader(NotificationSubtype.DISCOVER.getHeaderString()));
        getHeaders().add(UpnpHeader.Type.MX, new MXHeader(Integer.valueOf(i)));
        getHeaders().add(UpnpHeader.Type.ST, upnpHeader);
        getHeaders().add(UpnpHeader.Type.HOST, new HostHeader());
    }

    public UpnpHeader getSearchTarget() {
        return this.searchTarget;
    }
}
