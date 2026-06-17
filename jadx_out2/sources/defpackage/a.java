package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001b: THROW 
      (wrap:java.lang.IllegalArgumentException:0x0018: CONSTRUCTOR 
      (wrap:java.lang.String:0x0014: INVOKE 
      (wrap:java.lang.String:STR_CONCAT (r1v0 java.lang.String), (r2v0 long), (r4v0 java.lang.Object), (r5v0 long) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:15))
     VIRTUAL call: java.lang.Object.toString():java.lang.String A[MD:():java.lang.String (c), WRAPPED] (LINE:21))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:25) call: java.lang.IllegalArgumentException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:28) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, long j, Object obj, long j2) {
        throw new IllegalArgumentException((str + j + obj + j2).toString());
    }
}
