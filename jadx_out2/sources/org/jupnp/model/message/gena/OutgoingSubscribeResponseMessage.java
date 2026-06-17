package org.jupnp.model.message.gena;

import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.ServerHeader;
import org.jupnp.model.message.header.SubscriptionIdHeader;
import org.jupnp.model.message.header.TimeoutHeader;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingSubscribeResponseMessage extends StreamResponseMessage {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingSubscribeResponseMessage(LocalGENASubscription localGENASubscription) {
        super(new UpnpResponse(UpnpResponse.Status.OK));
        getHeaders().add(UpnpHeader.Type.SERVER, new ServerHeader());
        getHeaders().add(UpnpHeader.Type.SID, new SubscriptionIdHeader(localGENASubscription.getSubscriptionId()));
        getHeaders().add(UpnpHeader.Type.TIMEOUT, new TimeoutHeader(localGENASubscription.getActualDurationSeconds()));
    }

    public OutgoingSubscribeResponseMessage(UpnpResponse.Status status) {
        super(status);
    }
}
