package org.mozilla.javascript.dtoa;

import defpackage.ya0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DoubleFormatter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BQ_MASK = 2047;
    private static final long C_MIN = 4503599627370496L;
    static final long C_TINY = 3;
    static final int E_MAX = 309;
    static final int E_MIN = -323;
    static final int H = 17;
    private static final long MASK_63 = Long.MAX_VALUE;
    static final int P = 53;
    static final int Q_MAX = 971;
    static final int Q_MIN = -1074;
    private static final long T_MASK = 4503599627370495L;
    private static final int W = 11;

    private static long rop(long j, long j2, long j3) {
        long jA = ya0.a(j2, j3);
        long j4 = j * j3;
        long jA2 = ya0.a(j, j3);
        long j5 = (j4 >>> 1) + jA;
        return (jA2 + (j5 >>> 63)) | (((j5 & MASK_63) + MASK_63) >>> 63);
    }

    public static Decimal toDecimal(double d) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        return toDecimalImpl(jDoubleToRawLongBits, T_MASK & jDoubleToRawLongBits, ((int) (jDoubleToRawLongBits >>> 52)) & BQ_MASK);
    }

    private static Decimal toDecimalFull(int i, long j, int i2, boolean z) {
        long j2;
        int iFlog10pow2;
        char c;
        long j3;
        int i3 = ((int) j) & 1;
        long j4 = j << 2;
        long j5 = j4 + 2;
        if (j != C_MIN || i == Q_MIN) {
            j2 = j4 - 2;
            iFlog10pow2 = MathUtils.flog10pow2(i);
        } else {
            j2 = j4 - 1;
            iFlog10pow2 = MathUtils.flog10threeQuartersPow2(i);
        }
        int iFlog2pow10 = i + MathUtils.flog2pow10(-iFlog10pow2) + 2;
        long jG1 = MathUtils.g1(iFlog10pow2);
        long jG0 = MathUtils.g0(iFlog10pow2);
        long jRop = rop(jG1, jG0, j4 << iFlog2pow10);
        long jRop2 = rop(jG1, jG0, j2 << iFlog2pow10);
        long jRop3 = rop(jG1, jG0, j5 << iFlog2pow10);
        long j6 = jRop >> 2;
        if (j6 >= 100) {
            long jA = ya0.a(j6, 1844674407370955168L) * 10;
            long j7 = jA + 10;
            c = 2;
            j3 = 1;
            long j8 = i3;
            boolean z2 = jRop2 + j8 <= (jA << 2);
            if (z2 != ((j7 << 2) + j8 <= jRop3)) {
                if (!z2) {
                    jA = j7;
                }
                return new Decimal(jA, iFlog10pow2, z);
            }
        } else {
            c = 2;
            j3 = 1;
        }
        long j9 = j6 + j3;
        long j10 = i3;
        boolean z3 = jRop2 + j10 <= (j6 << c);
        if (z3 != ((j9 << c) + j10 <= jRop3)) {
            if (!z3) {
                j6 = j9;
            }
            return new Decimal(j6, iFlog10pow2 + i2, z);
        }
        long j11 = jRop - ((j6 + j9) << 1);
        if (j11 >= 0 && (j11 != 0 || (j6 & j3) != 0)) {
            j6 = j9;
        }
        return new Decimal(j6, iFlog10pow2 + i2, z);
    }

    private static Decimal toDecimalImpl(long j, long j2, int i) {
        boolean z = j < 0;
        if (i == 0) {
            return j2 != 0 ? j2 < C_TINY ? toDecimalFull(Q_MIN, j2 * 10, -1, z) : toDecimalFull(Q_MIN, j2, 0, z) : new Decimal(0L, 1, false);
        }
        int i2 = 1075 - i;
        long j3 = j2 | C_MIN;
        if (i2 > 0 && i2 < 53) {
            long j4 = j3 >> i2;
            if ((j4 << i2) == j3) {
                return new Decimal(j4, 0, z);
            }
        }
        return toDecimalFull(-i2, j3, 0, z);
    }

    public static String toString(double d) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j = T_MASK & jDoubleToRawLongBits;
        int i = ((int) (jDoubleToRawLongBits >>> 52)) & BQ_MASK;
        return i < BQ_MASK ? (i == 0 && j == 0) ? "0" : toDecimalImpl(jDoubleToRawLongBits, j, i).toString() : j != 0 ? "NaN" : jDoubleToRawLongBits > 0 ? "Infinity" : "-Infinity";
    }
}
