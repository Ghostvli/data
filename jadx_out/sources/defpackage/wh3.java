package defpackage;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.ex3;
import defpackage.gr4;
import defpackage.ja0;
import defpackage.mi2;
import defpackage.rq2;
import defpackage.sh1;
import defpackage.sy1;
import defpackage.t41;
import defpackage.wo0;
import defpackage.xy1;
import defpackage.yz3;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wh3 implements mi2, mz0, xy1.b, xy1.f, ex3.d {
    public static final Map Z = N();
    public static final t41 a0 = new t41.b().k0("icy").A0("application/x-icy").Q();
    public uh1 A;
    public b[] B;
    public ex3[] C;
    public f[] D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public g I;
    public yz3 J;
    public long K;
    public boolean L;
    public int M;
    public long N = Long.MIN_VALUE;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public long T;
    public long U;
    public boolean V;
    public int W;
    public boolean X;
    public boolean Y;
    public final Uri f;
    public final aa0 g;
    public final xo0 h;
    public final sy1 i;
    public final rq2.a j;
    public final wo0.a k;
    public final d l;
    public final j5 m;
    public final String n;
    public final long o;
    public final boolean p;
    public final int q;
    public final t41 r;
    public final long s;
    public final xy1 t;
    public final rh3 u;
    public final cz v;
    public final Runnable w;
    public final Runnable x;
    public final Handler y;
    public mi2.a z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends h51 {
        public a(yz3 yz3Var) {
            super(yz3Var);
        }

        @Override // defpackage.h51, defpackage.yz3
        public long i() {
            return wh3.this.K;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends j51 {
        public final ex3 b;
        public final wl0 c;
        public final AtomicReference d;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum a {
            PASS_THROUGH,
            DISCARD_AFTER_NEXT_SAMPLE_METADATA,
            DISCARDING
        }

        public b(ex3 ex3Var) {
            super(ex3Var);
            this.b = ex3Var;
            this.c = new wl0();
            this.d = new AtomicReference(a.PASS_THROUGH);
        }

        @Override // defpackage.gr4
        public void a(r73 r73Var, int i) {
            h().a(r73Var, i);
        }

        @Override // defpackage.gr4
        public void b(long j, int i, int i2, int i3, gr4.a aVar) {
            h().b(j, i, i2, i3, aVar);
            if (this.d.get() == a.DISCARD_AFTER_NEXT_SAMPLE_METADATA) {
                this.b.Z();
                this.d.set(a.DISCARDING);
            }
        }

        @Override // defpackage.gr4
        public void c(r73 r73Var, int i, int i2) {
            h().c(r73Var, i, i2);
        }

        @Override // defpackage.gr4
        public int d(x90 x90Var, int i, boolean z) {
            return h().d(x90Var, i, z);
        }

        @Override // defpackage.gr4
        public int f(x90 x90Var, int i, boolean z, int i2) {
            return h().f(x90Var, i, z, i2);
        }

        public final gr4 h() {
            return this.d.get() == a.DISCARDING ? this.c : this.b;
        }

        public boolean i() {
            return this.d.get() == a.PASS_THROUGH;
        }

        public void j(boolean z) {
            this.d.set(z ? a.PASS_THROUGH : a.DISCARD_AFTER_NEXT_SAMPLE_METADATA);
            if (z) {
                return;
            }
            this.b.t();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements xy1.e, sh1.a {
        public final Uri b;
        public final ne4 c;
        public final rh3 d;
        public final mz0 e;
        public final cz f;
        public volatile boolean h;
        public long j;
        public gr4 l;
        public boolean m;
        public final yf3 g = new yf3();
        public boolean i = true;
        public final long a = ty1.b();
        public ja0 k = i(0, null);

        public c(Uri uri, aa0 aa0Var, rh3 rh3Var, mz0 mz0Var, cz czVar) {
            this.b = uri;
            this.c = new ne4(aa0Var);
            this.d = rh3Var;
            this.e = mz0Var;
            this.f = czVar;
        }

        @Override // sh1.a
        public void a(r73 r73Var) {
            long jMax = !this.m ? this.j : Math.max(wh3.this.P(true), this.j);
            int iA = r73Var.a();
            gr4 gr4Var = (gr4) gg3.q(this.l);
            gr4Var.a(r73Var, iA);
            gr4Var.b(jMax, 1, iA, 0, null);
            this.m = true;
        }

        @Override // xy1.e
        public void b() {
            int iE = 0;
            String str = null;
            while (iE == 0 && !this.h) {
                try {
                    long j = this.g.a;
                    ja0 ja0VarI = i(j, str);
                    this.k = ja0VarI;
                    long jA = this.c.a(ja0VarI);
                    if (this.h) {
                        if (iE != 1 && this.d.b() != -1) {
                            this.g.a = this.d.b();
                        }
                        ia0.a(this.c);
                        return;
                    }
                    List list = (List) this.c.o().get("ETag");
                    str = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                    if (jA != -1) {
                        jA += j;
                        wh3.this.a0();
                    }
                    long j2 = jA;
                    wh3.this.A = uh1.d(this.c.o());
                    x90 sh1Var = this.c;
                    if (wh3.this.A != null && wh3.this.A.f != -1) {
                        sh1Var = new sh1(this.c, wh3.this.A.f, this);
                        gr4 gr4VarS = wh3.this.S();
                        this.l = gr4VarS;
                        gr4VarS.g(wh3.a0);
                    }
                    this.d.d(sh1Var, this.b, this.c.o(), j, j2, this.e);
                    if (wh3.this.A != null) {
                        this.d.c();
                    }
                    if (this.i) {
                        this.d.a(j, this.j);
                        this.i = false;
                    }
                    while (iE == 0 && !this.h) {
                        try {
                            this.f.a();
                            iE = this.d.e(this.g);
                            long jB = this.d.b();
                            if (jB > wh3.this.o + j) {
                                this.f.d();
                                wh3.this.y.post(wh3.this.x);
                                j = jB;
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    if (iE == 1) {
                        iE = 0;
                    } else if (this.d.b() != -1) {
                        this.g.a = this.d.b();
                    }
                    ia0.a(this.c);
                } catch (Throwable th) {
                    if (iE != 1 && this.d.b() != -1) {
                        this.g.a = this.d.b();
                    }
                    ia0.a(this.c);
                    throw th;
                }
            }
        }

        @Override // xy1.e
        public void c() {
            this.h = true;
        }

        public final ja0 i(long j, String str) {
            Map mapC = wh3.Z;
            if (str != null && !str.startsWith("W/")) {
                mapC = zi1.a().j(mapC).g("If-Range", str).c();
            }
            return new ja0.b().i(this.b).h(j).f(wh3.this.n).b(6).e(mapC).a();
        }

        public final void j(long j, long j2) {
            this.g.a = j;
            this.j = j2;
            this.i = true;
            this.m = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void r(long j, yz3 yz3Var, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e implements gx3 {
        public final int f;

        public e(int i) {
            this.f = i;
        }

        @Override // defpackage.gx3
        public void a() throws IOException {
            wh3.this.Z(this.f);
        }

        @Override // defpackage.gx3
        public int e(long j) {
            return wh3.this.k0(this.f, j);
        }

        @Override // defpackage.gx3
        public boolean isReady() {
            return wh3.this.U(this.f);
        }

        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return wh3.this.g0(this.f, u41Var, decoderInputBuffer, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public final int a;
        public final boolean b;

        public f(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && f.class == obj.getClass()) {
                f fVar = (f) obj;
                if (this.a == fVar.a && this.b == fVar.b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31) + (this.b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final er4 a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;

        public g(er4 er4Var, boolean[] zArr) {
            this.a = er4Var;
            this.b = zArr;
            int i = er4Var.a;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    public wh3(Uri uri, aa0 aa0Var, rh3 rh3Var, xo0 xo0Var, wo0.a aVar, sy1 sy1Var, rq2.a aVar2, d dVar, j5 j5Var, String str, int i, boolean z, int i2, t41 t41Var, long j, eq3 eq3Var) {
        this.f = uri;
        this.g = aa0Var;
        this.h = xo0Var;
        this.k = aVar;
        this.i = sy1Var;
        this.j = aVar2;
        this.l = dVar;
        this.m = j5Var;
        this.n = str;
        this.o = i;
        this.p = z;
        this.q = i2;
        this.r = t41Var;
        this.t = eq3Var != null ? new xy1(eq3Var) : new xy1("ProgressiveMediaPeriod");
        this.u = rh3Var;
        this.s = j;
        this.v = new cz();
        this.w = new Runnable() { // from class: th3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f.V();
            }
        };
        this.x = new Runnable() { // from class: uh3
            @Override // java.lang.Runnable
            public final void run() {
                wh3.y(this.f);
            }
        };
        this.y = fy4.E();
        this.D = new f[0];
        this.C = new ex3[0];
        this.B = new b[0];
        this.U = -9223372036854775807L;
        this.M = 1;
    }

    public static Map N() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    public static int Q(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 2) {
            return 4;
        }
        if (i != 3) {
            return i != 4 ? 0 : 2;
        }
        return 1;
    }

    private boolean R() {
        int i = 0;
        if (this.N == Long.MIN_VALUE) {
            return false;
        }
        L();
        boolean zM = true;
        while (true) {
            ex3[] ex3VarArr = this.C;
            if (i >= ex3VarArr.length) {
                return zM;
            }
            g gVar = this.I;
            if (gVar.c[i] && (gVar.b[i] || !this.G)) {
                zM &= ex3VarArr[i].M();
            }
            i++;
        }
    }

    private boolean T() {
        return this.U != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() throws Throwable {
        if (this.Y || this.F || !this.E || this.J == null) {
            return;
        }
        for (ex3 ex3Var : this.C) {
            if (ex3Var.J() == null) {
                return;
            }
        }
        this.v.d();
        int length = this.C.length;
        int i = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int iK = nt2.k(((t41) gg3.q(this.C[i3].J())).p);
            if (Q(iK) > Q(i)) {
                i2 = i3;
                i = iK;
            }
        }
        br4[] br4VarArr = new br4[length];
        boolean[] zArr = new boolean[length];
        for (int i4 = 0; i4 < length; i4++) {
            t41 t41VarQ = (t41) gg3.q(this.C[i4].J());
            String str = t41VarQ.p;
            boolean zO = nt2.o(str);
            boolean z = zO || nt2.t(str);
            zArr[i4] = z;
            this.G = z | this.G;
            this.H = this.s != -9223372036854775807L && length == 1 && nt2.q(str);
            uh1 uh1Var = this.A;
            if (uh1Var != null) {
                if (zO || this.D[i4].b) {
                    xs2 xs2Var = t41VarQ.l;
                    t41VarQ = t41VarQ.b().s0(xs2Var == null ? new xs2(uh1Var) : xs2Var.a(uh1Var)).Q();
                }
                if (zO && t41VarQ.h == -1 && t41VarQ.i == -1 && uh1Var.a != -1) {
                    t41VarQ = t41VarQ.b().T(uh1Var.a).Q();
                }
            }
            t41 t41VarC = t41VarQ.c(this.h.d(t41VarQ));
            if (i4 != i2) {
                t41VarC = t41VarC.b().w0(Integer.toString(i2)).Q();
            }
            br4VarArr[i4] = new br4(Integer.toString(i4), t41VarC);
            this.Q = t41VarC.v | this.Q;
            this.C[i4].e0(this.N);
        }
        this.I = new g(new er4(br4VarArr), zArr);
        if (this.H && this.K == -9223372036854775807L) {
            this.K = this.s;
            this.J = new a(this.J);
        }
        this.l.r(this.K, this.J, this.L);
        this.F = true;
        ((mi2.a) gg3.q(this.z)).e(this);
    }

    public static /* synthetic */ void y(wh3 wh3Var) {
        if (wh3Var.Y) {
            return;
        }
        ((mi2.a) gg3.q(wh3Var.z)).j(wh3Var);
    }

    public final void L() {
        gg3.v(this.F);
        gg3.q(this.I);
        gg3.q(this.J);
    }

    public final boolean M(c cVar, int i) {
        yz3 yz3Var;
        if (this.S || !((yz3Var = this.J) == null || yz3Var.i() == -9223372036854775807L)) {
            this.W = i;
            return true;
        }
        if (this.F && !m0()) {
            this.V = true;
            return false;
        }
        this.P = this.F;
        this.T = 0L;
        this.W = 0;
        for (ex3 ex3Var : this.C) {
            ex3Var.Z();
        }
        cVar.j(0L, 0L);
        return true;
    }

    public final int O() {
        int iK = 0;
        for (ex3 ex3Var : this.C) {
            iK += ex3Var.K();
        }
        return iK;
    }

    public final long P(boolean z) {
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.C.length; i++) {
            if (z || ((g) gg3.q(this.I)).c[i]) {
                jMax = Math.max(jMax, this.C[i].D());
            }
        }
        return jMax;
    }

    public gr4 S() {
        return f0(new f(0, true));
    }

    public boolean U(int i) {
        return !m0() && this.C[i].P(this.X);
    }

    public final void W(int i) {
        L();
        g gVar = this.I;
        boolean[] zArr = gVar.d;
        if (zArr[i]) {
            return;
        }
        t41 t41VarC = gVar.a.b(i).c(0);
        this.j.j(nt2.k(t41VarC.p), t41VarC, 0, null, this.T);
        zArr[i] = true;
    }

    public final void X(int i) {
        L();
        if (this.V) {
            if (!this.G || this.I.b[i]) {
                if (this.C[i].P(false)) {
                    return;
                }
                this.U = 0L;
                this.V = false;
                this.P = true;
                this.T = 0L;
                this.W = 0;
                for (ex3 ex3Var : this.C) {
                    ex3Var.Z();
                }
                ((mi2.a) gg3.q(this.z)).j(this);
            }
        }
    }

    public void Y() throws IOException {
        this.t.k(this.i.d(this.M));
    }

    public void Z(int i) throws IOException {
        this.C[i].R();
        Y();
    }

    public final void a0() {
        this.y.post(new Runnable() { // from class: sh3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.S = true;
            }
        });
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        if (this.X || this.t.i() || this.V) {
            return false;
        }
        if ((this.F || this.r != null) && this.R == 0) {
            return false;
        }
        boolean zF = this.v.f();
        if (this.t.j()) {
            return zF;
        }
        l0();
        return true;
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void j(c cVar, long j, long j2, boolean z) {
        ne4 ne4Var = cVar.c;
        ty1 ty1Var = new ty1(cVar.a, cVar.k, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h());
        this.i.c(cVar.a);
        this.j.m(ty1Var, 1, -1, null, 0, null, cVar.j, this.K);
        if (z) {
            return;
        }
        for (ex3 ex3Var : this.C) {
            ex3Var.Z();
        }
        if (this.R > 0) {
            ((mi2.a) gg3.q(this.z)).j(this);
        }
    }

    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return f();
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void l(c cVar, long j, long j2) {
        if (this.K == -9223372036854775807L && this.J != null) {
            long jP = P(true);
            long j3 = jP == Long.MIN_VALUE ? 0L : jP + 10000;
            this.K = j3;
            this.l.r(j3, this.J, this.L);
        }
        ne4 ne4Var = cVar.c;
        ty1 ty1Var = new ty1(cVar.a, cVar.k, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h());
        this.i.c(cVar.a);
        this.j.p(ty1Var, 1, -1, null, 0, null, cVar.j, this.K);
        this.X = true;
        ((mi2.a) gg3.q(this.z)).j(this);
    }

    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        L();
        if (!this.J.e()) {
            return 0L;
        }
        yz3.a aVarG = this.J.g(j);
        return zz3Var.a(j, aVarG.a.a, aVarG.b.a);
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public xy1.c v(c cVar, long j, long j2, IOException iOException, int i) {
        c cVar2;
        xy1.c cVarH;
        ne4 ne4Var = cVar.c;
        ty1 ty1Var = new ty1(cVar.a, cVar.k, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h());
        long jA = this.i.a(new sy1.c(ty1Var, new oh2(1, -1, null, 0, null, fy4.S1(cVar.j), fy4.S1(this.K)), iOException, i));
        if (jA == -9223372036854775807L) {
            cVarH = xy1.g;
            cVar2 = cVar;
        } else {
            int iO = O();
            cVar2 = cVar;
            cVarH = M(cVar2, iO) ? xy1.h(iO > this.W, jA) : xy1.f;
        }
        boolean zC = cVarH.c();
        this.j.r(ty1Var, 1, -1, null, 0, null, cVar2.j, this.K, iOException, !zC);
        if (!zC) {
            this.i.c(cVar2.a);
        }
        return cVarH;
    }

    @Override // defpackage.mz0
    public gr4 e(int i, int i2) {
        return f0(new f(i, false));
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void p(c cVar, long j, long j2, int i) {
        ne4 ne4Var = cVar.c;
        this.j.v(i == 0 ? new ty1(cVar.a, cVar.k, j) : new ty1(cVar.a, cVar.k, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h()), 1, -1, null, 0, null, cVar.j, this.K, i);
    }

    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        long jP;
        L();
        if (this.X || this.R == 0) {
            return Long.MIN_VALUE;
        }
        if (T()) {
            return this.U;
        }
        if (this.G) {
            int length = this.C.length;
            jP = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                g gVar = this.I;
                if (gVar.b[i] && gVar.c[i] && !this.C[i].O()) {
                    jP = Math.min(jP, this.C[i].D());
                }
            }
        } else {
            jP = Long.MAX_VALUE;
        }
        if (jP == Long.MAX_VALUE) {
            jP = P(false);
        }
        return jP == Long.MIN_VALUE ? this.T : jP;
    }

    public final gr4 f0(f fVar) {
        int length = this.C.length;
        for (int i = 0; i < length; i++) {
            if (fVar.equals(this.D[i])) {
                return this.C[i];
            }
        }
        if (this.E) {
            xz1.i("ProgressiveMediaPeriod", "Extractor added new track (id=" + fVar.a + ") after finishing tracks.");
            return new wl0();
        }
        ex3 ex3VarM = ex3.m(this.m, this.h, this.k);
        b bVar = new b(ex3VarM);
        ex3VarM.i0(this);
        int i2 = length + 1;
        f[] fVarArr = (f[]) Arrays.copyOf(this.D, i2);
        fVarArr[length] = fVar;
        this.D = (f[]) fy4.m(fVarArr);
        ex3[] ex3VarArr = (ex3[]) Arrays.copyOf(this.C, i2);
        ex3VarArr[length] = ex3VarM;
        this.C = (ex3[]) fy4.m(ex3VarArr);
        b[] bVarArr = (b[]) Arrays.copyOf(this.B, i2);
        bVarArr[length] = bVar;
        this.B = (b[]) fy4.m(bVarArr);
        return bVar;
    }

    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        if (this.R <= 0 || T() || !R()) {
            return;
        }
        this.X = true;
    }

    public int g0(int i, u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (m0()) {
            return -3;
        }
        W(i);
        int iW = this.C[i].W(u41Var, decoderInputBuffer, i2, this.X);
        if (iW == -3) {
            X(i);
        }
        return iW;
    }

    @Override // defpackage.mi2
    public long h(long j) throws Throwable {
        this.N = j;
        for (ex3 ex3Var : this.C) {
            ex3Var.e0(j);
        }
        return j;
    }

    public void h0() {
        if (this.F) {
            for (ex3 ex3Var : this.C) {
                ex3Var.V();
            }
        }
        this.t.m(this);
        this.y.removeCallbacksAndMessages(null);
        this.z = null;
        this.Y = true;
    }

    @Override // xy1.f
    public void i() {
        for (ex3 ex3Var : this.C) {
            ex3Var.X();
        }
        this.u.release();
    }

    public final boolean i0(boolean[] zArr, long j, boolean z) {
        int length = this.C.length;
        for (int i = 0; i < length; i++) {
            ex3 ex3Var = this.C[i];
            if (this.B[i].i() && (ex3Var.G() != 0 || !z)) {
                if (!(this.H ? ex3Var.c0(ex3Var.B()) : ex3Var.d0(j, this.X)) && (zArr[i] || !this.G)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return !this.X && this.t.j() && this.v.e();
    }

    public final void j0(yz3 yz3Var) throws Throwable {
        this.J = this.A == null ? yz3Var : new yz3.b(-9223372036854775807L);
        this.K = yz3Var.i();
        boolean z = !this.S && yz3Var.i() == -9223372036854775807L;
        this.L = z;
        this.M = z ? 7 : 1;
        if (this.F) {
            this.l.r(this.K, yz3Var, z);
        } else {
            V();
        }
    }

    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        jy0 jy0Var;
        L();
        g gVar = this.I;
        er4 er4Var = gVar.a;
        boolean[] zArr3 = gVar.c;
        int i = this.R;
        int i2 = 0;
        for (int i3 = 0; i3 < jy0VarArr.length; i3++) {
            gx3 gx3Var = gx3VarArr[i3];
            if (gx3Var != null && (jy0VarArr[i3] == null || !zArr[i3])) {
                int i4 = ((e) gx3Var).f;
                gg3.v(zArr3[i4]);
                this.R--;
                zArr3[i4] = false;
                gx3VarArr[i3] = null;
            }
        }
        boolean z = !this.O ? j == 0 || this.H : i != 0;
        for (int i5 = 0; i5 < jy0VarArr.length; i5++) {
            if (gx3VarArr[i5] == null && (jy0Var = jy0VarArr[i5]) != null) {
                gg3.v(jy0Var.length() == 1);
                gg3.v(jy0Var.i(0) == 0);
                int iD = er4Var.d(jy0Var.c());
                gg3.v(!zArr3[iD]);
                this.R++;
                zArr3[iD] = true;
                this.Q = jy0Var.l().v | this.Q;
                gx3VarArr[i5] = new e(iD);
                zArr2[i5] = true;
                if (this.p) {
                    z |= this.O;
                } else if (!z) {
                    ex3 ex3Var = this.C[iD];
                    z = (ex3Var.G() == 0 || ex3Var.d0(j, true)) ? false : true;
                }
            }
        }
        if (this.p) {
            int i6 = 0;
            while (true) {
                b[] bVarArr = this.B;
                if (i6 >= bVarArr.length) {
                    break;
                }
                bVarArr[i6].j(zArr3[i6]);
                i6++;
            }
        }
        if (this.R == 0) {
            this.V = false;
            this.P = false;
            this.Q = false;
            if (this.t.j()) {
                ex3[] ex3VarArr = this.C;
                int length = ex3VarArr.length;
                while (i2 < length) {
                    ex3VarArr[i2].t();
                    i2++;
                }
                this.t.f();
            } else {
                this.X = false;
                ex3[] ex3VarArr2 = this.C;
                int length2 = ex3VarArr2.length;
                while (i2 < length2) {
                    ex3VarArr2[i2].Z();
                    i2++;
                }
            }
        } else if (z) {
            j = n(j);
            while (i2 < gx3VarArr.length) {
                if (gx3VarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.O = true;
        return j;
    }

    public int k0(int i, long j) throws Throwable {
        if (m0()) {
            return 0;
        }
        W(i);
        ex3 ex3Var = this.C[i];
        int I = ex3Var.I(j, this.X);
        ex3Var.j0(I);
        if (I == 0) {
            X(i);
        }
        return I;
    }

    public final void l0() {
        c cVar = new c(this.f, this.g, this.u, this, this.v);
        if (this.F) {
            gg3.v(T());
            long j = this.N;
            if (j == Long.MIN_VALUE) {
                j = this.K;
            }
            if (j != -9223372036854775807L && this.U > j) {
                this.X = true;
                this.U = -9223372036854775807L;
                return;
            }
            cVar.j(((yz3) gg3.q(this.J)).g(this.U).a.b, this.U);
            for (ex3 ex3Var : this.C) {
                ex3Var.g0(this.U);
            }
            this.U = -9223372036854775807L;
        }
        this.W = O();
        this.t.n(cVar, this, this.i.d(this.M));
    }

    @Override // defpackage.mi2
    public void m() throws IOException {
        Y();
        if (this.X && !this.F) {
            throw r83.a("Loading finished before preparation is complete.", null);
        }
    }

    public final boolean m0() {
        return this.P || T();
    }

    @Override // defpackage.mi2
    public long n(long j) {
        L();
        boolean[] zArr = this.I.b;
        if (!this.J.e()) {
            j = 0;
        }
        int i = 0;
        this.P = false;
        boolean z = this.T == j;
        this.T = j;
        if (T()) {
            this.U = j;
            return j;
        }
        if (this.M == 7 || ((!this.X && !this.t.j()) || !i0(zArr, j, z))) {
            this.V = false;
            this.U = j;
            this.X = false;
            this.Q = false;
            if (this.t.j()) {
                ex3[] ex3VarArr = this.C;
                int length = ex3VarArr.length;
                while (i < length) {
                    ex3VarArr[i].t();
                    i++;
                }
                this.t.f();
                return j;
            }
            this.t.g();
            ex3[] ex3VarArr2 = this.C;
            int length2 = ex3VarArr2.length;
            while (i < length2) {
                ex3VarArr2[i].Z();
                i++;
            }
        }
        return j;
    }

    @Override // defpackage.mz0
    public void o() {
        this.E = true;
        this.y.post(this.w);
    }

    @Override // defpackage.mi2
    public long q() {
        if (this.Q) {
            this.Q = false;
            return this.T;
        }
        if (!this.P) {
            return -9223372036854775807L;
        }
        if (!this.X && O() <= this.W) {
            return -9223372036854775807L;
        }
        this.P = false;
        return this.T;
    }

    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) throws Throwable {
        this.z = aVar;
        if (this.r == null) {
            this.v.f();
            l0();
        } else {
            e(this.q, 3).g(this.r);
            j0(new mj1(new long[]{0}, new long[]{0}, -9223372036854775807L));
            o();
            this.U = j;
        }
    }

    @Override // defpackage.mi2
    public er4 s() {
        L();
        return this.I.a;
    }

    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        if (this.H) {
            return;
        }
        L();
        if (T()) {
            return;
        }
        boolean[] zArr = this.I.c;
        int length = this.C.length;
        for (int i = 0; i < length; i++) {
            this.C[i].s(j, z, zArr[i]);
        }
    }

    @Override // defpackage.mz0
    public void u(final yz3 yz3Var) {
        this.y.post(new Runnable() { // from class: vh3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f.j0(yz3Var);
            }
        });
    }

    @Override // ex3.d
    public void w(t41 t41Var) {
        this.y.post(this.w);
    }
}
