package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wx1 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0014: THROW 
      (wrap:java.lang.IllegalStateException:0x0011: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:14))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:18) call: java.lang.IllegalStateException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:21) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, Object obj, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }
}
