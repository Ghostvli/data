package defpackage;

import org.jupnp.binding.LocalServiceBindingException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r7 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0017: THROW 
      (wrap:org.jupnp.binding.LocalServiceBindingException:0x0014: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r1v0 java.lang.String), (r2v0 java.lang.Object), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:15))
     A[MD:(java.lang.String):void (m), WRAPPED] (LINE:21) call: org.jupnp.binding.LocalServiceBindingException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:24) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, Object obj, Object obj2, Object obj3) {
        throw new LocalServiceBindingException(str + obj + obj2 + obj3);
    }
}
