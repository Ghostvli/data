package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements j$.time.temporal.l, j$.time.temporal.m, Comparable, Serializable {
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i[] h = new i[24];
    private static final long serialVersionUID = 6414437269572265201L;
    public final byte a;
    public final byte b;
    public final byte c;
    public final int d;

    static {
        int i = 0;
        while (true) {
            i[] iVarArr = h;
            if (i >= iVarArr.length) {
                i iVar = iVarArr[0];
                g = iVar;
                i iVar2 = iVarArr[12];
                e = iVar;
                f = new i(23, 59, 59, 999999999);
                return;
            }
            iVarArr[i] = new i(i, 0, 0, 0);
            i++;
        }
    }

    public i(int i, int i2, int i3, int i4) {
        this.a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    public static i H(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? h[i] : new i(i, i2, i3, i4);
    }

    public static i N(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        i iVar = (i) temporalAccessor.b(j$.time.temporal.q.g);
        if (iVar != null) {
            return iVar;
        }
        j$.nio.file.j.f("Unable to obtain LocalTime from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static i Y(int i, int i2, int i3, int i4) {
        j$.time.temporal.a.HOUR_OF_DAY.i0(i);
        j$.time.temporal.a.MINUTE_OF_HOUR.i0(i2);
        j$.time.temporal.a.SECOND_OF_MINUTE.i0(i3);
        j$.time.temporal.a.NANO_OF_SECOND.i0(i4);
        return H(i, i2, i3, i4);
    }

    public static i f0(long j) {
        j$.time.temporal.a.NANO_OF_DAY.i0(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return H(i, i2, i3, (int) (j3 - (((long) i3) * 1000000000)));
    }

    public static i n0(DataInput dataInput) throws IOException {
        int i;
        int i2;
        int i3 = dataInput.readByte();
        int i4 = 0;
        if (i3 < 0) {
            i3 = ~i3;
            i2 = 0;
            i = 0;
        } else {
            byte b = dataInput.readByte();
            if (b < 0) {
                int i5 = ~b;
                i = 0;
                i4 = i5;
                i2 = 0;
            } else {
                byte b2 = dataInput.readByte();
                if (b2 < 0) {
                    i2 = ~b2;
                    i = 0;
                    i4 = b;
                } else {
                    i = dataInput.readInt();
                    i4 = b;
                    i2 = b2;
                }
            }
        }
        return Y(i3, i4, i2, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new q((byte) 4, this);
    }

    public final int Q(j$.time.temporal.p pVar) {
        switch (h.a[((j$.time.temporal.a) pVar).ordinal()]) {
            case 1:
                return this.d;
            case 2:
                throw new j$.time.temporal.r("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.d / 1000;
            case 4:
                throw new j$.time.temporal.r("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.d / 1000000;
            case 6:
                return (int) (o0() / 1000000);
            case 7:
                return this.c;
            case 8:
                return p0();
            case 9:
                return this.b;
            case 10:
                return (this.a * 60) + this.b;
            case 11:
                return this.a % 12;
            case 12:
                int i = this.a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.a;
            case 14:
                byte b = this.a;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.a / 12;
            default:
                throw new j$.time.temporal.r(b.a("Unsupported field: ", pVar));
        }
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
        if (dVar == j$.time.temporal.q.b || dVar == j$.time.temporal.q.a || dVar == j$.time.temporal.q.e || dVar == j$.time.temporal.q.d) {
            return null;
        }
        if (dVar == j$.time.temporal.q.g) {
            return this;
        }
        if (dVar == j$.time.temporal.q.f) {
            return null;
        }
        return dVar == j$.time.temporal.q.c ? ChronoUnit.NANOS : dVar.k(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.l e(j$.time.temporal.l lVar) {
        return lVar.c(o0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a == iVar.a && this.b == iVar.b && this.c == iVar.c && this.d == iVar.d) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? Q(pVar) : super.g(pVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) pVar).j0() : pVar != null && pVar.u(this);
    }

    public final int hashCode() {
        long jO0 = o0();
        return (int) (jO0 ^ (jO0 >>> 32));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.p pVar) {
        return pVar instanceof j$.time.temporal.a ? pVar == j$.time.temporal.a.NANO_OF_DAY ? o0() : pVar == j$.time.temporal.a.MICRO_OF_DAY ? o0() / 1000 : Q(pVar) : pVar.Y(this);
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final i d(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (i) temporalUnit.u(this, j);
        }
        switch (h.b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return l0(j);
            case 2:
                return l0((j % 86400000000L) * 1000);
            case 3:
                return l0((j % 86400000) * 1000000);
            case 4:
                return m0(j);
            case 5:
                return k0(j);
            case 6:
                return j0(j);
            case 7:
                return j0((j % 2) * 12);
            default:
                j$.nio.file.j.d("Unsupported unit: ", temporalUnit);
                return null;
        }
    }

    public final i j0(long j) {
        return j == 0 ? this : H(((((int) (j % 24)) + this.a) + 24) % 24, this.b, this.c, this.d);
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.l m(LocalDate localDate) {
        return (i) localDate.e(this);
    }

    public final i k0(long j) {
        if (j != 0) {
            int i = (this.a * 60) + this.b;
            int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i2) {
                return H(i2 / 60, i2 % 60, this.c, this.d);
            }
        }
        return this;
    }

    public final i l0(long j) {
        if (j != 0) {
            long jO0 = o0();
            long j2 = (((j % 86400000000000L) + jO0) + 86400000000000L) % 86400000000000L;
            if (jO0 != j2) {
                return H((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
            }
        }
        return this;
    }

    public final i m0(long j) {
        if (j != 0) {
            int i = (this.b * 60) + (this.a * 3600) + this.c;
            int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
            if (i != i2) {
                return H(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.d);
            }
        }
        return this;
    }

    public final long o0() {
        return (((long) this.c) * 1000000000) + (((long) this.b) * 60000000000L) + (((long) this.a) * 3600000000000L) + ((long) this.d);
    }

    public final int p0() {
        return (this.b * 60) + (this.a * 3600) + this.c;
    }

    @Override // j$.time.temporal.l
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public final i c(long j, j$.time.temporal.p pVar) {
        if (!(pVar instanceof j$.time.temporal.a)) {
            return (i) pVar.f0(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) pVar;
        aVar.i0(j);
        switch (h.a[aVar.ordinal()]) {
            case 1:
                return r0((int) j);
            case 2:
                return f0(j);
            case 3:
                return r0(((int) j) * 1000);
            case 4:
                return f0(j * 1000);
            case 5:
                return r0(((int) j) * 1000000);
            case 6:
                return f0(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.c != i) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.i0(i);
                    return H(this.a, this.b, i, this.d);
                }
                return this;
            case 8:
                return m0(j - ((long) p0()));
            case 9:
                int i2 = (int) j;
                if (this.b != i2) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.i0(i2);
                    return H(this.a, i2, this.c, this.d);
                }
                return this;
            case 10:
                return k0(j - ((long) ((this.a * 60) + this.b)));
            case 11:
                return j0(j - ((long) (this.a % 12)));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return j0(j - ((long) (this.a % 12)));
            case 13:
                int i3 = (int) j;
                if (this.a != i3) {
                    j$.time.temporal.a.HOUR_OF_DAY.i0(i3);
                    return H(i3, this.b, this.c, this.d);
                }
                return this;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i4 = (int) j;
                if (this.a != i4) {
                    j$.time.temporal.a.HOUR_OF_DAY.i0(i4);
                    return H(i4, this.b, this.c, this.d);
                }
                return this;
            case 15:
                return j0((j - ((long) (this.a / 12))) * 12);
            default:
                throw new j$.time.temporal.r(b.a("Unsupported field: ", pVar));
        }
    }

    public final i r0(int i) {
        if (this.d == i) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.i0(i);
        return H(this.a, this.b, this.c, i);
    }

    public final void s0(DataOutput dataOutput) throws IOException {
        if (this.d != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(this.c);
            dataOutput.writeInt(this.d);
            return;
        }
        if (this.c != 0) {
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(~this.c);
            return;
        }
        byte b = this.b;
        byte b2 = this.a;
        if (b == 0) {
            dataOutput.writeByte(~b2);
        } else {
            dataOutput.writeByte(b2);
            dataOutput.writeByte(~this.b);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        int i = this.d;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            sb.append(b3 < 10 ? ":0" : ":");
            sb.append((int) b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
                }
            }
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final int compareTo(i iVar) {
        int iCompare = Integer.compare(this.a, iVar.a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.b, iVar.b)) == 0 && (iCompare = Integer.compare(this.c, iVar.c)) == 0) ? Integer.compare(this.d, iVar.d) : iCompare;
    }
}
