package defpackage;

import android.util.Pair;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q85 {
    public static final byte[] a = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};
    public static final byte[] b = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a a(jz0 jz0Var, r73 r73Var) {
            jz0Var.s(r73Var.f(), 0, 8);
            r73Var.f0(0);
            return new a(r73Var.z(), r73Var.G());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a(jz0 jz0Var) {
        r73 r73Var = new r73(8);
        int i = a.a(jz0Var, r73Var).a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        jz0Var.s(r73Var.f(), 0, 4);
        r73Var.f0(0);
        int iZ = r73Var.z();
        if (iZ == 1463899717) {
            return true;
        }
        xz1.d("WavHeaderReader", "Unsupported form type: " + iZ);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static p85 b(jz0 jz0Var) throws r83 {
        byte[] bArr;
        r73 r73Var = new r73(16);
        a aVarD = d(1718449184, jz0Var, r73Var);
        gg3.v(aVarD.b >= 16);
        jz0Var.s(r73Var.f(), 0, 16);
        r73Var.f0(0);
        int I = r73Var.I();
        int I2 = r73Var.I();
        int iH = r73Var.H();
        int iH2 = r73Var.H();
        int I3 = r73Var.I();
        int I4 = r73Var.I();
        int i = ((int) aVarD.b) - 16;
        if (i > 0) {
            bArr = new byte[i];
            jz0Var.s(bArr, 0, i);
            if (I == 65534 && i == 24) {
                r73 r73Var2 = new r73(bArr);
                r73Var2.I();
                int I5 = r73Var2.I();
                if (I5 != 0 && I5 != I4) {
                    throw r83.e("validBits ( " + I5 + ")  != bitsPerSample( " + I4 + ") are not supported");
                }
                int iH3 = r73Var2.H();
                if ((iH3 >> 18) != 0) {
                    throw r83.e("invalid channel mask " + iH3);
                }
                if (iH3 != 0 && Integer.bitCount(iH3) != I2) {
                    throw r83.e("invalid number of channels (" + Integer.bitCount(iH3) + ") in channel mask " + iH3);
                }
                I = r73Var2.I();
                byte[] bArr2 = new byte[14];
                r73Var2.u(bArr2, 0, 14);
                if (!Arrays.equals(bArr2, a) && !Arrays.equals(bArr2, b)) {
                    throw r83.e("invalid wav format extension guid");
                }
            }
        } else {
            bArr = fy4.f;
        }
        byte[] bArr3 = bArr;
        int i2 = I;
        jz0Var.q((int) (jz0Var.k() - jz0Var.getPosition()));
        return new p85(i2, I2, iH, iH2, I3, I4, bArr3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long c(jz0 jz0Var) {
        r73 r73Var = new r73(8);
        a aVarA = a.a(jz0Var, r73Var);
        if (aVarA.a != 1685272116) {
            jz0Var.p();
            return -1L;
        }
        jz0Var.m(8);
        r73Var.f0(0);
        jz0Var.s(r73Var.f(), 0, 8);
        long jE = r73Var.E();
        jz0Var.q(((int) aVarA.b) + 8);
        return jE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a d(int i, jz0 jz0Var, r73 r73Var) throws r83 {
        a aVarA = a.a(jz0Var, r73Var);
        while (aVarA.a != i) {
            xz1.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.a);
            long j = aVarA.b;
            long j2 = 8 + j;
            if (j % 2 != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                throw r83.e("Chunk is too large (~2GB+) to skip; id: " + aVarA.a);
            }
            jz0Var.q((int) j2);
            aVarA = a.a(jz0Var, r73Var);
        }
        return aVarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair e(jz0 jz0Var) throws r83 {
        jz0Var.p();
        a aVarD = d(1684108385, jz0Var, new r73(8));
        jz0Var.q(8);
        return Pair.create(Long.valueOf(jz0Var.getPosition()), Long.valueOf(aVarD.b));
    }
}
