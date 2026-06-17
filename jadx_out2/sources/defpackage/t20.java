package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface t20 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static long a(t20 t20Var) {
        return t20Var.c("exo_len", -1L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static Uri d(t20 t20Var) {
        String strB = t20Var.b("exo_redir", null);
        if (strB == null) {
            return null;
        }
        return Uri.parse(strB);
    }

    String b(String str, String str2);

    long c(String str, long j);
}
