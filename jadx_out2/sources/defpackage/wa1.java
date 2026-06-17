package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class wa1 {
    public final float[] a;
    public final int[] b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wa1(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(wa1 wa1Var) {
        int i = 0;
        while (true) {
            int[] iArr = wa1Var.b;
            if (i >= iArr.length) {
                return;
            }
            this.a[i] = wa1Var.a[i];
            this.b[i] = iArr[i];
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wa1 b(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = c(fArr[i]);
        }
        return new wa1(fArr, iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int c(float f) {
        int iBinarySearch = Arrays.binarySearch(this.a, f);
        if (iBinarySearch >= 0) {
            return this.b[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        int[] iArr = this.b;
        if (i == 0) {
            return iArr[0];
        }
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.a;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return c91.c((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] d() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float[] e() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            wa1 wa1Var = (wa1) obj;
            if (Arrays.equals(this.a, wa1Var.a) && Arrays.equals(this.b, wa1Var.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f() {
        return this.b.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(wa1 wa1Var, wa1 wa1Var2, float f) {
        int[] iArr;
        if (wa1Var.equals(wa1Var2)) {
            a(wa1Var);
            return;
        }
        if (f <= 0.0f) {
            a(wa1Var);
            return;
        }
        if (f >= 1.0f) {
            a(wa1Var2);
            return;
        }
        if (wa1Var.b.length != wa1Var2.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + wa1Var.b.length + " vs " + wa1Var2.b.length + ")");
        }
        int i = 0;
        while (true) {
            iArr = wa1Var.b;
            if (i >= iArr.length) {
                break;
            }
            this.a[i] = ot2.i(wa1Var.a[i], wa1Var2.a[i], f);
            this.b[i] = c91.c(f, wa1Var.b[i], wa1Var2.b[i]);
            i++;
        }
        int length = iArr.length;
        while (true) {
            float[] fArr = this.a;
            if (length >= fArr.length) {
                return;
            }
            int[] iArr2 = wa1Var.b;
            fArr[length] = fArr[iArr2.length - 1];
            int[] iArr3 = this.b;
            iArr3[length] = iArr3[iArr2.length - 1];
            length++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + Arrays.hashCode(this.b);
    }
}
