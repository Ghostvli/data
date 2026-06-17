package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r14 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0009: THROW 
      (wrap:java.lang.IllegalStateException:0x0006: CONSTRUCTOR 
      (wrap:java.lang.String:0x0000: INVOKE (r0v0 java.lang.String), (r1v0 java.lang.Object[]) STATIC call: java.lang.String.format(java.lang.String, java.lang.Object[]):java.lang.String A[MD:(java.lang.String, java.lang.Object[]):java.lang.String VARARG (c), VARARG_CALL, WRAPPED] (LINE:1))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:7) call: java.lang.IllegalStateException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:10) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, Object[] objArr) {
        throw new IllegalStateException(String.format(str, objArr));
    }
}
