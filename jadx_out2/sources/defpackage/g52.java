package defpackage;

import defpackage.e52;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g52 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e52 a(no1 no1Var, f12 f12Var) {
        String strB;
        no1Var.h();
        e52.a aVar = null;
        q6 q6VarK = null;
        l6 l6VarH = null;
        boolean zU = false;
        while (no1Var.t()) {
            strB = no1Var.B();
            strB.getClass();
            switch (strB) {
                case "o":
                    l6VarH = a7.h(no1Var, f12Var);
                    break;
                case "pt":
                    q6VarK = a7.k(no1Var, f12Var);
                    break;
                case "inv":
                    zU = no1Var.u();
                    break;
                case "mode":
                    String strF = no1Var.F();
                    strF.getClass();
                    switch (strF) {
                        case "a":
                            aVar = e52.a.MASK_MODE_ADD;
                            break;
                        case "i":
                            f12Var.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = e52.a.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            aVar = e52.a.MASK_MODE_NONE;
                            break;
                        case "s":
                            aVar = e52.a.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            k02.c("Unknown mask mode " + strB + ". Defaulting to Add.");
                            aVar = e52.a.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    no1Var.O();
                    break;
            }
        }
        no1Var.l();
        return new e52(aVar, q6VarK, l6VarH, zU);
    }
}
