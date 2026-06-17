package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Depot;
import com.fongmi.android.tv.bean.Parse;
import com.fongmi.android.tv.bean.Rule;
import com.fongmi.android.tv.bean.Site;
import com.github.catvod.utils.Json;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import j$.util.stream.Stream$EL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b75 extends gh {
    public static final String n = "b75";
    public Site e;
    public String f;
    public Parse g;
    public List h;
    public List i;
    public List j;
    public List k;
    public List l;
    public List m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile b75 a = new b75();
    }

    public static /* synthetic */ boolean E(int i, Parse parse) {
        return parse.getType().intValue() == i;
    }

    private void F(Config config, JsonObject jsonObject) throws Exception {
        if (jsonObject.has("msg")) {
            throw new Exception(jsonObject.get("msg").getAsString());
        }
        if (jsonObject.has("urls")) {
            l0(config, jsonObject);
        } else {
            k0(config, jsonObject);
        }
    }

    public static b75 I() {
        return a.a;
    }

    public static int K() {
        return I().i().getId();
    }

    public static String L() {
        return I().i().getDesc();
    }

    public static int P() {
        return I().Y().indexOf(I().O());
    }

    public static String Z() {
        return I().i().getUrl();
    }

    public static boolean b0() {
        return !I().S().isEmpty();
    }

    private void d0(JsonObject jsonObject) {
        s(xc1.a(h(jsonObject, "headers")));
        u(qi3.e(h(jsonObject, "proxy")));
        u0(Rule.arrayFrom(h(jsonObject, "rules")));
        n0(an0.a(h(jsonObject, "doh")));
        o0(Json.safeListString(jsonObject, "flags"));
        t(Json.safeListString(jsonObject, "hosts"));
        m0(Json.safeListString(jsonObject, "ads"));
    }

    private void e0(Config config, JsonObject jsonObject) {
        if (Json.isEmpty(jsonObject, "lives")) {
            return;
        }
        Config configSave = Config.find(config, 1).save();
        if (lx1.J().q(config.getUrl())) {
            lx1.J().H(configSave.update()).c0(jsonObject);
        }
    }

    public static void j0(Config config, to toVar) {
        I().G().H(config).n(toVar);
    }

    private void k0(Config config, JsonObject jsonObject) {
        d0(jsonObject);
        e0(config, jsonObject);
        h0(config, jsonObject);
        g0(config, jsonObject);
        f0(config, jsonObject);
        config.setLogo(Json.safeString(jsonObject, "logo"));
        config.setNotice(Json.safeString(jsonObject, "notice"));
    }

    private void l0(Config config, JsonObject jsonObject) throws Exception {
        List<Depot> listArrayFrom = Depot.arrayFrom(jsonObject.getAsJsonArray("urls").toString());
        ArrayList arrayList = new ArrayList();
        Iterator<Depot> it = listArrayFrom.iterator();
        while (it.hasNext()) {
            arrayList.add(Config.find(it.next(), 0));
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Depot urls is empty");
        }
        Config config2 = (Config) arrayList.get(0);
        this.c = config2;
        o(config2);
        Config.delete(config.getUrl());
    }

    private void m0(List list) {
        this.k = list;
        bw3.a().d();
    }

    private void u0(List list) {
        this.i = list;
        bw3.a().d();
    }

    public b75 G() {
        this.k = null;
        this.h = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = null;
        this.l = null;
        this.i = null;
        this.m = null;
        di.d().b();
        bw3.a().d();
        return this;
    }

    public b75 H(Config config) {
        this.c = config;
        return this;
    }

    public List J() {
        List list = this.k;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List M() {
        List listB = an0.b(App.b());
        List list = this.h;
        if (list == null) {
            return listB;
        }
        listB.removeAll(list);
        listB.addAll(this.h);
        return listB;
    }

    public List N() {
        List list = this.l;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public Site O() {
        Site site = this.e;
        return site == null ? new Site() : site;
    }

    public Parse Q() {
        Parse parse = this.g;
        return parse == null ? new Parse() : parse;
    }

    public Parse R(final String str) {
        return (Parse) S().stream().filter(new Predicate() { // from class: s65
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Parse) obj).getName().equals(str);
            }
        }).findFirst().orElse(new Parse());
    }

    public List S() {
        List list = this.m;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List T(final int i) {
        return Stream$EL.toList(S().stream().filter(new Predicate() { // from class: r65
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b75.E(i, (Parse) obj);
            }
        }));
    }

    public List U(int i, final String str) {
        List listT = T(i);
        List list = Stream$EL.toList(listT.stream().filter(new Predicate() { // from class: q65
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Parse) obj).getExt().getFlag().contains(str);
            }
        }));
        return list.isEmpty() ? listT : list;
    }

    public List V() {
        List list = this.i;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public Site W(final String str) {
        return (Site) Y().stream().filter(new Predicate() { // from class: p65
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Site) obj).getKey().equals(str);
            }
        }).findFirst().orElse(new Site());
    }

    public List X() {
        return (List) Y().stream().map(new v65()).collect(Collectors.toList());
    }

    public List Y() {
        List list = this.j;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public String a0() {
        return TextUtils.isEmpty(this.f) ? "" : this.f;
    }

    public b75 c0() {
        return H(Config.vod());
    }

    @Override // defpackage.gh
    public Config e() {
        return Config.vod();
    }

    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    public final void f0(final Config config, JsonObject jsonObject) {
        t0((List) Json.safeListElement(jsonObject, "parses").stream().map(new Function() { // from class: y65
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Parse.objectFrom((JsonElement) obj);
            }
        }).distinct().collect(Collectors.toCollection(new dx1())));
        r0(config, S().isEmpty() ? new Parse() : (Parse) S().stream().filter(new Predicate() { // from class: z65
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Parse) obj).getName().equals(config.getParse());
            }
        }).findFirst().orElse((Parse) S().get(0)), false);
    }

    public final void g0(final Config config, JsonObject jsonObject) {
        final String strSafeString = Json.safeString(jsonObject, "spider");
        di.d().m(strSafeString, true);
        v0((List) Json.safeListElement(jsonObject, "sites").stream().map(new Function() { // from class: u65
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Site.objectFrom((JsonElement) obj, strSafeString);
            }
        }).distinct().collect(Collectors.toCollection(new dx1())));
        final Map map = (Map) Site.findAll().stream().collect(Collectors.toMap(new v65(), Function.identity()));
        Y().forEach(new Consumer() { // from class: w65
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Site site = (Site) obj;
                site.sync((Site) map.get(site.getKey()));
            }
        });
        p0(config, Y().isEmpty() ? new Site() : (Site) Y().stream().filter(new Predicate() { // from class: x65
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Site) obj).getKey().equals(config.getHome());
            }
        }).findFirst().orElse((Site) Y().get(0)), false);
    }

    public final void h0(Config config, JsonObject jsonObject) {
        if (Json.isEmpty(jsonObject, "wallpaper")) {
            return;
        }
        String strSafeString = Json.safeString(jsonObject, "wallpaper");
        this.f = strSafeString;
        Config configSave = Config.find(strSafeString, config.getName(), 2).save();
        if (m85.x().q(this.f)) {
            m85.x().w(configSave.update());
        }
    }

    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ Config i() {
        return super.i();
    }

    public final /* synthetic */ void i0(Site site) {
        site.setActivated(this.e);
    }

    @Override // defpackage.gh
    public String j() {
        return n;
    }

    @Override // defpackage.gh
    public boolean l() {
        return !Y().isEmpty();
    }

    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ void n(to toVar) {
        super.n(toVar);
    }

    public final void n0(List list) {
        this.h = list;
    }

    @Override // defpackage.gh
    public void o(Config config) {
        F(config, Json.parse(db0.e(qx4.a(config.getUrl()), n)).getAsJsonObject());
    }

    public final void o0(List list) {
        this.l = list;
    }

    public final void p0(Config config, Site site, boolean z) {
        this.e = site;
        site.setActivated(true);
        config.setHome(this.e.getKey());
        if (z) {
            config.save();
        }
        Y().forEach(new Consumer() { // from class: a75
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.i0((Site) obj);
            }
        });
    }

    public void q0(Site site) {
        p0(i(), site, true);
        qp3.h();
    }

    @Override // defpackage.gh
    public void r() {
        super.r();
        c00.i();
    }

    public final void r0(Config config, final Parse parse, boolean z) {
        this.g = parse;
        parse.setActivated(true);
        config.setParse(parse.getName());
        S().forEach(new Consumer() { // from class: t65
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Parse) obj).setActivated(parse);
            }
        });
        if (z) {
            config.save();
        }
    }

    public void s0(Parse parse) {
        r0(i(), parse, true);
    }

    public final void t0(List list) {
        if (!list.isEmpty()) {
            list.add(0, Parse.god());
        }
        this.m = list;
    }

    public final void v0(List list) {
        this.j = list;
    }
}
