package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jh {
    public eh1 a;
    public b90 b;
    public int c;
    public int d;
    public float e;
    public float f;
    public dh1 g;
    public fh1 h;
    public t80 i;
    public a j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
    }

    public dh1 a() {
        dh1 dh1Var = this.g;
        if (dh1Var != null) {
            return dh1Var;
        }
        this.i.E.f();
        this.g = e();
        g();
        this.i.E.h();
        return this.g;
    }

    public b90 b() {
        return this.b;
    }

    public float c() {
        return 1.0f / (this.e - 0.6f);
    }

    public jh d(eh1 eh1Var) {
        this.a = eh1Var;
        return this;
    }

    public abstract dh1 e();

    public void f() {
        g();
    }

    public void g() {
        eh1 eh1Var = this.a;
        if (eh1Var != null) {
            eh1Var.release();
        }
        this.a = null;
    }

    public jh h(t80 t80Var) {
        this.i = t80Var;
        return this;
    }

    public jh i(fh1 fh1Var) {
        this.h = fh1Var;
        this.c = fh1Var.b();
        this.d = fh1Var.a();
        this.e = fh1Var.c();
        this.f = fh1Var.n();
        this.i.E.k(this.c, this.d, c());
        this.i.E.h();
        return this;
    }

    public jh j(a aVar) {
        this.j = aVar;
        return this;
    }

    public jh k(b90 b90Var) {
        this.b = b90Var;
        return this;
    }
}
