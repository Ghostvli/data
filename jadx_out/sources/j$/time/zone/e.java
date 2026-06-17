package j$.time.zone;

import j$.nio.file.j;
import j$.time.ZoneOffset;
import j$.time.k;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    public final k a;
    public final byte b;
    public final j$.time.c c;
    public final j$.time.i d;
    public final boolean e;
    public final d f;
    public final ZoneOffset g;
    public final ZoneOffset h;
    public final ZoneOffset i;

    public e(k kVar, int i, j$.time.c cVar, j$.time.i iVar, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.a = kVar;
        this.b = (byte) i;
        this.c = cVar;
        this.d = iVar;
        this.e = z;
        this.f = dVar;
        this.g = zoneOffset;
        this.h = zoneOffset2;
        this.i = zoneOffset3;
    }

    public static e a(DataInput dataInput) {
        k kVar;
        e eVar;
        j$.time.i iVarH;
        int i = dataInput.readInt();
        k kVarQ = k.Q(i >>> 28);
        int i2 = ((264241152 & i) >>> 22) - 32;
        int i3 = (3670016 & i) >>> 19;
        j$.time.c cVarU = i3 == 0 ? null : j$.time.c.u(i3);
        int i4 = (507904 & i) >>> 14;
        d dVar = d.values()[(i & 12288) >>> 12];
        int i5 = (i & 4080) >>> 4;
        int i6 = (i & 12) >>> 2;
        int i7 = i & 3;
        if (i4 == 31) {
            long j = dataInput.readInt();
            j$.time.i iVar = j$.time.i.e;
            j$.time.temporal.a.SECOND_OF_DAY.i0(j);
            int i8 = (int) (j / 3600);
            kVar = kVarQ;
            eVar = null;
            long j2 = j - ((long) (i8 * 3600));
            int i9 = (int) (j2 / 60);
            iVarH = j$.time.i.H(i8, i9, (int) (j2 - ((long) (i9 * 60))), 0);
        } else {
            kVar = kVarQ;
            eVar = null;
            int i10 = i4 % 24;
            j$.time.i iVar2 = j$.time.i.e;
            j$.time.temporal.a.HOUR_OF_DAY.i0(i10);
            iVarH = j$.time.i.h[i10];
        }
        ZoneOffset zoneOffsetL0 = i5 == 255 ? ZoneOffset.l0(dataInput.readInt()) : ZoneOffset.l0((i5 - 128) * 900);
        ZoneOffset zoneOffsetL02 = i6 == 3 ? ZoneOffset.l0(dataInput.readInt()) : ZoneOffset.l0((i6 * 1800) + zoneOffsetL0.b);
        ZoneOffset zoneOffsetL03 = ZoneOffset.l0(i7 == 3 ? dataInput.readInt() : (i7 * 1800) + zoneOffsetL0.b);
        boolean z = i4 == 24;
        k kVar2 = kVar;
        Objects.requireNonNull(kVar2, "month");
        Objects.requireNonNull(iVarH, "time");
        Objects.requireNonNull(dVar, "timeDefnition");
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            j.a("Day of month indicator must be between -28 and 31 inclusive excluding zero");
            return eVar;
        }
        if (z && !iVarH.equals(j$.time.i.g)) {
            j.a("Time must be midnight when end of day flag is true");
            return eVar;
        }
        if (iVarH.d == 0) {
            return new e(kVar2, i2, cVarU, iVarH, z, dVar, zoneOffsetL0, zoneOffsetL02, zoneOffsetL03);
        }
        j.a("Time's nano-of-second must be zero");
        return eVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int iP0 = this.e ? 86400 : this.d.p0();
        int i = this.g.b;
        int i2 = this.h.b - i;
        int i3 = this.i.b - i;
        byte b = iP0 % 3600 == 0 ? this.e ? (byte) 24 : this.d.a : (byte) 31;
        int i4 = i % 900 == 0 ? (i / 900) + 128 : 255;
        int i5 = (i2 == 0 || i2 == 1800 || i2 == 3600) ? i2 / 1800 : 3;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        j$.time.c cVar = this.c;
        dataOutput.writeInt((this.a.getValue() << 28) + ((this.b + 32) << 22) + ((cVar == null ? 0 : cVar.getValue()) << 19) + (b << 14) + (this.f.ordinal() << 12) + (i4 << 4) + (i5 << 2) + i6);
        if (b == 31) {
            dataOutput.writeInt(iP0);
        }
        if (i4 == 255) {
            dataOutput.writeInt(i);
        }
        if (i5 == 3) {
            dataOutput.writeInt(this.h.b);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.i.b);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && this.c == eVar.c && this.f == eVar.f && this.d.equals(eVar.d) && this.e == eVar.e && this.g.equals(eVar.g) && this.h.equals(eVar.h) && this.i.equals(eVar.i);
    }

    public final int hashCode() {
        int iP0 = ((this.d.p0() + (this.e ? 1 : 0)) << 15) + (this.a.ordinal() << 11) + ((this.b + 32) << 5);
        j$.time.c cVar = this.c;
        return this.i.b ^ ((this.g.b ^ (this.f.ordinal() + (iP0 + ((cVar == null ? 7 : cVar.ordinal()) << 2)))) ^ this.h.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.i.b - this.h.b > 0 ? "Gap " : "Overlap ");
        sb.append(this.h);
        sb.append(" to ");
        sb.append(this.i);
        sb.append(", ");
        j$.time.c cVar = this.c;
        if (cVar != null) {
            byte b = this.b;
            if (b == -1) {
                sb.append(cVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.a.name());
            } else if (b < 0) {
                sb.append(cVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.b) - 1);
                sb.append(" of ");
                sb.append(this.a.name());
            } else {
                sb.append(cVar.name());
                sb.append(" on or after ");
                sb.append(this.a.name());
                sb.append(' ');
                sb.append((int) this.b);
            }
        } else {
            sb.append(this.a.name());
            sb.append(' ');
            sb.append((int) this.b);
        }
        sb.append(" at ");
        sb.append(this.e ? "24:00" : this.d.toString());
        sb.append(" ");
        sb.append(this.f);
        sb.append(", standard offset ");
        sb.append(this.g);
        sb.append(']');
        return sb.toString();
    }
}
