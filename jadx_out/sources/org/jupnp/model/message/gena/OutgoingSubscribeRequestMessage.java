package org.jupnp.model.message.gena;

import java.net.URL;
import java.util.List;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.CallbackHeader;
import org.jupnp.model.message.header.NTEventHeader;
import org.jupnp.model.message.header.TimeoutHeader;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingSubscribeRequestMessage extends StreamRequestMessage {
    public OutgoingSubscribeRequestMessage(RemoteGENASubscription remoteGENASubscription, List<URL> list, UpnpHeaders upnpHeaders) {
        super(UpnpRequest.Method.SUBSCRIBE, remoteGENASubscription.getEventSubscriptionURL());
        getHeaders().add(UpnpHeader.Type.CALLBACK, new CallbackHeader(list));
        getHeaders().add(UpnpHeader.Type.NT, new NTEventHeader());
        getHeaders().add(UpnpHeader.Type.TIMEOUT, new TimeoutHeader(remoteGENASubscription.getRequestedDurationSeconds()));
        if (upnpHeaders != null) {
            getHeaders().putAll(upnpHeaders);
        }
    }

    public boolean hasCallbackURLs() {
        return !((CallbackHeader) getHeaders().getFirstHeader(UpnpHeader.Type.CALLBACK, CallbackHeader.class)).getValue().isEmpty();
    }
}
