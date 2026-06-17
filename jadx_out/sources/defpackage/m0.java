package defpackage;

import defpackage.q0;
import defpackage.v42;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 extends q0 implements Serializable {
    public transient Map j;
    public transient int k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends d {
        public a() {
            super();
        }

        @Override // m0.d
        public Object b(Object obj, Object obj2) {
            return obj2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends d {
        public b() {
            super();
        }

        @Override // m0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(Object obj, Object obj2) {
            return v42.g(obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends v42.j {
        public final transient Map h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public final class a extends v42.d {
            public a() {
            }

            @Override // v42.d
            public Map b() {
                return c.this;
            }

            @Override // v42.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return mw.c(c.this.h.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return c.this.new b();
            }

            @Override // v42.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                m0.this.z(entry.getKey());
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public final class b implements Iterator {
            public final Iterator f;
            public Collection g;

            public b() {
                this.f = c.this.h.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f.next();
                this.g = (Collection) entry.getValue();
                return c.this.e(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                gg3.w(this.g != null, "no calls to next() since the last call to remove()");
                this.f.remove();
                m0.q(m0.this, this.g.size());
                this.g.clear();
                this.g = null;
            }
        }

        public c(Map map) {
            this.h = map;
        }

        @Override // v42.j
        public Set a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) v42.l(this.h, obj);
            if (collection == null) {
                return null;
            }
            return m0.this.B(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.h == m0.this.j) {
                m0.this.clear();
            } else {
                lm1.c(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return v42.k(this.h, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.h.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionS = m0.this.s();
            collectionS.addAll(collection);
            m0.q(m0.this, collection.size());
            collection.clear();
            return collectionS;
        }

        public Map.Entry e(Map.Entry entry) {
            Object key = entry.getKey();
            return v42.g(key, m0.this.B(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.h.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.h.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set g() {
            return m0.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.h.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.h.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public abstract class d implements Iterator {
        public final Iterator f;
        public Object g = null;
        public Collection h = null;
        public Iterator i = lm1.h();

        public d() {
            this.f = m0.this.j.entrySet().iterator();
        }

        public abstract Object b(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext() || this.i.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.i.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f.next();
                this.g = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.h = collection;
                this.i = collection.iterator();
            }
            return b(n43.a(this.g), this.i.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.i.remove();
            Collection collection = this.h;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f.remove();
            }
            m0.o(m0.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends v42.g {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Iterator {
            public Map.Entry f;
            public final /* synthetic */ Iterator g;
            public final /* synthetic */ e h;

            public a(e eVar, Iterator it) {
                this.g = it;
                this.h = eVar;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.g.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.g.next();
                this.f = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                gg3.w(this.f != null, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.f.getValue();
                this.g.remove();
                m0.q(m0.this, collection.size());
                collection.clear();
                this.f = null;
            }
        }

        public e(Map map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            lm1.c(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(this, b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) b().remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                m0.q(m0.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f extends i implements NavigableMap {
        public f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = h().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return e(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return h().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return m0.this.new f(h().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = h().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return e(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = h().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return e(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return h().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return m0.this.new f(h().headMap(obj, z));
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = h().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return e(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return h().higherKey(obj);
        }

        @Override // m0.i
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet f() {
            return m0.this.new g(h());
        }

        @Override // m0.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        public Map.Entry k(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionS = m0.this.s();
            collectionS.addAll((Collection) entry.getValue());
            it.remove();
            return v42.g(entry.getKey(), m0.this.A(collectionS));
        }

        @Override // m0.i, m0.c, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryLastEntry = h().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return e(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = h().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return e(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return h().lowerKey(obj);
        }

        @Override // m0.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap h() {
            return (NavigableMap) super.h();
        }

        @Override // m0.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return g();
        }

        @Override // m0.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return k(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return k(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return m0.this.new f(h().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return m0.this.new f(h().tailMap(obj, z));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g extends j implements NavigableSet {
        public g(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return c().ceilingKey(obj);
        }

        @Override // m0.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return m0.this.new g(c().descendingMap());
        }

        @Override // m0.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap c() {
            return (NavigableMap) super.c();
        }

        @Override // m0.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return c().floorKey(obj);
        }

        @Override // m0.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            return m0.this.new g(c().headMap(obj, z));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return c().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return c().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return lm1.q(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return lm1.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return m0.this.new g(c().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            return m0.this.new g(c().tailMap(obj, z));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class h extends l implements RandomAccess {
        public h(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i extends c implements SortedMap {
        public SortedSet j;

        public i(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return h().comparator();
        }

        public SortedSet f() {
            return m0.this.new j(h());
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return h().firstKey();
        }

        @Override // m0.c, java.util.AbstractMap, java.util.Map
        public SortedSet g() {
            SortedSet sortedSet = this.j;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetF = f();
            this.j = sortedSetF;
            return sortedSetF;
        }

        public SortedMap h() {
            return (SortedMap) this.h;
        }

        public SortedMap headMap(Object obj) {
            return m0.this.new i(h().headMap(obj));
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return h().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return m0.this.new i(h().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return m0.this.new i(h().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class j extends e implements SortedSet {
        public j(SortedMap sortedMap) {
            super(sortedMap);
        }

        public SortedMap c() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return c().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return m0.this.new j(c().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return c().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return m0.this.new j(c().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return m0.this.new j(c().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class m extends k implements Set {
        public m(Object obj, Set set) {
            super(obj, set, null);
        }

        @Override // m0.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zH = m24.h((Set) this.g, collection);
            if (zH) {
                m0.p(m0.this, this.g.size() - size);
                g();
            }
            return zH;
        }
    }

    public m0(Map map) {
        gg3.d(map.isEmpty());
        this.j = map;
    }

    public static /* synthetic */ int n(m0 m0Var) {
        int i2 = m0Var.k;
        m0Var.k = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int o(m0 m0Var) {
        int i2 = m0Var.k;
        m0Var.k = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int p(m0 m0Var, int i2) {
        int i3 = m0Var.k + i2;
        m0Var.k = i3;
        return i3;
    }

    public static /* synthetic */ int q(m0 m0Var, int i2) {
        int i3 = m0Var.k - i2;
        m0Var.k = i3;
        return i3;
    }

    public static Iterator x(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public abstract Collection A(Collection collection);

    public abstract Collection B(Object obj, Collection collection);

    public final List C(Object obj, List list, k kVar) {
        return list instanceof RandomAccess ? new h(obj, list, kVar) : new l(obj, list, kVar);
    }

    @Override // defpackage.q0, defpackage.dw2
    public Collection a() {
        return super.a();
    }

    @Override // defpackage.dw2
    public void clear() {
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.j.clear();
        this.k = 0;
    }

    @Override // defpackage.q0
    public Map e() {
        return new c(this.j);
    }

    @Override // defpackage.q0
    public Collection f() {
        return this instanceof j24 ? new q0.b() : new q0.a();
    }

    @Override // defpackage.q0
    public Set g() {
        return new e(this.j);
    }

    @Override // defpackage.dw2
    public Collection get(Object obj) {
        Collection collectionT = (Collection) this.j.get(obj);
        if (collectionT == null) {
            collectionT = t(obj);
        }
        return B(obj, collectionT);
    }

    @Override // defpackage.q0
    public Collection h() {
        return new q0.c();
    }

    @Override // defpackage.q0
    public Iterator i() {
        return new b();
    }

    @Override // defpackage.q0
    public Iterator k() {
        return new a();
    }

    @Override // defpackage.dw2
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.j.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.k++;
            return true;
        }
        Collection collectionT = t(obj);
        if (!collectionT.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.k++;
        this.j.put(obj, collectionT);
        return true;
    }

    public abstract Collection s();

    @Override // defpackage.dw2
    public int size() {
        return this.k;
    }

    public Collection t(Object obj) {
        return s();
    }

    public final Map u() {
        Map map = this.j;
        return map instanceof NavigableMap ? new f((NavigableMap) this.j) : map instanceof SortedMap ? new i((SortedMap) this.j) : new c(this.j);
    }

    public final Set v() {
        Map map = this.j;
        return map instanceof NavigableMap ? new g((NavigableMap) this.j) : map instanceof SortedMap ? new j((SortedMap) this.j) : new e(this.j);
    }

    @Override // defpackage.q0, defpackage.dw2
    public Collection values() {
        return super.values();
    }

    public abstract Collection w();

    public Collection y(Object obj) {
        Collection collection = (Collection) this.j.remove(obj);
        if (collection == null) {
            return w();
        }
        Collection collectionS = s();
        collectionS.addAll(collection);
        this.k -= collection.size();
        collection.clear();
        return A(collectionS);
    }

    public final void z(Object obj) {
        Collection collection = (Collection) v42.m(this.j, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.k -= size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class l extends k implements List {
        public l(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            f();
            boolean zIsEmpty = d().isEmpty();
            j().add(i, obj);
            m0.n(m0.this);
            if (zIsEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = j().addAll(i, collection);
            if (zAddAll) {
                m0.p(m0.this, d().size() - size);
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public Object get(int i) {
            f();
            return j().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            f();
            return j().indexOf(obj);
        }

        public List j() {
            return (List) d();
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            f();
            return j().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        public Object remove(int i) {
            f();
            Object objRemove = j().remove(i);
            m0.o(m0.this);
            g();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            f();
            return j().set(i, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [m0] */
        /* JADX WARN: Type inference failed for: r3v1, types: [m0$k] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.List
        public List subList(int i, int i2) {
            f();
            ?? r0 = m0.this;
            Object objE = e();
            List listSubList = j().subList(i, i2);
            k kVarC = c();
            ?? C = this;
            if (kVarC != null) {
                C = c();
            }
            return r0.C(objE, listSubList, C);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            f();
            return new a(i);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public final class a extends k.a implements ListIterator {
            public a(int i) {
                super(l.this.j().listIterator(i));
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = l.this.isEmpty();
                d().add(obj);
                m0.n(m0.this);
                if (zIsEmpty) {
                    l.this.b();
                }
            }

            public final ListIterator d() {
                return (ListIterator) b();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return d().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return d().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return d().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return d().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                d().set(obj);
            }

            public a() {
                super();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class k extends AbstractCollection {
        public final Object f;
        public Collection g;
        public final k h;
        public final Collection i;

        public k(Object obj, Collection collection, k kVar) {
            this.f = obj;
            this.g = collection;
            this.h = kVar;
            this.i = kVar == null ? null : kVar.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            f();
            boolean zIsEmpty = this.g.isEmpty();
            boolean zAdd = this.g.add(obj);
            if (zAdd) {
                m0.n(m0.this);
                if (zIsEmpty) {
                    b();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.g.addAll(collection);
            if (zAddAll) {
                m0.p(m0.this, this.g.size() - size);
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        public void b() {
            k kVar = this.h;
            if (kVar != null) {
                kVar.b();
            } else {
                m0.this.j.put(this.f, this.g);
            }
        }

        public k c() {
            return this.h;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.g.clear();
            m0.q(m0.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            f();
            return this.g.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            f();
            return this.g.containsAll(collection);
        }

        public Collection d() {
            return this.g;
        }

        public Object e() {
            return this.f;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.g.equals(obj);
        }

        public void f() {
            Collection collection;
            k kVar = this.h;
            if (kVar != null) {
                kVar.f();
                if (this.h.d() != this.i) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.g.isEmpty() || (collection = (Collection) m0.this.j.get(this.f)) == null) {
                    return;
                }
                this.g = collection;
            }
        }

        public void g() {
            k kVar = this.h;
            if (kVar != null) {
                kVar.g();
            } else if (this.g.isEmpty()) {
                m0.this.j.remove(this.f);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.g.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f();
            boolean zRemove = this.g.remove(obj);
            if (zRemove) {
                m0.o(m0.this);
                g();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.g.removeAll(collection);
            if (zRemoveAll) {
                m0.p(m0.this, this.g.size() - size);
                g();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            gg3.q(collection);
            int size = size();
            boolean zRetainAll = this.g.retainAll(collection);
            if (zRetainAll) {
                m0.p(m0.this, this.g.size() - size);
                g();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.g.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.g.toString();
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Iterator {
            public final Iterator f;
            public final Collection g;

            public a() {
                Collection collection = k.this.g;
                this.g = collection;
                this.f = m0.x(collection);
            }

            public Iterator b() {
                c();
                return this.f;
            }

            public void c() {
                k.this.f();
                if (k.this.g != this.g) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                c();
                return this.f.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                c();
                return this.f.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f.remove();
                m0.o(m0.this);
                k.this.g();
            }

            public a(Iterator it) {
                this.g = k.this.g;
                this.f = it;
            }
        }
    }
}
