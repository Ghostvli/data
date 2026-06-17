package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.progressindicator.a;
import defpackage.cn3;
import defpackage.dn4;
import defpackage.dq0;
import defpackage.h6;
import defpackage.h62;
import defpackage.ho0;
import defpackage.jl;
import defpackage.kj1;
import defpackage.m7;
import defpackage.nk3;
import defpackage.no0;
import defpackage.o62;
import defpackage.oi;
import defpackage.uj0;
import defpackage.ym3;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ProgressBar {
    public static final int v = ym3.C;
    public oi f;
    public int g;
    public boolean h;
    public boolean i;
    public final int j;
    public final int k;
    public long l;
    public m7 m;
    public boolean n;
    public int o;
    public boolean p;
    public final dq0.p q;
    public final Runnable r;
    public final Runnable s;
    public final h6 t;
    public final h6 u;

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class RunnableC0066a implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RunnableC0066a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            a.this.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            a.this.l();
            a.this.l = -1L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends h6 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h6
        public void b(Drawable drawable) {
            a.this.setIndeterminate(false);
            a aVar = a.this;
            aVar.r(aVar.g, a.this.h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends h6 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h6
        public void b(Drawable drawable) {
            super.b(drawable);
            if (a.this.n) {
                return;
            }
            a aVar = a.this;
            aVar.setVisibility(aVar.o);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(o62.d(context, attributeSet, i, v), attributeSet, i);
        this.l = -1L;
        this.n = false;
        this.o = 4;
        this.q = new dq0.p() { // from class: ni
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // dq0.p
            public final void a(dq0 dq0Var, boolean z, float f, float f2) {
                a.a(this.a, dq0Var, z, f, f2);
            }
        };
        this.r = new RunnableC0066a();
        this.s = new b();
        this.t = new c();
        this.u = new d();
        Context context2 = getContext();
        this.f = j(context2, attributeSet);
        TypedArray typedArrayI = dn4.i(context2, attributeSet, cn3.R, i, i2, new int[0]);
        this.j = typedArrayI.getInt(cn3.Y, -1);
        this.k = Math.min(typedArrayI.getInt(cn3.W, -1), 1000);
        typedArrayI.recycle();
        this.m = new m7();
        this.i = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(a aVar, dq0 dq0Var, boolean z, float f, float f2) {
        if (aVar.getProgressDrawable() == null || aVar.getProgressDrawable().getLevel() != 10000) {
            return;
        }
        aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private no0 getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().y();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().E();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getHideAnimationBehavior() {
        return this.f.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getIndeterminateDrawable()Landroid/graphics/drawable/Drawable; */
    @Override // android.widget.ProgressBar
    public kj1 getIndeterminateDrawable() {
        return (kj1) super.getIndeterminateDrawable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] getIndicatorColor() {
        return this.f.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getIndicatorTrackGapSize() {
        return this.f.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getProgressDrawable()Landroid/graphics/drawable/Drawable; */
    @Override // android.widget.ProgressBar
    public uj0 getProgressDrawable() {
        return (uj0) super.getProgressDrawable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getShowAnimationBehavior() {
        return this.f.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTrackColor() {
        return this.f.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTrackCornerRadius() {
        return this.f.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getTrackCornerRadiusFraction() {
        return this.f.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTrackThickness() {
        return this.f.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWaveAmplitude() {
        return this.f.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWaveSpeed() {
        return this.f.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWavelengthDeterminate() {
        return this.f.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWavelengthIndeterminate() {
        return this.f.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(boolean z) {
        if (this.i) {
            ((ho0) getCurrentDrawable()).s(t(), false, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public abstract oi j(Context context, AttributeSet attributeSet);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k() {
        if (getVisibility() != 0) {
            removeCallbacks(this.r);
            return;
        }
        removeCallbacks(this.s);
        long jUptimeMillis = SystemClock.uptimeMillis() - this.l;
        int i = this.k;
        long j = i;
        Runnable runnable = this.s;
        if (jUptimeMillis >= j) {
            runnable.run();
        } else {
            postDelayed(runnable, ((long) i) - jUptimeMillis);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        ((ho0) getCurrentDrawable()).s(false, false, true);
        if (o()) {
            setVisibility(4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        if (this.k > 0) {
            this.l = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean n() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o() {
        if (getProgressDrawable() == null || !getProgressDrawable().isVisible()) {
            return getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        if (t()) {
            m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.s);
        removeCallbacks(this.r);
        ((ho0) getCurrentDrawable()).j();
        s();
        super.onDetachedFromWindow();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getCurrentDrawingDelegate().g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        try {
            no0 currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i2) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        i(i == 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        i(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p() {
        q();
        if (getProgressDrawable() != null) {
            getProgressDrawable().o(this.u);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().o(this.u);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q() {
        if (getProgressDrawable() == null || getIndeterminateDrawable() == null) {
            return;
        }
        getIndeterminateDrawable().x().d(this.t);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(int i, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() == null || z) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.g = i;
            this.h = z;
            this.n = true;
            if (!getIndeterminateDrawable().isVisible() || this.m.a(getContext().getContentResolver()) == 0.0f) {
                this.t.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().x().f();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().u(this.u);
            getIndeterminateDrawable().x().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().u(this.u);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAnimatorDurationScaleProvider(m7 m7Var) {
        this.m = m7Var;
        if (getProgressDrawable() != null) {
            getProgressDrawable().h = m7Var;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().h = m7Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHideAfterMaxProgress(boolean z) {
        if (getProgressDrawable() == null) {
            return;
        }
        if (z) {
            getProgressDrawable().A(this.q);
        } else {
            getProgressDrawable().I(this.q);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHideAnimationBehavior(int i) {
        this.f.h = i;
        invalidate();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            ho0 ho0Var = (ho0) getCurrentDrawable();
            if (ho0Var != null) {
                ho0Var.j();
            }
            super.setIndeterminate(z);
            ho0 ho0Var2 = (ho0) getCurrentDrawable();
            if (ho0Var2 != null) {
                ho0Var2.s(t(), false, false);
            }
            if ((ho0Var2 instanceof kj1) && t()) {
                ((kj1) ho0Var2).x().g();
            }
            this.n = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIndeterminateAnimatorDurationScale(float f) {
        oi oiVar = this.f;
        if (oiVar.n != f) {
            oiVar.n = f;
            getIndeterminateDrawable().x().c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof kj1) {
            ((ho0) drawable).j();
            super.setIndeterminateDrawable(drawable);
        } else if (this.p) {
            jl.a("Cannot set framework drawable as indeterminate drawable.");
        } else {
            super.setIndeterminateDrawable(drawable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{h62.b(getContext(), nk3.w, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f.e = iArr;
        getIndeterminateDrawable().x().c();
        invalidate();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIndicatorTrackGapSize(int i) {
        oi oiVar = this.f;
        if (oiVar.i != i) {
            oiVar.i = i;
            oiVar.h();
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        r(i, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable instanceof uj0) {
            uj0 uj0Var = (uj0) drawable;
            uj0Var.j();
            super.setProgressDrawable(uj0Var);
            uj0Var.N(getProgress() / getMax());
            return;
        }
        if (this.p) {
            jl.a("Cannot set framework drawable as progress drawable.");
        } else {
            super.setProgressDrawable(drawable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowAnimationBehavior(int i) {
        this.f.g = i;
        invalidate();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTrackColor(int i) {
        oi oiVar = this.f;
        if (oiVar.f != i) {
            oiVar.f = i;
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTrackCornerRadius(int i) {
        oi oiVar = this.f;
        if (oiVar.b != i) {
            oiVar.b = Math.min(i, oiVar.a / 2);
            this.f.d = false;
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTrackCornerRadiusFraction(float f) {
        oi oiVar = this.f;
        if (oiVar.c != f) {
            oiVar.c = Math.min(f, 0.5f);
            this.f.d = true;
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTrackThickness(int i) {
        oi oiVar = this.f;
        if (oiVar.a != i) {
            oiVar.a = i;
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVisibilityAfterHide(int i) {
        if (i == 0 || i == 4 || i == 8) {
            this.o = i;
        } else {
            jl.a("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWaveAmplitude(int i) {
        oi oiVar = this.f;
        if (oiVar.l != i) {
            oiVar.l = Math.abs(i);
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWaveAmplitudeRampProgressMax(float f) {
        getProgressDrawable().O(f);
        invalidate();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWaveAmplitudeRampProgressMin(float f) {
        getProgressDrawable().P(f);
        invalidate();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWaveSpeed(int i) {
        this.f.m = i;
        getProgressDrawable().L(this.f.m != 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWavelength(int i) {
        setWavelengthDeterminate(i);
        setWavelengthIndeterminate(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWavelengthDeterminate(int i) {
        oi oiVar = this.f;
        if (oiVar.j != i) {
            oiVar.j = Math.abs(i);
            if (isIndeterminate()) {
                return;
            }
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWavelengthIndeterminate(int i) {
        oi oiVar = this.f;
        if (oiVar.k != i) {
            oiVar.k = Math.abs(i);
            if (isIndeterminate()) {
                requestLayout();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t() {
        return isAttachedToWindow() && getWindowVisibility() == 0 && n();
    }
}
