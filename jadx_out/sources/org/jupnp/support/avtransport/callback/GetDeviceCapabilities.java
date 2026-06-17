package org.jupnp.support.avtransport.callback;

import java.util.Map;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionArgumentValue;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.model.DeviceCapabilities;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GetDeviceCapabilities extends ActionCallback {
    public GetDeviceCapabilities(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service) {
        super(new ActionInvocation(service.getAction("GetDeviceCapabilities")));
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
    }

    public abstract void received(ActionInvocation<?> actionInvocation, DeviceCapabilities deviceCapabilities);

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        received(actionInvocation, new DeviceCapabilities((Map<String, ActionArgumentValue<?>>) actionInvocation.getOutputMap()));
    }

    public GetDeviceCapabilities(Service<?, ?> service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }
}
