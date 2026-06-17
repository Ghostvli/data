package defpackage;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nx extends AbstractMap implements Serializable {
    public static final Object o = new Object();
    public transient Object f;
    public transient int[] g;
    public transient Object[] h;
    public transient Object[] i;
    public transient int j;
    public transient int k;
    public transient Set l;
    public transient Set m;
    public transient Collection n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends e {
        public a() {
            super(nx.this, null);
        }

        @Override // nx.e
        public Object c(int i) {
            return nx.this.I(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends e {
        public b() {
            super(nx.this, null);
        }

        @Override // nx.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry c(int i) {
            return nx.this.new g(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends e {
        public c() {
            super(nx.this, null);
        }

        @Override // nx.e
        public Object c(int i) {
            return nx.this.Y(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g extends o0 {
        public final Object f;
        public int g;

        public g(int i) {
            this.f = nx.this.I(i);
            this.g = i;
        }

        public final void a() {
            int i = this.g;
            if (i == -1 || i >= nx.this.size() || !Objects.equals(this.f, nx.this.I(this.g))) {
                this.g = nx.this.F(this.f);
            }
        }

        @Override // defpackage.o0, java.util.Map.Entry
        public Object getKey() {
            return this.f;
        }

        @Override // defpackage.o0, java.util.Map.Entry
        public Object getValue() {
            Map mapY = nx.this.y();
            if (mapY != null) {
                return n43.a(mapY.get(this.f));
            }
            a();
            int i = this.g;
            return i == -1 ? n43.b() : nx.this.Y(i);
        }

        @Override // defpackage.o0, java.util.Map.Entry
        public Object setValue(Object obj) {
            Map mapY = nx.this.y();
            if (mapY != null) {
                return n43.a(mapY.put(this.f, obj));
            }
            a();
            int i = this.g;
            nx nxVar = nx.this;
            if (i == -1) {
                nxVar.put(this.f, obj);
                return n43.b();
            }
            Object objY = nxVar.Y(i);
            nx.this.X(this.g, obj);
            return objY;
        }
    }

    public nx() {
        G(3);
    }

    public static /* synthetic */ int g(nx nxVar) {
        int i = nxVar.k;
        nxVar.k = i - 1;
        return i;
    }

    public static nx s() {
        return new nx();
    }

    public static nx x(int i) {
        return new nx(i);
    }

    public Iterator A() {
        Map mapY = y();
        return mapY != null ? mapY.entrySet().iterator() : new b();
    }

    public int B() {
        return isEmpty() ? -1 : 0;
    }

    public int C(int i) {
        int i2 = i + 1;
        if (i2 < this.k) {
            return i2;
        }
        return -1;
    }

    public final int D() {
        return (1 << (this.j & 31)) - 1;
    }

    public void E() {
        this.j += 32;
    }

    public final int F(Object obj) {
        if (L()) {
            return -1;
        }
        int iC = uc1.c(obj);
        int iD = D();
        int iH = px.h(P(), iC & iD);
        if (iH == 0) {
            return -1;
        }
        int iB = px.b(iC, iD);
        do {
            int i = iH - 1;
            int iZ = z(i);
            if (px.b(iZ, iD) == iB && Objects.equals(obj, I(i))) {
                return i;
            }
            iH = px.c(iZ, iD);
        } while (iH != 0);
        return -1;
    }

    public void G(int i) {
        gg3.e(i >= 0, "Expected size must be >= 0");
        this.j = ll1.g(i, 1, 1073741823);
    }

    public void H(int i, Object obj, Object obj2, int i2, int i3) {
        U(i, px.d(i2, 0, i3));
        W(i, obj);
        X(i, obj2);
    }

    public final Object I(int i) {
        return O()[i];
    }

    public Iterator J() {
        Map mapY = y();
        return mapY != null ? mapY.keySet().iterator() : new a();
    }

    public void K(int i, int i2) {
        Object objP = P();
        int[] iArrN = N();
        Object[] objArrO = O();
        Object[] objArrQ = Q();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrO[i] = null;
            objArrQ[i] = null;
            iArrN[i] = 0;
            return;
        }
        Object obj = objArrO[i3];
        objArrO[i] = obj;
        objArrQ[i] = objArrQ[i3];
        objArrO[i3] = null;
        objArrQ[i3] = null;
        iArrN[i] = iArrN[i3];
        iArrN[i3] = 0;
        int iC = uc1.c(obj) & i2;
        int iH = px.h(objP, iC);
        if (iH == size) {
            px.i(objP, iC, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrN[i4];
            int iC2 = px.c(i5, i2);
            if (iC2 == size) {
                iArrN[i4] = px.d(i5, i + 1, i2);
                return;
            }
            iH = iC2;
        }
    }

    public boolean L() {
        return this.f == null;
    }

    public final Object M(Object obj) {
        if (L()) {
            return o;
        }
        int iD = D();
        int iF = px.f(obj, null, iD, P(), N(), O(), null);
        if (iF == -1) {
            return o;
        }
        Object objY = Y(iF);
        K(iF, iD);
        this.k--;
        E();
        return objY;
    }

    public final int[] N() {
        int[] iArr = this.g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] O() {
        Object[] objArr = this.h;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object P() {
        Object obj = this.f;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] Q() {
        Object[] objArr = this.i;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void R(int i) {
        this.g = Arrays.copyOf(N(), i);
        this.h = Arrays.copyOf(O(), i);
        this.i = Arrays.copyOf(Q(), i);
    }

    public final void S(int i) {
        int iMin;
        int length = N().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        R(iMin);
    }

    public final int T(int i, int i2, int i3, int i4) {
        Object objA = px.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            px.i(objA, i3 & i5, i4 + 1);
        }
        Object objP = P();
        int[] iArrN = N();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = px.h(objP, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrN[i7];
                int iB = px.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = px.h(objA, i9);
                px.i(objA, i9, iH);
                iArrN[i7] = px.d(iB, iH2, i5);
                iH = px.c(i8, i);
            }
        }
        this.f = objA;
        V(i5);
        return i5;
    }

    public final void U(int i, int i2) {
        N()[i] = i2;
    }

    public final void V(int i) {
        this.j = px.d(this.j, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public final void W(int i, Object obj) {
        O()[i] = obj;
    }

    public final void X(int i, Object obj) {
        Q()[i] = obj;
    }

    public final Object Y(int i) {
        return Q()[i];
    }

    public Iterator Z() {
        Map mapY = y();
        return mapY != null ? mapY.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (L()) {
            return;
        }
        E();
        Map mapY = y();
        if (mapY != null) {
            this.j = ll1.g(size(), 3, 1073741823);
            mapY.clear();
            this.f = null;
            this.k = 0;
            return;
        }
        Arrays.fill(O(), 0, this.k, (Object) null);
        Arrays.fill(Q(), 0, this.k, (Object) null);
        px.g(P());
        Arrays.fill(N(), 0, this.k, 0);
        this.k = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map mapY = y();
        return mapY != null ? mapY.containsKey(obj) : F(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map mapY = y();
        if (mapY != null) {
            return mapY.containsValue(obj);
        }
        for (int i = 0; i < this.k; i++) {
            if (Objects.equals(obj, Y(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.m;
        if (set != null) {
            return set;
        }
        Set setT = t();
        this.m = setT;
        return setT;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map mapY = y();
        if (mapY != null) {
            return mapY.get(obj);
        }
        int iF = F(obj);
        if (iF == -1) {
            return null;
        }
        o(iF);
        return Y(iF);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.l;
        if (set != null) {
            return set;
        }
        Set setV = v();
        this.l = setV;
        return setV;
    }

    public void o(int i) {
    }

    public int p(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (L()) {
            q();
        }
        Map mapY = y();
        if (mapY != null) {
            return mapY.put(obj, obj2);
        }
        int[] iArrN = N();
        Object[] objArrO = O();
        Object[] objArrQ = Q();
        int i = this.k;
        int i2 = i + 1;
        int iC = uc1.c(obj);
        int iD = D();
        int i3 = iC & iD;
        int iH = px.h(P(), i3);
        if (iH != 0) {
            int iB = px.b(iC, iD);
            int i4 = 0;
            while (true) {
                int i5 = iH - 1;
                int i6 = iArrN[i5];
                if (px.b(i6, iD) == iB && Objects.equals(obj, objArrO[i5])) {
                    Object obj3 = objArrQ[i5];
                    objArrQ[i5] = obj2;
                    o(i5);
                    return obj3;
                }
                int iC2 = px.c(i6, iD);
                i4++;
                if (iC2 != 0) {
                    iH = iC2;
                } else {
                    if (i4 >= 9) {
                        return r().put(obj, obj2);
                    }
                    if (i2 > iD) {
                        iD = T(iD, px.e(iD), iC, i);
                    } else {
                        iArrN[i5] = px.d(i6, i2, iD);
                    }
                }
            }
        } else if (i2 > iD) {
            iD = T(iD, px.e(iD), iC, i);
        } else {
            px.i(P(), i3, i2);
        }
        int i7 = iD;
        S(i2);
        H(i, obj, obj2, iC, i7);
        this.k = i2;
        E();
        return null;
    }

    public int q() {
        gg3.w(L(), "Arrays already allocated");
        int i = this.j;
        int iJ = px.j(i);
        this.f = px.a(iJ);
        V(iJ - 1);
        this.g = new int[i];
        this.h = new Object[i];
        this.i = new Object[i];
        return i;
    }

    public Map r() {
        Map mapU = u(D() + 1);
        int iB = B();
        while (iB >= 0) {
            mapU.put(I(iB), Y(iB));
            iB = C(iB);
        }
        this.f = mapU;
        this.g = null;
        this.h = null;
        this.i = null;
        E();
        return mapU;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map mapY = y();
        if (mapY != null) {
            return mapY.remove(obj);
        }
        Object objM = M(obj);
        if (objM == o) {
            return null;
        }
        return objM;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map mapY = y();
        return mapY != null ? mapY.size() : this.k;
    }

    public Set t() {
        return new d(this, null);
    }

    public Map u(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public Set v() {
        return new f(this, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.n;
        if (collection != null) {
            return collection;
        }
        Collection collectionW = w();
        this.n = collectionW;
        return collectionW;
    }

    public Collection w() {
        return new h(this, null);
    }

    public Map y() {
        Object obj = this.f;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int z(int i) {
        return N()[i];
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d extends AbstractSet {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            nx.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map mapY = nx.this.y();
            if (mapY != null) {
                return mapY.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iF = nx.this.F(entry.getKey());
                if (iF != -1 && Objects.equals(nx.this.Y(iF), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return nx.this.A();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD;
            int iF;
            Map mapY = nx.this.y();
            if (mapY != null) {
                return mapY.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (nx.this.L() || (iF = px.f(entry.getKey(), entry.getValue(), (iD = nx.this.D()), nx.this.P(), nx.this.N(), nx.this.O(), nx.this.Q())) == -1) {
                return false;
            }
            nx.this.K(iF, iD);
            nx.g(nx.this);
            nx.this.E();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return nx.this.size();
        }

        public /* synthetic */ d(nx nxVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            nx.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return nx.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return nx.this.J();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapY = nx.this.y();
            return mapY != null ? mapY.keySet().remove(obj) : nx.this.M(obj) != nx.o;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return nx.this.size();
        }

        public /* synthetic */ f(nx nxVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class h extends AbstractCollection {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            nx.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return nx.this.Z();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return nx.this.size();
        }

        public /* synthetic */ h(nx nxVar, a aVar) {
            this();
        }
    }

    public nx(int i) {
        G(i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public abstract class e implements Iterator {
        public int f;
        public int g;
        public int h;

        public e() {
            this.f = nx.this.j;
            this.g = nx.this.B();
            this.h = -1;
        }

        public final void b() {
            if (nx.this.j != this.f) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object c(int i);

        public void d() {
            this.f += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.g >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            if (!hasNext()) {
                bo.a();
                return null;
            }
            int i = this.g;
            this.h = i;
            Object objC = c(i);
            this.g = nx.this.C(this.g);
            return objC;
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            jw.d(this.h >= 0);
            d();
            nx nxVar = nx.this;
            nxVar.remove(nxVar.I(this.h));
            this.g = nx.this.p(this.g, this.h);
            this.h = -1;
        }

        public /* synthetic */ e(nx nxVar, a aVar) {
            this();
        }
    }
}
