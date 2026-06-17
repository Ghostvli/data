package defpackage;

import defpackage.m24;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v42 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ps4 {
        public a(Iterator it) {
            super(it);
        }

        @Override // defpackage.ps4
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object b(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends o0 {
        public final /* synthetic */ Map.Entry f;
        public final /* synthetic */ e g;

        public b(Map.Entry entry, e eVar) {
            this.f = entry;
            this.g = eVar;
        }

        @Override // defpackage.o0, java.util.Map.Entry
        public Object getKey() {
            return this.f.getKey();
        }

        @Override // defpackage.o0, java.util.Map.Entry
        public Object getValue() {
            return this.g.a(this.f.getKey(), this.f.getValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class d extends m24.d {
        public abstract Map b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object objL = v42.l(b(), key);
                if (Objects.equals(objL, entry.getValue()) && (objL != null || b().containsKey(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return b().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // m24.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) gg3.q(collection));
            } catch (UnsupportedOperationException unused) {
                return m24.i(this, collection.iterator());
            }
        }

        @Override // m24.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) gg3.q(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = m24.f(collection.size());
                for (Object obj : collection) {
                    if (this.contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetF.add(((Map.Entry) obj).getKey());
                    }
                }
                return this.b().keySet().retainAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        Object a(Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f extends AbstractMap {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends d {
            public a() {
            }

            @Override // v42.d
            public Map b() {
                return f.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return f.this.a();
            }
        }

        public abstract Iterator a();

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends m24.d {
        public final Map f;

        public g(Map map) {
            this.f = (Map) gg3.q(map);
        }

        public Map b() {
            return this.f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends f {
        public final Map f;
        public final e g;

        public h(Map map, e eVar) {
            this.f = (Map) gg3.q(map);
            this.g = (e) gg3.q(eVar);
        }

        @Override // v42.f
        public Iterator a() {
            return lm1.u(this.f.entrySet().iterator(), v42.c(this.g));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f.get(obj);
            if (obj2 != null || this.f.containsKey(obj)) {
                return this.g.a(obj, n43.a(obj2));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (this.f.containsKey(obj)) {
                return this.g.a(obj, n43.a(this.f.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            return new i(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends AbstractCollection {
        public final Map f;

        public i(Map map) {
            this.f = (Map) gg3.q(map);
        }

        public final Map b() {
            return this.f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return b().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return v42.s(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : this.b().entrySet()) {
                    if (Objects.equals(obj, entry.getValue())) {
                        this.b().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) gg3.q(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.b().keySet().removeAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) gg3.q(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.b().keySet().retainAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class j extends AbstractMap {
        public transient Set f;
        public transient Collection g;

        public abstract Set a();

        public Collection b() {
            return new i(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.f = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.g;
            if (collection != null) {
                return collection;
            }
            Collection collectionB = b();
            this.g = collectionB;
            return collectionB;
        }
    }

    public static p81 c(final e eVar) {
        gg3.q(eVar);
        return new p81() { // from class: t42
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return v42.p(eVar, (Map.Entry) obj);
            }
        };
    }

    public static int d(int i2) {
        if (i2 < 3) {
            jw.b(i2, "expectedSize");
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) Math.ceil(((double) i2) / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean e(Map map, Object obj) {
        return lm1.d(s(map.entrySet().iterator()), obj);
    }

    public static boolean f(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static Map.Entry g(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public static p81 h() {
        return c.f;
    }

    public static HashMap i(int i2) {
        return new HashMap(d(i2));
    }

    public static IdentityHashMap j() {
        return new IdentityHashMap();
    }

    public static boolean k(Map map, Object obj) {
        gg3.q(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static Object l(Map map, Object obj) {
        gg3.q(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static Object m(Map map, Object obj) {
        gg3.q(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String n(Map map) {
        StringBuilder sbB = mw.b(map.size());
        sbB.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sbB.append(", ");
            }
            sbB.append(entry.getKey());
            sbB.append('=');
            sbB.append(entry.getValue());
            z = false;
        }
        sbB.append('}');
        return sbB.toString();
    }

    public static Map o(Map map, e eVar) {
        return new h(map, eVar);
    }

    public static Map.Entry p(e eVar, Map.Entry entry) {
        gg3.q(eVar);
        gg3.q(entry);
        return new b(entry, eVar);
    }

    public static Map q(Map map, final p81 p81Var) {
        gg3.q(p81Var);
        return o(map, new e() { // from class: s42
            @Override // v42.e
            public final Object a(Object obj, Object obj2) {
                return p81Var.apply(obj2);
            }
        });
    }

    public static p81 r() {
        return c.g;
    }

    public static Iterator s(Iterator it) {
        return new a(it);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c implements p81 {
        public static final c f = new a("KEY", 0);
        public static final c g = new b("VALUE", 1);
        public static final /* synthetic */ c[] h = a();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum a extends c {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // defpackage.p81
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum b extends c {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // defpackage.p81
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        public c(String str, int i) {
        }

        public static /* synthetic */ c[] a() {
            return new c[]{f, g};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) h.clone();
        }

        public /* synthetic */ c(String str, int i, u42 u42Var) {
            this(str, i);
        }
    }
}
