package defpackage;

import com.fongmi.android.tv.bean.Site;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n84 extends f84 {
    public final bu3 a;
    public final ft0 b = new a();
    public final et0 c = new b();
    public final et0 d = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ft0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ft0
        public String b() {
            return "INSERT OR IGNORE INTO `Site` (`key`,`searchable`,`changeable`) VALUES (?,?,?)";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Site site) {
            if (site.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, site.getKey());
            }
            if (site.getSearchable() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.d(2, site.getSearchable().intValue());
            }
            if (site.getChangeable() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.d(3, site.getChangeable().intValue());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends et0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `Site` SET `key` = ?,`searchable` = ?,`changeable` = ? WHERE `key` = ?";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Site site) {
            if (site.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, site.getKey());
            }
            if (site.getSearchable() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.d(2, site.getSearchable().intValue());
            }
            if (site.getChangeable() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.d(3, site.getChangeable().intValue());
            }
            if (site.getKey() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, site.getKey());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends et0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR ABORT `Site` SET `key` = ?,`searchable` = ?,`changeable` = ? WHERE `key` = ?";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Site site) {
            if (site.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, site.getKey());
            }
            if (site.getSearchable() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.d(2, site.getSearchable().intValue());
            }
            if (site.getChangeable() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.d(3, site.getChangeable().intValue());
            }
            if (site.getKey() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, site.getKey());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public n84(bu3 bu3Var) {
        this.a = bu3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List n(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Site");
        try {
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "searchable");
            int iC3 = pw3.c(ow3VarA0, "changeable");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Site site = new Site();
                Integer numValueOf = null;
                site.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                site.setSearchable(ow3VarA0.isNull(iC2) ? null : Integer.valueOf((int) ow3VarA0.getLong(iC2)));
                if (!ow3VarA0.isNull(iC3)) {
                    numValueOf = Integer.valueOf((int) ow3VarA0.getLong(iC3));
                }
                site.setChangeable(numValueOf);
                arrayList.add(site);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List q() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List u(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ fw4 w(List list, lw3 lw3Var) {
        super.d(list);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object y(List list, lw3 lw3Var) throws Exception {
        this.d.d(lw3Var, list);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: l84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.u(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public void d(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: h84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.w(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: k84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.y(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f84
    public List g() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: i84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return n84.n((lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Ljava/lang/Long; */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Long a(final Site site) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: m84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.t(site, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(Ljava/lang/Object;)V */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(final Site site) {
        j70.b(this.a, false, true, new Function1() { // from class: g84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.v(site, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Long t(Site site, lw3 lw3Var) {
        return Long.valueOf(this.b.c(lw3Var, site));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ fw4 v(Site site, lw3 lw3Var) {
        super.c(site);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Object x(Site site, lw3 lw3Var) throws Exception {
        this.c.c(lw3Var, site);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void e(final Site site) {
        j70.b(this.a, false, true, new Function1() { // from class: j84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.x(site, (lw3) obj);
            }
        });
    }
}
