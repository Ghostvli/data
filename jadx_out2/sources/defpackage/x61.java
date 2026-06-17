package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x61 {
    public final k61 a;
    public final ViewGroup b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x61(ViewGroup viewGroup, k61 k61Var) {
        this.b = viewGroup;
        this.a = k61Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(int i) {
        uh uhVarC = c(i);
        if (uhVarC != null) {
            return uhVarC.t2() || uhVarC.I0();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b(int i) {
        String strE = e(i);
        p51 p51VarJ0 = this.a.j0(strE);
        if (p51VarJ0 == null) {
            p51VarJ0 = d(i);
        }
        d71 d71VarV = this.a.o().v(4097);
        if (this.a.j0(strE) == null) {
            d71VarV.c(this.b.getId(), p51VarJ0, strE);
        }
        p51 p51VarB0 = this.a.B0();
        if (p51VarB0 != null && p51VarB0 != p51VarJ0) {
            d71VarV.n(p51VarB0);
        }
        d71VarV.w(p51VarJ0).t(p51VarJ0).u(true).k();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uh c(int i) {
        return (uh) this.a.j0(e(i));
    }

    public abstract p51 d(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String e(int i) {
        return "android:switcher:" + i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f(int i) {
        uh uhVarC = c(i);
        return uhVarC != null && uhVarC.N0();
    }
}
