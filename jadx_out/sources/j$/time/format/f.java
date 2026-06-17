package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends j {
    public final boolean g;

    public f(j$.time.temporal.p pVar, int i, int i2, boolean z) {
        this(pVar, i, i2, z, 0);
        Objects.requireNonNull(pVar, "field");
        j$.time.temporal.s sVarQ = pVar.Q();
        if (sVarQ.a != sVarQ.b || sVarQ.c != sVarQ.d) {
            j$.nio.file.j.a(j$.time.b.a("Field must have a fixed set of values: ", pVar));
            throw null;
        }
        if (i < 0 || i > 9) {
            j$.nio.file.j.m("Minimum width must be from 0 to 9 inclusive but was ", i);
            throw null;
        }
        if (i2 < 1 || i2 > 9) {
            j$.nio.file.j.m("Maximum width must be from 1 to 9 inclusive but was ", i2);
            throw null;
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    @Override // j$.time.format.j, j$.time.format.e
    public final int H(w wVar, CharSequence charSequence, int i) {
        boolean z = wVar.c;
        DateTimeFormatter dateTimeFormatter = wVar.a;
        int i2 = (z || b(wVar)) ? this.b : 0;
        int i3 = (wVar.c || b(wVar)) ? this.c : 9;
        int length = charSequence.length();
        if (i != length) {
            if (this.g) {
                char cCharAt = charSequence.charAt(i);
                dateTimeFormatter.c.getClass();
                if (cCharAt == '.') {
                    i++;
                } else if (i2 > 0) {
                    return ~i;
                }
            }
            int i4 = i;
            int i5 = i2 + i4;
            if (i5 > length) {
                return ~i4;
            }
            int iMin = Math.min(i3 + i4, length);
            int i6 = 0;
            int i7 = i4;
            while (true) {
                if (i7 >= iMin) {
                    break;
                }
                int i8 = i7 + 1;
                char cCharAt2 = charSequence.charAt(i7);
                dateTimeFormatter.c.getClass();
                int i9 = cCharAt2 - '0';
                if (i9 < 0 || i9 > 9) {
                    i9 = -1;
                }
                if (i9 >= 0) {
                    i6 = (i6 * 10) + i9;
                    i7 = i8;
                } else if (i8 < i5) {
                    return ~i4;
                }
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i6).movePointLeft(i7 - i4);
            j$.time.temporal.s sVarQ = this.a.Q();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(sVarQ.a);
            return wVar.g(this.a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(sVarQ.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i4, i7);
        }
        if (i2 > 0) {
            return ~i;
        }
        return i;
    }

    @Override // j$.time.format.j
    public final boolean b(w wVar) {
        return wVar.c && this.b == this.c && !this.g;
    }

    @Override // j$.time.format.j
    public final j d() {
        if (this.e == -1) {
            return this;
        }
        return new f(this.a, this.b, this.c, this.g, -1);
    }

    @Override // j$.time.format.j
    public final j e(int i) {
        return new f(this.a, this.b, this.c, this.g, this.e + i);
    }

    @Override // j$.time.format.j
    public final String toString() {
        return "Fraction(" + this.a + "," + this.b + "," + this.c + (this.g ? ",DecimalPoint" : "") + ")";
    }

    @Override // j$.time.format.j, j$.time.format.e
    public final boolean u(y yVar, StringBuilder sb) {
        j$.time.temporal.p pVar = this.a;
        Long lA = yVar.a(pVar);
        if (lA == null) {
            return false;
        }
        c0 c0Var = yVar.b.c;
        long jLongValue = lA.longValue();
        j$.time.temporal.s sVarQ = pVar.Q();
        sVarQ.b(jLongValue, pVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(sVarQ.a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(sVarQ.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z = this.g;
        int i = this.b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.c), roundingMode).toPlainString().substring(2);
            c0Var.getClass();
            if (z) {
                sb.append('.');
            }
            sb.append(strSubstring);
            return true;
        }
        if (i > 0) {
            if (z) {
                c0Var.getClass();
                sb.append('.');
            }
            for (int i2 = 0; i2 < i; i2++) {
                c0Var.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    public f(j$.time.temporal.p pVar, int i, int i2, boolean z, int i3) {
        super(pVar, i, i2, f0.NOT_NEGATIVE, i3);
        this.g = z;
    }
}
