package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ye5 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:java.io.IOException:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 int) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:11))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:15) call: java.io.IOException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, int i) throws IOException {
        throw new IOException(str + i);
    }
}
