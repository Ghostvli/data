package defpackage;

import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r85 implements yz3 {
    public final p85 a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public r85(p85 p85Var, int i, long j, long j2) {
        this.a = p85Var;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / ((long) p85Var.e);
        this.d = j3;
        this.e = b(j3);
    }

    public final long b(long j) {
        return fy4.u1(j * ((long) this.b), 1000000L, this.a.c);
    }

    @Override // defpackage.yz3
    public boolean e() {
        return true;
    }

    @Override // defpackage.yz3
    public yz3.a g(long j) {
        long jT = fy4.t((((long) this.a.c) * j) / (((long) this.b) * 1000000), 0L, this.d - 1);
        long j2 = this.c + (((long) this.a.e) * jT);
        long jB = b(jT);
        a04 a04Var = new a04(jB, j2);
        if (jB >= j || jT == this.d - 1) {
            return new yz3.a(a04Var);
        }
        long j3 = jT + 1;
        return new yz3.a(a04Var, new a04(b(j3), this.c + (((long) this.a.e) * j3)));
    }

    @Override // defpackage.yz3
    public long i() {
        return this.e;
    }
}
