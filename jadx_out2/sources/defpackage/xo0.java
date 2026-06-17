package defpackage;

import android.os.Looper;
import defpackage.po0;
import defpackage.wo0;
import defpackage.xo0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface xo0 {
    public static final xo0 a = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements xo0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.xo0
        public po0 a(wo0.a aVar, t41 t41Var) {
            if (t41Var.t == null) {
                return null;
            }
            return new ou0(new po0.a(new zw4(1), 6001));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.xo0
        public void c(Looper looper, ie3 ie3Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.xo0
        public int d(t41 t41Var) {
            return t41Var.t != null ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        public static final b a = new b() { // from class: yo0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xo0.b
            public final void release() {
                xo0.b.a();
            }
        };

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static /* synthetic */ void a() {
        }

        void release();
    }

    po0 a(wo0.a aVar, t41 t41Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default b b(wo0.a aVar, t41 t41Var) {
        return b.a;
    }

    void c(Looper looper, ie3 ie3Var);

    int d(t41 t41Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void prepare() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void release() {
    }
}
