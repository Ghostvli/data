package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xg3 extends uc4 {
    public final long a;
    public final long b;
    public final byte[] c;

    public xg3(long j, byte[] bArr, long j2) {
        this.a = j2;
        this.b = j;
        this.c = bArr;
    }

    public static xg3 d(r73 r73Var, int i, long j) {
        long jS = r73Var.S();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        r73Var.u(bArr, 0, i2);
        return new xg3(jS, bArr, j);
    }

    @Override // defpackage.uc4
    public String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.a + ", identifier= " + this.b + " }";
    }
}
