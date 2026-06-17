package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xl4 extends vl4 {
    public final Runnable h;

    public xl4(Runnable runnable, long j, boolean z) {
        super(j, z);
        this.h = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.h.run();
    }

    public String toString() {
        return "Task[" + ua0.a(this.h) + '@' + ua0.b(this.h) + ", " + this.f + ", " + zl4.c(this.g) + ']';
    }
}
