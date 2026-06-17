package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u6 {
    public static final no1.a a = no1.a.a(SardineUtil.CUSTOM_NAMESPACE_PREFIX, "a");
    public static final no1.a b = no1.a.a(SardineUtil.CUSTOM_NAMESPACE_PREFIX, "e", "o", "r");
    public static final no1.a c = no1.a.a("fc", "sc", "sw", "t", "o");

    public static t6 a(no1 no1Var, f12 f12Var) {
        no1Var.h();
        w6 w6VarC = null;
        v6 v6VarB = null;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                v6VarB = b(no1Var, f12Var);
            } else if (iM != 1) {
                no1Var.N();
                no1Var.O();
            } else {
                w6VarC = c(no1Var, f12Var);
            }
        }
        no1Var.l();
        return new t6(w6VarC, v6VarB);
    }

    public static v6 b(no1 no1Var, f12 f12Var) {
        no1Var.h();
        l6 l6Var = null;
        l6 l6VarH = null;
        l6 l6VarH2 = null;
        um4 um4Var = null;
        while (no1Var.t()) {
            int iM = no1Var.M(b);
            if (iM == 0) {
                l6Var = a7.h(no1Var, f12Var);
            } else if (iM == 1) {
                l6VarH = a7.h(no1Var, f12Var);
            } else if (iM == 2) {
                l6VarH2 = a7.h(no1Var, f12Var);
            } else if (iM != 3) {
                no1Var.N();
                no1Var.O();
            } else {
                int iY = no1Var.y();
                if (iY == 1 || iY == 2) {
                    um4Var = iY == 1 ? um4.PERCENT : um4.INDEX;
                } else {
                    f12Var.a("Unsupported text range units: " + iY);
                    um4Var = um4.INDEX;
                }
            }
        }
        no1Var.l();
        if (l6Var == null && l6VarH != null) {
            l6Var = new l6(Collections.singletonList(new dr1(0)));
        }
        return new v6(l6Var, l6VarH, l6VarH2, um4Var);
    }

    public static w6 c(no1 no1Var, f12 f12Var) {
        no1Var.h();
        i6 i6VarC = null;
        i6 i6VarC2 = null;
        j6 j6VarE = null;
        j6 j6VarE2 = null;
        l6 l6VarH = null;
        while (no1Var.t()) {
            int iM = no1Var.M(c);
            if (iM == 0) {
                i6VarC = a7.c(no1Var, f12Var);
            } else if (iM == 1) {
                i6VarC2 = a7.c(no1Var, f12Var);
            } else if (iM == 2) {
                j6VarE = a7.e(no1Var, f12Var);
            } else if (iM == 3) {
                j6VarE2 = a7.e(no1Var, f12Var);
            } else if (iM != 4) {
                no1Var.N();
                no1Var.O();
            } else {
                l6VarH = a7.h(no1Var, f12Var);
            }
        }
        no1Var.l();
        return new w6(i6VarC, i6VarC2, j6VarE, j6VarE2, l6VarH);
    }
}
