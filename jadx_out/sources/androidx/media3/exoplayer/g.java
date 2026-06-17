package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.b;
import androidx.media3.exoplayer.g;
import androidx.media3.exoplayer.h;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.n;
import androidx.media3.exoplayer.q;
import androidx.media3.exoplayer.r;
import com.hierynomus.msdtyp.FileTime;
import defpackage.bc;
import defpackage.bc3;
import defpackage.bf3;
import defpackage.c35;
import defpackage.ci1;
import defpackage.cy0;
import defpackage.cz;
import defpackage.d94;
import defpackage.dc3;
import defpackage.dc4;
import defpackage.di2;
import defpackage.dj1;
import defpackage.e04;
import defpackage.e35;
import defpackage.er4;
import defpackage.et2;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.fz3;
import defpackage.gb0;
import defpackage.gg3;
import defpackage.gp;
import defpackage.hd3;
import defpackage.i25;
import defpackage.i52;
import defpackage.ie3;
import defpackage.ih4;
import defpackage.iy0;
import defpackage.j25;
import defpackage.jh4;
import defpackage.jq2;
import defpackage.jq3;
import defpackage.jy0;
import defpackage.kg2;
import defpackage.kk0;
import defpackage.l85;
import defpackage.lb0;
import defpackage.lq3;
import defpackage.lr4;
import defpackage.mc1;
import defpackage.mi;
import defpackage.n95;
import defpackage.no4;
import defpackage.o5;
import defpackage.o64;
import defpackage.od;
import defpackage.oo4;
import defpackage.or4;
import defpackage.p5;
import defpackage.p81;
import defpackage.pd;
import defpackage.ph2;
import defpackage.pr4;
import defpackage.pu1;
import defpackage.pw4;
import defpackage.qg;
import defpackage.t41;
import defpackage.tm4;
import defpackage.uq2;
import defpackage.w50;
import defpackage.w82;
import defpackage.wc;
import defpackage.xf;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xs2;
import defpackage.xz1;
import defpackage.yb;
import defpackage.yx0;
import defpackage.z20;
import defpackage.zu;
import defpackage.zv0;
import defpackage.zz3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends mi implements ExoPlayer {
    public final l85 A;
    public ph2 A0;
    public final n95 B;
    public bc3 B0;
    public final long C;
    public int C0;
    public final r D;
    public long D0;
    public final xf E;
    public final ih4 F;
    public final C0019g G;
    public final c H;
    public final c I;
    public int J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public dj1 P;
    public fz3 Q;
    public zz3 R;
    public o64 S;
    public ExoPlayer.c T;
    public boolean U;
    public hd3.b V;
    public ph2 W;
    public ph2 X;
    public t41 Y;
    public t41 Z;
    public Object a0;
    public final pr4 b;
    public Surface b0;
    public final hd3.b c;
    public SurfaceHolder c0;
    public final cz d = new cz();
    public dc4 d0;
    public final Context e;
    public boolean e0;
    public final hd3 f;
    public TextureView f0;
    public final o[] g;
    public int g0;
    public final o[] h;
    public int h0;
    public final or4 i;
    public d94 i0;
    public final mc1 j;
    public gb0 j0;
    public final h.f k;
    public gb0 k0;
    public final h l;
    public yb l0;
    public final pu1 m;
    public float m0;
    public final CopyOnWriteArraySet n;
    public float n0;
    public final no4.b o;
    public boolean o0;
    public final List p;
    public w50 p0;
    public final boolean q;
    public boolean q0;
    public final jq2.a r;
    public boolean r0;
    public final o5 s;
    public int s0;
    public final Looper t;
    public boolean t0;
    public final qg u;
    public boolean u0;
    public final zu v;
    public kk0 v0;
    public final d w;
    public e35 w0;
    public final e x;
    public long x0;
    public final bc y;
    public long y0;
    public final q z;
    public long z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static /* synthetic */ void a(Context context, boolean z, g gVar, ie3 ie3Var) {
            di2 di2VarL0 = di2.L0(context);
            if (di2VarL0 == null) {
                xz1.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return;
            }
            if (z) {
                gVar.x0(di2VarL0);
            }
            ie3Var.b(di2VarL0.S0());
        }

        public static void b(final Context context, final g gVar, final boolean z, final ie3 ie3Var) {
            gVar.L0().c(gVar.Q0(), null).d(new Runnable() { // from class: px0
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.a(context, z, gVar, ie3Var);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c {
        public final int a;
        public final Map b;
        public androidx.media3.exoplayer.b c;

        public c(int i) {
            this.a = i;
            this.b = new HashMap();
            this.c = androidx.media3.exoplayer.b.b;
        }

        public final androidx.media3.exoplayer.b b(androidx.media3.exoplayer.b bVar, List list) {
            b.C0016b c0016bC = bVar.c();
            HashSet hashSet = new HashSet(list);
            for (String str : bVar.e()) {
                if (!hashSet.contains(str)) {
                    c0016bC.b(str);
                }
            }
            return c0016bC.a();
        }

        public final void c(androidx.media3.exoplayer.b bVar) {
            for (Map.Entry entry : new HashMap(this.b).entrySet()) {
                w82.a(entry.getKey());
                List list = (List) entry.getValue();
                if (!b(bVar, list).equals(b(this.c, list))) {
                    throw null;
                }
            }
            this.c = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e implements j25, gp, n.b {
        public j25 f;
        public gp g;
        public j25 h;
        public gp i;

        public e() {
        }

        @Override // androidx.media3.exoplayer.n.b
        public void F(int i, Object obj) {
            if (i == 7) {
                this.f = (j25) obj;
                return;
            }
            if (i == 8) {
                this.g = (gp) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            dc4 dc4Var = (dc4) obj;
            if (dc4Var == null) {
                this.h = null;
                this.i = null;
            } else {
                this.h = dc4Var.getVideoFrameMetadataListener();
                this.i = dc4Var.getCameraMotionListener();
            }
        }

        @Override // defpackage.gp
        public void a(long j, float[] fArr) {
            gp gpVar = this.i;
            if (gpVar != null) {
                gpVar.a(j, fArr);
            }
            gp gpVar2 = this.g;
            if (gpVar2 != null) {
                gpVar2.a(j, fArr);
            }
        }

        @Override // defpackage.gp
        public void e() {
            gp gpVar = this.i;
            if (gpVar != null) {
                gpVar.e();
            }
            gp gpVar2 = this.g;
            if (gpVar2 != null) {
                gpVar2.e();
            }
        }

        @Override // defpackage.j25
        public void h(long j, long j2, t41 t41Var, MediaFormat mediaFormat) {
            j25 j25Var = this.h;
            if (j25Var != null) {
                j25Var.h(j, j2, t41Var, mediaFormat);
            }
            j25 j25Var2 = this.f;
            if (j25Var2 != null) {
                j25Var2.h(j, j2, t41Var, mediaFormat);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements uq2 {
        public final Object a;
        public final jq2 b;
        public no4 c;

        public f(Object obj, i52 i52Var) {
            this.a = obj;
            this.b = i52Var;
            this.c = i52Var.c0();
        }

        @Override // defpackage.uq2
        public Object a() {
            return this.a;
        }

        @Override // defpackage.uq2
        public no4 b() {
            return this.c;
        }

        public void d(no4 no4Var) {
            this.c = no4Var;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class C0019g {
        public final WeakReference a;
        public final IntConsumer b;

        public C0019g(Context context) {
            this.a = new WeakReference(context);
            IntConsumer intConsumer = new IntConsumer() { // from class: by0
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    this.a.c(i);
                }
            };
            this.b = intConsumer;
            mc1 mc1VarC = g.this.v.c(g.this.t, null);
            Objects.requireNonNull(mc1VarC);
            context.registerDeviceIdChangeListener(new cy0(mc1VarC), intConsumer);
        }

        public final void c(int i) {
            if (g.this.u0) {
                return;
            }
            g.this.i1(1, 19, Integer.valueOf(i));
        }

        public final void d() {
            Context context = (Context) this.a.get();
            if (context == null) {
                return;
            }
            context.unregisterDeviceIdChangeListener(this.b);
        }
    }

    static {
        kg2.a("media3.exoplayer");
    }

    public g(ExoPlayer.b bVar, hd3 hd3Var) {
        Looper looper;
        zu zuVar;
        try {
            xz1.g("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.0] [" + fy4.e + "]");
            this.e = bVar.a.getApplicationContext();
            this.s = (o5) bVar.i.apply(bVar.b);
            this.s0 = bVar.l;
            this.l0 = bVar.m;
            this.g0 = bVar.t;
            this.h0 = bVar.u;
            this.o0 = bVar.r;
            this.C = bVar.D;
            d dVar = new d();
            this.w = dVar;
            this.x = new e();
            Handler handler = new Handler(bVar.k);
            lq3 lq3Var = (lq3) bVar.d.get();
            o[] oVarArrB = lq3Var.b(handler, dVar, dVar, dVar, dVar);
            this.g = oVarArrB;
            gg3.v(oVarArrB.length > 0);
            this.h = new o[oVarArrB.length];
            int i = 0;
            while (true) {
                o[] oVarArr = this.h;
                if (i >= oVarArr.length) {
                    break;
                }
                o oVar = this.g[i];
                d dVar2 = this.w;
                oVarArr[i] = lq3Var.a(oVar, handler, dVar2, dVar2, dVar2, dVar2);
                i++;
            }
            or4 or4Var = (or4) bVar.f.get();
            this.i = or4Var;
            this.r = (jq2.a) bVar.e.get();
            qg qgVar = (qg) bVar.h.get();
            this.u = qgVar;
            this.q = bVar.v;
            this.R = bVar.w;
            this.x0 = bVar.y;
            this.y0 = bVar.z;
            this.z0 = bVar.A;
            this.Q = bVar.x;
            this.U = bVar.I;
            Looper looper2 = bVar.k;
            this.t = looper2;
            zu zuVar2 = bVar.b;
            this.v = zuVar2;
            hd3 hd3Var2 = hd3Var == null ? this : hd3Var;
            this.f = hd3Var2;
            this.m = new pu1(looper2, zuVar2, new pu1.b() { // from class: xw0
                @Override // pu1.b
                public final void a(Object obj, o21 o21Var) {
                    ((hd3.d) obj).onEvents(this.a.f, new hd3.c(o21Var));
                }
            });
            this.n = new CopyOnWriteArraySet();
            this.p = new ArrayList();
            this.S = new o64.a(0);
            this.T = ExoPlayer.c.b;
            o[] oVarArr2 = this.g;
            pr4 pr4Var = new pr4(new jq3[oVarArr2.length], new jy0[oVarArr2.length], xr4.b, null);
            this.b = pr4Var;
            this.o = new no4.b();
            hd3.b bVarF = new hd3.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32).e(29, or4Var.h()).e(23, bVar.s).e(25, bVar.s).e(33, bVar.s).e(26, bVar.s).e(34, bVar.s).f();
            this.c = bVarF;
            this.V = new hd3.b.a().b(bVarF).a(4).a(10).f();
            this.j = zuVar2.c(looper2, null);
            h.f fVar = new h.f() { // from class: yw0
                @Override // androidx.media3.exoplayer.h.f
                public final void a(h.e eVar) {
                    g gVar = this.a;
                    gVar.j.d(new Runnable() { // from class: ex0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.V0(eVar);
                        }
                    });
                }
            };
            this.k = fVar;
            this.B0 = bc3.k(pr4Var);
            this.s.g0(hd3Var2, looper2);
            ie3 ie3Var = new ie3(bVar.N);
            h hVar = new h(this.e, this.g, this.h, or4Var, pr4Var, (i) bVar.g.get(), qgVar, this.J, this.K, this.s, this.R, bVar.B, bVar.C, this.U, bVar.O, looper2, zuVar2, fVar, ie3Var, bVar.K, this.T, this.x, bVar.Q);
            this.l = hVar;
            Looper looperR = hVar.R();
            this.m0 = 1.0f;
            this.J = 0;
            ph2 ph2Var = ph2.M;
            this.W = ph2Var;
            this.X = ph2Var;
            this.A0 = ph2Var;
            this.C0 = -1;
            this.p0 = w50.d;
            this.q0 = true;
            addListener(this.s);
            qgVar.c(new Handler(looper2), this.s);
            y0(this.w);
            long j = bVar.c;
            if (j > 0) {
                hVar.J(j);
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31) {
                b.b(this.e, this, bVar.J, ie3Var);
            }
            xf xfVar = new xf(0, looperR, looper2, zuVar2, new xf.a() { // from class: zw0
                @Override // xf.a
                public final void a(Object obj, Object obj2) {
                    this.a.c1(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            });
            this.E = xfVar;
            xfVar.e(new Runnable() { // from class: ax0
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar = this.f;
                    gVar.E.g(Integer.valueOf(fy4.P(gVar.e)));
                }
            });
            bc bcVar = new bc(bVar.a, looperR, bVar.k, this.w, zuVar2);
            zu zuVar3 = zuVar2;
            this.y = bcVar;
            bcVar.d(bVar.q);
            if (bVar.M) {
                r rVar = bVar.P;
                this.D = rVar;
                rVar.b(new r.a() { // from class: bx0
                    @Override // androidx.media3.exoplayer.r.a
                    public final void a(boolean z) {
                        this.a.d1(z);
                    }
                }, this.e, looper2, looperR, zuVar3);
                zuVar3 = zuVar3;
            } else {
                this.D = null;
            }
            if (bVar.s) {
                zu zuVar4 = zuVar3;
                looper = looperR;
                zuVar = zuVar4;
                this.z = new q(bVar.a, this.w, this.l0.e(), looperR, looper2, zuVar4);
            } else {
                looper = looperR;
                zuVar = zuVar3;
                this.z = null;
            }
            int i3 = bVar.p ? bVar.o : (bVar.E == Integer.MAX_VALUE || bVar.F == Integer.MAX_VALUE || bVar.G == Integer.MAX_VALUE || bVar.H == Integer.MAX_VALUE) ? 0 : 1;
            l85 l85Var = new l85(bVar.a, looper, zuVar);
            this.A = l85Var;
            l85Var.f(i3 != 0);
            n95 n95Var = new n95(bVar.a, looper, zuVar);
            this.B = n95Var;
            int i4 = 2;
            n95Var.f(i3 == 2);
            this.v0 = kk0.e;
            this.w0 = e35.e;
            this.i0 = d94.c;
            this.G = i2 >= 34 ? new C0019g(bVar.a) : null;
            this.H = new c(1);
            this.I = new c(i4);
            this.F = new ih4(this, this.w, zuVar, bVar.E, bVar.F, bVar.G, bVar.H);
            hVar.D1(this.Q);
            hVar.m1(this.l0, bVar.n);
            i1(1, 3, this.l0);
            i1(2, 4, Integer.valueOf(this.g0));
            i1(2, 5, Integer.valueOf(this.h0));
            i1(1, 9, Boolean.valueOf(this.o0));
            i1(6, 8, this.x);
            j1(16, Integer.valueOf(this.s0));
            wc wcVar = bVar.j;
            if (wcVar != null) {
                i1(1, 20, wcVar);
            }
            this.d.f();
        } catch (Throwable th) {
            this.d.f();
            throw th;
        }
    }

    public static /* synthetic */ void G(bc3 bc3Var, hd3.d dVar) {
        dVar.onLoadingChanged(bc3Var.g);
        dVar.onIsLoadingChanged(bc3Var.g);
    }

    public static kk0 G0(q qVar) {
        return new kk0.b(0).g(qVar != null ? qVar.u() : 0).f(qVar != null ? qVar.t() : 0).e();
    }

    public static long U0(bc3 bc3Var) {
        no4.d dVar = new no4.d();
        no4.b bVar = new no4.b();
        bc3Var.a.n(bc3Var.b.a, bVar);
        return bc3Var.c == -9223372036854775807L ? bc3Var.a.t(bVar.c, dVar).d() : bVar.p() + bc3Var.c;
    }

    public static bc3 X0(bc3 bc3Var, int i) {
        bc3 bc3VarH = bc3Var.h(i);
        return (i == 1 || i == 4) ? bc3VarH.b(false) : bc3VarH;
    }

    public static /* synthetic */ void p(int i, hd3.e eVar, hd3.e eVar2, hd3.d dVar) {
        dVar.onPositionDiscontinuity(i);
        dVar.onPositionDiscontinuity(eVar, eVar2, i);
    }

    public static lr4 z0(lr4 lr4Var, dj1 dj1Var) {
        lr4.c cVarM = lr4Var.M();
        pw4 it = dj1Var.iterator();
        while (it.hasNext()) {
            cVarM.a0(((Integer) it.next()).intValue(), true);
        }
        return cVarM.K();
    }

    public final List A0(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            m.c cVar = new m.c((jq2) list.get(i2), this.q);
            arrayList.add(cVar);
            this.p.add(i2 + i, new f(cVar.b, cVar.a));
        }
        this.S = this.S.f(i, arrayList.size());
        return arrayList;
    }

    public void B0(int i, List list) {
        y1();
        gg3.d(i >= 0);
        int iMin = Math.min(i, this.p.size());
        if (this.B0.a.w()) {
            m1(list, this.C0 == -1);
        } else {
            v1(C0(this.B0, iMin, list), 0, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final bc3 C0(bc3 bc3Var, int i, List list) {
        no4 no4Var = bc3Var.a;
        this.L++;
        List listA0 = A0(i, list);
        no4 no4VarH0 = H0();
        bc3 bc3VarY0 = Y0(bc3Var, no4VarH0, P0(no4Var, no4VarH0, O0(bc3Var), M0(bc3Var)));
        this.l.v(i, listA0, this.S);
        return bc3VarY0;
    }

    public final ph2 D0() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return this.A0;
        }
        return this.A0.b().N(currentTimeline.t(getCurrentMediaItemIndex(), this.a).c.e).L();
    }

    public final boolean E0(int i, int i2, List list) {
        if (i2 - i != list.size()) {
            return false;
        }
        for (int i3 = i; i3 < i2; i3++) {
            if (!((f) this.p.get(i3)).b.a((fg2) list.get(i3 - i))) {
                return false;
            }
        }
        return true;
    }

    public final int F0(boolean z) {
        if (this.O) {
            return 4;
        }
        r rVar = this.D;
        if (rVar == null || rVar.a()) {
            return (this.B0.n != 1 || z) ? 0 : 1;
        }
        return 3;
    }

    public final no4 H0() {
        return new bf3(this.p, this.S);
    }

    public final List I0(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.r.e((fg2) list.get(i)));
        }
        return arrayList;
    }

    public final n J0(n.b bVar) {
        int iO0 = O0(this.B0);
        h hVar = this.l;
        no4 no4Var = this.B0.a;
        if (iO0 == -1) {
            iO0 = 0;
        }
        return new n(hVar, bVar, no4Var, iO0, this.v, hVar.R());
    }

    public final Pair K0(bc3 bc3Var, bc3 bc3Var2, boolean z, int i, boolean z2, boolean z3) {
        no4 no4Var = bc3Var2.a;
        no4 no4Var2 = bc3Var.a;
        if (no4Var2.w() && no4Var.w()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (no4Var2.w() != no4Var.w()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (no4Var.t(no4Var.n(bc3Var2.b.a, this.o).c, this.a).a.equals(no4Var2.t(no4Var2.n(bc3Var.b.a, this.o).c, this.a).a)) {
            return (z && i == 0 && bc3Var2.b.d < bc3Var.b.d) ? new Pair(Boolean.TRUE, 0) : (z && i == 1 && z3) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            z20.a();
            return null;
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i2));
    }

    public zu L0() {
        return this.v;
    }

    public final long M0(bc3 bc3Var) {
        if (!bc3Var.b.c()) {
            return fy4.S1(N0(bc3Var));
        }
        bc3Var.a.n(bc3Var.b.a, this.o);
        return bc3Var.c == -9223372036854775807L ? bc3Var.a.t(O0(bc3Var), this.a).c() : this.o.o() + fy4.S1(bc3Var.c);
    }

    public final long N0(bc3 bc3Var) {
        if (bc3Var.a.w()) {
            return fy4.c1(this.D0);
        }
        long jM = bc3Var.p ? bc3Var.m() : bc3Var.s;
        return bc3Var.b.c() ? jM : e1(bc3Var.a, bc3Var.b, jM);
    }

    public final int O0(bc3 bc3Var) {
        return bc3Var.a.w() ? this.C0 : bc3Var.a.n(bc3Var.b.a, this.o).c;
    }

    public final Pair P0(no4 no4Var, no4 no4Var2, int i, long j) {
        if (no4Var.w() || no4Var2.w()) {
            boolean z = !no4Var.w() && no4Var2.w();
            return Z0(no4Var2, z ? -1 : i, z ? -9223372036854775807L : j);
        }
        Pair pairP = no4Var.p(this.a, this.o, i, fy4.c1(j));
        Object obj = ((Pair) fy4.l(pairP)).first;
        if (no4Var2.h(obj) != -1) {
            return pairP;
        }
        int iB1 = h.b1(this.a, this.o, this.J, this.K, obj, no4Var, no4Var2);
        return iB1 != -1 ? Z0(no4Var2, iB1, no4Var2.t(iB1, this.a).c()) : Z0(no4Var2, -1, -9223372036854775807L);
    }

    public Looper Q0() {
        return this.l.R();
    }

    @Override // defpackage.hd3
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public zv0 getPlayerError() {
        y1();
        return this.B0.f;
    }

    public final hd3.e S0(long j) {
        Object obj;
        fg2 fg2Var;
        Object obj2;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        int currentPeriodIndex = getCurrentPeriodIndex();
        if (this.B0.a.w()) {
            obj = null;
            fg2Var = null;
            obj2 = null;
        } else {
            bc3 bc3Var = this.B0;
            Object obj3 = bc3Var.b.a;
            bc3Var.a.n(obj3, this.o);
            currentPeriodIndex = this.B0.a.h(obj3);
            obj2 = obj3;
            obj = this.B0.a.t(currentMediaItemIndex, this.a).a;
            fg2Var = this.a.c;
        }
        int i = currentPeriodIndex;
        long jS1 = fy4.S1(j);
        long jS12 = this.B0.b.c() ? fy4.S1(U0(this.B0)) : jS1;
        jq2.b bVar = this.B0.b;
        return new hd3.e(obj, currentMediaItemIndex, fg2Var, obj2, i, jS1, jS12, bVar.b, bVar.c);
    }

    public final hd3.e T0(int i, bc3 bc3Var, int i2) {
        int i3;
        int i4;
        Object obj;
        fg2 fg2Var;
        Object obj2;
        long jU0;
        long jU02;
        no4.b bVar = new no4.b();
        if (bc3Var.a.w()) {
            i3 = i2;
            i4 = i3;
            obj = null;
            fg2Var = null;
            obj2 = null;
        } else {
            Object obj3 = bc3Var.b.a;
            bc3Var.a.n(obj3, bVar);
            int i5 = bVar.c;
            int iH = bc3Var.a.h(obj3);
            Object obj4 = bc3Var.a.t(i5, this.a).a;
            fg2Var = this.a.c;
            obj2 = obj3;
            i4 = iH;
            obj = obj4;
            i3 = i5;
        }
        jq2.b bVar2 = bc3Var.b;
        if (i == 0) {
            boolean zC = bVar2.c();
            jq2.b bVar3 = bc3Var.b;
            if (zC) {
                jU0 = bVar.c(bVar3.b, bVar3.c);
                jU02 = U0(bc3Var);
            } else {
                jU0 = bVar3.e != -1 ? U0(this.B0) : bVar.e + bVar.d;
                jU02 = jU0;
            }
        } else if (bVar2.c()) {
            jU0 = bc3Var.s;
            jU02 = U0(bc3Var);
        } else {
            jU0 = bVar.e + bc3Var.s;
            jU02 = jU0;
        }
        long jS1 = fy4.S1(jU0);
        long jS12 = fy4.S1(jU02);
        jq2.b bVar4 = bc3Var.b;
        return new hd3.e(obj, i3, fg2Var, obj2, i4, jS1, jS12, bVar4.b, bVar4.c);
    }

    public final void V0(h.e eVar) {
        int i;
        long j;
        boolean z;
        long jE1;
        int i2 = this.L - eVar.c;
        this.L = i2;
        boolean z2 = true;
        if (eVar.d) {
            this.M = eVar.e;
            this.N = true;
        }
        if (i2 == 0) {
            no4 no4Var = eVar.b.a;
            int currentMediaItemIndex = -1;
            if (!this.B0.a.w() && no4Var.w()) {
                this.C0 = -1;
                this.D0 = 0L;
            }
            if (!no4Var.w()) {
                List listM = ((bf3) no4Var).M();
                gg3.v(listM.size() == this.p.size());
                for (int i3 = 0; i3 < listM.size(); i3++) {
                    ((f) this.p.get(i3)).d((no4) listM.get(i3));
                }
            }
            long j2 = -9223372036854775807L;
            if (this.N) {
                boolean z3 = eVar.b.a.w() && this.B0.a.w();
                boolean zEquals = eVar.b.b.equals(this.B0.b);
                boolean z4 = eVar.b.d == this.B0.s;
                if (z3 || (zEquals && z4)) {
                    z2 = false;
                }
                if (z2) {
                    currentMediaItemIndex = getCurrentMediaItemIndex();
                    if (no4Var.w() || eVar.b.b.c()) {
                        jE1 = eVar.b.d;
                    } else {
                        bc3 bc3Var = eVar.b;
                        jE1 = e1(no4Var, bc3Var.b, bc3Var.d);
                    }
                    j2 = jE1;
                }
                z = z2;
                long j3 = j2;
                i = currentMediaItemIndex;
                j = j3;
            } else {
                i = -1;
                j = -9223372036854775807L;
                z = false;
            }
            this.N = false;
            v1(eVar.b, 1, z, this.M, j, i, false);
        }
    }

    public boolean W0() {
        y1();
        return this.B0.p;
    }

    public final bc3 Y0(bc3 bc3Var, no4 no4Var, Pair pair) {
        gg3.d(no4Var.w() || pair != null);
        no4 no4Var2 = bc3Var.a;
        long jM0 = M0(bc3Var);
        bc3 bc3VarJ = bc3Var.j(no4Var);
        if (no4Var.w()) {
            jq2.b bVarL = bc3.l();
            long jC1 = fy4.c1(this.D0);
            bc3 bc3VarC = bc3VarJ.d(bVarL, jC1, jC1, jC1, 0L, er4.d, this.b, xi1.u()).c(bVarL);
            bc3VarC.q = bc3VarC.s;
            return bc3VarC;
        }
        Object obj = bc3VarJ.b.a;
        boolean zEquals = obj.equals(((Pair) fy4.l(pair)).first);
        jq2.b bVar = !zEquals ? new jq2.b(pair.first) : bc3VarJ.b;
        long jLongValue = ((Long) pair.second).longValue();
        long jC12 = fy4.c1(jM0);
        if (!no4Var2.w()) {
            jC12 -= no4Var2.n(obj, this.o).p();
            if (zEquals && jC12 - jLongValue == 1 && jC12 == no4Var2.n(obj, this.o).d) {
                jC12--;
            }
        }
        if (!zEquals || jLongValue < jC12) {
            jq2.b bVar2 = bVar;
            gg3.v(!bVar2.c());
            bc3 bc3VarC2 = bc3VarJ.d(bVar2, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? er4.d : bc3VarJ.h, !zEquals ? this.b : bc3VarJ.i, !zEquals ? xi1.u() : bc3VarJ.j).c(bVar2);
            bc3VarC2.q = jLongValue;
            return bc3VarC2;
        }
        if (jLongValue != jC12) {
            jq2.b bVar3 = bVar;
            gg3.v(!bVar3.c());
            long jMax = Math.max(0L, bc3VarJ.r - (jLongValue - jC12));
            long j = bc3VarJ.q;
            if (bc3VarJ.k.equals(bc3VarJ.b)) {
                j = jLongValue + jMax;
            }
            bc3 bc3VarD = bc3VarJ.d(bVar3, jLongValue, jLongValue, jLongValue, jMax, bc3VarJ.h, bc3VarJ.i, bc3VarJ.j);
            bc3VarD.q = j;
            return bc3VarD;
        }
        int iH = no4Var.h(bc3VarJ.k.a);
        if (iH != -1 && no4Var.l(iH, this.o).c == no4Var.n(bVar.a, this.o).c) {
            return bc3VarJ;
        }
        no4Var.n(bVar.a, this.o);
        boolean zC = bVar.c();
        no4.b bVar4 = this.o;
        long jC = zC ? bVar4.c(bVar.b, bVar.c) : bVar4.d;
        jq2.b bVar5 = bVar;
        bc3 bc3VarC3 = bc3VarJ.d(bVar5, bc3VarJ.s, bc3VarJ.s, bc3VarJ.d, jC - bc3VarJ.s, bc3VarJ.h, bc3VarJ.i, bc3VarJ.j).c(bVar5);
        bc3VarC3.q = jC;
        return bc3VarC3;
    }

    public final Pair Z0(no4 no4Var, int i, long j) {
        if (no4Var.w()) {
            this.C0 = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.D0 = j;
            return null;
        }
        if (i == -1 || i >= no4Var.v()) {
            i = no4Var.g(this.K);
            j = no4Var.t(i, this.a).c();
        }
        return no4Var.p(this.a, this.o, i, fy4.c1(j));
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void a(boolean z) {
        y1();
        if (this.u0) {
            return;
        }
        this.y.d(z);
    }

    public final void a1(final int i, final int i2) {
        if (i == this.i0.b() && i2 == this.i0.a()) {
            return;
        }
        this.i0 = new d94(i, i2);
        this.m.k(24, new pu1.a() { // from class: rw0
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((hd3.d) obj).onSurfaceSizeChanged(i, i2);
            }
        });
        i1(2, 14, new d94(i, i2));
    }

    @Override // defpackage.hd3
    public void addListener(hd3.d dVar) {
        this.m.c((hd3.d) gg3.q(dVar));
    }

    @Override // defpackage.hd3
    public void addMediaItems(int i, List list) {
        y1();
        B0(i, I0(list));
    }

    public final void b1() {
        bc3 bc3Var = this.B0;
        u1(bc3Var.l, bc3Var.m);
    }

    public final void c1(int i, final int i2) {
        y1();
        i1(1, 10, Integer.valueOf(i2));
        i1(2, 10, Integer.valueOf(i2));
        this.m.k(21, new pu1.a() { // from class: gx0
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((hd3.d) obj).onAudioSessionIdChanged(i2);
            }
        });
    }

    @Override // defpackage.hd3
    public void clearVideoSurface() {
        y1();
        h1();
        q1(null);
        a1(0, 0);
    }

    @Override // defpackage.hd3
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        y1();
        if (surfaceHolder == null || surfaceHolder != this.c0) {
            return;
        }
        clearVideoSurface();
    }

    @Override // defpackage.hd3
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        y1();
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // defpackage.hd3
    public void clearVideoTextureView(TextureView textureView) {
        y1();
        if (textureView == null || textureView != this.f0) {
            return;
        }
        clearVideoSurface();
    }

    public final void d1(boolean z) {
        if (this.u0) {
            return;
        }
        if (!z) {
            b1();
        } else if (this.B0.n == 3) {
            b1();
        }
    }

    @Override // defpackage.hd3
    public void decreaseDeviceVolume() {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.r(1);
        }
    }

    @Override // defpackage.mi
    public void e(int i, long j, int i2, boolean z) {
        y1();
        if (i == -1) {
            return;
        }
        gg3.d(i >= 0);
        no4 no4Var = this.B0.a;
        if (no4Var.w() || i < no4Var.v()) {
            this.s.U();
            this.L++;
            if (isPlayingAd()) {
                xz1.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                h.e eVar = new h.e(this.B0);
                eVar.b(1);
                this.k.a(eVar);
                return;
            }
            bc3 bc3VarX0 = this.B0;
            int i3 = bc3VarX0.e;
            if (i3 == 3 || (i3 == 4 && !no4Var.w())) {
                bc3VarX0 = X0(this.B0, 2);
            }
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            bc3 bc3VarY0 = Y0(bc3VarX0, no4Var, Z0(no4Var, i, j));
            this.l.d1(no4Var, i, fy4.c1(j));
            v1(bc3VarY0, 0, true, 1, N0(bc3VarY0), currentMediaItemIndex, z);
        }
    }

    public final long e1(no4 no4Var, jq2.b bVar, long j) {
        no4Var.n(bVar.a, this.o);
        return j + this.o.p();
    }

    public final bc3 f1(bc3 bc3Var, int i, int i2) {
        int iO0 = O0(bc3Var);
        long jM0 = M0(bc3Var);
        no4 no4Var = bc3Var.a;
        this.L++;
        g1(i, i2);
        no4 no4VarH0 = H0();
        bc3 bc3VarY0 = Y0(bc3Var, no4VarH0, P0(no4Var, no4VarH0, iO0, jM0));
        int i3 = bc3VarY0.e;
        if (i3 != 1 && i3 != 4 && iO0 >= i && iO0 < i2) {
            if (h.b1(this.a, this.o, this.J, this.K, bc3Var.b.a, no4Var, no4VarH0) == -1) {
                bc3VarY0 = X0(bc3VarY0, 4);
            }
        }
        this.l.Q0(i, i2, this.S);
        return bc3VarY0;
    }

    public final void g1(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.p.remove(i3);
        }
        this.S = this.S.a(i, i2);
    }

    @Override // defpackage.hd3
    public Looper getApplicationLooper() {
        return this.t;
    }

    @Override // defpackage.hd3
    public yb getAudioAttributes() {
        y1();
        return this.l0;
    }

    @Override // defpackage.hd3
    public int getAudioSessionId() {
        y1();
        return ((Integer) this.E.d()).intValue();
    }

    @Override // defpackage.hd3
    public hd3.b getAvailableCommands() {
        y1();
        return this.V;
    }

    @Override // defpackage.hd3
    public long getBufferedPosition() {
        y1();
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        bc3 bc3Var = this.B0;
        return bc3Var.k.equals(bc3Var.b) ? fy4.S1(this.B0.q) : getDuration();
    }

    @Override // defpackage.hd3
    public long getContentBufferedPosition() {
        y1();
        if (this.B0.a.w()) {
            return this.D0;
        }
        bc3 bc3Var = this.B0;
        if (bc3Var.k.d != bc3Var.b.d) {
            return bc3Var.a.t(getCurrentMediaItemIndex(), this.a).e();
        }
        long j = bc3Var.q;
        if (this.B0.k.c()) {
            bc3 bc3Var2 = this.B0;
            no4.b bVarN = bc3Var2.a.n(bc3Var2.k.a, this.o);
            long jG = bVarN.g(this.B0.k.b);
            j = jG == Long.MIN_VALUE ? bVarN.d : jG;
        }
        bc3 bc3Var3 = this.B0;
        return fy4.S1(e1(bc3Var3.a, bc3Var3.k, j));
    }

    @Override // defpackage.hd3
    public long getContentPosition() {
        y1();
        return M0(this.B0);
    }

    @Override // defpackage.hd3
    public int getCurrentAdGroupIndex() {
        y1();
        if (isPlayingAd()) {
            return this.B0.b.b;
        }
        return -1;
    }

    @Override // defpackage.hd3
    public int getCurrentAdIndexInAdGroup() {
        y1();
        if (isPlayingAd()) {
            return this.B0.b.c;
        }
        return -1;
    }

    @Override // defpackage.hd3
    public w50 getCurrentCues() {
        y1();
        return this.p0;
    }

    @Override // defpackage.hd3
    public int getCurrentMediaItemIndex() {
        y1();
        int iO0 = O0(this.B0);
        if (iO0 == -1) {
            return 0;
        }
        return iO0;
    }

    @Override // defpackage.hd3
    public int getCurrentPeriodIndex() {
        y1();
        if (!this.B0.a.w()) {
            bc3 bc3Var = this.B0;
            return bc3Var.a.h(bc3Var.b.a);
        }
        int i = this.C0;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // defpackage.hd3
    public long getCurrentPosition() {
        y1();
        return fy4.S1(N0(this.B0));
    }

    @Override // defpackage.hd3
    public no4 getCurrentTimeline() {
        y1();
        return this.B0.a;
    }

    @Override // defpackage.hd3
    public xr4 getCurrentTracks() {
        y1();
        return this.B0.i.d;
    }

    @Override // defpackage.hd3
    public kk0 getDeviceInfo() {
        y1();
        return this.v0;
    }

    @Override // defpackage.hd3
    public int getDeviceVolume() {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            return qVar.v();
        }
        return 0;
    }

    @Override // defpackage.hd3
    public long getDuration() {
        y1();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        bc3 bc3Var = this.B0;
        jq2.b bVar = bc3Var.b;
        bc3Var.a.n(bVar.a, this.o);
        return fy4.S1(this.o.c(bVar.b, bVar.c));
    }

    @Override // defpackage.hd3
    public long getMaxSeekToPreviousPosition() {
        y1();
        return this.z0;
    }

    @Override // defpackage.hd3
    public ph2 getMediaMetadata() {
        y1();
        return this.W;
    }

    @Override // defpackage.hd3
    public boolean getPlayWhenReady() {
        y1();
        return this.B0.l;
    }

    @Override // defpackage.hd3
    public dc3 getPlaybackParameters() {
        y1();
        return this.B0.o;
    }

    @Override // defpackage.hd3
    public int getPlaybackState() {
        y1();
        return this.B0.e;
    }

    @Override // defpackage.hd3
    public int getPlaybackSuppressionReason() {
        y1();
        return this.B0.n;
    }

    @Override // defpackage.hd3
    public ph2 getPlaylistMetadata() {
        y1();
        return this.X;
    }

    @Override // defpackage.hd3
    public int getRepeatMode() {
        y1();
        return this.J;
    }

    @Override // defpackage.hd3
    public long getSeekBackIncrement() {
        y1();
        return this.x0;
    }

    @Override // defpackage.hd3
    public long getSeekForwardIncrement() {
        y1();
        return this.y0;
    }

    @Override // defpackage.hd3
    public boolean getShuffleModeEnabled() {
        y1();
        return this.K;
    }

    @Override // defpackage.hd3
    public d94 getSurfaceSize() {
        y1();
        return this.i0;
    }

    @Override // defpackage.hd3
    public long getTotalBufferedDuration() {
        y1();
        return fy4.S1(this.B0.r);
    }

    @Override // defpackage.hd3
    public lr4 getTrackSelectionParameters() {
        y1();
        lr4 lr4VarC = this.i.c();
        return this.O ? lr4VarC.M().R(this.P).K() : lr4VarC;
    }

    @Override // defpackage.hd3
    public e35 getVideoSize() {
        y1();
        return this.w0;
    }

    @Override // defpackage.hd3
    public float getVolume() {
        y1();
        return this.m0;
    }

    public final void h1() {
        if (this.d0 != null) {
            J0(this.x).m(FileTime.NANO100_TO_MILLI).l(null).k();
            this.d0.g(this.w);
            this.d0 = null;
        }
        TextureView textureView = this.f0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.w) {
                xz1.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f0.setSurfaceTextureListener(null);
            }
            this.f0 = null;
        }
        SurfaceHolder surfaceHolder = this.c0;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.w);
            this.c0 = null;
        }
    }

    public final void i1(int i, int i2, Object obj) {
        for (o oVar : this.g) {
            if (i == -1 || oVar.d() == i) {
                J0(oVar).m(i2).l(obj).k();
            }
        }
        for (o oVar2 : this.h) {
            if (oVar2 != null && (i == -1 || oVar2.d() == i)) {
                J0(oVar2).m(i2).l(obj).k();
            }
        }
    }

    @Override // defpackage.hd3
    public void increaseDeviceVolume() {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.w(1);
        }
    }

    @Override // defpackage.hd3
    public boolean isDeviceMuted() {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            return qVar.x();
        }
        return false;
    }

    @Override // defpackage.hd3
    public boolean isLoading() {
        y1();
        return this.B0.g;
    }

    @Override // defpackage.hd3
    public boolean isPlayingAd() {
        y1();
        return this.B0.b.c();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public boolean isScrubbingModeEnabled() {
        y1();
        return this.O;
    }

    public final void j1(int i, Object obj) {
        i1(-1, i, obj);
    }

    public final List k1(List list, int i) {
        this.p.clear();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            m.c cVar = new m.c((jq2) list.get(i2), this.q);
            arrayList.add(cVar);
            this.p.add(i2, new f(cVar.b, cVar.a));
        }
        this.S = this.S.b(arrayList.size(), i);
        return arrayList;
    }

    public void l1(List list, int i, long j) {
        y1();
        n1(list, i, j, false);
    }

    public void m1(List list, boolean z) {
        y1();
        n1(list, -1, -9223372036854775807L, z);
    }

    @Override // defpackage.hd3
    public void moveMediaItems(int i, int i2, int i3) {
        y1();
        gg3.d(i >= 0 && i <= i2 && i3 >= 0);
        int size = this.p.size();
        int iMin = Math.min(i2, size);
        int iMin2 = Math.min(i3, size - (iMin - i));
        if (i >= size || i == iMin || i == iMin2) {
            return;
        }
        no4 currentTimeline = getCurrentTimeline();
        this.L++;
        fy4.b1(this.p, i, iMin, iMin2);
        this.S = this.S.g(i, iMin, iMin2);
        no4 no4VarH0 = H0();
        bc3 bc3Var = this.B0;
        bc3 bc3VarY0 = Y0(bc3Var, no4VarH0, P0(currentTimeline, no4VarH0, O0(bc3Var), M0(this.B0)));
        this.l.F0(i, iMin, iMin2, this.S);
        v1(bc3VarY0, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // defpackage.hd3
    public void mute() {
        y1();
        if (this.m0 != 0.0f) {
            setVolume(0.0f);
        }
    }

    public final void n1(List list, int i, long j, boolean z) {
        long j2;
        int iG;
        int i2;
        int iO0 = O0(this.B0);
        long currentPosition = getCurrentPosition();
        this.L++;
        List listK1 = k1(list, i);
        no4 no4VarH0 = H0();
        if (!no4VarH0.w() && i >= no4VarH0.v()) {
            throw new ci1(no4VarH0, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            iG = no4VarH0.g(this.K);
        } else if (i == -1) {
            iG = iO0;
            j2 = currentPosition;
        } else {
            j2 = j;
            iG = i;
        }
        bc3 bc3VarY0 = Y0(this.B0, no4VarH0, Z0(no4VarH0, iG, j2));
        if (bc3VarY0.e == 1) {
            i2 = 1;
        } else {
            i2 = 4;
            if (!no4VarH0.w()) {
                if (iG == -1) {
                    i2 = bc3VarY0.e;
                } else if (iG < no4VarH0.v()) {
                    i2 = 2;
                }
            }
        }
        bc3 bc3VarX0 = X0(bc3VarY0, i2);
        this.l.r1(listK1, iG, fy4.c1(j2), this.S);
        v1(bc3VarX0, 0, (this.B0.b.a.equals(bc3VarX0.b.a) || this.B0.a.w()) ? false : true, 4, N0(bc3VarX0), -1, false);
    }

    public final void o1(SurfaceHolder surfaceHolder) {
        this.e0 = false;
        this.c0 = surfaceHolder;
        surfaceHolder.addCallback(this.w);
        Surface surface = this.c0.getSurface();
        if (surface == null || !surface.isValid()) {
            a1(0, 0);
        } else {
            Rect surfaceFrame = this.c0.getSurfaceFrame();
            a1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void p1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        q1(surface);
        this.b0 = surface;
    }

    @Override // defpackage.hd3
    public void prepare() {
        y1();
        bc3 bc3Var = this.B0;
        if (bc3Var.e != 1) {
            return;
        }
        bc3 bc3VarF = bc3Var.f(null);
        bc3 bc3VarX0 = X0(bc3VarF, bc3VarF.a.w() ? 4 : 2);
        this.L++;
        this.l.K0();
        v1(bc3VarX0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final void q1(Object obj) {
        Object obj2 = this.a0;
        boolean z = (obj2 == null || obj2 == obj) ? false : true;
        boolean zL1 = this.l.L1(obj, z ? this.C : -9223372036854775807L);
        if (z) {
            Object obj3 = this.a0;
            Surface surface = this.b0;
            if (obj3 == surface) {
                surface.release();
                this.b0 = null;
            }
        }
        this.a0 = obj;
        if (zL1) {
            return;
        }
        r1(zv0.m(new iy0(3), 1003));
    }

    public final void r1(zv0 zv0Var) {
        bc3 bc3Var = this.B0;
        bc3 bc3VarC = bc3Var.c(bc3Var.b);
        bc3VarC.q = bc3VarC.s;
        bc3VarC.r = 0L;
        bc3 bc3VarX0 = X0(bc3VarC, 1);
        if (zv0Var != null) {
            bc3VarX0 = bc3VarX0.f(zv0Var);
        }
        this.L++;
        this.l.W1();
        v1(bc3VarX0, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // defpackage.hd3
    public void release() {
        xz1.g("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.0] [" + fy4.e + "] [" + kg2.b() + "]");
        y1();
        this.y.d(false);
        q qVar = this.z;
        if (qVar != null) {
            qVar.z();
        }
        this.A.g(false);
        this.B.g(false);
        r rVar = this.D;
        if (rVar != null) {
            rVar.disable();
        }
        C0019g c0019g = this.G;
        if (c0019g != null && Build.VERSION.SDK_INT >= 34) {
            c0019g.d();
        }
        this.F.j();
        if (!this.l.M0()) {
            this.m.k(10, new pu1.a() { // from class: sw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlayerError(zv0.m(new iy0(1), 1003));
                }
            });
        }
        this.m.i();
        this.j.m(null);
        this.u.f(this.s);
        bc3 bc3Var = this.B0;
        if (bc3Var.p) {
            this.B0 = bc3Var.a();
        }
        bc3 bc3VarX0 = X0(this.B0, 1);
        this.B0 = bc3VarX0;
        bc3 bc3VarC = bc3VarX0.c(bc3VarX0.b);
        this.B0 = bc3VarC;
        bc3VarC.q = bc3VarC.s;
        this.B0.r = 0L;
        this.s.release();
        h1();
        Surface surface = this.b0;
        if (surface != null) {
            surface.release();
            this.b0 = null;
        }
        if (this.t0) {
            w82.a(gg3.q(null));
            throw null;
        }
        this.p0 = w50.d;
        this.u0 = true;
    }

    @Override // defpackage.hd3
    public void removeListener(hd3.d dVar) {
        y1();
        this.m.j((hd3.d) gg3.q(dVar));
    }

    @Override // defpackage.hd3
    public void removeMediaItems(int i, int i2) {
        y1();
        gg3.d(i >= 0 && i2 >= i);
        int size = this.p.size();
        int iMin = Math.min(i2, size);
        if (i >= size || i == iMin) {
            return;
        }
        bc3 bc3VarF1 = f1(this.B0, i, iMin);
        v1(bc3VarF1, 0, !bc3VarF1.b.a.equals(this.B0.b.a), 4, N0(bc3VarF1), -1, false);
    }

    @Override // defpackage.hd3
    public void replaceMediaItems(int i, int i2, List list) {
        y1();
        gg3.d(i >= 0 && i2 >= i);
        int size = this.p.size();
        if (i > size) {
            return;
        }
        int iMin = Math.min(i2, size);
        if (E0(i, iMin, list)) {
            t1(i, iMin, list);
            return;
        }
        List listI0 = I0(list);
        if (this.B0.a.w()) {
            m1(listI0, this.C0 == -1);
        } else {
            bc3 bc3VarF1 = f1(C0(this.B0, iMin, listI0), i, iMin);
            v1(bc3VarF1, 0, !bc3VarF1.b.a.equals(this.B0.b.a), 4, N0(bc3VarF1), -1, false);
        }
    }

    public final void s1() {
        hd3.b bVar = this.V;
        hd3.b bVarU = fy4.U(this.f, this.c);
        this.V = bVarU;
        if (bVarU.equals(bVar)) {
            return;
        }
        this.m.h(13, new pu1.a() { // from class: fx0
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((hd3.d) obj).onAvailableCommandsChanged(this.a.V);
            }
        });
    }

    @Override // defpackage.hd3
    public void setAudioAttributes(final yb ybVar, boolean z) {
        y1();
        if (this.u0) {
            return;
        }
        if (!Objects.equals(this.l0, ybVar)) {
            this.l0 = ybVar;
            i1(1, 3, ybVar);
            q qVar = this.z;
            if (qVar != null) {
                qVar.B(ybVar.e());
            }
            this.m.h(20, new pu1.a() { // from class: cx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onAudioAttributesChanged(ybVar);
                }
            });
        }
        this.l.m1(this.l0, z);
        this.m.e();
    }

    @Override // defpackage.hd3
    public void setDeviceMuted(boolean z) {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.A(z, 1);
        }
    }

    @Override // defpackage.hd3
    public void setDeviceVolume(int i) {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.C(i, 1);
        }
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void setImageOutput(ImageOutput imageOutput) {
        y1();
        i1(4, 15, imageOutput);
    }

    @Override // defpackage.hd3
    public void setMediaItems(List list, boolean z) {
        y1();
        m1(I0(list), z);
    }

    @Override // defpackage.hd3
    public void setPlayWhenReady(boolean z) {
        y1();
        u1(z, 1);
    }

    @Override // defpackage.hd3
    public void setPlaybackParameters(dc3 dc3Var) {
        y1();
        if (dc3Var == null) {
            dc3Var = dc3.d;
        }
        if (this.B0.o.equals(dc3Var)) {
            return;
        }
        bc3 bc3VarG = this.B0.g(dc3Var);
        this.L++;
        this.l.w1(dc3Var);
        v1(bc3VarG, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // defpackage.hd3
    public void setPlaylistMetadata(ph2 ph2Var) {
        y1();
        gg3.q(ph2Var);
        if (ph2Var.equals(this.X)) {
            return;
        }
        this.X = ph2Var;
        this.m.k(15, new pu1.a() { // from class: uw0
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((hd3.d) obj).onPlaylistMetadataChanged(this.a.X);
            }
        });
    }

    @Override // defpackage.hd3
    public void setRepeatMode(final int i) {
        y1();
        if (this.J != i) {
            this.J = i;
            this.l.z1(i);
            this.m.h(8, new pu1.a() { // from class: tw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onRepeatModeChanged(i);
                }
            });
            s1();
            this.m.e();
        }
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void setScrubbingModeEnabled(boolean z) {
        lr4 lr4VarK;
        y1();
        if (z == this.O) {
            return;
        }
        this.O = z;
        if (!this.Q.a.isEmpty() && this.i.h()) {
            lr4 lr4VarC = this.i.c();
            if (z) {
                this.P = lr4VarC.I;
                lr4VarK = z0(lr4VarC, this.Q.a);
            } else {
                lr4VarK = lr4VarC.M().R(this.P).K();
                this.P = null;
            }
            if (!lr4VarK.equals(lr4VarC)) {
                this.i.m(lr4VarK);
            }
        }
        this.l.B1(z);
        b1();
    }

    @Override // defpackage.hd3
    public void setShuffleModeEnabled(final boolean z) {
        y1();
        if (this.K != z) {
            this.K = z;
            this.l.G1(z);
            this.m.h(9, new pu1.a() { // from class: vw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onShuffleModeEnabledChanged(z);
                }
            });
            s1();
            this.m.e();
        }
    }

    @Override // defpackage.hd3
    public void setTrackSelectionParameters(final lr4 lr4Var) {
        lr4 lr4VarZ0;
        y1();
        if (this.i.h()) {
            lr4 trackSelectionParameters = getTrackSelectionParameters();
            if (this.O) {
                this.P = lr4Var.I;
                lr4VarZ0 = z0(lr4Var, this.Q.a);
            } else {
                lr4VarZ0 = lr4Var;
            }
            if (!lr4VarZ0.equals(this.i.c())) {
                this.i.m(lr4VarZ0);
            }
            if (trackSelectionParameters.equals(lr4Var)) {
                return;
            }
            this.m.k(19, new pu1.a() { // from class: dx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onTrackSelectionParametersChanged(lr4Var);
                }
            });
        }
    }

    @Override // defpackage.hd3
    public void setVideoSurface(Surface surface) {
        y1();
        h1();
        q1(surface);
        int i = surface == null ? 0 : -1;
        a1(i, i);
    }

    @Override // defpackage.hd3
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        y1();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        h1();
        this.e0 = true;
        this.c0 = surfaceHolder;
        surfaceHolder.addCallback(this.w);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            q1(null);
            a1(0, 0);
        } else {
            q1(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            a1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // defpackage.hd3
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        y1();
        if (surfaceView instanceof i25) {
            h1();
            q1(surfaceView);
            o1(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof dc4)) {
                setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            h1();
            this.d0 = (dc4) surfaceView;
            J0(this.x).m(FileTime.NANO100_TO_MILLI).l(this.d0).k();
            this.d0.d(this.w);
            q1(this.d0.getVideoSurface());
            o1(surfaceView.getHolder());
        }
    }

    @Override // defpackage.hd3
    public void setVideoTextureView(TextureView textureView) {
        y1();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        h1();
        this.f0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            xz1.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.w);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            q1(null);
            a1(0, 0);
        } else {
            p1(surfaceTexture);
            a1(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // defpackage.hd3
    public void setVolume(float f2) {
        y1();
        final float fR = fy4.r(f2, 0.0f, 1.0f);
        float f3 = this.m0;
        if (f3 == fR) {
            return;
        }
        if (fR != 0.0f) {
            f3 = fR;
        }
        this.n0 = f3;
        this.m0 = fR;
        this.l.N1(fR);
        this.m.k(22, new pu1.a() { // from class: qw0
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((hd3.d) obj).onVolumeChanged(fR);
            }
        });
    }

    @Override // defpackage.hd3
    public void stop() {
        y1();
        r1(null);
        this.p0 = new w50(xi1.u(), this.B0.s);
    }

    public final void t1(int i, int i2, List list) {
        this.L++;
        this.l.b2(i, i2, list);
        for (int i3 = i; i3 < i2; i3++) {
            f fVar = (f) this.p.get(i3);
            fVar.d(oo4.z(fVar.b(), (fg2) list.get(i3 - i)));
        }
        v1(this.B0.j(H0()), 0, false, 4, -9223372036854775807L, -1, false);
    }

    public final void u1(boolean z, int i) {
        int iF0 = F0(z);
        bc3 bc3VarA = this.B0;
        if (bc3VarA.l == z && bc3VarA.n == iF0 && bc3VarA.m == i) {
            return;
        }
        this.L++;
        if (bc3VarA.p) {
            bc3VarA = bc3VarA.a();
        }
        bc3 bc3VarE = bc3VarA.e(z, i, iF0);
        this.l.u1(z, i, iF0);
        v1(bc3VarE, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // defpackage.hd3
    public void unmute() {
        y1();
        if (this.m0 == 0.0f) {
            float f2 = this.n0;
            if (f2 != 0.0f) {
                setVolume(f2);
            }
        }
    }

    public final void v1(final bc3 bc3Var, final int i, boolean z, final int i2, long j, int i3, boolean z2) {
        bc3 bc3Var2 = this.B0;
        this.B0 = bc3Var;
        boolean zEquals = bc3Var2.a.equals(bc3Var.a);
        Pair pairK0 = K0(bc3Var, bc3Var2, z, i2, !zEquals, z2);
        boolean zBooleanValue = ((Boolean) pairK0.first).booleanValue();
        final int iIntValue = ((Integer) pairK0.second).intValue();
        if (zBooleanValue) {
            fg2Var = bc3Var.a.w() ? null : bc3Var.a.t(bc3Var.a.n(bc3Var.b.a, this.o).c, this.a).c;
            this.A0 = ph2.M;
        }
        if (zBooleanValue || !bc3Var2.j.equals(bc3Var.j)) {
            this.A0 = this.A0.b().P(bc3Var.j).L();
        }
        ph2 ph2VarD0 = D0();
        boolean zEquals2 = ph2VarD0.equals(this.W);
        this.W = ph2VarD0;
        boolean z3 = bc3Var2.l != bc3Var.l;
        boolean z4 = bc3Var2.e != bc3Var.e;
        if (z4 || z3) {
            x1();
        }
        boolean z5 = bc3Var2.g;
        boolean z6 = bc3Var.g;
        boolean z7 = z5 != z6;
        if (z7) {
            w1(z6);
        }
        if (!zEquals) {
            this.m.h(0, new pu1.a() { // from class: lw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    hd3.d dVar = (hd3.d) obj;
                    dVar.onTimelineChanged(bc3Var.a, i);
                }
            });
        }
        if (z) {
            final hd3.e eVarT0 = T0(i2, bc3Var2, i3);
            final hd3.e eVarS0 = S0(j);
            this.m.h(11, new pu1.a() { // from class: kx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    g.p(i2, eVarT0, eVarS0, (hd3.d) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.m.h(1, new pu1.a() { // from class: lx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMediaItemTransition(fg2Var, iIntValue);
                }
            });
        }
        if (bc3Var2.f != bc3Var.f) {
            this.m.h(10, new pu1.a() { // from class: mx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlayerErrorChanged(bc3Var.f);
                }
            });
            if (bc3Var.f != null) {
                this.m.h(10, new pu1.a() { // from class: nx0
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onPlayerError(bc3Var.f);
                    }
                });
            }
        }
        pr4 pr4Var = bc3Var2.i;
        pr4 pr4Var2 = bc3Var.i;
        if (pr4Var != pr4Var2) {
            this.i.i(pr4Var2.e);
            this.m.h(2, new pu1.a() { // from class: ox0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onTracksChanged(bc3Var.i.d);
                }
            });
        }
        if (!zEquals2) {
            final ph2 ph2Var = this.W;
            this.m.h(14, new pu1.a() { // from class: mw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMediaMetadataChanged(ph2Var);
                }
            });
        }
        if (z7) {
            this.m.h(3, new pu1.a() { // from class: nw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    g.G(bc3Var, (hd3.d) obj);
                }
            });
        }
        if (z4 || z3) {
            this.m.h(-1, new pu1.a() { // from class: ow0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    bc3 bc3Var3 = bc3Var;
                    ((hd3.d) obj).onPlayerStateChanged(bc3Var3.l, bc3Var3.e);
                }
            });
        }
        if (z4) {
            this.m.h(4, new pu1.a() { // from class: pw0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackStateChanged(bc3Var.e);
                }
            });
        }
        if (z3 || bc3Var2.m != bc3Var.m) {
            this.m.h(5, new pu1.a() { // from class: ww0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    bc3 bc3Var3 = bc3Var;
                    ((hd3.d) obj).onPlayWhenReadyChanged(bc3Var3.l, bc3Var3.m);
                }
            });
        }
        if (bc3Var2.n != bc3Var.n) {
            this.m.h(6, new pu1.a() { // from class: hx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackSuppressionReasonChanged(bc3Var.n);
                }
            });
        }
        if (bc3Var2.n() != bc3Var.n()) {
            this.m.h(7, new pu1.a() { // from class: ix0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onIsPlayingChanged(bc3Var.n());
                }
            });
        }
        if (!bc3Var2.o.equals(bc3Var.o)) {
            this.m.h(12, new pu1.a() { // from class: jx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onPlaybackParametersChanged(bc3Var.o);
                }
            });
        }
        s1();
        this.m.e();
        if (bc3Var2.p != bc3Var.p) {
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                ((ExoPlayer.a) it.next()).C(bc3Var.p);
            }
        }
    }

    public final void w1(boolean z) {
    }

    public void x0(p5 p5Var) {
        this.s.j0((p5) gg3.q(p5Var));
    }

    public final void x1() {
        int playbackState = getPlaybackState();
        boolean z = false;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                boolean zW0 = W0();
                l85 l85Var = this.A;
                if (getPlayWhenReady() && !zW0) {
                    z = true;
                }
                l85Var.g(z);
                this.B.g(getPlayWhenReady());
                return;
            }
            if (playbackState != 4) {
                z20.a();
                return;
            }
        }
        this.A.g(false);
        this.B.g(false);
    }

    public void y0(ExoPlayer.a aVar) {
        this.n.add(aVar);
    }

    public final void y1() {
        this.d.b();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String strM = fy4.M("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (this.q0) {
                e04.a(strM);
            } else {
                xz1.j("ExoPlayerImpl", strM, this.r0 ? null : new IllegalStateException());
                this.r0 = true;
            }
        }
    }

    @Override // defpackage.hd3
    public void setMediaItems(List list, int i, long j) {
        y1();
        l1(I0(list), i, j);
    }

    @Override // defpackage.hd3
    public void decreaseDeviceVolume(int i) {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.r(i);
        }
    }

    @Override // defpackage.hd3
    public void increaseDeviceVolume(int i) {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.w(i);
        }
    }

    @Override // defpackage.hd3
    public void setDeviceMuted(boolean z, int i) {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.A(z, i);
        }
    }

    @Override // defpackage.hd3
    public void setDeviceVolume(int i, int i2) {
        y1();
        q qVar = this.z;
        if (qVar != null) {
            qVar.C(i, i2);
        }
    }

    @Override // defpackage.hd3
    public void clearVideoSurface(Surface surface) {
        y1();
        if (surface == null || surface != this.a0) {
            return;
        }
        clearVideoSurface();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d implements c35, od, tm4, et2, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, dc4.b, bc.c, q.b, ExoPlayer.a, ih4.b {
        public d() {
        }

        @Override // dc4.b
        public void A(Surface surface) {
            g.this.q1(surface);
        }

        @Override // androidx.media3.exoplayer.q.b
        public void B(final int i, final boolean z) {
            g.this.m.k(30, new pu1.a() { // from class: xx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onDeviceVolumeChanged(i, z);
                }
            });
        }

        @Override // androidx.media3.exoplayer.ExoPlayer.a
        public void C(boolean z) {
            g.this.x1();
        }

        @Override // ih4.b
        public void D(jh4 jh4Var) {
            g.this.r1(zv0.m(jh4Var, 1003));
        }

        @Override // defpackage.c35
        public void a(androidx.media3.exoplayer.b bVar) {
            g.this.I.c(bVar);
        }

        @Override // defpackage.od
        public void b(pd.a aVar) {
            g.this.s.b(aVar);
        }

        @Override // defpackage.od
        public void c(pd.a aVar) {
            g.this.s.c(aVar);
        }

        @Override // defpackage.od
        public void d(Exception exc) {
            g.this.s.d(exc);
        }

        @Override // defpackage.c35
        public void e(String str) {
            g.this.s.e(str);
        }

        @Override // defpackage.c35
        public void f(String str, long j, long j2) {
            g.this.s.f(str, j, j2);
        }

        @Override // defpackage.c35
        public void g(gb0 gb0Var) {
            g.this.s.g(gb0Var);
            g.this.Y = null;
            g.this.j0 = null;
        }

        @Override // defpackage.c35
        public void h(gb0 gb0Var) {
            g.this.j0 = gb0Var;
            g.this.s.h(gb0Var);
        }

        @Override // defpackage.od
        public void i(gb0 gb0Var) {
            g.this.s.i(gb0Var);
            g.this.Z = null;
            g.this.k0 = null;
        }

        @Override // defpackage.od
        public void j(String str) {
            g.this.s.j(str);
        }

        @Override // defpackage.od
        public void k(String str, long j, long j2) {
            g.this.s.k(str, j, j2);
        }

        @Override // defpackage.c35
        public void l(int i, long j) {
            g.this.s.l(i, j);
        }

        @Override // defpackage.od
        public void m(t41 t41Var, lb0 lb0Var) {
            g.this.Z = t41Var;
            g.this.s.m(t41Var, lb0Var);
        }

        @Override // defpackage.c35
        public void n(Object obj, long j) {
            g.this.s.n(obj, j);
            if (g.this.a0 == obj) {
                g.this.m.k(26, new yx0());
            }
        }

        @Override // defpackage.od
        public void o(long j) {
            g.this.s.o(j);
        }

        @Override // defpackage.od
        public void onAudioSessionIdChanged(final int i) {
            g.this.E.h(new p81() { // from class: zx0
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return Integer.valueOf(i);
                }
            }, new p81() { // from class: ay0
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return Integer.valueOf(i);
                }
            });
        }

        @Override // defpackage.tm4
        public void onCues(final w50 w50Var) {
            g.this.p0 = w50Var;
            g.this.m.k(27, new pu1.a() { // from class: qx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onCues(w50Var);
                }
            });
        }

        @Override // defpackage.et2
        public void onMetadata(final xs2 xs2Var) {
            g gVar = g.this;
            gVar.A0 = gVar.A0.b().O(xs2Var).L();
            ph2 ph2VarD0 = g.this.D0();
            if (!ph2VarD0.equals(g.this.W)) {
                g.this.W = ph2VarD0;
                g.this.m.h(14, new pu1.a() { // from class: sx0
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((hd3.d) obj).onMediaMetadataChanged(g.this.W);
                    }
                });
            }
            g.this.m.h(28, new pu1.a() { // from class: tx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onMetadata(xs2Var);
                }
            });
            g.this.m.e();
        }

        @Override // defpackage.od
        public void onSkipSilenceEnabledChanged(final boolean z) {
            if (g.this.o0 == z) {
                return;
            }
            g.this.o0 = z;
            g.this.m.k(23, new pu1.a() { // from class: rx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onSkipSilenceEnabledChanged(z);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            g.this.p1(surfaceTexture);
            g.this.a1(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            g.this.q1(null);
            g.this.a1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            g.this.a1(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // defpackage.c35
        public void onVideoSizeChanged(final e35 e35Var) {
            g.this.w0 = e35Var;
            g.this.m.k(25, new pu1.a() { // from class: vx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onVideoSizeChanged(e35Var);
                }
            });
        }

        @Override // defpackage.c35
        public void p(t41 t41Var, lb0 lb0Var) {
            g.this.Y = t41Var;
            g.this.s.p(t41Var, lb0Var);
        }

        @Override // defpackage.od
        public void q(Exception exc) {
            g.this.s.q(exc);
        }

        @Override // defpackage.c35
        public void r(Exception exc) {
            g.this.s.r(exc);
        }

        @Override // androidx.media3.exoplayer.q.b
        public void s(int i) {
            final kk0 kk0VarG0 = g.G0(g.this.z);
            if (kk0VarG0.equals(g.this.v0)) {
                return;
            }
            g.this.v0 = kk0VarG0;
            g.this.m.k(29, new pu1.a() { // from class: wx0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onDeviceInfoChanged(kk0VarG0);
                }
            });
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            g.this.a1(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (g.this.e0) {
                g.this.q1(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (g.this.e0) {
                g.this.q1(null);
            }
            g.this.a1(0, 0);
        }

        @Override // defpackage.od
        public void t(int i, long j, long j2) {
            g.this.s.t(i, j, j2);
        }

        @Override // defpackage.od
        public void u(gb0 gb0Var) {
            g.this.k0 = gb0Var;
            g.this.s.u(gb0Var);
        }

        @Override // bc.c
        public void v() {
            g.this.u1(false, 3);
        }

        @Override // defpackage.c35
        public void w(long j, int i) {
            g.this.s.w(j, i);
        }

        @Override // defpackage.od
        public void x(androidx.media3.exoplayer.b bVar) {
            g.this.H.c(bVar);
        }

        @Override // dc4.b
        public void y(Surface surface) {
            g.this.q1(null);
        }

        @Override // defpackage.tm4
        public void onCues(final List list) {
            g.this.m.k(27, new pu1.a() { // from class: ux0
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((hd3.d) obj).onCues(list);
                }
            });
        }
    }
}
