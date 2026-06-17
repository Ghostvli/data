package defpackage;

import defpackage.bl1;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nk1 extends w0 implements bl1.g, RandomAccess, rg3 {
    public static final int[] i;
    public static final nk1 j;
    public int[] g;
    public int h;

    static {
        int[] iArr = new int[0];
        i = iArr;
        j = new nk1(iArr, 0, false);
    }

    public nk1(int[] iArr, int i2, boolean z) {
        super(z);
        this.g = iArr;
        this.h = i2;
    }

    public static nk1 g() {
        return j;
    }

    private void k(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            x32.a(o(i2));
        }
    }

    private static int n(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    private String o(int i2) {
        return "Index:" + i2 + ", Size:" + this.h;
    }

    @Override // bl1.i, bl1.a
    public bl1.g a(int i2) {
        if (i2 >= this.h) {
            return new nk1(i2 == 0 ? i : Arrays.copyOf(this.g, i2), this.h, true);
        }
        d04.a();
        return null;
    }

    @Override // defpackage.w0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        b();
        bl1.a(collection);
        if (!(collection instanceof nk1)) {
            return super.addAll(collection);
        }
        nk1 nk1Var = (nk1) collection;
        int i2 = nk1Var.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.g;
        if (i4 > iArr.length) {
            this.g = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(nk1Var.g, 0, this.g, this.h, nk1Var.h);
        this.h = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Integer num) {
        f(i2, num.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        e(num.intValue());
        return true;
    }

    public void e(int i2) {
        b();
        int i3 = this.h;
        int[] iArr = this.g;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[n(iArr.length)];
            System.arraycopy(this.g, 0, iArr2, 0, this.h);
            this.g = iArr2;
        }
        int[] iArr3 = this.g;
        int i4 = this.h;
        this.h = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nk1)) {
            return super.equals(obj);
        }
        nk1 nk1Var = (nk1) obj;
        if (this.h != nk1Var.h) {
            return false;
        }
        int[] iArr = nk1Var.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2, int i3) {
        int i4;
        b();
        if (i2 < 0 || i2 > (i4 = this.h)) {
            x32.a(o(i2));
            return;
        }
        int[] iArr = this.g;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[n(iArr.length)];
            System.arraycopy(this.g, 0, iArr2, 0, i2);
            System.arraycopy(this.g, i2, iArr2, i2 + 1, this.h - i2);
            this.g = iArr2;
        }
        this.g[i2] = i3;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + this.g[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    public void j(int i2) {
        int[] iArr = this.g;
        if (i2 <= iArr.length) {
            return;
        }
        if (iArr.length == 0) {
            this.g = new int[Math.max(i2, 10)];
            return;
        }
        int length = iArr.length;
        while (length < i2) {
            length = n(length);
        }
        this.g = Arrays.copyOf(this.g, length);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Integer get(int i2) {
        return Integer.valueOf(m(i2));
    }

    public int m(int i2) {
        k(i2);
        return this.g[i2];
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i2) {
        b();
        k(i2);
        int[] iArr = this.g;
        int i3 = iArr[i2];
        if (i2 < this.h - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer set(int i2, Integer num) {
        return Integer.valueOf(r(i2, num.intValue()));
    }

    public int r(int i2, int i3) {
        b();
        k(i2);
        int[] iArr = this.g;
        int i4 = iArr[i2];
        iArr[i2] = i3;
        return i4;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            x32.a("toIndex < fromIndex");
            return;
        }
        int[] iArr = this.g;
        System.arraycopy(iArr, i3, iArr, i2, this.h - i3);
        this.h -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.h;
    }
}
