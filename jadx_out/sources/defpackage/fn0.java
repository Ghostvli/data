package defpackage;

import com.github.catvod.utils.Path;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fn0 {
    public final File a;
    public final String b;
    public String c;

    public fn0(String str, File file) {
        this.c = str;
        this.b = str;
        this.a = file;
    }

    public static fn0 a(String str, File file) {
        return new fn0(str, file);
    }

    public final void b() {
        try {
            Response responseExecute = q53.r(this.b, this.c).execute();
            try {
                c(responseExecute.body().byteStream(), e(responseExecute));
                responseExecute.close();
            } finally {
            }
        } catch (Exception e) {
            Path.clear(this.a);
            cx4.a(e.getMessage(), e);
        }
    }

    public final void c(InputStream inputStream, double d) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Path.create(this.a));
            try {
                byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    } else {
                        if (Thread.interrupted()) {
                            fileOutputStream.close();
                            bufferedInputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public File d() {
        b();
        return this.a;
    }

    public final double e(Response response) {
        try {
            String strHeader = response.header("Content-Length");
            if (strHeader != null) {
                return Double.parseDouble(strHeader);
            }
        } catch (Exception unused) {
        }
        return -1.0d;
    }

    public fn0 f(String str) {
        this.c = str;
        return this;
    }
}
