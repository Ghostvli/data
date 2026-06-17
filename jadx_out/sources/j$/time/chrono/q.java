package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.LocalDate;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends d {
    private static final long serialVersionUID = -5207853542612002020L;
    public final transient o a;
    public final transient int b;
    public final transient int c;
    public final transient int d;

    public q(o oVar, long j) {
        int i = (int) j;
        oVar.i0();
        if (i < oVar.e || i >= oVar.f) {
            j$.nio.file.j.h("Hijrah date out of range");
            throw null;
        }
        int iBinarySearch = Arrays.binarySearch(oVar.d, i);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int[] iArr = {oVar.k0(iBinarySearch), ((oVar.g + iBinarySearch) % 12) + 1, (i - oVar.d[iBinarySearch]) + 1};
        this.a = oVar;
        this.b = iArr[0];
        this.c = iArr[1];
        this.d = iArr[2];
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 6, this);
    }

    @Override // j$.time.chrono.b
    public final boolean E() {
        return this.a.g0(this.b);
    }

    @Override // j$.time.chrono.d
    public final b Q(long j) {
        return j == 0 ? this : j0(Math.addExact(this.b, (int) j), this.c, this.d);
    }

    @Override // j$.time.chrono.b
    public final long S() {
        return this.a.l0(this.b, this.c, this.d);
    }

    @Override // j$.time.chrono.b
    public final e T(j$.time.i iVar) {
        return new g(this, iVar);
    }

    @Override // j$.time.chrono.b
    public final m V() {
        return r.AH;
    }

    public final int Y() {
        return this.a.o0(this.b, this.c - 1) + this.d;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b a(long j, TemporalUnit temporalUnit) {
        return (q) super.a(j, temporalUnit);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b a0(j$.time.temporal.o oVar) {
        return (q) super.a0(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final b d(long j, TemporalUnit temporalUnit) {
        return (q) super.d(j, temporalUnit);
    }

    @Override // j$.time.chrono.b
    public final int d0() {
        return this.a.o0(this.b, 12);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.b == qVar.b && this.c == qVar.c && this.d == qVar.d && this.a.equals(qVar.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.b
    public final l f() {
        return this.a;
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final q H(long j) {
        return new q(this.a, S() + j);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        this.a.getClass();
        return ((i & (-2048)) ^ 2100100019) ^ (((i << 11) + (i2 << 6)) + i3);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        int iY;
        int iFloorMod;
        if (!(pVar instanceof j$.time.temporal.a)) {
            return pVar.Y(this);
        }
        switch (p.a[((j$.time.temporal.a) pVar).ordinal()]) {
            case 1:
                iY = this.d;
                return iY;
            case 2:
                iY = Y();
                return iY;
            case 3:
                iFloorMod = (this.d - 1) / 7;
                iY = iFloorMod + 1;
                return iY;
            case 4:
                iFloorMod = (int) Math.floorMod(S() + 3, 7L);
                iY = iFloorMod + 1;
                return iY;
            case 5:
                iFloorMod = (this.d - 1) % 7;
                iY = iFloorMod + 1;
                return iY;
            case 6:
                iFloorMod = (Y() - 1) % 7;
                iY = iFloorMod + 1;
                return iY;
            case 7:
                return S();
            case 8:
                iFloorMod = (Y() - 1) / 7;
                iY = iFloorMod + 1;
                return iY;
            case 9:
                iY = this.c;
                return iY;
            case 10:
                return ((((long) this.b) * 12) + ((long) this.c)) - 1;
            case 11:
                iY = this.b;
                return iY;
            case 12:
                iY = this.b;
                return iY;
            case 13:
                return this.b <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
        }
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final q N(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j;
        o oVar = this.a;
        long jFloorDiv = Math.floorDiv(j2, 12L);
        if (jFloorDiv >= oVar.k0(0) && jFloorDiv <= oVar.k0(oVar.d.length - 1) - 1) {
            return j0((int) jFloorDiv, ((int) Math.floorMod(j2, 12L)) + 1, this.d);
        }
        throw new DateTimeException("Invalid Hijrah year: " + jFloorDiv);
    }

    public final q j0(int i, int i2, int i3) {
        int iM0 = this.a.m0(i, i2);
        if (i3 > iM0) {
            i3 = iM0;
        }
        return new q(this.a, i, i2, i3);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return (q) super.m(localDate);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final q c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (q) super.c(j, pVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        this.a.F(aVar).b(j, aVar);
        int i = (int) j;
        switch (p.a[aVar.ordinal()]) {
            case 1:
                return j0(this.b, this.c, i);
            case 2:
                return H(Math.min(i, d0()) - Y());
            case 3:
                return H((j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return H(j - ((long) (((int) Math.floorMod(S() + 3, 7L)) + 1)));
            case 5:
                return H(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return H(j - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(this.a, j);
            case 8:
                return H((j - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return j0(this.b, i, this.d);
            case 10:
                return N(j - (((((long) this.b) * 12) + ((long) this.c)) - 1));
            case 11:
                if (this.b < 1) {
                    i = 1 - i;
                }
                return j0(i, this.c, this.d);
            case 12:
                return j0(i, this.c, this.d);
            case 13:
                return j0(1 - this.b, this.c, this.d);
            default:
                throw new j$.time.temporal.r(j$.time.b.a("Unsupported field: ", pVar));
        }
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
        int i = p.a[aVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.a.F(aVar) : j$.time.temporal.s.f(1L, 5L) : j$.time.temporal.s.f(1L, d0()) : j$.time.temporal.s.f(1L, this.a.m0(this.b, this.c));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b m(j$.time.temporal.m mVar) {
        return (q) super.m(mVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.l
    public final j$.time.temporal.l a(long j, TemporalUnit temporalUnit) {
        return (q) super.a(j, temporalUnit);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.l
    public final j$.time.temporal.l d(long j, TemporalUnit temporalUnit) {
        return (q) super.d(j, temporalUnit);
    }

    public q(o oVar, int i, int i2, int i3) {
        oVar.l0(i, i2, i3);
        this.a = oVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
