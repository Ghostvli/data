package defpackage;

import defpackage.d50;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mw2 extends d50 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mw2(Map map) {
        map.getClass();
        b().putAll(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d50
    public Object a(d50.c cVar) {
        cVar.getClass();
        return b().get(cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(d50.c cVar, Object obj) {
        cVar.getClass();
        b().put(cVar, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public mw2() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mw2(d50 d50Var) {
        this(d50Var.b());
        d50Var.getClass();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
      (wrap:d50:?: TERNARY null = ((wrap:int:0x0000: ARITH (r2v0 int) & (1 int) A[WRAPPED]) != (0 int)) ? (wrap:d50:0x0004: SGET  A[WRAPPED] (LINE:17) d50.b.c d50$b) : (r1v0 d50))
     A[MD:(d50):void (m)] (LINE:17) call: mw2.<init>(d50):void type: THIS */
    public /* synthetic */ mw2(d50 d50Var, int i, we0 we0Var) {
        this((i & 1) != 0 ? d50.b.c : d50Var);
    }
}
