package org.jupnp.support.igd.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerTwoBytes;
import org.jupnp.support.model.PortMapping;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PortMappingEntryGet extends ActionCallback {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PortMappingEntryGet(Service<?, ?> service, ControlPoint controlPoint, long j) {
        super(new ActionInvocation(service.getAction("GetGenericPortMappingEntry")), controlPoint);
        getActionInvocation().setInput("NewPortMappingIndex", new UnsignedIntegerTwoBytes(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        success(new PortMapping(actionInvocation.getOutputMap()));
    }

    public abstract void success(PortMapping portMapping);

    public PortMappingEntryGet(Service<?, ?> service, long j) {
        this(service, null, j);
    }
}
