package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Site;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderNull;
import com.github.catvod.utils.Util;
import dalvik.system.DexClassLoader;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class di {
    public final xm1 a;
    public final bj3 b;
    public final ao1 c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile di a = new di();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public di() {
        this.a = new xm1();
        this.b = new bj3();
        this.c = new ao1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static di d() {
        return a.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean g(String str) {
        return str.startsWith("csp_");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h(String str) {
        return str.contains(".js");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(String str) {
        return str.contains(".py");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        ul4.c(new Runnable() { // from class: ci
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.l();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DexClassLoader c(String str) {
        return this.a.g(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider e(String str) {
        Site siteW = b75.I().W(str);
        Live liveO = lx1.J().O(str);
        return !siteW.isEmpty() ? siteW.spider() : !liveO.isEmpty() ? liveO.spider() : new SpiderNull();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider f(String str, String str2, String str3, String str4) {
        return i(str2) ? this.b.c(str, str2, str3) : h(str2) ? this.c.c(str, str2, str3, str4) : g(str2) ? this.a.h(str, str2, str3, str4) : new SpiderNull();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JSONObject j(String str, LinkedHashMap linkedHashMap, String str2) {
        return this.a.k(str, linkedHashMap, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JSONObject k(String str, String str2, String str3, LinkedHashMap linkedHashMap, String str4) {
        return this.a.l(str, str2, str3, linkedHashMap, str4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void l() {
        this.a.f();
        this.b.b();
        this.c.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strMd5 = Util.md5(str);
        this.a.q(strMd5, str);
        if (z) {
            this.a.u(strMd5);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object[] n(Map map) {
        return map.containsKey("siteKey") ? e((String) map.get("siteKey")).proxy(map) : "js".equals(map.get("do")) ? this.c.e(map) : "py".equals(map.get("do")) ? this.b.e(map) : this.a.r(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(String str, String str2, String str3) {
        if (h(str2)) {
            this.c.f(str);
        } else if (i(str2)) {
            this.b.f(str);
        } else if (g(str2)) {
            this.a.u(Util.md5(str3));
        }
    }
}
