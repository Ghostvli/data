package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class yu0 extends n40 {
    public long h;
    public boolean i;
    public ia j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void i0(yu0 yu0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: decrementUseCount");
            return;
        }
        if ((i & 1) != 0) {
            z = false;
        }
        yu0Var.h0(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void n0(yu0 yu0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: incrementUseCount");
            return;
        }
        if ((i & 1) != 0) {
            z = false;
        }
        yu0Var.m0(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public final n40 f0(int i, String str) {
        it1.a(i);
        return it1.b(this, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h0(boolean z) {
        long jJ0 = this.h - j0(z);
        this.h = jJ0;
        if (jJ0 <= 0 && this.i) {
            shutdown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long j0(boolean z) {
        return z ? 4294967296L : 1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k0(jm0 jm0Var) {
        ia iaVar = this.j;
        if (iaVar == null) {
            iaVar = new ia();
            this.j = iaVar;
        }
        iaVar.addLast(jm0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long l0() {
        ia iaVar = this.j;
        return (iaVar == null || iaVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m0(boolean z) {
        this.h += j0(z);
        if (z) {
            return;
        }
        this.i = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o0() {
        return this.h >= j0(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p0() {
        ia iaVar = this.j;
        if (iaVar != null) {
            return iaVar.isEmpty();
        }
        return true;
    }

    public abstract long q0();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean r0() {
        jm0 jm0Var;
        ia iaVar = this.j;
        if (iaVar == null || (jm0Var = (jm0) iaVar.p()) == null) {
            return false;
        }
        jm0Var.run();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s0() {
        return false;
    }

    public abstract void shutdown();
}
