package org.jupnp.support.avtransport.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SetAVTransportURI extends ActionCallback {
    private final j02 logger;

    public SetAVTransportURI(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, String str, String str2) {
        super(new ActionInvocation(service.getAction("SetAVTransportURI")));
        j02 j02VarK = n02.k(SetAVTransportURI.class);
        this.logger = j02VarK;
        j02VarK.q("Creating SetAVTransportURI action for URI: {}", str);
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
        getActionInvocation().setInput("CurrentURI", str);
        getActionInvocation().setInput("CurrentURIMetaData", str2);
    }

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Execution successful");
    }

    public SetAVTransportURI(Service<?, ?> service, String str, String str2) {
        this(new UnsignedIntegerFourBytes(0L), service, str, str2);
    }

    public SetAVTransportURI(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service<?, ?> service, String str) {
        this(unsignedIntegerFourBytes, service, str, null);
    }

    public SetAVTransportURI(Service<?, ?> service, String str) {
        this(new UnsignedIntegerFourBytes(0L), service, str, null);
    }
}
