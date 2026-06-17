package defpackage;

import android.content.Context;
import android.os.RemoteException;
import androidx.media3.session.f;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h24 {
    public static int a(Context context, String str, int i) {
        if (str == null) {
            return 1;
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return 2;
        }
        for (String str2 : packagesForUid) {
            if (str2.equals(str)) {
                return 0;
            }
        }
        return 1;
    }

    public static void b(f fVar) {
        if (fVar != null) {
            try {
                fVar.a(0);
            } catch (RemoteException unused) {
            }
        }
    }
}
