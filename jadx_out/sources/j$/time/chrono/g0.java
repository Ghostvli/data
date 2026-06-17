package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends a implements Serializable {
    public static final g0 c = new g0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private g0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.s F(j$.time.temporal.a aVar) {
        int i = f0.a[aVar.ordinal()];
        if (i == 1) {
            j$.time.temporal.s sVar = j$.time.temporal.a.PROLEPTIC_MONTH.b;
            return j$.time.temporal.s.f(sVar.a + 6516, sVar.d + 6516);
        }
        if (i == 2) {
            j$.time.temporal.s sVar2 = j$.time.temporal.a.YEAR.b;
            return j$.time.temporal.s.g(1L, (-(sVar2.a + 543)) + 1, sVar2.d + 543);
        }
        if (i != 3) {
            return aVar.b;
        }
        j$.time.temporal.s sVar3 = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.s.f(sVar3.a + 543, sVar3.d + 543);
    }

    @Override // j$.time.chrono.l
    public final List G() {
        return j$.desugar.sun.nio.fs.g.o(j0.values());
    }

    @Override // j$.time.chrono.l
    public final m I(int i) {
        if (i == 0) {
            return j0.BEFORE_BE;
        }
        if (i == 1) {
            return j0.BE;
        }
        j$.nio.file.j.b("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.l
    public final int K(m mVar, int i) {
        if (mVar instanceof j0) {
            return mVar == j0.BE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // j$.time.chrono.l
    public final b O(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof i0 ? (i0) temporalAccessor : new i0(LocalDate.N(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final b U() {
        return new i0(LocalDate.N(LocalDate.l0(j$.desugar.sun.nio.fs.g.z())));
    }

    @Override // j$.time.chrono.l
    public final b Z(int i, int i2, int i3) {
        return new i0(LocalDate.m0(i - 543, i2, i3));
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b b0(Map map, j$.time.format.e0 e0Var) {
        return (i0) super.b0(map, e0Var);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime c0(Instant instant, ZoneId zoneId) {
        return k.N(this, instant, zoneId);
    }

    @Override // j$.time.chrono.l
    public final boolean g0(long j) {
        return s.c.g0(j - 543);
    }

    @Override // j$.time.chrono.l
    public final b p(long j) {
        return new i0(LocalDate.n0(j));
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "ThaiBuddhist";
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }

    @Override // j$.time.chrono.l
    public final String x() {
        return "buddhist";
    }

    @Override // j$.time.chrono.l
    public final b z(int i, int i2) {
        return new i0(LocalDate.o0(i - 543, i2));
    }
}
