package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import defpackage.d35;
import defpackage.fa1;
import defpackage.fd3;
import defpackage.k25;
import defpackage.q25;
import defpackage.t41;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fd3 implements q25.b {
    public static final Executor C = new Executor() { // from class: ed3
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            fd3.a(runnable);
        }
    };
    public int A;
    public int B;
    public final Context a;
    public final q25.a b;
    public final SparseArray c;
    public final boolean d;
    public final d35 e;
    public final d35.b f;
    public final zu g;
    public final CopyOnWriteArraySet h;
    public final long i;
    public final m25 j;
    public ko4 k;
    public t41 l;
    public f25 m;
    public xi1 n;
    public mc1 o;
    public j25 p;
    public boolean q;
    public boolean r;
    public long s;
    public int t;
    public Pair u;
    public int v;
    public int w;
    public long x;
    public long y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements d35.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // d35.b
        public void a(long j) {
            fd3.z(fd3.this);
            w82.a(gg3.q(null));
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // d35.b
        public void skip() {
            fd3.z(fd3.this);
            w82.a(gg3.q(null));
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Context a;
        public final l25 b;
        public q25.a c;
        public boolean d;
        public boolean f;
        public boolean g;
        public long h = 15000;
        public m25 i = new m25(1.0f);
        public zu e = zu.a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Context context, l25 l25Var) {
            this.a = context.getApplicationContext();
            this.b = l25Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public fd3 h() {
            gg3.v(!this.f);
            if (this.c == null) {
                this.c = new f(this.g);
            }
            fd3 fd3Var = new fd3(this, null);
            this.f = true;
            return fd3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b i(long j) {
            this.h = j;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b j(zu zuVar) {
            this.e = zuVar;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b k(boolean z) {
            this.d = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements d35, d {
        public final int a;
        public final int b;
        public t41 d;
        public int e;
        public long f;
        public int h;
        public boolean k;
        public boolean l;
        public xi1 c = xi1.u();
        public long g = -9223372036854775807L;
        public d35.a i = d35.a.a;
        public Executor j = fd3.C;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Context context, int i) {
            this.b = i;
            this.a = fy4.o0(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a(t41 t41Var) {
            t41Var.b().W(fd3.this.E(t41Var.F)).Q();
            fd3.z(fd3.this);
            w82.a(gg3.q(null));
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public boolean b() {
            return isInitialized() && fd3.this.G();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void c(long j, long j2) {
            fd3.this.O(j + this.f, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public Surface d() {
            gg3.v(isInitialized());
            fd3.z(fd3.this);
            w82.a(gg3.q(null));
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void e(Surface surface, d94 d94Var) {
            fd3.this.Q(surface, d94Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public boolean f(long j, d35.b bVar) {
            int i;
            gg3.v(isInitialized());
            long jC = fd3.this.j.c(j + this.f);
            if (jC != -9223372036854775807L && fd3.this.i != -9223372036854775807L && jC < fd3.this.i && (i = this.h) < 2) {
                this.h = i + 1;
                bVar.skip();
                return true;
            }
            if (!fd3.this.U()) {
                return false;
            }
            fd3.z(fd3.this);
            w82.a(gg3.q(null));
            throw null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void g() {
            if (fd3.this.d) {
                fd3.this.X();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void h() {
            if (fd3.this.d) {
                fd3.this.W();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void i(long j) {
            this.f = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public boolean isInitialized() {
            return this.l;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void j() {
            fd3.this.y = this.g;
            if (fd3.this.x >= fd3.this.y) {
                fd3.this.V();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void k(int i) {
            if (this.b == 0) {
                fd3.this.P(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void l() {
            fd3.this.C();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public boolean m(t41 t41Var) throws d35.c {
            gg3.v(!isInitialized());
            boolean zM = fd3.this.M(t41Var, this.b);
            this.l = zM;
            return zM;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void n(boolean z) {
            if (isInitialized()) {
                fd3.z(fd3.this);
                w82.a(gg3.q(null));
                throw null;
            }
            this.g = -9223372036854775807L;
            fd3.this.D(z);
            this.k = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void o(List list) {
            if (this.c.equals(list)) {
                return;
            }
            this.c = xi1.p(list);
            t41 t41Var = this.d;
            if (t41Var != null) {
                a(t41Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void p(boolean z) {
            if (fd3.this.d) {
                fd3.this.J(z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public boolean q(boolean z) {
            return fd3.this.I(z && isInitialized());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void r(int i, t41 t41Var, long j, int i2, List list) {
            gg3.v(isInitialized());
            this.c = xi1.p(list);
            this.e = i;
            this.d = t41Var;
            fd3.this.y = -9223372036854775807L;
            fd3.this.z = false;
            a(t41Var);
            boolean z = this.g == -9223372036854775807L;
            if (fd3.this.d || (this.b == 0 && z)) {
                long j2 = z ? -4611686018427387904L : this.g + 1;
                fd3.this.k.a(j2, new g(this.f + j, i2, j2));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void release() {
            fd3.this.N();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void s(d35.a aVar, Executor executor) {
            this.i = aVar;
            this.j = executor;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void setPlaybackSpeed(float f) {
            if (this.b == 0) {
                fd3.this.R(f);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void t(j25 j25Var) {
            if (this.b == 0) {
                fd3.this.T(j25Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void u() {
            if (isInitialized()) {
                long unused = fd3.this.x;
                fd3.this.D(false);
                fd3.z(fd3.this);
                w82.a(gg3.q(null));
                throw null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d35
        public void v() {
            if (fd3.this.k.l() == 0) {
                fd3.this.B();
                return;
            }
            ko4 ko4Var = new ko4();
            boolean z = true;
            while (true) {
                int iL = fd3.this.k.l();
                fd3 fd3Var = fd3.this;
                if (iL <= 0) {
                    fd3Var.k = ko4Var;
                    return;
                }
                g gVar = (g) gg3.q((g) fd3Var.k.i());
                if (z) {
                    int i = gVar.b;
                    if (i == 0 || i == 1) {
                        gVar = new g(gVar.a, 0, gVar.c);
                    } else {
                        fd3.this.B();
                    }
                    z = false;
                }
                ko4Var.a(gVar.c, gVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e implements k25.b {
        public static final xi4 b = zi4.a(new xi4() { // from class: gd3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.xi4
            public final Object get() {
                return fd3.e.a();
            }
        });
        public final boolean a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(boolean z) {
            this.a = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Class a() {
            try {
                return Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements q25.a {
        public final k25.b a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(boolean z) {
            this.a = new e(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // q25.a
        public q25 a(Context context, bx bxVar, xa0 xa0Var, q25.b bVar, Executor executor, long j, boolean z) {
            try {
                ((q25.a) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(k25.b.class).newInstance(this.a)).a(context, bxVar, xa0Var, bVar, executor, j, z);
                return null;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final long a;
        public final int b;
        public final long c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(long j, int i, long j2) {
            this.a = j;
            this.b = i;
            this.c = j2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fd3(b bVar) {
        this.a = bVar.a;
        this.k = new ko4();
        this.b = (q25.a) gg3.q(bVar.c);
        this.c = new SparseArray();
        this.n = xi1.u();
        this.m = f25.a;
        this.d = bVar.d;
        zu zuVar = bVar.e;
        this.g = zuVar;
        this.i = bVar.h != -9223372036854775807L ? -bVar.h : -9223372036854775807L;
        m25 m25Var = bVar.i;
        this.j = m25Var;
        this.e = new aj0(bVar.b, m25Var, zuVar);
        this.f = new a();
        this.h = new CopyOnWriteArraySet();
        this.l = new t41.b().Q();
        this.s = -9223372036854775807L;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.A = -1;
        this.w = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Runnable runnable) {
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: ARITH (wrap:int:0x0000: IGET (r1v0 fd3) A[DONT_GENERATE, REMOVE, WRAPPED] (LINE:1) fd3.v int) -= (1 int) A[ARITH_ONEARG] */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(fd3 fd3Var) {
        fd3Var.v--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ q25 z(fd3 fd3Var) {
        fd3Var.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(d dVar) {
        this.h.add(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B() {
        this.e.v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C() {
        d94 d94Var = d94.c;
        K(null, d94Var.b(), d94Var.a());
        this.u = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(boolean z) {
        ko4 ko4Var;
        if (H()) {
            this.v++;
            this.e.n(z);
            while (true) {
                int iL = this.k.l();
                ko4Var = this.k;
                if (iL <= 1) {
                    break;
                } else {
                    ko4Var.i();
                }
            }
            if (ko4Var.l() == 1) {
                g gVar = (g) gg3.q((g) this.k.i());
                this.s = gVar.a;
                this.t = gVar.b;
                L();
            }
            this.x = -9223372036854775807L;
            if (z) {
                this.y = -9223372036854775807L;
                this.z = false;
            }
            ((mc1) gg3.q(this.o)).d(new Runnable() { // from class: dd3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    fd3.b(this.f);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final bx E(bx bxVar) {
        return (bxVar == null || !bxVar.h() || this.r) ? bx.h : bxVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d35 F(int i) {
        if (fy4.u(this.c, i)) {
            return (d35) this.c.get(i);
        }
        c cVar = new c(this.a, i);
        if (i == 0) {
            A(cVar);
        }
        this.c.put(i, cVar);
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G() {
        return this.v == 0 && this.z && this.e.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H() {
        return this.w == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I(boolean z) {
        return this.e.q(z && this.v == 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J(boolean z) {
        this.e.p(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(Surface surface, int i, int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L() {
        this.e.r(1, this.l, this.s, this.t, xi1.u());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M(t41 t41Var, int i) throws d35.c {
        if (i != 0) {
            if (!H()) {
                return false;
            }
            w82.a(gg3.q(null));
            throw null;
        }
        gg3.v(this.w == 0);
        bx bxVarE = E(t41Var.F);
        try {
            if (this.q) {
                bxVarE = bx.h;
            } else if (bxVarE.c == 7 && Build.VERSION.SDK_INT < 34 && fa1.k()) {
                bxVarE = bxVarE.a().e(6).a();
            } else if (fa1.l(bxVarE.c) || Build.VERSION.SDK_INT < 29) {
                int i2 = bxVarE.c;
                if (i2 == 2 || i2 == 10) {
                    bxVarE = bx.h;
                }
            } else {
                xz1.i("PlaybackVidGraphWrapper", fy4.M("Color transfer %d is not supported. Falling back to OpenGl tone mapping.", Integer.valueOf(bxVarE.c)));
                bxVarE = bx.h;
            }
            bx bxVar = bxVarE;
            mc1 mc1VarC = this.g.c((Looper) gg3.q(Looper.myLooper()), null);
            this.o = mc1VarC;
            q25.a aVar = this.b;
            Context context = this.a;
            xa0 xa0Var = xa0.a;
            Objects.requireNonNull(mc1VarC);
            aVar.a(context, bxVar, xa0Var, this, new cy0(mc1VarC), 0L, false);
            throw null;
        } catch (fa1.a e2) {
            throw new d35.c(e2, t41Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N() {
        if (this.w == 2) {
            return;
        }
        mc1 mc1Var = this.o;
        if (mc1Var != null) {
            mc1Var.m(null);
        }
        this.u = null;
        this.w = 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O(long j, long j2) {
        this.e.c(j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P(int i) {
        this.e.k(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(Surface surface, d94 d94Var) {
        Pair pair = this.u;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((d94) this.u.second).equals(d94Var)) {
            return;
        }
        this.u = Pair.create(surface, d94Var);
        K(surface, d94Var.b(), d94Var.a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R(float f2) {
        this.j.e(f2);
        this.e.setPlaybackSpeed(f2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(int i) {
        if (i < this.A) {
            return;
        }
        this.A = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T(j25 j25Var) {
        this.p = j25Var;
        this.e.t(j25Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean U() {
        int i = this.A;
        return i != -1 && i == this.B;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V() {
        this.e.j();
        this.z = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W() {
        this.e.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X() {
        this.e.g();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 fd3$b) A[MD:(fd3$b):void (m)] (LINE:135) call: fd3.<init>(fd3$b):void type: THIS */
    public /* synthetic */ fd3(b bVar, a aVar) {
        this(bVar);
    }
}
