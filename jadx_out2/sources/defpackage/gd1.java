package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gd1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(jz0 jz0Var, boolean z) {
        int i;
        r73 r73Var = new r73(16);
        boolean z2 = true;
        while (true) {
            r73Var.b0(8);
            if (!jz0Var.j(r73Var.f(), 0, 8, true)) {
                return false;
            }
            long jS = r73Var.S();
            int iZ = r73Var.z();
            if (jS != 1) {
                i = 8;
            } else {
                if (!jz0Var.j(r73Var.f(), 8, 8, true)) {
                    return false;
                }
                jS = r73Var.X();
                i = 16;
            }
            long j = i;
            if (jS < j) {
                return false;
            }
            int i2 = (int) (jS - j);
            if (z2) {
                if (iZ != 1718909296 || i2 < 8) {
                    break;
                }
                r73Var.b0(4);
                jz0Var.s(r73Var.f(), 0, 4);
                if (r73Var.z() != 1751476579) {
                    return false;
                }
                if (!z) {
                    return true;
                }
                jz0Var.m(i2 - 4);
                z2 = false;
            } else {
                if (iZ == 1836086884) {
                    return true;
                }
                if (i2 != 0) {
                    jz0Var.m(i2);
                }
            }
        }
    }
}
