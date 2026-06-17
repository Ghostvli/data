package org.jupnp.model.message.control;

import org.jupnp.model.action.ActionException;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.header.SoapActionHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.QueryStateVariableAction;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.SoapActionType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingActionRequestMessage extends StreamRequestMessage implements ActionRequestMessage {
    private final Action action;
    private final String actionNamespace;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingActionRequestMessage(StreamRequestMessage streamRequestMessage, LocalService localService) throws ActionException {
        super(streamRequestMessage);
        SoapActionHeader soapActionHeader = (SoapActionHeader) getHeaders().getFirstHeader(UpnpHeader.Type.SOAPACTION, SoapActionHeader.class);
        if (soapActionHeader == null) {
            throw new ActionException(ErrorCode.INVALID_ACTION, "Missing SOAP action header");
        }
        SoapActionType value = soapActionHeader.getValue();
        Action<LocalService> action = localService.getAction(value.getActionName());
        this.action = action;
        if (action != null) {
            if (!QueryStateVariableAction.ACTION_NAME.equals(value.getActionName()) && !localService.getServiceType().implementsVersion(value.getServiceType())) {
                throw new ActionException(ErrorCode.INVALID_ACTION, "Service doesn't support the requested service version");
            }
            this.actionNamespace = value.getTypeString();
            return;
        }
        throw new ActionException(ErrorCode.INVALID_ACTION, "Service doesn't implement action: " + value.getActionName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Action getAction() {
        return this.action;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.control.ActionMessage
    public String getActionNamespace() {
        return this.actionNamespace;
    }
}
