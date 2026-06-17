package defpackage;

import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fv2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int a;
        public long b;
        public int c;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final int a;
        public final int b;
        public final int c;
        public final byte[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, int i2, int i3, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = bArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i) throws r83 {
        if (i == 0) {
            return 768;
        }
        if (i == 1) {
            return 1024;
        }
        if (i == 2 || i == 3) {
            return 2048;
        }
        if (i == 4) {
            return Buffer.SEGMENTING_THRESHOLD;
        }
        throw r83.e("Unsupported coreSbrFrameLengthIndex " + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static double b(int i) throws r83 {
        switch (i) {
            case 14700:
            case 16000:
                return 3.0d;
            case 22050:
            case 24000:
                return 2.0d;
            case 29400:
            case 32000:
            case 58800:
            case 64000:
                return 1.5d;
            case 44100:
            case 48000:
            case 88200:
            case 96000:
                return 1.0d;
            default:
                throw r83.e("Unsupported sampling rate " + i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(int i) throws r83 {
        switch (i) {
            case 0:
                return 96000;
            case 1:
                return 88200;
            case 2:
                return 64000;
            case 3:
                return 48000;
            case 4:
                return 44100;
            case 5:
                return 32000;
            case 6:
                return 24000;
            case 7:
                return 22050;
            case 8:
                return 16000;
            case 9:
                return 12000;
            case 10:
                return 11025;
            case 11:
                return 8000;
            case 12:
                return 7350;
            case 13:
            case 14:
            default:
                throw r83.e("Unsupported sampling rate index " + i);
            case 15:
                return 57600;
            case 16:
                return 51200;
            case 17:
                return 40000;
            case 18:
                return 38400;
            case 19:
                return 34150;
            case 20:
                return 28800;
            case 21:
                return 25600;
            case 22:
                return 20000;
            case 23:
                return 19200;
            case 24:
                return 17075;
            case 25:
                return 14400;
            case 26:
                return 12800;
            case 27:
                return 9600;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i) throws r83 {
        if (i == 0 || i == 1) {
            return 0;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i == 4) {
                    return 1;
                }
                throw r83.e("Unsupported coreSbrFrameLengthIndex " + i);
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(int i) {
        return (i & 16777215) == 12583333;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(q73 q73Var) {
        if (!q73Var.g()) {
            return 0;
        }
        q73Var.r(2);
        return q73Var.h(13);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean g(q73 q73Var, b bVar) throws r83 {
        q73Var.d();
        int iK = k(q73Var, 3, 8, 8);
        bVar.a = iK;
        if (iK == -1) {
            return false;
        }
        long jL = l(q73Var, 2, 8, 32);
        bVar.b = jL;
        if (jL == -1) {
            return false;
        }
        if (jL > 16) {
            throw r83.e("Contains sub-stream with an invalid packet label " + bVar.b);
        }
        if (jL == 0) {
            int i = bVar.a;
            if (i == 1) {
                throw r83.a("Mpegh3daConfig packet with invalid packet label 0", null);
            }
            if (i == 2) {
                throw r83.a("Mpegh3daFrame packet with invalid packet label 0", null);
            }
            if (i == 17) {
                throw r83.a("AudioTruncation packet with invalid packet label 0", null);
            }
        }
        int iK2 = k(q73Var, 11, 24, 24);
        bVar.c = iK2;
        return iK2 != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c h(q73 q73Var) throws r83 {
        int iH = q73Var.h(8);
        int iH2 = q73Var.h(5);
        int iH3 = iH2 == 31 ? q73Var.h(24) : c(iH2);
        int iH4 = q73Var.h(3);
        int iA = a(iH4);
        int iD = d(iH4);
        q73Var.r(2);
        p(q73Var);
        m(q73Var, j(q73Var), iD);
        byte[] bArr = null;
        if (q73Var.g()) {
            int iK = k(q73Var, 2, 4, 8) + 1;
            for (int i = 0; i < iK; i++) {
                int iK2 = k(q73Var, 4, 8, 16);
                int iK3 = k(q73Var, 4, 8, 16);
                if (iK2 == 7) {
                    int iH5 = q73Var.h(4) + 1;
                    q73Var.r(4);
                    byte[] bArr2 = new byte[iH5];
                    for (int i2 = 0; i2 < iH5; i2++) {
                        bArr2[i2] = (byte) q73Var.h(8);
                    }
                    bArr = bArr2;
                } else {
                    q73Var.r(iK3 * 8);
                }
            }
        }
        byte[] bArr3 = bArr;
        double dB = b(iH3);
        return new c(iH, (int) (((double) iH3) * dB), (int) (((double) iA) * dB), bArr3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(q73 q73Var) {
        q73Var.r(3);
        boolean zG = q73Var.g();
        if (zG) {
            q73Var.r(13);
        }
        return zG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(q73 q73Var) {
        int iH = q73Var.h(5);
        int iK = 0;
        for (int i = 0; i < iH + 1; i++) {
            int iH2 = q73Var.h(3);
            iK += k(q73Var, 5, 8, 16) + 1;
            if ((iH2 == 0 || iH2 == 2) && q73Var.g()) {
                p(q73Var);
            }
        }
        return iK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(q73 q73Var, int i, int i2, int i3) {
        gg3.d(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        pk1.a(pk1.a(i4, i5), 1 << i3);
        if (q73Var.b() < i) {
            return -1;
        }
        int iH = q73Var.h(i);
        if (iH != i4) {
            return iH;
        }
        if (q73Var.b() < i2) {
            return -1;
        }
        int iH2 = q73Var.h(i2);
        int i6 = iH + iH2;
        if (iH2 != i5) {
            return i6;
        }
        if (q73Var.b() < i3) {
            return -1;
        }
        return i6 + q73Var.h(i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long l(q73 q73Var, int i, int i2, int i3) {
        gg3.d(Math.max(Math.max(i, i2), i3) <= 63);
        long j = (1 << i) - 1;
        long j2 = (1 << i2) - 1;
        v02.a(v02.a(j, j2), 1 << i3);
        if (q73Var.b() < i) {
            return -1L;
        }
        long j3 = q73Var.j(i);
        if (j3 != j) {
            return j3;
        }
        if (q73Var.b() < i2) {
            return -1L;
        }
        long j4 = q73Var.j(i2);
        long j5 = j3 + j4;
        if (j4 != j2) {
            return j5;
        }
        if (q73Var.b() < i3) {
            return -1L;
        }
        return j5 + q73Var.j(i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(q73 q73Var, int i, int i2) {
        int iH;
        int iK = k(q73Var, 4, 8, 16) + 1;
        q73Var.q();
        for (int i3 = 0; i3 < iK; i3++) {
            int iH2 = q73Var.h(2);
            if (iH2 == 0) {
                i(q73Var);
                if (i2 > 0) {
                    o(q73Var);
                }
            } else if (iH2 == 1) {
                if (i(q73Var)) {
                    q73Var.q();
                }
                if (i2 > 0) {
                    o(q73Var);
                    iH = q73Var.h(2);
                } else {
                    iH = 0;
                }
                if (iH > 0) {
                    q73Var.r(6);
                    int iH3 = q73Var.h(2);
                    q73Var.r(4);
                    if (q73Var.g()) {
                        q73Var.r(5);
                    }
                    if (iH == 2 || iH == 3) {
                        q73Var.r(6);
                    }
                    if (iH3 == 2) {
                        q73Var.q();
                    }
                }
                int iFloor = ((int) Math.floor(Math.log(i - 1) / Math.log(2.0d))) + 1;
                int iH4 = q73Var.h(2);
                if (iH4 > 0 && q73Var.g()) {
                    q73Var.r(iFloor);
                }
                if (q73Var.g()) {
                    q73Var.r(iFloor);
                }
                if (i2 == 0 && iH4 == 0) {
                    q73Var.q();
                }
            } else if (iH2 == 3) {
                k(q73Var, 4, 8, 16);
                int iK2 = k(q73Var, 4, 8, 16);
                if (q73Var.g()) {
                    k(q73Var, 8, 16, 0);
                }
                q73Var.q();
                if (iK2 > 0) {
                    q73Var.r(iK2 * 8);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void n(q73 q73Var, int i) {
        int iH;
        boolean zG = q73Var.g();
        int i2 = zG ? 1 : 5;
        int i3 = zG ? 7 : 5;
        int i4 = zG ? 8 : 6;
        int i5 = 0;
        while (i5 < i) {
            if (q73Var.g()) {
                q73Var.r(7);
                iH = 0;
            } else {
                if (q73Var.h(2) == 3 && q73Var.h(i3) * i2 != 0) {
                    q73Var.q();
                }
                iH = q73Var.h(i4) * i2;
                if (iH != 0 && iH != 180) {
                    q73Var.q();
                }
                q73Var.q();
            }
            if (iH != 0 && iH != 180 && q73Var.g()) {
                i5++;
            }
            i5++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void o(q73 q73Var) {
        q73Var.r(3);
        q73Var.r(8);
        boolean zG = q73Var.g();
        boolean zG2 = q73Var.g();
        if (zG) {
            q73Var.r(5);
        }
        if (zG2) {
            q73Var.r(6);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void p(q73 q73Var) {
        int iH = q73Var.h(2);
        if (iH == 0) {
            q73Var.r(6);
            return;
        }
        int iK = k(q73Var, 5, 8, 16) + 1;
        if (iH == 1) {
            q73Var.r(iK * 7);
        } else if (iH == 2) {
            n(q73Var, iK);
        }
    }
}
