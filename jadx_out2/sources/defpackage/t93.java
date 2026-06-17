package defpackage;

import j$.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t93 {
    private final Collection<String> days;
    private final Collection<String> hours;
    private final Collection<String> minutes;
    private final Collection<String> months;
    private final Collection<String> seconds;
    private final Map<ChronoUnit, Map<String, Integer>> specialCases;
    private final Collection<String> weeks;
    private final String wordSeparator;
    private final Collection<String> years;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t93(String str, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(str, Arrays.asList(strArr), Arrays.asList(strArr2), Arrays.asList(strArr3), Arrays.asList(strArr4), Arrays.asList(strArr5), Arrays.asList(strArr6), Arrays.asList(strArr7));
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.util.LinkedHashMap.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Map a(ChronoUnit chronoUnit) {
        return new LinkedHashMap();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<ChronoUnit, Collection<String>> asMap() {
        EnumMap enumMap = new EnumMap(ChronoUnit.class);
        enumMap.put(ChronoUnit.SECONDS, seconds());
        enumMap.put(ChronoUnit.MINUTES, minutes());
        enumMap.put(ChronoUnit.HOURS, hours());
        enumMap.put(ChronoUnit.DAYS, days());
        enumMap.put(ChronoUnit.WEEKS, weeks());
        enumMap.put(ChronoUnit.MONTHS, months());
        enumMap.put(ChronoUnit.YEARS, years());
        return enumMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> days() {
        return this.days;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> hours() {
        return this.hours;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> minutes() {
        return this.minutes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> months() {
        return this.months;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void putSpecialCase(ChronoUnit chronoUnit, String str, int i) {
        this.specialCases.computeIfAbsent(chronoUnit, new Function() { // from class: s93
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return t93.a((ChronoUnit) obj);
            }
        }).put(str, Integer.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> seconds() {
        return this.seconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<ChronoUnit, Map<String, Integer>> specialCases() {
        return this.specialCases;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> weeks() {
        return this.weeks;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String wordSeparator() {
        return this.wordSeparator;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<String> years() {
        return this.years;
    }

    public t93(String str, Collection collection, Collection collection2, Collection collection3, Collection collection4, Collection collection5, Collection collection6, Collection collection7) {
        this.specialCases = new EnumMap(ChronoUnit.class);
        this.wordSeparator = str;
        this.seconds = collection;
        this.minutes = collection2;
        this.hours = collection3;
        this.days = collection4;
        this.weeks = collection5;
        this.months = collection6;
        this.years = collection7;
    }
}
