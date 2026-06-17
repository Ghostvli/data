package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lv3 implements gv3 {
    public final fv3 a;
    public gr4 b;
    public boolean j;
    public boolean k;
    public boolean l;
    public long c = -9223372036854775807L;
    public int f = -1;
    public long g = -9223372036854775807L;
    public long d = 0;
    public int e = -1;
    public int h = -1;
    public int i = -1;

    public lv3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    private void e() {
        gr4 gr4Var = (gr4) gg3.q(this.b);
        long j = this.g;
        boolean z = this.l;
        gr4Var.b(j, z ? 1 : 0, this.f, 0, null);
        this.f = -1;
        this.g = -9223372036854775807L;
        this.j = false;
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.c = j;
        this.f = -1;
        this.d = j2;
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
        int i2;
        int i3;
        gg3.q(this.b);
        if (f(r73Var, i)) {
            if (this.f == -1 && this.j) {
                this.l = (r73Var.q() & 4) == 0;
            }
            if (!this.k && (i2 = this.h) != -1 && (i3 = this.i) != -1) {
                t41 t41Var = this.a.c;
                if (i2 != t41Var.w || i3 != t41Var.x) {
                    this.b.g(t41Var.b().H0(this.h).i0(this.i).Q());
                }
                this.k = true;
            }
            int iA = r73Var.a();
            this.b.a(r73Var, iA);
            int i4 = this.f;
            if (i4 == -1) {
                this.f = iA;
            } else {
                this.f = i4 + iA;
            }
            this.g = iv3.a(this.d, j, this.c, 90000);
            if (z) {
                e();
            }
            this.e = i;
        }
    }

    public final boolean f(r73 r73Var, int i) {
        int iQ = r73Var.Q();
        int i2 = iQ & 8;
        boolean z = this.j;
        if (i2 == 8) {
            if (z && this.f > 0) {
                e();
            }
            this.j = true;
        } else {
            if (!z) {
                xz1.i("RtpVp9Reader", "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
                return false;
            }
            int iB = cv3.b(this.e);
            if (i < iB) {
                xz1.i("RtpVp9Reader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return false;
            }
        }
        if ((iQ & 128) != 0 && (r73Var.Q() & 128) != 0 && r73Var.a() < 1) {
            return false;
        }
        int i3 = iQ & 16;
        gg3.e(i3 == 0, "VP9 flexible mode is not supported.");
        if ((iQ & 32) != 0) {
            r73Var.g0(1);
            if (r73Var.a() < 1) {
                return false;
            }
            if (i3 == 0) {
                r73Var.g0(1);
            }
        }
        if ((iQ & 2) != 0) {
            int iQ2 = r73Var.Q();
            int i4 = (iQ2 >> 5) & 7;
            if ((iQ2 & 16) != 0) {
                int i5 = i4 + 1;
                if (r73Var.a() < i5 * 4) {
                    return false;
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    this.h = r73Var.Y();
                    this.i = r73Var.Y();
                }
            }
            if ((iQ2 & 8) != 0) {
                int iQ3 = r73Var.Q();
                if (r73Var.a() < iQ3) {
                    return false;
                }
                for (int i7 = 0; i7 < iQ3; i7++) {
                    int iY = (r73Var.Y() & 12) >> 2;
                    if (r73Var.a() < iY) {
                        return false;
                    }
                    r73Var.g0(iY);
                }
            }
        }
        return true;
    }
}
