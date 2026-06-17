package net.engio.mbassy.bus.error;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface IPublicationErrorHandler {
    void handleError(PublicationError publicationError);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ConsoleLogger implements IPublicationErrorHandler {
        private final boolean printStackTrace;

        public ConsoleLogger(boolean z) {
            this.printStackTrace = z;
        }

        @Override // net.engio.mbassy.bus.error.IPublicationErrorHandler
        public void handleError(PublicationError publicationError) {
            System.out.println(publicationError);
            if (!this.printStackTrace || publicationError.getCause() == null) {
                return;
            }
            publicationError.getCause().printStackTrace();
        }

        public ConsoleLogger() {
            this(false);
        }
    }
}
