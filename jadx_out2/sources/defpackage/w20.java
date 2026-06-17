package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w20 {
    public static final no1.a a = no1.a.a("ty", "d");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v20 a(no1 no1Var, f12 f12Var) {
        v20 v20VarA;
        String strF;
        no1Var.h();
        int iY = 2;
        while (true) {
            v20VarA = null;
            if (!no1Var.t()) {
                strF = null;
                break;
            }
            int iM = no1Var.M(a);
            if (iM == 0) {
                strF = no1Var.F();
                break;
            }
            if (iM != 1) {
                no1Var.N();
                no1Var.O();
            } else {
                iY = no1Var.y();
            }
        }
        if (strF == null) {
            return null;
        }
        switch (strF) {
            case "el":
                v20VarA = du.a(no1Var, f12Var, iY);
                break;
            case "fl":
                v20VarA = e54.a(no1Var, f12Var);
                break;
            case "gf":
                v20VarA = cb1.a(no1Var, f12Var);
                break;
            case "gr":
                v20VarA = g54.a(no1Var, f12Var);
                break;
            case "gs":
                v20VarA = fb1.a(no1Var, f12Var);
                break;
            case "mm":
                v20VarA = hs2.a(no1Var);
                f12Var.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case "rc":
                v20VarA = cp3.a(no1Var, f12Var);
                break;
            case "rd":
                v20VarA = ou3.a(no1Var, f12Var);
                break;
            case "rp":
                v20VarA = qq3.a(no1Var, f12Var);
                break;
            case "sh":
                v20VarA = m54.a(no1Var, f12Var);
                break;
            case "sr":
                v20VarA = jf3.a(no1Var, f12Var, iY);
                break;
            case "st":
                v20VarA = o54.a(no1Var, f12Var);
                break;
            case "tm":
                v20VarA = q54.a(no1Var, f12Var);
                break;
            case "tr":
                v20VarA = y6.h(no1Var, f12Var);
                break;
            default:
                k02.c("Unknown shape type ".concat(strF));
                break;
        }
        while (no1Var.t()) {
            no1Var.O();
        }
        no1Var.l();
        return v20VarA;
    }
}
