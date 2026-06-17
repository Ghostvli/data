package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class tg {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001d: THROW 
      (wrap:java.lang.IndexOutOfBoundsException:0x001a: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 int), (r4v0 java.lang.Object), (r5v0 int), (r6v0 java.lang.Object), (r7v0 int) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:23))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:27) call: java.lang.IndexOutOfBoundsException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:30) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, int i, Object obj, int i2, Object obj2, int i3) {
        throw new IndexOutOfBoundsException(str + i + obj + i2 + obj2 + i3);
    }
}
