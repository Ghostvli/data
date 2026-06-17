package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class a01 {
    public String a;
    public String b;
    public String c;
    public int d = -1;

    public a01(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a01)) {
            return false;
        }
        a01 a01Var = (a01) obj;
        return this.a.equals(a01Var.a) && this.b.equals(a01Var.b) && this.c.equals(a01Var.c);
    }

    public int hashCode() {
        if (this.d == -1) {
            this.d = (this.a.hashCode() ^ this.b.hashCode()) ^ this.c.hashCode();
        }
        return this.d;
    }
}
