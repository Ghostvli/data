package org.jupnp.model.action;

import org.jupnp.model.meta.Action;
import org.jupnp.model.profile.RemoteClientInfo;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteActionInvocation extends ActionInvocation {
    protected final RemoteClientInfo remoteClientInfo;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteActionInvocation(Action action, ActionArgumentValue[] actionArgumentValueArr, ActionArgumentValue[] actionArgumentValueArr2, RemoteClientInfo remoteClientInfo) {
        super(action, actionArgumentValueArr, actionArgumentValueArr2, null);
        this.remoteClientInfo = remoteClientInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteClientInfo getRemoteClientInfo() {
        return this.remoteClientInfo;
    }

    public RemoteActionInvocation(Action action, RemoteClientInfo remoteClientInfo) {
        super(action);
        this.remoteClientInfo = remoteClientInfo;
    }

    public RemoteActionInvocation(ActionException actionException, RemoteClientInfo remoteClientInfo) {
        super(actionException);
        this.remoteClientInfo = remoteClientInfo;
    }
}
