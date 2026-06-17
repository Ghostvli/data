package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class xq {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0018: ARITH (wrap:int:0x0012: ARITH (wrap:int:0x0011: ARITH (wrap:int:0x000b: ARITH (wrap:int:0x000a: ARITH (wrap:int:0x0004: ARITH (wrap:int:0x0000: INVOKE (r0v0 long) STATIC call: java.lang.Long.hashCode(long):int A[MD:(long):int (c), WRAPPED] (LINE:1)) * (31 int) A[WRAPPED] (LINE:5)) + (wrap:int:0x0006: INVOKE (r2v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:7)) A[WRAPPED] (LINE:11)) * (31 int) A[WRAPPED] (LINE:12)) + (wrap:int:0x000d: INVOKE (r3v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:14)) A[WRAPPED] (LINE:18)) * (31 int) A[WRAPPED] (LINE:19)) + (wrap:int:0x0014: INVOKE (r4v0 java.lang.Object) STATIC call: java.util.Objects.hashCode(java.lang.Object):int A[MD:(java.lang.Object):int (c), WRAPPED] (LINE:21)) (LINE:25) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int a(long j, Object obj, Object obj2, Object obj3) {
        return (((((Long.hashCode(j) * 31) + Objects.hashCode(obj)) * 31) + Objects.hashCode(obj2)) * 31) + Objects.hashCode(obj3);
    }
}
