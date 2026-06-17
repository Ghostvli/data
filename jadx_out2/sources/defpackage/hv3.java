package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hv3 implements gv3 {
    public final fv3 a;
    public gr4 b;
    public long c = -9223372036854775807L;
    public long d = 0;
    public int e = -1;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hv3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.c = j;
        this.d = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 1);
        this.b = gr4VarE;
        gr4VarE.g(this.a.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void c(long j, int i) {
        this.c = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        int iB;
        gg3.q(this.b);
        int i2 = this.e;
        if (i2 != -1 && i != (iB = cv3.b(i2))) {
            xz1.i("RtpPcmReader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i)));
        }
        long jA = iv3.a(this.d, j, this.c, this.a.b);
        int iA = r73Var.a();
        this.b.a(r73Var, iA);
        this.b.b(jA, 1, iA, 0, null);
        this.e = i;
    }
}
