package defpackage;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ia extends s0 {
    public static final a i = new a(null);
    public static final Object[] j = new Object[0];
    public int f;
    public Object[] g;
    public int h;

    public ia(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = j;
        } else {
            if (i2 <= 0) {
                b.a("Illegal Capacity: ", i2);
                throw null;
            }
            objArr = new Object[i2];
        }
        this.g = objArr;
    }

    private final void g(int i2) {
        if (i2 < 0) {
            e04.a("Deque is too big.");
            return;
        }
        Object[] objArr = this.g;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == j) {
            this.g = new Object[xn3.b(i2, 10)];
        } else {
            e(i0.Companion.e(objArr.length, i2));
        }
    }

    private final void o() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, Object obj) {
        i0.Companion.c(i2, size());
        if (i2 == size()) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        o();
        g(size() + 1);
        int iN = n(this.f + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int iF = f(iN);
            int iF2 = f(this.f);
            int i3 = this.f;
            Object[] objArr = this.g;
            if (iF >= i3) {
                objArr[iF2] = objArr[i3];
                ta.g(objArr, objArr, i3, i3 + 1, iF + 1);
            } else {
                ta.g(objArr, objArr, i3 - 1, i3, objArr.length);
                Object[] objArr2 = this.g;
                objArr2[objArr2.length - 1] = objArr2[0];
                ta.g(objArr2, objArr2, 0, 1, iF + 1);
            }
            this.g[iF] = obj;
            this.f = iF2;
        } else {
            int iN2 = n(this.f + size());
            Object[] objArr3 = this.g;
            if (iN < iN2) {
                ta.g(objArr3, objArr3, iN + 1, iN, iN2);
            } else {
                ta.g(objArr3, objArr3, 1, 0, iN2);
                Object[] objArr4 = this.g;
                objArr4[0] = objArr4[objArr4.length - 1];
                ta.g(objArr4, objArr4, iN + 1, iN, objArr4.length - 1);
            }
            this.g[iN] = obj;
        }
        this.h = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection collection) {
        collection.getClass();
        i0.Companion.c(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        o();
        g(size() + collection.size());
        int iN = n(this.f + size());
        int iN2 = n(this.f + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.f;
            int length = i3 - size;
            if (iN2 >= i3) {
                Object[] objArr = this.g;
                if (length >= 0) {
                    ta.g(objArr, objArr, length, i3, iN2);
                } else {
                    length += objArr.length;
                    int i4 = iN2 - i3;
                    int length2 = objArr.length - length;
                    if (length2 >= i4) {
                        ta.g(objArr, objArr, length, i3, iN2);
                    } else {
                        ta.g(objArr, objArr, length, i3, i3 + length2);
                        Object[] objArr2 = this.g;
                        ta.g(objArr2, objArr2, 0, this.f + length2, iN2);
                    }
                }
            } else {
                Object[] objArr3 = this.g;
                ta.g(objArr3, objArr3, length, i3, objArr3.length);
                Object[] objArr4 = this.g;
                if (size >= iN2) {
                    ta.g(objArr4, objArr4, objArr4.length - size, 0, iN2);
                } else {
                    ta.g(objArr4, objArr4, objArr4.length - size, 0, size);
                    Object[] objArr5 = this.g;
                    ta.g(objArr5, objArr5, 0, size, iN2);
                }
            }
            this.f = length;
            d(k(iN2 - size), collection);
        } else {
            int i5 = iN2 + size;
            Object[] objArr6 = this.g;
            if (iN2 < iN) {
                int i6 = size + iN;
                if (i6 <= objArr6.length) {
                    ta.g(objArr6, objArr6, i5, iN2, iN);
                } else if (i5 >= objArr6.length) {
                    ta.g(objArr6, objArr6, i5 - objArr6.length, iN2, iN);
                } else {
                    int length3 = iN - (i6 - objArr6.length);
                    ta.g(objArr6, objArr6, 0, length3, iN);
                    Object[] objArr7 = this.g;
                    ta.g(objArr7, objArr7, i5, iN2, length3);
                }
            } else {
                ta.g(objArr6, objArr6, size, 0, iN);
                Object[] objArr8 = this.g;
                if (i5 >= objArr8.length) {
                    ta.g(objArr8, objArr8, i5 - objArr8.length, iN2, objArr8.length);
                } else {
                    ta.g(objArr8, objArr8, 0, objArr8.length - size, objArr8.length);
                    Object[] objArr9 = this.g;
                    ta.g(objArr9, objArr9, i5, iN2, objArr9.length - size);
                }
            }
            d(iN2, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        o();
        g(size() + 1);
        int iF = f(this.f);
        this.f = iF;
        this.g[iF] = obj;
        this.h = size() + 1;
    }

    public final void addLast(Object obj) {
        o();
        g(size() + 1);
        this.g[n(this.f + size())] = obj;
        this.h = size() + 1;
    }

    @Override // defpackage.s0
    public int b() {
        return this.h;
    }

    @Override // defpackage.s0
    public Object c(int i2) {
        i0.Companion.b(i2, size());
        if (i2 == ow.l(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        o();
        int iN = n(this.f + i2);
        Object obj = this.g[iN];
        int size = size() >> 1;
        int i3 = this.f;
        if (i2 < size) {
            Object[] objArr = this.g;
            if (iN >= i3) {
                ta.g(objArr, objArr, i3 + 1, i3, iN);
            } else {
                ta.g(objArr, objArr, 1, 0, iN);
                Object[] objArr2 = this.g;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.f;
                ta.g(objArr2, objArr2, i4 + 1, i4, objArr2.length - 1);
            }
            Object[] objArr3 = this.g;
            int i5 = this.f;
            objArr3[i5] = null;
            this.f = j(i5);
        } else {
            int iN2 = n(i3 + ow.l(this));
            Object[] objArr4 = this.g;
            if (iN <= iN2) {
                ta.g(objArr4, objArr4, iN, iN + 1, iN2 + 1);
            } else {
                ta.g(objArr4, objArr4, iN, iN + 1, objArr4.length);
                Object[] objArr5 = this.g;
                objArr5[objArr5.length - 1] = objArr5[0];
                ta.g(objArr5, objArr5, 0, 1, iN2 + 1);
            }
            this.g[iN2] = null;
        }
        this.h = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            o();
            m(this.f, n(this.f + size()));
        }
        this.f = 0;
        this.h = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.g.length;
        while (i2 < length && it.hasNext()) {
            this.g[i2] = it.next();
            i2++;
        }
        int i3 = this.f;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.g[i4] = it.next();
        }
        this.h = size() + collection.size();
    }

    public final void e(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.g;
        ta.g(objArr2, objArr, 0, this.f, objArr2.length);
        Object[] objArr3 = this.g;
        int length = objArr3.length;
        int i3 = this.f;
        ta.g(objArr3, objArr, length - i3, 0, i3);
        this.f = 0;
        this.g = objArr;
    }

    public final int f(int i2) {
        return i2 == 0 ? ua.A(this.g) : i2 - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        i0.Companion.b(i2, size());
        return this.g[n(this.f + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int iN = n(this.f + size());
        int length = this.f;
        if (length < iN) {
            while (length < iN) {
                if (il1.a(obj, this.g[length])) {
                    i2 = this.f;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iN) {
            return -1;
        }
        int length2 = this.g.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iN; i3++) {
                    if (il1.a(obj, this.g[i3])) {
                        length = i3 + this.g.length;
                        i2 = this.f;
                    }
                }
                return -1;
            }
            if (il1.a(obj, this.g[length])) {
                i2 = this.f;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i2) {
        if (i2 == ua.A(this.g)) {
            return 0;
        }
        return i2 + 1;
    }

    public final int k(int i2) {
        return i2 < 0 ? i2 + this.g.length : i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iA;
        int i2;
        int iN = n(this.f + size());
        int i3 = this.f;
        if (i3 < iN) {
            iA = iN - 1;
            if (i3 <= iA) {
                while (!il1.a(obj, this.g[iA])) {
                    if (iA != i3) {
                        iA--;
                    }
                }
                i2 = this.f;
                return iA - i2;
            }
            return -1;
        }
        if (i3 > iN) {
            while (true) {
                iN--;
                Object[] objArr = this.g;
                if (-1 >= iN) {
                    iA = ua.A(objArr);
                    int i4 = this.f;
                    if (i4 <= iA) {
                        while (!il1.a(obj, this.g[iA])) {
                            if (iA != i4) {
                                iA--;
                            }
                        }
                        i2 = this.f;
                    }
                } else if (il1.a(obj, objArr[iN])) {
                    iA = iN + this.g.length;
                    i2 = this.f;
                    break;
                }
            }
            return iA - i2;
        }
        return -1;
    }

    public final void m(int i2, int i3) {
        Object[] objArr = this.g;
        if (i2 < i3) {
            ta.o(objArr, null, i2, i3);
        } else {
            ta.o(objArr, null, i2, objArr.length);
            ta.o(this.g, null, 0, i3);
        }
    }

    public final int n(int i2) {
        Object[] objArr = this.g;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public final Object p() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final void q(int i2, int i3) {
        int iN = n(this.f + (i2 - 1));
        int iN2 = n(this.f + (i3 - 1));
        while (i2 > 0) {
            int i4 = iN + 1;
            int iMin = Math.min(i2, Math.min(i4, iN2 + 1));
            Object[] objArr = this.g;
            int i5 = iN2 - iMin;
            int i6 = iN - iMin;
            ta.g(objArr, objArr, i5 + 1, i6 + 1, i4);
            iN = k(i6);
            iN2 = k(i5);
            i2 -= iMin;
        }
    }

    public final void r(int i2, int i3) {
        int iN = n(this.f + i3);
        int iN2 = n(this.f + i2);
        int size = size();
        while (true) {
            size -= i3;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.g;
            i3 = Math.min(size, Math.min(objArr.length - iN, objArr.length - iN2));
            Object[] objArr2 = this.g;
            int i4 = iN + i3;
            ta.g(objArr2, objArr2, iN2, iN, i4);
            iN = n(i4);
            iN2 = n(iN2 + i3);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        c(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int iN;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.g.length != 0) {
            int iN2 = n(this.f + size());
            int i2 = this.f;
            if (i2 < iN2) {
                iN = i2;
                while (true) {
                    objArr = this.g;
                    if (i2 >= iN2) {
                        break;
                    }
                    Object obj = objArr[i2];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.g[iN] = obj;
                        iN++;
                    }
                    i2++;
                }
                ta.o(objArr, null, iN, iN2);
            } else {
                int length = this.g.length;
                boolean z2 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr2 = this.g;
                    Object obj2 = objArr2[i2];
                    objArr2[i2] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.g[i3] = obj2;
                        i3++;
                    }
                    i2++;
                }
                iN = n(i3);
                for (int i4 = 0; i4 < iN2; i4++) {
                    Object[] objArr3 = this.g;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.g[iN] = obj3;
                        iN = j(iN);
                    }
                }
                z = z2;
            }
            if (z) {
                o();
                this.h = k(iN - this.f);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        o();
        Object[] objArr = this.g;
        int i2 = this.f;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f = j(i2);
        this.h = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        o();
        int iN = n(this.f + ow.l(this));
        Object[] objArr = this.g;
        Object obj = objArr[iN];
        objArr[iN] = null;
        this.h = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i2, int i3) {
        i0.Companion.d(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == 0) {
            return;
        }
        if (i4 == size()) {
            clear();
            return;
        }
        if (i4 == 1) {
            c(i2);
            return;
        }
        o();
        if (i2 < size() - i3) {
            q(i2, i3);
            int iN = n(this.f + i4);
            m(this.f, iN);
            this.f = iN;
        } else {
            r(i2, i3);
            int iN2 = n(this.f + size());
            m(k(iN2 - i4), iN2);
        }
        this.h = size() - i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int iN;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.g.length != 0) {
            int iN2 = n(this.f + size());
            int i2 = this.f;
            if (i2 < iN2) {
                iN = i2;
                while (true) {
                    objArr = this.g;
                    if (i2 >= iN2) {
                        break;
                    }
                    Object obj = objArr[i2];
                    if (collection.contains(obj)) {
                        this.g[iN] = obj;
                        iN++;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                ta.o(objArr, null, iN, iN2);
            } else {
                int length = this.g.length;
                boolean z2 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr2 = this.g;
                    Object obj2 = objArr2[i2];
                    objArr2[i2] = null;
                    if (collection.contains(obj2)) {
                        this.g[i3] = obj2;
                        i3++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                iN = n(i3);
                for (int i4 = 0; i4 < iN2; i4++) {
                    Object[] objArr3 = this.g;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (collection.contains(obj3)) {
                        this.g[iN] = obj3;
                        iN = j(iN);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                o();
                this.h = k(iN - this.f);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        i0.Companion.b(i2, size());
        int iN = n(this.f + i2);
        Object[] objArr = this.g;
        Object obj2 = objArr[iN];
        objArr[iN] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        objArr.getClass();
        if (objArr.length < size()) {
            objArr = ra.a(objArr, size());
        }
        Object[] objArr2 = objArr;
        int iN = n(this.f + size());
        int i2 = this.f;
        if (i2 < iN) {
            ta.j(this.g, objArr2, 0, i2, iN, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.g;
            ta.g(objArr3, objArr2, 0, this.f, objArr3.length);
            Object[] objArr4 = this.g;
            ta.g(objArr4, objArr2, objArr4.length - this.f, 0, iN);
        }
        return nw.e(size(), objArr2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }

    public ia() {
        this.g = j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        o();
        g(size() + collection.size());
        d(n(this.f + size()), collection);
        return true;
    }
}
