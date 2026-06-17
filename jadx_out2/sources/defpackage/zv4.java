package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class zv4 extends ty3 {
    public final ThreadLocal j;
    private volatile boolean threadLocalIsSet;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Illegal instructions before constructor call */
    public zv4(g40 g40Var, f30 f30Var) {
        bw4 bw4Var = bw4.f;
        super(g40Var.a(bw4Var) == null ? g40Var.N(bw4Var) : g40Var, f30Var);
        this.j = new ThreadLocal();
        if (f30Var.getContext().a(h30.b) instanceof n40) {
            return;
        }
        Object objF = kn4.f(g40Var, null);
        kn4.d(g40Var, objF);
        T0(g40Var, objF);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ty3, defpackage.w
    public void O0(Object obj) {
        if (this.threadLocalIsSet) {
            i73 i73Var = (i73) this.j.get();
            if (i73Var != null) {
                kn4.d((g40) i73Var.a(), i73Var.b());
            }
            this.j.remove();
        }
        Object objA = cy.a(obj, this.i);
        f30 f30Var = this.i;
        g40 context = f30Var.getContext();
        Object objF = kn4.f(context, null);
        zv4 zv4VarJ = objF != kn4.a ? k40.j(f30Var, context, objF) : null;
        try {
            this.i.resumeWith(objA);
            fw4 fw4Var = fw4.a;
            if (zv4VarJ == null || zv4VarJ.S0()) {
                kn4.d(context, objF);
            }
        } catch (Throwable th) {
            if (zv4VarJ == null || zv4VarJ.S0()) {
                kn4.d(context, objF);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean S0() {
        boolean z = this.threadLocalIsSet && this.j.get() == null;
        this.j.remove();
        return !z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T0(g40 g40Var, Object obj) {
        this.threadLocalIsSet = true;
        this.j.set(fu4.a(g40Var, obj));
    }
}
