package defpackage;

import defpackage.f21;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c21 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public f21 a;

        public a(f21 f21Var) {
            this.a = f21Var;
        }
    }

    public static boolean a(jz0 jz0Var) {
        r73 r73Var = new r73(4);
        jz0Var.s(r73Var.f(), 0, 4);
        return r73Var.S() == 1716281667;
    }

    public static int b(jz0 jz0Var) throws r83 {
        jz0Var.p();
        r73 r73Var = new r73(2);
        jz0Var.s(r73Var.f(), 0, 2);
        int iY = r73Var.Y();
        if ((iY >> 2) == 16382) {
            jz0Var.p();
            return iY;
        }
        jz0Var.p();
        throw r83.a("First frame does not start with sync code.", null);
    }

    public static xs2 c(jz0 jz0Var, boolean z) throws Throwable {
        xs2 xs2VarA = new zh1().a(jz0Var, z ? null : xh1.b, 0);
        if (xs2VarA == null || xs2VarA.j() == 0) {
            return null;
        }
        return xs2VarA;
    }

    public static xs2 d(jz0 jz0Var, boolean z) throws Throwable {
        jz0Var.p();
        long jK = jz0Var.k();
        xs2 xs2VarC = c(jz0Var, z);
        jz0Var.q((int) (jz0Var.k() - jK));
        return xs2VarC;
    }

    public static boolean e(jz0 jz0Var, a aVar) {
        jz0Var.p();
        q73 q73Var = new q73(new byte[4]);
        jz0Var.s(q73Var.a, 0, 4);
        boolean zG = q73Var.g();
        int iH = q73Var.h(7);
        int iH2 = q73Var.h(24) + 4;
        if (iH == 0) {
            aVar.a = h(jz0Var);
            return zG;
        }
        f21 f21Var = aVar.a;
        if (f21Var == null) {
            d04.a();
            return false;
        }
        if (iH == 3) {
            aVar.a = f21Var.b(f(jz0Var, iH2));
            return zG;
        }
        if (iH == 4) {
            aVar.a = f21Var.c(j(jz0Var, iH2));
            return zG;
        }
        if (iH != 6) {
            jz0Var.q(iH2);
            return zG;
        }
        r73 r73Var = new r73(iH2);
        jz0Var.readFully(r73Var.f(), 0, iH2);
        r73Var.g0(4);
        aVar.a = f21Var.a(xi1.w(cb3.d(r73Var)));
        return zG;
    }

    public static f21.a f(jz0 jz0Var, int i) {
        r73 r73Var = new r73(i);
        jz0Var.readFully(r73Var.f(), 0, i);
        return g(r73Var);
    }

    public static f21.a g(r73 r73Var) {
        r73Var.g0(1);
        int iT = r73Var.T();
        long jG = ((long) r73Var.g()) + ((long) iT);
        int i = iT / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long J = r73Var.J();
            if (J == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = J;
            jArrCopyOf2[i2] = r73Var.J();
            r73Var.g0(2);
            i2++;
        }
        r73Var.g0((int) (jG - ((long) r73Var.g())));
        return new f21.a(jArrCopyOf, jArrCopyOf2);
    }

    public static f21 h(jz0 jz0Var) {
        byte[] bArr = new byte[38];
        jz0Var.readFully(bArr, 0, 38);
        return new f21(bArr, 4);
    }

    public static void i(jz0 jz0Var) throws r83 {
        r73 r73Var = new r73(4);
        jz0Var.readFully(r73Var.f(), 0, 4);
        if (r73Var.S() != 1716281667) {
            throw r83.a("Failed to read FLAC stream marker.", null);
        }
    }

    public static List j(jz0 jz0Var, int i) {
        r73 r73Var = new r73(i);
        jz0Var.readFully(r73Var.f(), 0, i);
        r73Var.g0(4);
        return Arrays.asList(d85.k(r73Var, false, false).b);
    }
}
