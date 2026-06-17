package org.jupnp.support.igd.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.model.Connection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GetStatusInfo extends ActionCallback {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GetStatusInfo(Service<?, ?> service) {
        super(new ActionInvocation(service.getAction("GetStatusInfo")));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        try {
            success(new Connection.StatusInfo(Connection.Status.valueOf(actionInvocation.getOutput("NewConnectionStatus").getValue().toString()), (UnsignedIntegerFourBytes) actionInvocation.getOutput("NewUptime").getValue(), Connection.Error.valueOf(actionInvocation.getOutput("NewLastConnectionError").getValue().toString())));
        } catch (Exception e) {
            actionInvocation.setFailure(new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Invalid status or last error string", e));
            failure(actionInvocation, null);
        }
    }

    public abstract void success(Connection.StatusInfo statusInfo);
}
