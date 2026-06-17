package defpackage;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ox extends AbstractSet implements Serializable {
    public transient Object f;
    public transient int[] g;
    public transient Object[] h;
    public transient int i;
    public transient int j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Iterator {
        public int f;
        public int g;
        public int h = -1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            this.f = ox.this.i;
            this.g = ox.this.n();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            if (ox.this.i != this.f) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            this.f += 32;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.g >= 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public Object next() {
            b();
            if (!hasNext()) {
                bo.a();
                return null;
            }
            int i = this.g;
            this.h = i;
            Object objL = ox.this.l(i);
            this.g = ox.this.o(this.g);
            return objL;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public void remove() {
            b();
            jw.d(this.h >= 0);
            c();
            ox oxVar = ox.this;
            oxVar.remove(oxVar.l(this.h));
            this.g = ox.this.d(this.g, this.h);
            this.h = -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ox(int i) {
        r(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ox j(int i) {
        return new ox(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(int i) {
        this.g = Arrays.copyOf(y(), i);
        this.h = Arrays.copyOf(x(), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(int i) {
        int iMin;
        int length = y().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        A(iMin);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C(int i, int i2, int i3, int i4) {
        Object objA = px.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            px.i(objA, i3 & i5, i4 + 1);
        }
        Object objZ = z();
        int[] iArrY = y();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = px.h(objZ, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrY[i7];
                int iB = px.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = px.h(objA, i9);
                px.i(objA, i9, iH);
                iArrY[i7] = px.d(iB, iH2, i5);
                iH = px.c(i8, i);
            }
        }
        this.f = objA;
        F(i5);
        return i5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(int i, Object obj) {
        x()[i] = obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(int i, int i2) {
        y()[i] = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(int i) {
        this.i = px.d(this.i, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (w()) {
            e();
        }
        Set setK = k();
        if (setK != null) {
            return setK.add(obj);
        }
        int[] iArrY = y();
        Object[] objArrX = x();
        int i = this.j;
        int i2 = i + 1;
        int iC = uc1.c(obj);
        int iP = p();
        int i3 = iC & iP;
        int iH = px.h(z(), i3);
        if (iH != 0) {
            int iB = px.b(iC, iP);
            int i4 = 0;
            while (true) {
                int i5 = iH - 1;
                int i6 = iArrY[i5];
                if (px.b(i6, iP) == iB && Objects.equals(obj, objArrX[i5])) {
                    return false;
                }
                int iC2 = px.c(i6, iP);
                i4++;
                if (iC2 != 0) {
                    iH = iC2;
                } else {
                    if (i4 >= 9) {
                        return f().add(obj);
                    }
                    if (i2 > iP) {
                        iP = C(iP, px.e(iP), iC, i);
                    } else {
                        iArrY[i5] = px.d(i6, i2, iP);
                    }
                }
            }
        } else if (i2 > iP) {
            iP = C(iP, px.e(iP), iC, i);
        } else {
            px.i(z(), i3, i2);
        }
        B(i2);
        s(i, obj, iC, iP);
        this.j = i2;
        q();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (w()) {
            return;
        }
        q();
        Set setK = k();
        if (setK != null) {
            this.i = ll1.g(size(), 3, 1073741823);
            setK.clear();
            this.f = null;
            this.j = 0;
            return;
        }
        Arrays.fill(x(), 0, this.j, (Object) null);
        px.g(z());
        Arrays.fill(y(), 0, this.j, 0);
        this.j = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (w()) {
            return false;
        }
        Set setK = k();
        if (setK != null) {
            return setK.contains(obj);
        }
        int iC = uc1.c(obj);
        int iP = p();
        int iH = px.h(z(), iC & iP);
        if (iH == 0) {
            return false;
        }
        int iB = px.b(iC, iP);
        do {
            int i = iH - 1;
            int iM = m(i);
            if (px.b(iM, iP) == iB && Objects.equals(obj, l(i))) {
                return true;
            }
            iH = px.c(iM, iP);
        } while (iH != 0);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d(int i, int i2) {
        return i - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        gg3.w(w(), "Arrays already allocated");
        int i = this.i;
        int iJ = px.j(i);
        this.f = px.a(iJ);
        F(iJ - 1);
        this.g = new int[i];
        this.h = new Object[i];
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set f() {
        Set setG = g(p() + 1);
        int iN = n();
        while (iN >= 0) {
            setG.add(l(iN));
            iN = o(iN);
        }
        this.f = setG;
        this.g = null;
        this.h = null;
        q();
        return setG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Set g(int i) {
        return new LinkedHashSet(i, 1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        Set setK = k();
        return setK != null ? setK.iterator() : new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set k() {
        Object obj = this.f;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object l(int i) {
        return x()[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int m(int i) {
        return y()[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n() {
        return isEmpty() ? -1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int o(int i) {
        int i2 = i + 1;
        if (i2 < this.j) {
            return i2;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int p() {
        return (1 << (this.i & 31)) - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q() {
        this.i += 32;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(int i) {
        gg3.e(i >= 0, "Expected size must be >= 0");
        this.i = ll1.g(i, 1, 1073741823);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (w()) {
            return false;
        }
        Set setK = k();
        if (setK != null) {
            return setK.remove(obj);
        }
        int iP = p();
        int iF = px.f(obj, null, iP, z(), y(), x(), null);
        if (iF == -1) {
            return false;
        }
        u(iF, iP);
        this.j--;
        q();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(int i, Object obj, int i2, int i3) {
        E(i, px.d(i2, 0, i3));
        D(i, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set setK = k();
        return setK != null ? setK.size() : this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (!w()) {
            Set setK = k();
            return setK != null ? setK.toArray(objArr) : r43.e(x(), 0, this.j, objArr);
        }
        if (objArr.length > 0) {
            objArr[0] = null;
        }
        return objArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u(int i, int i2) {
        Object objZ = z();
        int[] iArrY = y();
        Object[] objArrX = x();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrX[i] = null;
            iArrY[i] = 0;
            return;
        }
        Object obj = objArrX[i3];
        objArrX[i] = obj;
        objArrX[i3] = null;
        iArrY[i] = iArrY[i3];
        iArrY[i3] = 0;
        int iC = uc1.c(obj) & i2;
        int iH = px.h(objZ, iC);
        if (iH == size) {
            px.i(objZ, iC, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrY[i4];
            int iC2 = px.c(i5, i2);
            if (iC2 == size) {
                iArrY[i4] = px.d(i5, i + 1, i2);
                return;
            }
            iH = iC2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w() {
        return this.f == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object[] x() {
        Object[] objArr = this.h;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int[] y() {
        int[] iArr = this.g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object z() {
        Object obj = this.f;
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (w()) {
            return new Object[0];
        }
        Set setK = k();
        return setK != null ? setK.toArray() : Arrays.copyOf(x(), this.j);
    }
}
