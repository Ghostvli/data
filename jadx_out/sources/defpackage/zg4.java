package defpackage;

import android.net.Uri;
import com.github.catvod.utils.Path;
import defpackage.db4;
import java.io.File;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zg4 implements db4.a {
    @Override // db4.a
    public void a() {
    }

    @Override // db4.a
    public boolean b(Uri uri) {
        return qx4.f(uri).endsWith(".strm");
    }

    @Override // db4.a
    public String c(String str) {
        if (str.startsWith("http")) {
            return d(str);
        }
        if (str.startsWith("file")) {
            str = str.substring(7);
        }
        return Path.read(new File(str)).split("\\R", 2)[0];
    }

    public final String d(String str) {
        Response responseExecute = q53.v(q53.y(), str).execute();
        try {
            String strHeader = responseExecute.header("Content-Disposition", "");
            if (strHeader.contains(".strm") || strHeader.contains(".txt")) {
                str = responseExecute.body().string().split("\\R", 2)[0];
            }
            responseExecute.close();
            return str;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // db4.a
    public void stop() {
    }
}
