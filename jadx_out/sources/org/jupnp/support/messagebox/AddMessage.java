package org.jupnp.support.messagebox;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.support.messagebox.model.Message;
import org.jupnp.util.MimeType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AddMessage extends ActionCallback {
    protected final MimeType mimeType;

    public AddMessage(Service<?, ?> service, Message message) {
        super(new ActionInvocation(service.getAction("AddMessage")));
        MimeType mimeTypeValueOf = MimeType.valueOf("text/xml;charset=\"utf-8\"");
        this.mimeType = mimeTypeValueOf;
        getActionInvocation().setInput("MessageID", Integer.toString(message.getId()));
        getActionInvocation().setInput("MessageType", mimeTypeValueOf.toString());
        getActionInvocation().setInput("Message", message.toString());
    }
}
