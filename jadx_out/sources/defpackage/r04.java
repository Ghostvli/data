package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r04 {
    public static final int a = rk4.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
    public static final qj4 b = new qj4("PERMIT");
    public static final qj4 c = new qj4("TAKEN");
    public static final qj4 d = new qj4("BROKEN");
    public static final qj4 e = new qj4("CANCELLED");
    public static final int f = rk4.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final n04 a(int i, int i2) {
        return new q04(i, i2);
    }

    public static /* synthetic */ n04 b(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(i, i2);
    }

    public static final s04 j(long j, s04 s04Var) {
        return new s04(j, s04Var, 0);
    }
}
