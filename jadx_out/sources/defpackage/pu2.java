package defpackage;

import defpackage.b04;
import defpackage.dv2;
import defpackage.t41;
import defpackage.xh1;
import java.io.EOFException;
import java.math.RoundingMode;
import okio.internal.Buffer;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pu2 implements hz0 {
    public static final pz0 w = new pz0() { // from class: mu2
        @Override // defpackage.pz0
        public final hz0[] d() {
            return pu2.h();
        }
    };
    public static final xh1.a x = new xh1.a() { // from class: nu2
        @Override // xh1.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            return pu2.i(i, i2, i3, i4, i5);
        }
    };
    public final int a;
    public final long b;
    public final r73 c;
    public final dv2.a d;
    public final f91 e;
    public final zh1 f;
    public final gr4 g;
    public mz0 h;
    public gr4 i;
    public gr4 j;
    public int k;
    public xs2 l;
    public xs2 m;
    public long n;
    public long o;
    public long p;
    public long q;
    public int r;
    public b04 s;
    public boolean t;
    public boolean u;
    public long v;

    public pu2(int i, long j) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = j;
        this.c = new r73(10);
        this.d = new dv2.a();
        this.e = new f91();
        this.n = -9223372036854775807L;
        this.f = new zh1();
        wl0 wl0Var = new wl0();
        this.g = wl0Var;
        this.j = wl0Var;
        this.q = -1L;
    }

    public static /* synthetic */ hz0[] h() {
        return new hz0[]{new pu2()};
    }

    public static /* synthetic */ boolean i(int i, int i2, int i3, int i4, int i5) {
        if (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) {
            return true;
        }
        if (i2 == 77 && i3 == 76 && i4 == 76) {
            return i5 == 84 || i == 2;
        }
        return false;
    }

    private void j() {
        gg3.q(this.i);
        fy4.l(this.h);
    }

    public static long p(xs2 xs2Var) {
        mm4 mm4Var;
        if (xs2Var == null || (mm4Var = (mm4) xs2Var.h(mm4.class, new ig3() { // from class: ou2
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return ((mm4) obj).a.equals("TLEN");
            }
        })) == null) {
            return -9223372036854775807L;
        }
        return fy4.c1(Long.parseLong((String) mm4Var.d.get(0)));
    }

    public static int q(r73 r73Var, int i) {
        if (r73Var.j() >= i + 4) {
            r73Var.f0(i);
            int iZ = r73Var.z();
            if (iZ == 1483304551 || iZ == 1231971951) {
                return iZ;
            }
        }
        if (r73Var.j() < 40) {
            return 0;
        }
        r73Var.f0(36);
        return r73Var.z() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean r(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public static tt2 s(xs2 xs2Var, long j) {
        st2 st2Var;
        if (xs2Var == null || (st2Var = (st2) xs2Var.g(st2.class)) == null) {
            return null;
        }
        return tt2.b(j, st2Var, p(xs2Var));
    }

    private int x(jz0 jz0Var) {
        if (this.r == 0) {
            jz0Var.p();
            if (v(jz0Var)) {
                return -1;
            }
            this.c.f0(0);
            int iZ = this.c.z();
            if (!r(iZ, this.k) || dv2.j(iZ) == -1) {
                jz0Var.q(1);
                this.k = 0;
                return 0;
            }
            this.d.a(iZ);
            if (this.n == -9223372036854775807L) {
                this.n = this.s.a(jz0Var.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.n += this.b - this.s.a(0L);
                }
            }
            this.r = this.d.c;
            long position = jz0Var.getPosition();
            dv2.a aVar = this.d;
            this.q = position + ((long) aVar.c);
            b04 b04Var = this.s;
            if (b04Var instanceof nj1) {
                nj1 nj1Var = (nj1) b04Var;
                nj1Var.j(l(this.o + ((long) aVar.g)), this.q);
                if (this.u && nj1Var.b(this.v)) {
                    this.u = false;
                    this.j = this.i;
                }
            }
        }
        int iD = this.j.d(jz0Var, this.r, true);
        if (iD == -1) {
            return -1;
        }
        int i = this.r - iD;
        this.r = i;
        if (i > 0) {
            return 0;
        }
        this.j.b(l(this.o), 1, this.d.c, 0, null);
        this.o += (long) this.d.g;
        this.r = 0;
        return 0;
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.k = 0;
        this.n = -9223372036854775807L;
        this.o = 0L;
        this.r = 0;
        this.q = -1L;
        this.v = j2;
        b04 b04Var = this.s;
        if (!(b04Var instanceof nj1) || ((nj1) b04Var).b(j2)) {
            return;
        }
        this.u = true;
        this.j = this.g;
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.h = mz0Var;
        gr4 gr4VarE = mz0Var.e(0, 1);
        this.i = gr4VarE;
        this.j = gr4VarE;
        this.h.o();
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws Throwable {
        j();
        int iW = w(jz0Var);
        if (iW == -1 && (this.s instanceof nj1)) {
            long jL = l(this.o);
            if (this.s.i() != jL) {
                ((nj1) this.s).k(jL);
                this.h.u(this.s);
                this.i.e(this.s.i());
            }
        }
        return iW;
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return z(jz0Var, true);
    }

    public final b04 k(jz0 jz0Var) {
        b04 b04VarT = t(jz0Var);
        tt2 tt2VarS = s(this.l, jz0Var.getPosition());
        if (this.t) {
            return new b04.a();
        }
        if (tt2VarS != null) {
            b04VarT = tt2VarS;
        } else if (b04VarT == null) {
            b04VarT = null;
        }
        if (b04VarT == null) {
            b04VarT = o(jz0Var, (this.a & 2) != 0);
        }
        if ((this.a & 4) != 0 && !b04VarT.e()) {
            b04VarT = new nj1(b04VarT.i(), jz0Var.getPosition(), b04VarT.c());
        }
        if (y(b04VarT) && b04VarT.i() != -9223372036854775807L && (b04VarT.c() != -1 || jz0Var.getLength() != -1)) {
            long jD = b04VarT.d() != -1 ? b04VarT.d() : 0L;
            long jC = b04VarT.c() != -1 ? b04VarT.c() : jz0Var.getLength();
            b04VarT = new h10(jC, jD, ll1.m(fy4.x1(jC - jD, 8000000L, b04VarT.i(), RoundingMode.HALF_UP)), -1, false);
        } else if (y(b04VarT)) {
            b04VarT = o(jz0Var, (this.a & 2) != 0);
        }
        this.i.e(b04VarT.i());
        return b04VarT;
    }

    public final long l(long j) {
        return this.n + ((j * 1000000) / ((long) this.d.d));
    }

    public void m() {
        this.t = true;
    }

    public final b04 n(long j, ma5 ma5Var, long j2) {
        long j3;
        long j4;
        long jA = ma5Var.a();
        if (jA == -9223372036854775807L) {
            return null;
        }
        long j5 = ma5Var.c;
        if (j5 != -1) {
            long j6 = j + j5;
            j3 = j5 - ((long) ma5Var.a.c);
            j4 = j6;
        } else {
            if (j2 == -1) {
                return null;
            }
            j3 = (j2 - j) - ((long) ma5Var.a.c);
            j4 = j2;
        }
        long j7 = j3;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return new h10(j4, j + ((long) ma5Var.a.c), ll1.e(fy4.x1(j7, 8000000L, jA, roundingMode)), ll1.e(v02.b(j7, ma5Var.b, roundingMode)), false);
    }

    public final b04 o(jz0 jz0Var, boolean z) {
        jz0Var.s(this.c.f(), 0, 4);
        this.c.f0(0);
        this.d.a(this.c.z());
        return new h10(jz0Var.getLength(), jz0Var.getPosition(), this.d, z);
    }

    @Override // defpackage.hz0
    public void release() {
    }

    public final b04 t(jz0 jz0Var) {
        int i;
        int i2;
        r73 r73Var = new r73(this.d.c);
        jz0Var.s(r73Var.f(), 0, this.d.c);
        dv2.a aVar = this.d;
        int i3 = 21;
        if ((aVar.a & 1) != 0) {
            if (aVar.e != 1) {
                i3 = 36;
            }
        } else if (aVar.e == 1) {
            i3 = 13;
        }
        int iQ = q(r73Var, i3);
        if (iQ != 1231971951) {
            if (iQ == 1447187017) {
                ez4 ez4VarB = ez4.b(jz0Var.getLength(), jz0Var.getPosition(), this.d, r73Var);
                jz0Var.q(this.d.c);
                return ez4VarB;
            }
            if (iQ != 1483304551) {
                jz0Var.p();
                return null;
            }
        }
        ma5 ma5VarC = ma5.c(this.d, r73Var);
        if (!this.e.c() && (i = ma5VarC.e) != -1 && (i2 = ma5VarC.f) != -1) {
            f91 f91Var = this.e;
            f91Var.a = i;
            f91Var.b = i2;
        }
        this.m = ma5VarC.b();
        long position = jz0Var.getPosition();
        if (jz0Var.getLength() != -1 && ma5VarC.c != -1 && jz0Var.getLength() != ma5VarC.c + position) {
            xz1.g("Mp3Extractor", "Data size mismatch between stream (" + jz0Var.getLength() + ") and Xing frame (" + (ma5VarC.c + position) + "), using Xing value.");
        }
        jz0Var.q(this.d.c);
        return iQ == 1483304551 ? na5.b(ma5VarC, position) : n(position, ma5VarC, jz0Var.getLength());
    }

    public final void u() {
        b04 b04Var = this.s;
        if ((b04Var instanceof h10) && b04Var.e()) {
            long j = this.q;
            if (j == -1 || j == this.s.c()) {
                return;
            }
            this.s = ((h10) this.s).l(this.q);
            ((mz0) gg3.q(this.h)).u(this.s);
            ((gr4) gg3.q(this.i)).e(this.s.i());
        }
    }

    public final boolean v(jz0 jz0Var) {
        b04 b04Var = this.s;
        if (b04Var != null) {
            long jC = b04Var.c();
            if (jC != -1 && jz0Var.k() > jC - 4) {
                return true;
            }
        }
        try {
            return !jz0Var.j(this.c.f(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final int w(jz0 jz0Var) throws Throwable {
        if (this.k == 0) {
            try {
                z(jz0Var, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.s == null) {
            b04 b04VarK = k(jz0Var);
            this.s = b04VarK;
            this.h.u(b04VarK);
            xs2 xs2VarB = this.l;
            if (xs2VarB == null || (this.a & 8) != 0) {
                xs2VarB = this.m;
            } else {
                xs2 xs2Var = this.m;
                if (xs2Var != null) {
                    xs2VarB = xs2VarB.b(xs2Var);
                }
            }
            t41.b bVarS0 = new t41.b().X(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG).A0(this.d.b).p0(Buffer.SEGMENTING_THRESHOLD).U(this.d.e).B0(this.d.d).e0(this.e.a).f0(this.e.b).s0(xs2VarB);
            if (this.s.h() != -2147483647) {
                bVarS0.T(this.s.h());
            }
            this.j.g(bVarS0.Q());
            this.p = jz0Var.getPosition();
        } else if (this.p != 0) {
            long position = jz0Var.getPosition();
            long j = this.p;
            if (position < j) {
                jz0Var.q((int) (j - position));
            }
        }
        return x(jz0Var);
    }

    public final boolean y(b04 b04Var) {
        return (b04Var.e() || (b04Var instanceof h10) || (this.a & 1) == 0) ? false : true;
    }

    public final boolean z(jz0 jz0Var, boolean z) throws Throwable {
        int iK;
        int i;
        int iJ;
        jz0Var.p();
        if (jz0Var.getPosition() == 0) {
            xs2 xs2VarA = this.f.a(jz0Var, (this.a & 8) == 0 ? null : x, 131072);
            this.l = xs2VarA;
            if (xs2VarA != null) {
                this.e.e(xs2VarA);
            }
            iK = (int) jz0Var.k();
            if (!z) {
                jz0Var.q(iK);
            }
            i = 0;
        } else {
            iK = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (!v(jz0Var)) {
                this.c.f0(0);
                int iZ = this.c.z();
                if ((i == 0 || r(iZ, i)) && (iJ = dv2.j(iZ)) != -1) {
                    i2++;
                    if (i2 != 1) {
                        if (i2 == 4) {
                            break;
                        }
                    } else {
                        this.d.a(iZ);
                        i = iZ;
                    }
                    jz0Var.m(iJ - 4);
                } else {
                    int i4 = i3 + 1;
                    if (i3 == 131072) {
                        if (z) {
                            return false;
                        }
                        u();
                        ll.a();
                        return false;
                    }
                    if (z) {
                        jz0Var.p();
                        jz0Var.m(iK + i4);
                    } else {
                        jz0Var.q(1);
                    }
                    i2 = 0;
                    i3 = i4;
                    i = 0;
                }
            } else if (i2 <= 0) {
                u();
                ll.a();
                return false;
            }
        }
        if (z) {
            jz0Var.q(iK + i3);
        } else {
            jz0Var.p();
        }
        this.k = i;
        return true;
    }

    public pu2(int i) {
        this(i, -9223372036854775807L);
    }

    public pu2() {
        this(0);
    }
}
