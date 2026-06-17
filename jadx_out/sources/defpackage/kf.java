package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kf implements hz0 {
    public final r73 a = new r73(4);
    public final j74 b = new j74(-1, -1, "image/avif");

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.b.a(j, j2);
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.b.b(mz0Var);
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        return this.b.d(jz0Var, yf3Var);
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        jz0Var.m(4);
        return g(jz0Var, 1718909296) && g(jz0Var, 1635150182);
    }

    public final boolean g(jz0 jz0Var, int i) {
        this.a.b0(4);
        jz0Var.s(this.a.f(), 0, 4);
        return this.a.S() == ((long) i);
    }

    @Override // defpackage.hz0
    public void release() {
    }
}
