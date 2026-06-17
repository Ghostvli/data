package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tu3 implements gv3 {
    public static final int[] h = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] i = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public final fv3 a;
    public final boolean b;
    public final int c;
    public gr4 d;
    public long e = -9223372036854775807L;
    public int g = -1;
    public long f = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tu3(fv3 fv3Var) {
        this.a = fv3Var;
        this.b = "audio/amr-wb".equals(gg3.q(fv3Var.c.p));
        this.c = fv3Var.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(int i2, boolean z) {
        gg3.l((i2 >= 0 && i2 <= 8) || i2 == 15, "Illegal AMR %s frame type %s", z ? "WB" : "NB", i2);
        return z ? i[i2] : h[i2];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.e = j;
        this.f = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i2) {
        gr4 gr4VarE = mz0Var.e(i2, 1);
        this.d = gr4VarE;
        gr4VarE.g(this.a.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void c(long j, int i2) {
        this.e = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i2, boolean z) {
        int iB;
        gg3.q(this.d);
        int i3 = this.g;
        if (i3 != -1 && i2 != (iB = cv3.b(i3))) {
            xz1.i("RtpAmrReader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i2)));
        }
        r73Var.g0(1);
        int iE = e((r73Var.q() >> 3) & 15, this.b);
        int iA = r73Var.a();
        gg3.e(iA == iE, "compound payload not supported currently");
        this.d.a(r73Var, iA);
        this.d.b(iv3.a(this.f, j, this.e, this.c), 1, iA, 0, null);
        this.g = i2;
    }
}
