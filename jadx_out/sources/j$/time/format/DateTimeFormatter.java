package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
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

    public static DateTimeFormatter ofLocalizedDate(FormatStyle formatStyle) {
        Objects.requireNonNull(formatStyle, "dateStyle");
        v vVar = new v();
        vVar.f(formatStyle, null);
        return vVar.r(e0.SMART, j$.time.chrono.s.c);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle formatStyle) {
        Objects.requireNonNull(formatStyle, "dateTimeStyle");
        v vVar = new v();
        vVar.f(formatStyle, formatStyle);
        return vVar.r(e0.SMART, j$.time.chrono.s.c);
    }

    public static DateTimeFormatter ofLocalizedTime(FormatStyle formatStyle) {
        Objects.requireNonNull(formatStyle, "timeStyle");
        v vVar = new v();
        vVar.f(null, formatStyle);
        return vVar.r(e0.SMART, j$.time.chrono.s.c);
    }

    public static DateTimeFormatter ofPattern(String str) {
        v vVar = new v();
        vVar.i(str);
        return vVar.s(Locale.getDefault(), e0.SMART, null);
    }

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

    /* JADX WARN: Removed duplicated region for block: B:127:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.format.d0 b(java.lang.CharSequence r24) {
        /*
            Method dump skipped, instruction units count: 1071
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.b(java.lang.CharSequence):j$.time.format.d0");
    }

    public final d c() {
        d dVar = this.a;
        return !dVar.b ? dVar : new d(dVar.a, false);
    }

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

    public final String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }

    public DateTimeFormatter withLocale(Locale locale) {
        if (this.b.equals(locale)) {
            return this;
        }
        return new DateTimeFormatter(this.a, locale, this.c, this.d, this.e, this.f);
    }

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
