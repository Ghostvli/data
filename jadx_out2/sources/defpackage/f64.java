package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f64 extends q8 {
    public static final int u = ol3.b;
    public static final int v = ol3.A;
    public b64 k;
    public FrameLayout l;
    public CoordinatorLayout m;
    public FrameLayout n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public t52 t;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends r1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public void g(View view, g2 g2Var) {
            super.g(view, g2Var);
            if (!f64.this.p) {
                g2Var.q0(false);
            } else {
                g2Var.a(1048576);
                g2Var.q0(true);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public boolean j(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                f64 f64Var = f64.this;
                if (f64Var.p) {
                    f64Var.cancel();
                    return true;
                }
            }
            return super.j(view, i, bundle);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f64(Context context, int i, int i2, int i3) {
        super(context, r(context, i, i2, i3));
        this.p = true;
        this.q = true;
        this.s = true;
        g(1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void h(f64 f64Var, View view) {
        if (f64Var.p && f64Var.isShowing() && f64Var.t()) {
            f64Var.cancel();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int r(Context context, int i, int i2, int i3) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i2, typedValue, true) ? typedValue.resourceId : i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean t() {
        if (!this.r) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.q = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.r = true;
        }
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void v() {
        t52 t52Var = this.t;
        if (t52Var == null) {
            return;
        }
        if (this.p) {
            t52Var.b();
        } else {
            t52Var.d();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        b64 b64VarK = k();
        if (!this.o || b64VarK.getState() == 5) {
            super.cancel();
        } else {
            b64VarK.a(5);
        }
    }

    public abstract void i(b64 b64Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        if (this.l == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), o(), null);
            this.l = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(n());
            this.n = frameLayout2;
            b64 b64VarL = l(frameLayout2);
            this.k = b64VarL;
            i(b64VarL);
            this.t = new t52(this.k, this.n);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b64 k() {
        if (this.k == null) {
            j();
        }
        return this.k;
    }

    public abstract b64 l(FrameLayout frameLayout);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final FrameLayout m() {
        if (this.l == null) {
            j();
        }
        return this.l;
    }

    public abstract int n();

    public abstract int o();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
        u();
        v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            pq0.c(window, 0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t52 t52Var = this.t;
        if (t52Var != null) {
            t52Var.d();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.my, android.app.Dialog
    public void onStart() {
        super.onStart();
        b64 b64Var = this.k;
        if (b64Var == null || b64Var.getState() != 5) {
            return;
        }
        this.k.a(q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final FrameLayout p() {
        if (this.n == null) {
            j();
        }
        return this.n;
    }

    public abstract int q();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s() {
        FrameLayout frameLayout;
        Window window = getWindow();
        if (window == null || (frameLayout = this.n) == null || !(frameLayout.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return;
        }
        window.setWindowAnimations(Gravity.getAbsoluteGravity(((CoordinatorLayout.f) this.n.getLayoutParams()).c, this.n.getLayoutDirection()) == 3 ? ym3.a : ym3.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.p != z) {
            this.p = z;
        }
        if (getWindow() != null) {
            v();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.p) {
            this.p = true;
        }
        this.q = z;
        this.r = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(w(0, view, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        FrameLayout frameLayout = this.l;
        if (frameLayout != null) {
            frameLayout.setFitsSystemWindows(this.s);
        }
        CoordinatorLayout coordinatorLayout = this.m;
        if (coordinatorLayout != null) {
            coordinatorLayout.setFitsSystemWindows(this.s);
        }
        Window window = getWindow();
        if (window != null) {
            p95.b(window, this.s);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View w(int i, View view, ViewGroup.LayoutParams layoutParams) {
        j();
        this.m = (CoordinatorLayout) m().findViewById(u);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) this.m, false);
        }
        FrameLayout frameLayoutP = p();
        frameLayoutP.removeAllViews();
        if (layoutParams == null) {
            frameLayoutP.addView(view);
        } else {
            frameLayoutP.addView(view, layoutParams);
        }
        this.m.findViewById(v).setOnClickListener(new View.OnClickListener() { // from class: e64
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f64.h(this.f, view2);
            }
        });
        l35.g0(p(), new a());
        return this.l;
    }

    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(w(i, null, null));
    }

    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(w(0, view, layoutParams));
    }
}
