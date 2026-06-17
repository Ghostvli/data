package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import org.jupnp.UpnpService;
import org.jupnp.model.gena.CancelReason;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.gena.IncomingSubscribeRequestMessage;
import org.jupnp.model.message.gena.OutgoingSubscribeResponseMessage;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.resource.ServiceEventSubscriptionResource;
import org.jupnp.protocol.ReceivingSync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingSubscribe extends ReceivingSync<StreamRequestMessage, OutgoingSubscribeResponseMessage> {
    private final j02 logger;
    protected LocalGENASubscription subscription;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReceivingSubscribe(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
        this.logger = n02.k(ReceivingSubscribe.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: executeSync()Lorg/jupnp/model/message/StreamResponseMessage; */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: IN */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: IN */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: IN */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jupnp.protocol.ReceivingSync
    public OutgoingSubscribeResponseMessage executeSync() {
        ServiceEventSubscriptionResource serviceEventSubscriptionResource = (ServiceEventSubscriptionResource) getUpnpService().getRegistry().getResource(ServiceEventSubscriptionResource.class, ((StreamRequestMessage) getInputMessage()).getUri());
        j02 j02Var = this.logger;
        if (serviceEventSubscriptionResource == null) {
            j02Var.h("No local resource found: {}", getInputMessage());
            return null;
        }
        j02Var.h("Found local event subscription matching relative request URI: {}", ((StreamRequestMessage) getInputMessage()).getUri());
        IncomingSubscribeRequestMessage incomingSubscribeRequestMessage = new IncomingSubscribeRequestMessage((StreamRequestMessage) getInputMessage(), serviceEventSubscriptionResource.getModel());
        if (incomingSubscribeRequestMessage.getCallbackURLs() != null) {
            Iterator<URL> it = incomingSubscribeRequestMessage.getCallbackURLs().iterator();
            while (it.hasNext()) {
                try {
                    InetAddress byName = InetAddress.getByName(it.next().getHost());
                    if (!byName.isLoopbackAddress() && !byName.isLinkLocalAddress() && !byName.isSiteLocalAddress()) {
                        this.logger.h("Callback URL not on accepted address range: {}", getInputMessage());
                        return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
                    }
                } catch (UnknownHostException unused) {
                    this.logger.h("Unknown host for callback URL: {}", getInputMessage());
                    return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
                }
            }
        }
        if (incomingSubscribeRequestMessage.getSubscriptionId() != null && (incomingSubscribeRequestMessage.hasNotificationHeader() || incomingSubscribeRequestMessage.getCallbackURLs() != null)) {
            this.logger.h("Subscription ID and NT or Callback in subscribe request: {}", getInputMessage());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.BAD_REQUEST);
        }
        if (incomingSubscribeRequestMessage.getSubscriptionId() != null) {
            return processRenewal(serviceEventSubscriptionResource.getModel(), incomingSubscribeRequestMessage);
        }
        if (incomingSubscribeRequestMessage.hasNotificationHeader() && incomingSubscribeRequestMessage.getCallbackURLs() != null) {
            return processNewSubscription(serviceEventSubscriptionResource.getModel(), incomingSubscribeRequestMessage);
        }
        this.logger.h("No subscription ID, no NT or Callback, neither subscription or renewal: {}", getInputMessage());
        return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingSubscribeResponseMessage processNewSubscription(LocalService localService, IncomingSubscribeRequestMessage incomingSubscribeRequestMessage) {
        List<URL> callbackURLs = incomingSubscribeRequestMessage.getCallbackURLs();
        if (callbackURLs == null || callbackURLs.isEmpty()) {
            this.logger.h("Missing or invalid Callback URLs in subscribe request: {}", getInputMessage());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
        if (!incomingSubscribeRequestMessage.hasNotificationHeader()) {
            this.logger.h("Missing or invalid NT header in subscribe request: {}", getInputMessage());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
        try {
            LocalGENASubscription localGENASubscription = new LocalGENASubscription(localService, getUpnpService().getConfiguration().isReceivedSubscriptionTimeoutIgnored() ? null : incomingSubscribeRequestMessage.getRequestedTimeoutSeconds(), callbackURLs) { // from class: org.jupnp.protocol.sync.ReceivingSubscribe.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.LocalGENASubscription
                public void ended(CancelReason cancelReason) {
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.GENASubscription
                public void established() {
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.GENASubscription
                public void eventReceived() {
                    ReceivingSubscribe.this.getUpnpService().getConfiguration().getSyncProtocolExecutorService().execute(ReceivingSubscribe.this.getUpnpService().getProtocolFactory().createSendingEvent(this));
                }
            };
            this.subscription = localGENASubscription;
            this.logger.h("Adding subscription to registry: {}", localGENASubscription);
            getUpnpService().getRegistry().addLocalSubscription(this.subscription);
            this.logger.y("Returning subscription response, waiting to send initial event");
            return new OutgoingSubscribeResponseMessage(this.subscription);
        } catch (Exception e) {
            this.logger.u("Couldn't create local subscription to service", e);
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingSubscribeResponseMessage processRenewal(LocalService localService, IncomingSubscribeRequestMessage incomingSubscribeRequestMessage) {
        LocalGENASubscription localSubscription = getUpnpService().getRegistry().getLocalSubscription(incomingSubscribeRequestMessage.getSubscriptionId());
        this.subscription = localSubscription;
        j02 j02Var = this.logger;
        if (localSubscription == null) {
            j02Var.h("Invalid subscription ID for renewal request: {}", getInputMessage());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
        j02Var.h("Renewing subscription: {}", localSubscription);
        this.subscription.setSubscriptionDuration(incomingSubscribeRequestMessage.getRequestedTimeoutSeconds());
        if (getUpnpService().getRegistry().updateLocalSubscription(this.subscription)) {
            return new OutgoingSubscribeResponseMessage(this.subscription);
        }
        this.logger.h("Subscription went away before it could be renewed: {}", getInputMessage());
        return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.ReceivingSync
    public void responseException(Throwable th) {
        LocalGENASubscription localGENASubscription = this.subscription;
        if (localGENASubscription == null) {
            return;
        }
        this.logger.h("Response could not be send to subscriber, removing local GENA subscription: {}", localGENASubscription);
        getUpnpService().getRegistry().removeLocalSubscription(this.subscription);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.ReceivingSync
    public void responseSent(StreamResponseMessage streamResponseMessage) {
        if (this.subscription == null) {
            return;
        }
        if (streamResponseMessage != null && !streamResponseMessage.getOperation().isFailed() && this.subscription.getCurrentSequence().getValue().longValue() == 0) {
            this.logger.y("Establishing subscription");
            this.subscription.registerOnService();
            this.subscription.establish();
            this.logger.y("Response to subscription sent successfully, now sending initial event asynchronously");
            getUpnpService().getConfiguration().getAsyncProtocolExecutor().execute(getUpnpService().getProtocolFactory().createSendingEvent(this.subscription));
            return;
        }
        if (this.subscription.getCurrentSequence().getValue().longValue() == 0) {
            this.logger.y("Subscription request's response aborted, not sending initial event");
            j02 j02Var = this.logger;
            if (streamResponseMessage == null) {
                j02Var.y("Reason: No response at all from subscriber");
            } else {
                j02Var.h("Reason: {}", streamResponseMessage.getOperation());
            }
            this.logger.h("Removing subscription from registry: {}", this.subscription);
            getUpnpService().getRegistry().removeLocalSubscription(this.subscription);
        }
    }
}
