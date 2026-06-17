package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tb implements s94 {
    public final int a;
    public final long b;
    public final int c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tb(int i, long j, int i2) {
        this.a = i;
        this.b = j;
        this.c = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "AtomSizeTooSmall{type=" + fy4.M1(this.a) + ", size=" + this.b + ", minHeaderSize=" + this.c + "}";
    }
}
