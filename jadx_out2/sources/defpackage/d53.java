package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d53 implements hz0 {
    public static final pz0 d = new pz0() { // from class: c53
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pz0
        public final hz0[] d() {
            return d53.g();
        }
    };
    public mz0 a;
    public ef4 b;
    public boolean c;

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: FILLED_NEW_ARRAY (wrap:d53:0x0002: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:3) call: d53.<init>():void type: CONSTRUCTOR) (LINE:7) elemType: hz0 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new d53()};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r73 h(r73 r73Var) {
        r73Var.f0(0);
        return r73Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        ef4 ef4Var = this.b;
        if (ef4Var != null) {
            ef4Var.m(j, j2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a = mz0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        gg3.q(this.a);
        if (this.b == null) {
            if (!i(jz0Var)) {
                throw r83.a("Failed to determine bitstream type", null);
            }
            jz0Var.p();
        }
        if (!this.c) {
            gr4 gr4VarE = this.a.e(0, 1);
            this.a.o();
            this.b.d(this.a, gr4VarE);
            this.c = true;
        }
        return this.b.g(jz0Var, yf3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        try {
            return i(jz0Var);
        } catch (r83 unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i(jz0 jz0Var) {
        g53 g53Var = new g53();
        if (g53Var.a(jz0Var, true) && (g53Var.b & 2) == 2) {
            int iMin = Math.min(g53Var.i, 8);
            r73 r73Var = new r73(iMin);
            jz0Var.s(r73Var.f(), 0, iMin);
            if (d21.p(h(r73Var))) {
                this.b = new d21();
            } else if (c85.r(h(r73Var))) {
                this.b = new c85();
            } else if (v63.o(h(r73Var))) {
                this.b = new v63();
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }
}
