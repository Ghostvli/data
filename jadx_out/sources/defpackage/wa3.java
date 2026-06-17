package defpackage;

import defpackage.wt4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wa3 implements wt4 {
    public final cr0 a;
    public final q73 b = new q73(new byte[10]);
    public int c = 0;
    public int d;
    public yo4 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public wa3(cr0 cr0Var) {
        this.a = cr0Var;
    }

    @Override // defpackage.wt4
    public void a(r73 r73Var, int i) {
        gg3.q(this.e);
        if ((i & 1) != 0) {
            int i2 = this.c;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    xz1.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i2 != 3) {
                        z20.a();
                        return;
                    }
                    if (this.j != -1) {
                        xz1.i("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.a.d(r73Var.j() == 0);
                }
            }
            h(1);
        }
        while (r73Var.a() > 0) {
            int i3 = this.c;
            if (i3 == 0) {
                r73Var.g0(r73Var.a());
            } else if (i3 != 1) {
                if (i3 == 2) {
                    if (e(r73Var, this.b.a, Math.min(10, this.i)) && e(r73Var, null, this.i)) {
                        g();
                        i |= this.k ? 4 : 0;
                        this.a.e(this.l, i);
                        h(3);
                    }
                } else {
                    if (i3 != 3) {
                        z20.a();
                        return;
                    }
                    int iA = r73Var.a();
                    int i4 = this.j;
                    int i5 = i4 == -1 ? 0 : iA - i4;
                    if (i5 > 0) {
                        iA -= i5;
                        r73Var.e0(r73Var.g() + iA);
                    }
                    this.a.a(r73Var);
                    int i6 = this.j;
                    if (i6 != -1) {
                        int i7 = i6 - iA;
                        this.j = i7;
                        if (i7 == 0) {
                            this.a.d(false);
                            h(1);
                        }
                    }
                }
            } else if (e(r73Var, this.b.a, 9)) {
                h(f() ? 2 : 0);
            }
        }
    }

    @Override // defpackage.wt4
    public void b(yo4 yo4Var, mz0 mz0Var, wt4.d dVar) {
        this.e = yo4Var;
        this.a.f(mz0Var, dVar);
    }

    @Override // defpackage.wt4
    public void c() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.c();
    }

    public boolean d(boolean z) {
        return this.c == 3 && this.j == -1 && !(z && (this.a instanceof tb1)) && (!z || f());
    }

    public final boolean e(r73 r73Var, byte[] bArr, int i) {
        int iMin = Math.min(r73Var.a(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            r73Var.g0(iMin);
        } else {
            r73Var.u(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    public final boolean f() {
        this.b.p(0);
        int iH = this.b.h(24);
        if (iH != 1) {
            xz1.i("PesReader", "Unexpected start code prefix: " + iH);
            this.j = -1;
            return false;
        }
        this.b.r(8);
        int iH2 = this.b.h(16);
        this.b.r(5);
        this.k = this.b.g();
        this.b.r(2);
        this.f = this.b.g();
        this.g = this.b.g();
        this.b.r(6);
        int iH3 = this.b.h(8);
        this.i = iH3;
        if (iH2 == 0) {
            this.j = -1;
        } else {
            int i = (iH2 - 3) - iH3;
            this.j = i;
            if (i < 0) {
                xz1.i("PesReader", "Found negative packet payload size: " + this.j);
                this.j = -1;
            }
        }
        return true;
    }

    public final void g() {
        this.b.p(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.r(4);
            long jH = ((long) this.b.h(3)) << 30;
            this.b.r(1);
            long jH2 = jH | ((long) (this.b.h(15) << 15));
            this.b.r(1);
            long jH3 = jH2 | ((long) this.b.h(15));
            this.b.r(1);
            if (!this.h && this.g) {
                this.b.r(4);
                long jH4 = ((long) this.b.h(3)) << 30;
                this.b.r(1);
                long jH5 = jH4 | ((long) (this.b.h(15) << 15));
                this.b.r(1);
                long jH6 = jH5 | ((long) this.b.h(15));
                this.b.r(1);
                this.e.b(jH6);
                this.h = true;
            }
            this.l = this.e.b(jH3);
        }
    }

    public final void h(int i) {
        this.c = i;
        this.d = 0;
    }
}
