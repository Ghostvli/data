package defpackage;

import defpackage.vi1;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zi1 implements Map, Serializable {
    public static final Map.Entry[] i = new Map.Entry[0];
    public transient dj1 f;
    public transient dj1 g;
    public transient vi1 h;

    public static a a() {
        return new a();
    }

    public static zi1 b(Iterable iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.i(iterable);
        return aVar.a();
    }

    public static zi1 c(Map map) {
        if ((map instanceof zi1) && !(map instanceof SortedMap)) {
            zi1 zi1Var = (zi1) map;
            if (!zi1Var.h()) {
                return zi1Var;
            }
        }
        return b(map.entrySet());
    }

    public static zi1 j() {
        return zp3.m;
    }

    public static zi1 k(Object obj, Object obj2) {
        jw.a(obj, obj2);
        return zp3.o(1, new Object[]{obj, obj2});
    }

    public static zi1 m(Object obj, Object obj2, Object obj3, Object obj4) {
        jw.a(obj, obj2);
        jw.a(obj3, obj4);
        return zp3.o(2, new Object[]{obj, obj2, obj3, obj4});
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract dj1 d();

    public abstract dj1 e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return v42.f(this, obj);
    }

    public abstract vi1 f();

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public dj1 entrySet() {
        dj1 dj1Var = this.f;
        if (dj1Var != null) {
            return dj1Var;
        }
        dj1 dj1VarD = d();
        this.f = dj1VarD;
        return dj1VarD;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public abstract boolean h();

    @Override // java.util.Map
    public int hashCode() {
        return m24.d(entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public dj1 keySet() {
        dj1 dj1Var = this.g;
        if (dj1Var != null) {
            return dj1Var;
        }
        dj1 dj1VarE = e();
        this.g = dj1VarE;
        return dj1VarE;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public vi1 values() {
        vi1 vi1Var = this.h;
        if (vi1Var != null) {
            return vi1Var;
        }
        vi1 vi1VarF = f();
        this.h = vi1VarF;
        return vi1VarF;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return v42.n(this);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public Comparator a;
        public Object[] b;
        public int c;
        public boolean d;
        public C0144a e;

        /* JADX INFO: renamed from: zi1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0144a {
            public final Object a;
            public final Object b;
            public final Object c;

            public C0144a(Object obj, Object obj2, Object obj3) {
                this.a = obj;
                this.b = obj2;
                this.c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.a + "=" + this.b + " and " + this.a + "=" + this.c);
            }
        }

        public a(int i) {
            this.b = new Object[i * 2];
            this.c = 0;
            this.d = false;
        }

        public static void k(Object[] objArr, int i, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i];
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * 2;
                Object obj = objArr[i3];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i3 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i2] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i, x63.b(comparator).f(v42.r()));
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * 2;
                objArr[i5] = entryArr[i4].getKey();
                objArr[i5 + 1] = entryArr[i4].getValue();
            }
        }

        public zi1 a() {
            return d();
        }

        public final zi1 b(boolean z) {
            Object[] objArrF;
            C0144a c0144a;
            C0144a c0144a2;
            if (z && (c0144a2 = this.e) != null) {
                throw c0144a2.a();
            }
            int length = this.c;
            if (this.a == null) {
                objArrF = this.b;
            } else {
                if (this.d) {
                    this.b = Arrays.copyOf(this.b, length * 2);
                }
                objArrF = this.b;
                if (!z) {
                    objArrF = f(objArrF, this.c);
                    if (objArrF.length < this.b.length) {
                        length = objArrF.length >>> 1;
                    }
                }
                k(objArrF, length, this.a);
            }
            this.d = true;
            zp3 zp3VarP = zp3.p(length, objArrF, this);
            if (!z || (c0144a = this.e) == null) {
                return zp3VarP;
            }
            throw c0144a.a();
        }

        public zi1 c() {
            return b(false);
        }

        public zi1 d() {
            return b(true);
        }

        public final void e(int i) {
            int i2 = i * 2;
            Object[] objArr = this.b;
            if (i2 > objArr.length) {
                this.b = Arrays.copyOf(objArr, vi1.b.c(objArr.length, i2));
                this.d = false;
            }
        }

        public final Object[] f(Object[] objArr, int i) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i2 = i - 1; i2 >= 0; i2--) {
                Object obj = objArr[i2 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i2);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i - bitSet.cardinality()) * 2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i * 2) {
                if (bitSet.get(i3 >>> 1)) {
                    i3 += 2;
                } else {
                    int i5 = i4 + 1;
                    int i6 = i3 + 1;
                    Object obj2 = objArr[i3];
                    Objects.requireNonNull(obj2);
                    objArr2[i4] = obj2;
                    i4 += 2;
                    i3 += 2;
                    Object obj3 = objArr[i6];
                    Objects.requireNonNull(obj3);
                    objArr2[i5] = obj3;
                }
            }
            return objArr2;
        }

        public a g(Object obj, Object obj2) {
            e(this.c + 1);
            jw.a(obj, obj2);
            Object[] objArr = this.b;
            int i = this.c;
            objArr[i * 2] = obj;
            objArr[(i * 2) + 1] = obj2;
            this.c = i + 1;
            return this;
        }

        public a h(Map.Entry entry) {
            return g(entry.getKey(), entry.getValue());
        }

        public a i(Iterable iterable) {
            if (iterable instanceof Collection) {
                e(this.c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                h((Map.Entry) it.next());
            }
            return this;
        }

        public a j(Map map) {
            return i(map.entrySet());
        }

        public a() {
            this(4);
        }
    }
}
