package com.google.android.material.button;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import defpackage.a8;
import defpackage.c62;
import defpackage.cn3;
import defpackage.dd4;
import defpackage.dn4;
import defpackage.e04;
import defpackage.e55;
import defpackage.e9;
import defpackage.ed4;
import defpackage.he4;
import defpackage.ie4;
import defpackage.jl;
import defpackage.k62;
import defpackage.l62;
import defpackage.lu2;
import defpackage.m62;
import defpackage.mk3;
import defpackage.o62;
import defpackage.p;
import defpackage.r54;
import defpackage.tn0;
import defpackage.v21;
import defpackage.w82;
import defpackage.x44;
import defpackage.y44;
import defpackage.ym3;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends a8 implements Checkable, r54 {
    public static final int[] Q = {R.attr.state_checkable};
    public static final int[] R = {R.attr.state_checked};
    public static final int S = ym3.t;
    public static final int T = mk3.z;
    public static final v21 U = new a("widthIncrease");
    public int A;
    public int B;
    public int C;
    public float D;
    public int E;
    public int F;
    public LinearLayout.LayoutParams G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public d M;
    public float N;
    public float O;
    public dd4 P;
    public final c62 i;
    public final LinkedHashSet j;
    public PorterDuff.Mode k;
    public ColorStateList l;
    public Drawable m;
    public PorterDuff.Mode n;
    public ColorStateList o;
    public Drawable p;
    public boolean q;
    public String r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends v21 {
        public a(String str) {
            super(str);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(MaterialButton materialButton) {
            return materialButton.getDisplayedWidthIncrease();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MaterialButton materialButton, float f) {
            materialButton.setDisplayedWidthIncrease(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum d {
        NONE,
        START,
        END,
        BOTH
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        int i2 = S;
        super(o62.e(context, attributeSet, i, i2, new int[]{T}), attributeSet, i);
        this.j = new LinkedHashSet();
        this.y = false;
        this.z = false;
        this.C = Integer.MIN_VALUE;
        this.D = -2.1474836E9f;
        this.E = Integer.MIN_VALUE;
        this.F = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.M = d.BOTH;
        Context context2 = getContext();
        TypedArray typedArrayI = dn4.i(context2, attributeSet, cn3.V2, i, i2, new int[0]);
        this.v = typedArrayI.getDimensionPixelSize(cn3.j3, 0);
        int i3 = typedArrayI.getInt(cn3.m3, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.k = e55.g(i3, mode);
        this.l = k62.b(getContext(), typedArrayI, cn3.l3);
        this.m = k62.e(getContext(), typedArrayI, cn3.h3);
        this.A = typedArrayI.getInteger(cn3.i3, 1);
        this.s = typedArrayI.getDimensionPixelSize(cn3.k3, 0);
        this.n = e55.g(typedArrayI.getInt(cn3.s3, -1), mode);
        this.o = typedArrayI.hasValue(cn3.r3) ? k62.b(getContext(), typedArrayI, cn3.r3) : this.l;
        this.B = typedArrayI.getInteger(cn3.q3, 3);
        Drawable drawableE = k62.e(getContext(), typedArrayI, cn3.p3);
        this.p = drawableE;
        this.q = drawableE == null;
        x44 x44VarF = he4.f(context2, typedArrayI, cn3.t3);
        x44VarF = x44VarF == null ? y44.i(context2, attributeSet, i, i2).m() : x44VarF;
        boolean z = typedArrayI.getBoolean(cn3.n3, false);
        c62 c62Var = new c62(this, x44VarF);
        this.i = c62Var;
        c62Var.t(typedArrayI);
        setCheckedInternal(typedArrayI.getBoolean(cn3.X2, false));
        if (x44VarF instanceof he4) {
            c62Var.z(k());
        }
        setOpticalCenterEnabled(z);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.v);
        C(this.m != null);
        F(this.p != null);
    }

    public static /* synthetic */ void b(MaterialButton materialButton) {
        materialButton.I = materialButton.getOpticalCenterShift();
        materialButton.E();
        materialButton.invalidate();
    }

    public static /* synthetic */ void e(MaterialButton materialButton, Runnable runnable) {
        materialButton.getClass();
        runnable.run();
        materialButton.B();
        materialButton.requestLayout();
    }

    public static /* synthetic */ void f(MaterialButton materialButton, float f) {
        int i = (int) (f * 0.11f);
        if (materialButton.I != i) {
            materialButton.I = i;
            materialButton.E();
            materialButton.invalidate();
        }
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.N;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        l62 l62VarG;
        if (this.H && this.J && (l62VarG = this.i.g()) != null) {
            return (int) (l62VarG.A() * 0.11f);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z) {
        if (!p() || this.y == z) {
            return;
        }
        this.y = z;
        refreshDrawableState();
        getParent();
        if (this.z) {
            return;
        }
        this.z = true;
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
        this.z = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f) {
        if (this.N != f) {
            this.N = f;
            E();
            invalidate();
            getParent();
        }
    }

    public final boolean A(final Runnable runnable) {
        dd4 dd4Var = this.P;
        if (dd4Var == null || !dd4Var.g()) {
            return false;
        }
        post(new Runnable() { // from class: b62
            @Override // java.lang.Runnable
            public final void run() {
                MaterialButton.e(this.f, runnable);
            }
        });
        return true;
    }

    public void B() {
        LinearLayout.LayoutParams layoutParams = this.G;
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
            this.G = null;
            this.D = -2.1474836E9f;
        }
    }

    public final void C(boolean z) {
        Drawable drawable = this.m;
        if (drawable != null) {
            Drawable drawableMutate = tn0.r(drawable).mutate();
            this.m = drawableMutate;
            drawableMutate.setTintList(this.l);
            PorterDuff.Mode mode = this.k;
            if (mode != null) {
                this.m.setTintMode(mode);
            }
            int intrinsicWidth = this.s;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.m.getIntrinsicWidth();
            }
            int intrinsicHeight = this.s;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.m.getIntrinsicHeight();
            }
            Drawable drawable2 = this.m;
            int i = this.t;
            int i2 = this.u;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.m.setVisible(true, z);
        }
        H();
        if (this.m == null && this.p != null && i()) {
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (r() && compoundDrawablesRelative[0] != this.m) || (q() && compoundDrawablesRelative[2] != this.m) || (s() && compoundDrawablesRelative[1] != this.m);
        if (z || z2) {
            if (r()) {
                setCompoundDrawablesRelative(this.m, n(1), n(2), null);
            } else if (q()) {
                setCompoundDrawablesRelative(n(0), n(1), this.m, null);
            } else if (s()) {
                setCompoundDrawablesRelative(n(0), this.m, n(2), null);
            }
        }
    }

    public final void D(int i, int i2) {
        if (this.m == null || getLayout() == null) {
            return;
        }
        if (r() || q()) {
            this.u = 0;
            if (j(this.A)) {
                this.t = 0;
                C(false);
                return;
            }
            int iL = l(i, this.A);
            if (this.t != iL) {
                this.t = iL;
                C(false);
                return;
            }
            return;
        }
        if (s()) {
            this.t = 0;
            if (this.A == 16) {
                this.u = 0;
                C(false);
                return;
            }
            int intrinsicHeight = this.s;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.m.getIntrinsicHeight();
            }
            int iM = m(i2, intrinsicHeight);
            if (this.u != iM) {
                this.u = iM;
                C(false);
            }
        }
    }

    public final void E() {
        int i = (int) (this.N - this.O);
        int i2 = (i / 2) + this.I;
        getLayoutParams().width = (int) (this.D + i);
        setPaddingRelative(this.E + i2, getPaddingTop(), (this.F + i) - i2, getPaddingBottom());
    }

    public final void F(boolean z) {
        Drawable drawable = this.p;
        if (drawable != null) {
            Drawable drawableMutate = tn0.r(drawable).mutate();
            this.p = drawableMutate;
            drawableMutate.setTintList(this.o);
            PorterDuff.Mode mode = this.n;
            if (mode != null) {
                this.p.setTintMode(mode);
            }
            int intrinsicWidth = this.s;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.p.getIntrinsicWidth();
            }
            int intrinsicHeight = this.s;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.p.getIntrinsicHeight();
            }
            Drawable drawable2 = this.p;
            int i = this.w;
            int i2 = this.x;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.p.setVisible(true, z);
        }
        I();
        if (this.p == null) {
            if (this.q) {
                return;
            }
            if (this.m != null && i()) {
                return;
            }
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (w() && compoundDrawablesRelative[0] != this.p) || (v() && compoundDrawablesRelative[2] != this.p) || (x() && compoundDrawablesRelative[1] != this.p);
        if (z || z2) {
            if (w()) {
                setCompoundDrawablesRelative(this.p, o(1), o(2), null);
            } else if (v()) {
                setCompoundDrawablesRelative(o(0), o(1), this.p, null);
            } else if (x()) {
                setCompoundDrawablesRelative(o(0), this.p, o(2), null);
            }
        }
    }

    public final void G(int i, int i2) {
        if (this.p == null || getLayout() == null) {
            return;
        }
        if (w() || v()) {
            this.x = 0;
            if (j(this.B)) {
                this.w = 0;
                F(false);
                return;
            }
            int iL = l(i, this.B);
            if (this.w != iL) {
                this.w = iL;
                F(false);
                return;
            }
            return;
        }
        if (x()) {
            this.w = 0;
            if (this.B == 16) {
                this.x = 0;
                F(false);
                return;
            }
            int intrinsicHeight = this.s;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.p.getIntrinsicHeight();
            }
            int iM = m(i2, intrinsicHeight);
            if (this.x != iM) {
                this.x = iM;
                F(false);
            }
        }
    }

    public final void H() {
        if (this.m == null || this.p == null || !i()) {
            return;
        }
        jl.a("iconGravity cannot have the same alignment as secondaryIconGravity");
    }

    public final void I() {
        if (this.p == null || this.m == null || !i()) {
            return;
        }
        jl.a("secondaryIconGravity cannot have the same alignment as iconGravity");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.r)) {
            return (p() ? CompoundButton.class : Button.class).getName();
        }
        return this.r;
    }

    public int getAllowedWidthDecrease() {
        return this.K;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (y()) {
            return this.i.b();
        }
        return 0;
    }

    public ed4 getCornerSpringForce() {
        return this.i.c();
    }

    public Drawable getIcon() {
        return this.m;
    }

    public int getIconGravity() {
        return this.A;
    }

    public int getIconPadding() {
        return this.v;
    }

    public int getIconSize() {
        return this.s;
    }

    public ColorStateList getIconTint() {
        return this.l;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.k;
    }

    public int getInsetBottom() {
        return this.i.d();
    }

    public int getInsetTop() {
        return this.i.e();
    }

    public ColorStateList getRippleColor() {
        if (y()) {
            return this.i.i();
        }
        return null;
    }

    public Drawable getSecondaryIcon() {
        return this.p;
    }

    public int getSecondaryIconGravity() {
        return this.B;
    }

    public ColorStateList getSecondaryIconTint() {
        return this.o;
    }

    public PorterDuff.Mode getSecondaryIconTintMode() {
        return this.n;
    }

    public x44 getShapeAppearance() {
        if (y()) {
            return this.i.j();
        }
        e04.a("Attempted to get ShapeAppearance from a MaterialButton which has an overwritten background.");
        return null;
    }

    public y44 getShapeAppearanceModel() {
        if (y()) {
            return this.i.k();
        }
        e04.a("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (y()) {
            return this.i.l();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (y()) {
            return this.i.m();
        }
        return 0;
    }

    @Override // defpackage.a8
    public ColorStateList getSupportBackgroundTintList() {
        return y() ? this.i.n() : super.getSupportBackgroundTintList();
    }

    @Override // defpackage.a8
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return y() ? this.i.o() : super.getSupportBackgroundTintMode();
    }

    public final boolean i() {
        if (r() && w()) {
            return true;
        }
        if (q() && v()) {
            return true;
        }
        return s() && x();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.y;
    }

    public final boolean j(int i) {
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        return i == 1 || i == 3 || (i == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE);
    }

    public final ed4 k() {
        return lu2.h(getContext(), mk3.P, ym3.d);
    }

    public final int l(int i, int i2) {
        int intrinsicWidth;
        int intrinsicWidth2;
        Drawable drawable = this.m;
        if (drawable != null) {
            intrinsicWidth = this.s;
            if (intrinsicWidth == 0) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
        } else {
            intrinsicWidth = 0;
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            intrinsicWidth2 = this.s;
            if (intrinsicWidth2 == 0) {
                intrinsicWidth2 = drawable2.getIntrinsicWidth();
            }
        } else {
            intrinsicWidth2 = 0;
        }
        int textLayoutWidth = (((((i - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - intrinsicWidth2) - this.v) - getPaddingStart();
        if (getActualTextAlignment() == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        return u() != (i2 == 4) ? -textLayoutWidth : textLayoutWidth;
    }

    public final int m(int i, int i2) {
        return Math.max(0, (((((i - getTextHeight()) - getPaddingTop()) - i2) - this.v) - getPaddingBottom()) / 2);
    }

    public final Drawable n(int i) {
        if (i == 0) {
            if (this.p == null || !w()) {
                return null;
            }
            return this.p;
        }
        if (i == 1) {
            if (this.p == null || !x()) {
                return null;
            }
            return this.p;
        }
        if (i == 2 && this.p != null && v()) {
            return this.p;
        }
        return null;
    }

    public final Drawable o(int i) {
        if (i == 0) {
            if (this.m == null || !r()) {
                return null;
            }
            return this.m;
        }
        if (i == 1) {
            if (this.m == null || !q()) {
                return null;
            }
            return this.m;
        }
        if (i == 2 && this.m != null && q()) {
            return this.m;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (y()) {
            m62.f(this, this.i.g());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (p()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, Q);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, R);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // defpackage.a8, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // defpackage.a8, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(p());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // defpackage.a8, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        D(getMeasuredWidth(), getMeasuredHeight());
        G(getMeasuredWidth(), getMeasuredHeight());
        int i6 = getResources().getConfiguration().orientation;
        if (this.C != i6) {
            this.C = i6;
            this.D = -2.1474836E9f;
        }
        if (this.D == -2.1474836E9f) {
            this.D = getMeasuredWidth();
            if (this.G == null) {
                getParent();
            }
        }
        if (this.K == Integer.MIN_VALUE) {
            if (this.m == null) {
                i5 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.s;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.m.getIntrinsicWidth();
                }
                i5 = iconPadding + intrinsicWidth;
            }
            this.K = (getMeasuredWidth() - getTextLayoutWidth()) - i5;
        }
        if (this.E == Integer.MIN_VALUE) {
            this.E = getPaddingStart();
        }
        if (this.F == Integer.MIN_VALUE) {
            this.F = getPaddingEnd();
        }
        this.J = t();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.c());
        setChecked(cVar.h);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.h = this.y;
        return cVar;
    }

    @Override // defpackage.a8, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        D(getMeasuredWidth(), getMeasuredHeight());
        G(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean p() {
        c62 c62Var = this.i;
        return c62Var != null && c62Var.r();
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean z;
        if (isEnabled() && this.i.s()) {
            toggle();
            z = true;
        } else {
            z = false;
        }
        boolean zPerformClick = super.performClick();
        if (z && !zPerformClick) {
            playSoundEffect(0);
        }
        return zPerformClick;
    }

    public final boolean q() {
        int i = this.A;
        return i == 3 || i == 4;
    }

    public final boolean r() {
        int i = this.A;
        return i == 1 || i == 2;
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.m != null) {
            if (this.m.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public final boolean s() {
        int i = this.A;
        return i == 16 || i == 32;
    }

    public void setA11yClassName(String str) {
        this.r = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (y()) {
            this.i.u(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // defpackage.a8, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!y()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.i.v();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // defpackage.a8, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? e9.b(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (y()) {
            this.i.w(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablePadding(int i) {
        if (getCompoundDrawablePadding() != i) {
            this.D = -2.1474836E9f;
        }
        super.setCompoundDrawablePadding(i);
    }

    public void setCornerRadius(int i) {
        if (y()) {
            this.i.x(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (y()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCornerSpringForce(ed4 ed4Var) {
        this.i.z(ed4Var);
    }

    public void setDisplayedWidthDecrease(int i) {
        this.O = Math.min(i, this.K);
        E();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (y()) {
            this.i.g().d0(f);
        }
    }

    public void setIcon(final Drawable drawable) {
        if (this.m == drawable || A(new Runnable() { // from class: x52
            @Override // java.lang.Runnable
            public final void run() {
                this.f.setIcon(drawable);
            }
        })) {
            return;
        }
        this.D = -2.1474836E9f;
        this.m = drawable;
        C(true);
        D(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setIconGravity(int i) {
        if (this.A != i) {
            H();
            this.A = i;
            D(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.v != i) {
            this.v = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setIconSize(final int i) {
        if (i < 0) {
            jl.a("iconSize cannot be less than 0");
            return;
        }
        if (this.s == i || A(new Runnable() { // from class: y52
            @Override // java.lang.Runnable
            public final void run() {
                this.f.setIconSize(i);
            }
        })) {
            return;
        }
        this.D = -2.1474836E9f;
        this.s = i;
        C(true);
        F(true);
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            C(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.k != mode) {
            this.k = mode;
            C(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(e9.a(getContext(), i));
    }

    public void setInsetBottom(int i) {
        this.i.A(i);
    }

    public void setInsetTop(int i) {
        this.i.B(i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.H != z) {
            this.H = z;
            c62 c62Var = this.i;
            if (z) {
                c62Var.y(new l62.d() { // from class: z52
                    @Override // l62.d
                    public final void a(float f) {
                        MaterialButton.f(this.a, f);
                    }
                });
            } else {
                c62Var.y(null);
            }
            post(new Runnable() { // from class: a62
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialButton.b(this.f);
                }
            });
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        z(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (y()) {
            this.i.C(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (y()) {
            setRippleColor(e9.a(getContext(), i));
        }
    }

    public void setSecondaryIcon(final Drawable drawable) {
        if (this.p == drawable || A(new Runnable() { // from class: w52
            @Override // java.lang.Runnable
            public final void run() {
                this.f.setIcon(drawable);
            }
        })) {
            return;
        }
        this.D = -2.1474836E9f;
        this.p = drawable;
        this.q = false;
        F(true);
        G(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setSecondaryIconGravity(int i) {
        if (this.B != i) {
            I();
            this.B = i;
            G(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setSecondaryIconResource(int i) {
        setSecondaryIcon(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setSecondaryIconTint(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            F(false);
        }
    }

    public void setSecondaryIconTintMode(PorterDuff.Mode mode) {
        if (this.n != mode) {
            this.n = mode;
            F(false);
        }
    }

    public void setSecondaryIconTintResource(int i) {
        setSecondaryIconTint(e9.a(getContext(), i));
    }

    public void setShapeAppearance(x44 x44Var) {
        if (!y()) {
            e04.a("Attempted to set ShapeAppearance on a MaterialButton which has an overwritten background.");
            return;
        }
        if (this.i.c() == null && x44Var.d()) {
            this.i.z(k());
        }
        this.i.D(x44Var);
    }

    @Override // defpackage.r54
    public void setShapeAppearanceModel(y44 y44Var) {
        if (y()) {
            this.i.D(y44Var);
        } else {
            e04.a("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (y()) {
            this.i.E(z);
        }
    }

    public void setSizeChange(ie4 ie4Var) {
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (y()) {
            this.i.F(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (y()) {
            setStrokeColor(e9.a(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (y()) {
            this.i.G(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (y()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // defpackage.a8
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (y()) {
            this.i.H(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // defpackage.a8
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (y()) {
            this.i.I(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.D = -2.1474836E9f;
        super.setText(charSequence, bufferType);
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        D(getMeasuredWidth(), getMeasuredHeight());
        G(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // defpackage.a8, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        this.D = -2.1474836E9f;
        super.setTextAppearance(context, i);
    }

    @Override // defpackage.a8, android.widget.TextView
    public void setTextSize(int i, float f) {
        this.D = -2.1474836E9f;
        super.setTextSize(i, f);
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.i.J(z);
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.D = -2.1474836E9f;
        super.setWidth(i);
    }

    public void setWidthChangeDirection(d dVar) {
        if (this.M != dVar) {
            this.M = dVar;
            z(true);
        }
    }

    public void setWidthChangeMax(int i) {
        if (this.L != i) {
            this.L = i;
            z(true);
        }
    }

    public final boolean t() {
        getParent();
        return false;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.y);
    }

    public final boolean u() {
        return getLayoutDirection() == 1;
    }

    public final boolean v() {
        int i = this.B;
        return i == 3 || i == 4;
    }

    public final boolean w() {
        int i = this.B;
        return i == 1 || i == 2;
    }

    public final boolean x() {
        int i = this.B;
        return i == 16 || i == 32;
    }

    public final boolean y() {
        c62 c62Var = this.i;
        return (c62Var == null || c62Var.q()) ? false : true;
    }

    public final void z(boolean z) {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends p {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public boolean h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            d(parcel);
        }

        public final void d(Parcel parcel) {
            this.h = parcel.readInt() == 1;
        }

        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h ? 1 : 0);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.x);
    }

    public MaterialButton(Context context) {
        this(context, null);
    }
}
