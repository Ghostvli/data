package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wx4 {
    public static final b a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static void h(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws ol1 {
            if (m(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m(b3) || m(b4)) {
                throw ol1.d();
            }
            int iR = ((b & 7) << 18) | (r(b2) << 12) | (r(b3) << 6) | r(b4);
            cArr[i] = l(iR);
            cArr[i + 1] = q(iR);
        }

        public static void i(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        public static void j(byte b, byte b2, byte b3, char[] cArr, int i) throws ol1 {
            if (m(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m(b3)))) {
                throw ol1.d();
            }
            cArr[i] = (char) (((b & 15) << 12) | (r(b2) << 6) | r(b3));
        }

        public static void k(byte b, byte b2, char[] cArr, int i) throws ol1 {
            if (b < -62 || m(b2)) {
                throw ol1.d();
            }
            cArr[i] = (char) (((b & 31) << 6) | r(b2));
        }

        public static char l(int i) {
            return (char) ((i >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        }

        public static boolean m(byte b) {
            return b > -65;
        }

        public static boolean n(byte b) {
            return b >= 0;
        }

        public static boolean o(byte b) {
            return b < -16;
        }

        public static boolean p(byte b) {
            return b < -32;
        }

        public static char q(int i) {
            return (char) ((i & 1023) + Utf8.LOG_SURROGATE_HEADER);
        }

        public static int r(byte b) {
            return b & Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public abstract String a(byte[] bArr, int i, int i2);

        public abstract int b(String str, byte[] bArr, int i, int i2);

        public int c(String str, byte[] bArr, int i, int i2) {
            byte[] bytes = str.getBytes(bl1.a);
            if (bytes.length - i > i2) {
                throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
            }
            System.arraycopy(bytes, 0, bArr, i, bytes.length);
            return i + bytes.length;
        }

        public abstract boolean d(byte[] bArr, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends b {
        public static boolean e(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 < i2 && b >= -62) {
                            i += 2;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return false;
                    }
                    if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return false;
                        }
                        int i4 = i + 2;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i + 3;
                            if (bArr[i4] <= -65) {
                                i += 4;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return false;
                    }
                    if (i3 >= i2 - 1) {
                        return false;
                    }
                    int i6 = i + 2;
                    byte b3 = bArr[i3];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        i += 3;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return false;
                }
                i = i3;
            }
            return true;
        }

        @Override // wx4.b
        public String a(byte[] bArr, int i, int i2) throws ol1 {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!a.n(b)) {
                    break;
                }
                i++;
                a.i(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (a.n(b2)) {
                    int i7 = i5 + 1;
                    a.i(b2, cArr, i5);
                    int i8 = i6;
                    while (i8 < i3) {
                        byte b3 = bArr[i8];
                        if (!a.n(b3)) {
                            break;
                        }
                        i8++;
                        a.i(b3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    i = i8;
                } else if (a.p(b2)) {
                    if (i6 >= i3) {
                        throw ol1.d();
                    }
                    i += 2;
                    a.k(b2, bArr[i6], cArr, i5);
                    i5++;
                } else if (a.o(b2)) {
                    if (i6 >= i3 - 1) {
                        throw ol1.d();
                    }
                    int i9 = i + 2;
                    i += 3;
                    a.j(b2, bArr[i6], bArr[i9], cArr, i5);
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw ol1.d();
                    }
                    byte b4 = bArr[i6];
                    int i10 = i + 3;
                    byte b5 = bArr[i + 2];
                    i += 4;
                    a.h(b2, b4, b5, bArr[i10], cArr, i5);
                    i5 += 2;
                }
            }
            return new String(cArr, 0, i5);
        }

        @Override // wx4.b
        public int b(String str, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            char cCharAt;
            int length = str.length();
            int i5 = i + i2;
            int i6 = 0;
            while (i6 < length && (i4 = i6 + i) < i5 && (cCharAt = str.charAt(i6)) < 128) {
                bArr[i4] = (byte) cCharAt;
                i6++;
            }
            if (i6 == length) {
                return i + length;
            }
            int i7 = i + i6;
            while (i6 < length) {
                char cCharAt2 = str.charAt(i6);
                if (cCharAt2 < 128 && i7 < i5) {
                    bArr[i7] = (byte) cCharAt2;
                    i7++;
                } else if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt2 >>> 6) | 960);
                    i7 += 2;
                    bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                        if (i7 > i5 - 4) {
                            if (55296 > cCharAt2 || cCharAt2 > 57343 || ((i3 = i6 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i3)))) {
                                throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                            }
                            return c(str, bArr, i, i2);
                        }
                        i6++;
                        if (i6 != str.length()) {
                            char cCharAt3 = str.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i9 = i7 + 3;
                                bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i7 += 4;
                                bArr[i9] = (byte) ((codePoint & 63) | 128);
                            }
                        }
                        return c(str, bArr, i, i2);
                    }
                    bArr[i7] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i10 = i7 + 2;
                    bArr[i7 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i7 += 3;
                    bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
                }
                i6++;
            }
            return i7;
        }

        @Override // wx4.b
        public boolean d(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return true;
            }
            return e(bArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends Exception {
        public d(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends b {
        public static boolean e() {
            return vw4.E() && vw4.F();
        }

        public static int f(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            int i3 = 8 - (((int) j) & 7);
            while (i2 < i3) {
                long j2 = 1 + j;
                if (vw4.u(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j2;
            }
            while (true) {
                int i4 = i2 + 8;
                if (i4 > i || (vw4.A(bArr, vw4.h + j) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j += 8;
                i2 = i4;
            }
            while (i2 < i) {
                long j3 = j + 1;
                if (vw4.u(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j3;
            }
            return i;
        }

        @Override // wx4.b
        public String a(byte[] bArr, int i, int i2) throws ol1 {
            Charset charset = bl1.a;
            String str = new String(bArr, i, i2, charset);
            if (str.indexOf(Utf8.REPLACEMENT_CODE_POINT) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                throw ol1.d();
            }
            return str;
        }

        @Override // wx4.b
        public int b(String str, byte[] bArr, int i, int i2) {
            return c(str, bArr, i, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
        
            return false;
         */
        @Override // wx4.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean d(byte[] r11, int r12, int r13) {
            /*
                r10 = this;
                r10 = r12 | r13
                int r0 = r11.length
                int r0 = r0 - r13
                r10 = r10 | r0
                if (r10 < 0) goto L91
                long r0 = (long) r12
                int r13 = r13 - r12
                int r10 = f(r11, r0, r13)
                int r13 = r13 - r10
                long r2 = (long) r10
                long r0 = r0 + r2
            L10:
                r10 = 0
                r12 = r10
            L12:
                r2 = 1
                if (r13 <= 0) goto L23
                long r4 = r0 + r2
                byte r12 = defpackage.vw4.u(r11, r0)
                if (r12 < 0) goto L22
                int r13 = r13 + (-1)
                r0 = r4
                goto L12
            L22:
                r0 = r4
            L23:
                if (r13 != 0) goto L27
                r10 = 1
                return r10
            L27:
                int r4 = r13 + (-1)
                r5 = -32
                r6 = -65
                if (r12 >= r5) goto L43
                if (r4 != 0) goto L32
                return r10
            L32:
                int r13 = r13 + (-2)
                r4 = -62
                if (r12 < r4) goto L42
                long r2 = r2 + r0
                byte r12 = defpackage.vw4.u(r11, r0)
                if (r12 <= r6) goto L40
                goto L42
            L40:
                r0 = r2
                goto L10
            L42:
                return r10
            L43:
                r7 = -16
                r8 = 2
                if (r12 >= r7) goto L6a
                r7 = 2
                if (r4 >= r7) goto L4d
                return r10
            L4d:
                int r13 = r13 + (-3)
                long r2 = r2 + r0
                byte r4 = defpackage.vw4.u(r11, r0)
                if (r4 > r6) goto L69
                r7 = -96
                if (r12 != r5) goto L5c
                if (r4 < r7) goto L69
            L5c:
                r5 = -19
                if (r12 != r5) goto L62
                if (r4 >= r7) goto L69
            L62:
                long r0 = r0 + r8
                byte r12 = defpackage.vw4.u(r11, r2)
                if (r12 <= r6) goto L10
            L69:
                return r10
            L6a:
                r5 = 3
                if (r4 >= r5) goto L6e
                return r10
            L6e:
                int r13 = r13 + (-4)
                long r2 = r2 + r0
                byte r4 = defpackage.vw4.u(r11, r0)
                if (r4 > r6) goto L90
                int r12 = r12 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L90
                long r8 = r8 + r0
                byte r12 = defpackage.vw4.u(r11, r2)
                if (r12 > r6) goto L90
                r2 = 3
                long r0 = r0 + r2
                byte r12 = defpackage.vw4.u(r11, r8)
                if (r12 <= r6) goto L10
            L90:
                return r10
            L91:
                java.lang.ArrayIndexOutOfBoundsException r10 = new java.lang.ArrayIndexOutOfBoundsException
                int r11 = r11.length
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Object[] r11 = new java.lang.Object[]{r11, r12, r13}
                java.lang.String r12 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r11 = java.lang.String.format(r12, r11)
                r10.<init>(r11)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: wx4.e.d(byte[], int, int):boolean");
        }
    }

    static {
        a = (!e.e() || s5.c()) ? new c() : new e();
    }

    public static String a(byte[] bArr, int i, int i2) {
        return i2 == 0 ? "" : a.a(bArr, i, i2);
    }

    public static int b(String str, byte[] bArr, int i, int i2) {
        return a.b(str, bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r2 < r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        throw new java.lang.IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r2) + 4294967296L));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r5) {
        /*
            int r0 = r5.length()
            r1 = 0
        L5:
            if (r1 >= r0) goto L12
            char r2 = r5.charAt(r1)
            r3 = 128(0x80, float:1.8E-43)
            if (r2 >= r3) goto L12
            int r1 = r1 + 1
            goto L5
        L12:
            r2 = r0
        L13:
            if (r1 >= r0) goto L33
            char r3 = r5.charAt(r1)
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L25
            int r3 = 127 - r3
            int r3 = r3 >>> 31
            int r2 = r2 + r3
            int r1 = r1 + 1
            goto L13
        L25:
            int r5 = d(r5, r1)     // Catch: wx4.d -> L2b
            int r2 = r2 + r5
            goto L33
        L2b:
            java.nio.charset.Charset r0 = defpackage.bl1.a
            byte[] r5 = r5.getBytes(r0)
            int r5 = r5.length
            return r5
        L33:
            if (r2 < r0) goto L36
            return r2
        L36:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            long r0 = (long) r2
            r2 = 4294967296(0x100000000, double:2.121995791E-314)
            long r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "UTF-8 length does not fit in int: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wx4.c(java.lang.String):int");
    }

    public static int d(String str, int i) throws d {
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(str, i) < 65536) {
                        throw new d(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static boolean e(byte[] bArr) {
        return a.d(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i, int i2) {
        return a.d(bArr, i, i2);
    }
}
