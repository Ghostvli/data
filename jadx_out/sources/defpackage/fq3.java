package defpackage;

import android.app.RemoteInput;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fq3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static RemoteInput a(fq3 fq3Var) {
            throw null;
        }
    }

    public static RemoteInput a(fq3 fq3Var) {
        return a.a(fq3Var);
    }

    public static RemoteInput[] b(fq3[] fq3VarArr) {
        if (fq3VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[fq3VarArr.length];
        for (int i = 0; i < fq3VarArr.length; i++) {
            fq3 fq3Var = fq3VarArr[i];
            remoteInputArr[i] = a(null);
        }
        return remoteInputArr;
    }
}
