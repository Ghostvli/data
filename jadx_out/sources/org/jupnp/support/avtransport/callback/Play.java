package org.jupnp.support.avtransport.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Play extends ActionCallback {
    private final j02 logger;

    public Play(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, String str) {
        super(new ActionInvocation(service.getAction("Play")));
        this.logger = n02.k(Play.class);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
        getActionInvocation().setInput("Speed", str);
    }

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Execution successful");
    }

    public Play(Service<?, ?> service, String str) {
        this(new UnsignedIntegerFourBytes(0L), service, str);
    }

    public Play(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service) {
        this(unsignedIntegerFourBytes, service, "1");
    }

    public Play(Service<?, ?> service) {
        this(new UnsignedIntegerFourBytes(0L), service, "1");
    }
}
