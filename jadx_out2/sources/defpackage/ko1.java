package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ko1 extends LinkedHashMap {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fo1 a() {
        return new fo1(new ko1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public eo1 b(String str) {
        return c(str, new eo1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public eo1 c(String str, eo1 eo1Var) {
        V v = get(str);
        return v instanceof eo1 ? (eo1) v : eo1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d(String str) {
        return e(str, Boolean.FALSE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean e(String str, Boolean bool) {
        V v = get(str);
        return v instanceof Boolean ? ((Boolean) v).booleanValue() : bool.booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public double f(String str) {
        return g(str, 0.0d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public double g(String str, double d) {
        V v = get(str);
        return v instanceof Number ? ((Number) v).doubleValue() : d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h(String str) {
        return i(str, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public int i(String str, int i) {
        V v = get(str);
        return v instanceof Number ? ((Number) v).intValue() : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long j(String str) {
        return k(str, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public long k(String str, long j) {
        V v = get(str);
        return v instanceof Number ? ((Number) v).longValue() : j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ko1 m(String str) {
        return n(str, new ko1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public ko1 n(String str, ko1 ko1Var) {
        V v = get(str);
        return v instanceof ko1 ? (ko1) v : ko1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String o(String str) {
        return p(str, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    public String p(String str, String str2) {
        V v = get(str);
        return v instanceof String ? (String) v : str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q(String str) {
        return super.containsKey(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r(String str) {
        return super.containsKey(str) && get(str) == 0;
    }
}
