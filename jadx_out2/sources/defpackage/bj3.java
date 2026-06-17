package defpackage;

import com.fongmi.android.tv.App;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bj3 {
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final zy1 b = new zy1();
    public volatile String c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a.values().forEach(new wm1());
        this.a.clear();
        this.c = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider c(final String str, final String str2, final String str3) {
        return (Spider) this.a.computeIfAbsent(str, new Function() { // from class: aj3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.d(str2, str, str3, (String) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Spider d(String str, String str2, String str3, String str4) {
        try {
            com.fongmi.chaquo.Spider spiderA = this.b.a(str);
            spiderA.siteKey = str2;
            spiderA.init(App.b(), str3);
            return spiderA;
        } catch (Throwable th) {
            th.printStackTrace();
            return new SpiderNull();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object[] e(Map map) {
        Spider spider;
        if (this.c == null || (spider = (Spider) this.a.get(this.c)) == null) {
            return null;
        }
        return spider.proxy(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(String str) {
        this.c = str;
    }
}
