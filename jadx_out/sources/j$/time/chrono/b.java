package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends j$.time.temporal.l, j$.time.temporal.m, Comparable {
    default boolean E() {
        return f().g0(i(j$.time.temporal.a.YEAR));
    }

    default long S() {
        return i(j$.time.temporal.a.EPOCH_DAY);
    }

    default e T(j$.time.i iVar) {
        return new g(this, iVar);
    }

    default m V() {
        return f().I(g(j$.time.temporal.a.ERA));
    }

    @Override // j$.time.temporal.l
    default b a(long j, TemporalUnit temporalUnit) {
        return d.u(f(), super.a(j, temporalUnit));
    }

    b a0(j$.time.temporal.o oVar);

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.d dVar) {
        if (dVar == j$.time.temporal.q.a || dVar == j$.time.temporal.q.e || dVar == j$.time.temporal.q.d || dVar == j$.time.temporal.q.g) {
            return null;
        }
        return dVar == j$.time.temporal.q.b ? f() : dVar == j$.time.temporal.q.c ? ChronoUnit.DAYS : dVar.k(this);
    }

    @Override // j$.time.temporal.l
    b c(long j, j$.time.temporal.p pVar);

    @Override // j$.time.temporal.l
    b d(long j, TemporalUnit temporalUnit);

    default int d0() {
        return E() ? 366 : 365;
    }

    @Override // j$.time.temporal.m
    default j$.time.temporal.l e(j$.time.temporal.l lVar) {
        return lVar.c(S(), j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e0 */
    default int compareTo(b bVar) {
        int iCompare = Long.compare(S(), bVar.S());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((a) f()).q().compareTo(bVar.f().q());
    }

    boolean equals(Object obj);

    l f();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).isDateBased() : pVar != null && pVar.u(this);
    }

    int hashCode();

    b m(j$.time.temporal.m mVar);

    String toString();
}
