package defpackage;

import defpackage.zi1;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ui1 extends zi1 implements Map {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends zi1.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a()Lzi1; */
        @Override // zi1.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ui1 a() {
            return d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: c()Lzi1; */
        @Override // zi1.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public ui1 c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: d()Lzi1; */
        @Override // zi1.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ui1 d() {
            int i = this.c;
            if (i == 0) {
                return ui1.r();
            }
            if (this.a != null) {
                if (this.d) {
                    this.b = Arrays.copyOf(this.b, i * 2);
                }
                zi1.a.k(this.b, this.c, this.a);
            }
            this.d = true;
            return new xp3(this.b, this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: g(Ljava/lang/Object;Ljava/lang/Object;)Lzi1$a; */
        @Override // zi1.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a g(Object obj, Object obj2) {
            super.g(obj, obj2);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: h(Ljava/util/Map$Entry;)Lzi1$a; */
        @Override // zi1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a h(Map.Entry entry) {
            super.h(entry);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: i(Ljava/lang/Iterable;)Lzi1$a; */
        @Override // zi1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a i(Iterable iterable) {
            super.i(iterable);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: j(Ljava/util/Map;)Lzi1$a; */
        @Override // zi1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a j(Map map) {
            super.j(map);
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a o() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ui1 r() {
        return xp3.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f()Lvi1; */
    @Override // defpackage.zi1
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final dj1 f() {
        throw new AssertionError("should never be called");
    }

    public abstract ui1 q();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: n()Lvi1; */
    /* JADX DEBUG: Method merged with bridge method: values()Ljava/util/Collection; */
    @Override // defpackage.zi1, java.util.Map
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public dj1 values() {
        return q().keySet();
    }
}
