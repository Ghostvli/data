package defpackage;

import android.net.Uri;
import defpackage.rq2;
import defpackage.sy1;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface df1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        df1 a(oe1 oe1Var, sy1 sy1Var, cf1 cf1Var, ev evVar, xi4 xi4Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a();

        boolean e(Uri uri, sy1.c cVar, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends IOException {
        public final Uri f;

        public c(Uri uri) {
            this.f = uri;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends IOException {
        public final Uri f;

        public d(Uri uri) {
            this.f = uri;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void t(we1 we1Var);
    }

    boolean a();

    boolean b(ef1 ef1Var, long j);

    boolean c(Uri uri);

    boolean d(Uri uri, long j);

    void e(Uri uri);

    void f(Uri uri);

    List g(int i);

    void h(Uri uri, rq2.a aVar, e eVar);

    long i();

    ze1 k();

    boolean m(Uri uri, long j);

    void n();

    void o(Uri uri);

    ef1 q(Uri uri);

    we1 r(Uri uri, boolean z);

    void s(b bVar);

    void stop();

    void t(b bVar);
}
