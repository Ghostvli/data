package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class wr extends vr {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: CONSTRUCTOR 
      (r1v0 z21)
      (wrap:g40:?: TERNARY null = ((wrap:int:0x0000: ARITH (r5v0 int) & (2 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (wrap:g40:0x0004: SGET  A[WRAPPED] (LINE:5) bs0.f bs0) : (r2v0 g40))
      (wrap:int:?: TERNARY null = ((wrap:int:0x0006: ARITH (r5v0 int) & (4 int) A[WRAPPED] (LINE:7)) != (0 int)) ? (-3 int) : (r3v0 int))
      (wrap:tl:?: TERNARY null = ((wrap:int:0x000b: ARITH (r5v0 int) & (8 int) A[WRAPPED] (LINE:12)) != (0 int)) ? (wrap:tl:0x000f: SGET  A[WRAPPED] (LINE:16) tl.f tl) : (r4v0 tl))
     A[MD:(z21, g40, int, tl):void (m)] (LINE:18) call: wr.<init>(z21, g40, int, tl):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ wr(z21 z21Var, g40 g40Var, int i, tl tlVar, int i2, we0 we0Var) {
        this(z21Var, (i2 & 2) != 0 ? bs0.f : g40Var, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? tl.f : tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tr
    public tr i(g40 g40Var, int i, tl tlVar) {
        return new wr(this.i, g40Var, i, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tr
    public z21 j() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vr
    public Object q(a31 a31Var, f30 f30Var) {
        Object objCollect = this.i.collect(a31Var, f30Var);
        return objCollect == kl1.e() ? objCollect : fw4.a;
    }

    public wr(z21 z21Var, g40 g40Var, int i, tl tlVar) {
        super(z21Var, g40Var, i, tlVar);
    }
}
