package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.c;
import defpackage.an4;
import defpackage.dp4;
import defpackage.e9;
import defpackage.en4;
import defpackage.f55;
import defpackage.fo0;
import defpackage.h5;
import defpackage.j9;
import defpackage.l35;
import defpackage.mn3;
import defpackage.nk3;
import defpackage.tn0;
import defpackage.u8;
import defpackage.um3;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final Property a0 = new a(Float.class, "thumbPos");
    public static final int[] b0 = {R.attr.state_checked};
    public float A;
    public float B;
    public VelocityTracker C;
    public int D;
    public float E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public final TextPaint N;
    public ColorStateList O;
    public Layout P;
    public Layout Q;
    public TransformationMethod R;
    public ObjectAnimator S;
    public final j9 T;
    public u8 U;
    public b V;
    public final Rect W;
    public Drawable f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public boolean i;
    public boolean j;
    public Drawable k;
    public ColorStateList l;
    public PorterDuff.Mode m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public CharSequence t;
    public CharSequence u;
    public CharSequence v;
    public CharSequence w;
    public boolean x;
    public int y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.E);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends c.f {
        public final Reference a;

        public b(SwitchCompat switchCompat) {
            this.a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.c.f
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.C = VelocityTracker.obtain();
        this.M = true;
        this.W = new Rect();
        en4.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.N = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        dp4 dp4VarV = dp4.v(context, attributeSet, mn3.f2, i, 0);
        l35.e0(this, context, mn3.f2, attributeSet, dp4VarV.r(), i, 0);
        Drawable drawableG = dp4VarV.g(mn3.i2);
        this.f = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = dp4VarV.g(mn3.r2);
        this.k = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(dp4VarV.p(mn3.g2));
        setTextOffInternal(dp4VarV.p(mn3.h2));
        this.x = dp4VarV.a(mn3.j2, true);
        this.p = dp4VarV.f(mn3.o2, 0);
        this.q = dp4VarV.f(mn3.l2, 0);
        this.r = dp4VarV.f(mn3.m2, 0);
        this.s = dp4VarV.a(mn3.k2, false);
        ColorStateList colorStateListC = dp4VarV.c(mn3.p2);
        if (colorStateListC != null) {
            this.g = colorStateListC;
            this.i = true;
        }
        PorterDuff.Mode modeE = fo0.e(dp4VarV.k(mn3.q2, -1), null);
        if (this.h != modeE) {
            this.h = modeE;
            this.j = true;
        }
        if (this.i || this.j) {
            b();
        }
        ColorStateList colorStateListC2 = dp4VarV.c(mn3.s2);
        if (colorStateListC2 != null) {
            this.l = colorStateListC2;
            this.n = true;
        }
        PorterDuff.Mode modeE2 = fo0.e(dp4VarV.k(mn3.t2, -1), null);
        if (this.m != modeE2) {
            this.m = modeE2;
            this.o = true;
        }
        if (this.n || this.o) {
            c();
        }
        int iN = dp4VarV.n(mn3.n2, 0);
        if (iN != 0) {
            m(context, iN);
        }
        j9 j9Var = new j9(this);
        this.T = j9Var;
        j9Var.m(attributeSet, i);
        dp4VarV.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.z = viewConfiguration.getScaledTouchSlop();
        this.D = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public static float f(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private u8 getEmojiTextViewHelper() {
        if (this.U == null) {
            this.U = new u8(this);
        }
        return this.U;
    }

    private boolean getTargetCheckedState() {
        return this.E > 0.5f;
    }

    private int getThumbOffset() {
        boolean zB = f55.b(this);
        float f = this.E;
        if (zB) {
            f = 1.0f - f;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.k;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.W;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f;
        Rect rectD = drawable2 != null ? fo0.d(drawable2) : fo0.c;
        return ((((this.F - this.H) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.v = charSequence;
        this.w = g(charSequence);
        this.Q = null;
        if (this.x) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.t = charSequence;
        this.u = g(charSequence);
        this.P = null;
        if (this.x) {
            p();
        }
    }

    public final void a(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) a0, z ? 1.0f : 0.0f);
        this.S = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.S.setAutoCancel(true);
        this.S.start();
    }

    public final void b() {
        Drawable drawable = this.f;
        if (drawable != null) {
            if (this.i || this.j) {
                Drawable drawableMutate = tn0.r(drawable).mutate();
                this.f = drawableMutate;
                if (this.i) {
                    tn0.o(drawableMutate, this.g);
                }
                if (this.j) {
                    tn0.p(this.f, this.h);
                }
                if (this.f.isStateful()) {
                    this.f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (this.n || this.o) {
                Drawable drawableMutate = tn0.r(drawable).mutate();
                this.k = drawableMutate;
                if (this.n) {
                    tn0.o(drawableMutate, this.l);
                }
                if (this.o) {
                    tn0.p(this.k, this.m);
                }
                if (this.k.isStateful()) {
                    this.k.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.S;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int i2;
        Rect rect = this.W;
        int i3 = this.I;
        int i4 = this.J;
        int i5 = this.K;
        int i6 = this.L;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.f;
        Rect rectD = drawable != null ? fo0.d(drawable) : fo0.c;
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (rectD != null) {
                int i8 = rectD.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rectD.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rectD.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rectD.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.k.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.k.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbOffset - rect.left;
            int i16 = thumbOffset + this.H + rect.right;
            this.f.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                tn0.l(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f;
        if (drawable != null) {
            tn0.k(drawable, f, f2);
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            tn0.k(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.k;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final CharSequence g(CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.R);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!f55.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.F;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.r : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (f55.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.F;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.r : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return an4.o(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.x;
    }

    public boolean getSplitTrack() {
        return this.s;
    }

    public int getSwitchMinWidth() {
        return this.q;
    }

    public int getSwitchPadding() {
        return this.r;
    }

    public CharSequence getTextOff() {
        return this.v;
    }

    public CharSequence getTextOn() {
        return this.t;
    }

    public Drawable getThumbDrawable() {
        return this.f;
    }

    public final float getThumbPosition() {
        return this.E;
    }

    public int getThumbTextPadding() {
        return this.p;
    }

    public ColorStateList getThumbTintList() {
        return this.g;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.h;
    }

    public Drawable getTrackDrawable() {
        return this.k;
    }

    public ColorStateList getTrackTintList() {
        return this.l;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.m;
    }

    public final boolean h(float f, float f2) {
        if (this.f == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f.getPadding(this.W);
        int i = this.J;
        int i2 = this.z;
        int i3 = i - i2;
        int i4 = (this.I + thumbOffset) - i2;
        int i5 = this.H + i4;
        Rect rect = this.W;
        return f > ((float) i4) && f < ((float) (((i5 + rect.left) + rect.right) + i2)) && f2 > ((float) i3) && f2 < ((float) (this.L + i2));
    }

    public final Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.N, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void j() {
        setTextOnInternal(this.t);
        setTextOffInternal(this.v);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.S;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.S.end();
        this.S = null;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.v;
            if (string == null) {
                string = getResources().getString(um3.b);
            }
            l35.t0(this, string);
        }
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.t;
            if (string == null) {
                string = getResources().getString(um3.c);
            }
            l35.t0(this, string);
        }
    }

    public void m(Context context, int i) {
        dp4 dp4VarT = dp4.t(context, i, mn3.u2);
        ColorStateList colorStateListC = dp4VarT.c(mn3.y2);
        if (colorStateListC != null) {
            this.O = colorStateListC;
        } else {
            this.O = getTextColors();
        }
        int iF = dp4VarT.f(mn3.v2, 0);
        if (iF != 0) {
            float f = iF;
            if (f != this.N.getTextSize()) {
                this.N.setTextSize(f);
                requestLayout();
            }
        }
        o(dp4VarT.k(mn3.w2, -1), dp4VarT.k(mn3.x2, -1));
        if (dp4VarT.a(mn3.J2, false)) {
            this.R = new h5(getContext());
        } else {
            this.R = null;
        }
        setTextOnInternal(this.t);
        setTextOffInternal(this.v);
        dp4VarT.x();
    }

    public void n(Typeface typeface, int i) {
        if (i <= 0) {
            this.N.setFakeBoldText(false);
            this.N.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i2 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i;
            this.N.setFakeBoldText((i2 & 1) != 0);
            this.N.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void o(int i, int i2) {
        n(i != 1 ? i != 2 ? i != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.W;
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.J;
        int i2 = this.L;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f;
        if (drawable != null) {
            if (!this.s || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = fo0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.P : this.Q;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.O;
            if (colorStateList != null) {
                this.N.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.N.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.t : this.v;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int i5;
        int paddingTop;
        int height;
        super.onLayout(z, i, i2, i3, i4);
        int iMax2 = 0;
        if (this.f != null) {
            Rect rect = this.W;
            Drawable drawable = this.k;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = fo0.d(this.f);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (f55.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.F + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.F) + iMax + iMax2;
        }
        int gravity = getGravity() & Token.ASSIGN_MOD;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i5 = this.G;
            paddingTop = paddingTop2 - (i5 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.G;
                this.I = paddingLeft;
                this.J = paddingTop;
                this.L = height;
                this.K = width;
            }
            paddingTop = getPaddingTop();
            i5 = this.G;
        }
        height = i5 + paddingTop;
        this.I = paddingLeft;
        this.J = paddingTop;
        this.L = height;
        this.K = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.x) {
            if (this.P == null) {
                this.P = i(this.u);
            }
            if (this.Q == null) {
                this.Q = i(this.w);
            }
        }
        Rect rect = this.W;
        Drawable drawable = this.f;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.H = Math.max(this.x ? Math.max(this.P.getWidth(), this.Q.getWidth()) + (this.p * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.k.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            Rect rectD = fo0.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        boolean z = this.M;
        int iMax3 = this.q;
        if (z) {
            iMax3 = Math.max(iMax3, (this.H * 2) + iMax + iMax2);
        }
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.F = iMax3;
        this.G = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.t : this.v;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.C
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.y
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.A
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = defpackage.f55.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.E
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.E
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.A = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.A
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.z
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.B
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.z
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.y = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.A = r0
            r6.B = r3
            return r1
        L89:
            int r0 = r6.y
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.y = r0
            android.view.VelocityTracker r0 = r6.C
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.y = r1
            r6.A = r0
            r6.B = r2
        Lb7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (this.V == null && this.U.b() && androidx.emoji2.text.c.i()) {
            androidx.emoji2.text.c cVarC = androidx.emoji2.text.c.c();
            int iE = cVarC.e();
            if (iE == 3 || iE == 0) {
                b bVar = new b(this);
                this.V = bVar;
                cVarC.t(bVar);
            }
        }
    }

    public final void q(MotionEvent motionEvent) {
        this.y = 0;
        boolean targetCheckedState = true;
        boolean z = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z) {
            this.C.computeCurrentVelocity(1000);
            float xVelocity = this.C.getXVelocity();
            if (Math.abs(xVelocity) <= this.D) {
                targetCheckedState = getTargetCheckedState();
            } else if (!f55.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(an4.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
        setTextOnInternal(this.t);
        setTextOffInternal(this.v);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.M = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.x != z) {
            this.x = z;
            requestLayout();
            if (z) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.s = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.q = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.r = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.N.getTypeface() == null || this.N.getTypeface().equals(typeface)) && (this.N.getTypeface() != null || typeface == null)) {
            return;
        }
        this.N.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.E = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(e9.b(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.p = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.g = colorStateList;
        this.i = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.h = mode;
        this.j = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(e9.b(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        this.n = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        this.o = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f || drawable == this.k;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.J);
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }
}
