package defpackage;

import defpackage.dv2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h10 extends g10 implements b04 {
    public final long i;
    public final int j;
    public final int k;
    public final boolean l;
    public final long m;

    public h10(long j, long j2, int i, int i2, boolean z, boolean z2) {
        super(j, j2, i, i2, z, z2);
        this.i = j2;
        this.j = i;
        this.k = i2;
        this.l = z;
        this.m = j == -1 ? -1L : j;
    }

    @Override // defpackage.b04
    public long a(long j) {
        return j(j);
    }

    @Override // defpackage.b04
    public long c() {
        return this.m;
    }

    @Override // defpackage.b04
    public long d() {
        return this.i;
    }

    @Override // defpackage.b04
    public int h() {
        return this.j;
    }

    public h10 l(long j) {
        return new h10(j, this.i, this.j, this.k, this.l, false);
    }

    public h10(long j, long j2, int i, int i2, boolean z) {
        this(j, j2, i, i2, z, true);
    }

    public h10(long j, long j2, dv2.a aVar, boolean z) {
        this(j, j2, aVar.f, aVar.c, z, true);
    }
}
