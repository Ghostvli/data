package defpackage;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.e43;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g43 {
    public static final Object a = new Object();
    public static final Object b = new Object();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle a(e43.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.g() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle b(fq3 fq3Var) {
        new Bundle();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle[] c(fq3[] fq3VarArr) {
        if (fq3VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[fq3VarArr.length];
        for (int i = 0; i < fq3VarArr.length; i++) {
            fq3 fq3Var = fq3VarArr[i];
            bundleArr[i] = b(null);
        }
        return bundleArr;
    }
}
