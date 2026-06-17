package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lh implements aa0 {
    public final boolean a;
    public final ArrayList b = new ArrayList(1);
    public int c;
    public ja0 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lh(boolean z) {
        this.a = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public final void f(hs4 hs4Var) {
        gg3.q(hs4Var);
        if (this.b.contains(hs4Var)) {
            return;
        }
        this.b.add(hs4Var);
        this.c++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(int i) {
        ja0 ja0Var = (ja0) fy4.l(this.d);
        for (int i2 = 0; i2 < this.c; i2++) {
            ((hs4) this.b.get(i2)).d(this, ja0Var, this.a, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        ja0 ja0Var = (ja0) fy4.l(this.d);
        for (int i = 0; i < this.c; i++) {
            ((hs4) this.b.get(i)).h(this, ja0Var, this.a);
        }
        this.d = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(ja0 ja0Var) {
        for (int i = 0; i < this.c; i++) {
            ((hs4) this.b.get(i)).b(this, ja0Var, this.a);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(ja0 ja0Var) {
        this.d = ja0Var;
        for (int i = 0; i < this.c; i++) {
            ((hs4) this.b.get(i)).i(this, ja0Var, this.a);
        }
    }
}
