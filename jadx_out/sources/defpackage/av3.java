package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class av3 implements gv3 {
    public final fv3 a;
    public gr4 b;
    public int c;
    public long d = -9223372036854775807L;
    public int e = -1;
    public long f;
    public int g;

    public av3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    public static int e(r73 r73Var) {
        int iC = in.c(r73Var.f(), new byte[]{0, 0, 1, -74});
        if (iC != -1) {
            r73Var.f0(iC + 4);
            if ((r73Var.q() >> 6) == 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.d = j;
        this.f = j2;
        this.g = 0;
    }

    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 2);
        this.b = gr4VarE;
        ((gr4) fy4.l(gr4VarE)).g(this.a.c);
    }

    @Override // defpackage.gv3
    public void c(long j, int i) {
    }

    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        int iB;
        gg3.q(this.b);
        int i2 = this.e;
        if (i2 != -1 && i != (iB = cv3.b(i2))) {
            xz1.i("RtpMpeg4Reader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
        }
        int iA = r73Var.a();
        this.b.a(r73Var, iA);
        if (this.g == 0) {
            this.c = e(r73Var);
        }
        this.g += iA;
        if (z) {
            if (this.d == -9223372036854775807L) {
                this.d = j;
            }
            this.b.b(iv3.a(this.f, j, this.d, 90000), this.c, this.g, 0, null);
            this.g = 0;
        }
        this.e = i;
    }
}
