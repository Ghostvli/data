package org.jupnp.support.messagebox;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.support.messagebox.model.Message;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RemoveMessage extends ActionCallback {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoveMessage(Service<?, ?> service, int i) {
        super(new ActionInvocation(service.getAction("RemoveMessage")));
        getActionInvocation().setInput("MessageID", Integer.valueOf(i));
    }

    public RemoveMessage(Service<?, ?> service, Message message) {
        this(service, message.getId());
    }
}
