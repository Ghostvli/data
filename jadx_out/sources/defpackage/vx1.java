package defpackage;

import com.fongmi.android.tv.bean.Live;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vx1 extends mx1 {
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
            return "INSERT OR IGNORE INTO `Live` (`name`,`keep`,`boot`,`pass`) VALUES (?,?,?,?)";
        }

        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Live live) {
            if (live.getName() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, live.getName());
            }
            if (live.getKeep() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, live.getKeep());
            }
            ow3Var.d(3, live.isBoot() ? 1L : 0L);
            ow3Var.d(4, live.isPass() ? 1L : 0L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends et0 {
        public b() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `Live` SET `name` = ?,`keep` = ?,`boot` = ?,`pass` = ? WHERE `name` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Live live) {
            if (live.getName() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, live.getName());
            }
            if (live.getKeep() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, live.getKeep());
            }
            ow3Var.d(3, live.isBoot() ? 1L : 0L);
            ow3Var.d(4, live.isPass() ? 1L : 0L);
            if (live.getName() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, live.getName());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends et0 {
        public c() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR ABORT `Live` SET `name` = ?,`keep` = ?,`boot` = ?,`pass` = ? WHERE `name` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Live live) {
            if (live.getName() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, live.getName());
            }
            if (live.getKeep() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, live.getKeep());
            }
            ow3Var.d(3, live.isBoot() ? 1L : 0L);
            ow3Var.d(4, live.isPass() ? 1L : 0L);
            if (live.getName() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, live.getName());
            }
        }
    }

    public vx1(bu3 bu3Var) {
        this.a = bu3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object A(List list, lw3 lw3Var) throws Exception {
        this.d.d(lw3Var, list);
        return null;
    }

    public static /* synthetic */ Live i(String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Live WHERE name = ?");
        boolean z = true;
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            int iC = pw3.c(ow3VarA0, "name");
            int iC2 = pw3.c(ow3VarA0, "keep");
            int iC3 = pw3.c(ow3VarA0, "boot");
            int iC4 = pw3.c(ow3VarA0, "pass");
            Live live = null;
            String strI = null;
            if (ow3VarA0.Y()) {
                Live live2 = new Live();
                live2.setName(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                if (!ow3VarA0.isNull(iC2)) {
                    strI = ow3VarA0.I(iC2);
                }
                live2.setKeep(strI);
                live2.setBoot(((int) ow3VarA0.getLong(iC3)) != 0);
                if (((int) ow3VarA0.getLong(iC4)) == 0) {
                    z = false;
                }
                live2.setPass(z);
                live = live2;
            }
            ow3VarA0.close();
            return live;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ List n(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Live");
        try {
            int iC = pw3.c(ow3VarA0, "name");
            int iC2 = pw3.c(ow3VarA0, "keep");
            int iC3 = pw3.c(ow3VarA0, "boot");
            int iC4 = pw3.c(ow3VarA0, "pass");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Live live = new Live();
                String strI = null;
                live.setName(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                if (!ow3VarA0.isNull(iC2)) {
                    strI = ow3VarA0.I(iC2);
                }
                live.setKeep(strI);
                boolean z = false;
                live.setBoot(((int) ow3VarA0.getLong(iC3)) != 0);
                if (((int) ow3VarA0.getLong(iC4)) != 0) {
                    z = true;
                }
                live.setPass(z);
                arrayList.add(live);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static List s() {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List w(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ fw4 y(List list, lw3 lw3Var) {
        super.d(list);
        return fw4.a;
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void e(final Live live) {
        j70.b(this.a, false, true, new Function1() { // from class: tx1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.z(live, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: sx1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.w(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void d(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: nx1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.y(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: rx1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.A(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.mx1
    public Live g(final String str) {
        return (Live) j70.b(this.a, true, false, new Function1() { // from class: qx1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vx1.i(str, (lw3) obj);
            }
        });
    }

    @Override // defpackage.mx1
    public List h() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: ox1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vx1.n((lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Long a(final Live live) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: ux1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.v(live, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void c(final Live live) {
        j70.b(this.a, false, true, new Function1() { // from class: px1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.x(live, (lw3) obj);
            }
        });
    }

    public final /* synthetic */ Long v(Live live, lw3 lw3Var) {
        return Long.valueOf(this.b.c(lw3Var, live));
    }

    public final /* synthetic */ fw4 x(Live live, lw3 lw3Var) {
        super.c(live);
        return fw4.a;
    }

    public final /* synthetic */ Object z(Live live, lw3 lw3Var) throws Exception {
        this.c.c(lw3Var, live);
        return null;
    }
}
