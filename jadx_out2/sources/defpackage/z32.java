package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z32 extends n40 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public n40 f0(int i, String str) {
        it1.a(i);
        return it1.b(this, str);
    }

    public abstract z32 h0();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String i0() {
        z32 z32VarH0;
        z32 z32VarC = mm0.c();
        if (this == z32VarC) {
            return "Dispatchers.Main";
        }
        try {
            z32VarH0 = z32VarC.h0();
        } catch (UnsupportedOperationException unused) {
            z32VarH0 = null;
        }
        if (this == z32VarH0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
