package defpackage;

import defpackage.ww2;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ww2 extends p04 implements rw2 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(ww2.class, Object.class, "owner$volatile");
    public final Function3 m;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements qp, f85 {
        public final sp f;
        public final Object g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(sp spVar, Object obj) {
            this.f = spVar;
            this.g = obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static fw4 b(ww2 ww2Var, a aVar, Throwable th, fw4 fw4Var, g40 g40Var) {
            ww2.w().set(ww2Var, aVar.g);
            ww2Var.c(aVar.g);
            return fw4.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static fw4 c(ww2 ww2Var, a aVar, Throwable th) {
            ww2Var.c(aVar.g);
            return fw4.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.f85
        public void a(f04 f04Var, int i) {
            this.f.a(f04Var, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: i(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V */
        @Override // defpackage.qp
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void i(fw4 fw4Var, Function3 function3) {
            ww2.w().set(ww2.this, this.g);
            sp spVar = this.f;
            final ww2 ww2Var = ww2.this;
            spVar.P(fw4Var, new Function1() { // from class: vw2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ww2.a.c(ww2Var, this, (Throwable) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.qp
        public void f(Function1 function1) {
            this.f.f(function1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Ln40;Ljava/lang/Object;)V */
        @Override // defpackage.qp
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(n40 n40Var, fw4 fw4Var) {
            this.f.e(n40Var, fw4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.f30
        public g40 getContext() {
            return this.f.getContext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: k(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object; */
        @Override // defpackage.qp
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object k(fw4 fw4Var, Object obj, Function3 function3) {
            sp spVar = this.f;
            final ww2 ww2Var = ww2.this;
            Object objK = spVar.k(fw4Var, obj, new Function3() { // from class: uw2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ww2.a.b(ww2Var, this, (Throwable) obj2, (fw4) obj3, (g40) obj4);
                }
            });
            if (objK != null) {
                ww2.w().set(ww2.this, this.g);
            }
            return objK;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.qp
        public boolean j(Throwable th) {
            return this.f.j(th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.qp
        public void m(Object obj) {
            this.f.m(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.f30
        public void resumeWith(Object obj) {
            this.f.resumeWith(obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ww2(boolean z) {
        super(1, z ? 1 : 0);
        this.owner$volatile = z ? null : xw2.a;
        this.m = new Function3() { // from class: sw2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                ww2 ww2Var = this.f;
                w82.a(obj);
                return ww2.u(ww2Var, null, obj2, obj3);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 t(ww2 ww2Var, Object obj, Throwable th, Object obj2, g40 g40Var) {
        ww2Var.c(obj);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Function3 u(final ww2 ww2Var, l04 l04Var, final Object obj, Object obj2) {
        return new Function3() { // from class: tw2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return ww2.t(this.f, obj, (Throwable) obj3, obj4, (g40) obj5);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [ww2.a.b(ww2, ww2$a, java.lang.Throwable, fw4, g40):fw4, ww2.a.d(fw4, kotlin.jvm.functions.Function3):void, ww2.a.h(fw4, java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object] */
    public static final /* synthetic */ AtomicReferenceFieldUpdater w() {
        return n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object z(ww2 ww2Var, Object obj, f30 f30Var) {
        if (ww2Var.B(obj)) {
            return fw4.a;
        }
        Object objA = ww2Var.A(obj, f30Var);
        return objA == kl1.e() ? objA : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object A(Object obj, f30 f30Var) {
        sp spVarB = up.b(jl1.c(f30Var));
        try {
            f(new a(spVarB, obj));
            Object objY = spVarB.y();
            if (objY == kl1.e()) {
                ta0.c(f30Var);
            }
            return objY == kl1.e() ? objY : fw4.a;
        } catch (Throwable th) {
            spVarB.N();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B(Object obj) {
        int iC = C(obj);
        if (iC == 0) {
            return true;
        }
        if (iC == 1) {
            return false;
        }
        if (iC != 2) {
            e04.a("unexpected");
            return false;
        }
        rn1.a("This mutex is already locked by the specified owner: ", obj);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C(Object obj) {
        while (!q()) {
            if (obj == null) {
                return 1;
            }
            int iX = x(obj);
            if (iX == 1) {
                return 2;
            }
            if (iX == 2) {
                return 1;
            }
        }
        n.set(this, obj);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rw2
    public void c(Object obj) {
        while (y()) {
            Object obj2 = n.get(this);
            if (obj2 != xw2.a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (z0.a(n, this, obj2, xw2.a)) {
                    release();
                    return;
                }
            }
        }
        e04.a("This mutex is not locked");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rw2
    public Object h(Object obj, f30 f30Var) {
        return z(this, obj, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "Mutex@" + ua0.b(this) + "[isLocked=" + y() + ",owner=" + n.get(this) + ']';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int x(Object obj) {
        while (y()) {
            Object obj2 = n.get(this);
            if (obj2 != xw2.a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean y() {
        return a() == 0;
    }
}
