package defpackage;

import defpackage.t41;
import defpackage.yz3;
import java.io.EOFException;
import java.util.Arrays;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n5 implements hz0 {
    public static final pz0 s = new pz0() { // from class: m5
        @Override // defpackage.pz0
        public final hz0[] d() {
            return n5.g();
        }
    };
    public static final int[] t = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] u = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public static final byte[] v = fy4.F0("#!AMR\n");
    public static final byte[] w = fy4.F0("#!AMR-WB\n");
    public final byte[] a;
    public final int b;
    public final gr4 c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public long h;
    public int i;
    public int j;
    public long k;
    public mz0 l;
    public gr4 m;
    public gr4 n;
    public yz3 o;
    public boolean p;
    public long q;
    public boolean r;

    public n5(int i) {
        this.b = (i & 2) != 0 ? i | 1 : i;
        this.a = new byte[1];
        this.i = -1;
        wl0 wl0Var = new wl0();
        this.c = wl0Var;
        this.n = wl0Var;
    }

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new n5()};
    }

    public static int i(int i, long j) {
        return (int) ((((long) i) * 8000000) / j);
    }

    public static boolean r(jz0 jz0Var, byte[] bArr) {
        jz0Var.p();
        byte[] bArr2 = new byte[bArr.length];
        jz0Var.s(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.e = 0L;
        this.f = 0;
        this.g = 0;
        this.q = j2;
        yz3 yz3Var = this.o;
        if (!(yz3Var instanceof mj1)) {
            if (j == 0 || !(yz3Var instanceof g10)) {
                this.k = 0L;
                return;
            } else {
                this.k = ((g10) yz3Var).j(j);
                return;
            }
        }
        long jA = ((mj1) yz3Var).a(j);
        this.k = jA;
        if (m(jA, this.q)) {
            return;
        }
        this.p = true;
        this.n = this.c;
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.l = mz0Var;
        gr4 gr4VarE = mz0Var.e(0, 1);
        this.m = gr4VarE;
        this.n = gr4VarE;
        mz0Var.o();
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        h();
        if (jz0Var.getPosition() == 0 && !t(jz0Var)) {
            throw r83.a("Could not find AMR header.", null);
        }
        p();
        int iU = u(jz0Var);
        q(jz0Var.getLength(), iU);
        if (iU == -1) {
            yz3 yz3Var = this.o;
            if (yz3Var instanceof mj1) {
                long j = this.k + this.e;
                ((mj1) yz3Var).k(j);
                this.l.u(this.o);
                this.m.e(j);
            }
        }
        return iU;
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return t(jz0Var);
    }

    public final void h() {
        gg3.q(this.m);
        fy4.l(this.l);
    }

    public final yz3 j(long j, boolean z) {
        return new g10(j, this.h, i(this.i, 20000L), this.i, z);
    }

    public final int k(int i) throws r83 {
        boolean zN = n(i);
        boolean z = this.d;
        if (zN) {
            return z ? u[i] : t[i];
        }
        StringBuilder sb = new StringBuilder("Illegal AMR ");
        sb.append(z ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw r83.a(sb.toString(), null);
    }

    public final boolean l(int i) {
        if (this.d) {
            return false;
        }
        return i < 12 || i > 14;
    }

    public final boolean m(long j, long j2) {
        return Math.abs(j2 - j) < 20000;
    }

    public final boolean n(int i) {
        if (i < 0 || i > 15) {
            return false;
        }
        return o(i) || l(i);
    }

    public final boolean o(int i) {
        if (this.d) {
            return i < 10 || i > 13;
        }
        return false;
    }

    public final void p() {
        if (this.r) {
            return;
        }
        this.r = true;
        boolean z = this.d;
        String str = z ? "audio/amr-wb" : "audio/amr";
        this.m.g(new t41.b().X(str).A0(z ? "audio/amr-wb" : DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP).p0(z ? u[8] : t[7]).U(1).B0(z ? 16000 : 8000).Q());
    }

    public final void q(long j, int i) {
        int i2;
        if (this.o != null) {
            return;
        }
        int i3 = this.b;
        if ((i3 & 4) != 0) {
            this.o = new mj1(new long[]{this.h}, new long[]{0}, -9223372036854775807L);
        } else if ((i3 & 1) == 0 || !((i2 = this.i) == -1 || i2 == this.f)) {
            this.o = new yz3.b(-9223372036854775807L);
        } else if (this.j >= 20 || i == -1) {
            yz3 yz3VarJ = j(j, (i3 & 2) != 0);
            this.o = yz3VarJ;
            this.m.e(yz3VarJ.i());
        }
        yz3 yz3Var = this.o;
        if (yz3Var != null) {
            this.l.u(yz3Var);
        }
    }

    @Override // defpackage.hz0
    public void release() {
    }

    public final int s(jz0 jz0Var) throws r83 {
        jz0Var.p();
        jz0Var.s(this.a, 0, 1);
        byte b = this.a[0];
        if ((b & 131) <= 0) {
            return k((b >> 3) & 15);
        }
        throw r83.a("Invalid padding bits for frame header " + ((int) b), null);
    }

    public final boolean t(jz0 jz0Var) {
        byte[] bArr = v;
        if (r(jz0Var, bArr)) {
            this.d = false;
            jz0Var.q(bArr.length);
            return true;
        }
        byte[] bArr2 = w;
        if (!r(jz0Var, bArr2)) {
            return false;
        }
        this.d = true;
        jz0Var.q(bArr2.length);
        return true;
    }

    public final int u(jz0 jz0Var) throws r83 {
        if (this.g == 0) {
            try {
                int iS = s(jz0Var);
                this.f = iS;
                this.g = iS;
                if (this.i == -1) {
                    this.h = jz0Var.getPosition();
                    this.i = this.f;
                }
                if (this.i == this.f) {
                    this.j++;
                }
                yz3 yz3Var = this.o;
                if (yz3Var instanceof mj1) {
                    mj1 mj1Var = (mj1) yz3Var;
                    long j = this.k + this.e + 20000;
                    long position = jz0Var.getPosition() + ((long) this.f);
                    if (!mj1Var.j(j, 100000L)) {
                        mj1Var.b(j, position);
                    }
                    if (this.p && m(j, this.q)) {
                        this.p = false;
                        this.n = this.m;
                    }
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iD = this.n.d(jz0Var, this.g, true);
        if (iD == -1) {
            return -1;
        }
        int i = this.g - iD;
        this.g = i;
        if (i > 0) {
            return 0;
        }
        this.n.b(this.k + this.e, 1, this.f, 0, null);
        this.e += 20000;
        return 0;
    }

    public n5() {
        this(0);
    }
}
