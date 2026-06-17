package com.fongmi.quickjs.method;

import com.github.catvod.Proxy;
import com.github.catvod.utils.Trans;
import com.github.catvod.utils.UriUtil;
import com.whl.quickjs.wrapper.JSCallFunction;
import com.whl.quickjs.wrapper.JSFunction;
import com.whl.quickjs.wrapper.JSMethod;
import com.whl.quickjs.wrapper.JSObject;
import com.whl.quickjs.wrapper.QuickJSContext;
import defpackage.e00;
import defpackage.e50;
import defpackage.g02;
import defpackage.uq3;
import defpackage.yp1;
import j$.net.URLEncoder;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Global {
    private final QuickJSContext ctx;
    private final ExecutorService executor;
    private final Timer timer = new Timer();

    /* JADX INFO: renamed from: com.fongmi.quickjs.method.Global$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class AnonymousClass1 implements Callback {
        final /* synthetic */ JSFunction val$complete;
        final /* synthetic */ uq3 val$req;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public AnonymousClass1(JSFunction jSFunction, uq3 uq3Var) {
            this.val$complete = jSFunction;
            this.val$req = uq3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$1(JSFunction jSFunction) {
            jSFunction.call(e00.a(Global.this.ctx));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(JSFunction jSFunction, uq3 uq3Var, Response response) {
            jSFunction.call(e00.h(Global.this.ctx, uq3Var, response));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Global global = Global.this;
            final JSFunction jSFunction = this.val$complete;
            global.submit(new Runnable() { // from class: com.fongmi.quickjs.method.b
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.lambda$onFailure$1(jSFunction);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.Callback
        public void onResponse(Call call, final Response response) {
            Global global = Global.this;
            final JSFunction jSFunction = this.val$complete;
            final uq3 uq3Var = this.val$req;
            global.submit(new Runnable() { // from class: com.fongmi.quickjs.method.a
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.lambda$onResponse$0(jSFunction, uq3Var, response);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.fongmi.quickjs.method.Global$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class AnonymousClass2 extends TimerTask {
        final /* synthetic */ JSFunction val$func;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass2(JSFunction jSFunction) {
            this.val$func = jSFunction;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Global global = Global.this;
            final JSFunction jSFunction = this.val$func;
            Objects.requireNonNull(jSFunction);
            global.submit(new Runnable() { // from class: com.fongmi.quickjs.method.c
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    jSFunction.call(new Object[0]);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Global(QuickJSContext quickJSContext, ExecutorService executorService) {
        this.executor = executorService;
        this.ctx = quickJSContext;
        setProperty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Global create(QuickJSContext quickJSContext, ExecutorService executorService) {
        return new Global(quickJSContext, executorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Callback getCallback(JSFunction jSFunction, uq3 uq3Var) {
        return new AnonymousClass1(jSFunction, uq3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setProperty$0(Method method, Object[] objArr) {
        try {
            return method.invoke(this, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void schedule(JSFunction jSFunction, int i) {
        this.timer.schedule(new AnonymousClass2(jSFunction), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setProperty() {
        for (final Method method : getClass().getMethods()) {
            if (method.isAnnotationPresent(JSMethod.class)) {
                this.ctx.getGlobalObject().setProperty(method.getName(), new JSCallFunction() { // from class: sa1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.whl.quickjs.wrapper.JSCallFunction
                    public final Object call(Object[] objArr) {
                        return this.a.lambda$setProperty$0(method, objArr);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void submit(Runnable runnable) {
        if (this.executor.isShutdown()) {
            return;
        }
        this.executor.submit(runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public JSObject _http(String str, JSObject jSObject) {
        JSFunction jSFunction = jSObject.getJSFunction("complete");
        if (jSFunction == null) {
            return req(str, jSObject);
        }
        uq3 uq3VarM = uq3.m(jSObject.stringify());
        e00.i(str, uq3VarM).enqueue(getCallback(jSFunction, uq3VarM));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String aesX(String str, boolean z, String str2, boolean z2, String str3, String str4, boolean z3) {
        String strA = e50.a(str, z, str2, z2, str3, str4, z3);
        g02.b("aesX").a("mode:%s\nencrypt:%s\ninBase64:%s\noutBase64:%s\nkey:%s\niv:%s\ninput:\n%s\nresult:\n%s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str3, str4, str2, strA);
        return strA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public Integer getPort() {
        return Integer.valueOf(Proxy.getPort());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String getProxy(Boolean bool) {
        return Proxy.getUrl(bool.booleanValue()) + "?do=js";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String joinUrl(String str, String str2) {
        return UriUtil.resolve(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String js2Proxy(Boolean bool, Integer num, String str, String str2, JSObject jSObject) {
        return getProxy(Boolean.valueOf(!bool.booleanValue())) + String.format("&from=catvod&siteType=%s&siteKey=%s&header=%s&url=%s", num, str, URLEncoder.encode(jSObject.stringify()), URLEncoder.encode(str2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String md5X(String str) {
        String strC = e50.c(str);
        g02.b("md5X").a("text:%s\nresult:\n%s", str, strC);
        return strC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public JSObject req(String str, JSObject jSObject) {
        try {
            uq3 uq3VarM = uq3.m(jSObject.stringify());
            return e00.h(this.ctx, uq3VarM, e00.i(str, uq3VarM).execute());
        } catch (Exception unused) {
            return e00.a(this.ctx);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String rsaX(String str, boolean z, boolean z2, String str2, boolean z3, String str3, boolean z4) {
        String strD = e50.d(str, z, z2, str2, z3, str3, z4);
        g02.b("rsaX").a("mode:%s\npub:%s\nencrypt:%s\ninBase64:%s\noutBase64:%s\nkey:\n%s\ninput:\n%s\nresult:\n%s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str3, str2, strD);
        return strD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String s2t(String str) {
        return Trans.s2t(false, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public Object setTimeout(JSFunction jSFunction, Integer num) {
        jSFunction.hold();
        schedule(jSFunction, num.intValue());
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String t2s(String str) {
        return Trans.t2s(false, str);
    }
}
