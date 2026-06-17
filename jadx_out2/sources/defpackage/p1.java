package defpackage;

import defpackage.t41;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p1 {
    public static final int[] a = {2002, 2000, 1920, 1601, 1600, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public int e;
        public int f;
        public int g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            this.a = true;
            this.b = -1;
            this.c = -1;
            this.d = true;
            this.e = 2;
            this.f = 1;
            this.g = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.c = i2;
            this.b = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(int i, int i2, int i3) {
        return fy4.M("ac-4.%02d.%02d.%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(int i, r73 r73Var) {
        r73Var.b0(7);
        byte[] bArrF = r73Var.f();
        bArrF[0] = -84;
        bArrF[1] = 64;
        bArrF[2] = -1;
        bArrF[3] = -1;
        bArrF[4] = (byte) ((i >> 16) & 255);
        bArrF[5] = (byte) ((i >> 8) & 255);
        bArrF[6] = (byte) (i & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(int i, boolean z, int i2) {
        int iD = d(i);
        if (i != 11 && i != 12 && i != 13 && i != 14) {
            return iD;
        }
        if (!z) {
            iD -= 2;
        }
        return i2 != 0 ? i2 != 1 ? iD : iD - 2 : iD - 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
            case 7:
            case 9:
                return 7;
            case 6:
            case 8:
            case 10:
                return 8;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 24;
            default:
                return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:166:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static t41 e(r73 r73Var, String str, String str2, oo0 oo0Var) throws r83 {
        int i;
        int i2;
        int iC;
        boolean zG;
        int i3;
        int iH;
        int iH2;
        int iH3;
        int i4;
        boolean z;
        boolean zG2;
        int i5;
        q73 q73Var = new q73();
        q73Var.m(r73Var);
        int iB = q73Var.b();
        int iH4 = q73Var.h(3);
        if (iH4 > 1) {
            throw r83.e("Unsupported AC-4 DSI version: " + iH4);
        }
        int iH5 = q73Var.h(7);
        int i6 = q73Var.g() ? 48000 : 44100;
        q73Var.r(4);
        int iH6 = q73Var.h(9);
        if (iH5 > 1) {
            if (iH4 == 0) {
                throw r83.e("Invalid AC-4 DSI version: " + iH4);
            }
            if (q73Var.g()) {
                q73Var.r(16);
                if (q73Var.g()) {
                    q73Var.r(128);
                }
            }
        }
        if (iH4 == 1) {
            if (!l(q73Var)) {
                throw r83.e("Invalid AC-4 DSI bitrate.");
            }
            q73Var.c();
        }
        b bVar = new b();
        for (int i7 = 0; i7 < iH6; i7++) {
            if (iH4 == 0) {
                zG = q73Var.g();
                i3 = 8;
                iH = q73Var.h(5);
                iH2 = q73Var.h(5);
                iH3 = 0;
                i4 = 0;
                z = false;
            } else {
                int iH7 = q73Var.h(8);
                iH3 = q73Var.h(8);
                i3 = 8;
                if (iH3 == 255) {
                    iH3 += q73Var.h(16);
                }
                if (iH7 > 2) {
                    q73Var.r(iH3 * 8);
                } else {
                    int iB2 = (iB - q73Var.b()) / 8;
                    int iH8 = q73Var.h(5);
                    iH2 = iH7;
                    iH = iH8;
                    z = iH8 == 31;
                    i4 = iB2;
                    zG = false;
                }
            }
            bVar.f = iH2;
            if (zG || z || iH != 6) {
                bVar.g = q73Var.h(3);
                if (q73Var.g()) {
                    q73Var.r(5);
                }
                q73Var.r(2);
                int i8 = 1;
                if (iH4 == 1 && (iH2 == 1 || iH2 == 2)) {
                    q73Var.r(2);
                }
                q73Var.r(5);
                q73Var.r(10);
                if (iH4 == 1) {
                    if (iH2 > 0) {
                        bVar.a = q73Var.g();
                    }
                    if (bVar.a) {
                        if (iH2 != 1) {
                            i5 = 2;
                            if (iH2 == 2) {
                                int iH9 = q73Var.h(5);
                                if (iH9 >= 0 && iH9 <= 15) {
                                    bVar.b = iH9;
                                }
                                if (iH9 < 11 || iH9 > 14) {
                                    i5 = 2;
                                } else {
                                    bVar.d = q73Var.g();
                                    i5 = 2;
                                    bVar.e = q73Var.h(2);
                                }
                            }
                            q73Var.r(24);
                            i8 = 1;
                        }
                        if (bVar.a) {
                            iC = c(bVar.b, bVar.d, bVar.e);
                        } else {
                            int i9 = bVar.c;
                            int i10 = bVar.g;
                            if (i9 > 0) {
                                int i11 = i9 + 1;
                                if (i10 == 4 && i11 == 17) {
                                    i11 = 21;
                                }
                                iC = i11;
                            } else {
                                if (i10 == 0) {
                                    i2 = 2;
                                } else if (i10 != 1) {
                                    i2 = 2;
                                    if (i10 == 2) {
                                        iC = i;
                                    } else if (i10 == 3) {
                                        iC = 10;
                                    } else if (i10 != 4) {
                                        xz1.i("Ac4Util", "AC-4 level " + bVar.g + " has not been defined.");
                                    } else {
                                        iC = 12;
                                    }
                                } else {
                                    iC = 6;
                                }
                                iC = i2;
                            }
                        }
                        if (iC > 0) {
                            return new t41.b().k0(str).A0("audio/ac4").U(iC).B0(i6).d0(oo0Var).o0(str2).V(a(iH5, bVar.f, bVar.g)).Q();
                        }
                        throw r83.e("Cannot determine channel count of presentation.");
                    }
                    i5 = 2;
                    if (iH2 == i8 || iH2 == i5) {
                        if (q73Var.g() && q73Var.g()) {
                            q73Var.r(i5);
                        }
                        if (q73Var.g()) {
                            q73Var.q();
                            int i12 = i3;
                            int iH10 = q73Var.h(i12);
                            int i13 = 0;
                            while (i13 < iH10) {
                                q73Var.r(i12);
                                i13++;
                                i12 = 8;
                            }
                        }
                    }
                }
                if (!zG && !z) {
                    q73Var.q();
                    if (iH == 0 || iH == 1 || iH == 2) {
                        if (iH2 == 0) {
                            for (int i14 = 0; i14 < 2; i14++) {
                                i(q73Var, bVar);
                            }
                        } else {
                            for (int i15 = 0; i15 < 2; i15++) {
                                j(q73Var, bVar);
                            }
                        }
                    } else if (iH == 3 || iH == 4) {
                        if (iH2 == 0) {
                            for (int i16 = 0; i16 < 3; i16++) {
                                i(q73Var, bVar);
                            }
                        } else {
                            for (int i17 = 0; i17 < 3; i17++) {
                                j(q73Var, bVar);
                            }
                        }
                    } else if (iH != 5) {
                        int iH11 = q73Var.h(7);
                        for (int i18 = 0; i18 < iH11; i18++) {
                            q73Var.r(8);
                        }
                    } else if (iH2 == 0) {
                        i(q73Var, bVar);
                    } else {
                        int iH12 = q73Var.h(3);
                        for (int i19 = 0; i19 < iH12 + 2; i19++) {
                            j(q73Var, bVar);
                        }
                    }
                } else if (iH2 == 0) {
                    i(q73Var, bVar);
                } else {
                    j(q73Var, bVar);
                }
                q73Var.q();
                zG2 = q73Var.g();
            } else {
                zG2 = true;
            }
            if (zG2) {
                int iH13 = q73Var.h(7);
                for (int i20 = 0; i20 < iH13; i20++) {
                    q73Var.r(15);
                }
            }
            if (iH2 > 0) {
                if (q73Var.g() && !l(q73Var)) {
                    throw r83.e("Can't parse bitrate DSI.");
                }
                if (q73Var.g()) {
                    q73Var.c();
                    q73Var.s(q73Var.h(16));
                    int iH14 = q73Var.h(5);
                    for (int i21 = 0; i21 < iH14; i21++) {
                        q73Var.r(3);
                        q73Var.r(8);
                    }
                }
            }
            i = 8;
            q73Var.c();
            if (iH4 == 1) {
                int iB3 = ((iB - q73Var.b()) / 8) - i4;
                if (iH3 < iB3) {
                    throw r83.e("pres_bytes is smaller than presentation bytes read.");
                }
                q73Var.s(iH3 - iB3);
            }
            if (bVar.a && bVar.b == -1) {
                throw r83.e("Can't determine channel mode of presentation " + i7);
            }
            if (bVar.a) {
            }
            if (iC > 0) {
            }
        }
        i = 8;
        if (bVar.a) {
        }
        if (iC > 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return g(new q73(bArr)).e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
    
        if (r11 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
    
        if (r11 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008e, code lost:
    
        if (r11 != 8) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c g(q73 q73Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int iH = q73Var.h(16);
        int iH2 = q73Var.h(16);
        if (iH2 == 65535) {
            iH2 = q73Var.h(24);
            i = 7;
        } else {
            i = 4;
        }
        int i5 = iH2 + i;
        if (iH == 44097) {
            i5 += 2;
        }
        int i6 = i5;
        int iH3 = q73Var.h(2);
        if (iH3 == 3) {
            iH3 += k(q73Var, 2);
        }
        int i7 = iH3;
        int iH4 = q73Var.h(10);
        if (q73Var.g() && q73Var.h(3) > 0) {
            q73Var.r(2);
        }
        int i8 = 48000;
        if (q73Var.g()) {
            i2 = 48000;
        } else {
            i2 = 48000;
            i8 = 44100;
        }
        int iH5 = q73Var.h(4);
        if (i8 != 44100 || iH5 != 13) {
            if (i8 == i2) {
                int[] iArr = a;
                if (iH5 < iArr.length) {
                    int i9 = iArr[iH5];
                    int i10 = iH4 % 5;
                    if (i10 == 1) {
                        if (iH5 != 3) {
                        }
                        i3 = i9 + 1;
                    } else if (i10 == 2) {
                        if (iH5 != 8) {
                        }
                        i3 = i9 + 1;
                    } else if (i10 != 3) {
                        if (i10 == 4) {
                            if (iH5 != 3) {
                                if (iH5 != 8) {
                                }
                            }
                            i3 = i9 + 1;
                        }
                        i4 = i9;
                    }
                } else {
                    i3 = 0;
                }
            }
            return new c(i7, 2, i8, i6, i4);
        }
        i3 = a[iH5];
        i4 = i3;
        return new c(i7, 2, i8, i6, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void i(q73 q73Var, b bVar) throws r83 {
        int iH = q73Var.h(5);
        q73Var.r(2);
        if (q73Var.g()) {
            q73Var.r(5);
        }
        if (iH >= 7 && iH <= 10) {
            q73Var.q();
        }
        if (q73Var.g()) {
            int iH2 = q73Var.h(3);
            if (bVar.b == -1 && iH >= 0 && iH <= 15 && (iH2 == 0 || iH2 == 1)) {
                bVar.b = iH;
            }
            if (q73Var.g()) {
                m(q73Var);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j(q73 q73Var, b bVar) throws r83 {
        q73Var.r(2);
        boolean zG = q73Var.g();
        int iH = q73Var.h(8);
        for (int i = 0; i < iH; i++) {
            q73Var.r(2);
            if (q73Var.g()) {
                q73Var.r(5);
            }
            if (zG) {
                q73Var.r(24);
            } else {
                if (q73Var.g()) {
                    if (!q73Var.g()) {
                        q73Var.r(4);
                    }
                    bVar.c = q73Var.h(6) + 1;
                }
                q73Var.r(4);
            }
        }
        if (q73Var.g()) {
            q73Var.r(3);
            if (q73Var.g()) {
                m(q73Var);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(q73 q73Var, int i) {
        int i2 = 0;
        while (true) {
            int iH = i2 + q73Var.h(i);
            if (!q73Var.g()) {
                return iH;
            }
            i2 = (iH + 1) << i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean l(q73 q73Var) {
        if (q73Var.b() < 66) {
            return false;
        }
        q73Var.r(66);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(q73 q73Var) throws r83 {
        int iH = q73Var.h(6);
        if (iH < 2 || iH > 42) {
            throw r83.e(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iH)));
        }
        q73Var.r(iH * 8);
    }
}
