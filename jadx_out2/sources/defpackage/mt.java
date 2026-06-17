package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.material.focus.FocusRingDrawable;
import defpackage.g2;
import defpackage.g62;
import defpackage.nt;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mt extends c8 implements nt.a, r54, g62 {
    public static final int C = ym3.v;
    public static final Rect D = new Rect();
    public static final int[] E = {R.attr.state_selected};
    public static final int[] F = {R.attr.state_checkable};
    public final RectF A;
    public final dm4 B;
    public nt j;
    public InsetDrawable k;
    public RippleDrawable l;
    public View.OnClickListener m;
    public CompoundButton.OnCheckedChangeListener n;
    public g62.a o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public CharSequence w;
    public final c x;
    public boolean y;
    public final Rect z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends dm4 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dm4
        public void a(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dm4
        public void b(Typeface typeface, boolean z) {
            mt mtVar = mt.this;
            boolean zD3 = mtVar.j.d3();
            mt mtVar2 = mt.this;
            mtVar.setText(zD3 ? mtVar2.j.w1() : mtVar2.getText());
            mt.this.requestLayout();
            mt.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends ViewOutlineProvider {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (mt.this.j != null) {
                mt.this.j.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends ry0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(mt mtVar) {
            super(mtVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ry0
        public int B(float f, float f2) {
            return (mt.this.n() && mt.this.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ry0
        public void C(List list) {
            list.add(0);
            if (mt.this.n() && mt.this.s() && mt.this.m != null) {
                list.add(1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ry0
        public boolean L(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i == 0) {
                return mt.this.performClick();
            }
            if (i == 1) {
                return mt.this.t();
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ry0
        public void O(g2 g2Var) {
            g2Var.j0(mt.this.r());
            g2Var.m0(mt.this.isClickable());
            g2Var.l0(mt.this.getAccessibilityClassName());
            g2Var.L0(mt.this.getText());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ry0
        public void P(int i, g2 g2Var) {
            if (i != 1) {
                g2Var.p0("");
                g2Var.h0(mt.D);
                return;
            }
            CharSequence closeIconContentDescription = mt.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                g2Var.p0(closeIconContentDescription);
            } else {
                CharSequence text = mt.this.getText();
                g2Var.p0(mt.this.getContext().getString(tm3.s, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            g2Var.h0(mt.this.getCloseIconTouchBoundsInt());
            g2Var.b(g2.a.i);
            g2Var.r0(mt.this.isEnabled());
            g2Var.l0(Button.class.getName());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ry0
        public void Q(int i, boolean z) {
            if (i == 1) {
                mt.this.s = z;
            }
            if (mt.this.j.M1(mt.this.s)) {
                mt.this.refreshDrawableState();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Illegal instructions before constructor call */
    public mt(Context context, AttributeSet attributeSet, int i) {
        int i2 = C;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        this.z = new Rect();
        this.A = new RectF();
        this.B = new a();
        Context context2 = getContext();
        C(attributeSet);
        nt ntVarJ0 = nt.J0(context2, attributeSet, i, i2);
        o(context2, attributeSet, i);
        setChipDrawable(ntVarJ0);
        ntVarJ0.d0(getElevation());
        TypedArray typedArrayI = dn4.i(context2, attributeSet, cn3.O0, i, i2, new int[0]);
        boolean zHasValue = typedArrayI.hasValue(cn3.B1);
        typedArrayI.recycle();
        this.x = new c(this);
        x();
        if (!zHasValue) {
            p();
        }
        setChecked(this.p);
        setText(ntVarJ0.w1());
        setEllipsize(ntVarJ0.p1());
        B();
        if (!this.j.d3()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.v);
        }
        this.u = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: lt
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                mt.b(this.a, compoundButton, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(mt mtVar, CompoundButton compoundButton, boolean z) {
        g62.a aVar = mtVar.o;
        if (aVar != null) {
            aVar.a(mtVar, z);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = mtVar.n;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.A.setEmpty();
        if (n() && this.m != null) {
            this.j.m1(this.A);
        }
        return this.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.z.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private bm4 getTextAppearance() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.x1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setCloseIconHovered(boolean z) {
        if (this.r != z) {
            this.r = z;
            refreshDrawableState();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setCloseIconPressed(boolean z) {
        if (this.q != z) {
            this.q = z;
            refreshDrawableState();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A() {
        nt ntVar;
        if (TextUtils.isEmpty(getText()) || (ntVar = this.j) == null) {
            return;
        }
        int iX0 = (int) (ntVar.X0() + this.j.y1() + this.j.E0());
        int iC1 = (int) (this.j.c1() + this.j.z1() + this.j.A0());
        if (this.k != null) {
            Rect rect = new Rect();
            this.k.getPadding(rect);
            iC1 += rect.left;
            iX0 += rect.right;
        }
        setPaddingRelative(iC1, getPaddingTop(), iX0, getPaddingBottom());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B() {
        TextPaint paint = getPaint();
        nt ntVar = this.j;
        if (ntVar != null) {
            paint.drawableState = ntVar.getState();
        }
        bm4 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.r(getContext(), paint, this.B);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            fn.a("Please set left drawable using R.attr#chipIcon.");
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            fn.a("Please set start drawable using R.attr#chipIcon.");
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            fn.a("Please set end drawable using R.attr#closeIcon.");
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            fn.a("Please set end drawable using R.attr#closeIcon.");
            return;
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            fn.a("Chip does not support multi-line text");
        } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // nt.a
    public void a() {
        m(this.v);
        requestLayout();
        invalidateOutline();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.y ? super.dispatchHoverEvent(motionEvent) : this.x.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.y) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.x.w(keyEvent) || this.x.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c8, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        nt ntVar = this.j;
        if ((ntVar == null || !ntVar.E1()) ? false : this.j.B2(l())) {
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.w)) {
            return this.w;
        }
        if (!r()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ot) && ((ot) parent).i()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.k;
        return insetDrawable == null ? this.j : insetDrawable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getCheckedIcon() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.T0();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getCheckedIconTint() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.U0();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getChipBackgroundColor() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.V0();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getChipCornerRadius() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return Math.max(0.0f, ntVar.W0());
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getChipDrawable() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getChipEndPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.X0();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getChipIcon() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.Y0();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getChipIconSize() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.Z0();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getChipIconTint() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.a1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getChipMinHeight() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.b1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getChipStartPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.c1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getChipStrokeColor() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.d1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getChipStrokeWidth() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.e1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getCloseIcon() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.f1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence getCloseIconContentDescription() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.g1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getCloseIconEndPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.h1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getCloseIconSize() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.i1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getCloseIconStartPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.j1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getCloseIconTint() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.l1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.p1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.y && (this.x.A() == 1 || this.x.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public String getFontVariationSettings() {
        nt ntVar = this.j;
        return ntVar != null ? ntVar.q1() : super.getFontVariationSettings();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ju2 getHideMotionSpec() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.r1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getIconEndPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.s1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getIconStartPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.t1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getRippleColor() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.u1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y44 getShapeAppearanceModel() {
        return this.j.J();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ju2 getShowMotionSpec() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.v1();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getTextEndPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.y1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getTextStartPadding() {
        nt ntVar = this.j;
        if (ntVar != null) {
            return ntVar.z1();
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(nt ntVar) {
        ntVar.F2(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final int[] l() {
        ?? IsEnabled = isEnabled();
        int i = IsEnabled;
        if (this.s) {
            i = IsEnabled + 1;
        }
        int i2 = i;
        if (this.r) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (this.q) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (isChecked()) {
            i4 = i3 + 1;
        }
        int[] iArr = new int[i4];
        int i5 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i5 = 1;
        }
        if (this.s) {
            iArr[i5] = 16842908;
            i5++;
        }
        if (this.r) {
            iArr[i5] = 16843623;
            i5++;
        }
        if (this.q) {
            iArr[i5] = 16842919;
            i5++;
        }
        if (isChecked()) {
            iArr[i5] = 16842913;
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean m(int i) {
        this.v = i;
        if (!v()) {
            if (this.k != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int iMax = Math.max(0, i - this.j.getIntrinsicHeight());
        int iMax2 = Math.max(0, i - this.j.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.k != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.k != null) {
            Rect rect = new Rect();
            this.k.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                y();
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        q(i2, i3, i2, i3);
        y();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n() {
        nt ntVar = this.j;
        return (ntVar == null || ntVar.f1() == null) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayI = dn4.i(context, attributeSet, cn3.O0, i, C, new int[0]);
        this.t = typedArrayI.getBoolean(cn3.v1, false);
        this.v = (int) Math.ceil(typedArrayI.getDimension(cn3.j1, p52.i(context)));
        typedArrayI.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m62.f(this, this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E);
        }
        if (r()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        return iArrOnCreateDrawableState;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.y) {
            this.x.K(z, i, rect);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ot) {
            ot otVar = (ot) getParent();
            g2.P0(accessibilityNodeInfo).o0(g2.f.a(otVar.b(this), 1, otVar.c() ? otVar.g(this) : -1, 1, false, isChecked()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.u != i) {
            this.u = i;
            A();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.q) {
                        if (!zContains) {
                            setCloseIconPressed(false);
                        }
                        z = true;
                    }
                }
                z = false;
            } else {
                if (this.q) {
                    t();
                    z = true;
                }
                setCloseIconPressed(false);
            }
            z = false;
            setCloseIconPressed(false);
        } else {
            if (zContains) {
                setCloseIconPressed(true);
                z = true;
            }
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p() {
        setOutlineProvider(new b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(int i, int i2, int i3, int i4) {
        this.k = new InsetDrawable((Drawable) this.j, i, i2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r() {
        nt ntVar = this.j;
        return ntVar != null && ntVar.D1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s() {
        nt ntVar = this.j;
        return ntVar != null && ntVar.F1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAccessibilityClassName(CharSequence charSequence) {
        this.w = charSequence;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.l) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c8, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.l) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c8, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckable(boolean z) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.N1(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckableResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.O1(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        nt ntVar = this.j;
        if (ntVar == null) {
            this.p = z;
        } else if (ntVar.D1()) {
            super.setChecked(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckedIcon(Drawable drawable) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.P1(drawable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckedIconResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.Q1(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckedIconTint(ColorStateList colorStateList) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.R1(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckedIconTintResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.S1(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCheckedIconVisible(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.T1(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipBackgroundColor(ColorStateList colorStateList) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.V1(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipBackgroundColorResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.W1(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setChipCornerRadius(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.X1(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.Y1(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipDrawable(nt ntVar) {
        nt ntVar2 = this.j;
        if (ntVar2 != ntVar) {
            w(ntVar2);
            this.j = ntVar;
            ntVar.R2(false);
            k(this.j);
            m(this.v);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipEndPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.Z1(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipEndPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.a2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIcon(Drawable drawable) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.b2(drawable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIconResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.c2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIconSize(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.d2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIconSizeResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.e2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIconTint(ColorStateList colorStateList) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.f2(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIconTintResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.g2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipIconVisible(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.h2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipMinHeight(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.j2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipMinHeightResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.k2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipStartPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.l2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipStartPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.m2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipStrokeColor(ColorStateList colorStateList) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.n2(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipStrokeColorResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.o2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipStrokeWidth(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.p2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChipStrokeWidthResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.q2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIcon(Drawable drawable) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.s2(drawable);
        }
        x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconContentDescription(CharSequence charSequence) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.t2(charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconEndPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.u2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconEndPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.v2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.w2(i);
        }
        x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconSize(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.x2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconSizeResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.y2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconStartPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.z2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconStartPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.A2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconTint(ColorStateList colorStateList) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.C2(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconTintResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.D2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c8, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            fn.a("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            fn.a("Please set end drawable using R.attr#closeIcon.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c8, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            fn.a("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            fn.a("Please set end drawable using R.attr#closeIcon.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            fn.a("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            fn.a("Please set end drawable using R.attr#closeIcon.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            fn.a("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            fn.a("Please set end drawable using R.attr#closeIcon.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.d0(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.j == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            fn.a("Text within a chip are not allowed to scroll.");
            return;
        }
        super.setEllipsize(truncateAt);
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.G2(truncateAt);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEnsureMinTouchTargetSize(boolean z) {
        this.t = z;
        m(this.v);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public boolean setFontVariationSettings(String str) {
        super.setFontVariationSettings(str);
        nt ntVar = this.j;
        if (ntVar == null) {
            return false;
        }
        ntVar.H2(str);
        B();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHideMotionSpec(ju2 ju2Var) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.I2(ju2Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHideMotionSpecResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.J2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconEndPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.K2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconEndPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.L2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconStartPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.M2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconStartPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.N2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g62
    public void setInternalOnCheckedChangeListener(g62.a aVar) {
        this.o = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.j == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
        } else {
            fn.a("Chip does not support multi-line text");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
        } else {
            fn.a("Chip does not support multi-line text");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.O2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
        } else {
            fn.a("Chip does not support multi-line text");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.n = onCheckedChangeListener;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
        x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRippleColor(ColorStateList colorStateList) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.P2(colorStateList);
        }
        if (this.j.B1()) {
            return;
        }
        z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRippleColorResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.Q2(i);
            if (this.j.B1()) {
                return;
            }
            z();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r54
    public void setShapeAppearanceModel(y44 y44Var) {
        this.j.setShapeAppearanceModel(y44Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowMotionSpec(ju2 ju2Var) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.S2(ju2Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowMotionSpecResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.T2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
        } else {
            fn.a("Chip does not support multi-line text");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        nt ntVar = this.j;
        if (ntVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(ntVar.d3() ? null : charSequence, bufferType);
        nt ntVar2 = this.j;
        if (ntVar2 != null) {
            ntVar2.U2(charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.W2(i);
        }
        B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextEndPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.X2(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextEndPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.Y2(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.Z2(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics()));
        }
        B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextStartPadding(float f) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.a3(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTextStartPaddingResource(int i) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.b3(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        if (this.y) {
            this.x.W(1, 1);
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        if (this.k != null) {
            this.k = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(nt ntVar) {
        if (ntVar != null) {
            ntVar.F2(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x() {
        if (n() && s() && this.m != null) {
            l35.g0(this, this.x);
            this.y = true;
        } else {
            l35.g0(this, null);
            this.y = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y() {
        z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z() {
        RippleDrawable rippleDrawable = new RippleDrawable(wt3.d(this.j.u1()), getBackgroundDrawable(), null);
        FocusRingDrawable.t(getContext(), rippleDrawable, this.j);
        this.l = rippleDrawable;
        this.j.c3(false);
        setBackground(this.l);
        A();
    }

    public void setCheckedIconVisible(boolean z) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.U1(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.i2(z);
        }
    }

    public void setCloseIconVisible(boolean z) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.E2(z);
        }
        x();
    }

    public void setTextAppearance(bm4 bm4Var) {
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.V2(bm4Var);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        nt ntVar = this.j;
        if (ntVar != null) {
            ntVar.W2(i);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            fn.a("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            fn.a("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            fn.a("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            fn.a("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public mt(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.g);
    }

    public mt(Context context) {
        this(context, null);
    }
}
