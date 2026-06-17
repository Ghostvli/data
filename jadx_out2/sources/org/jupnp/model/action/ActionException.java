package org.jupnp.model.action;

import org.jupnp.model.types.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ActionException extends Exception {
    private int errorCode;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Illegal instructions before constructor call */
    public ActionException(ErrorCode errorCode, String str, boolean z) {
        int code = errorCode.getCode();
        if (z) {
            str = errorCode.getDescription() + ". " + str + ".";
        }
        this(code, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getErrorCode() {
        return this.errorCode;
    }

    public ActionException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }

    public ActionException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getDescription());
    }

    public ActionException(ErrorCode errorCode, String str) {
        this(errorCode, str, true);
    }

    public ActionException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public ActionException(ErrorCode errorCode, String str, Throwable th) {
        this(errorCode.getCode(), errorCode.getDescription() + ". " + str + ".", th);
    }
}
