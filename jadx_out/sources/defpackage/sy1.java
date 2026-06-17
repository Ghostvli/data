package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface sy1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public boolean a(int i) {
            return i == 1 ? this.a - this.b > 1 : this.c - this.d > 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final long b;

        public b(int i, long j) {
            gg3.d(j >= 0);
            this.a = i;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final ty1 a;
        public final oh2 b;
        public final IOException c;
        public final int d;

        public c(ty1 ty1Var, oh2 oh2Var, IOException iOException, int i) {
            this.a = ty1Var;
            this.b = oh2Var;
            this.c = iOException;
            this.d = i;
        }
    }

    long a(c cVar);

    b b(a aVar, c cVar);

    default void c(long j) {
    }

    int d(int i);
}
