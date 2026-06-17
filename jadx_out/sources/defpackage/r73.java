package defpackage;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r73 {
    public static final char[] d = {'\r', '\n'};
    public static final char[] e = {'\n'};
    public static final dj1 f = dj1.A(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    public static final AtomicBoolean g = new AtomicBoolean();
    public byte[] a;
    public int b;
    public int c;

    public r73(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public static int c(int i, int i2, int i3, int i4) {
        byte b = (byte) i3;
        return ll1.i((byte) 0, ww4.a(((i & 7) << 2) | ((i2 & 48) >> 4)), ww4.a(((((byte) i2) & 15) << 4) | ((b & 60) >> 2)), ww4.a(((b & 3) << 6) | (((byte) i4) & Utf8.REPLACEMENT_BYTE)));
    }

    public static int h(Charset charset) {
        gg3.k(f.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean i(byte b) {
        return (b & 192) == 128;
    }

    public int A() {
        k(3);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = ((bArr[i] & 255) << 24) >> 8;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.b = i + 3;
        return (bArr[i4] & 255) | i5;
    }

    public String B() {
        return C(StandardCharsets.UTF_8);
    }

    public String C(Charset charset) {
        gg3.k(f.contains(charset), "Unsupported charset: %s", charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            a0();
        }
        String strO = O(e(charset) - this.b, charset);
        if (this.b == this.c) {
            return strO;
        }
        i0(charset);
        return strO;
    }

    public int D() {
        k(4);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    public long E() {
        k(8);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i + 2;
        this.b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i + 3;
        this.b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i + 4;
        this.b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i + 5;
        this.b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i + 6;
        this.b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i + 7;
        this.b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 48);
        this.b = i + 8;
        return ((((long) bArr[i8]) & 255) << 56) | j7;
    }

    public short F() {
        k(2);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public long G() {
        k(4);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i + 2;
        this.b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i + 3;
        this.b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        this.b = i + 4;
        return ((((long) bArr[i4]) & 255) << 24) | j3;
    }

    public int H() {
        int iD = D();
        if (iD >= 0) {
            return iD;
        }
        bo1.a("Top bit not zero: ", iD);
        return 0;
    }

    public int I() {
        k(2);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public long J() {
        k(8);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i + 2;
        this.b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i4 = i + 3;
        this.b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i + 4;
        this.b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i + 5;
        this.b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i + 6;
        this.b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i + 7;
        this.b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        this.b = i + 8;
        return (((long) bArr[i8]) & 255) | j7;
    }

    public String K() {
        return w((char) 0);
    }

    public String L(int i) {
        k(i);
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String strO = fy4.O(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return strO;
    }

    public short M() {
        k(2);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public String N(int i) {
        return O(i, StandardCharsets.UTF_8);
    }

    public String O(int i, Charset charset) {
        k(i);
        String str = new String(this.a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public int P() {
        return Q() | (Q() << 21) | (Q() << 14) | (Q() << 7);
    }

    public int Q() {
        k(1);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public int R() {
        k(4);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        int i4 = (bArr[i2] & 255) | i3;
        this.b = i + 4;
        return i4;
    }

    public long S() {
        k(4);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i + 2;
        this.b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i4 = i + 3;
        this.b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        this.b = i + 4;
        return (((long) bArr[i4]) & 255) | j3;
    }

    public int T() {
        k(3);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.b = i + 3;
        return (bArr[i4] & 255) | i5;
    }

    public int U() {
        int iZ = z();
        if (iZ >= 0) {
            return iZ;
        }
        bo1.a("Top bit not zero: ", iZ);
        return 0;
    }

    public int V() {
        return ll1.e(W());
    }

    public long W() {
        long j = 0;
        for (int i = 0; i < 9; i++) {
            if (this.b == this.c) {
                e04.a("Attempting to read a byte over the limit.");
                return 0L;
            }
            long jQ = Q();
            j |= (127 & jQ) << (i * 7);
            if ((jQ & 128) == 0) {
                return j;
            }
        }
        return j;
    }

    public long X() {
        long J = J();
        if (J >= 0) {
            return J;
        }
        throw new IllegalStateException("Top bit not zero: " + J);
    }

    public int Y() {
        k(2);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public long Z() {
        int i;
        k(1);
        long j = this.a[this.b];
        int i2 = 7;
        while (true) {
            if (i2 < 0) {
                break;
            }
            int i3 = 1 << i2;
            if ((((long) i3) & j) != 0) {
                i2--;
            } else if (i2 < 6) {
                j &= (long) (i3 - 1);
                i = 7 - i2;
            } else if (i2 == 7) {
                i = 1;
            }
        }
        i = 0;
        if (i == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        k(i);
        for (int i4 = 1; i4 < i; i4++) {
            byte b = this.a[this.b + i4];
            if ((b & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | ((long) (b & Utf8.REPLACEMENT_BYTE));
        }
        this.b += i;
        return j;
    }

    public int a() {
        return Math.max(this.c - this.b, 0);
    }

    public Charset a0() {
        if (a() >= 3) {
            byte[] bArr = this.a;
            int i = this.b;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.b = i + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.a;
        int i2 = this.b;
        byte b = bArr2[i2];
        if (b == -2 && bArr2[i2 + 1] == -1) {
            this.b = i2 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.b = i2 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public int b() {
        return this.a.length;
    }

    public void b0(int i) {
        d0(b() < i ? new byte[i] : this.a, i);
    }

    public void c0(byte[] bArr) {
        d0(bArr, bArr.length);
    }

    public void d(int i) {
        if (i > b()) {
            this.a = Arrays.copyOf(this.a, i);
        }
    }

    public void d0(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L33
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L11
            goto L33
        L11:
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L31
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L31
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L2a
            goto L31
        L2a:
            java.lang.String r4 = "Unsupported charset: "
            defpackage.c.a(r4, r5)
            r4 = 0
            return r4
        L31:
            r0 = 2
            goto L34
        L33:
            r0 = 1
        L34:
            int r1 = r4.b
        L36:
            int r2 = r4.c
            int r3 = r0 + (-1)
            int r3 = r2 - r3
            if (r1 >= r3) goto L95
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L4e
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L59
        L4e:
            byte[] r2 = r4.a
            r2 = r2[r1]
            boolean r2 = defpackage.fy4.T0(r2)
            if (r2 == 0) goto L59
            goto L92
        L59:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L69
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L7a
        L69:
            byte[] r2 = r4.a
            r3 = r2[r1]
            if (r3 != 0) goto L7a
            int r3 = r1 + 1
            r2 = r2[r3]
            boolean r2 = defpackage.fy4.T0(r2)
            if (r2 == 0) goto L7a
            goto L92
        L7a:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L93
            byte[] r2 = r4.a
            int r3 = r1 + 1
            r3 = r2[r3]
            if (r3 != 0) goto L93
            r2 = r2[r1]
            boolean r2 = defpackage.fy4.T0(r2)
            if (r2 == 0) goto L93
        L92:
            return r1
        L93:
            int r1 = r1 + r0
            goto L36
        L95:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r73.e(java.nio.charset.Charset):int");
    }

    public void e0(int i) {
        gg3.d(i >= 0 && i <= this.a.length);
        this.c = i;
    }

    public byte[] f() {
        return this.a;
    }

    public void f0(int i) {
        gg3.d(i >= 0 && i <= this.c);
        this.b = i;
    }

    public int g() {
        return this.b;
    }

    public void g0(int i) {
        f0(this.b + i);
    }

    public void h0() {
        while ((Q() & 128) != 0) {
        }
    }

    public final void i0(Charset charset) {
        if (v(charset, d) == '\r') {
            v(charset, e);
        }
    }

    public int j() {
        return this.c;
    }

    public final void k(int i) {
        if (!g.get() || a() >= i) {
            return;
        }
        q02.a("bytesNeeded= ", i, ", bytesLeft=", a());
    }

    public char l() {
        return m(ByteOrder.BIG_ENDIAN, 0);
    }

    public final char m(ByteOrder byteOrder, int i) {
        k(2);
        ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
        byte[] bArr = this.a;
        if (byteOrder == byteOrder2) {
            int i2 = this.b;
            return ys.c(bArr[i2 + i], bArr[i2 + i + 1]);
        }
        int i3 = this.b;
        return ys.c(bArr[i3 + i + 1], bArr[i3 + i]);
    }

    public int n(Charset charset) {
        if (o(charset) != 0) {
            return ll1.e(r0 >>> 8);
        }
        return 1114112;
    }

    public final int o(Charset charset) {
        int codePoint;
        gg3.k(f.contains(charset), "Unsupported charset: %s", charset);
        if (a() < h(charset)) {
            q02.a("position=", this.b, ", limit=", this.c);
            return 0;
        }
        byte b = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b2 = this.a[this.b];
            if ((b2 & 128) != 0) {
                return 0;
            }
            codePoint = ww4.b(b2);
        } else if (charset.equals(StandardCharsets.UTF_8)) {
            byte bS = s();
            if (bS == 1) {
                codePoint = ww4.b(this.a[this.b]);
            } else if (bS == 2) {
                byte[] bArr = this.a;
                int i = this.b;
                codePoint = c(0, 0, bArr[i], bArr[i + 1]);
            } else if (bS == 3) {
                byte[] bArr2 = this.a;
                int i2 = this.b;
                codePoint = c(0, bArr2[i2] & 15, bArr2[i2 + 1], bArr2[i2 + 2]);
            } else {
                if (bS != 4) {
                    return 0;
                }
                byte[] bArr3 = this.a;
                int i3 = this.b;
                codePoint = c(bArr3[i3], bArr3[i3 + 1], bArr3[i3 + 2], bArr3[i3 + 3]);
            }
            b = bS;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cM = m(byteOrder, 0);
            if (!Character.isHighSurrogate(cM) || a() < 4) {
                codePoint = cM;
                b = 2;
            } else {
                codePoint = Character.toCodePoint(cM, m(byteOrder, 2));
                b = 4;
            }
        }
        return (codePoint << 8) | b;
    }

    public int p() {
        if (a() < 4) {
            q02.a("position=", this.b, ", limit=", this.c);
            return 0;
        }
        int iZ = z();
        this.b -= 4;
        return iZ;
    }

    public int q() {
        k(1);
        return this.a[this.b] & 255;
    }

    public int r() {
        if (a() < 3) {
            q02.a("position=", this.b, ", limit=", this.c);
            return 0;
        }
        int iT = T();
        this.b -= 3;
        return iT;
    }

    public final byte s() {
        byte b = this.a[this.b];
        if ((b & 128) == 0) {
            return (byte) 1;
        }
        if ((b & 224) == 192 && a() >= 2 && i(this.a[this.b + 1])) {
            return (byte) 2;
        }
        if ((this.a[this.b] & 240) == 224 && a() >= 3 && i(this.a[this.b + 1]) && i(this.a[this.b + 2])) {
            return (byte) 3;
        }
        return ((this.a[this.b] & 248) == 240 && a() >= 4 && i(this.a[this.b + 1]) && i(this.a[this.b + 2]) && i(this.a[this.b + 3])) ? (byte) 4 : (byte) 0;
    }

    public void t(q73 q73Var, int i) {
        u(q73Var.a, 0, i);
        q73Var.p(0);
    }

    public void u(byte[] bArr, int i, int i2) {
        k(i2);
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final char v(Charset charset, char[] cArr) {
        int iO;
        if (a() < h(charset) || (iO = o(charset)) == 0) {
            return (char) 0;
        }
        int iA = xw4.a(iO >>> 8);
        if (Character.isSupplementaryCodePoint(iA)) {
            return (char) 0;
        }
        char cA = ys.a(iA);
        if (!ys.b(cArr, cA)) {
            return (char) 0;
        }
        this.b += ll1.e(iO & 255);
        return cA;
    }

    public String w(char c) {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != c) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        String strO = fy4.O(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return strO;
    }

    public double x() {
        return Double.longBitsToDouble(J());
    }

    public float y() {
        return Float.intBitsToFloat(z());
    }

    public int z() {
        k(4);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 16) | i3;
        int i6 = i + 3;
        this.b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.b = i + 4;
        return (bArr[i6] & 255) | i7;
    }

    public r73() {
        this.a = fy4.f;
    }

    public r73(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public r73(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }
}
