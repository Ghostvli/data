package com.chaquo.python;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class PyException extends RuntimeException {
    public PyException() {
    }

    public PyException(String str) {
        super(str);
    }

    public PyException(String str, Throwable th) {
        super(str, th);
    }

    public PyException(Throwable th) {
        super(th);
    }
}
