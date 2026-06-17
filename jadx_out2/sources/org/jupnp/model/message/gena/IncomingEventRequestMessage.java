package org.jupnp.model.message.gena;

import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.header.EventSequenceHeader;
import org.jupnp.model.message.header.NTEventHeader;
import org.jupnp.model.message.header.NTSHeader;
import org.jupnp.model.message.header.SubscriptionIdHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.NotificationSubtype;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingEventRequestMessage extends StreamRequestMessage {
    private final RemoteService service;
    private final List<StateVariableValue> stateVariableValues;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingEventRequestMessage(StreamRequestMessage streamRequestMessage, RemoteService remoteService) {
        super(streamRequestMessage);
        this.stateVariableValues = new ArrayList();
        this.service = remoteService;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UnsignedIntegerFourBytes getSequence() {
        EventSequenceHeader eventSequenceHeader = (EventSequenceHeader) getHeaders().getFirstHeader(UpnpHeader.Type.SEQ, EventSequenceHeader.class);
        if (eventSequenceHeader != null) {
            return eventSequenceHeader.getValue();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteService getService() {
        return this.service;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<StateVariableValue> getStateVariableValues() {
        return this.stateVariableValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSubscrptionId() {
        SubscriptionIdHeader subscriptionIdHeader = (SubscriptionIdHeader) getHeaders().getFirstHeader(UpnpHeader.Type.SID, SubscriptionIdHeader.class);
        if (subscriptionIdHeader != null) {
            return subscriptionIdHeader.getValue();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasNotificationHeaders() {
        UpnpHeader firstHeader = getHeaders().getFirstHeader(UpnpHeader.Type.NT);
        UpnpHeader firstHeader2 = getHeaders().getFirstHeader(UpnpHeader.Type.NTS);
        return (firstHeader == null || firstHeader.getValue() == null || firstHeader2 == null || firstHeader2.getValue() == null) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasValidNotificationHeaders() {
        NTEventHeader nTEventHeader = (NTEventHeader) getHeaders().getFirstHeader(UpnpHeader.Type.NT, NTEventHeader.class);
        NTSHeader nTSHeader = (NTSHeader) getHeaders().getFirstHeader(UpnpHeader.Type.NTS, NTSHeader.class);
        return (nTEventHeader == null || nTEventHeader.getValue() == null || nTSHeader == null || !nTSHeader.getValue().equals(NotificationSubtype.PROPCHANGE)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.UpnpMessage
    public String toString() {
        return super.toString() + " SEQUENCE: " + getSequence().getValue();
    }
}
