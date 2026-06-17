package org.mozilla.javascript.dtoa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.mozilla.javascript.dtoa.Decimal;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DecimalFormatter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final double MAX_FIXED = 1.0E21d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void fillZeroes(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('0');
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String toExponential(double d, int i) {
        if (i < 0) {
            return DoubleFormatter.toDecimal(d).toString(Decimal.Mode.TO_EXPONENTIAL);
        }
        boolean z = Math.signum(d) < 0.0d;
        if (z) {
            d = Math.abs(d);
        }
        BigDecimal bigDecimal = new BigDecimal(d, new MathContext(i + 1, RoundingMode.HALF_UP));
        return toExponentialString(bigDecimal, (bigDecimal.scale() >= 0 ? bigDecimal.precision() - bigDecimal.scale() : bigDecimal.precision() + (-bigDecimal.scale())) - 1, i, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String toExponentialString(BigDecimal bigDecimal, int i, int i2, boolean z) {
        String string = bigDecimal.unscaledValue().toString();
        int length = string.length();
        StringBuilder sb = new StringBuilder(length + i2 + 7);
        if (z) {
            sb.append('-');
        }
        sb.append(string.charAt(0));
        if (length > 1 || i2 >= 1) {
            sb.append('.');
            sb.append(string.substring(1));
            fillZeroes(sb, i2 - (length - 1));
        }
        sb.append('e');
        if (i >= 0) {
            sb.append('+');
        }
        sb.append(i);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String toFixed(double d, int i) {
        boolean z = Math.signum(d) < 0.0d;
        double dAbs = z ? Math.abs(d) : d;
        if (dAbs >= MAX_FIXED) {
            return DoubleFormatter.toString(d);
        }
        BigDecimal bigDecimal = new BigDecimal(dAbs, MathContext.UNLIMITED);
        if (bigDecimal.scale() > i) {
            bigDecimal = bigDecimal.setScale(i, RoundingMode.HALF_UP);
        }
        return toFixedString(bigDecimal, i, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String toFixedString(BigDecimal bigDecimal, int i, boolean z) {
        int iScale = bigDecimal.scale();
        String string = bigDecimal.unscaledValue().toString();
        int length = string.length();
        if (iScale == 0 && i == 0) {
            return z ? "-".concat(string) : string;
        }
        StringBuilder sb = new StringBuilder((length * 2) + 3);
        if (z) {
            sb.append('-');
        }
        if (iScale >= length) {
            sb.append("0.");
            fillZeroes(sb, iScale - length);
            sb.append(string);
        } else {
            int i2 = length - iScale;
            sb.append(string.substring(0, i2));
            sb.append('.');
            sb.append(string.substring(i2));
        }
        fillZeroes(sb, i - iScale);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String toPrecision(double d, int i) {
        int i2;
        int i3 = 0;
        boolean z = Math.signum(d) < 0.0d;
        if (z) {
            d = -d;
        }
        BigDecimal bigDecimal = new BigDecimal(d, new MathContext(i, RoundingMode.HALF_UP));
        int iScale = bigDecimal.scale();
        int iPrecision = bigDecimal.precision();
        if (iScale >= 0) {
            i3 = iScale >= iPrecision ? i : i - (iPrecision - iScale);
            i2 = iPrecision - iScale;
        } else {
            i2 = iPrecision + (-iScale);
        }
        int i4 = i2 - 1;
        return (i4 < -6 || i4 >= i) ? toExponentialString(bigDecimal, i4, i - 1, z) : toFixedString(bigDecimal, i3, z);
    }
}
