package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y45 extends yi {
    public static boolean k;
    public static int l = ml3.a;
    public final View f;
    public final a g;
    public View.OnAttachStateChangeListener h;
    public boolean i;
    public boolean j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static Integer e;
        public final View a;
        public final List b = new ArrayList();
        public boolean c;
        public ViewTreeObserverOnPreDrawListenerC0137a d;

        /* JADX INFO: renamed from: y45$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class ViewTreeObserverOnPreDrawListenerC0137a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference f;

            public ViewTreeObserverOnPreDrawListenerC0137a(a aVar) {
                this.f = new WeakReference(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.f.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.a = view;
        }

        public static int c(Context context) {
            if (e == null) {
                Display defaultDisplay = ((WindowManager) fg3.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        public void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        public void d(j94 j94Var) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j94Var.e(iG, iF);
                return;
            }
            if (!this.b.contains(j94Var)) {
                this.b.add(j94Var);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0137a viewTreeObserverOnPreDrawListenerC0137a = new ViewTreeObserverOnPreDrawListenerC0137a(this);
                this.d = viewTreeObserverOnPreDrawListenerC0137a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0137a);
            }
        }

        public final int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.a.getContext());
        }

        public final int f() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        public final boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        public final void j(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((j94) it.next()).e(i, i2);
            }
        }

        public void k(j94 j94Var) {
            this.b.remove(j94Var);
        }
    }

    public y45(View view) {
        this.f = (View) fg3.e(view);
        this.g = new a(view);
    }

    @Override // defpackage.rl4
    public void a(j94 j94Var) {
        this.g.d(j94Var);
    }

    public final Object c() {
        return this.f.getTag(l);
    }

    public final void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.h;
        if (onAttachStateChangeListener == null || this.j) {
            return;
        }
        this.f.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.j = true;
    }

    @Override // defpackage.rl4
    public void f(yq3 yq3Var) {
        n(yq3Var);
    }

    public final void g() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.h;
        if (onAttachStateChangeListener == null || !this.j) {
            return;
        }
        this.f.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.j = false;
    }

    @Override // defpackage.rl4
    public void i(j94 j94Var) {
        this.g.k(j94Var);
    }

    @Override // defpackage.yi, defpackage.rl4
    public void k(Drawable drawable) {
        super.k(drawable);
        e();
    }

    @Override // defpackage.rl4
    public yq3 l() {
        Object objC = c();
        if (objC != null) {
            if (objC instanceof yq3) {
                return (yq3) objC;
            }
            jl.a("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // defpackage.yi, defpackage.rl4
    public void m(Drawable drawable) {
        super.m(drawable);
        this.g.b();
        if (this.i) {
            return;
        }
        g();
    }

    public final void n(Object obj) {
        k = true;
        this.f.setTag(l, obj);
    }

    public String toString() {
        return "Target for: " + this.f;
    }
}
