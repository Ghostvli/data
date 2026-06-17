package defpackage;

import com.fongmi.android.tv.bean.Danmaku;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yy1 {
    public c6 a;

    public c6 a() {
        return this.a;
    }

    public yy1 b(Danmaku danmaku) {
        d(danmaku.getRealUrl());
        return this;
    }

    public void c(InputStream inputStream) {
        this.a = new c6(inputStream);
    }

    public void d(String str) {
        try {
            c(q53.r(str, "danmaku").execute().body().byteStream());
        } catch (Throwable unused) {
        }
    }
}
