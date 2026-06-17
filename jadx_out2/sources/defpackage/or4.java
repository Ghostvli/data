package defpackage;

import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.p;
import defpackage.jq2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class or4 {
    public a a;
    public qg b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(o oVar);

        void b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qg b() {
        return (qg) gg3.q(this.b);
    }

    public abstract lr4 c();

    public abstract p.a d();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(a aVar, qg qgVar) {
        gg3.v(this.a == null);
        this.a = aVar;
        this.b = qgVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(o oVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    public abstract boolean h();

    public abstract void i(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j() {
        this.a = null;
        this.b = null;
    }

    public abstract pr4 k(p[] pVarArr, er4 er4Var, jq2.b bVar, no4 no4Var);

    public abstract void l(yb ybVar);

    public abstract void m(lr4 lr4Var);
}
