package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p94 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i, r73 r73Var, int i2) {
        if (i == 12) {
            return 240;
        }
        if (i == 13) {
            return 120;
        }
        if (i == 21 && r73Var.a() >= 8 && r73Var.g() + 8 <= i2) {
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            if (iZ >= 12 && iZ2 == 1936877170) {
                return r73Var.R();
            }
        }
        return -2147483647;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xs2 b(r73 r73Var, int i) {
        r73Var.g0(12);
        while (r73Var.g() < i) {
            int iG = r73Var.g();
            int iZ = r73Var.z();
            if (r73Var.z() == 1935766900) {
                if (iZ < 16) {
                    return null;
                }
                r73Var.g0(4);
                int i2 = -1;
                int i3 = 0;
                for (int i4 = 0; i4 < 2; i4++) {
                    int iQ = r73Var.Q();
                    int iQ2 = r73Var.Q();
                    if (iQ == 0) {
                        i2 = iQ2;
                    } else if (iQ == 1) {
                        i3 = iQ2;
                    }
                }
                int iA = a(i2, r73Var, i);
                if (iA == -2147483647) {
                    return null;
                }
                return new xs2(new q94(iA, i3));
            }
            r73Var.f0(iG + iZ);
        }
        return null;
    }
}
