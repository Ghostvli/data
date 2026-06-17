package defpackage;

import defpackage.p31;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class rt4 extends p31.a implements RunnableFuture {
    public volatile hl1 m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a extends hl1 {
        public final Callable h;

        public a(Callable callable) {
            this.h = (Callable) gg3.q(callable);
        }

        @Override // defpackage.hl1
        public void a(Throwable th) {
            rt4.this.N(th);
        }

        @Override // defpackage.hl1
        public void b(Object obj) {
            rt4.this.M(obj);
        }

        @Override // defpackage.hl1
        public final boolean d() {
            return rt4.this.isDone();
        }

        @Override // defpackage.hl1
        public Object e() {
            return this.h.call();
        }

        @Override // defpackage.hl1
        public String f() {
            return this.h.toString();
        }
    }

    public rt4(Callable callable) {
        this.m = new a(callable);
    }

    public static rt4 T(Runnable runnable, Object obj) {
        return new rt4(Executors.callable(runnable, obj));
    }

    public static rt4 U(Callable callable) {
        return new rt4(callable);
    }

    @Override // defpackage.b0
    public String L() {
        hl1 hl1Var = this.m;
        if (hl1Var == null) {
            return super.L();
        }
        return "task=[" + hl1Var + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        hl1 hl1Var = this.m;
        if (hl1Var != null) {
            hl1Var.run();
        }
        this.m = null;
    }

    @Override // defpackage.b0
    public void y() {
        hl1 hl1Var;
        super.y();
        if (P() && (hl1Var = this.m) != null) {
            hl1Var.c();
        }
        this.m = null;
    }
}
