package j$.time.temporal;

import j$.time.format.d0;
import j$.time.format.e0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements p {
    public static final s f = s.f(1, 7);
    public static final s g = s.g(0, 4, 6);
    public static final s h = s.g(0, 52, 54);
    public static final s i = s.g(1, 52, 53);
    public final String a;
    public final u b;
    public final TemporalUnit c;
    public final TemporalUnit d;
    public final s e;

    public t(String str, u uVar, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, s sVar) {
        this.a = str;
        this.b = uVar;
        this.c = temporalUnit;
        this.d = temporalUnit2;
        this.e = sVar;
    }

    public static int a(int i2, int i3) {
        return ((i3 - 1) + (i2 + 7)) / 7;
    }

    @Override // j$.time.temporal.p
    public final s H(TemporalAccessor temporalAccessor) {
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            return this.e;
        }
        if (temporalUnit == ChronoUnit.MONTHS) {
            return f(temporalAccessor, a.DAY_OF_MONTH);
        }
        if (temporalUnit == ChronoUnit.YEARS) {
            return f(temporalAccessor, a.DAY_OF_YEAR);
        }
        if (temporalUnit == u.h) {
            return g(temporalAccessor);
        }
        if (temporalUnit == ChronoUnit.FOREVER) {
            return a.YEAR.b;
        }
        throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
    }

    @Override // j$.time.temporal.p
    public final TemporalAccessor N(Map map, d0 d0Var, e0 e0Var) {
        j$.time.chrono.b bVarD;
        j$.time.chrono.b bVarD2;
        j$.time.chrono.b bVarD3;
        long jLongValue = ((Long) map.get(this)).longValue();
        int intExact = Math.toIntExact(jLongValue);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        s sVar = this.e;
        u uVar = this.b;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            long jFloorMod = Math.floorMod((sVar.a(jLongValue, this) - 1) + (uVar.a.getValue() - 1), 7) + 1;
            map.remove(this);
            map.put(a.DAY_OF_WEEK, Long.valueOf(jFloorMod));
            return null;
        }
        a aVar = a.DAY_OF_WEEK;
        if (!map.containsKey(aVar)) {
            return null;
        }
        int iFloorMod = Math.floorMod(aVar.b.a(((Long) map.get(aVar)).longValue(), aVar) - uVar.a.getValue(), 7) + 1;
        j$.time.chrono.l lVarS = j$.time.chrono.l.s(d0Var);
        a aVar2 = a.YEAR;
        if (!map.containsKey(aVar2)) {
            if ((temporalUnit != u.h && temporalUnit != ChronoUnit.FOREVER) || !map.containsKey(uVar.f) || !map.containsKey(uVar.e)) {
                return null;
            }
            t tVar = uVar.f;
            int iA = tVar.e.a(((Long) map.get(tVar)).longValue(), uVar.f);
            if (e0Var == e0.LENIENT) {
                bVarD = e(lVarS, iA, 1, iFloorMod).d(Math.subtractExact(((Long) map.get(uVar.e)).longValue(), 1L), (TemporalUnit) chronoUnit);
            } else {
                t tVar2 = uVar.e;
                j$.time.chrono.b bVarE = e(lVarS, iA, tVar2.e.a(((Long) map.get(tVar2)).longValue(), uVar.e), iFloorMod);
                if (e0Var == e0.STRICT && c(bVarE) != iA) {
                    j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different week-based-year");
                    return null;
                }
                bVarD = bVarE;
            }
            map.remove(this);
            map.remove(uVar.f);
            map.remove(uVar.e);
            map.remove(aVar);
            return bVarD;
        }
        int iA2 = aVar2.b.a(((Long) map.get(aVar2)).longValue(), aVar2);
        ChronoUnit chronoUnit2 = ChronoUnit.MONTHS;
        if (temporalUnit == chronoUnit2) {
            a aVar3 = a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                long jLongValue2 = ((Long) map.get(aVar3)).longValue();
                long j = intExact;
                if (e0Var == e0.LENIENT) {
                    j$.time.chrono.b bVarD4 = lVarS.Z(iA2, 1, 1).d(Math.subtractExact(jLongValue2, 1L), (TemporalUnit) chronoUnit2);
                    int iB = b(bVarD4);
                    int iG = bVarD4.g(a.DAY_OF_MONTH);
                    bVarD3 = bVarD4.d(Math.addExact(Math.multiplyExact(Math.subtractExact(j, a(h(iG, iB), iG)), 7L), iFloorMod - b(bVarD4)), (TemporalUnit) ChronoUnit.DAYS);
                } else {
                    j$.time.chrono.b bVarZ = lVarS.Z(iA2, aVar3.b.a(jLongValue2, aVar3), 1);
                    long jA = sVar.a(j, this);
                    int iB2 = b(bVarZ);
                    int iG2 = bVarZ.g(a.DAY_OF_MONTH);
                    j$.time.chrono.b bVarD5 = bVarZ.d((((int) (jA - ((long) a(h(iG2, iB2), iG2)))) * 7) + (iFloorMod - b(bVarZ)), (TemporalUnit) ChronoUnit.DAYS);
                    if (e0Var == e0.STRICT && bVarD5.i(aVar3) != jLongValue2) {
                        j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    bVarD3 = bVarD5;
                }
                map.remove(this);
                map.remove(aVar2);
                map.remove(aVar3);
                map.remove(aVar);
                return bVarD3;
            }
        }
        if (temporalUnit != ChronoUnit.YEARS) {
            return null;
        }
        long j2 = intExact;
        j$.time.chrono.b bVarZ2 = lVarS.Z(iA2, 1, 1);
        if (e0Var == e0.LENIENT) {
            int iB3 = b(bVarZ2);
            int iG3 = bVarZ2.g(a.DAY_OF_YEAR);
            bVarD2 = bVarZ2.d(Math.addExact(Math.multiplyExact(Math.subtractExact(j2, a(h(iG3, iB3), iG3)), 7L), iFloorMod - b(bVarZ2)), (TemporalUnit) ChronoUnit.DAYS);
        } else {
            long jA2 = sVar.a(j2, this);
            int iB4 = b(bVarZ2);
            int iG4 = bVarZ2.g(a.DAY_OF_YEAR);
            j$.time.chrono.b bVarD6 = bVarZ2.d((((int) (jA2 - ((long) a(h(iG4, iB4), iG4)))) * 7) + (iFloorMod - b(bVarZ2)), (TemporalUnit) ChronoUnit.DAYS);
            if (e0Var == e0.STRICT && bVarD6.i(aVar2) != iA2) {
                j$.nio.file.j.h("Strict mode rejected resolved date as it is in a different year");
                return null;
            }
            bVarD2 = bVarD6;
        }
        map.remove(this);
        map.remove(aVar2);
        map.remove(aVar);
        return bVarD2;
    }

    @Override // j$.time.temporal.p
    public final s Q() {
        return this.e;
    }

    @Override // j$.time.temporal.p
    public final long Y(TemporalAccessor temporalAccessor) {
        int iC;
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            iC = b(temporalAccessor);
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            int iB = b(temporalAccessor);
            int iG = temporalAccessor.g(a.DAY_OF_MONTH);
            iC = a(h(iG, iB), iG);
        } else if (temporalUnit == ChronoUnit.YEARS) {
            int iB2 = b(temporalAccessor);
            int iG2 = temporalAccessor.g(a.DAY_OF_YEAR);
            iC = a(h(iG2, iB2), iG2);
        } else if (temporalUnit == u.h) {
            iC = d(temporalAccessor);
        } else {
            if (temporalUnit != ChronoUnit.FOREVER) {
                throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
            }
            iC = c(temporalAccessor);
        }
        return iC;
    }

    public final int b(TemporalAccessor temporalAccessor) {
        return Math.floorMod(temporalAccessor.g(a.DAY_OF_WEEK) - this.b.a.getValue(), 7) + 1;
    }

    public final int c(TemporalAccessor temporalAccessor) {
        int iB = b(temporalAccessor);
        int iG = temporalAccessor.g(a.YEAR);
        a aVar = a.DAY_OF_YEAR;
        int iG2 = temporalAccessor.g(aVar);
        int iH = h(iG2, iB);
        int iA = a(iH, iG2);
        return iA == 0 ? iG - 1 : iA >= a(iH, ((int) temporalAccessor.l(aVar).d) + this.b.b) ? iG + 1 : iG;
    }

    public final int d(TemporalAccessor temporalAccessor) {
        int iA;
        int iB = b(temporalAccessor);
        a aVar = a.DAY_OF_YEAR;
        int iG = temporalAccessor.g(aVar);
        int iH = h(iG, iB);
        int iA2 = a(iH, iG);
        return iA2 == 0 ? d(j$.time.chrono.l.s(temporalAccessor).O(temporalAccessor).a(iG, (TemporalUnit) ChronoUnit.DAYS)) : (iA2 <= 50 || iA2 < (iA = a(iH, ((int) temporalAccessor.l(aVar).d) + this.b.b))) ? iA2 : (iA2 - iA) + 1;
    }

    public final j$.time.chrono.b e(j$.time.chrono.l lVar, int i2, int i3, int i4) {
        j$.time.chrono.b bVarZ = lVar.Z(i2, 1, 1);
        int iH = h(1, b(bVarZ));
        int i5 = i4 - 1;
        return bVarZ.d(((Math.min(i3, a(iH, bVarZ.d0() + this.b.b) - 1) - 1) * 7) + i5 + (-iH), (TemporalUnit) ChronoUnit.DAYS);
    }

    public final s f(TemporalAccessor temporalAccessor, a aVar) {
        int iH = h(temporalAccessor.g(aVar), b(temporalAccessor));
        s sVarL = temporalAccessor.l(aVar);
        return s.f(a(iH, (int) sVarL.a), a(iH, (int) sVarL.d));
    }

    @Override // j$.time.temporal.p
    public final l f0(l lVar, long j) {
        if (this.e.a(j, this) == lVar.g(this)) {
            return lVar;
        }
        if (this.d != ChronoUnit.FOREVER) {
            return lVar.d(r0 - r1, this.c);
        }
        u uVar = this.b;
        return e(j$.time.chrono.l.s(lVar), (int) j, lVar.g(uVar.e), lVar.g(uVar.c));
    }

    public final s g(TemporalAccessor temporalAccessor) {
        a aVar = a.DAY_OF_YEAR;
        if (!temporalAccessor.h(aVar)) {
            return h;
        }
        int iB = b(temporalAccessor);
        int iG = temporalAccessor.g(aVar);
        int iH = h(iG, iB);
        int iA = a(iH, iG);
        if (iA == 0) {
            return g(j$.time.chrono.l.s(temporalAccessor).O(temporalAccessor).a(iG + 7, (TemporalUnit) ChronoUnit.DAYS));
        }
        return iA >= a(iH, this.b.b + ((int) temporalAccessor.l(aVar).d)) ? g(j$.time.chrono.l.s(temporalAccessor).O(temporalAccessor).d((r0 - iG) + 8, (TemporalUnit) ChronoUnit.DAYS)) : s.f(1L, r1 - 1);
    }

    public final int h(int i2, int i3) {
        int iFloorMod = Math.floorMod(i2 - i3, 7);
        return iFloorMod + 1 > this.b.b ? 7 - iFloorMod : -iFloorMod;
    }

    @Override // j$.time.temporal.p
    public final boolean isDateBased() {
        return true;
    }

    public final String toString() {
        return this.a + "[" + this.b.toString() + "]";
    }

    @Override // j$.time.temporal.p
    public final boolean u(TemporalAccessor temporalAccessor) {
        if (!temporalAccessor.h(a.DAY_OF_WEEK)) {
            return false;
        }
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            return true;
        }
        if (temporalUnit == ChronoUnit.MONTHS) {
            return temporalAccessor.h(a.DAY_OF_MONTH);
        }
        if (temporalUnit == ChronoUnit.YEARS) {
            return temporalAccessor.h(a.DAY_OF_YEAR);
        }
        if (temporalUnit == u.h) {
            return temporalAccessor.h(a.DAY_OF_YEAR);
        }
        if (temporalUnit == ChronoUnit.FOREVER) {
            return temporalAccessor.h(a.YEAR);
        }
        return false;
    }
}
