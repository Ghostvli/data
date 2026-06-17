package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b21 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public long a;
    }

    public static boolean a(r73 r73Var, f21 f21Var, int i, long j) {
        int iK = k(r73Var, i);
        long j2 = f21Var.j;
        return iK != -1 && (((j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 || ((j + ((long) iK)) > j2 ? 1 : ((j + ((long) iK)) == j2 ? 0 : -1)) >= 0) || iK >= f21Var.a) && iK <= f21Var.b;
    }

    public static boolean b(r73 r73Var, int i) {
        return r73Var.Q() == fy4.C(r73Var.f(), i, r73Var.g() - 1, 0);
    }

    public static boolean c(r73 r73Var, f21 f21Var, boolean z, a aVar) {
        try {
            long jZ = r73Var.Z();
            if (!z) {
                jZ *= (long) f21Var.b;
            }
            long j = f21Var.j;
            if (j != 0 && jZ > j) {
                return false;
            }
            aVar.a = jZ;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(r73 r73Var, f21 f21Var, int i, a aVar) {
        int iG = r73Var.g();
        long jS = r73Var.S();
        long j = jS >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) ((jS >> 4) & 15), f21Var) && f((int) ((jS >> 1) & 7), f21Var) && !(((jS & 1) > 1L ? 1 : ((jS & 1) == 1L ? 0 : -1)) == 0) && c(r73Var, f21Var, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(r73Var, f21Var, (int) ((jS >> 12) & 15), aVar.a) && e(r73Var, f21Var, (int) ((jS >> 8) & 15)) && b(r73Var, iG) && h(r73Var);
    }

    public static boolean e(r73 r73Var, f21 f21Var, int i) {
        int i2 = f21Var.e;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == f21Var.f;
        }
        if (i == 12) {
            return r73Var.Q() * 1000 == i2;
        }
        if (i <= 14) {
            int iY = r73Var.Y();
            if (i == 14) {
                iY *= 10;
            }
            if (iY == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(int i, f21 f21Var) {
        return i == 0 || i == f21Var.i;
    }

    public static boolean g(int i, f21 f21Var) {
        return i <= 7 ? i == f21Var.g - 1 : i <= 10 && f21Var.g == 2;
    }

    public static boolean h(r73 r73Var) {
        if (r73Var.a() == 0) {
            return true;
        }
        int iQ = r73Var.q();
        if ((iQ & 128) != 0) {
            return false;
        }
        int i = (iQ & 126) >> 1;
        if ((i < 2 || i > 7) && (i < 13 || i > 31)) {
            return true;
        }
        xz1.g("FlacFrameReader", "Ignoring frame where first subframe has a reserved type: " + i);
        return false;
    }

    public static boolean i(jz0 jz0Var, f21 f21Var, int i, a aVar) {
        long jK = jz0Var.k();
        r73 r73Var = new r73(17);
        jz0Var.s(r73Var.f(), 0, 2);
        if (r73Var.l() != i) {
            jz0Var.p();
            jz0Var.m((int) (jK - jz0Var.getPosition()));
            return false;
        }
        r73Var.e0(nz0.d(jz0Var, r73Var.f(), 2, 15) + 2);
        jz0Var.p();
        jz0Var.m((int) (jK - jz0Var.getPosition()));
        return d(r73Var, f21Var, i, aVar);
    }

    public static long j(jz0 jz0Var, f21 f21Var) throws r83 {
        jz0Var.p();
        jz0Var.m(1);
        byte[] bArr = new byte[1];
        jz0Var.s(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        jz0Var.m(2);
        int i = z ? 7 : 6;
        r73 r73Var = new r73(i);
        r73Var.e0(nz0.d(jz0Var, r73Var.f(), 0, i));
        jz0Var.p();
        a aVar = new a();
        if (c(r73Var, f21Var, z, aVar)) {
            return aVar.a;
        }
        throw r83.a(null, null);
    }

    public static int k(r73 r73Var, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return r73Var.Q() + 1;
            case 7:
                return r73Var.Y() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return Buffer.DEFAULT_SIZE << (i - 8);
            default:
                return -1;
        }
    }
}
