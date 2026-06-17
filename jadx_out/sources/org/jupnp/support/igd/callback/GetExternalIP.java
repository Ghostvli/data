package org.jupnp.support.igd.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GetExternalIP extends ActionCallback {
    public GetExternalIP(Service<?, ?> service) {
        super(new ActionInvocation(service.getAction("GetExternalIPAddress")));
    }

    public abstract void success(String str);

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        success((String) actionInvocation.getOutput("NewExternalIPAddress").getValue());
    }
}
