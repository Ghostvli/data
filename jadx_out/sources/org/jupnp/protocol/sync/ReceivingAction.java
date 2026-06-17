package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.action.ActionCancelledException;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.RemoteActionInvocation;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.control.IncomingActionRequestMessage;
import org.jupnp.model.message.control.OutgoingActionResponseMessage;
import org.jupnp.model.message.header.ContentTypeHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.resource.ServiceControlResource;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.protocol.ReceivingSync;
import org.jupnp.util.Exceptions;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingAction extends ReceivingSync<StreamRequestMessage, StreamResponseMessage> {
    private final j02 logger;

    public ReceivingAction(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
        this.logger = n02.k(ReceivingAction.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jupnp.protocol.ReceivingSync
    public StreamResponseMessage executeSync() {
        RemoteActionInvocation remoteActionInvocation;
        OutgoingActionResponseMessage outgoingActionResponseMessage;
        ContentTypeHeader contentTypeHeader = (ContentTypeHeader) ((StreamRequestMessage) getInputMessage()).getHeaders().getFirstHeader(UpnpHeader.Type.CONTENT_TYPE, ContentTypeHeader.class);
        if (contentTypeHeader != null && !contentTypeHeader.isUDACompliantXML()) {
            SpecificationViolationReporter.report("Received invalid Content-Type '{}': {}", contentTypeHeader, getInputMessage());
            return new StreamResponseMessage(new UpnpResponse(UpnpResponse.Status.UNSUPPORTED_MEDIA_TYPE));
        }
        if (contentTypeHeader == null) {
            SpecificationViolationReporter.report("Received without Content-Type: {}", getInputMessage());
        }
        ServiceControlResource serviceControlResource = (ServiceControlResource) getUpnpService().getRegistry().getResource(ServiceControlResource.class, ((StreamRequestMessage) getInputMessage()).getUri());
        j02 j02Var = this.logger;
        if (serviceControlResource == null) {
            j02Var.h("No local resource found: {}", getInputMessage());
            return null;
        }
        j02Var.h("Found local action resource matching relative request URI: {}", ((StreamRequestMessage) getInputMessage()).getUri());
        try {
            IncomingActionRequestMessage incomingActionRequestMessage = new IncomingActionRequestMessage((StreamRequestMessage) getInputMessage(), serviceControlResource.getModel());
            this.logger.h("Created incoming action request message: {}", incomingActionRequestMessage);
            remoteActionInvocation = new RemoteActionInvocation(incomingActionRequestMessage.getAction(), getRemoteClientInfo());
            this.logger.y("Reading body of request message");
            getUpnpService().getConfiguration().getSoapActionProcessor().readBody(incomingActionRequestMessage, remoteActionInvocation);
            this.logger.h("Executing on local service: {}", remoteActionInvocation);
            serviceControlResource.getModel().getExecutor(remoteActionInvocation.getAction()).execute(remoteActionInvocation);
            if (remoteActionInvocation.getFailure() == null) {
                outgoingActionResponseMessage = new OutgoingActionResponseMessage(remoteActionInvocation.getAction());
            } else {
                if (remoteActionInvocation.getFailure() instanceof ActionCancelledException) {
                    this.logger.y("Action execution was cancelled, returning 404 to client");
                    return null;
                }
                outgoingActionResponseMessage = new OutgoingActionResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR, remoteActionInvocation.getAction());
            }
        } catch (UnsupportedDataException e) {
            this.logger.u("Error reading action request XML body", e);
            remoteActionInvocation = new RemoteActionInvocation(Exceptions.unwrap(e) instanceof ActionException ? (ActionException) Exceptions.unwrap(e) : new ActionException(ErrorCode.ACTION_FAILED, e.getMessage()), getRemoteClientInfo());
            outgoingActionResponseMessage = new OutgoingActionResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR);
        } catch (ActionException e2) {
            this.logger.v("Error executing local action", e2);
            remoteActionInvocation = new RemoteActionInvocation(e2, getRemoteClientInfo());
            outgoingActionResponseMessage = new OutgoingActionResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR);
        }
        try {
            this.logger.y("Writing body of response message");
            getUpnpService().getConfiguration().getSoapActionProcessor().writeBody(outgoingActionResponseMessage, remoteActionInvocation);
            this.logger.h("Returning finished response message: {}", outgoingActionResponseMessage);
            return outgoingActionResponseMessage;
        } catch (UnsupportedDataException e3) {
            this.logger.u("Failure writing body of response message, sending '500 Internal Server Error' without body", e3);
            return new StreamResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
