package com.fongmi.quickjs.crawler;

import android.content.Context;
import com.fongmi.quickjs.method.Console;
import com.fongmi.quickjs.method.Global;
import com.fongmi.quickjs.method.Local;
import com.github.catvod.utils.Asset;
import com.github.catvod.utils.Json;
import com.github.catvod.utils.UriUtil;
import com.github.catvod.utils.Util;
import com.whl.quickjs.wrapper.JSArray;
import com.whl.quickjs.wrapper.JSObject;
import com.whl.quickjs.wrapper.QuickJSContext;
import dalvik.system.DexClassLoader;
import defpackage.au2;
import defpackage.eb;
import defpackage.pm1;
import defpackage.ur3;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Spider extends com.github.catvod.crawler.Spider {
    public final ExecutorService a = Executors.newSingleThreadExecutor();
    public final DexClassLoader b;
    public final String c;
    public QuickJSContext d;
    public JSObject e;
    public boolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends QuickJSContext.BytecodeModuleLoader {
        public a() {
        }

        @Override // com.whl.quickjs.wrapper.ModuleLoader
        public byte[] getModuleBytecode(String str) {
            return Spider.this.d.compileModule(au2.c().b(str), str);
        }

        @Override // com.whl.quickjs.wrapper.ModuleLoader
        public String moduleNormalizeName(String str, String str2) {
            return UriUtil.resolve(str, str2);
        }
    }

    public Spider(String str, DexClassLoader dexClassLoader) {
        this.c = str;
        this.b = dexClassLoader;
    }

    public final Object[] A(final Map map) {
        final JSArray jSArray = (JSArray) k("proxy", (JSObject) D(new Callable() { // from class: fc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.w(map);
            }
        }).get());
        Objects.requireNonNull(jSArray);
        JSONArray jSONArray = new JSONArray((String) D(new Callable() { // from class: gc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return jSArray.stringify();
            }
        }).get());
        return new Object[]{Integer.valueOf(jSONArray.optInt(0)), jSONArray.optString(1), p(jSONArray.opt(2), jSONArray.length() > 4 && jSONArray.optInt(4) == 1), jSONArray.length() > 3 ? Json.toMap(jSONArray.optString(3)) : null};
    }

    public final Object[] B(Map map) {
        final String str = (String) map.get("url");
        final String str2 = (String) map.get("header");
        ur3 ur3VarH = ur3.h((String) k("proxy", (JSArray) D(new Callable() { // from class: ic4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.x(str);
            }
        }).get(), D(new Callable() { // from class: jc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.y(str2);
            }
        }).get()));
        return new Object[]{Integer.valueOf(ur3VarH.b()), ur3VarH.d(), ur3VarH.g()};
    }

    public final void C() throws ExecutionException, InterruptedException {
        D(new Callable() { // from class: mc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.z();
            }
        }).get();
    }

    public final Future D(Callable callable) {
        return this.a.submit(callable);
    }

    @Override // com.github.catvod.crawler.Spider
    public String action(String str) {
        return (String) k("action", str);
    }

    @Override // com.github.catvod.crawler.Spider
    public String categoryContent(String str, String str2, boolean z, final HashMap<String, String> map) {
        return (String) k("category", str, str2, Boolean.valueOf(z), (JSObject) D(new Callable() { // from class: kc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.s(map);
            }
        }).get());
    }

    @Override // com.github.catvod.crawler.Spider
    public void destroy() {
        try {
            k("destroy", new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            C();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public String detailContent(List<String> list) {
        return (String) k("detail", list.get(0));
    }

    @Override // com.github.catvod.crawler.Spider
    public String homeContent(boolean z) {
        return (String) k("home", Boolean.valueOf(z));
    }

    @Override // com.github.catvod.crawler.Spider
    public String homeVideoContent() {
        return (String) k("homeVod", new Object[0]);
    }

    @Override // com.github.catvod.crawler.Spider
    public void init(Context context, final String str) throws ExecutionException, InterruptedException {
        q();
        k("init", D(new Callable() { // from class: hc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.t(str);
            }
        }).get());
    }

    @Override // com.github.catvod.crawler.Spider
    public boolean isVideoFormat(String str) {
        return ((Boolean) k("isVideo", str)).booleanValue();
    }

    public final Object k(final String str, final Object... objArr) {
        return ((CompletableFuture) D(new Callable() { // from class: ec4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.r(str, objArr);
            }
        }).get()).get();
    }

    public final void l() {
        QuickJSContext quickJSContextCreate = QuickJSContext.create();
        this.d = quickJSContextCreate;
        quickJSContextCreate.setConsole(new Console());
        this.d.evaluate(Asset.read("js/lib/http.js"));
        this.d.getGlobalObject().setProperty("local", Local.class);
        this.d.setModuleLoader(new a());
    }

    @Override // com.github.catvod.crawler.Spider
    public String liveContent(String str) {
        return (String) k("live", str);
    }

    public final void m() {
        try {
            Global.create(this.d, this.a);
            this.b.loadClass("com.github.catvod.js.Function").getDeclaredConstructor(QuickJSContext.class).newInstance(this.d);
        } catch (Throwable unused) {
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public boolean manualVideoCheck() {
        return ((Boolean) k("sniffer", new Object[0])).booleanValue();
    }

    public final void n() {
        String strB = au2.c().b(this.c);
        this.f = strB.contains("__jsEvalReturn");
        this.d.evaluateModule(strB.replace("__JS_SPIDER__", "globalThis.__JS_SPIDER__"), this.c);
        this.d.evaluateModule(String.format(Asset.read("js/lib/spider.js"), this.c));
        QuickJSContext quickJSContext = this.d;
        this.e = (JSObject) quickJSContext.getProperty(quickJSContext.getGlobalObject(), "__JS_SPIDER__");
    }

    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final Object t(String str) {
        if (!this.f) {
            return Json.isObj(str) ? this.d.parse(str) : str;
        }
        JSObject jSObjectCreateNewJSObject = this.d.createNewJSObject();
        jSObjectCreateNewJSObject.setProperty("stype", 3);
        jSObjectCreateNewJSObject.setProperty("skey", this.siteKey);
        if (Json.isObj(str)) {
            jSObjectCreateNewJSObject.setProperty("ext", (JSObject) this.d.parse(str));
            return jSObjectCreateNewJSObject;
        }
        jSObjectCreateNewJSObject.setProperty("ext", str);
        return jSObjectCreateNewJSObject;
    }

    public final ByteArrayInputStream p(Object obj, boolean z) {
        if (obj instanceof byte[]) {
            return new ByteArrayInputStream((byte[]) obj);
        }
        String string = obj.toString();
        if (z && string.contains("base64,")) {
            string = string.split("base64,")[1];
        }
        return new ByteArrayInputStream(z ? Util.decode(string) : string.getBytes());
    }

    @Override // com.github.catvod.crawler.Spider
    public String playerContent(String str, String str2, final List<String> list) {
        return (String) k("play", str, str2, (JSArray) D(new Callable() { // from class: lc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.v(list);
            }
        }).get());
    }

    @Override // com.github.catvod.crawler.Spider
    public Object[] proxy(Map<String, String> map) {
        return "catvod".equals(map.get("from")) ? B(map) : A(map);
    }

    public final void q() throws ExecutionException, InterruptedException {
        D(new Callable() { // from class: nc4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.u();
            }
        }).get();
    }

    public final /* synthetic */ CompletableFuture r(String str, Object[] objArr) {
        return eb.i(this.e, str, objArr);
    }

    public final /* synthetic */ JSObject s(HashMap map) {
        return pm1.c(this.d, map);
    }

    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z) {
        return (String) k("search", str, Boolean.valueOf(z));
    }

    public final /* synthetic */ Object u() {
        l();
        m();
        n();
        return null;
    }

    public final /* synthetic */ JSArray v(List list) {
        return pm1.a(this.d, list);
    }

    public final /* synthetic */ JSObject w(Map map) {
        return pm1.c(this.d, map);
    }

    public final /* synthetic */ JSArray x(String str) {
        return pm1.a(this.d, Arrays.asList(str.split(ServiceReference.DELIMITER)));
    }

    public final /* synthetic */ Object y(String str) {
        return this.d.parse(str);
    }

    public final /* synthetic */ Object z() {
        this.e.release();
        this.d.destroy();
        return null;
    }

    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z, String str2) {
        return (String) k("search", str, Boolean.valueOf(z), str2);
    }
}
