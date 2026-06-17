package defpackage;

import android.content.Context;
import com.fongmi.android.tv.App;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderNull;
import com.github.catvod.utils.CryptoUtil;
import com.github.catvod.utils.Path;
import com.github.catvod.utils.Util;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xm1 {
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();
    public volatile String e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Spider a(String str, String str2, String str3, String str4) {
        try {
            Spider spider = (Spider) Class.forName(str).getDeclaredConstructor(null).newInstance(null);
            spider.siteKey = str2;
            spider.init(App.b(), str3);
            return spider;
        } catch (Throwable th) {
            th.printStackTrace();
            return new SpiderNull();
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.lang.Object.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object b(String str) {
        return new Object();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        this.c.values().forEach(new wm1());
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DexClassLoader g(String str) {
        try {
            String strMd5 = Util.md5(str);
            q(strMd5, str);
            return (DexClassLoader) this.a.get(strMd5);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider h(final String str, String str2, String str3, final String str4) {
        final String str5 = "com.github.catvod.spider." + str2.split("csp_")[1];
        final String strUnwrap = CryptoUtil.unwrap(str3);
        if (str4 == null || str4.isEmpty()) {
            return (Spider) this.c.computeIfAbsent("built_in" + str, new Function() { // from class: tm1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return xm1.a(str5, str, strUnwrap, (String) obj);
                }
            });
        }
        final String strMd5 = Util.md5(str4);
        return (Spider) this.c.computeIfAbsent(strMd5 + str, new Function() { // from class: um1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.m(strMd5, str4, str5, str, strUnwrap, (String) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(DexClassLoader dexClassLoader) {
        try {
            Class<?> clsLoadClass = dexClassLoader.loadClass("com.github.catvod.spider.Init");
            clsLoadClass.getMethod("init", Context.class).invoke(clsLoadClass, App.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(String str, DexClassLoader dexClassLoader) {
        try {
            this.b.put(str, dexClassLoader.loadClass("com.github.catvod.spider.Proxy").getMethod("proxy", Map.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JSONObject k(String str, LinkedHashMap linkedHashMap, String str2) {
        return (JSONObject) t().loadClass("com.github.catvod.parser.Json" + str).getMethod("parse", LinkedHashMap.class, String.class).invoke(null, linkedHashMap, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JSONObject l(String str, String str2, String str3, LinkedHashMap linkedHashMap, String str4) {
        return (JSONObject) t().loadClass("com.github.catvod.parser.Mix" + str2).getMethod("parse", LinkedHashMap.class, String.class, String.class, String.class).invoke(null, linkedHashMap, str3, str, str4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Spider m(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            q(str, str2);
            DexClassLoader dexClassLoader = (DexClassLoader) this.a.get(str);
            if (dexClassLoader == null) {
                return new SpiderNull();
            }
            Spider spider = (Spider) dexClassLoader.loadClass(str3).newInstance();
            spider.siteKey = str4;
            spider.init(App.b(), str5);
            return spider;
        } catch (Throwable th) {
            th.printStackTrace();
            return new SpiderNull();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean n(Map.Entry entry) {
        return !((String) entry.getKey()).equals(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Object[] o(Map map, Map.Entry entry) {
        return s((Method) entry.getValue(), map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(String str, File file) {
        if (!Thread.interrupted() && Path.exists(file) && file.setReadOnly()) {
            String absolutePath = Path.jar().getAbsolutePath();
            DexClassLoader dexClassLoader = new DexClassLoader(file.getAbsolutePath(), absolutePath, absolutePath, App.b().getClassLoader());
            i(dexClassLoader);
            j(str, dexClassLoader);
            this.a.put(str, dexClassLoader);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(String str, String str2) {
        if (this.a.containsKey(str)) {
            return;
        }
        if (str2.startsWith("assets")) {
            str2 = qx4.a(str2);
        }
        synchronized (this.d.computeIfAbsent(str, new Function() { // from class: vm1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return xm1.b((String) obj);
            }
        })) {
            try {
                if (this.a.containsKey(str)) {
                    return;
                }
                String[] strArrSplit = str2.split(";md5;");
                String strTrim = strArrSplit.length > 1 ? strArrSplit[1].trim() : "";
                if (strTrim.startsWith("http")) {
                    strTrim = q53.E(strTrim).trim();
                }
                String str3 = strArrSplit[0];
                if (!strTrim.isEmpty() && Util.equals(str3, strTrim)) {
                    p(str, Path.jar(str3));
                } else if (str3.startsWith("http")) {
                    p(str, fn0.a(str3, Path.jar(str3)).d());
                } else if (str3.startsWith("file")) {
                    p(str, Path.local(str3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object[] r(Map map) {
        Object[] objArrS = s(this.e != null ? (Method) this.b.get(this.e) : null, map);
        return objArrS != null ? objArrS : v(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object[] s(Method method, Map map) {
        if (method == null) {
            return null;
        }
        try {
            return (Object[]) method.invoke(null, map);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final DexClassLoader t() {
        DexClassLoader dexClassLoader = (DexClassLoader) this.a.get(this.e);
        if (dexClassLoader != null) {
            return dexClassLoader;
        }
        d.a("No jar loaded for recent key: ", this.e);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u(String str) {
        this.e = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object[] v(final Map map) {
        return (Object[]) this.b.entrySet().stream().filter(new Predicate() { // from class: qm1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.n((Map.Entry) obj);
            }
        }).map(new Function() { // from class: rm1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.o(map, (Map.Entry) obj);
            }
        }).filter(new Predicate() { // from class: sm1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((Object[]) obj);
            }
        }).findFirst().orElse(null);
    }
}
