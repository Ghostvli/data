package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.a;
import defpackage.an4;
import defpackage.c93;
import defpackage.cn3;
import defpackage.cn4;
import defpackage.d33;
import defpackage.dp4;
import defpackage.e55;
import defpackage.e60;
import defpackage.e9;
import defpackage.gm3;
import defpackage.jl;
import defpackage.k62;
import defpackage.k9;
import defpackage.ol3;
import defpackage.pp0;
import defpackage.rh1;
import defpackage.ss0;
import defpackage.tm3;
import defpackage.tn0;
import defpackage.vu;
import defpackage.w82;
import defpackage.zk3;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a extends LinearLayout {
    public final TextWatcher A;
    public final TextInputLayout.g B;
    public final TextInputLayout f;
    public final FrameLayout g;
    public final CheckableImageButton h;
    public ColorStateList i;
    public PorterDuff.Mode j;
    public View.OnLongClickListener k;
    public final CheckableImageButton l;
    public final d m;
    public int n;
    public final LinkedHashSet o;
    public ColorStateList p;
    public PorterDuff.Mode q;
    public int r;
    public ImageView.ScaleType s;
    public View.OnLongClickListener t;
    public CharSequence u;
    public final TextView v;
    public boolean w;
    public EditText x;
    public final AccessibilityManager y;
    public AccessibilityManager.TouchExplorationStateChangeListener z;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0068a extends cn4 {
        public C0068a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.o().a(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            a.this.o().b(charSequence, i, i2, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements TextInputLayout.g {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout) {
            if (a.this.x == textInputLayout.getEditText()) {
                return;
            }
            if (a.this.x != null) {
                a.this.x.removeTextChangedListener(a.this.A);
                if (a.this.x.getOnFocusChangeListener() == a.this.o().e()) {
                    a.this.x.setOnFocusChangeListener(null);
                }
            }
            a.this.x = textInputLayout.getEditText();
            if (a.this.x != null) {
                a.this.x.addTextChangedListener(a.this.A);
            }
            a.this.o().n(a.this.x);
            a aVar = a.this;
            aVar.j0(aVar.o());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a.this.i();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a.this.O();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final SparseArray a = new SparseArray();
        public final a b;
        public final int c;
        public final int d;

        public d(a aVar, dp4 dp4Var) {
            this.b = aVar;
            this.c = dp4Var.n(cn3.A7, 0);
            this.d = dp4Var.n(cn3.Z7, 0);
        }

        public final ss0 b(int i) {
            if (i == -1) {
                return new e60(this.b);
            }
            if (i == 0) {
                return new d33(this.b);
            }
            if (i == 1) {
                return new c93(this.b, this.d);
            }
            if (i == 2) {
                return new vu(this.b);
            }
            if (i == 3) {
                return new pp0(this.b);
            }
            defpackage.b.a("Invalid end icon mode: ", i);
            return null;
        }

        public ss0 c(int i) {
            ss0 ss0Var = (ss0) this.a.get(i);
            if (ss0Var != null) {
                return ss0Var;
            }
            ss0 ss0VarB = b(i);
            this.a.append(i, ss0VarB);
            return ss0VarB;
        }
    }

    public a(TextInputLayout textInputLayout, dp4 dp4Var) {
        super(textInputLayout.getContext());
        this.n = 0;
        this.o = new LinkedHashSet();
        this.A = new C0068a();
        b bVar = new b();
        this.B = bVar;
        this.y = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.g = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonK = k(this, layoutInflaterFrom, ol3.t);
        this.h = checkableImageButtonK;
        CheckableImageButton checkableImageButtonK2 = k(frameLayout, layoutInflaterFrom, ol3.s);
        this.l = checkableImageButtonK2;
        this.m = new d(this, dp4Var);
        k9 k9Var = new k9(getContext());
        this.v = k9Var;
        E(dp4Var);
        D(dp4Var);
        F(dp4Var);
        frameLayout.addView(checkableImageButtonK2);
        addView(k9Var);
        addView(frameLayout);
        addView(checkableImageButtonK);
        checkableImageButtonK.setOnFocusableChangedListener(new CheckableImageButton.b() { // from class: qs0
            @Override // com.google.android.material.internal.CheckableImageButton.b
            public final void a(View view, boolean z) {
                a.a(this.a, view, z);
            }
        });
        checkableImageButtonK2.setOnFocusableChangedListener(new CheckableImageButton.b() { // from class: rs0
            @Override // com.google.android.material.internal.CheckableImageButton.b
            public final void a(View view, boolean z) {
                a aVar = this.a;
                rh1.k(aVar.l, aVar.t, aVar.n());
            }
        });
        textInputLayout.j(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public static /* synthetic */ void a(a aVar, View view, boolean z) {
        CheckableImageButton checkableImageButton = aVar.h;
        rh1.k(checkableImageButton, aVar.k, checkableImageButton.getContentDescription());
    }

    public int A() {
        return getPaddingEnd() + this.v.getPaddingEnd() + ((H() || I()) ? this.l.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).getMarginStart() : 0);
    }

    public final void A0() {
        int visibility = this.v.getVisibility();
        int i = (this.u == null || this.w) ? 8 : 0;
        if (visibility != i) {
            o().q(i == 0);
        }
        x0();
        this.v.setVisibility(i);
        this.f.p0();
    }

    public TextView B() {
        return this.v;
    }

    public boolean C() {
        return this.n != 0;
    }

    public final void D(dp4 dp4Var) {
        if (!dp4Var.s(cn3.a8)) {
            if (dp4Var.s(cn3.E7)) {
                this.p = k62.a(getContext(), dp4Var, cn3.E7);
            }
            if (dp4Var.s(cn3.F7)) {
                this.q = e55.g(dp4Var.k(cn3.F7, -1), null);
            }
        }
        if (dp4Var.s(cn3.C7)) {
            W(dp4Var.k(cn3.C7, 0));
            if (dp4Var.s(cn3.z7)) {
                S(dp4Var.p(cn3.z7));
            }
            Q(dp4Var.a(cn3.y7, true));
        } else if (dp4Var.s(cn3.a8)) {
            if (dp4Var.s(cn3.b8)) {
                this.p = k62.a(getContext(), dp4Var, cn3.b8);
            }
            if (dp4Var.s(cn3.c8)) {
                this.q = e55.g(dp4Var.k(cn3.c8, -1), null);
            }
            W(dp4Var.a(cn3.a8, false) ? 1 : 0);
            S(dp4Var.p(cn3.Y7));
        }
        V(dp4Var.f(cn3.B7, getResources().getDimensionPixelSize(zk3.d0)));
        if (dp4Var.s(cn3.D7)) {
            Z(rh1.b(dp4Var.k(cn3.D7, -1)));
        }
    }

    public final void E(dp4 dp4Var) {
        if (dp4Var.s(cn3.K7)) {
            this.i = k62.a(getContext(), dp4Var, cn3.K7);
        }
        if (dp4Var.s(cn3.L7)) {
            this.j = e55.g(dp4Var.k(cn3.L7, -1), null);
        }
        if (dp4Var.s(cn3.J7)) {
            e0(dp4Var.g(cn3.J7));
        }
        this.h.setContentDescription(getResources().getText(tm3.h));
        this.h.setImportantForAccessibility(2);
        this.h.setClickable(false);
        this.h.setPressable(false);
        this.h.setCheckable(false);
        this.h.setFocusable(false);
    }

    public final void F(dp4 dp4Var) {
        this.v.setVisibility(8);
        this.v.setId(ol3.z);
        this.v.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        this.v.setAccessibilityLiveRegion(1);
        s0(dp4Var.n(cn3.r8, 0));
        if (dp4Var.s(cn3.s8)) {
            t0(dp4Var.c(cn3.s8));
        }
        r0(dp4Var.p(cn3.q8));
    }

    public boolean G() {
        return C() && this.l.isChecked();
    }

    public boolean H() {
        return this.g.getVisibility() == 0 && this.l.getVisibility() == 0;
    }

    public boolean I() {
        return this.h.getVisibility() == 0;
    }

    public void J(boolean z) {
        this.w = z;
        A0();
    }

    public void K() {
        y0();
        M();
        L();
        if (o().t()) {
            w0(this.f.d0());
        }
    }

    public void L() {
        rh1.d(this.f, this.l, this.p);
    }

    public void M() {
        rh1.d(this.f, this.h, this.i);
    }

    public void N(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean zIsChecked;
        ss0 ss0VarO = o();
        boolean z3 = true;
        if (!ss0VarO.l() || (zIsChecked = this.l.isChecked()) == ss0VarO.m()) {
            z2 = false;
        } else {
            this.l.setChecked(!zIsChecked);
            z2 = true;
        }
        if (!ss0VarO.j() || (zIsActivated = this.l.isActivated()) == ss0VarO.k()) {
            z3 = z2;
        } else {
            P(!zIsActivated);
        }
        if (z || z3) {
            L();
        }
    }

    public final void O() {
        AccessibilityManager accessibilityManager;
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.z;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.y) == null) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }

    public void P(boolean z) {
        this.l.setActivated(z);
    }

    public void Q(boolean z) {
        this.l.setCheckable(z);
    }

    public void R(int i) {
        S(i != 0 ? getResources().getText(i) : null);
    }

    public void S(CharSequence charSequence) {
        if (n() != charSequence) {
            this.l.setContentDescription(charSequence);
            rh1.k(this.l, this.t, charSequence);
        }
    }

    public void T(int i) {
        U(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void U(Drawable drawable) {
        this.l.setImageDrawable(drawable);
        if (drawable != null) {
            rh1.a(this.f, this.l, this.p, this.q);
            L();
        }
    }

    public void V(int i) {
        if (i < 0) {
            jl.a("endIconSize cannot be less than 0");
        } else if (i != this.r) {
            this.r = i;
            rh1.g(this.l, i);
            rh1.g(this.h, i);
        }
    }

    public void W(int i) {
        if (this.n == i) {
            return;
        }
        v0(o());
        int i2 = this.n;
        this.n = i;
        l(i2);
        c0(i != 0);
        ss0 ss0VarO = o();
        T(v(ss0VarO));
        Q(ss0VarO.l());
        if (!ss0VarO.i(this.f.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        u0(ss0VarO);
        X(ss0VarO.f());
        R(ss0VarO.c());
        EditText editText = this.x;
        if (editText != null) {
            ss0VarO.n(editText);
            j0(ss0VarO);
        }
        rh1.a(this.f, this.l, this.p, this.q);
        N(true);
    }

    public void X(View.OnClickListener onClickListener) {
        rh1.h(this.l, onClickListener, this.t);
    }

    public void Y(View.OnLongClickListener onLongClickListener) {
        this.t = onLongClickListener;
        rh1.i(this.l, onLongClickListener);
    }

    public void Z(ImageView.ScaleType scaleType) {
        this.s = scaleType;
        rh1.j(this.l, scaleType);
        rh1.j(this.h, scaleType);
    }

    public void a0(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            rh1.a(this.f, this.l, colorStateList, this.q);
        }
    }

    public void b0(PorterDuff.Mode mode) {
        if (this.q != mode) {
            this.q = mode;
            rh1.a(this.f, this.l, this.p, mode);
        }
    }

    public void c0(boolean z) {
        if (H() != z) {
            this.l.setVisibility(z ? 0 : 8);
            x0();
            z0();
            this.f.p0();
        }
    }

    public void d0(int i) {
        e0(i != 0 ? e9.b(getContext(), i) : null);
        M();
    }

    public void e0(Drawable drawable) {
        this.h.setImageDrawable(drawable);
        y0();
        rh1.a(this.f, this.h, this.i, this.j);
    }

    public void f0(View.OnClickListener onClickListener) {
        rh1.h(this.h, onClickListener, this.k);
    }

    public void g0(View.OnLongClickListener onLongClickListener) {
        this.k = onLongClickListener;
        rh1.i(this.h, onLongClickListener);
    }

    public void h0(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            rh1.a(this.f, this.h, colorStateList, this.j);
        }
    }

    public final void i() {
        if (this.z == null || this.y == null || !isAttachedToWindow()) {
            return;
        }
        this.y.addTouchExplorationStateChangeListener(this.z);
    }

    public void i0(PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            rh1.a(this.f, this.h, this.i, mode);
        }
    }

    public void j() {
        this.l.performClick();
        this.l.jumpDrawablesToCurrentState();
    }

    public final void j0(ss0 ss0Var) {
        if (this.x == null) {
            return;
        }
        if (ss0Var.e() != null) {
            this.x.setOnFocusChangeListener(ss0Var.e());
        }
        if (ss0Var.g() != null) {
            this.l.setOnFocusChangeListener(ss0Var.g());
        }
    }

    public final CheckableImageButton k(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(gm3.e, viewGroup, false);
        checkableImageButton.setId(i);
        rh1.e(checkableImageButton);
        if (k62.k(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public void k0(int i) {
        l0(i != 0 ? getResources().getText(i) : null);
    }

    public final void l(int i) {
        Iterator it = this.o.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
    }

    public void l0(CharSequence charSequence) {
        this.l.setContentDescription(charSequence);
    }

    public CheckableImageButton m() {
        if (I()) {
            return this.h;
        }
        if (C() && H()) {
            return this.l;
        }
        return null;
    }

    public void m0(int i) {
        n0(i != 0 ? e9.b(getContext(), i) : null);
    }

    public CharSequence n() {
        return this.l.getContentDescription();
    }

    public void n0(Drawable drawable) {
        this.l.setImageDrawable(drawable);
    }

    public ss0 o() {
        return this.m.c(this.n);
    }

    public void o0(boolean z) {
        if (z && this.n != 1) {
            W(1);
        } else {
            if (z) {
                return;
            }
            W(0);
        }
    }

    public Drawable p() {
        return this.l.getDrawable();
    }

    public void p0(ColorStateList colorStateList) {
        this.p = colorStateList;
        rh1.a(this.f, this.l, colorStateList, this.q);
    }

    public int q() {
        return this.r;
    }

    public void q0(PorterDuff.Mode mode) {
        this.q = mode;
        rh1.a(this.f, this.l, this.p, mode);
    }

    public int r() {
        return this.n;
    }

    public void r0(CharSequence charSequence) {
        this.u = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.v.setText(charSequence);
        A0();
    }

    public ImageView.ScaleType s() {
        return this.s;
    }

    public void s0(int i) {
        an4.m(this.v, i);
    }

    public CheckableImageButton t() {
        return this.l;
    }

    public void t0(ColorStateList colorStateList) {
        this.v.setTextColor(colorStateList);
    }

    public Drawable u() {
        return this.h.getDrawable();
    }

    public final void u0(ss0 ss0Var) {
        ss0Var.s();
        this.z = ss0Var.h();
        i();
    }

    public final int v(ss0 ss0Var) {
        int i = this.m.c;
        return i == 0 ? ss0Var.d() : i;
    }

    public final void v0(ss0 ss0Var) {
        O();
        this.z = null;
        ss0Var.u();
    }

    public CharSequence w() {
        return this.l.getContentDescription();
    }

    public final void w0(boolean z) {
        if (!z || p() == null) {
            rh1.a(this.f, this.l, this.p, this.q);
            return;
        }
        Drawable drawableMutate = tn0.r(p()).mutate();
        drawableMutate.setTint(this.f.getErrorCurrentTextColors());
        this.l.setImageDrawable(drawableMutate);
    }

    public Drawable x() {
        return this.l.getDrawable();
    }

    public final void x0() {
        this.g.setVisibility((this.l.getVisibility() != 0 || I()) ? 8 : 0);
        setVisibility((H() || I() || ((this.u == null || this.w) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public CharSequence y() {
        return this.u;
    }

    public final void y0() {
        this.h.setVisibility(u() != null && this.f.O() && this.f.d0() ? 0 : 8);
        x0();
        z0();
        if (C()) {
            return;
        }
        this.f.p0();
    }

    public ColorStateList z() {
        return this.v.getTextColors();
    }

    public void z0() {
        if (this.f.j == null) {
            return;
        }
        this.v.setPaddingRelative(getContext().getResources().getDimensionPixelSize(zk3.R), this.f.j.getPaddingTop(), (H() || I()) ? 0 : this.f.j.getPaddingEnd(), this.f.j.getPaddingBottom());
    }
}
