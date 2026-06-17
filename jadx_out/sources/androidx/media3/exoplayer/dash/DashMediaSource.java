package androidx.media3.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.exoplayer.dash.a;
import androidx.media3.exoplayer.dash.c;
import androidx.media3.exoplayer.dash.d;
import defpackage.aa0;
import defpackage.bz1;
import defpackage.eq3;
import defpackage.ev;
import defpackage.fg2;
import defpackage.fj;
import defpackage.fv;
import defpackage.fy4;
import defpackage.g90;
import defpackage.gg3;
import defpackage.h90;
import defpackage.hs4;
import defpackage.i90;
import defpackage.ig0;
import defpackage.j5;
import defpackage.ja0;
import defpackage.ji;
import defpackage.jq2;
import defpackage.kf0;
import defpackage.kg2;
import defpackage.ki4;
import defpackage.l11;
import defpackage.m90;
import defpackage.mi2;
import defpackage.na3;
import defpackage.no4;
import defpackage.oh2;
import defpackage.qy;
import defpackage.r83;
import defpackage.rq2;
import defpackage.sq2;
import defpackage.sy1;
import defpackage.t83;
import defpackage.te0;
import defpackage.tq3;
import defpackage.tx4;
import defpackage.ty1;
import defpackage.v02;
import defpackage.w94;
import defpackage.xi4;
import defpackage.xo0;
import defpackage.xy1;
import defpackage.xz1;
import defpackage.y3;
import defpackage.zo0;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class DashMediaSource extends ji {
    public final Runnable A;
    public final Runnable B;
    public final d.b C;
    public final bz1 D;
    public final xi4 E;
    public aa0 F;
    public xy1 G;
    public hs4 H;
    public IOException I;
    public Handler J;
    public Uri K;
    public Uri L;
    public g90 M;
    public boolean N;
    public long O;
    public long P;
    public long Q;
    public int R;
    public long S;
    public int T;
    public fg2 U;
    public fg2.g V;
    public final boolean m;
    public final aa0.a n;
    public final a.InterfaceC0017a o;
    public final qy p;
    public final xo0 q;
    public final sy1 r;
    public final fj s;
    public final long t;
    public final long u;
    public final rq2.a v;
    public final t83.a w;
    public final e x;
    public final Object y;
    public final SparseArray z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements w94.b {
        public a() {
        }

        @Override // w94.b
        public void a(IOException iOException) {
            DashMediaSource.this.d0(iOException);
        }

        @Override // w94.b
        public void b() {
            DashMediaSource.this.e0(w94.i());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends no4 {
        public final long e;
        public final long f;
        public final long g;
        public final int h;
        public final long i;
        public final long j;
        public final long k;
        public final g90 l;
        public final fg2 m;
        public final fg2.g n;

        public b(long j, long j2, long j3, int i, long j4, long j5, long j6, g90 g90Var, fg2 fg2Var, fg2.g gVar) {
            gg3.v(g90Var.d == (gVar != null));
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.h = i;
            this.i = j4;
            this.j = j5;
            this.k = j6;
            this.l = g90Var;
            this.m = fg2Var;
            this.n = gVar;
        }

        public static boolean A(g90 g90Var) {
            return g90Var.d && g90Var.e != -9223372036854775807L && g90Var.b == -9223372036854775807L;
        }

        @Override // defpackage.no4
        public int h(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.h) >= 0 && iIntValue < o()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            gg3.o(i, o());
            return bVar.u(z ? this.l.d(i).a : null, z ? Integer.valueOf(this.h + i) : null, 0, this.l.g(i), fy4.c1(this.l.d(i).b - this.l.d(0).b) - this.i);
        }

        @Override // defpackage.no4
        public int o() {
            return this.l.e();
        }

        @Override // defpackage.no4
        public Object s(int i) {
            gg3.o(i, o());
            return Integer.valueOf(this.h + i);
        }

        @Override // defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            gg3.o(i, 1);
            long jZ = z(j);
            Object obj = no4.d.q;
            fg2 fg2Var = this.m;
            g90 g90Var = this.l;
            return dVar.h(obj, fg2Var, g90Var, this.e, this.f, this.g, true, A(g90Var), this.n, jZ, this.j, 0, o() - 1, this.i);
        }

        @Override // defpackage.no4
        public int v() {
            return 1;
        }

        public final long z(long j) {
            m90 m90VarL;
            long j2 = this.k;
            if (!A(this.l)) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.j) {
                    return -9223372036854775807L;
                }
            }
            long j3 = this.i + j2;
            long jG = this.l.g(0);
            int i = 0;
            while (i < this.l.e() - 1 && j3 >= jG) {
                j3 -= jG;
                i++;
                jG = this.l.g(i);
            }
            na3 na3VarD = this.l.d(i);
            int iA = na3VarD.a(2);
            return (iA == -1 || (m90VarL = ((tq3) ((y3) na3VarD.c.get(iA)).c.get(0)).l()) == null || m90VarL.i(jG) == 0) ? j2 : (j2 + m90VarL.a(m90VarL.f(j3, jG))) - j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements t83.a {
        public static final Pattern a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // t83.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).readLine();
            try {
                Matcher matcher = a.matcher(line);
                if (!matcher.matches()) {
                    throw r83.c("Couldn't parse timestamp: " + line, null);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j2 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= j * (((j2 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
                }
                return Long.valueOf(time);
            } catch (ParseException e) {
                throw r83.c(null, e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f implements bz1 {
        public f() {
        }

        @Override // defpackage.bz1
        public void a() throws IOException {
            DashMediaSource.this.G.a();
            b();
        }

        public final void b() throws IOException {
            if (DashMediaSource.this.I != null) {
                throw DashMediaSource.this.I;
            }
        }
    }

    static {
        kg2.a("media3.exoplayer.dash");
    }

    public DashMediaSource(fg2 fg2Var, g90 g90Var, aa0.a aVar, t83.a aVar2, a.InterfaceC0017a interfaceC0017a, qy qyVar, ev evVar, xo0 xo0Var, sy1 sy1Var, long j, long j2, xi4 xi4Var) {
        this.U = fg2Var;
        this.V = fg2Var.d;
        this.K = ((fg2.h) gg3.q(fg2Var.b)).a;
        this.L = fg2Var.b.a;
        this.M = g90Var;
        this.n = aVar;
        this.w = aVar2;
        this.o = interfaceC0017a;
        this.q = xo0Var;
        this.r = sy1Var;
        this.t = j;
        this.u = j2;
        this.p = qyVar;
        this.E = xi4Var;
        this.s = new fj();
        boolean z = g90Var != null;
        this.m = z;
        a aVar3 = null;
        this.v = z(null);
        this.y = new Object();
        this.z = new SparseArray();
        this.C = new c(this, aVar3);
        this.S = -9223372036854775807L;
        this.Q = -9223372036854775807L;
        if (!z) {
            this.x = new e(this, aVar3);
            this.D = new f();
            this.A = new Runnable() { // from class: k90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.n0();
                }
            };
            this.B = new Runnable() { // from class: l90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.l0();
                }
            };
            return;
        }
        gg3.v(true ^ g90Var.d);
        this.x = null;
        this.A = null;
        this.B = null;
        this.D = new bz1.a();
    }

    public static long N(na3 na3Var, long j, long j2) {
        long jC1 = fy4.c1(na3Var.b);
        boolean zS = S(na3Var);
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < na3Var.c.size(); i++) {
            y3 y3Var = (y3) na3Var.c.get(i);
            List list = y3Var.c;
            int i2 = y3Var.b;
            boolean z = (i2 == 1 || i2 == 2) ? false : true;
            if ((!zS || !z) && !list.isEmpty()) {
                m90 m90VarL = ((tq3) list.get(0)).l();
                if (m90VarL == null) {
                    return jC1 + j;
                }
                long j3 = m90VarL.j(j, j2);
                if (j3 == 0) {
                    return jC1;
                }
                long jC = (m90VarL.c(j, j2) + j3) - 1;
                jMin = Math.min(jMin, m90VarL.b(jC, j) + m90VarL.a(jC) + jC1);
            }
        }
        return jMin;
    }

    public static long O(na3 na3Var, long j, long j2) {
        long jC1 = fy4.c1(na3Var.b);
        boolean zS = S(na3Var);
        long jMax = jC1;
        for (int i = 0; i < na3Var.c.size(); i++) {
            y3 y3Var = (y3) na3Var.c.get(i);
            List list = y3Var.c;
            int i2 = y3Var.b;
            boolean z = (i2 == 1 || i2 == 2) ? false : true;
            if ((!zS || !z) && !list.isEmpty()) {
                m90 m90VarL = ((tq3) list.get(0)).l();
                if (m90VarL == null || m90VarL.j(j, j2) == 0) {
                    return jC1;
                }
                jMax = Math.max(jMax, m90VarL.a(m90VarL.c(j, j2)) + jC1);
            }
        }
        return jMax;
    }

    public static long P(g90 g90Var, long j) {
        m90 m90VarL;
        int iE = g90Var.e() - 1;
        na3 na3VarD = g90Var.d(iE);
        long jC1 = fy4.c1(na3VarD.b);
        long jG = g90Var.g(iE);
        long jC12 = fy4.c1(j);
        long jC13 = fy4.c1(g90Var.a);
        long jC14 = fy4.c1(g90Var.e);
        if (jC14 == -9223372036854775807L || jC14 >= 5000000) {
            jC14 = 5000000;
        }
        for (int i = 0; i < na3VarD.c.size(); i++) {
            List list = ((y3) na3VarD.c.get(i)).c;
            if (!list.isEmpty() && (m90VarL = ((tq3) list.get(0)).l()) != null) {
                long jD = ((jC13 + jC1) + m90VarL.d(jG, jC12)) - jC12;
                if (jD > 0 && (jD < jC14 - 100000 || (jD > jC14 && jD < jC14 + 100000))) {
                    jC14 = jD;
                }
            }
        }
        return v02.b(jC14, 1000L, RoundingMode.CEILING);
    }

    public static boolean S(na3 na3Var) {
        for (int i = 0; i < na3Var.c.size(); i++) {
            int i2 = ((y3) na3Var.c.get(i)).b;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean T(na3 na3Var) {
        for (int i = 0; i < na3Var.c.size(); i++) {
            m90 m90VarL = ((tq3) ((y3) na3Var.c.get(i)).c.get(0)).l();
            if (m90VarL == null || m90VarL.g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        Uri uri;
        this.J.removeCallbacks(this.A);
        if (this.G.i()) {
            return;
        }
        if (this.G.j()) {
            this.N = true;
            return;
        }
        synchronized (this.y) {
            uri = this.K;
        }
        this.N = false;
        m0(new t83(this.F, new ja0.b().i(uri).b(1).a(), 4, this.w), this.x, this.r.d(4));
    }

    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        this.H = hs4Var;
        this.q.c(Looper.myLooper(), C());
        this.q.prepare();
        if (this.m) {
            f0(false);
            return;
        }
        this.F = this.n.b();
        this.G = this.E != null ? new xy1((eq3) this.E.get()) : new xy1("DashMediaSource");
        this.J = fy4.E();
        n0();
    }

    @Override // defpackage.ji
    public void G() {
        this.N = false;
        this.F = null;
        xy1 xy1Var = this.G;
        if (xy1Var != null) {
            xy1Var.l();
            this.G = null;
        }
        k0(i().d);
        this.O = 0L;
        this.P = 0L;
        this.K = this.L;
        this.I = null;
        Handler handler = this.J;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.J = null;
        }
        this.Q = -9223372036854775807L;
        this.R = 0;
        this.S = -9223372036854775807L;
        this.z.clear();
        this.s.i();
        this.q.release();
    }

    public final synchronized fg2.g Q() {
        return this.V;
    }

    public final long R() {
        return Math.min((this.R - 1) * 1000, 5000);
    }

    public final void U() {
        w94.l(this.G, new a());
    }

    public void V(long j) {
        long j2 = this.S;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.S = j;
        }
    }

    public void W() {
        this.J.removeCallbacks(this.B);
        n0();
    }

    public void X(t83 t83Var, long j, long j2) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        this.r.c(t83Var.a);
        this.v.l(ty1Var, t83Var.c);
    }

    public void Y(t83 t83Var, long j, long j2) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        this.r.c(t83Var.a);
        this.v.o(ty1Var, t83Var.c);
        g90 g90Var = (g90) t83Var.e();
        g90 g90Var2 = this.M;
        int iE = g90Var2 == null ? 0 : g90Var2.e();
        long j3 = g90Var.d(0).b;
        int i = 0;
        while (i < iE && this.M.d(i).b < j3) {
            i++;
        }
        if (g90Var.d) {
            if (iE - i > g90Var.e()) {
                xz1.i("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j4 = this.S;
                if (j4 == -9223372036854775807L || g90Var.h * 1000 > j4) {
                    this.R = 0;
                } else {
                    xz1.i("DashMediaSource", "Loaded stale dynamic manifest: " + g90Var.h + ", " + this.S);
                }
            }
            int i2 = this.R;
            this.R = i2 + 1;
            if (i2 < this.r.d(t83Var.c)) {
                j0(R());
                return;
            } else {
                this.I = new i90();
                return;
            }
        }
        this.M = g90Var;
        this.N = g90Var.d & this.N;
        this.O = j - j2;
        this.P = j;
        this.T += i;
        synchronized (this.y) {
            if (t83Var.b.a.equals(this.K)) {
                Uri uriB = this.M.k;
                if (uriB == null) {
                    uriB = fv.b(t83Var.f());
                }
                this.K = uriB;
            }
        }
        g90 g90Var3 = this.M;
        if (!g90Var3.d || this.Q != -9223372036854775807L) {
            f0(true);
            return;
        }
        tx4 tx4Var = g90Var3.i;
        if (tx4Var != null) {
            g0(tx4Var);
        } else {
            U();
        }
    }

    public xy1.c Z(t83 t83Var, long j, long j2, IOException iOException, int i) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        long jA = this.r.a(new sy1.c(ty1Var, new oh2(t83Var.c), iOException, i));
        xy1.c cVarH = jA == -9223372036854775807L ? xy1.g : xy1.h(false, jA);
        boolean zC = cVarH.c();
        this.v.s(ty1Var, t83Var.c, iOException, !zC);
        if (!zC) {
            this.r.c(t83Var.a);
        }
        return cVarH;
    }

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        fg2.h hVar = (fg2.h) gg3.q(i().b);
        fg2.h hVar2 = fg2Var.b;
        return hVar2 != null && hVar2.a.equals(hVar.a) && hVar2.e.equals(hVar.e) && Objects.equals(hVar2.c, hVar.c);
    }

    public void a0(t83 t83Var, long j, long j2, int i) {
        this.v.u(i == 0 ? new ty1(t83Var.a, t83Var.b, j) : new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a()), t83Var.c, i);
    }

    public void b0(t83 t83Var, long j, long j2) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        this.r.c(t83Var.a);
        this.v.o(ty1Var, t83Var.c);
        e0(((Long) t83Var.e()).longValue() - j);
    }

    public xy1.c c0(t83 t83Var, long j, long j2, IOException iOException) {
        this.v.s(new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a()), t83Var.c, iOException, true);
        this.r.c(t83Var.a);
        d0(iOException);
        return xy1.f;
    }

    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        int iIntValue = ((Integer) bVar.a).intValue() - this.T;
        rq2.a aVarZ = z(bVar);
        androidx.media3.exoplayer.dash.b bVar2 = new androidx.media3.exoplayer.dash.b(this.T + iIntValue, this.M, this.s, iIntValue, this.o, this.H, null, this.q, x(bVar), this.r, aVarZ, this.Q, this.D, j5Var, this.p, this.C, C(), this.E);
        this.z.put(bVar2.f, bVar2);
        return bVar2;
    }

    public final void d0(IOException iOException) {
        xz1.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.Q = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        f0(true);
    }

    public final void e0(long j) {
        this.Q = j;
        f0(true);
    }

    public final void f0(boolean z) {
        long j;
        long j2;
        long j3;
        for (int i = 0; i < this.z.size(); i++) {
            int iKeyAt = this.z.keyAt(i);
            if (iKeyAt >= this.T) {
                ((androidx.media3.exoplayer.dash.b) this.z.valueAt(i)).U(this.M, iKeyAt - this.T);
            }
        }
        na3 na3VarD = this.M.d(0);
        int iE = this.M.e() - 1;
        na3 na3VarD2 = this.M.d(iE);
        long jG = this.M.g(iE);
        long jC1 = fy4.c1(fy4.q0(this.Q));
        long jO = O(na3VarD, this.M.g(0), jC1);
        long jN = N(na3VarD2, jG, jC1);
        boolean z2 = this.M.d && !T(na3VarD2);
        if (z2) {
            long j4 = this.M.f;
            if (j4 != -9223372036854775807L) {
                jO = Math.max(jO, jN - fy4.c1(j4));
            }
        }
        long j5 = jN - jO;
        g90 g90Var = this.M;
        if (g90Var.d) {
            gg3.v(g90Var.a != -9223372036854775807L);
            long jC12 = (jC1 - fy4.c1(this.M.a)) - jO;
            o0(jC12, j5);
            long jS1 = this.M.a + fy4.S1(jO);
            long jC13 = jC12 - fy4.c1(Q().a);
            j = 0;
            long jMin = Math.min(this.u, j5 / 2);
            j2 = jS1;
            j3 = jC13 < jMin ? jMin : jC13;
        } else {
            j = 0;
            j2 = -9223372036854775807L;
            j3 = 0;
        }
        long jC14 = jO - fy4.c1(na3VarD.b);
        g90 g90Var2 = this.M;
        F(new b(g90Var2.a, j2, this.Q, this.T, jC14, j5, j3, g90Var2, i(), this.M.d ? Q() : null));
        if (this.m) {
            return;
        }
        this.J.removeCallbacks(this.B);
        if (z2) {
            this.J.postDelayed(this.B, P(this.M, fy4.q0(this.Q)));
        }
        if (this.N) {
            n0();
            return;
        }
        if (z) {
            g90 g90Var3 = this.M;
            if (g90Var3.d) {
                long j6 = g90Var3.e;
                if (j6 != -9223372036854775807L) {
                    if (j6 == j) {
                        j6 = 5000;
                    }
                    j0(Math.max(j, (this.O + j6) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public final void g0(tx4 tx4Var) {
        String str = tx4Var.a;
        if (Objects.equals(str, "urn:mpeg:dash:utc:direct:2014") || Objects.equals(str, "urn:mpeg:dash:utc:direct:2012")) {
            h0(tx4Var);
            return;
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            i0(tx4Var, new d());
            return;
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            i0(tx4Var, new h(null));
        } else if (Objects.equals(str, "urn:mpeg:dash:utc:ntp:2014") || Objects.equals(str, "urn:mpeg:dash:utc:ntp:2012")) {
            U();
        } else {
            d0(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void h0(tx4 tx4Var) {
        try {
            e0(fy4.l1(tx4Var.b) - this.P);
        } catch (r83 e2) {
            d0(e2);
        }
    }

    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.U;
    }

    public final void i0(tx4 tx4Var, t83.a aVar) {
        m0(new t83(this.F, Uri.parse(tx4Var.b), 5, aVar), new g(this, null), 1);
    }

    public final void j0(long j) {
        this.J.postDelayed(this.A, j);
    }

    public final synchronized void k0(fg2.g gVar) {
        this.V = gVar;
    }

    public final void l0() {
        try {
            f0(false);
        } catch (Exception e2) {
            this.I = new IOException(e2);
        }
    }

    @Override // defpackage.jq2
    public void m() {
        this.D.a();
    }

    public final void m0(t83 t83Var, xy1.b bVar, int i) {
        this.G.n(t83Var, bVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0(long r19, long r21) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.o0(long, long):void");
    }

    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.U = fg2Var;
        this.V = fg2Var.d;
    }

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        androidx.media3.exoplayer.dash.b bVar = (androidx.media3.exoplayer.dash.b) mi2Var;
        bVar.O();
        this.z.remove(bVar.f);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h implements t83.a {
        public h() {
        }

        @Override // t83.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) {
            return Long.valueOf(fy4.l1(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements d.b {
        public c() {
        }

        @Override // androidx.media3.exoplayer.dash.d.b
        public void a() {
            DashMediaSource.this.W();
        }

        @Override // androidx.media3.exoplayer.dash.d.b
        public void b(long j) {
            DashMediaSource.this.V(j);
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e implements xy1.b {
        public e() {
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(t83 t83Var, long j, long j2, boolean z) {
            DashMediaSource.this.X(t83Var, j, j2);
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(t83 t83Var, long j, long j2) {
            DashMediaSource.this.Y(t83Var, j, j2);
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public xy1.c v(t83 t83Var, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.Z(t83Var, j, j2, iOException, i);
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void p(t83 t83Var, long j, long j2, int i) {
            DashMediaSource.this.a0(t83Var, j, j2, i);
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g implements xy1.b {
        public g() {
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(t83 t83Var, long j, long j2, boolean z) {
            DashMediaSource.this.X(t83Var, j, j2);
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(t83 t83Var, long j, long j2) {
            DashMediaSource.this.b0(t83Var, j, j2);
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public xy1.c v(t83 t83Var, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.c0(t83Var, j, j2, iOException);
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Factory implements sq2 {
        public static final /* synthetic */ int l = 0;
        public final a.InterfaceC0017a c;
        public final aa0.a d;
        public zo0 e;
        public qy f;
        public sy1 g;
        public long h;
        public long i;
        public t83.a j;
        public xi4 k;

        public Factory(a.InterfaceC0017a interfaceC0017a, aa0.a aVar) {
            this.c = (a.InterfaceC0017a) gg3.q(interfaceC0017a);
            this.d = aVar;
            this.e = new kf0();
            this.g = new ig0();
            this.h = 30000L;
            this.i = 5000000L;
            this.f = new te0();
            b(true);
            this.k = null;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public DashMediaSource e(fg2 fg2Var) {
            gg3.q(fg2Var.b);
            t83.a h90Var = this.j;
            if (h90Var == null) {
                h90Var = new h90();
            }
            List list = fg2Var.b.e;
            return new DashMediaSource(fg2Var, null, this.d, !list.isEmpty() ? new l11(h90Var, list) : h90Var, this.c, this.f, null, this.e.a(fg2Var), this.g, this.h, this.i, this.k, null);
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory b(boolean z) {
            this.c.b(z);
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory c(int i) {
            this.c.c(i);
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory d(xi4 xi4Var) {
            this.k = xi4Var;
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory f(zo0 zo0Var) {
            this.e = (zo0) gg3.r(zo0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Factory g(sy1 sy1Var) {
            this.g = (sy1) gg3.r(sy1Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Factory a(ki4.a aVar) {
            this.c.a((ki4.a) gg3.q(aVar));
            return this;
        }

        public Factory(aa0.a aVar) {
            this(new c.a(aVar), aVar);
        }
    }

    public /* synthetic */ DashMediaSource(fg2 fg2Var, g90 g90Var, aa0.a aVar, t83.a aVar2, a.InterfaceC0017a interfaceC0017a, qy qyVar, ev evVar, xo0 xo0Var, sy1 sy1Var, long j, long j2, xi4 xi4Var, a aVar3) {
        this(fg2Var, g90Var, aVar, aVar2, interfaceC0017a, qyVar, evVar, xo0Var, sy1Var, j, j2, xi4Var);
    }
}
