package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class sa3 {
    public u51 a;
    public p51 b;

    public sa3(u51 u51Var) {
        u51Var.getClass();
        this.a = u51Var;
    }

    public final oa3 a(List list) {
        int i;
        list.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i2 = Build.VERSION.SDK_INT;
        u51 u51Var = this.a;
        if (u51Var != null) {
            u51Var.getClass();
            i = u51Var.getApplicationInfo().targetSdkVersion;
        } else {
            p51 p51Var = this.b;
            p51Var.getClass();
            i = p51Var.Y1().getApplicationInfo().targetSdkVersion;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (ra3.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains("android.permission.ACCESS_BACKGROUND_LOCATION") && (i2 == 29 || (i2 == 30 && i < 30))) {
            linkedHashSet2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            linkedHashSet.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (linkedHashSet2.contains("android.permission.POST_NOTIFICATIONS") && i2 >= 33 && i >= 33) {
            linkedHashSet2.remove("android.permission.POST_NOTIFICATIONS");
            linkedHashSet.add("android.permission.POST_NOTIFICATIONS");
        }
        return new oa3(this.a, this.b, linkedHashSet, linkedHashSet2);
    }

    public final oa3 b(String... strArr) {
        strArr.getClass();
        return a(ow.m(Arrays.copyOf(strArr, strArr.length)));
    }

    public sa3(p51 p51Var) {
        p51Var.getClass();
        this.b = p51Var;
    }
}
