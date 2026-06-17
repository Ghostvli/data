package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xp4 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static xp4 p;
    public static xp4 q;
    public final View f;
    public final CharSequence g;
    public final int h;
    public final Runnable i = new Runnable() { // from class: vp4
        @Override // java.lang.Runnable
        public final void run() {
            this.f.h(false);
        }
    };
    public final Runnable j = new Runnable() { // from class: wp4
        @Override // java.lang.Runnable
        public final void run() {
            this.f.d();
        }
    };
    public int k;
    public int l;
    public zp4 m;
    public boolean n;
    public boolean o;

    public xp4(View view, CharSequence charSequence) {
        this.f = view;
        this.g = charSequence;
        this.h = o35.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void f(xp4 xp4Var) {
        xp4 xp4Var2 = p;
        if (xp4Var2 != null) {
            xp4Var2.b();
        }
        p = xp4Var;
        if (xp4Var != null) {
            xp4Var.e();
        }
    }

    public static void g(View view, CharSequence charSequence) {
        xp4 xp4Var = p;
        if (xp4Var != null && xp4Var.f == view) {
            f(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new xp4(view, charSequence);
            return;
        }
        xp4 xp4Var2 = q;
        if (xp4Var2 != null && xp4Var2.f == view) {
            xp4Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f.removeCallbacks(this.i);
    }

    public final void c() {
        this.o = true;
    }

    public void d() {
        if (q == this) {
            q = null;
            zp4 zp4Var = this.m;
            if (zp4Var != null) {
                zp4Var.c();
                this.m = null;
                c();
                this.f.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (p == this) {
            f(null);
        }
        this.f.removeCallbacks(this.j);
    }

    public final void e() {
        this.f.postDelayed(this.i, ViewConfiguration.getLongPressTimeout());
    }

    public void h(boolean z) {
        long longPressTimeout;
        long j;
        long j2;
        if (this.f.isAttachedToWindow()) {
            f(null);
            xp4 xp4Var = q;
            if (xp4Var != null) {
                xp4Var.d();
            }
            q = this;
            this.n = z;
            zp4 zp4Var = new zp4(this.f.getContext());
            this.m = zp4Var;
            zp4Var.e(this.f, this.k, this.l, this.n, this.g);
            this.f.addOnAttachStateChangeListener(this);
            if (this.n) {
                j2 = 2500;
            } else {
                if ((l35.H(this.f) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            this.f.removeCallbacks(this.j);
            this.f.postDelayed(this.j, j2);
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!this.o && Math.abs(x - this.k) <= this.h && Math.abs(y - this.l) <= this.h) {
            return false;
        }
        this.k = x;
        this.l = y;
        this.o = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.m != null && this.n) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f.isEnabled() && this.m == null && i(motionEvent)) {
            f(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.k = view.getWidth() / 2;
        this.l = view.getHeight() / 2;
        h(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
