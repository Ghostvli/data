package j$.time;

import com.hierynomus.msdtyp.FileTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalDate implements j$.time.temporal.l, j$.time.temporal.m, j$.time.chrono.b, Serializable {
    public static final LocalDate d = m0(-999999999, 1, 1);
    public static final LocalDate e = m0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    public final int a;
    public final short b;
    public final short c;

    static {
        m0(1970, 1, 1);
    }

    public LocalDate(int i, int i2, int i3) {
        this.a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    public static LocalDate H(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (j$.time.chrono.s.c.g0(i)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    j$.nio.file.j.c("Invalid date 'February 29' as '", i, "' is not a leap year");
                    return null;
                }
                throw new DateTimeException("Invalid date '" + k.Q(i2).name() + " " + i3 + "'");
            }
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate N(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.b(j$.time.temporal.q.f);
        if (localDate != null) {
            return localDate;
        }
        j$.nio.file.j.f("Unable to obtain LocalDate from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static LocalDate l0(a aVar) {
        Objects.requireNonNull(aVar, "clock");
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), aVar.a);
    }

    public static LocalDate m0(int i, int i2, int i3) {
        j$.time.temporal.a.YEAR.i0(i);
        j$.time.temporal.a.MONTH_OF_YEAR.i0(i2);
        j$.time.temporal.a.DAY_OF_MONTH.i0(i3);
        return H(i, i2, i3);
    }

    public static LocalDate n0(long j) {
        long j2;
        j$.time.temporal.a.EPOCH_DAY.i0(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / Token.SETPROP_OP;
        int i3 = ((i2 + 2) % 12) + 1;
        int i4 = (i - (((i2 * 306) + 5) / 10)) + 1;
        long j7 = j5 + j2 + ((long) (i2 / 10));
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new LocalDate(aVar.b.a(j7, aVar), i3, i4);
    }

    public static LocalDate now(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return l0(zoneId == ZoneOffset.UTC ? a.b : new a(zoneId));
    }

    public static LocalDate o0(int i, int i2) {
        long j = i;
        j$.time.temporal.a.YEAR.i0(j);
        j$.time.temporal.a.DAY_OF_YEAR.i0(i2);
        boolean zG0 = j$.time.chrono.s.c.g0(j);
        if (i2 == 366 && !zG0) {
            j$.nio.file.j.c("Invalid date 'DayOfYear 366' as '", i, "' is not a leap year");
            return null;
        }
        k kVarQ = k.Q(((i2 - 1) / 31) + 1);
        if (i2 > (kVarQ.H(zG0) + kVarQ.u(zG0)) - 1) {
            kVarQ = k.a[(kVarQ.ordinal() + 13) % 12];
        }
        return new LocalDate(i, kVarQ.getValue(), (i2 - kVarQ.u(zG0)) + 1);
    }

    public static LocalDate ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return n0(Math.floorDiv(instant.a + ((long) zoneId.H().d(instant).b), 86400L));
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.a(charSequence, new d(1));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static LocalDate t0(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, j$.time.chrono.s.c.g0((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new LocalDate(i, i2, i3);
    }

    private Object writeReplace() {
        return new q((byte) 3, this);
    }

    @Override // j$.time.chrono.b
    public final boolean E() {
        return j$.time.chrono.s.c.g0(this.a);
    }

    public final int Q(j$.time.temporal.p pVar) {
        switch (f.a[((j$.time.temporal.a) pVar).ordinal()]) {
            case 1:
                return this.c;
            case 2:
                return f0();
            case 3:
                return ((this.c - 1) / 7) + 1;
            case 4:
                int i = this.a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return Y().getValue();
            case 6:
                return ((this.c - 1) % 7) + 1;
            case 7:
                return ((f0() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.r("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((f0() - 1) / 7) + 1;
            case 10:
                return this.b;
            case 11:
                throw new j$.time.temporal.r("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.a;
            case 13:
                return this.a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.r(b.a("Unsupported field: ", pVar));
        }
    }

    @Override // j$.time.chrono.b
    public final long S() {
        long j = this.a;
        long j2 = this.b;
        long j3 = 365 * j;
        long j4 = (((367 * j2) - 362) / 12) + (j >= 0 ? ((j + 399) / 400) + (((3 + j) / 4) - ((99 + j) / 100)) + j3 : j3 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + ((long) (this.c - 1));
        if (j2 > 2) {
            j4 = !E() ? j4 - 2 : j4 - 1;
        }
        return j4 - 719528;
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.e T(i iVar) {
        return LocalDateTime.Q(this, iVar);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.m V() {
        return this.a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    public final c Y() {
        return c.u(((int) Math.floorMod(S() + 3, 7L)) + 1);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.b a0(j$.time.temporal.o oVar) {
        if (oVar != null) {
            p pVar = (p) oVar;
            return q0((((long) pVar.a) * 12) + ((long) pVar.b)).plusDays(pVar.c);
        }
        Objects.requireNonNull(oVar, "amountToAdd");
        return (LocalDate) ((p) oVar).u(this);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.Q(this, i.g);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(d dVar) {
        return dVar == j$.time.temporal.q.f ? this : super.b(dVar);
    }

    @Override // j$.time.chrono.b
    public final int d0() {
        return E() ? 366 : 365;
    }

    @Override // j$.time.chrono.b, java.lang.Comparable
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        return bVar instanceof LocalDate ? u((LocalDate) bVar) : super.compareTo(bVar);
    }

    @Override // j$.time.chrono.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && u((LocalDate) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.l f() {
        return j$.time.chrono.s.c;
    }

    public final int f0() {
        return (k.Q(this.b).u(E()) + this.c) - 1;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? Q(pVar) : super.g(pVar);
    }

    @Override // j$.time.chrono.b
    public final int hashCode() {
        int i = this.a;
        return (i & (-2048)) ^ (((i << 11) + (this.b << 6)) + this.c);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? pVar == j$.time.temporal.a.EPOCH_DAY ? S() : pVar == j$.time.temporal.a.PROLEPTIC_MONTH ? ((((long) this.a) * 12) + ((long) this.b)) - 1 : Q(pVar) : pVar.Y(this);
    }

    public final boolean i0(j$.time.chrono.b bVar) {
        return bVar instanceof LocalDate ? u((LocalDate) bVar) < 0 : S() < bVar.S();
    }

    public final int j0() {
        short s = this.b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : E() ? 29 : 28;
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final LocalDate a(long j, TemporalUnit temporalUnit) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = d(Long.MAX_VALUE, temporalUnit);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.d(j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.H(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.r(b.a("Unsupported field: ", pVar));
        }
        int i = f.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.s.f(1L, j0());
        }
        if (i == 2) {
            return j$.time.temporal.s.f(1L, d0());
        }
        if (i != 3) {
            return i != 4 ? aVar.b : this.a <= 0 ? j$.time.temporal.s.f(1L, 1000000000L) : j$.time.temporal.s.f(1L, 999999999L);
        }
        return j$.time.temporal.s.f(1L, (k.Q(this.b) != k.FEBRUARY || E()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public final LocalDate d(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.u(this, j);
        }
        switch (f.b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusDays(j);
            case 2:
                return r0(j);
            case 3:
                return q0(j);
            case 4:
                return s0(j);
            case 5:
                return s0(Math.multiplyExact(j, 10L));
            case 6:
                return s0(Math.multiplyExact(j, 100L));
            case 7:
                return s0(Math.multiplyExact(j, 1000L));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j), aVar);
            default:
                j$.nio.file.j.d("Unsupported unit: ", temporalUnit);
                return null;
        }
    }

    public LocalDate plusDays(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((long) this.c) + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new LocalDate(this.a, this.b, (int) j2);
            }
            if (j2 <= 59) {
                long jJ0 = j0();
                if (j2 <= jJ0) {
                    return new LocalDate(this.a, this.b, (int) j2);
                }
                short s = this.b;
                if (s < 12) {
                    return new LocalDate(this.a, s + 1, (int) (j2 - jJ0));
                }
                j$.time.temporal.a.YEAR.i0(this.a + 1);
                return new LocalDate(this.a + 1, 1, (int) (j2 - jJ0));
            }
        }
        return n0(Math.addExact(S(), j));
    }

    public final LocalDate q0(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.a) * 12) + ((long) (this.b - 1)) + j;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return t0(aVar.b.a(Math.floorDiv(j2, 12L), aVar), ((int) Math.floorMod(j2, 12L)) + 1, this.c);
    }

    public final LocalDate r0(long j) {
        return plusDays(Math.multiplyExact(j, 7L));
    }

    public final LocalDate s0(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return t0(aVar.b.a(((long) this.a) + j, aVar), this.b, this.c);
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        int i = this.a;
        short s = this.b;
        short s2 = this.c;
        int iAbs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + FileTime.NANO100_TO_MILLI);
            sb.deleteCharAt(0);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    public final int u(LocalDate localDate) {
        int i = this.a - localDate.a;
        return (i == 0 && (i = this.b - localDate.b) == 0) ? this.c - localDate.c : i;
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public final LocalDate c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (LocalDate) pVar.f0(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        aVar.i0(j);
        switch (f.a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.c != i) {
                    return m0(this.a, this.b, i);
                }
                return this;
            case 2:
                int i2 = (int) j;
                if (f0() != i2) {
                    return o0(this.a, i2);
                }
                return this;
            case 3:
                return r0(j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.a < 1) {
                    j = 1 - j;
                }
                return w0((int) j);
            case 5:
                return plusDays(j - ((long) Y().getValue()));
            case 6:
                return plusDays(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return plusDays(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return n0(j);
            case 9:
                return r0(j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i3 = (int) j;
                if (this.b != i3) {
                    j$.time.temporal.a.MONTH_OF_YEAR.i0(i3);
                    return t0(this.a, i3, this.c);
                }
                return this;
            case 11:
                return q0(j - (((((long) this.a) * 12) + ((long) this.b)) - 1));
            case 12:
                return w0((int) j);
            case 13:
                if (i(j$.time.temporal.a.ERA) != j) {
                    return w0(1 - this.a);
                }
                return this;
            default:
                throw new j$.time.temporal.r(b.a("Unsupported field: ", pVar));
        }
    }

    @Override // j$.time.chrono.b
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final LocalDate m(j$.time.temporal.m mVar) {
        return mVar instanceof LocalDate ? (LocalDate) mVar : (LocalDate) mVar.e(this);
    }

    public final LocalDate w0(int i) {
        if (this.a == i) {
            return this;
        }
        j$.time.temporal.a.YEAR.i0(i);
        return t0(i, this.b, this.c);
    }

    public static LocalDate now() {
        return l0(j$.desugar.sun.nio.fs.g.z());
    }
}
