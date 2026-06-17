package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g22 extends Drawable implements Drawable.Callback, Animatable {
    public static final boolean Y;
    public static final List Z;
    public static final Executor a0;
    public boolean A;
    public hq3 B;
    public boolean C;
    public final Matrix D;
    public Bitmap E;
    public Canvas F;
    public Rect G;
    public RectF H;
    public Paint I;
    public Rect J;
    public Rect K;
    public RectF L;
    public RectF M;
    public Matrix N;
    public float[] O;
    public Matrix P;
    public boolean Q;
    public jb R;
    public final ValueAnimator.AnimatorUpdateListener S;
    public final Semaphore T;
    public Handler U;
    public Runnable V;
    public final Runnable W;
    public float X;
    public f12 f;
    public final x22 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public b k;
    public final ArrayList l;
    public fi1 m;
    public String n;
    public a41 o;
    public Map p;
    public String q;
    public final i22 r;
    public boolean s;
    public boolean t;
    public ry u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(f12 f12Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        NONE,
        PLAY,
        RESUME
    }

    static {
        Y = Build.VERSION.SDK_INT <= 25;
        Z = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        a0 = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new u22());
    }

    public g22() {
        x22 x22Var = new x22();
        this.g = x22Var;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = b.NONE;
        this.l = new ArrayList();
        this.r = new i22();
        this.s = false;
        this.t = true;
        this.v = 255;
        this.A = false;
        this.B = hq3.AUTOMATIC;
        this.C = false;
        this.D = new Matrix();
        this.O = new float[9];
        this.Q = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: a22
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g22.g(this.a, valueAnimator);
            }
        };
        this.S = animatorUpdateListener;
        this.T = new Semaphore(1);
        this.W = new Runnable() { // from class: b22
            @Override // java.lang.Runnable
            public final void run() {
                g22.k(this.f);
            }
        };
        this.X = -3.4028235E38f;
        x22Var.addUpdateListener(animatorUpdateListener);
    }

    public static /* synthetic */ void g(g22 g22Var, ValueAnimator valueAnimator) {
        if (g22Var.D()) {
            g22Var.invalidateSelf();
            return;
        }
        ry ryVar = g22Var.u;
        if (ryVar != null) {
            ryVar.M(g22Var.g.k());
        }
    }

    public static boolean g0(float f) {
        return (Float.isNaN(f) || Float.isInfinite(f)) ? false : true;
    }

    public static boolean h0(RectF rectF) {
        return g0(rectF.left) && g0(rectF.top) && g0(rectF.right) && g0(rectF.bottom);
    }

    public static /* synthetic */ void k(final g22 g22Var) {
        ry ryVar = g22Var.u;
        if (ryVar == null) {
            return;
        }
        try {
            g22Var.T.acquire();
            ryVar.M(g22Var.g.k());
            if (Y && g22Var.Q) {
                if (g22Var.U == null) {
                    g22Var.U = new Handler(Looper.getMainLooper());
                    g22Var.V = new Runnable() { // from class: w12
                        @Override // java.lang.Runnable
                        public final void run() {
                            g22.n(this.f);
                        }
                    };
                }
                g22Var.U.post(g22Var.V);
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            g22Var.T.release();
            throw th;
        }
        g22Var.T.release();
    }

    public static /* synthetic */ void n(g22 g22Var) {
        Drawable.Callback callback = g22Var.getCallback();
        if (callback != null) {
            callback.invalidateDrawable(g22Var);
        }
    }

    public final void A(int i, int i2) {
        Bitmap bitmap = this.E;
        if (bitmap == null || bitmap.getWidth() < i || this.E.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.E = bitmapCreateBitmap;
            this.F.setBitmap(bitmapCreateBitmap);
            this.Q = true;
            return;
        }
        if (this.E.getWidth() > i || this.E.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.E, 0, 0, i, i2);
            this.E = bitmapCreateBitmap2;
            this.F.setBitmap(bitmapCreateBitmap2);
            this.Q = true;
        }
    }

    public void A0(String str) {
        this.n = str;
    }

    public final void B() {
        if (this.F != null) {
            return;
        }
        this.F = new Canvas();
        this.M = new RectF();
        this.N = new Matrix();
        this.P = new Matrix();
        this.G = new Rect();
        this.H = new RectF();
        this.I = new qr1();
        this.J = new Rect();
        this.K = new Rect();
        this.L = new RectF();
    }

    public void B0(boolean z) {
        this.s = z;
    }

    public jb C() {
        jb jbVar = this.R;
        return jbVar != null ? jbVar : or1.d();
    }

    public void C0(final int i) {
        if (this.f == null) {
            this.l.add(new a() { // from class: r12
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.C0(i);
                }
            });
        } else {
            this.g.A(i + 0.99f);
        }
    }

    public boolean D() {
        return C() == jb.ENABLED;
    }

    public void D0(final String str) {
        f12 f12Var = this.f;
        if (f12Var == null) {
            this.l.add(new a() { // from class: y12
                @Override // g22.a
                public final void a(f12 f12Var2) {
                    this.a.D0(str);
                }
            });
            return;
        }
        c52 c52VarL = f12Var.l(str);
        if (c52VarL != null) {
            C0((int) (c52VarL.b + c52VarL.c));
        } else {
            f02.a("Cannot find marker with name ", str, ".");
        }
    }

    public Bitmap E(String str) {
        fi1 fi1VarL = L();
        if (fi1VarL != null) {
            return fi1VarL.a(str);
        }
        return null;
    }

    public void E0(final float f) {
        f12 f12Var = this.f;
        if (f12Var == null) {
            this.l.add(new a() { // from class: u12
                @Override // g22.a
                public final void a(f12 f12Var2) {
                    this.a.E0(f);
                }
            });
        } else {
            this.g.A(ot2.i(f12Var.p(), this.f.f(), f));
        }
    }

    public boolean F() {
        return this.A;
    }

    public void F0(final int i, final int i2) {
        if (this.f == null) {
            this.l.add(new a() { // from class: v12
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.F0(i, i2);
                }
            });
        } else {
            this.g.B(i, i2 + 0.99f);
        }
    }

    public boolean G() {
        return this.t;
    }

    public void G0(final String str) {
        f12 f12Var = this.f;
        if (f12Var == null) {
            this.l.add(new a() { // from class: q12
                @Override // g22.a
                public final void a(f12 f12Var2) {
                    this.a.G0(str);
                }
            });
            return;
        }
        c52 c52VarL = f12Var.l(str);
        if (c52VarL == null) {
            f02.a("Cannot find marker with name ", str, ".");
        } else {
            int i = (int) c52VarL.b;
            F0(i, ((int) c52VarL.c) + i);
        }
    }

    public f12 H() {
        return this.f;
    }

    public void H0(final int i) {
        if (this.f == null) {
            this.l.add(new a() { // from class: s12
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.H0(i);
                }
            });
        } else {
            this.g.C(i);
        }
    }

    public final Context I() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void I0(final String str) {
        f12 f12Var = this.f;
        if (f12Var == null) {
            this.l.add(new a() { // from class: z12
                @Override // g22.a
                public final void a(f12 f12Var2) {
                    this.a.I0(str);
                }
            });
            return;
        }
        c52 c52VarL = f12Var.l(str);
        if (c52VarL != null) {
            H0((int) c52VarL.b);
        } else {
            f02.a("Cannot find marker with name ", str, ".");
        }
    }

    public final a41 J() {
        if (getCallback() == null) {
            return null;
        }
        if (this.o == null) {
            a41 a41Var = new a41(getCallback(), null);
            this.o = a41Var;
            String str = this.q;
            if (str != null) {
                a41Var.c(str);
            }
        }
        return this.o;
    }

    public void J0(final float f) {
        f12 f12Var = this.f;
        if (f12Var == null) {
            this.l.add(new a() { // from class: d22
                @Override // g22.a
                public final void a(f12 f12Var2) {
                    this.a.J0(f);
                }
            });
        } else {
            H0((int) ot2.i(f12Var.p(), this.f.f(), f));
        }
    }

    public int K() {
        return (int) this.g.l();
    }

    public void K0(boolean z) {
        if (this.x == z) {
            return;
        }
        this.x = z;
        ry ryVar = this.u;
        if (ryVar != null) {
            ryVar.K(z);
        }
    }

    public final fi1 L() {
        fi1 fi1Var = this.m;
        if (fi1Var != null && !fi1Var.b(I())) {
            this.m = null;
        }
        if (this.m == null) {
            this.m = new fi1(getCallback(), this.n, null, this.f.j());
        }
        return this.m;
    }

    public void L0(boolean z) {
        this.w = z;
        f12 f12Var = this.f;
        if (f12Var != null) {
            f12Var.v(z);
        }
    }

    public String M() {
        return this.n;
    }

    public void M0(final float f) {
        if (this.f == null) {
            this.l.add(new a() { // from class: e22
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.M0(f);
                }
            });
            return;
        }
        if (or1.h()) {
            or1.b("Drawable#setProgress");
        }
        this.g.z(this.f.h(f));
        if (or1.h()) {
            or1.c("Drawable#setProgress");
        }
    }

    public l22 N(String str) {
        f12 f12Var = this.f;
        if (f12Var == null) {
            return null;
        }
        return (l22) f12Var.j().get(str);
    }

    public void N0(hq3 hq3Var) {
        this.B = hq3Var;
        u();
    }

    public boolean O() {
        return this.s;
    }

    public void O0(int i) {
        this.g.setRepeatCount(i);
    }

    public c52 P() {
        Iterator it = Z.iterator();
        c52 c52VarL = null;
        while (it.hasNext()) {
            c52VarL = this.f.l((String) it.next());
            if (c52VarL != null) {
                break;
            }
        }
        return c52VarL;
    }

    public void P0(int i) {
        this.g.setRepeatMode(i);
    }

    public float Q() {
        return this.g.n();
    }

    public void Q0(boolean z) {
        this.j = z;
    }

    public float R() {
        return this.g.o();
    }

    public void R0(float f) {
        this.g.D(f);
    }

    public ma3 S() {
        f12 f12Var = this.f;
        if (f12Var != null) {
            return f12Var.n();
        }
        return null;
    }

    public void S0(em4 em4Var) {
    }

    public float T() {
        return this.g.k();
    }

    public void T0(boolean z) {
        this.g.E(z);
    }

    public hq3 U() {
        return this.C ? hq3.SOFTWARE : hq3.HARDWARE;
    }

    public final boolean U0() {
        f12 f12Var = this.f;
        if (f12Var == null) {
            return false;
        }
        float f = this.X;
        float fK = this.g.k();
        this.X = fK;
        return Math.abs(fK - f) * f12Var.d() >= 50.0f;
    }

    public int V() {
        return this.g.getRepeatCount();
    }

    public boolean V0() {
        return this.p == null && this.f.c().h() > 0;
    }

    public int W() {
        return this.g.getRepeatMode();
    }

    public float X() {
        return this.g.p();
    }

    public em4 Y() {
        return null;
    }

    public Typeface Z(y31 y31Var) {
        Map map = this.p;
        if (map != null) {
            String strA = y31Var.a();
            if (map.containsKey(strA)) {
                return (Typeface) map.get(strA);
            }
            String strB = y31Var.b();
            if (map.containsKey(strB)) {
                return (Typeface) map.get(strB);
            }
            String str = y31Var.a() + "-" + y31Var.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        a41 a41VarJ = J();
        if (a41VarJ != null) {
            return a41VarJ.b(y31Var);
        }
        return null;
    }

    public final boolean a0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r2).getClipChildren();
        }
        return false;
    }

    public boolean b0() {
        x22 x22Var = this.g;
        if (x22Var == null) {
            return false;
        }
        return x22Var.isRunning();
    }

    public boolean c0() {
        if (isVisible()) {
            return this.g.isRunning();
        }
        b bVar = this.k;
        return bVar == b.PLAY || bVar == b.RESUME;
    }

    public boolean d0() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ry ryVar = this.u;
        if (ryVar == null) {
            return;
        }
        boolean zD = D();
        if (zD) {
            try {
                this.T.acquire();
            } catch (InterruptedException unused) {
                if (or1.h()) {
                    or1.c("Drawable#draw");
                }
                if (!zD) {
                    return;
                }
                this.T.release();
                if (ryVar.P() == this.g.k()) {
                    return;
                }
            } catch (Throwable th) {
                if (or1.h()) {
                    or1.c("Drawable#draw");
                }
                if (zD) {
                    this.T.release();
                    if (ryVar.P() != this.g.k()) {
                        a0.execute(this.W);
                    }
                }
                throw th;
            }
        }
        if (or1.h()) {
            or1.b("Drawable#draw");
        }
        if (zD && U0()) {
            M0(this.g.k());
        }
        boolean z = this.j;
        boolean z2 = this.C;
        if (z) {
            try {
                if (z2) {
                    k0(canvas, ryVar);
                } else {
                    x(canvas);
                }
            } catch (Throwable th2) {
                k02.b("Lottie crashed in draw!", th2);
            }
        } else if (z2) {
            k0(canvas, ryVar);
        } else {
            x(canvas);
        }
        this.Q = false;
        if (or1.h()) {
            or1.c("Drawable#draw");
        }
        if (zD) {
            this.T.release();
            if (ryVar.P() == this.g.k()) {
                return;
            }
            a0.execute(this.W);
        }
    }

    public boolean e0() {
        return this.z;
    }

    public boolean f0(h22 h22Var) {
        return this.r.b(h22Var);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.v;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        f12 f12Var = this.f;
        if (f12Var == null) {
            return -1;
        }
        return f12Var.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        f12 f12Var = this.f;
        if (f12Var == null) {
            return -1;
        }
        return f12Var.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void i0() {
        this.l.clear();
        this.g.r();
        if (isVisible()) {
            return;
        }
        this.k = b.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        if (this.Q) {
            return;
        }
        this.Q = true;
        if ((!Y || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return b0();
    }

    public void j0() {
        if (this.u == null) {
            this.l.add(new a() { // from class: c22
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.j0();
                }
            });
            return;
        }
        u();
        if (r(I()) || V() == 0) {
            if (isVisible()) {
                this.g.s();
                this.k = b.NONE;
            } else {
                this.k = b.PLAY;
            }
        }
        if (r(I())) {
            return;
        }
        c52 c52VarP = P();
        if (c52VarP != null) {
            x0((int) c52VarP.b);
        } else {
            x0((int) (X() < 0.0f ? R() : Q()));
        }
        this.g.j();
        if (isVisible()) {
            return;
        }
        this.k = b.NONE;
    }

    public final void k0(Canvas canvas, ry ryVar) {
        if (this.f == null || ryVar == null) {
            return;
        }
        B();
        canvas.getMatrix(this.N);
        canvas.getClipBounds(this.G);
        v(this.G, this.H);
        this.N.mapRect(this.H);
        w(this.H, this.G);
        boolean z = this.t;
        RectF rectF = this.M;
        if (z) {
            rectF.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            ryVar.d(rectF, null, false);
        }
        this.N.mapRect(this.M);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        n0(this.M, fWidth, fHeight);
        if (!a0()) {
            RectF rectF2 = this.M;
            Rect rect = this.G;
            rectF2.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        if (!h0(this.M)) {
            k02.c("Skipping software rendering: transformed bounds contain non-finite values.");
            return;
        }
        int iCeil = (int) Math.ceil(this.M.width());
        int iCeil2 = (int) Math.ceil(this.M.height());
        if (iCeil <= 0 || iCeil2 <= 0) {
            k02.c("Skipping software rendering: transformed bounds have negative values.");
            return;
        }
        long j = ((long) iCeil) * ((long) iCeil2);
        if (j > 50000000) {
            k02.c("Skipping software rendering: bitmap request exceeds safe pixel count (" + j + ")");
            return;
        }
        A(iCeil, iCeil2);
        if (this.Q) {
            this.N.getValues(this.O);
            float[] fArr = this.O;
            float f = fArr[0];
            float f2 = fArr[4];
            this.D.set(this.N);
            this.D.preScale(fWidth, fHeight);
            Matrix matrix = this.D;
            RectF rectF3 = this.M;
            matrix.postTranslate(-rectF3.left, -rectF3.top);
            this.D.postScale(1.0f / f, 1.0f / f2);
            this.E.eraseColor(0);
            this.F.setMatrix(uy4.a);
            this.F.scale(f, f2);
            ryVar.i(this.F, this.D, this.v, null);
            this.N.invert(this.P);
            this.P.mapRect(this.L, this.M);
            w(this.L, this.K);
        }
        this.J.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.E, this.J, this.K, this.I);
    }

    public List l0(zq1 zq1Var) {
        if (this.u == null) {
            k02.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        this.u.h(zq1Var, 0, arrayList, new zq1(new String[0]));
        return arrayList;
    }

    public void m0() {
        if (this.u == null) {
            this.l.add(new a() { // from class: x12
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.m0();
                }
            });
            return;
        }
        u();
        if (r(I()) || V() == 0) {
            if (isVisible()) {
                this.g.w();
                this.k = b.NONE;
            } else {
                this.k = b.RESUME;
            }
        }
        if (r(I())) {
            return;
        }
        x0((int) (X() < 0.0f ? R() : Q()));
        this.g.j();
        if (isVisible()) {
            return;
        }
        this.k = b.NONE;
    }

    public final void n0(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    public void o0(boolean z) {
        this.y = z;
    }

    public void p0(boolean z) {
        this.z = z;
    }

    public void q(final zq1 zq1Var, final Object obj, final y22 y22Var) {
        ry ryVar = this.u;
        if (ryVar == null) {
            this.l.add(new a() { // from class: t12
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.q(zq1Var, obj, y22Var);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (zq1Var == zq1.c) {
            ryVar.g(obj, y22Var);
        } else if (zq1Var.d() != null) {
            zq1Var.d().g(obj, y22Var);
        } else {
            List listL0 = l0(zq1Var);
            for (int i = 0; i < listL0.size(); i++) {
                ((zq1) listL0.get(i)).d().g(obj, y22Var);
            }
            zIsEmpty = true ^ listL0.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == q22.H) {
                M0(T());
            }
        }
    }

    public void q0(jb jbVar) {
        this.R = jbVar;
    }

    public boolean r(Context context) {
        if (this.i) {
            return true;
        }
        return this.h && or1.f().a(context) == ip3.STANDARD_MOTION;
    }

    public void r0(boolean z) {
        if (z != this.A) {
            this.A = z;
            invalidateSelf();
        }
    }

    public final void s() {
        f12 f12Var = this.f;
        if (f12Var == null) {
            return;
        }
        ry ryVar = new ry(this, zr1.b(f12Var), f12Var.k(), f12Var);
        this.u = ryVar;
        if (this.x) {
            ryVar.K(true);
        }
        this.u.Q(this.t);
    }

    public void s0(boolean z) {
        if (z != this.t) {
            this.t = z;
            ry ryVar = this.u;
            if (ryVar != null) {
                ryVar.Q(z);
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.v = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        k02.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            b bVar = this.k;
            if (bVar == b.PLAY) {
                j0();
                return visible;
            }
            if (bVar == b.RESUME) {
                m0();
                return visible;
            }
        } else {
            if (this.g.isRunning()) {
                i0();
                this.k = b.RESUME;
                return visible;
            }
            if (zIsVisible) {
                this.k = b.NONE;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        j0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        z();
    }

    public void t() {
        if (this.g.isRunning()) {
            this.g.cancel();
            if (!isVisible()) {
                this.k = b.NONE;
            }
        }
        this.f = null;
        this.u = null;
        this.m = null;
        this.X = -3.4028235E38f;
        this.g.i();
        invalidateSelf();
    }

    public boolean t0(f12 f12Var) {
        if (this.f == f12Var) {
            return false;
        }
        this.Q = true;
        t();
        this.f = f12Var;
        s();
        this.g.y(f12Var);
        M0(this.g.getAnimatedFraction());
        Iterator it = new ArrayList(this.l).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(f12Var);
            }
            it.remove();
        }
        this.l.clear();
        f12Var.v(this.w);
        u();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public final void u() {
        f12 f12Var = this.f;
        if (f12Var == null) {
            return;
        }
        this.C = this.B.b(Build.VERSION.SDK_INT, f12Var.q(), f12Var.m());
    }

    public void u0(String str) {
        this.q = str;
        a41 a41VarJ = J();
        if (a41VarJ != null) {
            a41VarJ.c(str);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void v(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void v0(z31 z31Var) {
        a41 a41Var = this.o;
        if (a41Var != null) {
            a41Var.d(z31Var);
        }
    }

    public final void w(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public void w0(Map map) {
        if (map == this.p) {
            return;
        }
        this.p = map;
        invalidateSelf();
    }

    public final void x(Canvas canvas) {
        ry ryVar = this.u;
        f12 f12Var = this.f;
        if (ryVar == null || f12Var == null) {
            return;
        }
        this.D.reset();
        if (!getBounds().isEmpty()) {
            this.D.preTranslate(r2.left, r2.top);
            this.D.preScale(r2.width() / f12Var.b().width(), r2.height() / f12Var.b().height());
        }
        ryVar.i(canvas, this.D, this.v, null);
    }

    public void x0(final int i) {
        if (this.f == null) {
            this.l.add(new a() { // from class: f22
                @Override // g22.a
                public final void a(f12 f12Var) {
                    this.a.x0(i);
                }
            });
        } else {
            this.g.z(i);
        }
    }

    public void y(h22 h22Var, boolean z) {
        boolean zA = this.r.a(h22Var, z);
        if (this.f == null || !zA) {
            return;
        }
        s();
    }

    public void y0(boolean z) {
        this.i = z;
    }

    public void z() {
        this.l.clear();
        this.g.j();
        if (isVisible()) {
            return;
        }
        this.k = b.NONE;
    }

    public void z0(ei1 ei1Var) {
        fi1 fi1Var = this.m;
        if (fi1Var != null) {
            fi1Var.d(ei1Var);
        }
    }
}
