package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o90 implements m90 {
    public final st a;
    public final long b;

    public o90(st stVar, long j) {
        this.a = stVar;
        this.b = j;
    }

    @Override // defpackage.m90
    public long a(long j) {
        return this.a.e[(int) j] - this.b;
    }

    @Override // defpackage.m90
    public long b(long j, long j2) {
        return this.a.d[(int) j];
    }

    @Override // defpackage.m90
    public long c(long j, long j2) {
        return 0L;
    }

    @Override // defpackage.m90
    public long d(long j, long j2) {
        return -9223372036854775807L;
    }

    @Override // defpackage.m90
    public vn3 e(long j) {
        return new vn3(null, this.a.c[(int) j], r6.b[r7]);
    }

    @Override // defpackage.m90
    public long f(long j, long j2) {
        return this.a.b(j + this.b);
    }

    @Override // defpackage.m90
    public boolean g() {
        return true;
    }

    @Override // defpackage.m90
    public long h() {
        return 0L;
    }

    @Override // defpackage.m90
    public long i(long j) {
        return this.a.a;
    }

    @Override // defpackage.m90
    public long j(long j, long j2) {
        return this.a.a;
    }
}
