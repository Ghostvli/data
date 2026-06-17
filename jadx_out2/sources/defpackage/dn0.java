package defpackage;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dn0 {
    public static final double a = Math.log(2.0d);
    public static final double[] b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a(double d, double d2, double d3) {
        p62.b("tolerance", d3);
        if (Math.copySign(d - d2, 1.0d) <= d3 || d == d2) {
            return true;
        }
        return Double.isNaN(d) && Double.isNaN(d2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(double d) {
        if (en0.b(d)) {
            return d == 0.0d || 52 - Long.numberOfTrailingZeros(en0.a(d)) <= Math.getExponent(d);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c(double d) {
        if (d > 0.0d && en0.b(d)) {
            long jA = en0.a(d);
            if ((jA & (jA - 1)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(double d, RoundingMode roundingMode) {
        boolean zC;
        gg3.e(d > 0.0d && en0.b(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (!en0.c(d)) {
            return d(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                p62.e(c(d));
                return !z ? exponent + 1 : exponent;
            case 2:
                if (!z) {
                }
                break;
            case 3:
                z = !c(d);
                if (!z) {
                }
                break;
            case 4:
                z = exponent < 0;
                zC = c(d);
                z &= !zC;
                if (!z) {
                }
                break;
            case 5:
                z = exponent >= 0;
                zC = c(d);
                z &= !zC;
                if (!z) {
                }
                break;
            case 6:
            case 7:
            case 8:
                double d2 = en0.d(d);
                if (d2 * d2 > 2.0d) {
                    z = true;
                }
                if (!z) {
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static double e(double d, RoundingMode roundingMode) {
        if (!en0.b(d)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                p62.e(b(d));
                return d;
            case 2:
                return (d >= 0.0d || b(d)) ? d : ((long) d) - 1;
            case 3:
                return (d <= 0.0d || b(d)) ? d : ((long) d) + 1;
            case 4:
                return d;
            case 5:
                if (b(d)) {
                    return d;
                }
                return ((long) d) + ((long) (d > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d);
            case 7:
                double dRint = Math.rint(d);
                return Math.abs(d - dRint) == 0.5d ? d + Math.copySign(0.5d, d) : dRint;
            case 8:
                double dRint2 = Math.rint(d);
                return Math.abs(d - dRint2) == 0.5d ? d : dRint2;
            default:
                throw new AssertionError();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long f(double d, RoundingMode roundingMode) {
        double dE = e(d, roundingMode);
        p62.a(((-9.223372036854776E18d) - dE < 1.0d) & (dE < 9.223372036854776E18d), d, roundingMode);
        return (long) dE;
    }
}
