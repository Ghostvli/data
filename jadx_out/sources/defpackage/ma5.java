package defpackage;

import defpackage.dv2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ma5 {
    public final dv2.a a;
    public final long b;
    public final long c;
    public final qu2 d;
    public final int e;
    public final int f;
    public final long[] g;

    public ma5(dv2.a aVar, long j, long j2, long[] jArr, qu2 qu2Var, int i, int i2) {
        this.a = new dv2.a(aVar);
        this.b = j;
        this.c = j2;
        this.g = jArr;
        this.d = qu2Var;
        this.e = i;
        this.f = i2;
    }

    public static ma5 c(dv2.a aVar, r73 r73Var) {
        long[] jArr;
        int i;
        int i2;
        int iZ = r73Var.z();
        int iU = (iZ & 1) != 0 ? r73Var.U() : -1;
        long jS = (iZ & 2) != 0 ? r73Var.S() : -1L;
        qu2 qu2VarD = null;
        if ((iZ & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = r73Var.Q();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZ & 8) != 0) {
            r73Var.g0(4);
        }
        if (r73Var.a() >= 24) {
            r73Var.g0(11);
            qu2VarD = qu2.d(r73Var.y(), r73Var.Y(), r73Var.Y());
            r73Var.g0(2);
            int iT = r73Var.T();
            i2 = iT & 4095;
            i = (16773120 & iT) >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new ma5(aVar, iU, jS, jArr, qu2VarD, i, i2);
    }

    public long a() {
        long j = this.b;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        dv2.a aVar = this.a;
        return fy4.t1((j * ((long) aVar.g)) - 1, aVar.d);
    }

    public xs2 b() {
        qu2 qu2Var = this.d;
        if (qu2Var != null) {
            return new xs2(qu2Var);
        }
        return null;
    }
}
