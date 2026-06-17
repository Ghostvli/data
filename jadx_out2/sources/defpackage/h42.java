package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class h42 implements Map, Serializable, op1 {
    public static final a s = new a(null);
    public static final h42 t;
    public Object[] f;
    public Object[] g;
    public int[] h;
    public int[] i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public j42 o;
    public k42 p;
    public i42 q;
    public boolean r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends d implements Iterator, op1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h42 h42Var) {
            super(h42Var);
            h42Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public c next() {
            b();
            if (c() >= e().k) {
                bo.a();
                return null;
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            c cVar = new c(e(), d());
            f();
            return cVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void j(StringBuilder sb) {
            sb.getClass();
            if (c() >= e().k) {
                bo.a();
                return;
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object obj = e().f[d()];
            if (obj == e()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = e().g;
            objArr.getClass();
            Object obj2 = objArr[d()];
            if (obj2 == e()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            f();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int k() {
            if (c() >= e().k) {
                bo.a();
                return 0;
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object obj = e().f[d()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = e().g;
            objArr.getClass();
            Object obj2 = objArr[d()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            f();
            return iHashCode2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements Map.Entry, op1 {
        public final h42 f;
        public final int g;
        public final int h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(h42 h42Var, int i) {
            h42Var.getClass();
            this.f = h42Var;
            this.g = i;
            this.h = h42Var.m;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void a() {
            if (this.f.m != this.h) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return il1.a(entry.getKey(), getKey()) && il1.a(entry.getValue(), getValue());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public Object getKey() {
            a();
            return this.f.f[this.g];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public Object getValue() {
            a();
            Object[] objArr = this.f.g;
            objArr.getClass();
            return objArr[this.g];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            this.f.m();
            Object[] objArrJ = this.f.j();
            int i = this.g;
            Object obj2 = objArrJ[i];
            objArrJ[i] = obj;
            return obj2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: (wrap:java.lang.Object:INVOKE), 61, (wrap:java.lang.Object:INVOKE) */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final h42 f;
        public int g;
        public int h;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(h42 h42Var) {
            h42Var.getClass();
            this.f = h42Var;
            this.h = -1;
            this.i = h42Var.m;
            f();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            if (this.f.m != this.i) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int c() {
            return this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int d() {
            return this.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final h42 e() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void f() {
            while (this.g < this.f.k) {
                int[] iArr = this.f.h;
                int i = this.g;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.g = i + 1;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g(int i) {
            this.g = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h(int i) {
            this.h = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean hasNext() {
            return this.g < this.f.k;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void remove() {
            b();
            if (this.h == -1) {
                e04.a("Call next() before removing element from the iterator.");
                return;
            }
            this.f.m();
            this.f.K(this.h);
            this.h = -1;
            this.i = this.f.m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends d implements Iterator, op1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h42 h42Var) {
            super(h42Var);
            h42Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public Object next() {
            b();
            if (c() >= e().k) {
                bo.a();
                return null;
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object obj = e().f[d()];
            f();
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends d implements Iterator, op1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h42 h42Var) {
            super(h42Var);
            h42Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public Object next() {
            b();
            if (c() >= e().k) {
                bo.a();
                return null;
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object[] objArr = e().g;
            objArr.getClass();
            Object obj = objArr[d()];
            f();
            return obj;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        h42 h42Var = new h42(0);
        h42Var.r = true;
        t = h42Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h42(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i, int i2) {
        this.f = objArr;
        this.g = objArr2;
        this.h = iArr;
        this.i = iArr2;
        this.j = i;
        this.k = i2;
        this.l = s.d(y());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void r(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > w()) {
            int iE = i0.Companion.e(w(), i);
            this.f = yt1.e(this.f, iE);
            Object[] objArr = this.g;
            this.g = objArr != null ? yt1.e(objArr, iE) : null;
            this.h = Arrays.copyOf(this.h, iE);
            int iC = s.c(iE);
            if (iC > y()) {
                I(iC);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int A() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection B() {
        k42 k42Var = this.p;
        if (k42Var != null) {
            return k42Var;
        }
        k42 k42Var2 = new k42(this);
        this.p = k42Var2;
        return k42Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final e D() {
        return new e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E(Collection collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        s(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (F((Map.Entry) it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean F(Map.Entry entry) {
        int i = i(entry.getKey());
        Object[] objArrJ = j();
        if (i >= 0) {
            objArrJ[i] = entry.getValue();
            return true;
        }
        int i2 = (-i) - 1;
        if (il1.a(entry.getValue(), objArrJ[i2])) {
            return false;
        }
        objArrJ[i2] = entry.getValue();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G(int i) {
        int iC = C(this.f[i]);
        int i2 = this.j;
        while (true) {
            int[] iArr = this.i;
            if (iArr[iC] == 0) {
                iArr[iC] = i + 1;
                this.h[i] = iC;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            iC = iC == 0 ? y() - 1 : iC - 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H() {
        this.m++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I(int i) {
        H();
        int i2 = 0;
        if (this.k > size()) {
            n(false);
        }
        this.i = new int[i];
        this.l = s.d(i);
        while (i2 < this.k) {
            int i3 = i2 + 1;
            if (!G(i2)) {
                e04.a("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                return;
            }
            i2 = i3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J(Map.Entry entry) {
        entry.getClass();
        m();
        int iU = u(entry.getKey());
        if (iU < 0) {
            return false;
        }
        Object[] objArr = this.g;
        objArr.getClass();
        if (!il1.a(objArr[iU], entry.getValue())) {
            return false;
        }
        K(iU);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(int i) {
        yt1.f(this.f, i);
        Object[] objArr = this.g;
        if (objArr != null) {
            yt1.f(objArr, i);
        }
        L(this.h[i]);
        this.h[i] = -1;
        this.n = size() - 1;
        H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(int i) {
        int iD = xn3.d(this.j * 2, y() / 2);
        int i2 = 0;
        int i3 = i;
        do {
            i = i == 0 ? y() - 1 : i - 1;
            i2++;
            int i4 = this.j;
            int[] iArr = this.i;
            if (i2 > i4) {
                iArr[i3] = 0;
                return;
            }
            int i5 = iArr[i];
            if (i5 == 0) {
                iArr[i3] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i3] = -1;
            } else {
                int i6 = i5 - 1;
                if (((C(this.f[i6]) - i) & (y() - 1)) >= i2) {
                    this.i[i3] = i5;
                    this.h[i6] = i3;
                }
                iD--;
            }
            i3 = i;
            i2 = 0;
            iD--;
        } while (iD >= 0);
        this.i[i3] = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M(Object obj) {
        m();
        int iU = u(obj);
        if (iU < 0) {
            return false;
        }
        K(iU);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean N(Object obj) {
        m();
        int iV = v(obj);
        if (iV < 0) {
            return false;
        }
        K(iV);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean O(int i) {
        int iW = w();
        int i2 = this.k;
        int i3 = iW - i2;
        int size = i2 - size();
        return i3 < i && i3 + size >= i && size >= w() / 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final f P() {
        return new f(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public void clear() {
        m();
        int i = this.k - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.h;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.i[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        yt1.g(this.f, 0, this.k);
        Object[] objArr = this.g;
        if (objArr != null) {
            yt1.g(objArr, 0, this.k);
        }
        this.n = 0;
        this.k = 0;
        H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return u(obj) >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return v(obj) >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Map) && q((Map) obj);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public Object get(Object obj) {
        int iU = u(obj);
        if (iU < 0) {
            return null;
        }
        Object[] objArr = this.g;
        objArr.getClass();
        return objArr[iU];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public int hashCode() {
        b bVarT = t();
        int iK = 0;
        while (bVarT.hasNext()) {
            iK += bVarT.k();
        }
        return iK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int i(Object obj) {
        m();
        while (true) {
            int iC = C(obj);
            int iD = xn3.d(this.j * 2, y() / 2);
            int i = 0;
            while (true) {
                int i2 = this.i[iC];
                if (i2 <= 0) {
                    if (this.k < w()) {
                        int i3 = this.k;
                        int i4 = i3 + 1;
                        this.k = i4;
                        this.f[i3] = obj;
                        this.h[i3] = iC;
                        this.i[iC] = i4;
                        this.n = size() + 1;
                        H();
                        if (i > this.j) {
                            this.j = i;
                        }
                        return i3;
                    }
                    s(1);
                } else {
                    if (il1.a(this.f[i2 - 1], obj)) {
                        return -i2;
                    }
                    i++;
                    if (i > iD) {
                        I(y() * 2);
                        break;
                    }
                    iC = iC == 0 ? y() - 1 : iC - 1;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object[] j() {
        Object[] objArr = this.g;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = yt1.d(w());
        this.g = objArrD;
        return objArrD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map k() {
        m();
        this.r = true;
        if (size() > 0) {
            return this;
        }
        h42 h42Var = t;
        h42Var.getClass();
        return h42Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        if (this.r) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(boolean z) {
        int i;
        Object[] objArr = this.g;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.k;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.h;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.f;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.i[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        yt1.g(this.f, i3, i);
        if (objArr != null) {
            yt1.g(objArr, i3, this.k);
        }
        this.k = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(Collection collection) {
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!p((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p(Map.Entry entry) {
        entry.getClass();
        int iU = u(entry.getKey());
        if (iU < 0) {
            return false;
        }
        Object[] objArr = this.g;
        objArr.getClass();
        return il1.a(objArr[iU], entry.getValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        m();
        int i = i(obj);
        Object[] objArrJ = j();
        if (i >= 0) {
            objArrJ[i] = obj2;
            return null;
        }
        int i2 = (-i) - 1;
        Object obj3 = objArrJ[i2];
        objArrJ[i2] = obj2;
        return obj3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public void putAll(Map map) {
        map.getClass();
        m();
        E(map.entrySet());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean q(Map map) {
        return size() == map.size() && o(map.entrySet());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public Object remove(Object obj) {
        m();
        int iU = u(obj);
        if (iU < 0) {
            return null;
        }
        Object[] objArr = this.g;
        objArr.getClass();
        Object obj2 = objArr[iU];
        K(iU);
        return obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(int i) {
        if (O(i)) {
            n(true);
        } else {
            r(this.k + i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public final /* bridge */ int size() {
        return A();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final b t() {
        return new b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarT = t();
        int i = 0;
        while (bVarT.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            bVarT.j(sb);
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u(Object obj) {
        int iC = C(obj);
        int i = this.j;
        while (true) {
            int i2 = this.i[iC];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (il1.a(this.f[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iC = iC == 0 ? y() - 1 : iC - 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int v(Object obj) {
        int i = this.k;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.h[i] >= 0) {
                Object[] objArr = this.g;
                objArr.getClass();
                if (il1.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int w() {
        return this.f.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set x() {
        i42 i42Var = this.q;
        if (i42Var != null) {
            return i42Var;
        }
        i42 i42Var2 = new i42(this);
        this.q = i42Var2;
        return i42Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int y() {
        return this.i.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set z() {
        j42 j42Var = this.o;
        if (j42Var != null) {
            return j42Var;
        }
        j42 j42Var2 = new j42(this);
        this.o = j42Var2;
        return j42Var2;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: h42.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int c(int i) {
            return Integer.highestOneBit(xn3.b(i, 1) * 3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final h42 e() {
            return h42.t;
        }

        public a() {
        }
    }

    public h42() {
        this(8);
    }

    public h42(int i) {
        this(yt1.d(i), null, new int[i], new int[s.c(i)], 2, 0);
    }
}
