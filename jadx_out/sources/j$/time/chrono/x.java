package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends d {
    public static final LocalDate d = LocalDate.m0(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    public final transient LocalDate a;
    public final transient y b;
    public final transient int c;

    public x(LocalDate localDate) {
        if (localDate.i0(d)) {
            j$.nio.file.j.h("JapaneseDate before Meiji 6 is not supported");
            throw null;
        }
        y yVarP = y.p(localDate);
        this.b = yVarP;
        this.c = (localDate.a - yVarP.b.a) + 1;
        this.a = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 4, this);
    }

    @Override // j$.time.chrono.d
    public final b H(long j) {
        return j0(this.a.plusDays(j));
    }

    @Override // j$.time.chrono.d
    public final b N(long j) {
        return j0(this.a.q0(j));
    }

    @Override // j$.time.chrono.d
    public final b Q(long j) {
        return j0(this.a.s0(j));
    }

    @Override // j$.time.chrono.b
    public final long S() {
        return this.a.S();
    }

    @Override // j$.time.chrono.b
    public final e T(j$.time.i iVar) {
        return new g(this, iVar);
    }

    @Override // j$.time.chrono.b
    public final m V() {
        return this.b;
    }

    public final x Y(long j, ChronoUnit chronoUnit) {
        return (x) super.d(j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b a(long j, TemporalUnit temporalUnit) {
        return (x) super.a(j, temporalUnit);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b a0(j$.time.temporal.o oVar) {
        return (x) super.a0(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b d(long j, TemporalUnit temporalUnit) {
        return (x) super.d(j, temporalUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // j$.time.chrono.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d0() {
        /*
            r4 = this;
            j$.time.chrono.y r0 = r4.b
            j$.time.chrono.y r0 = r0.q()
            r1 = 1
            if (r0 == 0) goto L19
            j$.time.LocalDate r0 = r0.b
            int r2 = r0.a
            j$.time.LocalDate r3 = r4.a
            int r3 = r3.a
            if (r2 != r3) goto L19
            int r0 = r0.f0()
            int r0 = r0 - r1
            goto L1f
        L19:
            j$.time.LocalDate r0 = r4.a
            int r0 = r0.d0()
        L1f:
            int r2 = r4.c
            if (r2 != r1) goto L2d
            j$.time.chrono.y r4 = r4.b
            j$.time.LocalDate r4 = r4.b
            int r4 = r4.f0()
            int r4 = r4 - r1
            int r0 = r0 - r4
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.d0():int");
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.a.equals(((x) obj).a);
        }
        return false;
    }

    @Override // j$.time.chrono.b
    public final l f() {
        return v.c;
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final x c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (x) super.c(j, pVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        if (i(aVar) == j) {
            return this;
        }
        int[] iArr = w.a;
        int i = iArr[aVar.ordinal()];
        if (i == 3 || i == 8 || i == 9) {
            v vVar = v.c;
            int iA = vVar.F(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3) {
                return j0(this.a.w0(vVar.K(this.b, iA)));
            }
            if (i2 == 8) {
                return j0(this.a.w0(vVar.K(y.r(iA), this.c)));
            }
            if (i2 == 9) {
                return j0(this.a.w0(iA));
            }
        }
        return j0(this.a.c(j, pVar));
    }

    @Override // j$.time.chrono.b, j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.p pVar) {
        if (pVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || pVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || pVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || pVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).isDateBased() : pVar != null && pVar.u(this);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        v.c.getClass();
        return this.a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.Y(this);
        }
        switch (w.a[((j$.time.temporal.a) pVar).ordinal()]) {
            case 2:
                int i = this.c;
                LocalDate localDate = this.a;
                return i == 1 ? (localDate.f0() - this.b.b.f0()) + 1 : localDate.f0();
            case 3:
                return this.c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
            case 8:
                return this.b.a;
            default:
                return this.a.i(pVar);
        }
    }

    public final x i0(j$.time.d dVar) {
        return (x) super.m(dVar);
    }

    public final x j0(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new x(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return (x) super.m(localDate);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.H(this);
        }
        if (!h(pVar)) {
            throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        int i = w.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.s.f(1L, this.a.j0());
        }
        if (i == 2) {
            return j$.time.temporal.s.f(1L, d0());
        }
        if (i != 3) {
            return v.c.F(aVar);
        }
        y yVar = this.b;
        int i2 = yVar.b.a;
        return yVar.q() != null ? j$.time.temporal.s.f(1L, (r5.b.a - i2) + 1) : j$.time.temporal.s.f(1L, 999999999 - i2);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b m(j$.time.temporal.m mVar) {
        return (x) super.m(mVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final j$.time.temporal.l a(long j, TemporalUnit temporalUnit) {
        return (x) super.a(j, temporalUnit);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    public final j$.time.temporal.l d(long j, TemporalUnit temporalUnit) {
        return (x) super.d(j, temporalUnit);
    }

    public x(y yVar, int i, LocalDate localDate) {
        if (!localDate.i0(d)) {
            this.b = yVar;
            this.c = i;
            this.a = localDate;
            return;
        }
        j$.nio.file.j.h("JapaneseDate before Meiji 6 is not supported");
        throw null;
    }
}
