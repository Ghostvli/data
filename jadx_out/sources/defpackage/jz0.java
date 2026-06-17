package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface jz0 extends x90 {
    int b(int i);

    boolean d(byte[] bArr, int i, int i2, boolean z);

    long getLength();

    long getPosition();

    boolean i(int i, boolean z);

    boolean j(byte[] bArr, int i, int i2, boolean z);

    long k();

    void m(int i);

    int n(byte[] bArr, int i, int i2);

    void p();

    void q(int i);

    boolean r(int i, boolean z);

    @Override // defpackage.x90
    int read(byte[] bArr, int i, int i2);

    void readFully(byte[] bArr, int i, int i2);

    void s(byte[] bArr, int i, int i2);
}
