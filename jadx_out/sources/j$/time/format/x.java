package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements TemporalAccessor {
    public final /* synthetic */ j$.time.chrono.b a;
    public final /* synthetic */ TemporalAccessor b;
    public final /* synthetic */ j$.time.chrono.l c;
    public final /* synthetic */ ZoneId d;

    public x(j$.time.chrono.b bVar, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.a = bVar;
        this.b = temporalAccessor;
        this.c = lVar;
        this.d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.d dVar) {
        return dVar == j$.time.temporal.q.b ? this.c : dVar == j$.time.temporal.q.a ? this.d : dVar == j$.time.temporal.q.c ? this.b.b(dVar) : dVar.k(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.p pVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !pVar.isDateBased()) ? this.b.h(pVar) : bVar.h(pVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !pVar.isDateBased()) ? this.b.i(pVar) : bVar.i(pVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        j$.time.chrono.b bVar = this.a;
        return (bVar == null || !pVar.isDateBased()) ? this.b.l(pVar) : bVar.l(pVar);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.b + str + str2;
    }
}
