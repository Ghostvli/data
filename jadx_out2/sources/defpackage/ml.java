package defpackage;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ml {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0020: THROW 
      (wrap:java.io.EOFException:0x001d: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      ("\n not found: limit=")
      (r2v0 long)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (" content="))
      (r4v0 java.lang.Object)
      (8230 char)
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:24))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:30) call: java.io.EOFException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:33) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(long j, Object obj) throws EOFException {
        throw new EOFException("\\n not found: limit=" + j + ((Object) " content=") + obj + (char) 8230);
    }
}
