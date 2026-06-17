package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class tg4 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001c: THROW 
      (wrap:java.lang.IndexOutOfBoundsException:0x0019: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r2v0 java.lang.String)
      (r3v0 int)
      (r4v0 java.lang.Object)
      (r5v0 int)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (")."))
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:22))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:26) call: java.lang.IndexOutOfBoundsException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:29) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, int i, Object obj, int i2) {
        throw new IndexOutOfBoundsException(str + i + obj + i2 + ((Object) ")."));
    }
}
