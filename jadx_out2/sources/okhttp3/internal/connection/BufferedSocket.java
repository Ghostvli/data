package okhttp3.internal.connection;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Socket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSocket extends Socket {
    @Override // okio.Socket
    BufferedSink getSink();

    @Override // okio.Socket
    BufferedSource getSource();
}
