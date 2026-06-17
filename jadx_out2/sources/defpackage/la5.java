package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class la5 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0018: THROW 
      (wrap:java.lang.NumberFormatException:0x0015: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT ("val ["), (r3v0 java.lang.Object), (wrap:java.lang.Object:?: CAST (java.lang.Object) ("] is not a valid number.")) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:18))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:22) call: java.lang.NumberFormatException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:25) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Object obj) {
        throw new NumberFormatException("val [" + obj + ((Object) "] is not a valid number."));
    }
}
