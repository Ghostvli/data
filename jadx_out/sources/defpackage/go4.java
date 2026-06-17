package defpackage;

import j$.time.LocalDateTime;
import j$.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class go4 {
    public final t93 a;
    public final LocalDateTime b;

    public go4(t93 t93Var, LocalDateTime localDateTime) {
        this.a = t93Var;
        this.b = localDateTime;
    }

    public static /* synthetic */ s83 a(String str) {
        return new s83("Unable to parse the date: " + str);
    }

    public static /* synthetic */ boolean b(final go4 go4Var, final String str, Map.Entry entry) {
        go4Var.getClass();
        return ((Collection) entry.getValue()).stream().anyMatch(new Predicate() { // from class: fo4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.h(str, (String) obj);
            }
        });
    }

    public final qa0 d(int i, ChronoUnit chronoUnit) {
        ChronoUnit chronoUnit2 = ChronoUnit.YEARS;
        LocalDateTime localDateTime = this.b;
        LocalDateTime localDateTimeMinusDays = chronoUnit == chronoUnit2 ? localDateTime.minusYears(i).minusDays(1L) : localDateTime.a(i, chronoUnit);
        boolean zIsDateBased = chronoUnit.isDateBased();
        if (zIsDateBased) {
            localDateTimeMinusDays = localDateTimeMinusDays.truncatedTo(ChronoUnit.DAYS);
        }
        return new qa0(localDateTimeMinusDays, zIsDateBased);
    }

    public qa0 e(String str) {
        for (Map.Entry<ChronoUnit, Map<String, Integer>> entry : this.a.specialCases().entrySet()) {
            ChronoUnit key = entry.getKey();
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                int iIntValue = entry2.getValue().intValue();
                if (h(str, key2)) {
                    return d(iIntValue, key);
                }
            }
        }
        return d(g(str), f(str));
    }

    public final ChronoUnit f(final String str) {
        return (ChronoUnit) this.a.asMap().entrySet().stream().filter(new Predicate() { // from class: co4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return go4.b(this.a, str, (Map.Entry) obj);
            }
        }).map(new Function() { // from class: do4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (ChronoUnit) ((Map.Entry) obj).getKey();
            }
        }).findFirst().orElseThrow(new Supplier() { // from class: eo4
            @Override // java.util.function.Supplier
            public final Object get() {
                return go4.a(str);
            }
        });
    }

    public final int g(String str) {
        try {
            return Integer.parseInt(str.replaceAll("\\D+", ""));
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    public final boolean h(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (this.a.wordSeparator().isEmpty()) {
            return str.toLowerCase().contains(str2.toLowerCase());
        }
        String strQuote = Pattern.quote(str2.toLowerCase());
        String strQuote2 = this.a.wordSeparator().equals(" ") ? "[ \\t\\xA0\\u1680\\u180e\\u2000-\\u200a\\u202f\\u205f\\u3000\\d]" : Pattern.quote(this.a.wordSeparator());
        return p83.g("(^|" + strQuote2 + ")" + strQuote + "($|" + strQuote2 + ")", str.toLowerCase());
    }
}
