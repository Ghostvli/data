package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.temporal.TemporalAccessor;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter g;
    public static final DateTimeFormatter h;
    public static final DateTimeFormatter i;
    public final d a;
    public final Locale b;
    public final c0 c;
    public final e0 d;
    public final j$.time.chrono.l e;
    public final ZoneId f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        v vVar = new v();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        f0 f0Var = f0.EXCEEDS_PAD;
        vVar.o(aVar, 4, 10, f0Var);
        vVar.d('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        vVar.n(aVar2, 2);
        vVar.d('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        vVar.n(aVar3, 2);
        e0 e0Var = e0.STRICT;
        j$.time.chrono.s sVar = j$.time.chrono.s.c;
        DateTimeFormatter dateTimeFormatterR = vVar.r(e0Var, sVar);
        g = dateTimeFormatterR;
        v vVar2 = new v();
        q qVar = q.INSENSITIVE;
        vVar2.c(qVar);
        vVar2.a(dateTimeFormatterR);
        k kVar = k.e;
        vVar2.c(kVar);
        vVar2.r(e0Var, sVar);
        v vVar3 = new v();
        vVar3.c(qVar);
        vVar3.a(dateTimeFormatterR);
        vVar3.q();
        vVar3.c(kVar);
        vVar3.r(e0Var, sVar);
        v vVar4 = new v();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        vVar4.n(aVar4, 2);
        vVar4.d(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        vVar4.n(aVar5, 2);
        vVar4.q();
        vVar4.d(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        vVar4.n(aVar6, 2);
        vVar4.q();
        vVar4.b(j$.time.temporal.a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatterR2 = vVar4.r(e0Var, null);
        v vVar5 = new v();
        vVar5.c(qVar);
        vVar5.a(dateTimeFormatterR2);
        vVar5.c(kVar);
        vVar5.r(e0Var, null);
        v vVar6 = new v();
        vVar6.c(qVar);
        vVar6.a(dateTimeFormatterR2);
        vVar6.q();
        vVar6.c(kVar);
        vVar6.r(e0Var, null);
        v vVar7 = new v();
        vVar7.c(qVar);
        vVar7.a(dateTimeFormatterR);
        vVar7.d('T');
        vVar7.a(dateTimeFormatterR2);
        DateTimeFormatter dateTimeFormatterR3 = vVar7.r(e0Var, sVar);
        v vVar8 = new v();
        vVar8.c(qVar);
        vVar8.a(dateTimeFormatterR3);
        q qVar2 = q.LENIENT;
        vVar8.c(qVar2);
        vVar8.c(kVar);
        q qVar3 = q.STRICT;
        vVar8.c(qVar3);
        DateTimeFormatter dateTimeFormatterR4 = vVar8.r(e0Var, sVar);
        h = dateTimeFormatterR4;
        v vVar9 = new v();
        vVar9.a(dateTimeFormatterR4);
        vVar9.q();
        vVar9.d('[');
        q qVar4 = q.SENSITIVE;
        vVar9.c(qVar4);
        j$.time.d dVar = v.h;
        vVar9.c(new t(dVar, "ZoneRegionId()"));
        vVar9.d(']');
        vVar9.r(e0Var, sVar);
        v vVar10 = new v();
        vVar10.a(dateTimeFormatterR3);
        vVar10.q();
        vVar10.c(kVar);
        vVar10.q();
        vVar10.d('[');
        vVar10.c(qVar4);
        vVar10.c(new t(dVar, "ZoneRegionId()"));
        vVar10.d(']');
        vVar10.r(e0Var, sVar);
        v vVar11 = new v();
        vVar11.c(qVar);
        vVar11.o(aVar, 4, 10, f0Var);
        vVar11.d('-');
        vVar11.n(j$.time.temporal.a.DAY_OF_YEAR, 3);
        vVar11.q();
        vVar11.c(kVar);
        vVar11.r(e0Var, sVar);
        v vVar12 = new v();
        vVar12.c(qVar);
        vVar12.o(j$.time.temporal.i.c, 4, 10, f0Var);
        vVar12.e("-W");
        vVar12.n(j$.time.temporal.i.b, 2);
        vVar12.d('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        vVar12.n(aVar7, 1);
        vVar12.q();
        vVar12.c(kVar);
        vVar12.r(e0Var, sVar);
        v vVar13 = new v();
        vVar13.c(qVar);
        vVar13.c(new g());
        i = vVar13.r(e0Var, null);
        v vVar14 = new v();
        vVar14.c(qVar);
        vVar14.n(aVar, 4);
        vVar14.n(aVar2, 2);
        vVar14.n(aVar3, 2);
        vVar14.q();
        vVar14.c(qVar2);
        vVar14.h("+HHMMss", "Z");
        vVar14.c(qVar3);
        vVar14.r(e0Var, sVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        v vVar15 = new v();
        vVar15.c(qVar);
        vVar15.c(qVar2);
        vVar15.q();
        vVar15.j(aVar7, map);
        vVar15.e(", ");
        vVar15.p();
        vVar15.o(aVar3, 1, 2, f0.NOT_NEGATIVE);
        vVar15.d(' ');
        vVar15.j(aVar2, map2);
        vVar15.d(' ');
        vVar15.n(aVar, 4);
        vVar15.d(' ');
        vVar15.n(aVar4, 2);
        vVar15.d(':');
        vVar15.n(aVar5, 2);
        vVar15.q();
        vVar15.d(':');
        vVar15.n(aVar6, 2);
        vVar15.p();
        vVar15.d(' ');
        vVar15.h("+HHMM", "GMT");
        vVar15.r(e0.SMART, sVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DateTimeFormatter(d dVar, Locale locale, c0 c0Var, e0 e0Var, j$.time.chrono.l lVar, ZoneId zoneId) {
        Objects.requireNonNull(dVar, "printerParser");
        this.a = dVar;
        Objects.requireNonNull(locale, "locale");
        this.b = locale;
        Objects.requireNonNull(c0Var, "decimalStyle");
        this.c = c0Var;
        Objects.requireNonNull(e0Var, "resolverStyle");
        this.d = e0Var;
        this.e = lVar;
        this.f = zoneId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DateTimeFormatter ofLocalizedDate(FormatStyle formatStyle) {
        Objects.requireNonNull(formatStyle, "dateStyle");
        v vVar = new v();
        vVar.f(formatStyle, null);
        return vVar.r(e0.SMART, j$.time.chrono.s.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle formatStyle) {
        Objects.requireNonNull(formatStyle, "dateTimeStyle");
        v vVar = new v();
        vVar.f(formatStyle, formatStyle);
        return vVar.r(e0.SMART, j$.time.chrono.s.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DateTimeFormatter ofLocalizedTime(FormatStyle formatStyle) {
        Objects.requireNonNull(formatStyle, "timeStyle");
        v vVar = new v();
        vVar.f(null, formatStyle);
        return vVar.r(e0.SMART, j$.time.chrono.s.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DateTimeFormatter ofPattern(String str) {
        v vVar = new v();
        vVar.i(str);
        return vVar.s(Locale.getDefault(), e0.SMART, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object a(CharSequence charSequence, j$.time.d dVar) {
        String string;
        Objects.requireNonNull(charSequence, "text");
        try {
            return b(charSequence).b(dVar);
        } catch (DateTimeParseException e) {
            throw e;
        } catch (RuntimeException e2) {
            if (charSequence.length() > 64) {
                string = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                string = charSequence.toString();
            }
            DateTimeParseException dateTimeParseException = new DateTimeParseException("Text '" + string + "' could not be parsed: " + e2.getMessage(), e2);
            charSequence.toString();
            throw dateTimeParseException;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:127:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d0 b(CharSequence charSequence) {
        long j;
        int i2 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        Objects.requireNonNull(charSequence, "text");
        w wVar = new w(this);
        int iH = this.a.H(wVar, charSequence, parsePosition.getIndex());
        if (iH < 0) {
            parsePosition.setErrorIndex(~iH);
            wVar = null;
        } else {
            parsePosition.setIndex(iH);
        }
        if (wVar == null || parsePosition.getErrorIndex() >= 0 || parsePosition.getIndex() < charSequence.length()) {
            String string = charSequence.length() > 64 ? charSequence.subSequence(0, 64).toString() + "..." : charSequence.toString();
            if (parsePosition.getErrorIndex() >= 0) {
                String str = "Text '" + string + "' could not be parsed at index " + parsePosition.getErrorIndex();
                parsePosition.getErrorIndex();
                throw new DateTimeParseException(str, charSequence);
            }
            String str2 = "Text '" + string + "' could not be parsed, unparsed text found at index " + parsePosition.getIndex();
            parsePosition.getIndex();
            throw new DateTimeParseException(str2, charSequence);
        }
        d0 d0VarC = wVar.c();
        d0VarC.c = wVar.d();
        ZoneId zoneId = d0VarC.b;
        if (zoneId == null) {
            zoneId = wVar.a.f;
        }
        d0VarC.b = zoneId;
        d0VarC.e = this.d;
        d0VarC.q();
        d0VarC.w(d0VarC.c.b0(d0VarC.a, d0VarC.e));
        d0VarC.t();
        if (((HashMap) d0VarC.a).size() > 0) {
            loop0: while (i2 < 50) {
                Iterator it = ((HashMap) d0VarC.a).entrySet().iterator();
                while (it.hasNext()) {
                    j$.time.temporal.p pVar = (j$.time.temporal.p) ((Map.Entry) it.next()).getKey();
                    TemporalAccessor temporalAccessorN = pVar.N(d0VarC.a, d0VarC, d0VarC.e);
                    if (temporalAccessorN == null) {
                        if (!((HashMap) d0VarC.a).containsKey(pVar)) {
                            break;
                        }
                    } else {
                        if (temporalAccessorN instanceof ChronoZonedDateTime) {
                            ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) temporalAccessorN;
                            ZoneId zoneId2 = d0VarC.b;
                            if (zoneId2 == null) {
                                d0VarC.b = chronoZonedDateTime.R();
                            } else if (!zoneId2.equals(chronoZonedDateTime.R())) {
                                throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + d0VarC.b);
                            }
                            temporalAccessorN = chronoZonedDateTime.D();
                        }
                        if (temporalAccessorN instanceof j$.time.chrono.e) {
                            j$.time.chrono.e eVar = (j$.time.chrono.e) temporalAccessorN;
                            d0VarC.u(eVar.j(), j$.time.p.d);
                            d0VarC.w(eVar.n());
                        } else if (temporalAccessorN instanceof j$.time.chrono.b) {
                            d0VarC.w((j$.time.chrono.b) temporalAccessorN);
                        } else {
                            if (!(temporalAccessorN instanceof j$.time.i)) {
                                j$.nio.file.j.h("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                                return null;
                            }
                            d0VarC.u((j$.time.i) temporalAccessorN, j$.time.p.d);
                        }
                    }
                    i2++;
                }
            }
            if (i2 == 50) {
                j$.nio.file.j.h("One of the parsed fields has an incorrectly implemented resolve method");
                return null;
            }
            if (i2 > 0) {
                d0VarC.q();
                d0VarC.w(d0VarC.c.b0(d0VarC.a, d0VarC.e));
                d0VarC.t();
            }
        }
        if (d0VarC.g == null) {
            Map map = d0VarC.a;
            j$.time.temporal.a aVar = j$.time.temporal.a.MILLI_OF_SECOND;
            boolean zContainsKey = ((HashMap) map).containsKey(aVar);
            Map map2 = d0VarC.a;
            if (zContainsKey) {
                long jLongValue = ((Long) ((HashMap) map2).remove(aVar)).longValue();
                Map map3 = d0VarC.a;
                j$.time.temporal.a aVar2 = j$.time.temporal.a.MICRO_OF_SECOND;
                boolean zContainsKey2 = ((HashMap) map3).containsKey(aVar2);
                Map map4 = d0VarC.a;
                if (zContainsKey2) {
                    long jLongValue2 = (((Long) ((HashMap) map4).get(aVar2)).longValue() % 1000) + (jLongValue * 1000);
                    d0VarC.x(aVar, aVar2, Long.valueOf(jLongValue2));
                    ((HashMap) d0VarC.a).remove(aVar2);
                    ((HashMap) d0VarC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue2 * 1000));
                } else {
                    ((HashMap) map4).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue * 1000000));
                }
            } else {
                j$.time.temporal.a aVar3 = j$.time.temporal.a.MICRO_OF_SECOND;
                if (((HashMap) map2).containsKey(aVar3)) {
                    ((HashMap) d0VarC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(((Long) ((HashMap) d0VarC.a).remove(aVar3)).longValue() * 1000));
                }
            }
            Map map5 = d0VarC.a;
            j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
            Long l = (Long) ((HashMap) map5).get(aVar4);
            if (l != null) {
                Map map6 = d0VarC.a;
                j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
                Long l2 = (Long) ((HashMap) map6).get(aVar5);
                Map map7 = d0VarC.a;
                j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
                Long l3 = (Long) ((HashMap) map7).get(aVar6);
                Map map8 = d0VarC.a;
                j$.time.temporal.a aVar7 = j$.time.temporal.a.NANO_OF_SECOND;
                Long l4 = (Long) ((HashMap) map8).get(aVar7);
                if ((l2 != null || (l3 == null && l4 == null)) && (l2 == null || l3 != null || l4 == null)) {
                    j = 1000000;
                    d0VarC.s(l.longValue(), l2 != null ? l2.longValue() : 0L, l3 != null ? l3.longValue() : 0L, l4 != null ? l4.longValue() : 0L);
                    ((HashMap) d0VarC.a).remove(aVar4);
                    ((HashMap) d0VarC.a).remove(aVar5);
                    ((HashMap) d0VarC.a).remove(aVar6);
                    ((HashMap) d0VarC.a).remove(aVar7);
                } else {
                    j = 1000000;
                }
            } else {
                j = 1000000;
            }
            if (d0VarC.e != e0.LENIENT && ((HashMap) d0VarC.a).size() > 0) {
                for (Map.Entry entry : ((HashMap) d0VarC.a).entrySet()) {
                    j$.time.temporal.p pVar2 = (j$.time.temporal.p) entry.getKey();
                    if (pVar2 instanceof j$.time.temporal.a) {
                        j$.time.temporal.a aVar8 = (j$.time.temporal.a) pVar2;
                        if (aVar8.j0()) {
                            aVar8.i0(((Long) entry.getValue()).longValue());
                        }
                    }
                }
            }
        }
        j$.time.chrono.b bVar = d0VarC.f;
        if (bVar != null) {
            d0VarC.p(bVar);
        }
        j$.time.i iVar = d0VarC.g;
        if (iVar != null) {
            d0VarC.p(iVar);
            if (d0VarC.f != null && ((HashMap) d0VarC.a).size() > 0) {
                d0VarC.p(d0VarC.f.T(d0VarC.g));
            }
        }
        if (d0VarC.f != null && d0VarC.g != null) {
            j$.time.p pVar3 = d0VarC.h;
            pVar3.getClass();
            j$.time.p pVar4 = j$.time.p.d;
            if (pVar3 != pVar4) {
                d0VarC.f = d0VarC.f.a0(d0VarC.h);
                d0VarC.h = pVar4;
            }
        }
        if (d0VarC.g == null) {
            if (!((HashMap) d0VarC.a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
                if (!((HashMap) d0VarC.a).containsKey(j$.time.temporal.a.SECOND_OF_DAY)) {
                    if (((HashMap) d0VarC.a).containsKey(j$.time.temporal.a.SECOND_OF_MINUTE)) {
                        Map map9 = d0VarC.a;
                        j$.time.temporal.a aVar9 = j$.time.temporal.a.NANO_OF_SECOND;
                        boolean zContainsKey3 = ((HashMap) map9).containsKey(aVar9);
                        Map map10 = d0VarC.a;
                        if (zContainsKey3) {
                            long jLongValue3 = ((Long) ((HashMap) map10).get(aVar9)).longValue();
                            ((HashMap) d0VarC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue3 / 1000));
                            ((HashMap) d0VarC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue3 / j));
                        } else {
                            ((HashMap) map10).put(aVar9, 0L);
                            ((HashMap) d0VarC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, 0L);
                            ((HashMap) d0VarC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, 0L);
                        }
                    }
                }
            }
        }
        if (d0VarC.f != null && d0VarC.g != null) {
            Long l5 = (Long) ((HashMap) d0VarC.a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l5 != null) {
                ((HashMap) d0VarC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(d0VarC.f.T(d0VarC.g).M(ZoneOffset.l0(l5.intValue())).h0()));
                return d0VarC;
            }
            if (d0VarC.b != null) {
                ((HashMap) d0VarC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(d0VarC.f.T(d0VarC.g).M(d0VarC.b).h0()));
            }
        }
        return d0VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final d c() {
        d dVar = this.a;
        return !dVar.b ? dVar : new d(dVar.a, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        d dVar = this.a;
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            dVar.u(new y(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new DateTimeException(e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DateTimeFormatter withLocale(Locale locale) {
        if (this.b.equals(locale)) {
            return this;
        }
        return new DateTimeFormatter(this.a, locale, this.c, this.d, this.e, this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DateTimeFormatter withZone(ZoneId zoneId) {
        if (Objects.equals(this.f, zoneId)) {
            return this;
        }
        return new DateTimeFormatter(this.a, this.b, this.c, this.d, this.e, zoneId);
    }

    public static DateTimeFormatter ofPattern(String str, Locale locale) {
        v vVar = new v();
        vVar.i(str);
        return vVar.s(locale, e0.SMART, null);
    }
}
