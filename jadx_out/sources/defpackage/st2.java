package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class st2 extends yh1 {
    public final int b;
    public final int c;
    public final int d;
    public final int[] e;
    public final int[] f;

    public st2(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = iArr;
        this.f = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && st2.class == obj.getClass()) {
            st2 st2Var = (st2) obj;
            if (this.b == st2Var.b && this.c == st2Var.c && this.d == st2Var.d && Arrays.equals(this.e, st2Var.e) && Arrays.equals(this.f, st2Var.f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.b) * 31) + this.c) * 31) + this.d) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f);
    }
}
