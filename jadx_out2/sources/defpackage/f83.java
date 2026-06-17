package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Parse;
import com.fongmi.android.tv.bean.Result;
import com.github.catvod.utils.Json;
import com.github.catvod.utils.Util;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f83 implements w73 {
    public w73 e;
    public Parse f;
    public final AtomicBoolean a = new AtomicBoolean();
    public ExecutorService c = Executors.newSingleThreadExecutor();
    public ExecutorService d = Executors.newCachedThreadPool();
    public final List b = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f83(w73 w73Var) {
        this.e = w73Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f83 k(w73 w73Var) {
        return new f83(w73Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(Result result, boolean z) {
        if (z) {
            this.f = b75.I().Q();
        }
        if (result.getPlayUrl().startsWith("json:")) {
            this.f = Parse.get(1, result.getPlayUrl().substring(5));
        }
        if (result.getPlayUrl().startsWith("parse:")) {
            this.f = b75.I().R(result.getPlayUrl().substring(6));
        }
        Parse parse = this.f;
        if (parse == null || parse.isEmpty()) {
            this.f = Parse.get(0, result.getPlayUrl());
        }
        this.f.setHeader(result.getHeader());
        this.f.setClick(n(result));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f83 B(Result result, boolean z) {
        A(result, z);
        m(result);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(String str, Parse parse, String str2) {
        D(str, parse.getName(), parse.getHeader(), parse.getUrl() + str2, parse.getClick());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(final String str, final String str2, final Map map, final String str3, final String str4) {
        if (w85.a()) {
            App.d(new Runnable() { // from class: c83
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.y(str, str2, map, str3, str4);
                }
            });
        } else {
            a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(List list, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((Parse) it.next()).getUrl());
            sb.append(";");
        }
        F(new HashMap(), t14.b().d("/parse?jxs=" + Util.substring(sb.toString()) + "&url=" + str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(Map map, String str) {
        D("", "", map, str, "");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G() {
        ExecutorService executorService = this.c;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        ExecutorService executorService2 = this.d;
        if (executorService2 != null) {
            executorService2.shutdownNow();
        }
        this.d = null;
        this.c = null;
        this.e = null;
        this.a.set(true);
        H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((f70) it.next()).I(false);
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((f70) it2.next()).destroy();
        }
        if (this.b.isEmpty()) {
            return;
        }
        this.b.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I(final String str, String str2) throws InterruptedException {
        List<Parse> listU = b75.I().U(1, str2);
        List listU2 = b75.I().U(0, str2);
        final CountDownLatch countDownLatch = new CountDownLatch(listU.size() + (1 ^ (listU2.isEmpty() ? 1 : 0)));
        for (final Parse parse : listU) {
            this.d.execute(new Runnable() { // from class: d83
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.z(countDownLatch, parse, str);
                }
            });
        }
        if (!listU2.isEmpty()) {
            E(listU2, str);
        }
        countDownLatch.await();
        a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w73
    public void a() {
        if (this.a.compareAndSet(false, true)) {
            App.d(new Runnable() { // from class: b83
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.w();
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w73
    public void b(final Map map, final String str, final String str2) {
        if (this.a.compareAndSet(false, true)) {
            App.d(new Runnable() { // from class: e83
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.x(map, str, str2);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(Result result) {
        result.setHeader(this.f.getHeader());
        if (result.getUrl().isEmpty()) {
            a();
        } else if (result.needParse()) {
            F(result.getHeader(), qx4.a(result.getUrl().v()));
        } else {
            b(result.getHeader(), result.getUrl().v(), result.getJxFrom());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(Map map, String str, String str2, boolean z) {
        if (str.length() > 40) {
            b(map, str, str2);
        } else if (z) {
            a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(String str, String str2, String str3) throws InterruptedException {
        int iIntValue = this.f.getType().intValue();
        if (iIntValue == 0) {
            C(str, this.f, str2);
            return;
        }
        if (iIntValue == 1) {
            s(this.f, str2, true);
            return;
        }
        if (iIntValue == 2) {
            q(str2);
        } else if (iIntValue == 3) {
            r(str2, str3);
        } else {
            if (iIntValue != 4) {
                return;
            }
            I(str2, str3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(Result result) {
        final Future<?> futureSubmit = this.c.submit(p(result));
        ul4.f(new Runnable() { // from class: z73
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.u(futureSubmit);
            }
        }, f10.j, TimeUnit.MILLISECONDS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String n(Result result) {
        String click = b75.I().W(result.getKey()).getClick();
        return !TextUtils.isEmpty(click) ? click : result.getClick();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map o(JsonObject jsonObject) {
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            if (!entry.getValue().isJsonNull() && (entry.getKey().equalsIgnoreCase("User-Agent") || entry.getKey().equalsIgnoreCase("Referer") || entry.getKey().equalsIgnoreCase("Cookie") || entry.getKey().equalsIgnoreCase("ua"))) {
                map.put(qx4.b(entry.getKey()), entry.getValue().getAsString());
            }
        }
        return map.isEmpty() ? this.f.getHeader() : map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Runnable p(final Result result) {
        return new Runnable() { // from class: a83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.v(result);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Parse parse : b75.I().S()) {
            if (parse.getType().intValue() == 1) {
                linkedHashMap.put(parse.getName(), parse.extUrl());
            }
        }
        i(Result.fromObject(di.d().j(this.f.getUrl(), linkedHashMap, str)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Parse parse : b75.I().S()) {
            linkedHashMap.put(parse.getName(), parse.mixMap());
        }
        i(Result.fromObject(di.d().k(str2, this.f.getUrl(), this.f.getName(), linkedHashMap, str)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(Parse parse, String str, boolean z) {
        Response responseExecute = q53.s(parse.getUrl() + str, parse.getHeader()).execute();
        try {
            JsonObject asJsonObject = Json.parse(responseExecute.body().string()).getAsJsonObject();
            String strSafeString = Json.safeString(asJsonObject, "url");
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("data");
            if (strSafeString.isEmpty()) {
                strSafeString = Json.safeString(asJsonObject2, "url");
            }
            j(o(asJsonObject), strSafeString, parse.getName(), z);
            responseExecute.close();
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: z(Ljava/util/concurrent/CountDownLatch;Lcom/fongmi/android/tv/bean/Parse;Ljava/lang/String;)V */
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final void z(CountDownLatch countDownLatch, Parse parse, String str) {
        try {
            s(parse, str, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void u(Future future) {
        if (future.cancel(true)) {
            a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void v(Result result) {
        try {
            l(result.getKey(), result.getUrl().v(), result.getFlag());
        } catch (Throwable unused) {
            a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void w() {
        w73 w73Var = this.e;
        if (w73Var != null) {
            w73Var.a();
        }
        G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void x(Map map, String str, String str2) {
        w73 w73Var = this.e;
        if (w73Var != null) {
            w73Var.b(map, str, str2);
        }
        G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void y(String str, String str2, Map map, String str3, String str4) {
        this.b.add(f70.r(App.b()).G(str, str2, map, str3, str4, this, !str3.contains("player/?url=")));
    }
}
