package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends a implements Serializable {
    public static final v c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    private v() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.s F(j$.time.temporal.a aVar) {
        switch (u.a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                j$.nio.file.j.d("Unsupported field: ", aVar);
                return null;
            case 5:
                y[] yVarArr = y.e;
                int i = yVarArr[yVarArr.length - 1].b.a;
                int iMin = Http2Connection.DEGRADED_PONG_TIMEOUT_NS - yVarArr[yVarArr.length - 1].b.a;
                int i2 = yVarArr[0].b.a;
                int i3 = 1;
                while (true) {
                    y[] yVarArr2 = y.e;
                    if (i3 >= yVarArr2.length) {
                        return j$.time.temporal.s.g(1L, iMin, 999999999 - i);
                    }
                    y yVar = yVarArr2[i3];
                    iMin = Math.min(iMin, (yVar.b.a - i2) + 1);
                    i2 = yVar.b.a;
                    i3++;
                }
                break;
            case 6:
                y yVar2 = y.d;
                long j = j$.time.temporal.a.DAY_OF_YEAR.b.c;
                long jMin = j;
                for (y yVar3 : y.e) {
                    long jMin2 = Math.min(jMin, (yVar3.b.d0() - yVar3.b.f0()) + 1);
                    jMin = yVar3.q() != null ? Math.min(jMin2, yVar3.q().b.f0() - 1) : jMin2;
                }
                return j$.time.temporal.s.g(1L, jMin, j$.time.temporal.a.DAY_OF_YEAR.b.d);
            case 7:
                return j$.time.temporal.s.f(x.d.a, 999999999L);
            case 8:
                long j2 = y.d.a;
                y[] yVarArr3 = y.e;
                return j$.time.temporal.s.f(j2, yVarArr3[yVarArr3.length - 1].a);
            default:
                return aVar.b;
        }
    }

    @Override // j$.time.chrono.l
    public final List G() {
        y[] yVarArr = y.e;
        return j$.desugar.sun.nio.fs.g.o((y[]) Arrays.copyOf(yVarArr, yVarArr.length));
    }

    @Override // j$.time.chrono.l
    public final m I(int i) {
        return y.r(i);
    }

    @Override // j$.time.chrono.l
    public final int K(m mVar, int i) {
        if (!(mVar instanceof y)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int i2 = ((y) mVar).b.a;
        int i3 = (i2 + i) - 1;
        if (i == 1 || (i3 >= -999999999 && i3 <= 999999999 && i3 >= i2 && mVar == y.p(LocalDate.m0(i3, 1, 1)))) {
            return i3;
        }
        j$.nio.file.j.h("Invalid yearOfEra value");
        return 0;
    }

    @Override // j$.time.chrono.l
    public final b O(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof x ? (x) temporalAccessor : new x(LocalDate.N(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final b U() {
        return new x(LocalDate.N(LocalDate.l0(j$.desugar.sun.nio.fs.g.z())));
    }

    @Override // j$.time.chrono.l
    public final b Z(int i, int i2, int i3) {
        return new x(LocalDate.m0(i, i2, i3));
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b b0(Map map, j$.time.format.e0 e0Var) {
        return (x) super.b0(map, e0Var);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime c0(Instant instant, ZoneId zoneId) {
        return k.N(this, instant, zoneId);
    }

    @Override // j$.time.chrono.a
    public final b f0(Map map, j$.time.format.e0 e0Var) {
        x xVarI0;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l = (Long) map.get(aVar);
        y yVarR = l != null ? y.r(F(aVar).a(l.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.get(aVar2);
        int iA = l2 != null ? F(aVar2).a(l2.longValue(), aVar2) : 0;
        if (yVarR == null && l2 != null && !map.containsKey(j$.time.temporal.a.YEAR) && e0Var != j$.time.format.e0.STRICT) {
            y[] yVarArr = y.e;
            yVarR = ((y[]) Arrays.copyOf(yVarArr, yVarArr.length))[((y[]) Arrays.copyOf(yVarArr, yVarArr.length)).length - 1];
        }
        if (l2 != null && yVarR != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (e0Var == j$.time.format.e0.LENIENT) {
                        return new x(LocalDate.m0((yVarR.b.a + iA) - 1, 1, 1)).Y(Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), ChronoUnit.MONTHS).Y(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), ChronoUnit.DAYS);
                    }
                    int iA2 = F(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = F(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (e0Var != j$.time.format.e0.SMART) {
                        LocalDate localDate = x.d;
                        LocalDate localDateM0 = LocalDate.m0((yVarR.b.a + iA) - 1, iA2, iA3);
                        if (!localDateM0.i0(yVarR.b) && yVarR == y.p(localDateM0)) {
                            return new x(yVarR, iA, localDateM0);
                        }
                        j$.nio.file.j.h("year, month, and day not valid for Era");
                        return null;
                    }
                    if (iA < 1) {
                        j$.nio.file.j.b("Invalid YearOfEra: ", iA);
                        return null;
                    }
                    int i = (yVarR.b.a + iA) - 1;
                    try {
                        xVarI0 = new x(LocalDate.m0(i, iA2, iA3));
                    } catch (DateTimeException unused) {
                        xVarI0 = new x(LocalDate.m0(i, iA2, 1)).i0(new j$.time.d(6));
                    }
                    if (xVarI0.b == yVarR || xVarI0.g(j$.time.temporal.a.YEAR_OF_ERA) <= 1 || iA <= 1) {
                        return xVarI0;
                    }
                    throw new DateTimeException("Invalid YearOfEra for Era: " + yVarR + " " + iA);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (e0Var == j$.time.format.e0.LENIENT) {
                    return new x(LocalDate.o0((yVarR.b.a + iA) - 1, 1)).Y(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), ChronoUnit.DAYS);
                }
                int iA4 = F(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                LocalDate localDate2 = x.d;
                LocalDate localDate3 = yVarR.b;
                int i2 = localDate3.a;
                LocalDate localDateO0 = iA == 1 ? LocalDate.o0(i2, (localDate3.f0() + iA4) - 1) : LocalDate.o0((i2 + iA) - 1, iA4);
                if (!localDateO0.i0(yVarR.b) && yVarR == y.p(localDateO0)) {
                    return new x(yVarR, iA, localDateO0);
                }
                j$.nio.file.j.h("Invalid parameters");
            }
        }
        return null;
    }

    @Override // j$.time.chrono.l
    public final boolean g0(long j) {
        return s.c.g0(j);
    }

    @Override // j$.time.chrono.l
    public final b p(long j) {
        return new x(LocalDate.n0(j));
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "Japanese";
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }

    @Override // j$.time.chrono.l
    public final String x() {
        return "japanese";
    }

    @Override // j$.time.chrono.l
    public final b z(int i, int i2) {
        return new x(LocalDate.o0(i, i2));
    }
}
