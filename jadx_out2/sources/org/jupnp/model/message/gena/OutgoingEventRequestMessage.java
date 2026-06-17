package org.jupnp.model.message.gena;

import java.net.URL;
import java.util.Collection;
import org.jupnp.model.gena.GENASubscription;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.ContentTypeHeader;
import org.jupnp.model.message.header.EventSequenceHeader;
import org.jupnp.model.message.header.NTEventHeader;
import org.jupnp.model.message.header.NTSHeader;
import org.jupnp.model.message.header.SubscriptionIdHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.NotificationSubtype;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingEventRequestMessage extends StreamRequestMessage {
    private final Collection<StateVariableValue> stateVariableValues;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingEventRequestMessage(GENASubscription gENASubscription, URL url, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Collection<StateVariableValue> collection) {
        super(new UpnpRequest(UpnpRequest.Method.NOTIFY, url));
        getHeaders().add(UpnpHeader.Type.CONTENT_TYPE, new ContentTypeHeader());
        getHeaders().add(UpnpHeader.Type.NT, new NTEventHeader());
        getHeaders().add(UpnpHeader.Type.NTS, new NTSHeader(NotificationSubtype.PROPCHANGE));
        getHeaders().add(UpnpHeader.Type.SID, new SubscriptionIdHeader(gENASubscription.getSubscriptionId()));
        getHeaders().add(UpnpHeader.Type.SEQ, new EventSequenceHeader(unsignedIntegerFourBytes.getValue().longValue()));
        this.stateVariableValues = collection;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<StateVariableValue> getStateVariableValues() {
        return this.stateVariableValues;
    }

    public OutgoingEventRequestMessage(GENASubscription gENASubscription, URL url) {
        this(gENASubscription, url, gENASubscription.getCurrentSequence(), gENASubscription.getCurrentValues().values());
    }
}
