package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Depot;
import com.fongmi.android.tv.bean.Group;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Rule;
import com.github.catvod.utils.Json;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lx1 extends gh {
    public static final String i = "lx1";
    public Live e;
    public List f;
    public List g;
    public List h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile lx1 a = new lx1();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0000: INVOKE (r0v0 com.fongmi.android.tv.bean.Group) VIRTUAL call: com.fongmi.android.tv.bean.Group.isKeep():boolean A[DONT_GENERATE, MD:():boolean (m), REMOVE, WRAPPED] (LINE:1))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean D(Group group) {
        return !group.isKeep();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lx1 J() {
        return a.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String L() {
        return J().i().getDesc();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int N() {
        return J().P().indexOf(J().M());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String Q() {
        return J().M().getCore().getResp();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String S() {
        return J().i().getUrl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean T() {
        return !TextUtils.isEmpty(S());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean X() {
        return J().M().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean Y() {
        return J().P().size() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b0(Config config, to toVar) {
        J().G().H(config).n(toVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(final List list) {
        final Set set = (Set) Keep.getLive().stream().map(new Function() { // from class: ix1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Keep) obj).getKey();
            }
        }).collect(Collectors.toSet());
        list.stream().filter(new Predicate() { // from class: jx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return lx1.D((Group) obj);
            }
        }).flatMap(new Function() { // from class: kx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Group) obj).getChannel().stream();
            }
        }).filter(new Predicate() { // from class: ax1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return set.contains(((Channel) obj).getName());
            }
        }).forEach(new Consumer() { // from class: bx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Group) list.get(0)).add((Channel) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(Config config, JsonObject jsonObject) throws Exception {
        if (jsonObject.has("msg")) {
            throw new Exception(jsonObject.get("msg").getAsString());
        }
        if (jsonObject.has("urls")) {
            e0(config, jsonObject);
        } else {
            d0(config, jsonObject);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lx1 G() {
        this.h = null;
        this.e = null;
        this.f = null;
        this.g = null;
        bw3.a().d();
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lx1 H(Config config) {
        this.c = config;
        if (config.isEmpty()) {
            return this;
        }
        this.b = config.getUrl().equals(b75.Z());
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] I(List list) {
        int iFind;
        String[] strArrSplit = M().getKeep().split("@@@");
        if (strArrSplit.length < 3) {
            return new int[]{1, 0};
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Group group = (Group) list.get(i2);
            if (group.getName().equals(strArrSplit[0]) && (iFind = group.find(strArrSplit[1])) != -1) {
                group.getChannel().get(iFind).setIndex(strArrSplit[2]);
                return new int[]{i2, iFind};
            }
        }
        return new int[]{1, 0};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List K() {
        List list = this.h;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Live M() {
        Live live = this.e;
        return live == null ? new Live() : live;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Live O(final String str) {
        return (Live) P().stream().filter(new Predicate() { // from class: hx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Live) obj).getName().equals(str);
            }
        }).findFirst().orElse(new Live());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List P() {
        List list = this.f;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List R() {
        List list = this.g;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lx1 U() {
        return H(Config.live());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V(JsonObject jsonObject) {
        s(xc1.a(h(jsonObject, "headers")));
        u(qi3.e(h(jsonObject, "proxy")));
        l0(Rule.arrayFrom(h(jsonObject, "rules")));
        t(Json.safeListString(jsonObject, "hosts"));
        g0(Json.safeListString(jsonObject, "ads"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W(final Config config, JsonObject jsonObject) {
        final String strSafeString = Json.safeString(jsonObject, "spider");
        di.d().m(strSafeString, false);
        k0((List) Json.safeListElement(jsonObject, "lives").stream().map(new Function() { // from class: cx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Live.objectFrom((JsonElement) obj, strSafeString);
            }
        }).distinct().collect(Collectors.toCollection(new dx1())));
        final Map map = (Map) Live.findAll().stream().collect(Collectors.toMap(new Function() { // from class: ex1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Live) obj).getName();
            }
        }, Function.identity()));
        P().forEach(new Consumer() { // from class: fx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Live live = (Live) obj;
                live.sync((Live) map.get(live.getName()));
            }
        });
        h0(config, P().isEmpty() ? new Live() : (Live) P().stream().filter(new Predicate() { // from class: gx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Live) obj).getName().equals(config.getHome());
            }
        }).findFirst().orElse((Live) P().get(0)), false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void Z(Live live) {
        live.setActivated(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a0() {
        if (this.b) {
            return;
        }
        n(new to());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c0(JsonObject jsonObject) {
        d0(i(), jsonObject);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d0(Config config, JsonObject jsonObject) {
        V(jsonObject);
        W(config, jsonObject);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public Config e() {
        return Config.live();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e0(Config config, JsonObject jsonObject) throws Exception {
        List<Depot> listArrayFrom = Depot.arrayFrom(jsonObject.getAsJsonArray("urls").toString());
        ArrayList arrayList = new ArrayList();
        Iterator<Depot> it = listArrayFrom.iterator();
        while (it.hasNext()) {
            arrayList.add(Config.find(it.next(), 1));
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Depot urls is empty");
        }
        Config config2 = (Config) arrayList.get(0);
        this.c = config2;
        o(config2);
        Config.delete(config.getUrl());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public synchronized void f() {
        try {
            if (l()) {
                return;
            }
            super.f();
            nw1.h(M());
            nw1.i(M());
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0(Config config, String str) {
        Live liveSync = new Live(qx4.c(config.getUrl()), config.getUrl()).sync();
        this.f = new ArrayList(av4.a(new Object[]{liveSync}));
        zx1.h(liveSync, str);
        h0(config, liveSync, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g0(List list) {
        this.h = list;
        bw3.a().d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h0(Config config, Live live, boolean z) {
        this.e = live;
        live.setActivated(true);
        config.setHome(this.e.getName());
        if (z) {
            config.save();
        }
        P().forEach(new Consumer() { // from class: zw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.Z((Live) obj);
            }
        });
        if (z) {
            return;
        }
        if (this.e.isBoot() || q24.B()) {
            c00.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ Config i() {
        return super.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i0(Live live) {
        h0(i(), live, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public String j() {
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j0(Channel channel) {
        if (this.e == null || channel.getGroup().isHidden()) {
            return;
        }
        this.e.keep(channel).save();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k0(List list) {
        this.f = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public boolean l() {
        return (P().isEmpty() || M().getGroups().isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l0(List list) {
        this.g = list;
        bw3.a().d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ void n(to toVar) {
        super.n(toVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public void o(Config config) {
        String strE = db0.e(qx4.a(config.getUrl()), i);
        if (Json.isObj(strE)) {
            F(config, Json.parse(strE).getAsJsonObject());
        } else {
            f0(config, strE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ boolean q(String str) {
        return super.q(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public void r() {
        super.r();
        c00.g();
    }
}
