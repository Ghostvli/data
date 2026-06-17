package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements l {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        new Locale("ja", "JP", "JP");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static l H(l lVar, String str) {
        String strX;
        l lVar2 = (l) a.putIfAbsent(str, lVar);
        if (lVar2 == null && (strX = lVar.x()) != null) {
            b.putIfAbsent(strX, lVar);
        }
        return lVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b N(b bVar, long j, long j2, long j3) {
        long j4;
        b bVarD = bVar.d(j, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        b bVarD2 = bVarD.d(j2, (TemporalUnit) chronoUnit);
        if (j3 <= 7) {
            if (j3 < 1) {
                bVarD2 = bVarD2.d(Math.subtractExact(j3, 7L) / 7, (TemporalUnit) chronoUnit);
                j4 = (j3 + 6) % 7;
            }
            return bVarD2.m(new j$.time.temporal.n(j$.time.c.u((int) j3).getValue(), 0));
        }
        long j5 = j3 - 1;
        bVarD2 = bVarD2.d(j5 / 7, (TemporalUnit) chronoUnit);
        j4 = j5 % 7;
        j3 = j4 + 1;
        return bVarD2.m(new j$.time.temporal.n(j$.time.c.u((int) j3).getValue(), 0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void u(Map map, j$.time.temporal.a aVar, long j) {
        Long l = (Long) map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new DateTimeException("Conflict found: " + aVar + " " + l + " differs from " + aVar + " " + j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (e0Var != j$.time.format.e0.LENIENT) {
                aVar.i0(l.longValue());
            }
            b bVarC = U().c(1L, (j$.time.temporal.p) j$.time.temporal.a.DAY_OF_MONTH).c(l.longValue(), (j$.time.temporal.p) aVar);
            u(map, j$.time.temporal.a.MONTH_OF_YEAR, bVarC.g(r6));
            u(map, j$.time.temporal.a.YEAR, bVarC.g(r6));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b Y(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = F(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (e0Var == j$.time.format.e0.LENIENT) {
            long jSubtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return Z(iA, 1, 1).d(jSubtractExact, (TemporalUnit) ChronoUnit.MONTHS).d(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = F(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = F(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (e0Var != j$.time.format.e0.SMART) {
            return Z(iA, iA2, iA3);
        }
        try {
            return Z(iA, iA2, iA3);
        } catch (DateTimeException unused) {
            return this.Z(iA, iA2, 1).m(new j$.time.d(6));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.l
    public b b0(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return p(((Long) map.remove(aVar)).longValue());
        }
        Q(map, e0Var);
        b bVarF0 = f0(map, e0Var);
        if (bVarF0 != null) {
            return bVarF0;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (map.containsKey(aVar2)) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                    return Y(map, e0Var);
                }
                j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(aVar5)) {
                        int iA = F(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (e0Var == j$.time.format.e0.LENIENT) {
                            long jSubtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                            return Z(iA, 1, 1).d(jSubtractExact, (TemporalUnit) ChronoUnit.MONTHS).d(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int iA2 = F(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        int iA3 = F(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                        b bVarD = Z(iA, iA2, 1).d((F(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((iA3 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                        if (e0Var != j$.time.format.e0.STRICT || bVarD.g(aVar3) == iA2) {
                            return bVarD;
                        }
                        j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                    if (map.containsKey(aVar6)) {
                        int iA4 = F(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (e0Var == j$.time.format.e0.LENIENT) {
                            return N(Z(iA4, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                        }
                        int iA5 = F(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        b bVarM = Z(iA4, iA5, 1).d((F(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).m(new j$.time.temporal.n(j$.time.c.u(F(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), 0));
                        if (e0Var != j$.time.format.e0.STRICT || bVarM.g(aVar3) == iA5) {
                            return bVarM;
                        }
                        j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                }
            }
            j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar7)) {
                int iA6 = F(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                if (e0Var != j$.time.format.e0.LENIENT) {
                    return z(iA6, F(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
                }
                return z(iA6, 1).d(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
            }
            j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(aVar8)) {
                j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(aVar9)) {
                    int iA7 = F(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (e0Var == j$.time.format.e0.LENIENT) {
                        return z(iA7, 1).d(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int iA8 = F(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
                    b bVarD2 = z(iA7, 1).d((F(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((iA8 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                    if (e0Var != j$.time.format.e0.STRICT || bVarD2.g(aVar2) == iA7) {
                        return bVarD2;
                    }
                    j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
                j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar10)) {
                    int iA9 = F(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (e0Var == j$.time.format.e0.LENIENT) {
                        return N(z(iA9, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
                    }
                    b bVarM2 = z(iA9, 1).d((F(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).m(new j$.time.temporal.n(j$.time.c.u(F(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), 0));
                    if (e0Var != j$.time.format.e0.STRICT || bVarM2.g(aVar2) == iA9) {
                        return bVarM2;
                    }
                    j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return q().compareTo(((l) obj).q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && q().compareTo(((a) obj).q()) == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b f0(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l == null) {
            j$.time.temporal.a aVar2 = j$.time.temporal.a.ERA;
            if (!map.containsKey(aVar2)) {
                return null;
            }
            F(aVar2).b(((Long) map.get(aVar2)).longValue(), aVar2);
            return null;
        }
        Long l2 = (Long) map.remove(j$.time.temporal.a.ERA);
        int iA = e0Var != j$.time.format.e0.LENIENT ? F(aVar).a(l.longValue(), aVar) : Math.toIntExact(l.longValue());
        if (l2 != null) {
            u(map, j$.time.temporal.a.YEAR, K(I(F(r2).a(l2.longValue(), r2)), iA));
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.YEAR;
        if (map.containsKey(aVar3)) {
            u(map, aVar3, K(z(F(aVar3).a(((Long) map.get(aVar3)).longValue(), aVar3), 1).V(), iA));
            return null;
        }
        if (e0Var == j$.time.format.e0.STRICT) {
            map.put(aVar, l);
            return null;
        }
        if (G().isEmpty()) {
            u(map, aVar3, iA);
            return null;
        }
        u(map, aVar3, K((m) r9.get(r9.size() - 1), iA));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.l
    public final int hashCode() {
        return q().hashCode() ^ getClass().hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.l
    public final String toString() {
        return q();
    }
}
