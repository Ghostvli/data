package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.N(1)),
    MICROS("Micros", Duration.N(1000)),
    MILLIS("Millis", Duration.N(1000000)),
    SECONDS("Seconds", Duration.H(1, 0)),
    MINUTES("Minutes", Duration.H(60, 0)),
    HOURS("Hours", Duration.H(3600, 0)),
    HALF_DAYS("HalfDays", Duration.H(43200, 0)),
    DAYS("Days", Duration.H(86400, 0)),
    WEEKS("Weeks", Duration.H(604800, 0)),
    MONTHS("Months", Duration.H(2629746, 0)),
    YEARS("Years", Duration.H(31556952, 0)),
    DECADES("Decades", Duration.H(315569520, 0)),
    CENTURIES("Centuries", Duration.H(3155695200L, 0)),
    MILLENNIA("Millennia", Duration.H(31556952000L, 0)),
    ERAS("Eras", Duration.H(31556952000000000L, 0)),
    FOREVER("Forever", Duration.H(Math.addExact(Long.MAX_VALUE, Math.floorDiv(999999999L, 1000000000L)), (int) Math.floorMod(999999999L, 1000000000L)));

    public final String a;
    public final Duration b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    ChronoUnit(String str, Duration duration) {
        this.a = str;
        this.b = duration;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalUnit
    public final Duration getDuration() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalUnit
    public boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalUnit
    public final l u(l lVar, long j) {
        return lVar.d(j, this);
    }
}
