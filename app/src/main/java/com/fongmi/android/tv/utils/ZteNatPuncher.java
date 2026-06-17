package com.fongmi.android.tv.utils;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZteNatPuncher {
    private static final byte[] MAGIC = {82, 122, -28, 100};
    private static final String TAG = "ZteNatPuncher";

    private static class Log {
        static void d(String tag, String msg) { Logger.t(tag).d(msg); }
        static void i(String tag, String msg) { Logger.t(tag).i(msg); }
        static void w(String tag, String msg) { Logger.t(tag).w(msg); }
        static void e(String tag, String msg, Throwable t) { Logger.t(tag).e(t, msg); }
        static void e(String tag, String msg) { Logger.t(tag).e(msg); }
    }
    
    private static void fileLog(String msg) {
        Log.d(TAG, msg);
        try {
            java.io.File file = new java.io.File(android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS), "zte_proxy_debug.txt");
            java.io.FileOutputStream fos = new java.io.FileOutputStream(file, true);
            String line = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", java.util.Locale.getDefault()).format(new java.util.Date()) + " " + msg + "\n";
            fos.write(line.getBytes("UTF-8"));
            fos.close();
        } catch (Throwable ignored) {}
    }

    private volatile Thread acceptThread;
    private volatile Session activeSession;
    private volatile Thread heartbeatThread;
    /* access modifiers changed from: private */
    public volatile String localIp;
    private volatile int localProxyPort;
    /* access modifiers changed from: private */
    public volatile boolean running;
    private ServerSocket serverSocket;
    private volatile boolean zteNatMode;

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
        private final byte[] sendBuffer = new byte[65536];

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
                this.upstreamSock.setSoTimeout(10000);
                this.upstreamSock.setTcpNoDelay(true);
                Log.i(ZteNatPuncher.TAG, "Connected to upstream " + str + ":" + i);
            }
        }

        private String forwardToUpstream(String str, String str2) {
            String strRewriteUriForUpstream;
            String str3;
            int port;
            String strExtractHeader;
            int iIndexOf;
            int i;
            String str4;
            String r4 = "503";
            try {
                String[] strArrSplit = str.split("\r\n");
                String[] strArrSplit2 = strArrSplit[0].split(" ", 3);
                String str5 = strArrSplit2[0];
                String str6 = strArrSplit2[1];
                boolean isSetup = "SETUP".equals(str5);
                String str7 = "/";
                String origUrl = rewriteUriForUpstream(str6);
                if (isSetup) {
                    strRewriteUriForUpstream = this.contentBase;
                    if (strRewriteUriForUpstream == null) {
                        strRewriteUriForUpstream = origUrl;
                    }
                } else {
                    strRewriteUriForUpstream = this.upstreamUrl;
                    if (strRewriteUriForUpstream == null) {
                        strRewriteUriForUpstream = origUrl;
                    }
                }
                if (isSetup) {
                    String str8 = this.trackId;
                    if (str8 != null && !str8.equals("*")) {
                        if (!strRewriteUriForUpstream.endsWith("/")) {
                            strRewriteUriForUpstream = strRewriteUriForUpstream.concat("/");
                        }
                        strRewriteUriForUpstream = strRewriteUriForUpstream + this.trackId;
                    }
                }
                Socket socket = this.upstreamSock;
                if (socket == null || socket.isClosed()) {
                    if (strRewriteUriForUpstream != null) {
                        URI uri = new URI(strRewriteUriForUpstream);
                        String host = uri.getHost();
                        if (uri.getPort() > 0) {
                            str3 = "*";
                            port = uri.getPort();
                        } else {
                            str3 = "*";
                            port = 554;
                        }
                        ensureUpstream(host, port);
                    } else {
                        str3 = "*";
                    }
                } else {
                    str3 = "*";
                }
                
                this.cseq++;
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(" ");
                sb.append(strRewriteUriForUpstream);
                sb.append(" RTSP/1.0\r\n");
                int i2 = 1;
                boolean z = false;
                while (true) {
                    String[] strArr = strArrSplit;
                    if (i2 >= strArrSplit.length) {
                        break;
                    }
                    String str9 = strArr[i2];
                    if (str9.isEmpty()) {
                        i = i2;
                        str4 = str7;
                    } else {
                        i = i2;
                        String lowerCase = str9.toLowerCase();
                        str4 = str7;
                        if (lowerCase.startsWith("cseq:")) {
                            sb.append("CSeq: ");
                            sb.append(this.cseq);
                            sb.append("\r\n");
                            z = true;
                        } else if ((!lowerCase.startsWith("transport:") || !"SETUP".equals(str5)) && !lowerCase.startsWith("user-agent:") && (!this.zteNat || !lowerCase.startsWith("x-nat:"))) {
                            sb.append(str9);
                            sb.append("\r\n");
                        }
                    }
                    i2 = i + 1;
                    strArrSplit = strArr;
                    str7 = str4;
                }
                String str10 = str7;
                if (!z) {
                    sb.append("CSeq: ");
                    sb.append(this.cseq);
                    sb.append("\r\n");
                }
                
                try {
                    if (isSetup) {
                        try {
                            sb = new StringBuilder();
                            r4 = "503";
                            sb.append("SETUP ");
                            sb.append(strRewriteUriForUpstream);
                            sb.append(" RTSP/1.0\r\n");
                            sb.append("CSeq: ");
                            sb.append(this.cseq);
                            sb.append("\r\n");
                            if (this.zteNat || this.udpRelayNeeded) {
                                if (this.rtpRelaySock == null) {
                                    DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
                                    this.rtpRelaySock = datagramSocket;
                                    datagramSocket.setReuseAddress(true);
                                    this.rtpRelaySock.bind(new InetSocketAddress(0));
                                    this.localRtpPort = this.rtpRelaySock.getLocalPort();
                                    Log.i(ZteNatPuncher.TAG, "RTP relay socket bound to port " + this.localRtpPort);
                                }
                                sb.append("Transport: MP2T/RTP/UDP;unicast;client_address=" + ZteNatPuncher.this.localIp + ";client_port=" + this.localRtpPort + "-" + (this.localRtpPort + 1) + ";mode=PLAY\r\n");
                            } else {
                                String strExtractHeader2 = ZteNatPuncher.this.extractHeader(str, "Transport");
                                if (strExtractHeader2 != null) {
                                    sb.append("Transport: ");
                                    sb.append(strExtractHeader2);
                                    sb.append("\r\n");
                                } else {
                                    sb.append("Transport: RTP/AVP/TCP;unicast;interleaved=0-1;mode=PLAY\r\n");
                                }
                            }
                            if (this.sessionId != null) {
                                sb.append("Session: ");
                                sb.append(this.sessionId);
                                sb.append("\r\n");
                            }
                            if (this.zteNat) {
                                Socket socket2 = this.upstreamSock;
                                int localPort = socket2 != null ? socket2.getLocalPort() : 0;
                                sb.append("x-NAT: ");
                                sb.append(ZteNatPuncher.this.localIp);
                                sb.append(":");
                                sb.append(localPort);
                                sb.append("\r\n");
                            }
                            sb.append("User-Agent: HMTL RTSP 1.0; CTC/2.0\r\n");
                            sb.append("\r\n");
                        } catch (Exception e) {
                            r4 = "503";
                        }
                    } else {
                        r4 = "503";
                        if (this.zteNat) {
                            Socket socket3 = this.upstreamSock;
                            int localPort2 = socket3 != null ? socket3.getLocalPort() : 0;
                            sb.append("x-NAT: ");
                            sb.append(ZteNatPuncher.this.localIp);
                            sb.append(":");
                            sb.append(localPort2);
                            sb.append("\r\n");
                        }
                        if (!str.contains("User-Agent:")) {
                            sb.append("User-Agent: HMTL RTSP 1.0; CTC/2.0\r\n");
                        }
                        if ("DESCRIBE".equals(str5) && !str.contains("Accept:")) {
                            sb.append("Accept: application/sdp\r\n");
                        }
                        if ("DESCRIBE".equals(str5)) {
                            sb.append("Timeshift: 1\r\n");
                            sb.append("x-BurstSize: 1048576\r\n");
                        }
                        sb.append("\r\n");
                        if (str2 != null) {
                            if (!str2.isEmpty()) {
                                sb.append(str2);
                            }
                        }
                    }
                    String string = sb.toString();
                    Log.d(ZteNatPuncher.TAG, "Forwarding to upstream: " + str5 + " -> " + strRewriteUriForUpstream.substring(0, Math.min(80, strRewriteUriForUpstream.length())));
                    OutputStream outputStream = this.upstreamSock.getOutputStream();
                    outputStream.write(string.getBytes("UTF-8"));
                    this.upstreamSock.getOutputStream().flush();
                    String upstreamResponse = readUpstreamResponse();
                    try {
                        if (upstreamResponse == null) {
                            Log.w(ZteNatPuncher.TAG, "No response from upstream for " + str5);
                            return buildRtspResponse(r4, "Upstream timeout");
                        }
                        int iExtractStatusCode = ZteNatPuncher.this.extractStatusCode(upstreamResponse);
                        Log.d(ZteNatPuncher.TAG, "Upstream response: " + str5 + " -> " + iExtractStatusCode);
                        if (("DESCRIBE".equals(str5) || "OPTIONS".equals(str5)) && ((iExtractStatusCode == 301 || iExtractStatusCode == 302) && (strExtractHeader = ZteNatPuncher.this.extractHeader(upstreamResponse, "Location")) != null && !strExtractHeader.isEmpty())) {
                            Log.i(ZteNatPuncher.TAG, "RTSP redirect " + iExtractStatusCode + " -> " + strExtractHeader.substring(0, Math.min(80, strExtractHeader.length())));
                            URI uri2 = new URI(strExtractHeader);
                            String host2 = uri2.getHost();
                            int port2 = uri2.getPort() > 0 ? uri2.getPort() : 554;
                            this.upstreamUrl = strExtractHeader;
                            try {
                                this.upstreamSock.close();
                            } catch (Exception unused) {
                            }
                            this.upstreamSock = null;
                            ensureUpstream(host2, port2);
                            return forwardToUpstream(str, str2);
                        }
                        if ("DESCRIBE".equals(str5) && iExtractStatusCode == 200) {
                            String strExtractHeader3 = ZteNatPuncher.this.extractHeader(upstreamResponse, "Content-Base");
                            if (strExtractHeader3 == null || strExtractHeader3.isEmpty()) {
                                this.contentBase = strRewriteUriForUpstream;
                                if (!strRewriteUriForUpstream.endsWith(str10)) {
                                    this.contentBase += str10;
                                }
                            } else {
                                this.contentBase = strExtractHeader3;
                            }
                            Matcher matcher = Pattern.compile("a=control:(trackID=\\d+)").matcher(upstreamResponse);
                            if (matcher.find()) {
                                this.trackId = matcher.group(1);
                            } else if (upstreamResponse.contains("a=control:*")) {
                                this.trackId = str3;
                            } else {
                                this.trackId = "trackID=1";
                            }
                        }
                        if ("SETUP".equals(str5)) {
                            if (iExtractStatusCode == 461 && !this.zteNat) {
                                Log.i(ZteNatPuncher.TAG, "SETUP 461 Unsupported Transport - server requires UDP, switching to UDP relay mode");
                                this.udpRelayNeeded = true;
                                return forwardToUpstream(str, str2);
                            }
                            if (iExtractStatusCode == 200) {
                                String strExtractHeader4 = ZteNatPuncher.this.extractHeader(upstreamResponse, "Session");
                                this.sessionId = strExtractHeader4;
                                if (strExtractHeader4 != null && (iIndexOf = strExtractHeader4.indexOf(59)) > 0) {
                                    this.sessionId = this.sessionId.substring(0, iIndexOf).trim();
                                }
                                if (!this.udpRelayNeeded && !this.zteNat) {
                                    Log.i(ZteNatPuncher.TAG, "SETUP OK (transparent): session=" + this.sessionId);
                                    return rewriteGenericResponse(upstreamResponse);
                                }
                                Matcher matcher2 = Pattern.compile("server_port=(\\d+)").matcher(upstreamResponse);
                                if (matcher2.find()) {
                                    this.serverRtpPort = Integer.parseInt(matcher2.group(1));
                                }
                                Matcher matcher3 = Pattern.compile("source=([^\\r\\n;]+)").matcher(upstreamResponse);
                                if (matcher3.find()) {
                                    this.serverRtpIp = matcher3.group(1).trim();
                                } else {
                                    this.serverRtpIp = this.upstreamHost;
                                }
                                Log.i(ZteNatPuncher.TAG, "SETUP OK (UDP relay): session=" + this.sessionId + " serverRtp=" + this.serverRtpIp + ":" + this.serverRtpPort);
                                sendZteHeartbeat();
                                startHeartbeatLoop();
                                return rewriteSetupResponseToInterleaved(upstreamResponse);
                            }
                        }
                        if ("PLAY".equals(str5) && iExtractStatusCode == 200) {
                            if (this.udpRelayNeeded || this.zteNat) {
                                sendZteHeartbeat();
                                startRtpRelay();
                            } else {
                                this.transparentRelay = true;
                            }
                        }
                        return rewriteGenericResponse(upstreamResponse);
                    } catch (Exception e2) {
                        r4 = "503";
                        Log.e(ZteNatPuncher.TAG, "forwardToUpstream parsing response error", e2);
                    }
                } catch (Exception e3) {
                    r4 = "503";
                    Log.e(ZteNatPuncher.TAG, "forwardToUpstream writing error", e3);
                }
            } catch (Exception e4) {
                r4 = "503";
                Log.e(ZteNatPuncher.TAG, "forwardToUpstream error", e4);
            }
            return buildRtspResponse(r4, "Proxy error");
        }

        private void heartbeatLoop() {
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
            }
        }

        private void rtpRelayLoop() {
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

        private void transparentRelayC2ULoop(InputStream inputStream, OutputStream outputStream) {
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

        private void transparentRelayU2CLoop(InputStream inputStream, OutputStream outputStream) {
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
                String[] strArrSplit = str.split("\r\n");
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
                        rawPath = "/";
                    }
                    if (rawPath.startsWith("/") && (iIndexOf = rawPath.indexOf(47, 1)) > 0) {
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
                synchronized (this.clientSock) {
                    this.sendBuffer[0] = 36;
                    this.sendBuffer[1] = (byte) i;
                    this.sendBuffer[2] = (byte) ((i2 >> 8) & 255);
                    this.sendBuffer[3] = (byte) (i2 & 255);
                    System.arraycopy(bArr, 0, this.sendBuffer, 4, i2);
                    outputStream.write(this.sendBuffer, 0, 4 + i2);
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
                ZteNatPuncher.this.heartbeatThread = new Thread(() -> heartbeatLoop(), "ZTE-NAT-Heartbeat");
                ZteNatPuncher.this.heartbeatThread.setDaemon(true);
                ZteNatPuncher.this.heartbeatThread.start();
            }
        }

        private void startRtpRelay() {
            if (this.rtpRelayActive) {
                return;
            }
            this.rtpRelayActive = true;
            Thread thread = new Thread(() -> rtpRelayLoop(), "ZTE-RTP-Relay");
            thread.setDaemon(true);
            thread.start();
        }

        private void startTransparentRelay() {
            try {
                final InputStream inputStream = this.clientSock.getInputStream();
                final InputStream inputStream2 = this.upstreamSock.getInputStream();
                final OutputStream outputStream = this.clientSock.getOutputStream();
                final OutputStream outputStream2 = this.upstreamSock.getOutputStream();
                Thread thread = new Thread(() -> transparentRelayC2ULoop(inputStream, outputStream2), "ZTE-Transparent-C2U");
                thread.setDaemon(true);
                Thread thread2 = new Thread(() -> transparentRelayU2CLoop(inputStream2, outputStream), "ZTE-Transparent-U2C");
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
                } catch (Exception unused3) {
                }
                this.rtpRelaySock = null;
            }
            Socket socket2 = this.clientSock;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (Exception unused4) {
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
            InetAddress addr = InetAddress.getByName(host);
            if (addr.isLoopbackAddress() || addr.isSiteLocalAddress()) {
                this.localIp = addr.getHostAddress();
                return;
            }
            int port = uri.getPort() > 0 ? uri.getPort() : 554;
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 3000);
            this.localIp = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (Exception unused) {
            this.localIp = "127.0.0.1";
        }
    }

    /* access modifiers changed from: private */
    public String extractHeader(String str, String str2) {
        Matcher matcher = Pattern.compile(str2 + ":\\s*([^\\r\\n]+)", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int extractStatusCode(String str) {
        Matcher matcher = Pattern.compile("RTSP/1\\.0\\s+(\\d+)").matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return -1;
    }

    /* access modifiers changed from: private */
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

    private void acceptLoop() {
        while (this.running) {
            try {
                Socket socketAccept = this.serverSocket.accept();
                socketAccept.setSoTimeout(0);
                socketAccept.setTcpNoDelay(true);
                fileLog("MPV connected to proxy");
                handleClient(socketAccept);
            } catch (Exception e) {
                if (this.running) {
                    fileLog("Accept error: " + e.getMessage());
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
                rawPath = "/";
            }
            String rawQuery = uri.getRawQuery();
            StringBuilder sb = new StringBuilder("/");
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
            fileLog("getProxyUrl failed: " + e.getMessage());
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
            fileLog("Local RTSP proxy started on port " + this.localProxyPort + " zteNat=" + z);
            this.acceptThread = new Thread(() -> acceptLoop(), "ZTE-Proxy-Accept");
            this.acceptThread.setDaemon(true);
            this.acceptThread.start();
        } catch (Exception e) {
            fileLog("Failed to start proxy: " + e.getMessage());
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
