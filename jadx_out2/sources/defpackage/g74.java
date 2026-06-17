package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import defpackage.a6;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class g74 extends ah {
    public static final Map a = new HashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ah
    public void a() {
        a.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ah
    public void c(ih ihVar, Canvas canvas, float f, float f2, boolean z, a6.a aVar) {
        float f3;
        float f4;
        float f5;
        int i = ihVar.m;
        float f6 = f + i;
        float f7 = f2 + i;
        if (ihVar.l != 0) {
            f6 += 4.0f;
            f7 += 4.0f;
        }
        float f8 = f7;
        float f9 = f6;
        aVar.i(z);
        TextPaint textPaintK = aVar.k(ihVar, z);
        g(ihVar, canvas, f, f2);
        String[] strArr = ihVar.d;
        if (strArr == null) {
            if (aVar.n(ihVar)) {
                aVar.f(ihVar, textPaintK, true);
                float fAscent = f8 - textPaintK.ascent();
                if (aVar.s) {
                    float f10 = aVar.k + f9;
                    fAscent += aVar.l;
                    f3 = f10;
                } else {
                    f3 = f9;
                }
                h(ihVar, null, canvas, f3, fAscent, textPaintK);
            }
            aVar.f(ihVar, textPaintK, false);
            i(ihVar, null, canvas, f9, f8 - textPaintK.ascent(), textPaintK, z);
        } else if (strArr.length == 1) {
            if (aVar.n(ihVar)) {
                aVar.f(ihVar, textPaintK, true);
                float fAscent2 = f8 - textPaintK.ascent();
                if (aVar.s) {
                    float f11 = aVar.k + f9;
                    fAscent2 += aVar.l;
                    f5 = f11;
                } else {
                    f5 = f9;
                }
                h(ihVar, strArr[0], canvas, f5, fAscent2, textPaintK);
            }
            aVar.f(ihVar, textPaintK, false);
            i(ihVar, strArr[0], canvas, f9, f8 - textPaintK.ascent(), textPaintK, z);
        } else {
            float length = (ihVar.p - (ihVar.m * 2)) / strArr.length;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (str != null && str.length() != 0) {
                    if (aVar.n(ihVar)) {
                        aVar.f(ihVar, textPaintK, true);
                        float fAscent3 = ((i2 * length) + f8) - textPaintK.ascent();
                        if (aVar.s) {
                            float f12 = aVar.k + f9;
                            fAscent3 += aVar.l;
                            f4 = f12;
                        } else {
                            f4 = f9;
                        }
                        h(ihVar, strArr[i2], canvas, f4, fAscent3, textPaintK);
                    }
                    aVar.f(ihVar, textPaintK, false);
                    i(ihVar, strArr[i2], canvas, f9, ((i2 * length) + f8) - textPaintK.ascent(), textPaintK, z);
                }
            }
        }
        if (ihVar.j != 0) {
            Paint paintM = aVar.m(ihVar);
            float f13 = (f2 + ihVar.p) - aVar.h;
            canvas.drawLine(f, f13, f + ihVar.o, f13, paintM);
        }
        if (ihVar.l != 0) {
            canvas.drawRect(f, f2, f + ihVar.o, f2 + ihVar.p, aVar.j(ihVar));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ah
    public void d(ih ihVar, TextPaint textPaint, boolean z) {
        float fMax = 0.0f;
        Float fValueOf = Float.valueOf(0.0f);
        if (ihVar.d == null) {
            CharSequence charSequence = ihVar.c;
            if (charSequence != null) {
                fMax = textPaint.measureText(charSequence.toString());
                fValueOf = j(ihVar, textPaint);
            }
            ihVar.o = fMax;
            ihVar.p = fValueOf.floatValue();
            return;
        }
        Float fJ = j(ihVar, textPaint);
        for (String str : ihVar.d) {
            if (str.length() > 0) {
                fMax = Math.max(textPaint.measureText(str), fMax);
            }
        }
        ihVar.o = fMax;
        ihVar.p = ihVar.d.length * fJ.floatValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(ih ihVar, Canvas canvas, float f, float f2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(ih ihVar, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else {
            canvas.drawText(ihVar.c.toString(), f, f2, paint);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(ih ihVar, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        if (z && (ihVar instanceof rb4)) {
            textPaint.setAlpha(255);
        }
        if (str != null) {
            canvas.drawText(str, f, f2, textPaint);
        } else {
            canvas.drawText(ihVar.c.toString(), f, f2, textPaint);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Float j(ih ihVar, Paint paint) {
        Float fValueOf = Float.valueOf(paint.getTextSize());
        Map map = a;
        Float f = (Float) map.get(fValueOf);
        if (f != null) {
            return f;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        Float fValueOf2 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
        map.put(fValueOf, fValueOf2);
        return fValueOf2;
    }
}
