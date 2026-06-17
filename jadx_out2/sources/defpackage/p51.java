package defpackage;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.g;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p51 implements ComponentCallbacks, View.OnCreateContextMenuListener, bt1, l45, androidx.lifecycle.e, vx3 {
    public static final Object h0 = new Object();
    public p51 B;
    public int C;
    public int D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean L;
    public ViewGroup M;
    public View N;
    public boolean O;
    public j Q;
    public Handler R;
    public boolean T;
    public LayoutInflater U;
    public boolean V;
    public String W;
    public androidx.lifecycle.j Y;
    public l71 Z;
    public x.c b0;
    public sx3 c0;
    public int d0;
    public Bundle g;
    public SparseArray h;
    public Bundle i;
    public Boolean j;
    public Bundle l;
    public p51 m;
    public int o;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public k61 y;
    public c61 z;
    public int f = -1;
    public String k = UUID.randomUUID().toString();
    public String n = null;
    public Boolean p = null;
    public k61 A = new l61();
    public boolean K = true;
    public boolean P = true;
    public Runnable S = new b();
    public g.b X = g.b.j;
    public nw2 a0 = new nw2();
    public final AtomicInteger e0 = new AtomicInteger();
    public final ArrayList f0 = new ArrayList();
    public final m g0 = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends q3 {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ m3 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(AtomicReference atomicReference, m3 m3Var) {
            this.a = atomicReference;
            this.b = m3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q3
        public void b(Object obj, i3 i3Var) {
            q3 q3Var = (q3) this.a.get();
            if (q3Var != null) {
                q3Var.b(obj, i3Var);
            } else {
                e04.a("Operation cannot be started before fragment is in created state");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q3
        public void c() {
            q3 q3Var = (q3) this.a.getAndSet(null);
            if (q3Var != null) {
                q3Var.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            p51.this.s2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends m {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
            super(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // p51.m
        public void a() {
            p51.this.c0.c();
            t.c(p51.this);
            Bundle bundle = p51.this.g;
            p51.this.c0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            p51.this.G(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements Runnable {
        public final /* synthetic */ ub4 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(ub4 ub4Var) {
            this.f = ub4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            this.f.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends x51 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.x51
        public View c(int i) {
            View view = p51.this.N;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + p51.this + " does not have a view");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.x51
        public boolean d() {
            return p51.this.N != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements androidx.lifecycle.i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            View view;
            if (aVar != g.a.ON_STOP || (view = p51.this.N) == null) {
                return;
            }
            k.a(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements r81 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: apply(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // defpackage.r81
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r3 apply(Void r2) {
            p51 p51Var = p51.this;
            Object obj = p51Var.z;
            return obj instanceof s3 ? ((s3) obj).W() : p51Var.X1().W();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i extends m {
        public final /* synthetic */ r81 a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ m3 c;
        public final /* synthetic */ l3 d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(r81 r81Var, AtomicReference atomicReference, m3 m3Var, l3 l3Var) {
            super(null);
            this.a = r81Var;
            this.b = atomicReference;
            this.c = m3Var;
            this.d = l3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // p51.m
        public void a() {
            String strN = p51.this.N();
            this.b.set(((r3) this.a.apply(null)).j(strN, p51.this, this.c, this.d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j {
        public View a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public ArrayList h;
        public ArrayList i;
        public Object j = null;
        public Object k;
        public Object l;
        public Object m;
        public Object n;
        public Object o;
        public Boolean p;
        public Boolean q;
        public float r;
        public View s;
        public boolean t;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j() {
            Object obj = p51.h0;
            this.k = obj;
            this.l = null;
            this.m = obj;
            this.n = null;
            this.o = obj;
            this.r = 1.0f;
            this.s = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l extends RuntimeException {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public l(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p51() {
        E0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void F(p51 p51Var) {
        p51Var.Z.d(p51Var.i);
        p51Var.i = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static p51 G0(Context context, String str, Bundle bundle) {
        try {
            p51 p51Var = (p51) a61.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return p51Var;
            }
            bundle.setClassLoader(p51Var.getClass().getClassLoader());
            p51Var.e2(bundle);
            return p51Var;
        } catch (IllegalAccessException e2) {
            n51.a(str, ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            return null;
        } catch (InstantiationException e3) {
            n51.a(str, ": make sure class name exists, is public, and has an empty constructor that is public", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            n51.a(str, ": could not find Fragment constructor", e4);
            return null;
        } catch (InvocationTargetException e5) {
            n51.a(str, ": calling Fragment constructor caused an exception", e5);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean A0() {
        return this.P;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A1(Bundle bundle) {
        this.A.U0();
        this.f = 1;
        this.L = false;
        this.Y.a(new g());
        V0(bundle);
        this.V = true;
        if (this.L) {
            this.Y.h(g.a.ON_CREATE);
        } else {
            m51.a(this, " did not call through to super.onCreate()");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View B0() {
        return this.N;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B1(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.F) {
            return false;
        }
        if (this.J && this.K) {
            Y0(menu, menuInflater);
            z = true;
        }
        return this.A.D(menu, menuInflater) | z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bt1 C0() {
        l71 l71Var = this.Z;
        if (l71Var != null) {
            return l71Var;
        }
        wx1.a("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.A.U0();
        this.w = true;
        this.Z = new l71(this, d0(), new Runnable() { // from class: o51
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                p51.F(this.f);
            }
        });
        View viewZ0 = Z0(layoutInflater, viewGroup, bundle);
        this.N = viewZ0;
        l71 l71Var = this.Z;
        if (viewZ0 == null) {
            if (l71Var.c()) {
                e04.a("Called getViewLifecycleOwner() but onCreateView() returned null");
                return;
            } else {
                this.Z = null;
                return;
            }
        }
        l71Var.b();
        if (k61.K0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.N + " for Fragment " + this);
        }
        a55.a(this.N, this.Z);
        d55.a(this.N, this.Z);
        c55.a(this.N, this.Z);
        this.a0.l(this.Z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public androidx.lifecycle.l D0() {
        return this.a0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D1() {
        this.A.E();
        this.Y.h(g.a.ON_DESTROY);
        this.f = 0;
        this.L = false;
        this.V = false;
        a1();
        if (this.L) {
            return;
        }
        m51.a(this, " did not call through to super.onDestroy()");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E0() {
        this.Y = new androidx.lifecycle.j(this);
        this.c0 = sx3.a(this);
        this.b0 = null;
        if (this.f0.contains(this.g0)) {
            return;
        }
        W1(this.g0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E1() {
        this.A.F();
        if (this.N != null && this.Z.getLifecycle().b().b(g.b.h)) {
            this.Z.a(g.a.ON_DESTROY);
        }
        this.f = 1;
        this.L = false;
        c1();
        if (!this.L) {
            m51.a(this, " did not call through to super.onDestroyView()");
        } else {
            cz1.b(this).c();
            this.w = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F0() {
        E0();
        this.W = this.k;
        this.k = UUID.randomUUID().toString();
        this.q = false;
        this.r = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = 0;
        this.y = null;
        this.A = new l61();
        this.z = null;
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.F = false;
        this.G = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F1() {
        this.f = -1;
        this.L = false;
        d1();
        this.U = null;
        if (!this.L) {
            m51.a(this, " did not call through to super.onDetach()");
        } else {
            if (this.A.J0()) {
                return;
            }
            this.A.E();
            this.A = new l61();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(boolean z) {
        ViewGroup viewGroup;
        k61 k61Var;
        j jVar = this.Q;
        if (jVar != null) {
            jVar.t = false;
        }
        if (this.N == null || (viewGroup = this.M) == null || (k61Var = this.y) == null) {
            return;
        }
        ub4 ub4VarP = ub4.p(viewGroup, k61Var);
        ub4VarP.r();
        if (z) {
            this.z.g().post(new e(ub4VarP));
        } else {
            ub4VarP.i();
        }
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacks(this.S);
            this.R = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LayoutInflater G1(Bundle bundle) {
        LayoutInflater layoutInflaterE1 = e1(bundle);
        this.U = layoutInflaterE1;
        return layoutInflaterE1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x51 H() {
        return new f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H0() {
        return this.z != null && this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H1() {
        onLowMemory();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.C));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.D));
        printWriter.print(" mTag=");
        printWriter.println(this.E);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.k);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.q);
        printWriter.print(" mRemoving=");
        printWriter.print(this.r);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.t);
        printWriter.print(" mInLayout=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.F);
        printWriter.print(" mDetached=");
        printWriter.print(this.G);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.K);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.H);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.P);
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.y);
        }
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.z);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.B);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.l);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.g);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.h);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.i);
        }
        p51 p51VarZ0 = z0(false);
        if (p51VarZ0 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(p51VarZ0);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(m0());
        if (V() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(V());
        }
        if (Y() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(Y());
        }
        if (n0() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(n0());
        }
        if (p0() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(p0());
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.M);
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.N);
        }
        if (R() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(R());
        }
        if (U() != null) {
            cz1.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.A + ":");
        this.A.X(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I0() {
        if (this.F) {
            return true;
        }
        k61 k61Var = this.y;
        return k61Var != null && k61Var.N0(this.B);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I1(boolean z) {
        i1(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final j J() {
        if (this.Q == null) {
            this.Q = new j();
        }
        return this.Q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J0() {
        return this.x > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean J1(MenuItem menuItem) {
        if (this.F) {
            return false;
        }
        if (this.J && this.K && j1(menuItem)) {
            return true;
        }
        return this.A.K(menuItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p51 K(String str) {
        return str.equals(this.k) ? this : this.A.k0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean K0() {
        if (!this.K) {
            return false;
        }
        k61 k61Var = this.y;
        return k61Var == null || k61Var.O0(this.B);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K1(Menu menu) {
        if (this.F) {
            return;
        }
        if (this.J && this.K) {
            k1(menu);
        }
        this.A.L(menu);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.e
    public x.c L() {
        Application application = null;
        if (this.y == null) {
            e04.a("Can't access ViewModels from detached fragment");
            return null;
        }
        if (this.b0 == null) {
            Context applicationContext = Y1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && k61.K0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + Y1().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.b0 = new u(application, this, S());
        }
        return this.b0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L0() {
        j jVar = this.Q;
        if (jVar == null) {
            return false;
        }
        return jVar.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L1() {
        this.A.N();
        if (this.N != null) {
            this.Z.a(g.a.ON_PAUSE);
        }
        this.Y.h(g.a.ON_PAUSE);
        this.f = 6;
        this.L = false;
        l1();
        if (this.L) {
            return;
        }
        m51.a(this, " did not call through to super.onPause()");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.e
    public d50 M() {
        Application application;
        Context applicationContext = Y1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && k61.K0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + Y1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        mw2 mw2Var = new mw2();
        if (application != null) {
            mw2Var.c(x.a.h, application);
        }
        mw2Var.c(t.a, this);
        mw2Var.c(t.b, this);
        if (S() != null) {
            mw2Var.c(t.c, S());
        }
        return mw2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M0() {
        k61 k61Var = this.y;
        if (k61Var == null) {
            return false;
        }
        return k61Var.R0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M1(boolean z) {
        m1(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String N() {
        return "fragment_" + this.k + "_rq#" + this.e0.getAndIncrement();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean N0() {
        View view;
        return (!H0() || I0() || (view = this.N) == null || view.getWindowToken() == null || this.N.getVisibility() != 0) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean N1(Menu menu) {
        boolean z = false;
        if (this.F) {
            return false;
        }
        if (this.J && this.K) {
            n1(menu);
            z = true;
        }
        return this.A.P(menu) | z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final u51 O() {
        c61 c61Var = this.z;
        if (c61Var == null) {
            return null;
        }
        return (u51) c61Var.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O0() {
        this.A.U0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O1() {
        boolean zP0 = this.y.P0(this);
        Boolean bool = this.p;
        if (bool == null || bool.booleanValue() != zP0) {
            this.p = Boolean.valueOf(zP0);
            o1(zP0);
            this.A.Q();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean P() {
        Boolean bool;
        j jVar = this.Q;
        if (jVar == null || (bool = jVar.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P0(Bundle bundle) {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P1() {
        this.A.U0();
        this.A.b0(true);
        this.f = 7;
        this.L = false;
        q1();
        if (!this.L) {
            m51.a(this, " did not call through to super.onResume()");
            return;
        }
        androidx.lifecycle.j jVar = this.Y;
        g.a aVar = g.a.ON_RESUME;
        jVar.h(aVar);
        if (this.N != null) {
            this.Z.a(aVar);
        }
        this.A.R();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Q() {
        Boolean bool;
        j jVar = this.Q;
        if (jVar == null || (bool = jVar.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q0(int i2, int i3, Intent intent) {
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q1(Bundle bundle) {
        r1(bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View R() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        return jVar.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R0(Activity activity) {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R1() {
        this.A.U0();
        this.A.b0(true);
        this.f = 5;
        this.L = false;
        s1();
        if (!this.L) {
            m51.a(this, " did not call through to super.onStart()");
            return;
        }
        androidx.lifecycle.j jVar = this.Y;
        g.a aVar = g.a.ON_START;
        jVar.h(aVar);
        if (this.N != null) {
            this.Z.a(aVar);
        }
        this.A.S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bundle S() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S0(Context context) {
        this.L = true;
        c61 c61Var = this.z;
        Activity activityE = c61Var == null ? null : c61Var.e();
        if (activityE != null) {
            this.L = false;
            R0(activityE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S1() {
        this.A.U();
        if (this.N != null) {
            this.Z.a(g.a.ON_STOP);
        }
        this.Y.h(g.a.ON_STOP);
        this.f = 4;
        this.L = false;
        t1();
        if (this.L) {
            return;
        }
        m51.a(this, " did not call through to super.onStop()");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final k61 T() {
        if (this.z != null) {
            return this.A;
        }
        wx1.a("Fragment ", this, " has not been attached yet.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T0(p51 p51Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T1() {
        Bundle bundle = this.g;
        u1(this.N, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.A.V();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Context U() {
        c61 c61Var = this.z;
        if (c61Var == null) {
            return null;
        }
        return c61Var.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean U0(MenuItem menuItem) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final q3 U1(m3 m3Var, r81 r81Var, l3 l3Var) {
        if (this.f > 1) {
            wx1.a("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
            return null;
        }
        AtomicReference atomicReference = new AtomicReference();
        W1(new i(r81Var, atomicReference, m3Var, l3Var));
        return new a(atomicReference, m3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int V() {
        j jVar = this.Q;
        if (jVar == null) {
            return 0;
        }
        return jVar.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V0(Bundle bundle) {
        this.L = true;
        a2();
        if (this.A.Q0(1)) {
            return;
        }
        this.A.C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final q3 V1(m3 m3Var, l3 l3Var) {
        return U1(m3Var, new h(), l3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object W() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        return jVar.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Animation W0(int i2, boolean z, int i3) {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W1(m mVar) {
        if (this.f >= 0) {
            mVar.a();
        } else {
            this.f0.add(mVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t54 X() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        jVar.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Animator X0(int i2, boolean z, int i3) {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final u51 X1() {
        u51 u51VarO = O();
        if (u51VarO != null) {
            return u51VarO;
        }
        wx1.a("Fragment ", this, " not attached to an activity.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int Y() {
        j jVar = this.Q;
        if (jVar == null) {
            return 0;
        }
        return jVar.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Context Y1() {
        Context contextU = U();
        if (contextU != null) {
            return contextU;
        }
        wx1.a("Fragment ", this, " not attached to a context.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object Z() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        return jVar.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View Z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.d0;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View Z1() {
        View viewB0 = B0();
        if (viewB0 != null) {
            return viewB0;
        }
        wx1.a("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView().");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t54 a0() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        jVar.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a2() {
        Bundle bundle;
        Bundle bundle2 = this.g;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.A.i1(bundle);
        this.A.C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b1() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b2() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.N != null) {
            Bundle bundle = this.g;
            c2(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.g = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View c0() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        return jVar.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c2(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.h;
        if (sparseArray != null) {
            this.N.restoreHierarchyState(sparseArray);
            this.h = null;
        }
        this.L = false;
        v1(bundle);
        if (!this.L) {
            m51.a(this, " did not call through to super.onViewStateRestored()");
        } else if (this.N != null) {
            this.Z.a(g.a.ON_CREATE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l45
    public k45 d0() {
        if (this.y == null) {
            e04.a("Can't access ViewModels from detached fragment");
            return null;
        }
        if (h0() != g.b.g.ordinal()) {
            return this.y.F0(this);
        }
        e04.a("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d2(int i2, int i3, int i4, int i5) {
        if (this.Q == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        J().c = i2;
        J().d = i3;
        J().e = i4;
        J().f = i5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object e0() {
        c61 c61Var = this.z;
        if (c61Var == null) {
            return null;
        }
        return c61Var.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LayoutInflater e1(Bundle bundle) {
        return g0(bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e2(Bundle bundle) {
        if (this.y == null || !M0()) {
            this.l = bundle;
        } else {
            e04.a("Fragment already added and state has been saved");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        return this == obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final LayoutInflater f0() {
        LayoutInflater layoutInflater = this.U;
        return layoutInflater == null ? G1(null) : layoutInflater;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f1(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f2(View view) {
        J().s = view;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LayoutInflater g0(Bundle bundle) {
        c61 c61Var = this.z;
        if (c61Var == null) {
            e04.a("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
            return null;
        }
        LayoutInflater layoutInflaterJ = c61Var.j();
        bs1.a(layoutInflaterJ, this.A.y0());
        return layoutInflaterJ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g1(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g2(n nVar) {
        Bundle bundle;
        if (this.y != null) {
            e04.a("Fragment already added");
            return;
        }
        if (nVar == null || (bundle = nVar.f) == null) {
            bundle = null;
        }
        this.g = bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bt1
    public androidx.lifecycle.g getLifecycle() {
        return this.Y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int h0() {
        g.b bVar = this.X;
        return (bVar == g.b.g || this.B == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.B.h0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h1(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
        c61 c61Var = this.z;
        Activity activityE = c61Var == null ? null : c61Var.e();
        if (activityE != null) {
            this.L = false;
            g1(activityE, attributeSet, bundle);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h2(boolean z) {
        if (this.K != z) {
            this.K = z;
            if (this.J && H0() && !I0()) {
                this.z.m();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i0() {
        j jVar = this.Q;
        if (jVar == null) {
            return 0;
        }
        return jVar.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i1(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i2(int i2) {
        if (this.Q == null && i2 == 0) {
            return;
        }
        J();
        this.Q.g = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p51 j0() {
        return this.B;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j1(MenuItem menuItem) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j2(boolean z) {
        if (this.Q == null) {
            return;
        }
        J().b = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final k61 k0() {
        k61 k61Var = this.y;
        if (k61Var != null) {
            return k61Var;
        }
        wx1.a("Fragment ", this, " not associated with a fragment manager.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k1(Menu menu) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k2(float f2) {
        J().r = f2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vx3
    public final qx3 l0() {
        return this.c0.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l2(ArrayList arrayList, ArrayList arrayList2) {
        J();
        j jVar = this.Q;
        jVar.h = arrayList;
        jVar.i = arrayList2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean m0() {
        j jVar = this.Q;
        if (jVar == null) {
            return false;
        }
        return jVar.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m1(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m2(boolean z) {
        b71.h(this, z);
        if (!this.P && z && this.f < 5 && this.y != null && H0() && this.V) {
            k61 k61Var = this.y;
            k61Var.W0(k61Var.w(this));
        }
        this.P = z;
        this.O = this.f < 5 && !z;
        if (this.g != null) {
            this.j = Boolean.valueOf(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n0() {
        j jVar = this.Q;
        if (jVar == null) {
            return 0;
        }
        return jVar.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n1(Menu menu) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean n2(String str) {
        c61 c61Var = this.z;
        if (c61Var != null) {
            return c61Var.k(str);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o1(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o2(Intent intent) {
        p2(intent, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        X1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p0() {
        j jVar = this.Q;
        if (jVar == null) {
            return 0;
        }
        return jVar.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p1(int i2, String[] strArr, int[] iArr) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p2(Intent intent, Bundle bundle) {
        c61 c61Var = this.z;
        if (c61Var != null) {
            c61Var.l(this, intent, -1, bundle);
        } else {
            wx1.a("Fragment ", this, " not attached to Activity");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float q0() {
        j jVar = this.Q;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q2(Intent intent, int i2) {
        r2(intent, i2, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object r0() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.m;
        return obj == h0 ? Z() : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r1(Bundle bundle) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r2(Intent intent, int i2, Bundle bundle) {
        if (this.z != null) {
            k0().S0(this, intent, i2, bundle);
        } else {
            wx1.a("Fragment ", this, " not attached to Activity");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Resources s0() {
        return Y1().getResources();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s2() {
        if (this.Q == null || !J().t) {
            return;
        }
        if (this.z == null) {
            J().t = false;
        } else if (Looper.myLooper() != this.z.g().getLooper()) {
            this.z.g().postAtFrontOfQueue(new d());
        } else {
            G(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object t0() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.k;
        return obj == h0 ? W() : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t1() {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.k);
        if (this.C != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.C));
        }
        if (this.E != null) {
            sb.append(" tag=");
            sb.append(this.E);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object u0() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        return jVar.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u1(View view, Bundle bundle) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object v0() {
        j jVar = this.Q;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.o;
        return obj == h0 ? u0() : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v1(Bundle bundle) {
        this.L = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ArrayList w0() {
        ArrayList arrayList;
        j jVar = this.Q;
        return (jVar == null || (arrayList = jVar.h) == null) ? new ArrayList() : arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w1(Bundle bundle) {
        this.A.U0();
        this.f = 3;
        this.L = false;
        P0(bundle);
        if (!this.L) {
            m51.a(this, " did not call through to super.onActivityCreated()");
        } else {
            b2();
            this.A.y();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ArrayList x0() {
        ArrayList arrayList;
        j jVar = this.Q;
        return (jVar == null || (arrayList = jVar.i) == null) ? new ArrayList() : arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x1() {
        Iterator it = this.f0.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a();
        }
        this.f0.clear();
        this.A.m(this.z, H(), this);
        this.f = 0;
        this.L = false;
        S0(this.z.f());
        if (!this.L) {
            m51.a(this, " did not call through to super.onAttach()");
        } else {
            this.y.I(this);
            this.A.z();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String y0(int i2) {
        return s0().getString(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y1(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p51 z0(boolean z) {
        String str;
        if (z) {
            b71.g(this);
        }
        p51 p51Var = this.m;
        if (p51Var != null) {
            return p51Var;
        }
        k61 k61Var = this.y;
        if (k61Var == null || (str = this.n) == null) {
            return null;
        }
        return k61Var.g0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean z1(MenuItem menuItem) {
        if (this.F) {
            return false;
        }
        if (U0(menuItem)) {
            return true;
        }
        return this.A.B(menuItem);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class m {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public m() {
        }

        public abstract void a();

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:5) call: p51.m.<init>():void type: THIS */
        public /* synthetic */ m(b bVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class n implements Parcelable {
        public static final Parcelable.Creator<n> CREATOR = new a();
        public final Bundle f;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return new n(parcel, null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i) {
                return new n[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public n(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f);
        }

        public n(Bundle bundle) {
            this.f = bundle;
        }
    }
}
