package defpackage;

import defpackage.jq2;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface jy0 extends ir4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        jy0[] a(a[] aVarArr, qg qgVar, jq2.b bVar, no4 no4Var);
    }

    boolean a(int i, long j);

    void b(long j, long j2, long j3, List list, w72[] w72VarArr);

    int d();

    void disable();

    void enable();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default boolean f(long j, pt ptVar, List list) {
        return false;
    }

    void g(boolean z);

    int j(long j, List list);

    int k();

    t41 l();

    int m();

    boolean n(int i, long j);

    void o(float f);

    Object p();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void q() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void r() {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final br4 a;
        public final int[] b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(br4 br4Var, int[] iArr, int i) {
            if (iArr.length == 0) {
                xz1.e("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.a = br4Var;
            this.b = iArr;
            this.c = i;
        }

        public a(br4 br4Var, int... iArr) {
            this(br4Var, iArr, 0);
        }
    }
}
