package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Device;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.bean.Vod;
import com.fongmi.android.tv.service.PlaybackService;
import com.github.catvod.utils.Path;
import fi.iki.elonen.NanoHTTPD;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.FormBody;
import org.jupnp.model.Namespace;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class p2 implements zg3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends to {
        public final /* synthetic */ boolean f;
        public final /* synthetic */ int g;
        public final /* synthetic */ List h;

        public a(boolean z, int i, List list) {
            this.f = z;
            this.g = i;
            this.h = list;
        }

        @Override // defpackage.to
        public void b(String str) {
            i43.i(str);
        }

        @Override // defpackage.to
        public void d() {
            if (this.f) {
                History.delete(this.g);
            }
            History.sync(this.h);
            qp3.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends to {
        public final /* synthetic */ boolean f;
        public final /* synthetic */ List g;
        public final /* synthetic */ List h;

        public b(boolean z, List list, List list2) {
            this.f = z;
            this.g = list;
            this.h = list2;
        }

        @Override // defpackage.to
        public void b(String str) {
            i43.i(str);
        }

        @Override // defpackage.to
        public void d() {
            if (this.f) {
                Keep.deleteAll();
            }
            Keep.sync(this.g, this.h);
            qp3.i();
        }
    }

    public static /* synthetic */ void f(String str, PlaybackService playbackService) {
        if ("play".equals(str)) {
            playbackService.player().Y();
            return;
        }
        if ("pause".equals(str)) {
            playbackService.player().X();
            return;
        }
        if ("stop".equals(str)) {
            playbackService.dispatchStop();
            return;
        }
        if ("prev".equals(str)) {
            playbackService.dispatchPrev();
            return;
        }
        if (ES6Iterator.NEXT_METHOD.equals(str)) {
            playbackService.dispatchNext();
        } else if ("loop".equals(str)) {
            playbackService.dispatchLoop();
        } else if ("replay".equals(str)) {
            playbackService.dispatchReplay();
        }
    }

    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith(Namespace.CONTROL);
    }

    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        Map<String, String> parms = iHTTPSession.getParms();
        String str2 = parms.get("do");
        if ("file".equals(str2)) {
            k(parms);
        } else if ("push".equals(str2)) {
            l(parms);
        } else if ("cast".equals(str2)) {
            i(parms);
        } else if ("sync".equals(str2)) {
            p(parms);
        } else if ("search".equals(str2)) {
            n(parms);
        } else if ("setting".equals(str2)) {
            o(parms);
        } else if ("refresh".equals(str2)) {
            m(parms);
        } else if ("control".equals(str2)) {
            j(parms);
        }
        return gx2.e();
    }

    public final to g(List list, List list2, boolean z) {
        return new b(z, list, list2);
    }

    public final to h(List list, boolean z, int i) {
        return new a(z, i, list);
    }

    public final void i(Map map) {
        Config configObjectFrom = Config.objectFrom((String) map.get("config"));
        wq.f(Config.find(configObjectFrom), Device.objectFrom((String) map.get("device")), History.objectFrom((String) map.get("history")));
    }

    public final void j(Map map) {
        final PlaybackService playbackServiceF = t14.b().f();
        final String str = (String) map.get("type");
        if (playbackServiceF == null) {
            return;
        }
        App.d(new Runnable() { // from class: l2
            @Override // java.lang.Runnable
            public final void run() {
                p2.f(str, playbackServiceF);
            }
        });
    }

    public final void k(Map map) {
        String str = (String) map.get("path");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith(".apk")) {
            w01.o(Path.local(str));
        } else if (str.endsWith(".srt") || str.endsWith(".ssa") || str.endsWith(".ass")) {
            qp3.m(str);
        } else {
            u14.e(str);
        }
    }

    public final void l(Map map) {
        String str = (String) map.get("url");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u14.c(str);
    }

    public final void m(Map map) {
        String str = (String) map.get("type");
        String str2 = (String) map.get("path");
        String str3 = (String) map.get("json");
        if ("live".equals(str)) {
            qp3.j();
            return;
        }
        if ("detail".equals(str)) {
            qp3.c();
            return;
        }
        if ("player".equals(str)) {
            qp3.k();
            return;
        }
        if ("category".equals(str)) {
            qp3.a();
            return;
        }
        if ("danmaku".equals(str)) {
            qp3.b(str2);
        } else if ("subtitle".equals(str)) {
            qp3.m(str2);
        } else if ("vod".equals(str)) {
            qp3.n(Vod.objectFrom(str3));
        }
    }

    public final void n(Map map) {
        String str = (String) map.get("word");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u14.d(str);
    }

    public final void o(Map map) {
        String str = (String) map.get("text");
        String str2 = (String) map.get("name");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u14.f(str, str2);
    }

    public final void p(Map map) {
        String str = (String) map.get("type");
        boolean zEquals = Objects.equals(map.get("force"), "true");
        String str2 = (String) aa4.a((String) map.get("mode"), "0");
        if (map.get("device") != null && (str2.equals("0") || str2.equals("2"))) {
            Device deviceObjectFrom = Device.objectFrom((String) map.get("device"));
            if ("history".equals(str)) {
                r(deviceObjectFrom, map);
            } else if ("keep".equals(str)) {
                s(deviceObjectFrom);
            }
        }
        if (str2.equals("0") || str2.equals("1")) {
            if ("history".equals(str)) {
                t(map, zEquals);
            } else if ("keep".equals(str)) {
                u(map, zEquals);
            }
        }
    }

    public final void q(Device device, String str, FormBody.Builder builder) {
        try {
            q53.x(q53.k(f10.h), device.getIp().concat("/action?do=sync&mode=0&type=" + str), builder.build()).execute();
        } catch (Exception e) {
            App.d(new Runnable() { // from class: o2
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(e.getMessage());
                }
            });
        }
    }

    public final void r(Device device, Map map) {
        try {
            Config configFind = Config.find(Config.objectFrom((String) map.get("config")));
            if (configFind.getUrl() == null) {
                configFind = Config.vod();
            }
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("config", configFind.toString());
            builder.add("targets", App.c().toJson(History.get(configFind.getId())));
            q(device, "history", builder);
        } catch (Exception e) {
            App.d(new Runnable() { // from class: n2
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(e.getMessage());
                }
            });
        }
    }

    public final void s(Device device) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("targets", App.c().toJson(Keep.getVod()));
            builder.add("configs", App.c().toJson(Config.findUrls()));
            q(device, "keep", builder);
        } catch (Exception e) {
            App.d(new Runnable() { // from class: m2
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(e.getMessage());
                }
            });
        }
    }

    public void t(Map map, boolean z) {
        Config configFind = Config.find(Config.objectFrom((String) map.get("config")));
        List<History> listArrayFrom = History.arrayFrom((String) map.get("targets"));
        if (configFind.getUrl() == null) {
            return;
        }
        if (!configFind.getUrl().equals(b75.Z())) {
            b75.j0(configFind, h(listArrayFrom, z, configFind.getId()));
            return;
        }
        if (z) {
            History.delete(configFind.getId());
        }
        History.sync(listArrayFrom);
        qp3.g();
    }

    public final void u(Map map, boolean z) {
        List<Keep> listArrayFrom = Keep.arrayFrom((String) map.get("targets"));
        List<Config> listArrayFrom2 = Config.arrayFrom((String) map.get("configs"));
        if (TextUtils.isEmpty(b75.Z()) && !listArrayFrom2.isEmpty()) {
            b75.j0(Config.find(listArrayFrom2.get(0)), g(listArrayFrom2, listArrayFrom, z));
            return;
        }
        if (z) {
            Keep.deleteAll();
        }
        Keep.sync(listArrayFrom2, listArrayFrom);
        qp3.i();
    }
}
