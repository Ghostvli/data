package org.jupnp.model.message.gena;

import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.header.SubscriptionIdHeader;
import org.jupnp.model.message.header.TimeoutHeader;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingSubscribeResponseMessage extends StreamResponseMessage {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingSubscribeResponseMessage(StreamResponseMessage streamResponseMessage) {
        super(streamResponseMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSubscriptionDurationSeconds() {
        return ((TimeoutHeader) getHeaders().getFirstHeader(UpnpHeader.Type.TIMEOUT, TimeoutHeader.class)).getValue().intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSubscriptionId() {
        return ((SubscriptionIdHeader) getHeaders().getFirstHeader(UpnpHeader.Type.SID, SubscriptionIdHeader.class)).getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isValidHeaders() {
        return (getHeaders().getFirstHeader(UpnpHeader.Type.SID, SubscriptionIdHeader.class) == null || getHeaders().getFirstHeader(UpnpHeader.Type.TIMEOUT, TimeoutHeader.class) == null) ? false : true;
    }
}
