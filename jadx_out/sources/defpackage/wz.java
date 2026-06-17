package defpackage;

import com.fongmi.android.tv.bean.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wz extends hz {
    public final bu3 a;
    public final ft0 b = new a();
    public final et0 c = new b();
    public final et0 d = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ft0 {
        public a() {
        }

        @Override // defpackage.ft0
        public String b() {
            return "INSERT OR IGNORE INTO `Config` (`id`,`type`,`time`,`url`,`json`,`name`,`logo`,`home`,`parse`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
        }

        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Config config) {
            ow3Var.d(1, config.getId());
            ow3Var.d(2, config.getType());
            ow3Var.d(3, config.getTime());
            if (config.getUrl() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, config.getUrl());
            }
            if (config.getJson() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, config.getJson());
            }
            if (config.getName() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.w(6, config.getName());
            }
            if (config.getLogo() == null) {
                ow3Var.e(7);
            } else {
                ow3Var.w(7, config.getLogo());
            }
            if (config.getHome() == null) {
                ow3Var.e(8);
            } else {
                ow3Var.w(8, config.getHome());
            }
            if (config.getParse() == null) {
                ow3Var.e(9);
            } else {
                ow3Var.w(9, config.getParse());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends et0 {
        public b() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `Config` SET `id` = ?,`type` = ?,`time` = ?,`url` = ?,`json` = ?,`name` = ?,`logo` = ?,`home` = ?,`parse` = ? WHERE `id` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Config config) {
            ow3Var.d(1, config.getId());
            ow3Var.d(2, config.getType());
            ow3Var.d(3, config.getTime());
            if (config.getUrl() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, config.getUrl());
            }
            if (config.getJson() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, config.getJson());
            }
            if (config.getName() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.w(6, config.getName());
            }
            if (config.getLogo() == null) {
                ow3Var.e(7);
            } else {
                ow3Var.w(7, config.getLogo());
            }
            if (config.getHome() == null) {
                ow3Var.e(8);
            } else {
                ow3Var.w(8, config.getHome());
            }
            if (config.getParse() == null) {
                ow3Var.e(9);
            } else {
                ow3Var.w(9, config.getParse());
            }
            ow3Var.d(10, config.getId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends et0 {
        public c() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR ABORT `Config` SET `id` = ?,`type` = ?,`time` = ?,`url` = ?,`json` = ?,`name` = ?,`logo` = ?,`home` = ?,`parse` = ? WHERE `id` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Config config) {
            ow3Var.d(1, config.getId());
            ow3Var.d(2, config.getType());
            ow3Var.d(3, config.getTime());
            if (config.getUrl() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, config.getUrl());
            }
            if (config.getJson() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, config.getJson());
            }
            if (config.getName() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.w(6, config.getName());
            }
            if (config.getLogo() == null) {
                ow3Var.e(7);
            } else {
                ow3Var.w(7, config.getLogo());
            }
            if (config.getHome() == null) {
                ow3Var.e(8);
            } else {
                ow3Var.w(8, config.getHome());
            }
            if (config.getParse() == null) {
                ow3Var.e(9);
            } else {
                ow3Var.w(9, config.getParse());
            }
            ow3Var.d(10, config.getId());
        }
    }

    public wz(bu3 bu3Var) {
        this.a = bu3Var;
    }

    public static /* synthetic */ List A(int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT id, name, url, type, time FROM Config WHERE type = ? ORDER BY time DESC");
        try {
            ow3VarA0.d(1, i);
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Config config = new Config();
                config.setId((int) ow3VarA0.getLong(0));
                String strI = null;
                config.setName(ow3VarA0.isNull(1) ? null : ow3VarA0.I(1));
                if (!ow3VarA0.isNull(2)) {
                    strI = ow3VarA0.I(2);
                }
                config.setUrl(strI);
                config.setType((int) ow3VarA0.getLong(3));
                config.setTime(ow3VarA0.getLong(4));
                arrayList.add(config);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static List E() {
        return Collections.EMPTY_LIST;
    }

    public static /* synthetic */ Config o(String str, int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Config WHERE url = ? AND type = ?");
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            ow3VarA0.d(2, i);
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "type");
            int iC3 = pw3.c(ow3VarA0, "time");
            int iC4 = pw3.c(ow3VarA0, "url");
            int iC5 = pw3.c(ow3VarA0, "json");
            int iC6 = pw3.c(ow3VarA0, "name");
            int iC7 = pw3.c(ow3VarA0, "logo");
            int iC8 = pw3.c(ow3VarA0, "home");
            int iC9 = pw3.c(ow3VarA0, "parse");
            Config config = null;
            String strI = null;
            if (ow3VarA0.Y()) {
                Config config2 = new Config();
                config2.setId((int) ow3VarA0.getLong(iC));
                config2.setType((int) ow3VarA0.getLong(iC2));
                config2.setTime(ow3VarA0.getLong(iC3));
                config2.setUrl(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                config2.setJson(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                config2.setName(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                config2.setLogo(ow3VarA0.isNull(iC7) ? null : ow3VarA0.I(iC7));
                config2.setHome(ow3VarA0.isNull(iC8) ? null : ow3VarA0.I(iC8));
                if (!ow3VarA0.isNull(iC9)) {
                    strI = ow3VarA0.I(iC9);
                }
                config2.setParse(strI);
                config = config2;
            }
            ow3VarA0.close();
            return config;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ Object p(String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Config WHERE url = ?");
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ List q(int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Config WHERE type = ? ORDER BY time DESC");
        try {
            ow3VarA0.d(1, i);
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "type");
            int iC3 = pw3.c(ow3VarA0, "time");
            int iC4 = pw3.c(ow3VarA0, "url");
            int iC5 = pw3.c(ow3VarA0, "json");
            int iC6 = pw3.c(ow3VarA0, "name");
            int iC7 = pw3.c(ow3VarA0, "logo");
            int iC8 = pw3.c(ow3VarA0, "home");
            int iC9 = pw3.c(ow3VarA0, "parse");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Config config = new Config();
                config.setId((int) ow3VarA0.getLong(iC));
                config.setType((int) ow3VarA0.getLong(iC2));
                config.setTime(ow3VarA0.getLong(iC3));
                String strI = null;
                config.setUrl(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                config.setJson(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                config.setName(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                config.setLogo(ow3VarA0.isNull(iC7) ? null : ow3VarA0.I(iC7));
                config.setHome(ow3VarA0.isNull(iC8) ? null : ow3VarA0.I(iC8));
                if (!ow3VarA0.isNull(iC9)) {
                    strI = ow3VarA0.I(iC9);
                }
                config.setParse(strI);
                arrayList.add(config);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static /* synthetic */ Object s(String str, int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Config WHERE url = ? AND type = ?");
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            ow3VarA0.d(2, i);
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ List t(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Config");
        try {
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "type");
            int iC3 = pw3.c(ow3VarA0, "time");
            int iC4 = pw3.c(ow3VarA0, "url");
            int iC5 = pw3.c(ow3VarA0, "json");
            int iC6 = pw3.c(ow3VarA0, "name");
            int iC7 = pw3.c(ow3VarA0, "logo");
            int iC8 = pw3.c(ow3VarA0, "home");
            int iC9 = pw3.c(ow3VarA0, "parse");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Config config = new Config();
                config.setId((int) ow3VarA0.getLong(iC));
                config.setType((int) ow3VarA0.getLong(iC2));
                config.setTime(ow3VarA0.getLong(iC3));
                String strI = null;
                config.setUrl(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                config.setJson(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                config.setName(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                config.setLogo(ow3VarA0.isNull(iC7) ? null : ow3VarA0.I(iC7));
                config.setHome(ow3VarA0.isNull(iC8) ? null : ow3VarA0.I(iC8));
                if (!ow3VarA0.isNull(iC9)) {
                    strI = ow3VarA0.I(iC9);
                }
                config.setParse(strI);
                arrayList.add(config);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static /* synthetic */ Config u(int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Config WHERE type = ? ORDER BY time DESC LIMIT 1");
        try {
            ow3VarA0.d(1, i);
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "type");
            int iC3 = pw3.c(ow3VarA0, "time");
            int iC4 = pw3.c(ow3VarA0, "url");
            int iC5 = pw3.c(ow3VarA0, "json");
            int iC6 = pw3.c(ow3VarA0, "name");
            int iC7 = pw3.c(ow3VarA0, "logo");
            int iC8 = pw3.c(ow3VarA0, "home");
            int iC9 = pw3.c(ow3VarA0, "parse");
            Config config = null;
            String strI = null;
            if (ow3VarA0.Y()) {
                Config config2 = new Config();
                config2.setId((int) ow3VarA0.getLong(iC));
                config2.setType((int) ow3VarA0.getLong(iC2));
                config2.setTime(ow3VarA0.getLong(iC3));
                config2.setUrl(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                config2.setJson(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                config2.setName(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                config2.setLogo(ow3VarA0.isNull(iC7) ? null : ow3VarA0.I(iC7));
                config2.setHome(ow3VarA0.isNull(iC8) ? null : ow3VarA0.I(iC8));
                if (!ow3VarA0.isNull(iC9)) {
                    strI = ow3VarA0.I(iC9);
                }
                config2.setParse(strI);
                config = config2;
            }
            return config;
        } finally {
            ow3VarA0.close();
        }
    }

    public static /* synthetic */ Config y(int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Config WHERE id = ?");
        try {
            ow3VarA0.d(1, i);
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "type");
            int iC3 = pw3.c(ow3VarA0, "time");
            int iC4 = pw3.c(ow3VarA0, "url");
            int iC5 = pw3.c(ow3VarA0, "json");
            int iC6 = pw3.c(ow3VarA0, "name");
            int iC7 = pw3.c(ow3VarA0, "logo");
            int iC8 = pw3.c(ow3VarA0, "home");
            int iC9 = pw3.c(ow3VarA0, "parse");
            Config config = null;
            String strI = null;
            if (ow3VarA0.Y()) {
                Config config2 = new Config();
                config2.setId((int) ow3VarA0.getLong(iC));
                config2.setType((int) ow3VarA0.getLong(iC2));
                config2.setTime(ow3VarA0.getLong(iC3));
                config2.setUrl(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                config2.setJson(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                config2.setName(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                config2.setLogo(ow3VarA0.isNull(iC7) ? null : ow3VarA0.I(iC7));
                config2.setHome(ow3VarA0.isNull(iC8) ? null : ow3VarA0.I(iC8));
                if (!ow3VarA0.isNull(iC9)) {
                    strI = ow3VarA0.I(iC9);
                }
                config2.setParse(strI);
                config = config2;
            }
            return config;
        } finally {
            ow3VarA0.close();
        }
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public Long a(final Config config) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: oz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.H(config, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void c(final Config config) {
        j70.b(this.a, false, true, new Function1() { // from class: rz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.J(config, (lw3) obj);
            }
        });
    }

    public final /* synthetic */ Long H(Config config, lw3 lw3Var) {
        return Long.valueOf(this.b.c(lw3Var, config));
    }

    public final /* synthetic */ List I(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    public final /* synthetic */ fw4 J(Config config, lw3 lw3Var) {
        super.c(config);
        return fw4.a;
    }

    public final /* synthetic */ fw4 K(List list, lw3 lw3Var) {
        super.d(list);
        return fw4.a;
    }

    public final /* synthetic */ Object L(Config config, lw3 lw3Var) throws Exception {
        this.c.c(lw3Var, config);
        return null;
    }

    public final /* synthetic */ Object M(List list, lw3 lw3Var) throws Exception {
        this.d.d(lw3Var, list);
        return null;
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void e(final Config config) {
        j70.b(this.a, false, true, new Function1() { // from class: lz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.L(config, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: mz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.I(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void d(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: iz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.K(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: kz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.M(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public void g(final String str) {
        j70.b(this.a, false, true, new Function1() { // from class: nz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.p(str, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public void h(final String str, final int i) {
        j70.b(this.a, false, true, new Function1() { // from class: vz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.s(str, i, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public Config i(final String str, final int i) {
        return (Config) j70.b(this.a, true, false, new Function1() { // from class: qz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.o(str, i, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public List j() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: pz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.t((lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public Config k(final int i) {
        return (Config) j70.b(this.a, true, false, new Function1() { // from class: sz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.y(i, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public List l(final int i) {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: uz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.q(i, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public Config m(final int i) {
        return (Config) j70.b(this.a, true, false, new Function1() { // from class: jz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.u(i, (lw3) obj);
            }
        });
    }

    @Override // defpackage.hz
    public List n(final int i) {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: tz
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return wz.A(i, (lw3) obj);
            }
        });
    }
}
