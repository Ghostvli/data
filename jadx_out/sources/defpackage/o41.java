package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o41 implements Comparable {
    public final int f;
    public final int g;
    public final String h;
    public final String i;

    public o41(int i, int i2, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.f = i;
        this.g = i2;
        this.h = str;
        this.i = str2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(o41 o41Var) {
        o41Var.getClass();
        int i = this.f - o41Var.f;
        return i == 0 ? this.g - o41Var.g : i;
    }

    public final String b() {
        return this.h;
    }

    public final int e() {
        return this.f;
    }

    public final String f() {
        return this.i;
    }
}
