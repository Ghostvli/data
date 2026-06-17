package defpackage;

import android.util.Log;
import defpackage.bb0;
import defpackage.sr2;
import defpackage.sz0;
import defpackage.xl0;
import defpackage.zs0;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class us0 implements ws0, sr2.a, zs0.a {
    public static final boolean i = Log.isLoggable("Engine", 2);
    public final un1 a;
    public final ys0 b;
    public final sr2 c;
    public final b d;
    public final ms3 e;
    public final c f;
    public final a g;
    public final y2 h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final bb0.e a;
        public final tf3 b = sz0.d(150, new C0125a());
        public int c;

        /* JADX INFO: renamed from: us0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0125a implements sz0.d {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0125a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            @Override // sz0.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public bb0 create() {
                a aVar = a.this;
                return new bb0(aVar.a, aVar.b);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(bb0.e eVar) {
            this.a = eVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public bb0 a(com.bumptech.glide.c cVar, Object obj, xs0 xs0Var, wq1 wq1Var, int i, int i2, Class cls, Class cls2, ug3 ug3Var, zl0 zl0Var, Map map, boolean z, boolean z2, boolean z3, u63 u63Var, bb0.b bVar) {
            bb0 bb0Var = (bb0) fg3.e((bb0) this.b.a());
            int i3 = this.c;
            this.c = i3 + 1;
            return bb0Var.p(cVar, obj, xs0Var, wq1Var, i, i2, cls, cls2, ug3Var, zl0Var, map, z, z2, z3, u63Var, bVar, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final ka1 a;
        public final ka1 b;
        public final ka1 c;
        public final ka1 d;
        public final ws0 e;
        public final zs0.a f;
        public final tf3 g = sz0.d(150, new a());

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements sz0.d {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            @Override // sz0.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public vs0 create() {
                b bVar = b.this;
                return new vs0(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(ka1 ka1Var, ka1 ka1Var2, ka1 ka1Var3, ka1 ka1Var4, ws0 ws0Var, zs0.a aVar) {
            this.a = ka1Var;
            this.b = ka1Var2;
            this.c = ka1Var3;
            this.d = ka1Var4;
            this.e = ws0Var;
            this.f = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public vs0 a(wq1 wq1Var, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((vs0) fg3.e((vs0) this.g.a())).l(wq1Var, z, z2, z3, z4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements bb0.e {
        public final xl0.a a;
        public volatile xl0 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(xl0.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // bb0.e
        public xl0 a() {
            if (this.b == null) {
                synchronized (this) {
                    try {
                        if (this.b == null) {
                            this.b = this.a.build();
                        }
                        if (this.b == null) {
                            this.b = new yl0();
                        }
                    } finally {
                    }
                }
            }
            return this.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d {
        public final vs0 a;
        public final cs3 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(cs3 cs3Var, vs0 vs0Var) {
            this.b = cs3Var;
            this.a = vs0Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            synchronized (us0.this) {
                this.a.r(this.b);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public us0(sr2 sr2Var, xl0.a aVar, ka1 ka1Var, ka1 ka1Var2, ka1 ka1Var3, ka1 ka1Var4, un1 un1Var, ys0 ys0Var, y2 y2Var, b bVar, a aVar2, ms3 ms3Var, boolean z) {
        this.c = sr2Var;
        c cVar = new c(aVar);
        this.f = cVar;
        y2 y2Var2 = y2Var == null ? new y2(z) : y2Var;
        this.h = y2Var2;
        y2Var2.f(this);
        this.b = ys0Var == null ? new ys0() : ys0Var;
        this.a = un1Var == null ? new un1() : un1Var;
        this.d = bVar == null ? new b(ka1Var, ka1Var2, ka1Var3, ka1Var4, this, this) : bVar;
        this.g = aVar2 == null ? new a(cVar) : aVar2;
        this.e = ms3Var == null ? new ms3() : ms3Var;
        sr2Var.d(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j(String str, long j, wq1 wq1Var) {
        Log.v("Engine", str + " in " + b02.a(j) + "ms, key: " + wq1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zs0.a
    public void a(wq1 wq1Var, zs0 zs0Var) {
        this.h.d(wq1Var);
        if (zs0Var.f()) {
            this.c.c(wq1Var, zs0Var);
        } else {
            this.e.a(zs0Var, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ws0
    public synchronized void b(vs0 vs0Var, wq1 wq1Var) {
        this.a.d(wq1Var, vs0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ws0
    public synchronized void c(vs0 vs0Var, wq1 wq1Var, zs0 zs0Var) {
        if (zs0Var != null) {
            try {
                if (zs0Var.f()) {
                    this.h.a(wq1Var, zs0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.d(wq1Var, vs0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // sr2.a
    public void d(yr3 yr3Var) {
        this.e.a(yr3Var, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zs0 e(wq1 wq1Var) {
        yr3 yr3VarE = this.c.e(wq1Var);
        if (yr3VarE == null) {
            return null;
        }
        return yr3VarE instanceof zs0 ? (zs0) yr3VarE : new zs0(yr3VarE, true, true, wq1Var, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d f(com.bumptech.glide.c cVar, Object obj, wq1 wq1Var, int i2, int i3, Class cls, Class cls2, ug3 ug3Var, zl0 zl0Var, Map map, boolean z, boolean z2, u63 u63Var, boolean z3, boolean z4, boolean z5, boolean z6, cs3 cs3Var, Executor executor) {
        long jB = i ? b02.b() : 0L;
        xs0 xs0VarA = this.b.a(obj, wq1Var, i2, i3, map, cls, cls2, u63Var);
        synchronized (this) {
            try {
                zs0 zs0VarI = i(xs0VarA, z3, jB);
                if (zs0VarI == null) {
                    return l(cVar, obj, wq1Var, i2, i3, cls, cls2, ug3Var, zl0Var, map, z, z2, u63Var, z3, z4, z5, z6, cs3Var, executor, xs0VarA, jB);
                }
                cs3Var.c(zs0VarI, ba0.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zs0 g(wq1 wq1Var) {
        zs0 zs0VarE = this.h.e(wq1Var);
        if (zs0VarE != null) {
            zs0VarE.a();
        }
        return zs0VarE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zs0 h(wq1 wq1Var) {
        zs0 zs0VarE = e(wq1Var);
        if (zs0VarE != null) {
            zs0VarE.a();
            this.h.a(wq1Var, zs0VarE);
        }
        return zs0VarE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zs0 i(xs0 xs0Var, boolean z, long j) {
        if (!z) {
            return null;
        }
        zs0 zs0VarG = g(xs0Var);
        if (zs0VarG != null) {
            if (i) {
                j("Loaded resource from active resources", j, xs0Var);
            }
            return zs0VarG;
        }
        zs0 zs0VarH = h(xs0Var);
        if (zs0VarH == null) {
            return null;
        }
        if (i) {
            j("Loaded resource from cache", j, xs0Var);
        }
        return zs0VarH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(yr3 yr3Var) {
        if (yr3Var instanceof zs0) {
            ((zs0) yr3Var).g();
        } else {
            jl.a("Cannot release anything but an EngineResource");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final d l(com.bumptech.glide.c cVar, Object obj, wq1 wq1Var, int i2, int i3, Class cls, Class cls2, ug3 ug3Var, zl0 zl0Var, Map map, boolean z, boolean z2, u63 u63Var, boolean z3, boolean z4, boolean z5, boolean z6, cs3 cs3Var, Executor executor, xs0 xs0Var, long j) {
        vs0 vs0VarA = this.a.a(xs0Var, z6);
        if (vs0VarA != null) {
            vs0VarA.a(cs3Var, executor);
            if (i) {
                j("Added to existing load", j, xs0Var);
            }
            return new d(cs3Var, vs0VarA);
        }
        vs0 vs0VarA2 = this.d.a(xs0Var, z3, z4, z5, z6);
        bb0 bb0VarA = this.g.a(cVar, obj, xs0Var, wq1Var, i2, i3, cls, cls2, ug3Var, zl0Var, map, z, z2, z6, u63Var, vs0VarA2);
        this.a.c(xs0Var, vs0VarA2);
        vs0VarA2.a(cs3Var, executor);
        vs0VarA2.s(bb0VarA);
        if (i) {
            j("Started new load", j, xs0Var);
        }
        return new d(cs3Var, vs0VarA2);
    }

    public us0(sr2 sr2Var, xl0.a aVar, ka1 ka1Var, ka1 ka1Var2, ka1 ka1Var3, ka1 ka1Var4, boolean z) {
        this(sr2Var, aVar, ka1Var, ka1Var2, ka1Var3, ka1Var4, null, null, null, null, null, null, z);
    }
}
