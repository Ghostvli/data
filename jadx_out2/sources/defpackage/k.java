package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static final int[] a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    public static final int[] b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final int b;
        public final String c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] a(int i, int i2) {
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int[] iArr = a;
            if (i5 >= iArr.length) {
                break;
            }
            if (i == iArr[i5]) {
                i4 = i5;
            }
            i5++;
        }
        int i6 = -1;
        while (true) {
            int[] iArr2 = b;
            if (i3 >= iArr2.length) {
                break;
            }
            if (i2 == iArr2[i3]) {
                i6 = i3;
            }
            i3++;
        }
        if (i != -1 && i6 != -1) {
            return b(2, i4, i6);
        }
        j.a("Invalid sample rate or number of channels: ", i, ", ", i2);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] b(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(q73 q73Var) {
        int iH = q73Var.h(5);
        return iH == 31 ? q73Var.h(6) + 32 : iH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(q73 q73Var) throws r83 {
        int iH = q73Var.h(4);
        if (iH == 15) {
            if (q73Var.b() >= 24) {
                return q73Var.h(24);
            }
            throw r83.a("AAC header insufficient data", null);
        }
        if (iH < 13) {
            return a[iH];
        }
        throw r83.a("AAC header wrong Sampling Frequency Index", null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b e(q73 q73Var, boolean z) throws r83 {
        int iC = c(q73Var);
        int iD = d(q73Var);
        int iH = q73Var.h(4);
        String str = "mp4a.40." + iC;
        if (iC == 5 || iC == 29) {
            iD = d(q73Var);
            iC = c(q73Var);
            if (iC == 22) {
                iH = q73Var.h(4);
            }
        }
        if (z) {
            if (iC != 1 && iC != 2 && iC != 3 && iC != 4 && iC != 6 && iC != 7 && iC != 17) {
                switch (iC) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw r83.e("Unsupported audio object type: " + iC);
                }
            }
            g(q73Var, iC, iH);
            switch (iC) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = q73Var.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw r83.e("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i = b[iH];
        if (i != -1) {
            return new b(iD, i, str);
        }
        throw r83.a(null, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b f(byte[] bArr) {
        return e(new q73(bArr), false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(q73 q73Var, int i, int i2) {
        if (q73Var.g()) {
            xz1.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (q73Var.g()) {
            q73Var.r(14);
        }
        boolean zG = q73Var.g();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            q73Var.r(3);
        }
        if (zG) {
            if (i == 22) {
                q73Var.r(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                q73Var.r(3);
            }
            q73Var.r(1);
        }
    }
}
