package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f62 extends c8 {
    public static final int D = ym3.x;
    public static final int[] E = {mk3.X};
    public static final int[] F;
    public static final int[][] G;
    public static final int H;
    public CompoundButton.OnCheckedChangeListener A;
    public final f7 B;
    public final h6 C;
    public final LinkedHashSet j;
    public final LinkedHashSet k;
    public ColorStateList l;
    public boolean m;
    public boolean n;
    public boolean o;
    public CharSequence p;
    public Drawable q;
    public Drawable r;
    public boolean s;
    public ColorStateList t;
    public ColorStateList u;
    public PorterDuff.Mode v;
    public int w;
    public int[] x;
    public boolean y;
    public CharSequence z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends h6 {
        public a() {
        }

        @Override // defpackage.h6
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = f62.this.t;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }

        @Override // defpackage.h6
        public void c(Drawable drawable) {
            super.c(drawable);
            f62 f62Var = f62.this;
            ColorStateList colorStateList = f62Var.t;
            if (colorStateList != null) {
                drawable.setTint(colorStateList.getColorForState(f62Var.x, f62.this.t.getDefaultColor()));
            }
        }
    }

    static {
        int i = mk3.W;
        F = new int[]{i};
        G = new int[][]{new int[]{R.attr.state_enabled, i}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        H = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f62(Context context, AttributeSet attributeSet, int i) {
        int i2 = D;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        this.j = new LinkedHashSet();
        this.k = new LinkedHashSet();
        this.B = f7.a(getContext(), gl3.d);
        this.C = new a();
        Context context2 = getContext();
        this.q = sy.a(this);
        this.t = getSuperButtonTintList();
        setSupportButtonTintList(null);
        dp4 dp4VarJ = dn4.j(context2, attributeSet, cn3.x3, i, i2, new int[0]);
        this.r = dp4VarJ.g(cn3.A3);
        if (this.q != null && dn4.g(context2) && c(dp4VarJ)) {
            super.setButtonDrawable((Drawable) null);
            this.q = e9.b(context2, gl3.c);
            this.s = true;
            if (this.r == null) {
                this.r = e9.b(context2, gl3.e);
            }
        }
        this.u = k62.a(context2, dp4VarJ, cn3.B3);
        this.v = e55.g(dp4VarJ.k(cn3.C3, -1), PorterDuff.Mode.SRC_IN);
        this.m = dp4VarJ.a(cn3.I3, false);
        this.n = dp4VarJ.a(cn3.D3, true);
        this.o = dp4VarJ.a(cn3.G3, false);
        this.p = dp4VarJ.p(cn3.F3);
        if (dp4VarJ.s(cn3.E3)) {
            setCheckedState(dp4VarJ.k(cn3.E3, 0));
        }
        if (dp4VarJ.s(cn3.H3)) {
            setRippleColor(k62.a(context2, dp4VarJ, cn3.H3));
        }
        dp4VarJ.x();
        e();
    }

    private String getButtonStateDescription() {
        int i = this.w;
        return i == 1 ? getResources().getString(tm3.p) : i == 0 ? getResources().getString(tm3.r) : getResources().getString(tm3.q);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.l == null) {
            int[][] iArr = G;
            int[] iArr2 = new int[iArr.length];
            int iD = h62.d(this, nk3.s);
            int iD2 = h62.d(this, nk3.v);
            int iD3 = h62.d(this, mk3.l);
            int iD4 = h62.d(this, mk3.j);
            iArr2[0] = h62.j(iD3, iD2, 1.0f);
            iArr2[1] = h62.j(iD3, iD, 1.0f);
            iArr2[2] = h62.j(iD3, iD4, 0.54f);
            iArr2[3] = h62.j(iD3, iD4, 0.38f);
            iArr2[4] = h62.j(iD3, iD4, 0.38f);
            this.l = new ColorStateList(iArr, iArr2);
        }
        return this.l;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.t;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    private void setRippleColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof DrawableWrapper) {
            background = ((DrawableWrapper) background).getDrawable();
        }
        if (background instanceof RippleDrawable) {
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public final boolean c(dp4 dp4Var) {
        return dp4Var.n(cn3.y3, 0) == H && dp4Var.n(cn3.z3, 0) == 0;
    }

    public boolean d() {
        return this.o;
    }

    public final void e() {
        this.q = go0.c(this.q, this.t, sy.c(this));
        this.r = go0.c(this.r, this.u, this.v);
        g();
        h();
        super.setButtonDrawable(go0.a(this.q, this.r));
        refreshDrawableState();
    }

    public final void f() {
        if (Build.VERSION.SDK_INT < 30 || this.z != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    public final void g() {
        f7 f7Var;
        if (this.s) {
            f7 f7Var2 = this.B;
            if (f7Var2 != null) {
                f7Var2.f(this.C);
                this.B.b(this.C);
            }
            Drawable drawable = this.q;
            if (!(drawable instanceof AnimatedStateListDrawable) || (f7Var = this.B) == null) {
                return;
            }
            ((AnimatedStateListDrawable) drawable).addTransition(ol3.a, ol3.B, f7Var, false);
            ((AnimatedStateListDrawable) this.q).addTransition(ol3.d, ol3.B, this.B, false);
        }
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.q;
    }

    public Drawable getButtonIconDrawable() {
        return this.r;
    }

    public ColorStateList getButtonIconTintList() {
        return this.u;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.v;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.t;
    }

    public int getCheckedState() {
        return this.w;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.p;
    }

    public final void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.q;
        if (drawable != null && (colorStateList2 = this.t) != null) {
            drawable.setTintList(colorStateList2);
        }
        Drawable drawable2 = this.r;
        if (drawable2 == null || (colorStateList = this.u) == null) {
            return;
        }
        drawable2.setTintList(colorStateList);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.w == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.m && this.t == null && this.u == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        this.x = go0.e(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.n || !TextUtils.isEmpty(getText()) || (drawableA = sy.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (e55.f(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.p));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f = getCheckedState();
        return bVar;
    }

    @Override // defpackage.c8, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(e9.b(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.r = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(e9.b(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.u == colorStateList) {
            return;
        }
        this.u = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.v == mode) {
            return;
        }
        this.v = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.t == colorStateList) {
            return;
        }
        this.t = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.n = z;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    public void setCheckedState(int i) {
        AutofillManager autofillManagerA;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.w != i) {
            this.w = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            f();
            if (this.y) {
                return;
            }
            this.y = true;
            LinkedHashSet linkedHashSet = this.k;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    w82.a(it.next());
                    throw null;
                }
            }
            if (this.w != 2 && (onCheckedChangeListener = this.A) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManagerA = e62.a(getContext().getSystemService(d62.a()))) != null) {
                autofillManagerA.notifyValueChanged(this);
            }
            this.y = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.p = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z) {
        if (this.o == z) {
            return;
        }
        this.o = z;
        refreshDrawableState();
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.A = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.z = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.m = z;
        if (z) {
            sy.d(this, getMaterialThemeColorsTintList());
        } else {
            sy.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // defpackage.c8, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.q = drawable;
        this.s = false;
        e();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public int f;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }

        public final String c() {
            int i = this.f;
            return i != 1 ? i != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + c() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Integer.valueOf(this.f));
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        public /* synthetic */ b(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    public f62(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.o);
    }
}
