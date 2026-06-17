package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import java.net.URL;
import org.jupnp.UpnpService;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.action.ActionCancelledException;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.control.IncomingActionResponseMessage;
import org.jupnp.model.message.control.OutgoingActionRequestMessage;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.protocol.SendingSync;
import org.jupnp.transport.RouterException;
import org.jupnp.util.Exceptions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingAction extends SendingSync<OutgoingActionRequestMessage, IncomingActionResponseMessage> {
    protected final ActionInvocation actionInvocation;
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SendingAction(UpnpService upnpService, ActionInvocation actionInvocation, URL url) {
        super(upnpService, new OutgoingActionRequestMessage(actionInvocation, url));
        this.logger = n02.k(SendingAction.class);
        this.actionInvocation = actionInvocation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: executeSync()Lorg/jupnp/model/message/StreamResponseMessage; */
    @Override // org.jupnp.protocol.SendingSync
    public IncomingActionResponseMessage executeSync() {
        return invokeRemote(getInputMessage());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void handleResponse(IncomingActionResponseMessage incomingActionResponseMessage) throws ActionException {
        try {
            this.logger.h("Received response for outgoing call, reading SOAP response body: {}", incomingActionResponseMessage);
            getUpnpService().getConfiguration().getSoapActionProcessor().readBody(incomingActionResponseMessage, this.actionInvocation);
        } catch (UnsupportedDataException e) {
            this.logger.v("Error reading SOAP body", e);
            throw new ActionException(ErrorCode.ACTION_FAILED, "Error reading SOAP response message. " + e.getMessage(), false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void handleResponseFailure(IncomingActionResponseMessage incomingActionResponseMessage) throws ActionException {
        try {
            this.logger.y("Received response with Internal Server Error, reading SOAP failure message");
            getUpnpService().getConfiguration().getSoapActionProcessor().readBody(incomingActionResponseMessage, this.actionInvocation);
        } catch (UnsupportedDataException e) {
            this.logger.v("Error reading SOAP body", e);
            throw new ActionException(ErrorCode.ACTION_FAILED, "Error reading SOAP response failure message. " + e.getMessage(), false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingActionResponseMessage invokeRemote(OutgoingActionRequestMessage outgoingActionRequestMessage) throws RouterException {
        this.logger.i("Sending outgoing action call '{}' to remote service of: {}", this.actionInvocation.getAction().getName(), this.actionInvocation.getAction().getService().getDevice());
        IncomingActionResponseMessage incomingActionResponseMessage = null;
        try {
            StreamResponseMessage streamResponseMessageSendRemoteRequest = sendRemoteRequest(outgoingActionRequestMessage);
            if (streamResponseMessageSendRemoteRequest == null) {
                this.logger.y("No connection or no no response received, returning null");
                this.actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, "Connection error or no response received"));
                return null;
            }
            IncomingActionResponseMessage incomingActionResponseMessage2 = new IncomingActionResponseMessage(streamResponseMessageSendRemoteRequest);
            try {
                if (!incomingActionResponseMessage2.isFailedNonRecoverable()) {
                    if (incomingActionResponseMessage2.isFailedRecoverable()) {
                        handleResponseFailure(incomingActionResponseMessage2);
                        return incomingActionResponseMessage2;
                    }
                    handleResponse(incomingActionResponseMessage2);
                    return incomingActionResponseMessage2;
                }
                this.logger.h("Response was a non-recoverable failure: {}", incomingActionResponseMessage2);
                throw new ActionException(ErrorCode.ACTION_FAILED, "Non-recoverable remote execution failure: " + incomingActionResponseMessage2.getOperation().getResponseDetails());
            } catch (ActionException e) {
                e = e;
                incomingActionResponseMessage = incomingActionResponseMessage2;
                this.logger.v("Remote action invocation failed, returning Internal Server Error message", e);
                this.actionInvocation.setFailure(e);
                return (incomingActionResponseMessage == null || !incomingActionResponseMessage.getOperation().isFailed()) ? new IncomingActionResponseMessage(new UpnpResponse(UpnpResponse.Status.INTERNAL_SERVER_ERROR)) : incomingActionResponseMessage;
            }
        } catch (ActionException e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StreamResponseMessage sendRemoteRequest(OutgoingActionRequestMessage outgoingActionRequestMessage) throws RouterException, ActionException {
        try {
            this.logger.h("Writing SOAP request body of: {}", outgoingActionRequestMessage);
            getUpnpService().getConfiguration().getSoapActionProcessor().writeBody(outgoingActionRequestMessage, this.actionInvocation);
            this.logger.y("Sending SOAP body of message as stream to remote device");
            return getUpnpService().getRouter().send(outgoingActionRequestMessage);
        } catch (UnsupportedDataException e) {
            this.logger.v("Error writing SOAP body", e);
            throw new ActionException(ErrorCode.ACTION_FAILED, "Error writing request message. " + e.getMessage());
        } catch (RouterException e2) {
            Throwable thUnwrap = Exceptions.unwrap(e2);
            if (!(thUnwrap instanceof InterruptedException)) {
                throw e2;
            }
            this.logger.v("Sending action request message was interrupted", e2);
            throw new ActionCancelledException((InterruptedException) thUnwrap);
        }
    }
}
