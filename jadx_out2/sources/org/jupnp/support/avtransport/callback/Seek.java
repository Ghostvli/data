package org.jupnp.support.avtransport.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.model.SeekMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Seek extends ActionCallback {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Seek(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, SeekMode seekMode, String str) {
        super(new ActionInvocation(service.getAction("Seek")));
        this.logger = n02.k(Seek.class);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
        getActionInvocation().setInput("Unit", seekMode.name());
        getActionInvocation().setInput("Target", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Execution successful");
    }

    public Seek(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, String str) {
        this(unsignedIntegerFourBytes, service, SeekMode.REL_TIME, str);
    }

    public Seek(Service<?, ?> service, SeekMode seekMode, String str) {
        this(new UnsignedIntegerFourBytes(0L), service, seekMode, str);
    }

    public Seek(Service<?, ?> service, String str) {
        this(new UnsignedIntegerFourBytes(0L), service, SeekMode.REL_TIME, str);
    }
}
