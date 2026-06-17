package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q02 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0017: THROW 
      (wrap:java.lang.IndexOutOfBoundsException:0x0014: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r1v0 java.lang.String), (r2v0 int), (r3v0 java.lang.Object), (r4v0 int) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:15))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:21) call: java.lang.IndexOutOfBoundsException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:24) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, int i, Object obj, int i2) {
        throw new IndexOutOfBoundsException(str + i + obj + i2);
    }
}
