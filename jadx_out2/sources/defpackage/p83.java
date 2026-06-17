package defpackage;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p83 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends s83 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str) {
            super(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String a(String str, String str2) {
        return str2;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:int:0x0000: ARRAY_LENGTH (r1v0 java.lang.String[]) A[WRAPPED] (LINE:1)) > (1 int)) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean b(String[] strArr) {
        return strArr.length > 1;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0001: AGET (r1v0 java.lang.String[]), (0 ??[int, short, byte, char]) (LINE:2) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String d(String[] strArr) {
        return strArr[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map f(String str) {
        return (Map) Arrays.stream(str.split("&")).map(new Function() { // from class: h83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).split("=");
            }
        }).filter(new Predicate() { // from class: i83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return p83.b((String[]) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: j83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return p83.d((String[]) obj);
            }
        }, new Function() { // from class: k83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return yy4.e(((String[]) obj)[1]);
            }
        }, new BinaryOperator() { // from class: l83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return p83.a((String) obj, (String) obj2);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean g(String str, String str2) {
        return h(Pattern.compile(str), str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h(Pattern pattern, String str) {
        return pattern.matcher(str).find();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String i(String str, String str2, int i) {
        return j(Pattern.compile(str), str2, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(Pattern pattern, String str, int i) {
        return n(pattern, str).group(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String k(String str, String str2) {
        return i(str, str2, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String l(Pattern pattern, String str) {
        return j(pattern, str, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Matcher m(Pattern[] patternArr, String str) throws a {
        a aVar = null;
        for (Pattern pattern : patternArr) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher;
            }
            if (aVar == null) {
                aVar = new a("Failed to find pattern \"" + pattern.pattern() + "\"" + (str.length() <= 1000 ? "inside of \"" + str + "\"" : ""));
            }
        }
        if (aVar != null) {
            throw aVar;
        }
        throw new a("Empty patterns array passed to matchMultiplePatterns");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Matcher n(Pattern pattern, String str) throws a {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher;
        }
        String str2 = "Failed to find pattern \"" + pattern.pattern() + "\"";
        if (str.length() <= 1024) {
            str2 = str2 + " inside of \"" + str + "\"";
        }
        throw new a(str2);
    }
}
