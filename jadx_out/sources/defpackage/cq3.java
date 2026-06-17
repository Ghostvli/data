package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cq3 extends ej1 {
    public static final cq3 k = new cq3(xi1.u(), x63.d());
    public final transient xi1 j;

    public cq3(xi1 xi1Var, Comparator comparator) {
        super(comparator);
        this.j = xi1Var;
    }

    @Override // defpackage.ej1
    public ej1 D() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.h);
        return isEmpty() ? ej1.F(comparatorReverseOrder) : new cq3(this.j.D(), comparatorReverseOrder);
    }

    @Override // defpackage.ej1
    public ej1 I(Object obj, boolean z) {
        return S(0, T(obj, z));
    }

    @Override // defpackage.ej1
    public ej1 L(Object obj, boolean z, Object obj2, boolean z2) {
        return O(obj, z).I(obj2, z2);
    }

    @Override // defpackage.ej1
    public ej1 O(Object obj, boolean z) {
        return S(U(obj, z), size());
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public pw4 descendingIterator() {
        return this.j.D().iterator();
    }

    public cq3 S(int i, int i2) {
        return (i == 0 && i2 == size()) ? this : i < i2 ? new cq3(this.j.subList(i, i2), this.h) : ej1.F(this.h);
    }

    public int T(Object obj, boolean z) {
        int iBinarySearch = Collections.binarySearch(this.j, gg3.q(obj), comparator());
        return iBinarySearch >= 0 ? z ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    public int U(Object obj, boolean z) {
        int iBinarySearch = Collections.binarySearch(this.j, gg3.q(obj), comparator());
        return iBinarySearch >= 0 ? z ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    public final int V(Object obj) {
        return Collections.binarySearch(this.j, obj, W());
    }

    public Comparator W() {
        return this.h;
    }

    @Override // defpackage.dj1, defpackage.vi1
    public xi1 b() {
        return this.j;
    }

    @Override // defpackage.vi1
    public int c(Object[] objArr, int i) {
        return this.j.c(objArr, i);
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        int iU = U(obj, true);
        if (iU == size()) {
            return null;
        }
        return this.j.get(iU);
    }

    @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (V(obj) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        if (collection instanceof kw2) {
            collection = ((kw2) collection).i();
        }
        if (!na4.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        pw4 it = iterator();
        Iterator it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int iP = P(next2, next);
                if (iP < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iP == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iP > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // defpackage.vi1
    public Object[] d() {
        return this.j.d();
    }

    @Override // defpackage.vi1
    public int e() {
        return this.j.e();
    }

    @Override // defpackage.dj1, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!na4.b(this.h, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            pw4 it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 == null || P(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // defpackage.vi1
    public int f() {
        return this.j.f();
    }

    @Override // java.util.SortedSet
    public Object first() {
        if (!isEmpty()) {
            return this.j.get(0);
        }
        bo.a();
        return null;
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        int iT = T(obj, true) - 1;
        if (iT == -1) {
            return null;
        }
        return this.j.get(iT);
    }

    @Override // defpackage.vi1
    public boolean g() {
        return this.j.g();
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        int iU = U(obj, false);
        if (iU == size()) {
            return null;
        }
        return this.j.get(iU);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: j */
    public pw4 iterator() {
        return this.j.iterator();
    }

    @Override // java.util.SortedSet
    public Object last() {
        if (!isEmpty()) {
            return this.j.get(size() - 1);
        }
        bo.a();
        return null;
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        int iT = T(obj, false) - 1;
        if (iT == -1) {
            return null;
        }
        return this.j.get(iT);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.j.size();
    }
}
