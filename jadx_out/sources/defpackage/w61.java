package defpackage;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.g;
import defpackage.p51;
import defpackage.ub4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w61 {
    public final e61 a;
    public final z61 b;
    public final p51 c;
    public boolean d = false;
    public int e = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View f;

        public a(View view) {
            this.f = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f.removeOnAttachStateChangeListener(this);
            l35.d0(this.f);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.b.values().length];
            a = iArr;
            try {
                iArr[g.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.b.i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.b.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g.b.g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public w61(e61 e61Var, z61 z61Var, ClassLoader classLoader, a61 a61Var, Bundle bundle) {
        this.a = e61Var;
        this.b = z61Var;
        p51 p51VarC = ((u61) bundle.getParcelable("state")).c(a61Var, classLoader);
        this.c = p51VarC;
        p51VarC.g = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        p51VarC.e2(bundle2);
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + p51VarC);
        }
    }

    public void a() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Bundle bundle = this.c.g;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.c.w1(bundle2);
        this.a.a(this.c, bundle2, false);
    }

    public void b() {
        p51 p51VarM0 = k61.m0(this.c.M);
        p51 p51VarJ0 = this.c.j0();
        if (p51VarM0 != null && !p51VarM0.equals(p51VarJ0)) {
            p51 p51Var = this.c;
            b71.j(p51Var, p51VarM0, p51Var.D);
        }
        int iJ = this.b.j(this.c);
        p51 p51Var2 = this.c;
        p51Var2.M.addView(p51Var2.N, iJ);
    }

    public void c() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        p51 p51Var = this.c;
        p51 p51Var2 = p51Var.m;
        w61 w61VarN = null;
        if (p51Var2 != null) {
            w61 w61VarN2 = this.b.n(p51Var2.k);
            p51 p51Var3 = this.c;
            if (w61VarN2 == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(p51Var3);
                p51 p51Var4 = this.c.m;
                sb.append(" declared target fragment ");
                sb.append(p51Var4);
                sb.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb.toString());
            }
            p51Var3.n = p51Var3.m.k;
            p51Var3.m = null;
            w61VarN = w61VarN2;
        } else {
            String str = p51Var.n;
            if (str != null && (w61VarN = this.b.n(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(this.c);
                String str2 = this.c.n;
                sb2.append(" declared target fragment ");
                sb2.append(str2);
                sb2.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb2.toString());
            }
        }
        if (w61VarN != null) {
            w61VarN.m();
        }
        p51 p51Var5 = this.c;
        p51Var5.z = p51Var5.y.x0();
        p51 p51Var6 = this.c;
        p51Var6.B = p51Var6.y.A0();
        this.a.g(this.c, false);
        this.c.x1();
        this.a.b(this.c, false);
    }

    public int d() {
        p51 p51Var = this.c;
        if (p51Var.y == null) {
            return p51Var.f;
        }
        int iMin = this.e;
        int i = b.a[p51Var.X.ordinal()];
        if (i != 1) {
            iMin = i != 2 ? i != 3 ? i != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        p51 p51Var2 = this.c;
        if (p51Var2.t) {
            boolean z = p51Var2.u;
            int i2 = this.e;
            if (z) {
                iMin = Math.max(i2, 2);
                View view = this.c.N;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = i2 < 4 ? Math.min(iMin, p51Var2.f) : Math.min(iMin, 1);
            }
        }
        if (!this.c.q) {
            iMin = Math.min(iMin, 1);
        }
        p51 p51Var3 = this.c;
        ViewGroup viewGroup = p51Var3.M;
        ub4.c.a aVarN = viewGroup != null ? ub4.p(viewGroup, p51Var3.k0()).n(this) : null;
        if (aVarN == ub4.c.a.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (aVarN == ub4.c.a.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            p51 p51Var4 = this.c;
            if (p51Var4.r) {
                iMin = p51Var4.J0() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        p51 p51Var5 = this.c;
        if (p51Var5.O && p51Var5.f < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (k61.K0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.c);
        }
        return iMin;
    }

    public void e() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Bundle bundle = this.c.g;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        p51 p51Var = this.c;
        if (p51Var.V) {
            p51Var.f = 1;
            p51Var.a2();
        } else {
            this.a.h(p51Var, bundle2, false);
            this.c.A1(bundle2);
            this.a.c(this.c, bundle2, false);
        }
    }

    public void f() {
        String resourceName;
        if (this.c.t) {
            return;
        }
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Bundle bundle = this.c.g;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterG1 = this.c.G1(bundle2);
        p51 p51Var = this.c;
        ViewGroup viewGroup2 = p51Var.M;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = p51Var.D;
            if (i != 0) {
                if (i == -1) {
                    pb1.a("Cannot create fragment ", this.c, " for a container view with no id");
                    return;
                }
                viewGroup = (ViewGroup) p51Var.y.s0().c(this.c.D);
                if (viewGroup == null) {
                    p51 p51Var2 = this.c;
                    if (!p51Var2.v) {
                        try {
                            resourceName = p51Var2.s0().getResourceName(this.c.D);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.D) + " (" + resourceName + ") for fragment " + this.c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    b71.i(this.c, viewGroup);
                }
            }
        }
        p51 p51Var3 = this.c;
        p51Var3.M = viewGroup;
        p51Var3.C1(layoutInflaterG1, viewGroup, bundle2);
        if (this.c.N != null) {
            if (k61.K0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.c);
            }
            this.c.N.setSaveFromParentEnabled(false);
            p51 p51Var4 = this.c;
            p51Var4.N.setTag(tl3.a, p51Var4);
            if (viewGroup != null) {
                b();
            }
            p51 p51Var5 = this.c;
            if (p51Var5.F) {
                p51Var5.N.setVisibility(8);
            }
            boolean zM = l35.M(this.c.N);
            p51 p51Var6 = this.c;
            if (zM) {
                l35.d0(p51Var6.N);
            } else {
                View view = p51Var6.N;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.c.T1();
            e61 e61Var = this.a;
            p51 p51Var7 = this.c;
            e61Var.m(p51Var7, p51Var7.N, bundle2, false);
            int visibility = this.c.N.getVisibility();
            this.c.k2(this.c.N.getAlpha());
            p51 p51Var8 = this.c;
            if (p51Var8.M != null && visibility == 0) {
                View viewFindFocus = p51Var8.N.findFocus();
                if (viewFindFocus != null) {
                    this.c.f2(viewFindFocus);
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.c);
                    }
                }
                this.c.N.setAlpha(0.0f);
            }
        }
        this.c.f = 2;
    }

    public void g() {
        p51 p51VarF;
        if (k61.K0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        p51 p51Var = this.c;
        boolean zIsChangingConfigurations = true;
        boolean z = p51Var.r && !p51Var.J0();
        if (z) {
            p51 p51Var2 = this.c;
            if (!p51Var2.s) {
                this.b.B(p51Var2.k, null);
            }
        }
        if (!z && !this.b.p().q(this.c)) {
            String str = this.c.n;
            if (str != null && (p51VarF = this.b.f(str)) != null && p51VarF.H) {
                this.c.m = p51VarF;
            }
            this.c.f = 0;
            return;
        }
        c61 c61Var = this.c.z;
        if (c61Var instanceof l45) {
            zIsChangingConfigurations = this.b.p().n();
        } else if (c61Var.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) c61Var.f()).isChangingConfigurations();
        }
        if ((z && !this.c.s) || zIsChangingConfigurations) {
            this.b.p().f(this.c);
        }
        this.c.D1();
        this.a.d(this.c, false);
        for (w61 w61Var : this.b.k()) {
            if (w61Var != null) {
                p51 p51VarK = w61Var.k();
                if (this.c.k.equals(p51VarK.n)) {
                    p51VarK.m = this.c;
                    p51VarK.n = null;
                }
            }
        }
        p51 p51Var3 = this.c;
        String str2 = p51Var3.n;
        if (str2 != null) {
            p51Var3.m = this.b.f(str2);
        }
        this.b.s(this);
    }

    public void h() {
        View view;
        if (k61.K0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        p51 p51Var = this.c;
        ViewGroup viewGroup = p51Var.M;
        if (viewGroup != null && (view = p51Var.N) != null) {
            viewGroup.removeView(view);
        }
        this.c.E1();
        this.a.n(this.c, false);
        p51 p51Var2 = this.c;
        p51Var2.M = null;
        p51Var2.N = null;
        p51Var2.Z = null;
        p51Var2.a0.l(null);
        this.c.u = false;
    }

    public void i() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.F1();
        this.a.e(this.c, false);
        p51 p51Var = this.c;
        p51Var.f = -1;
        p51Var.z = null;
        p51Var.B = null;
        p51Var.y = null;
        if ((!p51Var.r || p51Var.J0()) && !this.b.p().q(this.c)) {
            return;
        }
        if (k61.K0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.c);
        }
        this.c.F0();
    }

    public void j() {
        p51 p51Var = this.c;
        if (p51Var.t && p51Var.u && !p51Var.w) {
            if (k61.K0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Bundle bundle = this.c.g;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            p51 p51Var2 = this.c;
            p51Var2.C1(p51Var2.G1(bundle2), null, bundle2);
            View view = this.c.N;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                p51 p51Var3 = this.c;
                p51Var3.N.setTag(tl3.a, p51Var3);
                p51 p51Var4 = this.c;
                if (p51Var4.F) {
                    p51Var4.N.setVisibility(8);
                }
                this.c.T1();
                e61 e61Var = this.a;
                p51 p51Var5 = this.c;
                e61Var.m(p51Var5, p51Var5.N, bundle2, false);
                this.c.f = 2;
            }
        }
    }

    public p51 k() {
        return this.c;
    }

    public final boolean l(View view) {
        if (view == this.c.N) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.N) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z = false;
            while (true) {
                int iD = d();
                p51 p51Var = this.c;
                int i = p51Var.f;
                if (iD == i) {
                    if (!z && i == -1 && p51Var.r && !p51Var.J0() && !this.c.s) {
                        if (k61.K0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.c);
                        }
                        this.b.p().f(this.c);
                        this.b.s(this);
                        if (k61.K0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.c);
                        }
                        this.c.F0();
                    }
                    p51 p51Var2 = this.c;
                    if (p51Var2.T) {
                        if (p51Var2.N != null && (viewGroup = p51Var2.M) != null) {
                            ub4 ub4VarP = ub4.p(viewGroup, p51Var2.k0());
                            if (this.c.F) {
                                ub4VarP.e(this);
                            } else {
                                ub4VarP.g(this);
                            }
                        }
                        p51 p51Var3 = this.c;
                        k61 k61Var = p51Var3.y;
                        if (k61Var != null) {
                            k61Var.I0(p51Var3);
                        }
                        p51 p51Var4 = this.c;
                        p51Var4.T = false;
                        p51Var4.f1(p51Var4.F);
                        this.c.A.J();
                    }
                    this.d = false;
                    return;
                }
                if (iD <= i) {
                    switch (i - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (p51Var.s && this.b.q(p51Var.k) == null) {
                                this.b.B(this.c.k, r());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.c.f = 1;
                            break;
                        case 2:
                            p51Var.u = false;
                            p51Var.f = 2;
                            break;
                        case 3:
                            if (k61.K0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                            }
                            p51 p51Var5 = this.c;
                            if (p51Var5.s) {
                                this.b.B(p51Var5.k, r());
                            } else if (p51Var5.N != null && p51Var5.h == null) {
                                s();
                            }
                            p51 p51Var6 = this.c;
                            if (p51Var6.N != null && (viewGroup2 = p51Var6.M) != null) {
                                ub4.p(viewGroup2, p51Var6.k0()).f(this);
                            }
                            this.c.f = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            p51Var.f = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (p51Var.N != null && (viewGroup3 = p51Var.M) != null) {
                                ub4.p(viewGroup3, p51Var.k0()).d(ub4.c.b.e(this.c.N.getVisibility()), this);
                            }
                            this.c.f = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            p51Var.f = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z = true;
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public void n() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.L1();
        this.a.f(this.c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.c.g;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.c.g.getBundle("savedInstanceState") == null) {
            this.c.g.putBundle("savedInstanceState", new Bundle());
        }
        p51 p51Var = this.c;
        p51Var.h = p51Var.g.getSparseParcelableArray("viewState");
        p51 p51Var2 = this.c;
        p51Var2.i = p51Var2.g.getBundle("viewRegistryState");
        u61 u61Var = (u61) this.c.g.getParcelable("state");
        if (u61Var != null) {
            p51 p51Var3 = this.c;
            p51Var3.n = u61Var.q;
            p51Var3.o = u61Var.r;
            Boolean bool = p51Var3.j;
            if (bool != null) {
                p51Var3.P = bool.booleanValue();
                this.c.j = null;
            } else {
                p51Var3.P = u61Var.s;
            }
        }
        p51 p51Var4 = this.c;
        if (p51Var4.P) {
            return;
        }
        p51Var4.O = true;
    }

    public void p() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View viewC0 = this.c.c0();
        if (viewC0 != null && l(viewC0)) {
            boolean zRequestFocus = viewC0.requestFocus();
            if (k61.K0(2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(viewC0);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.N.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.f2(null);
        this.c.P1();
        this.a.i(this.c, false);
        this.b.B(this.c.k, null);
        p51 p51Var = this.c;
        p51Var.g = null;
        p51Var.h = null;
        p51Var.i = null;
    }

    public p51.n q() {
        if (this.c.f > -1) {
            return new p51.n(r());
        }
        return null;
    }

    public Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        p51 p51Var = this.c;
        if (p51Var.f == -1 && (bundle = p51Var.g) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new u61(this.c));
        if (this.c.f > -1) {
            Bundle bundle3 = new Bundle();
            this.c.Q1(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.j(this.c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.c.c0.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleK1 = this.c.A.k1();
            if (!bundleK1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleK1);
            }
            if (this.c.N != null) {
                s();
            }
            SparseArray<? extends Parcelable> sparseArray = this.c.h;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.c.i;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.c.l;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void s() {
        if (this.c.N == null) {
            return;
        }
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.c + " with view " + this.c.N);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.c.N.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.c.h = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.c.Z.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.c.i = bundle;
    }

    public void t(int i) {
        this.e = i;
    }

    public void u() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.R1();
        this.a.k(this.c, false);
    }

    public void v() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.S1();
        this.a.l(this.c, false);
    }

    public w61(e61 e61Var, z61 z61Var, p51 p51Var) {
        this.a = e61Var;
        this.b = z61Var;
        this.c = p51Var;
    }

    public w61(e61 e61Var, z61 z61Var, p51 p51Var, Bundle bundle) {
        this.a = e61Var;
        this.b = z61Var;
        this.c = p51Var;
        p51Var.h = null;
        p51Var.i = null;
        p51Var.x = 0;
        p51Var.u = false;
        p51Var.q = false;
        p51 p51Var2 = p51Var.m;
        p51Var.n = p51Var2 != null ? p51Var2.k : null;
        p51Var.m = null;
        p51Var.g = bundle;
        p51Var.l = bundle.getBundle("arguments");
    }
}
