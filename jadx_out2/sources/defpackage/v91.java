package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class v91 implements ns4 {
    public final ns4 b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v91(ns4 ns4Var) {
        this.b = (ns4) fg3.e(ns4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ns4
    public yr3 a(Context context, yr3 yr3Var, int i, int i2) {
        r91 r91Var = (r91) yr3Var.get();
        mk mkVar = new mk(r91Var.e(), a.c(context).f());
        yr3 yr3VarA = this.b.a(context, mkVar, i, i2);
        if (mkVar != yr3VarA) {
            mkVar.b();
        }
        r91Var.m(this.b, (Bitmap) yr3VarA.get());
        return yr3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof v91) {
            return this.b.equals(((v91) obj).b);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wq1
    public int hashCode() {
        return this.b.hashCode();
    }
}
