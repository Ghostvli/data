package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w95 {
    public static final w95 b;
    public final m a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m {
        public static final w95 b = new a().a().a().b().c();
        public final w95 a;

        public m(w95 w95Var) {
            this.a = w95Var;
        }

        public w95 a() {
            return this.a;
        }

        public w95 b() {
            return this.a;
        }

        public w95 c() {
            return this.a;
        }

        public void d(View view) {
        }

        public void e(w95 w95Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return p() == mVar.p() && o() == mVar.o() && u43.a(l(), mVar.l()) && u43.a(j(), mVar.j()) && u43.a(f(), mVar.f());
        }

        public om0 f() {
            return null;
        }

        public lk1 g(int i) {
            return lk1.e;
        }

        public lk1 h(int i) {
            if ((i & 8) == 0) {
                return lk1.e;
            }
            jl.a("Unable to query the maximum insets for IME");
            return null;
        }

        public int hashCode() {
            return u43.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        public lk1 i() {
            return l();
        }

        public lk1 j() {
            return lk1.e;
        }

        public lk1 k() {
            return l();
        }

        public lk1 l() {
            return lk1.e;
        }

        public lk1 m() {
            return l();
        }

        public w95 n(int i, int i2, int i3, int i4) {
            return b;
        }

        public boolean o() {
            return false;
        }

        public boolean p() {
            return false;
        }

        public void q(lk1[] lk1VarArr) {
        }

        public void r(lk1 lk1Var) {
        }

        public void s(w95 w95Var) {
        }

        public void t(lk1 lk1Var) {
        }

        public void u(int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class n {
        public static int a() {
            return 8;
        }

        public static int b(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            if (i == 512) {
                return 9;
            }
            defpackage.b.a("type needs to be >= FIRST and <= LAST, type=", i);
            return 0;
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 1;
        }

        public static int e() {
            return 519;
        }

        public static int f() {
            return 64;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class o {
        public static int a(int i) {
            int iStatusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= iStatusBars;
                }
            }
            return i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class p {
        public static int a(int i) {
            int iStatusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    } else if (i3 == 512) {
                        iStatusBars = WindowInsets.Type.systemOverlays();
                    }
                    i2 |= iStatusBars;
                }
            }
            return i2;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            b = l.s;
        } else if (i2 >= 30) {
            b = k.r;
        } else {
            b = m.b;
        }
    }

    public w95(w95 w95Var) {
        if (w95Var == null) {
            this.a = new m(this);
            return;
        }
        m mVar = w95Var.a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34 && (mVar instanceof l)) {
            this.a = new l(this, (l) mVar);
        } else if (i2 >= 30 && (mVar instanceof k)) {
            this.a = new k(this, (k) mVar);
        } else if (i2 >= 29 && (mVar instanceof j)) {
            this.a = new j(this, (j) mVar);
        } else if (i2 >= 28 && (mVar instanceof i)) {
            this.a = new i(this, (i) mVar);
        } else if (mVar instanceof h) {
            this.a = new h(this, (h) mVar);
        } else if (mVar instanceof g) {
            this.a = new g(this, (g) mVar);
        } else {
            this.a = new m(this);
        }
        mVar.e(this);
    }

    public static lk1 n(lk1 lk1Var, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, lk1Var.a - i2);
        int iMax2 = Math.max(0, lk1Var.b - i3);
        int iMax3 = Math.max(0, lk1Var.c - i4);
        int iMax4 = Math.max(0, lk1Var.d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? lk1Var : lk1.c(iMax, iMax2, iMax3, iMax4);
    }

    public static w95 w(WindowInsets windowInsets) {
        return x(windowInsets, null);
    }

    public static w95 x(WindowInsets windowInsets, View view) {
        w95 w95Var = new w95((WindowInsets) hg3.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            w95Var.s(l35.D(view));
            w95Var.d(view.getRootView());
            w95Var.u(view.getWindowSystemUiVisibility());
        }
        return w95Var;
    }

    public w95 a() {
        return this.a.a();
    }

    public w95 b() {
        return this.a.b();
    }

    public w95 c() {
        return this.a.c();
    }

    public void d(View view) {
        this.a.d(view);
    }

    public om0 e() {
        return this.a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w95) {
            return u43.a(this.a, ((w95) obj).a);
        }
        return false;
    }

    public lk1 f(int i2) {
        return this.a.g(i2);
    }

    public lk1 g(int i2) {
        return this.a.h(i2);
    }

    public lk1 h() {
        return this.a.j();
    }

    public int hashCode() {
        m mVar = this.a;
        if (mVar == null) {
            return 0;
        }
        return mVar.hashCode();
    }

    public int i() {
        return this.a.l().d;
    }

    public int j() {
        return this.a.l().a;
    }

    public int k() {
        return this.a.l().c;
    }

    public int l() {
        return this.a.l().b;
    }

    public w95 m(int i2, int i3, int i4, int i5) {
        return this.a.n(i2, i3, i4, i5);
    }

    public boolean o() {
        return this.a.o();
    }

    public w95 p(int i2, int i3, int i4, int i5) {
        return new a(this).d(lk1.c(i2, i3, i4, i5)).a();
    }

    public void q(lk1[] lk1VarArr) {
        this.a.q(lk1VarArr);
    }

    public void r(lk1 lk1Var) {
        this.a.r(lk1Var);
    }

    public void s(w95 w95Var) {
        this.a.s(w95Var);
    }

    public void t(lk1 lk1Var) {
        this.a.t(lk1Var);
    }

    public void u(int i2) {
        this.a.u(i2);
    }

    public WindowInsets v() {
        m mVar = this.a;
        if (mVar instanceof g) {
            return ((g) mVar).c;
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends c {
        public d() {
        }

        @Override // w95.f
        public void c(int i, lk1 lk1Var) {
            this.c.setInsets(o.a(i), lk1Var.f());
        }

        public d(w95 w95Var) {
            super(w95Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends d {
        public e() {
        }

        @Override // w95.d, w95.f
        public void c(int i, lk1 lk1Var) {
            this.c.setInsets(p.a(i), lk1Var.f());
        }

        public e(w95 w95Var) {
            super(w95Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends h {
        public i(w95 w95Var, WindowInsets windowInsets) {
            super(w95Var, windowInsets);
        }

        @Override // w95.m
        public w95 a() {
            return w95.w(this.c.consumeDisplayCutout());
        }

        @Override // w95.g, w95.m
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.c, iVar.c) && Objects.equals(this.g, iVar.g) && g.A(this.h, iVar.h);
        }

        @Override // w95.m
        public om0 f() {
            return om0.e(this.c.getDisplayCutout());
        }

        @Override // w95.m
        public int hashCode() {
            return this.c.hashCode();
        }

        public i(w95 w95Var, i iVar) {
            super(w95Var, iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k extends j {
        public static final w95 r = w95.w(WindowInsets.CONSUMED);

        public k(w95 w95Var, WindowInsets windowInsets) {
            super(w95Var, windowInsets);
        }

        @Override // w95.g, w95.m
        public final void d(View view) {
        }

        @Override // w95.g, w95.m
        public lk1 g(int i) {
            return lk1.e(this.c.getInsets(o.a(i)));
        }

        @Override // w95.g, w95.m
        public lk1 h(int i) {
            return lk1.e(this.c.getInsetsIgnoringVisibility(o.a(i)));
        }

        public k(w95 w95Var, k kVar) {
            super(w95Var, kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l extends k {
        public static final w95 s = w95.w(WindowInsets.CONSUMED);

        public l(w95 w95Var, WindowInsets windowInsets) {
            super(w95Var, windowInsets);
        }

        @Override // w95.k, w95.g, w95.m
        public lk1 g(int i) {
            return lk1.e(this.c.getInsets(p.a(i)));
        }

        @Override // w95.k, w95.g, w95.m
        public lk1 h(int i) {
            return lk1.e(this.c.getInsetsIgnoringVisibility(p.a(i)));
        }

        public l(w95 w95Var, l lVar) {
            super(w95Var, lVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends f {
        public static Field e;
        public static boolean f;
        public static Constructor g;
        public static boolean h;
        public WindowInsets c;
        public lk1 d;

        public b() {
            this.c = i();
        }

        private static WindowInsets i() {
            if (!f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!h) {
                try {
                    g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                h = true;
            }
            Constructor constructor = g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // w95.f
        public w95 b() {
            a();
            w95 w95VarW = w95.w(this.c);
            w95VarW.q(this.b);
            w95VarW.t(this.d);
            return w95VarW;
        }

        @Override // w95.f
        public void e(lk1 lk1Var) {
            this.d = lk1Var;
        }

        @Override // w95.f
        public void g(lk1 lk1Var) {
            WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(lk1Var.a, lk1Var.b, lk1Var.c, lk1Var.d);
            }
        }

        public b(w95 w95Var) {
            super(w95Var);
            this.c = w95Var.v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public final w95 a;
        public lk1[] b;

        public f() {
            this(new w95((w95) null));
        }

        public final void a() {
            lk1[] lk1VarArr = this.b;
            if (lk1VarArr != null) {
                lk1 lk1VarF = lk1VarArr[n.b(1)];
                lk1 lk1VarF2 = this.b[n.b(2)];
                if (lk1VarF2 == null) {
                    lk1VarF2 = this.a.f(2);
                }
                if (lk1VarF == null) {
                    lk1VarF = this.a.f(1);
                }
                g(lk1.a(lk1VarF, lk1VarF2));
                lk1 lk1Var = this.b[n.b(16)];
                if (lk1Var != null) {
                    f(lk1Var);
                }
                lk1 lk1Var2 = this.b[n.b(32)];
                if (lk1Var2 != null) {
                    d(lk1Var2);
                }
                lk1 lk1Var3 = this.b[n.b(64)];
                if (lk1Var3 != null) {
                    h(lk1Var3);
                }
            }
        }

        public abstract w95 b();

        public void c(int i, lk1 lk1Var) {
            if (this.b == null) {
                this.b = new lk1[10];
            }
            for (int i2 = 1; i2 <= 512; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.b[n.b(i2)] = lk1Var;
                }
            }
        }

        public void d(lk1 lk1Var) {
        }

        public abstract void e(lk1 lk1Var);

        public void f(lk1 lk1Var) {
        }

        public abstract void g(lk1 lk1Var);

        public void h(lk1 lk1Var) {
        }

        public f(w95 w95Var) {
            this.a = w95Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends m {
        public static boolean i;
        public static Method j;
        public static Class k;
        public static Field l;
        public static Field m;
        public final WindowInsets c;
        public lk1[] d;
        public lk1 e;
        public w95 f;
        public lk1 g;
        public int h;

        public g(w95 w95Var, g gVar) {
            this(w95Var, new WindowInsets(gVar.c));
        }

        public static boolean A(int i2, int i3) {
            return (i2 & 6) == (i3 & 6);
        }

        @SuppressLint({"WrongConstant"})
        private lk1 v(int i2, boolean z) {
            lk1 lk1VarA = lk1.e;
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    lk1VarA = lk1.a(lk1VarA, w(i3, z));
                }
            }
            return lk1VarA;
        }

        private lk1 x() {
            w95 w95Var = this.f;
            return w95Var != null ? w95Var.h() : lk1.e;
        }

        private lk1 y(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                fn.a("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
                return null;
            }
            if (!i) {
                z();
            }
            Method method = j;
            if (method != null && k != null && l != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) l.get(m.get(objInvoke));
                    if (rect != null) {
                        return lk1.d(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void z() {
            try {
                j = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                k = cls;
                l = cls.getDeclaredField("mVisibleInsets");
                m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                l.setAccessible(true);
                m.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            i = true;
        }

        @Override // w95.m
        public void d(View view) {
            lk1 lk1VarY = y(view);
            if (lk1VarY == null) {
                lk1VarY = lk1.e;
            }
            r(lk1VarY);
        }

        @Override // w95.m
        public void e(w95 w95Var) {
            w95Var.s(this.f);
            w95Var.r(this.g);
            w95Var.u(this.h);
        }

        @Override // w95.m
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equals(this.g, gVar.g) && A(this.h, gVar.h);
        }

        @Override // w95.m
        public lk1 g(int i2) {
            return v(i2, false);
        }

        @Override // w95.m
        public lk1 h(int i2) {
            return v(i2, true);
        }

        @Override // w95.m
        public final lk1 l() {
            if (this.e == null) {
                this.e = lk1.c(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // w95.m
        public w95 n(int i2, int i3, int i4, int i5) {
            a aVar = new a(w95.w(this.c));
            aVar.d(w95.n(l(), i2, i3, i4, i5));
            aVar.c(w95.n(j(), i2, i3, i4, i5));
            return aVar.a();
        }

        @Override // w95.m
        public boolean p() {
            return this.c.isRound();
        }

        @Override // w95.m
        public void q(lk1[] lk1VarArr) {
            this.d = lk1VarArr;
        }

        @Override // w95.m
        public void r(lk1 lk1Var) {
            this.g = lk1Var;
        }

        @Override // w95.m
        public void s(w95 w95Var) {
            this.f = w95Var;
        }

        @Override // w95.m
        public void u(int i2) {
            this.h = i2;
        }

        public lk1 w(int i2, boolean z) {
            lk1 lk1VarH;
            int i3;
            if (i2 == 1) {
                return z ? lk1.c(0, Math.max(x().b, l().b), 0, 0) : (this.h & 4) != 0 ? lk1.e : lk1.c(0, l().b, 0, 0);
            }
            if (i2 == 2) {
                if (z) {
                    lk1 lk1VarX = x();
                    lk1 lk1VarJ = j();
                    return lk1.c(Math.max(lk1VarX.a, lk1VarJ.a), 0, Math.max(lk1VarX.c, lk1VarJ.c), Math.max(lk1VarX.d, lk1VarJ.d));
                }
                if ((this.h & 2) != 0) {
                    return lk1.e;
                }
                lk1 lk1VarL = l();
                w95 w95Var = this.f;
                lk1VarH = w95Var != null ? w95Var.h() : null;
                int iMin = lk1VarL.d;
                if (lk1VarH != null) {
                    iMin = Math.min(iMin, lk1VarH.d);
                }
                return lk1.c(lk1VarL.a, 0, lk1VarL.c, iMin);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return k();
                }
                if (i2 == 32) {
                    return i();
                }
                if (i2 == 64) {
                    return m();
                }
                if (i2 != 128) {
                    return lk1.e;
                }
                w95 w95Var2 = this.f;
                om0 om0VarE = w95Var2 != null ? w95Var2.e() : f();
                return om0VarE != null ? lk1.c(om0VarE.b(), om0VarE.d(), om0VarE.c(), om0VarE.a()) : lk1.e;
            }
            lk1[] lk1VarArr = this.d;
            lk1VarH = lk1VarArr != null ? lk1VarArr[n.b(8)] : null;
            if (lk1VarH != null) {
                return lk1VarH;
            }
            lk1 lk1VarL2 = l();
            lk1 lk1VarX2 = x();
            int i4 = lk1VarL2.d;
            if (i4 > lk1VarX2.d) {
                return lk1.c(0, 0, 0, i4);
            }
            lk1 lk1Var = this.g;
            return (lk1Var == null || lk1Var.equals(lk1.e) || (i3 = this.g.d) <= lk1VarX2.d) ? lk1.e : lk1.c(0, 0, 0, i3);
        }

        public g(w95 w95Var, WindowInsets windowInsets) {
            super(w95Var);
            this.e = null;
            this.c = windowInsets;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends g {
        public lk1 n;

        public h(w95 w95Var, h hVar) {
            super(w95Var, hVar);
            this.n = null;
            this.n = hVar.n;
        }

        @Override // w95.m
        public w95 b() {
            return w95.w(this.c.consumeStableInsets());
        }

        @Override // w95.m
        public w95 c() {
            return w95.w(this.c.consumeSystemWindowInsets());
        }

        @Override // w95.m
        public final lk1 j() {
            if (this.n == null) {
                this.n = lk1.c(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // w95.m
        public boolean o() {
            return this.c.isConsumed();
        }

        @Override // w95.m
        public void t(lk1 lk1Var) {
            this.n = lk1Var;
        }

        public h(w95 w95Var, WindowInsets windowInsets) {
            super(w95Var, windowInsets);
            this.n = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j extends i {
        public lk1 o;
        public lk1 p;
        public lk1 q;

        public j(w95 w95Var, WindowInsets windowInsets) {
            super(w95Var, windowInsets);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        @Override // w95.m
        public lk1 i() {
            if (this.p == null) {
                this.p = lk1.e(this.c.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // w95.m
        public lk1 k() {
            if (this.o == null) {
                this.o = lk1.e(this.c.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // w95.m
        public lk1 m() {
            if (this.q == null) {
                this.q = lk1.e(this.c.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // w95.g, w95.m
        public w95 n(int i, int i2, int i3, int i4) {
            return w95.w(this.c.inset(i, i2, i3, i4));
        }

        @Override // w95.h, w95.m
        public void t(lk1 lk1Var) {
        }

        public j(w95 w95Var, j jVar) {
            super(w95Var, jVar);
            this.o = null;
            this.p = null;
            this.q = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends f {
        public final WindowInsets.Builder c;

        public c(w95 w95Var) {
            super(w95Var);
            WindowInsets windowInsetsV = w95Var.v();
            this.c = windowInsetsV != null ? x95.a(windowInsetsV) : rc4.a();
        }

        @Override // w95.f
        public w95 b() {
            a();
            w95 w95VarW = w95.w(this.c.build());
            w95VarW.q(this.b);
            return w95VarW;
        }

        @Override // w95.f
        public void d(lk1 lk1Var) {
            this.c.setMandatorySystemGestureInsets(lk1Var.f());
        }

        @Override // w95.f
        public void e(lk1 lk1Var) {
            this.c.setStableInsets(lk1Var.f());
        }

        @Override // w95.f
        public void f(lk1 lk1Var) {
            this.c.setSystemGestureInsets(lk1Var.f());
        }

        @Override // w95.f
        public void g(lk1 lk1Var) {
            this.c.setSystemWindowInsets(lk1Var.f());
        }

        @Override // w95.f
        public void h(lk1 lk1Var) {
            this.c.setTappableElementInsets(lk1Var.f());
        }

        public c() {
            this.c = rc4.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final f a;

        public a() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.a = new e();
                return;
            }
            if (i >= 30) {
                this.a = new d();
            } else if (i >= 29) {
                this.a = new c();
            } else {
                this.a = new b();
            }
        }

        public w95 a() {
            return this.a.b();
        }

        public a b(int i, lk1 lk1Var) {
            this.a.c(i, lk1Var);
            return this;
        }

        public a c(lk1 lk1Var) {
            this.a.e(lk1Var);
            return this;
        }

        public a d(lk1 lk1Var) {
            this.a.g(lk1Var);
            return this;
        }

        public a(w95 w95Var) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.a = new e(w95Var);
                return;
            }
            if (i >= 30) {
                this.a = new d(w95Var);
            } else if (i >= 29) {
                this.a = new c(w95Var);
            } else {
                this.a = new b(w95Var);
            }
        }
    }

    public w95(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            this.a = new l(this, windowInsets);
            return;
        }
        if (i2 >= 30) {
            this.a = new k(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.a = new j(this, windowInsets);
        } else if (i2 >= 28) {
            this.a = new i(this, windowInsets);
        } else {
            this.a = new h(this, windowInsets);
        }
    }
}
