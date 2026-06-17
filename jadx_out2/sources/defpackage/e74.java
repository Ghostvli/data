package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class e74 extends e1 {
    public final rh4[] d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e74(Class cls, boolean z, rh4[] rh4VarArr) {
        super(cls, null, z);
        this.d = rh4VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh4
    public synchronized ph4[] a() throws Throwable {
        try {
            try {
                int length = this.d.length;
                ph4[] ph4VarArr = new ph4[length];
                int i = 0;
                while (i < length) {
                    rh4 rh4Var = this.d[i];
                    e74 e74Var = this;
                    ph4VarArr[i] = e74Var.d(rh4Var.a, rh4Var.c, rh4Var.b, rh4Var.d, rh4Var.e);
                    i++;
                    this = e74Var;
                }
                return ph4VarArr;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            e74 e74Var2 = this;
            Throwable th22 = th;
            throw th22;
        }
    }
}
