package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.t41;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Settings;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rp0 {
    public static final int[] a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    public static final int[] b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    public static final int[] c = {64, Token.ASSIGN_MOD, 128, 192, 224, Buffer.DEFAULT_SIZE, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, okio.internal.Buffer.SEGMENTING_THRESHOLD, 6144, 7680};
    public static final int[] d = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    public static final int[] e = {5, 8, 10, 12};
    public static final int[] f = {6, 9, 12, 15};
    public static final int[] g = {2, 4, 6, 8};
    public static final int[] h = {9, 11, 13, 16};
    public static final int[] i = {5, 8, 10, 12};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final long e;
        public final int f;

        public b(String str, int i, int i2, int i3, long j, int i4) {
            this.a = str;
            this.c = i;
            this.b = i2;
            this.d = i3;
            this.e = j;
            this.f = i4;
        }
    }

    public static void a(byte[] bArr, int i2) throws r83 {
        int i3 = i2 - 2;
        if (((bArr[i2 - 1] & 255) | ((bArr[i3] << 8) & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) != fy4.z(bArr, 0, i3, Settings.DEFAULT_INITIAL_WINDOW_SIZE)) {
            throw r83.a("CRC check failed", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
        L36:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5e
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
            goto L36
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rp0.b(byte[]):int");
    }

    public static int c(int i2) {
        if (i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368) {
            return 1;
        }
        if (i2 == 1683496997 || i2 == 622876772) {
            return 2;
        }
        if (i2 == 1078008818 || i2 == -233094848) {
            return 3;
        }
        return (i2 == 1908687592 || i2 == -398277519) ? 4 : 0;
    }

    public static q73 d(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 == 127 || b2 == 100 || b2 == 64 || b2 == 113) {
            return new q73(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (e(bArrCopyOf)) {
            for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                byte b3 = bArrCopyOf[i2];
                int i3 = i2 + 1;
                bArrCopyOf[i2] = bArrCopyOf[i3];
                bArrCopyOf[i3] = b3;
            }
        }
        q73 q73Var = new q73(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            q73 q73Var2 = new q73(bArrCopyOf);
            while (q73Var2.b() >= 16) {
                q73Var2.r(2);
                q73Var.f(q73Var2.h(14), 14);
            }
        }
        q73Var.n(bArrCopyOf);
        return q73Var;
    }

    public static boolean e(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24;
    }

    public static boolean f(jz0 jz0Var, int i2) {
        r73 r73Var = new r73(i2);
        if (!jz0Var.j(r73Var.f(), 0, i2, true)) {
            return false;
        }
        jz0Var.p();
        if (c(r73Var.p()) != 1 || r73Var.a() < 10) {
            return false;
        }
        byte[] bArr = new byte[10];
        r73Var.u(bArr, 0, 10);
        r73Var.f0(0);
        int iB = b(bArr);
        if (iB > 0 && r73Var.a() >= iB + 4) {
            r73Var.g0(iB);
            if (c(r73Var.z()) == 2) {
                return true;
            }
        }
        return false;
    }

    public static int g(ByteBuffer byteBuffer) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return okio.internal.Buffer.SEGMENTING_THRESHOLD;
        }
        int iPosition = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition);
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 7);
            } else if (b4 != 31) {
                i2 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b2 = byteBuffer.get(iPosition + 5);
            } else {
                i2 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 6);
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b2 = byteBuffer.get(iPosition + 4);
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    public static int h(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    public static t41 i(byte[] bArr, String str, String str2, int i2, String str3, oo0 oo0Var) {
        q73 q73VarD = d(bArr);
        q73VarD.r(60);
        int i3 = a[q73VarD.h(6)];
        int i4 = b[q73VarD.h(4)];
        int iH = q73VarD.h(5);
        int[] iArr = c;
        int i5 = iH >= iArr.length ? -1 : (iArr[iH] * 1000) / 2;
        q73VarD.r(10);
        return new t41.b().k0(str).X(str3).A0("audio/vnd.dts").T(i5).U(i3 + (q73VarD.h(2) > 0 ? 1 : 0)).B0(i4).d0(oo0Var).o0(str2).y0(i2).Q();
    }

    public static b j(byte[] bArr) throws r83 {
        int i2;
        int i3;
        int iH;
        int i4;
        long jU1;
        int i5;
        q73 q73VarD = d(bArr);
        q73VarD.r(40);
        int iH2 = q73VarD.h(2);
        if (q73VarD.g()) {
            i2 = 20;
            i3 = 12;
        } else {
            i2 = 16;
            i3 = 8;
        }
        q73VarD.r(i3);
        int iH3 = q73VarD.h(i2) + 1;
        boolean zG = q73VarD.g();
        int iH4 = -1;
        int i6 = 0;
        if (zG) {
            iH = q73VarD.h(2);
            int iH5 = (q73VarD.h(3) + 1) * 512;
            if (q73VarD.g()) {
                q73VarD.r(36);
            }
            int iH6 = q73VarD.h(3) + 1;
            int iH7 = q73VarD.h(3) + 1;
            if (iH6 != 1 || iH7 != 1) {
                throw r83.e("Multiple audio presentations or assets not supported");
            }
            int i7 = iH2 + 1;
            int iH8 = q73VarD.h(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                if (((iH8 >> i8) & 1) == 1) {
                    q73VarD.r(8);
                }
            }
            if (q73VarD.g()) {
                q73VarD.r(2);
                int iH9 = (q73VarD.h(2) + 1) << 2;
                int iH10 = q73VarD.h(2) + 1;
                while (i6 < iH10) {
                    q73VarD.r(iH9);
                    i6++;
                }
            }
            i6 = iH5;
        } else {
            iH = -1;
        }
        q73VarD.r(i2);
        q73VarD.r(12);
        if (zG) {
            if (q73VarD.g()) {
                q73VarD.r(4);
            }
            if (q73VarD.g()) {
                q73VarD.r(24);
            }
            if (q73VarD.g()) {
                q73VarD.s(q73VarD.h(10) + 1);
            }
            q73VarD.r(5);
            i4 = d[q73VarD.h(4)];
            iH4 = q73VarD.h(8) + 1;
        } else {
            i4 = -2147483647;
        }
        int i9 = i4;
        if (zG) {
            if (iH == 0) {
                i5 = 32000;
            } else if (iH == 1) {
                i5 = 44100;
            } else {
                if (iH != 2) {
                    throw r83.a("Unsupported reference clock code in DTS HD header: " + iH, null);
                }
                i5 = 48000;
            }
            jU1 = fy4.u1(i6, 1000000L, i5);
        } else {
            jU1 = -9223372036854775807L;
        }
        return new b("audio/vnd.dts.hd;profile=lbr", iH4, i9, iH3, jU1, 0);
    }

    public static int k(byte[] bArr) {
        q73 q73VarD = d(bArr);
        q73VarD.r(42);
        return q73VarD.h(q73VarD.g() ? 12 : 8) + 1;
    }

    public static b l(byte[] bArr, AtomicInteger atomicInteger) throws r83 {
        int iH;
        long jU1;
        AtomicInteger atomicInteger2;
        int i2;
        int i3;
        q73 q73VarD = d(bArr);
        int i4 = q73VarD.h(32) == 1078008818 ? 1 : 0;
        int iN = n(q73VarD, e, true) + 1;
        if (i4 == 0) {
            iH = -2147483647;
            jU1 = -9223372036854775807L;
        } else {
            if (!q73VarD.g()) {
                throw r83.e("Only supports full channel mask-based audio presentation");
            }
            a(bArr, iN);
            int iH2 = q73VarD.h(2);
            if (iH2 == 0) {
                i2 = 512;
            } else if (iH2 == 1) {
                i2 = 480;
            } else {
                if (iH2 != 2) {
                    throw r83.a("Unsupported base duration index in DTS UHD header: " + iH2, null);
                }
                i2 = 384;
            }
            int iH3 = i2 * (q73VarD.h(3) + 1);
            int iH4 = q73VarD.h(2);
            if (iH4 == 0) {
                i3 = 32000;
            } else if (iH4 == 1) {
                i3 = 44100;
            } else {
                if (iH4 != 2) {
                    throw r83.a("Unsupported clock rate index in DTS UHD header: " + iH4, null);
                }
                i3 = 48000;
            }
            if (q73VarD.g()) {
                q73VarD.r(36);
            }
            iH = (1 << q73VarD.h(2)) * i3;
            jU1 = fy4.u1(iH3, 1000000L, i3);
        }
        int i5 = iH;
        long j = jU1;
        int iN2 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            iN2 += n(q73VarD, f, true);
        }
        if (i4 != 0) {
            atomicInteger2 = atomicInteger;
            atomicInteger2.set(n(q73VarD, g, true));
        } else {
            atomicInteger2 = atomicInteger;
        }
        return new b("audio/vnd.dts.uhd;profile=p2", 2, i5, iN + iN2 + (atomicInteger2.get() != 0 ? n(q73VarD, h, true) : 0), j, 0);
    }

    public static int m(byte[] bArr) {
        q73 q73VarD = d(bArr);
        q73VarD.r(32);
        return n(q73VarD, i, true) + 1;
    }

    public static int n(q73 q73Var, int[] iArr, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 3 && q73Var.g(); i4++) {
            i3++;
        }
        if (z) {
            int i5 = 0;
            while (i2 < i3) {
                i5 += 1 << iArr[i2];
                i2++;
            }
            i2 = i5;
        }
        return i2 + q73Var.h(iArr[i3]);
    }
}
