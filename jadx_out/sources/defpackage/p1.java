package defpackage;

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

        public c(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.c = i2;
            this.b = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    public static String a(int i, int i2, int i3) {
        return fy4.M("ac-4.%02d.%02d.%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

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

    /* JADX WARN: Removed duplicated region for block: B:166:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.t41 e(defpackage.r73 r20, java.lang.String r21, java.lang.String r22, defpackage.oo0 r23) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 803
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p1.e(r73, java.lang.String, java.lang.String, oo0):t41");
    }

    public static int f(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return g(new q73(bArr)).e;
    }

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static p1.c g(defpackage.q73 r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = k(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L53
            r4 = r7
            goto L55
        L53:
            r4 = r7
            r7 = r6
        L55:
            int r11 = r11.h(r3)
            if (r7 != r6) goto L65
            r6 = 13
            if (r11 != r6) goto L65
            int[] r0 = defpackage.p1.a
            r11 = r0[r11]
        L63:
            r9 = r11
            goto L95
        L65:
            if (r7 != r4) goto L93
            int[] r4 = defpackage.p1.a
            int r6 = r4.length
            if (r11 >= r6) goto L93
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r9 = 1
            if (r1 == r9) goto L8c
            r9 = 11
            if (r1 == r0) goto L87
            if (r1 == r2) goto L8c
            if (r1 == r3) goto L7e
            goto L91
        L7e:
            if (r11 == r2) goto L84
            if (r11 == r6) goto L84
            if (r11 != r9) goto L91
        L84:
            int r11 = r4 + 1
            goto L63
        L87:
            if (r11 == r6) goto L84
            if (r11 != r9) goto L91
            goto L84
        L8c:
            if (r11 == r2) goto L84
            if (r11 != r6) goto L91
            goto L84
        L91:
            r9 = r4
            goto L95
        L93:
            r11 = 0
            goto L63
        L95:
            p1$c r4 = new p1$c
            r6 = 2
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p1.g(q73):p1$c");
    }

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

    public static boolean l(q73 q73Var) {
        if (q73Var.b() < 66) {
            return false;
        }
        q73Var.r(66);
        return true;
    }

    public static void m(q73 q73Var) throws r83 {
        int iH = q73Var.h(6);
        if (iH < 2 || iH > 42) {
            throw r83.e(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iH)));
        }
        q73Var.r(iH * 8);
    }
}
