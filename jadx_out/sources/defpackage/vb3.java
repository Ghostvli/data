package defpackage;

import android.net.Uri;
import com.fongmi.android.tv.bean.Danmaku;
import com.fongmi.android.tv.bean.Drm;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Sub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vb3 {
    public Map a;
    public boolean b;
    public List c;
    public ph2 d;
    public List e;
    public String f;
    public String g;
    public String h;
    public Drm i;

    public vb3(String str, String str2, Map map, String str3, Drm drm, List list, List list2, ph2 ph2Var) {
        this.g = str;
        this.h = str2;
        this.i = drm;
        this.e = list;
        this.f = str3;
        this.a = map;
        this.b = (map == null || map.isEmpty()) ? false : true;
        this.c = list2;
        this.d = ph2Var;
    }

    public static vb3 c(Result result, String str, ph2 ph2Var) {
        return new vb3(str, result.getRealUrl(), result.getHeader(), result.getFormat(), result.getDrm(), result.getSubs(), result.getDanmaku(), ph2Var);
    }

    public static vb3 d(Result result, String str, ph2 ph2Var) {
        return new vb3(str, null, null, result.getFormat(), result.getDrm(), result.getSubs(), result.getDanmaku(), ph2Var);
    }

    public vb3 b() {
        if (this.a == null) {
            this.a = new HashMap();
        }
        final String str = "User-Agent";
        if (this.a.keySet().stream().noneMatch(new Predicate() { // from class: ub3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equalsIgnoreCase((String) obj);
            }
        })) {
            this.a.put("User-Agent", q24.s().isEmpty() ? ge3.c() : q24.s());
        }
        return this;
    }

    public List e() {
        return this.c;
    }

    public Drm f() {
        return this.i;
    }

    public String g() {
        return this.f;
    }

    public Map h() {
        return this.a;
    }

    public String i() {
        return this.g;
    }

    public ph2 j() {
        return this.d;
    }

    public List k() {
        return this.e;
    }

    public Uri l() {
        return qx4.k(this.h);
    }

    public String m() {
        return this.h;
    }

    public boolean n() {
        return this.b;
    }

    public void o(final Danmaku danmaku) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (!danmaku.isEmpty() && !this.c.contains(danmaku)) {
            this.c.add(0, danmaku);
        }
        this.c.forEach(new Consumer() { // from class: tb3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Danmaku danmaku2 = (Danmaku) obj;
                danmaku2.setSelected(danmaku2.getUrl().equals(danmaku.getUrl()));
            }
        });
    }

    public void p(String str) {
        this.f = str;
    }

    public void q(Map map) {
        this.a = map;
        if (map == null || map.isEmpty()) {
            return;
        }
        this.b = true;
    }

    public void r(ph2 ph2Var) {
        this.d = ph2Var;
    }

    public void s(Sub sub) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        if (sub == null || this.e.contains(sub)) {
            return;
        }
        this.e.add(0, sub);
    }

    public void t(String str) {
        this.h = str;
    }
}
