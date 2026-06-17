package androidx.media3.exoplayer;

import androidx.media3.exoplayer.n;
import defpackage.gx3;
import defpackage.ie3;
import defpackage.jq2;
import defpackage.jq3;
import defpackage.no4;
import defpackage.t41;
import defpackage.x72;
import defpackage.zu;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface o extends n.b {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a();

        void b();
    }

    gx3 G();

    void H();

    long I();

    boolean L();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default boolean M(long j) {
        return false;
    }

    x72 N();

    boolean b();

    void c(long j, long j2);

    int d();

    void disable();

    void f(no4 no4Var);

    String getName();

    int getState();

    boolean isReady();

    boolean j();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default long l(long j, long j2) {
        if (getState() == 1) {
            return (isReady() || b()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    void m(jq3 jq3Var, t41[] t41VarArr, gx3 gx3Var, long j, boolean z, boolean z2, long j2, long j3, jq2.b bVar);

    void o(t41[] t41VarArr, gx3 gx3Var, long j, long j2, jq2.b bVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void p() {
    }

    void q();

    void release();

    void reset();

    void start();

    void stop();

    void t(long j, boolean z);

    void w(int i, ie3 ie3Var, zu zuVar);

    p x();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void z(float f, float f2) {
    }
}
