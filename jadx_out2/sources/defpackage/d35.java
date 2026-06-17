package defpackage;

import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface d35 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        public static final a a = new C0075a();

        /* JADX INFO: renamed from: d35$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0075a implements a {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void onVideoSizeChanged(e35 e35Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(long j);

        void skip();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends Exception {
        public final t41 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Throwable th, t41 t41Var) {
            super(th);
            this.f = t41Var;
        }
    }

    boolean b();

    void c(long j, long j2);

    Surface d();

    void e(Surface surface, d94 d94Var);

    boolean f(long j, b bVar);

    void g();

    void h();

    void i(long j);

    boolean isInitialized();

    void j();

    void k(int i);

    void l();

    boolean m(t41 t41Var);

    void n(boolean z);

    void o(List list);

    void p(boolean z);

    boolean q(boolean z);

    void r(int i, t41 t41Var, long j, int i2, List list);

    void release();

    void s(a aVar, Executor executor);

    void setPlaybackSpeed(float f);

    void t(j25 j25Var);

    void u();

    void v();
}
