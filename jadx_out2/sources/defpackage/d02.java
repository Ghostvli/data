package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class d02 implements a02 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.a02
    public void a(int i, String str, String str2) {
        vy4.a(str2);
        if (str == null) {
            str = "NO_TAG";
        }
        Log.println(i, str, str2);
    }
}
