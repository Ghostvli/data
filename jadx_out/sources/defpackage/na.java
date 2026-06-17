package defpackage;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class na implements Collection, Set, op1 {
    public int[] f;
    public Object[] g;
    public int h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a extends lj1 {
        public a() {
            super(na.this.f());
        }

        @Override // defpackage.lj1
        public Object b(int i) {
            return na.this.n(i);
        }

        @Override // defpackage.lj1
        public void c(int i) {
            na.this.g(i);
        }
    }

    public na(int i) {
        this.f = i20.a;
        this.g = i20.c;
        if (i > 0) {
            pa.a(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i;
        int iC;
        int iF = f();
        if (obj == null) {
            iC = pa.d(this);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iC = pa.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i2 = ~iC;
        if (iF >= d().length) {
            int i3 = 8;
            if (iF >= 8) {
                i3 = (iF >> 1) + iF;
            } else if (iF < 4) {
                i3 = 4;
            }
            int[] iArrD = d();
            Object[] objArrC = c();
            pa.a(this, i3);
            if (iF != f()) {
                throw new ConcurrentModificationException();
            }
            if (!(d().length == 0)) {
                ta.i(iArrD, d(), 0, 0, iArrD.length, 6, null);
                ta.j(objArrC, c(), 0, 0, objArrC.length, 6, null);
            }
        }
        if (i2 < iF) {
            int i4 = i2 + 1;
            ta.e(d(), d(), i4, i2, iF);
            ta.g(c(), c(), i4, i2, iF);
        }
        if (iF != f() || i2 >= d().length) {
            throw new ConcurrentModificationException();
        }
        d()[i2] = i;
        c()[i2] = obj;
        m(f() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        collection.getClass();
        b(f() + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final void b(int i) {
        int iF = f();
        if (d().length < i) {
            int[] iArrD = d();
            Object[] objArrC = c();
            pa.a(this, i);
            if (f() > 0) {
                ta.i(iArrD, d(), 0, 0, f(), 6, null);
                ta.j(objArrC, c(), 0, 0, f(), 6, null);
            }
        }
        if (f() != iF) {
            throw new ConcurrentModificationException();
        }
    }

    public final Object[] c() {
        return this.g;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (f() != 0) {
            k(i20.a);
            j(i20.c);
            m(0);
        }
        if (f() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int[] d() {
        return this.f;
    }

    public int e() {
        return this.h;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int iF = f();
            for (int i = 0; i < iF; i++) {
                if (!((Set) obj).contains(n(i))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final int f() {
        return this.h;
    }

    public final Object g(int i) {
        int i2;
        Object[] objArr;
        int iF = f();
        Object obj = c()[i];
        if (iF <= 1) {
            clear();
            return obj;
        }
        int i3 = iF - 1;
        if (d().length <= 8 || f() >= d().length / 3) {
            if (i < i3) {
                int i4 = i + 1;
                ta.e(d(), d(), i, i4, iF);
                ta.g(c(), c(), i, i4, iF);
            }
            c()[i3] = null;
        } else {
            int iF2 = f() > 8 ? f() + (f() >> 1) : 8;
            int[] iArrD = d();
            Object[] objArrC = c();
            pa.a(this, iF2);
            if (i > 0) {
                ta.i(iArrD, d(), 0, 0, i, 6, null);
                objArr = objArrC;
                ta.j(objArr, c(), 0, 0, i, 6, null);
                i2 = i;
            } else {
                i2 = i;
                objArr = objArrC;
            }
            if (i2 < i3) {
                int i5 = i2 + 1;
                ta.e(iArrD, d(), i2, i5, iF);
                ta.g(objArr, c(), i2, i5, iF);
            }
        }
        if (iF != f()) {
            throw new ConcurrentModificationException();
        }
        m(i3);
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrD = d();
        int iF = f();
        int i = 0;
        for (int i2 = 0; i2 < iF; i2++) {
            i += iArrD[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        return obj == null ? pa.d(this) : pa.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return f() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final void j(Object[] objArr) {
        objArr.getClass();
        this.g = objArr;
    }

    public final void k(int[] iArr) {
        iArr.getClass();
        this.f = iArr;
    }

    public final void m(int i) {
        this.h = i;
    }

    public final Object n(int i) {
        return c()[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        collection.getClass();
        boolean z = false;
        for (int iF = f() - 1; -1 < iF; iF--) {
            if (!ww.E(collection, c()[iF])) {
                g(iF);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        Object[] objArrA = oa.a(objArr, this.h);
        ta.g(this.g, objArrA, 0, 0, this.h);
        objArrA.getClass();
        return objArrA;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(f() * 14);
        sb.append('{');
        int iF = f();
        for (int i = 0; i < iF; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objN = n(i);
            if (objN != this) {
                sb.append(objN);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public na() {
        this(0, 1, null);
    }

    public /* synthetic */ na(int i, int i2, we0 we0Var) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ta.l(this.g, 0, this.h);
    }
}
