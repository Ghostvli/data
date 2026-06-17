package defpackage;

import android.net.Uri;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Core;
import com.github.catvod.utils.Path;
import com.google.gson.JsonObject;
import com.tvbus.engine.Listener;
import com.tvbus.engine.TVCore;
import defpackage.db4;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uk4 implements db4.a, Listener {
    public static final String j = "uk4";
    public CountDownLatch f;
    public TVCore g;
    public String h;
    public Core i;

    @Override // db4.a
    public void a() {
        TVCore tVCore = this.g;
        if (tVCore != null) {
            tVCore.stop();
        }
        this.h = null;
    }

    @Override // db4.a
    public boolean b(Uri uri) {
        return "tvbus".equals(qx4.i(uri));
    }

    @Override // db4.a
    public String c(String str) throws InterruptedException, ez0 {
        Core core = lx1.J().M().getCore();
        Core core2 = this.i;
        if (core2 != null && !core2.equals(core)) {
            e();
        }
        if (this.g == null) {
            this.i = core;
            h(core);
        }
        this.f = new CountDownLatch(1);
        this.g.start(str);
        this.f.await();
        return f();
    }

    public final void e() throws ez0 {
        q24.S(true);
        App.e(new Runnable() { // from class: tk4
            @Override // java.lang.Runnable
            public final void run() {
                System.exit(0);
            }
        }, 100L);
        throw new ez0(vr3.l(sm3.I));
    }

    public final String f() throws ez0 {
        String str = this.h;
        if (str == null) {
            return "";
        }
        boolean zStartsWith = str.startsWith("-");
        String str2 = this.h;
        if (zStartsWith) {
            throw new ez0(vr3.m(sm3.H, str2));
        }
        return str2;
    }

    public final String g(String str) {
        File file = new File(Path.so(), qx4.g(str));
        if (!Path.exists(file)) {
            fn0.a(str, file).d();
        }
        return file.getAbsolutePath();
    }

    public final void h(Core core) {
        try {
            App.b().h(core.getHook());
            this.g = new TVCore(g(core.getSo())).listener(this).auth(core.getAuth()).name(core.getName()).pass(core.getPass()).domain(core.getDomain()).broker(core.getBroker());
            for (Core.Option option : core.getOption()) {
                this.g.option(option.getKey(), option.getValues());
            }
            this.g.serv(0).play(8902).mode(1).init();
        } catch (Exception unused) {
        } catch (Throwable th) {
            App.b().h(null);
            throw th;
        }
        App.b().h(null);
    }

    @Override // com.tvbus.engine.Listener
    public void onInfo(String str) {
    }

    @Override // com.tvbus.engine.Listener
    public void onInited(String str) {
        g02.b(j).g(str);
    }

    @Override // com.tvbus.engine.Listener
    public void onPrepared(String str) {
        g02.b(j).g(str);
        JsonObject jsonObject = (JsonObject) App.c().fromJson(str, JsonObject.class);
        if (jsonObject.get("hls") == null) {
            return;
        }
        this.h = jsonObject.get("hls").getAsString();
        this.f.countDown();
    }

    @Override // com.tvbus.engine.Listener
    public void onQuit(String str) {
    }

    @Override // com.tvbus.engine.Listener
    public void onStart(String str) {
        g02.b(j).g(str);
    }

    @Override // com.tvbus.engine.Listener
    public void onStop(String str) {
        g02.b(j).g(str);
        String asString = ((JsonObject) App.c().fromJson(str, JsonObject.class)).get("errno").getAsString();
        this.h = asString;
        if (asString.startsWith("-")) {
            this.f.countDown();
        }
    }

    @Override // db4.a
    public void stop() {
        TVCore tVCore = this.g;
        if (tVCore != null) {
            tVCore.stop();
        }
        this.h = null;
    }
}
