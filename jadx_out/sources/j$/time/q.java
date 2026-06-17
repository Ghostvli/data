package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    public byte a;
    public Object b;

    public q(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    public static Object a(byte b, ObjectInput objectInput) throws IOException {
        switch (b) {
            case 1:
                Duration duration = Duration.c;
                long j = objectInput.readLong();
                long j2 = objectInput.readInt();
                return Duration.H(Math.addExact(j, Math.floorDiv(j2, 1000000000L)), (int) Math.floorMod(j2, 1000000000L));
            case 2:
                Instant instant = Instant.EPOCH;
                return Instant.N(objectInput.readLong(), objectInput.readInt());
            case 3:
                LocalDate localDate = LocalDate.d;
                return LocalDate.m0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return i.n0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.c;
                LocalDate localDate2 = LocalDate.d;
                return LocalDateTime.Q(LocalDate.m0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), i.n0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.c;
                LocalDate localDate3 = LocalDate.d;
                LocalDateTime localDateTimeQ = LocalDateTime.Q(LocalDate.m0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), i.n0(objectInput));
                ZoneOffset zoneOffsetN0 = ZoneOffset.n0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetN0.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeQ, zoneId, zoneOffsetN0);
                }
                j$.nio.file.j.a("ZoneId must match ZoneOffset");
                return null;
            case 7:
                int i = v.d;
                return ZoneId.N(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.n0(objectInput);
            case 9:
                int i2 = o.c;
                return new o(i.n0(objectInput), ZoneOffset.n0(objectInput));
            case 10:
                int i3 = OffsetDateTime.c;
                LocalDate localDate4 = LocalDate.d;
                return new OffsetDateTime(LocalDateTime.Q(LocalDate.m0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), i.n0(objectInput)), ZoneOffset.n0(objectInput));
            case 11:
                int i4 = s.b;
                return s.u(objectInput.readInt());
            case 12:
                int i5 = u.c;
                int i6 = objectInput.readInt();
                byte b2 = objectInput.readByte();
                j$.time.temporal.a.YEAR.i0(i6);
                j$.time.temporal.a.MONTH_OF_YEAR.i0(b2);
                return new u(i6, b2);
            case 13:
                int i7 = m.c;
                byte b3 = objectInput.readByte();
                byte b4 = objectInput.readByte();
                k kVarQ = k.Q(b3);
                Objects.requireNonNull(kVarQ, "month");
                j$.time.temporal.a.DAY_OF_MONTH.i0(b4);
                if (b4 <= kVarQ.N()) {
                    return new m(kVarQ.getValue(), b4);
                }
                throw new DateTimeException("Illegal value for DayOfMonth field, value " + ((int) b4) + " is not valid for month " + kVarQ.name());
            case 14:
                p pVar = p.d;
                return p.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b = objectInput.readByte();
        this.a = b;
        this.b = a(b, objectInput);
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.a);
                objectOutput.writeInt(duration.b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.a);
                objectOutput.writeInt(instant.b);
                return;
            case 3:
                LocalDate localDate = (LocalDate) obj;
                objectOutput.writeInt(localDate.a);
                objectOutput.writeByte(localDate.b);
                objectOutput.writeByte(localDate.c);
                return;
            case 4:
                ((i) obj).s0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                LocalDate localDate2 = localDateTime.a;
                objectOutput.writeInt(localDate2.a);
                objectOutput.writeByte(localDate2.b);
                objectOutput.writeByte(localDate2.c);
                localDateTime.b.s0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.a;
                LocalDate localDate3 = localDateTime2.a;
                objectOutput.writeInt(localDate3.a);
                objectOutput.writeByte(localDate3.b);
                objectOutput.writeByte(localDate3.c);
                localDateTime2.b.s0(objectOutput);
                zonedDateTime.b.o0(objectOutput);
                zonedDateTime.c.f0(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((v) obj).b);
                return;
            case 8:
                ((ZoneOffset) obj).o0(objectOutput);
                return;
            case 9:
                o oVar = (o) obj;
                oVar.a.s0(objectOutput);
                oVar.b.o0(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.a;
                LocalDate localDate4 = localDateTime3.a;
                objectOutput.writeInt(localDate4.a);
                objectOutput.writeByte(localDate4.b);
                objectOutput.writeByte(localDate4.c);
                localDateTime3.b.s0(objectOutput);
                offsetDateTime.b.o0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((s) obj).a);
                return;
            case 12:
                u uVar = (u) obj;
                objectOutput.writeInt(uVar.a);
                objectOutput.writeByte(uVar.b);
                return;
            case 13:
                m mVar = (m) obj;
                objectOutput.writeByte(mVar.a);
                objectOutput.writeByte(mVar.b);
                return;
            case 14:
                p pVar = (p) obj;
                objectOutput.writeInt(pVar.a);
                objectOutput.writeInt(pVar.b);
                objectOutput.writeInt(pVar.c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public q() {
    }
}
