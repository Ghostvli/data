package defpackage;

import android.util.SparseArray;
import defpackage.t41;
import defpackage.wt4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wi0 implements wt4.c {
    public final int a;
    public final List b;

    public wi0(int i) {
        this(i, xi1.u());
    }

    @Override // wt4.c
    public SparseArray a() {
        return new SparseArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    @Override // wt4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.wt4 b(int r6, wt4.b r7) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wi0.b(int, wt4$b):wt4");
    }

    public final k04 c(wt4.b bVar) {
        return new k04(e(bVar), "video/mp2t");
    }

    public final sx4 d(wt4.b bVar) {
        return new sx4(e(bVar), "video/mp2t");
    }

    public final List e(wt4.b bVar) {
        String str;
        int i;
        if (f(32)) {
            return this.b;
        }
        r73 r73Var = new r73(bVar.e);
        List arrayList = this.b;
        while (r73Var.a() > 0) {
            int iQ = r73Var.Q();
            int iG = r73Var.g() + r73Var.Q();
            if (iQ == 134) {
                arrayList = new ArrayList();
                int iQ2 = r73Var.Q() & 31;
                for (int i2 = 0; i2 < iQ2; i2++) {
                    String strN = r73Var.N(3);
                    int iQ3 = r73Var.Q();
                    boolean z = (iQ3 & 128) != 0;
                    if (z) {
                        i = iQ3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bQ = (byte) r73Var.Q();
                    r73Var.g0(1);
                    arrayList.add(new t41.b().A0(str).o0(strN).R(i).l0(z ? gv.h((bQ & 64) != 0) : null).Q());
                }
            }
            r73Var.f0(iG);
        }
        return arrayList;
    }

    public final boolean f(int i) {
        return (this.a & i) != 0;
    }

    public wi0(int i, List list) {
        this.a = i;
        this.b = list;
    }
}
