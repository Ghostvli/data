package org.jupnp.support.avtransport;

import org.jupnp.model.action.ActionException;
import org.jupnp.model.types.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AVTransportException extends ActionException {
    private static final long serialVersionUID = 5842516381341682273L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AVTransportException(AVTransportErrorCode aVTransportErrorCode, String str) {
        super(aVTransportErrorCode.getCode(), aVTransportErrorCode.getDescription() + ". " + str + ".");
    }

    public AVTransportException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public AVTransportException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public AVTransportException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AVTransportException(int i, String str) {
        super(i, str);
    }

    public AVTransportException(AVTransportErrorCode aVTransportErrorCode) {
        super(aVTransportErrorCode.getCode(), aVTransportErrorCode.getDescription());
    }
}
