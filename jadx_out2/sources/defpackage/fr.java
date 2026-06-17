package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fr {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(long j, r73 r73Var, gr4[] gr4VarArr) {
        while (true) {
            if (r73Var.a() <= 1) {
                return;
            }
            int iC = c(r73Var);
            int iC2 = c(r73Var);
            int iG = r73Var.g() + iC2;
            if (iC2 == -1 || iC2 > r73Var.a()) {
                xz1.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iG = r73Var.j();
            } else if (iC == 4 && iC2 >= 8) {
                int iQ = r73Var.Q();
                int iY = r73Var.Y();
                int iZ = iY == 49 ? r73Var.z() : 0;
                int iQ2 = r73Var.Q();
                if (iY == 47) {
                    r73Var.g0(1);
                }
                boolean z = iQ == 181 && (iY == 49 || iY == 47) && iQ2 == 3;
                if (iY == 49) {
                    z &= iZ == 1195456820;
                }
                if (z) {
                    b(j, r73Var, gr4VarArr);
                }
            }
            r73Var.f0(iG);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(long j, r73 r73Var, gr4[] gr4VarArr) {
        int iQ = r73Var.Q();
        if ((iQ & 64) != 0) {
            r73Var.g0(1);
            int i = (iQ & 31) * 3;
            int iG = r73Var.g();
            for (gr4 gr4Var : gr4VarArr) {
                r73Var.f0(iG);
                gr4Var.a(r73Var, i);
                gg3.v(j != -9223372036854775807L);
                gr4Var.b(j, 1, i, 0, null);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(r73 r73Var) {
        int i = 0;
        while (r73Var.a() != 0) {
            int iQ = r73Var.Q();
            i += iQ;
            if (iQ != 255) {
                return i;
            }
        }
        return -1;
    }
}
