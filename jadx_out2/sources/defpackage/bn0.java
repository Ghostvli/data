package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bn0 {
    public final int a;
    public final int b;
    public final String c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bn0(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bn0 a(r73 r73Var) {
        String str;
        r73Var.g0(2);
        int iQ = r73Var.Q();
        int i = iQ >> 1;
        int iQ2 = ((r73Var.Q() >> 3) & 31) | ((iQ & 1) << 5);
        if (i == 4 || i == 5 || i == 7 || i == 8) {
            str = "dvhe";
        } else if (i == 9) {
            str = "dvav";
        } else {
            if (i != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i < 10 ? ".0" : ".");
        sb.append(i);
        sb.append(iQ2 < 10 ? ".0" : ".");
        sb.append(iQ2);
        return new bn0(i, iQ2, sb.toString());
    }
}
