package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.format.d0;
import j$.time.format.e0;
import java.util.Map;
import org.mozilla.javascript.Token;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements p {
    public static final g DAY_OF_QUARTER;
    public static final g QUARTER_OF_YEAR;
    public static final g WEEK_BASED_YEAR;
    public static final g WEEK_OF_WEEK_BASED_YEAR;
    public static final int[] a;
    public static final /* synthetic */ g[] b;

    static {
        g gVar = new g() { // from class: j$.time.temporal.c
            @Override // j$.time.temporal.p
            public final s H(TemporalAccessor temporalAccessor) {
                if (!u(temporalAccessor)) {
                    throw new r("Unsupported field: DayOfQuarter");
                }
                long jI = temporalAccessor.i(g.QUARTER_OF_YEAR);
                if (jI == 1) {
                    return j$.time.chrono.s.c.g0(temporalAccessor.i(a.YEAR)) ? s.f(1L, 91L) : s.f(1L, 90L);
                }
                return jI == 2 ? s.f(1L, 91L) : (jI == 3 || jI == 4) ? s.f(1L, 92L) : Q();
            }

            @Override // j$.time.temporal.p
            public final TemporalAccessor N(Map map, d0 d0Var, e0 e0Var) {
                LocalDate localDateM0;
                long jSubtractExact;
                a aVar = a.YEAR;
                Long l = (Long) map.get(aVar);
                p pVar = g.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(pVar);
                if (l != null && l2 != null) {
                    int iA = aVar.b.a(l.longValue(), aVar);
                    long jLongValue = ((Long) map.get(g.DAY_OF_QUARTER)).longValue();
                    g gVar2 = i.a;
                    if (j$.time.chrono.l.s(d0Var).equals(j$.time.chrono.s.c)) {
                        if (e0Var == e0.LENIENT) {
                            localDateM0 = LocalDate.m0(iA, 1, 1).q0(Math.multiplyExact(Math.subtractExact(l2.longValue(), 1L), 3L));
                            jSubtractExact = Math.subtractExact(jLongValue, 1L);
                        } else {
                            localDateM0 = LocalDate.m0(iA, ((pVar.Q().a(l2.longValue(), pVar) - 1) * 3) + 1, 1);
                            if (jLongValue < 1 || jLongValue > 90) {
                                if (e0Var == e0.STRICT) {
                                    H(localDateM0).b(jLongValue, this);
                                } else {
                                    Q().b(jLongValue, this);
                                }
                            }
                            jSubtractExact = jLongValue - 1;
                        }
                        map.remove(this);
                        map.remove(aVar);
                        map.remove(pVar);
                        return localDateM0.plusDays(jSubtractExact);
                    }
                    j$.nio.file.j.h("Resolve requires IsoChronology");
                }
                return null;
            }

            @Override // j$.time.temporal.p
            public final s Q() {
                return s.g(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.p
            public final long Y(TemporalAccessor temporalAccessor) {
                if (!u(temporalAccessor)) {
                    throw new r("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.g(a.DAY_OF_YEAR) - g.a[((temporalAccessor.g(a.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.s.c.g0(temporalAccessor.i(a.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.p
            public final l f0(l lVar, long j) {
                long jY = Y(lVar);
                Q().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return lVar.c((j - jY) + lVar.i(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }

            @Override // j$.time.temporal.p
            public final boolean u(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.DAY_OF_YEAR) || !temporalAccessor.h(a.MONTH_OF_YEAR) || !temporalAccessor.h(a.YEAR)) {
                    return false;
                }
                g gVar2 = i.a;
                return j$.time.chrono.l.s(temporalAccessor).equals(j$.time.chrono.s.c);
            }
        };
        DAY_OF_QUARTER = gVar;
        g gVar2 = new g() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.p
            public final s H(TemporalAccessor temporalAccessor) {
                if (u(temporalAccessor)) {
                    return Q();
                }
                throw new r("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.p
            public final s Q() {
                return s.f(1L, 4L);
            }

            @Override // j$.time.temporal.p
            public final long Y(TemporalAccessor temporalAccessor) {
                if (u(temporalAccessor)) {
                    return (temporalAccessor.i(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new r("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.p
            public final l f0(l lVar, long j) {
                long jY = Y(lVar);
                Q().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return lVar.c(((j - jY) * 3) + lVar.i(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }

            @Override // j$.time.temporal.p
            public final boolean u(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.MONTH_OF_YEAR)) {
                    return false;
                }
                g gVar3 = i.a;
                return j$.time.chrono.l.s(temporalAccessor).equals(j$.time.chrono.s.c);
            }
        };
        QUARTER_OF_YEAR = gVar2;
        g gVar3 = new g() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.p
            public final s H(TemporalAccessor temporalAccessor) {
                if (u(temporalAccessor)) {
                    return g.l0(LocalDate.N(temporalAccessor));
                }
                throw new r("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.p
            public final TemporalAccessor N(Map map, d0 d0Var, e0 e0Var) {
                LocalDate localDateC;
                long j;
                p pVar = g.WEEK_BASED_YEAR;
                Long l = (Long) map.get(pVar);
                a aVar = a.DAY_OF_WEEK;
                Long l2 = (Long) map.get(aVar);
                if (l != null && l2 != null) {
                    int iA = pVar.Q().a(l.longValue(), pVar);
                    long jLongValue = ((Long) map.get(g.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                    g gVar4 = i.a;
                    if (j$.time.chrono.l.s(d0Var).equals(j$.time.chrono.s.c)) {
                        LocalDate localDateM0 = LocalDate.m0(iA, 1, 4);
                        if (e0Var == e0.LENIENT) {
                            long jLongValue2 = l2.longValue();
                            if (jLongValue2 > 7) {
                                long j2 = jLongValue2 - 1;
                                localDateM0 = localDateM0.r0(j2 / 7);
                                j = j2 % 7;
                            } else {
                                if (jLongValue2 < 1) {
                                    localDateM0 = localDateM0.r0(Math.subtractExact(jLongValue2, 7L) / 7);
                                    j = (jLongValue2 + 6) % 7;
                                }
                                localDateC = localDateM0.r0(Math.subtractExact(jLongValue, 1L)).c(jLongValue2, aVar);
                            }
                            jLongValue2 = j + 1;
                            localDateC = localDateM0.r0(Math.subtractExact(jLongValue, 1L)).c(jLongValue2, aVar);
                        } else {
                            int iA2 = aVar.b.a(l2.longValue(), aVar);
                            if (jLongValue < 1 || jLongValue > 52) {
                                if (e0Var == e0.STRICT) {
                                    g.l0(localDateM0).b(jLongValue, this);
                                } else {
                                    Q().b(jLongValue, this);
                                }
                            }
                            localDateC = localDateM0.r0(jLongValue - 1).c(iA2, aVar);
                        }
                        map.remove(this);
                        map.remove(pVar);
                        map.remove(aVar);
                        return localDateC;
                    }
                    j$.nio.file.j.h("Resolve requires IsoChronology");
                }
                return null;
            }

            @Override // j$.time.temporal.p
            public final s Q() {
                return s.g(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.p
            public final long Y(TemporalAccessor temporalAccessor) {
                if (u(temporalAccessor)) {
                    return g.i0(LocalDate.N(temporalAccessor));
                }
                throw new r("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.p
            public final l f0(l lVar, long j) {
                Q().b(j, this);
                return lVar.d(Math.subtractExact(j, Y(lVar)), ChronoUnit.WEEKS);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }

            @Override // j$.time.temporal.p
            public final boolean u(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                g gVar4 = i.a;
                return j$.time.chrono.l.s(temporalAccessor).equals(j$.time.chrono.s.c);
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = gVar3;
        g gVar4 = new g() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.p
            public final s H(TemporalAccessor temporalAccessor) {
                if (u(temporalAccessor)) {
                    return a.YEAR.b;
                }
                throw new r("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.p
            public final s Q() {
                return a.YEAR.b;
            }

            @Override // j$.time.temporal.p
            public final long Y(TemporalAccessor temporalAccessor) {
                if (u(temporalAccessor)) {
                    return g.j0(LocalDate.N(temporalAccessor));
                }
                throw new r("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.p
            public final l f0(l lVar, long j) {
                if (!u(lVar)) {
                    throw new r("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.b.a(j, g.WEEK_BASED_YEAR);
                LocalDate localDateN = LocalDate.N(lVar);
                int iG = localDateN.g(a.DAY_OF_WEEK);
                int iI0 = g.i0(localDateN);
                if (iI0 == 53 && g.k0(iA) == 52) {
                    iI0 = 52;
                }
                return lVar.m(LocalDate.m0(iA, 1, 4).plusDays(((iI0 - 1) * 7) + (iG - r3.g(r6))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }

            @Override // j$.time.temporal.p
            public final boolean u(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                g gVar5 = i.a;
                return j$.time.chrono.l.s(temporalAccessor).equals(j$.time.chrono.s.c);
            }
        };
        WEEK_BASED_YEAR = gVar4;
        b = new g[]{gVar, gVar2, gVar3, gVar4};
        a = new int[]{0, 90, Token.TEMPLATE_CHARS, 273, 0, 91, Token.TEMPLATE_LITERAL_SUBST, 274};
    }

    public static int i0(LocalDate localDate) {
        int iOrdinal = localDate.Y().ordinal();
        int iF0 = localDate.f0() - 1;
        int i = (3 - iOrdinal) + iF0;
        int i2 = i - ((i / 7) * 7);
        int i3 = i2 - 3;
        if (i3 < -3) {
            i3 = i2 + 4;
        }
        if (iF0 < i3) {
            if (localDate.f0() != 180) {
                localDate = LocalDate.o0(localDate.a, 180);
            }
            return (int) l0(localDate.s0(-1L)).d;
        }
        int i4 = ((iF0 - i3) / 7) + 1;
        if (i4 != 53 || i3 == -3 || (i3 == -2 && localDate.E())) {
            return i4;
        }
        return 1;
    }

    public static int j0(LocalDate localDate) {
        int i = localDate.a;
        int iF0 = localDate.f0();
        if (iF0 <= 3) {
            return iF0 - localDate.Y().ordinal() < -2 ? i - 1 : i;
        }
        if (iF0 >= 363) {
            return ((iF0 - 363) - (localDate.E() ? 1 : 0)) - localDate.Y().ordinal() >= 0 ? i + 1 : i;
        }
        return i;
    }

    public static int k0(int i) {
        LocalDate localDateM0 = LocalDate.m0(i, 1, 1);
        if (localDateM0.Y() != j$.time.c.THURSDAY) {
            return (localDateM0.Y() == j$.time.c.WEDNESDAY && localDateM0.E()) ? 53 : 52;
        }
        return 53;
    }

    public static s l0(LocalDate localDate) {
        return s.f(1L, k0(j0(localDate)));
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) b.clone();
    }

    @Override // j$.time.temporal.p
    public final boolean isDateBased() {
        return true;
    }
}
