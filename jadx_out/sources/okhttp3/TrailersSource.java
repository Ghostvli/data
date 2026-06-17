package okhttp3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface TrailersSource {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final TrailersSource EMPTY = new TrailersSource() { // from class: okhttp3.TrailersSource$Companion$EMPTY$1
        @Override // okhttp3.TrailersSource
        public Headers get() {
            return Headers.EMPTY;
        }

        @Override // okhttp3.TrailersSource
        public Headers peek() {
            return Headers.EMPTY;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class DefaultImpls {
        @Deprecated
        public static Headers peek(TrailersSource trailersSource) {
            return TrailersSource.super.peek();
        }
    }

    Headers get();

    default Headers peek() {
        return null;
    }
}
