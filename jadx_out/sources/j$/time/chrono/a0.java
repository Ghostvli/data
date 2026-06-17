package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends a implements Serializable {
    public static final a0 c = new a0();
    private static final long serialVersionUID = 1039765215346859963L;

    private a0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.s F(j$.time.temporal.a aVar) {
        int i = z.a[aVar.ordinal()];
        if (i == 1) {
            j$.time.temporal.s sVar = j$.time.temporal.a.PROLEPTIC_MONTH.b;
            return j$.time.temporal.s.f(sVar.a - 22932, sVar.d - 22932);
        }
        if (i == 2) {
            j$.time.temporal.s sVar2 = j$.time.temporal.a.YEAR.b;
            return j$.time.temporal.s.g(1L, sVar2.d - 1911, (-sVar2.a) + 1912);
        }
        if (i != 3) {
            return aVar.b;
        }
        j$.time.temporal.s sVar3 = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.s.f(sVar3.a - 1911, sVar3.d - 1911);
    }

    @Override // j$.time.chrono.l
    public final List G() {
        return j$.desugar.sun.nio.fs.g.o(d0.values());
    }

    @Override // j$.time.chrono.l
    public final m I(int i) {
        if (i == 0) {
            return d0.BEFORE_ROC;
        }
        if (i == 1) {
            return d0.ROC;
        }
        j$.nio.file.j.b("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.l
    public final int K(m mVar, int i) {
        if (mVar instanceof d0) {
            return mVar == d0.ROC ? i : 1 - i;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.l
    public final b O(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof c0 ? (c0) temporalAccessor : new c0(LocalDate.N(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final b U() {
        return new c0(LocalDate.N(LocalDate.l0(j$.desugar.sun.nio.fs.g.z())));
    }

    @Override // j$.time.chrono.l
    public final b Z(int i, int i2, int i3) {
        return new c0(LocalDate.m0(i + 1911, i2, i3));
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b b0(Map map, j$.time.format.e0 e0Var) {
        return (c0) super.b0(map, e0Var);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime c0(Instant instant, ZoneId zoneId) {
        return k.N(this, instant, zoneId);
    }

    @Override // j$.time.chrono.l
    public final boolean g0(long j) {
        return s.c.g0(j + 1911);
    }

    @Override // j$.time.chrono.l
    public final b p(long j) {
        return new c0(LocalDate.n0(j));
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "Minguo";
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }

    @Override // j$.time.chrono.l
    public final String x() {
        return "roc";
    }

    @Override // j$.time.chrono.l
    public final b z(int i, int i2) {
        return new c0(LocalDate.o0(i + 1911, i2));
    }
}
