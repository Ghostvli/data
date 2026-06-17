package defpackage;

import android.os.Handler;
import defpackage.jq2;
import defpackage.wo0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface wo0 {
    void C(int i, jq2.b bVar);

    void D(int i, jq2.b bVar);

    default void E(int i, jq2.b bVar) {
    }

    void F(int i, jq2.b bVar);

    void G(int i, jq2.b bVar, cr1 cr1Var);

    void a(int i, jq2.b bVar, Exception exc);

    void x(int i, jq2.b bVar, int i2);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final int a;
        public final jq2.b b;
        public final CopyOnWriteArrayList c;

        /* JADX INFO: renamed from: wo0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0129a {
            public Handler a;
            public wo0 b;

            public C0129a(Handler handler, wo0 wo0Var) {
                this.a = handler;
                this.b = wo0Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public static /* synthetic */ void f(a aVar, wo0 wo0Var, cr1 cr1Var) {
            wo0Var.E(aVar.a, aVar.b);
            wo0Var.G(aVar.a, aVar.b, cr1Var);
        }

        public void g(Handler handler, wo0 wo0Var) {
            gg3.q(handler);
            gg3.q(wo0Var);
            this.c.add(new C0129a(handler, wo0Var));
        }

        public void h(final cr1 cr1Var) {
            for (C0129a c0129a : this.c) {
                final wo0 wo0Var = c0129a.b;
                fy4.o1(c0129a.a, new Runnable() { // from class: vo0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wo0.a.f(this.f, wo0Var, cr1Var);
                    }
                });
            }
        }

        public void i() {
            for (C0129a c0129a : this.c) {
                final wo0 wo0Var = c0129a.b;
                fy4.o1(c0129a.a, new Runnable() { // from class: to0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wo0.a aVar = this.f;
                        wo0Var.D(aVar.a, aVar.b);
                    }
                });
            }
        }

        public void j() {
            for (C0129a c0129a : this.c) {
                final wo0 wo0Var = c0129a.b;
                fy4.o1(c0129a.a, new Runnable() { // from class: uo0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wo0.a aVar = this.f;
                        wo0Var.C(aVar.a, aVar.b);
                    }
                });
            }
        }

        public void k(final int i) {
            for (C0129a c0129a : this.c) {
                final wo0 wo0Var = c0129a.b;
                fy4.o1(c0129a.a, new Runnable() { // from class: ro0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wo0.a aVar = this.f;
                        wo0Var.x(aVar.a, aVar.b, i);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0129a c0129a : this.c) {
                final wo0 wo0Var = c0129a.b;
                fy4.o1(c0129a.a, new Runnable() { // from class: qo0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wo0.a aVar = this.f;
                        wo0Var.a(aVar.a, aVar.b, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0129a c0129a : this.c) {
                final wo0 wo0Var = c0129a.b;
                fy4.o1(c0129a.a, new Runnable() { // from class: so0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wo0.a aVar = this.f;
                        wo0Var.F(aVar.a, aVar.b);
                    }
                });
            }
        }

        public void n(wo0 wo0Var) {
            for (C0129a c0129a : this.c) {
                if (c0129a.b == wo0Var) {
                    this.c.remove(c0129a);
                }
            }
        }

        public a o(int i, jq2.b bVar) {
            return new a(this.c, i, bVar);
        }

        public a(CopyOnWriteArrayList copyOnWriteArrayList, int i, jq2.b bVar) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.b = bVar;
        }
    }
}
