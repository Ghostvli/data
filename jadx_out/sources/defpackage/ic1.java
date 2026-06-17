package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ic1 extends jc1 implements gj0 {
    public final Handler h;
    public final String i;
    public final boolean j;
    public final ic1 k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Runnable {
        public final /* synthetic */ qp f;
        public final /* synthetic */ ic1 g;

        public a(qp qpVar, ic1 ic1Var) {
            this.f = qpVar;
            this.g = ic1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f.e(this.g, fw4.a);
        }
    }

    public ic1(Handler handler, String str, boolean z) {
        super(null);
        this.h = handler;
        this.i = str;
        this.j = z;
        this.k = z ? this : new ic1(handler, str, true);
    }

    public static void j0(ic1 ic1Var, Runnable runnable) {
        ic1Var.h.removeCallbacks(runnable);
    }

    public static fw4 k0(ic1 ic1Var, Runnable runnable, Throwable th) {
        ic1Var.h.removeCallbacks(runnable);
        return fw4.a;
    }

    @Override // defpackage.gj0
    public void F(long j, qp qpVar) {
        final a aVar = new a(qpVar, this);
        if (this.h.postDelayed(aVar, xn3.e(j, 4611686018427387903L))) {
            qpVar.f(new Function1() { // from class: gc1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ic1.k0(this.f, aVar, (Throwable) obj);
                }
            });
        } else {
            l0(qpVar.getContext(), aVar);
        }
    }

    @Override // defpackage.n40
    public void c0(g40 g40Var, Runnable runnable) {
        if (this.h.post(runnable)) {
            return;
        }
        l0(g40Var, runnable);
    }

    @Override // defpackage.n40
    public boolean d0(g40 g40Var) {
        return (this.j && il1.a(Looper.myLooper(), this.h.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ic1)) {
            return false;
        }
        ic1 ic1Var = (ic1) obj;
        return ic1Var.h == this.h && ic1Var.j == this.j;
    }

    public int hashCode() {
        return (this.j ? 1231 : 1237) ^ System.identityHashCode(this.h);
    }

    public final void l0(g40 g40Var, Runnable runnable) {
        on1.c(g40Var, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        mm0.b().c0(g40Var, runnable);
    }

    @Override // defpackage.z32
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public ic1 h0() {
        return this.k;
    }

    @Override // defpackage.n40
    public String toString() {
        String strI0 = i0();
        if (strI0 == null) {
            strI0 = this.i;
            if (strI0 == null) {
                strI0 = this.h.toString();
            }
            if (this.j) {
                return strI0 + ".immediate";
            }
        }
        return strI0;
    }

    @Override // defpackage.gj0
    public qm0 y(long j, final Runnable runnable, g40 g40Var) {
        if (this.h.postDelayed(runnable, xn3.e(j, 4611686018427387903L))) {
            return new qm0() { // from class: hc1
                @Override // defpackage.qm0
                public final void e() {
                    ic1.j0(this.f, runnable);
                }
            };
        }
        l0(g40Var, runnable);
        return u33.f;
    }

    public /* synthetic */ ic1(Handler handler, String str, int i, we0 we0Var) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public ic1(Handler handler, String str) {
        this(handler, str, false);
    }
}
