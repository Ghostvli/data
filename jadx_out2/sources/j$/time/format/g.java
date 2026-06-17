package j$.time.format;

import com.hierynomus.msdtyp.FileTime;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements e {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.e
    public final int H(w wVar, CharSequence charSequence, int i) {
        v vVar = new v();
        vVar.a(DateTimeFormatter.g);
        vVar.d('T');
        j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
        vVar.n(aVar, 2);
        vVar.d(':');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
        vVar.n(aVar2, 2);
        vVar.d(':');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
        vVar.n(aVar3, 2);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
        int i2 = 1;
        vVar.b(aVar4, 0, 9, true);
        vVar.d('Z');
        d dVarC = vVar.s(Locale.getDefault(), e0.SMART, null).c();
        w wVar2 = new w(wVar.a);
        wVar2.b = wVar.b;
        wVar2.c = wVar.c;
        int iH = dVarC.H(wVar2, charSequence, i);
        if (iH < 0) {
            return iH;
        }
        long jLongValue = wVar2.e(j$.time.temporal.a.YEAR).longValue();
        int iIntValue = wVar2.e(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
        int iIntValue2 = wVar2.e(j$.time.temporal.a.DAY_OF_MONTH).intValue();
        int iIntValue3 = wVar2.e(aVar).intValue();
        int iIntValue4 = wVar2.e(aVar2).intValue();
        Long lE = wVar2.e(aVar3);
        Long lE2 = wVar2.e(aVar4);
        int iIntValue5 = lE != null ? lE.intValue() : 0;
        int iIntValue6 = lE2 != null ? lE2.intValue() : 0;
        if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
            iIntValue3 = 0;
        } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
            wVar.c().d = true;
            i2 = 0;
            iIntValue5 = 59;
        } else {
            i2 = 0;
        }
        int i3 = ((int) jLongValue) % FileTime.NANO100_TO_MILLI;
        try {
            LocalDateTime localDateTime = LocalDateTime.c;
            return wVar.g(aVar4, iIntValue6, i, wVar.g(j$.time.temporal.a.INSTANT_SECONDS, new LocalDateTime(LocalDate.m0(i3, iIntValue, iIntValue2), j$.time.i.Y(iIntValue3, iIntValue4, iIntValue5, 0)).i0(i2).B(ZoneOffset.UTC) + Math.multiplyExact(jLongValue / 10000, 315569520000L), i, iH));
        } catch (RuntimeException unused) {
            return ~i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        return "Instant()";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.e
    public final boolean u(y yVar, StringBuilder sb) {
        Long lA = yVar.a(j$.time.temporal.a.INSTANT_SECONDS);
        TemporalAccessor temporalAccessor = yVar.a;
        j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
        Long lValueOf = temporalAccessor.h(aVar) ? Long.valueOf(temporalAccessor.i(aVar)) : null;
        int i = 0;
        if (lA == null) {
            return false;
        }
        long jLongValue = lA.longValue();
        int iA = aVar.b.a(lValueOf != null ? lValueOf.longValue() : 0L, aVar);
        if (jLongValue >= -62167219200L) {
            long j = jLongValue - 253402300800L;
            long jFloorDiv = Math.floorDiv(j, 315569520000L) + 1;
            LocalDateTime localDateTimeY = LocalDateTime.Y(Math.floorMod(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (jFloorDiv > 0) {
                sb.append('+');
                sb.append(jFloorDiv);
            }
            sb.append(localDateTimeY);
            if (localDateTimeY.b.c == 0) {
                sb.append(":00");
            }
        } else {
            long j2 = jLongValue + 62167219200L;
            long j3 = j2 / 315569520000L;
            long j4 = j2 % 315569520000L;
            LocalDateTime localDateTimeY2 = LocalDateTime.Y(j4 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(localDateTimeY2);
            if (localDateTimeY2.b.c == 0) {
                sb.append(":00");
            }
            if (j3 < 0) {
                if (localDateTimeY2.a.a == -10000) {
                    sb.replace(length, length + 2, Long.toString(j3 - 1));
                } else if (j4 == 0) {
                    sb.insert(length, j3);
                } else {
                    sb.insert(length + 1, Math.abs(j3));
                }
            }
        }
        if (iA > 0) {
            sb.append('.');
            int i2 = 100000000;
            while (true) {
                if (iA <= 0 && i % 3 == 0 && i >= -2) {
                    break;
                }
                int i3 = iA / i2;
                sb.append((char) (i3 + 48));
                iA -= i3 * i2;
                i2 /= 10;
                i++;
            }
        }
        sb.append('Z');
        return true;
    }
}
