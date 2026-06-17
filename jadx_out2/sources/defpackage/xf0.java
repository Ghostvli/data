package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import defpackage.ki4;
import defpackage.t41;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xf0 implements pe1 {
    public static final int[] f = {8, 13, 11, 2, 0, 1, 7};
    public final int a;
    public ki4.a b;
    public boolean c;
    public int d;
    public final boolean e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xf0(int i, boolean z) {
        this.a = i;
        this.e = z;
        this.b = new qh0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(int i, List list) {
        if (ll1.j(f, i) == -1 || list.contains(Integer.valueOf(i))) {
            return;
        }
        list.add(Integer.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static q71 i(ki4.a aVar, boolean z, yo4 yo4Var, List list, int i) {
        int i2;
        if (z) {
            i2 = 4;
        } else {
            aVar = ki4.a.a;
            i2 = 36;
        }
        ki4.a aVar2 = aVar;
        int iK = i2 | q71.k(i);
        if (list == null) {
            list = xi1.u();
        }
        return new q71(aVar2, iK, yo4Var, null, list, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static vt4 j(int i, boolean z, t41 t41Var, List list, yo4 yo4Var, ki4.a aVar, boolean z2) {
        int i2;
        int i3 = i | 16;
        if (list != null) {
            i3 = i | 48;
        } else {
            list = z ? Collections.singletonList(new t41.b().A0("application/cea-608").Q()) : Collections.EMPTY_LIST;
        }
        String str = t41Var.k;
        if (!TextUtils.isEmpty(str)) {
            if (!nt2.b(str, "audio/mp4a-latm")) {
                i3 |= 2;
            }
            if (!nt2.b(str, "video/avc")) {
                i3 |= 4;
            }
        }
        if (z2) {
            i2 = 0;
        } else {
            aVar = ki4.a.a;
            i2 = 1;
        }
        return new vt4(2, i2, aVar, yo4Var, new wi0(i3, list), 112800);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean n(hz0 hz0Var, jz0 jz0Var) {
        try {
            boolean zE = hz0Var.e(jz0Var);
            jz0Var.p();
            return zE;
        } catch (EOFException unused) {
            jz0Var.p();
            return false;
        } catch (Throwable th) {
            jz0Var.p();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pe1
    public t41 d(t41 t41Var) {
        String str;
        if (!this.c || !this.b.a(t41Var)) {
            return t41Var;
        }
        t41.b bVarZ = t41Var.b().A0("application/x-media3-cues").Z(this.b.c(t41Var));
        StringBuilder sb = new StringBuilder();
        sb.append(t41Var.p);
        if (t41Var.k != null) {
            str = " " + t41Var.k;
        } else {
            str = "";
        }
        sb.append(str);
        return bVarZ.V(sb.toString()).E0(Long.MAX_VALUE).Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(Landroid/net/Uri;Lt41;Ljava/util/List;Lyo4;Ljava/util/Map;Ljz0;Lie3;)Lte1; */
    @Override // defpackage.pe1
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public rm e(Uri uri, t41 t41Var, List list, yo4 yo4Var, Map map, jz0 jz0Var, ie3 ie3Var) {
        int iA = s01.a(t41Var.p);
        int iB = s01.b(map);
        int iC = s01.c(uri);
        int[] iArr = f;
        ArrayList arrayList = new ArrayList(iArr.length);
        f(iA, arrayList);
        f(iB, arrayList);
        f(iC, arrayList);
        int i = 0;
        for (int i2 : iArr) {
            f(i2, arrayList);
        }
        jz0Var.p();
        hz0 hz0Var = null;
        while (i < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i)).intValue();
            ArrayList arrayList2 = arrayList;
            hz0 hz0Var2 = (hz0) gg3.q(h(iIntValue, t41Var, list, yo4Var));
            if (n(hz0Var2, jz0Var)) {
                return new rm(hz0Var2, t41Var, yo4Var, this.b, this.c);
            }
            if (hz0Var == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                hz0Var = hz0Var2;
            }
            i++;
            arrayList = arrayList2;
        }
        return new rm((hz0) gg3.q(hz0Var), t41Var, yo4Var, this.b, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final hz0 h(int i, t41 t41Var, List list, yo4 yo4Var) {
        if (i == 0) {
            return new j1();
        }
        if (i == 1) {
            return new n1();
        }
        if (i == 2) {
            return new d5();
        }
        if (i == 7) {
            return new pu2(0, 0L);
        }
        if (i == 8) {
            return i(this.b, this.c, yo4Var, list, this.d);
        }
        if (i == 11) {
            return j(this.a, this.e, t41Var, list, yo4Var, this.b, this.c);
        }
        if (i != 13) {
            return null;
        }
        return new d95(t41Var.d, yo4Var, this.b, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Z)Lpe1; */
    @Override // defpackage.pe1
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public xf0 b(boolean z) {
        this.c = z;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(I)Lpe1; */
    @Override // defpackage.pe1
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public xf0 c(int i) {
        this.d = i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Lki4$a;)Lpe1; */
    @Override // defpackage.pe1
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public xf0 a(ki4.a aVar) {
        this.b = aVar;
        return this;
    }

    public xf0() {
        this(0, true);
        this.d = 3;
    }
}
