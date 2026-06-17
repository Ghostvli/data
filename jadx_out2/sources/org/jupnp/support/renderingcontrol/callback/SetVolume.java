package org.jupnp.support.renderingcontrol.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.model.types.UnsignedIntegerTwoBytes;
import org.jupnp.support.model.Channel;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SetVolume extends ActionCallback {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SetVolume(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, long j) {
        super(new ActionInvocation(service.getAction("SetVolume")));
        this.logger = n02.k(SetVolume.class);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
        getActionInvocation().setInput("Channel", Channel.Master.toString());
        getActionInvocation().setInput("DesiredVolume", new UnsignedIntegerTwoBytes(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Executed successfully");
    }

    public SetVolume(Service<?, ?> service, long j) {
        this(new UnsignedIntegerFourBytes(0L), service, j);
    }
}
