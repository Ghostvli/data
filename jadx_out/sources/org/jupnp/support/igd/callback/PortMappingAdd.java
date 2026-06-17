package org.jupnp.support.igd.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.support.model.PortMapping;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PortMappingAdd extends ActionCallback {
    protected final PortMapping portMapping;

    public PortMappingAdd(Service<?, ?> service, ControlPoint controlPoint, PortMapping portMapping) {
        super(new ActionInvocation(service.getAction("AddPortMapping")), controlPoint);
        this.portMapping = portMapping;
        getActionInvocation().setInput("NewExternalPort", portMapping.getExternalPort());
        getActionInvocation().setInput("NewProtocol", portMapping.getProtocol());
        getActionInvocation().setInput("NewInternalClient", portMapping.getInternalClient());
        getActionInvocation().setInput("NewInternalPort", portMapping.getInternalPort());
        getActionInvocation().setInput("NewLeaseDuration", portMapping.getLeaseDurationSeconds());
        getActionInvocation().setInput("NewEnabled", Boolean.valueOf(portMapping.isEnabled()));
        if (portMapping.hasRemoteHost()) {
            getActionInvocation().setInput("NewRemoteHost", portMapping.getRemoteHost());
        }
        if (portMapping.hasDescription()) {
            getActionInvocation().setInput("NewPortMappingDescription", portMapping.getDescription());
        }
    }

    public PortMappingAdd(Service<?, ?> service, PortMapping portMapping) {
        this(service, null, portMapping);
    }
}
