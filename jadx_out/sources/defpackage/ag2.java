package defpackage;

import defpackage.yv0;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface ag2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final byte[] a;
        public final ty1 b;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public final byte[] a;
            public ty1 b;

            public a(byte[] bArr) {
                this.a = bArr;
            }

            public b c() {
                return new b(this);
            }

            public a d(ty1 ty1Var) {
                this.b = ty1Var;
                return this;
            }
        }

        public b(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
        }
    }

    b a(UUID uuid, yv0.d dVar);

    b b(UUID uuid, yv0.a aVar);
}
