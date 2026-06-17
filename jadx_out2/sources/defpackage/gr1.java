package defpackage;

import defpackage.no1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gr1 {
    public static no1.a a = no1.a.a("k");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List a(no1 no1Var, f12 f12Var, float f, cz4 cz4Var, boolean z) {
        no1 no1Var2;
        f12 f12Var2;
        float f2;
        cz4 cz4Var2;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (no1Var.K() == no1.b.STRING) {
            f12Var.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        no1Var.h();
        while (no1Var.t()) {
            if (no1Var.M(a) != 0) {
                no1Var.O();
            } else if (no1Var.K() == no1.b.BEGIN_ARRAY) {
                no1Var.c();
                if (no1Var.K() == no1.b.NUMBER) {
                    no1 no1Var3 = no1Var;
                    f12 f12Var3 = f12Var;
                    float f3 = f;
                    cz4 cz4Var3 = cz4Var;
                    boolean z3 = z;
                    dr1 dr1VarC = fr1.c(no1Var3, f12Var3, f3, cz4Var3, false, z3);
                    no1Var2 = no1Var3;
                    f12Var2 = f12Var3;
                    f2 = f3;
                    cz4Var2 = cz4Var3;
                    z2 = z3;
                    arrayList.add(dr1VarC);
                } else {
                    no1Var2 = no1Var;
                    f12Var2 = f12Var;
                    f2 = f;
                    cz4Var2 = cz4Var;
                    z2 = z;
                    while (no1Var2.t()) {
                        arrayList.add(fr1.c(no1Var2, f12Var2, f2, cz4Var2, true, z2));
                    }
                }
                no1Var2.i();
                no1Var = no1Var2;
                f12Var = f12Var2;
                f = f2;
                cz4Var = cz4Var2;
                z = z2;
            } else {
                no1 no1Var4 = no1Var;
                arrayList.add(fr1.c(no1Var4, f12Var, f, cz4Var, false, z));
                no1Var = no1Var4;
            }
        }
        no1Var.l();
        b(arrayList);
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(List list) {
        int i;
        Object obj;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            dr1 dr1Var = (dr1) list.get(i2);
            i2++;
            dr1 dr1Var2 = (dr1) list.get(i2);
            dr1Var.h = Float.valueOf(dr1Var2.g);
            if (dr1Var.c == null && (obj = dr1Var2.b) != null) {
                dr1Var.c = obj;
                if (dr1Var instanceof h93) {
                    ((h93) dr1Var).j();
                }
            }
        }
        dr1 dr1Var3 = (dr1) list.get(i);
        if ((dr1Var3.b == null || dr1Var3.c == null) && list.size() > 1) {
            list.remove(dr1Var3);
        }
    }
}
