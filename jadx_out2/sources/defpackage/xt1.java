package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xt1 extends s0 implements List, RandomAccess, Serializable, pp1 {
    public static final b i = new b(null);
    public static final xt1 j;
    public Object[] f;
    public int g;
    public boolean h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements ListIterator, op1 {
        public final xt1 f;
        public int g;
        public int h;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(xt1 xt1Var, int i) {
            xt1Var.getClass();
            this.f = xt1Var;
            this.g = i;
            this.h = -1;
            this.i = ((AbstractList) xt1Var).modCount;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void b() {
            if (((AbstractList) this.f).modCount != this.i) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator
        public void add(Object obj) {
            b();
            xt1 xt1Var = this.f;
            int i = this.g;
            this.g = i + 1;
            xt1Var.add(i, obj);
            this.h = -1;
            this.i = ((AbstractList) this.f).modCount;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.g < this.f.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.g > 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            b();
            if (this.g >= this.f.g) {
                bo.a();
                return null;
            }
            int i = this.g;
            this.g = i + 1;
            this.h = i;
            return this.f.f[this.h];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator
        public Object previous() {
            b();
            int i = this.g;
            if (i <= 0) {
                bo.a();
                return null;
            }
            int i2 = i - 1;
            this.g = i2;
            this.h = i2;
            return this.f.f[this.h];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.g - 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            int i = this.h;
            if (i == -1) {
                e04.a("Call next() or previous() before removing element from the iterator.");
                return;
            }
            this.f.c(i);
            this.g = this.h;
            this.h = -1;
            this.i = ((AbstractList) this.f).modCount;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.ListIterator
        public void set(Object obj) {
            b();
            int i = this.h;
            if (i != -1) {
                this.f.set(i, obj);
            } else {
                e04.a("Call next() or previous() before replacing element from the iterator.");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        xt1 xt1Var = new xt1(0);
        xt1Var.h = true;
        j = xt1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xt1(int i2) {
        this.f = yt1.d(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final Object A(int i2) {
        z();
        Object[] objArr = this.f;
        Object obj = objArr[i2];
        ta.g(objArr, objArr, i2, i2 + 1, this.g);
        yt1.f(this.f, this.g - 1);
        this.g--;
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i2, int i3) {
        if (i3 > 0) {
            z();
        }
        Object[] objArr = this.f;
        ta.g(objArr, objArr, i2, i2 + i3, this.g);
        Object[] objArr2 = this.f;
        int i4 = this.g;
        yt1.g(objArr2, i4 - i3, i4);
        this.g -= i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final int C(int i2, int i3, Collection collection, boolean z) {
        Object[] objArr;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            objArr = this.f;
            if (i4 >= i3) {
                break;
            }
            int i6 = i2 + i4;
            if (collection.contains(objArr[i6]) == z) {
                Object[] objArr2 = this.f;
                i4++;
                objArr2[i5 + i2] = objArr2[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        ta.g(objArr, objArr, i2 + i5, i3 + i2, this.g);
        Object[] objArr3 = this.f;
        int i8 = this.g;
        yt1.g(objArr3, i8 - i7, i8);
        if (i7 > 0) {
            z();
        }
        this.g -= i7;
        return i7;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final void p(int i2, Collection collection, int i3) {
        z();
        y(i2, i3);
        Iterator it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f[i2 + i4] = it.next();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int i2, Object obj) {
        z();
        y(i2, 1);
        this.f[i2] = obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void s() {
        if (this.h) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final boolean u(List list) {
        return yt1.h(this.f, 0, this.g, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void x(int i2) {
        w(this.g + i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void z() {
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, Object obj) {
        s();
        i0.Companion.c(i2, this.g);
        q(i2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection collection) {
        collection.getClass();
        s();
        i0.Companion.c(i2, this.g);
        int size = collection.size();
        p(i2, collection, size);
        return size > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s0
    public int b() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s0
    public Object c(int i2) {
        s();
        i0.Companion.b(i2, this.g);
        return A(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        s();
        B(0, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && u((List) obj);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        i0.Companion.b(i2, this.g);
        return this.f[i2];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return yt1.i(this.f, 0, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.g; i2++) {
            if (il1.a(this.f[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.g == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i2 = this.g - 1; i2 >= 0; i2--) {
            if (il1.a(this.f[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i2) {
        i0.Companion.c(i2, this.g);
        return new c(this, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List r() {
        s();
        this.h = true;
        return this.g > 0 ? this : j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        s();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            c(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        collection.getClass();
        s();
        return C(0, this.g, collection, false) > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        collection.getClass();
        s();
        return C(0, this.g, collection, true) > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        s();
        i0.Companion.b(i2, this.g);
        Object[] objArr = this.f;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.List
    public List subList(int i2, int i3) {
        i0.Companion.d(i2, i3, this.g);
        return new a(this.f, i2, i3 - i2, null, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i2 = this.g;
        Object[] objArr2 = this.f;
        if (length >= i2) {
            ta.g(objArr2, objArr, 0, 0, i2);
            return nw.e(this.g, objArr);
        }
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, 0, i2, objArr.getClass());
        objArrCopyOfRange.getClass();
        return objArrCopyOfRange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection
    public String toString() {
        return yt1.j(this.f, 0, this.g, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(int i2) {
        if (i2 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f;
        if (i2 > objArr.length) {
            this.f = yt1.e(this.f, i0.Companion.e(objArr.length, i2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(int i2, int i3) {
        x(i3);
        Object[] objArr = this.f;
        ta.g(objArr, objArr, i2 + i3, i2, this.g);
        this.g += i3;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: xt1.b.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ b(we0 we0Var) {
            this();
        }

        public b() {
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
      (wrap:int:?: TERNARY null = ((wrap:int:0x0000: ARITH (r2v0 int) & (1 int) A[WRAPPED]) != (0 int)) ? (10 int) : (r1v0 int))
     A[MD:(int):void (m)] (LINE:11) call: xt1.<init>(int):void type: THIS */
    public /* synthetic */ xt1(int i2, int i3, we0 we0Var) {
        this((i3 & 1) != 0 ? 10 : i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        s();
        q(this.g, obj);
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends s0 implements List, RandomAccess, Serializable, pp1 {
        public Object[] f;
        public final int g;
        public int h;
        public final a i;
        public final xt1 j;

        /* JADX INFO: renamed from: xt1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0133a implements ListIterator, op1 {
            public final a f;
            public int g;
            public int h;
            public int i;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0133a(a aVar, int i) {
                aVar.getClass();
                this.f = aVar;
                this.g = i;
                this.h = -1;
                this.i = ((AbstractList) aVar).modCount;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator
            public void add(Object obj) {
                b();
                a aVar = this.f;
                int i = this.g;
                this.g = i + 1;
                aVar.add(i, obj);
                this.h = -1;
                this.i = ((AbstractList) this.f).modCount;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final void b() {
                if (((AbstractList) this.f.j).modCount != this.i) {
                    throw new ConcurrentModificationException();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.g < this.f.h;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.g > 0;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                b();
                if (this.g >= this.f.h) {
                    bo.a();
                    return null;
                }
                int i = this.g;
                this.g = i + 1;
                this.h = i;
                return this.f.f[this.f.g + this.h];
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.g;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator
            public Object previous() {
                b();
                int i = this.g;
                if (i <= 0) {
                    bo.a();
                    return null;
                }
                int i2 = i - 1;
                this.g = i2;
                this.h = i2;
                return this.f.f[this.f.g + this.h];
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.g - 1;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                b();
                int i = this.h;
                if (i == -1) {
                    e04.a("Call next() or previous() before removing element from the iterator.");
                    return;
                }
                this.f.c(i);
                this.g = this.h;
                this.h = -1;
                this.i = ((AbstractList) this.f).modCount;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.ListIterator
            public void set(Object obj) {
                b();
                int i = this.h;
                if (i != -1) {
                    this.f.set(i, obj);
                } else {
                    e04.a("Call next() or previous() before replacing element from the iterator.");
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Object[] objArr, int i, int i2, a aVar, xt1 xt1Var) {
            objArr.getClass();
            xt1Var.getClass();
            this.f = objArr;
            this.g = i;
            this.h = i2;
            this.i = aVar;
            this.j = xt1Var;
            ((AbstractList) this).modCount = ((AbstractList) xt1Var).modCount;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void n() {
            if (((AbstractList) this.j).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void r() {
            ((AbstractList) this).modCount++;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            o();
            n();
            i0.Companion.c(i, this.h);
            m(this.g + i, obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection collection) {
            collection.getClass();
            o();
            n();
            i0.Companion.c(i, this.h);
            int size = collection.size();
            k(this.g + i, collection, size);
            return size > 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.s0
        public int b() {
            n();
            return this.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.s0
        public Object c(int i) {
            o();
            n();
            i0.Companion.b(i, this.h);
            return s(this.g + i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            o();
            n();
            u(this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            n();
            if (obj != this) {
                return (obj instanceof List) && p((List) obj);
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            n();
            i0.Companion.b(i, this.h);
            return this.f[this.g + i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            n();
            return yt1.i(this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            n();
            for (int i = 0; i < this.h; i++) {
                if (il1.a(this.f[this.g + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            n();
            return this.h == 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator(0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void k(int i, Collection collection, int i2) {
            r();
            a aVar = this.i;
            if (aVar != null) {
                aVar.k(i, collection, i2);
            } else {
                this.j.p(i, collection, i2);
            }
            this.f = this.j.f;
            this.h += i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            n();
            for (int i = this.h - 1; i >= 0; i--) {
                if (il1.a(this.f[this.g + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            n();
            i0.Companion.c(i, this.h);
            return new C0133a(this, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m(int i, Object obj) {
            r();
            a aVar = this.i;
            if (aVar != null) {
                aVar.m(i, obj);
            } else {
                this.j.q(i, obj);
            }
            this.f = this.j.f;
            this.h++;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void o() {
            if (q()) {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean p(List list) {
            return yt1.h(this.f, this.g, this.h, list);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean q() {
            return this.j.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            o();
            n();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                c(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection collection) {
            collection.getClass();
            o();
            n();
            return w(this.g, this.h, collection, false) > 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection collection) {
            collection.getClass();
            o();
            n();
            return w(this.g, this.h, collection, true) > 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Object s(int i) {
            r();
            a aVar = this.i;
            this.h--;
            return aVar != null ? aVar.s(i) : this.j.A(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            o();
            n();
            i0.Companion.b(i, this.h);
            Object[] objArr = this.f;
            int i2 = this.g;
            Object obj2 = objArr[i2 + i];
            objArr[i2 + i] = obj;
            return obj2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            i0.Companion.d(i, i2, this.h);
            return new a(this.f, this.g + i, i2 - i, this, this.j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] objArr) {
            objArr.getClass();
            n();
            int length = objArr.length;
            int i = this.h;
            Object[] objArr2 = this.f;
            if (length >= i) {
                int i2 = this.g;
                ta.g(objArr2, objArr, 0, i2, i + i2);
                return nw.e(this.h, objArr);
            }
            int i3 = this.g;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i3, i + i3, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection
        public String toString() {
            n();
            return yt1.j(this.f, this.g, this.h, this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u(int i, int i2) {
            if (i2 > 0) {
                r();
            }
            a aVar = this.i;
            if (aVar != null) {
                aVar.u(i, i2);
            } else {
                this.j.B(i, i2);
            }
            this.h -= i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int w(int i, int i2, Collection collection, boolean z) {
            a aVar = this.i;
            int iW = aVar != null ? aVar.w(i, i2, collection, z) : this.j.C(i, i2, collection, z);
            if (iW > 0) {
                r();
            }
            this.h -= iW;
            return iW;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            o();
            n();
            m(this.g + this.h, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            collection.getClass();
            o();
            n();
            int size = collection.size();
            k(this.g + this.h, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            n();
            Object[] objArr = this.f;
            int i = this.g;
            return ta.l(objArr, i, this.h + i);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        collection.getClass();
        s();
        int size = collection.size();
        p(this.g, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ta.l(this.f, 0, this.g);
    }
}
