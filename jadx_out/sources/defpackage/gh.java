package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gh {
    public final AtomicInteger a = new AtomicInteger(0);
    public boolean b;
    public volatile Config c;
    public volatile Future d;

    public abstract Config e();

    public synchronized void f() {
        try {
            if (l()) {
                return;
            }
            if (this.c == null) {
                this.c = e();
            }
            t14.b().i();
            o(this.c);
        } finally {
        }
    }

    public final JsonArray g(String str) {
        try {
            JsonElement string = JsonParser.parseString(q53.E(qx4.a(str)));
            return string.isJsonArray() ? string.getAsJsonArray() : new JsonArray();
        } catch (Exception unused) {
            return new JsonArray();
        }
    }

    public JsonArray h(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            return new JsonArray();
        }
        JsonElement jsonElementG = jsonObject.get(str);
        if (jsonElementG.isJsonObject()) {
            return new JsonArray();
        }
        if (jsonElementG.isJsonPrimitive()) {
            jsonElementG = g(jsonElementG.getAsString());
        }
        JsonArray jsonArray = new JsonArray();
        for (JsonElement jsonElement : jsonElementG.getAsJsonArray()) {
            if (jsonElement.isJsonPrimitive()) {
                jsonArray.addAll(g(jsonElement.getAsString()));
            } else if (jsonElement.isJsonObject()) {
                jsonArray.add(jsonElement);
            }
        }
        return jsonArray;
    }

    public Config i() {
        return this.c == null ? e() : this.c;
    }

    public abstract String j();

    public boolean k(Throwable th) {
        if ("Canceled".equals(th.getMessage()) || (th instanceof InterruptedException) || (th instanceof InterruptedIOException)) {
            return true;
        }
        return th.getCause() instanceof InterruptedIOException;
    }

    public abstract boolean l();

    public final /* synthetic */ void m(int i, to toVar) {
        p(i, this.c, toVar);
    }

    public void n(final to toVar) {
        final int iIncrementAndGet = this.a.incrementAndGet();
        if (this.d != null && !this.d.isDone()) {
            this.d.cancel(true);
        }
        this.d = ul4.h(new Runnable() { // from class: bh
            @Override // java.lang.Runnable
            public final void run() {
                this.f.m(iIncrementAndGet, toVar);
            }
        });
        toVar.c();
    }

    public abstract void o(Config config);

    public void p(int i, final Config config, final to toVar) {
        try {
            t14.b().i();
            q53.e(j());
            o(config);
            if (this.a.get() != i) {
                if (this.a.get() == i) {
                    r();
                    return;
                }
                return;
            }
            if (config.equals(this.c)) {
                config.update();
            }
            App.d(new Runnable() { // from class: ch
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(config.getNotice());
                }
            });
            Objects.requireNonNull(toVar);
            App.d(new dh(toVar));
            if (this.a.get() == i) {
                r();
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                boolean zK = k(th);
                AtomicInteger atomicInteger = this.a;
                if (zK) {
                    if (atomicInteger.get() != i) {
                        return;
                    }
                } else if (atomicInteger.get() == i) {
                    if (TextUtils.isEmpty(config.getUrl())) {
                        App.d(new Runnable() { // from class: eh
                            @Override // java.lang.Runnable
                            public final void run() {
                                toVar.b("");
                            }
                        });
                    } else {
                        App.d(new Runnable() { // from class: fh
                            @Override // java.lang.Runnable
                            public final void run() {
                                toVar.b(i43.e(sm3.A, th));
                            }
                        });
                    }
                    if (this.a.get() != i) {
                        return;
                    }
                } else if (this.a.get() != i) {
                    return;
                }
                r();
            } catch (Throwable th2) {
                if (this.a.get() == i) {
                    r();
                }
                throw th2;
            }
        }
    }

    public boolean q(String str) {
        return this.b || this.c == null || TextUtils.isEmpty(this.c.getUrl()) || str.equals(this.c.getUrl());
    }

    public void r() {
        c00.d();
    }

    public void s(List list) {
        q53.C().a(list);
    }

    public void t(List list) {
        q53.m().f(list);
    }

    public void u(List list) {
        q53.c().a(list);
        q53.D().a(list);
    }
}
