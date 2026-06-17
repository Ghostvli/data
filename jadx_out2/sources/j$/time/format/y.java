package j$.time.format;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public final TemporalAccessor a;
    public final DateTimeFormatter b;
    public int c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.zone.f fVarH;
        j$.time.chrono.l lVar = dateTimeFormatter.e;
        ZoneId zoneId = dateTimeFormatter.f;
        if (lVar != null || zoneId != null) {
            j$.time.chrono.l lVar2 = (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.q.b);
            ZoneId zoneId2 = (ZoneId) temporalAccessor.b(j$.time.temporal.q.a);
            j$.time.chrono.b bVarO = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            zoneId = Objects.equals(zoneId, zoneId2) ? null : zoneId;
            if (lVar != null || zoneId != null) {
                j$.time.chrono.l lVar3 = lVar != null ? lVar : lVar2;
                if (zoneId == null) {
                    zoneId2 = zoneId != null ? zoneId : zoneId2;
                    if (lVar != null) {
                        if (temporalAccessor.h(j$.time.temporal.a.EPOCH_DAY)) {
                            bVarO = lVar3.O(temporalAccessor);
                        } else if (lVar != j$.time.chrono.s.c || lVar2 != null) {
                            for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                                if (aVar.isDateBased() && temporalAccessor.h(aVar)) {
                                    j$.nio.file.j.l("Unable to apply override chronology '", lVar, "' because the temporal object being formatted contains date fields but does not represent a whole date: ", temporalAccessor);
                                    throw null;
                                }
                            }
                        }
                    }
                    temporalAccessor = new x(bVarO, temporalAccessor, lVar3, zoneId2);
                } else if (temporalAccessor.h(j$.time.temporal.a.INSTANT_SECONDS)) {
                    j$.time.chrono.s sVar = j$.time.chrono.s.c;
                    if (lVar3 == null) {
                        Objects.requireNonNull(sVar, "defaultObj");
                        lVar3 = sVar;
                    }
                    temporalAccessor = lVar3.c0(Instant.H(temporalAccessor), zoneId);
                } else {
                    try {
                        fVarH = zoneId.H();
                    } catch (j$.time.zone.g unused) {
                    }
                    ZoneId zoneIdD = fVarH.h() ? fVarH.d(Instant.EPOCH) : zoneId;
                    if (zoneIdD instanceof ZoneOffset) {
                        j$.time.temporal.a aVar2 = j$.time.temporal.a.OFFSET_SECONDS;
                        if (temporalAccessor.h(aVar2) && temporalAccessor.g(aVar2) != zoneId.H().d(Instant.EPOCH).b) {
                            j$.nio.file.j.l("Unable to apply override zone '", zoneId, "' because the temporal object being formatted has a different offset but does not represent an instant: ", temporalAccessor);
                            throw null;
                        }
                    }
                    if (zoneId != null) {
                    }
                    if (lVar != null) {
                    }
                    temporalAccessor = new x(bVarO, temporalAccessor, lVar3, zoneId2);
                }
            }
        }
        this.a = temporalAccessor;
        this.b = dateTimeFormatter;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long a(j$.time.temporal.p pVar) {
        int i = this.c;
        TemporalAccessor temporalAccessor = this.a;
        if (i <= 0 || temporalAccessor.h(pVar)) {
            return Long.valueOf(temporalAccessor.i(pVar));
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object b(j$.time.d dVar) {
        TemporalAccessor temporalAccessor = this.a;
        Object objB = temporalAccessor.b(dVar);
        if (objB != null || this.c != 0) {
            return objB;
        }
        j$.nio.file.j.l("Unable to extract ", dVar, " from temporal ", temporalAccessor);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        return this.a.toString();
    }
}
