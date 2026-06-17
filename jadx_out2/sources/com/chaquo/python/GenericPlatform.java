package com.chaquo.python;

import com.chaquo.python.Python;
import defpackage.zt2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class GenericPlatform extends Python.Platform {
    private String mPath = System.getenv("PYTHONPATH");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GenericPlatform() {
        if (System.getProperty("java.vendor").toLowerCase().contains("android")) {
            zt2.a("Cannot use GenericPlatform on Android. Call Python.start(new AndroidPlatform(context)) before using Python, or use PyApplication to do this automatically.");
            throw null;
        }
        System.loadLibrary("chaquopy_java");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.chaquo.python.Python.Platform
    public String getPath() {
        return this.mPath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GenericPlatform setPath(String str) {
        this.mPath = str;
        return this;
    }
}
