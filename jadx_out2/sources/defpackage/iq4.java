package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class iq4 {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final t41 g;
    public final int h;
    public final long[] i;
    public final long[] j;
    public final int k;
    public final yq4[] l;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iq4(int i, int i2, long j, long j2, long j3, long j4, t41 t41Var, int i3, yq4[] yq4VarArr, int i4, long[] jArr, long[] jArr2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = t41Var;
        this.h = i3;
        this.l = yq4VarArr;
        this.k = i4;
        this.i = jArr;
        this.j = jArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iq4 a(t41 t41Var) {
        return new iq4(this.a, this.b, this.c, this.d, this.e, this.f, t41Var, this.h, this.l, this.k, this.i, this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yq4 b(int i) {
        yq4[] yq4VarArr = this.l;
        if (yq4VarArr == null) {
            return null;
        }
        return yq4VarArr[i];
    }
}
