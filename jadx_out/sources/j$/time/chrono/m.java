package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface m extends TemporalAccessor, j$.time.temporal.m {
    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.d dVar) {
        return dVar == j$.time.temporal.q.c ? ChronoUnit.ERAS : super.b(dVar);
    }

    @Override // j$.time.temporal.m
    default j$.time.temporal.l e(j$.time.temporal.l lVar) {
        return lVar.c(getValue(), j$.time.temporal.a.ERA);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.p pVar) {
        return pVar == j$.time.temporal.a.ERA ? getValue() : super.g(pVar);
    }

    int getValue();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? pVar == j$.time.temporal.a.ERA : pVar != null && pVar.u(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.p pVar) {
        if (pVar == j$.time.temporal.a.ERA) {
            return getValue();
        }
        if (pVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
        }
        return pVar.Y(this);
    }
}
