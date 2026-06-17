package defpackage;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.bumptech.glide.b;
import defpackage.cb0;
import defpackage.sz0;
import defpackage.u90;
import defpackage.up3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bb0 implements u90.a, Runnable, Comparable, sz0.f {
    public static final s63 N = s63.e("glide_thread_priority_override");
    public Object A;
    public com.bumptech.glide.d B;
    public Supplier C;
    public Thread D;
    public wq1 E;
    public wq1 F;
    public Object G;
    public ba0 H;
    public t90 I;
    public volatile u90 J;
    public volatile boolean K;
    public volatile boolean L;
    public boolean M;
    public final e i;
    public final tf3 j;
    public com.bumptech.glide.c m;
    public wq1 n;
    public ug3 o;
    public xs0 p;
    public int q;
    public int r;
    public zl0 s;
    public u63 t;
    public b u;
    public int v;
    public h w;
    public g x;
    public long y;
    public boolean z;
    public final ab0 f = new ab0();
    public final List g = new ArrayList();
    public final je4 h = je4.a();
    public final d k = new d();
    public final f l = new f();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ms0.values().length];
            c = iArr;
            try {
                iArr[ms0.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ms0.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.values().length];
            b = iArr2;
            try {
                iArr2[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void b(ja1 ja1Var);

        void c(yr3 yr3Var, ba0 ba0Var, boolean z);

        void d(bb0 bb0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements cb0.a {
        public final ba0 a;

        public c(ba0 ba0Var) {
            this.a = ba0Var;
        }

        @Override // cb0.a
        public yr3 a(yr3 yr3Var) {
            return bb0.this.z(this.a, yr3Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public wq1 a;
        public gs3 b;
        public vz1 c;

        public void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public void b(e eVar, u63 u63Var) {
            qa1.a("DecodeJob.encode");
            try {
                eVar.a().b(this.a, new r90(this.b, this.c, u63Var));
            } finally {
                this.c.h();
                qa1.e();
            }
        }

        public boolean c() {
            return this.c != null;
        }

        public void d(wq1 wq1Var, gs3 gs3Var, vz1 vz1Var) {
            this.a = wq1Var;
            this.b = gs3Var;
            this.c = vz1Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        xl0 a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public boolean a;
        public boolean b;
        public boolean c;

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }

        public synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        public synchronized void e() {
            this.b = false;
            this.a = false;
            this.c = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public bb0(e eVar, tf3 tf3Var) {
        this.i = eVar;
        this.j = tf3Var;
    }

    private void B() {
        this.l.e();
        this.k.a();
        this.f.a();
        this.K = false;
        this.m = null;
        this.n = null;
        this.t = null;
        this.o = null;
        this.p = null;
        this.u = null;
        this.w = null;
        this.J = null;
        this.D = null;
        this.E = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.y = 0L;
        this.L = false;
        this.A = null;
        this.g.clear();
        this.j.b(this);
    }

    public void A(boolean z) {
        if (this.l.d(z)) {
            B();
        }
    }

    public final void C(g gVar) {
        this.x = gVar;
        this.u.d(this);
    }

    public final void D() {
        if (!this.B.a(b.d.class)) {
            e04.a("OverrideGlideThreadPriority experiment is not enabled.");
            return;
        }
        Supplier supplier = this.C;
        if (supplier == null || supplier.get() == null) {
            return;
        }
        try {
            Process.setThreadPriority(Process.myTid(), 9);
        } catch (IllegalArgumentException | SecurityException e2) {
            this.C = null;
            if (Log.isLoggable("DecodeJob", 2)) {
                Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e2);
            }
        }
    }

    public final void E() {
        this.D = Thread.currentThread();
        this.y = b02.b();
        boolean zB = false;
        while (!this.L && this.J != null && !(zB = this.J.b())) {
            this.w = m(this.w);
            this.J = l();
            if (this.w == h.SOURCE) {
                C(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.w == h.FINISHED || this.L) && !zB) {
            w();
        }
    }

    public final yr3 F(Object obj, ba0 ba0Var, uy1 uy1Var) {
        u63 u63VarN = n(ba0Var);
        com.bumptech.glide.load.data.a aVarL = this.m.i().l(obj);
        try {
            return uy1Var.a(aVarL, u63VarN, this.q, this.r, new c(ba0Var));
        } finally {
            aVarL.b();
        }
    }

    public final void G() {
        int i = a.a[this.x.ordinal()];
        if (i == 1) {
            this.w = m(h.INITIALIZE);
            this.J = l();
            E();
        } else if (i == 2) {
            E();
        } else if (i == 3) {
            k();
        } else {
            defpackage.d.a("Unrecognized run reason: ", this.x);
        }
    }

    public final void H() {
        Throwable th;
        this.h.c();
        if (!this.K) {
            this.K = true;
            return;
        }
        if (this.g.isEmpty()) {
            th = null;
        } else {
            List list = this.g;
            th = (Throwable) list.get(list.size() - 1);
        }
        l02.a("Already notified", th);
    }

    public boolean I() {
        h hVarM = m(h.INITIALIZE);
        return hVarM == h.RESOURCE_CACHE || hVarM == h.DATA_CACHE;
    }

    @Override // u90.a
    public void a(wq1 wq1Var, Exception exc, t90 t90Var, ba0 ba0Var) {
        t90Var.b();
        ja1 ja1Var = new ja1("Fetching data failed", exc);
        ja1Var.j(wq1Var, ba0Var, t90Var.a());
        this.g.add(ja1Var);
        if (Thread.currentThread() != this.D) {
            C(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            E();
        }
    }

    public void b() {
        this.L = true;
        u90 u90Var = this.J;
        if (u90Var != null) {
            u90Var.cancel();
        }
    }

    @Override // u90.a
    public void e() {
        C(g.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // u90.a
    public void f(wq1 wq1Var, Object obj, t90 t90Var, ba0 ba0Var, wq1 wq1Var2) {
        this.E = wq1Var;
        this.G = obj;
        this.I = t90Var;
        this.H = ba0Var;
        this.F = wq1Var2;
        this.M = wq1Var != this.f.c().get(0);
        if (Thread.currentThread() != this.D) {
            C(g.DECODE_DATA);
            return;
        }
        qa1.a("DecodeJob.decodeFromRetrievedData");
        try {
            k();
        } finally {
            qa1.e();
        }
    }

    @Override // sz0.f
    public je4 g() {
        return this.h;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(bb0 bb0Var) {
        int iO = o() - bb0Var.o();
        return iO == 0 ? this.v - bb0Var.v : iO;
    }

    public final yr3 i(t90 t90Var, Object obj, ba0 ba0Var) {
        if (obj == null) {
            t90Var.b();
            return null;
        }
        try {
            long jB = b02.b();
            yr3 yr3VarJ = j(obj, ba0Var);
            if (Log.isLoggable("DecodeJob", 2)) {
                q("Decoded result " + yr3VarJ, jB);
            }
            return yr3VarJ;
        } finally {
            t90Var.b();
        }
    }

    public final yr3 j(Object obj, ba0 ba0Var) {
        return F(obj, ba0Var, this.f.h(obj.getClass()));
    }

    public final void k() {
        Supplier supplier;
        if (Log.isLoggable("DecodeJob", 2)) {
            r("Retrieved data", this.y, "data: " + this.G + ", cache key: " + this.E + ", fetcher: " + this.I);
        }
        yr3 yr3VarI = null;
        if (this.B.a(b.d.class) && (supplier = this.C) != null && supplier.get() != null) {
            try {
                Process.setThreadPriority(Process.myTid(), ((Integer) this.C.get()).intValue());
            } catch (IllegalArgumentException | SecurityException e2) {
                this.C = null;
                if (Log.isLoggable("DecodeJob", 2)) {
                    Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e2);
                }
            }
        }
        try {
            yr3VarI = i(this.I, this.G, this.H);
        } catch (ja1 e3) {
            e3.i(this.F, this.H);
            this.g.add(e3);
        }
        if (yr3VarI != null) {
            v(yr3VarI, this.H, this.M);
        } else {
            E();
        }
    }

    public final u90 l() {
        int i = a.b[this.w.ordinal()];
        if (i == 1) {
            return new as3(this.f, this);
        }
        if (i == 2) {
            return new p90(this.f, this);
        }
        if (i == 3) {
            return new fb4(this.f, this);
        }
        if (i == 4) {
            return null;
        }
        defpackage.d.a("Unrecognized stage: ", this.w);
        return null;
    }

    public final h m(h hVar) {
        int i = a.b[hVar.ordinal()];
        if (i == 1) {
            return this.s.a() ? h.DATA_CACHE : m(h.DATA_CACHE);
        }
        if (i == 2) {
            return this.z ? h.FINISHED : h.SOURCE;
        }
        if (i == 3 || i == 4) {
            return h.FINISHED;
        }
        if (i == 5) {
            return this.s.b() ? h.RESOURCE_CACHE : m(h.RESOURCE_CACHE);
        }
        defpackage.c.a("Unrecognized stage: ", hVar);
        return null;
    }

    public final u63 n(ba0 ba0Var) {
        u63 u63Var = this.t;
        if (Build.VERSION.SDK_INT < 26) {
            return u63Var;
        }
        boolean z = ba0Var == ba0.RESOURCE_DISK_CACHE || this.f.x();
        s63 s63Var = nn0.j;
        Boolean bool = (Boolean) u63Var.c(s63Var);
        if (bool != null && (!bool.booleanValue() || z)) {
            return u63Var;
        }
        u63 u63Var2 = new u63();
        u63Var2.d(this.t);
        u63Var2.e(s63Var, Boolean.valueOf(z));
        return u63Var2;
    }

    public final int o() {
        return this.o.ordinal();
    }

    public bb0 p(com.bumptech.glide.c cVar, Object obj, xs0 xs0Var, wq1 wq1Var, int i, int i2, Class cls, Class cls2, ug3 ug3Var, zl0 zl0Var, Map map, boolean z, boolean z2, boolean z3, u63 u63Var, b bVar, int i3) {
        this.f.v(cVar, obj, wq1Var, i, i2, zl0Var, cls, cls2, ug3Var, u63Var, map, z, z2, this.i);
        this.m = cVar;
        this.n = wq1Var;
        this.o = ug3Var;
        this.p = xs0Var;
        this.q = i;
        this.r = i2;
        this.s = zl0Var;
        this.z = z3;
        this.t = u63Var;
        this.u = bVar;
        this.v = i3;
        this.x = g.INITIALIZE;
        this.A = obj;
        this.B = cVar.g();
        this.C = (Supplier) u63Var.c(N);
        return this;
    }

    public final void q(String str, long j) {
        r(str, j, null);
    }

    public final void r(String str, long j, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(b02.a(j));
        sb.append(", load key: ");
        sb.append(this.p);
        sb.append(str2 != null ? ", ".concat(str2) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    @Override // java.lang.Runnable
    public void run() {
        qa1.c("DecodeJob#run(reason=%s, model=%s)", this.x, this.A);
        t90 t90Var = this.I;
        try {
            try {
                try {
                    if (this.L) {
                        w();
                        if (t90Var != null) {
                            t90Var.b();
                        }
                        qa1.e();
                        return;
                    }
                    G();
                    if (t90Var != null) {
                        t90Var.b();
                    }
                    qa1.e();
                } catch (uo e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.L + ", stage: " + this.w, th);
                }
                if (this.w != h.ENCODE) {
                    this.g.add(th);
                    w();
                }
                if (!this.L) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (t90Var != null) {
                t90Var.b();
            }
            qa1.e();
            throw th2;
        }
    }

    public final void t(yr3 yr3Var, ba0 ba0Var, boolean z) {
        if (this.B.a(b.d.class)) {
            D();
        }
        H();
        this.u.c(yr3Var, ba0Var, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(yr3 yr3Var, ba0 ba0Var, boolean z) {
        vz1 vz1Var;
        qa1.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (yr3Var instanceof zj1) {
                ((zj1) yr3Var).a();
            }
            if (this.k.c()) {
                yr3Var = vz1.e(yr3Var);
                vz1Var = yr3Var;
            } else {
                vz1Var = 0;
            }
            t(yr3Var, ba0Var, z);
            this.w = h.ENCODE;
            try {
                if (this.k.c()) {
                    this.k.b(this.i, this.t);
                }
                x();
            } finally {
                if (vz1Var != 0) {
                    vz1Var.h();
                }
            }
        } finally {
            qa1.e();
        }
    }

    public final void w() {
        if (this.B.a(b.d.class)) {
            D();
        }
        H();
        this.u.b(new ja1("Failed to load resource", new ArrayList(this.g)));
        y();
    }

    public final void x() {
        if (this.l.b()) {
            B();
        }
    }

    public final void y() {
        if (this.l.c()) {
            B();
        }
    }

    public yr3 z(ba0 ba0Var, yr3 yr3Var) {
        yr3 yr3VarA;
        ns4 ns4Var;
        ms0 ms0VarB;
        gs3 gs3VarN;
        wq1 q90Var;
        Class<?> cls = yr3Var.get().getClass();
        if (ba0Var != ba0.RESOURCE_DISK_CACHE) {
            ns4 ns4VarS = this.f.s(cls);
            ns4Var = ns4VarS;
            yr3VarA = ns4VarS.a(this.m, yr3Var, this.q, this.r);
        } else {
            yr3VarA = yr3Var;
            ns4Var = null;
        }
        if (!yr3Var.equals(yr3VarA)) {
            yr3Var.b();
        }
        if (this.f.w(yr3VarA)) {
            gs3VarN = this.f.n(yr3VarA);
            ms0VarB = gs3VarN.b(this.t);
        } else {
            ms0VarB = ms0.NONE;
            gs3VarN = null;
        }
        if (!this.s.d(!this.f.y(this.E), ba0Var, ms0VarB)) {
            return yr3VarA;
        }
        if (gs3VarN == null) {
            throw new up3.d(yr3VarA.get().getClass());
        }
        int i = a.c[ms0VarB.ordinal()];
        if (i == 1) {
            q90Var = new q90(this.E, this.n);
        } else {
            if (i != 2) {
                defpackage.c.a("Unknown strategy: ", ms0VarB);
                return null;
            }
            q90Var = new bs3(this.f.b(), this.E, this.n, this.q, this.r, ns4Var, cls, this.t);
        }
        vz1 vz1VarE = vz1.e(yr3VarA);
        this.k.d(q90Var, gs3VarN, vz1VarE);
        return vz1VarE;
    }
}
