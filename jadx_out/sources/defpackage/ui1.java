package defpackage;

import defpackage.zi1;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ui1 extends zi1 implements Map {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends zi1.a {
        @Override // zi1.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ui1 a() {
            return d();
        }

        @Override // zi1.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public ui1 c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

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

        @Override // zi1.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a g(Object obj, Object obj2) {
            super.g(obj, obj2);
            return this;
        }

        @Override // zi1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a h(Map.Entry entry) {
            super.h(entry);
            return this;
        }

        @Override // zi1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a i(Iterable iterable) {
            super.i(iterable);
            return this;
        }

        @Override // zi1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a j(Map map) {
            super.j(map);
            return this;
        }
    }

    public static a o() {
        return new a();
    }

    public static ui1 r() {
        return xp3.o;
    }

    @Override // defpackage.zi1
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final dj1 f() {
        throw new AssertionError("should never be called");
    }

    public abstract ui1 q();

    @Override // defpackage.zi1, java.util.Map
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public dj1 values() {
        return q().keySet();
    }
}
