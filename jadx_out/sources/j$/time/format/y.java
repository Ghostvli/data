package j$.time.format;

import j$.time.temporal.TemporalAccessor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public final TemporalAccessor a;
    public final DateTimeFormatter b;
    public int c;

    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y(j$.time.temporal.TemporalAccessor r10, j$.time.format.DateTimeFormatter r11) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.y.<init>(j$.time.temporal.TemporalAccessor, j$.time.format.DateTimeFormatter):void");
    }

    public final Long a(j$.time.temporal.p pVar) {
        int i = this.c;
        TemporalAccessor temporalAccessor = this.a;
        if (i <= 0 || temporalAccessor.h(pVar)) {
            return Long.valueOf(temporalAccessor.i(pVar));
        }
        return null;
    }

    public final Object b(j$.time.d dVar) {
        TemporalAccessor temporalAccessor = this.a;
        Object objB = temporalAccessor.b(dVar);
        if (objB != null || this.c != 0) {
            return objB;
        }
        j$.nio.file.j.l("Unable to extract ", dVar, " from temporal ", temporalAccessor);
        return null;
    }

    public final String toString() {
        return this.a.toString();
    }
}
