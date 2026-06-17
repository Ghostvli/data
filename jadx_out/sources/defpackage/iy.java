package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.g;
import androidx.lifecycle.p;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.x;
import defpackage.iy;
import defpackage.m3;
import defpackage.qx3;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class iy extends ky implements bt1, l45, androidx.lifecycle.e, vx3, h63, s3, i63, o63, k63, l63, vr2, o81 {
    public final b30 h = new b30();
    public final xr2 i = new xr2(new Runnable() { // from class: ey
        @Override // java.lang.Runnable
        public final void run() {
            this.f.g1();
        }
    });
    public final androidx.lifecycle.j j = new androidx.lifecycle.j(this);
    public final sx3 k;
    public k45 l;
    public x.c m;
    public f63 n;
    public final j o;
    public final n81 p;
    public int q;
    public final AtomicInteger r;
    public final r3 s;
    public final CopyOnWriteArrayList t;
    public final CopyOnWriteArrayList u;
    public final CopyOnWriteArrayList v;
    public final CopyOnWriteArrayList w;
    public final CopyOnWriteArrayList x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends r3 {

        /* JADX INFO: renamed from: iy$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class RunnableC0084a implements Runnable {
            public final /* synthetic */ int f;
            public final /* synthetic */ m3.a g;

            public RunnableC0084a(int i, m3.a aVar) {
                this.f = i;
                this.g = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f, this.g.a());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b implements Runnable {
            public final /* synthetic */ int f;
            public final /* synthetic */ IntentSender.SendIntentException g;

            public b(int i, IntentSender.SendIntentException sendIntentException) {
                this.f = i;
                this.g = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.g));
            }
        }

        public a() {
        }

        @Override // defpackage.r3
        public void f(int i, m3 m3Var, Object obj, i3 i3Var) {
            Bundle bundleExtra;
            int i2;
            iy iyVar = iy.this;
            m3.a aVarB = m3Var.b(iyVar, obj);
            if (aVarB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0084a(i, aVarB));
                return;
            }
            Intent intentA = m3Var.a(iyVar, obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(iyVar.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleExtra = null;
            }
            Bundle bundle = bundleExtra;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                a3.p(iyVar, stringArrayExtra, i);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                a3.r(iyVar, intentA, i, bundle);
                return;
            }
            yk1 yk1Var = (yk1) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i2 = i;
            } catch (IntentSender.SendIntentException e) {
                e = e;
                i2 = i;
            }
            try {
                a3.s(iyVar, yk1Var.u(), i2, yk1Var.c(), yk1Var.d(), yk1Var.s(), 0, bundle);
            } catch (IntentSender.SendIntentException e2) {
                e = e2;
                new Handler(Looper.getMainLooper()).post(new b(i2, e));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements androidx.lifecycle.i {
        public b() {
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            if (aVar == g.a.ON_STOP) {
                Window window = iy.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    g.a(viewPeekDecorView);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements androidx.lifecycle.i {
        public c() {
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            if (aVar == g.a.ON_DESTROY) {
                iy.this.h.b();
                if (!iy.this.isChangingConfigurations()) {
                    iy.this.d0().a();
                }
                iy.this.o.i();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements androidx.lifecycle.i {
        public d() {
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            iy.this.e1();
            iy.this.getLifecycle().c(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                iy.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            } catch (NullPointerException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements androidx.lifecycle.i {
        public f() {
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            if (aVar != g.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            iy.this.n.n(h.a((iy) bt1Var));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i {
        public Object a;
        public k45 b;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface j extends Executor {
        void K(View view);

        void i();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class k implements j, ViewTreeObserver.OnDrawListener, Runnable {
        public Runnable g;
        public final long f = SystemClock.uptimeMillis() + 10000;
        public boolean h = false;

        public k() {
        }

        public static /* synthetic */ void a(k kVar) {
            Runnable runnable = kVar.g;
            if (runnable != null) {
                runnable.run();
                kVar.g = null;
            }
        }

        @Override // iy.j
        public void K(View view) {
            if (this.h) {
                return;
            }
            this.h = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.g = runnable;
            View decorView = iy.this.getWindow().getDecorView();
            if (!this.h) {
                decorView.postOnAnimation(new Runnable() { // from class: jy
                    @Override // java.lang.Runnable
                    public final void run() {
                        iy.k.a(this.f);
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // iy.j
        public void i() {
            iy.this.getWindow().getDecorView().removeCallbacks(this);
            iy.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.g;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f) {
                    this.h = false;
                    iy.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.g = null;
            if (iy.this.p.c()) {
                this.h = false;
                iy.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            iy.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public iy() {
        sx3 sx3VarA = sx3.a(this);
        this.k = sx3VarA;
        this.n = null;
        j jVarD1 = d1();
        this.o = jVarD1;
        this.p = new n81(jVarD1, new Function0() { // from class: fy
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return iy.X0(this.f);
            }
        });
        this.r = new AtomicInteger();
        this.s = new a();
        this.t = new CopyOnWriteArrayList();
        this.u = new CopyOnWriteArrayList();
        this.v = new CopyOnWriteArrayList();
        this.w = new CopyOnWriteArrayList();
        this.x = new CopyOnWriteArrayList();
        this.y = false;
        this.z = false;
        if (getLifecycle() == null) {
            e04.a("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
            throw null;
        }
        getLifecycle().a(new b());
        getLifecycle().a(new c());
        getLifecycle().a(new d());
        sx3VarA.c();
        t.c(this);
        l0().c("android:support:activity-result", new qx3.b() { // from class: gy
            @Override // qx3.b
            public final Bundle a() {
                return iy.W0(this.a);
            }
        });
        b1(new j63() { // from class: hy
            @Override // defpackage.j63
            public final void a(Context context) {
                iy.V0(this.a, context);
            }
        });
    }

    public static /* synthetic */ void V0(iy iyVar, Context context) {
        Bundle bundleA = iyVar.l0().a("android:support:activity-result");
        if (bundleA != null) {
            iyVar.s.g(bundleA);
        }
    }

    public static /* synthetic */ Bundle W0(iy iyVar) {
        iyVar.getClass();
        Bundle bundle = new Bundle();
        iyVar.s.h(bundle);
        return bundle;
    }

    public static /* synthetic */ fw4 X0(iy iyVar) {
        iyVar.reportFullyDrawn();
        return null;
    }

    @Override // defpackage.vr2
    public void D(ds2 ds2Var) {
        this.i.b(ds2Var);
    }

    @Override // defpackage.l63
    public final void K0(h20 h20Var) {
        this.x.remove(h20Var);
    }

    @Override // androidx.lifecycle.e
    public x.c L() {
        if (this.m == null) {
            this.m = new u(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.m;
    }

    @Override // defpackage.k63
    public final void L0(h20 h20Var) {
        this.w.remove(h20Var);
    }

    @Override // androidx.lifecycle.e
    public d50 M() {
        mw2 mw2Var = new mw2();
        if (getApplication() != null) {
            mw2Var.c(x.a.h, getApplication());
        }
        mw2Var.c(t.a, this);
        mw2Var.c(t.b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mw2Var.c(t.c, getIntent().getExtras());
        }
        return mw2Var;
    }

    @Override // defpackage.l63
    public final void N(h20 h20Var) {
        this.x.add(h20Var);
    }

    @Override // defpackage.k63
    public final void O(h20 h20Var) {
        this.w.add(h20Var);
    }

    @Override // defpackage.o63
    public final void T(h20 h20Var) {
        this.u.add(h20Var);
    }

    @Override // defpackage.s3
    public final r3 W() {
        return this.s;
    }

    @Override // defpackage.o63
    public final void Y(h20 h20Var) {
        this.u.remove(h20Var);
    }

    public void a1(ds2 ds2Var, bt1 bt1Var, g.b bVar) {
        this.i.c(ds2Var, bt1Var, bVar);
    }

    public final void b1(j63 j63Var) {
        this.h.a(j63Var);
    }

    public final void c1(h20 h20Var) {
        this.v.add(h20Var);
    }

    @Override // defpackage.l45
    public k45 d0() {
        if (getApplication() != null) {
            e1();
            return this.l;
        }
        e04.a("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        return null;
    }

    public final j d1() {
        return new k();
    }

    public void e1() {
        if (this.l == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.l = iVar.b;
            }
            if (this.l == null) {
                this.l = new k45();
            }
        }
    }

    public void f1() {
        a55.a(getWindow().getDecorView(), this);
        d55.a(getWindow().getDecorView(), this);
        c55.a(getWindow().getDecorView(), this);
        b55.a(getWindow().getDecorView(), this);
        z45.a(getWindow().getDecorView(), this);
    }

    public void g1() {
        invalidateOptionsMenu();
    }

    @Override // defpackage.bt1
    public androidx.lifecycle.g getLifecycle() {
        return this.j;
    }

    public Object h1() {
        return null;
    }

    @Override // defpackage.vx3
    public final qx3 l0() {
        return this.k.b();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.s.b(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        y().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            ((h20) it.next()).accept(configuration);
        }
    }

    @Override // defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.k.d(bundle);
        this.h.c(this);
        super.onCreate(bundle);
        p.e(this);
        int i2 = this.q;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        this.i.d(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.i.f(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.y = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.y = false;
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                ((h20) it.next()).accept(new cw2(z, configuration));
            }
        } catch (Throwable th) {
            this.y = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            ((h20) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        this.i.e(menu);
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.z = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.z = false;
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                ((h20) it.next()).accept(new db3(z, configuration));
            }
        } catch (Throwable th) {
            this.z = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        this.i.g(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.s.b(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objH1 = h1();
        k45 k45Var = this.l;
        if (k45Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            k45Var = iVar.b;
        }
        if (k45Var == null && objH1 == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.a = objH1;
        iVar2.b = k45Var;
        return iVar2;
    }

    @Override // defpackage.ky, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.g lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.j) {
            ((androidx.lifecycle.j) lifecycle).m(g.b.h);
        }
        super.onSaveInstanceState(bundle);
        this.k.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            ((h20) it.next()).accept(Integer.valueOf(i2));
        }
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (dq4.d()) {
                dq4.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.p.b();
        } finally {
            dq4.b();
        }
    }

    @Override // defpackage.vr2
    public void s0(ds2 ds2Var) {
        this.i.h(ds2Var);
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i2);

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        f1();
        this.o.K(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // defpackage.i63
    public final void t0(h20 h20Var) {
        this.t.add(h20Var);
    }

    @Override // defpackage.i63
    public final void x0(h20 h20Var) {
        this.t.remove(h20Var);
    }

    @Override // defpackage.h63
    public final f63 y() {
        if (this.n == null) {
            this.n = new f63(new e());
            getLifecycle().a(new f());
        }
        return this.n;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.y) {
            return;
        }
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            ((h20) it.next()).accept(new cw2(z));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.z) {
            return;
        }
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((h20) it.next()).accept(new db3(z));
        }
    }
}
