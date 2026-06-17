package defpackage;

import defpackage.bl1;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s21 extends w0 implements bl1.f, RandomAccess, rg3 {
    public static final float[] i;
    public static final s21 j;
    public float[] g;
    public int h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        float[] fArr = new float[0];
        i = fArr;
        j = new s21(fArr, 0, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s21(float[] fArr, int i2, boolean z) {
        super(z);
        this.g = fArr;
        this.h = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static s21 g() {
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
    public bl1.f a(int i2) {
        if (i2 >= this.h) {
            return new s21(i2 == 0 ? i : Arrays.copyOf(this.g, i2), this.h, true);
        }
        d04.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        b();
        bl1.a(collection);
        if (!(collection instanceof s21)) {
            return super.addAll(collection);
        }
        s21 s21Var = (s21) collection;
        int i2 = s21Var.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.g;
        if (i4 > fArr.length) {
            this.g = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(s21Var.g, 0, this.g, this.h, s21Var.h);
        this.h = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: add(ILjava/lang/Object;)V */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Float f) {
        f(i2, f.floatValue());
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
    public boolean add(Float f) {
        e(f.floatValue());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(float f) {
        b();
        int i2 = this.h;
        float[] fArr = this.g;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[n(fArr.length)];
            System.arraycopy(this.g, 0, fArr2, 0, this.h);
            this.g = fArr2;
        }
        float[] fArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        fArr3[i3] = f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s21)) {
            return super.equals(obj);
        }
        s21 s21Var = (s21) obj;
        if (this.h != s21Var.h) {
            return false;
        }
        float[] fArr = s21Var.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Float.floatToIntBits(this.g[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(int i2, float f) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            x32.a(o(i2));
            return;
        }
        float[] fArr = this.g;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[n(fArr.length)];
            System.arraycopy(this.g, 0, fArr2, 0, i2);
            System.arraycopy(this.g, i2, fArr2, i2 + 1, this.h - i2);
            this.g = fArr2;
        }
        this.g[i2] = f;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.g[i2]);
        }
        return iFloatToIntBits;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(int i2) {
        float[] fArr = this.g;
        if (i2 <= fArr.length) {
            return;
        }
        if (fArr.length == 0) {
            this.g = new float[Math.max(i2, 10)];
            return;
        }
        int length = fArr.length;
        while (length < i2) {
            length = n(length);
        }
        this.g = Arrays.copyOf(this.g, length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(I)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Float get(int i2) {
        return Float.valueOf(m(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float m(int i2) {
        k(i2);
        return this.g[i2];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: remove(I)Ljava/lang/Object; */
    @Override // defpackage.w0, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Float remove(int i2) {
        b();
        k(i2);
        float[] fArr = this.g;
        float f = fArr[i2];
        if (i2 < this.h - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: set(ILjava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Float set(int i2, Float f) {
        return Float.valueOf(r(i2, f.floatValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float r(int i2, float f) {
        b();
        k(i2);
        float[] fArr = this.g;
        float f2 = fArr[i2];
        fArr[i2] = f;
        return f2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList
    public void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            x32.a("toIndex < fromIndex");
            return;
        }
        float[] fArr = this.g;
        System.arraycopy(fArr, i3, fArr, i2, this.h - i3);
        this.h -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.h;
    }
}
