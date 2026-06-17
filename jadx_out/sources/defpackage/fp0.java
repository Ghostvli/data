package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fp0 {
    public static final no1.a f = no1.a.a("ef");
    public static final no1.a g = no1.a.a("nm", "v");
    public i6 a;
    public j6 b;
    public j6 c;
    public j6 d;
    public j6 e;

    public final void a(no1 no1Var, f12 f12Var) {
        no1Var.h();
        String strF = "";
        while (no1Var.t()) {
            int iM = no1Var.M(g);
            if (iM != 0) {
                if (iM == 1) {
                    strF.getClass();
                    switch (strF) {
                        case "Distance":
                            this.d = a7.e(no1Var, f12Var);
                            break;
                        case "Opacity":
                            this.b = a7.f(no1Var, f12Var, false);
                            break;
                        case "Direction":
                            this.c = a7.f(no1Var, f12Var, false);
                            break;
                        case "Shadow Color":
                            this.a = a7.c(no1Var, f12Var);
                            break;
                        case "Softness":
                            this.e = a7.e(no1Var, f12Var);
                            break;
                        default:
                            no1Var.O();
                            break;
                    }
                } else {
                    no1Var.N();
                    no1Var.O();
                }
            } else {
                strF = no1Var.F();
            }
        }
        no1Var.l();
    }

    public ep0 b(no1 no1Var, f12 f12Var) {
        j6 j6Var;
        j6 j6Var2;
        j6 j6Var3;
        j6 j6Var4;
        while (no1Var.t()) {
            if (no1Var.M(f) != 0) {
                no1Var.N();
                no1Var.O();
            } else {
                no1Var.c();
                while (no1Var.t()) {
                    a(no1Var, f12Var);
                }
                no1Var.i();
            }
        }
        i6 i6Var = this.a;
        if (i6Var == null || (j6Var = this.b) == null || (j6Var2 = this.c) == null || (j6Var3 = this.d) == null || (j6Var4 = this.e) == null) {
            return null;
        }
        return new ep0(i6Var, j6Var, j6Var2, j6Var3, j6Var4);
    }
}
