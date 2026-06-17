package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class fh0 extends ny3 {
    public static final fh0 n = new fh0();

    public fh0() {
        super(zl4.c, zl4.d, zl4.e, zl4.a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.n40
    public n40 f0(int i, String str) {
        it1.a(i);
        return i >= zl4.c ? it1.b(this, str) : super.f0(i, str);
    }

    @Override // defpackage.n40
    public String toString() {
        return "Dispatchers.Default";
    }
}
