package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zs0 implements yr3 {
    public final boolean f;
    public final boolean g;
    public final yr3 h;
    public final a i;
    public final wq1 j;
    public int k;
    public boolean l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(wq1 wq1Var, zs0 zs0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zs0(yr3 yr3Var, boolean z, boolean z2, wq1 wq1Var, a aVar) {
        this.h = (yr3) fg3.e(yr3Var);
        this.f = z;
        this.g = z2;
        this.j = wq1Var;
        this.i = (a) fg3.e(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void a() {
        if (this.l) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.k++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public synchronized void b() {
        if (this.k > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.l) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.l = true;
        if (this.g) {
            this.h.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public int c() {
        return this.h.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public Class d() {
        return this.h.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yr3 e() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        boolean z;
        synchronized (this) {
            int i = this.k;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.k = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.i.a(this.j, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public Object get() {
        return this.h.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f + ", listener=" + this.i + ", key=" + this.j + ", acquired=" + this.k + ", isRecycled=" + this.l + ", resource=" + this.h + '}';
    }
}
