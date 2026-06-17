package j$.time.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements e {
    public static final ConcurrentMap c = new ConcurrentHashMap(16, 0.75f, 2);
    public final FormatStyle a;
    public final FormatStyle b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i(FormatStyle formatStyle, FormatStyle formatStyle2) {
        this.a = formatStyle;
        this.b = formatStyle2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.e
    public final int H(w wVar, CharSequence charSequence, int i) {
        return a(wVar.a.b, wVar.d()).c().H(wVar, charSequence, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final DateTimeFormatter a(Locale locale, j$.time.chrono.l lVar) {
        String strQ = lVar.q();
        String string = locale.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(strQ);
        sb.append("|");
        sb.append(string);
        sb.append("|");
        FormatStyle formatStyle = this.a;
        sb.append(formatStyle);
        FormatStyle formatStyle2 = this.b;
        sb.append(formatStyle2);
        String string2 = sb.toString();
        DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) ((ConcurrentHashMap) c).get(string2);
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        if (formatStyle == null && formatStyle2 == null) {
            j$.nio.file.j.a("Either dateStyle or timeStyle must be non-null");
            return null;
        }
        DateFormat dateInstance = formatStyle2 == null ? DateFormat.getDateInstance(formatStyle.ordinal(), locale) : formatStyle == null ? DateFormat.getTimeInstance(formatStyle2.ordinal(), locale) : DateFormat.getDateTimeInstance(formatStyle.ordinal(), formatStyle2.ordinal(), locale);
        if (!(dateInstance instanceof SimpleDateFormat)) {
            throw new UnsupportedOperationException("Can't determine pattern from " + dateInstance);
        }
        String pattern = ((SimpleDateFormat) dateInstance).toPattern();
        if (pattern == null) {
            pattern = null;
        } else {
            int i = 0;
            boolean z = pattern.indexOf(66) != -1;
            boolean z2 = pattern.indexOf(98) != -1;
            if (z || z2) {
                StringBuilder sb2 = new StringBuilder(pattern.length());
                char c2 = ' ';
                while (i < pattern.length()) {
                    char cCharAt = pattern.charAt(i);
                    if (cCharAt != ' ') {
                        if (cCharAt != 'B' && cCharAt != 'b') {
                            sb2.append(cCharAt);
                        }
                    } else if (i == 0 || (c2 != 'B' && c2 != 'b')) {
                        sb2.append(cCharAt);
                    }
                    i++;
                    c2 = cCharAt;
                }
                int length = sb2.length() - 1;
                if (length >= 0 && sb2.charAt(length) == ' ') {
                    sb2.deleteCharAt(length);
                }
                pattern = sb2.toString();
            }
        }
        v vVar = new v();
        vVar.i(pattern);
        DateTimeFormatter dateTimeFormatterS = vVar.s(locale, e0.SMART, null);
        DateTimeFormatter dateTimeFormatter2 = (DateTimeFormatter) ((ConcurrentHashMap) c).putIfAbsent(string2, dateTimeFormatterS);
        return dateTimeFormatter2 != null ? dateTimeFormatter2 : dateTimeFormatterS;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        Object obj = this.a;
        if (obj == null) {
            obj = "";
        }
        FormatStyle formatStyle = this.b;
        return "Localized(" + obj + "," + (formatStyle != null ? formatStyle : "") + ")";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.e
    public final boolean u(y yVar, StringBuilder sb) {
        a(yVar.b.b, j$.time.chrono.l.s(yVar.a)).c().u(yVar, sb);
        return true;
    }
}
