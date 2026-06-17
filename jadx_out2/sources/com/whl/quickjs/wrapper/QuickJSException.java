package com.whl.quickjs.wrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QuickJSException extends RuntimeException {
    private final boolean jsError;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QuickJSException(String str, boolean z) {
        super(str);
        this.jsError = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isJSError() {
        return this.jsError;
    }

    public QuickJSException(String str) {
        this(str, false);
    }
}
