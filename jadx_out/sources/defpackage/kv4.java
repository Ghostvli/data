package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.emoji2.text.c;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kv4 extends vr0 {
    public static Paint l;
    public TextPaint k;

    public kv4(jv4 jv4Var) {
        super(jv4Var);
    }

    public static Paint e() {
        if (l == null) {
            TextPaint textPaint = new TextPaint();
            l = textPaint;
            textPaint.setColor(c.c().d());
            l.setStyle(Paint.Style.FILL);
        }
        return l;
    }

    public final TextPaint c(CharSequence charSequence, int i, int i2, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.k;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.k = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    public void d(Canvas canvas, TextPaint textPaint, float f, float f2, float f3, float f4) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f, f3, f2, f4, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint textPaintC = c(charSequence, i, i2, paint);
        if (textPaintC != null && textPaintC.bgColor != 0) {
            d(canvas, textPaintC, f, f + b(), i3, i5);
        }
        Paint paint2 = textPaintC;
        if (c.c().j()) {
            canvas.drawRect(f, i3, f + b(), i5, e());
        }
        jv4 jv4VarA = a();
        float f2 = i4;
        if (paint2 == null) {
            paint2 = paint;
        }
        jv4VarA.a(canvas, f, f2, paint2);
    }
}
