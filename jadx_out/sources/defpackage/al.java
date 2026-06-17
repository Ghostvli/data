package defpackage;

import defpackage.bl1;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class al extends w0 implements bl1.a, RandomAccess, rg3 {
    public static final boolean[] i;
    public static final al j;
    public boolean[] g;
    public int h;

    static {
        boolean[] zArr = new boolean[0];
        i = zArr;
        j = new al(zArr, 0, false);
    }

    public al(boolean[] zArr, int i2, boolean z) {
        super(z);
        this.g = zArr;
        this.h = i2;
    }

    public static al g() {
        return j;
    }

    public static int m(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    @Override // bl1.i, bl1.a
    public bl1.a a(int i2) {
        if (i2 >= this.h) {
            return new al(i2 == 0 ? i : Arrays.copyOf(this.g, i2), this.h, true);
        }
        d04.a();
        return null;
    }

    @Override // defpackage.w0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        b();
        bl1.a(collection);
        if (!(collection instanceof al)) {
            return super.addAll(collection);
        }
        al alVar = (al) collection;
        int i2 = alVar.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.g;
        if (i4 > zArr.length) {
            this.g = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(alVar.g, 0, this.g, this.h, alVar.h);
        this.h = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Boolean bool) {
        e(i2, bool.booleanValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        f(bool.booleanValue());
        return true;
    }

    public final void e(int i2, boolean z) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            x32.a(n(i2));
            return;
        }
        boolean[] zArr = this.g;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[m(zArr.length)];
            System.arraycopy(this.g, 0, zArr2, 0, i2);
            System.arraycopy(this.g, i2, zArr2, i2 + 1, this.h - i2);
            this.g = zArr2;
        }
        this.g[i2] = z;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof al)) {
            return super.equals(obj);
        }
        al alVar = (al) obj;
        if (this.h != alVar.h) {
            return false;
        }
        boolean[] zArr = alVar.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public void f(boolean z) {
        b();
        int i2 = this.h;
        boolean[] zArr = this.g;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[m(zArr.length)];
            System.arraycopy(this.g, 0, zArr2, 0, this.h);
            this.g = zArr2;
        }
        boolean[] zArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            iC = (iC * 31) + bl1.c(this.g[i2]);
        }
        return iC;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    public final void j(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            x32.a(n(i2));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i2) {
        return Boolean.valueOf(l(i2));
    }

    public boolean l(int i2) {
        j(i2);
        return this.g[i2];
    }

    public final String n(int i2) {
        return "Index:" + i2 + ", Size:" + this.h;
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i2) {
        b();
        j(i2);
        boolean[] zArr = this.g;
        boolean z = zArr[i2];
        if (i2 < this.h - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i2, Boolean bool) {
        return Boolean.valueOf(q(i2, bool.booleanValue()));
    }

    public boolean q(int i2, boolean z) {
        b();
        j(i2);
        boolean[] zArr = this.g;
        boolean z2 = zArr[i2];
        zArr[i2] = z;
        return z2;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            x32.a("toIndex < fromIndex");
            return;
        }
        boolean[] zArr = this.g;
        System.arraycopy(zArr, i3, zArr, i2, this.h - i3);
        this.h -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.h;
    }
}
