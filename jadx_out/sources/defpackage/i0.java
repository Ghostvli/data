package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 extends u implements List, op1 {
    public static final a Companion = new a(null);
    private static final int maxArraySize = 2147483639;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Iterator, op1 {
        public int f;

        public b() {
        }

        public final int b() {
            return this.f;
        }

        public final void c(int i) {
            this.f = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f < i0.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                bo.a();
                return null;
            }
            i0 i0Var = i0.this;
            int i = this.f;
            this.f = i + 1;
            return i0Var.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends b implements ListIterator, op1 {
        public c(int i) {
            super();
            i0.Companion.c(i, i0.this.size());
            c(i);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                bo.a();
                return null;
            }
            i0 i0Var = i0.this;
            c(b() - 1);
            return i0Var.get(b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends i0 implements RandomAccess {
        public final i0 f;
        public final int g;
        public int h;

        public d(i0 i0Var, int i, int i2) {
            i0Var.getClass();
            this.f = i0Var;
            this.g = i;
            i0.Companion.d(i, i2, i0Var.size());
            this.h = i2 - i;
        }

        @Override // defpackage.i0, java.util.List
        public Object get(int i) {
            i0.Companion.b(i, this.h);
            return this.f.get(this.g + i);
        }

        @Override // defpackage.u
        public int getSize() {
            return this.h;
        }

        @Override // defpackage.i0, java.util.List
        public List subList(int i, int i2) {
            i0.Companion.d(i, i2, this.h);
            i0 i0Var = this.f;
            int i3 = this.g;
            return new d(i0Var, i + i3, i3 + i2);
        }
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.f(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract Object get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.g(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (il1.a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (il1.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Object> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final void a(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                tg.a("startIndex: ", i, ", endIndex: ", i2, ", size: ", i3);
            } else {
                if (i <= i2) {
                    return;
                }
                j.a("startIndex: ", i, " > endIndex: ", i2);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i >= i2) {
                ug.a("index: ", i, ", size: ", i2);
            }
        }

        public final void c(int i, int i2) {
            if (i < 0 || i > i2) {
                ug.a("index: ", i, ", size: ", i2);
            }
        }

        public final void d(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                tg.a("fromIndex: ", i, ", toIndex: ", i2, ", size: ", i3);
            } else {
                if (i <= i2) {
                    return;
                }
                j.a("fromIndex: ", i, " > toIndex: ", i2);
            }
        }

        public final int e(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - i0.maxArraySize <= 0) {
                return i3;
            }
            if (i2 > i0.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return i0.maxArraySize;
        }

        public final boolean f(Collection collection, Collection collection2) {
            collection.getClass();
            collection2.getClass();
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!il1.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection collection) {
            collection.getClass();
            Iterator it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public a() {
        }
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i) {
        return new c(i);
    }
}
