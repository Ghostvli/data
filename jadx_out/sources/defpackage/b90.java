package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class b90 {
    public long a;
    public long b;

    public long a(long j) {
        return c(this.a + j);
    }

    public long b() {
        return this.b;
    }

    public long c(long j) {
        long j2 = j - this.a;
        this.b = j2;
        this.a = j;
        return j2;
    }
}
