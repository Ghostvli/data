package defpackage;

import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pa {
    public static final void a(na naVar, int i) {
        naVar.getClass();
        naVar.k(new int[i]);
        naVar.j(new Object[i]);
    }

    public static final int b(na naVar, int i) {
        naVar.getClass();
        try {
            return i20.a(naVar.d(), naVar.f(), i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(na naVar, Object obj, int i) {
        naVar.getClass();
        int iF = naVar.f();
        if (iF == 0) {
            return -1;
        }
        int iB = b(naVar, i);
        if (iB < 0 || il1.a(obj, naVar.c()[iB])) {
            return iB;
        }
        int i2 = iB + 1;
        while (i2 < iF && naVar.d()[i2] == i) {
            if (il1.a(obj, naVar.c()[i2])) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iB - 1; i3 >= 0 && naVar.d()[i3] == i; i3--) {
            if (il1.a(obj, naVar.c()[i3])) {
                return i3;
            }
        }
        return ~i2;
    }

    public static final int d(na naVar) {
        naVar.getClass();
        return c(naVar, null, 0);
    }
}
