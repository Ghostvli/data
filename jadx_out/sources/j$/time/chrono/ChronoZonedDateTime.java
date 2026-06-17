package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.b;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends b> extends j$.time.temporal.l, Comparable<ChronoZonedDateTime<?>> {
    e D();

    ChronoZonedDateTime L(ZoneId zoneId);

    ZoneId R();

    @Override // j$.time.temporal.l
    default ChronoZonedDateTime a(long j, TemporalUnit temporalUnit) {
        return k.u(f(), super.a(j, temporalUnit));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.d dVar) {
        return (dVar == j$.time.temporal.q.e || dVar == j$.time.temporal.q.a) ? R() : dVar == j$.time.temporal.q.d ? o() : dVar == j$.time.temporal.q.g ? j() : dVar == j$.time.temporal.q.b ? f() : dVar == j$.time.temporal.q.c ? ChronoUnit.NANOS : dVar.k(this);
    }

    @Override // j$.time.temporal.l
    ChronoZonedDateTime c(long j, j$.time.temporal.p pVar);

    @Override // j$.time.temporal.l
    ChronoZonedDateTime d(long j, TemporalUnit temporalUnit);

    default l f() {
        return n().f();
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return super.g(pVar);
        }
        int i = i.a[((j$.time.temporal.a) pVar).ordinal()];
        if (i != 1) {
            return i != 2 ? D().g(pVar) : o().b;
        }
        throw new j$.time.temporal.r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    default long h0() {
        return ((n().S() * 86400) + ((long) j().p0())) - ((long) o().b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.Y(this);
        }
        int i = i.a[((j$.time.temporal.a) pVar).ordinal()];
        return i != 1 ? i != 2 ? D().i(pVar) : o().b : h0();
    }

    default j$.time.i j() {
        return D().j();
    }

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.s l(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? (pVar == j$.time.temporal.a.INSTANT_SECONDS || pVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) pVar).b : D().l(pVar) : pVar.H(this);
    }

    @Override // j$.time.temporal.l
    default ChronoZonedDateTime m(j$.time.temporal.m mVar) {
        return k.u(f(), mVar.e(this));
    }

    default b n() {
        return D().n();
    }

    ZoneOffset o();

    default Instant toInstant() {
        return Instant.N(h0(), j().d);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    default int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int iCompare = Long.compare(h0(), chronoZonedDateTime.h0());
        return (iCompare == 0 && (iCompare = j().d - chronoZonedDateTime.j().d) == 0 && (iCompare = D().compareTo(chronoZonedDateTime.D())) == 0 && (iCompare = R().q().compareTo(chronoZonedDateTime.R().q())) == 0) ? ((a) f()).q().compareTo(chronoZonedDateTime.f().q()) : iCompare;
    }
}
