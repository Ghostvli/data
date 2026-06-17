package com.hierynomus.spnego;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SpnegoException extends Exception {
    public SpnegoException(String str) {
        super(str);
    }

    public SpnegoException(String str, IOException iOException) {
        super(str, iOException);
    }
}
