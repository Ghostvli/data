package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kv3 implements gv3 {
    public final fv3 a;
    public gr4 b;
    public long c = -9223372036854775807L;
    public int d = -1;
    public int e = -1;
    public long f = -9223372036854775807L;
    public long g = 0;
    public boolean h;
    public boolean i;
    public boolean j;

    public kv3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    private void e() {
        gr4 gr4Var = (gr4) gg3.q(this.b);
        long j = this.f;
        boolean z = this.i;
        gr4Var.b(j, z ? 1 : 0, this.e, 0, null);
        this.e = -1;
        this.f = -9223372036854775807L;
        this.h = false;
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.c = j;
        this.e = -1;
        this.g = j2;
    }

    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 2);
        this.b = gr4VarE;
        gr4VarE.g(this.a.c);
    }

    @Override // defpackage.gv3
    public void c(long j, int i) {
        gg3.v(this.c == -9223372036854775807L);
        this.c = j;
    }

    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        gg3.q(this.b);
        if (f(r73Var, i)) {
            if (this.e == -1 && this.h) {
                this.i = (r73Var.q() & 1) == 0;
            }
            if (!this.j) {
                int iG = r73Var.g();
                r73Var.f0(iG + 6);
                int I = r73Var.I() & 16383;
                int I2 = r73Var.I() & 16383;
                r73Var.f0(iG);
                t41 t41Var = this.a.c;
                if (I != t41Var.w || I2 != t41Var.x) {
                    this.b.g(t41Var.b().H0(I).i0(I2).Q());
                }
                this.j = true;
            }
            int iA = r73Var.a();
            this.b.a(r73Var, iA);
            int i2 = this.e;
            if (i2 == -1) {
                this.e = iA;
            } else {
                this.e = i2 + iA;
            }
            this.f = iv3.a(this.g, j, this.c, 90000);
            if (z) {
                e();
            }
            this.d = i;
        }
    }

    public final boolean f(r73 r73Var, int i) {
        int iQ = r73Var.Q();
        if ((iQ & 16) == 16 && (iQ & 7) == 0) {
            if (this.h && this.e > 0) {
                e();
            }
            this.h = true;
        } else {
            if (!this.h) {
                xz1.i("RtpVP8Reader", "RTP packet is not the start of a new VP8 partition, skipping.");
                return false;
            }
            int iB = cv3.b(this.d);
            if (i < iB) {
                xz1.i("RtpVP8Reader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return false;
            }
        }
        if ((iQ & 128) != 0) {
            int iQ2 = r73Var.Q();
            if ((iQ2 & 128) != 0 && (r73Var.Q() & 128) != 0) {
                r73Var.g0(1);
            }
            if ((iQ2 & 64) != 0) {
                r73Var.g0(1);
            }
            if ((iQ2 & 32) != 0 || (iQ2 & 16) != 0) {
                r73Var.g0(1);
            }
        }
        return true;
    }
}
