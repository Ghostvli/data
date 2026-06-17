package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public enum h implements TemporalUnit {
    WEEK_BASED_YEARS("WeekBasedYears", Duration.H(31556952, 0)),
    QUARTER_YEARS("QuarterYears", Duration.H(7889238, 0));

    public final String a;
    public final Duration b;

    h(String str, Duration duration) {
        this.a = str;
        this.b = duration;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final Duration getDuration() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final boolean isDateBased() {
        throw null;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final l u(l lVar, long j) {
        int i = b.a[ordinal()];
        if (i == 1) {
            return lVar.c(Math.addExact(lVar.g(r4), j), i.c);
        }
        if (i == 2) {
            return lVar.d(j / 4, ChronoUnit.YEARS).d((j % 4) * 3, ChronoUnit.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }
}
