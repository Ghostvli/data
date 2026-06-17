package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hi implements w72 {
    public final long b;
    public final long c;
    public long d;

    public hi(long j, long j2) {
        this.b = j;
        this.c = j2;
        f();
    }

    public final void c() {
        long j = this.d;
        if (j < this.b || j > this.c) {
            bo.a();
        }
    }

    public final long d() {
        return this.d;
    }

    public boolean e() {
        return this.d > this.c;
    }

    public void f() {
        this.d = this.b - 1;
    }

    @Override // defpackage.w72
    public boolean next() {
        this.d++;
        return !e();
    }
}
