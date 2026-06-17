package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.exoplayer.smoothstreaming.a;
import androidx.media3.exoplayer.smoothstreaming.b;
import defpackage.aa0;
import defpackage.bz1;
import defpackage.eq3;
import defpackage.ev;
import defpackage.fd4;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gd4;
import defpackage.gg3;
import defpackage.h74;
import defpackage.hs4;
import defpackage.ig0;
import defpackage.j5;
import defpackage.ja0;
import defpackage.ji;
import defpackage.jq2;
import defpackage.kf0;
import defpackage.kg2;
import defpackage.ki4;
import defpackage.l11;
import defpackage.mi2;
import defpackage.oh2;
import defpackage.qy;
import defpackage.rq2;
import defpackage.sq2;
import defpackage.sy1;
import defpackage.t83;
import defpackage.te0;
import defpackage.ty1;
import defpackage.xi4;
import defpackage.xo0;
import defpackage.xy1;
import defpackage.zo0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class SsMediaSource extends ji implements xy1.b {
    public bz1 A;
    public hs4 B;
    public long C;
    public fd4 D;
    public Handler E;
    public fg2 F;
    public final boolean m;
    public final Uri n;
    public final aa0.a o;
    public final b.a p;
    public final qy q;
    public final xo0 r;
    public final sy1 s;
    public final long t;
    public final rq2.a u;
    public final t83.a v;
    public final ArrayList w;
    public xi4 x;
    public aa0 y;
    public xy1 z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        kg2.a("media3.exoplayer.smoothstreaming");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SsMediaSource(fg2 fg2Var, fd4 fd4Var, aa0.a aVar, t83.a aVar2, b.a aVar3, qy qyVar, ev evVar, xo0 xo0Var, sy1 sy1Var, long j, xi4 xi4Var) {
        gg3.v(fd4Var == null || !fd4Var.d);
        this.F = fg2Var;
        fg2.h hVar = (fg2.h) gg3.q(fg2Var.b);
        this.D = fd4Var;
        this.n = hVar.a.equals(Uri.EMPTY) ? null : fy4.L(hVar.a);
        this.o = aVar;
        this.v = aVar2;
        this.p = aVar3;
        this.q = qyVar;
        this.r = xo0Var;
        this.s = sy1Var;
        this.t = j;
        this.x = xi4Var;
        this.u = z(null);
        this.m = fd4Var != null;
        this.w = new ArrayList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        this.B = hs4Var;
        this.r.c(Looper.myLooper(), C());
        this.r.prepare();
        if (this.m) {
            this.A = new bz1.a();
            M();
            return;
        }
        this.y = this.o.b();
        xy1 xy1Var = this.x != null ? new xy1((eq3) this.x.get()) : new xy1("SsMediaSource");
        this.z = xy1Var;
        this.A = xy1Var;
        this.E = fy4.E();
        O();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ji
    public void G() {
        this.D = this.m ? this.D : null;
        this.y = null;
        this.C = 0L;
        xy1 xy1Var = this.z;
        if (xy1Var != null) {
            xy1Var.l();
            this.z = null;
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
        this.r.release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Lxy1$e;JJZ)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void j(t83 t83Var, long j, long j2, boolean z) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        this.s.c(t83Var.a);
        this.u.l(ty1Var, t83Var.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: l(Lxy1$e;JJ)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void l(t83 t83Var, long j, long j2) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        this.s.c(t83Var.a);
        this.u.o(ty1Var, t83Var.c);
        this.D = (fd4) t83Var.e();
        this.C = j - j2;
        M();
        N();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Lxy1$e;JJLjava/io/IOException;I)Lxy1$c; */
    @Override // xy1.b
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public xy1.c v(t83 t83Var, long j, long j2, IOException iOException, int i) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        long jA = this.s.a(new sy1.c(ty1Var, new oh2(t83Var.c), iOException, i));
        xy1.c cVarH = jA == -9223372036854775807L ? xy1.g : xy1.h(false, jA);
        boolean zC = cVarH.c();
        this.u.s(ty1Var, t83Var.c, iOException, !zC);
        if (!zC) {
            this.s.c(t83Var.a);
        }
        return cVarH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: p(Lxy1$e;JJI)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void p(t83 t83Var, long j, long j2, int i) {
        this.u.u(i == 0 ? new ty1(t83Var.a, t83Var.b, j) : new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a()), t83Var.c, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M() {
        h74 h74Var;
        for (int i = 0; i < this.w.size(); i++) {
            ((c) this.w.get(i)).x(this.D);
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (fd4.b bVar : this.D.f) {
            if (bVar.k > 0) {
                jMax2 = Math.min(jMax2, bVar.e(0));
                jMax = Math.max(jMax, bVar.e(bVar.k - 1) + bVar.c(bVar.k - 1));
            }
        }
        fd4 fd4Var = this.D;
        if (jMax2 == Long.MAX_VALUE) {
            long j = fd4Var.d ? -9223372036854775807L : 0L;
            fd4 fd4Var2 = this.D;
            boolean z = fd4Var2.d;
            h74Var = new h74(j, 0L, 0L, 0L, true, z, z, fd4Var2, i());
        } else if (fd4Var.d) {
            long j2 = fd4Var.h;
            if (j2 != -9223372036854775807L && j2 > 0) {
                jMax2 = Math.max(jMax2, jMax - j2);
            }
            long j3 = jMax2;
            long j4 = jMax - j3;
            long jC1 = j4 - fy4.c1(this.t);
            if (jC1 < 5000000) {
                jC1 = Math.min(5000000L, j4 / 2);
            }
            h74Var = new h74(-9223372036854775807L, j4, j3, jC1, true, true, true, this.D, i());
        } else {
            long j5 = fd4Var.g;
            if (j5 == -9223372036854775807L) {
                j5 = jMax - jMax2;
            }
            long j6 = j5;
            h74Var = new h74(jMax2 + j6, j6, jMax2, 0L, true, false, false, this.D, i());
        }
        F(h74Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N() {
        if (this.D.d) {
            this.E.postDelayed(new Runnable() { // from class: id4
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.O();
                }
            }, Math.max(0L, (this.C + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O() {
        if (this.z.i()) {
            return;
        }
        t83 t83Var = new t83(this.y, new ja0.b().i(this.n).b(1).a(), 4, this.v);
        this.z.n(t83Var, this, this.s.d(t83Var.c));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        fg2.h hVar = (fg2.h) gg3.q(i().b);
        fg2.h hVar2 = fg2Var.b;
        return hVar2 != null && hVar2.a.equals(hVar.a) && hVar2.e.equals(hVar.e) && Objects.equals(hVar2.c, hVar.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        rq2.a aVarZ = z(bVar);
        c cVar = new c(this.D, this.p, this.B, this.q, null, this.r, x(bVar), this.s, aVarZ, this.A, j5Var, this.x);
        this.w.add(cVar);
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.F;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void m() {
        this.A.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.F = fg2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((c) mi2Var).w();
        this.w.remove(mi2Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Factory implements sq2 {
        public static final /* synthetic */ int k = 0;
        public final b.a c;
        public final aa0.a d;
        public qy e;
        public zo0 f;
        public sy1 g;
        public long h;
        public t83.a i;
        public xi4 j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Factory(b.a aVar, aa0.a aVar2) {
            this.c = (b.a) gg3.q(aVar);
            this.d = aVar2;
            this.j = null;
            this.f = new kf0();
            this.g = new ig0();
            this.h = 30000L;
            this.e = new te0();
            b(true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Lfg2;)Ljq2; */
        @Override // jq2.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SsMediaSource e(fg2 fg2Var) {
            gg3.q(fg2Var.b);
            t83.a gd4Var = this.i;
            if (gd4Var == null) {
                gd4Var = new gd4();
            }
            List list = fg2Var.b.e;
            return new SsMediaSource(fg2Var, null, this.d, !list.isEmpty() ? new l11(gd4Var, list) : gd4Var, this.c, this.e, null, this.f.a(fg2Var), this.g, this.h, this.j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Z)Ljq2$a; */
        @Override // jq2.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory b(boolean z) {
            this.c.b(z);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: d(Lxi4;)Ljq2$a; */
        @Override // jq2.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory d(xi4 xi4Var) {
            this.j = xi4Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: f(Lzo0;)Ljq2$a; */
        @Override // jq2.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory f(zo0 zo0Var) {
            this.f = (zo0) gg3.r(zo0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: g(Lsy1;)Ljq2$a; */
        @Override // jq2.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory g(sy1 sy1Var) {
            this.g = (sy1) gg3.r(sy1Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Lki4$a;)Ljq2$a; */
        @Override // jq2.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Factory a(ki4.a aVar) {
            this.c.a((ki4.a) gg3.q(aVar));
            return this;
        }

        public Factory(aa0.a aVar) {
            this(new a.C0025a(aVar), aVar);
        }
    }
}
