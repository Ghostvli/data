package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends a implements Serializable {
    public static final s c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    private s() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.s F(j$.time.temporal.a aVar) {
        return aVar.b;
    }

    @Override // j$.time.chrono.l
    public final List G() {
        return j$.desugar.sun.nio.fs.g.o(t.values());
    }

    @Override // j$.time.chrono.l
    public final m I(int i) {
        if (i == 0) {
            return t.BCE;
        }
        if (i == 1) {
            return t.CE;
        }
        j$.nio.file.j.b("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.l
    public final int K(m mVar, int i) {
        if (mVar instanceof t) {
            return mVar == t.CE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.l
    public final b O(TemporalAccessor temporalAccessor) {
        return LocalDate.N(temporalAccessor);
    }

    @Override // j$.time.chrono.l
    public final e P(LocalDateTime localDateTime) {
        return LocalDateTime.H(localDateTime);
    }

    @Override // j$.time.chrono.a
    public final void Q(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (e0Var != j$.time.format.e0.LENIENT) {
                aVar.i0(l.longValue());
            }
            a.u(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l.longValue(), 12L)) + 1);
            a.u(map, j$.time.temporal.a.YEAR, Math.floorDiv(l.longValue(), 12L));
        }
    }

    @Override // j$.time.chrono.l
    public final b U() {
        return LocalDate.N(LocalDate.l0(j$.desugar.sun.nio.fs.g.z()));
    }

    @Override // j$.time.chrono.a
    public final b Y(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = aVar.b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z = true;
        if (e0Var == j$.time.format.e0.LENIENT) {
            return LocalDate.m0(iA, 1, 1).q0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).plusDays(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = aVar2.b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = aVar3.b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (e0Var == j$.time.format.e0.SMART) {
            if (iA2 == 4 || iA2 == 6 || iA2 == 9 || iA2 == 11) {
                iA3 = Math.min(iA3, 30);
            } else if (iA2 == 2) {
                j$.time.k kVar = j$.time.k.FEBRUARY;
                long j = iA;
                int i = j$.time.s.b;
                if ((3 & j) != 0 || (j % 100 == 0 && j % 400 != 0)) {
                    z = false;
                }
                iA3 = Math.min(iA3, kVar.H(z));
            }
        }
        return LocalDate.m0(iA, iA2, iA3);
    }

    @Override // j$.time.chrono.l
    public final b Z(int i, int i2, int i3) {
        return LocalDate.m0(i, i2, i3);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b b0(Map map, j$.time.format.e0 e0Var) {
        return (LocalDate) super.b0(map, e0Var);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime c0(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.u(instant.a, instant.b, zoneId);
    }

    @Override // j$.time.chrono.a
    public final b f0(Map map, j$.time.format.e0 e0Var) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (e0Var != j$.time.format.e0.LENIENT) {
                aVar.i0(l.longValue());
            }
            Long l2 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l2 == null) {
                j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
                Long l3 = (Long) map.get(aVar2);
                if (e0Var != j$.time.format.e0.STRICT) {
                    a.u(map, aVar2, (l3 == null || l3.longValue() > 0) ? l.longValue() : Math.subtractExact(1L, l.longValue()));
                } else if (l3 != null) {
                    long jLongValue = l3.longValue();
                    long jLongValue2 = l.longValue();
                    if (jLongValue <= 0) {
                        jLongValue2 = Math.subtractExact(1L, jLongValue2);
                    }
                    a.u(map, aVar2, jLongValue2);
                } else {
                    map.put(aVar, l);
                }
            } else if (l2.longValue() == 1) {
                a.u(map, j$.time.temporal.a.YEAR, l.longValue());
            } else {
                if (l2.longValue() != 0) {
                    j$.nio.file.j.j("Invalid value for era: ", l2);
                    return null;
                }
                a.u(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l.longValue()));
            }
        } else {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
            if (map.containsKey(aVar3)) {
                aVar3.i0(((Long) map.get(aVar3)).longValue());
            }
        }
        return null;
    }

    @Override // j$.time.chrono.l
    public final boolean g0(long j) {
        if ((3 & j) == 0) {
            return j % 100 != 0 || j % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.l
    public final b p(long j) {
        return LocalDate.n0(j);
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "ISO";
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }

    @Override // j$.time.chrono.l
    public final String x() {
        return "iso8601";
    }

    @Override // j$.time.chrono.l
    public final b z(int i, int i2) {
        return LocalDate.o0(i, i2);
    }
}
