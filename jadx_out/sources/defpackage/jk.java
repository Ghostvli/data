package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface jk {
    lu1 a(Uri uri);

    default lu1 b(ph2 ph2Var) {
        byte[] bArr = ph2Var.k;
        if (bArr != null) {
            return c(bArr);
        }
        Uri uri = ph2Var.n;
        if (uri != null) {
            return a(uri);
        }
        return null;
    }

    lu1 c(byte[] bArr);
}
