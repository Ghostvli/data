package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fd1 implements hz0 {
    public final hz0 a;
    public final boolean b;

    public fd1(int i) {
        boolean z = (i & 1) != 0;
        this.b = z;
        if (z) {
            this.a = new j74(-1, -1, "image/heif");
        } else {
            this.a = new ed1();
        }
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.a.a(j, j2);
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a.b(mz0Var);
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        return this.a.d(jz0Var, yf3Var);
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return this.b ? gd1.a(jz0Var, false) : this.a.e(jz0Var);
    }

    @Override // defpackage.hz0
    public void release() {
        this.a.release();
    }
}
