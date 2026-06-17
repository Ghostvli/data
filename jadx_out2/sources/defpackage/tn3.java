package defpackage;

import org.jupnp.model.message.header.InvalidHeaderException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class tn3 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:org.jupnp.model.message.header.InvalidHeaderException:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r1v0 java.lang.String), (r2v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:9))
      (r3v0 java.lang.Throwable)
     A[MD:(java.lang.String, java.lang.Throwable):void (m), WRAPPED] (LINE:15) call: org.jupnp.model.message.header.InvalidHeaderException.<init>(java.lang.String, java.lang.Throwable):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, Object obj, Throwable th) {
        throw new InvalidHeaderException(str + obj, th);
    }
}
