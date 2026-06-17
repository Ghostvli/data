package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b5 implements d40 {
    public final d40 a;
    public final float b;

    public b5(float f, d40 d40Var) {
        while (d40Var instanceof b5) {
            d40Var = ((b5) d40Var).a;
            f += ((b5) d40Var).b;
        }
        this.a = d40Var;
        this.b = f;
    }

    @Override // defpackage.d40
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b5)) {
            return false;
        }
        b5 b5Var = (b5) obj;
        return this.a.equals(b5Var.a) && this.b == b5Var.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
