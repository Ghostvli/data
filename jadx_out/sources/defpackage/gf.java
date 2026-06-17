package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gf implements df {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public gf(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
    }

    public static gf c(r73 r73Var) {
        int iD = r73Var.D();
        r73Var.g0(12);
        int iD2 = r73Var.D();
        int iD3 = r73Var.D();
        int iD4 = r73Var.D();
        r73Var.g0(4);
        int iD5 = r73Var.D();
        int iD6 = r73Var.D();
        r73Var.g0(4);
        return new gf(iD, iD2, iD3, iD4, iD5, iD6, r73Var.D());
    }

    public long a() {
        return fy4.u1(this.e, ((long) this.c) * 1000000, this.d);
    }

    public int b() {
        int i = this.a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        xz1.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.a));
        return -1;
    }

    @Override // defpackage.df
    public int getType() {
        return 1752331379;
    }
}
