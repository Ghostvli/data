package defpackage;

import com.google.gson.JsonIOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k10 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0015: THROW 
      (wrap:com.google.gson.JsonIOException:0x0012: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r2v0 java.lang.String)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (wrap:java.lang.String:0x0007: INVOKE (r3v0 java.lang.Object) VIRTUAL call: java.lang.Object.toString():java.lang.String A[MD:():java.lang.String (c), WRAPPED] (LINE:8)))
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:15))
     A[MD:(java.lang.String):void (m), WRAPPED] (LINE:19) call: com.google.gson.JsonIOException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:22) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, Object obj) {
        throw new JsonIOException(str + ((Object) obj.toString()));
    }
}
