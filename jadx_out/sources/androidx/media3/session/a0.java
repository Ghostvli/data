package androidx.media3.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.session.b0;
import androidx.media3.session.u;
import defpackage.b72;
import defpackage.c24;
import defpackage.cd3;
import defpackage.e24;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.hd3;
import defpackage.hg3;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {
    public static final b72.e a = new b72.e(MediaLibraryService.SERVICE_INTERFACE, null);

    public static boolean a(cd3 cd3Var, cd3 cd3Var2) {
        boolean z = cd3Var != null && cd3Var.E() == 7;
        boolean z2 = cd3Var2 != null && cd3Var2.E() == 7;
        return (z && z2) ? ((cd3) fy4.l(cd3Var)).x() == ((cd3) fy4.l(cd3Var2)).x() && TextUtils.equals(((cd3) fy4.l(cd3Var)).y(), ((cd3) fy4.l(cd3Var2)).y()) : z == z2;
    }

    public static boolean b(c24 c24Var, c24 c24Var2) {
        hd3.e eVar = c24Var.a;
        int i = eVar.c;
        hd3.e eVar2 = c24Var2.a;
        return i == eVar2.c && eVar.f == eVar2.f && eVar.i == eVar2.i && eVar.j == eVar2.j;
    }

    public static int c(long j, long j2) {
        if (j == -9223372036854775807L || j2 == -9223372036854775807L) {
            return 0;
        }
        if (j2 == 0) {
            return 100;
        }
        return fy4.s(fy4.n1(j, j2), 0, 100);
    }

    public static int[] d(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    public static long e(b0 b0Var, long j, long j2, long j3) {
        boolean z = b0Var.c.equals(c24.l) || j2 < b0Var.c.c;
        if (b0Var.x) {
            if (z || j == -9223372036854775807L) {
                if (j3 == -9223372036854775807L) {
                    j3 = SystemClock.elapsedRealtime() - b0Var.c.c;
                }
                c24 c24Var = b0Var.c;
                long j4 = c24Var.a.g + ((long) (j3 * b0Var.g.a));
                long j5 = c24Var.d;
                return j5 != -9223372036854775807L ? Math.min(j4, j5) : j4;
            }
        } else if (z || j == -9223372036854775807L) {
            return b0Var.c.a.g;
        }
        return j;
    }

    public static hd3.b f(hd3.b bVar, hd3.b bVar2) {
        if (bVar == null || bVar2 == null) {
            return hd3.b.b;
        }
        hd3.b.a aVar = new hd3.b.a();
        for (int i = 0; i < bVar.g(); i++) {
            if (bVar2.c(bVar.f(i))) {
                aVar.a(bVar.f(i));
            }
        }
        return aVar.f();
    }

    public static b0 g(b0 b0Var, b0 b0Var2, b0.c cVar, hd3.b bVar, boolean z, e24 e24Var) {
        b0 b0VarC;
        if (cVar.a && bVar.c(17)) {
            hg3.i(b0Var.j.w() || b0Var2.c.a.c < b0Var.j.v(), "Invalid PlayerInfo update, old index: " + b0Var.c.a.c + " (count=" + b0Var.j.v() + "), new index = " + b0Var2.c.a.c + ", sent from " + e24Var.e() + ", interface version=" + e24Var.d());
            b0VarC = b0Var2.v(b0Var.j);
        } else {
            b0VarC = b0Var2;
        }
        if (cVar.b && bVar.c(30)) {
            b0VarC = b0VarC.c(b0Var.F);
        }
        return (z && b0Var2.n == 0.0f) ? b0VarC.z(b0Var.o) : b0VarC;
    }

    public static List h(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static void i(hd3 hd3Var, u.i iVar) {
        if (iVar.b == -1) {
            boolean zIsCommandAvailable = hd3Var.isCommandAvailable(20);
            xi1 xi1Var = iVar.a;
            if (zIsCommandAvailable) {
                hd3Var.setMediaItems(xi1Var, true);
                return;
            } else {
                if (xi1Var.isEmpty()) {
                    return;
                }
                hd3Var.setMediaItem((fg2) iVar.a.get(0), true);
                return;
            }
        }
        boolean zIsCommandAvailable2 = hd3Var.isCommandAvailable(20);
        xi1 xi1Var2 = iVar.a;
        if (zIsCommandAvailable2) {
            hd3Var.setMediaItems(xi1Var2, iVar.b, iVar.c);
        } else {
            if (xi1Var2.isEmpty()) {
                return;
            }
            hd3Var.setMediaItem((fg2) iVar.a.get(0), iVar.c);
        }
    }

    public static List j(List list, int i) {
        ArrayList arrayList = new ArrayList();
        Parcel parcelObtain = Parcel.obtain();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                Parcelable parcelable = (Parcelable) list.get(i2);
                parcelObtain.writeParcelable(parcelable, 0);
                if (parcelObtain.dataSize() >= i) {
                    break;
                }
                arrayList.add(parcelable);
            } finally {
                parcelObtain.recycle();
            }
        }
        return arrayList;
    }
}
