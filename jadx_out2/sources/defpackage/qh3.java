package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qh3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int a(int i, int i2, int i3) {
        return c(c(i, i3) - c(i2, i3), i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int b(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                return i2 - a(i2, i, i3);
            }
        } else {
            if (i3 >= 0) {
                jl.a("Step is zero.");
                return 0;
            }
            if (i > i2) {
                return i2 + a(i, i2, -i3);
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int c(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }
}
