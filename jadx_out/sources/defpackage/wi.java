package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.material.focus.FocusRingDrawable;
import com.hierynomus.msdtyp.FileTime;
import defpackage.g2;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okio.internal.Buffer;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wi extends View {
    public static final String l1 = "wi";
    public static final int m1 = ym3.E;
    public static final int n1 = mk3.F;
    public static final int o1 = mk3.H;
    public static final int p1 = mk3.L;
    public static final int q1 = mk3.J;
    public int A;
    public int A0;
    public int B;
    public float[] B0;
    public int C;
    public int C0;
    public int D;
    public int D0;
    public int E;
    public int E0;
    public int F;
    public int F0;
    public int G;
    public boolean G0;
    public int H;
    public boolean H0;
    public int I;
    public boolean I0;
    public int J;
    public ColorStateList J0;
    public int K;
    public ColorStateList K0;
    public int L;
    public ColorStateList L0;
    public int M;
    public ColorStateList M0;
    public int N;
    public ColorStateList N0;
    public int O;
    public final Path O0;
    public int P;
    public final RectF P0;
    public int Q;
    public final RectF Q0;
    public int R;
    public final RectF R0;
    public int S;
    public final RectF S0;
    public int T;
    public final Rect T0;
    public int U;
    public final RectF U0;
    public int V;
    public final Rect V0;
    public boolean W;
    public final Matrix W0;
    public final List X0;
    public Drawable Y0;
    public List Z0;
    public Drawable a0;
    public float a1;
    public boolean b0;
    public float b1;
    public Drawable c0;
    public ColorStateList c1;
    public boolean d0;
    public ColorStateList d1;
    public ColorStateList e0;
    public float e1;
    public final Paint f;
    public Drawable f0;
    public int f1;
    public final Paint g;
    public boolean g0;
    public final int g1;
    public final Paint h;
    public Drawable h0;
    public final ViewTreeObserver.OnScrollChangedListener h1;
    public final Paint i;
    public boolean i0;
    public final ViewTreeObserver.OnGlobalLayoutListener i1;
    public final Paint j;
    public ColorStateList j0;
    public final Runnable j1;
    public final Paint k;
    public int k0;
    public boolean k1;
    public final Paint l;
    public int l0;
    public final c m;
    public int m0;
    public final AccessibilityManager n;
    public float n0;
    public b o;
    public float o0;
    public int p;
    public MotionEvent p0;
    public final List q;
    public final Rect q0;
    public final List r;
    public List r0;
    public final List s;
    public List s0;
    public boolean t;
    public boolean t0;
    public ValueAnimator u;
    public float u0;
    public ValueAnimator v;
    public float v0;
    public final int w;
    public ArrayList w0;
    public final int x;
    public int x0;
    public int y;
    public int y0;
    public int z;
    public float z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ViewOverlay viewOverlayA0 = wi.this.a0();
            if (viewOverlayA0 == null) {
                return;
            }
            Iterator it = wi.this.q.iterator();
            while (it.hasNext()) {
                viewOverlayA0.remove((yp4) it.next());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends ry0 {
        public final wi q;
        public final Rect r;

        public c(wi wiVar) {
            super(wiVar);
            this.r = new Rect();
            this.q = wiVar;
        }

        @Override // defpackage.ry0
        public int B(float f, float f2) {
            for (int i = 0; i < this.q.getValues().size(); i++) {
                this.q.a1(i, this.r);
                if (this.r.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // defpackage.ry0
        public void C(List list) {
            for (int i = 0; i < this.q.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // defpackage.ry0
        public boolean L(int i, int i2, Bundle bundle) {
            if (!this.q.isEnabled()) {
                return false;
            }
            if (i2 != 4096 && i2 != 8192) {
                if (i2 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    if (this.q.Y0(i, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                        this.q.d1();
                        this.q.postInvalidate();
                        return true;
                    }
                }
                return false;
            }
            float fW = this.q.w(20);
            if (i2 == 8192) {
                fW = -fW;
            }
            if (this.q.v0()) {
                fW = -fW;
            }
            if (!this.q.Y0(i, r62.a(this.q.getValues().get(i).floatValue() + fW, this.q.getValueFrom(), this.q.getValueTo()))) {
                return false;
            }
            this.q.setActiveThumbIndex(i);
            this.q.P0();
            this.q.d1();
            this.q.postInvalidate();
            return true;
        }

        @Override // defpackage.ry0
        public void P(int i, g2 g2Var) {
            g2Var.b(g2.a.L);
            List<Float> values = this.q.getValues();
            Float f = values.get(i);
            float fFloatValue = f.floatValue();
            float valueFrom = this.q.getValueFrom();
            float valueTo = this.q.getValueTo();
            if (this.q.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    g2Var.a(8192);
                }
                if (fFloatValue < valueTo) {
                    g2Var.a(Buffer.SEGMENTING_THRESHOLD);
                }
            }
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            try {
                valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
                valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
                fFloatValue = numberInstance.parse(numberInstance.format(fFloatValue)).floatValue();
            } catch (ParseException unused) {
                Log.w(wi.l1, String.format("Error parsing value(%s), valueFrom(%s), and valueTo(%s) into a float.", f, Float.valueOf(valueFrom), Float.valueOf(valueTo)));
            }
            g2Var.E0(g2.g.a(1, valueFrom, valueTo, fFloatValue));
            g2Var.l0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.q.getContentDescription() != null) {
                sb.append(this.q.getContentDescription());
                sb.append(",");
            }
            String strU = this.q.U(fFloatValue);
            String string = this.q.getContext().getString(tm3.n);
            if (values.size() > 1) {
                string = Z(i);
            }
            CharSequence charSequenceE = l35.E(this.q);
            if (TextUtils.isEmpty(charSequenceE)) {
                sb.append(String.format(Locale.getDefault(), "%s, %s", string, strU));
            } else {
                g2Var.K0(charSequenceE);
            }
            g2Var.p0(sb.toString());
            this.q.a1(i, this.r);
            g2Var.h0(this.r);
        }

        public final String Z(int i) {
            return i == this.q.getValues().size() + (-1) ? this.q.getContext().getString(tm3.l) : i == 0 ? this.q.getContext().getString(tm3.m) : "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum d {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    public wi(Context context, AttributeSet attributeSet, int i) {
        super(o62.d(context, attributeSet, i, m1), attributeSet, i);
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = false;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.W = false;
        this.b0 = false;
        this.d0 = false;
        this.g0 = false;
        this.i0 = false;
        this.q0 = new Rect();
        this.r0 = new ArrayList();
        this.s0 = new ArrayList();
        this.t0 = false;
        this.w0 = new ArrayList();
        this.x0 = -1;
        this.y0 = -1;
        this.z0 = 0.0f;
        this.A0 = 0;
        this.H0 = false;
        this.O0 = new Path();
        this.P0 = new RectF();
        this.Q0 = new RectF();
        this.R0 = new RectF();
        this.S0 = new RectF();
        this.T0 = new Rect();
        this.U0 = new RectF();
        this.V0 = new Rect();
        this.W0 = new Matrix();
        this.X0 = new ArrayList();
        this.Z0 = Collections.EMPTY_LIST;
        this.f1 = 0;
        this.h1 = new ViewTreeObserver.OnScrollChangedListener() { // from class: ti
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.a.f1();
            }
        };
        this.i1 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ui
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f.f1();
            }
        };
        this.j1 = new Runnable() { // from class: vi
            @Override // java.lang.Runnable
            public final void run() {
                wi.a(this.f);
            }
        };
        Context context2 = getContext();
        this.k1 = isShown();
        this.f = new Paint();
        this.g = new Paint();
        Paint paint = new Paint(1);
        this.h = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.j = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.k = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.l = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        this.x = context2.getResources().getDimensionPixelSize(zk3.F);
        z0(context2.getResources());
        M0(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        this.w = ViewConfiguration.get(context2).getScaledTouchSlop();
        c cVar = new c(this);
        this.m = cVar;
        l35.g0(this, cVar);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.n = accessibilityManager;
        if (Build.VERSION.SDK_INT >= 29) {
            this.g1 = accessibilityManager.getRecommendedTimeoutMillis(FileTime.NANO100_TO_MILLI, 6);
        } else {
            this.g1 = 120000;
        }
    }

    public static float W(ValueAnimator valueAnimator, float f) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    public static /* synthetic */ void a(wi wiVar) {
        wiVar.setActiveThumbIndex(-1);
        wiVar.invalidate();
    }

    public static /* synthetic */ void b(wi wiVar, ValueAnimator valueAnimator) {
        wiVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator it = wiVar.q.iterator();
        while (it.hasNext()) {
            ((yp4) it.next()).K0(fFloatValue);
        }
        wiVar.postInvalidateOnAnimation();
    }

    public static boolean p0(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    public final int A(boolean z) {
        return z ? 0 : 2;
    }

    public final void A0(Canvas canvas, int i, int i2) {
        Canvas canvas2;
        if (U0()) {
            float[] fArr = {this.L + (H0(((Float) this.w0.get(this.y0)).floatValue()) * i), i2};
            if (y0()) {
                this.W0.mapPoints(fArr);
            }
            if (Build.VERSION.SDK_INT < 28) {
                float f = fArr[0];
                int i3 = this.O;
                float f2 = fArr[1];
                canvas2 = canvas;
                canvas2.clipRect(f - i3, f2 - i3, f + i3, f2 + i3, Region.Op.UNION);
            } else {
                canvas2 = canvas;
            }
            canvas2.drawCircle(fArr[0], fArr[1], this.O, this.i);
        }
    }

    public final ValueAnimator B(boolean z) {
        int iF;
        TimeInterpolator timeInterpolatorG;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(W(z ? this.v : this.u, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        if (z) {
            iF = lu2.f(getContext(), n1, 83);
            timeInterpolatorG = lu2.g(getContext(), p1, k7.e);
        } else {
            iF = lu2.f(getContext(), o1, Token.OR);
            timeInterpolatorG = lu2.g(getContext(), q1, k7.c);
        }
        valueAnimatorOfFloat.setDuration(iF);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorG);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: si
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                wi.b(this.a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void B0(Canvas canvas, int i) {
        if (this.T <= 0 || this.w0.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.w0;
        float fFloatValue = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        float f = this.v0;
        if (fFloatValue < f) {
            L(canvas, w1(f), i);
        }
        if (l0() || (this.w0.size() > 1 && ((Float) this.w0.get(0)).floatValue() > this.u0)) {
            L(canvas, w1(this.u0), i);
        }
    }

    public final void C() {
        if (this.q.size() > this.w0.size()) {
            List<yp4> listSubList = this.q.subList(this.w0.size(), this.q.size());
            for (yp4 yp4Var : listSubList) {
                if (isAttachedToWindow()) {
                    E(yp4Var);
                }
            }
            listSubList.clear();
        }
        while (true) {
            if (this.q.size() >= this.w0.size()) {
                break;
            }
            yp4 yp4VarC0 = yp4.C0(getContext(), null, 0, this.p);
            this.q.add(yp4VarC0);
            if (isAttachedToWindow()) {
                p(yp4VarC0);
            }
        }
        int i = this.q.size() != 1 ? 1 : 0;
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            ((yp4) it.next()).q0(i);
        }
    }

    public final void C0(Canvas canvas) {
        float[] fArr = this.B0;
        if (fArr == null || fArr.length == 0) {
            return;
        }
        float[] fArrV = V();
        int iCeil = (int) Math.ceil(fArrV[0] * ((this.B0.length / 2.0f) - 1.0f));
        int iFloor = (int) Math.floor(fArrV[1] * ((this.B0.length / 2.0f) - 1.0f));
        if (iCeil > 0) {
            O(0, iCeil * 2, canvas, this.j);
        }
        if (iCeil <= iFloor) {
            O(iCeil * 2, (iFloor + 1) * 2, canvas, this.k);
        }
        int i = (iFloor + 1) * 2;
        float[] fArr2 = this.B0;
        if (i < fArr2.length) {
            O(i, fArr2.length, canvas, this.j);
        }
    }

    public final l62 D() {
        l62 l62Var = new l62();
        l62Var.j0(2);
        l62Var.e0(getThumbTintList());
        l62Var.setShapeAppearanceModel(y44.e().p(0, this.M / 2.0f).m());
        l62Var.setBounds(0, 0, this.M, this.N);
        l62Var.d0(getThumbElevation());
        l62Var.q0(getThumbStrokeWidth());
        l62Var.p0(getThumbStrokeColor());
        l62Var.setState(getDrawableState());
        return l62Var;
    }

    public final boolean D0() {
        int iMax = this.y + Math.max(Math.max(Math.max((this.M / 2) - this.z, 0), Math.max((this.K - this.A) / 2, 0)), Math.max(Math.max(this.D0 - this.B, 0), Math.max(this.E0 - this.C, 0)));
        if (this.L == iMax) {
            return false;
        }
        this.L = iMax;
        if (!isLaidOut()) {
            return true;
        }
        p1(y0() ? getHeight() : getWidth());
        return true;
    }

    public final void E(yp4 yp4Var) {
        ViewGroup viewGroupD = e55.d(this);
        if (viewGroupD == null) {
            return;
        }
        viewGroupD.getOverlay().remove(yp4Var);
        yp4Var.E0(viewGroupD);
    }

    public final boolean E0() {
        int paddingTop;
        int paddingBottom;
        if (y0()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i = paddingTop + paddingBottom;
        int iMax = Math.max(this.H, Math.max(this.K + i, this.N + i));
        if (iMax == this.I) {
            return false;
        }
        this.I = iMax;
        return true;
    }

    public final float F(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f2 = (f - this.L) / this.F0;
        float f3 = this.u0;
        return (f2 * (f3 - this.v0)) + f3;
    }

    public final boolean F0(int i) {
        int i2 = this.y0;
        int iC = (int) r62.c(((long) i2) + ((long) i), 0L, this.w0.size() - 1);
        this.y0 = iC;
        if (iC == i2) {
            return false;
        }
        this.x0 = iC;
        h1();
        d1();
        postInvalidate();
        return true;
    }

    public final void G(int i) {
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            ((li) it.next()).a(this, ((Float) this.w0.get(i)).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.n;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        O0(i);
        this.m.E(i);
    }

    public final boolean G0(int i) {
        if (v0() || y0()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return F0(i);
    }

    public final void H() {
        for (li liVar : this.r) {
            Iterator it = this.w0.iterator();
            while (it.hasNext()) {
                liVar.a(this, ((Float) it.next()).floatValue(), false);
            }
        }
    }

    public final float H0(float f) {
        float f2 = this.u0;
        float f3 = (f - f2) / (this.v0 - f2);
        return (v0() || y0()) ? 1.0f - f3 : f3;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(android.graphics.Canvas r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wi.I(android.graphics.Canvas, int, int):void");
    }

    public final void I0() {
        Iterator it = this.s.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
    }

    public final void J(float f, float f2, float f3, float f4, Canvas canvas, RectF rectF, d dVar, int i) {
        if (f2 - f > getTrackCornerSize() - i) {
            rectF.set(f, f3, f2, f4);
        } else {
            rectF.setEmpty();
        }
        k1(canvas, this.f, rectF, getTrackCornerSize(), dVar);
    }

    public final void J0() {
        Iterator it = this.s.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
    }

    public final void K(Canvas canvas, int i, int i2) {
        int iX;
        int iX2;
        float[] fArrV = V();
        float f = i2;
        int i3 = this.K;
        float f2 = f - (i3 / 2.0f);
        float f3 = f + (i3 / 2.0f);
        int size = 0;
        if (l0() && fArrV[0] == 0.5f) {
            iX = this.P;
        } else {
            iX = x((v0() || y0()) ? this.w0.size() - 1 : 0);
        }
        int i4 = iX;
        float f4 = i;
        J(this.L - getTrackCornerSize(), (this.L + (fArrV[0] * f4)) - i4, f2, f3, canvas, this.Q0, d.LEFT, i4);
        if (l0() && fArrV[1] == 0.5f) {
            iX2 = this.P;
        } else {
            if (!v0() && !y0()) {
                size = this.w0.size() - 1;
            }
            iX2 = x(size);
        }
        int i5 = iX2;
        J(this.L + (fArrV[1] * f4) + i5, r1 + i + getTrackCornerSize(), f2, f3, canvas, this.R0, d.RIGHT, i5);
    }

    public abstract boolean K0();

    public final void L(Canvas canvas, float f, float f2) {
        for (int i = 0; i < this.w0.size(); i++) {
            float fW1 = w1(((Float) this.w0.get(i)).floatValue());
            float fX = x(i) + (this.M / 2.0f);
            if (f >= fW1 - fX && f <= fW1 + fX) {
                return;
            }
        }
        boolean zY0 = y0();
        Paint paint = this.l;
        if (zY0) {
            canvas.drawPoint(f2, f, paint);
        } else {
            canvas.drawPoint(f, f2, paint);
        }
    }

    public final void L0(yp4 yp4Var, float f) {
        t(yp4Var, f);
        if (y0()) {
            RectF rectF = new RectF(this.T0);
            this.W0.mapRect(rectF);
            rectF.round(this.T0);
        }
        pj0.c(e55.d(this), this, this.T0);
        yp4Var.setBounds(this.T0);
    }

    public final void M(Canvas canvas, int i, int i2, float f, Drawable drawable) {
        canvas.save();
        if (y0()) {
            canvas.concat(this.W0);
        }
        canvas.translate((this.L + ((int) (H0(f) * i))) - (drawable.getBounds().width() / 2.0f), i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void M0(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayI = dn4.i(context, attributeSet, cn3.D5, i, m1, new int[0]);
        setOrientation(typedArrayI.getInt(cn3.F5, 0));
        this.p = typedArrayI.getResourceId(cn3.O5, ym3.G);
        this.u0 = typedArrayI.getFloat(cn3.H5, 0.0f);
        this.v0 = typedArrayI.getFloat(cn3.I5, 1.0f);
        setCentered(typedArrayI.getBoolean(cn3.J5, false));
        this.z0 = typedArrayI.getFloat(cn3.G5, 0.0f);
        this.A0 = typedArrayI.getInt(cn3.K5, 0);
        this.E = (int) Math.ceil(typedArrayI.getDimension(cn3.P5, p52.i(context)));
        boolean zHasValue = typedArrayI.hasValue(cn3.f6);
        int i2 = zHasValue ? cn3.f6 : cn3.h6;
        int i3 = zHasValue ? cn3.f6 : cn3.g6;
        ColorStateList colorStateListB = k62.b(context, typedArrayI, i2);
        if (colorStateListB == null) {
            colorStateListB = e9.a(context, sk3.j);
        }
        setTrackInactiveTintList(colorStateListB);
        ColorStateList colorStateListB2 = k62.b(context, typedArrayI, i3);
        if (colorStateListB2 == null) {
            colorStateListB2 = e9.a(context, sk3.g);
        }
        setTrackActiveTintList(colorStateListB2);
        ColorStateList colorStateListB3 = k62.b(context, typedArrayI, cn3.Q5);
        if (colorStateListB3 == null) {
            colorStateListB3 = e9.a(context, sk3.k);
        }
        setThumbTintList(colorStateListB3);
        if (typedArrayI.hasValue(cn3.U5)) {
            setThumbStrokeColor(k62.b(context, typedArrayI, cn3.U5));
        }
        setThumbStrokeWidth(typedArrayI.getDimension(cn3.V5, 0.0f));
        ColorStateList colorStateListB4 = k62.b(context, typedArrayI, cn3.L5);
        if (colorStateListB4 == null) {
            colorStateListB4 = e9.a(context, sk3.h);
        }
        setHaloTintList(colorStateListB4);
        this.C0 = typedArrayI.hasValue(cn3.d6) ? typedArrayI.getInt(cn3.d6, -1) : A(typedArrayI.getBoolean(cn3.e6, true));
        boolean zHasValue2 = typedArrayI.hasValue(cn3.Y5);
        int i4 = zHasValue2 ? cn3.Y5 : cn3.a6;
        int i5 = zHasValue2 ? cn3.Y5 : cn3.Z5;
        ColorStateList colorStateListB5 = k62.b(context, typedArrayI, i4);
        if (colorStateListB5 == null) {
            colorStateListB5 = e9.a(context, sk3.i);
        }
        setTickInactiveTintList(colorStateListB5);
        ColorStateList colorStateListB6 = k62.b(context, typedArrayI, i5);
        if (colorStateListB6 == null) {
            colorStateListB6 = e9.a(context, sk3.f);
        }
        setTickActiveTintList(colorStateListB6);
        setThumbTrackGapSize(typedArrayI.getDimensionPixelSize(cn3.W5, 0));
        setTrackStopIndicatorSize(typedArrayI.getDimensionPixelSize(cn3.s6, 0));
        setTrackCornerSize(typedArrayI.getDimensionPixelSize(cn3.i6, -1));
        setTrackInsideCornerSize(typedArrayI.getDimensionPixelSize(cn3.r6, 0));
        setTrackIconActiveStart(k62.e(context, typedArrayI, cn3.m6));
        setTrackIconActiveEnd(k62.e(context, typedArrayI, cn3.l6));
        setTrackIconActiveColor(k62.b(context, typedArrayI, cn3.k6));
        setTrackIconInactiveStart(k62.e(context, typedArrayI, cn3.p6));
        setTrackIconInactiveEnd(k62.e(context, typedArrayI, cn3.o6));
        setTrackIconInactiveColor(k62.b(context, typedArrayI, cn3.n6));
        setTrackIconSize(typedArrayI.getDimensionPixelSize(cn3.q6, 0));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(cn3.T5, 0) * 2;
        int dimensionPixelSize2 = typedArrayI.getDimensionPixelSize(cn3.X5, dimensionPixelSize);
        int dimensionPixelSize3 = typedArrayI.getDimensionPixelSize(cn3.S5, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(typedArrayI.getDimensionPixelSize(cn3.M5, 0));
        setThumbElevation(typedArrayI.getDimension(cn3.R5, 0.0f));
        setTrackHeight(typedArrayI.getDimensionPixelSize(cn3.j6, 0));
        setTickActiveRadius(typedArrayI.getDimensionPixelSize(cn3.b6, this.T / 2));
        setTickInactiveRadius(typedArrayI.getDimensionPixelSize(cn3.c6, this.T / 2));
        setLabelBehavior(typedArrayI.getInt(cn3.N5, 0));
        if (!typedArrayI.getBoolean(cn3.E5, true)) {
            setEnabled(false);
        }
        setValues(Float.valueOf(this.u0));
        typedArrayI.recycle();
    }

    public final void N(Canvas canvas, int i, int i2) {
        wi wiVar;
        Canvas canvas2;
        int i3;
        int i4;
        int i5 = 0;
        while (i5 < this.w0.size()) {
            float fFloatValue = ((Float) this.w0.get(i5)).floatValue();
            Drawable drawable = this.Y0;
            if (drawable != null) {
                wiVar = this;
                canvas2 = canvas;
                i3 = i;
                i4 = i2;
                wiVar.M(canvas2, i3, i4, fFloatValue, drawable);
            } else {
                wiVar = this;
                canvas2 = canvas;
                i3 = i;
                i4 = i2;
                if (i5 < wiVar.Z0.size()) {
                    wiVar.M(canvas2, i3, i4, fFloatValue, (Drawable) wiVar.Z0.get(i5));
                } else {
                    if (!wiVar.isEnabled()) {
                        canvas2.drawCircle(wiVar.L + (wiVar.H0(fFloatValue) * i3), i4, wiVar.getThumbRadius(), wiVar.h);
                    }
                    wiVar.M(canvas2, i3, i4, fFloatValue, (Drawable) wiVar.X0.get(i5));
                }
            }
            i5++;
            this = wiVar;
            canvas = canvas2;
            i = i3;
            i2 = i4;
        }
    }

    public final void N0() {
        int i;
        if (!g0() || (i = this.Q) == -1 || this.R == -1) {
            return;
        }
        Q0(i, this.S, Integer.valueOf(this.x0));
    }

    public final void O(int i, int i2, Canvas canvas, Paint paint) {
        while (i < i2) {
            boolean zY0 = y0();
            float[] fArr = this.B0;
            float f = zY0 ? fArr[i + 1] : fArr[i];
            if (!s0(f) && (!l0() || !r0(f))) {
                float[] fArr2 = this.B0;
                canvas.drawPoint(fArr2[i], fArr2[i + 1], paint);
            }
            i += 2;
        }
    }

    public final void O0(int i) {
        b bVar = this.o;
        if (bVar == null) {
            this.o = new b(this, null);
        } else {
            removeCallbacks(bVar);
        }
        this.o.a(i);
        postDelayed(this.o, 200L);
    }

    public final void P(Canvas canvas, RectF rectF, Drawable drawable) {
        if (y0()) {
            this.W0.mapRect(rectF);
        }
        rectF.round(this.V0);
        drawable.setBounds(this.V0);
        drawable.draw(canvas);
    }

    public void P0() {
        removeCallbacks(this.j1);
        postDelayed(this.j1, this.g1);
    }

    public final void Q(Canvas canvas, RectF rectF, RectF rectF2) {
        if (i0()) {
            if (this.w0.size() > 1) {
                Log.w(l1, "Track icons can only be used when only 1 thumb is present.");
            }
            q(canvas, rectF, this.a0, true);
            q(canvas, rectF2, this.f0, true);
            q(canvas, rectF, this.c0, false);
            q(canvas, rectF2, this.h0, false);
        }
    }

    public final void Q0(int i, int i2, Integer num) {
        for (int i3 = 0; i3 < this.X0.size(); i3++) {
            if (num == null || i3 == num.intValue()) {
                ((l62) this.X0.get(i3)).setShapeAppearanceModel(y44.e().p(0, i / 2.0f).m());
                ((l62) this.X0.get(i3)).setBounds(0, 0, i, i2 >= 0 ? i2 : this.N);
            }
        }
        q1(false);
    }

    public final void R(boolean z) {
        if (!this.t) {
            this.t = true;
            ValueAnimator valueAnimatorB = B(true);
            this.u = valueAnimatorB;
            this.v = null;
            valueAnimatorB.start();
        }
        Iterator it = this.q.iterator();
        if (z) {
            for (int i = 0; i < this.w0.size() && it.hasNext(); i++) {
                if (i != this.y0) {
                    R0((yp4) it.next(), ((Float) this.w0.get(i)).floatValue());
                }
            }
        }
        if (it.hasNext()) {
            R0((yp4) it.next(), ((Float) this.w0.get(this.y0)).floatValue());
        } else {
            r14.a("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.q.size()), Integer.valueOf(this.w0.size())});
        }
    }

    public final void R0(yp4 yp4Var, float f) {
        yp4Var.L0(U(f));
        L0(yp4Var, f);
        ViewOverlay viewOverlayA0 = a0();
        if (viewOverlayA0 == null) {
            return;
        }
        viewOverlayA0.add(yp4Var);
    }

    public final void S() {
        if (this.t) {
            this.t = false;
            ValueAnimator valueAnimatorB = B(false);
            this.v = valueAnimatorB;
            this.u = null;
            valueAnimatorB.addListener(new a());
            this.v.start();
        }
    }

    public final void S0(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            jl.a("At least one value must be set");
            return;
        }
        Collections.sort(arrayList);
        if (this.w0.size() == arrayList.size() && this.w0.equals(arrayList)) {
            return;
        }
        this.w0 = arrayList;
        this.I0 = true;
        b1();
        this.y0 = 0;
        d1();
        C();
        H();
        postInvalidate();
    }

    public final void T(int i) {
        if (i == 1) {
            F0(Integer.MAX_VALUE);
            return;
        }
        if (i == 2) {
            F0(Integer.MIN_VALUE);
        } else if (i == 17) {
            G0(Integer.MAX_VALUE);
        } else {
            if (i != 66) {
                return;
            }
            G0(Integer.MIN_VALUE);
        }
    }

    public final boolean T0() {
        return this.J == 3;
    }

    public final String U(float f) {
        if (h0()) {
            throw null;
        }
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    public final boolean U0() {
        return this.G0 || X() == null;
    }

    public final float[] V() {
        float fFloatValue = ((Float) this.w0.get(0)).floatValue();
        ArrayList arrayList = this.w0;
        float fFloatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.w0.size() == 1) {
            fFloatValue = this.u0;
        }
        float fH0 = H0(fFloatValue);
        float fH02 = H0(fFloatValue2);
        if (l0()) {
            float fMin = Math.min(0.5f, fH02);
            fH02 = Math.max(0.5f, fH02);
            fH0 = fMin;
        }
        return (l0() || !(v0() || y0())) ? new float[]{fH0, fH02} : new float[]{fH02, fH0};
    }

    public final boolean V0(float f) {
        return Y0(this.x0, f);
    }

    public final double W0(float f) {
        float f2 = this.z0;
        if (f2 <= 0.0f) {
            return f;
        }
        int i = (int) ((this.v0 - this.u0) / f2);
        return ((double) Math.round(f * i)) / ((double) i);
    }

    public final RippleDrawable X() {
        Drawable background = getBackground();
        if (background instanceof DrawableWrapper) {
            background = ((DrawableWrapper) background).getDrawable();
        }
        if (background instanceof RippleDrawable) {
            return (RippleDrawable) background;
        }
        return null;
    }

    public final void X0() {
        if (this.x0 == -1 || this.s0.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.w0.size(); i++) {
            if (i == this.x0) {
                Y0(i, ((Float) this.s0.get(i)).floatValue());
                return;
            }
        }
    }

    public final float Y(int i, float f) {
        float minSeparation = getMinSeparation();
        if (this.f1 == 0) {
            minSeparation = F(minSeparation);
        }
        if (v0() || y0()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        return r62.a(f, i3 < 0 ? this.u0 : ((Float) this.w0.get(i3)).floatValue() + minSeparation, i2 >= this.w0.size() ? this.v0 : ((Float) this.w0.get(i2)).floatValue() - minSeparation);
    }

    public final boolean Y0(int i, float f) {
        this.y0 = i;
        if (Math.abs(f - ((Float) this.w0.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.w0.set(i, Float.valueOf(Y(i, f)));
        G(i);
        return true;
    }

    public final int Z(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean Z0() {
        return V0(f0());
    }

    public final ViewOverlay a0() {
        ViewGroup viewGroupD = e55.d(this);
        if (viewGroupD == null) {
            return null;
        }
        return viewGroupD.getOverlay();
    }

    public void a1(int i, Rect rect) {
        int iH0 = this.L + ((int) (H0(getValues().get(i).floatValue()) * this.F0));
        int iY = y();
        int iMax = Math.max(this.E, this.F) / 2;
        int iMax2 = Math.max(this.M / 2, iMax);
        int iMax3 = Math.max(this.N / 2, iMax);
        RectF rectF = new RectF(iH0 - iMax2, iY - iMax3, iH0 + iMax2, iY + iMax3);
        if (y0()) {
            this.W0.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public final float[] b0(float f, float f2) {
        return y0() ? new float[]{f, f, f, f, f2, f2, f2, f2} : new float[]{f, f, f2, f2, f2, f2, f, f};
    }

    public final void b1() {
        if (this.X0.size() != this.w0.size()) {
            this.X0.clear();
            for (int i = 0; i < this.w0.size(); i++) {
                this.X0.add(D());
            }
        }
    }

    public final int c0() {
        return (int) (((this.v0 - this.u0) / this.z0) + 1.0f);
    }

    public final void c1(float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6;
        FocusRingDrawable focusRingDrawableD0 = d0();
        if (focusRingDrawableD0 != null) {
            float dimensionPixelOffset = getResources().getDimensionPixelOffset(zk3.E);
            float f7 = (this.M / 2.0f) + (dimensionPixelOffset * 2.0f);
            float f8 = (this.N / 2.0f) + dimensionPixelOffset;
            if (y0()) {
                f3 = f2 - f8;
                float f9 = f2 + f8;
                f4 = f - f7;
                f5 = f + f7;
                f6 = f9;
            } else {
                f3 = f - f7;
                f6 = f + f7;
                f4 = f2 - f8;
                f5 = f2 + f8;
            }
            focusRingDrawableD0.mutate();
            focusRingDrawableD0.x((int) f3, (int) f4, (int) f6, (int) f5);
        }
    }

    public final FocusRingDrawable d0() {
        return FocusRingDrawable.l(getBackground());
    }

    public final void d1() {
        RippleDrawable rippleDrawableX;
        float fH0 = (H0(((Float) this.w0.get(this.y0)).floatValue()) * this.F0) + this.L;
        int iY = y();
        if (!U0() && getMeasuredWidth() > 0 && (rippleDrawableX = X()) != null) {
            int i = this.O;
            float[] fArr = {fH0 - i, iY - i, i + fH0, i + iY};
            if (y0()) {
                this.W0.mapPoints(fArr);
            }
            rippleDrawableX.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        }
        c1(fH0, iY);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.m.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f.setColor(Z(this.N0));
        this.g.setColor(Z(this.M0));
        this.j.setColor(Z(this.L0));
        this.k.setColor(Z(this.K0));
        this.l.setColor(Z(this.L0));
        for (yp4 yp4Var : this.q) {
            if (yp4Var.isStateful()) {
                yp4Var.setState(getDrawableState());
            }
        }
        for (int i = 0; i < this.X0.size(); i++) {
            if (((l62) this.X0.get(i)).isStateful()) {
                ((l62) this.X0.get(i)).setState(getDrawableState());
            }
        }
        this.i.setColor(Z(this.J0));
        this.i.setAlpha(63);
    }

    public final int e0() {
        return (this.F0 / this.D) + 1;
    }

    public final void e1() {
        float f;
        boolean zY0 = y0();
        boolean zV0 = v0();
        float f2 = 0.5f;
        if (zY0 && zV0) {
            f = 0.5f;
            f2 = -0.2f;
        } else {
            f = 1.2f;
            if (zY0) {
                f2 = 1.2f;
                f = 0.5f;
            }
        }
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            ((yp4) it.next()).I0(f2, f);
        }
    }

    public final float f0() {
        double dW0 = W0(this.e1);
        if (v0() || y0()) {
            dW0 = 1.0d - dW0;
        }
        float f = this.v0;
        float f2 = this.u0;
        return (float) ((dW0 * ((double) (f - f2))) + ((double) f2));
    }

    public final void f1() {
        e1();
        int i = this.J;
        if (i == 0 || i == 1) {
            if (this.x0 == -1 || !isEnabled()) {
                S();
                return;
            } else {
                R(false);
                return;
            }
        }
        if (i == 2) {
            S();
            return;
        }
        if (i != 3) {
            qn.a("Unexpected labelBehavior: ", this.J);
        } else if (isEnabled() && w0()) {
            R(true);
        } else {
            S();
        }
    }

    public final boolean g0() {
        return this.P > 0;
    }

    public final void g1() {
        float fY = y();
        this.W0.reset();
        this.W0.setRotate(90.0f, fY, fY);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.m.x();
    }

    public int getActiveThumbIndex() {
        return this.x0;
    }

    public int getContinuousModeTickCount() {
        return this.A0;
    }

    public int getFocusedThumbIndex() {
        return this.y0;
    }

    public int getHaloRadius() {
        return this.O;
    }

    public ColorStateList getHaloTintList() {
        return this.J0;
    }

    public int getLabelBehavior() {
        return this.J;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.z0;
    }

    public float getThumbElevation() {
        return this.a1;
    }

    public int getThumbHeight() {
        return this.N;
    }

    public int getThumbRadius() {
        return this.M / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.c1;
    }

    public float getThumbStrokeWidth() {
        return this.b1;
    }

    public ColorStateList getThumbTintList() {
        return this.d1;
    }

    public int getThumbTrackGapSize() {
        return this.P;
    }

    public int getThumbWidth() {
        return this.M;
    }

    public int getTickActiveRadius() {
        return this.D0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.K0;
    }

    public int getTickInactiveRadius() {
        return this.E0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.L0;
    }

    public ColorStateList getTickTintList() {
        if (this.L0.equals(this.K0)) {
            return this.K0;
        }
        e04.a("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
        return null;
    }

    public int getTickVisibilityMode() {
        return this.C0;
    }

    public ColorStateList getTrackActiveTintList() {
        return this.M0;
    }

    public int getTrackCornerSize() {
        int i = this.U;
        return i == -1 ? this.K / 2 : i;
    }

    public int getTrackHeight() {
        return this.K;
    }

    public ColorStateList getTrackIconActiveColor() {
        return this.e0;
    }

    public Drawable getTrackIconActiveEnd() {
        return this.c0;
    }

    public Drawable getTrackIconActiveStart() {
        return this.a0;
    }

    public ColorStateList getTrackIconInactiveColor() {
        return this.j0;
    }

    public Drawable getTrackIconInactiveEnd() {
        return this.h0;
    }

    public Drawable getTrackIconInactiveStart() {
        return this.f0;
    }

    public int getTrackIconSize() {
        return this.k0;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.N0;
    }

    public int getTrackInsideCornerSize() {
        return this.V;
    }

    public int getTrackSidePadding() {
        return this.L;
    }

    public int getTrackStopIndicatorSize() {
        return this.T;
    }

    public ColorStateList getTrackTintList() {
        if (this.N0.equals(this.M0)) {
            return this.M0;
        }
        e04.a("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
        return null;
    }

    public int getTrackWidth() {
        return this.F0;
    }

    public float getValueFrom() {
        return this.u0;
    }

    public float getValueTo() {
        return this.v0;
    }

    public List<Float> getValues() {
        return new ArrayList(this.w0);
    }

    public boolean h0() {
        return false;
    }

    public final void h1() {
        if (g0() && this.Y0 == null && this.Z0.isEmpty()) {
            int i = this.M;
            this.Q = i;
            this.S = this.N;
            this.R = this.P;
            Q0(Math.round(i * 0.5f), m0() ? this.N - this.x : -1, Integer.valueOf(this.x0));
        }
    }

    public final boolean i0() {
        return (this.a0 == null && this.c0 == null && this.f0 == null && this.h0 == null) ? false : true;
    }

    public final void i1() {
        int iMin;
        r1();
        if (this.z0 <= 0.0f) {
            j1(this.A0);
            return;
        }
        int i = this.C0;
        if (i != 0) {
            iMin = 0;
            if (i == 1) {
                int iC0 = c0();
                if (iC0 <= e0()) {
                    iMin = iC0;
                }
            } else if (i != 2) {
                jr1.a("Unexpected tickVisibilityMode: ", this.C0);
                return;
            }
        } else {
            iMin = Math.min(c0(), e0());
        }
        j1(iMin);
    }

    public final Drawable j0(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        o(drawableNewDrawable);
        return drawableNewDrawable;
    }

    public final void j1(int i) {
        if (i == 0) {
            this.B0 = null;
            return;
        }
        float[] fArr = this.B0;
        if (fArr == null || fArr.length != i * 2) {
            this.B0 = new float[i * 2];
        }
        float f = this.F0 / (i - 1);
        float fY = y();
        for (int i2 = 0; i2 < i * 2; i2 += 2) {
            float[] fArr2 = this.B0;
            fArr2[i2] = this.L + ((i2 / 2.0f) * f);
            fArr2[i2 + 1] = fY;
        }
        if (y0()) {
            this.W0.mapPoints(this.B0);
        }
    }

    public final void k0() {
        this.f.setStrokeWidth(this.K);
        this.g.setStrokeWidth(this.K);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k1(android.graphics.Canvas r7, android.graphics.Paint r8, android.graphics.RectF r9, float r10, wi.d r11) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wi.k1(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, float, wi$d):void");
    }

    public boolean l0() {
        return this.W;
    }

    public final void l1() {
        Drawable drawable = this.c0;
        if (drawable != null) {
            if (!this.d0 && this.e0 != null) {
                this.c0 = tn0.r(drawable).mutate();
                this.d0 = true;
            }
            if (this.d0) {
                this.c0.setTintList(this.e0);
            }
        }
    }

    public void m(li liVar) {
        this.r.add(liVar);
    }

    public final boolean m0() {
        FocusRingDrawable focusRingDrawableD0 = d0();
        return focusRingDrawableD0 != null && focusRingDrawableD0.r();
    }

    public final void m1() {
        Drawable drawable = this.a0;
        if (drawable != null) {
            if (!this.b0 && this.e0 != null) {
                this.a0 = tn0.r(drawable).mutate();
                this.b0 = true;
            }
            if (this.b0) {
                this.a0.setTintList(this.e0);
            }
        }
    }

    public final void n(int i, Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i, this.N);
        } else {
            float fMax = Math.max(i, this.N) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final boolean n0() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final void n1() {
        Drawable drawable = this.h0;
        if (drawable != null) {
            if (!this.i0 && this.j0 != null) {
                this.h0 = tn0.r(drawable).mutate();
                this.i0 = true;
            }
            if (this.i0) {
                this.h0.setTintList(this.j0);
            }
        }
    }

    public final void o(Drawable drawable) {
        n(this.M, drawable);
    }

    public final boolean o0() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final void o1() {
        Drawable drawable = this.f0;
        if (drawable != null) {
            if (!this.g0 && this.j0 != null) {
                this.f0 = tn0.r(drawable).mutate();
                this.g0 = true;
            }
            if (this.g0) {
                this.f0.setTintList(this.j0);
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k1 = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.h1);
        getViewTreeObserver().addOnGlobalLayoutListener(this.i1);
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            p((yp4) it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        b bVar = this.o;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        this.t = false;
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            E((yp4) it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.h1);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.i1);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.I0) {
            r1();
            i1();
        }
        super.onDraw(canvas);
        int iY = y();
        K(canvas, this.F0, iY);
        I(canvas, this.F0, iY);
        if (v0() || y0()) {
            Q(canvas, this.P0, this.Q0);
        } else {
            Q(canvas, this.P0, this.R0);
        }
        C0(canvas);
        B0(canvas, iY);
        if ((this.t0 || isFocused()) && isEnabled()) {
            A0(canvas, this.F0, iY);
        }
        f1();
        N(canvas, this.F0, iY);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            N0();
            this.x0 = -1;
            this.m.o(this.y0);
        } else {
            if (this.x0 == -1) {
                T(i);
                this.x0 = this.y0;
            }
            N0();
            h1();
            this.m.V(this.y0);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.x0 = this.y0;
        this.H0 |= keyEvent.isLongPress();
        Float fS = s(i);
        if (fS != null) {
            if (V0(((Float) this.w0.get(this.x0)).floatValue() + fS.floatValue())) {
                d1();
                postInvalidate();
            }
            return true;
        }
        if (i != 61) {
            return super.onKeyDown(i, keyEvent);
        }
        N0();
        if (keyEvent.hasNoModifiers()) {
            return F0(1);
        }
        if (keyEvent.isShiftPressed()) {
            return F0(-1);
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.H0 = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Rect rect = this.q0;
        rect.left = 0;
        rect.top = 0;
        rect.right = i3 - i;
        rect.bottom = i4 - i2;
        if (!this.r0.contains(rect)) {
            this.r0.add(this.q0);
        }
        l35.u0(this, this.r0);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.I + ((this.J == 1 || T0()) ? ((yp4) this.q.get(0)).getIntrinsicHeight() : 0), com.hierynomus.protocol.commons.buffer.Buffer.MAX_SIZE);
        if (y0()) {
            super.onMeasure(iMakeMeasureSpec, i2);
        } else {
            super.onMeasure(i, iMakeMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.u0 = eVar.f;
        this.v0 = eVar.g;
        S0(eVar.h);
        this.z0 = eVar.i;
        if (eVar.j) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f = this.u0;
        eVar.g = this.v0;
        eVar.h = new ArrayList(this.w0);
        eVar.i = this.z0;
        eVar.j = hasFocus();
        return eVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (y0()) {
            i = i2;
        }
        p1(i);
        d1();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float y = y0() ? motionEvent.getY() : motionEvent.getX();
        float x = y0() ? motionEvent.getX() : motionEvent.getY();
        float f = (y - this.L) / this.F0;
        this.e1 = f;
        float fMax = Math.max(0.0f, f);
        this.e1 = fMax;
        this.e1 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.n0 = y;
            this.o0 = x;
            this.s0.clear();
            this.s0 = getValues();
            if ((y0() || !u0(motionEvent)) && (!y0() || !t0(motionEvent))) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (K0()) {
                    requestFocus();
                    this.t0 = true;
                    h1();
                    I0();
                    Z0();
                    d1();
                    invalidate();
                }
            }
        } else if (actionMasked == 1) {
            this.t0 = false;
            MotionEvent motionEvent2 = this.p0;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.p0.getX() - motionEvent.getX()) <= this.w && Math.abs(this.p0.getY() - motionEvent.getY()) <= this.w && K0()) {
                I0();
            }
            if (this.x0 != -1) {
                Z0();
                d1();
                N0();
                this.x0 = -1;
                J0();
            }
            invalidate();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                this.t0 = false;
                X0();
                d1();
                N0();
                this.x0 = -1;
                J0();
                invalidate();
            }
        } else if (this.t0) {
            Z0();
            d1();
            invalidate();
        } else {
            if (!y0() && u0(motionEvent) && Math.abs(y - this.n0) < this.w) {
                return false;
            }
            if (y0() && t0(motionEvent) && Math.abs(x - this.o0) < this.w * 0.8f) {
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            if (K0()) {
                this.t0 = true;
                h1();
                I0();
                Z0();
                d1();
                invalidate();
            }
        }
        setPressed(this.t0);
        this.p0 = MotionEvent.obtain(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.k1 = z;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        ViewOverlay viewOverlayA0;
        super.onVisibilityChanged(view, i);
        if (i == 0 || (viewOverlayA0 = a0()) == null) {
            return;
        }
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            viewOverlayA0.remove((yp4) it.next());
        }
    }

    public final void p(yp4 yp4Var) {
        yp4Var.J0(e55.d(this));
    }

    public final void p1(int i) {
        this.F0 = Math.max(i - (this.L * 2), 0);
        i1();
    }

    public final void q(Canvas canvas, RectF rectF, Drawable drawable, boolean z) {
        if (drawable != null) {
            z(rectF, this.U0, this.k0, this.l0, z);
            if (this.U0.isEmpty()) {
                return;
            }
            P(canvas, this.U0, drawable);
        }
    }

    public final boolean q0(double d2) {
        double dDoubleValue = new BigDecimal(Double.toString(d2)).divide(new BigDecimal(Float.toString(this.z0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final void q1(boolean z) {
        boolean zE0 = E0();
        boolean zD0 = D0();
        if (y0()) {
            g1();
        }
        if (zE0 || z) {
            requestLayout();
        } else if (zD0) {
            postInvalidate();
        }
    }

    public final float r(float f) {
        if (!this.w0.isEmpty() && g0()) {
            float fW1 = w1(((Float) this.w0.get((v0() || y0()) ? 0 : this.w0.size() - 1)).floatValue()) - this.L;
            int i = this.F0;
            if (fW1 > i - f) {
                return Math.max(i - fW1, this.V);
            }
        }
        return f;
    }

    public final boolean r0(float f) {
        float f2 = (this.F0 + (this.L * 2)) / 2.0f;
        int i = this.P;
        return f >= f2 - ((float) i) && f <= f2 + ((float) i);
    }

    public final void r1() {
        if (this.I0) {
            u1();
            t1();
            s1();
            x1();
            this.I0 = false;
        }
    }

    public final Float s(int i) {
        float fW = this.H0 ? w(20) : v();
        if (i == 21) {
            if (!v0()) {
                fW = -fW;
            }
            return Float.valueOf(fW);
        }
        if (i == 22) {
            if (v0()) {
                fW = -fW;
            }
            return Float.valueOf(fW);
        }
        if (i == 69) {
            return Float.valueOf(-fW);
        }
        if (i == 70 || i == 81) {
            return Float.valueOf(fW);
        }
        return null;
    }

    public final boolean s0(float f) {
        for (int i = 0; i < this.w0.size(); i++) {
            float fW1 = w1(((Float) this.w0.get(i)).floatValue());
            float fX = x(i) + (this.M / 2.0f);
            if (f >= fW1 - fX && f <= fW1 + fX) {
                return true;
            }
        }
        return false;
    }

    public final void s1() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            r14.a("minSeparation(%s) must be greater or equal to 0", new Object[]{Float.valueOf(minSeparation)});
            return;
        }
        float f = this.z0;
        if (f <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.f1 != 1) {
            r14.a("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.z0)});
        } else if (minSeparation < f || !q0(minSeparation)) {
            r14.a("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.z0), Float.valueOf(this.z0)});
        }
    }

    public void setActiveThumbIndex(int i) {
        this.x0 = i;
    }

    public void setCentered(boolean z) {
        if (this.W == z) {
            return;
        }
        this.W = z;
        float f = this.u0;
        if (z) {
            setValues(Float.valueOf((f + this.v0) / 2.0f));
        } else {
            setValues(Float.valueOf(f));
        }
        q1(true);
    }

    public void setContinuousModeTickCount(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("The continuousModeTickCount(%s) must be greater than or equal to 0", Integer.valueOf(i)));
        }
        if (this.A0 != i) {
            this.A0 = i;
            this.I0 = true;
            postInvalidate();
        }
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        this.Y0 = j0(drawable);
        this.Z0.clear();
        postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.Y0 = null;
        this.Z0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.Z0.add(j0(drawable));
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.w0.size()) {
            jl.a("index out of range");
            return;
        }
        this.y0 = i;
        this.m.V(i);
        postInvalidate();
    }

    public void setHaloRadius(int i) {
        if (i == this.O) {
            return;
        }
        this.O = i;
        RippleDrawable rippleDrawableX = X();
        if (U0() || rippleDrawableX == null) {
            postInvalidate();
        } else {
            go0.k(rippleDrawableX, this.O);
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.J0)) {
            return;
        }
        this.J0 = colorStateList;
        RippleDrawable rippleDrawableX = X();
        if (!U0() && rippleDrawableX != null) {
            rippleDrawableX.setColor(colorStateList);
            return;
        }
        this.i.setColor(Z(colorStateList));
        this.i.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.J != i) {
            this.J = i;
            q1(true);
        }
    }

    public void setLabelFormatter(sr1 sr1Var) {
    }

    public void setOrientation(int i) {
        if (this.G == i) {
            return;
        }
        this.G = i;
        q1(true);
    }

    public void setSeparationUnit(int i) {
        this.f1 = i;
        this.I0 = true;
        postInvalidate();
    }

    public void setStepSize(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f), Float.valueOf(this.u0), Float.valueOf(this.v0)));
        }
        if (this.z0 != f) {
            this.z0 = f;
            this.I0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f) {
        if (f == this.a1) {
            return;
        }
        this.a1 = f;
        for (int i = 0; i < this.X0.size(); i++) {
            ((l62) this.X0.get(i)).d0(this.a1);
        }
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbHeight(int i) {
        if (i == this.N) {
            return;
        }
        this.N = i;
        for (int i2 = 0; i2 < this.X0.size(); i2++) {
            ((l62) this.X0.get(i2)).setBounds(0, 0, this.M, this.N);
        }
        Drawable drawable = this.Y0;
        if (drawable != null) {
            o(drawable);
        }
        Iterator it = this.Z0.iterator();
        while (it.hasNext()) {
            o((Drawable) it.next());
        }
        q1(false);
    }

    public void setThumbHeightResource(int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(int i) {
        int i2 = i * 2;
        setThumbWidth(i2);
        setThumbHeight(i2);
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        if (colorStateList == this.c1) {
            return;
        }
        this.c1 = colorStateList;
        for (int i = 0; i < this.X0.size(); i++) {
            ((l62) this.X0.get(i)).o0(colorStateList);
        }
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(e9.a(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f) {
        if (f == this.b1) {
            return;
        }
        this.b1 = f;
        for (int i = 0; i < this.X0.size(); i++) {
            ((l62) this.X0.get(i)).q0(f);
        }
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.d1)) {
            return;
        }
        this.d1 = colorStateList;
        for (int i = 0; i < this.X0.size(); i++) {
            ((l62) this.X0.get(i)).e0(this.d1);
        }
        invalidate();
    }

    public void setThumbTrackGapSize(int i) {
        if (this.P == i) {
            return;
        }
        this.P = i;
        invalidate();
    }

    public void setThumbWidth(int i) {
        if (i == this.M) {
            return;
        }
        this.M = i;
        Drawable drawable = this.Y0;
        if (drawable != null) {
            n(i, drawable);
        }
        for (int i2 = 0; i2 < this.Z0.size(); i2++) {
            n(i, (Drawable) this.Z0.get(i2));
        }
        Q0(i, -1, null);
    }

    public void setThumbWidthResource(int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    public void setTickActiveRadius(int i) {
        if (this.D0 != i) {
            this.D0 = i;
            this.k.setStrokeWidth(i * 2);
            q1(false);
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.K0)) {
            return;
        }
        this.K0 = colorStateList;
        this.k.setColor(Z(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i) {
        if (this.E0 != i) {
            this.E0 = i;
            this.j.setStrokeWidth(i * 2);
            q1(false);
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.L0)) {
            return;
        }
        this.L0 = colorStateList;
        this.j.setColor(Z(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i) {
        if (this.C0 != i) {
            this.C0 = i;
            postInvalidate();
        }
    }

    public void setTickVisible(boolean z) {
        setTickVisibilityMode(A(z));
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.M0)) {
            return;
        }
        this.M0 = colorStateList;
        this.g.setColor(Z(colorStateList));
        invalidate();
    }

    public void setTrackCornerSize(int i) {
        if (this.U == i) {
            return;
        }
        this.U = i;
        invalidate();
    }

    public void setTrackHeight(int i) {
        if (this.K != i) {
            this.K = i;
            k0();
            q1(false);
        }
    }

    public void setTrackIconActiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.e0) {
            return;
        }
        this.e0 = colorStateList;
        m1();
        l1();
        invalidate();
    }

    public void setTrackIconActiveEnd(Drawable drawable) {
        if (drawable == this.c0) {
            return;
        }
        this.c0 = drawable;
        this.d0 = false;
        l1();
        invalidate();
    }

    public void setTrackIconActiveStart(Drawable drawable) {
        if (drawable == this.a0) {
            return;
        }
        this.a0 = drawable;
        this.b0 = false;
        m1();
        invalidate();
    }

    public void setTrackIconInactiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.j0) {
            return;
        }
        this.j0 = colorStateList;
        o1();
        n1();
        invalidate();
    }

    public void setTrackIconInactiveEnd(Drawable drawable) {
        if (drawable == this.h0) {
            return;
        }
        this.h0 = drawable;
        this.i0 = false;
        n1();
        invalidate();
    }

    public void setTrackIconInactiveStart(Drawable drawable) {
        if (drawable == this.f0) {
            return;
        }
        this.f0 = drawable;
        this.g0 = false;
        o1();
        invalidate();
    }

    public void setTrackIconSize(int i) {
        if (this.k0 == i) {
            return;
        }
        this.k0 = i;
        invalidate();
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.N0)) {
            return;
        }
        this.N0 = colorStateList;
        this.f.setColor(Z(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i) {
        if (this.V == i) {
            return;
        }
        this.V = i;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        if (this.T == i) {
            return;
        }
        this.T = i;
        this.l.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.u0 = f;
        this.I0 = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.v0 = f;
        this.I0 = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        S0(arrayList);
    }

    public final void t(yp4 yp4Var, float f) {
        int iH0;
        int intrinsicWidth;
        int iY;
        int intrinsicHeight;
        int i;
        boolean zY0 = y0();
        int i2 = this.L;
        if (zY0) {
            iH0 = (i2 + ((int) (H0(f) * this.F0))) - (yp4Var.getIntrinsicHeight() / 2);
            intrinsicWidth = yp4Var.getIntrinsicHeight() + iH0;
            if (!v0()) {
                int iY2 = y() + this.m0 + (this.N / 2);
                iY = yp4Var.getIntrinsicWidth() + iY2;
                i = iY2;
                this.T0.set(iH0, i, intrinsicWidth, iY);
            }
            iY = y() - (this.m0 + (this.N / 2));
            intrinsicHeight = yp4Var.getIntrinsicWidth();
        } else {
            iH0 = (i2 + ((int) (H0(f) * this.F0))) - (yp4Var.getIntrinsicWidth() / 2);
            intrinsicWidth = yp4Var.getIntrinsicWidth() + iH0;
            iY = y() - (this.m0 + (this.N / 2));
            intrinsicHeight = yp4Var.getIntrinsicHeight();
        }
        i = iY - intrinsicHeight;
        this.T0.set(iH0, i, intrinsicWidth, iY);
    }

    public final boolean t0(MotionEvent motionEvent) {
        return !p0(motionEvent) && n0();
    }

    public final void t1() {
        if (this.z0 <= 0.0f || v1(this.v0)) {
            return;
        }
        r14.a("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.valueOf(this.z0), Float.valueOf(this.u0), Float.valueOf(this.v0)});
    }

    public final float u(float f) {
        if (!this.w0.isEmpty() && g0()) {
            float fW1 = w1(((Float) this.w0.get((v0() || y0()) ? this.w0.size() - 1 : 0)).floatValue()) - this.L;
            if (fW1 < f) {
                return Math.max(fW1, this.V);
            }
        }
        return f;
    }

    public final boolean u0(MotionEvent motionEvent) {
        return !p0(motionEvent) && o0();
    }

    public final void u1() {
        float f = this.u0;
        if (f >= this.v0) {
            r14.a("valueFrom(%s) must be smaller than valueTo(%s)", new Object[]{Float.valueOf(f), Float.valueOf(this.v0)});
            return;
        }
        for (Float f2 : this.w0) {
            if (f2.floatValue() < this.u0 || f2.floatValue() > this.v0) {
                r14.a("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[]{f2, Float.valueOf(this.u0), Float.valueOf(this.v0)});
                return;
            } else if (this.z0 > 0.0f && !v1(f2.floatValue())) {
                r14.a("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{f2, Float.valueOf(this.u0), Float.valueOf(this.z0), Float.valueOf(this.z0)});
                return;
            }
        }
    }

    public final float v() {
        float f = this.z0;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    public final boolean v0() {
        return getLayoutDirection() == 1;
    }

    public final boolean v1(float f) {
        return q0(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.u0)), MathContext.DECIMAL64).doubleValue());
    }

    public final float w(int i) {
        float fV = v();
        return (this.v0 - this.u0) / fV <= i ? fV : Math.round(r1 / r2) * fV;
    }

    public final boolean w0() {
        Rect rect = new Rect();
        e55.d(this).getHitRect(rect);
        return getLocalVisibleRect(rect) && x0();
    }

    public final float w1(float f) {
        return (H0(f) * this.F0) + this.L;
    }

    public final int x(int i) {
        if (!this.t0 || i != this.x0 || this.Y0 != null || !this.Z0.isEmpty()) {
            return this.P;
        }
        return this.P - ((this.M - Math.round(this.M * 0.5f)) / 2);
    }

    public final boolean x0() {
        return this.k1;
    }

    public final void x1() {
        float f = this.z0;
        if (f == 0.0f) {
            return;
        }
        if (((int) f) != f) {
            Log.w(l1, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f)));
        }
        float f2 = this.u0;
        if (((int) f2) != f2) {
            Log.w(l1, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f2)));
        }
        float f3 = this.v0;
        if (((int) f3) != f3) {
            Log.w(l1, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f3)));
        }
    }

    public final int y() {
        int i = this.I / 2;
        int intrinsicHeight = 0;
        if ((this.J == 1 || T0()) && !this.q.isEmpty()) {
            intrinsicHeight = ((yp4) this.q.get(0)).getIntrinsicHeight();
        }
        return i + intrinsicHeight;
    }

    public boolean y0() {
        return this.G == 1;
    }

    public final void z(RectF rectF, RectF rectF2, int i, int i2, boolean z) {
        if (rectF.right - rectF.left < (i2 * 2) + i) {
            rectF2.setEmpty();
            return;
        }
        float f = z ^ (v0() || y0()) ? rectF.left + i2 : (rectF.right - i2) - i;
        float f2 = i;
        float fY = y() - (f2 / 2.0f);
        rectF2.set(f, fY, f + f2, f2 + fY);
    }

    public final void z0(Resources resources) {
        this.H = resources.getDimensionPixelSize(zk3.q0);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(zk3.p0);
        this.y = dimensionPixelOffset;
        this.L = dimensionPixelOffset;
        this.z = resources.getDimensionPixelSize(zk3.l0);
        this.A = resources.getDimensionPixelSize(zk3.o0);
        this.B = resources.getDimensionPixelSize(zk3.n0);
        this.C = resources.getDimensionPixelSize(zk3.n0);
        this.D = resources.getDimensionPixelSize(zk3.m0);
        this.m0 = resources.getDimensionPixelSize(zk3.k0);
        this.l0 = resources.getDimensionPixelOffset(zk3.G);
        this.F = resources.getDimensionPixelSize(zk3.d0);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        public int f;

        public b() {
            this.f = -1;
        }

        public void a(int i) {
            this.f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            wi.this.m.W(this.f, 4);
        }

        public /* synthetic */ b(wi wiVar, a aVar) {
            this();
        }
    }

    public void setValues(List<Float> list) {
        S0(new ArrayList(list));
    }

    public void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    public void setTrackIconActiveEnd(int i) {
        setTrackIconActiveEnd(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setTrackIconActiveStart(int i) {
        setTrackIconActiveStart(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setTrackIconInactiveEnd(int i) {
        setTrackIconInactiveEnd(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setTrackIconInactiveStart(int i) {
        setTrackIconInactiveStart(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public float f;
        public float g;
        public ArrayList h;
        public float i;
        public boolean j;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f = parcel.readFloat();
            this.g = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.h = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.i = parcel.readFloat();
            this.j = parcel.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f);
            parcel.writeFloat(this.g);
            parcel.writeList(this.h);
            parcel.writeFloat(this.i);
            parcel.writeBooleanArray(new boolean[]{this.j});
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public /* synthetic */ e(Parcel parcel, a aVar) {
            this(parcel);
        }
    }
}
