package org.jupnp.model.message.discovery;

import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.MANHeader;
import org.jupnp.model.message.header.MXHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingSearchRequest extends IncomingDatagramMessage<UpnpRequest> {
    public IncomingSearchRequest(IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        super(incomingDatagramMessage);
    }

    public Integer getMX() {
        MXHeader mXHeader = (MXHeader) getHeaders().getFirstHeader(UpnpHeader.Type.MX, MXHeader.class);
        if (mXHeader != null) {
            return mXHeader.getValue();
        }
        return null;
    }

    public UpnpHeader getSearchTarget() {
        return getHeaders().getFirstHeader(UpnpHeader.Type.ST);
    }

    public boolean isMANSSDPDiscover() {
        MANHeader mANHeader = (MANHeader) getHeaders().getFirstHeader(UpnpHeader.Type.MAN, MANHeader.class);
        return mANHeader != null && mANHeader.getValue().equals(NotificationSubtype.DISCOVER.getHeaderString());
    }
}
