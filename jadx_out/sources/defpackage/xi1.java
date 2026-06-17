package defpackage;

import defpackage.vi1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xi1 extends vi1 implements List, RandomAccess {
    public static final qw4 g = new b(yp3.j, 0);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends f0 {
        public final xi1 h;

        public b(xi1 xi1Var, int i) {
            super(xi1Var.size(), i);
            this.h = xi1Var;
        }

        @Override // defpackage.f0
        public Object b(int i) {
            return this.h.get(i);
        }
    }

    public static xi1 A(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return o(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static xi1 B(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return o(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static xi1 C(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        gg3.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[objArr.length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        return o(objArr2);
    }

    public static xi1 E(Comparator comparator, Iterable iterable) {
        gg3.q(comparator);
        Object[] objArrK = km1.k(iterable);
        r43.b(objArrK);
        Arrays.sort(objArrK, comparator);
        return k(objArrK);
    }

    public static Collector H() {
        return bw.a();
    }

    public static xi1 k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    public static xi1 l(Object[] objArr, int i) {
        return i == 0 ? u() : new yp3(objArr, i);
    }

    public static a m() {
        return new a();
    }

    public static a n(int i) {
        jw.b(i, "expectedSize");
        return new a(i);
    }

    public static xi1 o(Object... objArr) {
        return k(r43.b(objArr));
    }

    public static xi1 p(Collection collection) {
        if (!(collection instanceof vi1)) {
            return o(collection.toArray());
        }
        xi1 xi1VarB = ((vi1) collection).b();
        return xi1VarB.g() ? k(xi1VarB.toArray()) : xi1VarB;
    }

    public static xi1 q(Object[] objArr) {
        return objArr.length == 0 ? u() : o((Object[]) objArr.clone());
    }

    public static xi1 u() {
        return yp3.j;
    }

    public static xi1 w(Object obj) {
        return o(obj);
    }

    public static xi1 x(Object obj, Object obj2) {
        return o(obj, obj2);
    }

    public static xi1 y(Object obj, Object obj2, Object obj3) {
        return o(obj, obj2, obj3);
    }

    public static xi1 z(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return o(obj, obj2, obj3, obj4, obj5);
    }

    public xi1 D() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: F */
    public xi1 subList(int i, int i2) {
        gg3.u(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? u() : G(i, i2);
    }

    public xi1 G(int i, int i2) {
        return new d(i, i2 - i);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.vi1
    public final xi1 b() {
        return this;
    }

    @Override // defpackage.vi1
    public int c(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return ru1.b(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ru1.c(this, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public pw4 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ru1.e(this, obj);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public qw4 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public qw4 listIterator(int i) {
        gg3.s(i, size());
        return isEmpty() ? g : new b(this, i);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends vi1.a {
        public a() {
            this(4);
        }

        @Override // vi1.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            super.d(obj);
            return this;
        }

        public a i(Object... objArr) {
            super.e(objArr);
            return this;
        }

        public a j(Iterable iterable) {
            super.b(iterable);
            return this;
        }

        public xi1 k() {
            this.c = true;
            return xi1.l(this.a, this.b);
        }

        public xi1 l(Comparator comparator) {
            this.c = true;
            Arrays.sort(this.a, 0, this.b, comparator);
            return xi1.l(this.a, this.b);
        }

        public a m(a aVar) {
            f(aVar.a, aVar.b);
            return this;
        }

        public a(int i) {
            super(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends xi1 {
        public final transient xi1 h;

        public c(xi1 xi1Var) {
            this.h = xi1Var;
        }

        @Override // defpackage.xi1
        public xi1 D() {
            return this.h;
        }

        @Override // defpackage.xi1, java.util.List
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public xi1 subList(int i, int i2) {
            gg3.u(i, i2, size());
            return this.h.subList(J(i2), J(i)).D();
        }

        public final int I(int i) {
            return (size() - 1) - i;
        }

        public final int J(int i) {
            return size() - i;
        }

        @Override // defpackage.xi1, defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.h.contains(obj);
        }

        @Override // defpackage.vi1
        public boolean g() {
            return this.h.g();
        }

        @Override // java.util.List
        public Object get(int i) {
            gg3.o(i, size());
            return this.h.get(I(i));
        }

        @Override // defpackage.xi1, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.h.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return I(iLastIndexOf);
            }
            return -1;
        }

        @Override // defpackage.xi1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // defpackage.xi1, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.h.indexOf(obj);
            if (iIndexOf >= 0) {
                return I(iIndexOf);
            }
            return -1;
        }

        @Override // defpackage.xi1, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.h.size();
        }

        @Override // defpackage.xi1, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d extends xi1 {
        public final transient int h;
        public final transient int i;

        public d(int i, int i2) {
            this.h = i;
            this.i = i2;
        }

        @Override // defpackage.xi1, java.util.List
        /* JADX INFO: renamed from: F */
        public xi1 subList(int i, int i2) {
            gg3.u(i, i2, this.i);
            xi1 xi1Var = xi1.this;
            int i3 = this.h;
            return xi1Var.subList(i + i3, i2 + i3);
        }

        @Override // defpackage.vi1
        public Object[] d() {
            return xi1.this.d();
        }

        @Override // defpackage.vi1
        public int e() {
            return xi1.this.f() + this.h + this.i;
        }

        @Override // defpackage.vi1
        public int f() {
            return xi1.this.f() + this.h;
        }

        @Override // defpackage.vi1
        public boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i) {
            gg3.o(i, this.i);
            return xi1.this.get(i + this.h);
        }

        @Override // defpackage.xi1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // defpackage.xi1, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.i;
        }

        @Override // defpackage.xi1, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }
}
