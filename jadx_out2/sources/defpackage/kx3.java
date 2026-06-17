package defpackage;

import android.os.Bundle;
import androidx.lifecycle.q;
import androidx.lifecycle.t;
import defpackage.qx3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kx3 implements qx3.b {
    public final qx3 a;
    public boolean b;
    public Bundle c;
    public final cs1 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kx3(qx3 qx3Var, final l45 l45Var) {
        qx3Var.getClass();
        l45Var.getClass();
        this.a = qx3Var;
        this.d = is1.b(new Function0() { // from class: jx3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return kx3.b(l45Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lx3 b(l45 l45Var) {
        return t.e(l45Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // qx3.b
    public Bundle a() {
        i73[] i73VarArr;
        Map mapH = y42.h();
        if (mapH.isEmpty()) {
            i73VarArr = new i73[0];
        } else {
            ArrayList arrayList = new ArrayList(mapH.size());
            for (Map.Entry entry : mapH.entrySet()) {
                arrayList.add(fu4.a((String) entry.getKey(), entry.getValue()));
            }
            i73VarArr = (i73[]) arrayList.toArray(new i73[0]);
        }
        Bundle bundleA = jm.a((i73[]) Arrays.copyOf(i73VarArr, i73VarArr.length));
        Bundle bundleA2 = xx3.a(bundleA);
        Bundle bundle = this.c;
        if (bundle != null) {
            xx3.b(bundleA2, bundle);
        }
        for (Map.Entry entry2 : d().e().entrySet()) {
            String str = (String) entry2.getKey();
            Bundle bundleA3 = ((q) entry2.getValue()).a().a();
            if (!nx3.f(nx3.a(bundleA3))) {
                xx3.c(bundleA2, str, bundleA3);
            }
        }
        this.b = false;
        return bundleA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bundle c(String str) {
        i73[] i73VarArr;
        str.getClass();
        e();
        Bundle bundle = this.c;
        if (bundle == null || !nx3.b(nx3.a(bundle), str)) {
            return null;
        }
        Bundle bundleD = nx3.d(nx3.a(bundle), str);
        if (bundleD == null) {
            Map mapH = y42.h();
            if (mapH.isEmpty()) {
                i73VarArr = new i73[0];
            } else {
                ArrayList arrayList = new ArrayList(mapH.size());
                for (Map.Entry entry : mapH.entrySet()) {
                    arrayList.add(fu4.a((String) entry.getKey(), entry.getValue()));
                }
                i73VarArr = (i73[]) arrayList.toArray(new i73[0]);
            }
            bundleD = jm.a((i73[]) Arrays.copyOf(i73VarArr, i73VarArr.length));
            xx3.a(bundleD);
        }
        xx3.e(xx3.a(bundle), str);
        if (nx3.f(nx3.a(bundle))) {
            this.c = null;
        }
        return bundleD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lx3 d() {
        return (lx3) this.d.getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        i73[] i73VarArr;
        if (this.b) {
            return;
        }
        Bundle bundleA = this.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Map mapH = y42.h();
        if (mapH.isEmpty()) {
            i73VarArr = new i73[0];
        } else {
            ArrayList arrayList = new ArrayList(mapH.size());
            for (Map.Entry entry : mapH.entrySet()) {
                arrayList.add(fu4.a((String) entry.getKey(), entry.getValue()));
            }
            i73VarArr = (i73[]) arrayList.toArray(new i73[0]);
        }
        Bundle bundleA2 = jm.a((i73[]) Arrays.copyOf(i73VarArr, i73VarArr.length));
        Bundle bundleA3 = xx3.a(bundleA2);
        Bundle bundle = this.c;
        if (bundle != null) {
            xx3.b(bundleA3, bundle);
        }
        if (bundleA != null) {
            xx3.b(bundleA3, bundleA);
        }
        this.c = bundleA2;
        this.b = true;
        d();
    }
}
