package defpackage;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import defpackage.op;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mv {
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public Typeface D;
    public op E;
    public op F;
    public CharSequence H;
    public CharSequence I;
    public boolean J;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int R;
    public int[] S;
    public boolean T;
    public final TextPaint U;
    public final TextPaint V;
    public TimeInterpolator W;
    public TimeInterpolator X;
    public float Y;
    public float Z;
    public final View a;
    public float a0;
    public float b;
    public ColorStateList b0;
    public boolean c;
    public float c0;
    public float d;
    public float d0;
    public float e;
    public float e0;
    public int f;
    public ColorStateList f0;
    public final Rect g;
    public float g0;
    public final Rect h;
    public float h0;
    public Rect i;
    public float i0;
    public final RectF j;
    public StaticLayout j0;
    public float k0;
    public float l0;
    public float m0;
    public CharSequence n0;
    public ColorStateList o;
    public ColorStateList p;
    public int q;
    public float r;
    public float s;
    public float t;
    public me4 t0;
    public float u;
    public float v;
    public float w;
    public boolean w0;
    public Typeface x;
    public Typeface y;
    public Typeface z;
    public int k = 16;
    public int l = 16;
    public float m = 15.0f;
    public float n = 15.0f;
    public TextUtils.TruncateAt G = TextUtils.TruncateAt.END;
    public boolean K = true;
    public int o0 = 1;
    public int p0 = 1;
    public float q0 = 0.0f;
    public float r0 = 1.0f;
    public int s0 = le4.o;
    public int u0 = -1;
    public int v0 = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements op.a {
        public a() {
        }

        @Override // op.a
        public void a(Typeface typeface) {
            mv.this.Y(typeface);
        }
    }

    public mv(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(Token.DEFAULT);
        this.U = textPaint;
        this.V = new TextPaint(textPaint);
        this.h = new Rect();
        this.g = new Rect();
        this.j = new RectF();
        this.e = e();
        L(view.getContext().getResources().getConfiguration());
    }

    public static boolean G(float f, float f2) {
        return Math.abs(f - f2) < 1.0E-5f;
    }

    public static float K(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return k7.a(f, f2, f3);
    }

    public static boolean P(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), Math.round((Color.red(i) * f2) + (Color.red(i2) * f)), Math.round((Color.green(i) * f2) + (Color.green(i2) * f)), Math.round((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    public float A() {
        E(this.V);
        return -this.V.ascent();
    }

    public float B() {
        return this.b;
    }

    public final Layout.Alignment C() {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.k, this.J ? 1 : 0) & 7;
        if (absoluteGravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        boolean z = this.J;
        return absoluteGravity != 5 ? z ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : z ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    public final void D(TextPaint textPaint) {
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.x);
        textPaint.setLetterSpacing(this.g0);
    }

    public final void E(TextPaint textPaint) {
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.A);
        textPaint.setLetterSpacing(this.h0);
    }

    public final void F(float f) {
        boolean z = this.c;
        RectF rectF = this.j;
        if (z) {
            rectF.set(f < this.e ? this.g : this.h);
            return;
        }
        rectF.left = K(this.g.left, this.h.left, f, this.W);
        this.j.top = K(this.r, this.s, f, this.W);
        this.j.right = K(this.g.right, this.h.right, f, this.W);
        this.j.bottom = K(this.g.bottom, this.h.bottom, f, this.W);
    }

    public final boolean H() {
        return this.a.getLayoutDirection() == 1;
    }

    public final boolean I() {
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.o;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public final boolean J(CharSequence charSequence, boolean z) {
        return (z ? gm4.d : gm4.c).isRtl(charSequence, 0, charSequence.length());
    }

    public void L(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.z;
            if (typeface != null) {
                this.y = mv4.b(configuration, typeface);
            }
            Typeface typeface2 = this.C;
            if (typeface2 != null) {
                this.B = mv4.b(configuration, typeface2);
            }
            Typeface typeface3 = this.y;
            if (typeface3 == null) {
                typeface3 = this.z;
            }
            this.x = typeface3;
            Typeface typeface4 = this.B;
            if (typeface4 == null) {
                typeface4 = this.C;
            }
            this.A = typeface4;
            O(true);
        }
    }

    public final float M(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void N() {
        O(false);
    }

    public void O(boolean z) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z) {
            return;
        }
        b(z);
        c();
    }

    public void Q(ColorStateList colorStateList) {
        if (this.p == colorStateList && this.o == colorStateList) {
            return;
        }
        this.p = colorStateList;
        this.o = colorStateList;
        N();
    }

    public void R(int i, int i2, int i3, int i4) {
        if (P(this.h, i, i2, i3, i4)) {
            return;
        }
        this.h.set(i, i2, i3, i4);
        this.T = true;
    }

    public void S(Rect rect) {
        R(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void T(int i) {
        if (i != this.p0) {
            this.p0 = i;
            N();
        }
    }

    public void U(int i) {
        bm4 bm4Var = new bm4(this.a.getContext(), i);
        if (bm4Var.k() != null) {
            this.p = bm4Var.k();
        }
        if (bm4Var.l() != 0.0f) {
            this.n = bm4Var.l();
        }
        ColorStateList colorStateList = bm4Var.c;
        if (colorStateList != null) {
            this.b0 = colorStateList;
        }
        this.Z = bm4Var.i;
        this.a0 = bm4Var.j;
        this.Y = bm4Var.k;
        this.g0 = bm4Var.m;
        op opVar = this.F;
        if (opVar != null) {
            opVar.c();
        }
        this.F = new op(new a(), bm4Var.e());
        bm4Var.g(this.a.getContext(), this.F);
        N();
    }

    public final void V(float f) {
        this.l0 = f;
        this.a.postInvalidateOnAnimation();
    }

    public void W(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            N();
        }
    }

    public void X(int i) {
        if (this.l != i) {
            this.l = i;
            N();
        }
    }

    public void Y(Typeface typeface) {
        if (Z(typeface)) {
            N();
        }
    }

    public final boolean Z(Typeface typeface) {
        op opVar = this.F;
        if (opVar != null) {
            opVar.c();
        }
        if (this.z == typeface) {
            return false;
        }
        this.z = typeface;
        Typeface typefaceB = mv4.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.y = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.z;
        }
        this.x = typefaceB;
        return true;
    }

    public void a0(int i, int i2, int i3, int i4) {
        b0(i, i2, i3, i4, true);
    }

    public final void b(boolean z) {
        float fM;
        i(1.0f, z);
        if (this.I != null && this.j0 != null) {
            boolean zR0 = r0();
            CharSequence charSequenceEllipsize = this.I;
            if (zR0) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.U, this.j0.getWidth(), this.G);
            }
            this.n0 = charSequenceEllipsize;
        }
        CharSequence charSequence = this.n0;
        if (charSequence != null) {
            this.k0 = M(this.U, charSequence);
        } else {
            this.k0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.l, this.J ? 1 : 0);
        Rect rect = this.i;
        if (rect == null) {
            rect = this.h;
        }
        int i = absoluteGravity & Token.ASSIGN_MOD;
        if (i == 48) {
            this.s = rect.top;
        } else if (i != 80) {
            this.s = rect.centerY() - ((this.U.descent() - this.U.ascent()) / 2.0f);
        } else {
            this.s = rect.bottom + this.U.ascent();
        }
        int i2 = absoluteGravity & 8388615;
        if (i2 == 1) {
            this.u = rect.centerX() - (this.k0 / 2.0f);
        } else if (i2 != 5) {
            this.u = rect.left;
        } else {
            this.u = rect.right - this.k0;
        }
        if (this.k0 <= this.h.width()) {
            float f = this.u;
            float fMax = f + Math.max(0.0f, this.h.left - f);
            this.u = fMax;
            this.u = fMax + Math.min(0.0f, this.h.right - (this.k0 + fMax));
        }
        if (m() <= this.h.height()) {
            float f2 = this.s;
            float fMax2 = f2 + Math.max(0.0f, this.h.top - f2);
            this.s = fMax2;
            this.s = fMax2 + Math.min(0.0f, this.h.bottom - (q() + fMax2));
        }
        i(0.0f, z);
        float height = this.j0 != null ? r11.getHeight() : 0.0f;
        StaticLayout staticLayout = this.j0;
        if (staticLayout == null || this.o0 <= 1) {
            CharSequence charSequence2 = this.I;
            fM = charSequence2 != null ? M(this.U, charSequence2) : 0.0f;
        } else {
            fM = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.j0;
        this.q = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.k, this.J ? 1 : 0);
        int i3 = absoluteGravity2 & Token.ASSIGN_MOD;
        if (i3 != 48) {
            Rect rect2 = this.g;
            if (i3 != 80) {
                this.r = rect2.centerY() - (height / 2.0f);
            } else {
                this.r = (rect2.bottom - height) + (this.w0 ? this.U.descent() : 0.0f);
            }
        } else {
            this.r = this.g.top;
        }
        int i4 = absoluteGravity2 & 8388615;
        if (i4 != 1) {
            Rect rect3 = this.g;
            if (i4 != 5) {
                this.t = rect3.left;
            } else {
                this.t = rect3.right - fM;
            }
        } else {
            this.t = this.g.centerX() - (fM / 2.0f);
        }
        k0(this.b);
    }

    public void b0(int i, int i2, int i3, int i4, boolean z) {
        if (P(this.g, i, i2, i3, i4) && z == this.w0) {
            return;
        }
        this.g.set(i, i2, i3, i4);
        this.T = true;
        this.w0 = z;
    }

    public final void c() {
        g(this.b);
    }

    public void c0(Rect rect) {
        a0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final float d(float f) {
        float f2 = this.e;
        return f <= f2 ? k7.b(1.0f, 0.0f, this.d, f2, f) : k7.b(0.0f, 1.0f, f2, 1.0f, f);
    }

    public void d0(float f) {
        if (this.h0 != f) {
            this.h0 = f;
            N();
        }
    }

    public final float e() {
        float f = this.d;
        return f + ((1.0f - f) * 0.5f);
    }

    public void e0(int i) {
        if (i != this.o0) {
            this.o0 = i;
            N();
        }
    }

    public final boolean f(CharSequence charSequence) {
        boolean zH = H();
        return this.K ? J(charSequence, zH) : zH;
    }

    public final void f0(float f) {
        this.m0 = f;
        this.a.postInvalidateOnAnimation();
    }

    public final void g(float f) {
        float f2;
        F(f);
        if (!this.c) {
            this.v = K(this.t, this.u, f, this.W);
            this.w = K(this.r, this.s, f, this.W);
            k0(f);
            float f3 = this.g0;
            float f4 = this.h0;
            TextPaint textPaint = this.U;
            if (f3 != f4) {
                textPaint.setLetterSpacing(K(f4, f3, f, k7.b));
            } else {
                textPaint.setLetterSpacing(f3);
            }
            f2 = f;
        } else if (f < this.e) {
            this.v = this.t;
            this.w = this.r;
            k0(0.0f);
            f2 = 0.0f;
        } else {
            this.v = this.u;
            this.w = this.s - Math.max(0, this.f);
            k0(1.0f);
            f2 = 1.0f;
        }
        TimeInterpolator timeInterpolator = k7.b;
        V(1.0f - K(0.0f, 1.0f, 1.0f - f, timeInterpolator));
        f0(K(1.0f, 0.0f, f, timeInterpolator));
        ColorStateList colorStateList = this.p;
        ColorStateList colorStateList2 = this.o;
        TextPaint textPaint2 = this.U;
        if (colorStateList != colorStateList2) {
            textPaint2.setColor(a(v(), t(), f2));
        } else {
            textPaint2.setColor(t());
        }
        this.N = K(this.c0, this.Y, f, null);
        this.O = K(this.d0, this.Z, f, null);
        this.P = K(this.e0, this.a0, f, null);
        int iA = a(u(this.f0), u(this.b0), f);
        this.Q = iA;
        this.U.setShadowLayer(this.N, this.O, this.P, iA);
        if (this.c) {
            this.U.setAlpha((int) (d(f) * this.U.getAlpha()));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint3 = this.U;
                textPaint3.setShadowLayer(this.N, this.O, this.P, h62.a(this.Q, textPaint3.getAlpha()));
            }
        }
        this.a.postInvalidateOnAnimation();
    }

    public void g0(int i) {
        if (this.k != i) {
            this.k = i;
            N();
        }
    }

    public final void h(float f) {
        i(f, false);
    }

    public void h0(float f) {
        if (this.m != f) {
            this.m = f;
            N();
        }
    }

    public final void i(float f, boolean z) {
        Typeface typeface;
        float f2;
        float f3;
        if (this.H == null) {
            return;
        }
        float fWidth = this.h.width();
        float fWidth2 = this.g.width();
        if (G(f, 1.0f)) {
            f2 = r0() ? this.n : this.m;
            f3 = r0() ? this.g0 : this.h0;
            this.L = r0() ? 1.0f : K(this.m, this.n, f, this.X) / this.m;
            if (!r0()) {
                fWidth = fWidth2;
            }
            typeface = this.x;
            fWidth2 = fWidth;
        } else {
            float f4 = this.m;
            float f5 = this.h0;
            typeface = this.A;
            if (G(f, 0.0f)) {
                this.L = 1.0f;
            } else {
                this.L = K(this.m, this.n, f, this.X) / this.m;
            }
            float f6 = this.n / this.m;
            float f7 = fWidth2 * f6;
            if (!z && !this.c && f7 > fWidth && r0()) {
                fWidth2 = Math.min(fWidth / f6, fWidth2);
            }
            f2 = f4;
            f3 = f5;
        }
        int i = f < 0.5f ? this.o0 : this.p0;
        if (fWidth2 > 0.0f) {
            boolean z2 = this.M != f2;
            boolean z3 = this.i0 != f3;
            boolean z4 = this.D != typeface;
            StaticLayout staticLayout = this.j0;
            boolean z5 = z2 || z3 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z4 || (this.R != i) || this.T;
            this.M = f2;
            this.i0 = f3;
            this.D = typeface;
            this.T = false;
            this.R = i;
            this.U.setLinearText(this.L != 1.0f);
            z = z5;
        }
        if (this.I == null || z) {
            this.U.setTextSize(this.M);
            this.U.setTypeface(this.D);
            this.U.setLetterSpacing(this.i0);
            this.J = f(this.H);
            StaticLayout staticLayoutJ = j(q0() ? i : 1, this.U, this.H, fWidth2 * (r0() ? 1.0f : this.L), this.J);
            this.j0 = staticLayoutJ;
            this.I = staticLayoutJ.getText();
        }
    }

    public final boolean i0(Typeface typeface) {
        op opVar = this.E;
        if (opVar != null) {
            opVar.c();
        }
        if (this.C == typeface) {
            return false;
        }
        this.C = typeface;
        Typeface typefaceB = mv4.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.B = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.C;
        }
        this.A = typefaceB;
        return true;
    }

    public final StaticLayout j(int i, TextPaint textPaint, CharSequence charSequence, float f, boolean z) {
        return (StaticLayout) hg3.g(le4.b(charSequence, textPaint, (int) f).d(this.G).g(z).c(i == 1 ? Layout.Alignment.ALIGN_NORMAL : C()).f(false).i(i).h(this.q0, this.r0).e(this.s0).j(this.t0).a());
    }

    public void j0(float f) {
        float fA = r62.a(f, 0.0f, 1.0f);
        if (fA != this.b) {
            this.b = fA;
            c();
        }
    }

    public void k(Canvas canvas) {
        int iSave = canvas.save();
        if (this.I == null || this.j.width() <= 0.0f || this.j.height() <= 0.0f) {
            return;
        }
        this.U.setTextSize(this.M);
        float f = this.v;
        float f2 = this.w;
        float f3 = this.L;
        if (f3 != 1.0f && !this.c) {
            canvas.scale(f3, f3, f, f2);
        }
        if (q0() && r0() && (!this.c || this.b > this.e)) {
            l(canvas, this.v - this.j0.getLineStart(0), f2);
        } else {
            canvas.translate(f, f2);
            this.j0.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public final void k0(float f) {
        h(f);
        this.a.postInvalidateOnAnimation();
    }

    public final void l(Canvas canvas, float f, float f2) {
        int alpha = this.U.getAlpha();
        canvas.translate(f, f2);
        if (!this.c) {
            this.U.setAlpha((int) (this.m0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.U;
                textPaint.setShadowLayer(this.N, this.O, this.P, h62.a(this.Q, textPaint.getAlpha()));
            }
            this.j0.draw(canvas);
        }
        if (!this.c) {
            this.U.setAlpha((int) (this.l0 * alpha));
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            TextPaint textPaint2 = this.U;
            textPaint2.setShadowLayer(this.N, this.O, this.P, h62.a(this.Q, textPaint2.getAlpha()));
        }
        int lineBaseline = this.j0.getLineBaseline(0);
        CharSequence charSequence = this.n0;
        float f3 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f3, this.U);
        if (i >= 31) {
            this.U.setShadowLayer(this.N, this.O, this.P, this.Q);
        }
        if (this.c) {
            return;
        }
        String strTrim = this.n0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.U.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.j0.getLineEnd(0), str.length()), 0.0f, f3, (Paint) this.U);
    }

    public void l0(TimeInterpolator timeInterpolator) {
        this.W = timeInterpolator;
        N();
    }

    public float m() {
        D(this.V);
        return (-this.V.ascent()) + this.V.descent();
    }

    public final boolean m0(int[] iArr) {
        this.S = iArr;
        if (!I()) {
            return false;
        }
        N();
        return true;
    }

    public float n() {
        D(this.V);
        return -this.V.ascent();
    }

    public void n0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.H, charSequence)) {
            this.H = charSequence;
            this.I = null;
            N();
        }
    }

    public void o(RectF rectF, int i, int i2) {
        this.J = f(this.H);
        rectF.left = Math.max(r(i, i2), this.h.left);
        rectF.top = this.h.top;
        rectF.right = Math.min(s(rectF, i, i2), this.h.right);
        rectF.bottom = this.h.top + q();
        if (this.j0 == null || r0()) {
            return;
        }
        float lineWidth = this.j0.getLineWidth(r4.getLineCount() - 1) * (this.n / this.m);
        if (this.J) {
            rectF.left = rectF.right - lineWidth;
        } else {
            rectF.right = rectF.left + lineWidth;
        }
    }

    public void o0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        N();
    }

    public ColorStateList p() {
        return this.p;
    }

    public void p0(Typeface typeface) {
        boolean Z = Z(typeface);
        boolean zI0 = i0(typeface);
        if (Z || zI0) {
            N();
        }
    }

    public float q() {
        int i = this.u0;
        return i != -1 ? i : n();
    }

    public final boolean q0() {
        if (this.o0 > 1 || this.p0 > 1) {
            return !this.J || this.c;
        }
        return false;
    }

    public final float r(int i, int i2) {
        float f;
        float f2;
        int i3;
        if (i2 == 17 || (i2 & 7) == 1) {
            f = i / 2.0f;
            f2 = this.k0 / 2.0f;
        } else if ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) {
            boolean z = this.J;
            Rect rect = this.h;
            if (z) {
                i3 = rect.left;
                return i3;
            }
            f = rect.right;
            f2 = this.k0;
        } else {
            boolean z2 = this.J;
            Rect rect2 = this.h;
            if (!z2) {
                i3 = rect2.left;
                return i3;
            }
            f = rect2.right;
            f2 = this.k0;
        }
        return f - f2;
    }

    public final boolean r0() {
        return this.p0 == 1;
    }

    public final float s(RectF rectF, int i, int i2) {
        float f;
        float f2;
        int i3;
        if (i2 == 17 || (i2 & 7) == 1) {
            f = i / 2.0f;
            f2 = this.k0 / 2.0f;
        } else if ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) {
            if (!this.J) {
                i3 = this.h.right;
                return i3;
            }
            f = rectF.left;
            f2 = this.k0;
        } else {
            if (this.J) {
                i3 = this.h.right;
                return i3;
            }
            f = rectF.left;
            f2 = this.k0;
        }
        return f + f2;
    }

    public void s0(int i) {
        D(this.V);
        float f = i;
        this.u0 = j(this.p0, this.V, this.H, f * (this.n / this.m), this.J).getHeight();
        E(this.V);
        this.v0 = j(this.o0, this.V, this.H, f, this.J).getHeight();
    }

    public int t() {
        return u(this.p);
    }

    public final int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.S;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final int v() {
        return u(this.o);
    }

    public int w() {
        return this.q;
    }

    public int x() {
        return this.o0;
    }

    public float y() {
        E(this.V);
        return (-this.V.ascent()) + this.V.descent();
    }

    public float z() {
        int i = this.v0;
        return i != -1 ? i : A();
    }
}
