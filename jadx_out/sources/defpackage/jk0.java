package defpackage;

import com.fongmi.android.tv.bean.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jk0 extends bk0 {
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
            return "INSERT OR IGNORE INTO `Device` (`id`,`uuid`,`name`,`ip`,`type`) VALUES (?,?,?,?,?)";
        }

        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Device device) {
            if (device.getId() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.d(1, device.getId().intValue());
            }
            if (device.getUuid() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, device.getUuid());
            }
            if (device.getName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, device.getName());
            }
            if (device.getIp() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, device.getIp());
            }
            ow3Var.d(5, device.getType());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends et0 {
        public b() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `Device` SET `id` = ?,`uuid` = ?,`name` = ?,`ip` = ?,`type` = ? WHERE `id` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Device device) {
            if (device.getId() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.d(1, device.getId().intValue());
            }
            if (device.getUuid() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, device.getUuid());
            }
            if (device.getName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, device.getName());
            }
            if (device.getIp() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, device.getIp());
            }
            ow3Var.d(5, device.getType());
            if (device.getId() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.d(6, device.getId().intValue());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends et0 {
        public c() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR ABORT `Device` SET `id` = ?,`uuid` = ?,`name` = ?,`ip` = ?,`type` = ? WHERE `id` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Device device) {
            if (device.getId() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.d(1, device.getId().intValue());
            }
            if (device.getUuid() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, device.getUuid());
            }
            if (device.getName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, device.getName());
            }
            if (device.getIp() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, device.getIp());
            }
            ow3Var.d(5, device.getType());
            if (device.getId() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.d(6, device.getId().intValue());
            }
        }
    }

    public jk0(bu3 bu3Var) {
        this.a = bu3Var;
    }

    public static /* synthetic */ Object i(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Device");
        try {
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ List k(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Device");
        try {
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "uuid");
            int iC3 = pw3.c(ow3VarA0, "name");
            int iC4 = pw3.c(ow3VarA0, "ip");
            int iC5 = pw3.c(ow3VarA0, "type");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Device device = new Device();
                String strI = null;
                device.setId(ow3VarA0.isNull(iC) ? null : Integer.valueOf((int) ow3VarA0.getLong(iC)));
                device.setUuid(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                device.setName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                if (!ow3VarA0.isNull(iC4)) {
                    strI = ow3VarA0.I(iC4);
                }
                device.setIp(strI);
                device.setType((int) ow3VarA0.getLong(iC5));
                arrayList.add(device);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static List q() {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List u(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object x(List list, lw3 lw3Var) throws Exception {
        this.d.d(lw3Var, list);
        return null;
    }

    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: hk0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.u(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: gk0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.x(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.bk0
    public void g() {
        j70.b(this.a, false, true, new Function1() { // from class: ek0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return jk0.i((lw3) obj);
            }
        });
    }

    @Override // defpackage.bk0
    public List h() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: ck0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return jk0.k((lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Long a(final Device device) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: ik0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.t(device, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(final Device device) {
        j70.b(this.a, false, true, new Function1() { // from class: dk0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.v(device, (lw3) obj);
            }
        });
    }

    public final /* synthetic */ Long t(Device device, lw3 lw3Var) {
        return Long.valueOf(this.b.c(lw3Var, device));
    }

    public final /* synthetic */ fw4 v(Device device, lw3 lw3Var) {
        super.c(device);
        return fw4.a;
    }

    public final /* synthetic */ Object w(Device device, lw3 lw3Var) throws Exception {
        this.c.c(lw3Var, device);
        return null;
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(final Device device) {
        j70.b(this.a, false, true, new Function1() { // from class: fk0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.w(device, (lw3) obj);
            }
        });
    }
}
