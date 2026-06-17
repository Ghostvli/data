package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yw3 implements Iterable {
    public c f;
    public c g;
    public final WeakHashMap h = new WeakHashMap();
    public int i = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yw3.e
        public c c(c cVar) {
            return cVar.i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yw3.e
        public c d(c cVar) {
            return cVar.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yw3.e
        public c c(c cVar) {
            return cVar.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yw3.e
        public c d(c cVar) {
            return cVar.i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements Map.Entry {
        public final Object f;
        public final Object g;
        public c h;
        public c i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Object obj, Object obj2) {
            this.f = obj;
            this.g = obj2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f.equals(cVar.f) && this.g.equals(cVar.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.g.hashCode() ^ this.f.hashCode();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.f + "=" + this.g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends f implements Iterator {
        public c f;
        public boolean g = true;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yw3.f
        public void b(c cVar) {
            c cVar2 = this.f;
            if (cVar == cVar2) {
                c cVar3 = cVar2.i;
                this.f = cVar3;
                this.g = cVar3 == null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.g) {
                this.g = false;
                this.f = yw3.this.f;
            } else {
                c cVar = this.f;
                this.f = cVar != null ? cVar.h : null;
            }
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.g) {
                return yw3.this.f != null;
            }
            c cVar = this.f;
            return (cVar == null || cVar.h == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class e extends f implements Iterator {
        public c f;
        public c g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(c cVar, c cVar2) {
            this.f = cVar2;
            this.g = cVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yw3.f
        public void b(c cVar) {
            if (this.f == cVar && cVar == this.g) {
                this.g = null;
                this.f = null;
            }
            c cVar2 = this.f;
            if (cVar2 == cVar) {
                this.f = c(cVar2);
            }
            if (this.g == cVar) {
                this.g = f();
            }
        }

        public abstract c c(c cVar);

        public abstract c d(c cVar);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.g;
            this.g = f();
            return cVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final c f() {
            c cVar = this.g;
            c cVar2 = this.f;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.g != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f {
        public abstract void b(c cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map.Entry b() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c c(Object obj) {
        c cVar = this.f;
        while (cVar != null && !cVar.f.equals(obj)) {
            cVar = cVar.h;
        }
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d d() {
        d dVar = new d();
        this.h.put(dVar, Boolean.FALSE);
        return dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Iterator descendingIterator() {
        b bVar = new b(this.g, this.f);
        this.h.put(bVar, Boolean.FALSE);
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map.Entry e() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yw3)) {
            return false;
        }
        yw3 yw3Var = (yw3) obj;
        if (size() != yw3Var.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = yw3Var.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c f(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.i++;
        c cVar2 = this.g;
        if (cVar2 == null) {
            this.f = cVar;
            this.g = cVar;
            return cVar;
        }
        cVar2.h = cVar;
        cVar.i = cVar2;
        this.g = cVar;
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object g(Object obj, Object obj2) {
        c cVarC = c(obj);
        if (cVarC != null) {
            return cVarC.g;
        }
        f(obj, obj2);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f, this.g);
        this.h.put(aVar, Boolean.FALSE);
        return aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object j(Object obj) {
        c cVarC = c(obj);
        if (cVarC == null) {
            return null;
        }
        this.i--;
        if (!this.h.isEmpty()) {
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(cVarC);
            }
        }
        c cVar = cVarC.i;
        c cVar2 = cVarC.h;
        if (cVar != null) {
            cVar.h = cVar2;
        } else {
            this.f = cVar2;
        }
        c cVar3 = cVarC.h;
        if (cVar3 != null) {
            cVar3.i = cVar;
        } else {
            this.g = cVar;
        }
        cVarC.h = null;
        cVarC.i = null;
        return cVarC.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
