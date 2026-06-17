package defpackage;

import defpackage.hs1;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface cd1 {
    public static final cd1 a = new a();
    public static final cd1 b = new hs1.a().c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements cd1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.cd1
        public Map getHeaders() {
            return Collections.EMPTY_MAP;
        }
    }

    Map getHeaders();
}
