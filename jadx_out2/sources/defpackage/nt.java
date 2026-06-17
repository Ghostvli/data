package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.focus.FocusRingDrawable;
import defpackage.im4;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nt extends l62 implements Drawable.Callback, im4.b {
    public static final int[] Y0 = {R.attr.state_enabled};
    public static final ShapeDrawable Z0 = new ShapeDrawable(new OvalShape());
    public final PointF A0;
    public final Path B0;
    public final im4 C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public boolean J0;
    public int K0;
    public int L0;
    public ColorFilter M0;
    public PorterDuffColorFilter N0;
    public ColorStateList O;
    public ColorStateList O0;
    public ColorStateList P;
    public PorterDuff.Mode P0;
    public float Q;
    public int[] Q0;
    public float R;
    public boolean R0;
    public ColorStateList S;
    public ColorStateList S0;
    public float T;
    public WeakReference T0;
    public ColorStateList U;
    public TextUtils.TruncateAt U0;
    public CharSequence V;
    public boolean V0;
    public boolean W;
    public int W0;
    public Drawable X;
    public boolean X0;
    public ColorStateList Y;
    public float Z;
    public boolean a0;
    public boolean b0;
    public Drawable c0;
    public Drawable d0;
    public ColorStateList e0;
    public float f0;
    public CharSequence g0;
    public boolean h0;
    public boolean i0;
    public Drawable j0;
    public ColorStateList k0;
    public ju2 l0;
    public ju2 m0;
    public float n0;
    public float o0;
    public float p0;
    public float q0;
    public float r0;
    public float s0;
    public float t0;
    public float u0;
    public final Context v0;
    public final Paint w0;
    public final Paint x0;
    public final Paint.FontMetrics y0;
    public final RectF z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nt(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.R = -1.0f;
        this.w0 = new Paint(1);
        this.y0 = new Paint.FontMetrics();
        this.z0 = new RectF();
        this.A0 = new PointF();
        this.B0 = new Path();
        this.L0 = 255;
        this.P0 = PorterDuff.Mode.SRC_IN;
        this.T0 = new WeakReference(null);
        S(context);
        this.v0 = context;
        im4 im4Var = new im4(this);
        this.C0 = im4Var;
        this.V = "";
        im4Var.g().density = context.getResources().getDisplayMetrics().density;
        this.x0 = null;
        int[] iArr = Y0;
        setState(iArr);
        B2(iArr);
        this.V0 = true;
        Z0.setTint(-1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean C1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean G1(bm4 bm4Var) {
        return (bm4Var == null || bm4Var.k() == null || !bm4Var.k().isStateful()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean H1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean I1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static nt J0(Context context, AttributeSet attributeSet, int i, int i2) {
        nt ntVar = new nt(context, attributeSet, i, i2);
        ntVar.J1(attributeSet, i, i2);
        return ntVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float A0() {
        if (f3() || e3()) {
            return this.o0 + o1() + this.p0;
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ColorFilter A1() {
        ColorFilter colorFilter = this.M0;
        return colorFilter != null ? colorFilter : this.N0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A2(int i) {
        z2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (g3()) {
            float f = this.u0 + this.t0 + this.f0 + this.s0 + this.r0;
            if (tn0.f(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B1() {
        return this.R0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B2(int[] iArr) {
        if (Arrays.equals(this.Q0, iArr)) {
            return false;
        }
        this.Q0 = iArr;
        if (g3()) {
            return L1(getState(), iArr);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (g3()) {
            float f = this.u0 + this.t0;
            if (tn0.f(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.f0;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.f0;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.f0;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C2(ColorStateList colorStateList) {
        if (this.e0 != colorStateList) {
            this.e0 = colorStateList;
            if (g3()) {
                this.c0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (g3()) {
            float f = this.u0 + this.t0 + this.f0 + this.s0 + this.r0;
            if (tn0.f(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean D1() {
        return this.h0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D2(int i) {
        C2(e9.a(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float E0() {
        if (g3()) {
            return this.s0 + this.f0 + this.t0;
        }
        return 0.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean E1() {
        return I1(this.c0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E2(boolean z) {
        if (this.b0 != z) {
            boolean zG3 = g3();
            this.b0 = z;
            boolean zG32 = g3();
            if (zG3 != zG32) {
                Drawable drawable = this.c0;
                if (zG32) {
                    y0(drawable);
                } else {
                    h3(drawable);
                }
                invalidateSelf();
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.V != null) {
            float fA0 = this.n0 + A0() + this.q0;
            float fE0 = this.u0 + E0() + this.r0;
            if (tn0.f(this) == 0) {
                rectF.left = rect.left + fA0;
                rectF.right = rect.right - fE0;
            } else {
                rectF.left = rect.left + fE0;
                rectF.right = rect.right - fA0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean F1() {
        return this.b0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F2(a aVar) {
        this.T0 = new WeakReference(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float G0() {
        this.C0.g().getFontMetrics(this.y0);
        Paint.FontMetrics fontMetrics = this.y0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G2(TextUtils.TruncateAt truncateAt) {
        this.U0 = truncateAt;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Paint.Align H0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.V != null) {
            float fA0 = this.n0 + A0() + this.q0;
            if (tn0.f(this) == 0) {
                pointF.x = rect.left + fA0;
            } else {
                pointF.x = rect.right - fA0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - G0();
        }
        return align;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H2(String str) {
        bm4 bm4VarX1 = x1();
        if (bm4VarX1 == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        bm4VarX1.o(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I0() {
        return this.i0 && this.j0 != null && this.h0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I2(ju2 ju2Var) {
        this.m0 = ju2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J1(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayI = dn4.i(this.v0, attributeSet, cn3.O0, i, i2, new int[0]);
        this.X0 = typedArrayI.hasValue(cn3.B1);
        r2(k62.b(this.v0, typedArrayI, cn3.n1));
        V1(k62.b(this.v0, typedArrayI, cn3.a1));
        j2(typedArrayI.getDimension(cn3.i1, 0.0f));
        if (typedArrayI.hasValue(cn3.b1)) {
            X1(typedArrayI.getDimension(cn3.b1, 0.0f));
        }
        n2(k62.b(this.v0, typedArrayI, cn3.l1));
        p2(typedArrayI.getDimension(cn3.m1, 0.0f));
        P2(k62.b(this.v0, typedArrayI, cn3.A1));
        U2(typedArrayI.getText(cn3.T0));
        bm4 bm4VarH = k62.h(this.v0, typedArrayI, cn3.P0);
        bm4VarH.q(typedArrayI.getDimension(cn3.Q0, bm4VarH.l()));
        if (Build.VERSION.SDK_INT >= 26) {
            int iG = k62.g(typedArrayI, cn3.w1, cn3.V0);
            if (typedArrayI.hasValue(iG)) {
                bm4VarH.o(typedArrayI.getString(iG));
            }
        }
        V2(bm4VarH);
        int i3 = typedArrayI.getInt(cn3.R0, 0);
        if (i3 == 1) {
            G2(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            G2(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            G2(TextUtils.TruncateAt.END);
        }
        i2(typedArrayI.getBoolean(cn3.h1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            i2(typedArrayI.getBoolean(cn3.e1, false));
        }
        b2(k62.e(this.v0, typedArrayI, cn3.d1));
        if (typedArrayI.hasValue(cn3.g1)) {
            f2(k62.b(this.v0, typedArrayI, cn3.g1));
        }
        d2(typedArrayI.getDimension(cn3.f1, -1.0f));
        E2(typedArrayI.getBoolean(cn3.u1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            E2(typedArrayI.getBoolean(cn3.p1, false));
        }
        s2(k62.e(this.v0, typedArrayI, cn3.o1));
        C2(k62.b(this.v0, typedArrayI, cn3.t1));
        x2(typedArrayI.getDimension(cn3.r1, 0.0f));
        N1(typedArrayI.getBoolean(cn3.U0, false));
        U1(typedArrayI.getBoolean(cn3.Z0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            U1(typedArrayI.getBoolean(cn3.X0, false));
        }
        P1(k62.e(this.v0, typedArrayI, cn3.W0));
        if (typedArrayI.hasValue(cn3.Y0)) {
            R1(k62.b(this.v0, typedArrayI, cn3.Y0));
        }
        S2(ju2.b(this.v0, typedArrayI, cn3.C1));
        I2(ju2.b(this.v0, typedArrayI, cn3.x1));
        l2(typedArrayI.getDimension(cn3.k1, 0.0f));
        M2(typedArrayI.getDimension(cn3.z1, 0.0f));
        K2(typedArrayI.getDimension(cn3.y1, 0.0f));
        a3(typedArrayI.getDimension(cn3.E1, 0.0f));
        X2(typedArrayI.getDimension(cn3.D1, 0.0f));
        z2(typedArrayI.getDimension(cn3.s1, 0.0f));
        u2(typedArrayI.getDimension(cn3.q1, 0.0f));
        Z1(typedArrayI.getDimension(cn3.c1, 0.0f));
        O2(typedArrayI.getDimensionPixelSize(cn3.S0, Integer.MAX_VALUE));
        typedArrayI.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J2(int i) {
        I2(ju2.c(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K0(Canvas canvas, Rect rect) {
        if (e3()) {
            z0(rect, this.z0);
            RectF rectF = this.z0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.j0.setBounds(0, 0, (int) this.z0.width(), (int) this.z0.height());
            this.j0.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K1() {
        a aVar = (a) this.T0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K2(float f) {
        if (this.p0 != f) {
            float fA0 = A0();
            this.p0 = f;
            float fA02 = A0();
            invalidateSelf();
            if (fA0 != fA02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L0(Canvas canvas, Rect rect) {
        if (this.X0) {
            return;
        }
        this.w0.setColor(this.E0);
        this.w0.setStyle(Paint.Style.FILL);
        this.w0.setColorFilter(A1());
        this.z0.set(rect);
        canvas.drawRoundRect(this.z0, W0(), W0(), this.w0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean L1(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.O;
        int iR = r(colorStateList != null ? colorStateList.getColorForState(iArr, this.D0) : 0);
        boolean state = true;
        if (this.D0 != iR) {
            this.D0 = iR;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.P;
        int iR2 = r(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.E0) : 0);
        if (this.E0 != iR2) {
            this.E0 = iR2;
            zOnStateChange = true;
        }
        int i = h62.i(iR, iR2);
        if ((this.F0 != i) | (C() == null)) {
            this.F0 = i;
            e0(ColorStateList.valueOf(i));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.S;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.G0) : 0;
        if (this.G0 != colorForState) {
            this.G0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.S0 == null || !wt3.e(iArr)) ? 0 : this.S0.getColorForState(iArr, this.H0);
        if (this.H0 != colorForState2) {
            this.H0 = colorForState2;
            if (this.R0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.C0.e() == null || this.C0.e().k() == null) ? 0 : this.C0.e().k().getColorForState(iArr, this.I0);
        if (this.I0 != colorForState3) {
            this.I0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z2 = C1(getState(), R.attr.state_checked) && this.h0;
        if (this.J0 == z2 || this.j0 == null) {
            z = false;
        } else {
            float fA0 = A0();
            this.J0 = z2;
            if (fA0 != A0()) {
                zOnStateChange = true;
                z = true;
            } else {
                z = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.O0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.K0) : 0;
        if (this.K0 != colorForState4) {
            this.K0 = colorForState4;
            this.N0 = go0.m(this, this.O0, this.P0);
        } else {
            state = zOnStateChange;
        }
        if (I1(this.X)) {
            state |= this.X.setState(iArr);
        }
        if (I1(this.j0)) {
            state |= this.j0.setState(iArr);
        }
        if (I1(this.c0)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.c0.setState(iArr3);
        }
        if (I1(this.d0)) {
            state |= this.d0.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z) {
            K1();
        }
        return state;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L2(int i) {
        K2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M0(Canvas canvas, Rect rect) {
        if (f3()) {
            z0(rect, this.z0);
            RectF rectF = this.z0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.X.setBounds(0, 0, (int) this.z0.width(), (int) this.z0.height());
            this.X.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean M1(boolean z) {
        if (this.c0 != null) {
            return B2(z ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : Y0);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M2(float f) {
        if (this.o0 != f) {
            float fA0 = A0();
            this.o0 = f;
            float fA02 = A0();
            invalidateSelf();
            if (fA0 != fA02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N0(Canvas canvas, Rect rect) {
        if (this.T <= 0.0f || this.X0) {
            return;
        }
        this.w0.setColor(this.G0);
        this.w0.setStyle(Paint.Style.STROKE);
        if (!this.X0) {
            this.w0.setColorFilter(A1());
        }
        RectF rectF = this.z0;
        float f = rect.left;
        float f2 = this.T;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.R - (this.T / 2.0f);
        canvas.drawRoundRect(this.z0, f3, f3, this.w0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N1(boolean z) {
        if (this.h0 != z) {
            this.h0 = z;
            float fA0 = A0();
            if (!z && this.J0) {
                this.J0 = false;
            }
            float fA02 = A0();
            invalidateSelf();
            if (fA0 != fA02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N2(int i) {
        M2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O0(Canvas canvas, Rect rect) {
        if (this.X0) {
            return;
        }
        this.w0.setColor(this.D0);
        this.w0.setStyle(Paint.Style.FILL);
        this.z0.set(rect);
        canvas.drawRoundRect(this.z0, W0(), W0(), this.w0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O1(int i) {
        N1(this.v0.getResources().getBoolean(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O2(int i) {
        this.W0 = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P0(Canvas canvas, Rect rect) {
        if (g3()) {
            C0(rect, this.z0);
            RectF rectF = this.z0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.c0.setBounds(0, 0, (int) this.z0.width(), (int) this.z0.height());
            this.d0.setBounds(this.c0.getBounds());
            this.d0.jumpToCurrentState();
            this.d0.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P1(Drawable drawable) {
        if (this.j0 != drawable) {
            float fA0 = A0();
            this.j0 = drawable;
            float fA02 = A0();
            h3(this.j0);
            y0(this.j0);
            invalidateSelf();
            if (fA0 != fA02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P2(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            i3();
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q0(Canvas canvas, Rect rect) {
        this.w0.setColor(this.H0);
        this.w0.setStyle(Paint.Style.FILL);
        this.z0.set(rect);
        if (!this.X0) {
            canvas.drawRoundRect(this.z0, W0(), W0(), this.w0);
        } else {
            l(new RectF(rect), this.B0);
            super.w(canvas, this.w0, this.B0, y());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q1(int i) {
        P1(e9.b(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q2(int i) {
        P2(e9.a(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R0(Canvas canvas, Rect rect) {
        Canvas canvas2;
        Paint paint = this.x0;
        if (paint != null) {
            paint.setColor(gx.k(-16777216, 127));
            canvas.drawRect(rect, this.x0);
            if (f3() || e3()) {
                z0(rect, this.z0);
                canvas.drawRect(this.z0, this.x0);
            }
            if (this.V != null) {
                canvas2 = canvas;
                canvas2.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.x0);
            } else {
                canvas2 = canvas;
            }
            if (g3()) {
                C0(rect, this.z0);
                canvas2.drawRect(this.z0, this.x0);
            }
            this.x0.setColor(gx.k(-65536, 127));
            B0(rect, this.z0);
            canvas2.drawRect(this.z0, this.x0);
            this.x0.setColor(gx.k(-16711936, 127));
            D0(rect, this.z0);
            canvas2.drawRect(this.z0, this.x0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R1(ColorStateList colorStateList) {
        if (this.k0 != colorStateList) {
            this.k0 = colorStateList;
            if (I0()) {
                this.j0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R2(boolean z) {
        this.V0 = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S0(Canvas canvas, Rect rect) {
        if (this.V != null) {
            Paint.Align alignH0 = H0(rect, this.A0);
            F0(rect, this.z0);
            if (this.C0.e() != null) {
                this.C0.g().drawableState = getState();
                this.C0.n(this.v0);
            }
            this.C0.g().setTextAlign(alignH0);
            int iSave = 0;
            boolean z = Math.round(this.C0.h(w1().toString())) > Math.round(this.z0.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.z0);
            }
            CharSequence charSequenceEllipsize = this.V;
            if (z && this.U0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.C0.g(), this.z0.width(), this.U0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.A0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.C0.g());
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S1(int i) {
        R1(e9.a(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S2(ju2 ju2Var) {
        this.l0 = ju2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable T0() {
        return this.j0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T1(int i) {
        U1(this.v0.getResources().getBoolean(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T2(int i) {
        S2(ju2.c(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList U0() {
        return this.k0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U1(boolean z) {
        if (this.i0 != z) {
            boolean zE3 = e3();
            this.i0 = z;
            boolean zE32 = e3();
            if (zE3 != zE32) {
                Drawable drawable = this.j0;
                if (zE32) {
                    y0(drawable);
                } else {
                    h3(drawable);
                }
                invalidateSelf();
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.V, charSequence)) {
            return;
        }
        this.V = charSequence;
        this.C0.m(true);
        invalidateSelf();
        K1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList V0() {
        return this.P;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V1(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V2(bm4 bm4Var) {
        this.C0.k(bm4Var, this.v0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float W0() {
        return this.X0 ? L() : this.R;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W1(int i) {
        V1(e9.a(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W2(int i) {
        V2(new bm4(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float X0() {
        return this.u0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X1(float f) {
        if (this.R != f) {
            this.R = f;
            setShapeAppearanceModel(J().a(f));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X2(float f) {
        if (this.r0 != f) {
            this.r0 = f;
            invalidateSelf();
            K1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable Y0() {
        Drawable drawable = this.X;
        if (drawable != null) {
            return tn0.q(drawable);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y1(int i) {
        X1(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y2(int i) {
        X2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float Z0() {
        return this.Z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z1(float f) {
        if (this.u0 != f) {
            this.u0 = f;
            invalidateSelf();
            K1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z2(float f) {
        bm4 bm4VarX1 = x1();
        if (bm4VarX1 != null) {
            bm4VarX1.q(f);
            this.C0.g().setTextSize(f);
            a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // im4.b
    public void a() {
        K1();
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList a1() {
        return this.Y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a2(int i) {
        Z1(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a3(float f) {
        if (this.q0 != f) {
            this.q0 = f;
            invalidateSelf();
            K1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float b1() {
        return this.Q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b2(Drawable drawable) {
        Drawable drawableY0 = Y0();
        if (drawableY0 != drawable) {
            float fA0 = A0();
            this.X = drawable != null ? tn0.r(drawable).mutate() : null;
            float fA02 = A0();
            h3(drawableY0);
            if (f3()) {
                y0(this.X);
            }
            invalidateSelf();
            if (fA0 != fA02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b3(int i) {
        a3(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float c1() {
        return this.n0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c2(int i) {
        b2(e9.b(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c3(boolean z) {
        if (this.R0 != z) {
            this.R0 = z;
            i3();
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList d1() {
        return this.S;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d2(float f) {
        if (this.Z != f) {
            float fA0 = A0();
            this.Z = f;
            float fA02 = A0();
            invalidateSelf();
            if (fA0 != fA02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d3() {
        return this.V0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Canvas canvas2;
        int iA;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.L0;
        if (i < 255) {
            canvas2 = canvas;
            iA = aq.a(canvas2, bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iA = 0;
        }
        O0(canvas2, bounds);
        L0(canvas2, bounds);
        if (this.X0) {
            super.draw(canvas2);
        }
        N0(canvas2, bounds);
        Q0(canvas2, bounds);
        M0(canvas2, bounds);
        K0(canvas2, bounds);
        if (this.V0) {
            S0(canvas2, bounds);
        }
        P0(canvas2, bounds);
        R0(canvas2, bounds);
        if (this.L0 < 255) {
            canvas2.restoreToCount(iA);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float e1() {
        return this.T;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e2(int i) {
        d2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e3() {
        return this.i0 && this.j0 != null && this.J0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable f1() {
        Drawable drawable = this.c0;
        if (drawable != null) {
            return tn0.q(drawable);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f2(ColorStateList colorStateList) {
        this.a0 = true;
        if (this.Y != colorStateList) {
            this.Y = colorStateList;
            if (f3()) {
                this.X.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean f3() {
        return this.W && this.X != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence g1() {
        return this.g0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g2(int i) {
        f2(e9.a(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g3() {
        return this.b0 && this.c0 != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.L0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.M0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.Q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.n0 + A0() + this.q0 + this.C0.h(w1().toString()) + this.r0 + E0() + this.u0), this.W0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Outline outline2;
        if (this.X0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.R);
        } else {
            outline.setRoundRect(bounds, this.R);
            outline2 = outline;
        }
        outline2.setAlpha(getAlpha() / 255.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float h1() {
        return this.t0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h2(int i) {
        i2(this.v0.getResources().getBoolean(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h3(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float i1() {
        return this.f0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i2(boolean z) {
        if (this.W != z) {
            boolean zF3 = f3();
            this.W = z;
            boolean zF32 = f3();
            if (zF3 != zF32) {
                Drawable drawable = this.X;
                if (zF32) {
                    y0(drawable);
                } else {
                    h3(drawable);
                }
                invalidateSelf();
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i3() {
        this.S0 = this.R0 ? wt3.d(this.U) : null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (H1(this.O) || H1(this.P) || H1(this.S)) {
            return true;
        }
        return (this.R0 && H1(this.S0)) || G1(this.C0.e()) || I0() || I1(this.X) || I1(this.j0) || H1(this.O0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float j1() {
        return this.s0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j2(float f) {
        if (this.Q != f) {
            this.Q = f;
            invalidateSelf();
            K1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j3() {
        RippleDrawable rippleDrawable = new RippleDrawable(wt3.d(u1()), this.c0, Z0);
        FocusRingDrawable.s(this.v0, rippleDrawable);
        this.d0 = rippleDrawable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] k1() {
        return this.Q0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k2(int i) {
        j2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList l1() {
        return this.e0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l2(float f) {
        if (this.n0 != f) {
            this.n0 = f;
            invalidateSelf();
            K1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m1(RectF rectF) {
        D0(getBounds(), rectF);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m2(int i) {
        l2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float n1() {
        Drawable drawable = this.J0 ? this.j0 : this.X;
        float f = this.Z;
        if (f > 0.0f || drawable == null) {
            return f;
        }
        float fCeil = (float) Math.ceil(e55.b(this.v0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n2(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            if (this.X0) {
                o0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float o1() {
        Drawable drawable = this.J0 ? this.j0 : this.X;
        float f = this.Z;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o2(int i) {
        n2(e9.a(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (f3()) {
            zOnLayoutDirectionChanged |= tn0.m(this.X, i);
        }
        if (e3()) {
            zOnLayoutDirectionChanged |= tn0.m(this.j0, i);
        }
        if (g3()) {
            zOnLayoutDirectionChanged |= tn0.m(this.c0, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (f3()) {
            zOnLevelChange |= this.X.setLevel(i);
        }
        if (e3()) {
            zOnLevelChange |= this.j0.setLevel(i);
        }
        if (g3()) {
            zOnLevelChange |= this.c0.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.X0) {
            super.onStateChange(iArr);
        }
        return L1(iArr, k1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TextUtils.TruncateAt p1() {
        return this.U0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p2(float f) {
        if (this.T != f) {
            this.T = f;
            this.w0.setStrokeWidth(f);
            if (this.X0) {
                super.q0(f);
            }
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String q1() {
        bm4 bm4VarX1 = x1();
        if (bm4VarX1 == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        return bm4VarX1.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q2(int i) {
        p2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ju2 r1() {
        return this.m0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r2(ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float s1() {
        return this.p0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s2(Drawable drawable) {
        Drawable drawableF1 = f1();
        if (drawableF1 != drawable) {
            float fE0 = E0();
            this.c0 = drawable != null ? tn0.r(drawable).mutate() : null;
            j3();
            float fE02 = E0();
            h3(drawableF1);
            if (g3()) {
                y0(this.c0);
            }
            invalidateSelf();
            if (fE0 != fE02) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.L0 != i) {
            this.L0 = i;
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.M0 != colorFilter) {
            this.M0 = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.O0 != colorStateList) {
            this.O0 = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.P0 != mode) {
            this.P0 = mode;
            this.N0 = go0.m(this, this.O0, mode);
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (f3()) {
            visible |= this.X.setVisible(z, z2);
        }
        if (e3()) {
            visible |= this.j0.setVisible(z, z2);
        }
        if (g3()) {
            visible |= this.c0.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float t1() {
        return this.o0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t2(CharSequence charSequence) {
        if (this.g0 != charSequence) {
            this.g0 = pj.c().h(charSequence);
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList u1() {
        return this.U;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u2(float f) {
        if (this.t0 != f) {
            this.t0 = f;
            invalidateSelf();
            if (g3()) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ju2 v1() {
        return this.l0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v2(int i) {
        u2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence w1() {
        return this.V;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w2(int i) {
        s2(e9.b(this.v0, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bm4 x1() {
        return this.C0.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x2(float f) {
        if (this.f0 != f) {
            this.f0 = f;
            invalidateSelf();
            if (g3()) {
                K1();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        tn0.m(drawable, tn0.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.c0) {
            drawable.setTintList(this.e0);
            if (drawable.isStateful()) {
                drawable.setState(k1());
                return;
            }
            return;
        }
        Drawable drawable2 = this.X;
        if (drawable == drawable2 && this.a0) {
            drawable2.setTintList(this.Y);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float y1() {
        return this.r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y2(int i) {
        x2(this.v0.getResources().getDimension(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (f3() || e3()) {
            float f = this.n0 + this.o0;
            float fO1 = o1();
            if (tn0.f(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + fO1;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - fO1;
            }
            float fN1 = n1();
            float fExactCenterY = rect.exactCenterY() - (fN1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fN1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float z1() {
        return this.q0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z2(float f) {
        if (this.s0 != f) {
            this.s0 = f;
            invalidateSelf();
            if (g3()) {
                K1();
            }
        }
    }
}
