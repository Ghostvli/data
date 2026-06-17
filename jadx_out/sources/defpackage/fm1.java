package defpackage;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class fm1 extends p51 {
    public final Handler i0 = new Handler(Looper.getMainLooper());
    public oa3 j0;
    public kr k0;
    public final q3 l0;
    public final q3 m0;
    public final q3 n0;
    public final q3 o0;
    public final q3 p0;
    public final q3 q0;
    public final q3 r0;
    public final q3 s0;
    public final q3 t0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends tr1 implements Function0 {
        public final /* synthetic */ boolean g;
        public final /* synthetic */ fm1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, fm1 fm1Var) {
            super(0);
            this.g = z;
            this.h = fm1Var;
        }

        public final void a() {
            boolean z = this.g;
            fm1 fm1Var = this.h;
            kr krVar = null;
            if (z) {
                oa3 oa3Var = fm1Var.j0;
                if (oa3Var == null) {
                    il1.j("pb");
                    oa3Var = null;
                }
                oa3Var.l.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                oa3 oa3Var2 = this.h.j0;
                if (oa3Var2 == null) {
                    il1.j("pb");
                    oa3Var2 = null;
                }
                oa3Var2.m.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                oa3 oa3Var3 = this.h.j0;
                if (oa3Var3 == null) {
                    il1.j("pb");
                    oa3Var3 = null;
                }
                oa3Var3.n.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                kr krVar2 = this.h.k0;
                if (krVar2 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar2;
                }
                krVar.b();
                return;
            }
            fm1Var.n2("android.permission.ACCESS_BACKGROUND_LOCATION");
            oa3 oa3Var4 = this.h.j0;
            if (oa3Var4 == null) {
                il1.j("pb");
                oa3Var4 = null;
            }
            oa3Var4.getClass();
            oa3 oa3Var5 = this.h.j0;
            if (oa3Var5 == null) {
                il1.j("pb");
                oa3Var5 = null;
            }
            oa3Var5.getClass();
            oa3 oa3Var6 = this.h.j0;
            if (oa3Var6 == null) {
                il1.j("pb");
                oa3Var6 = null;
            }
            oa3Var6.getClass();
            kr krVar3 = this.h.k0;
            if (krVar3 == null) {
                il1.j("task");
            } else {
                krVar = krVar3;
            }
            krVar.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends tr1 implements Function0 {
        public final /* synthetic */ boolean g;
        public final /* synthetic */ fm1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, fm1 fm1Var) {
            super(0);
            this.g = z;
            this.h = fm1Var;
        }

        public final void a() {
            boolean z = this.g;
            fm1 fm1Var = this.h;
            kr krVar = null;
            if (z) {
                oa3 oa3Var = fm1Var.j0;
                if (oa3Var == null) {
                    il1.j("pb");
                    oa3Var = null;
                }
                oa3Var.l.add("android.permission.BODY_SENSORS_BACKGROUND");
                oa3 oa3Var2 = this.h.j0;
                if (oa3Var2 == null) {
                    il1.j("pb");
                    oa3Var2 = null;
                }
                oa3Var2.m.remove("android.permission.BODY_SENSORS_BACKGROUND");
                oa3 oa3Var3 = this.h.j0;
                if (oa3Var3 == null) {
                    il1.j("pb");
                    oa3Var3 = null;
                }
                oa3Var3.n.remove("android.permission.BODY_SENSORS_BACKGROUND");
                kr krVar2 = this.h.k0;
                if (krVar2 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar2;
                }
                krVar.b();
                return;
            }
            fm1Var.n2("android.permission.BODY_SENSORS_BACKGROUND");
            oa3 oa3Var4 = this.h.j0;
            if (oa3Var4 == null) {
                il1.j("pb");
                oa3Var4 = null;
            }
            oa3Var4.getClass();
            oa3 oa3Var5 = this.h.j0;
            if (oa3Var5 == null) {
                il1.j("pb");
                oa3Var5 = null;
            }
            oa3Var5.getClass();
            oa3 oa3Var6 = this.h.j0;
            if (oa3Var6 == null) {
                il1.j("pb");
                oa3Var6 = null;
            }
            oa3Var6.getClass();
            kr krVar3 = this.h.k0;
            if (krVar3 == null) {
                il1.j("task");
            } else {
                krVar = krVar3;
            }
            krVar.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends tr1 implements Function0 {
        public c() {
            super(0);
        }

        public final void a() {
            int i = Build.VERSION.SDK_INT;
            fm1 fm1Var = fm1.this;
            kr krVar = null;
            kr krVar2 = null;
            oa3 oa3Var = null;
            if (i < 26) {
                kr krVar3 = fm1Var.k0;
                if (krVar3 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar3;
                }
                krVar.b();
                return;
            }
            boolean zCanRequestPackageInstalls = fm1Var.X1().getPackageManager().canRequestPackageInstalls();
            fm1 fm1Var2 = fm1.this;
            if (zCanRequestPackageInstalls) {
                kr krVar4 = fm1Var2.k0;
                if (krVar4 == null) {
                    il1.j("task");
                } else {
                    krVar2 = krVar4;
                }
                krVar2.b();
                return;
            }
            oa3 oa3Var2 = fm1Var2.j0;
            if (oa3Var2 == null) {
                il1.j("pb");
                oa3Var2 = null;
            }
            oa3Var2.getClass();
            oa3 oa3Var3 = fm1.this.j0;
            if (oa3Var3 == null) {
                il1.j("pb");
            } else {
                oa3Var = oa3Var3;
            }
            oa3Var.getClass();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends tr1 implements Function0 {
        public d() {
            super(0);
        }

        public final void a() {
            kr krVar = null;
            kr krVar2 = null;
            oa3 oa3Var = null;
            if (Build.VERSION.SDK_INT < 30) {
                kr krVar3 = fm1.this.k0;
                if (krVar3 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar3;
                }
                krVar.b();
                return;
            }
            boolean zIsExternalStorageManager = Environment.isExternalStorageManager();
            fm1 fm1Var = fm1.this;
            if (zIsExternalStorageManager) {
                kr krVar4 = fm1Var.k0;
                if (krVar4 == null) {
                    il1.j("task");
                } else {
                    krVar2 = krVar4;
                }
                krVar2.b();
                return;
            }
            oa3 oa3Var2 = fm1Var.j0;
            if (oa3Var2 == null) {
                il1.j("pb");
                oa3Var2 = null;
            }
            oa3Var2.getClass();
            oa3 oa3Var3 = fm1.this.j0;
            if (oa3Var3 == null) {
                il1.j("pb");
            } else {
                oa3Var = oa3Var3;
            }
            oa3Var.getClass();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends tr1 implements Function0 {
        public e() {
            super(0);
        }

        public final void a() {
            int i = Build.VERSION.SDK_INT;
            fm1 fm1Var = fm1.this;
            kr krVar = null;
            kr krVar2 = null;
            oa3 oa3Var = null;
            if (i < 26) {
                kr krVar3 = fm1Var.k0;
                if (krVar3 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar3;
                }
                krVar.b();
                return;
            }
            boolean zA = ua3.a(fm1Var.Y1());
            fm1 fm1Var2 = fm1.this;
            if (zA) {
                kr krVar4 = fm1Var2.k0;
                if (krVar4 == null) {
                    il1.j("task");
                } else {
                    krVar2 = krVar4;
                }
                krVar2.b();
                return;
            }
            oa3 oa3Var2 = fm1Var2.j0;
            if (oa3Var2 == null) {
                il1.j("pb");
                oa3Var2 = null;
            }
            oa3Var2.getClass();
            oa3 oa3Var3 = fm1.this.j0;
            if (oa3Var3 == null) {
                il1.j("pb");
            } else {
                oa3Var = oa3Var3;
            }
            oa3Var.getClass();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends tr1 implements Function0 {
        public f() {
            super(0);
        }

        public final void a() {
            boolean zCanWrite = Settings.System.canWrite(fm1.this.Y1());
            fm1 fm1Var = fm1.this;
            oa3 oa3Var = null;
            kr krVar = null;
            if (zCanWrite) {
                kr krVar2 = fm1Var.k0;
                if (krVar2 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar2;
                }
                krVar.b();
                return;
            }
            oa3 oa3Var2 = fm1Var.j0;
            if (oa3Var2 == null) {
                il1.j("pb");
                oa3Var2 = null;
            }
            oa3Var2.getClass();
            oa3 oa3Var3 = fm1.this.j0;
            if (oa3Var3 == null) {
                il1.j("pb");
            } else {
                oa3Var = oa3Var3;
            }
            oa3Var.getClass();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends tr1 implements Function0 {
        public final /* synthetic */ Boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Boolean bool) {
            super(0);
            this.h = bool;
        }

        public final void a() {
            fm1 fm1Var = fm1.this;
            Boolean bool = this.h;
            bool.getClass();
            fm1Var.O2(bool.booleanValue());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends tr1 implements Function0 {
        public final /* synthetic */ Boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Boolean bool) {
            super(0);
            this.h = bool;
        }

        public final void a() {
            fm1 fm1Var = fm1.this;
            Boolean bool = this.h;
            bool.getClass();
            fm1Var.P2(bool.booleanValue());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i extends tr1 implements Function0 {
        public i() {
            super(0);
        }

        public final void a() {
            fm1.this.Q2();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j extends tr1 implements Function0 {
        public j() {
            super(0);
        }

        public final void a() {
            fm1.this.R2();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k extends tr1 implements Function0 {
        public final /* synthetic */ Map h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Map map) {
            super(0);
            this.h = map;
        }

        public final void a() {
            fm1 fm1Var = fm1.this;
            Map map = this.h;
            map.getClass();
            fm1Var.S2(map);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class l extends tr1 implements Function0 {
        public l() {
            super(0);
        }

        public final void a() {
            fm1.this.T2();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class m extends tr1 implements Function0 {
        public m() {
            super(0);
        }

        public final void a() {
            fm1.this.U2();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class n extends tr1 implements Function0 {
        public n() {
            super(0);
        }

        public final void a() {
            fm1.this.V2();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    public fm1() {
        q3 q3VarV1 = V1(new n3(), new l3() { // from class: vl1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.v2(this.a, (Map) obj);
            }
        });
        q3VarV1.getClass();
        this.l0 = q3VarV1;
        q3 q3VarV12 = V1(new o3(), new l3() { // from class: wl1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.C2(this.a, (Boolean) obj);
            }
        });
        q3VarV12.getClass();
        this.m0 = q3VarV12;
        q3 q3VarV13 = V1(new p3(), new l3() { // from class: xl1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.z2(this.a, (k3) obj);
            }
        });
        q3VarV13.getClass();
        this.n0 = q3VarV13;
        q3 q3VarV14 = V1(new p3(), new l3() { // from class: yl1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.u2(this.a, (k3) obj);
            }
        });
        q3VarV14.getClass();
        this.o0 = q3VarV14;
        q3 q3VarV15 = V1(new p3(), new l3() { // from class: zl1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.A2(this.a, (k3) obj);
            }
        });
        q3VarV15.getClass();
        this.p0 = q3VarV15;
        q3 q3VarV16 = V1(new p3(), new l3() { // from class: am1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.B2(this.a, (k3) obj);
            }
        });
        q3VarV16.getClass();
        this.q0 = q3VarV16;
        q3 q3VarV17 = V1(new p3(), new l3() { // from class: bm1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.x2(this.a, (k3) obj);
            }
        });
        q3VarV17.getClass();
        this.r0 = q3VarV17;
        q3 q3VarV18 = V1(new o3(), new l3() { // from class: cm1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.y2(this.a, (Boolean) obj);
            }
        });
        q3VarV18.getClass();
        this.s0 = q3VarV18;
        q3 q3VarV19 = V1(new p3(), new l3() { // from class: dm1
            @Override // defpackage.l3
            public final void a(Object obj) {
                fm1.w2(this.a, (k3) obj);
            }
        });
        q3VarV19.getClass();
        this.t0 = q3VarV19;
    }

    public static void A2(fm1 fm1Var, k3 k3Var) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new j());
    }

    public static void B2(fm1 fm1Var, k3 k3Var) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new i());
    }

    public static void C2(fm1 fm1Var, Boolean bool) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new g(bool));
    }

    public static void t2(Function0 function0) {
        function0.getClass();
        function0.invoke();
    }

    public static void u2(fm1 fm1Var, k3 k3Var) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new n());
    }

    public static void v2(fm1 fm1Var, Map map) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new k(map));
    }

    public static void w2(fm1 fm1Var, k3 k3Var) {
        fm1Var.getClass();
        if (fm1Var.N2()) {
            kr krVar = fm1Var.k0;
            oa3 oa3Var = null;
            if (krVar == null) {
                il1.j("task");
                krVar = null;
            }
            oa3 oa3Var2 = fm1Var.j0;
            if (oa3Var2 == null) {
                il1.j("pb");
            } else {
                oa3Var = oa3Var2;
            }
            krVar.a(new ArrayList(oa3Var.q));
        }
    }

    public static void x2(fm1 fm1Var, k3 k3Var) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new l());
    }

    public static void y2(fm1 fm1Var, Boolean bool) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new h(bool));
    }

    public static void z2(fm1 fm1Var, k3 k3Var) {
        fm1Var.getClass();
        fm1Var.W2(fm1Var.new m());
    }

    public final boolean N2() {
        if (this.j0 != null && this.k0 != null && U() != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }

    public final void O2(boolean z) {
        if (N2()) {
            W2(new a(z, this));
        }
    }

    public final void P2(boolean z) {
        if (N2()) {
            W2(new b(z, this));
        }
    }

    public final void Q2() {
        if (N2()) {
            W2(new c());
        }
    }

    public final void R2() {
        if (N2()) {
            W2(new d());
        }
    }

    public final void S2(Map map) {
        if (N2()) {
            oa3 oa3Var = this.j0;
            oa3 oa3Var2 = null;
            kr krVar = null;
            if (oa3Var == null) {
                il1.j("pb");
                oa3Var = null;
            }
            oa3Var.l.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (((Boolean) entry.getValue()).booleanValue()) {
                    oa3 oa3Var3 = this.j0;
                    if (oa3Var3 == null) {
                        il1.j("pb");
                        oa3Var3 = null;
                    }
                    oa3Var3.l.add(str);
                    oa3 oa3Var4 = this.j0;
                    if (oa3Var4 == null) {
                        il1.j("pb");
                        oa3Var4 = null;
                    }
                    oa3Var4.m.remove(str);
                    oa3 oa3Var5 = this.j0;
                    if (oa3Var5 == null) {
                        il1.j("pb");
                        oa3Var5 = null;
                    }
                    oa3Var5.n.remove(str);
                } else if (n2(str)) {
                    arrayList.add(str);
                    oa3 oa3Var6 = this.j0;
                    if (oa3Var6 == null) {
                        il1.j("pb");
                        oa3Var6 = null;
                    }
                    oa3Var6.m.add(str);
                } else {
                    arrayList2.add(str);
                    oa3 oa3Var7 = this.j0;
                    if (oa3Var7 == null) {
                        il1.j("pb");
                        oa3Var7 = null;
                    }
                    oa3Var7.n.add(str);
                    oa3 oa3Var8 = this.j0;
                    if (oa3Var8 == null) {
                        il1.j("pb");
                        oa3Var8 = null;
                    }
                    oa3Var8.m.remove(str);
                }
            }
            if (Build.VERSION.SDK_INT >= 34) {
                oa3 oa3Var9 = this.j0;
                if (oa3Var9 == null) {
                    il1.j("pb");
                    oa3Var9 = null;
                }
                if (oa3Var9.l.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
                    oa3 oa3Var10 = this.j0;
                    if (oa3Var10 == null) {
                        il1.j("pb");
                        oa3Var10 = null;
                    }
                    boolean zContains = oa3Var10.m.contains("android.permission.READ_MEDIA_IMAGES");
                    oa3 oa3Var11 = this.j0;
                    if (zContains) {
                        if (oa3Var11 == null) {
                            il1.j("pb");
                            oa3Var11 = null;
                        }
                        oa3Var11.m.remove("android.permission.READ_MEDIA_IMAGES");
                        arrayList.remove("android.permission.READ_MEDIA_IMAGES");
                        oa3 oa3Var12 = this.j0;
                        if (oa3Var12 == null) {
                            il1.j("pb");
                            oa3Var12 = null;
                        }
                        oa3Var12.p.add("android.permission.READ_MEDIA_IMAGES");
                    } else {
                        if (oa3Var11 == null) {
                            il1.j("pb");
                            oa3Var11 = null;
                        }
                        if (oa3Var11.n.contains("android.permission.READ_MEDIA_IMAGES")) {
                            oa3 oa3Var13 = this.j0;
                            if (oa3Var13 == null) {
                                il1.j("pb");
                                oa3Var13 = null;
                            }
                            oa3Var13.n.remove("android.permission.READ_MEDIA_IMAGES");
                            arrayList2.remove("android.permission.READ_MEDIA_IMAGES");
                            oa3 oa3Var14 = this.j0;
                            if (oa3Var14 == null) {
                                il1.j("pb");
                                oa3Var14 = null;
                            }
                            oa3Var14.p.add("android.permission.READ_MEDIA_IMAGES");
                        }
                    }
                    oa3 oa3Var15 = this.j0;
                    if (oa3Var15 == null) {
                        il1.j("pb");
                        oa3Var15 = null;
                    }
                    boolean zContains2 = oa3Var15.m.contains("android.permission.READ_MEDIA_VIDEO");
                    oa3 oa3Var16 = this.j0;
                    if (zContains2) {
                        if (oa3Var16 == null) {
                            il1.j("pb");
                            oa3Var16 = null;
                        }
                        oa3Var16.m.remove("android.permission.READ_MEDIA_VIDEO");
                        arrayList.remove("android.permission.READ_MEDIA_VIDEO");
                        oa3 oa3Var17 = this.j0;
                        if (oa3Var17 == null) {
                            il1.j("pb");
                            oa3Var17 = null;
                        }
                        oa3Var17.p.add("android.permission.READ_MEDIA_VIDEO");
                    } else {
                        if (oa3Var16 == null) {
                            il1.j("pb");
                            oa3Var16 = null;
                        }
                        if (oa3Var16.n.contains("android.permission.READ_MEDIA_VIDEO")) {
                            oa3 oa3Var18 = this.j0;
                            if (oa3Var18 == null) {
                                il1.j("pb");
                                oa3Var18 = null;
                            }
                            oa3Var18.n.remove("android.permission.READ_MEDIA_VIDEO");
                            arrayList2.remove("android.permission.READ_MEDIA_VIDEO");
                            oa3 oa3Var19 = this.j0;
                            if (oa3Var19 == null) {
                                il1.j("pb");
                                oa3Var19 = null;
                            }
                            oa3Var19.p.add("android.permission.READ_MEDIA_VIDEO");
                        }
                    }
                }
            }
            ArrayList<String> arrayList3 = new ArrayList();
            oa3 oa3Var20 = this.j0;
            if (oa3Var20 == null) {
                il1.j("pb");
                oa3Var20 = null;
            }
            arrayList3.addAll(oa3Var20.m);
            oa3 oa3Var21 = this.j0;
            if (oa3Var21 == null) {
                il1.j("pb");
                oa3Var21 = null;
            }
            arrayList3.addAll(oa3Var21.n);
            for (String str2 : arrayList3) {
                if (ua3.d(Y1(), str2)) {
                    oa3 oa3Var22 = this.j0;
                    if (oa3Var22 == null) {
                        il1.j("pb");
                        oa3Var22 = null;
                    }
                    oa3Var22.m.remove(str2);
                    oa3 oa3Var23 = this.j0;
                    if (oa3Var23 == null) {
                        il1.j("pb");
                        oa3Var23 = null;
                    }
                    oa3Var23.l.add(str2);
                }
            }
            oa3 oa3Var24 = this.j0;
            if (oa3Var24 == null) {
                il1.j("pb");
                oa3Var24 = null;
            }
            int size = oa3Var24.l.size();
            oa3 oa3Var25 = this.j0;
            if (oa3Var25 == null) {
                il1.j("pb");
                oa3Var25 = null;
            }
            if (size == oa3Var25.g.size()) {
                kr krVar2 = this.k0;
                if (krVar2 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar2;
                }
                krVar.b();
                return;
            }
            oa3 oa3Var26 = this.j0;
            if (oa3Var26 == null) {
                il1.j("pb");
                oa3Var26 = null;
            }
            oa3Var26.getClass();
            oa3 oa3Var27 = this.j0;
            if (oa3Var27 == null) {
                il1.j("pb");
                oa3Var27 = null;
            }
            oa3Var27.getClass();
            oa3 oa3Var28 = this.j0;
            if (oa3Var28 == null) {
                il1.j("pb");
                oa3Var28 = null;
            }
            oa3Var28.getClass();
            oa3 oa3Var29 = this.j0;
            if (oa3Var29 == null) {
                il1.j("pb");
                oa3Var29 = null;
            }
            for (String str3 : oa3Var29.p) {
                oa3 oa3Var30 = this.j0;
                if (oa3Var30 == null) {
                    il1.j("pb");
                    oa3Var30 = null;
                }
                oa3Var30.m.add(str3);
            }
            oa3 oa3Var31 = this.j0;
            if (oa3Var31 == null) {
                il1.j("pb");
                oa3Var31 = null;
            }
            oa3Var31.p.clear();
            kr krVar3 = this.k0;
            if (krVar3 == null) {
                il1.j("task");
                krVar3 = null;
            }
            krVar3.b();
            oa3 oa3Var32 = this.j0;
            if (oa3Var32 == null) {
                il1.j("pb");
            } else {
                oa3Var2 = oa3Var32;
            }
            oa3Var2.j = false;
        }
    }

    public final void T2() {
        if (N2()) {
            W2(new e());
        }
    }

    public final void U2() {
        if (N2()) {
            oa3 oa3Var = null;
            kr krVar = null;
            if (Settings.canDrawOverlays(Y1())) {
                kr krVar2 = this.k0;
                if (krVar2 == null) {
                    il1.j("task");
                } else {
                    krVar = krVar2;
                }
                krVar.b();
                return;
            }
            oa3 oa3Var2 = this.j0;
            if (oa3Var2 == null) {
                il1.j("pb");
                oa3Var2 = null;
            }
            oa3Var2.getClass();
            oa3 oa3Var3 = this.j0;
            if (oa3Var3 == null) {
                il1.j("pb");
            } else {
                oa3Var = oa3Var3;
            }
            oa3Var.getClass();
        }
    }

    public final void V2() {
        if (N2()) {
            W2(new f());
        }
    }

    public final void W2(final Function0 function0) {
        this.i0.post(new Runnable() { // from class: em1
            @Override // java.lang.Runnable
            public final void run() {
                fm1.t2(function0);
            }
        });
    }

    public final void X2(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        this.m0.a("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final void Y2(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        this.s0.a("android.permission.BODY_SENSORS_BACKGROUND");
    }

    public final void Z2(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        if (Build.VERSION.SDK_INT < 26) {
            Q2();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(Uri.parse("package:" + X1().getPackageName()));
        this.q0.a(intent);
    }

    @Override // defpackage.p51
    public void a1() {
        super.a1();
        if (N2()) {
            oa3 oa3Var = this.j0;
            if (oa3Var == null) {
                il1.j("pb");
                oa3Var = null;
            }
            Dialog dialog = oa3Var.f;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        }
    }

    public final void a3(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            R2();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.parse("package:" + X1().getPackageName()));
        if (intent.resolveActivity(X1().getPackageManager()) == null) {
            intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        this.p0.a(intent);
    }

    public final void b3(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        if (Build.VERSION.SDK_INT < 26) {
            Q2();
            return;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", X1().getPackageName());
        this.r0.a(intent);
    }

    public final void c3(oa3 oa3Var, Set set, kr krVar) {
        oa3Var.getClass();
        set.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        this.l0.a(set.toArray(new String[0]));
    }

    public final void d3(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        if (Settings.canDrawOverlays(Y1())) {
            U2();
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + X1().getPackageName()));
        this.n0.a(intent);
    }

    public final void e3(oa3 oa3Var, kr krVar) {
        oa3Var.getClass();
        krVar.getClass();
        this.j0 = oa3Var;
        this.k0 = krVar;
        if (Settings.System.canWrite(Y1())) {
            V2();
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + X1().getPackageName()));
        this.o0.a(intent);
    }
}
