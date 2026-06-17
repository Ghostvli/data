package defpackage;

import com.google.gson.JsonSyntaxException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lu4 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0019: THROW 
      (wrap:com.google.gson.JsonSyntaxException:0x0016: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT ("Failed parsing '"), (r2v0 java.lang.Object), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:17))
      (r5v0 java.lang.Throwable)
     A[MD:(java.lang.String, java.lang.Throwable):void (m), WRAPPED] (LINE:23) call: com.google.gson.JsonSyntaxException.<init>(java.lang.String, java.lang.Throwable):void type: CONSTRUCTOR)
     (LINE:26) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Object obj, Object obj2, Object obj3, Throwable th) {
        throw new JsonSyntaxException("Failed parsing '" + obj + obj2 + obj3, th);
    }
}
