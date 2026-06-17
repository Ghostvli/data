package org.jupnp.support.avtransport.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.model.PlayMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SetPlayMode extends ActionCallback {
    private final j02 logger;

    public SetPlayMode(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, PlayMode playMode) {
        super(new ActionInvocation(service.getAction("SetPlayMode")));
        this.logger = n02.k(SetPlayMode.class);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
        getActionInvocation().setInput("NewPlayMode", playMode.toString());
    }

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Execution successful");
    }

    public SetPlayMode(Service<?, ?> service, PlayMode playMode) {
        this(new UnsignedIntegerFourBytes(0L), service, playMode);
    }
}
