package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class oe4 implements Serializable {
    public final String f;
    public final dg2 g;
    public final String h;
    public final boolean i;
    public final mj0 j;
    public final String k;

    public oe4(String str, String str2, boolean z, dg2 dg2Var, mj0 mj0Var, String str3) {
        this.f = str;
        this.h = str2;
        this.i = z;
        this.g = dg2Var;
        this.j = mj0Var;
        this.k = str3;
    }

    public static boolean a(oe4 oe4Var, List list) {
        if (yy4.o(list)) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (oe4Var.b((oe4) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean b(oe4 oe4Var) {
        dg2 dg2Var;
        dg2 dg2Var2;
        return oe4Var != null && (dg2Var = this.g) != null && (dg2Var2 = oe4Var.g) != null && dg2Var.f == dg2Var2.f && this.j == oe4Var.j && this.i == oe4Var.i;
    }

    public String c() {
        return this.h;
    }

    public dg2 d() {
        return this.g;
    }
}
