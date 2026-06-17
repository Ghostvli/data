package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ii4 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final TextPaint f;
    public final Paint g;
    public final Paint h;
    public CharSequence i;
    public Layout.Alignment j;
    public Bitmap k;
    public float l;
    public int m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ii4(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.a = fRound;
        this.b = fRound;
        this.c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            return charSequence != null && charSequence.equals(charSequence2);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(p50 p50Var, cq cqVar, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = p50Var.d == null;
        if (!z) {
            i5 = -16777216;
        } else if (TextUtils.isEmpty(p50Var.a)) {
            return;
        } else {
            i5 = p50Var.l ? p50Var.m : cqVar.c;
        }
        if (a(this.i, p50Var.a) && Objects.equals(this.j, p50Var.b) && this.k == p50Var.d && this.l == p50Var.e && this.m == p50Var.f && Integer.valueOf(this.n).equals(Integer.valueOf(p50Var.g)) && this.o == p50Var.h && Integer.valueOf(this.p).equals(Integer.valueOf(p50Var.i)) && this.q == p50Var.j && this.r == p50Var.k && this.s == cqVar.a && this.t == cqVar.b && this.u == i5 && this.w == cqVar.d && this.v == cqVar.e && Objects.equals(this.f.getTypeface(), cqVar.f) && this.x == f && this.y == f2 && this.z == f3 && this.A == i && this.B == i2 && this.C == i3 && this.D == i4) {
            d(canvas, z);
            return;
        }
        boolean zA = qj.a(p50Var.a);
        CharSequence charSequenceB = p50Var.a;
        if (zA) {
            charSequenceB = qj.b(charSequenceB);
        }
        this.i = charSequenceB;
        this.j = p50Var.b;
        this.k = p50Var.d;
        this.l = p50Var.e;
        this.m = p50Var.f;
        this.n = p50Var.g;
        this.o = p50Var.h;
        this.p = p50Var.i;
        this.q = p50Var.j;
        this.r = p50Var.k;
        this.s = cqVar.a;
        this.t = cqVar.b;
        this.u = i5;
        this.w = cqVar.d;
        this.v = cqVar.e;
        this.f.setTypeface(cqVar.f);
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.A = i;
        this.B = i2;
        this.C = i3;
        this.D = i4;
        if (z) {
            gg3.q(this.i);
            g();
        } else {
            gg3.q(this.k);
            f();
        }
        d(canvas, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(Canvas canvas) {
        canvas.drawBitmap(this.k, (Rect) null, this.J, this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(Canvas canvas, boolean z) {
        if (z) {
            e(canvas);
            return;
        }
        gg3.q(this.J);
        gg3.q(this.k);
        c(canvas);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(Canvas canvas) {
        Canvas canvas2;
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.u) > 0) {
            this.g.setColor(this.u);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.g);
        } else {
            canvas2 = canvas;
        }
        int i = this.w;
        if (i == 1) {
            this.f.setStrokeJoin(Paint.Join.ROUND);
            this.f.setStrokeWidth(this.a);
            this.f.setColor(this.v);
            this.f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else if (i == 2) {
            TextPaint textPaint = this.f;
            float f = this.b;
            float f2 = this.c;
            textPaint.setShadowLayer(f, f2, f2, this.v);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.v;
            int i3 = z ? this.v : -1;
            float f3 = this.b / 2.0f;
            this.f.setColor(this.s);
            this.f.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.f.setShadowLayer(this.b, f4, f4, i2);
            staticLayout2.draw(canvas2);
            this.f.setShadowLayer(this.b, f3, f3, i3);
        }
        this.f.setColor(this.s);
        this.f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(iSave);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        float f;
        int i;
        float f2;
        Bitmap bitmap = this.k;
        int i2 = this.C;
        int i3 = this.A;
        int i4 = this.D;
        int i5 = this.B;
        float f3 = i2 - i3;
        float f4 = i3 + (this.o * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.l * f5);
        int iRound = Math.round(f3 * this.q);
        float f7 = this.r;
        int iRound2 = f7 != -3.4028235E38f ? Math.round(f5 * f7) : Math.round(iRound * (bitmap.getHeight() / bitmap.getWidth()));
        int i6 = this.p;
        if (i6 != 2) {
            if (i6 == 1) {
                f = iRound / 2;
            }
            int iRound3 = Math.round(f4);
            i = this.n;
            if (i == 2) {
                if (i == 1) {
                    f2 = iRound2 / 2;
                }
                int iRound4 = Math.round(f6);
                this.J = new Rect(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
            }
            f2 = iRound2;
            f6 -= f2;
            int iRound42 = Math.round(f6);
            this.J = new Rect(iRound3, iRound42, iRound + iRound3, iRound2 + iRound42);
        }
        f = iRound;
        f4 -= f;
        int iRound32 = Math.round(f4);
        i = this.n;
        if (i == 2) {
        }
        f6 -= f2;
        int iRound422 = Math.round(f6);
        this.J = new Rect(iRound32, iRound422, iRound + iRound32, iRound2 + iRound422);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        int iMax;
        int iMin;
        int iRound;
        int i;
        int i2;
        CharSequence charSequence = this.i;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.i);
        int i3 = this.C - this.A;
        int i4 = this.D - this.B;
        this.f.setTextSize(this.x);
        int i5 = (int) ((this.x * 0.125f) + 0.5f);
        int i6 = i5 * 2;
        int i7 = i3 - i6;
        float f = this.q;
        float f2 = -3.4028235E38f;
        if (f != -3.4028235E38f) {
            i7 = (int) (i7 * f);
        }
        int i8 = i7;
        String str = "SubtitlePainter";
        if (i8 <= 0) {
            xz1.i("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.y > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.y), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.w == 1) {
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class);
            int length = foregroundColorSpanArr.length;
            int i9 = 0;
            while (i9 < length) {
                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i9]);
                i9++;
                f2 = f2;
            }
        }
        float f3 = f2;
        if (Color.alpha(this.t) > 0) {
            int i10 = this.w;
            if (i10 == 0 || i10 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.j;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f, i8, alignment2, this.d, this.e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int iMax2 = 0;
        int i11 = 0;
        while (i11 < lineCount) {
            iMax2 = Math.max((int) Math.ceil(this.E.getLineWidth(i11)), iMax2);
            i11++;
            str = str;
        }
        String str2 = str;
        if (this.q == f3 || iMax2 >= i8) {
            i8 = iMax2;
        }
        int i12 = i8 + i6;
        float f4 = this.o;
        if (f4 != f3) {
            int iRound2 = Math.round(i3 * f4);
            int i13 = this.A;
            int i14 = iRound2 + i13;
            int i15 = this.p;
            if (i15 == 1) {
                i14 = ((i14 * 2) - i12) / 2;
            } else if (i15 == 2) {
                i14 -= i12;
            }
            iMax = Math.max(i14, i13);
            iMin = Math.min(i12 + iMax, this.C);
        } else {
            iMax = ((i3 - i12) / 2) + this.A;
            iMin = iMax + i12;
        }
        int i16 = iMin - iMax;
        if (i16 <= 0) {
            xz1.i(str2, "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f5 = this.l;
        if (f5 == f3) {
            iRound = (this.D - height) - ((int) (i4 * this.z));
        } else if (this.m == 0) {
            iRound = Math.round(i4 * f5) + this.B;
            int i17 = this.n;
            if (i17 == 2) {
                iRound -= height;
            } else if (i17 == 1) {
                iRound = ((iRound * 2) - height) / 2;
            }
            i = iRound + height;
            i2 = this.D;
            if (i > i2) {
                iRound = i2 - height;
            } else {
                int i18 = this.B;
                if (iRound < i18) {
                    iRound = i18;
                }
            }
        } else {
            int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
            float f6 = this.l;
            if (f6 >= 0.0f) {
                iRound = Math.round(f6 * lineBottom) + this.B;
                i = iRound + height;
                i2 = this.D;
                if (i > i2) {
                }
            } else {
                iRound = Math.round((f6 + 1.0f) * lineBottom) + this.D;
                iRound -= height;
                i = iRound + height;
                i2 = this.D;
                if (i > i2) {
                }
            }
        }
        this.E = new StaticLayout(spannableStringBuilder, this.f, i16, alignment2, this.d, this.e, true);
        this.F = new StaticLayout(spannableStringBuilder2, this.f, i16, alignment2, this.d, this.e, true);
        this.G = iMax;
        this.H = iRound;
        this.I = i5;
    }
}
