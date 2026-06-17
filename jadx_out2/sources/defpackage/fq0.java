package defpackage;

import org.jupnp.model.message.header.InvalidHeaderException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class fq0 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0005: THROW 
      (wrap:org.jupnp.model.message.header.InvalidHeaderException:0x0002: CONSTRUCTOR (r1v0 java.lang.String) A[MD:(java.lang.String):void (m), WRAPPED] (LINE:3) call: org.jupnp.model.message.header.InvalidHeaderException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:6) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str) {
        throw new InvalidHeaderException(str);
    }
}
