package j$.time.format;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import java.lang.ref.SoftReference;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends t {
    public static final Map i = new ConcurrentHashMap();
    public final g0 e;
    public final boolean f;
    public final Map g;
    public final Map h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u(g0 g0Var, boolean z) {
        super(j$.time.temporal.q.e, "ZoneText(" + g0Var + ")");
        this.g = new HashMap();
        this.h = new HashMap();
        Objects.requireNonNull(g0Var, "textStyle");
        this.e = g0Var;
        this.f = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.t
    public final n a(w wVar) {
        n nVar;
        if (this.e == g0.NARROW) {
            return super.a(wVar);
        }
        Locale locale = wVar.a.b;
        boolean z = wVar.b;
        Set set = j$.time.zone.i.d;
        int size = set.size();
        Map map = z ? this.g : this.h;
        Map.Entry entry = (Map.Entry) map.get(locale);
        if (entry != null && ((Integer) entry.getKey()).intValue() == size && (nVar = (n) ((SoftReference) entry.getValue()).get()) != null) {
            return nVar;
        }
        n nVar2 = wVar.b ? new n("", null, null) : new m("", null, null);
        for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
            String str = strArr[0];
            if (set.contains(str)) {
                nVar2.a(str, str);
                HashMap map2 = (HashMap) h0.d;
                String str2 = (String) map2.get(str);
                if (str2 == null) {
                    HashMap map3 = (HashMap) h0.g;
                    if (map3.containsKey(str)) {
                        str = (String) map3.get(str);
                        str2 = (String) map2.get(str);
                    }
                }
                if (str2 != null) {
                    Map map4 = (Map) ((HashMap) h0.f).get(str2);
                    str = (map4 == null || !map4.containsKey(locale.getCountry())) ? (String) ((HashMap) h0.e).get(str2) : (String) map4.get(locale.getCountry());
                }
                HashMap map5 = (HashMap) h0.g;
                if (map5.containsKey(str)) {
                    str = (String) map5.get(str);
                }
                for (int i2 = this.e == g0.FULL ? 1 : 2; i2 < strArr.length; i2 += 2) {
                    nVar2.a(strArr[i2], str);
                }
            }
        }
        map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(nVar2)));
        return nVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5  */
    @Override // j$.time.format.t, j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(y yVar, StringBuilder sb) {
        boolean zG;
        g0 g0Var;
        g0 g0Var2;
        String[] strArr;
        ZoneId zoneId = (ZoneId) yVar.b(j$.time.temporal.q.a);
        if (zoneId == null) {
            return false;
        }
        String strQ = zoneId.q();
        if (!(zoneId instanceof ZoneOffset)) {
            TemporalAccessor temporalAccessor = yVar.a;
            String str = null;
            Map concurrentHashMap = null;
            if (this.f) {
                zG = 2;
                Locale locale = yVar.b.b;
                g0Var = g0.NARROW;
                g0Var2 = this.e;
                if (g0Var2 != g0Var) {
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) i;
                    SoftReference softReference = (SoftReference) concurrentHashMap2.get(strQ);
                    if (softReference == null || (concurrentHashMap = (Map) softReference.get()) == null || (strArr = (String[]) concurrentHashMap.get(locale)) == null) {
                        TimeZone timeZone = TimeZone.getTimeZone(strQ);
                        String[] strArr2 = {strQ, timeZone.getDisplayName(false, 1, locale), timeZone.getDisplayName(false, 0, locale), timeZone.getDisplayName(true, 1, locale), timeZone.getDisplayName(true, 0, locale), strQ, strQ};
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        concurrentHashMap.put(locale, strArr2);
                        concurrentHashMap2.put(strQ, new SoftReference(concurrentHashMap));
                        strArr = strArr2;
                    }
                    str = zG != 0 ? zG != 1 ? strArr[g0Var2.a + 5] : strArr[g0Var2.a + 3] : strArr[g0Var2.a + 1];
                }
                if (str != null) {
                    strQ = str;
                }
            } else {
                if (temporalAccessor.h(j$.time.temporal.a.INSTANT_SECONDS)) {
                    zG = zoneId.H().g(Instant.H(temporalAccessor));
                } else {
                    j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
                    if (temporalAccessor.h(aVar)) {
                        j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_DAY;
                        if (temporalAccessor.h(aVar2)) {
                            LocalDateTime localDateTimeQ = LocalDateTime.Q(LocalDate.n0(temporalAccessor.i(aVar)), j$.time.i.f0(temporalAccessor.i(aVar2)));
                            Object objE = zoneId.H().e(localDateTimeQ);
                            if ((objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null) == null) {
                                zG = zoneId.H().g(localDateTimeQ.M(zoneId).toInstant());
                            }
                        }
                    }
                }
                Locale locale2 = yVar.b.b;
                g0Var = g0.NARROW;
                g0Var2 = this.e;
                if (g0Var2 != g0Var) {
                }
                if (str != null) {
                }
            }
        }
        sb.append(strQ);
        return true;
    }
}
