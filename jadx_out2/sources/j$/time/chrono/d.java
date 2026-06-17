package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements b, j$.time.temporal.l, j$.time.temporal.m, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b u(l lVar, j$.time.temporal.l lVar2) {
        b bVar = (b) lVar2;
        if (lVar.equals(bVar.f())) {
            return bVar;
        }
        j$.nio.file.j.k("Chronology mismatch, expected: ", lVar.q(), bVar.f().q());
        return null;
    }

    public abstract b H(long j);

    public abstract b N(long j);

    public abstract b Q(long j);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b, j$.time.temporal.l
    public /* bridge */ /* synthetic */ j$.time.temporal.l a(long j, TemporalUnit temporalUnit) {
        return a(j, temporalUnit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public b a0(j$.time.temporal.o oVar) {
        return u(f(), oVar.u(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(JLj$/time/temporal/p;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    public b c(long j, j$.time.temporal.p pVar) {
        if (pVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
        }
        return u(f(), pVar.f0(this, j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(JLj$/time/temporal/TemporalUnit;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    public b d(long j, TemporalUnit temporalUnit) {
        boolean z = temporalUnit instanceof ChronoUnit;
        if (!z) {
            if (!z) {
                return u(f(), temporalUnit.u(this, j));
            }
            j$.nio.file.j.d("Unsupported unit: ", temporalUnit);
            return null;
        }
        switch (c.a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return H(j);
            case 2:
                return H(Math.multiplyExact(j, 7L));
            case 3:
                return N(j);
            case 4:
                return Q(j);
            case 5:
                return Q(Math.multiplyExact(j, 10L));
            case 6:
                return Q(Math.multiplyExact(j, 100L));
            case 7:
                return Q(Math.multiplyExact(j, 1000L));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j), (j$.time.temporal.p) aVar);
            default:
                j$.nio.file.j.d("Unsupported unit: ", temporalUnit);
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public int hashCode() {
        long jS = S();
        return f().hashCode() ^ ((int) (jS ^ (jS >>> 32)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: k(Lj$/time/LocalDate;)Lj$/time/temporal/l; */
    @Override // j$.time.temporal.l
    public b m(j$.time.temporal.m mVar) {
        return u(f(), mVar.e(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public final String toString() {
        long jI = i(j$.time.temporal.a.YEAR_OF_ERA);
        long jI2 = i(j$.time.temporal.a.MONTH_OF_YEAR);
        long jI3 = i(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(f().toString());
        sb.append(" ");
        sb.append(V());
        sb.append(" ");
        sb.append(jI);
        sb.append(jI2 < 10 ? "-0" : "-");
        sb.append(jI2);
        sb.append(jI3 < 10 ? "-0" : "-");
        sb.append(jI3);
        return sb.toString();
    }
}
