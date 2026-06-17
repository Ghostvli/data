package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zo4 {
    public final SparseArray a = new SparseArray();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yo4 a(int i) {
        yo4 yo4Var = (yo4) this.a.get(i);
        if (yo4Var != null) {
            return yo4Var;
        }
        yo4 yo4Var2 = new yo4(9223372036854775806L);
        this.a.put(i, yo4Var2);
        return yo4Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a.clear();
    }
}
