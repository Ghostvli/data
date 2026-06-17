package j$.nio.channels;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface CompletionHandler<V, A> {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final /* synthetic */ class Wrapper implements java.nio.channels.CompletionHandler {
        public /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.nio.channels.CompletionHandler convert(CompletionHandler completionHandler) {
            if (completionHandler == null) {
                return null;
            }
            if (completionHandler instanceof c) {
                throw null;
            }
            return new Wrapper();
        }

        @Override // java.nio.channels.CompletionHandler
        public final /* synthetic */ void completed(Object obj, Object obj2) {
            CompletionHandler.this.completed(obj, obj2);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            CompletionHandler completionHandler = CompletionHandler.this;
            if (obj instanceof Wrapper) {
                obj = CompletionHandler.this;
            }
            return completionHandler.equals(obj);
        }

        @Override // java.nio.channels.CompletionHandler
        public final /* synthetic */ void failed(Throwable th, Object obj) {
            CompletionHandler.this.failed(th, obj);
        }

        public final /* synthetic */ int hashCode() {
            return CompletionHandler.this.hashCode();
        }
    }

    void completed(V v, A a);

    void failed(Throwable th, A a);
}
