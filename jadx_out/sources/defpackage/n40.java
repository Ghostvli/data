package defpackage;

import defpackage.g40;
import defpackage.h30;
import defpackage.n40;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n40 extends x implements h30 {
    public static final a g = new a(null);

    public n40() {
        super(h30.b);
    }

    public static /* synthetic */ n40 g0(n40 n40Var, int i, String str, int i2, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: limitedParallelism");
            return null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return n40Var.f0(i, str);
    }

    @Override // defpackage.x, defpackage.g40
    public g40 B(g40.c cVar) {
        return h30.a.b(this, cVar);
    }

    @Override // defpackage.h30
    public final f30 Q(f30 f30Var) {
        return new gm0(this, f30Var);
    }

    @Override // defpackage.h30
    public final void Z(f30 f30Var) {
        f30Var.getClass();
        ((gm0) f30Var).t();
    }

    @Override // defpackage.x, g40.b, defpackage.g40
    public g40.b a(g40.c cVar) {
        return h30.a.a(this, cVar);
    }

    public abstract void c0(g40 g40Var, Runnable runnable);

    public boolean d0(g40 g40Var) {
        return true;
    }

    public /* synthetic */ n40 e0(int i) {
        return f0(i, null);
    }

    public n40 f0(int i, String str) {
        it1.a(i);
        return new ht1(this, i, str);
    }

    public String toString() {
        return ua0.a(this) + '@' + ua0.b(this);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends y {
        public a() {
            super(h30.b, new Function1() { // from class: m40
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return n40.a.c((g40.b) obj);
                }
            });
        }

        public static n40 c(g40.b bVar) {
            if (bVar instanceof n40) {
                return (n40) bVar;
            }
            return null;
        }

        public /* synthetic */ a(we0 we0Var) {
            this();
        }
    }
}
