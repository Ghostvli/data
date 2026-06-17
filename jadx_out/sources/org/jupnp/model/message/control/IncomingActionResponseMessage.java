package org.jupnp.model.message.control;

import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingActionResponseMessage extends StreamResponseMessage implements ActionResponseMessage {
    public IncomingActionResponseMessage(StreamResponseMessage streamResponseMessage) {
        super(streamResponseMessage);
    }

    @Override // org.jupnp.model.message.control.ActionMessage
    public String getActionNamespace() {
        return null;
    }

    public boolean isFailedNonRecoverable() {
        int statusCode = getOperation().getStatusCode();
        if (!getOperation().isFailed() || statusCode == UpnpResponse.Status.METHOD_NOT_SUPPORTED.getStatusCode()) {
            return false;
        }
        return (statusCode == UpnpResponse.Status.INTERNAL_SERVER_ERROR.getStatusCode() && hasBody()) ? false : true;
    }

    public boolean isFailedRecoverable() {
        return hasBody() && getOperation().getStatusCode() == UpnpResponse.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }

    public IncomingActionResponseMessage(UpnpResponse upnpResponse) {
        super(upnpResponse);
    }
}
