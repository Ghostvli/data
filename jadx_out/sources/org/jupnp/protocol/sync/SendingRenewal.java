package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.gena.CancelReason;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.gena.IncomingSubscribeResponseMessage;
import org.jupnp.model.message.gena.OutgoingRenewalRequestMessage;
import org.jupnp.protocol.SendingSync;
import org.jupnp.transport.RouterException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingRenewal extends SendingSync<OutgoingRenewalRequestMessage, IncomingSubscribeResponseMessage> {
    private final j02 logger;
    protected final RemoteGENASubscription subscription;

    public SendingRenewal(UpnpService upnpService, RemoteGENASubscription remoteGENASubscription) {
        super(upnpService, new OutgoingRenewalRequestMessage(remoteGENASubscription, upnpService.getConfiguration().getEventSubscriptionHeaders(remoteGENASubscription.getService())));
        this.logger = n02.k(SendingRenewal.class);
        this.subscription = remoteGENASubscription;
    }

    @Override // org.jupnp.protocol.SendingSync
    public IncomingSubscribeResponseMessage executeSync() throws RouterException {
        this.logger.h("Sending subscription renewal request: {}", getInputMessage());
        try {
            StreamResponseMessage streamResponseMessageSend = getUpnpService().getRouter().send(getInputMessage());
            if (streamResponseMessageSend == null) {
                onRenewalFailure();
                return null;
            }
            final IncomingSubscribeResponseMessage incomingSubscribeResponseMessage = new IncomingSubscribeResponseMessage(streamResponseMessageSend);
            if (streamResponseMessageSend.getOperation().isFailed()) {
                this.logger.h("Subscription renewal failed, response was: {}", streamResponseMessageSend);
                getUpnpService().getRegistry().removeRemoteSubscription(this.subscription);
                getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: w04
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.subscription.end(CancelReason.RENEWAL_FAILED, incomingSubscribeResponseMessage.getOperation());
                    }
                });
                return incomingSubscribeResponseMessage;
            }
            boolean zIsValidHeaders = incomingSubscribeResponseMessage.isValidHeaders();
            j02 j02Var = this.logger;
            if (!zIsValidHeaders) {
                j02Var.error("Subscription renewal failed, invalid or missing (SID, Timeout) response headers");
                getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: x04
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.subscription.end(CancelReason.RENEWAL_FAILED, incomingSubscribeResponseMessage.getOperation());
                    }
                });
                return incomingSubscribeResponseMessage;
            }
            j02Var.h("Subscription renewed, updating in registry, response was: {}", streamResponseMessageSend);
            this.subscription.setActualSubscriptionDurationSeconds(incomingSubscribeResponseMessage.getSubscriptionDurationSeconds());
            getUpnpService().getRegistry().updateRemoteSubscription(this.subscription);
            return incomingSubscribeResponseMessage;
        } catch (RouterException e) {
            onRenewalFailure();
            throw e;
        }
    }

    public void onRenewalFailure() {
        this.logger.y("Subscription renewal failed, removing subscription from registry");
        getUpnpService().getRegistry().removeRemoteSubscription(this.subscription);
        getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: y04
            @Override // java.lang.Runnable
            public final void run() {
                this.f.subscription.end(CancelReason.RENEWAL_FAILED, null);
            }
        });
    }
}
