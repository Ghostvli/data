package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class of {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001a: THROW 
      (wrap:java.lang.IllegalStateException:0x0017: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r2v0 java.lang.String)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (wrap:java.lang.String:0x0007: INVOKE (r3v0 p51) VIRTUAL call: p51.toString():java.lang.String A[MD:():java.lang.String (m), WRAPPED] (LINE:8)))
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (" is already attached to a FragmentManager."))
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:20))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:24) call: java.lang.IllegalStateException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:27) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, p51 p51Var) {
        throw new IllegalStateException(str + ((Object) p51Var.toString()) + ((Object) " is already attached to a FragmentManager."));
    }
}
