package com.github.catvod.utils;

import android.util.Log;
import com.hierynomus.msdtyp.FileTime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.HTTP;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ZteNatPuncher {
    private static final byte[] MAGIC = {82, 122, -28, 100};
    private static final String TAG = "ZteNatPuncher";
    private volatile Thread acceptThread;
    private volatile Session activeSession;
    private volatile Thread heartbeatThread;
    private volatile String localIp;
    private volatile int localProxyPort;
    private volatile boolean running;
    private ServerSocket serverSocket;
    private volatile boolean zteNatMode;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class Session {
        private final Socket clientSock;
        private String contentBase;
        private int localRtpPort;
        private volatile boolean rtpRelayActive;
        private DatagramSocket rtpRelaySock;
        private String serverRtpIp;
        private int serverRtpPort;
        private String sessionId;
        private volatile boolean sessionRunning;
        private String trackId;
        private volatile boolean transparentRelay;
        private boolean udpRelayNeeded;
        private String upstreamHost;
        private int upstreamPort;
        private Socket upstreamSock;
        private String upstreamUrl;
        private boolean zteNat;
        private int cseq = 0;
        private int clientCseq = 0;
        private int interleavedChannel = 0;

        public Session(Socket socket, boolean z) {
            this.clientSock = socket;
            this.zteNat = z;
        }

        private String buildRtspResponse(String str, String str2) {
            return "RTSP/1.0 " + str + " " + str2 + "\r\nCSeq: " + this.clientCseq + "\r\n\r\n";
        }

        private void ensureUpstream(String str, int i) throws IOException {
            Socket socket = this.upstreamSock;
            if (socket == null || socket.isClosed() || !str.equals(this.upstreamHost) || i != this.upstreamPort) {
                Socket socket2 = this.upstreamSock;
                if (socket2 != null) {
                    try {
                        socket2.close();
                    } catch (Exception unused) {
                    }
                }
                this.upstreamHost = str;
                this.upstreamPort = i;
                Socket socket3 = new Socket();
                this.upstreamSock = socket3;
                socket3.connect(new InetSocketAddress(str, i), 5000);
                this.upstreamSock.setSoTimeout(FileTime.NANO100_TO_MILLI);
                this.upstreamSock.setTcpNoDelay(true);
                Log.i(ZteNatPuncher.TAG, "Connected to upstream " + str + ":" + i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
        /* JADX WARN: Type inference failed for: r19v12 */
        /* JADX WARN: Type inference failed for: r19v13 */
        /* JADX WARN: Type inference failed for: r19v14 */
        /* JADX WARN: Type inference failed for: r19v3 */
        /* JADX WARN: Type inference failed for: r19v4 */
        /* JADX WARN: Type inference failed for: r19v5 */
        /* JADX WARN: Type inference failed for: r19v6 */
        /* JADX WARN: Type inference failed for: r19v7 */
        /* JADX WARN: Type inference failed for: r19v8 */
        /* JADX WARN: Type inference failed for: r24v0, types: [com.github.catvod.utils.ZteNatPuncher$Session] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v26 */
        /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v30 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.lang.String forwardToUpstream(java.lang.String r25, java.lang.String r26) {
            /*
                Method dump skipped, instruction units count: 1298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.utils.ZteNatPuncher.Session.forwardToUpstream(java.lang.String, java.lang.String):java.lang.String");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startHeartbeatLoop$3() {
            while (this.sessionRunning && ZteNatPuncher.this.running) {
                try {
                    Thread.sleep(25000L);
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    Log.w(ZteNatPuncher.TAG, "Heartbeat error: " + e.getMessage());
                }
                if (this.sessionRunning && ZteNatPuncher.this.running) {
                    sendZteHeartbeat();
                }
                return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startRtpRelay$2() {
            Socket socket;
            try {
                byte[] bArr = new byte[65536];
                while (this.sessionRunning && this.rtpRelayActive && this.rtpRelaySock != null) {
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 65536);
                    this.rtpRelaySock.receive(datagramPacket);
                    int length = datagramPacket.getLength();
                    if (length > 0 && (socket = this.clientSock) != null && !socket.isClosed()) {
                        sendInterleaved(this.interleavedChannel, datagramPacket.getData(), length);
                    }
                }
            } catch (Exception e) {
                if (this.sessionRunning) {
                    Log.d(ZteNatPuncher.TAG, "RTP relay ended: " + e.getMessage());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startTransparentRelay$0(InputStream inputStream, OutputStream outputStream) {
            int i;
            try {
                byte[] bArr = new byte[65536];
                while (this.sessionRunning && (i = inputStream.read(bArr)) > 0) {
                    outputStream.write(bArr, 0, i);
                    outputStream.flush();
                }
            } catch (Exception e) {
                if (this.sessionRunning) {
                    Log.d(ZteNatPuncher.TAG, "C->U relay ended: " + e.getMessage());
                }
            } finally {
                this.sessionRunning = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startTransparentRelay$1(InputStream inputStream, OutputStream outputStream) {
            int i;
            try {
                byte[] bArr = new byte[65536];
                while (this.sessionRunning && (i = inputStream.read(bArr)) > 0) {
                    outputStream.write(bArr, 0, i);
                    outputStream.flush();
                }
            } catch (Exception e) {
                if (this.sessionRunning) {
                    Log.d(ZteNatPuncher.TAG, "U->C relay ended: " + e.getMessage());
                }
            } finally {
                this.sessionRunning = false;
            }
        }

        private String processRequest(String str, String str2) {
            try {
                String[] strArrSplit = str.split(HTTP.CRLF);
                if (strArrSplit.length == 0) {
                    return null;
                }
                String[] strArrSplit2 = strArrSplit[0].split(" ", 3);
                if (strArrSplit2.length < 2) {
                    return null;
                }
                String str3 = strArrSplit2[0];
                String str4 = strArrSplit2[1];
                Log.d(ZteNatPuncher.TAG, "Client request: " + str3 + " " + str4.substring(0, Math.min(80, str4.length())));
                Matcher matcher = Pattern.compile("CSeq:\\s*(\\d+)", 2).matcher(str);
                if (matcher.find()) {
                    this.clientCseq = Integer.parseInt(matcher.group(1));
                }
                if (!"OPTIONS".equals(str3) && !"DESCRIBE".equals(str3) && !"SETUP".equals(str3) && !"PLAY".equals(str3) && !"TEARDOWN".equals(str3) && !"GET_PARAMETER".equals(str3)) {
                    if (!"PAUSE".equals(str3)) {
                        return buildRtspResponse("451", "Invalid method");
                    }
                    Log.d(ZteNatPuncher.TAG, "PAUSE intercepted (not supported by upstream), returning 200 OK");
                    return buildRtspResponse("200", "OK");
                }
                return forwardToUpstream(str, str2);
            } catch (Exception e) {
                Log.e(ZteNatPuncher.TAG, "processRequest error", e);
                return null;
            }
        }

        private String readUpstreamResponse() {
            try {
                InputStream inputStream = this.upstreamSock.getInputStream();
                byte[] bArr = new byte[32768];
                long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
                int i = 0;
                while (i < 32768 && System.currentTimeMillis() < jCurrentTimeMillis) {
                    int iAvailable = inputStream.available();
                    if (iAvailable > 0) {
                        int i2 = inputStream.read(bArr, i, Math.min(iAvailable, 32768 - i));
                        if (i2 <= 0) {
                            break;
                        }
                        i += i2;
                        String str = new String(bArr, 0, i, "UTF-8");
                        if (str.contains("\r\n\r\n")) {
                            Matcher matcher = Pattern.compile("Content-Length:\\s*(\\d+)", 2).matcher(str);
                            if (matcher.find()) {
                                int i3 = Integer.parseInt(matcher.group(1));
                                int iIndexOf = str.indexOf("\r\n\r\n") + 4;
                                while (i < iIndexOf + i3 && System.currentTimeMillis() < jCurrentTimeMillis) {
                                    int iAvailable2 = inputStream.available();
                                    if (iAvailable2 > 0) {
                                        int i4 = inputStream.read(bArr, i, Math.min(iAvailable2, 32768 - i));
                                        if (i4 <= 0) {
                                            break;
                                        }
                                        i += i4;
                                    } else {
                                        Thread.sleep(50L);
                                    }
                                }
                            }
                            return new String(bArr, 0, i, "UTF-8");
                        }
                    } else {
                        Thread.sleep(50L);
                    }
                }
                if (i > 0) {
                    return new String(bArr, 0, i, "UTF-8");
                }
                return null;
            } catch (Exception e) {
                Log.w(ZteNatPuncher.TAG, "readUpstreamResponse error: " + e.getMessage());
                return null;
            }
        }

        private String rewriteGenericResponse(String str) {
            try {
                return str.replaceAll("CSeq:\\s*\\d+", "CSeq: " + this.clientCseq);
            } catch (Exception unused) {
                return str;
            }
        }

        private String rewriteSetupResponseToInterleaved(String str) {
            try {
                return str.replaceAll("Transport:[^\\r\\n]+", "Transport: RTP/AVP/TCP;unicast;interleaved=0-1;mode=PLAY");
            } catch (Exception unused) {
                return str;
            }
        }

        private String rewriteUriForUpstream(String str) {
            int iIndexOf;
            try {
                if (str.startsWith("rtsp://127.0.0.1") || str.startsWith("rtsp://localhost")) {
                    URI uri = new URI(str);
                    String rawPath = uri.getRawPath();
                    if (rawPath == null) {
                        rawPath = ServiceReference.DELIMITER;
                    }
                    if (rawPath.startsWith(ServiceReference.DELIMITER) && (iIndexOf = rawPath.indexOf(47, 1)) > 0) {
                        String strSubstring = rawPath.substring(1, iIndexOf);
                        String strSubstring2 = rawPath.substring(iIndexOf);
                        int iLastIndexOf = strSubstring.lastIndexOf(58);
                        if (iLastIndexOf > 0) {
                            String strSubstring3 = strSubstring.substring(0, iLastIndexOf);
                            int i = Integer.parseInt(strSubstring.substring(iLastIndexOf + 1));
                            this.upstreamHost = strSubstring3;
                            this.upstreamPort = i;
                        } else {
                            this.upstreamHost = strSubstring;
                            this.upstreamPort = 554;
                        }
                        String rawQuery = uri.getRawQuery();
                        if (rawQuery != null) {
                            strSubstring2 = strSubstring2 + "?" + rawQuery;
                        }
                        String str2 = "rtsp://" + this.upstreamHost + ":" + this.upstreamPort + strSubstring2;
                        if (this.upstreamUrl == null) {
                            this.upstreamUrl = str2;
                        }
                        return str2;
                    }
                } else if (this.upstreamUrl != null && !str.contains("://")) {
                    return this.upstreamUrl;
                }
                return str;
            } catch (Exception e) {
                Log.w(ZteNatPuncher.TAG, "rewriteUri failed: " + e.getMessage());
                return str;
            }
        }

        private void sendInterleaved(int i, byte[] bArr, int i2) {
            try {
                OutputStream outputStream = this.clientSock.getOutputStream();
                byte[] bArr2 = {36, (byte) i, (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
                synchronized (this.clientSock) {
                    outputStream.write(bArr2);
                    outputStream.write(bArr, 0, i2);
                    outputStream.flush();
                }
            } catch (Exception e) {
                Log.w(ZteNatPuncher.TAG, "sendInterleaved error: " + e.getMessage());
            }
        }

        private void sendZteHeartbeat() {
            if (this.rtpRelaySock == null || this.serverRtpIp == null || this.serverRtpPort <= 0) {
                StringBuilder sb = new StringBuilder("Cannot send heartbeat: relay=");
                sb.append(this.rtpRelaySock != null);
                sb.append(" server=");
                sb.append(this.serverRtpIp);
                sb.append(":");
                sb.append(this.serverRtpPort);
                Log.w(ZteNatPuncher.TAG, sb.toString());
                return;
            }
            try {
                byte[] bytes = "ZXV10STB".getBytes("UTF-8");
                byte[] bArr = {127, -1, -1, -1};
                byte[] bArr2 = new byte[4];
                if (ZteNatPuncher.this.localIp != null) {
                    String[] strArrSplit = ZteNatPuncher.this.localIp.split("\\.");
                    for (int i = 0; i < 4 && i < strArrSplit.length; i++) {
                        bArr2[i] = (byte) Integer.parseInt(strArrSplit[i]);
                    }
                }
                int i2 = this.localRtpPort;
                byte[] bArr3 = {(byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
                Socket socket = this.upstreamSock;
                int localPort = socket != null ? socket.getLocalPort() : 0;
                byte[] bArr4 = {(byte) ((localPort >> 8) & 255), (byte) (localPort & 255)};
                byte[] bArr5 = new byte[84];
                System.arraycopy(bytes, 0, bArr5, 0, 8);
                System.arraycopy(bArr, 0, bArr5, 8, 4);
                System.arraycopy(bArr2, 0, bArr5, 12, 4);
                System.arraycopy(ZteNatPuncher.MAGIC, 0, bArr5, 16, 4);
                bArr5[16] = bArr3[0];
                bArr5[17] = bArr3[1];
                bArr5[18] = bArr4[0];
                bArr5[19] = bArr4[1];
                this.rtpRelaySock.send(new DatagramPacket(bArr5, 84, InetAddress.getByName(this.serverRtpIp), this.serverRtpPort));
                Log.d(ZteNatPuncher.TAG, "ZTE heartbeat sent to " + this.serverRtpIp + ":" + this.serverRtpPort + " from port " + this.localRtpPort);
            } catch (Exception e) {
                Log.w(ZteNatPuncher.TAG, "ZTE heartbeat failed: " + e.getMessage());
            }
        }

        private void startHeartbeatLoop() {
            if (ZteNatPuncher.this.heartbeatThread == null || !ZteNatPuncher.this.heartbeatThread.isAlive()) {
                ZteNatPuncher.this.heartbeatThread = new Thread(new Runnable() { // from class: com.github.catvod.utils.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.lambda$startHeartbeatLoop$3();
                    }
                }, "ZTE-NAT-Heartbeat");
                ZteNatPuncher.this.heartbeatThread.setDaemon(true);
                ZteNatPuncher.this.heartbeatThread.start();
            }
        }

        private void startRtpRelay() {
            if (this.rtpRelayActive) {
                return;
            }
            this.rtpRelayActive = true;
            Thread thread = new Thread(new Runnable() { // from class: com.github.catvod.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.lambda$startRtpRelay$2();
                }
            }, "ZTE-RTP-Relay");
            thread.setDaemon(true);
            thread.start();
        }

        private void startTransparentRelay() {
            try {
                final InputStream inputStream = this.clientSock.getInputStream();
                final InputStream inputStream2 = this.upstreamSock.getInputStream();
                final OutputStream outputStream = this.clientSock.getOutputStream();
                final OutputStream outputStream2 = this.upstreamSock.getOutputStream();
                Thread thread = new Thread(new Runnable() { // from class: com.github.catvod.utils.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.lambda$startTransparentRelay$0(inputStream, outputStream2);
                    }
                }, "ZTE-Transparent-C2U");
                thread.setDaemon(true);
                Thread thread2 = new Thread(new Runnable() { // from class: com.github.catvod.utils.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.lambda$startTransparentRelay$1(inputStream2, outputStream);
                    }
                }, "ZTE-Transparent-U2C");
                thread2.setDaemon(true);
                thread.start();
                thread2.start();
                thread.join();
                thread2.join();
            } catch (Exception e) {
                Log.w(ZteNatPuncher.TAG, "Transparent relay error: " + e.getMessage());
            }
        }

        public void close() {
            this.sessionRunning = false;
            this.rtpRelayActive = false;
            Socket socket = this.upstreamSock;
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception unused) {
                }
                this.upstreamSock = null;
            }
            DatagramSocket datagramSocket = this.rtpRelaySock;
            if (datagramSocket != null) {
                try {
                    datagramSocket.close();
                } catch (Exception unused2) {
                }
                this.rtpRelaySock = null;
            }
            Socket socket2 = this.clientSock;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (Exception unused3) {
                }
            }
        }

        public void run() {
            int i;
            this.sessionRunning = true;
            try {
                try {
                    InputStream inputStream = this.clientSock.getInputStream();
                    byte[] bArr = new byte[65536];
                    StringBuilder sb = new StringBuilder();
                    while (this.sessionRunning && !this.transparentRelay && (i = inputStream.read(bArr)) > 0) {
                        sb.append(new String(bArr, 0, i, "UTF-8"));
                        while (sb.indexOf("\r\n\r\n") >= 0) {
                            int iIndexOf = sb.indexOf("\r\n\r\n") + 4;
                            String strSubstring = sb.substring(0, iIndexOf);
                            sb.delete(0, iIndexOf);
                            int contentLength = ZteNatPuncher.this.getContentLength(strSubstring);
                            while (contentLength > 0 && sb.length() < contentLength) {
                                int i2 = inputStream.read(bArr);
                                if (i2 <= 0) {
                                    break;
                                } else {
                                    sb.append(new String(bArr, 0, i2, "UTF-8"));
                                }
                            }
                            String strSubstring2 = contentLength > 0 ? sb.substring(0, Math.min(contentLength, sb.length())) : "";
                            if (contentLength > 0) {
                                sb.delete(0, Math.min(contentLength, sb.length()));
                            }
                            String strProcessRequest = processRequest(strSubstring, strSubstring2);
                            if (strProcessRequest != null) {
                                this.clientSock.getOutputStream().write(strProcessRequest.getBytes("UTF-8"));
                                this.clientSock.getOutputStream().flush();
                            }
                        }
                    }
                    if (this.transparentRelay && this.sessionRunning) {
                        Log.i(ZteNatPuncher.TAG, "Switching to transparent TCP relay");
                        startTransparentRelay();
                    }
                } catch (Exception e) {
                    if (this.sessionRunning) {
                        Log.d(ZteNatPuncher.TAG, "Client session ended: " + e.getMessage());
                    }
                }
                this.sessionRunning = false;
                close();
            } catch (Throwable th) {
                this.sessionRunning = false;
                close();
                throw th;
            }
        }
    }

    private void detectLocalIp(String str) {
        try {
            URI uri = new URI(str);
            String host = uri.getHost();
            int port = uri.getPort() > 0 ? uri.getPort() : 554;
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 3000);
            this.localIp = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (Exception unused) {
            this.localIp = "127.0.0.1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String extractHeader(String str, String str2) {
        Matcher matcher = Pattern.compile(str2 + ":\\s*([^\\r\\n]+)", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int extractStatusCode(String str) {
        Matcher matcher = Pattern.compile("RTSP/1\\.0\\s+(\\d+)").matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentLength(String str) {
        Matcher matcher = Pattern.compile("Content-Length:\\s*(\\d+)", 2).matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    private void handleClient(Socket socket) {
        Session session = this.activeSession;
        if (session != null) {
            session.close();
        }
        Session session2 = new Session(socket, this.zteNatMode);
        this.activeSession = session2;
        session2.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        while (this.running) {
            try {
                Socket socketAccept = this.serverSocket.accept();
                socketAccept.setSoTimeout(0);
                socketAccept.setTcpNoDelay(true);
                Log.i(TAG, "MPV connected to proxy");
                handleClient(socketAccept);
            } catch (Exception e) {
                if (this.running) {
                    Log.w(TAG, "Accept error: " + e.getMessage());
                }
            }
        }
    }

    public String getProxyUrl(String str) {
        if (this.localProxyPort <= 0) {
            return str;
        }
        try {
            URI uri = new URI(str);
            String rawPath = uri.getRawPath();
            if (rawPath == null) {
                rawPath = ServiceReference.DELIMITER;
            }
            String rawQuery = uri.getRawQuery();
            StringBuilder sb = new StringBuilder(ServiceReference.DELIMITER);
            sb.append(uri.getHost());
            sb.append(":");
            sb.append(uri.getPort() > 0 ? uri.getPort() : 554);
            sb.append(rawPath);
            String string = sb.toString();
            if (rawQuery != null) {
                string = string + "?" + rawQuery;
            }
            return "rtsp://127.0.0.1:" + this.localProxyPort + string;
        } catch (Exception e) {
            Log.e(TAG, "getProxyUrl failed", e);
            return str;
        }
    }

    public synchronized void start(String str, boolean z) {
        stop();
        this.zteNatMode = z;
        this.running = true;
        detectLocalIp(str);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"));
            this.serverSocket = serverSocket;
            this.localProxyPort = serverSocket.getLocalPort();
            Log.i(TAG, "Local RTSP proxy started on port " + this.localProxyPort + " zteNat=" + z);
            this.acceptThread = new Thread(new Runnable() { // from class: ef5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.lambda$start$0();
                }
            }, "ZTE-Proxy-Accept");
            this.acceptThread.setDaemon(true);
            this.acceptThread.start();
        } catch (Exception e) {
            Log.e(TAG, "Failed to start proxy", e);
            this.running = false;
        }
    }

    public synchronized void stop() {
        try {
            this.running = false;
            Session session = this.activeSession;
            if (session != null) {
                session.close();
                this.activeSession = null;
            }
            if (this.heartbeatThread != null) {
                this.heartbeatThread.interrupt();
                this.heartbeatThread = null;
            }
            if (this.acceptThread != null) {
                this.acceptThread.interrupt();
                this.acceptThread = null;
            }
            ServerSocket serverSocket = this.serverSocket;
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception unused) {
                }
                this.serverSocket = null;
            }
            this.localProxyPort = 0;
        } catch (Throwable th) {
            throw th;
        }
    }
}
