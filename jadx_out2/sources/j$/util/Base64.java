package j$.util;

import com.hierynomus.protocol.commons.buffer.Buffer;
import j$.nio.file.j;
import j$.sun.nio.cs.c;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public class Base64 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Decoder {
        public static final int[] a;
        public static final int[] b;
        public static final Decoder c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[Buffer.DEFAULT_SIZE];
            a = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < 64; i++) {
                a[Encoder.b[i]] = i;
            }
            a[61] = -2;
            int[] iArr2 = new int[Buffer.DEFAULT_SIZE];
            b = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i2 = 0; i2 < 64; i2++) {
                b[Encoder.c[i2]] = i2;
            }
            b[61] = -2;
            c = new Decoder();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c5, code lost:
        
            if (r10 != 18) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010f, code lost:
        
            if (r10 != 6) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0111, code lost:
        
            r6[r11] = (byte) (r12 >> 16);
            r11 = r11 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x011c, code lost:
        
            if (r10 != 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x011e, code lost:
        
            r0 = r11 + 1;
            r6[r11] = (byte) (r12 >> 16);
            r11 = r11 + 2;
            r6[r0] = (byte) (r12 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x012f, code lost:
        
            if (r10 == 12) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0131, code lost:
        
            if (r9 < r7) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0133, code lost:
        
            if (r11 == r1) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0139, code lost:
        
            return java.util.Arrays.copyOf(r6, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x013a, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x013b, code lost:
        
            j$.nio.file.j.m("Input byte array has incorrect ending byte at ", r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0140, code lost:
        
            return r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0141, code lost:
        
            j$.nio.file.j.a("Last unit does not have enough valid bits");
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0146, code lost:
        
            return r20;
         */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00b3 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public byte[] decode(String str) {
            int i;
            int i2;
            byte[] bArr;
            char c2;
            int i3;
            byte[] bytes = str.getBytes(c.a);
            int length = bytes.length;
            char c3 = 2;
            if (length == 0) {
                i = 0;
            } else {
                if (length < 2) {
                    j.a("Input byte[] should at least have 2 bytes for base64 bytes");
                    return null;
                }
                int i4 = bytes[length + (-1)] == 61 ? bytes[length + (-2)] == 61 ? 2 : 1 : 0;
                if (i4 == 0 && (i2 = length & 3) != 0) {
                    i4 = 4 - i2;
                }
                i = (((length + 3) / 4) * 3) - i4;
            }
            byte[] bArr2 = new byte[i];
            int length2 = bytes.length;
            int i5 = 18;
            int i6 = 18;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i7 >= length2) {
                    bArr = null;
                    break;
                }
                int[] iArr = a;
                if (i6 == i5) {
                    bArr = null;
                    if (i7 + 4 < length2) {
                        int i10 = ((length2 - i7) & (-4)) + i7;
                        while (true) {
                            if (i7 >= i10) {
                                c2 = c3;
                                break;
                            }
                            int i11 = iArr[bytes[i7] & 255];
                            c2 = c3;
                            int i12 = iArr[bytes[i7 + 1] & 255];
                            int i13 = iArr[bytes[i7 + 2] & 255];
                            int i14 = i7 + 4;
                            int i15 = iArr[bytes[i7 + 3] & 255];
                            if ((i11 | i12 | i13 | i15) < 0) {
                                break;
                            }
                            int i16 = (i11 << 18) | (i12 << 12) | (i13 << 6) | i15;
                            bArr2[i8] = (byte) (i16 >> 16);
                            int i17 = i8 + 2;
                            bArr2[i8 + 1] = (byte) (i16 >> 8);
                            i8 += 3;
                            bArr2[i17] = (byte) i16;
                            i7 = i14;
                            c3 = c2;
                        }
                        if (i7 < length2) {
                            break;
                            break;
                        }
                        break;
                    }
                    int i18 = i7 + 1;
                    byte b2 = bytes[i7];
                    i3 = iArr[b2 & 255];
                    if (i3 < 0) {
                        int i19 = (i3 << i6) | i9;
                        i6 -= 6;
                        if (i6 < 0) {
                            bArr2[i8] = (byte) (i19 >> 16);
                            int i20 = i8 + 2;
                            bArr2[i8 + 1] = (byte) (i19 >> 8);
                            i8 += 3;
                            bArr2[i20] = (byte) i19;
                            i6 = 18;
                            i9 = 0;
                        } else {
                            i9 = i19;
                        }
                        i7 = i18;
                        i5 = 18;
                        c3 = c2;
                    } else {
                        if (i3 != -2) {
                            throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(b2, 16));
                        }
                        if (i6 == 6) {
                            if (i18 != length2) {
                                i7 += 2;
                                if (bytes[i18] == 61) {
                                }
                            }
                            j.a("Input byte array has wrong 4-byte ending unit");
                            return bArr;
                        }
                        i7 = i18;
                    }
                } else {
                    bArr = null;
                }
                c2 = c3;
                int i182 = i7 + 1;
                byte b22 = bytes[i7];
                i3 = iArr[b22 & 255];
                if (i3 < 0) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Encoder {
        public static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        public static final char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        public static final Encoder d = new Encoder(false);
        public static final Encoder e = new Encoder(true);
        public final boolean a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Encoder(boolean z) {
            this.a = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String encodeToString(byte[] bArr) {
            byte[] bArr2 = bArr;
            int length = ((bArr2.length + 2) / 3) * 4;
            byte[] bArrCopyOf = new byte[length];
            int length2 = bArr2.length;
            char[] cArr = b;
            char[] cArr2 = c;
            boolean z = this.a;
            char[] cArr3 = z ? cArr2 : cArr;
            int i = (length2 / 3) * 3;
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int iMin = Math.min(i2 + i, i);
                char[] cArr4 = z ? cArr2 : cArr;
                int i4 = i2;
                int i5 = i3;
                while (i4 < iMin) {
                    int i6 = i4 + 2;
                    int i7 = ((bArr[i4 + 1] & 255) << 8) | ((bArr2[i4] & 255) << 16);
                    i4 += 3;
                    int i8 = i7 | (bArr[i6] & 255);
                    bArrCopyOf[i5] = (byte) cArr4[(i8 >>> 18) & 63];
                    bArrCopyOf[i5 + 1] = (byte) cArr4[(i8 >>> 12) & 63];
                    int i9 = i5 + 3;
                    bArrCopyOf[i5 + 2] = (byte) cArr4[(i8 >>> 6) & 63];
                    i5 += 4;
                    bArrCopyOf[i9] = (byte) cArr4[i8 & 63];
                    bArr2 = bArr;
                }
                int i10 = ((iMin - i2) / 3) * 4;
                i3 += i10;
                if (i10 == -1 && iMin < length2) {
                    throw null;
                }
                bArr2 = bArr;
                i2 = iMin;
            }
            if (i2 < length2) {
                int i11 = i2 + 1;
                int i12 = bArr[i2] & 255;
                int i13 = i3 + 1;
                bArrCopyOf[i3] = (byte) cArr3[i12 >> 2];
                if (i11 == length2) {
                    bArrCopyOf[i13] = (byte) cArr3[(i12 << 4) & 63];
                    int i14 = i3 + 3;
                    bArrCopyOf[i3 + 2] = 61;
                    i3 += 4;
                    bArrCopyOf[i14] = 61;
                } else {
                    int i15 = bArr[i11] & 255;
                    bArrCopyOf[i13] = (byte) cArr3[((i12 << 4) & 63) | (i15 >> 4)];
                    int i16 = i3 + 3;
                    bArrCopyOf[i3 + 2] = (byte) cArr3[(i15 << 2) & 63];
                    i3 += 4;
                    bArrCopyOf[i16] = 61;
                }
            }
            if (i3 != length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3);
            }
            return new String(bArrCopyOf, 0, 0, bArrCopyOf.length);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Decoder getDecoder() {
        return Decoder.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Encoder getEncoder() {
        return Encoder.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Encoder getUrlEncoder() {
        return Encoder.e;
    }
}
