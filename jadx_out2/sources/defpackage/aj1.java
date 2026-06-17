package defpackage;

import defpackage.vi1;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aj1 extends wh implements Serializable {
    public final transient zi1 j;
    public final transient int k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends pw4 {
        public final Iterator f;
        public Object g = null;
        public Iterator h = lm1.f();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            this.f = aj1.this.j.entrySet().iterator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!this.h.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f.next();
                this.g = entry.getKey();
                this.h = ((vi1) entry.getValue()).iterator();
            }
            Object obj = this.g;
            Objects.requireNonNull(obj);
            return v42.g(obj, this.h.next());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.h.hasNext() || this.f.hasNext();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends pw4 {
        public final Iterator f;
        public Iterator g = lm1.f();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            this.f = aj1.this.j.values().iterator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.g.hasNext() || this.f.hasNext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public Object next() {
            if (!this.g.hasNext()) {
                this.g = ((vi1) this.f.next()).iterator();
            }
            return this.g.next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public Map a;
        public Comparator b;
        public Comparator c;
        public int d = 4;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public aj1 a() {
            Map map = this.a;
            if (map == null) {
                return yi1.w();
            }
            Collection collectionEntrySet = map.entrySet();
            Comparator comparator = this.b;
            if (comparator != null) {
                collectionEntrySet = x63.b(comparator).e().c(collectionEntrySet);
            }
            return yi1.u(collectionEntrySet, this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Map b() {
            Map map = this.a;
            if (map != null) {
                return map;
            }
            Map mapE = nb3.e();
            this.a = mapE;
            return mapE;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public vi1.b c(int i) {
            return xi1.n(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c d(Object obj, Object obj2) {
            jw.a(obj, obj2);
            vi1.b bVarC = (vi1.b) b().get(obj);
            if (bVarC == null) {
                bVarC = c(this.d);
                b().put(obj, bVarC);
            }
            bVarC.a(obj2);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends vi1 {
        public final aj1 g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(aj1 aj1Var) {
            this.g = aj1Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.g.c(entry.getKey(), entry.getValue());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: iterator()Ljava/util/Iterator; */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: j */
        public pw4 iterator() {
            return this.g.i();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.g.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends vi1 {
        public final transient aj1 g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(aj1 aj1Var) {
            this.g = aj1Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public int c(Object[] objArr, int i) {
            pw4 it = this.g.j.values().iterator();
            while (it.hasNext()) {
                i = ((vi1) it.next()).c(objArr, i);
            }
            return i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.g.d(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: iterator()Ljava/util/Iterator; */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* JADX INFO: renamed from: j */
        public pw4 iterator() {
            return this.g.k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.g.size();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public aj1(zi1 zi1Var, int i) {
        this.j = zi1Var;
        this.k = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0, defpackage.dw2
    public /* bridge */ /* synthetic */ boolean c(Object obj, Object obj2) {
        return super.c(obj, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dw2
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public boolean d(Object obj) {
        return obj != null && super.d(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public Map e() {
        throw new AssertionError("should never be called");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public Set g() {
        throw new AssertionError("unreachable");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b()Ljava/util/Map; */
    @Override // defpackage.q0, defpackage.dw2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public zi1 b() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f()Ljava/util/Collection; */
    @Override // defpackage.q0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public vi1 f() {
        return new d(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: h()Ljava/util/Collection; */
    @Override // defpackage.q0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public vi1 h() {
        return new e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a()Ljava/util/Collection; */
    @Override // defpackage.q0, defpackage.dw2
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public vi1 a() {
        return (vi1) super.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i()Ljava/util/Iterator; */
    @Override // defpackage.q0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public pw4 i() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dw2
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: keySet()Ljava/util/Set; */
    @Override // defpackage.q0, defpackage.dw2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public dj1 keySet() {
        return this.j.keySet();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: k()Ljava/util/Iterator; */
    @Override // defpackage.q0
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public pw4 k() {
        return new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0, defpackage.dw2
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: values()Ljava/util/Collection; */
    @Override // defpackage.q0, defpackage.dw2
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public vi1 values() {
        return (vi1) super.values();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dw2
    public int size() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
