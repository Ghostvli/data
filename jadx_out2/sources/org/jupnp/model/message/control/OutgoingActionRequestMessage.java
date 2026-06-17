package org.jupnp.model.message.control;

import defpackage.j02;
import defpackage.jl;
import defpackage.n02;
import java.net.URL;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.action.RemoteActionInvocation;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.ContentTypeHeader;
import org.jupnp.model.message.header.SoapActionHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.message.header.UserAgentHeader;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.QueryStateVariableAction;
import org.jupnp.model.types.SoapActionType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingActionRequestMessage extends StreamRequestMessage implements ActionRequestMessage {
    private final String actionNamespace;
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingActionRequestMessage(Action action, UpnpRequest upnpRequest) {
        SoapActionHeader soapActionHeader;
        super(upnpRequest);
        j02 j02VarK = n02.k(OutgoingActionRequestMessage.class);
        this.logger = j02VarK;
        getHeaders().add(UpnpHeader.Type.CONTENT_TYPE, new ContentTypeHeader(ContentTypeHeader.DEFAULT_CONTENT_TYPE_UTF8));
        if (action instanceof QueryStateVariableAction) {
            j02VarK.y("Adding magic control SOAP action header for state variable query action");
            soapActionHeader = new SoapActionHeader(new SoapActionType("schemas-upnp-org", SoapActionType.MAGIC_CONTROL_TYPE, null, action.getName()));
        } else {
            soapActionHeader = new SoapActionHeader(new SoapActionType(action.getService().getServiceType(), action.getName()));
        }
        this.actionNamespace = soapActionHeader.getValue().getTypeString();
        if (!getOperation().getMethod().equals(UpnpRequest.Method.POST)) {
            jl.a("Can't send action with request method: ".concat(String.valueOf(getOperation().getMethod())));
            throw null;
        }
        getHeaders().add(UpnpHeader.Type.SOAPACTION, soapActionHeader);
        j02VarK.h("Added SOAP action header: {}", soapActionHeader);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.control.ActionMessage
    public String getActionNamespace() {
        return this.actionNamespace;
    }

    public OutgoingActionRequestMessage(ActionInvocation actionInvocation, URL url) {
        this(actionInvocation.getAction(), new UpnpRequest(UpnpRequest.Method.POST, url));
        if (actionInvocation instanceof RemoteActionInvocation) {
            RemoteActionInvocation remoteActionInvocation = (RemoteActionInvocation) actionInvocation;
            if (remoteActionInvocation.getRemoteClientInfo() == null || remoteActionInvocation.getRemoteClientInfo().getRequestUserAgent() == null) {
                return;
            }
            getHeaders().add(UpnpHeader.Type.USER_AGENT, new UserAgentHeader(remoteActionInvocation.getRemoteClientInfo().getRequestUserAgent()));
            return;
        }
        if (actionInvocation.getClientInfo() != null) {
            getHeaders().putAll(actionInvocation.getClientInfo().getRequestHeaders());
        }
    }
}
