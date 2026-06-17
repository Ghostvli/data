package org.jupnp.model.action;

import org.jupnp.model.types.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ActionCancelledException extends ActionException {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionCancelledException(InterruptedException interruptedException) {
        super(ErrorCode.ACTION_FAILED, "Action execution interrupted", interruptedException);
    }
}
