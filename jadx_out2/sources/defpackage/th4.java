package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class th4 extends v54 implements ce4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public th4(int i) {
        super(1, Integer.MAX_VALUE, tl.g);
        d(Integer.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Y(int i) {
        boolean zD;
        synchronized (this) {
            zD = d(Integer.valueOf(((Number) L()).intValue() + i));
        }
        return zD;
    }
}
