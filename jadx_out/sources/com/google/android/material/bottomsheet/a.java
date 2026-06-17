package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.insets.ProtectionLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import defpackage.d63;
import defpackage.e55;
import defpackage.g2;
import defpackage.gm3;
import defpackage.h62;
import defpackage.l35;
import defpackage.l62;
import defpackage.mk3;
import defpackage.ol3;
import defpackage.p95;
import defpackage.pq0;
import defpackage.q8;
import defpackage.r1;
import defpackage.t52;
import defpackage.w95;
import defpackage.ym3;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a extends q8 {
    public BottomSheetBehavior k;
    public FrameLayout l;
    public CoordinatorLayout m;
    public FrameLayout n;
    public ProtectionLayout o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public f t;
    public boolean u;
    public t52 v;
    public List w;
    public BottomSheetBehavior.g x;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0061a implements d63 {
        public C0061a() {
        }

        @Override // defpackage.d63
        public w95 a(View view, w95 w95Var) {
            if (a.this.t != null) {
                a.this.k.Q0(a.this.t);
            }
            if (w95Var != null) {
                a aVar = a.this;
                aVar.t = new f(aVar.n, w95Var, null);
                a.this.t.e(a.this.getWindow());
                a.this.k.h0(a.this.t);
            }
            return w95Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.q && aVar.isShowing() && a.this.r()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends r1 {
        public c() {
        }

        @Override // defpackage.r1
        public void g(View view, g2 g2Var) {
            super.g(view, g2Var);
            if (!a.this.q) {
                g2Var.q0(false);
            } else {
                g2Var.a(1048576);
                g2Var.q0(true);
            }
        }

        @Override // defpackage.r1
        public boolean j(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                a aVar = a.this;
                if (aVar.q) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends BottomSheetBehavior.g {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i) {
            if (i == 5) {
                a.this.cancel();
            }
        }
    }

    public a(Context context, int i) {
        super(context, e(context, i));
        this.q = true;
        this.r = true;
        this.x = new e();
        g(1);
        o();
    }

    public static int e(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(mk3.d, typedValue, true) ? typedValue.resourceId : ym3.h;
    }

    private void o() {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{mk3.p});
        this.u = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior bottomSheetBehaviorM = m();
        if (!this.p || bottomSheetBehaviorM.getState() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorM.a(5);
        }
    }

    public final FrameLayout l() {
        if (this.l == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), gm3.b, null);
            this.l = frameLayout;
            this.o = (ProtectionLayout) frameLayout.findViewById(ol3.q);
            List list = this.w;
            if (list != null) {
                q(list);
            }
            this.m = (CoordinatorLayout) this.l.findViewById(ol3.b);
            FrameLayout frameLayout2 = (FrameLayout) this.l.findViewById(ol3.c);
            this.n = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorX0 = BottomSheetBehavior.x0(frameLayout2);
            this.k = bottomSheetBehaviorX0;
            bottomSheetBehaviorX0.h0(this.x);
            this.k.b1(this.q);
            this.v = new t52(this.k, this.n);
        }
        return this.l;
    }

    public BottomSheetBehavior m() {
        if (this.k == null) {
            l();
        }
        return this.k;
    }

    public boolean n() {
        return this.p;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.u && Color.alpha(pq0.a(window)) < 255;
            FrameLayout frameLayout = this.l;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.m;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            p95.b(window, !z);
            f fVar = this.t;
            if (fVar != null) {
                fVar.e(window);
            }
        }
        s();
    }

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

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.t;
        if (fVar != null) {
            fVar.e(null);
        }
        t52 t52Var = this.v;
        if (t52Var != null) {
            t52Var.d();
        }
    }

    @Override // defpackage.my, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.k;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.k.a(4);
    }

    public void p() {
        this.k.Q0(this.x);
    }

    public void q(List list) {
        this.w = list;
        ProtectionLayout protectionLayout = this.o;
        if (protectionLayout != null) {
            protectionLayout.setProtections(list);
            this.o.setVisibility(list.isEmpty() ? 8 : 0);
        }
    }

    public boolean r() {
        if (!this.s) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.r = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.s = true;
        }
        return this.r;
    }

    public final void s() {
        t52 t52Var = this.v;
        if (t52Var == null) {
            return;
        }
        if (this.q) {
            t52Var.b();
        } else {
            t52Var.d();
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.q != z) {
            this.q = z;
            BottomSheetBehavior bottomSheetBehavior = this.k;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.b1(z);
            }
            if (getWindow() != null) {
                s();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.q) {
            this.q = true;
        }
        this.r = z;
        this.s = true;
    }

    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(t(0, view, null));
    }

    public final View t(int i, View view, ViewGroup.LayoutParams layoutParams) {
        l();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.l.findViewById(ol3.b);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.u) {
            l35.p0(this.l, new C0061a());
        }
        this.n.removeAllViews();
        FrameLayout frameLayout = this.n;
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(ol3.A).setOnClickListener(new b());
        l35.g0(this.n, new c());
        this.n.setOnTouchListener(new d());
        return this.l;
    }

    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(t(i, null, null));
    }

    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(t(0, view, layoutParams));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends BottomSheetBehavior.g {
        public final Boolean a;
        public final w95 b;
        public Window c;
        public boolean d;

        public f(View view, w95 w95Var) {
            this.b = w95Var;
            l62 l62VarA0 = BottomSheetBehavior.x0(view).A0();
            ColorStateList colorStateListC = l62VarA0 != null ? l62VarA0.C() : view.getBackgroundTintList();
            if (colorStateListC != null) {
                this.a = Boolean.valueOf(h62.h(colorStateListC.getDefaultColor()));
                return;
            }
            Integer numC = e55.c(view);
            if (numC != null) {
                this.a = Boolean.valueOf(h62.h(numC.intValue()));
            } else {
                this.a = null;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i) {
            d(view);
        }

        public final void d(View view) {
            if (view.getTop() < this.b.l()) {
                Window window = this.c;
                if (window != null) {
                    Boolean bool = this.a;
                    pq0.b(window, bool == null ? this.d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.b.l() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.c;
                if (window2 != null) {
                    pq0.b(window2, this.d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void e(Window window) {
            if (this.c == window) {
                return;
            }
            this.c = window;
            if (window != null) {
                this.d = p95.a(window, window.getDecorView()).b();
            }
        }

        public /* synthetic */ f(View view, w95 w95Var, C0061a c0061a) {
            this(view, w95Var);
        }
    }
}
