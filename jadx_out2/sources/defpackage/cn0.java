package defpackage;

import defpackage.bl1;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cn0 extends w0 implements bl1.b, RandomAccess, rg3 {
    public static final double[] i;
    public static final cn0 j;
    public double[] g;
    public int h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        double[] dArr = new double[0];
        i = dArr;
        j = new cn0(dArr, 0, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cn0(double[] dArr, int i2, boolean z) {
        super(z);
        this.g = dArr;
        this.h = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cn0 g() {
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void k(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            x32.a(o(i2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int n(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String o(int i2) {
        return "Index:" + i2 + ", Size:" + this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(I)Lbl1$i; */
    @Override // bl1.i, bl1.a
    public bl1.b a(int i2) {
        if (i2 >= this.h) {
            return new cn0(i2 == 0 ? i : Arrays.copyOf(this.g, i2), this.h, true);
        }
        d04.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        b();
        bl1.a(collection);
        if (!(collection instanceof cn0)) {
            return super.addAll(collection);
        }
        cn0 cn0Var = (cn0) collection;
        int i2 = cn0Var.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.g;
        if (i4 > dArr.length) {
            this.g = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(cn0Var.g, 0, this.g, this.h, cn0Var.h);
        this.h = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: add(ILjava/lang/Object;)V */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Double d) {
        f(i2, d.doubleValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: add(Ljava/lang/Object;)Z */
    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d) {
        e(d.doubleValue());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(double d) {
        b();
        int i2 = this.h;
        double[] dArr = this.g;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[n(dArr.length)];
            System.arraycopy(this.g, 0, dArr2, 0, this.h);
            this.g = dArr2;
        }
        double[] dArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        dArr3[i3] = d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cn0)) {
            return super.equals(obj);
        }
        cn0 cn0Var = (cn0) obj;
        if (this.h != cn0Var.h) {
            return false;
        }
        double[] dArr = cn0Var.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Double.doubleToLongBits(this.g[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(int i2, double d) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            x32.a(o(i2));
            return;
        }
        double[] dArr = this.g;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[n(dArr.length)];
            System.arraycopy(this.g, 0, dArr2, 0, i2);
            System.arraycopy(this.g, i2, dArr2, i2 + 1, this.h - i2);
            this.g = dArr2;
        }
        this.g[i2] = d;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            iF = (iF * 31) + bl1.f(Double.doubleToLongBits(this.g[i2]));
        }
        return iF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(int i2) {
        double[] dArr = this.g;
        if (i2 <= dArr.length) {
            return;
        }
        if (dArr.length == 0) {
            this.g = new double[Math.max(i2, 10)];
            return;
        }
        int length = dArr.length;
        while (length < i2) {
            length = n(length);
        }
        this.g = Arrays.copyOf(this.g, length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(I)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Double get(int i2) {
        return Double.valueOf(m(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public double m(int i2) {
        k(i2);
        return this.g[i2];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: remove(I)Ljava/lang/Object; */
    @Override // defpackage.w0, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Double remove(int i2) {
        b();
        k(i2);
        double[] dArr = this.g;
        double d = dArr[i2];
        if (i2 < this.h - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: set(ILjava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Double set(int i2, Double d) {
        return Double.valueOf(r(i2, d.doubleValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public double r(int i2, double d) {
        b();
        k(i2);
        double[] dArr = this.g;
        double d2 = dArr[i2];
        dArr[i2] = d;
        return d2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList
    public void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            x32.a("toIndex < fromIndex");
            return;
        }
        double[] dArr = this.g;
        System.arraycopy(dArr, i3, dArr, i2, this.h - i3);
        this.h -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.h;
    }
}
