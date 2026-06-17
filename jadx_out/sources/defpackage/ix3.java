package defpackage;

import android.os.Bundle;
import defpackage.qx3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ix3 {
    public final Map a;
    public final Map b;
    public final Map c;
    public final Map d;
    public final qx3.b e;

    public ix3(Map map) {
        map.getClass();
        this.a = y42.s(map);
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new qx3.b() { // from class: hx3
            @Override // qx3.b
            public final Bundle a() {
                return ix3.a(this.a);
            }
        };
    }

    public static Bundle a(ix3 ix3Var) {
        i73[] i73VarArr;
        for (Map.Entry entry : y42.q(ix3Var.d).entrySet()) {
            ix3Var.c((String) entry.getKey(), ((qw2) entry.getValue()).getValue());
        }
        for (Map.Entry entry2 : y42.q(ix3Var.b).entrySet()) {
            ix3Var.c((String) entry2.getKey(), ((qx3.b) entry2.getValue()).a());
        }
        Map map = ix3Var.a;
        if (map.isEmpty()) {
            i73VarArr = new i73[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry3 : map.entrySet()) {
                arrayList.add(fu4.a((String) entry3.getKey(), entry3.getValue()));
            }
            i73VarArr = (i73[]) arrayList.toArray(new i73[0]);
        }
        Bundle bundleA = jm.a((i73[]) Arrays.copyOf(i73VarArr, i73VarArr.length));
        xx3.a(bundleA);
        return bundleA;
    }

    public final qx3.b b() {
        return this.e;
    }

    public final void c(String str, Object obj) {
        str.getClass();
        this.a.put(str, obj);
        qw2 qw2Var = (qw2) this.c.get(str);
        if (qw2Var != null) {
            qw2Var.setValue(obj);
        }
        qw2 qw2Var2 = (qw2) this.d.get(str);
        if (qw2Var2 != null) {
            qw2Var2.setValue(obj);
        }
    }

    public /* synthetic */ ix3(Map map, int i, we0 we0Var) {
        this((i & 1) != 0 ? y42.h() : map);
    }
}
