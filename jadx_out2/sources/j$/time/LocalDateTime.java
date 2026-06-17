package j$.time;

import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.l, j$.time.temporal.m, j$.time.chrono.e, Serializable {
    public static final LocalDateTime c = Q(LocalDate.d, i.e);
    public static final LocalDateTime d = Q(LocalDate.e, i.f);
    private static final long serialVersionUID = 6207766400415563566L;
    public final LocalDate a;
    public final i b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LocalDateTime(LocalDate localDate, i iVar) {
        this.a = localDate;
        this.b = iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static LocalDateTime H(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).a;
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).a;
        }
        try {
            return new LocalDateTime(LocalDate.N(temporalAccessor), i.N(temporalAccessor));
        } catch (DateTimeException e) {
            j$.nio.file.j.g("Unable to obtain LocalDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static LocalDateTime Q(LocalDate localDate, i iVar) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(iVar, "time");
        return new LocalDateTime(localDate, iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static LocalDateTime Y(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j2 = i;
        j$.time.temporal.a.NANO_OF_SECOND.i0(j2);
        long j3 = j + ((long) zoneOffset.b);
        return new LocalDateTime(LocalDate.n0(Math.floorDiv(j3, 86400L)), i.f0((((long) ((int) Math.floorMod(j3, 86400L))) * 1000000000) + j2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static LocalDateTime now() {
        a aVarZ = j$.desugar.sun.nio.fs.g.z();
        Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        return Y(instantOfEpochMilli.a, instantOfEpochMilli.b, aVarZ.a.H().d(instantOfEpochMilli));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return Y(instant.a, instant.b, zoneId.H().d(instant));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.a(charSequence, new d(2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object writeReplace() {
        return new q((byte) 5, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean N(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return u((LocalDateTime) eVar) < 0;
        }
        long jS = this.a.S();
        long jS2 = eVar.n().S();
        if (jS >= jS2) {
            return jS == jS2 && this.b.o0() < eVar.j().o0();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // j$.time.chrono.e, java.lang.Comparable
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.e eVar) {
        return eVar instanceof LocalDateTime ? u((LocalDateTime) eVar) : super.compareTo(eVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: M(Lj$/time/ZoneId;)Lj$/time/chrono/ChronoZonedDateTime; */
    @Override // j$.time.chrono.e
    /* JADX INFO: renamed from: atZone, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime M(ZoneId zoneId) {
        return ZonedDateTime.N(this, zoneId, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(d dVar) {
        return dVar == j$.time.temporal.q.f ? this.a : super.b(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.a.equals(localDateTime.a) && this.b.equals(localDateTime.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(JLj$/time/temporal/TemporalUnit;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.u(this, j);
        }
        switch (g.a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return k0(this.a, 0L, 0L, 0L, j);
            case 2:
                LocalDateTime localDateTimeI0 = i0(j / 86400000000L);
                return localDateTimeI0.k0(localDateTimeI0.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimeI02 = i0(j / 86400000);
                return localDateTimeI02.k0(localDateTimeI02.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return j0(j);
            case 5:
                return k0(this.a, 0L, j, 0L, 0L);
            case 6:
                return k0(this.a, j, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimeI03 = i0(j / 256);
                return localDateTimeI03.k0(localDateTimeI03.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return m0(this.a.d(j, temporalUnit), this.b);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() ? this.b.g(pVar) : this.a.g(pVar) : super.g(pVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar != null && pVar.u(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        return aVar.isDateBased() || aVar.j0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() ? this.b.i(pVar) : this.a.i(pVar) : pVar.Y(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final LocalDateTime i0(long j) {
        return m0(this.a.plusDays(j), this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.e
    public final i j() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final LocalDateTime j0(long j) {
        return k0(this.a, 0L, 0L, j, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final LocalDateTime k0(LocalDate localDate, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        i iVar = this.b;
        if (j5 == 0) {
            return m0(localDate, iVar);
        }
        long j6 = j / 24;
        long jO0 = iVar.o0();
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L) + jO0;
        long jFloorDiv = Math.floorDiv(j7, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jFloorMod = Math.floorMod(j7, 86400000000000L);
        return m0(localDate.plusDays(jFloorDiv), jFloorMod == jO0 ? this.b : i.f0(jFloorMod));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() ? this.b.l(pVar) : this.a.l(pVar) : pVar.H(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(JLj$/time/temporal/p;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (LocalDateTime) pVar.f0(this, j);
        }
        boolean zJ0 = ((j$.time.temporal.a) pVar).j0();
        LocalDate localDate = this.a;
        return zJ0 ? m0(localDate, this.b.c(j, pVar)) : m0(localDate.c(j, pVar), this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final LocalDateTime m0(LocalDate localDate, i iVar) {
        return (this.a == localDate && this.b == iVar) ? this : new LocalDateTime(localDate, iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(JLj$/time/temporal/TemporalUnit;)Lj$/time/chrono/e; */
    /* JADX DEBUG: Method merged with bridge method: a(JLj$/time/temporal/TemporalUnit;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: minus, reason: merged with bridge method [inline-methods] */
    public LocalDateTime a(long j, TemporalUnit temporalUnit) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = d(Long.MAX_VALUE, temporalUnit);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.d(j2, temporalUnit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LocalDateTime minusDays(long j) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = i0(Long.MAX_VALUE);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.i0(j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LocalDateTime minusYears(long j) {
        LocalDate localDateS0;
        LocalDate localDate = this.a;
        if (j == Long.MIN_VALUE) {
            this = m0(localDate.s0(Long.MAX_VALUE), this.b);
            localDateS0 = this.a.s0(1L);
        } else {
            localDateS0 = localDate.s0(-j);
        }
        return this.m0(localDateS0, this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.e
    public final j$.time.chrono.b n() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: k(Lj$/time/LocalDate;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime m(j$.time.temporal.m mVar) {
        return mVar instanceof LocalDate ? m0((LocalDate) mVar, this.b) : mVar instanceof i ? m0(this.a, (i) mVar) : mVar instanceof LocalDateTime ? (LocalDateTime) mVar : (LocalDateTime) mVar.e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LocalDateTime truncatedTo(TemporalUnit temporalUnit) {
        LocalDate localDate = this.a;
        i iVarF0 = this.b;
        iVarF0.getClass();
        if (temporalUnit != ChronoUnit.NANOS) {
            Duration duration = temporalUnit.getDuration();
            long j = duration.a;
            if (j > 86400) {
                throw new j$.time.temporal.r("Unit is too large to be used for truncation");
            }
            long j2 = duration.b;
            if (j < 0) {
                j++;
                j2 -= 1000000000;
            }
            long jAddExact = Math.addExact(Math.multiplyExact(j, 1000000000L), j2);
            if (86400000000000L % jAddExact != 0) {
                throw new j$.time.temporal.r("Unit must divide into a standard day without remainder");
            }
            iVarF0 = i.f0((iVarF0.o0() / jAddExact) * jAddExact);
        }
        return m0(localDate, iVarF0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u(LocalDateTime localDateTime) {
        int iU = this.a.u(localDateTime.a);
        return iU == 0 ? this.b.compareTo(localDateTime.b) : iU;
    }
}
