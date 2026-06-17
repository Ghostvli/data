package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements j$.time.temporal.m {
    public final /* synthetic */ int a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [j$.time.Instant.parse(java.lang.CharSequence):j$.time.Instant, j$.time.LocalDate.parse(java.lang.CharSequence, j$.time.format.DateTimeFormatter):j$.time.LocalDate, j$.time.LocalDateTime.parse(java.lang.CharSequence, j$.time.format.DateTimeFormatter):j$.time.LocalDateTime, j$.time.OffsetDateTime.parse(java.lang.CharSequence, j$.time.format.DateTimeFormatter):j$.time.OffsetDateTime, j$.time.ZonedDateTime.parse(java.lang.CharSequence, j$.time.format.DateTimeFormatter):j$.time.ZonedDateTime, j$.time.temporal.q.<clinit>():void] */
    public /* synthetic */ d(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.m
    public j$.time.temporal.l e(j$.time.temporal.l lVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return lVar.c(lVar.l(aVar).d, aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object k(TemporalAccessor temporalAccessor) {
        int i = this.a;
        d dVar = j$.time.temporal.q.a;
        Object objOfInstant = null;
        switch (i) {
            case 0:
                return Instant.H(temporalAccessor);
            case 1:
                return LocalDate.N(temporalAccessor);
            case 2:
                return LocalDateTime.H(temporalAccessor);
            case 3:
                int i2 = OffsetDateTime.c;
                if (temporalAccessor instanceof OffsetDateTime) {
                    return (OffsetDateTime) temporalAccessor;
                }
                try {
                    ZoneOffset zoneOffsetI0 = ZoneOffset.i0(temporalAccessor);
                    LocalDate localDate = (LocalDate) temporalAccessor.b(j$.time.temporal.q.f);
                    i iVar = (i) temporalAccessor.b(j$.time.temporal.q.g);
                    objOfInstant = (localDate == null || iVar == null) ? OffsetDateTime.ofInstant(Instant.H(temporalAccessor), zoneOffsetI0) : new OffsetDateTime(LocalDateTime.Q(localDate, iVar), zoneOffsetI0);
                    return objOfInstant;
                } catch (DateTimeException e) {
                    j$.nio.file.j.g("Unable to obtain OffsetDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e);
                    return objOfInstant;
                }
            case 4:
                if (temporalAccessor instanceof ZonedDateTime) {
                    return (ZonedDateTime) temporalAccessor;
                }
                try {
                    ZoneId zoneIdU = ZoneId.u(temporalAccessor);
                    j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
                    objOfInstant = temporalAccessor.h(aVar) ? ZonedDateTime.u(temporalAccessor.i(aVar), temporalAccessor.g(j$.time.temporal.a.NANO_OF_SECOND), zoneIdU) : ZonedDateTime.N(LocalDateTime.Q(LocalDate.N(temporalAccessor), i.N(temporalAccessor)), zoneIdU, null);
                    return objOfInstant;
                } catch (DateTimeException e2) {
                    j$.nio.file.j.g("Unable to obtain ZonedDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e2);
                    return objOfInstant;
                }
            case 5:
                ZoneId zoneId = (ZoneId) temporalAccessor.b(dVar);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 6:
            default:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_DAY;
                if (temporalAccessor.h(aVar2)) {
                    return i.f0(temporalAccessor.i(aVar2));
                }
                return null;
            case 7:
                return (ZoneId) temporalAccessor.b(dVar);
            case 8:
                return (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.q.b);
            case 9:
                return (TemporalUnit) temporalAccessor.b(j$.time.temporal.q.c);
            case 10:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.OFFSET_SECONDS;
                if (temporalAccessor.h(aVar3)) {
                    return ZoneOffset.l0(temporalAccessor.g(aVar3));
                }
                return null;
            case 11:
                ZoneId zoneId2 = (ZoneId) temporalAccessor.b(dVar);
                return zoneId2 != null ? zoneId2 : (ZoneId) temporalAccessor.b(j$.time.temporal.q.d);
            case 12:
                j$.time.temporal.a aVar4 = j$.time.temporal.a.EPOCH_DAY;
                if (temporalAccessor.h(aVar4)) {
                    return LocalDate.n0(temporalAccessor.i(aVar4));
                }
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        switch (this.a) {
            case 7:
                return "ZoneId";
            case 8:
                return "Chronology";
            case 9:
                return "Precision";
            case 10:
                return "ZoneOffset";
            case 11:
                return "Zone";
            case 12:
                return "LocalDate";
            case 13:
                return "LocalTime";
            default:
                return super.toString();
        }
    }
}
