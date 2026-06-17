package org.mozilla.javascript;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class DToA {
    private static final int Bias = 1023;
    private static final int Bletch = 16;
    private static final int Bndry_mask = 1048575;
    private static final int Exp_11 = 1072693248;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Exp_msk1 = 1048576;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Exp_shift = 20;
    private static final int Exp_shift1 = 20;
    private static final int Exp_shiftL = 52;
    private static final int Frac_mask = 1048575;
    private static final int Frac_mask1 = 1048575;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Int_max = 14;
    private static final int Log2P = 1;
    private static final int P = 53;
    private static final int Quick_max = 14;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Ten_pmax = 22;
    private static final int n_bigtens = 5;
    private static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    private static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static char BASEDIGIT(int i) {
        return (char) (i >= 10 ? i + 87 : i + 48);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0127, code lost:
    
        if (r8 > 0) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String JS_dtobasestr(int i, double d) {
        boolean z;
        String string;
        BigInteger bigIntegerMultiply;
        if (2 > i || i > 36) {
            defpackage.b.a("Bad base: ", i);
            return null;
        }
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (Double.isInfinite(d)) {
            return d > 0.0d ? "Infinity" : "-Infinity";
        }
        if (d == 0.0d) {
            return "0";
        }
        if (d >= 0.0d) {
            z = false;
        } else {
            d = -d;
            z = true;
        }
        double dFloor = Math.floor(d);
        long j = (long) dFloor;
        if (j == dFloor) {
            if (z) {
                j = -j;
            }
            string = Long.toString(j, i);
        } else {
            long jDoubleToLongBits = Double.doubleToLongBits(dFloor);
            int i2 = ((int) (jDoubleToLongBits >> 52)) & Exp_mask_shifted;
            long j2 = i2 == 0 ? (jDoubleToLongBits & Frac_maskL) << 1 : (jDoubleToLongBits & Frac_maskL) | Exp_msk1L;
            if (z) {
                j2 = -j2;
            }
            int i3 = i2 - 1075;
            BigInteger bigIntegerValueOf = BigInteger.valueOf(j2);
            if (i3 > 0) {
                bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i3);
            } else if (i3 < 0) {
                bigIntegerValueOf = bigIntegerValueOf.shiftRight(-i3);
            }
            string = bigIntegerValueOf.toString(i);
        }
        if (d == dFloor) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append('.');
        double d2 = d - dFloor;
        long jDoubleToLongBits2 = Double.doubleToLongBits(d);
        int i4 = (int) (jDoubleToLongBits2 >> 32);
        int i5 = (int) jDoubleToLongBits2;
        int[] iArr = new int[1];
        BigInteger bigIntegerD2b = d2b(d2, iArr, new int[1]);
        int i6 = -((i4 >>> 20) & Exp_mask_shifted);
        if (i6 == 0) {
            i6 = -1;
        }
        int i7 = i6 + 1076;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(1L);
        if (i5 == 0 && (1048575 & i4) == 0 && (i4 & 2145386496) != 0) {
            i7 = i6 + 1077;
            bigIntegerMultiply = BigInteger.valueOf(2L);
        } else {
            bigIntegerMultiply = bigIntegerValueOf2;
        }
        BigInteger bigIntegerShiftLeft = bigIntegerD2b.shiftLeft(iArr[0] + i7);
        BigInteger bigIntegerShiftLeft2 = BigInteger.valueOf(1L).shiftLeft(i7);
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(i);
        boolean z2 = false;
        while (true) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerShiftLeft.multiply(bigIntegerValueOf3).divideAndRemainder(bigIntegerShiftLeft2);
            BigInteger bigIntegerShiftLeft3 = bigIntegerArrDivideAndRemainder[1];
            int iIntValue = (char) bigIntegerArrDivideAndRemainder[0].intValue();
            if (Objects.equals(bigIntegerValueOf2, bigIntegerMultiply)) {
                bigIntegerMultiply = bigIntegerValueOf2.multiply(bigIntegerValueOf3);
                bigIntegerValueOf2 = bigIntegerMultiply;
            } else {
                BigInteger bigIntegerMultiply2 = bigIntegerValueOf2.multiply(bigIntegerValueOf3);
                bigIntegerMultiply = bigIntegerMultiply.multiply(bigIntegerValueOf3);
                bigIntegerValueOf2 = bigIntegerMultiply2;
            }
            int iCompareTo = bigIntegerShiftLeft3.compareTo(bigIntegerValueOf2);
            BigInteger bigIntegerSubtract = bigIntegerShiftLeft2.subtract(bigIntegerMultiply);
            int iCompareTo2 = bigIntegerSubtract.signum() <= 0 ? 1 : bigIntegerShiftLeft3.compareTo(bigIntegerSubtract);
            if (iCompareTo2 == 0 && (i5 & 1) == 0) {
                if (iCompareTo > 0) {
                    iIntValue++;
                }
                z2 = true;
            } else {
                if (iCompareTo < 0 || (iCompareTo == 0 && (i5 & 1) == 0)) {
                    if (iCompareTo2 > 0) {
                        bigIntegerShiftLeft3 = bigIntegerShiftLeft3.shiftLeft(1);
                        if (bigIntegerShiftLeft3.compareTo(bigIntegerShiftLeft2) > 0) {
                        }
                    }
                    z2 = true;
                }
                iIntValue++;
                z2 = true;
            }
            sb.append(BASEDIGIT(iIntValue));
            if (z2) {
                return sb.toString();
            }
            bigIntegerShiftLeft = bigIntegerShiftLeft3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static BigInteger d2b(double d, int[] iArr, int[] iArr2) {
        byte[] bArr;
        int iLo0bits;
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        int i = (int) (jDoubleToLongBits >>> 32);
        int i2 = (int) jDoubleToLongBits;
        int i3 = 1048575 & i;
        int i4 = (i & Integer.MAX_VALUE) >>> 20;
        if (i4 != 0) {
            i3 |= Exp_msk1;
        }
        int i5 = 1;
        if (i2 != 0) {
            bArr = new byte[8];
            iLo0bits = lo0bits(i2);
            int i6 = i2 >>> iLo0bits;
            if (iLo0bits != 0) {
                stuffBits(bArr, 4, i6 | (i3 << (32 - iLo0bits)));
                i3 >>= iLo0bits;
            } else {
                stuffBits(bArr, 4, i6);
            }
            stuffBits(bArr, 0, i3);
            if (i3 != 0) {
                i5 = 2;
            }
        } else {
            bArr = new byte[4];
            int iLo0bits2 = lo0bits(i3);
            i3 >>>= iLo0bits2;
            stuffBits(bArr, 0, i3);
            iLo0bits = iLo0bits2 + 32;
        }
        if (i4 != 0) {
            iArr[0] = (i4 - 1075) + iLo0bits;
            iArr2[0] = 53 - iLo0bits;
        } else {
            iArr[0] = (i4 - 1074) + iLo0bits;
            iArr2[0] = (i5 * 32) - hi0bits(i3);
        }
        return new BigInteger(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int hi0bits(int i) {
        int i2;
        if (((-65536) & i) == 0) {
            i <<= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if (((-16777216) & i) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if (((-268435456) & i) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if (((-1073741824) & i) == 0) {
            i2 += 2;
            i <<= 2;
        }
        if ((Sign_bit & i) == 0) {
            i2++;
            if ((i & Buffer.MAX_SIZE) == 0) {
                return 32;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int lo0bits(int i) {
        int i2 = 0;
        if ((i & 7) != 0) {
            if ((i & 1) != 0) {
                return 0;
            }
            return (i & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i) == 0) {
            i >>>= 16;
            i2 = 16;
        }
        if ((i & 255) == 0) {
            i2 += 8;
            i >>>= 8;
        }
        if ((i & 15) == 0) {
            i2 += 4;
            i >>>= 4;
        }
        if ((i & 3) == 0) {
            i2 += 2;
            i >>>= 2;
        }
        if ((i & 1) == 0) {
            i2++;
            if (((i >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void stuffBits(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }
}
