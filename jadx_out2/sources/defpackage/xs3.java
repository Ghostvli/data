package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class xs3 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0020: THROW 
      (wrap:java.io.IOException:0x001d: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      ("Content-Length (")
      (r3v0 long)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (") and stream length ("))
      (r5v0 int)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (") disagree"))
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:26))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:30) call: java.io.IOException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:33) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(long j, int i) throws IOException {
        throw new IOException("Content-Length (" + j + ((Object) ") and stream length (") + i + ((Object) ") disagree"));
    }
}
