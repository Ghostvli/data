package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y41 implements jz0 {
    public final jz0 a;

    public y41(jz0 jz0Var) {
        this.a = jz0Var;
    }

    @Override // defpackage.jz0
    public int b(int i) {
        return this.a.b(i);
    }

    @Override // defpackage.jz0
    public boolean d(byte[] bArr, int i, int i2, boolean z) {
        return this.a.d(bArr, i, i2, z);
    }

    @Override // defpackage.jz0
    public long getLength() {
        return this.a.getLength();
    }

    @Override // defpackage.jz0
    public long getPosition() {
        return this.a.getPosition();
    }

    @Override // defpackage.jz0
    public boolean i(int i, boolean z) {
        return this.a.i(i, z);
    }

    @Override // defpackage.jz0
    public boolean j(byte[] bArr, int i, int i2, boolean z) {
        return this.a.j(bArr, i, i2, z);
    }

    @Override // defpackage.jz0
    public long k() {
        return this.a.k();
    }

    @Override // defpackage.jz0
    public void m(int i) {
        this.a.m(i);
    }

    @Override // defpackage.jz0
    public int n(byte[] bArr, int i, int i2) {
        return this.a.n(bArr, i, i2);
    }

    @Override // defpackage.jz0
    public void p() {
        this.a.p();
    }

    @Override // defpackage.jz0
    public void q(int i) {
        this.a.q(i);
    }

    @Override // defpackage.jz0
    public boolean r(int i, boolean z) {
        return this.a.r(i, z);
    }

    @Override // defpackage.jz0, defpackage.x90
    public int read(byte[] bArr, int i, int i2) {
        return this.a.read(bArr, i, i2);
    }

    @Override // defpackage.jz0
    public void readFully(byte[] bArr, int i, int i2) {
        this.a.readFully(bArr, i, i2);
    }

    @Override // defpackage.jz0
    public void s(byte[] bArr, int i, int i2) {
        this.a.s(bArr, i, i2);
    }
}
