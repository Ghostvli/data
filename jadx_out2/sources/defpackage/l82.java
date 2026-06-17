package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface l82 {
    public static final l82 a = new l82() { // from class: j82
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l82
        public final List b(String str, boolean z, boolean z2) {
            return q82.k(str, z, z2);
        }
    };
    public static final l82 b = new l82() { // from class: k82
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l82
        public final List b(String str, boolean z, boolean z2) {
            return q82.o(l82.a.b(str, z, z2));
        }
    };

    List b(String str, boolean z, boolean z2);
}
