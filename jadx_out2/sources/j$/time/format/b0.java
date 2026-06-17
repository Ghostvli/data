package j$.time.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    public static final ConcurrentMap a = new ConcurrentHashMap(16, 0.75f, 2);
    public static final z b = new z();
    public static final b0 c = new b0();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object a(j$.time.temporal.p pVar, Locale locale) {
        Object a0Var;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(pVar, locale);
        Object obj = ((ConcurrentHashMap) a).get(simpleImmutableEntry);
        if (obj != null) {
            return obj;
        }
        HashMap map = new HashMap();
        if (pVar == j$.time.temporal.a.ERA) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            String[] eras = dateFormatSymbols.getEras();
            for (int i = 0; i < eras.length; i++) {
                if (!eras[i].isEmpty()) {
                    long j = i;
                    map2.put(Long.valueOf(j), eras[i]);
                    Long lValueOf = Long.valueOf(j);
                    String str = eras[i];
                    map3.put(lValueOf, str.substring(0, Character.charCount(str.codePointAt(0))));
                }
            }
            if (!map2.isEmpty()) {
                map.put(g0.FULL, map2);
                map.put(g0.SHORT, map2);
                map.put(g0.NARROW, map3);
            }
            a0Var = new a0(map);
        } else if (pVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            int length = DateFormatSymbols.getInstance(locale).getMonths().length;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (long j2 = 1; j2 <= length; j2++) {
                String strB = j$.desugar.sun.nio.fs.g.b(j2, "LLLL", locale);
                linkedHashMap.put(Long.valueOf(j2), strB);
                linkedHashMap2.put(Long.valueOf(j2), strB.substring(0, Character.charCount(strB.codePointAt(0))));
                linkedHashMap3.put(Long.valueOf(j2), j$.desugar.sun.nio.fs.g.b(j2, "LLL", locale));
            }
            if (length > 0) {
                map.put(g0.FULL_STANDALONE, linkedHashMap);
                map.put(g0.NARROW_STANDALONE, linkedHashMap2);
                map.put(g0.SHORT_STANDALONE, linkedHashMap3);
                map.put(g0.FULL, linkedHashMap);
                map.put(g0.NARROW, linkedHashMap2);
                map.put(g0.SHORT, linkedHashMap3);
            }
            a0Var = new a0(map);
        } else if (pVar == j$.time.temporal.a.DAY_OF_WEEK) {
            int length2 = DateFormatSymbols.getInstance(locale).getWeekdays().length;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            boolean z = locale == Locale.SIMPLIFIED_CHINESE || locale == Locale.TRADITIONAL_CHINESE;
            for (long j3 = 1; j3 <= length2; j3++) {
                String strA = j$.desugar.sun.nio.fs.g.a(j3, "cccc", locale);
                linkedHashMap4.put(Long.valueOf(j3), strA);
                linkedHashMap5.put(Long.valueOf(j3), z ? new StringBuilder().appendCodePoint(strA.codePointBefore(strA.length())).toString() : strA.substring(0, Character.charCount(strA.codePointAt(0))));
                linkedHashMap6.put(Long.valueOf(j3), j$.desugar.sun.nio.fs.g.a(j3, "ccc", locale));
            }
            if (length2 > 0) {
                map.put(g0.FULL_STANDALONE, linkedHashMap4);
                map.put(g0.NARROW_STANDALONE, linkedHashMap5);
                map.put(g0.SHORT_STANDALONE, linkedHashMap6);
                map.put(g0.FULL, linkedHashMap4);
                map.put(g0.NARROW, linkedHashMap5);
                map.put(g0.SHORT, linkedHashMap6);
            }
            a0Var = new a0(map);
        } else if (pVar == j$.time.temporal.a.AMPM_OF_DAY) {
            DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            String[] amPmStrings = dateFormatSymbols2.getAmPmStrings();
            for (int i2 = 0; i2 < amPmStrings.length; i2++) {
                if (!amPmStrings[i2].isEmpty()) {
                    long j4 = i2;
                    map4.put(Long.valueOf(j4), amPmStrings[i2]);
                    Long lValueOf2 = Long.valueOf(j4);
                    String str2 = amPmStrings[i2];
                    map5.put(lValueOf2, str2.substring(0, Character.charCount(str2.codePointAt(0))));
                }
            }
            if (!map4.isEmpty()) {
                map.put(g0.FULL, map4);
                map.put(g0.SHORT, map4);
                map.put(g0.NARROW, map5);
            }
            a0Var = new a0(map);
        } else {
            a0Var = "";
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) a;
        concurrentHashMap.putIfAbsent(simpleImmutableEntry, a0Var);
        return concurrentHashMap.get(simpleImmutableEntry);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String b(j$.time.chrono.l lVar, j$.time.temporal.p pVar, long j, g0 g0Var, Locale locale) {
        if (lVar == j$.time.chrono.s.c || !(pVar instanceof j$.time.temporal.a)) {
            return c(pVar, j, g0Var, locale);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String c(j$.time.temporal.p pVar, long j, g0 g0Var, Locale locale) {
        Object objA = a(pVar, locale);
        if (objA instanceof a0) {
            return ((a0) objA).a(j, g0Var);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Iterator d(j$.time.chrono.l lVar, j$.time.temporal.p pVar, g0 g0Var, Locale locale) {
        if (lVar == j$.time.chrono.s.c || !(pVar instanceof j$.time.temporal.a)) {
            return e(pVar, g0Var, locale);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Iterator e(j$.time.temporal.p pVar, g0 g0Var, Locale locale) {
        List list;
        Object objA = a(pVar, locale);
        if (!(objA instanceof a0) || (list = (List) ((HashMap) ((a0) objA).b).get(g0Var)) == null) {
            return null;
        }
        return list.iterator();
    }
}
