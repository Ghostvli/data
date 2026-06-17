package defpackage;

import android.text.TextUtils;
import android.util.LruCache;
import com.github.catvod.utils.Asset;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class au2 {
    public final LruCache a = new LruCache(50);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile au2 a = new au2();
    }

    public static au2 c() {
        return a.a;
    }

    public void a() {
        this.a.evictAll();
    }

    public String b(String str) {
        String str2 = (String) this.a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (str.startsWith("http")) {
            LruCache lruCache = this.a;
            String strE = q53.E(str);
            lruCache.put(str, strE);
            return strE;
        }
        if (str.startsWith("assets")) {
            LruCache lruCache2 = this.a;
            String str3 = Asset.read(str);
            lruCache2.put(str, str3);
            return str3;
        }
        if (!str.startsWith("lib/")) {
            return str2;
        }
        LruCache lruCache3 = this.a;
        String str4 = Asset.read("js/".concat(str));
        lruCache3.put(str, str4);
        return str4;
    }
}
