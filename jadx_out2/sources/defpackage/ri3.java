package defpackage;

import fi.iki.elonen.NanoHTTPD;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import j$.net.URLEncoder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.internal.Buffer;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ri3 implements zg3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith("/proxy");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        Object obj;
        try {
            Map<String, String> parms = iHTTPSession.getParms();
            parms.putAll(iHTTPSession.getHeaders());
            parms.putAll(map);
            String str2 = parms.get("do");
            if ("m3u8_sub".equals(str2)) {
                return e(parms);
            }
            if ("dash_sub".equals(str2)) {
                return c(parms);
            }
            if ("m3u8".equals(str2) && parms.get("siteKey") == null) {
                return d(parms);
            }
            Object[] objArrN = di.d().n(parms);
            Object obj2 = objArrN[0];
            if (obj2 instanceof NanoHTTPD.Response) {
                return (NanoHTTPD.Response) obj2;
            }
            String str3 = (String) objArrN[1];
            InputStream inputStreamF = (InputStream) objArrN[2];
            Map map2 = (objArrN.length <= 3 || (obj = objArrN[3]) == null) ? null : (Map) obj;
            if ("m3u8".equals(str2) && str3 != null && str3.contains("mpegURL")) {
                inputStreamF = g(inputStreamF, parms);
            } else if (str3 != null && str3.contains("dash")) {
                inputStreamF = f(inputStreamF, parms, map2);
            }
            NanoHTTPD.Response responseNewChunkedResponse = NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.lookup(((Integer) objArrN[0]).intValue()), str3, inputStreamF);
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    responseNewChunkedResponse.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return responseNewChunkedResponse;
        } catch (Throwable th) {
            th.printStackTrace();
            return gx2.c(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response c(Map map) {
        try {
            String str = (String) map.get("url");
            if (str != null && !str.isEmpty()) {
                String str2 = (String) map.get("ua");
                if (str2 == null || str2.isEmpty()) {
                    str2 = (String) map.get("User-Agent");
                }
                if (str2 == null || str2.isEmpty()) {
                    str2 = (String) map.get("user-agent");
                }
                String str3 = (String) map.get("referer");
                if (str3 == null || str3.isEmpty()) {
                    str3 = (String) map.get("Referer");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(30000);
                if (str2 != null && !str2.isEmpty()) {
                    httpURLConnection.setRequestProperty("User-Agent", str2);
                }
                if (str3 != null && !str3.isEmpty()) {
                    httpURLConnection.setRequestProperty("Referer", str3);
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                String contentType = httpURLConnection.getContentType();
                if (contentType == null) {
                    contentType = DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4;
                }
                return NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.lookup(responseCode), contentType, responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream());
            }
            return gx2.c("Missing url");
        } catch (Throwable th) {
            return gx2.c(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response d(Map map) {
        try {
            String str = (String) map.get("url");
            if (str != null && !str.isEmpty()) {
                String str2 = (String) map.get("ua");
                if (str2 == null || str2.isEmpty()) {
                    str2 = (String) map.get("User-Agent");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(30000);
                if (str2 != null && !str2.isEmpty()) {
                    httpURLConnection.setRequestProperty("User-Agent", str2);
                }
                String str3 = (String) map.get("referer");
                if (str3 != null && !str3.isEmpty()) {
                    httpURLConnection.setRequestProperty("Referer", str3);
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                return NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.lookup(responseCode), "application/vnd.apple.mpegURL", g(responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream(), map));
            }
            return gx2.c("Missing url");
        } catch (Throwable th) {
            return gx2.c(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response e(Map map) {
        try {
            String str = (String) map.get("url");
            if (str != null && !str.isEmpty()) {
                String str2 = (String) map.get("ua");
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(30000);
                if (str2 == null || str2.isEmpty()) {
                    str2 = "Mozilla/5.0 (Linux; Android 12; HD1900 Build/SKQ1.211113.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/97.0.4692.98 Mobile Safari/537.36";
                }
                httpURLConnection.setRequestProperty("User-Agent", str2);
                String str3 = (String) map.get("referer");
                if (str3 != null && !str3.isEmpty()) {
                    httpURLConnection.setRequestProperty("Referer", str3);
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                String contentType = httpURLConnection.getContentType();
                String str4 = "video/MP2T";
                if (contentType == null) {
                    contentType = "video/MP2T";
                }
                InputStream errorStream = responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                if (str.contains(".png") || contentType.contains(DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG)) {
                    errorStream = h(errorStream);
                } else {
                    str4 = contentType;
                }
                return NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.lookup(responseCode), str4, errorStream);
            }
            return gx2.c("Missing url");
        } catch (Throwable th) {
            return gx2.c(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InputStream f(InputStream inputStream, Map map, Map map2) {
        String str;
        String str2 = null;
        if (map2 != null) {
            try {
                str = null;
                for (Map.Entry entry : map2.entrySet()) {
                    String lowerCase = ((String) entry.getKey()).toLowerCase();
                    if (lowerCase.equals("user-agent")) {
                        str2 = (String) entry.getValue();
                    } else if (lowerCase.equals("referer") || lowerCase.equals("referrer")) {
                        str = (String) entry.getValue();
                    }
                }
            } catch (Throwable unused) {
                return inputStream;
            }
        } else {
            str = null;
        }
        if (str2 == null || str2.isEmpty()) {
            str2 = (String) map.get("User-Agent");
        }
        if (str2 == null || str2.isEmpty()) {
            str2 = (String) map.get("user-agent");
        }
        if (str == null || str.isEmpty()) {
            str = (String) map.get("Referer");
        }
        if (str == null || str.isEmpty()) {
            str = (String) map.get("referer");
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String strE = t14.b().e(true);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));
            }
            Matcher matcher = Pattern.compile("https?://[^\\s<>\"]+").matcher(line);
            if (matcher.find()) {
                StringBuffer stringBuffer = new StringBuffer();
                matcher.reset();
                while (matcher.find()) {
                    String strGroup = matcher.group();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(strE);
                    sb2.append("/proxy?do=dash_sub&url=");
                    sb2.append(URLEncoder.encode(strGroup, "UTF-8"));
                    if (str2 != null && !str2.isEmpty()) {
                        sb2.append("&ua=");
                        sb2.append(URLEncoder.encode(str2, "UTF-8"));
                    }
                    if (str != null && !str.isEmpty()) {
                        sb2.append("&referer=");
                        sb2.append(URLEncoder.encode(str, "UTF-8"));
                    }
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(sb2.toString()));
                }
                matcher.appendTail(stringBuffer);
                line = stringBuffer.toString();
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InputStream g(InputStream inputStream, Map map) {
        try {
            String str = (String) map.get("url");
            String strSubstring = str != null ? str.substring(0, str.lastIndexOf(47) + 1) : "";
            String str2 = (String) map.get("ua");
            if (str2 == null || str2.isEmpty()) {
                str2 = (String) map.get("User-Agent");
            }
            if (str2 == null || str2.isEmpty()) {
                str2 = (String) map.get("user-agent");
            }
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));
                }
                String strTrim = line.trim();
                if (strTrim.isEmpty() || strTrim.startsWith("#")) {
                    sb.append(line);
                } else {
                    if (!strTrim.startsWith("http://") && !strTrim.startsWith("https://")) {
                        strTrim = strSubstring + strTrim;
                    }
                    if (strTrim.startsWith("http://") || strTrim.startsWith("https://")) {
                        if (strTrim.contains(".m3u8") || strTrim.contains("m3u8/")) {
                            sb.append(t14.b().e(true));
                            sb.append("/proxy?do=m3u8&url=");
                            sb.append(URLEncoder.encode(strTrim, "UTF-8"));
                        } else {
                            sb.append(t14.b().e(true));
                            sb.append("/ts.ts?url=");
                            sb.append(URLEncoder.encode(strTrim, "UTF-8"));
                        }
                        if (str2 != null && !str2.isEmpty()) {
                            sb.append("&ua=");
                            sb.append(URLEncoder.encode(str2, "UTF-8"));
                        }
                    } else {
                        sb.append(line);
                    }
                }
                sb.append("\n");
            }
        } catch (Throwable unused) {
            return inputStream;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InputStream h(InputStream inputStream) {
        try {
            byte[] bArr = new byte[Buffer.SEGMENTING_THRESHOLD];
            int i = inputStream.read(bArr, 0, Math.min(Buffer.SEGMENTING_THRESHOLD, Buffer.SEGMENTING_THRESHOLD));
            int i2 = 8;
            if (i < 8) {
                return inputStream;
            }
            if (bArr[0] == -119) {
                if (bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= i - 188) {
                            i3 = -1;
                            break;
                        }
                        if (bArr[i3] == 71) {
                            for (int i4 = 1; i4 < 188 && i3 + i4 < i && (bArr[i3 + i4] != 71 || i4 <= 0); i4++) {
                            }
                        } else {
                            i3++;
                        }
                    }
                    if (i3 <= 0) {
                        while (true) {
                            if (i2 >= i) {
                                break;
                            }
                            if ((bArr[i2] & 255) == 71 && i2 + 188 <= i) {
                                i3 = i2;
                                break;
                            }
                            i2++;
                        }
                    }
                    if (i3 <= 0) {
                        return new a(new ByteArrayInputStream(bArr, 0, i), inputStream);
                    }
                    int i5 = i - i3;
                    byte[] bArr2 = new byte[i5];
                    System.arraycopy(bArr, i3, bArr2, 0, i5);
                    return new a(new ByteArrayInputStream(bArr2), inputStream);
                }
            }
            return new a(new ByteArrayInputStream(bArr, 0, i), inputStream);
        } catch (Throwable unused) {
            return inputStream;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends InputStream implements InputStreamRetargetInterface {
        public final InputStream f;
        public final InputStream g;
        public boolean h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(InputStream inputStream, InputStream inputStream2) {
            this.f = inputStream;
            this.g = inputStream2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                this.f.close();
            } catch (Throwable unused) {
            }
            try {
                this.g.close();
            } catch (Throwable unused2) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public int read() throws IOException {
            if (!this.h) {
                int i = this.f.read();
                if (i != -1) {
                    return i;
                }
                this.h = true;
            }
            return this.g.read();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
        public /* synthetic */ long transferTo(OutputStream outputStream) {
            return DesugarInputStream.transferTo(this, outputStream);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.h) {
                int i3 = this.f.read(bArr, i, i2);
                if (i3 > 0) {
                    return i3;
                }
                this.h = true;
            }
            return this.g.read(bArr, i, i2);
        }
    }
}
