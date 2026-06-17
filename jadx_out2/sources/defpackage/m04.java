package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m04 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static su0 a(String str) {
        return kj3.S(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static er0 b(su0 su0Var, br0 br0Var) {
        zy4.j(su0Var);
        zy4.j(br0Var);
        return zw.a(su0Var, br0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static er0 c(String str, br0 br0Var) {
        zy4.h(str);
        return b(a(str), br0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends IllegalStateException {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str, Object... objArr) {
            super(String.format(str, objArr));
        }

        public a(String str) {
            super(str);
        }
    }
}
