package defpackage;

import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wu3 implements gv3 {
    public final fv3 a;
    public gr4 b;
    public int d;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;
    public boolean l;
    public long c = -9223372036854775807L;
    public int e = -1;

    public wu3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    private void e() {
        gr4 gr4Var = (gr4) gg3.q(this.b);
        long j = this.k;
        boolean z = this.h;
        gr4Var.b(j, z ? 1 : 0, this.d, 0, null);
        this.d = 0;
        this.k = -9223372036854775807L;
        this.h = false;
        this.l = false;
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.c = j;
        this.d = 0;
        this.j = j2;
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
        int iG = r73Var.g();
        int iY = r73Var.Y();
        boolean z2 = (iY & 1024) > 0;
        if ((iY & 512) != 0 || (iY & 504) != 0 || (iY & 7) != 0) {
            xz1.i("RtpH263Reader", "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
            return;
        }
        boolean z3 = this.l;
        if (z2) {
            if (z3 && this.d > 0) {
                e();
            }
            this.l = true;
            if ((r73Var.q() & 252) < 128) {
                xz1.i("RtpH263Reader", "Picture start Code (PSC) missing, dropping packet.");
                return;
            } else {
                r73Var.f()[iG] = 0;
                r73Var.f()[iG + 1] = 0;
                r73Var.f0(iG);
            }
        } else {
            if (!z3) {
                xz1.i("RtpH263Reader", "First payload octet of the H263 packet is not the beginning of a new H263 partition, Dropping current packet.");
                return;
            }
            int iB = cv3.b(this.e);
            if (i < iB) {
                xz1.i("RtpH263Reader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return;
            }
        }
        if (this.d == 0) {
            f(r73Var, this.i);
            if (!this.i && this.h) {
                int i2 = this.f;
                t41 t41Var = this.a.c;
                if (i2 != t41Var.w || this.g != t41Var.x) {
                    this.b.g(t41Var.b().H0(this.f).i0(this.g).Q());
                }
                this.i = true;
            }
        }
        int iA = r73Var.a();
        this.b.a(r73Var, iA);
        this.d += iA;
        this.k = iv3.a(this.j, j, this.c, 90000);
        if (z) {
            e();
        }
        this.e = i;
    }

    public final void f(r73 r73Var, boolean z) {
        int iG = r73Var.g();
        if (((r73Var.S() >> 10) & 63) != 32) {
            r73Var.f0(iG);
            this.h = false;
            return;
        }
        int iQ = r73Var.q();
        int i = (iQ >> 1) & 1;
        if (!z && i == 0) {
            int i2 = (iQ >> 2) & 7;
            if (i2 == 1) {
                this.f = 128;
                this.g = 96;
            } else {
                int i3 = i2 - 2;
                this.f = Token.GENEXPR << i3;
                this.g = Token.LABEL << i3;
            }
        }
        r73Var.f0(iG);
        this.h = i == 0;
    }
}
