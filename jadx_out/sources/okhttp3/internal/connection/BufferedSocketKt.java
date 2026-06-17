package okhttp3.internal.connection;

import java.net.Socket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class BufferedSocketKt {
    public static final BufferedSocket asBufferedSocket(Socket socket) {
        socket.getClass();
        return asBufferedSocket(Okio.socket(socket));
    }

    public static final BufferedSocket asBufferedSocket(okio.Socket socket) {
        socket.getClass();
        return new BufferedSocket(socket) { // from class: okhttp3.internal.connection.BufferedSocketKt.asBufferedSocket.1
            private final okio.Socket delegate;
            private final BufferedSink sink;
            private final BufferedSource source;

            {
                this.delegate = socket;
                this.source = Okio.buffer(socket.getSource());
                this.sink = Okio.buffer(socket.getSink());
            }

            @Override // okio.Socket
            public void cancel() {
                this.delegate.cancel();
            }

            @Override // okio.Socket
            public BufferedSink getSink() {
                return this.sink;
            }

            @Override // okio.Socket
            public BufferedSource getSource() {
                return this.source;
            }
        };
    }
}
