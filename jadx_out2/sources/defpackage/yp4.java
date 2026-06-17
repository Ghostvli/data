package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import defpackage.im4;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yp4 extends l62 implements im4.b {
    public static final int g0 = ym3.G;
    public static final int h0 = mk3.f0;
    public CharSequence O;
    public final Context P;
    public final Paint.FontMetrics Q;
    public final im4 R;
    public final View.OnLayoutChangeListener S;
    public final Rect T;
    public int U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public int Z;
    public int a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnLayoutChangeListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            yp4.this.N0(view);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yp4(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Q = new Paint.FontMetrics();
        im4 im4Var = new im4(this);
        this.R = im4Var;
        this.S = new a();
        this.T = new Rect();
        this.b0 = 1.0f;
        this.c0 = 1.0f;
        this.d0 = 0.5f;
        this.e0 = 0.5f;
        this.f0 = 1.0f;
        this.P = context;
        im4Var.g().density = context.getResources().getDisplayMetrics().density;
        im4Var.g().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private float A0() {
        this.R.g().getFontMetrics(this.Q);
        Paint.FontMetrics fontMetrics = this.Q;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yp4 C0(Context context, AttributeSet attributeSet, int i, int i2) {
        yp4 yp4Var = new yp4(context, attributeSet, i, i2);
        yp4Var.H0(attributeSet, i, i2);
        return yp4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void H0(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayI = dn4.i(this.P, attributeSet, cn3.x8, i, i2, new int[0]);
        this.Z = this.P.getResources().getDimensionPixelSize(zk3.v0);
        boolean z = typedArrayI.getBoolean(cn3.G8, true);
        this.Y = z;
        if (z) {
            setShapeAppearanceModel(J().C().r(D0()).m());
        } else {
            this.Z = 0;
        }
        L0(typedArrayI.getText(cn3.E8));
        bm4 bm4VarH = k62.h(this.P, typedArrayI, cn3.y8);
        if (bm4VarH != null && typedArrayI.hasValue(cn3.z8)) {
            bm4VarH.p(k62.b(this.P, typedArrayI, cn3.z8));
        }
        M0(bm4VarH);
        e0(ColorStateList.valueOf(typedArrayI.getColor(cn3.F8, h62.i(gx.k(h62.c(this.P, R.attr.colorBackground, yp4.class.getCanonicalName()), 229), gx.k(h62.c(this.P, mk3.i, yp4.class.getCanonicalName()), Token.SETPROP_OP)))));
        o0(ColorStateList.valueOf(h62.c(this.P, mk3.l, yp4.class.getCanonicalName())));
        this.U = typedArrayI.getDimensionPixelSize(cn3.A8, 0);
        this.V = typedArrayI.getDimensionPixelSize(cn3.C8, 0);
        this.W = typedArrayI.getDimensionPixelSize(cn3.D8, 0);
        this.X = typedArrayI.getDimensionPixelSize(cn3.B8, 0);
        typedArrayI.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float B0(Rect rect) {
        return rect.centerY() - A0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qq0 D0() {
        float f = -z0();
        float fWidth = (float) ((((double) getBounds().width()) - (((double) this.Z) * Math.sqrt(2.0d))) / 2.0d);
        return new b53(new d52(this.Z), Math.min(Math.max(f, -fWidth), fWidth));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E0(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.S);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F0(Canvas canvas) {
        if (this.O == null) {
            return;
        }
        int iB0 = (int) B0(getBounds());
        if (this.R.e() != null) {
            this.R.g().drawableState = getState();
            this.R.n(this.P);
            this.R.g().setAlpha((int) (this.f0 * 255.0f));
        }
        CharSequence charSequence = this.O;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iB0, this.R.g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float G0() {
        CharSequence charSequence = this.O;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.R.h(charSequence.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I0(float f, float f2) {
        this.d0 = f;
        this.e0 = f2;
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J0(View view) {
        if (view == null) {
            return;
        }
        N0(view);
        view.addOnLayoutChangeListener(this.S);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K0(float f) {
        this.b0 = f;
        this.c0 = f;
        this.f0 = k7.b(0.0f, 1.0f, 0.19f, 1.0f, f);
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L0(CharSequence charSequence) {
        if (TextUtils.equals(this.O, charSequence)) {
            return;
        }
        this.O = charSequence;
        this.R.m(true);
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M0(bm4 bm4Var) {
        this.R.k(bm4Var, this.P);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.a0 = iArr[0];
        view.getWindowVisibleDisplayFrame(this.T);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // im4.b
    public void a() {
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float fZ0 = z0();
        float f = (float) (-((((double) this.Z) * Math.sqrt(2.0d)) - ((double) this.Z)));
        canvas.scale(this.b0, this.c0, getBounds().left + (getBounds().width() * this.d0), getBounds().top + (getBounds().height() * this.e0));
        canvas.translate(fZ0, f);
        super.draw(canvas);
        F0(canvas);
        canvas.restore();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.R.g().getTextSize(), this.W);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.U * 2) + G0(), this.V);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.Y) {
            setShapeAppearanceModel(J().C().r(D0()).m());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float z0() {
        int i;
        int i2 = ((this.T.right - getBounds().right) - this.a0) - this.X;
        Rect rect = this.T;
        if (i2 < 0) {
            i = ((rect.right - getBounds().right) - this.a0) - this.X;
        } else {
            if (((rect.left - getBounds().left) - this.a0) + this.X <= 0) {
                return 0.0f;
            }
            i = ((this.T.left - getBounds().left) - this.a0) + this.X;
        }
        return i;
    }
}
