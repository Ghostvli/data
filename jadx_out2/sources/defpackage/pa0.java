package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class pa0 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0014: THROW 
      (wrap:s83:0x0011: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:14))
      (r5v0 java.lang.Throwable)
     A[MD:(java.lang.String, java.lang.Throwable):void (m), WRAPPED] (LINE:18) call: s83.<init>(java.lang.String, java.lang.Throwable):void type: CONSTRUCTOR)
     (LINE:21) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, Object obj, Object obj2, Throwable th) throws s83 {
        throw new s83(str + obj + obj2, th);
    }
}
