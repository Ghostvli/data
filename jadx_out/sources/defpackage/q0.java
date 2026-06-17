package defpackage;

import defpackage.gw2;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q0 implements dw2 {
    public transient Collection f;
    public transient Set g;
    public transient Collection h;
    public transient Map i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends gw2.b {
        public a() {
        }

        @Override // gw2.b
        public dw2 b() {
            return q0.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return q0.this.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends a implements Set {
        public b() {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return m24.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return m24.d(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c extends AbstractCollection {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            q0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return q0.this.d(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return q0.this.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return q0.this.size();
        }
    }

    @Override // defpackage.dw2
    public Collection a() {
        Collection collection = this.f;
        if (collection != null) {
            return collection;
        }
        Collection collectionF = f();
        this.f = collectionF;
        return collectionF;
    }

    @Override // defpackage.dw2
    public Map b() {
        Map map = this.i;
        if (map != null) {
            return map;
        }
        Map mapE = e();
        this.i = mapE;
        return mapE;
    }

    @Override // defpackage.dw2
    public boolean c(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean d(Object obj) {
        Iterator it = b().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map e();

    public boolean equals(Object obj) {
        return gw2.b(this, obj);
    }

    public abstract Collection f();

    public abstract Set g();

    public abstract Collection h();

    public int hashCode() {
        return b().hashCode();
    }

    public abstract Iterator i();

    public boolean j() {
        return size() == 0;
    }

    public Iterator k() {
        return v42.s(a().iterator());
    }

    @Override // defpackage.dw2
    public Set keySet() {
        Set set = this.g;
        if (set != null) {
            return set;
        }
        Set setG = g();
        this.g = setG;
        return setG;
    }

    @Override // defpackage.dw2
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return b().toString();
    }

    @Override // defpackage.dw2
    public Collection values() {
        Collection collection = this.h;
        if (collection != null) {
            return collection;
        }
        Collection collectionH = h();
        this.h = collectionH;
        return collectionH;
    }
}
