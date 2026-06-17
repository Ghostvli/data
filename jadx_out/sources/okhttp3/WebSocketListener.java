package okhttp3;

import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i, String str) {
        webSocket.getClass();
        str.getClass();
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        webSocket.getClass();
        str.getClass();
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        webSocket.getClass();
        th.getClass();
    }

    public void onMessage(WebSocket webSocket, String str) {
        webSocket.getClass();
        str.getClass();
    }

    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.getClass();
        response.getClass();
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        webSocket.getClass();
        byteString.getClass();
    }
}
