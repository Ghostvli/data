package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface nh1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(ih ihVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public boolean a;
        public int c;
        public int d;
        public ih e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public long m;
        public long n;
        public long o;
        public boolean p;
        public long q;
        public long r;
        public long s;
        public boolean u;
        public b90 b = new b90();
        public dh1 t = new e90(4);

        public int a(int i, int i2) {
            if (i == 1) {
                int i3 = this.f + i2;
                this.f = i3;
                return i3;
            }
            if (i == 4) {
                int i4 = this.i + i2;
                this.i = i4;
                return i4;
            }
            if (i == 5) {
                int i5 = this.h + i2;
                this.h = i5;
                return i5;
            }
            if (i == 6) {
                int i6 = this.g + i2;
                this.g = i6;
                return i6;
            }
            if (i != 7) {
                return 0;
            }
            int i7 = this.j + i2;
            this.j = i7;
            return i7;
        }

        public int b(int i) {
            int i2 = this.k + i;
            this.k = i2;
            return i2;
        }

        public void c(ih ihVar) {
            if (this.u) {
                return;
            }
            this.t.c(ihVar);
        }

        public dh1 d() {
            dh1 dh1Var;
            this.u = true;
            synchronized (this) {
                dh1Var = this.t;
                this.t = new e90(4);
            }
            this.u = false;
            return dh1Var;
        }

        public void e() {
            this.l = this.k;
            this.k = 0;
            this.j = 0;
            this.i = 0;
            this.h = 0;
            this.g = 0;
            this.f = 0;
            this.m = 0L;
            this.o = 0L;
            this.n = 0L;
            this.q = 0L;
            this.p = false;
            synchronized (this) {
                this.t.clear();
            }
        }

        public void f(b bVar) {
            if (bVar == null) {
                return;
            }
            this.l = bVar.l;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
        }
    }

    void a(boolean z);

    void b(a aVar);

    void c();

    void clear();

    void d(ah1 ah1Var);

    void e(fh1 fh1Var, dh1 dh1Var, long j, b bVar);

    void f(boolean z);

    void release();
}
