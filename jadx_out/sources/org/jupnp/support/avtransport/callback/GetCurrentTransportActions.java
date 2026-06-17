package org.jupnp.support.avtransport.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.model.TransportAction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GetCurrentTransportActions extends ActionCallback {
    public GetCurrentTransportActions(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service) {
        super(new ActionInvocation(service.getAction("GetCurrentTransportActions")));
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
    }

    public abstract void received(ActionInvocation<?> actionInvocation, TransportAction[] transportActionArr);

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        received(actionInvocation, TransportAction.valueOfCommaSeparatedList((String) actionInvocation.getOutput("Actions").getValue()));
    }

    public GetCurrentTransportActions(Service<?, ?> service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }
}
