package defpackage;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lk1 {
    public static final lk1 e = new lk1(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static Insets a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    public lk1(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static lk1 a(lk1 lk1Var, lk1 lk1Var2) {
        return c(Math.max(lk1Var.a, lk1Var2.a), Math.max(lk1Var.b, lk1Var2.b), Math.max(lk1Var.c, lk1Var2.c), Math.max(lk1Var.d, lk1Var2.d));
    }

    public static lk1 b(lk1 lk1Var, lk1 lk1Var2) {
        return c(Math.min(lk1Var.a, lk1Var2.a), Math.min(lk1Var.b, lk1Var2.b), Math.min(lk1Var.c, lk1Var2.c), Math.min(lk1Var.d, lk1Var2.d));
    }

    public static lk1 c(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new lk1(i, i2, i3, i4);
    }

    public static lk1 d(Rect rect) {
        return c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static lk1 e(Insets insets) {
        return c(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lk1.class != obj.getClass()) {
            return false;
        }
        lk1 lk1Var = (lk1) obj;
        return this.d == lk1Var.d && this.a == lk1Var.a && this.c == lk1Var.c && this.b == lk1Var.b;
    }

    public Insets f() {
        return a.a(this.a, this.b, this.c, this.d);
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
