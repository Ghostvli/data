package okhttp3.internal;

import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeImageTestsAccessorsKt {
    public static final Cache buildCache(Path path, long j, FileSystem fileSystem) {
        path.getClass();
        fileSystem.getClass();
        return new Cache(fileSystem, path, j);
    }

    public static final void finishedAccessor(Dispatcher dispatcher, RealCall.AsyncCall asyncCall) {
        dispatcher.getClass();
        asyncCall.getClass();
        dispatcher.finished$okhttp(asyncCall);
    }

    public static final RealConnection getConnectionAccessor(Exchange exchange) {
        exchange.getClass();
        return exchange.getConnection$okhttp();
    }

    public static final Exchange getExchangeAccessor(Response response) {
        response.getClass();
        return response.exchange();
    }

    public static final long getIdleAtNsAccessor(RealConnection realConnection) {
        realConnection.getClass();
        return realConnection.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(RealConnection realConnection, long j) {
        realConnection.getClass();
        realConnection.setIdleAtNs(j);
    }
}
