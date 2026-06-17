package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.a;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yn0 implements ns4 {
    public final ns4 b;
    public final boolean c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yn0(ns4 ns4Var, boolean z) {
        this.b = ns4Var;
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ns4
    public yr3 a(Context context, yr3 yr3Var, int i, int i2) {
        kk kkVarF = a.c(context).f();
        Drawable drawable = (Drawable) yr3Var.get();
        yr3 yr3VarA = xn0.a(kkVarF, drawable, i, i2);
        if (yr3VarA == null) {
            if (!this.c) {
                return yr3Var;
            }
            f02.a("Unable to convert ", drawable, " to a Bitmap");
            return null;
        }
        yr3 yr3VarA2 = this.b.a(context, yr3VarA, i, i2);
        if (!yr3VarA2.equals(yr3VarA)) {
            return d(context, yr3VarA2);
        }
        yr3VarA2.b();
        return yr3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ns4 c() {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final yr3 d(Context context, yr3 yr3Var) {
        return ds1.f(context.getResources(), yr3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof yn0) {
            return this.b.equals(((yn0) obj).b);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wq1
    public int hashCode() {
        return this.b.hashCode();
    }
}
