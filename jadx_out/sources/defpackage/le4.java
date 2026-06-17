package defpackage;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class le4 {
    public static final int o = 1;
    public CharSequence a;
    public final TextPaint b;
    public final int c;
    public int e;
    public boolean l;
    public me4 n;
    public int d = 0;
    public Layout.Alignment f = Layout.Alignment.ALIGN_NORMAL;
    public int g = Integer.MAX_VALUE;
    public float h = 0.0f;
    public float i = 1.0f;
    public int j = o;
    public boolean k = true;
    public TextUtils.TruncateAt m = null;

    public le4(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i;
        this.e = charSequence.length();
    }

    public static le4 b(CharSequence charSequence, TextPaint textPaint, int i) {
        return new le4(charSequence, textPaint, i);
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int iMax = Math.max(0, this.c);
        CharSequence charSequenceEllipsize = this.a;
        if (this.g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.b, iMax, this.m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.e);
        this.e = iMin;
        if (this.l && this.g == 1) {
            this.f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.d, iMin, this.b, iMax);
        builderObtain.setAlignment(this.f);
        builderObtain.setIncludePad(this.k);
        builderObtain.setTextDirection(this.l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.g);
        float f = this.h;
        if (f != 0.0f || this.i != 1.0f) {
            builderObtain.setLineSpacing(f, this.i);
        }
        if (this.g > 1) {
            builderObtain.setHyphenationFrequency(this.j);
        }
        me4 me4Var = this.n;
        if (me4Var != null) {
            me4Var.a(builderObtain);
        }
        return builderObtain.build();
    }

    public le4 c(Layout.Alignment alignment) {
        this.f = alignment;
        return this;
    }

    public le4 d(TextUtils.TruncateAt truncateAt) {
        this.m = truncateAt;
        return this;
    }

    public le4 e(int i) {
        this.j = i;
        return this;
    }

    public le4 f(boolean z) {
        this.k = z;
        return this;
    }

    public le4 g(boolean z) {
        this.l = z;
        return this;
    }

    public le4 h(float f, float f2) {
        this.h = f;
        this.i = f2;
        return this;
    }

    public le4 i(int i) {
        this.g = i;
        return this;
    }

    public le4 j(me4 me4Var) {
        this.n = me4Var;
        return this;
    }
}
