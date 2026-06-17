package defpackage;

import defpackage.q0;
import defpackage.v42;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gw2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends j0 {
        public transient xi4 l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Map map, xi4 xi4Var) {
            super(map);
            this.l = (xi4) gg3.q(xi4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: s()Ljava/util/Collection; */
        @Override // defpackage.m0
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public List s() {
            return (List) this.l.get();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m0, defpackage.q0
        public Map e() {
            return u();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m0, defpackage.q0
        public Set g() {
            return v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b extends AbstractCollection {
        public abstract dw2 b();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().c(entry.getKey(), entry.getValue());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().remove(entry.getKey(), entry.getValue());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends d implements hu1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(hu1 hu1Var, v42.e eVar) {
            super(hu1Var, eVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: get(Ljava/lang/Object;)Ljava/util/Collection; */
        @Override // gw2.d, defpackage.dw2
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public List get(Object obj) {
            return m(obj, this.j.get(obj));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: m(Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection; */
        @Override // gw2.d
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public List m(final Object obj, Collection collection) {
            return ru1.i((List) collection, new p81() { // from class: hw2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj2) {
                    return this.f.k.a(obj, obj2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends q0 {
        public final dw2 j;
        public final v42.e k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(dw2 dw2Var, v42.e eVar) {
            this.j = (dw2) gg3.q(dw2Var);
            this.k = (v42.e) gg3.q(eVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dw2
        public void clear() {
            this.j.clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q0
        public Map e() {
            return v42.o(this.j.b(), new v42.e() { // from class: jw2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // v42.e
                public final Object a(Object obj, Object obj2) {
                    return this.a.m(obj, (Collection) obj2);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q0
        public Collection f() {
            return new q0.a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q0
        public Set g() {
            return this.j.keySet();
        }

        @Override // defpackage.dw2
        public abstract Collection get(Object obj);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q0
        public Collection h() {
            return mw.d(this.j.a(), new p81() { // from class: iw2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    Map.Entry entry = (Map.Entry) obj;
                    return this.f.k.a(entry.getKey(), entry.getValue());
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q0
        public Iterator i() {
            return lm1.u(this.j.a().iterator(), v42.c(this.k));
        }

        public abstract Collection m(Object obj, Collection collection);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dw2
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.q0, defpackage.dw2
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dw2
        public int size() {
            return this.j.size();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(dw2 dw2Var, Object obj) {
        if (obj == dw2Var) {
            return true;
        }
        if (obj instanceof dw2) {
            return dw2Var.b().equals(((dw2) obj).b());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hu1 c(Map map, xi4 xi4Var) {
        return new a(map, xi4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hu1 d(hu1 hu1Var, v42.e eVar) {
        return new c(hu1Var, eVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hu1 e(hu1 hu1Var, final p81 p81Var) {
        gg3.q(p81Var);
        return d(hu1Var, new v42.e() { // from class: fw2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // v42.e
            public final Object a(Object obj, Object obj2) {
                return p81Var.apply(obj2);
            }
        });
    }
}
