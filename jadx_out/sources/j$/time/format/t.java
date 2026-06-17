package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public class t implements e {
    public static volatile Map.Entry c;
    public static volatile Map.Entry d;
    public final j$.time.d a;
    public final String b;

    public t(j$.time.d dVar, String str) {
        this.a = dVar;
        this.b = str;
    }

    public static int b(w wVar, CharSequence charSequence, int i, int i2, k kVar) {
        String upperCase = charSequence.subSequence(i, i2).toString().toUpperCase();
        if (i2 >= charSequence.length()) {
            wVar.f(ZoneId.of(upperCase));
            return i2;
        }
        if (charSequence.charAt(i2) == '0' || wVar.a(charSequence.charAt(i2), 'Z')) {
            wVar.f(ZoneId.of(upperCase));
            return i2;
        }
        w wVar2 = new w(wVar.a);
        wVar2.b = wVar.b;
        wVar2.c = wVar.c;
        int iH = kVar.H(wVar2, charSequence, i2);
        try {
            if (iH >= 0) {
                wVar.f(ZoneId.Q(upperCase, ZoneOffset.l0((int) wVar2.e(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return iH;
            }
            if (kVar == k.e) {
                return ~i;
            }
            wVar.f(ZoneId.of(upperCase));
            return i2;
        } catch (DateTimeException unused) {
            return ~i;
        }
    }

    @Override // j$.time.format.e
    public final int H(w wVar, CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        if (i > length) {
            throw new IndexOutOfBoundsException();
        }
        if (i == length) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == '+' || cCharAt == '-') {
            return b(wVar, charSequence, i, i, k.e);
        }
        int i3 = i + 2;
        if (length >= i3) {
            char cCharAt2 = charSequence.charAt(i + 1);
            if (wVar.a(cCharAt, 'U') && wVar.a(cCharAt2, 'T')) {
                int i4 = i + 3;
                return (length < i4 || !wVar.a(charSequence.charAt(i3), 'C')) ? b(wVar, charSequence, i, i3, k.f) : b(wVar, charSequence, i, i4, k.f);
            }
            if (wVar.a(cCharAt, 'G') && length >= (i2 = i + 3) && wVar.a(cCharAt2, 'M') && wVar.a(charSequence.charAt(i3), 'T')) {
                int i5 = i + 4;
                if (length < i5 || !wVar.a(charSequence.charAt(i2), '0')) {
                    return b(wVar, charSequence, i, i2, k.f);
                }
                wVar.f(ZoneId.of("GMT0"));
                return i5;
            }
        }
        n nVarA = a(wVar);
        ParsePosition parsePosition = new ParsePosition(i);
        String strC = nVarA.c(charSequence, parsePosition);
        if (strC != null) {
            wVar.f(ZoneId.of(strC));
            return parsePosition.getIndex();
        }
        if (!wVar.a(cCharAt, 'Z')) {
            return ~i;
        }
        wVar.f(ZoneOffset.UTC);
        return i + 1;
    }

    public n a(w wVar) {
        Set<String> set = j$.time.zone.i.d;
        int size = set.size();
        Map.Entry simpleImmutableEntry = wVar.b ? c : d;
        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
            synchronized (this) {
                try {
                    simpleImmutableEntry = wVar.b ? c : d;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        Integer numValueOf = Integer.valueOf(size);
                        n nVar = wVar.b ? new n("", null, null) : new m("", null, null);
                        for (String str : set) {
                            nVar.a(str, str);
                        }
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(numValueOf, nVar);
                        if (wVar.b) {
                            c = simpleImmutableEntry;
                        } else {
                            d = simpleImmutableEntry;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (n) simpleImmutableEntry.getValue();
    }

    public final String toString() {
        return this.b;
    }

    @Override // j$.time.format.e
    public boolean u(y yVar, StringBuilder sb) {
        ZoneId zoneId = (ZoneId) yVar.b(this.a);
        if (zoneId == null) {
            return false;
        }
        sb.append(zoneId.q());
        return true;
    }
}
