package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import java.net.URL;
import java.util.Iterator;
import org.jupnp.UpnpService;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.gena.OutgoingEventRequestMessage;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.protocol.SendingSync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingEvent extends SendingSync<OutgoingEventRequestMessage, StreamResponseMessage> {
    protected final UnsignedIntegerFourBytes currentSequence;
    private final j02 logger;
    protected final OutgoingEventRequestMessage[] requestMessages;
    protected final String subscriptionId;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SendingEvent(UpnpService upnpService, LocalGENASubscription localGENASubscription) {
        super(upnpService, null);
        this.logger = n02.k(SendingEvent.class);
        this.subscriptionId = localGENASubscription.getSubscriptionId();
        this.requestMessages = new OutgoingEventRequestMessage[localGENASubscription.getCallbackURLs().size()];
        Iterator<URL> it = localGENASubscription.getCallbackURLs().iterator();
        int i = 0;
        while (it.hasNext()) {
            this.requestMessages[i] = new OutgoingEventRequestMessage(localGENASubscription, it.next());
            getUpnpService().getConfiguration().getGenaEventProcessor().writeBody(this.requestMessages[i]);
            i++;
        }
        this.currentSequence = localGENASubscription.getCurrentSequence();
        localGENASubscription.incrementSequence();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.SendingSync
    public StreamResponseMessage executeSync() {
        this.logger.h("Sending event for subscription: {}", this.subscriptionId);
        StreamResponseMessage streamResponseMessageSend = null;
        for (OutgoingEventRequestMessage outgoingEventRequestMessage : this.requestMessages) {
            long jLongValue = this.currentSequence.getValue().longValue();
            j02 j02Var = this.logger;
            if (jLongValue == 0) {
                j02Var.h("Sending initial event message to callback URL: {}", outgoingEventRequestMessage.getUri());
            } else {
                j02Var.i("Sending event message '{}' to callback URL: {}", this.currentSequence, outgoingEventRequestMessage.getUri());
            }
            streamResponseMessageSend = getUpnpService().getRouter().send(outgoingEventRequestMessage);
            this.logger.h("Received event callback response: {}", streamResponseMessageSend);
        }
        return streamResponseMessageSend;
    }
}
