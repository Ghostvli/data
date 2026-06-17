package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.k;
import defpackage.t41;
import defpackage.wt4;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e5 implements cr0 {
    public static final byte[] x = {73, 68, 51};
    public final boolean a;
    public final q73 b;
    public final r73 c;
    public final String d;
    public final int e;
    public final String f;
    public String g;
    public gr4 h;
    public gr4 i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public long s;
    public int t;
    public long u;
    public gr4 v;
    public long w;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e5(boolean z, String str, int i, String str2) {
        this.b = new q73(new byte[7]);
        this.c = new r73(Arrays.copyOf(x, 10));
        this.o = -1;
        this.p = -1;
        this.s = -9223372036854775807L;
        this.u = -9223372036854775807L;
        this.a = z;
        this.d = str;
        this.e = i;
        this.f = str2;
        s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean i(r73 r73Var, byte[] bArr, int i) {
        int iMin = Math.min(r73Var.a(), i - this.k);
        r73Var.u(bArr, this.k, iMin);
        int i2 = this.k + iMin;
        this.k = i2;
        return i2 == i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m(int i) {
        return (i & 65526) == 65520;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        b();
        while (r73Var.a() > 0) {
            int i = this.j;
            if (i == 0) {
                j(r73Var);
            } else if (i == 1) {
                g(r73Var);
            } else if (i != 2) {
                if (i == 3) {
                    if (i(r73Var, this.b.a, this.m ? 7 : 5)) {
                        n();
                    }
                } else {
                    if (i != 4) {
                        z20.a();
                        return;
                    }
                    p(r73Var);
                }
            } else if (i(r73Var, this.c.f(), 10)) {
                o();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        gg3.q(this.h);
        fy4.l(this.v);
        fy4.l(this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        this.u = -9223372036854775807L;
        q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.u = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.g = dVar.b();
        gr4 gr4VarE = mz0Var.e(dVar.c(), 1);
        this.h = gr4VarE;
        this.v = gr4VarE;
        if (!this.a) {
            this.i = new wl0();
            return;
        }
        dVar.a();
        gr4 gr4VarE2 = mz0Var.e(dVar.c(), 5);
        this.i = gr4VarE2;
        gr4VarE2.g(new t41.b().k0(dVar.b()).X(this.f).A0("application/id3").Q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(r73 r73Var) {
        if (r73Var.a() == 0) {
            return;
        }
        this.b.a[0] = r73Var.f()[r73Var.g()];
        this.b.p(2);
        int iH = this.b.h(4);
        int i = this.p;
        if (i != -1 && iH != i) {
            q();
            return;
        }
        if (!this.n) {
            this.n = true;
            this.o = this.q;
            this.p = iH;
        }
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h(r73 r73Var, int i) {
        r73Var.f0(i + 1);
        if (!w(r73Var, this.b.a, 1)) {
            return false;
        }
        this.b.p(4);
        int iH = this.b.h(1);
        int i2 = this.o;
        if (i2 != -1 && iH != i2) {
            return false;
        }
        if (this.p != -1) {
            if (!w(r73Var, this.b.a, 1)) {
                return true;
            }
            this.b.p(2);
            if (this.b.h(4) != this.p) {
                return false;
            }
            r73Var.f0(i + 2);
        }
        if (!w(r73Var, this.b.a, 4)) {
            return true;
        }
        this.b.p(14);
        int iH2 = this.b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrF = r73Var.f();
        int iJ = r73Var.j();
        int i3 = i + iH2;
        if (i3 >= iJ) {
            return true;
        }
        byte b = bArrF[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == iJ) {
                return true;
            }
            return l((byte) -1, bArrF[i4]) && ((bArrF[i4] & 8) >> 3) == iH;
        }
        if (b != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == iJ) {
            return true;
        }
        if (bArrF[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == iJ || bArrF[i6] == 51;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(r73 r73Var) {
        byte[] bArrF = r73Var.f();
        int iG = r73Var.g();
        int iJ = r73Var.j();
        while (iG < iJ) {
            int i = iG + 1;
            byte b = bArrF[iG];
            int i2 = b & 255;
            if (this.l == 512 && l((byte) -1, (byte) i2) && (this.n || h(r73Var, iG - 1))) {
                this.q = (b & 8) >> 3;
                this.m = (b & 1) == 0;
                if (this.n) {
                    t();
                } else {
                    r();
                }
                r73Var.f0(i);
                return;
            }
            int i3 = this.l;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.l = 768;
            } else if (i4 == 511) {
                this.l = 512;
            } else if (i4 == 836) {
                this.l = 1024;
            } else if (i4 == 1075) {
                u();
                r73Var.f0(i);
                return;
            } else if (i3 != 256) {
                this.l = Buffer.DEFAULT_SIZE;
            }
            iG = i;
        }
        r73Var.f0(iG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long k() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l(byte b, byte b2) {
        return m(((b & 255) << 8) | (b2 & 255));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        this.b.p(0);
        boolean z = this.r;
        q73 q73Var = this.b;
        if (z) {
            q73Var.r(10);
        } else {
            int i = 2;
            int iH = q73Var.h(2) + 1;
            if (iH != 2) {
                xz1.i("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
            } else {
                i = iH;
            }
            this.b.r(5);
            byte[] bArrB = k.b(i, this.p, this.b.h(3));
            k.b bVarF = k.f(bArrB);
            t41 t41VarQ = new t41.b().k0(this.g).X(this.f).A0("audio/mp4a-latm").V(bVarF.c).U(bVarF.b).B0(bVarF.a).l0(Collections.singletonList(bArrB)).o0(this.d).y0(this.e).Q();
            this.s = 1024000000 / ((long) t41VarQ.I);
            this.h.g(t41VarQ);
            this.r = true;
        }
        this.b.r(4);
        int iH2 = this.b.h(13);
        int i2 = iH2 - 7;
        if (this.m) {
            i2 = iH2 - 9;
        }
        v(this.h, this.s, 0, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o() {
        this.i.a(this.c, 10);
        this.c.f0(6);
        v(this.i, 0L, 10, this.c.P() + 10);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(r73 r73Var) {
        int iMin = Math.min(r73Var.a(), this.t - this.k);
        this.v.a(r73Var, iMin);
        int i = this.k + iMin;
        this.k = i;
        if (i == this.t) {
            gg3.v(this.u != -9223372036854775807L);
            this.v.b(this.u, 1, this.t, 0, null);
            this.u += this.w;
            s();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        this.n = false;
        s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r() {
        this.j = 1;
        this.k = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s() {
        this.j = 0;
        this.k = 0;
        this.l = Buffer.DEFAULT_SIZE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t() {
        this.j = 3;
        this.k = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        this.j = 2;
        this.k = x.length;
        this.t = 0;
        this.c.f0(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(gr4 gr4Var, long j, int i, int i2) {
        this.j = 4;
        this.k = i;
        this.v = gr4Var;
        this.w = j;
        this.t = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w(r73 r73Var, byte[] bArr, int i) {
        if (r73Var.a() < i) {
            return false;
        }
        r73Var.u(bArr, 0, i);
        return true;
    }

    public e5(boolean z, String str) {
        this(z, null, 0, str);
    }
}
