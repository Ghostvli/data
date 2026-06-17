package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class im {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001a: THROW 
      (wrap:java.lang.IllegalArgumentException:0x0017: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r2v0 java.lang.String)
      (r3v0 java.lang.Object)
      (r4v0 java.lang.Object)
      (r5v0 java.lang.Object)
      (wrap:char:?: CAST (char) (r6v0 int))
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:20))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:24) call: java.lang.IllegalArgumentException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:27) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(String str, Object obj, Object obj2, Object obj3, int i) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i));
    }
}
