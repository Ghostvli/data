package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w54 {
    public static final qj4 a = new qj4("NO_VALUE");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final pw2 a(int i, int i2, tl tlVar) {
        if (i < 0) {
            vx4.a("replay cannot be negative, but was ", i);
            return null;
        }
        if (i2 < 0) {
            vx4.a("extraBufferCapacity cannot be negative, but was ", i2);
            return null;
        }
        if (i <= 0 && i2 <= 0 && tlVar != tl.f) {
            zt.a("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", tlVar);
            return null;
        }
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
        }
        return new v54(i, i3, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ pw2 b(int i, int i2, tl tlVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            tlVar = tl.f;
        }
        return a(i, i2, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 e(u54 u54Var, g40 g40Var, int i, tl tlVar) {
        return ((i == 0 || i == -3) && tlVar == tl.f) ? u54Var : new wr(u54Var, g40Var, i, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object f(Object[] objArr, long j) {
        return objArr[((int) j) & (objArr.length - 1)];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void g(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }
}
