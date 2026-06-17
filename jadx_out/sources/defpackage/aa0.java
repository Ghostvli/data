package defpackage;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface aa0 extends x90 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        aa0 b();
    }

    long a(ja0 ja0Var);

    void close();

    void f(hs4 hs4Var);

    Uri getUri();

    default Map o() {
        return Collections.EMPTY_MAP;
    }
}
