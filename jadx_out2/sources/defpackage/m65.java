package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class m65 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001b: ARITH (wrap:int:0x0015: ARITH (wrap:int:0x0014: ARITH (wrap:int:0x000e: ARITH (wrap:int:0x000d: ARITH (wrap:int:0x0007: ARITH (wrap:int:0x0006: ARITH (wrap:int:0x0000: ARITH (r0v0 int) * (31 int) A[WRAPPED] (LINE:1)) + (wrap:int:0x0002: INVOKE (r1v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:3)) A[WRAPPED] (LINE:7)) * (31 int) A[WRAPPED] (LINE:8)) + (wrap:int:0x0009: INVOKE (r2v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:10)) A[WRAPPED] (LINE:14)) * (31 int) A[WRAPPED] (LINE:15)) + (wrap:int:0x0010: INVOKE (r3v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:17)) A[WRAPPED] (LINE:21)) * (31 int) A[WRAPPED] (LINE:22)) + (wrap:int:0x0017: INVOKE (r4v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:24)) (LINE:28) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int a(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        return (((((((i * 31) + Objects.hashCode(obj)) * 31) + Objects.hashCode(obj2)) * 31) + Objects.hashCode(obj3)) * 31) + Objects.hashCode(obj4);
    }
}
