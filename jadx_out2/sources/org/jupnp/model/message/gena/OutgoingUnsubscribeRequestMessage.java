package org.jupnp.model.message.gena;

import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.SubscriptionIdHeader;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingUnsubscribeRequestMessage extends StreamRequestMessage {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingUnsubscribeRequestMessage(RemoteGENASubscription remoteGENASubscription, UpnpHeaders upnpHeaders) {
        super(UpnpRequest.Method.UNSUBSCRIBE, remoteGENASubscription.getEventSubscriptionURL());
        getHeaders().add(UpnpHeader.Type.SID, new SubscriptionIdHeader(remoteGENASubscription.getSubscriptionId()));
        if (upnpHeaders != null) {
            getHeaders().putAll(upnpHeaders);
        }
    }
}
