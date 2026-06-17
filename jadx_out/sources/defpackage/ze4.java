package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ze4 extends wj1 {
    String a();

    boolean b();

    String d();

    long e();

    boolean f();

    default List g() {
        return Collections.EMPTY_LIST;
    }

    long getDuration();

    default l20 j() {
        return l20.UNKNOWN;
    }

    default boolean k() {
        return false;
    }

    String l();

    qa0 m();

    gf4 o();

    default String q() {
        return null;
    }
}
