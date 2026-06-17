package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p33 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(r33 r33Var, l33 l33Var) {
        zy4.j(r33Var);
        zy4.j(l33Var);
        l33 l33VarK = l33Var;
        int i = 0;
        while (l33VarK != null) {
            l33 l33VarN = l33VarK.N();
            int iL = l33VarN != null ? l33VarN.l() : 0;
            l33 l33VarB = l33VarK.B();
            r33Var.a(l33VarK, i);
            if (l33VarN == null || l33VarK.y()) {
                if (l33VarK.l() > 0) {
                    l33VarK = l33VarK.k(0);
                    i++;
                } else {
                    while (l33VarK.B() == null && i > 0) {
                        r33Var.b(l33VarK, i);
                        l33VarK = l33VarK.N();
                        i--;
                    }
                    r33Var.b(l33VarK, i);
                    if (l33VarK == l33Var) {
                        return;
                    } else {
                        l33VarK = l33VarK.B();
                    }
                }
            } else if (iL == l33VarN.l()) {
                l33VarK = l33VarN.k(l33VarK.Y());
            } else if (l33VarB == null) {
                do {
                    i--;
                    r33Var.b(l33VarN, i);
                    if (l33VarN == l33Var) {
                        break;
                    }
                    if (l33VarN.B() != null) {
                        l33VarK = l33VarN.B();
                        break;
                    }
                    l33VarN = l33VarN.N();
                } while (l33VarN != null);
                l33VarK = l33VarN;
                if (l33VarK == l33Var || l33VarK == null) {
                    return;
                }
            } else {
                l33VarK = l33VarB;
            }
        }
    }
}
