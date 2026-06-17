package defpackage;

import defpackage.y94;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.json.HTTP;
import org.jupnp.model.message.Connection;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.transport.Router;
import org.jupnp.transport.spi.InitializationException;
import org.jupnp.transport.spi.StreamServer;
import org.jupnp.transport.spi.StreamServerConfiguration;
import org.jupnp.transport.spi.UpnpStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y94 implements StreamServer {
    public final a f;
    public ServerSocket g;
    public volatile boolean h;
    public Router i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 implements StreamServerConfiguration {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final /* synthetic */ boolean a(Object obj) {
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public final /* synthetic */ Object[] b() {
            return new Object[]{Integer.valueOf(this.a)};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        @Override // org.jupnp.transport.spi.StreamServerConfiguration
        public int getListenPort() {
            return this.a;
        }

        public final int hashCode() {
            return x94.a(this.a);
        }

        public final String toString() {
            return yq.a(b(), a.class, "a");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends to3 implements Connection {
        public final Socket a;

        public b(Socket socket) {
            this.a = socket;
        }

        private /* synthetic */ boolean a(Object obj) {
            return (obj instanceof b) && Objects.equals(this.a, ((b) obj).a);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.a};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        @Override // org.jupnp.model.message.Connection
        public InetAddress getLocalAddress() {
            return this.a.getLocalAddress();
        }

        @Override // org.jupnp.model.message.Connection
        public InetAddress getRemoteAddress() {
            return this.a.getInetAddress();
        }

        public final int hashCode() {
            return Objects.hashCode(this.a);
        }

        @Override // org.jupnp.model.message.Connection
        public boolean isOpen() {
            return !this.a.isClosed();
        }

        public final String toString() {
            return yq.a(b(), b.class, "a");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends UpnpStream {
        public final Socket f;

        public c(ProtocolFactory protocolFactory, Socket socket) {
            super(protocolFactory);
            this.f = socket;
        }

        public static /* synthetic */ List a(String str) {
            return new ArrayList();
        }

        public final StreamRequestMessage b(String str, String str2, Map map) {
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.getByHttpName(str), URI.create(str2));
            streamRequestMessage.setConnection(new b(this.f));
            streamRequestMessage.setHeaders(new UpnpHeaders((Map<String, List<String>>) map));
            return streamRequestMessage;
        }

        public final void c(InputStream inputStream, StreamRequestMessage streamRequestMessage, Map map) throws IOException {
            List list = (List) map.getOrDefault("content-length", Collections.EMPTY_LIST);
            if (list == null || list.isEmpty()) {
                return;
            }
            int i = 0;
            int i2 = Integer.parseInt(((String) list.get(0)).trim());
            if (i2 <= 0) {
                return;
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int i3 = inputStream.read(bArr, i, i2 - i);
                if (i3 == -1) {
                    break;
                } else {
                    i += i3;
                }
            }
            if (streamRequestMessage.isContentTypeMissingOrText()) {
                streamRequestMessage.setBodyCharacters(bArr);
            } else {
                streamRequestMessage.setBody(UpnpMessage.BodyType.BYTES, bArr);
            }
        }

        public final Map d(InputStream inputStream) throws IOException {
            HashMap map = new HashMap();
            while (true) {
                String strE = e(inputStream);
                if (strE.isEmpty()) {
                    return map;
                }
                int iIndexOf = strE.indexOf(58);
                if (iIndexOf >= 0) {
                    ((List) map.computeIfAbsent(strE.substring(0, iIndexOf).trim().toLowerCase(), new Function() { // from class: ba4
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return y94.c.a((String) obj);
                        }
                    })).add(strE.substring(iIndexOf + 1).trim());
                }
            }
        }

        public final String e(InputStream inputStream) throws IOException {
            StringBuilder sb = new StringBuilder();
            int i = -1;
            while (true) {
                int i2 = inputStream.read();
                if (i2 == -1) {
                    return sb.toString();
                }
                if (i == 13 && i2 == 10) {
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
                sb.append((char) i2);
                i = i2;
            }
        }

        public final void f(OutputStream outputStream) throws IOException {
            outputStream.write(HTTP.CRLF.getBytes(StandardCharsets.ISO_8859_1));
        }

        public final void g(OutputStream outputStream, String str, String str2) throws IOException {
            outputStream.write((str + ": " + str2 + HTTP.CRLF).getBytes(StandardCharsets.ISO_8859_1));
        }

        public final void h(OutputStream outputStream, StreamResponseMessage streamResponseMessage) throws IOException {
            if (streamResponseMessage == null) {
                i(outputStream, 404, "Not Found");
                g(outputStream, "Content-Length", "0");
                f(outputStream);
                return;
            }
            i(outputStream, streamResponseMessage.getOperation().getStatusCode(), streamResponseMessage.getOperation().getStatusMessage());
            for (Map.Entry<String, List<String>> entry : streamResponseMessage.getHeaders().entrySet()) {
                if (entry.getKey() != null) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        g(outputStream, entry.getKey(), it.next());
                    }
                }
            }
            byte[] bodyBytes = streamResponseMessage.hasBody() ? streamResponseMessage.getBodyBytes() : null;
            g(outputStream, "Content-Length", String.valueOf(bodyBytes != null ? bodyBytes.length : 0));
            f(outputStream);
            if (bodyBytes == null || bodyBytes.length <= 0) {
                return;
            }
            outputStream.write(bodyBytes);
        }

        public final void i(OutputStream outputStream, int i, String str) throws IOException {
            outputStream.write(("HTTP/1.1 " + i + " " + ((String) aa4.a(str, "")) + HTTP.CRLF).getBytes(StandardCharsets.ISO_8859_1));
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    try {
                        InputStream inputStream = this.f.getInputStream();
                        String strE = e(inputStream);
                        String[] strArrSplit = strE.split(" ", 3);
                        if (strE.isEmpty() || strArrSplit.length < 2) {
                            this.f.close();
                        } else {
                            Map mapD = d(inputStream);
                            StreamRequestMessage streamRequestMessageB = b(strArrSplit[0], strArrSplit[1], mapD);
                            c(inputStream, streamRequestMessageB, mapD);
                            StreamResponseMessage streamResponseMessageProcess = process(streamRequestMessageB);
                            OutputStream outputStream = this.f.getOutputStream();
                            h(outputStream, streamResponseMessageProcess);
                            outputStream.flush();
                            responseSent(streamResponseMessageProcess);
                        }
                        this.f.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e) {
                    responseException(e);
                    this.f.close();
                }
            } catch (Throwable th) {
                try {
                    this.f.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
    }

    public y94(a aVar) {
        this.f = aVar;
    }

    @Override // org.jupnp.transport.spi.StreamServer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a getConfiguration() {
        return this.f;
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public int getPort() {
        ServerSocket serverSocket = this.g;
        if (serverSocket != null) {
            return serverSocket.getLocalPort();
        }
        return -1;
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public void init(InetAddress inetAddress, Router router) {
        this.i = router;
        try {
            ServerSocket serverSocket = new ServerSocket();
            this.g = serverSocket;
            serverSocket.setReuseAddress(true);
            this.g.bind(new InetSocketAddress(inetAddress, this.f.getListenPort()), 50);
        } catch (IOException e) {
            throw new InitializationException("Could not bind HTTP server socket on " + inetAddress, e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.h) {
            try {
                Socket socketAccept = this.g.accept();
                socketAccept.setSoTimeout(30000);
                Router router = this.i;
                router.received(new c(router.getProtocolFactory(), socketAccept));
            } catch (SocketException unused) {
                return;
            } catch (IOException unused2) {
            }
        }
    }

    @Override // org.jupnp.transport.spi.StreamServer
    public void stop() {
        this.h = true;
        try {
            ServerSocket serverSocket = this.g;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException unused) {
        }
    }
}
