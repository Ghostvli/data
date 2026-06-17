package defpackage;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vr0 extends ReplacementSpan {
    public final jv4 g;
    public final Paint.FontMetricsInt f = new Paint.FontMetricsInt();
    public short h = -1;
    public short i = -1;
    public float j = 1.0f;

    public vr0(jv4 jv4Var) {
        hg3.h(jv4Var, "rasterizer cannot be null");
        this.g = jv4Var;
    }

    public final jv4 a() {
        return this.g;
    }

    public final int b() {
        return this.h;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f);
        Paint.FontMetricsInt fontMetricsInt2 = this.f;
        this.j = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.g.e();
        this.i = (short) (this.g.e() * this.j);
        short sI = (short) (this.g.i() * this.j);
        this.h = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
