package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wp0 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long g(long j) {
        return tp0.b((j << 1) + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long h(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? g(xn3.g(j, -4611686018427387903L, 4611686018427387903L)) : i(k(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long i(long j) {
        return tp0.b(j << 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long j(long j) {
        return (-4611686018426999999L > j || j >= 4611686018427000000L) ? g(l(j)) : i(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long k(long j) {
        return j * 1000000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long l(long j) {
        return j / 1000000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long m(int i, xp0 xp0Var) {
        xp0Var.getClass();
        return xp0Var.compareTo(xp0.j) <= 0 ? i(yp0.b(i, xp0Var, xp0.g)) : n(i, xp0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long n(long j, xp0 xp0Var) {
        xp0Var.getClass();
        xp0 xp0Var2 = xp0.g;
        long jB = yp0.b(4611686018426999999L, xp0Var2, xp0Var);
        return ((-jB) > j || j > jB) ? g(xn3.g(yp0.a(j, xp0Var, xp0.i), -4611686018427387903L, 4611686018427387903L)) : i(yp0.b(j, xp0Var, xp0Var2));
    }
}
