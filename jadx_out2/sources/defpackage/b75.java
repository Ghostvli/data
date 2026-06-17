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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:int:0x0004: INVOKE 
      (wrap:java.lang.Integer:0x0000: INVOKE (r1v0 com.fongmi.android.tv.bean.Parse) VIRTUAL call: com.fongmi.android.tv.bean.Parse.getType():java.lang.Integer A[MD:():java.lang.Integer (m), WRAPPED] (LINE:1))
     VIRTUAL call: java.lang.Integer.intValue():int A[MD:():int (c), WRAPPED] (LINE:5)) == (r0v0 int)) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean E(int i, Parse parse) {
        return parse.getType().intValue() == i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b75 I() {
        return a.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int K() {
        return I().i().getId();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String L() {
        return I().i().getDesc();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int P() {
        return I().Y().indexOf(I().O());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String Z() {
        return I().i().getUrl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b0() {
        return !I().S().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void d0(JsonObject jsonObject) {
        s(xc1.a(h(jsonObject, "headers")));
        u(qi3.e(h(jsonObject, "proxy")));
        u0(Rule.arrayFrom(h(jsonObject, "rules")));
        n0(an0.a(h(jsonObject, "doh")));
        o0(Json.safeListString(jsonObject, "flags"));
        t(Json.safeListString(jsonObject, "hosts"));
        m0(Json.safeListString(jsonObject, "ads"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void e0(Config config, JsonObject jsonObject) {
        if (Json.isEmpty(jsonObject, "lives")) {
            return;
        }
        Config configSave = Config.find(config, 1).save();
        if (lx1.J().q(config.getUrl())) {
            lx1.J().H(configSave.update()).c0(jsonObject);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j0(Config config, to toVar) {
        I().G().H(config).n(toVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void k0(Config config, JsonObject jsonObject) {
        d0(jsonObject);
        e0(config, jsonObject);
        h0(config, jsonObject);
        g0(config, jsonObject);
        f0(config, jsonObject);
        config.setLogo(Json.safeString(jsonObject, "logo"));
        config.setNotice(Json.safeString(jsonObject, "notice"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void m0(List list) {
        this.k = list;
        bw3.a().d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void u0(List list) {
        this.i = list;
        bw3.a().d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b75 H(Config config) {
        this.c = config;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List J() {
        List list = this.k;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List N() {
        List list = this.l;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site O() {
        Site site = this.e;
        return site == null ? new Site() : site;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Parse Q() {
        Parse parse = this.g;
        return parse == null ? new Parse() : parse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Parse R(final String str) {
        return (Parse) S().stream().filter(new Predicate() { // from class: s65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Parse) obj).getName().equals(str);
            }
        }).findFirst().orElse(new Parse());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List S() {
        List list = this.m;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List T(final int i) {
        return Stream$EL.toList(S().stream().filter(new Predicate() { // from class: r65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b75.E(i, (Parse) obj);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List U(int i, final String str) {
        List listT = T(i);
        List list = Stream$EL.toList(listT.stream().filter(new Predicate() { // from class: q65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Parse) obj).getExt().getFlag().contains(str);
            }
        }));
        return list.isEmpty() ? listT : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List V() {
        List list = this.i;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site W(final String str) {
        return (Site) Y().stream().filter(new Predicate() { // from class: p65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Site) obj).getKey().equals(str);
            }
        }).findFirst().orElse(new Site());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List X() {
        return (List) Y().stream().map(new v65()).collect(Collectors.toList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List Y() {
        List list = this.j;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String a0() {
        return TextUtils.isEmpty(this.f) ? "" : this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b75 c0() {
        return H(Config.vod());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public Config e() {
        return Config.vod();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0(final Config config, JsonObject jsonObject) {
        t0((List) Json.safeListElement(jsonObject, "parses").stream().map(new Function() { // from class: y65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Parse.objectFrom((JsonElement) obj);
            }
        }).distinct().collect(Collectors.toCollection(new dx1())));
        r0(config, S().isEmpty() ? new Parse() : (Parse) S().stream().filter(new Predicate() { // from class: z65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Parse) obj).getName().equals(config.getParse());
            }
        }).findFirst().orElse((Parse) S().get(0)), false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g0(final Config config, JsonObject jsonObject) {
        final String strSafeString = Json.safeString(jsonObject, "spider");
        di.d().m(strSafeString, true);
        v0((List) Json.safeListElement(jsonObject, "sites").stream().map(new Function() { // from class: u65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Site.objectFrom((JsonElement) obj, strSafeString);
            }
        }).distinct().collect(Collectors.toCollection(new dx1())));
        final Map map = (Map) Site.findAll().stream().collect(Collectors.toMap(new v65(), Function.identity()));
        Y().forEach(new Consumer() { // from class: w65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Site site = (Site) obj;
                site.sync((Site) map.get(site.getKey()));
            }
        });
        p0(config, Y().isEmpty() ? new Site() : (Site) Y().stream().filter(new Predicate() { // from class: x65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Site) obj).getKey().equals(config.getHome());
            }
        }).findFirst().orElse((Site) Y().get(0)), false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ Config i() {
        return super.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void i0(Site site) {
        site.setActivated(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public String j() {
        return n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public boolean l() {
        return !Y().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ void n(to toVar) {
        super.n(toVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n0(List list) {
        this.h = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public void o(Config config) {
        F(config, Json.parse(db0.e(qx4.a(config.getUrl()), n)).getAsJsonObject());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o0(List list) {
        this.l = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p0(Config config, Site site, boolean z) {
        this.e = site;
        site.setActivated(true);
        config.setHome(this.e.getKey());
        if (z) {
            config.save();
        }
        Y().forEach(new Consumer() { // from class: a75
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.i0((Site) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q0(Site site) {
        p0(i(), site, true);
        qp3.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh
    public void r() {
        super.r();
        c00.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0(Config config, final Parse parse, boolean z) {
        this.g = parse;
        parse.setActivated(true);
        config.setParse(parse.getName());
        S().forEach(new Consumer() { // from class: t65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Parse) obj).setActivated(parse);
            }
        });
        if (z) {
            config.save();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s0(Parse parse) {
        r0(i(), parse, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0(List list) {
        if (!list.isEmpty()) {
            list.add(0, Parse.god());
        }
        this.m = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0(List list) {
        this.j = list;
    }
}
