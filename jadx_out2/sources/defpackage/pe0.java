package defpackage;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.exoplayer.ExoPlayer;
import defpackage.he;
import defpackage.pd;
import defpackage.qe0;
import defpackage.uc;
import defpackage.vc;
import defpackage.wc;
import defpackage.xi1;
import defpackage.yc;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pe0 implements pd {
    public static final AtomicInteger f0 = new AtomicInteger();
    public dc3 A;
    public boolean B;
    public long C;
    public long D;
    public long E;
    public long F;
    public int G;
    public boolean H;
    public boolean I;
    public long J;
    public float K;
    public ByteBuffer L;
    public int M;
    public ByteBuffer N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public int T;
    public boolean U;
    public af V;
    public AudioDeviceInfo W;
    public int X;
    public boolean Y;
    public long Z;
    public final Context a;
    public boolean a0;
    public final zc b;
    public boolean b0;
    public final boolean c;
    public long c0;
    public final ds d;
    public long d0;
    public final ot4 e;
    public Handler e0;
    public final gp4 f;
    public final fp4 g;
    public final xi1 h;
    public final ArrayDeque i;
    public final boolean j;
    public int k;
    public c l;
    public final j m;
    public final j n;
    public final ExoPlayer.a o;
    public ie3 p;
    public pd.d q;
    public g r;
    public g s;
    public xc t;
    public wc u;
    public wc.f v;
    public vc w;
    public yb x;
    public i y;
    public i z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        uc a(t41 t41Var, yb ybVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements vc.a {
        public final wc.g a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(wc.g gVar) {
            this.a = gVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vc.a
        public void a(long j) {
            if (this == pe0.this.l && pe0.this.q != null) {
                pe0.this.q.a(j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vc.a
        public void b() {
            if (this == pe0.this.l && pe0.this.q != null && pe0.this.R) {
                pe0.this.q.j();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vc.a
        public void c() {
            if (this == pe0.this.l && pe0.this.P) {
                pe0.this.Q = true;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vc.a
        public void d() {
            pe0.f0.getAndDecrement();
            if (pe0.this.q != null) {
                pd.d dVar = pe0.this.q;
                wc.g gVar = this.a;
                dVar.b(new pd.a(gVar.a, gVar.b, gVar.c, gVar.d, gVar.e, gVar.f));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vc.a
        public void e() {
            if (this == pe0.this.l && pe0.this.q != null) {
                pe0.this.q.g(pe0.this.s.e.f, fy4.S1(pe0.this.s.d != -1 ? fy4.t1(pe0.this.s.e.f / pe0.this.s.d, ((vc) gg3.q(pe0.this.w)).j()) : -9223372036854775807L), SystemClock.elapsedRealtime() - pe0.this.Z);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        public static final d a = new qe0.a().h();

        int a(int i, int i2, int i3, int i4, int i5, int i6, double d);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public final Context a;
        public ec b = ec.g;
        public zc c;
        public boolean d;
        public boolean e;
        public boolean f;
        public d g;
        public wc h;
        public b i;
        public ExoPlayer.a j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public pe0 g() {
            gg3.v(!this.f);
            this.f = true;
            if (this.c == null) {
                this.c = new h(new yc[0]);
            }
            wc wcVar = this.h;
            b bVar = this.i;
            if (wcVar == null) {
                if (bVar == null) {
                    this.i = new me0(this.a);
                }
                if (this.g == null) {
                    this.g = d.a;
                }
                this.h = new he.b(this.a).i(this.a != null ? null : this.b).j(this.i).k(this.g).l(null).h();
            } else {
                gg3.v(bVar == null);
                gg3.v(this.g == null);
                gg3.v(true);
            }
            return new pe0(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f h(boolean z) {
            this.e = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f i(boolean z) {
            this.d = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final t41 a;
        public final t41 b;
        public final int c;
        public final int d;
        public final wc.g e;
        public final xc f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(t41 t41Var, t41 t41Var2, int i, int i2, wc.g gVar, xc xcVar) {
            this.a = t41Var;
            this.b = t41Var2;
            this.c = i;
            this.d = i2;
            this.e = gVar;
            this.f = xcVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final pd.a l() {
            wc.g gVar = this.e;
            return new pd.a(gVar.a, gVar.b, gVar.c, gVar.d, gVar.e, gVar.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final g m(wc.g gVar) {
            return new g(this.a, this.b, this.c, this.d, gVar, this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long n(long j) {
            return fy4.t1(j, this.e.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long o(long j) {
            return fy4.t1(j, this.a.I);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean p() {
            return Objects.equals(this.a.p, "audio/raw");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i {
        public final dc3 a;
        public final long b;
        public final long c;
        public long d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(dc3 dc3Var, long j, long j2) {
            this.a = dc3Var;
            this.b = j;
            this.c = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j {
        public Exception a;
        public long b = -9223372036854775807L;
        public long c = -9223372036854775807L;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a = null;
            this.b = -9223372036854775807L;
            this.c = -9223372036854775807L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b() {
            if (this.a == null) {
                return false;
            }
            return pe0.c0() || SystemClock.elapsedRealtime() < this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.a == null) {
                this.a = exc;
            }
            if (this.b == -9223372036854775807L && !pe0.c0()) {
                this.b = 200 + jElapsedRealtime;
            }
            long j = this.b;
            if (j == -9223372036854775807L || jElapsedRealtime < j) {
                this.c = jElapsedRealtime + 50;
                return;
            }
            Exception exc2 = this.a;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = this.a;
            a();
            throw exc3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pe0(f fVar) {
        this.a = fVar.a == null ? null : fVar.a.getApplicationContext();
        this.x = yb.i;
        this.b = fVar.c;
        this.c = fVar.d;
        this.j = fVar.e;
        this.k = 0;
        this.u = fVar.h;
        ds dsVar = new ds();
        this.d = dsVar;
        ot4 ot4Var = new ot4();
        this.e = ot4Var;
        this.f = new gp4();
        this.g = new fp4();
        this.h = xi1.x(ot4Var, dsVar);
        this.K = 1.0f;
        this.T = 0;
        this.V = new af(0, 0.0f);
        dc3 dc3Var = dc3.d;
        this.z = new i(dc3Var, 0L, 0L);
        this.A = dc3Var;
        this.B = false;
        this.i = new ArrayDeque();
        this.m = new j();
        this.n = new j();
        this.o = fVar.j;
        this.X = (Build.VERSION.SDK_INT < 34 || fVar.a == null) ? -1 : T(fVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void A(pe0 pe0Var) {
        pd.d dVar = pe0Var.q;
        if (dVar != null) {
            dVar.h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int T(Context context) {
        return n0(context.getDeviceId());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int W(int i2, ByteBuffer byteBuffer) {
        if (i2 == 20) {
            return w63.h(byteBuffer);
        }
        if (i2 != 30) {
            switch (i2) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iM = dv2.m(fy4.V(byteBuffer, byteBuffer.position()));
                    if (iM != -1) {
                        return iM;
                    }
                    d04.a();
                    return 0;
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i2) {
                        case 14:
                            int iB = l1.b(byteBuffer);
                            if (iB == -1) {
                                return 0;
                            }
                            return l1.i(byteBuffer, iB) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            return p1.f(byteBuffer);
                        case 18:
                            break;
                        default:
                            bo1.a("Unexpected audio encoding: ", i2);
                            return 0;
                    }
                    break;
            }
            return l1.e(byteBuffer);
        }
        return rp0.g(byteBuffer);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int X(int i2) {
        int iB = nz0.b(i2);
        gg3.v(iB != -2147483647);
        return iB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c0() {
        return f0.get() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int n0(int i2) {
        if (i2 == 0 || i2 == -1) {
            return -1;
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(long j2) {
        dc3 dc3VarA;
        if (v0()) {
            dc3VarA = dc3.d;
        } else {
            dc3VarA = t0() ? this.b.a(this.A) : dc3.d;
            this.A = dc3VarA;
        }
        dc3 dc3Var = dc3VarA;
        this.B = t0() ? this.b.d(this.B) : false;
        this.i.add(new i(dc3Var, Math.max(0L, j2), this.s.n(Z())));
        s0();
        pd.d dVar = this.q;
        if (dVar != null) {
            dVar.onSkipSilenceEnabledChanged(this.B);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long N(long j2) {
        while (!this.i.isEmpty() && j2 >= ((i) this.i.getFirst()).c) {
            this.z = (i) this.i.remove();
        }
        i iVar = this.z;
        long j3 = j2 - iVar.c;
        long jP0 = fy4.p0(j3, iVar.a.a);
        if (!this.i.isEmpty()) {
            i iVar2 = this.z;
            return iVar2.b + jP0 + iVar2.d;
        }
        long jB = this.b.b(j3);
        i iVar3 = this.z;
        long j4 = iVar3.b + jB;
        iVar3.d = jB - jP0;
        return j4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long O(long j2) {
        long jC = this.b.c();
        long jN = j2 + this.s.n(jC);
        long j3 = this.c0;
        if (jC > j3) {
            long jN2 = this.s.n(jC - j3);
            this.c0 = jC;
            a0(jN2);
        }
        return jN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final vc P(wc.g gVar) throws pd.c {
        try {
            return this.u.i(gVar);
        } catch (wc.e e2) {
            pd.c cVar = new pd.c(0, gVar.b, gVar.c, gVar.a, gVar.f, this.s.a, gVar.e, e2);
            pd.d dVar = this.q;
            if (dVar == null) {
                throw cVar;
            }
            dVar.d(cVar);
            throw cVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final vc Q() throws pd.c {
        try {
            return P(this.s.e);
        } catch (pd.c e2) {
            int i2 = this.s.e.f;
            while (i2 > 1000000) {
                i2 /= 2;
                int i3 = this.s.d != -1 ? this.s.d : 1;
                int i4 = i2 % i3;
                if (i4 != 0) {
                    i2 += i3 - i4;
                }
                wc.g gVarL = this.s.e.a().o(i2).l();
                try {
                    vc vcVarP = this.P(gVarL);
                    this.s = this.s.m(gVarL);
                    return vcVarP;
                } catch (pd.c e3) {
                    e2.addSuppressed(e3);
                }
            }
            this.g0();
            throw e2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R(long j2) throws Exception {
        pd.d dVar;
        if (this.N == null || this.n.b()) {
            return;
        }
        int iRemaining = this.N.remaining();
        try {
            boolean zO = this.w.o(this.N, this.M, j2);
            this.Z = SystemClock.elapsedRealtime();
            this.n.a();
            if (this.w.i()) {
                if (this.F > 0) {
                    this.b0 = false;
                }
                if (this.R && (dVar = this.q) != null && !zO && !this.b0) {
                    dVar.f();
                }
            }
            if (this.s.p()) {
                this.E += (long) (iRemaining - this.N.remaining());
            }
            if (zO) {
                if (!this.s.p()) {
                    gg3.v(this.N == this.L);
                    this.F += ((long) this.G) * ((long) this.M);
                }
                this.N = null;
            }
        } catch (vc.b e2) {
            if (!e2.g) {
                z = false;
            } else if (Z() <= 0) {
                if (this.w.i()) {
                    g0();
                }
            }
            pd.f fVar = new pd.f(e2.f, this.s.a, z);
            pd.d dVar2 = this.q;
            if (dVar2 != null) {
                dVar2.d(fVar);
            }
            if (e2.g) {
                throw fVar;
            }
            this.n.c(fVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean S() throws Exception {
        ByteBuffer byteBuffer;
        if (!this.t.g()) {
            R(Long.MIN_VALUE);
            return this.N == null;
        }
        this.t.i();
        k0(Long.MIN_VALUE);
        return this.t.f() && ((byteBuffer = this.N) == null || !byteBuffer.hasRemaining());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final wc.c U(t41 t41Var) {
        return V(t41Var, -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final wc.c V(t41 t41Var, int i2) {
        return new wc.c.a(t41Var).l(this.x).n(this.c).p(this.j).o(this.k != 0).s(this.W).m(this.T).q(this.Y).r(i2).t(this.X).k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long Y() {
        return this.s.p() ? this.C / ((long) this.s.c) : this.D;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long Z() {
        return this.s.p() ? fy4.o(this.E, this.s.d) : this.F;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public boolean a(t41 t41Var) {
        return k(t41Var) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a0(long j2) {
        this.d0 += j2;
        if (this.e0 == null) {
            this.e0 = new Handler(Looper.myLooper());
        }
        this.e0.removeCallbacksAndMessages(null);
        this.e0.postDelayed(new Runnable() { // from class: oe0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.i0();
            }
        }, 100L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public boolean b() {
        if (e0()) {
            return this.O && !g();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean b0(long j2) {
        return j2 > fy4.J(this.w.e(), ((vc) gg3.q(this.w)).j());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void c(int i2, int i3) {
        g gVar;
        vc vcVar = this.w;
        if (vcVar == null || !vcVar.i() || (gVar = this.s) == null || !gVar.e.k) {
            return;
        }
        this.w.c(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void d(ie3 ie3Var) {
        this.p = ie3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean d0() {
        if (this.m.b()) {
            return false;
        }
        this.w = Q();
        c cVar = new c(this.s.e);
        this.l = cVar;
        this.w.h(cVar);
        ExoPlayer.a aVar = this.o;
        if (aVar != null) {
            aVar.z(this.w.i());
        }
        if (this.w.i() && this.s.e.k) {
            this.w.c(this.s.a.K, this.s.a.L);
        }
        ie3 ie3Var = this.p;
        if (ie3Var != null) {
            this.w.d(ie3Var);
        }
        r0();
        int i2 = this.V.a;
        if (i2 != 0) {
            this.w.l(i2);
            this.w.f(this.V.b);
        }
        AudioDeviceInfo audioDeviceInfo = this.W;
        if (audioDeviceInfo != null) {
            this.w.setPreferredDevice(audioDeviceInfo);
        }
        this.I = true;
        int audioSessionId = this.w.getAudioSessionId();
        boolean z = audioSessionId != this.T;
        this.T = audioSessionId;
        pd.d dVar = this.q;
        if (dVar != null) {
            dVar.c(this.s.l());
            if (z) {
                this.U = true;
                g gVar = this.s;
                this.s = gVar.m(gVar.e.a().n(this.T).l());
                g gVar2 = this.r;
                if (gVar2 != null) {
                    this.r = gVar2.m(gVar2.e.a().n(this.T).l());
                }
                this.q.onAudioSessionIdChanged(this.T);
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void e(zu zuVar) {
        this.u.e(zuVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e0() {
        return this.w != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void f() {
        if (!this.O && e0() && S()) {
            j0();
            this.O = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0() {
        if (this.v != null || this.a == null) {
            return;
        }
        wc.f fVar = new wc.f() { // from class: ne0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // wc.f
            public final void a() {
                pe0.A(this.a);
            }
        };
        this.v = fVar;
        this.u.h(fVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void flush() {
        if (e0()) {
            m0();
            this.l = null;
            g gVar = this.r;
            if (gVar != null) {
                this.s = gVar;
                this.r = null;
            }
            f0.incrementAndGet();
            this.w.release();
            this.w = null;
        }
        this.n.a();
        this.m.a();
        this.c0 = 0L;
        this.d0 = 0L;
        Handler handler = this.e0;
        if (handler != null) {
            ((Handler) gg3.q(handler)).removeCallbacksAndMessages(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public boolean g() {
        if (e0()) {
            return !(Build.VERSION.SDK_INT >= 29 && this.w.i() && this.Q) && b0(Z());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g0() {
        if (this.s.e.e) {
            this.a0 = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public dc3 getPlaybackParameters() {
        return this.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void h(int i2) {
        if (this.U) {
            if (this.T != i2) {
                return;
            } else {
                this.U = false;
            }
        }
        if (this.T != i2) {
            this.T = i2;
            this.S = i2 != 0;
            l0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ByteBuffer h0(ByteBuffer byteBuffer) {
        if (this.s.p()) {
            int iJ = (int) fy4.J(fy4.c1(20L), this.s.e.b);
            long jZ = Z();
            if (jZ < iJ) {
                return v93.a(byteBuffer, this.s.e.a, this.s.d, (int) jZ, iJ);
            }
        }
        return byteBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public long i() {
        if (e0()) {
            return this.s.p() ? this.s.n(this.w.k()) : fy4.x1(this.w.k(), 1000000L, X(this.s.e.a), RoundingMode.DOWN);
        }
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i0() {
        if (this.d0 >= 300000) {
            this.q.e();
            this.d0 = 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void j(wc wcVar) {
        if (wcVar.equals(this.u)) {
            return;
        }
        this.u.release();
        this.u = wcVar;
        wc.f fVar = this.v;
        if (fVar != null) {
            wcVar.h(fVar);
        }
        l0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j0() {
        if (this.P) {
            return;
        }
        this.P = true;
        if (this.w.i()) {
            this.Q = false;
        }
        this.w.stop();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public int k(t41 t41Var) {
        boolean z;
        if (fy4.R0(t41Var.J)) {
            boolean zU0 = u0(t41Var.J);
            if (!zU0 || t41Var.J == 4) {
                z = false;
            } else {
                t41Var = t41Var.b().t0(4).Q();
                z = true;
            }
            if (!zU0 && t41Var.J != 2) {
                t41Var = t41Var.b().t0(2).Q();
                z = true;
            }
        } else {
            z = false;
        }
        int i2 = this.u.f(U(t41Var)).d;
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 2) {
            return 0;
        }
        return z ? 1 : 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k0(long j2) throws Exception {
        R(j2);
        if (this.N != null) {
            return;
        }
        if (!this.t.g()) {
            ByteBuffer byteBuffer = this.L;
            if (byteBuffer != null) {
                q0(byteBuffer);
                R(j2);
                return;
            }
            return;
        }
        while (!this.t.f()) {
            do {
                ByteBuffer byteBufferE = this.t.e();
                if (byteBufferE.hasRemaining()) {
                    q0(byteBufferE);
                    R(j2);
                } else {
                    ByteBuffer byteBuffer2 = this.L;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.t.j(this.L);
                    }
                }
            } while (this.N == null);
            return;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public uc l(t41 t41Var) {
        if (this.a0) {
            return uc.d;
        }
        wc.d dVarF = this.u.f(U(t41Var));
        return new uc.b().e(dVarF.a).f(dVarF.b).g(dVarF.c).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l0() {
        if (this.s != null) {
            g gVar = this.r;
            if (gVar != null) {
                this.s = gVar;
                this.r = null;
            }
            try {
                this.s = new g(this.s.a, this.s.b, this.s.c, this.s.d, this.u.g(U(this.s.b)), this.s.f);
            } catch (wc.b e2) {
                throw new IllegalStateException(new pd.b(e2, this.s.a));
            }
        }
        flush();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void m(int i2) {
        gg3.v(Build.VERSION.SDK_INT >= 29);
        this.k = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m0() {
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.b0 = false;
        this.G = 0;
        this.z = new i(this.A, 0L, 0L);
        this.J = 0L;
        this.y = null;
        this.i.clear();
        this.L = null;
        this.M = 0;
        this.N = null;
        this.P = false;
        this.O = false;
        this.Q = false;
        this.e.q();
        s0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public long n(boolean z) {
        if (!e0() || this.I) {
            return Long.MIN_VALUE;
        }
        return O(N(Math.min(this.w.e(), this.s.n(Z()))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void o() {
        if (this.Y) {
            this.Y = false;
            l0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o0() {
        if (e0()) {
            this.w.setPlaybackParameters(this.A);
            this.A = this.w.getPlaybackParameters();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void p(yb ybVar) {
        if (this.x.equals(ybVar)) {
            return;
        }
        this.x = ybVar;
        if (this.Y) {
            return;
        }
        l0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p0(dc3 dc3Var) {
        i iVar = new i(dc3Var, -9223372036854775807L, -9223372036854775807L);
        if (e0()) {
            this.y = iVar;
        } else {
            this.z = iVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void pause() {
        this.R = false;
        if (e0()) {
            this.w.pause();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void play() {
        this.R = true;
        if (e0()) {
            this.w.play();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void q(pd.d dVar) {
        this.q = dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(ByteBuffer byteBuffer) {
        gg3.v(this.N == null);
        if (byteBuffer.hasRemaining()) {
            this.N = h0(byteBuffer);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0() {
        if (e0()) {
            this.w.setVolume(this.K);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void release() {
        this.u.release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void reset() {
        flush();
        pw4 it = this.h.iterator();
        while (it.hasNext()) {
            ((yc) it.next()).reset();
        }
        this.f.reset();
        this.g.reset();
        xc xcVar = this.t;
        if (xcVar != null) {
            xcVar.k();
        }
        this.R = false;
        this.a0 = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void s() {
        this.H = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s0() {
        xc xcVar = this.s.f;
        this.t = xcVar;
        xcVar.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void setPlaybackParameters(dc3 dc3Var) {
        if (v0()) {
            this.A = dc3Var;
            o0();
        } else {
            dc3 dc3Var2 = new dc3(fy4.r(dc3Var.a, 0.1f, 8.0f), fy4.r(dc3Var.b, 0.1f, 8.0f));
            this.A = dc3Var2;
            p0(dc3Var2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        this.W = audioDeviceInfo;
        vc vcVar = this.w;
        if (vcVar != null) {
            vcVar.setPreferredDevice(audioDeviceInfo);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void setVolume(float f2) {
        if (this.K != f2) {
            this.K = f2;
            r0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void t() {
        gg3.v(this.S);
        if (this.Y) {
            return;
        }
        this.Y = true;
        l0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean t0() {
        return (this.Y || !this.s.p() || u0(this.s.a.J)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public ec u() {
        wc wcVar = this.u;
        if (wcVar instanceof he) {
            return ((he) wcVar).c();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean u0(int i2) {
        return this.c && fy4.Q0(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void v(af afVar) {
        if (this.V.equals(afVar)) {
            return;
        }
        int i2 = afVar.a;
        float f2 = afVar.b;
        vc vcVar = this.w;
        if (vcVar != null) {
            if (this.V.a != i2) {
                vcVar.l(i2);
            }
            if (i2 != 0) {
                this.w.f(f2);
            }
        }
        this.V = afVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v0() {
        g gVar = this.s;
        return gVar != null && gVar.e.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void w(int i2) {
        int iN0 = n0(i2);
        if (this.X == iN0) {
            return;
        }
        this.X = iN0;
        l0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void x(t41 t41Var, int i2, int[] iArr) throws pd.b {
        xc xcVar;
        t41 t41Var2;
        int i3;
        int iU0;
        f0();
        if ("audio/raw".equals(t41Var.p)) {
            gg3.d(fy4.R0(t41Var.J));
            int iU02 = fy4.u0(t41Var.J, t41Var.H);
            xi1.a aVar = new xi1.a();
            aVar.j(this.h);
            if (u0(t41Var.J)) {
                aVar.a(this.g);
            } else {
                aVar.a(this.f);
                aVar.i(this.b.e());
            }
            xcVar = new xc(aVar.k());
            if (xcVar.equals(this.t)) {
                xcVar = this.t;
            }
            this.e.r(t41Var.K, t41Var.L);
            this.d.p(iArr);
            try {
                yc.a aVarA = xcVar.a(new yc.a(t41Var));
                t41 t41VarQ = t41Var.b().t0(aVarA.c).B0(aVarA.a).U(aVarA.b).Q();
                iU0 = fy4.u0(aVarA.c, aVarA.b);
                i3 = iU02;
                t41Var2 = t41VarQ;
            } catch (yc.c e2) {
                throw new pd.b(e2, t41Var);
            }
        } else {
            xcVar = new xc(xi1.u());
            t41Var2 = t41Var;
            i3 = -1;
            iU0 = -1;
        }
        xc xcVar2 = xcVar;
        if (i2 == 0) {
            i2 = -1;
        }
        wc.c cVarV = V(t41Var2, i2);
        try {
            wc.g gVarG = this.u.g(cVarV);
            if (gVarG.a == 0) {
                throw new pd.b("Invalid output encoding (isOffload=" + gVarG.e + ")", cVarV.a);
            }
            if (gVarG.c == 0) {
                throw new pd.b("Invalid output channel config (isOffload=" + gVarG.e + ")", cVarV.a);
            }
            this.a0 = false;
            g gVar = new g(t41Var, t41Var2, i3, iU0, gVarG, xcVar2);
            if (e0()) {
                this.r = gVar;
            } else {
                this.s = gVar;
            }
        } catch (wc.b e3) {
            throw new pd.b(e3, t41Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public boolean y(ByteBuffer byteBuffer, long j2, int i2) throws Exception {
        ByteBuffer byteBuffer2 = this.L;
        gg3.d(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.r != null) {
            if (!S()) {
                return false;
            }
            vc vcVar = this.w;
            if (vcVar == null || vcVar.m(this.s.e, U(this.r.b), this.r.e)) {
                this.s = this.r;
                this.r = null;
                vc vcVar2 = this.w;
                if (vcVar2 != null && vcVar2.i() && this.s.e.k) {
                    this.w.n();
                    this.w.c(this.s.a.K, this.s.a.L);
                    this.b0 = true;
                }
            } else {
                j0();
                if (g()) {
                    return false;
                }
                flush();
            }
            M(j2);
        }
        if (!e0()) {
            try {
                if (!d0()) {
                    return false;
                }
            } catch (pd.c e2) {
                if (e2.g) {
                    throw e2;
                }
                this.m.c(e2);
                return false;
            }
        }
        this.m.a();
        if (this.I) {
            this.J = Math.max(0L, j2);
            this.H = false;
            this.I = false;
            if (v0()) {
                o0();
            }
            M(j2);
            if (this.R) {
                play();
            }
        }
        if (this.L == null) {
            gg3.d(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.s.p() && this.G == 0) {
                int iW = W(this.s.e.a, byteBuffer);
                this.G = iW;
                if (iW == 0) {
                    return true;
                }
            }
            if (this.y != null) {
                if (!S()) {
                    return false;
                }
                M(j2);
                this.y = null;
            }
            long jO = this.J + this.s.o(Y() - this.e.p());
            if (!this.H && Math.abs(jO - j2) > 200000) {
                pd.d dVar = this.q;
                if (dVar != null) {
                    dVar.d(new pd.e(j2, jO));
                }
                this.H = true;
            }
            if (this.H) {
                if (!S()) {
                    return false;
                }
                long j3 = j2 - jO;
                this.J += j3;
                this.H = false;
                M(j2);
                pd.d dVar2 = this.q;
                if (dVar2 != null && j3 != 0) {
                    dVar2.i();
                }
            }
            if (this.s.p()) {
                this.C += (long) byteBuffer.remaining();
            } else {
                this.D += ((long) this.G) * ((long) i2);
            }
            this.L = byteBuffer;
            this.M = i2;
        }
        k0(j2);
        if (!this.L.hasRemaining()) {
            this.L = null;
            this.M = 0;
            return true;
        }
        if (!this.w.g()) {
            return false;
        }
        xz1.i("DefaultAudioSink", "Resetting stalled audio output");
        flush();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pd
    public void z(boolean z) {
        this.B = z;
        p0(v0() ? dc3.d : this.A);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h implements zc {
        public final yc[] a;
        public final w64 b;
        public final la4 c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(yc[] ycVarArr, w64 w64Var, la4 la4Var) {
            yc[] ycVarArr2 = new yc[ycVarArr.length + 2];
            this.a = ycVarArr2;
            System.arraycopy(ycVarArr, 0, ycVarArr2, 0, ycVarArr.length);
            this.b = w64Var;
            this.c = la4Var;
            ycVarArr2[ycVarArr.length] = w64Var;
            ycVarArr2[ycVarArr.length + 1] = la4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zc
        public dc3 a(dc3 dc3Var) {
            this.c.m(dc3Var.a);
            this.c.l(dc3Var.b);
            return dc3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zc
        public long b(long j) {
            return this.c.c() ? this.c.j(j) : j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zc
        public long c() {
            return this.b.x();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zc
        public boolean d(boolean z) {
            this.b.G(z);
            return z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zc
        public yc[] e() {
            return this.a;
        }

        public h(yc... ycVarArr) {
            this(ycVarArr, new w64(), new la4());
        }
    }
}
