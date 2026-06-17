package defpackage;

import android.database.Cursor;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface hj4 extends Closeable {
    void A();

    void G();

    boolean f();

    String getPath();

    boolean isOpen();

    void j();

    Cursor k(lj4 lj4Var);

    List m();

    void n();

    void o(String str);

    nj4 q(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void r() {
        j();
    }

    boolean x();

    void z();
}
