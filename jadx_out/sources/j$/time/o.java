package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements j$.time.temporal.l, j$.time.temporal.m, Comparable, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 7264499704384272492L;
    public final i a;
    public final ZoneOffset b;

    static {
        i iVar = i.e;
        ZoneOffset zoneOffset = ZoneOffset.g;
        iVar.getClass();
        new o(iVar, zoneOffset);
        i iVar2 = i.f;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        iVar2.getClass();
        new o(iVar2, zoneOffset2);
    }

    public o(i iVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(iVar, "time");
        this.a = iVar;
        Objects.requireNonNull(zoneOffset, "offset");
        this.b = zoneOffset;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new q((byte) 9, this);
    }

    public final o H(i iVar, ZoneOffset zoneOffset) {
        return (this.a == iVar && this.b.equals(zoneOffset)) ? this : new o(iVar, zoneOffset);
    }

    @Override // j$.time.temporal.l
    public final j$.time.temporal.l a(long j, TemporalUnit temporalUnit) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = d(Long.MAX_VALUE, temporalUnit);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.d(j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(d dVar) {
        if (dVar == j$.time.temporal.q.d || dVar == j$.time.temporal.q.e) {
            return this.b;
        }
        if (((dVar == j$.time.temporal.q.a) || (dVar == j$.time.temporal.q.b)) || dVar == j$.time.temporal.q.f) {
            return null;
        }
        return dVar == j$.time.temporal.q.g ? this.a : dVar == j$.time.temporal.q.c ? ChronoUnit.NANOS : dVar.k(this);
    }

    @Override // j$.time.temporal.l
    public final j$.time.temporal.l c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (o) pVar.f0(this, j);
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
        i iVar = this.a;
        if (pVar != aVar) {
            return H(iVar.c(j, pVar), this.b);
        }
        j$.time.temporal.a aVar2 = (j$.time.temporal.a) pVar;
        return H(iVar, ZoneOffset.l0(aVar2.b.a(j, aVar2)));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        boolean zEquals = this.b.equals(oVar.b);
        i iVar = this.a;
        if (zEquals) {
            return iVar.compareTo(oVar.a);
        }
        int iCompare = Long.compare(iVar.o0() - (((long) this.b.b) * 1000000000), oVar.a.o0() - (((long) oVar.b.b) * 1000000000));
        return iCompare == 0 ? this.a.compareTo(oVar.a) : iCompare;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.l e(j$.time.temporal.l lVar) {
        return lVar.c(this.a.o0(), j$.time.temporal.a.NANO_OF_DAY).c(this.b.b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.a.equals(oVar.a) && this.b.equals(oVar.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() || pVar == j$.time.temporal.a.OFFSET_SECONDS : pVar != null && pVar.u(this);
    }

    public final int hashCode() {
        return this.b.b ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? pVar == j$.time.temporal.a.OFFSET_SECONDS ? this.b.b : this.a.i(pVar) : pVar.Y(this);
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return (o) localDate.e(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.s l(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? pVar == j$.time.temporal.a.OFFSET_SECONDS ? ((j$.time.temporal.a) pVar).b : this.a.l(pVar) : pVar.H(this);
    }

    public final String toString() {
        return this.a.toString() + this.b.c;
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final o d(long j, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? H(this.a.d(j, temporalUnit), this.b) : (o) temporalUnit.u(this, j);
    }
}
