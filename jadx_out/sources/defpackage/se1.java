package defpackage;

import android.net.Uri;
import defpackage.fv;
import defpackage.ja0;
import defpackage.ne1;
import defpackage.we1;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class se1 extends v72 {
    public static final AtomicInteger O = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public final ie3 C;
    public final long D;
    public te1 E;
    public kf1 F;
    public int G;
    public boolean H;
    public volatile boolean I;
    public boolean J;
    public xi1 K;
    public boolean L;
    public long M;
    public boolean N;
    public final int k;
    public final int l;
    public final Uri m;
    public final boolean n;
    public final int o;
    public final aa0 p;
    public final ja0 q;
    public final te1 r;
    public final boolean s;
    public final boolean t;
    public final yo4 u;
    public final pe1 v;
    public final List w;
    public final oo0 x;
    public final xh1 y;
    public final r73 z;

    public se1(pe1 pe1Var, aa0 aa0Var, ja0 ja0Var, t41 t41Var, boolean z, aa0 aa0Var2, ja0 ja0Var2, boolean z2, Uri uri, List list, int i, Object obj, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, yo4 yo4Var, long j4, oo0 oo0Var, te1 te1Var, xh1 xh1Var, r73 r73Var, boolean z6, boolean z7, ie3 ie3Var) {
        super(aa0Var, ja0Var, t41Var, i, obj, j, j2, j3);
        this.A = z;
        this.o = i2;
        this.M = z3 ? j2 - j : -9223372036854775807L;
        this.l = i3;
        this.q = ja0Var2;
        this.p = aa0Var2;
        this.H = ja0Var2 != null;
        this.B = z2;
        this.m = uri;
        this.s = z5;
        this.u = yo4Var;
        this.D = j4;
        this.t = z4;
        this.v = pe1Var;
        this.w = list;
        this.x = oo0Var;
        this.r = te1Var;
        this.y = xh1Var;
        this.z = r73Var;
        this.N = z6;
        this.n = z7;
        this.C = ie3Var;
        this.K = xi1.u();
        this.k = O.getAndIncrement();
    }

    public static aa0 j(aa0 aa0Var, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return aa0Var;
        }
        gg3.q(bArr2);
        return new f5(aa0Var, bArr, bArr2);
    }

    public static se1 l(pe1 pe1Var, aa0 aa0Var, t41 t41Var, long j, we1 we1Var, ne1.e eVar, Uri uri, List list, int i, Object obj, boolean z, zo4 zo4Var, long j2, se1 se1Var, byte[] bArr, byte[] bArr2, boolean z2, boolean z3, ie3 ie3Var, fv.a aVar) {
        boolean z4;
        aa0 aa0VarJ;
        ja0 ja0VarA;
        boolean z5;
        Uri uri2;
        xh1 xh1Var;
        r73 r73Var;
        te1 te1Var;
        we1.g gVar = eVar.a;
        ja0 ja0VarA2 = new ja0.b().i(kx4.g(we1Var.a, gVar.f)).h(gVar.n).g(gVar.o).b(eVar.d ? 8 : 0).a();
        boolean z6 = bArr != null;
        aa0 aa0VarJ2 = j(aa0Var, bArr, z6 ? n((String) gg3.q(gVar.m)) : null);
        we1.f fVar = gVar.g;
        if (fVar != null) {
            boolean z7 = bArr2 != null;
            byte[] bArrN = z7 ? n((String) gg3.q(fVar.m)) : null;
            z4 = true;
            ja0VarA = new ja0.b().i(kx4.g(we1Var.a, fVar.f)).h(fVar.n).g(fVar.o).a();
            aa0VarJ = j(aa0Var, bArr2, bArrN);
            z5 = z7;
        } else {
            z4 = true;
            aa0VarJ = null;
            ja0VarA = null;
            z5 = false;
        }
        long j3 = j + gVar.j;
        long j4 = j3 + gVar.h;
        int i2 = we1Var.j + gVar.i;
        if (se1Var != null) {
            ja0 ja0Var = se1Var.q;
            boolean z8 = (ja0VarA == ja0Var || (ja0VarA != null && ja0Var != null && ja0VarA.a.equals(ja0Var.a) && ja0VarA.g == se1Var.q.g)) ? z4 : false;
            uri2 = uri;
            boolean z9 = (uri2.equals(se1Var.m) && se1Var.J) ? z4 : false;
            xh1Var = se1Var.y;
            r73Var = se1Var.z;
            te1Var = (z8 && z9 && !se1Var.L && se1Var.l == i2) ? se1Var.E : null;
        } else {
            uri2 = uri;
            xh1Var = new xh1();
            r73Var = new r73(10);
            te1Var = null;
        }
        return new se1(pe1Var, aa0VarJ2, ja0VarA2, t41Var, z6, aa0VarJ, ja0VarA, z5, uri2, list, i, obj, j3, j4, eVar.b, eVar.c, !eVar.d, i2, gVar.p, z, zo4Var.a(i2), j2, gVar.k, te1Var, xh1Var, r73Var, z2, z3, ie3Var);
    }

    public static byte[] n(String str) {
        if (xa.f(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean z(se1 se1Var, long j, Uri uri, boolean z, ne1.e eVar, long j2) {
        if (se1Var == null) {
            return false;
        }
        if (uri.equals(se1Var.m) && se1Var.J) {
            return false;
        }
        return !z || j2 + eVar.a.j < j;
    }

    @Override // xy1.e
    public void b() {
        te1 te1Var;
        gg3.q(this.F);
        if (this.E == null && (te1Var = this.r) != null && te1Var.e()) {
            this.E = this.r;
            this.H = false;
        }
        u();
        if (this.I) {
            return;
        }
        if (!this.t) {
            t();
        }
        this.J = !this.I;
    }

    @Override // xy1.e
    public void c() {
        this.I = true;
    }

    @Override // defpackage.v72
    public boolean h() {
        return this.J;
    }

    public void k() {
        this.N = false;
    }

    public final void m(aa0 aa0Var, ja0 ja0Var, boolean z, boolean z2) {
        ja0 ja0VarE;
        long position;
        int i = this.G;
        if (z) {
            z = i != 0;
            ja0VarE = ja0Var;
        } else {
            ja0VarE = ja0Var.e(i);
        }
        try {
            sf0 sf0VarW = w(aa0Var, ja0VarE, z2);
            if (z) {
                sf0VarW.q(this.G);
            }
            do {
                try {
                    try {
                        if (this.I) {
                            break;
                        }
                    } catch (EOFException e) {
                        if ((this.d.f & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                            throw e;
                        }
                        this.E.c();
                        position = sf0VarW.getPosition();
                    }
                } catch (Throwable th) {
                    this.G = (int) (sf0VarW.getPosition() - ja0Var.g);
                    throw th;
                }
            } while (this.E.a(sf0VarW));
            position = sf0VarW.getPosition();
            this.G = (int) (position - ja0Var.g);
        } finally {
            ia0.a(aa0Var);
        }
    }

    public int o(int i) {
        gg3.v(!this.N);
        if (i >= this.K.size()) {
            return 0;
        }
        return ((Integer) this.K.get(i)).intValue();
    }

    public long p() {
        long j = this.M;
        if (j != -9223372036854775807L) {
            return this.g + j;
        }
        return -9223372036854775807L;
    }

    public void q(kf1 kf1Var, xi1 xi1Var) {
        this.F = kf1Var;
        this.K = xi1Var;
    }

    public void r() {
        this.L = true;
    }

    public boolean s() {
        return this.M != -9223372036854775807L;
    }

    public final void t() {
        m(this.i, this.b, this.A, true);
    }

    public final void u() {
        if (this.H) {
            gg3.q(this.p);
            gg3.q(this.q);
            m(this.p, this.q, this.B, false);
            this.G = 0;
            this.H = false;
        }
    }

    public final long v(jz0 jz0Var) throws Throwable {
        wg3 wg3Var;
        jz0Var.p();
        try {
            this.z.b0(10);
            jz0Var.s(this.z.f(), 0, 10);
            if (this.z.T() != 4801587) {
                return -9223372036854775807L;
            }
            this.z.g0(3);
            int iP = this.z.P();
            int i = iP + 10;
            if (i > this.z.b()) {
                byte[] bArrF = this.z.f();
                this.z.b0(i);
                System.arraycopy(bArrF, 0, this.z.f(), 0, 10);
            }
            jz0Var.s(this.z.f(), 10, iP);
            xs2 xs2VarE = this.y.e(this.z.f(), iP);
            if (xs2VarE == null || (wg3Var = (wg3) xs2VarE.h(wg3.class, new ig3() { // from class: re1
                @Override // defpackage.ig3
                public final boolean apply(Object obj) {
                    return ((wg3) obj).b.equals("com.apple.streaming.transportStreamTimestamp");
                }
            })) == null) {
                return -9223372036854775807L;
            }
            System.arraycopy(wg3Var.c, 0, this.z.f(), 0, 8);
            this.z.f0(0);
            this.z.e0(8);
            return this.z.J() & 8589934591L;
        } catch (EOFException unused) {
            return -9223372036854775807L;
        }
    }

    public final sf0 w(aa0 aa0Var, ja0 ja0Var, boolean z) throws Throwable {
        te1 te1VarE;
        long jA = aa0Var.a(ja0Var);
        if (z) {
            try {
                this.u.j(this.s, this.g, this.D);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e) {
                throw new IOException(e);
            }
        }
        sf0 sf0Var = new sf0(aa0Var, ja0Var.g, jA);
        if (this.E == null) {
            long jV = v(sf0Var);
            sf0Var.p();
            te1 te1Var = this.r;
            if (te1Var != null) {
                te1VarE = te1Var.f();
            } else {
                te1VarE = this.v.e(ja0Var.a, this.d, this.w, this.u, aa0Var.o(), sf0Var, this.C);
                sf0Var = sf0Var;
            }
            this.E = te1VarE;
            boolean zD = te1VarE.d();
            kf1 kf1Var = this.F;
            if (zD) {
                kf1Var.t0(jV != -9223372036854775807L ? this.u.b(jV) : this.g);
            } else {
                kf1Var.t0(0L);
            }
            this.F.e0();
            this.E.b(this.F);
        }
        this.F.p0(this.x);
        return sf0Var;
    }

    public void x(long j) {
        this.M = j;
    }

    public boolean y() {
        return this.N;
    }
}
