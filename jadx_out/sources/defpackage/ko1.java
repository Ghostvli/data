package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ko1 extends LinkedHashMap {
    public static fo1 a() {
        return new fo1(new ko1());
    }

    public eo1 b(String str) {
        return c(str, new eo1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public eo1 c(String str, eo1 eo1Var) {
        V v = get(str);
        return v instanceof eo1 ? (eo1) v : eo1Var;
    }

    public boolean d(String str) {
        return e(str, Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean e(String str, Boolean bool) {
        V v = get(str);
        return v instanceof Boolean ? ((Boolean) v).booleanValue() : bool.booleanValue();
    }

    public double f(String str) {
        return g(str, 0.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public double g(String str, double d) {
        V v = get(str);
        return v instanceof Number ? ((Number) v).doubleValue() : d;
    }

    public int h(String str) {
        return i(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int i(String str, int i) {
        V v = get(str);
        return v instanceof Number ? ((Number) v).intValue() : i;
    }

    public long j(String str) {
        return k(str, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long k(String str, long j) {
        V v = get(str);
        return v instanceof Number ? ((Number) v).longValue() : j;
    }

    public ko1 m(String str) {
        return n(str, new ko1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ko1 n(String str, ko1 ko1Var) {
        V v = get(str);
        return v instanceof ko1 ? (ko1) v : ko1Var;
    }

    public String o(String str) {
        return p(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String p(String str, String str2) {
        V v = get(str);
        return v instanceof String ? (String) v : str2;
    }

    public boolean q(String str) {
        return super.containsKey(str);
    }

    public boolean r(String str) {
        return super.containsKey(str) && get(str) == 0;
    }
}
