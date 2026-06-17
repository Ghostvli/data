package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yk {
    public static final no1.a a = no1.a.a("ef");
    public static final no1.a b = no1.a.a("ty", "v");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xk a(no1 no1Var, f12 f12Var) {
        no1Var.h();
        xk xkVar = null;
        while (true) {
            boolean z = false;
            while (no1Var.t()) {
                int iM = no1Var.M(b);
                if (iM != 0) {
                    if (iM != 1) {
                        no1Var.N();
                        no1Var.O();
                    } else if (z) {
                        xkVar = new xk(a7.e(no1Var, f12Var));
                    } else {
                        no1Var.O();
                    }
                } else if (no1Var.y() == 0) {
                    z = true;
                }
            }
            no1Var.l();
            return xkVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xk b(no1 no1Var, f12 f12Var) {
        xk xkVar = null;
        while (no1Var.t()) {
            if (no1Var.M(a) != 0) {
                no1Var.N();
                no1Var.O();
            } else {
                no1Var.c();
                while (no1Var.t()) {
                    xk xkVarA = a(no1Var, f12Var);
                    if (xkVarA != null) {
                        xkVar = xkVarA;
                    }
                }
                no1Var.i();
            }
        }
        return xkVar;
    }
}
