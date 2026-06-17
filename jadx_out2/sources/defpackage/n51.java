package defpackage;

import defpackage.p51;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n51 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0016: THROW 
      (wrap:p51$l:0x0013: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT ("Unable to instantiate fragment "), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:16))
      (r5v0 java.lang.Exception)
     A[MD:(java.lang.String, java.lang.Exception):void (m), WRAPPED] (LINE:20) call: p51.l.<init>(java.lang.String, java.lang.Exception):void type: CONSTRUCTOR)
     (LINE:23) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Object obj, Object obj2, Exception exc) {
        throw new p51.l("Unable to instantiate fragment " + obj + obj2, exc);
    }
}
