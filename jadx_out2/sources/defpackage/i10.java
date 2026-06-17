package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class i10 {
    public int a;
    public int b;
    public long c;
    public String d;
    public String e;
    public int f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i10(int i, int i2, String str, String str2) {
        this.a = i;
        this.b = i2;
        this.d = str;
        this.e = str2;
        this.f = i ^ (i2 + (str.hashCode() * str2.hashCode()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof i10)) {
            return false;
        }
        i10 i10Var = (i10) obj;
        int i = this.a;
        if (i != i10Var.a) {
            return false;
        }
        if (i == 3 || i == 4) {
            return this.b == i10Var.b;
        }
        if (i == 5 || i == 6) {
            return this.c == i10Var.c;
        }
        if (i == 12) {
            return this.d.equals(i10Var.d) && this.e.equals(i10Var.e);
        }
        if (i == 18) {
            return this.b == i10Var.b && this.d.equals(i10Var.d) && this.e.equals(i10Var.e);
        }
        zt2.a("unsupported constant type");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.f;
    }
}
