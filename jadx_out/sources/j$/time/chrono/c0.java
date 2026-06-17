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

    public c0(LocalDate localDate) {
        Objects.requireNonNull(localDate, "isoDate");
        this.a = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 7, this);
    }

    @Override // j$.time.chrono.d
    public final b H(long j) {
        return i0(this.a.plusDays(j));
    }

    @Override // j$.time.chrono.d
    public final b N(long j) {
        return i0(this.a.q0(j));
    }

    @Override // j$.time.chrono.d
    public final b Q(long j) {
        return i0(this.a.s0(j));
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
        return Y() >= 1 ? d0.ROC : d0.BEFORE_ROC;
    }

    public final int Y() {
        return this.a.a - 1911;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b a(long j, TemporalUnit temporalUnit) {
        return (c0) super.a(j, temporalUnit);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b a0(j$.time.temporal.o oVar) {
        return (c0) super.a0(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b d(long j, TemporalUnit temporalUnit) {
        return (c0) super.d(j, temporalUnit);
    }

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

    @Override // j$.time.chrono.b
    public final l f() {
        return a0.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.c0 c(long r8, j$.time.temporal.p r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.a
            if (r0 == 0) goto L9f
            r0 = r10
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r7.i(r0)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 != 0) goto L10
            return r7
        L10:
            int[] r1 = j$.time.chrono.b0.a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L49
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L49
            if (r2 == r3) goto L49
            goto L5f
        L25:
            j$.time.chrono.a0 r10 = j$.time.chrono.a0.c
            j$.time.temporal.s r10 = r10.F(r0)
            r10.b(r8, r0)
            int r10 = r7.Y()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            j$.time.LocalDate r10 = r7.a
            short r2 = r10.b
            long r2 = (long) r2
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.LocalDate r8 = r10.q0(r8)
            j$.time.chrono.c0 r7 = r7.i0(r8)
            return r7
        L49:
            j$.time.chrono.a0 r2 = j$.time.chrono.a0.c
            j$.time.temporal.s r2 = r2.F(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L88
            if (r0 == r4) goto L7b
            if (r0 == r3) goto L6a
        L5f:
            j$.time.LocalDate r0 = r7.a
            j$.time.LocalDate r8 = r0.c(r8, r10)
            j$.time.chrono.c0 r7 = r7.i0(r8)
            return r7
        L6a:
            j$.time.LocalDate r8 = r7.a
            int r9 = r7.Y()
            int r9 = 1912 - r9
            j$.time.LocalDate r8 = r8.w0(r9)
            j$.time.chrono.c0 r7 = r7.i0(r8)
            return r7
        L7b:
            j$.time.LocalDate r8 = r7.a
            int r2 = r2 + 1911
            j$.time.LocalDate r8 = r8.w0(r2)
            j$.time.chrono.c0 r7 = r7.i0(r8)
            return r7
        L88:
            j$.time.LocalDate r8 = r7.a
            int r9 = r7.Y()
            r10 = 1
            if (r9 < r10) goto L94
            int r2 = r2 + 1911
            goto L96
        L94:
            int r2 = 1912 - r2
        L96:
            j$.time.LocalDate r8 = r8.w0(r2)
            j$.time.chrono.c0 r7 = r7.i0(r8)
            return r7
        L9f:
            j$.time.chrono.b r7 = super.c(r8, r10)
            j$.time.chrono.c0 r7 = (j$.time.chrono.c0) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.c0.c(long, j$.time.temporal.p):j$.time.chrono.c0");
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        a0.c.getClass();
        return this.a.hashCode() ^ (-1990173233);
    }

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

    public final c0 i0(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new c0(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return (c0) super.m(localDate);
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
