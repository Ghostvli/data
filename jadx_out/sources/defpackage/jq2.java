package defpackage;

import android.os.Handler;
import defpackage.ki4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface jq2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        public static final a a = sq2.b;

        default a a(ki4.a aVar) {
            return this;
        }

        default a b(boolean z) {
            return this;
        }

        default a c(int i) {
            return this;
        }

        default a d(xi4 xi4Var) {
            return this;
        }

        jq2 e(fg2 fg2Var);

        a f(zo0 zo0Var);

        a g(sy1 sy1Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void a(jq2 jq2Var, no4 no4Var);
    }

    default boolean a(fg2 fg2Var) {
        return false;
    }

    void b(Handler handler, rq2 rq2Var);

    void c(rq2 rq2Var);

    mi2 d(b bVar, j5 j5Var, long j);

    void e(Handler handler, wo0 wo0Var);

    void f(c cVar, hs4 hs4Var, ie3 ie3Var);

    void g(wo0 wo0Var);

    void h(c cVar);

    fg2 i();

    void k(c cVar);

    void m();

    default boolean n() {
        return true;
    }

    default no4 o() {
        return null;
    }

    default void q(fg2 fg2Var) {
    }

    void s(mi2 mi2Var);

    void u(c cVar);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Object a;
        public final int b;
        public final int c;
        public final long d;
        public final int e;

        public b(Object obj, int i, int i2, long j, int i3) {
            this.a = obj;
            this.b = i;
            this.c = i2;
            this.d = j;
            this.e = i3;
        }

        public b a(Object obj) {
            return this.a.equals(obj) ? this : new b(obj, this.b, this.c, this.d, this.e);
        }

        public b b(long j) {
            return this.d == j ? this : new b(this.a, this.b, this.c, j, this.e);
        }

        public boolean c() {
            return this.b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e;
        }

        public int hashCode() {
            return ((((((((527 + this.a.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
        }

        public b(Object obj, long j) {
            this(obj, -1, -1, j, -1);
        }

        public b(Object obj, long j, int i) {
            this(obj, -1, -1, j, i);
        }

        public b(Object obj, int i, int i2, long j) {
            this(obj, i, i2, j, -1);
        }

        public b(Object obj) {
            this(obj, -1L);
        }
    }
}
