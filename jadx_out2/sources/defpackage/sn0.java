package defpackage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class sn0 implements ns3 {
    public final kk a;
    public final ns3 b;
    public final ns3 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sn0(kk kkVar, ns3 ns3Var, ns3 ns3Var2) {
        this.a = kkVar;
        this.b = ns3Var;
        this.c = ns3Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yr3 b(yr3 yr3Var) {
        return yr3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ns3
    public yr3 a(yr3 yr3Var, u63 u63Var) {
        Drawable drawable = (Drawable) yr3Var.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(mk.f(((BitmapDrawable) drawable).getBitmap(), this.a), u63Var);
        }
        if (drawable instanceof r91) {
            return this.c.a(b(yr3Var), u63Var);
        }
        return null;
    }
}
