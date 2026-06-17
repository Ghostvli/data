package defpackage;

import android.text.TextUtils;
import defpackage.ki4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e95 implements ki4 {
    public final r73 a = new r73();
    public final y85 b = new y85();

    public static int d(r73 r73Var) {
        int i = -1;
        int iG = 0;
        while (i == -1) {
            iG = r73Var.g();
            String strB = r73Var.B();
            i = strB == null ? 0 : "STYLE".equals(strB) ? 2 : strB.startsWith("NOTE") ? 1 : 3;
        }
        r73Var.f0(iG);
        return i;
    }

    public static void e(r73 r73Var) {
        while (!TextUtils.isEmpty(r73Var.B())) {
        }
    }

    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        a95 a95VarN;
        this.a.d0(bArr, i2 + i);
        this.a.f0(i);
        ArrayList arrayList = new ArrayList();
        try {
            f95.e(this.a);
            while (!TextUtils.isEmpty(this.a.B())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iD = d(this.a);
                if (iD == 0) {
                    qs1.c(new h95(arrayList2), bVar, g20Var);
                    return;
                }
                if (iD == 1) {
                    e(this.a);
                } else if (iD == 2) {
                    if (!arrayList2.isEmpty()) {
                        jl.a("A style block was found after the first cue.");
                        return;
                    } else {
                        this.a.B();
                        arrayList.addAll(this.b.d(this.a));
                    }
                } else if (iD == 3 && (a95VarN = b95.n(this.a, arrayList)) != null) {
                    arrayList2.add(a95VarN);
                }
            }
        } catch (r83 e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // defpackage.ki4
    public int c() {
        return 1;
    }
}
