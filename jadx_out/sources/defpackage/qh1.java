package defpackage;

import android.os.Build;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qh1 {
    public static final dj1 a;

    static {
        a = Build.VERSION.SDK_INT < 32 ? dj1.z(12, 252, 6396, 4) : dj1.B(12, 252, 6396, 4, 3145980, 82172, 737532, 9126140, 33904892, 202070268, 744444, 67108860, 743676, 3152124, 88316, 81980, 205215996, 3890172);
    }

    public static int a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            if (a.contains(num)) {
                return iIntValue;
            }
        }
        return 0;
    }

    public static int b(ec ecVar) {
        int iA = a(ecVar.j());
        if (iA != 0) {
            return iA;
        }
        int iA2 = a(ecVar.k());
        if (iA2 != 0) {
            return iA2;
        }
        return 12;
    }
}
