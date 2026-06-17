package org.jupnp.support.avtransport.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Pause extends ActionCallback {
    private final j02 logger;

    public Pause(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service) {
        super(new ActionInvocation(service.getAction("Pause")));
        this.logger = n02.k(Pause.class);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
    }

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Execution successful");
    }

    public Pause(ActionInvocation<?> actionInvocation) {
        super(actionInvocation);
        this.logger = n02.k(Pause.class);
    }

    public Pause(Service<?, ?> service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }

    public Pause(ActionInvocation<?> actionInvocation, ControlPoint controlPoint) {
        super(actionInvocation, controlPoint);
        this.logger = n02.k(Pause.class);
    }
}
