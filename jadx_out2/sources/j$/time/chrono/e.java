package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface e extends j$.time.temporal.l, j$.time.temporal.m, Comparable {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default long B(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((n().S() * 86400) + ((long) j().p0())) - ((long) zoneOffset.b);
    }

    ChronoZonedDateTime M(ZoneId zoneId);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: X */
    default int compareTo(e eVar) {
        int iCompareTo = n().compareTo(eVar.n());
        return (iCompareTo == 0 && (iCompareTo = j().compareTo(eVar.j())) == 0) ? ((a) f()).q().compareTo(eVar.f().q()) : iCompareTo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(JLj$/time/temporal/TemporalUnit;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    default e a(long j, TemporalUnit temporalUnit) {
        return g.u(f(), super.a(j, temporalUnit));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.d dVar) {
        if (dVar == j$.time.temporal.q.a || dVar == j$.time.temporal.q.e || dVar == j$.time.temporal.q.d) {
            return null;
        }
        return dVar == j$.time.temporal.q.g ? j() : dVar == j$.time.temporal.q.b ? f() : dVar == j$.time.temporal.q.c ? ChronoUnit.NANOS : dVar.k(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.m
    default j$.time.temporal.l e(j$.time.temporal.l lVar) {
        return lVar.c(n().S(), j$.time.temporal.a.EPOCH_DAY).c(j().o0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default l f() {
        return n().f();
    }

    j$.time.i j();

    b n();
}
