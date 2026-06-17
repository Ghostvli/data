package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends d {
    private static final long serialVersionUID = 1300372329181994526L;
    public final transient LocalDate a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c0(LocalDate localDate) {
        Objects.requireNonNull(localDate, "isoDate");
        this.a = localDate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object writeReplace() {
        return new e0((byte) 7, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d
    public final b H(long j) {
        return i0(this.a.plusDays(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d
    public final b N(long j) {
        return i0(this.a.q0(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d
    public final b Q(long j) {
        return i0(this.a.s0(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public final long S() {
        return this.a.S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public final e T(j$.time.i iVar) {
        return new g(this, iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public final m V() {
        return Y() >= 1 ? d0.ROC : d0.BEFORE_ROC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int Y() {
        return this.a.a - 1911;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b a(long j, TemporalUnit temporalUnit) {
        return (c0) super.a(j, temporalUnit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b a0(j$.time.temporal.o oVar) {
        return (c0) super.a0(oVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b d(long j, TemporalUnit temporalUnit) {
        return (c0) super.d(j, temporalUnit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return this.a.equals(((c0) obj).a);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.b
    public final l f() {
        return a0.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(JLj$/time/temporal/p;)Lj$/time/chrono/b; */
    /* JADX DEBUG: Method merged with bridge method: c(JLj$/time/temporal/p;)Lj$/time/temporal/l; */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c0 c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (c0) super.c(j, pVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        if (i(aVar) == j) {
            return this;
        }
        int[] iArr = b0.a;
        int i = iArr[aVar.ordinal()];
        if (i == 4) {
            int iA = a0.c.F(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 4) {
                return i0(this.a.w0(Y() >= 1 ? iA + 1911 : 1912 - iA));
            }
            if (i2 == 6) {
                return i0(this.a.w0(iA + 1911));
            }
            if (i2 == 7) {
                return i0(this.a.w0(1912 - Y()));
            }
        } else {
            if (i == 5) {
                a0.c.F(aVar).b(j, aVar);
                long jY = ((long) Y()) * 12;
                LocalDate localDate = this.a;
                return i0(localDate.q0(j - ((jY + ((long) localDate.b)) - 1)));
            }
            if (i == 6 || i == 7) {
            }
        }
        return i0(this.a.c(j, pVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        a0.c.getClass();
        return this.a.hashCode() ^ (-1990173233);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.Y(this);
        }
        int i = b0.a[((j$.time.temporal.a) pVar).ordinal()];
        if (i == 4) {
            int iY = Y();
            if (iY < 1) {
                iY = 1 - iY;
            }
            return iY;
        }
        if (i == 5) {
            return ((((long) Y()) * 12) + ((long) this.a.b)) - 1;
        }
        if (i == 6) {
            return Y();
        }
        if (i != 7) {
            return this.a.i(pVar);
        }
        return Y() < 1 ? 0 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c0 i0(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new c0(localDate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return (c0) super.m(localDate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.H(this);
        }
        if (!h(pVar)) {
            throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        int i = b0.a[aVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return this.a.l(pVar);
        }
        if (i != 4) {
            return a0.c.F(aVar);
        }
        j$.time.temporal.s sVar = j$.time.temporal.a.YEAR.b;
        return j$.time.temporal.s.f(1L, Y() <= 0 ? (-sVar.a) + 1912 : sVar.d - 1911);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b m(j$.time.temporal.m mVar) {
        return (c0) super.m(mVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final j$.time.temporal.l a(long j, TemporalUnit temporalUnit) {
        return (c0) super.a(j, temporalUnit);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    public final j$.time.temporal.l d(long j, TemporalUnit temporalUnit) {
        return (c0) super.d(j, temporalUnit);
    }
}
