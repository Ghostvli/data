package defpackage;

import android.net.Uri;
import defpackage.ki4;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface pz0 {
    public static final pz0 a = new pz0() { // from class: oz0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pz0
        public final hz0[] d() {
            return pz0.b();
        }
    };

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0001: NEW_ARRAY (0 int) (LINE:2) type: hz0[] */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static /* synthetic */ hz0[] b() {
        return new hz0[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default pz0 a(ki4.a aVar) {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default pz0 c(int i) {
        return this;
    }

    hz0[] d();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default pz0 e(boolean z) {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default hz0[] f(Uri uri, Map map) {
        return d();
    }
}
