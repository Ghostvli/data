package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class zt0 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: ARITH (wrap:int:0x0000: ARITH (r0v0 int) * (31 int) A[WRAPPED] (LINE:1)) + (wrap:int:0x0002: INVOKE (r1v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:3)) (LINE:7) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int a(int i, Object obj) {
        return (i * 31) + Objects.hashCode(obj);
    }
}
