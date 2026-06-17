package defpackage;

import android.net.Uri;
import defpackage.aa0;
import defpackage.cg0;
import defpackage.fg2;
import defpackage.gf0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kf0 implements zo0 {
    public final Object a = new Object();
    public fg2.f b;
    public xo0 c;
    public aa0.a d;
    public String e;
    public sy1 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zo0
    public xo0 a(fg2 fg2Var) {
        xo0 xo0Var;
        gg3.q(fg2Var.b);
        fg2.f fVar = fg2Var.b.c;
        if (fVar == null) {
            return xo0.a;
        }
        synchronized (this.a) {
            try {
                if (!fVar.equals(this.b)) {
                    this.b = fVar;
                    this.c = b(fVar);
                }
                xo0Var = (xo0) gg3.q(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xo0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final xo0 b(fg2.f fVar) {
        aa0.a aVarE = this.d;
        if (aVarE == null) {
            aVarE = new cg0.b().e(this.e);
        }
        Uri uri = fVar.c;
        vg1 vg1Var = new vg1(uri == null ? null : uri.toString(), fVar.h, aVarE);
        pw4 it = fVar.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            vg1Var.c((String) entry.getKey(), (String) entry.getValue());
        }
        gf0.b bVarE = new gf0.b().f(fVar.a, z71.d).c(fVar.f).d(fVar.g).e(ll1.n(fVar.j));
        sy1 sy1Var = this.f;
        if (sy1Var != null) {
            bVarE.b(sy1Var);
        }
        gf0 gf0VarA = bVarE.a(vg1Var);
        gf0VarA.E(0, fVar.d());
        return gf0VarA;
    }
}
