package defpackage;

import java.util.List;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gu2 {
    public final long a;
    public final List b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String a;
        public final String b;
        public final long c;
        public final long d;

        public a(String str, String str2, long j, long j2) {
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = j2;
        }
    }

    public gu2(long j, List list) {
        this.a = j;
        this.b = list;
    }

    public iu2 a(long j) {
        iu2 iu2Var;
        long j2;
        iu2 iu2Var2 = null;
        if (this.b.size() < 2) {
            return null;
        }
        boolean z = true;
        int size = this.b.size() - 1;
        long j3 = j;
        long j4 = -1;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        while (size >= 0) {
            a aVar = (a) this.b.get(size);
            boolean z2 = (aVar.a.equals(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4) || aVar.a.equals("video/quicktime")) ? z : false;
            if (size == 0) {
                iu2Var = iu2Var2;
                j3 -= aVar.d;
                j2 = 0;
            } else {
                iu2Var = iu2Var2;
                j2 = j3 - aVar.c;
            }
            long j8 = j3;
            j3 = j2;
            if (z2 && j3 != j8) {
                j7 = j8 - j3;
                j6 = j3;
            }
            if (size == 0) {
                j5 = j8;
                j4 = j3;
            }
            size--;
            iu2Var2 = iu2Var;
            z = true;
        }
        return (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) ? iu2Var2 : new iu2(j4, j5, this.a, j6, j7);
    }
}
