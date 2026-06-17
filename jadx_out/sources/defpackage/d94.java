package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d94 {
    public static final d94 c = new d94(-1, -1);
    public static final d94 d = new d94(0, 0);
    public static final String e = fy4.N0(0);
    public static final String f = fy4.N0(1);
    public final int a;
    public final int b;

    public d94(int i, int i2) {
        gg3.d((i == -1 || i >= 0) && (i2 == -1 || i2 >= 0));
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof d94) {
            d94 d94Var = (d94) obj;
            if (this.a == d94Var.a && this.b == d94Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.a;
        return ((i2 >>> 16) | (i2 << 16)) ^ i;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
