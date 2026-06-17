package defpackage;

import android.util.Log;
import fi.iki.elonen.NanoHTTPD;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import okio.internal.Buffer;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xt4 implements zg3 {
    private InputStream c(InputStream inputStream) {
        int i;
        int i2;
        int i3;
        try {
            byte[] bArr = new byte[Buffer.SEGMENTING_THRESHOLD];
            int i4 = 0;
            while (true) {
                i = -1;
                if (i4 >= 4096 || (i3 = inputStream.read(bArr, i4, 4096 - i4)) == -1) {
                    break;
                }
                i4 += i3;
            }
            int i5 = 8;
            if (i4 < 8) {
                return new a(new ByteArrayInputStream(bArr, 0, i4), inputStream);
            }
            if (bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
                int i6 = 0;
                while (true) {
                    if (i6 < i4 - 188) {
                        if (bArr[i6] == 71 && (i2 = i6 + 188) < i4 && bArr[i2] == 71) {
                            i = i6;
                            break;
                        }
                        i6++;
                    } else {
                        break;
                    }
                }
                if (i <= 0) {
                    while (true) {
                        if (i5 >= i4) {
                            break;
                        }
                        if ((bArr[i5] & 255) == 71) {
                            i = i5;
                            break;
                        }
                        i5++;
                    }
                }
                if (i <= 0 || i >= i4) {
                    return new a(new ByteArrayInputStream(bArr, 0, i4), inputStream);
                }
                int i7 = i4 - i;
                byte[] bArr2 = new byte[i7];
                System.arraycopy(bArr, i, bArr2, 0, i7);
                return new a(new ByteArrayInputStream(bArr2), inputStream);
            }
            return new a(new ByteArrayInputStream(bArr, 0, i4), inputStream);
        } catch (Throwable unused) {
            return inputStream;
        }
    }

    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith("/ts.ts");
    }

    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> parms = iHTTPSession.getParms();
            String str2 = parms.get("url");
            if (str2 != null && !str2.isEmpty()) {
                Log.d("TsProxy", "fetching: ".concat(str2));
                String str3 = parms.get("ua");
                if (str3 == null || str3.isEmpty()) {
                    str3 = parms.get("User-Agent");
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(15000);
                    httpURLConnection2.setReadTimeout(30000);
                    if (str3 == null || str3.isEmpty()) {
                        str3 = "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0";
                    }
                    httpURLConnection2.setRequestProperty("User-Agent", str3);
                    String str4 = parms.get("referer");
                    if (str4 != null && !str4.isEmpty()) {
                        httpURLConnection2.setRequestProperty("Referer", str4);
                    }
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    int responseCode = httpURLConnection2.getResponseCode();
                    Log.d("TsProxy", "responseCode=" + responseCode + " url=" + str2);
                    InputStream errorStream = responseCode >= 400 ? httpURLConnection2.getErrorStream() : httpURLConnection2.getInputStream();
                    String contentType = httpURLConnection2.getContentType();
                    String str5 = "video/MP2T";
                    if (contentType == null) {
                        contentType = "video/MP2T";
                    }
                    if (str2.contains(".png") || contentType.contains(DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG)) {
                        errorStream = c(errorStream);
                    } else {
                        str5 = contentType;
                    }
                    long contentLengthLong = httpURLConnection2.getContentLengthLong();
                    return contentLengthLong > 0 ? NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.lookup(responseCode), str5, errorStream, contentLengthLong) : NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.lookup(responseCode), str5, errorStream);
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    Log.e("TsProxy", "error: " + th.getMessage(), th);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                    }
                    return gx2.c(th.getMessage());
                }
            }
            return gx2.c("Missing url");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends InputStream implements InputStreamRetargetInterface {
        public final InputStream f;
        public final InputStream g;
        public boolean h;

        public a(InputStream inputStream, InputStream inputStream2) {
            this.f = inputStream;
            this.g = inputStream2;
        }

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
