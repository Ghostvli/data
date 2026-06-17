package defpackage;

import defpackage.no1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n6 {
    public static final no1.a a = no1.a.a("k", "x", "y");

    public static m6 a(no1 no1Var, f12 f12Var) {
        ArrayList arrayList = new ArrayList();
        if (no1Var.K() == no1.b.BEGIN_ARRAY) {
            no1Var.c();
            while (no1Var.t()) {
                arrayList.add(j93.a(no1Var, f12Var));
            }
            no1Var.i();
            gr1.b(arrayList);
        } else {
            arrayList.add(new dr1(wo1.e(no1Var, uy4.e())));
        }
        return new m6(arrayList);
    }

    public static z6 b(no1 no1Var, f12 f12Var) {
        no1Var.h();
        m6 m6VarA = null;
        j6 j6VarE = null;
        boolean z = false;
        j6 j6VarE2 = null;
        while (no1Var.K() != no1.b.END_OBJECT) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                m6VarA = a(no1Var, f12Var);
            } else if (iM != 1) {
                if (iM != 2) {
                    no1Var.N();
                    no1Var.O();
                } else if (no1Var.K() == no1.b.STRING) {
                    no1Var.O();
                    z = true;
                } else {
                    j6VarE = a7.e(no1Var, f12Var);
                }
            } else if (no1Var.K() == no1.b.STRING) {
                no1Var.O();
                z = true;
            } else {
                j6VarE2 = a7.e(no1Var, f12Var);
            }
        }
        no1Var.l();
        if (z) {
            f12Var.a("Lottie doesn't support expressions.");
        }
        return m6VarA != null ? m6VarA : new r6(j6VarE2, j6VarE);
    }
}
