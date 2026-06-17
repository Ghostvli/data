package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nb4 {
    public static final Object a = new Object();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object c(mb4 mb4Var, int i) {
        Object obj;
        mb4Var.getClass();
        int iA = i20.a(mb4Var.g, mb4Var.i, i);
        if (iA < 0 || (obj = mb4Var.h[iA]) == a) {
            return null;
        }
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void d(mb4 mb4Var) {
        int i = mb4Var.i;
        int[] iArr = mb4Var.g;
        Object[] objArr = mb4Var.h;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        mb4Var.f = false;
        mb4Var.i = i2;
    }
}
