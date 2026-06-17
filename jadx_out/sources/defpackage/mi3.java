package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mi3 extends w0 implements RandomAccess {
    public static final Object[] i;
    public static final mi3 j;
    public Object[] g;
    public int h;

    static {
        Object[] objArr = new Object[0];
        i = objArr;
        j = new mi3(objArr, 0, false);
    }

    public mi3(Object[] objArr, int i2, boolean z) {
        super(z);
        this.g = objArr;
        this.h = i2;
    }

    public static Object[] c(int i2) {
        return new Object[i2];
    }

    public static mi3 d() {
        return j;
    }

    private void f(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            x32.a(j(i2));
        }
    }

    private static int g(int i2) {
        return Math.max(((i2 * 3) / 2) + 1, 10);
    }

    private String j(int i2) {
        return "Index:" + i2 + ", Size:" + this.h;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, Object obj) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            x32.a(j(i2));
            return;
        }
        Object[] objArr = this.g;
        if (i3 < objArr.length) {
            System.arraycopy(objArr, i2, objArr, i2 + 1, i3 - i2);
        } else {
            Object[] objArrC = c(g(objArr.length));
            System.arraycopy(this.g, 0, objArrC, 0, i2);
            System.arraycopy(this.g, i2, objArrC, i2 + 1, this.h - i2);
            this.g = objArrC;
        }
        this.g[i2] = obj;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    public void e(int i2) {
        Object[] objArr = this.g;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr.length == 0) {
            this.g = new Object[Math.max(i2, 10)];
            return;
        }
        int length = objArr.length;
        while (length < i2) {
            length = g(length);
        }
        this.g = Arrays.copyOf(this.g, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        f(i2);
        return this.g[i2];
    }

    @Override // bl1.i, bl1.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public mi3 a(int i2) {
        if (i2 >= this.h) {
            return new mi3(i2 == 0 ? i : Arrays.copyOf(this.g, i2), this.h, true);
        }
        d04.a();
        return null;
    }

    @Override // defpackage.w0, java.util.AbstractList, java.util.List
    public Object remove(int i2) {
        b();
        f(i2);
        Object[] objArr = this.g;
        Object obj = objArr[i2];
        if (i2 < this.h - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        b();
        f(i2);
        Object[] objArr = this.g;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        b();
        int i2 = this.h;
        Object[] objArr = this.g;
        if (i2 == objArr.length) {
            this.g = Arrays.copyOf(this.g, g(objArr.length));
        }
        Object[] objArr2 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
