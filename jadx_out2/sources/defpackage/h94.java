package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h94 implements p81 {
    public final /* synthetic */ i94 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [i94.a(android.net.Uri):lu1, i94.b(ph2):lu1, i94.c(byte[]):lu1] */
    public /* synthetic */ h94(i94 i94Var) {
        this.f = i94Var;
    }

    /* JADX DEBUG: Class process forced to load method for inline: i94.d(i94, android.graphics.Bitmap):android.graphics.Bitmap */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p81
    public final Object apply(Object obj) {
        return this.f.e((Bitmap) obj);
    }
}
