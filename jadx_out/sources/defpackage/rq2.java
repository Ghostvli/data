package defpackage;

import android.os.Handler;
import defpackage.jq2;
import defpackage.rq2;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface rq2 {
    void B(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var, IOException iOException, boolean z);

    void H(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var, int i2);

    void s(int i, jq2.b bVar, oh2 oh2Var);

    void v(int i, jq2.b bVar, oh2 oh2Var);

    void y(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var);

    void z(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final int a;
        public final jq2.b b;
        public final CopyOnWriteArrayList c;

        /* JADX INFO: renamed from: rq2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0118a {
            public Handler a;
            public rq2 b;

            public C0118a(Handler handler, rq2 rq2Var) {
                this.a = handler;
                this.b = rq2Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public a A(int i, jq2.b bVar) {
            return new a(this.c, i, bVar);
        }

        public void h(Handler handler, rq2 rq2Var) {
            gg3.q(handler);
            gg3.q(rq2Var);
            this.c.add(new C0118a(handler, rq2Var));
        }

        public void i(final g20 g20Var) {
            for (C0118a c0118a : this.c) {
                final rq2 rq2Var = c0118a.b;
                fy4.o1(c0118a.a, new Runnable() { // from class: qq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g20Var.accept(rq2Var);
                    }
                });
            }
        }

        public void j(int i, t41 t41Var, int i2, Object obj, long j) {
            k(new oh2(1, i, t41Var, i2, obj, fy4.S1(j), -9223372036854775807L));
        }

        public void k(final oh2 oh2Var) {
            i(new g20() { // from class: kq2
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    rq2.a aVar = this.a;
                    ((rq2) obj).s(aVar.a, aVar.b, oh2Var);
                }
            });
        }

        public void l(ty1 ty1Var, int i) {
            m(ty1Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void m(ty1 ty1Var, int i, int i2, t41 t41Var, int i3, Object obj, long j, long j2) {
            n(ty1Var, new oh2(i, i2, t41Var, i3, obj, fy4.S1(j), fy4.S1(j2)));
        }

        public void n(final ty1 ty1Var, final oh2 oh2Var) {
            i(new g20() { // from class: oq2
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    rq2.a aVar = this.a;
                    ((rq2) obj).y(aVar.a, aVar.b, ty1Var, oh2Var);
                }
            });
        }

        public void o(ty1 ty1Var, int i) {
            p(ty1Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void p(ty1 ty1Var, int i, int i2, t41 t41Var, int i3, Object obj, long j, long j2) {
            q(ty1Var, new oh2(i, i2, t41Var, i3, obj, fy4.S1(j), fy4.S1(j2)));
        }

        public void q(final ty1 ty1Var, final oh2 oh2Var) {
            i(new g20() { // from class: mq2
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    rq2.a aVar = this.a;
                    ((rq2) obj).z(aVar.a, aVar.b, ty1Var, oh2Var);
                }
            });
        }

        public void r(ty1 ty1Var, int i, int i2, t41 t41Var, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
            t(ty1Var, new oh2(i, i2, t41Var, i3, obj, fy4.S1(j), fy4.S1(j2)), iOException, z);
        }

        public void s(ty1 ty1Var, int i, IOException iOException, boolean z) {
            r(ty1Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void t(final ty1 ty1Var, final oh2 oh2Var, final IOException iOException, final boolean z) {
            i(new g20() { // from class: nq2
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    rq2.a aVar = this.a;
                    ((rq2) obj).B(aVar.a, aVar.b, ty1Var, oh2Var, iOException, z);
                }
            });
        }

        public void u(ty1 ty1Var, int i, int i2) {
            v(ty1Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i2);
        }

        public void v(ty1 ty1Var, int i, int i2, t41 t41Var, int i3, Object obj, long j, long j2, int i4) {
            w(ty1Var, new oh2(i, i2, t41Var, i3, obj, fy4.S1(j), fy4.S1(j2)), i4);
        }

        public void w(final ty1 ty1Var, final oh2 oh2Var, final int i) {
            i(new g20() { // from class: lq2
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    rq2.a aVar = this.a;
                    ((rq2) obj).H(aVar.a, aVar.b, ty1Var, oh2Var, i);
                }
            });
        }

        public void x(rq2 rq2Var) {
            for (C0118a c0118a : this.c) {
                if (c0118a.b == rq2Var) {
                    this.c.remove(c0118a);
                }
            }
        }

        public void y(int i, long j, long j2) {
            z(new oh2(1, i, null, 3, null, fy4.S1(j), fy4.S1(j2)));
        }

        public void z(final oh2 oh2Var) {
            final jq2.b bVar = (jq2.b) gg3.q(this.b);
            i(new g20() { // from class: pq2
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    rq2 rq2Var = (rq2) obj;
                    rq2Var.v(this.a.a, bVar, oh2Var);
                }
            });
        }

        public a(CopyOnWriteArrayList copyOnWriteArrayList, int i, jq2.b bVar) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.b = bVar;
        }
    }
}
