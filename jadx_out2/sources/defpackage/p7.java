package defpackage;

import org.jupnp.binding.LocalServiceBindingException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p7 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001b: THROW 
      (wrap:org.jupnp.binding.LocalServiceBindingException:0x0018: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r2v0 java.lang.String)
      (r3v0 java.lang.Object)
      (r4v0 java.lang.Object)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (wrap:java.lang.String:0x0000: INVOKE (r1v0 java.lang.Object) STATIC call: java.lang.String.valueOf(java.lang.Object):java.lang.String A[MD:(java.lang.Object):java.lang.String (c), WRAPPED] (LINE:1)))
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:19))
     A[MD:(java.lang.String):void (m), WRAPPED] (LINE:25) call: org.jupnp.binding.LocalServiceBindingException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:28) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Object obj, String str, Object obj2, Object obj3) {
        throw new LocalServiceBindingException(str + obj2 + obj3 + ((Object) String.valueOf(obj)));
    }
}
