package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ff implements df {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public ff(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static ff b(r73 r73Var) {
        int iD = r73Var.D();
        r73Var.g0(8);
        int iD2 = r73Var.D();
        int iD3 = r73Var.D();
        r73Var.g0(4);
        int iD4 = r73Var.D();
        r73Var.g0(12);
        return new ff(iD, iD2, iD3, iD4);
    }

    public boolean a() {
        return (this.b & 16) == 16;
    }

    @Override // defpackage.df
    public int getType() {
        return 1751742049;
    }
}
