package defpackage;

import defpackage.ki4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qs1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(yh4 yh4Var, long j) {
        if (j == -9223372036854775807L) {
            return 0;
        }
        int iA = yh4Var.a(j);
        if (iA == -1) {
            iA = yh4Var.f();
        }
        return (iA <= 0 || yh4Var.b(iA + (-1)) != j) ? iA : iA - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(yh4 yh4Var, int i, g20 g20Var) {
        long jB = yh4Var.b(i);
        List listE = yh4Var.e(jB);
        if (listE.isEmpty()) {
            return;
        }
        if (i == yh4Var.f() - 1) {
            z20.a();
            return;
        }
        long jB2 = yh4Var.b(i + 1) - yh4Var.b(i);
        if (jB2 > 0) {
            g20Var.accept(new y50(listE, jB, jB2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(yh4 yh4Var, ki4.b bVar, g20 g20Var) {
        boolean z;
        int iA = a(yh4Var, bVar.a);
        if (bVar.a == -9223372036854775807L || iA >= yh4Var.f()) {
            z = false;
        } else {
            List listE = yh4Var.e(bVar.a);
            long jB = yh4Var.b(iA);
            if (!listE.isEmpty()) {
                long j = bVar.a;
                if (j < jB) {
                    g20Var.accept(new y50(listE, j, jB - j));
                    z = true;
                }
            }
        }
        for (int i = iA; i < yh4Var.f(); i++) {
            b(yh4Var, i, g20Var);
        }
        if (bVar.b) {
            if (z) {
                iA--;
            }
            for (int i2 = 0; i2 < iA; i2++) {
                b(yh4Var, i2, g20Var);
            }
            if (z) {
                g20Var.accept(new y50(yh4Var.e(bVar.a), yh4Var.b(iA), bVar.a - yh4Var.b(iA)));
            }
        }
    }
}
