package defpackage;

import defpackage.mq3;
import defpackage.t41;
import defpackage.wt4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k04 {
    public final List a;
    public final String b;
    public final gr4[] c;
    public final mq3 d = new mq3(new mq3.b() { // from class: j04
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // mq3.b
        public final void a(long j, r73 r73Var) {
            fr.a(j, r73Var, this.a.c);
        }
    });

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k04(List list, String str) {
        this.a = list;
        this.b = str;
        this.c = new gr4[list.size()];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.d.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(long j, r73 r73Var) {
        this.d.a(j, r73Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(mz0 mz0Var, wt4.d dVar) {
        for (int i = 0; i < this.c.length; i++) {
            dVar.a();
            gr4 gr4VarE = mz0Var.e(dVar.c(), 3);
            t41 t41Var = (t41) this.a.get(i);
            String str = t41Var.p;
            gg3.k("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: %s", str);
            String strB = t41Var.a;
            if (strB == null) {
                strB = dVar.b();
            }
            gr4VarE.g(new t41.b().k0(strB).X(this.b).A0(str).C0(t41Var.e).o0(t41Var.d).R(t41Var.M).l0(t41Var.s).Q());
            this.c[i] = gr4VarE;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e() {
        this.d.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(int i) {
        this.d.g(i);
    }
}
