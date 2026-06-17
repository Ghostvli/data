package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.focus.FocusRingDrawable;
import defpackage.c30;
import defpackage.dl;
import defpackage.hg3;
import defpackage.ju2;
import defpackage.k7;
import defpackage.ki1;
import defpackage.l62;
import defpackage.lu2;
import defpackage.m62;
import defpackage.mk3;
import defpackage.o7;
import defpackage.r54;
import defpackage.s62;
import defpackage.sk3;
import defpackage.w44;
import defpackage.wt3;
import defpackage.y44;
import defpackage.zl3;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final TimeInterpolator C = k7.c;
    public static final int D = mk3.C;
    public static final int E = mk3.L;
    public static final int F = mk3.D;
    public static final int G = mk3.J;
    public static final int[] H = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] I = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] J = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] K = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] L = {R.attr.state_enabled};
    public static final int[] M = new int[0];
    public ViewTreeObserver.OnPreDrawListener B;
    public y44 a;
    public l62 b;
    public Drawable c;
    public dl d;
    public Drawable e;
    public boolean f;
    public float h;
    public float i;
    public float j;
    public int k;
    public StateListAnimator l;
    public Animator m;
    public ju2 n;
    public ju2 o;
    public int q;
    public ArrayList s;
    public ArrayList t;
    public ArrayList u;
    public final FloatingActionButton v;
    public final w44 w;
    public boolean g = true;
    public float p = 1.0f;
    public int r = 0;
    public final Rect x = new Rect();
    public final RectF y = new RectF();
    public final RectF z = new RectF();
    public final Matrix A = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0065a extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ g c;

        public C0065a(boolean z, g gVar) {
            this.b = z;
            this.c = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.r = 0;
            a.this.m = null;
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.v;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            g gVar = this.c;
            if (gVar != null) {
                gVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.v.b(0, this.b);
            a.this.r = 1;
            a.this.m = animator;
            this.a = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ g b;

        public b(boolean z, g gVar) {
            this.a = z;
            this.b = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.r = 0;
            a.this.m = null;
            g gVar = this.b;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.v.b(0, this.a);
            a.this.r = 2;
            a.this.m = animator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends s62 {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            a.this.p = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements TypeEvaluator {
        public final FloatEvaluator a = new FloatEvaluator();

        public d() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f, Float f2, Float f3) {
            float fFloatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends l62 {
        public e(y44 y44Var) {
            super(y44Var);
        }

        @Override // defpackage.l62, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface g {
        void a();

        void b();
    }

    public a(FloatingActionButton floatingActionButton, w44 w44Var) {
        this.v = floatingActionButton;
        this.w = w44Var;
    }

    public static /* synthetic */ void a(a aVar, float f2, float f3, float f4, float f5, float f6, float f7, float f8, Matrix matrix, ValueAnimator valueAnimator) {
        aVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        aVar.v.setAlpha(k7.b(f2, f3, 0.0f, 0.2f, fFloatValue));
        aVar.v.setScaleX(k7.a(f4, f5, fFloatValue));
        aVar.v.setScaleY(k7.a(f6, f5, fFloatValue));
        aVar.p = k7.a(f7, f8, fFloatValue);
        aVar.e(k7.a(f7, f8, fFloatValue), matrix);
        aVar.v.setImageMatrix(matrix);
    }

    public void A() {
        l62 l62Var = this.b;
        if (l62Var != null) {
            m62.f(this.v, l62Var);
        }
    }

    public void B() {
        Z();
    }

    public void C() {
        ViewTreeObserver viewTreeObserver = this.v.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.B;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.B = null;
        }
    }

    public void D(float f2, float f3, float f4) {
        if (this.v.getStateListAnimator() == this.l) {
            StateListAnimator stateListAnimatorI = i(f2, f3, f4);
            this.l = stateListAnimatorI;
            this.v.setStateListAnimator(stateListAnimatorI);
        }
        if (V()) {
            Z();
        }
    }

    public void E(Rect rect) {
        hg3.h(this.e, "Didn't initialize content background");
        if (!V()) {
            this.w.b(this.e);
        } else {
            this.w.b(new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    public void F() {
        ArrayList arrayList = this.u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b();
            }
        }
    }

    public void G() {
        ArrayList arrayList = this.u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }
    }

    public void H(ColorStateList colorStateList) {
        l62 l62Var = this.b;
        if (l62Var != null) {
            l62Var.setTintList(colorStateList);
        }
        dl dlVar = this.d;
        if (dlVar != null) {
            dlVar.c(colorStateList);
        }
    }

    public void I(PorterDuff.Mode mode) {
        l62 l62Var = this.b;
        if (l62Var != null) {
            l62Var.setTintMode(mode);
        }
    }

    public final void J(float f2) {
        if (this.h != f2) {
            this.h = f2;
            D(f2, this.i, this.j);
        }
    }

    public void K(boolean z) {
        this.f = z;
    }

    public final void L(ju2 ju2Var) {
        this.o = ju2Var;
    }

    public final void M(float f2) {
        if (this.i != f2) {
            this.i = f2;
            D(this.h, f2, this.j);
        }
    }

    public final void N(float f2) {
        this.p = f2;
        Matrix matrix = this.A;
        e(f2, matrix);
        this.v.setImageMatrix(matrix);
    }

    public final void O(int i) {
        if (this.q != i) {
            this.q = i;
            Y();
        }
    }

    public void P(int i) {
        this.k = i;
    }

    public final void Q(float f2) {
        if (this.j != f2) {
            this.j = f2;
            D(this.h, this.i, f2);
        }
    }

    public void R(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(wt3.d(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(wt3.d(colorStateList));
        }
    }

    public void S(boolean z) {
        this.g = z;
        Z();
    }

    public final void T(y44 y44Var) {
        this.a = y44Var;
        l62 l62Var = this.b;
        if (l62Var != null) {
            l62Var.setShapeAppearanceModel(y44Var);
        }
        Object obj = this.c;
        if (obj instanceof r54) {
            ((r54) obj).setShapeAppearanceModel(y44Var);
        }
        dl dlVar = this.d;
        if (dlVar != null) {
            dlVar.f(y44Var);
        }
    }

    public final void U(ju2 ju2Var) {
        this.n = ju2Var;
    }

    public boolean V() {
        return this.w.a() || w();
    }

    public final boolean W() {
        return this.v.isLaidOut() && !this.v.isInEditMode();
    }

    public void X(g gVar, boolean z) {
        if (z()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = this.n == null;
        boolean zW = W();
        FloatingActionButton floatingActionButton = this.v;
        if (!zW) {
            floatingActionButton.b(0, z);
            this.v.setAlpha(1.0f);
            this.v.setScaleY(1.0f);
            this.v.setScaleX(1.0f);
            N(1.0f);
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            this.v.setAlpha(0.0f);
            this.v.setScaleY(z2 ? 0.4f : 0.0f);
            this.v.setScaleX(z2 ? 0.4f : 0.0f);
            N(z2 ? 0.4f : 0.0f);
        }
        ju2 ju2Var = this.n;
        AnimatorSet animatorSetF = ju2Var != null ? f(ju2Var, 1.0f, 1.0f, 1.0f) : h(1.0f, 1.0f, 1.0f, D, E);
        animatorSetF.addListener(new b(z, gVar));
        ArrayList arrayList = this.s;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetF.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetF.start();
    }

    public final void Y() {
        N(this.p);
    }

    public final void Z() {
        Rect rect = this.x;
        q(rect);
        E(rect);
        this.w.c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a0(float f2) {
        l62 l62Var = this.b;
        if (l62Var != null) {
            l62Var.d0(f2);
        }
    }

    public final void b0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new d());
    }

    public final void e(float f2, Matrix matrix) {
        matrix.reset();
        if (this.v.getDrawable() == null || this.q == 0) {
            return;
        }
        RectF rectF = this.y;
        RectF rectF2 = this.z;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.q;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.q;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    public final AnimatorSet f(ju2 ju2Var, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.v, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        ju2Var.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.v, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        ju2Var.e("scale").a(objectAnimatorOfFloat2);
        b0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.v, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        ju2Var.e("scale").a(objectAnimatorOfFloat3);
        b0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        e(f4, this.A);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.v, new ki1(), new c(), new Matrix(this.A));
        ju2Var.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        o7.a(animatorSet, arrayList);
        return animatorSet;
    }

    public dl g(int i, ColorStateList colorStateList) {
        Context context = this.v.getContext();
        dl dlVar = new dl((y44) hg3.g(this.a));
        dlVar.e(c30.b(context, sk3.e), c30.b(context, sk3.d), c30.b(context, sk3.b), c30.b(context, sk3.c));
        dlVar.d(i);
        dlVar.c(colorStateList);
        return dlVar;
    }

    public final AnimatorSet h(final float f2, final float f3, final float f4, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.v.getAlpha();
        final float scaleX = this.v.getScaleX();
        final float scaleY = this.v.getScaleY();
        final float f5 = this.p;
        final Matrix matrix = new Matrix(this.A);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: w21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.a(this.a, alpha, f2, scaleX, f3, scaleY, f5, f4, matrix, valueAnimator);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        o7.a(animatorSet, arrayList);
        animatorSet.setDuration(lu2.f(this.v.getContext(), i, this.v.getContext().getResources().getInteger(zl3.b)));
        animatorSet.setInterpolator(lu2.g(this.v.getContext(), i2, k7.b));
        return animatorSet;
    }

    public final StateListAnimator i(float f2, float f3, float f4) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(H, j(f2, f4));
        stateListAnimator.addState(I, j(f2, f3));
        stateListAnimator.addState(J, j(f2, f3));
        stateListAnimator.addState(K, j(f2, f3));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.v, "elevation", f2).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.v;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(C);
        stateListAnimator.addState(L, animatorSet);
        stateListAnimator.addState(M, j(0.0f, 0.0f));
        return stateListAnimator;
    }

    public final Animator j(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.v, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(C);
        return animatorSet;
    }

    public l62 k() {
        return new e((y44) hg3.g(this.a));
    }

    public final Drawable l() {
        return this.e;
    }

    public float m() {
        return this.v.getElevation();
    }

    public boolean n() {
        return this.f;
    }

    public final ju2 o() {
        return this.o;
    }

    public float p() {
        return this.i;
    }

    public void q(Rect rect) {
        if (this.w.a()) {
            int iU = u();
            int iMax = Math.max(iU, (int) Math.ceil(this.g ? m() + this.j : 0.0f));
            int iMax2 = Math.max(iU, (int) Math.ceil(r1 * 1.5f));
            rect.set(iMax, iMax2, iMax, iMax2);
            return;
        }
        if (!w()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.k - this.v.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    public float r() {
        return this.j;
    }

    public final y44 s() {
        return this.a;
    }

    public final ju2 t() {
        return this.n;
    }

    public int u() {
        if (this.f) {
            return Math.max((this.k - this.v.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    public void v(g gVar, boolean z) {
        a aVar;
        AnimatorSet animatorSetH;
        if (y()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        if (!W()) {
            this.v.b(z ? 8 : 4, z);
            if (gVar != null) {
                gVar.b();
                return;
            }
            return;
        }
        ju2 ju2Var = this.o;
        if (ju2Var != null) {
            animatorSetH = f(ju2Var, 0.0f, 0.0f, 0.0f);
            aVar = this;
        } else {
            aVar = this;
            animatorSetH = aVar.h(0.0f, 0.4f, 0.4f, F, G);
        }
        animatorSetH.addListener(aVar.new C0065a(z, gVar));
        ArrayList arrayList = aVar.t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetH.start();
    }

    public final boolean w() {
        return this.f && this.v.getSizeDimension() < this.k;
    }

    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        l62 l62VarK = k();
        this.b = l62VarK;
        l62VarK.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.S(this.v.getContext());
        if (i > 0) {
            this.d = g(i, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) hg3.g(this.d), (Drawable) hg3.g(this.b)});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(wt3.d(colorStateList2), layerDrawable, null);
        this.c = rippleDrawable;
        FocusRingDrawable.t(this.v.getContext(), rippleDrawable, this.b);
        this.e = rippleDrawable;
    }

    public boolean y() {
        int visibility = this.v.getVisibility();
        int i = this.r;
        return visibility == 0 ? i == 1 : i != 2;
    }

    public boolean z() {
        int visibility = this.v.getVisibility();
        int i = this.r;
        return visibility != 0 ? i == 2 : i != 1;
    }
}
