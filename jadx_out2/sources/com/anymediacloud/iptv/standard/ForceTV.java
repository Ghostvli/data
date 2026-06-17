package com.anymediacloud.iptv.standard;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ForceTV {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(int i) {
        try {
            start(i, 20971520);
        } catch (Throwable unused) {
        }
    }

    public native int start(int i, int i2);

    public native int stop();
}
