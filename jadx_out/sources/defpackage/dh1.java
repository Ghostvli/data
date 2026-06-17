package defpackage;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface dh1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements Comparator {
        public boolean f;

        public a(boolean z) {
            b(z);
        }

        /* JADX INFO: renamed from: a */
        public int compare(ih ihVar, ih ihVar2) {
            if (this.f && d90.g(ihVar, ihVar2)) {
                return 0;
            }
            return d90.d(ihVar, ihVar2);
        }

        public void b(boolean z) {
            this.f = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public abstract int a(Object obj);

        public void b() {
        }

        public void c() {
        }

        public Object d() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c extends b {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends a {
        public d(boolean z) {
            super(z);
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ih ihVar, ih ihVar2) {
            return super.compare(ihVar, ihVar2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends a {
        public e(boolean z) {
            super(z);
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a */
        public int compare(ih ihVar, ih ihVar2) {
            if (this.f && d90.g(ihVar, ihVar2)) {
                return 0;
            }
            return Float.compare(ihVar.l(), ihVar2.l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends a {
        public f(boolean z) {
            super(z);
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a */
        public int compare(ih ihVar, ih ihVar2) {
            if (this.f && d90.g(ihVar, ihVar2)) {
                return 0;
            }
            return Float.compare(ihVar2.l(), ihVar.l());
        }
    }

    dh1 a(long j, long j2);

    boolean b(ih ihVar);

    boolean c(ih ihVar);

    void clear();

    dh1 d(long j, long j2);

    void e(b bVar);

    boolean f(ih ihVar);

    ih first();

    void g(b bVar);

    boolean isEmpty();

    ih last();

    int size();
}
