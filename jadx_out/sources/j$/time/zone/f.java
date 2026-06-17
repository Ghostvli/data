package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.k;
import j$.time.temporal.n;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements Serializable {
    public static final long[] i = new long[0];
    public static final e[] j = new e[0];
    public static final LocalDateTime[] k = new LocalDateTime[0];
    public static final b[] l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;
    public final long[] a;
    public final ZoneOffset[] b;
    public final long[] c;
    public final LocalDateTime[] d;
    public final ZoneOffset[] e;
    public final e[] f;
    public final TimeZone g;
    public final transient ConcurrentMap h = new ConcurrentHashMap();

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.a = jArr;
        this.b = zoneOffsetArr;
        this.c = jArr2;
        this.e = zoneOffsetArr2;
        this.f = eVarArr;
        if (jArr2.length == 0) {
            this.d = k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jArr2.length) {
                int i3 = i2 + 1;
                b bVar = new b(jArr2[i2], zoneOffsetArr2[i2], zoneOffsetArr2[i3]);
                boolean zU = bVar.u();
                LocalDateTime localDateTime = bVar.b;
                if (zU) {
                    arrayList.add(localDateTime);
                    arrayList.add(bVar.b.j0(bVar.d.b - bVar.c.b));
                } else {
                    arrayList.add(localDateTime.j0(bVar.d.b - bVar.c.b));
                    arrayList.add(bVar.b);
                }
                i2 = i3;
            }
            this.d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.g = null;
    }

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.b;
        if (bVar.u()) {
            if (localDateTime.N(localDateTime2)) {
                return bVar.c;
            }
            if (!localDateTime.N(bVar.b.j0(bVar.d.b - bVar.c.b))) {
                return bVar.d;
            }
        } else {
            if (!localDateTime.N(localDateTime2)) {
                return bVar.d;
            }
            if (localDateTime.N(bVar.b.j0(bVar.d.b - bVar.c.b))) {
                return bVar.c;
            }
        }
        return bVar;
    }

    public static int c(long j2, ZoneOffset zoneOffset) {
        return LocalDate.n0(Math.floorDiv(j2 + ((long) zoneOffset.b), 86400L)).a;
    }

    public static ZoneOffset i(int i2) {
        return ZoneOffset.l0(i2 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.g != null ? (byte) 100 : (byte) 1, this);
    }

    public final b[] b(int i2) {
        LocalDate localDateH;
        b[] bVarArr = l;
        Integer numValueOf = Integer.valueOf(i2);
        b[] bVarArr2 = (b[]) ((ConcurrentHashMap) this.h).get(numValueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j2 = 1;
        int i3 = 0;
        int i4 = 1;
        if (this.g != null) {
            if (i2 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.c;
            LocalDate localDateM0 = LocalDate.m0(i2 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.i0(0L);
            long jB = new LocalDateTime(localDateM0, j$.time.i.h[0]).B(this.b[0]);
            long j3 = 1000;
            int offset = this.g.getOffset(jB * 1000);
            long j4 = 31968000 + jB;
            while (jB < j4) {
                long j5 = jB + 7776000;
                long j6 = j3;
                if (offset != this.g.getOffset(j5 * j6)) {
                    while (j5 - jB > j2) {
                        long jFloorDiv = Math.floorDiv(j5 + jB, 2L);
                        if (this.g.getOffset(jFloorDiv * j6) == offset) {
                            jB = jFloorDiv;
                        } else {
                            j5 = jFloorDiv;
                        }
                        j2 = 1;
                    }
                    if (this.g.getOffset(jB * j6) == offset) {
                        jB = j5;
                    }
                    ZoneOffset zoneOffsetI = i(offset);
                    int offset2 = this.g.getOffset(jB * j6);
                    ZoneOffset zoneOffsetI2 = i(offset2);
                    if (c(jB, zoneOffsetI2) == i2) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(jB, zoneOffsetI, zoneOffsetI2);
                    }
                    offset = offset2;
                } else {
                    jB = j5;
                }
                j3 = j6;
                j2 = 1;
            }
            if (1916 <= i2 && i2 < 2100) {
                ((ConcurrentHashMap) this.h).putIfAbsent(numValueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i5 = 0;
        while (i5 < eVarArr.length) {
            e eVar = eVarArr[i5];
            byte b = eVar.b;
            k kVar = eVar.a;
            if (b < 0) {
                long j7 = i2;
                int iH = kVar.H(s.c.g0(j7)) + 1 + eVar.b;
                LocalDate localDate = LocalDate.d;
                j$.time.temporal.a.YEAR.i0(j7);
                j$.time.temporal.a.DAY_OF_MONTH.i0(iH);
                localDateH = LocalDate.H(i2, kVar.getValue(), iH);
                j$.time.c cVar = eVar.c;
                if (cVar != null) {
                    localDateH = localDateH.k(new n(cVar.getValue(), i4));
                }
            } else {
                LocalDate localDate2 = LocalDate.d;
                j$.time.temporal.a.YEAR.i0(i2);
                j$.time.temporal.a.DAY_OF_MONTH.i0(b);
                localDateH = LocalDate.H(i2, kVar.getValue(), b);
                j$.time.c cVar2 = eVar.c;
                if (cVar2 != null) {
                    localDateH = localDateH.k(new n(cVar2.getValue(), i3));
                }
            }
            if (eVar.e) {
                localDateH = localDateH.plusDays(1L);
            }
            LocalDateTime localDateTimeQ = LocalDateTime.Q(localDateH, eVar.d);
            d dVar = eVar.f;
            ZoneOffset zoneOffset = eVar.g;
            ZoneOffset zoneOffset2 = eVar.h;
            int i6 = c.a[dVar.ordinal()];
            if (i6 == 1) {
                localDateTimeQ = localDateTimeQ.j0(zoneOffset2.b - ZoneOffset.UTC.b);
            } else if (i6 == 2) {
                localDateTimeQ = localDateTimeQ.j0(zoneOffset2.b - zoneOffset.b);
            }
            bVarArr3[i5] = new b(localDateTimeQ, eVar.h, eVar.i);
            i5++;
            i3 = 0;
        }
        if (i2 < 2100) {
            ((ConcurrentHashMap) this.h).putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return i(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.c;
        if (jArr.length == 0) {
            return this.b[0];
        }
        long j2 = instant.a;
        if (this.f.length <= 0 || j2 <= jArr[jArr.length - 1]) {
            int iBinarySearch = Arrays.binarySearch(jArr, j2);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            return this.e[iBinarySearch + 1];
        }
        b[] bVarArrB = b(c(j2, this.e[r8.length - 1]));
        b bVar = null;
        for (int i2 = 0; i2 < bVarArrB.length; i2++) {
            bVar = bVarArrB[i2];
            if (j2 < bVar.a) {
                return bVar.c;
            }
        }
        return bVar.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r9) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.g, fVar.g) && Arrays.equals(this.a, fVar.a) && Arrays.equals(this.b, fVar.b) && Arrays.equals(this.c, fVar.c) && Arrays.equals(this.e, fVar.e) && Arrays.equals(this.f, fVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final List f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (!(objE instanceof b)) {
            return Collections.singletonList((ZoneOffset) objE);
        }
        b bVar = (b) objE;
        return bVar.u() ? Collections.EMPTY_LIST : j$.desugar.sun.nio.fs.g.o(new Object[]{bVar.c, bVar.d});
    }

    public final boolean g(Instant instant) {
        ZoneOffset zoneOffsetI;
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            zoneOffsetI = i(timeZone.getRawOffset());
        } else if (this.c.length == 0) {
            zoneOffsetI = this.b[0];
        } else {
            int iBinarySearch = Arrays.binarySearch(this.a, instant.a);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            zoneOffsetI = this.b[iBinarySearch + 1];
        }
        return !zoneOffsetI.equals(d(instant));
    }

    public final boolean h() {
        b bVar;
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            if (timeZone.useDaylightTime() || this.g.getDSTSavings() != 0) {
                return false;
            }
            Instant instant = Instant.EPOCH;
            j$.time.a.b.getClass();
            Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
            b bVar2 = null;
            if (this.g != null) {
                long j2 = instantOfEpochMilli.a;
                if (instantOfEpochMilli.b > 0 && j2 < Long.MAX_VALUE) {
                    j2++;
                }
                int iC = c(j2, d(instantOfEpochMilli));
                b[] bVarArrB = b(iC);
                int length = bVarArrB.length - 1;
                while (true) {
                    if (length >= 0) {
                        bVar = bVarArrB[length];
                        if (j2 > bVar.a) {
                            break;
                        }
                        length--;
                    } else if (iC > 1800) {
                        b[] bVarArrB2 = b(iC - 1);
                        for (int length2 = bVarArrB2.length - 1; length2 >= 0; length2--) {
                            bVar = bVarArrB2[length2];
                            if (j2 <= bVar.a) {
                            }
                        }
                        j$.time.a.b.getClass();
                        long jMin = Math.min(j2 - 31104000, (System.currentTimeMillis() / 1000) + 31968000);
                        int offset = this.g.getOffset((j2 - 1) * 1000);
                        long jS = LocalDate.m0(1800, 1, 1).S() * 86400;
                        while (true) {
                            if (jS > jMin) {
                                break;
                            }
                            int offset2 = this.g.getOffset(jMin * 1000);
                            if (offset != offset2) {
                                int iC2 = c(jMin, i(offset2));
                                b[] bVarArrB3 = b(iC2 + 1);
                                int length3 = bVarArrB3.length - 1;
                                while (true) {
                                    if (length3 < 0) {
                                        b[] bVarArrB4 = b(iC2);
                                        bVar2 = bVarArrB4[bVarArrB4.length - 1];
                                        break;
                                    }
                                    bVar2 = bVarArrB3[length3];
                                    if (j2 > bVar2.a) {
                                        break;
                                    }
                                    length3--;
                                }
                            } else {
                                jMin -= 7776000;
                            }
                        }
                    }
                }
                bVar2 = bVar;
            } else {
                long[] jArr = this.c;
                if (jArr.length != 0) {
                    long j3 = instantOfEpochMilli.a;
                    if (instantOfEpochMilli.b > 0 && j3 < Long.MAX_VALUE) {
                        j3++;
                    }
                    long j4 = jArr[jArr.length - 1];
                    if (this.f.length <= 0 || j3 <= j4) {
                        int iBinarySearch = Arrays.binarySearch(this.c, j3);
                        if (iBinarySearch < 0) {
                            iBinarySearch = (-iBinarySearch) - 1;
                        }
                        if (iBinarySearch > 0) {
                            int i2 = iBinarySearch - 1;
                            long j5 = this.c[i2];
                            ZoneOffset[] zoneOffsetArr = this.e;
                            bVar2 = new b(j5, zoneOffsetArr[i2], zoneOffsetArr[iBinarySearch]);
                        }
                    } else {
                        ZoneOffset[] zoneOffsetArr2 = this.e;
                        ZoneOffset zoneOffset = zoneOffsetArr2[zoneOffsetArr2.length - 1];
                        int iC3 = c(j3, zoneOffset);
                        b[] bVarArrB5 = b(iC3);
                        int length4 = bVarArrB5.length - 1;
                        while (true) {
                            if (length4 < 0) {
                                int i3 = iC3 - 1;
                                if (i3 > c(j4, zoneOffset)) {
                                    b[] bVarArrB6 = b(i3);
                                    bVar2 = bVarArrB6[bVarArrB6.length - 1];
                                }
                            } else {
                                b bVar3 = bVarArrB5[length4];
                                if (j3 > bVar3.a) {
                                    bVar2 = bVar3;
                                    break;
                                }
                                length4--;
                            }
                        }
                    }
                }
            }
            if (bVar2 != null) {
                return false;
            }
        } else if (this.c.length != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f) ^ ((((Objects.hashCode(this.g) ^ Arrays.hashCode(this.a)) ^ Arrays.hashCode(this.b)) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.e));
    }

    public final String toString() {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.b[r3.length - 1] + "]";
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {i(timeZone.getRawOffset())};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = timeZone;
    }
}
