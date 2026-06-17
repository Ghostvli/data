package androidx.media3.exoplayer.hls;

import android.os.Looper;
import defpackage.aa0;
import defpackage.ag0;
import defpackage.cf1;
import defpackage.df1;
import defpackage.ev;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.h74;
import defpackage.hs4;
import defpackage.ig0;
import defpackage.j5;
import defpackage.ji;
import defpackage.jq2;
import defpackage.k11;
import defpackage.kf0;
import defpackage.kg2;
import defpackage.ki4;
import defpackage.mi2;
import defpackage.oe1;
import defpackage.pe1;
import defpackage.qe1;
import defpackage.qy;
import defpackage.rq2;
import defpackage.sq2;
import defpackage.sy1;
import defpackage.te0;
import defpackage.ve1;
import defpackage.we1;
import defpackage.wf0;
import defpackage.xf0;
import defpackage.xi4;
import defpackage.xo0;
import defpackage.yf0;
import defpackage.ze1;
import defpackage.zo0;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class HlsMediaSource extends ji implements df1.e {
    public fg2 A;
    public final pe1 m;
    public final oe1 n;
    public final qy o;
    public final xo0 p;
    public final sy1 q;
    public final boolean r;
    public final int s;
    public final boolean t;
    public final df1 u;
    public final long v;
    public final long w;
    public final xi4 x;
    public fg2.g y;
    public hs4 z;

    static {
        kg2.a("media3.exoplayer.hls");
    }

    public HlsMediaSource(fg2 fg2Var, oe1 oe1Var, pe1 pe1Var, qy qyVar, ev evVar, xo0 xo0Var, sy1 sy1Var, df1 df1Var, long j, boolean z, int i, boolean z2, long j2, xi4 xi4Var) {
        this.A = fg2Var;
        this.y = fg2Var.d;
        this.n = oe1Var;
        this.m = pe1Var;
        this.o = qyVar;
        this.p = xo0Var;
        this.q = sy1Var;
        this.u = df1Var;
        this.v = j;
        this.r = z;
        this.s = i;
        this.t = z2;
        this.w = j2;
        this.x = xi4Var;
    }

    public static we1.d J(List list, long j) {
        we1.d dVar = null;
        for (int i = 0; i < list.size(); i++) {
            we1.d dVar2 = (we1.d) list.get(i);
            long j2 = dVar2.j;
            if (j2 > j || !dVar2.q) {
                if (j2 > j) {
                    break;
                }
            } else {
                dVar = dVar2;
            }
        }
        return dVar;
    }

    public static we1.f K(List list, long j) {
        return (we1.f) list.get(fy4.i(list, Long.valueOf(j), true, true));
    }

    public static long N(we1 we1Var, long j) {
        long j2;
        we1.h hVar = we1Var.v;
        long j3 = we1Var.e;
        if (j3 != -9223372036854775807L) {
            j2 = we1Var.u - j3;
        } else {
            long j4 = hVar.d;
            if (j4 == -9223372036854775807L || we1Var.n == -9223372036854775807L) {
                long j5 = hVar.c;
                j2 = j5 != -9223372036854775807L ? j5 : we1Var.m * 3;
            } else {
                j2 = j4;
            }
        }
        return j2 + j;
    }

    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        this.z = hs4Var;
        this.p.c((Looper) gg3.q(Looper.myLooper()), C());
        this.p.prepare();
        this.u.h(((fg2.h) gg3.q(i().b)).a, z(null), this);
    }

    @Override // defpackage.ji
    public void G() {
        this.u.stop();
        this.p.release();
    }

    public final h74 H(we1 we1Var, long j, long j2, qe1 qe1Var) {
        long jI = we1Var.h - this.u.i();
        long j3 = we1Var.o ? jI + we1Var.u : -9223372036854775807L;
        long jL = L(we1Var);
        long j4 = this.y.a;
        O(we1Var, fy4.t(j4 != -9223372036854775807L ? fy4.c1(j4) : N(we1Var, jL), jL, we1Var.u + jL));
        return new h74(j, j2, -9223372036854775807L, j3, we1Var.u, jI, M(we1Var, jL), true, !we1Var.o, we1Var.d == 2 && we1Var.f, qe1Var, i(), this.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.h74 I(defpackage.we1 r25, long r26, long r28, defpackage.qe1 r30) {
        /*
            r24 = this;
            r0 = r25
            long r1 = r0.e
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L31
            java.util.List r1 = r0.r
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L16
            goto L31
        L16:
            boolean r1 = r0.g
            if (r1 != 0) goto L2e
            long r1 = r0.e
            long r3 = r0.u
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L23
            goto L2e
        L23:
            java.util.List r3 = r0.r
            we1$f r1 = K(r3, r1)
            long r1 = r1.j
        L2b:
            r16 = r1
            goto L34
        L2e:
            long r1 = r0.e
            goto L2b
        L31:
            r1 = 0
            goto L2b
        L34:
            h74 r3 = new h74
            long r10 = r0.u
            fg2 r22 = r24.i()
            r23 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14 = 0
            r18 = 1
            r19 = 0
            r20 = 1
            r12 = r10
            r4 = r26
            r6 = r28
            r21 = r30
            r3.<init>(r4, r6, r8, r10, r12, r14, r16, r18, r19, r20, r21, r22, r23)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaSource.I(we1, long, long, qe1):h74");
    }

    public final long L(we1 we1Var) {
        if (we1Var.p) {
            return fy4.c1(fy4.q0(this.v)) - we1Var.e();
        }
        return 0L;
    }

    public final long M(we1 we1Var, long j) {
        long jC1 = we1Var.e;
        if (jC1 == -9223372036854775807L) {
            jC1 = (we1Var.u + j) - fy4.c1(this.y.a);
        }
        if (we1Var.g) {
            return jC1;
        }
        we1.d dVarJ = J(we1Var.s, jC1);
        if (dVarJ != null) {
            return dVarJ.j;
        }
        if (we1Var.r.isEmpty()) {
            return 0L;
        }
        we1.f fVarK = K(we1Var.r, jC1);
        we1.d dVarJ2 = J(fVarK.r, jC1);
        return dVarJ2 != null ? dVarJ2.j : fVarK.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(defpackage.we1 r5, long r6) {
        /*
            r4 = this;
            fg2 r0 = r4.i()
            fg2$g r0 = r0.d
            float r1 = r0.d
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L2a
            float r0 = r0.e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L2a
            we1$h r5 = r5.v
            long r0 = r5.c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L2a
            long r0 = r5.d
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            fg2$g r0 = r4.y
            fg2$g$a r0 = r0.a()
            long r6 = defpackage.fy4.S1(r6)
            fg2$g$a r6 = r0.k(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L3f
            r0 = r7
            goto L43
        L3f:
            fg2$g r0 = r4.y
            float r0 = r0.d
        L43:
            fg2$g$a r6 = r6.j(r0)
            if (r5 == 0) goto L4a
            goto L4e
        L4a:
            fg2$g r5 = r4.y
            float r7 = r5.e
        L4e:
            fg2$g$a r5 = r6.h(r7)
            fg2$g r5 = r5.f()
            r4.y = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaSource.O(we1, long):void");
    }

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        fg2 fg2VarI = i();
        fg2.h hVar = (fg2.h) gg3.q(fg2VarI.b);
        fg2.h hVar2 = fg2Var.b;
        return hVar2 != null && hVar2.a.equals(hVar.a) && hVar2.e.equals(hVar.e) && Objects.equals(hVar2.c, hVar.c) && fg2VarI.d.equals(fg2Var.d);
    }

    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        rq2.a aVarZ = z(bVar);
        return new ve1(this.m, this.u, this.n, this.z, null, this.p, x(bVar), this.q, aVarZ, j5Var, this.o, this.r, this.s, this.t, C(), this.w, this.x);
    }

    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.A;
    }

    @Override // defpackage.jq2
    public void m() {
        this.u.n();
    }

    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.A = fg2Var;
    }

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((ve1) mi2Var).D();
    }

    @Override // df1.e
    public void t(we1 we1Var) {
        HlsMediaSource hlsMediaSource;
        h74 h74VarI;
        long jS1 = we1Var.p ? fy4.S1(we1Var.h) : -9223372036854775807L;
        int i = we1Var.d;
        long j = (i == 2 || i == 1) ? jS1 : -9223372036854775807L;
        qe1 qe1Var = new qe1((ze1) gg3.q(this.u.k()), we1Var);
        if (this.u.a()) {
            hlsMediaSource = this;
            h74VarI = hlsMediaSource.H(we1Var, j, jS1, qe1Var);
        } else {
            hlsMediaSource = this;
            h74VarI = hlsMediaSource.I(we1Var, j, jS1, qe1Var);
        }
        hlsMediaSource.F(h74VarI);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Factory implements sq2 {
        public static final /* synthetic */ int s = 0;
        public final oe1 c;
        public pe1 d;
        public ki4.a e;
        public boolean f;
        public int g;
        public cf1 h;
        public df1.a i;
        public qy j;
        public zo0 k;
        public sy1 l;
        public xi4 m;
        public boolean n;
        public int o;
        public boolean p;
        public long q;
        public long r;

        public Factory(oe1 oe1Var) {
            this.c = (oe1) gg3.q(oe1Var);
            this.k = new kf0();
            this.h = new yf0();
            this.i = ag0.A;
            this.l = new ig0();
            this.j = new te0();
            this.m = null;
            this.o = 1;
            this.q = -9223372036854775807L;
            this.n = true;
            this.g = 3;
            b(true);
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource e(fg2 fg2Var) {
            gg3.q(fg2Var.b);
            if (this.d == null) {
                this.d = new xf0();
            }
            ki4.a aVar = this.e;
            if (aVar != null) {
                this.d.a(aVar);
            }
            this.d.b(this.f);
            this.d.c(this.g);
            pe1 pe1Var = this.d;
            cf1 cf1Var = this.h;
            List list = fg2Var.b.e;
            cf1 k11Var = !list.isEmpty() ? new k11(cf1Var, list) : cf1Var;
            oe1 oe1Var = this.c;
            qy qyVar = this.j;
            xo0 xo0VarA = this.k.a(fg2Var);
            sy1 sy1Var = this.l;
            return new HlsMediaSource(fg2Var, oe1Var, pe1Var, qyVar, null, xo0VarA, sy1Var, this.i.a(this.c, sy1Var, k11Var, null, this.m), this.q, this.n, this.o, this.p, this.r, this.m);
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory b(boolean z) {
            this.f = z;
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory c(int i) {
            this.g = i;
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory d(xi4 xi4Var) {
            this.m = xi4Var;
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory f(zo0 zo0Var) {
            this.k = (zo0) gg3.r(zo0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Factory g(sy1 sy1Var) {
            this.l = (sy1) gg3.r(sy1Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Factory a(ki4.a aVar) {
            this.e = aVar;
            return this;
        }

        public Factory(aa0.a aVar) {
            this(new wf0(aVar));
        }
    }
}
