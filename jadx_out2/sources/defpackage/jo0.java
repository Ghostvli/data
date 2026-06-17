package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class jo0 implements hh1, mf3 {
    public jo0 c;
    public boolean d;
    public int b = 0;
    public int e = 0;
    public final ko0 a = new ko0();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mf3
    public boolean a() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mf3
    public void b(boolean z) {
        this.d = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh1
    public synchronized void c() {
        this.e--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh1
    public int d() {
        return this.a.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh1
    public void destroy() {
        ko0 ko0Var = this.a;
        if (ko0Var != null) {
            ko0Var.c();
        }
        this.b = 0;
        this.e = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh1
    public synchronized boolean e() {
        return this.e > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh1
    public int f() {
        return this.a.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(int i, int i2, int i3, boolean z, int i4) {
        this.a.a(i, i2, i3, z, i4);
        this.b = this.a.b.getRowBytes() * this.a.b.getHeight();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get()Ljava/lang/Object; */
    @Override // defpackage.hh1
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ko0 get() {
        ko0 ko0Var = this.a;
        if (ko0Var.b == null) {
            return null;
        }
        return ko0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: g()Ljava/lang/Object; */
    @Override // defpackage.mf3
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public jo0 g() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void l() {
        this.e++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: h(Ljava/lang/Object;)V */
    @Override // defpackage.mf3
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void h(jo0 jo0Var) {
        this.c = jo0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh1
    public int size() {
        return this.b;
    }
}
