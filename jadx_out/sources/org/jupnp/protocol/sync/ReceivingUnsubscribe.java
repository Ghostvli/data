package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.gena.IncomingUnsubscribeRequestMessage;
import org.jupnp.model.resource.ServiceEventSubscriptionResource;
import org.jupnp.protocol.ReceivingSync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingUnsubscribe extends ReceivingSync<StreamRequestMessage, StreamResponseMessage> {
    private final j02 logger;

    public ReceivingUnsubscribe(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
        this.logger = n02.k(ReceivingUnsubscribe.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jupnp.protocol.ReceivingSync
    public StreamResponseMessage executeSync() {
        ServiceEventSubscriptionResource serviceEventSubscriptionResource = (ServiceEventSubscriptionResource) getUpnpService().getRegistry().getResource(ServiceEventSubscriptionResource.class, ((StreamRequestMessage) getInputMessage()).getUri());
        j02 j02Var = this.logger;
        if (serviceEventSubscriptionResource == null) {
            j02Var.h("No local resource found: {}", getInputMessage());
            return null;
        }
        j02Var.h("Found local event subscription matching relative request URI: {}", ((StreamRequestMessage) getInputMessage()).getUri());
        IncomingUnsubscribeRequestMessage incomingUnsubscribeRequestMessage = new IncomingUnsubscribeRequestMessage((StreamRequestMessage) getInputMessage(), serviceEventSubscriptionResource.getModel());
        if (incomingUnsubscribeRequestMessage.getSubscriptionId() != null && (incomingUnsubscribeRequestMessage.hasNotificationHeader() || incomingUnsubscribeRequestMessage.hasCallbackHeader())) {
            this.logger.h("Subscription ID and NT or Callback in unsubcribe request: {}", getInputMessage());
            return new StreamResponseMessage(UpnpResponse.Status.BAD_REQUEST);
        }
        LocalGENASubscription localSubscription = getUpnpService().getRegistry().getLocalSubscription(incomingUnsubscribeRequestMessage.getSubscriptionId());
        j02 j02Var2 = this.logger;
        if (localSubscription == null) {
            j02Var2.h("Invalid subscription ID for unsubscribe request: {}", getInputMessage());
            return new StreamResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
        j02Var2.h("Unregistering subscription: {}", localSubscription);
        if (getUpnpService().getRegistry().removeLocalSubscription(localSubscription)) {
            localSubscription.end(null);
        } else {
            this.logger.y("Subscription was already removed from registry");
        }
        return new StreamResponseMessage(UpnpResponse.Status.OK);
    }
}
