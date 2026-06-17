package androidx.media3.exoplayer;

import defpackage.t41;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface p {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(o oVar);
    }

    static int B(int i) {
        return i & 24;
    }

    static int C(int i) {
        return u(i, 0, 0, 0);
    }

    static int J(int i) {
        return i & 3584;
    }

    static int O(int i) {
        return i & 7;
    }

    static int i(int i, int i2, int i3, int i4, int i5, int i6) {
        return i | i2 | i3 | i4 | i5 | i6;
    }

    static int k(int i) {
        return i & 384;
    }

    static boolean n(int i, boolean z) {
        int iO = O(i);
        if (iO != 4) {
            return z && iO == 3;
        }
        return true;
    }

    static int r(int i, int i2, int i3, int i4, int i5) {
        return i(i, i2, i3, i4, i5, 0);
    }

    static int s(int i) {
        return i & 64;
    }

    static int u(int i, int i2, int i3, int i4) {
        return i(i, i2, i3, 0, 128, i4);
    }

    static int v(int i) {
        return i & 32;
    }

    int E();

    int a(t41 t41Var);

    int d();

    String getName();

    void h();

    void y(a aVar);
}
