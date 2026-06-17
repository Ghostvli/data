package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xu3 implements gv3 {
    public final fv3 c;
    public gr4 d;
    public int e;
    public int i;
    public long j;
    public final r73 b = new r73(dx2.a);
    public final r73 a = new r73();
    public long f = -9223372036854775807L;
    public int g = -1;
    public long h = -9223372036854775807L;
    public boolean k = false;
    public boolean l = false;

    public xu3(fv3 fv3Var) {
        this.c = fv3Var;
    }

    public static int e(int i) {
        return i == 5 ? 1 : 0;
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.f = j;
        this.h = -9223372036854775807L;
        i();
        this.j = j2;
    }

    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 2);
        this.d = gr4VarE;
        ((gr4) fy4.l(gr4VarE)).g(this.c.c);
    }

    @Override // defpackage.gv3
    public void c(long j, int i) {
    }

    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) throws r83 {
        gg3.q(this.d);
        long j2 = this.h;
        if (j2 != -9223372036854775807L && j != j2) {
            i();
        }
        if (!this.k) {
            try {
                int i2 = r73Var.f()[0] & 31;
                if (this.l && i2 != 28) {
                    this.k = true;
                }
                if (!this.k) {
                    if (i2 > 0 && i2 < 24) {
                        g(r73Var);
                    } else if (i2 == 24) {
                        h(r73Var);
                    } else {
                        if (i2 != 28) {
                            throw r83.c(fy4.M("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i2)), null);
                        }
                        f(r73Var, i);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw r83.c(null, e);
            }
        }
        if (this.f == -9223372036854775807L) {
            this.f = j;
        }
        if (z) {
            if (!this.k) {
                this.d.b(iv3.a(this.j, j, this.f, 90000), this.e, this.i, 0, null);
            }
            i();
        }
        this.h = j;
        this.g = i;
    }

    public final void f(r73 r73Var, int i) {
        byte b = r73Var.f()[0];
        byte b2 = r73Var.f()[1];
        int i2 = (b & 224) | (b2 & 31);
        boolean z = (b2 & 128) > 0;
        boolean z2 = (b2 & 64) > 0;
        if (z) {
            if (this.l) {
                this.k = true;
                this.i = 0;
            }
            this.l = true;
            this.i += j();
            r73Var.f()[1] = (byte) i2;
            this.a.c0(r73Var.f());
            this.a.f0(1);
        } else {
            if (this.k) {
                return;
            }
            int iB = cv3.b(this.g);
            if (i != iB) {
                this.k = true;
                xz1.i("RtpH264Reader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return;
            } else {
                this.a.c0(r73Var.f());
                this.a.f0(2);
            }
        }
        int iA = this.a.a();
        this.d.a(this.a, iA);
        this.i += iA;
        if (z2) {
            this.l = false;
            this.e = e(i2 & 31);
        }
    }

    public final void g(r73 r73Var) {
        int iA = r73Var.a();
        this.i += j();
        this.d.a(r73Var, iA);
        this.i += iA;
        this.e = e(r73Var.f()[0] & 31);
    }

    public final void h(r73 r73Var) {
        r73Var.Q();
        while (r73Var.a() > 4) {
            int iY = r73Var.Y();
            this.i += j();
            this.d.a(r73Var, iY);
            this.i += iY;
        }
        this.e = 0;
    }

    public final void i() {
        this.k = false;
        this.l = false;
        this.i = 0;
        this.e = 0;
    }

    public final int j() {
        this.b.f0(0);
        int iA = this.b.a();
        ((gr4) gg3.q(this.d)).a(this.b, iA);
        return iA;
    }
}
