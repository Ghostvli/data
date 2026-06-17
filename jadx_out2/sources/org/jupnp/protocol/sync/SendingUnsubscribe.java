package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.gena.CancelReason;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.gena.OutgoingUnsubscribeRequestMessage;
import org.jupnp.protocol.SendingSync;
import org.jupnp.protocol.sync.SendingUnsubscribe;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingUnsubscribe extends SendingSync<OutgoingUnsubscribeRequestMessage, StreamResponseMessage> {
    private final j02 logger;
    protected final RemoteGENASubscription subscription;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SendingUnsubscribe(UpnpService upnpService, RemoteGENASubscription remoteGENASubscription) {
        super(upnpService, new OutgoingUnsubscribeRequestMessage(remoteGENASubscription, upnpService.getConfiguration().getEventSubscriptionHeaders(remoteGENASubscription.getService())));
        this.logger = n02.k(SendingUnsubscribe.class);
        this.subscription = remoteGENASubscription;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(SendingUnsubscribe sendingUnsubscribe, StreamResponseMessage streamResponseMessage) {
        if (streamResponseMessage == null) {
            sendingUnsubscribe.logger.y("Unsubscribe failed, no response received");
            sendingUnsubscribe.subscription.end(CancelReason.UNSUBSCRIBE_FAILED, null);
            return;
        }
        sendingUnsubscribe.getClass();
        boolean zIsFailed = streamResponseMessage.getOperation().isFailed();
        j02 j02Var = sendingUnsubscribe.logger;
        if (zIsFailed) {
            j02Var.h("Unsubscribe failed, response was: {}", streamResponseMessage);
            sendingUnsubscribe.subscription.end(CancelReason.UNSUBSCRIBE_FAILED, streamResponseMessage.getOperation());
        } else {
            j02Var.h("Unsubscribe successful, response was: {}", streamResponseMessage);
            sendingUnsubscribe.subscription.end(null, streamResponseMessage.getOperation());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.SendingSync
    public StreamResponseMessage executeSync() {
        this.logger.h("Sending unsubscribe request: {}", getInputMessage());
        try {
            StreamResponseMessage streamResponseMessageSend = getUpnpService().getRouter().send(getInputMessage());
            onUnsubscribe(streamResponseMessageSend);
            return streamResponseMessageSend;
        } catch (Throwable th) {
            onUnsubscribe(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onUnsubscribe(final StreamResponseMessage streamResponseMessage) {
        getUpnpService().getRegistry().removeRemoteSubscription(this.subscription);
        getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: e14
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                SendingUnsubscribe.a(this.f, streamResponseMessage);
            }
        });
    }
}
