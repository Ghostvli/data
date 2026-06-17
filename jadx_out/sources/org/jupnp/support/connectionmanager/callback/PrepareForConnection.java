package org.jupnp.support.connectionmanager.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.ServiceReference;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.support.model.ConnectionInfo;
import org.jupnp.support.model.ProtocolInfo;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PrepareForConnection extends ActionCallback {
    public PrepareForConnection(Service<?, ?> service, ControlPoint controlPoint, ProtocolInfo protocolInfo, ServiceReference serviceReference, int i, ConnectionInfo.Direction direction) {
        super(new ActionInvocation(service.getAction("PrepareForConnection")), controlPoint);
        getActionInvocation().setInput("RemoteProtocolInfo", protocolInfo.toString());
        getActionInvocation().setInput("PeerConnectionManager", serviceReference.toString());
        getActionInvocation().setInput("PeerConnectionID", Integer.valueOf(i));
        getActionInvocation().setInput("Direction", direction.toString());
    }

    public abstract void received(ActionInvocation<?> actionInvocation, int i, int i2, int i3);

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        received(actionInvocation, ((Integer) actionInvocation.getOutput("ConnectionID").getValue()).intValue(), ((Integer) actionInvocation.getOutput("RcsID").getValue()).intValue(), ((Integer) actionInvocation.getOutput("AVTransportID").getValue()).intValue());
    }

    public PrepareForConnection(Service<?, ?> service, ProtocolInfo protocolInfo, ServiceReference serviceReference, int i, ConnectionInfo.Direction direction) {
        this(service, null, protocolInfo, serviceReference, i, direction);
    }
}
