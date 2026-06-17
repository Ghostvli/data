package com.google.android.material.focus;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.animation.OvershootInterpolator;
import defpackage.cn3;
import defpackage.he4;
import defpackage.l62;
import defpackage.mk3;
import defpackage.p52;
import defpackage.x44;
import defpackage.y44;
import defpackage.z44;
import defpackage.zk3;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class FocusRingDrawable extends DrawableWrapper {
    public static final Drawable u = new ColorDrawable(0);
    public static final int[] v = {R.attr.state_focused};
    public static final TimeInterpolator w = new OvershootInterpolator(4.0f);
    public static final FloatProperty x = new a("interpolation");
    public final Paint f;
    public final RectF g;
    public final Rect h;
    public final Path i;
    public final Path j;
    public final Matrix k;
    public final z44 l;
    public WeakReference m;
    public float n;
    public ObjectAnimator o;
    public float p;
    public boolean q;
    public boolean r;
    public boolean s;
    public c t;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends FloatProperty {
        public a(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(FocusRingDrawable focusRingDrawable) {
            return Float.valueOf(focusRingDrawable.p);
        }

        @Override // android.util.FloatProperty
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(FocusRingDrawable focusRingDrawable, float f) {
            focusRingDrawable.p = f;
            focusRingDrawable.invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            FocusRingDrawable.this.p = 1.0f;
            FocusRingDrawable.this.invalidateSelf();
        }
    }

    public FocusRingDrawable(c cVar, Resources resources) {
        super(null);
        this.f = new Paint(1);
        this.g = new RectF();
        this.h = new Rect();
        this.i = new Path();
        this.j = new Path();
        this.k = new Matrix();
        this.l = z44.m();
        this.n = -1.0f;
        this.p = 1.0f;
        this.r = false;
        this.s = false;
        c cVar2 = new c(cVar);
        this.t = cVar2;
        Drawable.ConstantState constantState = cVar2.a;
        if (constantState != null) {
            setDrawable(resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
        }
        A();
    }

    public static Drawable D(Context context, Drawable drawable) {
        return !z(context) ? drawable : new FocusRingDrawable(context, drawable);
    }

    public static FocusRingDrawable l(Drawable drawable) {
        if (drawable instanceof FocusRingDrawable) {
            return (FocusRingDrawable) drawable;
        }
        if (drawable instanceof DrawableWrapper) {
            Drawable drawable2 = ((DrawableWrapper) drawable).getDrawable();
            if (drawable2 instanceof FocusRingDrawable) {
                return (FocusRingDrawable) drawable2;
            }
        }
        if (!(drawable instanceof LayerDrawable)) {
            return null;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
            Drawable drawable3 = layerDrawable.getDrawable(i);
            if (drawable3 instanceof FocusRingDrawable) {
                return (FocusRingDrawable) drawable3;
            }
        }
        return null;
    }

    public static FocusRingDrawable s(Context context, LayerDrawable layerDrawable) {
        return t(context, layerDrawable, null);
    }

    public static FocusRingDrawable t(Context context, LayerDrawable layerDrawable, l62 l62Var) {
        if (!z(context)) {
            return null;
        }
        FocusRingDrawable focusRingDrawable = new FocusRingDrawable(context, u);
        if (l62Var != null) {
            focusRingDrawable.y(l62Var);
        }
        layerDrawable.addLayer(focusRingDrawable);
        focusRingDrawable.setCallback(layerDrawable);
        return focusRingDrawable;
    }

    public static boolean z(Context context) {
        return p52.d(context.getTheme(), mk3.r, false);
    }

    public final void A() {
        this.f.setStyle(Paint.Style.STROKE);
        if (Float.isNaN(this.t.j)) {
            return;
        }
        this.f.setStrokeWidth(this.t.j);
    }

    public final void B(TypedArray typedArray, Resources.Theme theme) {
        TypedValue typedValueB;
        Resources resources = theme.getResources();
        if (this.t.d != Integer.MIN_VALUE && (typedValueB = p52.b(theme, this.t.d)) != null) {
            this.t.c = typedValueB.data != 0;
            this.t.e = true;
        }
        if (!this.t.e) {
            c cVar = this.t;
            cVar.c = p52.d(theme, mk3.r, cVar.c);
        }
        if (this.t.c) {
            c cVar2 = this.t;
            cVar2.f = v(cVar2.f, theme, this.t.g, typedArray, cn3.x2, -16777216);
            c cVar3 = this.t;
            cVar3.h = v(cVar3.h, theme, this.t.i, typedArray, cn3.t2, -1);
            float dimensionPixelSize = resources.getDimensionPixelSize(zk3.c0);
            c cVar4 = this.t;
            cVar4.j = w(cVar4.j, theme, this.t.k, typedArray, cn3.y2, dimensionPixelSize);
            c cVar5 = this.t;
            cVar5.l = w(cVar5.l, theme, this.t.m, typedArray, cn3.v2, dimensionPixelSize);
            c cVar6 = this.t;
            cVar6.n = w(cVar6.n, theme, this.t.o, typedArray, cn3.z2, Float.NaN);
            c cVar7 = this.t;
            cVar7.p = w(cVar7.p, theme, this.t.q, typedArray, cn3.w2, 0.0f);
            c cVar8 = this.t;
            cVar8.r = w(cVar8.r, theme, this.t.s, typedArray, cn3.u2, 0.0f);
            int i = this.t.u;
            c cVar9 = this.t;
            if (i != Integer.MIN_VALUE) {
                cVar9.t = y44.l(theme, cVar9.u).m();
                return;
            }
            TypedValue typedValueB2 = p52.b(theme, cVar9.v != Integer.MIN_VALUE ? this.t.v : mk3.s);
            if (typedValueB2 != null) {
                this.t.t = y44.l(theme, typedValueB2.resourceId).m();
            }
        }
    }

    public final void C(TypedArray typedArray) {
        this.t.d = o(typedArray, cn3.s2);
        if (this.t.d == Integer.MIN_VALUE && typedArray.hasValue(cn3.s2)) {
            c cVar = this.t;
            cVar.c = typedArray.getBoolean(cn3.s2, cVar.c);
            this.t.e = true;
        }
        this.t.g = o(typedArray, cn3.x2);
        if (this.t.g == Integer.MIN_VALUE) {
            this.t.f = typedArray.getColor(cn3.x2, Integer.MIN_VALUE);
        }
        this.t.i = o(typedArray, cn3.t2);
        if (this.t.i == Integer.MIN_VALUE) {
            this.t.h = typedArray.getColor(cn3.t2, Integer.MIN_VALUE);
        }
        this.t.k = o(typedArray, cn3.y2);
        if (this.t.k == Integer.MIN_VALUE) {
            this.t.j = typedArray.getDimension(cn3.y2, Float.NaN);
        }
        this.t.m = o(typedArray, cn3.v2);
        if (this.t.m == Integer.MIN_VALUE) {
            this.t.l = typedArray.getDimension(cn3.v2, Float.NaN);
        }
        this.t.m = o(typedArray, cn3.v2);
        if (this.t.m == Integer.MIN_VALUE) {
            this.t.l = typedArray.getDimension(cn3.v2, Float.NaN);
        }
        this.t.o = o(typedArray, cn3.z2);
        if (this.t.o == Integer.MIN_VALUE) {
            this.t.n = typedArray.getDimension(cn3.z2, Float.NaN);
        }
        this.t.q = o(typedArray, cn3.w2);
        if (this.t.q == Integer.MIN_VALUE) {
            this.t.p = typedArray.getDimension(cn3.w2, Float.NaN);
        }
        this.t.s = o(typedArray, cn3.u2);
        if (this.t.s == Integer.MIN_VALUE) {
            this.t.r = typedArray.getDimension(cn3.u2, Float.NaN);
        }
        this.t.v = o(typedArray, cn3.A2);
        this.t.u = n(typedArray, cn3.A2);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        q(theme);
    }

    public final void c(RectF rectF) {
        if (this.t.w != null) {
            rectF.set(this.t.w);
            return;
        }
        WeakReference weakReference = this.m;
        if (weakReference != null && weakReference.get() != null) {
            rectF.set(((l62) this.m.get()).getBounds());
            return;
        }
        if (!(getDrawable() instanceof RippleDrawable)) {
            rectF.set(getBounds());
            return;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) getDrawable();
        rippleDrawable.getHotspotBounds(this.h);
        int radius = rippleDrawable.getRadius();
        if (radius > 0) {
            this.h.inset(Math.max(0, (this.h.width() / 2) - radius), Math.max(0, (this.h.height() / 2) - radius));
        }
        rectF.set(this.h);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return true;
    }

    public final float d() {
        return this.t.p + this.t.r + ((this.t.l / 2.0f) * this.p);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.t.c && this.r) {
            float f = f();
            float fD = d();
            Path pathM = m();
            if (pathM != null) {
                j(canvas, pathM, fD, this.t.l, this.t.h);
                j(canvas, pathM, f, this.t.j, this.t.f);
            } else {
                float fG = g();
                k(canvas, e(fG), fD, this.t.l, this.t.h);
                k(canvas, fG, f, this.t.j, this.t.f);
            }
        }
    }

    public final float e(float f) {
        return Math.max(0.0f, f - (this.t.j / 2.0f));
    }

    public final float f() {
        return this.t.p + ((this.t.j / 2.0f) * this.p);
    }

    public final float g() {
        int radius;
        if (!Float.isNaN(this.t.n)) {
            return this.t.n;
        }
        float f = this.n;
        if (f >= 0.0f) {
            return f;
        }
        WeakReference weakReference = this.m;
        if (weakReference != null && weakReference.get() != null) {
            float fM = ((l62) this.m.get()).m();
            if (fM >= 0.0f) {
                return Math.max(0.0f, fM - (this.t.j / 2.0f));
            }
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof RippleDrawable) || (radius = ((RippleDrawable) drawable).getRadius()) < 0) {
            return 0.0f;
        }
        return radius;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!this.t.Q()) {
            return null;
        }
        this.t.b = getChangingConfigurations();
        return this.t;
    }

    public final void h() {
        if (this.t.t == null) {
            this.n = -1.0f;
            this.j.reset();
            return;
        }
        c(this.g);
        y44 y44VarB = this.t.t.b(v);
        if (!y44VarB.B(this.g)) {
            this.l.f(y44VarB, null, 1.0f, this.g, null, this.j);
            this.n = -1.0f;
        } else {
            float f = f();
            this.g.inset(f, f);
            this.n = y44VarB.x().a(this.g);
            this.j.reset();
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean hasFocusStateSpecified() {
        try {
            if (super.hasFocusStateSpecified()) {
                return true;
            }
            return this.t.c;
        } catch (NoSuchMethodError unused) {
            return this.t.c;
        }
    }

    public final ObjectAnimator i() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, x, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(w);
        objectAnimatorOfFloat.addListener(new b());
        return objectAnimatorOfFloat;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, cn3.r2, 0, 0) : resources.obtainAttributes(attributeSet, cn3.r2);
        C(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        p(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.isProjected();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return super.isStateful() || this.t.c;
    }

    public final void j(Canvas canvas, Path path, float f, float f2, int i) {
        c(this.g);
        float f3 = f * 2.0f;
        float fWidth = 1.0f - (f3 / this.g.width());
        float fHeight = 1.0f - (f3 / this.g.height());
        this.k.reset();
        this.k.postScale(fWidth, fHeight, this.g.centerX(), this.g.centerY());
        path.transform(this.k, this.i);
        this.f.setStrokeWidth(f2 * this.p);
        this.f.setColor(i);
        canvas.drawPath(this.i, this.f);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        ObjectAnimator objectAnimator = this.o;
        if (objectAnimator != null) {
            objectAnimator.end();
            this.o = null;
        }
    }

    public final void k(Canvas canvas, float f, float f2, float f3, int i) {
        c(this.g);
        this.g.inset(f2, f2);
        this.f.setStrokeWidth(f3 * this.p);
        this.f.setColor(i);
        canvas.drawRoundRect(this.g, f, f, this.f);
    }

    public final Path m() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        WeakReference weakReference = this.m;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        Path pathF = ((l62) this.m.get()).F();
        if (pathF.isEmpty()) {
            return null;
        }
        return pathF;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.s && super.mutate() == this) {
            this.t = new c(this.t);
            Drawable drawable = getDrawable();
            if (drawable != null) {
                this.t.a = drawable.getConstantState();
            }
            this.s = true;
        }
        return this;
    }

    public final int n(TypedArray typedArray, int i) {
        if (typedArray.getType(i) == 1) {
            return typedArray.getResourceId(i, Integer.MIN_VALUE);
        }
        return Integer.MIN_VALUE;
    }

    public final int o(TypedArray typedArray, int i) {
        if (typedArray.getType(i) != 2) {
            return Integer.MIN_VALUE;
        }
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i, typedValue)) {
            return typedValue.data;
        }
        return Integer.MIN_VALUE;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.t.c) {
            h();
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (!this.t.c) {
            this.r = false;
            return super.onStateChange(iArr);
        }
        boolean zStateSetMatches = StateSet.stateSetMatches(v, iArr);
        boolean z = this.r != zStateSetMatches;
        this.r = zStateSetMatches;
        if (z && iArr.length > 0 && !this.q) {
            u(zStateSetMatches);
        }
        this.q = iArr.length == 0;
        return super.onStateChange(iArr) || z;
    }

    public final void p(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        Drawable drawableCreateFromXmlInner = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                break;
            } else if (next == 2) {
                drawableCreateFromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawableCreateFromXmlInner != null) {
            setDrawable(drawableCreateFromXmlInner);
            this.t.a = drawableCreateFromXmlInner.getConstantState();
        } else {
            Drawable drawable = u;
            setDrawable(drawable);
            this.t.a = drawable.getConstantState();
        }
    }

    public final void q(Resources.Theme theme) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(cn3.r2);
        B(typedArrayObtainStyledAttributes, theme);
        typedArrayObtainStyledAttributes.recycle();
        A();
    }

    public boolean r() {
        return this.t.c;
    }

    public final void u(boolean z) {
        ObjectAnimator objectAnimator = this.o;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.o = null;
        }
        if (!z) {
            this.p = 1.0f;
            return;
        }
        ObjectAnimator objectAnimatorI = i();
        this.o = objectAnimatorI;
        objectAnimatorI.start();
    }

    public final int v(int i, Resources.Theme theme, int i2, TypedArray typedArray, int i3, int i4) {
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (i2 != Integer.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (theme.resolveAttribute(i2, typedValue, true)) {
                return typedValue.data;
            }
        }
        return typedArray.getColor(i3, i4);
    }

    public final float w(float f, Resources.Theme theme, int i, TypedArray typedArray, int i2, float f2) {
        if (!Float.isNaN(f)) {
            return f;
        }
        if (i != Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (theme.resolveAttribute(i, typedValue, true)) {
                return typedValue.getDimension(theme.getResources().getDisplayMetrics());
            }
        }
        return typedArray.getDimension(i2, f2);
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.t.w == null) {
            this.t.w = new Rect();
        }
        this.t.w.set(i, i2, i3, i4);
    }

    public void y(l62 l62Var) {
        this.m = new WeakReference(l62Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends Drawable.ConstantState {
        public Drawable.ConstantState a;
        public int b;
        public boolean c;
        public int d;
        public boolean e;
        public int f;
        public int g;
        public int h;
        public int i;
        public float j;
        public int k;
        public float l;
        public int m;
        public float n;
        public int o;
        public float p;
        public int q;
        public float r;
        public int s;
        public x44 t;
        public int u;
        public int v;
        public Rect w;

        public c(c cVar) {
            this.b = 0;
            this.c = false;
            this.d = Integer.MIN_VALUE;
            this.e = false;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = Integer.MIN_VALUE;
            this.i = Integer.MIN_VALUE;
            this.j = Float.NaN;
            this.k = Integer.MIN_VALUE;
            this.l = Float.NaN;
            this.m = Integer.MIN_VALUE;
            this.n = Float.NaN;
            this.o = Integer.MIN_VALUE;
            this.p = Float.NaN;
            this.q = Integer.MIN_VALUE;
            this.r = Float.NaN;
            this.s = Integer.MIN_VALUE;
            this.t = null;
            this.u = Integer.MIN_VALUE;
            this.v = Integer.MIN_VALUE;
            this.w = null;
            if (cVar != null) {
                this.a = cVar.a;
                this.b = cVar.b;
                this.c = cVar.c;
                this.d = cVar.d;
                this.e = cVar.e;
                this.f = cVar.f;
                this.g = cVar.g;
                this.h = cVar.h;
                this.i = cVar.i;
                this.j = cVar.j;
                this.k = cVar.k;
                this.l = cVar.l;
                this.m = cVar.m;
                this.n = cVar.n;
                this.o = cVar.o;
                this.p = cVar.p;
                this.q = cVar.q;
                this.r = cVar.r;
                this.s = cVar.s;
                this.u = cVar.u;
                this.v = cVar.v;
                x44 x44Var = cVar.t;
                if (x44Var instanceof y44) {
                    this.t = ((y44) x44Var).C().m();
                } else if (x44Var instanceof he4) {
                    this.t = ((he4) x44Var).j().j();
                } else {
                    this.t = x44Var;
                }
                if (cVar.w != null) {
                    this.w = new Rect(cVar.w);
                }
            }
        }

        public boolean Q() {
            return this.a != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            Drawable.ConstantState constantState = this.a;
            return this.b | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new FocusRingDrawable(this, null, 0 == true ? 1 : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new FocusRingDrawable(this, resources, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public FocusRingDrawable() {
        super(null);
        this.f = new Paint(1);
        this.g = new RectF();
        this.h = new Rect();
        this.i = new Path();
        this.j = new Path();
        this.k = new Matrix();
        this.l = z44.m();
        this.n = -1.0f;
        this.p = 1.0f;
        this.r = false;
        this.s = false;
        this.t = new c(null);
    }

    public FocusRingDrawable(Context context, Drawable drawable) {
        super(drawable);
        this.f = new Paint(1);
        this.g = new RectF();
        this.h = new Rect();
        this.i = new Path();
        this.j = new Path();
        this.k = new Matrix();
        this.l = z44.m();
        this.n = -1.0f;
        this.p = 1.0f;
        this.r = false;
        this.s = false;
        c cVar = new c(null);
        this.t = cVar;
        if (drawable != null) {
            cVar.a = drawable.getConstantState();
        }
        q(context.getTheme());
    }

    public /* synthetic */ FocusRingDrawable(c cVar, Resources resources, a aVar) {
        this(cVar, resources);
    }
}
