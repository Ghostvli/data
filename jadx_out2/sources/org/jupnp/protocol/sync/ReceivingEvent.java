package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.gena.IncomingEventRequestMessage;
import org.jupnp.model.message.gena.OutgoingEventResponseMessage;
import org.jupnp.model.resource.ServiceEventCallbackResource;
import org.jupnp.protocol.ReceivingSync;
import org.jupnp.protocol.sync.ReceivingEvent;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingEvent extends ReceivingSync<StreamRequestMessage, OutgoingEventResponseMessage> {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReceivingEvent(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
        this.logger = n02.k(ReceivingEvent.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(ReceivingEvent receivingEvent, RemoteGENASubscription remoteGENASubscription, IncomingEventRequestMessage incomingEventRequestMessage) {
        receivingEvent.logger.y("Calling active subscription with event state variable values");
        remoteGENASubscription.receive(incomingEventRequestMessage.getSequence(), incomingEventRequestMessage.getStateVariableValues());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: executeSync()Lorg/jupnp/model/message/StreamResponseMessage; */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: IN */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: IN */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: IN */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jupnp.protocol.ReceivingSync
    public OutgoingEventResponseMessage executeSync() {
        if (!((StreamRequestMessage) getInputMessage()).isContentTypeTextUDA()) {
            this.logger.d("Received without or with invalid Content-Type: {}", getInputMessage());
        }
        ServiceEventCallbackResource serviceEventCallbackResource = (ServiceEventCallbackResource) getUpnpService().getRegistry().getResource(ServiceEventCallbackResource.class, ((StreamRequestMessage) getInputMessage()).getUri());
        if (serviceEventCallbackResource == null) {
            this.logger.h("No local resource found: {}", getInputMessage());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.NOT_FOUND));
        }
        final IncomingEventRequestMessage incomingEventRequestMessage = new IncomingEventRequestMessage((StreamRequestMessage) getInputMessage(), serviceEventCallbackResource.getModel());
        if (incomingEventRequestMessage.getSubscrptionId() == null) {
            this.logger.h("Subscription ID missing in event request: {}", getInputMessage());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        }
        if (!incomingEventRequestMessage.hasValidNotificationHeaders()) {
            this.logger.h("Missing NT and/or NTS headers in event request: {}", getInputMessage());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.BAD_REQUEST));
        }
        if (!incomingEventRequestMessage.hasValidNotificationHeaders()) {
            this.logger.h("Invalid NT and/or NTS headers in event request: {}", getInputMessage());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        }
        if (incomingEventRequestMessage.getSequence() == null) {
            this.logger.h("Sequence missing in event request: {}", getInputMessage());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        }
        try {
            getUpnpService().getConfiguration().getGenaEventProcessor().readBody(incomingEventRequestMessage);
            final RemoteGENASubscription waitRemoteSubscription = getUpnpService().getRegistry().getWaitRemoteSubscription(incomingEventRequestMessage.getSubscrptionId());
            if (waitRemoteSubscription == null) {
                this.logger.q("Invalid subscription ID, no active subscription: {}", incomingEventRequestMessage);
                return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
            }
            getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: so3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    ReceivingEvent.a(this.f, waitRemoteSubscription, incomingEventRequestMessage);
                }
            });
            return new OutgoingEventResponseMessage();
        } catch (UnsupportedDataException e) {
            this.logger.v("Can't read event message request body", e);
            final RemoteGENASubscription remoteSubscription = getUpnpService().getRegistry().getRemoteSubscription(incomingEventRequestMessage.getSubscrptionId());
            if (remoteSubscription != null) {
                getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: ro3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        remoteSubscription.invalidMessage(e);
                    }
                });
            }
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.INTERNAL_SERVER_ERROR));
        }
    }
}
