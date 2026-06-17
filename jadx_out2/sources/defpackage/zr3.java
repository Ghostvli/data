package defpackage;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zr3 implements ds3 {
    public final fs3 a;
    public final kk b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zr3(fs3 fs3Var, kk kkVar) {
        this.a = fs3Var;
        this.b = kkVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;IILu63;)Lyr3; */
    @Override // defpackage.ds3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yr3 b(Uri uri, int i, int i2, u63 u63Var) {
        yr3 yr3VarB = this.a.b(uri, i, i2, u63Var);
        if (yr3VarB == null) {
            return null;
        }
        return xn0.a(this.b, (Drawable) yr3VarB.get(), i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;Lu63;)Z */
    @Override // defpackage.ds3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, u63 u63Var) {
        return "android.resource".equals(uri.getScheme());
    }
}
