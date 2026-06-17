package defpackage;

import androidx.lifecycle.x;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h45 {
    public final k45 a;
    public final x.c b;
    public final d50 c;
    public final dk4 d;

    public h45(k45 k45Var, x.c cVar, d50 d50Var) {
        k45Var.getClass();
        cVar.getClass();
        d50Var.getClass();
        this.a = k45Var;
        this.b = cVar;
        this.c = d50Var;
        this.d = new dk4();
    }

    public static /* synthetic */ c45 e(h45 h45Var, hp1 hp1Var, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = j45.a.c(hp1Var);
        }
        return h45Var.d(hp1Var, str);
    }

    public final c45 d(hp1 hp1Var, String str) {
        c45 c45VarB;
        hp1Var.getClass();
        str.getClass();
        synchronized (this.d) {
            try {
                c45VarB = this.a.b(str);
                if (hp1Var.d(c45VarB)) {
                    if (this.b instanceof x.e) {
                        x.e eVar = (x.e) this.b;
                        c45VarB.getClass();
                        eVar.d(c45VarB);
                    }
                    c45VarB.getClass();
                } else {
                    mw2 mw2Var = new mw2(this.c);
                    mw2Var.c(x.c, str);
                    c45VarB = i45.a(this.b, hp1Var, mw2Var);
                    this.a.d(str, c45VarB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c45VarB;
    }
}
