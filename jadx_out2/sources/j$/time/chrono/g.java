package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements e, j$.time.temporal.l, j$.time.temporal.m, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    public final transient b a;
    public final transient j$.time.i b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g(b bVar, j$.time.i iVar) {
        Objects.requireNonNull(iVar, "time");
        this.a = bVar;
        this.b = iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static g u(l lVar, j$.time.temporal.l lVar2) {
        g gVar = (g) lVar2;
        if (lVar.equals(gVar.f())) {
            return gVar;
        }
        j$.nio.file.j.k("Chronology mismatch, required: ", lVar.q(), gVar.f().q());
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object writeReplace() {
        return new e0((byte) 2, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(JLj$/time/temporal/TemporalUnit;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final g d(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return u(this.a.f(), temporalUnit.u(this, j));
        }
        switch (f.a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return N(this.a, 0L, 0L, 0L, j);
            case 2:
                g gVarY = Y(this.a.d(j / 86400000000L, (TemporalUnit) ChronoUnit.DAYS), this.b);
                return gVarY.N(gVarY.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                g gVarY2 = Y(this.a.d(j / 86400000, (TemporalUnit) ChronoUnit.DAYS), this.b);
                return gVarY2.N(gVarY2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return N(this.a, 0L, 0L, j, 0L);
            case 5:
                return N(this.a, 0L, j, 0L, 0L);
            case 6:
                return N(this.a, j, 0L, 0L, 0L);
            case 7:
                g gVarY3 = Y(this.a.d(j / 256, (TemporalUnit) ChronoUnit.DAYS), this.b);
                return gVarY3.N(gVarY3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return Y(this.a.d(j, temporalUnit), this.b);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime M(ZoneId zoneId) {
        return k.H(zoneId, null, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g N(b bVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        j$.time.i iVar = this.b;
        if (j5 == 0) {
            return Y(bVar, iVar);
        }
        long j6 = j / 24;
        long jO0 = iVar.o0();
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L) + jO0;
        long jFloorDiv = Math.floorDiv(j7, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jFloorMod = Math.floorMod(j7, 86400000000000L);
        return Y(bVar.d(jFloorDiv, (TemporalUnit) ChronoUnit.DAYS), jFloorMod == jO0 ? this.b : j$.time.i.f0(jFloorMod));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(JLj$/time/temporal/p;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final g c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return u(this.a.f(), pVar.f0(this, j));
        }
        boolean zJ0 = ((j$.time.temporal.a) pVar).j0();
        b bVar = this.a;
        return zJ0 ? Y(bVar, this.b.c(j, pVar)) : Y(bVar.c(j, pVar), this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g Y(j$.time.temporal.l lVar, j$.time.i iVar) {
        b bVar = this.a;
        return (bVar == lVar && this.b == iVar) ? this : new g(d.u(bVar.f(), lVar), iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() ? this.b.g(pVar) : this.a.g(pVar) : l(pVar).a(i(pVar), pVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar != null && pVar.u(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        return aVar.isDateBased() || aVar.j0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() ? this.b.i(pVar) : this.a.i(pVar) : pVar.Y(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.e
    public final j$.time.i j() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return localDate != null ? Y(localDate, this.b) : u(this.a.f(), (g) localDate.e(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        if (pVar instanceof j$.time.temporal.a) {
            return (((j$.time.temporal.a) pVar).j0() ? this.b : this.a).l(pVar);
        }
        return pVar.H(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.e
    public final b n() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }
}
