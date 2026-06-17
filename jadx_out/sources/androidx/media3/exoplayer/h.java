package androidx.media3.exoplayer;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.h;
import androidx.media3.exoplayer.i;
import androidx.media3.exoplayer.j;
import androidx.media3.exoplayer.k;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.n;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.p;
import defpackage.ay1;
import defpackage.bc3;
import defpackage.bf3;
import defpackage.cc3;
import defpackage.cz;
import defpackage.dc3;
import defpackage.dn0;
import defpackage.er4;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.fz3;
import defpackage.ga0;
import defpackage.gg3;
import defpackage.ie3;
import defpackage.j25;
import defpackage.jq2;
import defpackage.jq3;
import defpackage.jy0;
import defpackage.kq3;
import defpackage.mc1;
import defpackage.mi2;
import defpackage.nc;
import defpackage.ni2;
import defpackage.no4;
import defpackage.nt2;
import defpackage.o5;
import defpackage.o64;
import defpackage.oj;
import defpackage.or4;
import defpackage.po0;
import defpackage.pr4;
import defpackage.qg;
import defpackage.r83;
import defpackage.t41;
import defpackage.wg1;
import defpackage.xi1;
import defpackage.xs2;
import defpackage.xz1;
import defpackage.yb;
import defpackage.zu;
import defpackage.zv0;
import defpackage.zz3;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Handler.Callback, mi2.a, or4.a, m.d, e.a, n.a, nc.a, j25 {
    public static final long q0 = fy4.S1(10000);
    public final long A;
    public final ie3 B;
    public final boolean C;
    public final o5 D;
    public final mc1 E;
    public final boolean F;
    public final nc G;
    public final boolean H;
    public zz3 I;
    public zz3 K;
    public boolean L;
    public boolean M;
    public C0020h N;
    public int O;
    public bc3 P;
    public e Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean W;
    public int X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public boolean b0;
    public int c0;
    public C0020h d0;
    public long e0;
    public final kq3[] f;
    public long f0;
    public final p[] g;
    public int g0;
    public final boolean[] h;
    public boolean h0;
    public final or4 i;
    public zv0 i0;
    public final pr4 j;
    public long j0;
    public final i k;
    public final qg l;
    public ExoPlayer.c l0;
    public final mc1 m;
    public final cc3 n;
    public final Looper o;
    public boolean o0;
    public final no4.d p;
    public final no4.b q;
    public final long r;
    public final boolean s;
    public final androidx.media3.exoplayer.e t;
    public final ArrayList u;
    public final zu v;
    public final f w;
    public final l x;
    public final m y;
    public final ay1 z;
    public long n0 = -9223372036854775807L;
    public float p0 = 1.0f;
    public fz3 J = fz3.j;
    public long k0 = -9223372036854775807L;
    public long V = -9223372036854775807L;
    public no4 m0 = no4.a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements o.a {
        public a() {
        }

        @Override // androidx.media3.exoplayer.o.a
        public void a() {
            h.this.a0 = true;
        }

        @Override // androidx.media3.exoplayer.o.a
        public void b() {
            if (h.this.i0() || h.this.b0) {
                h.this.m.h(2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final int a;
        public final int b;
        public final int c;
        public final o64 d;

        public c(int i, int i2, int i3, o64 o64Var) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = o64Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements Comparable {
        public final n f;
        public int g;
        public long h;
        public Object i;

        public d(n nVar) {
            this.f = nVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.i;
            if ((obj == null) != (dVar.i == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.g - dVar.g;
            return i != 0 ? i : Long.compare(this.h, dVar.h);
        }

        public void b(int i, long j, Object obj) {
            this.g = i;
            this.h = j;
            this.i = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public boolean a;
        public bc3 b;
        public int c;
        public boolean d;
        public int e;

        public e(bc3 bc3Var) {
            this.b = bc3Var;
        }

        public void b(int i) {
            this.a |= i > 0;
            this.c += i;
        }

        public void c(bc3 bc3Var) {
            this.a |= this.b != bc3Var;
            this.b = bc3Var;
        }

        public void d(int i) {
            if (this.d && this.e != 5) {
                gg3.d(i == 5);
                return;
            }
            this.a = true;
            this.d = true;
            this.e = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final jq2.b a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final int i;

        public g(jq2.b bVar, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i) {
            this.a = bVar;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = z4;
            this.h = z5;
            this.i = i;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0020h {
        public final no4 a;
        public final int b;
        public final long c;

        public C0020h(no4 no4Var, int i, long j) {
            this.a = no4Var;
            this.b = i;
            this.c = j;
        }
    }

    public h(Context context, o[] oVarArr, o[] oVarArr2, or4 or4Var, pr4 pr4Var, i iVar, qg qgVar, int i, boolean z, o5 o5Var, zz3 zz3Var, ay1 ay1Var, long j, boolean z2, boolean z3, Looper looper, zu zuVar, f fVar, ie3 ie3Var, cc3 cc3Var, ExoPlayer.c cVar, final j25 j25Var, boolean z4) {
        this.w = fVar;
        this.i = or4Var;
        this.j = pr4Var;
        this.k = iVar;
        this.l = qgVar;
        this.X = i;
        this.Y = z;
        this.I = zz3Var;
        this.z = ay1Var;
        this.A = j;
        this.j0 = j;
        this.S = z2;
        this.C = z3;
        this.v = zuVar;
        this.B = ie3Var;
        this.l0 = cVar;
        this.D = o5Var;
        this.H = z4;
        this.r = iVar.j(ie3Var);
        this.s = iVar.g(ie3Var);
        bc3 bc3VarK = bc3.k(pr4Var);
        this.P = bc3VarK;
        this.Q = new e(bc3VarK);
        this.g = new p[oVarArr.length];
        this.h = new boolean[oVarArr.length];
        p.a aVarD = or4Var.d();
        this.f = new kq3[oVarArr.length];
        boolean z5 = false;
        for (int i2 = 0; i2 < oVarArr.length; i2++) {
            oVarArr[i2].w(i2, ie3Var, zuVar);
            this.g[i2] = oVarArr[i2].x();
            if (aVarD != null) {
                this.g[i2].y(aVarD);
            }
            o oVar = oVarArr2[i2];
            if (oVar != null) {
                oVar.w(i2, ie3Var, zuVar);
                z5 = true;
            }
            this.f[i2] = new kq3(oVarArr[i2], oVarArr2[i2], i2);
        }
        this.F = z5;
        this.t = new androidx.media3.exoplayer.e(this, zuVar);
        this.u = new ArrayList();
        this.p = new no4.d();
        this.q = new no4.b();
        or4Var.e(this, qgVar);
        this.h0 = true;
        mc1 mc1VarC = zuVar.c(looper, null);
        this.E = mc1VarC;
        this.x = new l(o5Var, mc1VarC, new k.a() { // from class: fy0
            @Override // androidx.media3.exoplayer.k.a
            public final k a(ni2 ni2Var, long j2) {
                return this.a.A(ni2Var, j2);
            }
        }, cVar);
        this.y = new m(this, o5Var, mc1VarC, ie3Var);
        cc3 cc3Var2 = cc3Var == null ? new cc3() : cc3Var;
        this.n = cc3Var2;
        Looper looperA = cc3Var2.a();
        this.o = looperA;
        mc1 mc1VarC2 = zuVar.c(looperA, this);
        this.m = mc1VarC2;
        this.G = new nc(context, looperA, this);
        mc1VarC2.l(35, new j25() { // from class: gy0
            @Override // defpackage.j25
            public final void h(long j2, long j3, t41 t41Var, MediaFormat mediaFormat) {
                h.o(this.f, j25Var, j2, j3, t41Var, mediaFormat);
            }
        }).a();
    }

    public static void W0(no4 no4Var, d dVar, no4.d dVar2, no4.b bVar) {
        int i = no4Var.t(no4Var.n(dVar.i, bVar).c, dVar2).o;
        Object obj = no4Var.m(i, bVar, true).b;
        long j = bVar.d;
        dVar.b(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean X0(d dVar, no4 no4Var, no4 no4Var2, int i, boolean z, no4.d dVar2, no4.b bVar) {
        Object obj = dVar.i;
        if (obj == null) {
            Pair pairA1 = a1(no4Var, new C0020h(dVar.f.g(), dVar.f.c(), dVar.f.e() == Long.MIN_VALUE ? -9223372036854775807L : fy4.c1(dVar.f.e())), false, i, z, dVar2, bVar);
            if (pairA1 == null) {
                return false;
            }
            dVar.b(no4Var.h(pairA1.first), ((Long) pairA1.second).longValue(), pairA1.first);
            if (dVar.f.e() == Long.MIN_VALUE) {
                W0(no4Var, dVar, dVar2, bVar);
            }
            return true;
        }
        int iH = no4Var.h(obj);
        if (iH == -1) {
            return false;
        }
        if (dVar.f.e() == Long.MIN_VALUE) {
            W0(no4Var, dVar, dVar2, bVar);
            return true;
        }
        dVar.g = iH;
        no4Var2.n(dVar.i, bVar);
        if (bVar.f && no4Var2.t(bVar.c, dVar2).n == no4Var2.h(dVar.i)) {
            Pair pairP = no4Var.p(dVar2, bVar, no4Var.n(dVar.i, bVar).c, dVar.h + bVar.p());
            dVar.b(no4Var.h(pairP.first), ((Long) pairP.second).longValue(), pairP.first);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.exoplayer.h.g Z0(defpackage.no4 r41, defpackage.bc3 r42, androidx.media3.exoplayer.h.C0020h r43, androidx.media3.exoplayer.l r44, int r45, boolean r46, boolean r47, no4.d r48, no4.b r49) {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.Z0(no4, bc3, androidx.media3.exoplayer.h$h, androidx.media3.exoplayer.l, int, boolean, boolean, no4$d, no4$b):androidx.media3.exoplayer.h$g");
    }

    public static Pair a1(no4 no4Var, C0020h c0020h, boolean z, int i, boolean z2, no4.d dVar, no4.b bVar) {
        Pair pairP;
        no4 no4Var2;
        int iB1;
        no4 no4Var3 = c0020h.a;
        if (no4Var.w()) {
            return null;
        }
        boolean zW = no4Var3.w();
        no4 no4Var4 = no4Var3;
        if (zW) {
            no4Var4 = no4Var;
        }
        try {
            pairP = no4Var4.p(dVar, bVar, c0020h.b, c0020h.c);
            no4Var2 = no4Var4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (no4Var.equals(no4Var2)) {
            return pairP;
        }
        if (no4Var.h(pairP.first) != -1) {
            return (no4Var2.n(pairP.first, bVar).f && no4Var2.t(bVar.c, dVar).n == no4Var2.h(pairP.first)) ? no4Var.p(dVar, bVar, no4Var.n(pairP.first, bVar).c, c0020h.c) : pairP;
        }
        if (z && (iB1 = b1(dVar, bVar, i, z2, pairP.first, no4Var2, no4Var)) != -1) {
            return no4Var.p(dVar, bVar, iB1, -9223372036854775807L);
        }
        return null;
    }

    public static int b1(no4.d dVar, no4.b bVar, int i, boolean z, Object obj, no4 no4Var, no4 no4Var2) {
        no4.b bVar2;
        Object obj2 = no4Var.t(no4Var.n(obj, bVar).c, dVar).a;
        int i2 = 0;
        for (int i3 = 0; i3 < no4Var2.v(); i3++) {
            if (no4Var2.t(i3, dVar).a.equals(obj2)) {
                return i3;
            }
        }
        int iH = no4Var.h(obj);
        int iO = no4Var.o();
        int iJ = iH;
        int iH2 = -1;
        while (i2 < iO && iH2 == -1) {
            no4.d dVar2 = dVar;
            bVar2 = bVar;
            int i4 = i;
            boolean z2 = z;
            no4 no4Var3 = no4Var;
            iJ = no4Var3.j(iJ, bVar2, dVar2, i4, z2);
            if (iJ == -1) {
                break;
            }
            iH2 = no4Var2.h(no4Var3.s(iJ));
            i2++;
            no4Var = no4Var3;
            bVar = bVar2;
            dVar = dVar2;
            i = i4;
            z = z2;
        }
        bVar2 = bVar;
        if (iH2 == -1) {
            return -1;
        }
        return no4Var2.l(iH2, bVar2).c;
    }

    public static int e2(int i, int i2) {
        if (i == -1) {
            return 2;
        }
        if (i2 == 2) {
            return 1;
        }
        return i2;
    }

    public static boolean j0(boolean z, jq2.b bVar, long j, jq2.b bVar2, no4.b bVar3, long j2) {
        if (!z && j == j2 && bVar.a.equals(bVar2.a)) {
            if (bVar.c() && bVar3.t(bVar.b)) {
                return (bVar3.i(bVar.b, bVar.c) == 4 || bVar3.i(bVar.b, bVar.c) == 2) ? false : true;
            }
            if (bVar2.c() && bVar3.t(bVar2.b)) {
                return true;
            }
        }
        return false;
    }

    public static int k2(int i, int i2, boolean z) {
        if (i == 0) {
            return 1;
        }
        return i2 == 1 ? z ? 4 : 0 : i2;
    }

    public static /* synthetic */ void n(h hVar, n nVar) {
        hVar.getClass();
        try {
            hVar.B(nVar);
        } catch (zv0 e2) {
            xz1.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            wg1.a(e2);
        }
    }

    public static boolean n0(bc3 bc3Var, no4.b bVar) {
        jq2.b bVar2 = bc3Var.b;
        no4 no4Var = bc3Var.a;
        return no4Var.w() || no4Var.n(bVar2.a, bVar).f;
    }

    public static /* synthetic */ void o(h hVar, j25 j25Var, long j, long j2, t41 t41Var, MediaFormat mediaFormat) {
        hVar.getClass();
        j25Var.h(j, j2, t41Var, mediaFormat);
        hVar.h(j, j2, t41Var, mediaFormat);
    }

    public final k A(ni2 ni2Var, long j) {
        return new k(this.g, j, this.i, this.k.i(this.B), this.y, ni2Var, this.j, this.l0.a);
    }

    public final void A0() throws zv0 {
        k kVarX;
        if (this.T || !this.F || this.o0 || y() || (kVarX = this.x.x()) == null || kVarX != this.x.y() || kVarX.k() == null || !kVarX.k().f || M(kVarX.k()) > 10000000) {
            return;
        }
        this.x.c();
        s0();
    }

    public final void A1(int i) throws zv0 {
        this.X = i;
        int iY = this.x.Y(this.P.a, i);
        if ((iY & 1) != 0) {
            e1(true);
        } else if ((iY & 2) != 0) {
            C();
        }
        a0(false);
    }

    public final void B(n nVar) {
        if (nVar.i()) {
            return;
        }
        try {
            nVar.f().F(nVar.h(), nVar.d());
        } finally {
            nVar.j(true);
        }
    }

    public final void B0() {
        k kVarY = this.x.y();
        if (kVarY == null) {
            return;
        }
        int i = 0;
        if (kVarY.k() == null || this.T) {
            if (kVarY.h.k || this.T) {
                kq3[] kq3VarArr = this.f;
                int length = kq3VarArr.length;
                while (i < length) {
                    kq3 kq3Var = kq3VarArr[i];
                    if (kq3Var.x(kVarY) && kq3Var.r(kVarY)) {
                        long j = kVarY.h.f;
                        kq3Var.O(kVarY, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : kVarY.m() + kVarY.h.f);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (h0()) {
            if (y() && this.x.x() == this.x.y()) {
                return;
            }
            if (kVarY.k().f || this.e0 >= kVarY.k().n()) {
                if (!kVarY.k().f || M(kVarY.k()) <= 10000000) {
                    pr4 pr4VarP = kVarY.p();
                    k kVarD = this.x.d();
                    pr4 pr4VarP2 = kVarD.p();
                    no4 no4Var = this.P.a;
                    j2(no4Var, kVarD.h.a, no4Var, kVarY.h.a, -9223372036854775807L, false);
                    if (kVarD.f && ((this.F && this.n0 != -9223372036854775807L) || kVarD.a.q() != -9223372036854775807L)) {
                        this.n0 = -9223372036854775807L;
                        boolean z = this.F && !this.o0;
                        if (z) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < this.f.length) {
                                    if (pr4VarP2.c(i2) && this.f[i2].m() != -2 && !nt2.a(pr4VarP2.c[i2].l().p, pr4VarP2.c[i2].l().k) && !this.f[i2].u()) {
                                        z = false;
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (!z) {
                            l1(kVarD.n());
                            if (kVarD.s()) {
                                return;
                            }
                            this.x.N(kVarD);
                            a0(false);
                            o0();
                            return;
                        }
                    }
                    kq3[] kq3VarArr2 = this.f;
                    int length2 = kq3VarArr2.length;
                    while (i < length2) {
                        kq3VarArr2[i].F(pr4VarP, pr4VarP2, kVarD.n());
                        i++;
                    }
                }
            }
        }
    }

    public void B1(boolean z) {
        this.m.l(36, Boolean.valueOf(z)).a();
    }

    public final void C() {
        if (this.F && y()) {
            for (kq3 kq3Var : this.f) {
                int iH = kq3Var.h();
                kq3Var.c(this.t);
                this.c0 -= iH - kq3Var.h();
            }
            this.n0 = -9223372036854775807L;
        }
    }

    public final void C0() {
        k kVarY = this.x.y();
        if (kVarY == null || this.x.u() == kVarY || kVarY.i || !m2()) {
            return;
        }
        this.x.y().i = true;
    }

    public final void C1(boolean z) throws Throwable {
        if (!z) {
            if (this.N != null && this.M && !this.m.f(37)) {
                this.O++;
            }
            final int i = this.O;
            if (i > 0) {
                this.E.d(new Runnable() { // from class: dy0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.D.G0(i);
                    }
                });
            }
            this.O = 0;
            this.M = false;
            this.m.k(37);
            C0020h c0020h = this.N;
            if (c0020h != null) {
                f1(c0020h);
                this.N = null;
                this.M = false;
            }
        }
        this.L = z;
        x();
    }

    public final void D(int i) {
        int iH = this.f[i].h();
        this.f[i].b(this.t);
        u0(i, false);
        this.c0 -= iH;
    }

    public final void D0() throws Throwable {
        c0(this.y.i(), true);
    }

    public void D1(fz3 fz3Var) {
        this.m.l(38, fz3Var).a();
    }

    public final void E() {
        for (int i = 0; i < this.f.length; i++) {
            D(i);
        }
        this.n0 = -9223372036854775807L;
    }

    public final void E0(c cVar) throws Throwable {
        this.Q.b(1);
        c0(this.y.v(cVar.a, cVar.b, cVar.c, cVar.d), false);
    }

    public final void E1(fz3 fz3Var) {
        this.J = fz3Var;
        x();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() throws defpackage.zv0 {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.F():void");
    }

    public void F0(int i, int i2, int i3, o64 o64Var) {
        this.m.l(19, new c(i, i2, i3, o64Var)).a();
    }

    public final void F1(zz3 zz3Var) {
        this.I = zz3Var;
    }

    public final void G(k kVar, int i, boolean z, long j) throws zv0 {
        kq3 kq3Var = this.f[i];
        if (kq3Var.y()) {
            return;
        }
        boolean z2 = kVar == this.x.u();
        pr4 pr4VarP = kVar.p();
        jq3 jq3Var = pr4VarP.b[i];
        jy0 jy0Var = pr4VarP.c[i];
        boolean z3 = R1() && this.P.e == 3;
        boolean z4 = !z && z3;
        this.c0++;
        kq3Var.e(jq3Var, jy0Var, kVar.c[i], this.e0, z4, z2, j, kVar.m(), kVar.h.a, this.t);
        kq3Var.n(11, new a(), kVar);
        if (z3 && z2) {
            kq3Var.W();
        }
    }

    public final void G0() {
        for (k kVarU = this.x.u(); kVarU != null; kVarU = kVarU.k()) {
            for (jy0 jy0Var : kVarU.p().c) {
                if (jy0Var != null) {
                    jy0Var.q();
                }
            }
        }
    }

    public void G1(boolean z) {
        this.m.a(12, z ? 1 : 0, 0).a();
    }

    public final void H() throws zv0 {
        I(new boolean[this.f.length], this.x.y().n());
    }

    public final void H0(boolean z) {
        for (k kVarU = this.x.u(); kVarU != null; kVarU = kVarU.k()) {
            for (jy0 jy0Var : kVarU.p().c) {
                if (jy0Var != null) {
                    jy0Var.g(z);
                }
            }
        }
    }

    public final void H1(boolean z) throws zv0 {
        this.Y = z;
        int iZ = this.x.Z(this.P.a, z);
        if ((iZ & 1) != 0) {
            e1(true);
        } else if ((iZ & 2) != 0) {
            C();
        }
        a0(false);
    }

    public final void I(boolean[] zArr, long j) throws zv0 {
        h hVar;
        long j2;
        k kVarY = this.x.y();
        pr4 pr4VarP = kVarY.p();
        for (int i = 0; i < this.f.length; i++) {
            if (!pr4VarP.c(i)) {
                this.f[i].L();
            }
        }
        int i2 = 0;
        while (i2 < this.f.length) {
            if (!pr4VarP.c(i2) || this.f[i2].x(kVarY)) {
                hVar = this;
                j2 = j;
            } else {
                hVar = this;
                j2 = j;
                hVar.G(kVarY, i2, zArr[i2], j2);
            }
            i2++;
            this = hVar;
            j = j2;
        }
    }

    public final void I0() {
        for (k kVarU = this.x.u(); kVarU != null; kVarU = kVarU.k()) {
            for (jy0 jy0Var : kVarU.p().c) {
                if (jy0Var != null) {
                    jy0Var.r();
                }
            }
        }
    }

    public final void I1(o64 o64Var) throws Throwable {
        this.Q.b(1);
        c0(this.y.D(o64Var), false);
    }

    public void J(long j) {
        this.j0 = j;
    }

    @Override // i14.a
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void j(mi2 mi2Var) {
        this.m.l(9, mi2Var).a();
    }

    public final void J1(int i) {
        bc3 bc3Var = this.P;
        if (bc3Var.e != i) {
            if (i != 2) {
                this.k0 = -9223372036854775807L;
            }
            if (i != 3 && bc3Var.p) {
                this.P = bc3Var.i(false);
            }
            this.P = this.P.h(i);
        }
    }

    public final xi1 K(jy0[] jy0VarArr) {
        xi1.a aVar = new xi1.a();
        boolean z = false;
        for (jy0 jy0Var : jy0VarArr) {
            if (jy0Var != null) {
                xs2 xs2Var = jy0Var.h(0).l;
                if (xs2Var == null) {
                    aVar.a(new xs2(new xs2.a[0]));
                } else {
                    aVar.a(xs2Var);
                    z = true;
                }
            }
        }
        return z ? aVar.k() : xi1.u();
    }

    public void K0() {
        this.m.e(29).a();
    }

    public final void K1(j25 j25Var) {
        for (kq3 kq3Var : this.f) {
            kq3Var.T(j25Var);
        }
    }

    public final long L() {
        bc3 bc3Var = this.P;
        return O(bc3Var.a, bc3Var.b.a, bc3Var.s);
    }

    public final void L0() {
        this.Q.b(1);
        T0(false, false, false, true);
        this.k.h(this.B);
        J1(this.P.a.w() ? 4 : 2);
        f2();
        this.y.w(this.l.e());
        this.m.h(2);
    }

    public boolean L1(Object obj, long j) {
        if (!this.R && this.o.getThread().isAlive()) {
            cz czVar = new cz(this.v);
            this.m.l(30, new Pair(obj, czVar)).a();
            if (j != -9223372036854775807L) {
                return czVar.c(j);
            }
        }
        return true;
    }

    public final long M(k kVar) {
        gg3.v(kVar.f);
        return (long) ((kVar.n() - this.e0) / this.t.getPlaybackParameters().a);
    }

    public boolean M0() {
        if (this.R || !this.o.getThread().isAlive()) {
            return true;
        }
        this.R = true;
        cz czVar = new cz(this.v);
        this.m.l(7, czVar).a();
        return czVar.c(this.A);
    }

    public final void M1(Object obj, cz czVar) {
        for (kq3 kq3Var : this.f) {
            kq3Var.U(obj);
        }
        int i = this.P.e;
        if (i == 3 || i == 2) {
            this.m.h(2);
        }
        if (czVar != null) {
            czVar.f();
        }
    }

    public final long N() {
        long jMin = this.P.e == 3 ? 1000L : q0;
        for (kq3 kq3Var : this.f) {
            jMin = Math.min(jMin, fy4.S1(kq3Var.j(this.e0, this.f0)));
        }
        if (!this.P.n()) {
            return jMin;
        }
        k kVarK = this.x.u() != null ? this.x.u().k() : null;
        return (kVarK == null || ((float) this.e0) + (((float) fy4.c1(jMin)) * this.P.o.a) < ((float) kVarK.n())) ? jMin : Math.min(jMin, q0);
    }

    public final void N0(cz czVar) {
        try {
            T0(true, false, true, false);
            O0();
            this.k.d(this.B);
            this.G.h();
            this.i.j();
            J1(1);
        } finally {
            this.m.m(null);
            this.n.b();
            czVar.f();
        }
    }

    public void N1(float f2) {
        this.m.l(32, Float.valueOf(f2)).a();
    }

    public final long O(no4 no4Var, Object obj, long j) {
        no4Var.t(no4Var.n(obj, this.q).c, this.p);
        no4.d dVar = this.p;
        if (dVar.f != -9223372036854775807L && dVar.g()) {
            no4.d dVar2 = this.p;
            if (dVar2.i) {
                return fy4.c1(dVar2.b() - this.p.f) - (j + this.q.p());
            }
        }
        return -9223372036854775807L;
    }

    public final void O0() {
        for (int i = 0; i < this.f.length; i++) {
            this.g[i].h();
            this.f[i].H();
        }
    }

    public final void O1(float f2) {
        this.p0 = f2;
        float f3 = f2 * this.G.f();
        for (kq3 kq3Var : this.f) {
            kq3Var.V(f3);
        }
    }

    public final long P(k kVar) {
        if (kVar == null) {
            return 0L;
        }
        long jM = kVar.m();
        if (!kVar.f) {
            return jM;
        }
        int i = 0;
        while (true) {
            kq3[] kq3VarArr = this.f;
            if (i >= kq3VarArr.length) {
                return jM;
            }
            if (kq3VarArr[i].x(kVar)) {
                long jK = this.f[i].k(kVar);
                if (jK == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jM = Math.max(jK, jM);
            }
            i++;
        }
    }

    public final void P0(int i, int i2, o64 o64Var) throws Throwable {
        this.Q.b(1);
        c0(this.y.A(i, i2, o64Var), false);
    }

    public final boolean P1() {
        k kVarU;
        k kVarK;
        return R1() && !this.T && (kVarU = this.x.u()) != null && (kVarK = kVarU.k()) != null && this.e0 >= kVarK.n() && kVarK.i;
    }

    public final Pair Q(no4 no4Var) {
        if (no4Var.w()) {
            return Pair.create(bc3.l(), 0L);
        }
        Pair pairP = no4Var.p(this.p, this.q, no4Var.g(this.Y), -9223372036854775807L);
        jq2.b bVarQ = this.x.Q(no4Var, pairP.first, 0L);
        long jLongValue = ((Long) pairP.second).longValue();
        if (bVarQ.c()) {
            no4Var.n(bVarQ.a, this.q);
            jLongValue = bVarQ.c == this.q.m(bVarQ.b) ? this.q.h() : 0L;
        }
        return Pair.create(bVarQ, Long.valueOf(jLongValue));
    }

    public void Q0(int i, int i2, o64 o64Var) {
        this.m.i(20, i, i2, o64Var).a();
    }

    public final boolean Q1() {
        if (!k0(this.x.n())) {
            return false;
        }
        k kVarN = this.x.n();
        long jV = V(kVarN.l());
        k kVarU = this.x.u();
        long j = this.e0;
        i.a aVar = new i.a(this.B, this.P.a, kVarN.h.a, kVarN == kVarU ? kVarN.C(j) : kVarN.C(j) - kVarN.h.b, jV, this.t.getPlaybackParameters().a, this.P.l, this.U, U1(this.P.a, kVarN.h.a) ? this.z.b() : -9223372036854775807L, this.V);
        boolean zC = this.k.c(aVar);
        k kVarU2 = this.x.u();
        if (zC || !kVarU2.f || jV >= 500000 || (this.r <= 0 && !this.s)) {
            return zC;
        }
        kVarU2.a.t(this.P.s, false);
        return this.k.c(aVar);
    }

    public Looper R() {
        return this.o;
    }

    public final void R0() throws zv0 {
        float f2 = this.t.getPlaybackParameters().a;
        k kVarY = this.x.y();
        pr4 pr4Var = null;
        boolean z = true;
        for (k kVarU = this.x.u(); kVarU != null && kVarU.f; kVarU = kVarU.k()) {
            bc3 bc3Var = this.P;
            pr4 pr4VarZ = kVarU.z(f2, bc3Var.a, bc3Var.l);
            if (kVarU == this.x.u()) {
                pr4Var = pr4VarZ;
            }
            if (!pr4VarZ.a(kVarU.p())) {
                l lVar = this.x;
                if (z) {
                    k kVarU2 = lVar.u();
                    boolean z2 = (this.x.N(kVarU2) & 1) != 0;
                    boolean[] zArr = new boolean[this.f.length];
                    long jB = kVarU2.b((pr4) gg3.q(pr4Var), this.P.s, z2, zArr);
                    bc3 bc3Var2 = this.P;
                    boolean z3 = (bc3Var2.e == 4 || jB == bc3Var2.s) ? false : true;
                    bc3 bc3Var3 = this.P;
                    this.P = g0(bc3Var3.b, jB, bc3Var3.c, bc3Var3.d, z3, 5);
                    if (z3) {
                        V0(jB, true);
                    }
                    C();
                    boolean[] zArr2 = new boolean[this.f.length];
                    int i = 0;
                    while (true) {
                        kq3[] kq3VarArr = this.f;
                        if (i >= kq3VarArr.length) {
                            break;
                        }
                        int iH = kq3VarArr[i].h();
                        zArr2[i] = this.f[i].y();
                        this.f[i].B(kVarU2.c[i], this.t, this.e0, zArr[i]);
                        if (iH - this.f[i].h() > 0) {
                            u0(i, false);
                        }
                        this.c0 -= iH - this.f[i].h();
                        i++;
                    }
                    I(zArr2, this.e0);
                    kVarU2.i = true;
                } else {
                    lVar.N(kVarU);
                    if (kVarU.f) {
                        long jMax = Math.max(kVarU.h.b, kVarU.C(this.e0));
                        if (this.F && y() && this.x.x() == kVarU) {
                            C();
                        }
                        kVarU.a(pr4VarZ, jMax, false);
                    }
                }
                a0(true);
                if (this.P.e != 4) {
                    o0();
                    i2();
                    this.m.h(2);
                    return;
                }
                return;
            }
            if (kVarU == kVarY) {
                z = false;
            }
        }
    }

    public final boolean R1() {
        bc3 bc3Var = this.P;
        return bc3Var.l && bc3Var.n == 0;
    }

    public final zz3 S(long j) {
        fz3 fz3Var;
        Double d2;
        if (!this.L || j == -9223372036854775807L || (d2 = (fz3Var = this.J).b) == null || fz3Var.c == null) {
            return this.I;
        }
        double d3 = j;
        double dDoubleValue = d2.doubleValue() * d3;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        long jF = dn0.f(dDoubleValue, roundingMode);
        long jF2 = dn0.f(this.J.c.doubleValue() * d3, roundingMode);
        zz3 zz3Var = this.K;
        if (zz3Var == null || zz3Var.a != jF || zz3Var.b != jF2) {
            this.K = new zz3(jF, jF2);
        }
        return this.K;
    }

    public final void S0() throws zv0 {
        R0();
        e1(true);
    }

    public final boolean S1(k kVar, long j) {
        if (!this.P.a.w() && kVar.h.a.equals(this.P.b)) {
            long jD = kVar.D(j);
            boolean Z = true;
            for (kq3 kq3Var : this.f) {
                if (kq3Var.y()) {
                    Z &= kq3Var.Z(kVar, jD);
                }
            }
            if (!Z) {
                return false;
            }
            mi2 mi2Var = kVar.a;
            long j2 = this.P.s;
            zz3 zz3Var = zz3.e;
            if (mi2Var.d(j2, zz3Var) == kVar.a.d(j, zz3Var)) {
                return true;
            }
        }
        return false;
    }

    public final long T() {
        if (this.P.e != 3 || R1()) {
            return q0;
        }
        return 1000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009e A[PHI: r2 r6 r8
      0x009e: PHI (r2v2 jq2$b) = (r2v1 jq2$b), (r2v12 jq2$b) binds: [B:28:0x0074, B:30:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r6v3 long) = (r6v2 long), (r6v10 long) binds: [B:28:0x0074, B:30:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r8v2 long) = (r8v1 long), (r8v7 long) binds: [B:28:0x0074, B:30:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5 A[PHI: r0
      0x00e5: PHI (r0v12 no4) = (r0v11 no4), (r0v11 no4), (r0v22 no4), (r0v22 no4) binds: [B:34:0x00ab, B:36:0x00af, B:38:0x00c0, B:40:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T0(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.T0(boolean, boolean, boolean, boolean):void");
    }

    public final boolean T1(boolean z) {
        if (this.c0 == 0) {
            return m0();
        }
        boolean z2 = false;
        if (!z) {
            return false;
        }
        if (!this.P.g) {
            return true;
        }
        k kVarU = this.x.u();
        long jB = U1(this.P.a, kVarU.h.a) ? this.z.b() : -9223372036854775807L;
        k kVarN = this.x.n();
        boolean z3 = kVarN.s() && kVarN.h.k;
        if (kVarN.h.a.c() && !kVarN.f) {
            z2 = true;
        }
        if (z3 || z2) {
            return true;
        }
        return this.k.a(new i.a(this.B, this.P.a, kVarU.h.a, kVarU.C(this.e0), V(kVarN.j()), this.t.getPlaybackParameters().a, this.P.l, this.U, jB, this.V));
    }

    public final long U() {
        return V(this.P.q);
    }

    public final void U0() {
        k kVarU = this.x.u();
        this.T = kVarU != null && kVarU.h.j && this.S;
    }

    public final boolean U1(no4 no4Var, jq2.b bVar) {
        if (!bVar.c() && !no4Var.w()) {
            no4Var.t(no4Var.n(bVar.a, this.q).c, this.p);
            if (this.p.g()) {
                no4.d dVar = this.p;
                if (dVar.i && dVar.f != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    public final long V(long j) {
        k kVarN = this.x.n();
        if (kVarN == null) {
            return 0L;
        }
        return Math.max(0L, j - kVarN.C(this.e0));
    }

    public final void V0(long j, boolean z) {
        k kVarU = this.x.u();
        long jD = kVarU == null ? j + 1000000000000L : kVarU.D(j);
        this.e0 = jD;
        this.t.c(jD);
        for (kq3 kq3Var : this.f) {
            kq3Var.M(kVarU, this.e0, z);
        }
        G0();
    }

    public final void V1() {
        k kVarU = this.x.u();
        if (kVarU == null) {
            return;
        }
        pr4 pr4VarP = kVarU.p();
        for (int i = 0; i < this.f.length; i++) {
            if (pr4VarP.c(i)) {
                this.f[i].W();
            }
        }
    }

    public final void W(int i) {
        bc3 bc3Var = this.P;
        h2(bc3Var.l, i, bc3Var.n, bc3Var.m);
    }

    public void W1() {
        this.m.e(6).a();
    }

    public final void X() {
        O1(this.p0);
    }

    public final void X1(boolean z, boolean z2) {
        T0(z || !this.Z, false, true, false);
        this.Q.b(z2 ? 1 : 0);
        this.k.e(this.B);
        this.G.n(this.P.l, 1);
        J1(1);
    }

    public final void Y(mi2 mi2Var) {
        boolean zF = this.x.F(mi2Var);
        l lVar = this.x;
        if (zF) {
            lVar.K(this.e0);
            o0();
        } else if (lVar.G(mi2Var)) {
            p0();
        }
    }

    public final void Y0(no4 no4Var, no4 no4Var2) {
        if (no4Var.w() && no4Var2.w()) {
            return;
        }
        int size = this.u.size() - 1;
        while (true) {
            ArrayList arrayList = this.u;
            if (size < 0) {
                Collections.sort(arrayList);
                return;
            }
            no4 no4Var3 = no4Var;
            no4 no4Var4 = no4Var2;
            if (!X0((d) arrayList.get(size), no4Var3, no4Var4, this.X, this.Y, this.p, this.q)) {
                ((d) this.u.get(size)).f.j(false);
                this.u.remove(size);
            }
            size--;
            no4Var = no4Var3;
            no4Var2 = no4Var4;
        }
    }

    public final void Y1() {
        this.t.g();
        for (kq3 kq3Var : this.f) {
            kq3Var.Y();
        }
    }

    public final void Z(IOException iOException, int i) {
        zv0 zv0VarL = zv0.l(iOException, i);
        k kVarU = this.x.u();
        if (kVarU != null) {
            zv0VarL = zv0VarL.j(kVarU.h.a);
        }
        xz1.e("ExoPlayerImplInternal", "Playback error", zv0VarL);
        X1(false, false);
        this.P = this.P.f(zv0VarL);
    }

    public final void Z1() {
        k kVarN = this.x.n();
        boolean z = this.W || (kVarN != null && kVarN.a.isLoading());
        bc3 bc3Var = this.P;
        if (z != bc3Var.g) {
            this.P = bc3Var.b(z);
        }
    }

    @Override // or4.a
    public void a(o oVar) {
        this.m.h(26);
    }

    public final void a0(boolean z) {
        k kVarN = this.x.n();
        jq2.b bVar = kVarN == null ? this.P.b : kVarN.h.a;
        boolean zEquals = this.P.k.equals(bVar);
        if (!zEquals) {
            this.P = this.P.c(bVar);
        }
        bc3 bc3Var = this.P;
        bc3Var.q = kVarN == null ? bc3Var.s : kVarN.j();
        this.P.r = U();
        if ((!zEquals || z) && kVarN != null && kVarN.f) {
            a2(kVarN.h.a, kVarN.o(), kVarN.p());
        }
    }

    public final void a2(jq2.b bVar, er4 er4Var, pr4 pr4Var) {
        k kVar = (k) gg3.q(this.x.n());
        k kVarU = this.x.u();
        long j = this.e0;
        this.k.f(new i.a(this.B, this.P.a, bVar, kVar == kVarU ? kVar.C(j) : kVar.C(j) - kVar.h.b, V(kVar.j()), this.t.getPlaybackParameters().a, this.P.l, this.U, U1(this.P.a, kVar.h.a) ? this.z.b() : -9223372036854775807L, this.V), er4Var, pr4Var.c);
    }

    @Override // or4.a
    public void b() {
        this.m.h(10);
    }

    public final void b0(k kVar) throws zv0 {
        h hVar;
        if (!kVar.f) {
            float f2 = this.t.getPlaybackParameters().a;
            bc3 bc3Var = this.P;
            kVar.q(f2, bc3Var.a, bc3Var.l);
        }
        a2(kVar.h.a, kVar.o(), kVar.p());
        if (kVar == this.x.u()) {
            V0(kVar.h.b, true);
            H();
            kVar.i = true;
            bc3 bc3Var2 = this.P;
            jq2.b bVar = bc3Var2.b;
            long j = kVar.h.b;
            hVar = this;
            hVar.P = hVar.g0(bVar, j, bc3Var2.c, j, false, 5);
        } else {
            hVar = this;
        }
        hVar.o0();
    }

    public void b2(int i, int i2, List list) {
        this.m.i(27, i, i2, list).a();
    }

    @Override // nc.a
    public void c(float f2) {
        this.m.h(34);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(defpackage.no4 r20, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.c0(no4, boolean):void");
    }

    public final void c1(long j) {
        this.m.j(2, j + (i0() ? N() : T()));
    }

    public final void c2(int i, int i2, List list) throws Throwable {
        this.Q.b(1);
        c0(this.y.E(i, i2, list), false);
    }

    @Override // nc.a
    public void d(int i) {
        this.m.a(33, i, 0).a();
    }

    public final void d0(mi2 mi2Var) throws zv0 {
        boolean zF = this.x.F(mi2Var);
        l lVar = this.x;
        if (zF) {
            b0((k) gg3.q(lVar.n()));
            return;
        }
        k kVarV = lVar.v(mi2Var);
        if (kVarV != null) {
            gg3.v(!kVarV.f);
            float f2 = this.t.getPlaybackParameters().a;
            bc3 bc3Var = this.P;
            kVarV.q(f2, bc3Var.a, bc3Var.l);
            if (this.x.G(mi2Var)) {
                p0();
            }
        }
    }

    public void d1(no4 no4Var, int i, long j) {
        this.m.l(3, new C0020h(no4Var, i, j)).a();
    }

    public final void d2() throws zv0 {
        if (this.P.a.w() || !this.y.t()) {
            return;
        }
        boolean zW0 = w0();
        A0();
        B0();
        C0();
        y0();
        z0(zW0);
    }

    @Override // mi2.a
    public void e(mi2 mi2Var) {
        this.m.l(8, mi2Var).a();
    }

    public final void e0(dc3 dc3Var, float f2, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.Q.b(1);
            }
            this.P = this.P.g(dc3Var);
        }
        n2(dc3Var.a);
        for (kq3 kq3Var : this.f) {
            kq3Var.Q(f2, dc3Var.a);
        }
    }

    public final void e1(boolean z) throws zv0 {
        jq2.b bVar = this.x.u().h.a;
        long jH1 = h1(bVar, this.P.s, true, false);
        if (jH1 != this.P.s) {
            bc3 bc3Var = this.P;
            this.P = g0(bVar, jH1, bc3Var.c, bc3Var.d, z, 5);
        }
    }

    @Override // androidx.media3.exoplayer.m.d
    public void f() {
        this.m.k(2);
        this.m.h(22);
    }

    public final void f0(dc3 dc3Var, boolean z) {
        e0(dc3Var, dc3Var.a, true, z);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:42|43|(7:(11:45|(1:52)(1:51)|53|54|105|55|(1:62)|63|64|65|66)(1:69)|111|93|94|95|65|66)|70|(2:72|(1:(2:74|(2:117|80)(2:115|78))(1:114)))(0)|81|(1:83)(1:84)|85|86|(1:89)|90|107|91|92) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0194, code lost:
    
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0193, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1(androidx.media3.exoplayer.h.C0020h r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.f1(androidx.media3.exoplayer.h$h):void");
    }

    public final void f2() {
        bc3 bc3Var = this.P;
        g2(bc3Var.l, bc3Var.n, bc3Var.m);
    }

    @Override // androidx.media3.exoplayer.n.a
    public void g(n nVar) {
        if (!this.R && this.o.getThread().isAlive()) {
            this.m.l(14, nVar).a();
        } else {
            xz1.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            nVar.j(false);
        }
    }

    public final bc3 g0(jq2.b bVar, long j, long j2, long j3, boolean z, int i) {
        List list;
        er4 er4Var;
        pr4 pr4Var;
        this.h0 = (!this.h0 && j == this.P.s && bVar.equals(this.P.b)) ? false : true;
        U0();
        bc3 bc3Var = this.P;
        er4 er4Var2 = bc3Var.h;
        pr4 pr4Var2 = bc3Var.i;
        List listU = bc3Var.j;
        if (this.y.t()) {
            k kVarU = this.x.u();
            er4 er4VarO = kVarU == null ? er4.d : kVarU.o();
            pr4 pr4VarP = kVarU == null ? this.j : kVarU.p();
            xi1 xi1VarK = K(pr4VarP.c);
            if (kVarU != null) {
                ni2 ni2Var = kVarU.h;
                if (ni2Var.d != j2) {
                    kVarU.h = ni2Var.a(j2);
                }
            }
            x0();
            er4Var = er4VarO;
            pr4Var = pr4VarP;
            list = xi1VarK;
        } else {
            if (!bVar.equals(this.P.b)) {
                er4Var2 = er4.d;
                pr4Var2 = this.j;
                listU = xi1.u();
            }
            list = listU;
            er4Var = er4Var2;
            pr4Var = pr4Var2;
        }
        if (z) {
            this.Q.d(i);
        }
        return this.P.d(bVar, j, j2, j3, U(), er4Var, pr4Var, list);
    }

    public final long g1(jq2.b bVar, long j, boolean z) {
        return h1(bVar, j, this.x.u() != this.x.y(), z);
    }

    public final void g2(boolean z, int i, int i2) {
        h2(z, this.G.n(z, this.P.e), i, i2);
    }

    @Override // defpackage.j25
    public void h(long j, long j2, t41 t41Var, MediaFormat mediaFormat) {
        if (this.M) {
            this.m.e(37).a();
        }
    }

    public final boolean h0() {
        k kVarY = this.x.y();
        if (!kVarY.f) {
            return false;
        }
        int i = 0;
        while (true) {
            kq3[] kq3VarArr = this.f;
            if (i >= kq3VarArr.length) {
                return true;
            }
            if (!kq3VarArr[i].o(kVarY)) {
                return false;
            }
            i++;
        }
    }

    public final long h1(jq2.b bVar, long j, boolean z, boolean z2) throws zv0 {
        l lVar;
        Y1();
        boolean z3 = true;
        l2(false, true);
        if (z2 || this.P.e == 3) {
            J1(2);
        }
        k kVarU = this.x.u();
        k kVarK = kVarU;
        while (kVarK != null && !bVar.equals(kVarK.h.a)) {
            kVarK = kVarK.k();
        }
        if (z || kVarU != kVarK || (kVarK != null && kVarK.D(j) < 0)) {
            E();
            if (kVarK != null) {
                while (true) {
                    k kVarU2 = this.x.u();
                    lVar = this.x;
                    if (kVarU2 == kVarK) {
                        break;
                    }
                    lVar.b();
                }
                lVar.N(kVarK);
                kVarK.B(1000000000000L);
                H();
                kVarK.i = true;
            }
        }
        C();
        l lVar2 = this.x;
        if (kVarK != null) {
            lVar2.N(kVarK);
            if (!kVarK.f) {
                kVarK.h = kVarK.h.b(j, -9223372036854775807L);
            } else if (kVarK.g) {
                if (this.L && this.J.i && S1(kVarK, j)) {
                    z3 = false;
                } else {
                    j = kVarK.a.n(j);
                    kVarK.a.t(j - this.r, this.s);
                }
            }
            V0(j, z3);
            o0();
        } else {
            lVar2.g();
            V0(j, true);
        }
        a0(false);
        this.m.h(2);
        return j;
    }

    public final void h2(boolean z, int i, int i2, int i3) {
        boolean z2 = z && i != -1;
        int iE2 = e2(i, i3);
        int iK2 = k2(i, i2, this.L);
        bc3 bc3Var = this.P;
        if (bc3Var.l == z2 && bc3Var.n == iK2 && bc3Var.m == iE2) {
            return;
        }
        this.P = bc3Var.e(z2, iE2, iK2);
        l2(false, false);
        H0(z2);
        if (!R1()) {
            Y1();
            i2();
            bc3 bc3Var2 = this.P;
            if (bc3Var2.p) {
                this.P = bc3Var2.i(false);
            }
            this.x.K(this.e0);
            return;
        }
        int i4 = this.P.e;
        if (i4 == 3) {
            this.t.f();
            V1();
            this.m.h(2);
        } else if (i4 == 2) {
            this.m.h(2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        int i;
        l lVar;
        jq2.b bVar;
        k kVarY;
        try {
            switch (message.what) {
                case 1:
                    boolean z = message.arg1 != 0;
                    int i2 = message.arg2;
                    v1(z, i2 >> 4, true, i2 & 15);
                    break;
                case 2:
                    F();
                    break;
                case 3:
                    f1((C0020h) message.obj);
                    break;
                case 4:
                    x1((dc3) message.obj);
                    break;
                case 5:
                    F1((zz3) message.obj);
                    break;
                case 6:
                    X1(false, true);
                    break;
                case 7:
                    N0((cz) message.obj);
                    return true;
                case 8:
                    d0((mi2) message.obj);
                    break;
                case 9:
                    Y((mi2) message.obj);
                    break;
                case 10:
                    R0();
                    break;
                case 11:
                    A1(message.arg1);
                    break;
                case 12:
                    H1(message.arg1 != 0);
                    break;
                case 13:
                    o1(message.arg1 != 0, (cz) message.obj);
                    break;
                case 14:
                    i1((n) message.obj);
                    break;
                case 15:
                    k1((n) message.obj);
                    break;
                case 16:
                    f0((dc3) message.obj, false);
                    break;
                case 17:
                    q1((b) message.obj);
                    break;
                case 18:
                    u((b) message.obj, message.arg1);
                    break;
                case 19:
                    E0((c) message.obj);
                    break;
                case 20:
                    P0(message.arg1, message.arg2, (o64) message.obj);
                    break;
                case 21:
                    I1((o64) message.obj);
                    break;
                case 22:
                    D0();
                    break;
                case 23:
                    t1(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    z();
                    break;
                case 26:
                    S0();
                    break;
                case 27:
                    c2(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    y1((ExoPlayer.c) message.obj);
                    break;
                case 29:
                    L0();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    M1(pair.first, (cz) pair.second);
                    break;
                case 31:
                    n1((yb) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    O1(((Float) message.obj).floatValue());
                    break;
                case 33:
                    W(message.arg1);
                    break;
                case Token.GETPROPNOWARN /* 34 */:
                    X();
                    break;
                case 35:
                    K1((j25) message.obj);
                    break;
                case 36:
                    C1(((Boolean) message.obj).booleanValue());
                    break;
                case Token.SETPROP /* 37 */:
                    this.M = false;
                    C0020h c0020h = this.N;
                    if (c0020h != null) {
                        f1(c0020h);
                        this.N = null;
                    }
                    break;
                case Token.SETPROP_SUPER /* 38 */:
                    E1((fz3) message.obj);
                    break;
            }
        } catch (ga0 e2) {
            Z(e2, e2.f);
        } catch (RuntimeException e3) {
            zv0 zv0VarM = zv0.m(e3, ((e3 instanceof IllegalStateException) || (e3 instanceof IllegalArgumentException)) ? 1004 : 1000);
            xz1.e("ExoPlayerImplInternal", "Playback error", zv0VarM);
            X1(true, false);
            this.P = this.P.f(zv0VarM);
        } catch (oj e4) {
            Z(e4, 1002);
        } catch (po0.a e5) {
            Z(e5, e5.f);
        } catch (r83 e6) {
            int i3 = e6.g;
            if (i3 == 1) {
                i = e6.f ? 3001 : 3003;
            } else if (i3 == 4) {
                i = e6.f ? 3002 : 3004;
            }
            Z(e6, i);
        } catch (IOException e7) {
            Z(e7, 2000);
        } catch (zv0 e8) {
            e = e8;
            if (e.o == 1 && (kVarY = this.x.y()) != null && e.t == null) {
                e = e.j(kVarY.h.a);
            }
            if (e.o == 1 && (bVar = e.t) != null && l0(e.q, bVar)) {
                this.o0 = true;
                C();
                k kVarX = this.x.x();
                k kVarU = this.x.u();
                if (this.x.u() != kVarX) {
                    while (kVarU != null && kVarU.k() != kVarX) {
                        kVarU = kVarU.k();
                    }
                }
                this.x.N(kVarU);
                if (this.P.e != 4) {
                    o0();
                    this.m.h(2);
                }
            } else {
                zv0 zv0Var = this.i0;
                if (zv0Var != null) {
                    zv0Var.addSuppressed(e);
                    e = this.i0;
                }
                if (e.o == 1 && this.x.u() != this.x.y()) {
                    while (true) {
                        k kVarU2 = this.x.u();
                        k kVarY2 = this.x.y();
                        lVar = this.x;
                        if (kVarU2 == kVarY2) {
                            break;
                        }
                        lVar.b();
                    }
                    k kVar = (k) gg3.q(lVar.u());
                    r0();
                    ni2 ni2Var = kVar.h;
                    jq2.b bVar2 = ni2Var.a;
                    long j = ni2Var.b;
                    this.P = g0(bVar2, j, ni2Var.d, j, true, 0);
                }
                if (e.u && (this.i0 == null || (i = e.f) == 5004 || i == 5003)) {
                    xz1.j("ExoPlayerImplInternal", "Recoverable renderer error", e);
                    if (this.i0 == null) {
                        this.i0 = e;
                    }
                    mc1 mc1Var = this.m;
                    mc1Var.b(mc1Var.l(25, e));
                } else {
                    xz1.e("ExoPlayerImplInternal", "Playback error", e);
                    X1(true, false);
                    this.P = this.P.f(e);
                }
            }
        }
        r0();
        return true;
    }

    public final boolean i0() {
        if (this.C) {
            return true;
        }
        return this.L && this.J.g;
    }

    public final void i1(n nVar) {
        if (nVar.e() == -9223372036854775807L) {
            j1(nVar);
            return;
        }
        if (this.P.a.w()) {
            this.u.add(new d(nVar));
            return;
        }
        d dVar = new d(nVar);
        no4 no4Var = this.P.a;
        if (!X0(dVar, no4Var, no4Var, this.X, this.Y, this.p, this.q)) {
            nVar.j(false);
        } else {
            this.u.add(dVar);
            Collections.sort(this.u);
        }
    }

    public final void i2() {
        k kVarU = this.x.u();
        if (kVarU == null) {
            return;
        }
        long jQ = kVarU.f ? kVarU.a.q() : -9223372036854775807L;
        if (jQ != -9223372036854775807L) {
            if (!kVarU.s()) {
                this.x.N(kVarU);
                a0(false);
                o0();
            }
            V0(jQ, true);
            if (jQ != this.P.s) {
                bc3 bc3Var = this.P;
                long j = jQ;
                this.P = g0(bc3Var.b, j, bc3Var.c, j, true, 5);
            }
        } else {
            long jH = this.t.h(kVarU != this.x.y());
            this.e0 = jH;
            long jC = kVarU.C(jH);
            v0(this.P.s, jC);
            if (this.t.D()) {
                boolean z = !this.Q.d;
                bc3 bc3Var2 = this.P;
                this.P = g0(bc3Var2.b, jC, bc3Var2.c, jC, z, 6);
            } else {
                this.P.o(jC);
            }
        }
        this.P.q = this.x.n().j();
        this.P.r = U();
        bc3 bc3Var3 = this.P;
        if (bc3Var3.l && bc3Var3.e == 3 && U1(bc3Var3.a, bc3Var3.b) && this.P.o.a == 1.0f) {
            float fA = this.z.a(L(), this.P.r);
            if (this.t.getPlaybackParameters().a != fA) {
                p1(this.P.o.d(fA));
                e0(this.P.o, this.t.getPlaybackParameters().a, false, false);
            }
        }
    }

    public final void j1(n nVar) {
        if (nVar.b() != this.o) {
            this.m.l(15, nVar).a();
            return;
        }
        B(nVar);
        int i = this.P.e;
        if (i == 3 || i == 2) {
            this.m.h(2);
        }
    }

    public final void j2(no4 no4Var, jq2.b bVar, no4 no4Var2, jq2.b bVar2, long j, boolean z) {
        if (!U1(no4Var, bVar)) {
            dc3 dc3Var = bVar.c() ? dc3.d : this.P.o;
            if (this.t.getPlaybackParameters().equals(dc3Var)) {
                return;
            }
            p1(dc3Var);
            e0(this.P.o, dc3Var.a, false, false);
            return;
        }
        no4Var.t(no4Var.n(bVar.a, this.q).c, this.p);
        this.z.d((fg2.g) fy4.l(this.p.j));
        if (j != -9223372036854775807L) {
            this.z.e(O(no4Var, bVar.a, j));
            return;
        }
        if (!Objects.equals(!no4Var2.w() ? no4Var2.t(no4Var2.n(bVar2.a, this.q).c, this.p).a : null, this.p.a) || z) {
            this.z.e(-9223372036854775807L);
        }
    }

    public final boolean k0(k kVar) {
        return (kVar == null || kVar.r() || kVar.l() == Long.MIN_VALUE) ? false : true;
    }

    public final void k1(final n nVar) {
        Looper looperB = nVar.b();
        if (looperB.getThread().isAlive()) {
            this.v.c(looperB, null).d(new Runnable() { // from class: hy0
                @Override // java.lang.Runnable
                public final void run() {
                    h.n(this.f, nVar);
                }
            });
        } else {
            xz1.i("TAG", "Trying to send message on a dead thread.");
            nVar.j(false);
        }
    }

    public final boolean l0(int i, jq2.b bVar) {
        if (this.x.x() == null || !this.x.x().h.a.equals(bVar)) {
            return false;
        }
        return this.f[i].v(this.x.x());
    }

    public final void l1(long j) {
        for (kq3 kq3Var : this.f) {
            kq3Var.N(j);
        }
    }

    public final void l2(boolean z, boolean z2) {
        this.U = z;
        this.V = (!z || z2) ? -9223372036854775807L : this.v.e();
    }

    public final boolean m0() {
        k kVarU = this.x.u();
        long j = kVarU.h.f;
        if (kVarU.f) {
            return j == -9223372036854775807L || this.P.s < j || !R1();
        }
        return false;
    }

    public void m1(yb ybVar, boolean z) {
        this.m.i(31, z ? 1 : 0, 0, ybVar).a();
    }

    public final boolean m2() throws zv0 {
        h hVar;
        k kVarY = this.x.y();
        pr4 pr4VarP = kVarY.p();
        int i = 0;
        boolean z = true;
        int i2 = 0;
        while (true) {
            kq3[] kq3VarArr = this.f;
            if (i2 >= kq3VarArr.length) {
                break;
            }
            int iH = kq3VarArr[i2].h();
            int iJ = this.f[i2].J(kVarY, pr4VarP, this.t);
            if ((iJ & 2) != 0 && this.b0) {
                s1(false);
            }
            this.c0 -= iH - this.f[i2].h();
            z &= (iJ & 1) != 0;
            i2++;
        }
        if (z) {
            while (i < this.f.length) {
                if (!pr4VarP.c(i) || this.f[i].x(kVarY)) {
                    hVar = this;
                } else {
                    hVar = this;
                    hVar.G(kVarY, i, false, kVarY.n());
                }
                i++;
                this = hVar;
            }
        }
        return z;
    }

    public final void n1(yb ybVar, boolean z) {
        this.i.l(ybVar);
        nc ncVar = this.G;
        if (!z) {
            ybVar = null;
        }
        ncVar.k(ybVar);
        f2();
    }

    public final void n2(float f2) {
        for (k kVarU = this.x.u(); kVarU != null; kVarU = kVarU.k()) {
            for (jy0 jy0Var : kVarU.p().c) {
                if (jy0Var != null) {
                    jy0Var.o(f2);
                }
            }
        }
    }

    public final void o0() {
        boolean zQ1 = Q1();
        this.W = zQ1;
        if (zQ1) {
            k kVar = (k) gg3.q(this.x.n());
            kVar.e(new j.b().f(kVar.C(this.e0)).g(this.t.getPlaybackParameters().a).e(this.V).d());
        }
        Z1();
    }

    public final void o1(boolean z, cz czVar) {
        if (this.Z != z) {
            this.Z = z;
            if (!z) {
                for (kq3 kq3Var : this.f) {
                    kq3Var.L();
                }
            }
        }
        if (czVar != null) {
            czVar.f();
        }
    }

    @Override // androidx.media3.exoplayer.e.a
    public void onPlaybackParametersChanged(dc3 dc3Var) {
        this.m.l(16, dc3Var).a();
    }

    public final void p0() {
        this.x.I();
        k kVarW = this.x.w();
        if (kVarW != null) {
            if ((!kVarW.e || kVarW.f) && !kVarW.a.isLoading()) {
                if (this.k.b(this.B, this.P.a, kVarW.h.a, kVarW.f ? kVarW.a.f() : 0L)) {
                    if (kVarW.e) {
                        kVarW.e(new j.b().f(kVarW.C(this.e0)).g(this.t.getPlaybackParameters().a).e(this.V).d());
                    } else {
                        kVarW.v(this, kVarW.h.b);
                    }
                }
            }
        }
    }

    public final void p1(dc3 dc3Var) {
        this.m.k(16);
        this.t.setPlaybackParameters(dc3Var);
    }

    public final void q0() {
        for (kq3 kq3Var : this.f) {
            kq3Var.D();
        }
    }

    public final void q1(b bVar) throws Throwable {
        this.Q.b(1);
        if (bVar.c != -1) {
            this.d0 = new C0020h(new bf3(bVar.a, bVar.b), bVar.c, bVar.d);
        }
        c0(this.y.C(bVar.a, bVar.b), false);
    }

    public final void r0() {
        this.Q.c(this.P);
        if (this.Q.a) {
            this.w.a(this.Q);
            this.Q = new e(this.P);
        }
    }

    public void r1(List list, int i, long j, o64 o64Var) {
        this.m.l(17, new b(list, o64Var, i, j, null)).a();
    }

    public final void s0() throws zv0 {
        h hVar;
        k kVarX = this.x.x();
        if (kVarX == null) {
            return;
        }
        pr4 pr4VarP = kVarX.p();
        int i = 0;
        while (i < this.f.length) {
            if (pr4VarP.c(i) && this.f[i].s() && !this.f[i].u()) {
                this.f[i].X();
                hVar = this;
                hVar.G(kVarX, i, false, kVarX.n());
            } else {
                hVar = this;
            }
            i++;
            this = hVar;
        }
        h hVar2 = this;
        if (hVar2.y()) {
            hVar2.n0 = kVarX.a.q();
            if (kVarX.s()) {
                return;
            }
            hVar2.x.N(kVarX);
            hVar2.a0(false);
            hVar2.o0();
        }
    }

    public final void s1(boolean z) {
        if (z == this.b0) {
            return;
        }
        this.b0 = z;
        if (z || !this.P.p) {
            return;
        }
        this.m.h(2);
    }

    public final void t0(int i) {
        kq3 kq3Var = this.f[i];
        try {
            kq3Var.G((k) gg3.q(this.x.u()));
        } catch (IOException | RuntimeException e2) {
            int iM = kq3Var.m();
            if (iM != 3 && iM != 5) {
                throw e2;
            }
            pr4 pr4VarP = this.x.u().p();
            xz1.e("ExoPlayerImplInternal", "Disabling track due to error: " + t41.l(pr4VarP.c[i].l()), e2);
            pr4 pr4Var = new pr4((jq3[]) pr4VarP.b.clone(), (jy0[]) pr4VarP.c.clone(), pr4VarP.d, pr4VarP.e);
            pr4Var.b[i] = null;
            pr4Var.c[i] = null;
            D(i);
            this.x.u().a(pr4Var, this.P.s, false);
        }
    }

    public final void t1(boolean z) throws zv0 {
        this.S = z;
        U0();
        if (!this.T || this.x.y() == this.x.u()) {
            return;
        }
        e1(true);
        a0(false);
    }

    public final void u(b bVar, int i) throws Throwable {
        this.Q.b(1);
        m mVar = this.y;
        if (i == -1) {
            i = mVar.r();
        }
        c0(mVar.f(i, bVar.a, bVar.b), false);
    }

    public final void u0(final int i, final boolean z) {
        boolean[] zArr = this.h;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.E.d(new Runnable() { // from class: ey0
                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = this.f;
                    int i2 = i;
                    hVar.D.c0(i2, hVar.f[i2].m(), z);
                }
            });
        }
    }

    public void u1(boolean z, int i, int i2) {
        this.m.a(1, z ? 1 : 0, i | (i2 << 4)).a();
    }

    public void v(int i, List list, o64 o64Var) {
        this.m.i(18, i, 0, new b(list, o64Var, -1, -9223372036854775807L, null)).a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v0(long r9, long r11) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.v0(long, long):void");
    }

    public final void v1(boolean z, int i, boolean z2, int i2) {
        this.Q.b(z2 ? 1 : 0);
        g2(z, i, i2);
    }

    public final void w() {
        pr4 pr4VarP = this.x.u().p();
        for (int i = 0; i < this.f.length; i++) {
            if (pr4VarP.c(i)) {
                this.f[i].f();
            }
        }
    }

    public final boolean w0() {
        ni2 ni2VarT;
        this.x.K(this.e0);
        boolean z = false;
        if (this.x.T() && (ni2VarT = this.x.t(this.e0, this.P)) != null) {
            k kVarH = this.x.h(ni2VarT);
            if (!kVarH.e) {
                kVarH.v(this, ni2VarT.b);
            } else if (kVarH.f) {
                this.m.l(8, kVarH.a).a();
            }
            if (this.x.u() == kVarH) {
                V0(ni2VarT.b, true);
            }
            a0(false);
            z = true;
        }
        if (!this.W) {
            o0();
            return z;
        }
        this.W = k0(this.x.n());
        Z1();
        return z;
    }

    public void w1(dc3 dc3Var) {
        this.m.l(4, dc3Var).a();
    }

    public final void x() {
        for (kq3 kq3Var : this.f) {
            kq3Var.R(this.L ? this.J : null);
        }
    }

    public final void x0() {
        k kVarU;
        boolean z;
        if (this.x.u() == this.x.y() && (kVarU = this.x.u()) != null) {
            pr4 pr4VarP = kVarU.p();
            boolean z2 = false;
            int i = 0;
            boolean z3 = false;
            while (true) {
                if (i >= this.f.length) {
                    z = true;
                    break;
                }
                if (pr4VarP.c(i)) {
                    if (this.f[i].m() != 1) {
                        z = false;
                        break;
                    } else if (pr4VarP.b[i].a != 0) {
                        z3 = true;
                    }
                }
                i++;
            }
            if (z3 && z) {
                z2 = true;
            }
            s1(z2);
        }
    }

    public final void x1(dc3 dc3Var) {
        p1(dc3Var);
        f0(this.t.getPlaybackParameters(), true);
    }

    public final boolean y() {
        if (!this.F) {
            return false;
        }
        for (kq3 kq3Var : this.f) {
            if (kq3Var.u()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y0() {
        /*
            r15 = this;
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r15.P1()
            if (r2 == 0) goto L82
            if (r1 == 0) goto Ld
            r15.r0()
        Ld:
            r15.o0 = r0
            androidx.media3.exoplayer.l r1 = r15.x
            androidx.media3.exoplayer.k r1 = r1.b()
            java.lang.Object r1 = defpackage.gg3.q(r1)
            androidx.media3.exoplayer.k r1 = (androidx.media3.exoplayer.k) r1
            bc3 r2 = r15.P
            jq2$b r2 = r2.b
            java.lang.Object r2 = r2.a
            ni2 r3 = r1.h
            jq2$b r3 = r3.a
            java.lang.Object r3 = r3.a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L47
            bc3 r2 = r15.P
            jq2$b r2 = r2.b
            int r4 = r2.b
            r5 = -1
            if (r4 != r5) goto L47
            ni2 r4 = r1.h
            jq2$b r4 = r4.a
            int r6 = r4.b
            if (r6 != r5) goto L47
            int r2 = r2.e
            int r4 = r4.e
            if (r2 == r4) goto L47
            r2 = r3
            goto L48
        L47:
            r2 = r0
        L48:
            ni2 r4 = r1.h
            jq2$b r6 = r4.a
            long r7 = r4.b
            long r9 = r4.d
            r13 = r2 ^ 1
            r14 = 0
            r11 = r7
            r5 = r15
            bc3 r15 = r5.g0(r6, r7, r9, r11, r13, r14)
            r5.P = r15
            r5.U0()
            r5.i2()
            boolean r15 = r5.y()
            if (r15 == 0) goto L72
            androidx.media3.exoplayer.l r15 = r5.x
            androidx.media3.exoplayer.k r15 = r15.x()
            if (r1 != r15) goto L72
            r5.q0()
        L72:
            bc3 r15 = r5.P
            int r15 = r15.e
            r1 = 3
            if (r15 != r1) goto L7c
            r5.V1()
        L7c:
            r5.w()
            r1 = r3
            r15 = r5
            goto L2
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.h.y0():void");
    }

    public final void y1(ExoPlayer.c cVar) {
        this.l0 = cVar;
        this.x.W(this.P.a, cVar);
    }

    public final void z() throws zv0 {
        S0();
    }

    public final void z0(boolean z) {
        if (this.l0.a == -9223372036854775807L) {
            return;
        }
        if (z || !this.P.a.equals(this.m0)) {
            no4 no4Var = this.P.a;
            this.m0 = no4Var;
            this.x.B(no4Var);
        }
        p0();
    }

    public void z1(int i) {
        this.m.a(11, i, 0).a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final List a;
        public final o64 b;
        public final int c;
        public final long d;

        public b(List list, o64 o64Var, int i, long j) {
            this.a = list;
            this.b = o64Var;
            this.c = i;
            this.d = j;
        }

        public /* synthetic */ b(List list, o64 o64Var, int i, long j, a aVar) {
            this(list, o64Var, i, j);
        }
    }
}
