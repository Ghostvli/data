package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.g;
import defpackage.b71;
import defpackage.d71;
import defpackage.p51;
import defpackage.qx3;
import defpackage.yk1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k61 {
    public static boolean S;
    public q3 D;
    public q3 E;
    public q3 F;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList M;
    public ArrayList N;
    public ArrayList O;
    public n61 P;
    public b71.c Q;
    public boolean b;
    public ArrayList d;
    public ArrayList e;
    public f63 g;
    public ArrayList m;
    public c61 v;
    public x51 w;
    public p51 x;
    public p51 y;
    public final ArrayList a = new ArrayList();
    public final z61 c = new z61();
    public final d61 f = new d61(this);
    public final e63 h = new b(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map j = Collections.synchronizedMap(new HashMap());
    public final Map k = Collections.synchronizedMap(new HashMap());
    public final Map l = Collections.synchronizedMap(new HashMap());
    public final e61 n = new e61(this);
    public final CopyOnWriteArrayList o = new CopyOnWriteArrayList();
    public final h20 p = new h20() { // from class: f61
        @Override // defpackage.h20
        public final void accept(Object obj) {
            k61.e(this.a, (Configuration) obj);
        }
    };
    public final h20 q = new h20() { // from class: g61
        @Override // defpackage.h20
        public final void accept(Object obj) {
            k61.a(this.a, (Integer) obj);
        }
    };
    public final h20 r = new h20() { // from class: h61
        @Override // defpackage.h20
        public final void accept(Object obj) {
            k61.d(this.a, (cw2) obj);
        }
    };
    public final h20 s = new h20() { // from class: i61
        @Override // defpackage.h20
        public final void accept(Object obj) {
            k61.c(this.a, (db3) obj);
        }
    };
    public final ds2 t = new c();
    public int u = -1;
    public a61 z = null;
    public a61 A = new d();
    public wb4 B = null;
    public wb4 C = new e();
    public ArrayDeque G = new ArrayDeque();
    public Runnable R = new f();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements l3 {
        public a() {
        }

        @Override // defpackage.l3
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            m mVar = (m) k61.this.G.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = mVar.f;
            int i2 = mVar.g;
            p51 p51VarI = k61.this.c.i(str);
            if (p51VarI != null) {
                p51VarI.p1(i2, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends e63 {
        public b(boolean z) {
            super(z);
        }

        @Override // defpackage.e63
        public void d() {
            k61.this.G0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements ds2 {
        public c() {
        }

        @Override // defpackage.ds2
        public boolean f(MenuItem menuItem) {
            return k61.this.K(menuItem);
        }

        @Override // defpackage.ds2
        public void r(Menu menu) {
            k61.this.L(menu);
        }

        @Override // defpackage.ds2
        public void w(Menu menu, MenuInflater menuInflater) {
            k61.this.D(menu, menuInflater);
        }

        @Override // defpackage.ds2
        public void x(Menu menu) {
            k61.this.P(menu);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends a61 {
        public d() {
        }

        @Override // defpackage.a61
        public p51 a(ClassLoader classLoader, String str) {
            return k61.this.x0().b(k61.this.x0().f(), str, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements wb4 {
        public e() {
        }

        @Override // defpackage.wb4
        public ub4 a(ViewGroup viewGroup) {
            return new oh0(viewGroup);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k61.this.b0(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements androidx.lifecycle.i {
        public final /* synthetic */ String f;
        public final /* synthetic */ p61 g;
        public final /* synthetic */ androidx.lifecycle.g h;

        public g(String str, p61 p61Var, androidx.lifecycle.g gVar) {
            this.f = str;
            this.g = p61Var;
            this.h = gVar;
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            Bundle bundle;
            if (aVar == g.a.ON_START && (bundle = (Bundle) k61.this.k.get(this.f)) != null) {
                this.g.a(this.f, bundle);
                k61.this.t(this.f);
            }
            if (aVar == g.a.ON_DESTROY) {
                this.h.c(this);
                k61.this.l.remove(this.f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements o61 {
        public final /* synthetic */ p51 f;

        public h(p51 p51Var) {
            this.f = p51Var;
        }

        @Override // defpackage.o61
        public void a(k61 k61Var, p51 p51Var) {
            this.f.T0(p51Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i implements l3 {
        public i() {
        }

        @Override // defpackage.l3
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k3 k3Var) {
            m mVar = (m) k61.this.G.pollLast();
            if (mVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = mVar.f;
            int i = mVar.g;
            p51 p51VarI = k61.this.c.i(str);
            if (p51VarI != null) {
                p51VarI.Q0(i, k3Var.d(), k3Var.c());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class j implements l3 {
        public j() {
        }

        @Override // defpackage.l3
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k3 k3Var) {
            m mVar = (m) k61.this.G.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = mVar.f;
            int i = mVar.g;
            p51 p51VarI = k61.this.c.i(str);
            if (p51VarI != null) {
                p51VarI.Q0(i, k3Var.d(), k3Var.c());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k extends m3 {
        @Override // defpackage.m3
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, yk1 yk1Var) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentC = yk1Var.c();
            if (intentC != null && (bundleExtra = intentC.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentC.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentC.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    yk1Var = new yk1.a(yk1Var.u()).b(null).c(yk1Var.s(), yk1Var.d()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", yk1Var);
            if (k61.K0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // defpackage.m3
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public k3 c(int i, Intent intent) {
            return new k3(i, intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class l {
        public void a(k61 k61Var, p51 p51Var, Bundle bundle) {
        }

        public void b(k61 k61Var, p51 p51Var, Context context) {
        }

        public void c(k61 k61Var, p51 p51Var, Bundle bundle) {
        }

        public void d(k61 k61Var, p51 p51Var) {
        }

        public void e(k61 k61Var, p51 p51Var) {
        }

        public void f(k61 k61Var, p51 p51Var) {
        }

        public void g(k61 k61Var, p51 p51Var, Context context) {
        }

        public void h(k61 k61Var, p51 p51Var, Bundle bundle) {
        }

        public void i(k61 k61Var, p51 p51Var) {
        }

        public void j(k61 k61Var, p51 p51Var, Bundle bundle) {
        }

        public void k(k61 k61Var, p51 p51Var) {
        }

        public void l(k61 k61Var, p51 p51Var) {
        }

        public abstract void m(k61 k61Var, p51 p51Var, View view, Bundle bundle);

        public void n(k61 k61Var, p51 p51Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class n implements p61 {
        public final androidx.lifecycle.g a;
        public final p61 b;
        public final androidx.lifecycle.i c;

        public n(androidx.lifecycle.g gVar, p61 p61Var, androidx.lifecycle.i iVar) {
            this.a = gVar;
            this.b = p61Var;
            this.c = iVar;
        }

        @Override // defpackage.p61
        public void a(String str, Bundle bundle) {
            this.b.a(str, bundle);
        }

        public boolean b(g.b bVar) {
            return this.a.b().b(bVar);
        }

        public void c() {
            this.a.c(this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface o {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class p implements o {
        public final String a;
        public final int b;
        public final int c;

        public p(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // k61.o
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            p51 p51Var = k61.this.y;
            if (p51Var == null || this.b >= 0 || this.a != null || !p51Var.T().Z0()) {
                return k61.this.c1(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    public static p51 E0(View view) {
        Object tag = view.getTag(tl3.a);
        if (tag instanceof p51) {
            return (p51) tag;
        }
        return null;
    }

    public static boolean K0(int i2) {
        return S || Log.isLoggable("FragmentManager", i2);
    }

    public static /* synthetic */ void a(k61 k61Var, Integer num) {
        if (k61Var.M0() && num.intValue() == 80) {
            k61Var.G(false);
        }
    }

    public static /* synthetic */ void c(k61 k61Var, db3 db3Var) {
        if (k61Var.M0()) {
            k61Var.O(db3Var.a(), false);
        }
    }

    public static /* synthetic */ void d(k61 k61Var, cw2 cw2Var) {
        if (k61Var.M0()) {
            k61Var.H(cw2Var.a(), false);
        }
    }

    public static void d0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            pf pfVar = (pf) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                pfVar.x(-1);
                pfVar.C();
            } else {
                pfVar.x(1);
                pfVar.B();
            }
            i2++;
        }
    }

    public static /* synthetic */ void e(k61 k61Var, Configuration configuration) {
        if (k61Var.M0()) {
            k61Var.A(configuration, false);
        }
    }

    public static int j1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 == 8194) {
            return 4097;
        }
        if (i2 == 8197) {
            return 4100;
        }
        if (i2 != 4099) {
            return i2 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    public static k61 l0(View view) {
        u51 u51Var;
        p51 p51VarM0 = m0(view);
        if (p51VarM0 != null) {
            if (p51VarM0.H0()) {
                return p51VarM0.T();
            }
            throw new IllegalStateException("The Fragment " + p51VarM0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                u51Var = null;
                break;
            }
            if (context instanceof u51) {
                u51Var = (u51) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (u51Var != null) {
            return u51Var.n1();
        }
        wx1.a("View ", view, " is not within a subclass of FragmentActivity.");
        return null;
    }

    public static p51 m0(View view) {
        while (view != null) {
            p51 p51VarE0 = E0(view);
            if (p51VarE0 != null) {
                return p51VarE0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public void A(Configuration configuration, boolean z) {
        if (z && (this.v instanceof i63)) {
            v1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null) {
                p51Var.y1(configuration);
                if (z) {
                    p51Var.A.A(configuration, true);
                }
            }
        }
    }

    public p51 A0() {
        return this.x;
    }

    public boolean B(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null && p51Var.z1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public p51 B0() {
        return this.y;
    }

    public void C() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(1);
    }

    public wb4 C0() {
        wb4 wb4Var = this.B;
        if (wb4Var != null) {
            return wb4Var;
        }
        p51 p51Var = this.x;
        return p51Var != null ? p51Var.y.C0() : this.C;
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null && O0(p51Var) && p51Var.B1(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(p51Var);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                p51 p51Var2 = (p51) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(p51Var2)) {
                    p51Var2.b1();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public b71.c D0() {
        return this.Q;
    }

    public void E() {
        this.K = true;
        b0(true);
        Y();
        s();
        T(-1);
        Object obj = this.v;
        if (obj instanceof o63) {
            ((o63) obj).Y(this.q);
        }
        Object obj2 = this.v;
        if (obj2 instanceof i63) {
            ((i63) obj2).x0(this.p);
        }
        Object obj3 = this.v;
        if (obj3 instanceof k63) {
            ((k63) obj3).L0(this.r);
        }
        Object obj4 = this.v;
        if (obj4 instanceof l63) {
            ((l63) obj4).K0(this.s);
        }
        Object obj5 = this.v;
        if ((obj5 instanceof vr2) && this.x == null) {
            ((vr2) obj5).s0(this.t);
        }
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.g != null) {
            this.h.h();
            this.g = null;
        }
        q3 q3Var = this.D;
        if (q3Var != null) {
            q3Var.c();
            this.E.c();
            this.F.c();
        }
    }

    public void F() {
        T(1);
    }

    public k45 F0(p51 p51Var) {
        return this.P.m(p51Var);
    }

    public void G(boolean z) {
        if (z && (this.v instanceof o63)) {
            v1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null) {
                p51Var.H1();
                if (z) {
                    p51Var.A.G(true);
                }
            }
        }
    }

    public void G0() {
        b0(true);
        if (this.h.g()) {
            Z0();
        } else {
            this.g.k();
        }
    }

    public void H(boolean z, boolean z2) {
        if (z2 && (this.v instanceof k63)) {
            v1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null) {
                p51Var.I1(z);
                if (z2) {
                    p51Var.A.H(z, true);
                }
            }
        }
    }

    public void H0(p51 p51Var) {
        if (K0(2)) {
            Log.v("FragmentManager", "hide: " + p51Var);
        }
        if (p51Var.F) {
            return;
        }
        p51Var.F = true;
        p51Var.T = true ^ p51Var.T;
        s1(p51Var);
    }

    public void I(p51 p51Var) {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((o61) it.next()).a(this, p51Var);
        }
    }

    public void I0(p51 p51Var) {
        if (p51Var.q && L0(p51Var)) {
            this.H = true;
        }
    }

    public void J() {
        for (p51 p51Var : this.c.l()) {
            if (p51Var != null) {
                p51Var.f1(p51Var.I0());
                p51Var.A.J();
            }
        }
    }

    public boolean J0() {
        return this.K;
    }

    public boolean K(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null && p51Var.J1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void L(Menu menu) {
        if (this.u < 1) {
            return;
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null) {
                p51Var.K1(menu);
            }
        }
    }

    public final boolean L0(p51 p51Var) {
        return (p51Var.J && p51Var.K) || p51Var.A.p();
    }

    public final void M(p51 p51Var) {
        if (p51Var == null || !p51Var.equals(g0(p51Var.k))) {
            return;
        }
        p51Var.O1();
    }

    public final boolean M0() {
        p51 p51Var = this.x;
        if (p51Var == null) {
            return true;
        }
        return p51Var.H0() && this.x.k0().M0();
    }

    public void N() {
        T(5);
    }

    public boolean N0(p51 p51Var) {
        if (p51Var == null) {
            return false;
        }
        return p51Var.I0();
    }

    public void O(boolean z, boolean z2) {
        if (z2 && (this.v instanceof l63)) {
            v1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null) {
                p51Var.M1(z);
                if (z2) {
                    p51Var.A.O(z, true);
                }
            }
        }
    }

    public boolean O0(p51 p51Var) {
        if (p51Var == null) {
            return true;
        }
        return p51Var.K0();
    }

    public boolean P(Menu menu) {
        boolean z = false;
        if (this.u < 1) {
            return false;
        }
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null && O0(p51Var) && p51Var.N1(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean P0(p51 p51Var) {
        if (p51Var == null) {
            return true;
        }
        k61 k61Var = p51Var.y;
        return p51Var.equals(k61Var.B0()) && P0(k61Var.x);
    }

    public void Q() {
        x1();
        M(this.y);
    }

    public boolean Q0(int i2) {
        return this.u >= i2;
    }

    public void R() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(7);
    }

    public boolean R0() {
        return this.I || this.J;
    }

    public void S() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(5);
    }

    public void S0(p51 p51Var, Intent intent, int i2, Bundle bundle) {
        if (this.D == null) {
            this.v.l(p51Var, intent, i2, bundle);
            return;
        }
        this.G.addLast(new m(p51Var.k, i2));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.a(intent);
    }

    public final void T(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            T0(i2, false);
            Iterator it = u().iterator();
            while (it.hasNext()) {
                ((ub4) it.next()).l();
            }
            this.b = false;
            b0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public void T0(int i2, boolean z) {
        c61 c61Var;
        if (this.v == null && i2 != -1) {
            e04.a("No activity");
            return;
        }
        if (z || i2 != this.u) {
            this.u = i2;
            this.c.t();
            u1();
            if (this.H && (c61Var = this.v) != null && this.u == 7) {
                c61Var.m();
                this.H = false;
            }
        }
    }

    public void U() {
        this.J = true;
        this.P.p(true);
        T(4);
    }

    public void U0() {
        if (this.v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.p(false);
        for (p51 p51Var : this.c.o()) {
            if (p51Var != null) {
                p51Var.O0();
            }
        }
    }

    public void V() {
        T(2);
    }

    public void V0(FragmentContainerView fragmentContainerView) {
        View view;
        for (w61 w61Var : this.c.k()) {
            p51 p51VarK = w61Var.k();
            if (p51VarK.D == fragmentContainerView.getId() && (view = p51VarK.N) != null && view.getParent() == null) {
                p51VarK.M = fragmentContainerView;
                w61Var.b();
            }
        }
    }

    public final void W() {
        if (this.L) {
            this.L = false;
            u1();
        }
    }

    public void W0(w61 w61Var) {
        p51 p51VarK = w61Var.k();
        if (p51VarK.O) {
            if (this.b) {
                this.L = true;
            } else {
                p51VarK.O = false;
                w61Var.m();
            }
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                p51 p51Var = (p51) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(p51Var.toString());
            }
        }
        ArrayList arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                pf pfVar = (pf) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(pfVar.toString());
                pfVar.z(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size3 = this.a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        o oVar = (o) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(oVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public void X0() {
        Z(new p(null, -1, 0), false);
    }

    public final void Y() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((ub4) it.next()).l();
        }
    }

    public void Y0(int i2, int i3, boolean z) {
        if (i2 >= 0) {
            Z(new p(null, i2, i3), z);
        } else {
            defpackage.b.a("Bad id: ", i2);
        }
    }

    public void Z(o oVar, boolean z) {
        if (!z) {
            if (this.v == null) {
                if (this.K) {
                    e04.a("FragmentManager has been destroyed");
                    return;
                } else {
                    e04.a("FragmentManager has not been attached to a host.");
                    return;
                }
            }
            q();
        }
        synchronized (this.a) {
            try {
                if (this.v == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(oVar);
                    m1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean Z0() {
        return b1(null, -1, 0);
    }

    public final void a0(boolean z) {
        if (this.b) {
            e04.a("FragmentManager is already executing transactions");
            return;
        }
        if (this.v == null) {
            if (this.K) {
                e04.a("FragmentManager has been destroyed");
                return;
            } else {
                e04.a("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.v.g().getLooper()) {
            e04.a("Must be called from main thread of fragment host");
            return;
        }
        if (!z) {
            q();
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    public boolean a1(int i2, int i3) {
        if (i2 >= 0) {
            return b1(null, i2, i3);
        }
        defpackage.b.a("Bad id: ", i2);
        return false;
    }

    public boolean b0(boolean z) {
        a0(z);
        boolean z2 = false;
        while (p0(this.M, this.N)) {
            z2 = true;
            this.b = true;
            try {
                g1(this.M, this.N);
            } finally {
                r();
            }
        }
        x1();
        W();
        this.c.b();
        return z2;
    }

    public final boolean b1(String str, int i2, int i3) {
        b0(false);
        a0(true);
        p51 p51Var = this.y;
        if (p51Var != null && i2 < 0 && str == null && p51Var.T().Z0()) {
            return true;
        }
        boolean zC1 = c1(this.M, this.N, str, i2, i3);
        if (zC1) {
            this.b = true;
            try {
                g1(this.M, this.N);
            } finally {
                r();
            }
        }
        x1();
        W();
        this.c.b();
        return zC1;
    }

    public void c0(o oVar, boolean z) {
        if (z && (this.v == null || this.K)) {
            return;
        }
        a0(z);
        if (oVar.a(this.M, this.N)) {
            this.b = true;
            try {
                g1(this.M, this.N);
            } finally {
                r();
            }
        }
        x1();
        W();
        this.c.b();
    }

    public boolean c1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int iH0 = h0(str, i2, (i3 & 1) != 0);
        if (iH0 < 0) {
            return false;
        }
        for (int size = this.d.size() - 1; size >= iH0; size--) {
            arrayList.add((pf) this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void d1(Bundle bundle, String str, p51 p51Var) {
        if (p51Var.y != this) {
            v1(new IllegalStateException("Fragment " + p51Var + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, p51Var.k);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        boolean z = ((pf) arrayList.get(i2)).r;
        ArrayList arrayList4 = this.O;
        if (arrayList4 == null) {
            this.O = new ArrayList();
        } else {
            arrayList4.clear();
        }
        this.O.addAll(this.c.o());
        p51 p51VarB0 = B0();
        boolean z2 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            pf pfVar = (pf) arrayList.get(i4);
            boolean zBooleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            ArrayList arrayList5 = this.O;
            p51VarB0 = !zBooleanValue ? pfVar.D(arrayList5, p51VarB0) : pfVar.G(arrayList5, p51VarB0);
            z2 = z2 || pfVar.i;
        }
        this.O.clear();
        if (!z && this.u >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator it = ((pf) arrayList.get(i5)).c.iterator();
                while (it.hasNext()) {
                    p51 p51Var = ((d71.a) it.next()).b;
                    if (p51Var != null && p51Var.y != null) {
                        this.c.r(w(p51Var));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i2, i3);
        boolean zBooleanValue2 = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
        if (z2 && (arrayList3 = this.m) != null && !arrayList3.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(o0((pf) it2.next()));
            }
            Iterator it3 = this.m.iterator();
            while (it3.hasNext()) {
                w82.a(it3.next());
                Iterator it4 = linkedHashSet.iterator();
                if (it4.hasNext()) {
                    throw null;
                }
            }
            Iterator it5 = this.m.iterator();
            while (it5.hasNext()) {
                w82.a(it5.next());
                Iterator it6 = linkedHashSet.iterator();
                if (it6.hasNext()) {
                    throw null;
                }
            }
        }
        for (int i6 = i2; i6 < i3; i6++) {
            pf pfVar2 = (pf) arrayList.get(i6);
            if (zBooleanValue2) {
                for (int size = pfVar2.c.size() - 1; size >= 0; size--) {
                    p51 p51Var2 = ((d71.a) pfVar2.c.get(size)).b;
                    if (p51Var2 != null) {
                        w(p51Var2).m();
                    }
                }
            } else {
                Iterator it7 = pfVar2.c.iterator();
                while (it7.hasNext()) {
                    p51 p51Var3 = ((d71.a) it7.next()).b;
                    if (p51Var3 != null) {
                        w(p51Var3).m();
                    }
                }
            }
        }
        T0(this.u, true);
        for (ub4 ub4Var : v(arrayList, i2, i3)) {
            ub4Var.t(zBooleanValue2);
            ub4Var.r();
            ub4Var.i();
        }
        while (i2 < i3) {
            pf pfVar3 = (pf) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue() && pfVar3.v >= 0) {
                pfVar3.v = -1;
            }
            pfVar3.F();
            i2++;
        }
        if (z2) {
            h1();
        }
    }

    public void e1(l lVar, boolean z) {
        this.n.o(lVar, z);
    }

    public boolean f0() {
        boolean zB0 = b0(true);
        n0();
        return zB0;
    }

    public void f1(p51 p51Var) {
        if (K0(2)) {
            Log.v("FragmentManager", "remove: " + p51Var + " nesting=" + p51Var.x);
        }
        boolean zJ0 = p51Var.J0();
        if (p51Var.G && zJ0) {
            return;
        }
        this.c.u(p51Var);
        if (L0(p51Var)) {
            this.H = true;
        }
        p51Var.r = true;
        s1(p51Var);
    }

    public p51 g0(String str) {
        return this.c.f(str);
    }

    public final void g1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            e04.a("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((pf) arrayList.get(i2)).r) {
                if (i3 != i2) {
                    e0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((pf) arrayList.get(i3)).r) {
                        i3++;
                    }
                }
                e0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            e0(arrayList, arrayList2, i3, size);
        }
    }

    public final int h0(String str, int i2, boolean z) {
        ArrayList arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i2 < 0) {
            if (z) {
                return 0;
            }
            return this.d.size() - 1;
        }
        int size = this.d.size() - 1;
        while (size >= 0) {
            pf pfVar = (pf) this.d.get(size);
            if ((str != null && str.equals(pfVar.E())) || (i2 >= 0 && i2 == pfVar.v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z) {
            if (size == this.d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            pf pfVar2 = (pf) this.d.get(size - 1);
            if ((str == null || !str.equals(pfVar2.E())) && (i2 < 0 || i2 != pfVar2.v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public final void h1() {
        ArrayList arrayList = this.m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        w82.a(this.m.get(0));
        throw null;
    }

    public void i(pf pfVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(pfVar);
    }

    public p51 i0(int i2) {
        return this.c.g(i2);
    }

    public void i1(Parcelable parcelable) {
        w61 w61Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.v.f().getClassLoader());
                this.k.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.v.f().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.c.x(map);
        m61 m61Var = (m61) bundle3.getParcelable("state");
        if (m61Var == null) {
            return;
        }
        this.c.v();
        Iterator it = m61Var.f.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.c.B((String) it.next(), null);
            if (bundleB != null) {
                p51 p51VarI = this.P.i(((u61) bundleB.getParcelable("state")).g);
                if (p51VarI != null) {
                    if (K0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + p51VarI);
                    }
                    w61Var = new w61(this.n, this.c, p51VarI, bundleB);
                } else {
                    w61Var = new w61(this.n, this.c, this.v.f().getClassLoader(), v0(), bundleB);
                }
                p51 p51VarK = w61Var.k();
                p51VarK.g = bundleB;
                p51VarK.y = this;
                if (K0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + p51VarK.k + "): " + p51VarK);
                }
                w61Var.o(this.v.f().getClassLoader());
                this.c.r(w61Var);
                w61Var.t(this.u);
            }
        }
        for (p51 p51Var : this.P.l()) {
            if (!this.c.c(p51Var.k)) {
                if (K0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + p51Var + " that was not found in the set of active Fragments " + m61Var.f);
                }
                this.P.o(p51Var);
                p51Var.y = this;
                w61 w61Var2 = new w61(this.n, this.c, p51Var);
                w61Var2.t(1);
                w61Var2.m();
                p51Var.r = true;
                w61Var2.m();
            }
        }
        this.c.w(m61Var.g);
        if (m61Var.h != null) {
            this.d = new ArrayList(m61Var.h.length);
            int i2 = 0;
            while (true) {
                qf[] qfVarArr = m61Var.h;
                if (i2 >= qfVarArr.length) {
                    break;
                }
                pf pfVarD = qfVarArr[i2].d(this);
                if (K0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + pfVarD.v + "): " + pfVarD);
                    PrintWriter printWriter = new PrintWriter(new c02("FragmentManager"));
                    pfVarD.A("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(pfVarD);
                i2++;
            }
        } else {
            this.d = null;
        }
        this.i.set(m61Var.i);
        String str3 = m61Var.j;
        if (str3 != null) {
            p51 p51VarG0 = g0(str3);
            this.y = p51VarG0;
            M(p51VarG0);
        }
        ArrayList arrayList = m61Var.k;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.j.put((String) arrayList.get(i3), (rf) m61Var.l.get(i3));
            }
        }
        this.G = new ArrayDeque(m61Var.m);
    }

    public w61 j(p51 p51Var) {
        String str = p51Var.W;
        if (str != null) {
            b71.e(p51Var, str);
        }
        if (K0(2)) {
            Log.v("FragmentManager", "add: " + p51Var);
        }
        w61 w61VarW = w(p51Var);
        p51Var.y = this;
        this.c.r(w61VarW);
        if (!p51Var.G) {
            this.c.a(p51Var);
            p51Var.r = false;
            if (p51Var.N == null) {
                p51Var.T = false;
            }
            if (L0(p51Var)) {
                this.H = true;
            }
        }
        return w61VarW;
    }

    public p51 j0(String str) {
        return this.c.h(str);
    }

    public void k(o61 o61Var) {
        this.o.add(o61Var);
    }

    public p51 k0(String str) {
        return this.c.i(str);
    }

    public Bundle k1() {
        qf[] qfVarArr;
        int size;
        Bundle bundle = new Bundle();
        n0();
        Y();
        b0(true);
        this.I = true;
        this.P.p(true);
        ArrayList arrayListY = this.c.y();
        HashMap mapM = this.c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.c.z();
            ArrayList arrayList = this.d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                qfVarArr = null;
            } else {
                qfVarArr = new qf[size];
                for (int i2 = 0; i2 < size; i2++) {
                    qfVarArr[i2] = new qf((pf) this.d.get(i2));
                    if (K0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                    }
                }
            }
            m61 m61Var = new m61();
            m61Var.f = arrayListY;
            m61Var.g = arrayListZ;
            m61Var.h = qfVarArr;
            m61Var.i = this.i.get();
            p51 p51Var = this.y;
            if (p51Var != null) {
                m61Var.j = p51Var.k;
            }
            m61Var.k.addAll(this.j.keySet());
            m61Var.l.addAll(this.j.values());
            m61Var.m = new ArrayList(this.G);
            bundle.putParcelable("state", m61Var);
            for (String str : this.k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.k.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (K0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public int l() {
        return this.i.getAndIncrement();
    }

    public p51.n l1(p51 p51Var) {
        w61 w61VarN = this.c.n(p51Var.k);
        if (w61VarN == null || !w61VarN.k().equals(p51Var)) {
            v1(new IllegalStateException("Fragment " + p51Var + " is not currently in the FragmentManager"));
        }
        return w61VarN.q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m(c61 c61Var, x51 x51Var, p51 p51Var) {
        String str;
        if (this.v != null) {
            e04.a("Already attached");
            return;
        }
        this.v = c61Var;
        this.w = x51Var;
        this.x = p51Var;
        if (p51Var != null) {
            k(new h(p51Var));
        } else if (c61Var instanceof o61) {
            k((o61) c61Var);
        }
        if (this.x != null) {
            x1();
        }
        if (c61Var instanceof h63) {
            h63 h63Var = (h63) c61Var;
            f63 f63VarY = h63Var.y();
            this.g = f63VarY;
            bt1 bt1Var = h63Var;
            if (p51Var != null) {
                bt1Var = p51Var;
            }
            f63VarY.h(bt1Var, this.h);
        }
        if (p51Var != null) {
            this.P = p51Var.y.r0(p51Var);
        } else if (c61Var instanceof l45) {
            this.P = n61.k(((l45) c61Var).d0());
        } else {
            this.P = new n61(false);
        }
        this.P.p(R0());
        this.c.A(this.P);
        Object obj = this.v;
        if ((obj instanceof vx3) && p51Var == null) {
            qx3 qx3VarL0 = ((vx3) obj).l0();
            qx3VarL0.c("android:support:fragments", new qx3.b() { // from class: j61
                @Override // qx3.b
                public final Bundle a() {
                    return this.a.k1();
                }
            });
            Bundle bundleA = qx3VarL0.a("android:support:fragments");
            if (bundleA != null) {
                i1(bundleA);
            }
        }
        Object obj2 = this.v;
        if (obj2 instanceof s3) {
            r3 r3VarW = ((s3) obj2).W();
            if (p51Var != null) {
                str = p51Var.k + ":";
            } else {
                str = "";
            }
            String strConcat = "FragmentManager:".concat(str);
            this.D = r3VarW.i(strConcat.concat("StartActivityForResult"), new p3(), new i());
            this.E = r3VarW.i(strConcat.concat("StartIntentSenderForResult"), new k(), new j());
            this.F = r3VarW.i(strConcat.concat("RequestPermissions"), new n3(), new a());
        }
        Object obj3 = this.v;
        if (obj3 instanceof i63) {
            ((i63) obj3).t0(this.p);
        }
        Object obj4 = this.v;
        if (obj4 instanceof o63) {
            ((o63) obj4).T(this.q);
        }
        Object obj5 = this.v;
        if (obj5 instanceof k63) {
            ((k63) obj5).O(this.r);
        }
        Object obj6 = this.v;
        if (obj6 instanceof l63) {
            ((l63) obj6).N(this.s);
        }
        Object obj7 = this.v;
        if ((obj7 instanceof vr2) && p51Var == null) {
            ((vr2) obj7).D(this.t);
        }
    }

    public void m1() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.v.g().removeCallbacks(this.R);
                    this.v.g().post(this.R);
                    x1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(p51 p51Var) {
        if (K0(2)) {
            Log.v("FragmentManager", "attach: " + p51Var);
        }
        if (p51Var.G) {
            p51Var.G = false;
            if (p51Var.q) {
                return;
            }
            this.c.a(p51Var);
            if (K0(2)) {
                Log.v("FragmentManager", "add from attach: " + p51Var);
            }
            if (L0(p51Var)) {
                this.H = true;
            }
        }
    }

    public final void n0() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((ub4) it.next()).m();
        }
    }

    public void n1(p51 p51Var, boolean z) {
        ViewGroup viewGroupU0 = u0(p51Var);
        if (viewGroupU0 == null || !(viewGroupU0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupU0).setDrawDisappearingViewsLast(!z);
    }

    public d71 o() {
        return new pf(this);
    }

    public final Set o0(pf pfVar) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < pfVar.c.size(); i2++) {
            p51 p51Var = ((d71.a) pfVar.c.get(i2)).b;
            if (p51Var != null && pfVar.i) {
                hashSet.add(p51Var);
            }
        }
        return hashSet;
    }

    public final void o1(String str, Bundle bundle) {
        n nVar = (n) this.l.get(str);
        if (nVar == null || !nVar.b(g.b.i)) {
            this.k.put(str, bundle);
        } else {
            nVar.a(str, bundle);
        }
        if (K0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    public boolean p() {
        boolean zL0 = false;
        for (p51 p51Var : this.c.l()) {
            if (p51Var != null) {
                zL0 = L0(p51Var);
            }
            if (zL0) {
                return true;
            }
        }
        return false;
    }

    public final boolean p0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.a) {
            int i2 = 0;
            if (this.a.isEmpty()) {
                return false;
            }
            try {
                int size = this.a.size();
                boolean zA = false;
                while (true) {
                    ArrayList arrayList3 = this.a;
                    if (i2 >= size) {
                        arrayList3.clear();
                        this.v.g().removeCallbacks(this.R);
                        return zA;
                    }
                    zA |= ((o) arrayList3.get(i2)).a(arrayList, arrayList2);
                    i2++;
                }
            } catch (Throwable th) {
                this.a.clear();
                this.v.g().removeCallbacks(this.R);
                throw th;
            }
        }
    }

    public final void p1(String str, bt1 bt1Var, p61 p61Var) {
        androidx.lifecycle.g lifecycle = bt1Var.getLifecycle();
        if (lifecycle.b() == g.b.f) {
            return;
        }
        g gVar = new g(str, p61Var, lifecycle);
        n nVar = (n) this.l.put(str, new n(lifecycle, p61Var, gVar));
        if (nVar != null) {
            nVar.c();
        }
        if (K0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + p61Var);
        }
        lifecycle.a(gVar);
    }

    public final void q() {
        if (R0()) {
            e04.a("Can not perform this action after onSaveInstanceState");
        }
    }

    public int q0() {
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void q1(p51 p51Var, g.b bVar) {
        if (p51Var.equals(g0(p51Var.k)) && (p51Var.z == null || p51Var.y == this)) {
            p51Var.X = bVar;
        } else {
            yo1.a("Fragment ", p51Var, " is not an active fragment of FragmentManager ", this);
        }
    }

    public final void r() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    public final n61 r0(p51 p51Var) {
        return this.P.j(p51Var);
    }

    public void r1(p51 p51Var) {
        if (p51Var != null && (!p51Var.equals(g0(p51Var.k)) || (p51Var.z != null && p51Var.y != this))) {
            yo1.a("Fragment ", p51Var, " is not an active fragment of FragmentManager ", this);
            return;
        }
        p51 p51Var2 = this.y;
        this.y = p51Var;
        M(p51Var2);
        M(this.y);
    }

    public final void s() {
        c61 c61Var = this.v;
        if (c61Var instanceof l45 ? this.c.p().n() : c61Var.f() instanceof Activity ? !((Activity) this.v.f()).isChangingConfigurations() : true) {
            Iterator it = this.j.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((rf) it.next()).f.iterator();
                while (it2.hasNext()) {
                    this.c.p().g((String) it2.next());
                }
            }
        }
    }

    public x51 s0() {
        return this.w;
    }

    public final void s1(p51 p51Var) {
        ViewGroup viewGroupU0 = u0(p51Var);
        if (viewGroupU0 == null || p51Var.V() + p51Var.Y() + p51Var.n0() + p51Var.p0() <= 0) {
            return;
        }
        if (viewGroupU0.getTag(tl3.c) == null) {
            viewGroupU0.setTag(tl3.c, p51Var);
        }
        ((p51) viewGroupU0.getTag(tl3.c)).j2(p51Var.m0());
    }

    public final void t(String str) {
        this.k.remove(str);
        if (K0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public p51 t0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        p51 p51VarG0 = g0(string);
        if (p51VarG0 == null) {
            v1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return p51VarG0;
    }

    public void t1(p51 p51Var) {
        if (K0(2)) {
            Log.v("FragmentManager", "show: " + p51Var);
        }
        if (p51Var.F) {
            p51Var.F = false;
            p51Var.T = !p51Var.T;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        p51 p51Var = this.x;
        if (p51Var != null) {
            sb.append(p51Var.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.x)));
            sb.append("}");
        } else {
            c61 c61Var = this.v;
            if (c61Var != null) {
                sb.append(c61Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final Set u() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((w61) it.next()).k().M;
            if (viewGroup != null) {
                hashSet.add(ub4.q(viewGroup, C0()));
            }
        }
        return hashSet;
    }

    public final ViewGroup u0(p51 p51Var) {
        ViewGroup viewGroup = p51Var.M;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (p51Var.D > 0 && this.w.d()) {
            View viewC = this.w.c(p51Var.D);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    public final void u1() {
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            W0((w61) it.next());
        }
    }

    public final Set v(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((pf) arrayList.get(i2)).c.iterator();
            while (it.hasNext()) {
                p51 p51Var = ((d71.a) it.next()).b;
                if (p51Var != null && (viewGroup = p51Var.M) != null) {
                    hashSet.add(ub4.p(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public a61 v0() {
        a61 a61Var = this.z;
        if (a61Var != null) {
            return a61Var;
        }
        p51 p51Var = this.x;
        return p51Var != null ? p51Var.y.v0() : this.A;
    }

    public final void v1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new c02("FragmentManager"));
        c61 c61Var = this.v;
        if (c61Var != null) {
            try {
                c61Var.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            X("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    public w61 w(p51 p51Var) {
        w61 w61VarN = this.c.n(p51Var.k);
        if (w61VarN != null) {
            return w61VarN;
        }
        w61 w61Var = new w61(this.n, this.c, p51Var);
        w61Var.o(this.v.f().getClassLoader());
        w61Var.t(this.u);
        return w61Var;
    }

    public List w0() {
        return this.c.o();
    }

    public void w1(l lVar) {
        this.n.p(lVar);
    }

    public void x(p51 p51Var) {
        if (K0(2)) {
            Log.v("FragmentManager", "detach: " + p51Var);
        }
        if (p51Var.G) {
            return;
        }
        p51Var.G = true;
        if (p51Var.q) {
            if (K0(2)) {
                Log.v("FragmentManager", "remove from detach: " + p51Var);
            }
            this.c.u(p51Var);
            if (L0(p51Var)) {
                this.H = true;
            }
            s1(p51Var);
        }
    }

    public c61 x0() {
        return this.v;
    }

    public final void x1() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    this.h.j(q0() > 0 && P0(this.x));
                } else {
                    this.h.j(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(4);
    }

    public LayoutInflater.Factory2 y0() {
        return this.f;
    }

    public void z() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(0);
    }

    public e61 z0() {
        return this.n;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();
        public String f;
        public int g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i) {
                return new m[i];
            }
        }

        public m(Parcel parcel) {
            this.f = parcel.readString();
            this.g = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f);
            parcel.writeInt(this.g);
        }

        public m(String str, int i) {
            this.f = str;
            this.g = i;
        }
    }
}
