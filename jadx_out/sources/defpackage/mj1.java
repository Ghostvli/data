package defpackage;

import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mj1 implements yz3 {
    public final r02 a;
    public final r02 b;
    public long c;

    public mj1(long[] jArr, long[] jArr2, long j) {
        gg3.d(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.a = new r02(length);
            this.b = new r02(length);
        } else {
            int i = length + 1;
            r02 r02Var = new r02(i);
            this.a = r02Var;
            r02 r02Var2 = new r02(i);
            this.b = r02Var2;
            r02Var.a(0L);
            r02Var2.a(0L);
        }
        this.a.b(jArr);
        this.b.b(jArr2);
        this.c = j;
    }

    public long a(long j) {
        if (this.b.d() == 0) {
            return -9223372036854775807L;
        }
        return this.b.c(fy4.h(this.a, j, true, true));
    }

    public void b(long j, long j2) {
        if (this.b.d() == 0 && j > 0) {
            this.a.a(0L);
            this.b.a(0L);
        }
        this.a.a(j2);
        this.b.a(j);
    }

    @Override // defpackage.yz3
    public boolean e() {
        return this.b.d() > 0;
    }

    @Override // defpackage.yz3
    public yz3.a g(long j) {
        if (this.b.d() == 0) {
            return new yz3.a(a04.c);
        }
        int iH = fy4.h(this.b, j, true, true);
        a04 a04Var = new a04(this.b.c(iH), this.a.c(iH));
        if (a04Var.a == j || iH == this.b.d() - 1) {
            return new yz3.a(a04Var);
        }
        int i = iH + 1;
        return new yz3.a(a04Var, new a04(this.b.c(i), this.a.c(i)));
    }

    @Override // defpackage.yz3
    public long i() {
        return this.c;
    }

    public boolean j(long j, long j2) {
        if (this.b.d() == 0) {
            return false;
        }
        r02 r02Var = this.b;
        return j - r02Var.c(r02Var.d() - 1) < j2;
    }

    public void k(long j) {
        this.c = j;
    }
}
