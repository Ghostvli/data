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
public abstract class Previous extends ActionCallback {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Previous(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service) {
        super(new ActionInvocation(service.getAction("Previous")));
        this.logger = n02.k(Previous.class);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Execution successful");
    }

    public Previous(ActionInvocation<?> actionInvocation) {
        super(actionInvocation);
        this.logger = n02.k(Previous.class);
    }

    public Previous(Service<?, ?> service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }

    public Previous(ActionInvocation<?> actionInvocation, ControlPoint controlPoint) {
        super(actionInvocation, controlPoint);
        this.logger = n02.k(Previous.class);
    }
}
