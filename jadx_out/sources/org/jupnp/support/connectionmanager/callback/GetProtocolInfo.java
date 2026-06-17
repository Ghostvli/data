package org.jupnp.support.connectionmanager.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.action.ActionArgumentValue;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.support.model.ProtocolInfos;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GetProtocolInfo extends ActionCallback {
    public GetProtocolInfo(Service<?, ?> service, ControlPoint controlPoint) {
        super(new ActionInvocation(service.getAction("GetProtocolInfo")), controlPoint);
    }

    public abstract void received(ActionInvocation<?> actionInvocation, ProtocolInfos protocolInfos, ProtocolInfos protocolInfos2);

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        try {
            ActionArgumentValue output = actionInvocation.getOutput("Sink");
            ActionArgumentValue output2 = actionInvocation.getOutput("Source");
            received(actionInvocation, output != null ? new ProtocolInfos(output.toString()) : null, output2 != null ? new ProtocolInfos(output2.toString()) : null);
        } catch (Exception e) {
            actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, "Can't parse ProtocolInfo response: ".concat(String.valueOf(e)), e));
            failure(actionInvocation, null);
        }
    }

    public GetProtocolInfo(Service<?, ?> service) {
        this(service, null);
    }
}
