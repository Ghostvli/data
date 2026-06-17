package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class o11 implements lf3 {
    public final of3 a;
    public final int b;
    public final boolean c;
    public mf3 d;
    public int e;

    public o11(of3 of3Var, int i) {
        if (i <= 0) {
            jl.a("The pool limit must be > 0");
            throw null;
        }
        this.a = of3Var;
        this.b = i;
        this.c = false;
    }

    @Override // defpackage.lf3
    public mf3 a() {
        mf3 mf3VarNewInstance = this.d;
        if (mf3VarNewInstance != null) {
            this.d = (mf3) mf3VarNewInstance.g();
            this.e--;
        } else {
            mf3VarNewInstance = this.a.newInstance();
        }
        if (mf3VarNewInstance != null) {
            mf3VarNewInstance.h(null);
            mf3VarNewInstance.b(false);
            this.a.a(mf3VarNewInstance);
        }
        return mf3VarNewInstance;
    }

    @Override // defpackage.lf3
    public void b(mf3 mf3Var) {
        if (mf3Var.a()) {
            System.out.print("[FinitePool] Element is already in pool: " + mf3Var);
            return;
        }
        if (this.c || this.e < this.b) {
            this.e++;
            mf3Var.h(this.d);
            mf3Var.b(true);
            this.d = mf3Var;
        }
        this.a.b(mf3Var);
    }
}
