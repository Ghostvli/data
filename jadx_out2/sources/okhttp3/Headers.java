package okhttp3;

import defpackage.i73;
import defpackage.op1;
import defpackage.sg4;
import defpackage.we0;
import defpackage.wg4;
import defpackage.yf4;
import defpackage.zt;
import j$.time.Instant;
import j$.util.DateRetargetClass;
import j$.util.DesugarDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal.http.DateFormattingKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Headers implements Iterable<i73>, op1 {
    public static final Companion Companion = new Companion(null);
    public static final Headers EMPTY = new Headers(new String[0]);
    private final String[] namesAndValues;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Headers(String[] strArr) {
        strArr.getClass();
        this.namesAndValues = strArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m61deprecated_size() {
        return size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i = 0; i < length2; i++) {
            length += (long) this.namesAndValues[i].length();
        }
        return length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return _HeadersCommonKt.commonEquals(this, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String get(String str) {
        str.getClass();
        return _HeadersCommonKt.commonHeadersGet(this.namesAndValues, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Date getDate(String str) {
        str.getClass();
        String str2 = get(str);
        if (str2 != null) {
            return DateFormattingKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        str.getClass();
        Date date = getDate(str);
        if (date != null) {
            return DateRetargetClass.toInstant(date);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String[] getNamesAndValues$okhttp() {
        return this.namesAndValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return _HeadersCommonKt.commonHashCode(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator<i73> iterator() {
        return _HeadersCommonKt.commonIterator(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String name(int i) {
        return _HeadersCommonKt.commonName(this, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(sg4.z(yf4.a));
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        setUnmodifiableSet.getClass();
        return setUnmodifiableSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Builder newBuilder() {
        return _HeadersCommonKt.commonNewBuilder(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(sg4.z(yf4.a));
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strName.toLowerCase(locale);
            lowerCase.getClass();
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i));
        }
        return treeMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return _HeadersCommonKt.commonToString(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String value(int i) {
        return _HeadersCommonKt.commonValue(this, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List<String> values(String str) {
        str.getClass();
        return _HeadersCommonKt.commonValues(this, str);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.Headers.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m63deprecated_of(String... strArr) {
            strArr.getClass();
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Headers of(String... strArr) {
            strArr.getClass();
            return _HeadersCommonKt.commonHeadersOf((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m62deprecated_of(Map<String, String> map) {
            map.getClass();
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            map.getClass();
            return _HeadersCommonKt.commonToHeaders(map);
        }
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder add(String str) {
            str.getClass();
            int iZ = wg4.Z(str, ':', 0, false, 6, null);
            if (iZ != -1) {
                add(wg4.O0(str.substring(0, iZ)).toString(), str.substring(iZ + 1));
                return this;
            }
            zt.a("Unexpected header: ", str);
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addAll(Headers headers) {
            headers.getClass();
            return _HeadersCommonKt.commonAddAll(this, headers);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addLenient$okhttp(String str) {
            str.getClass();
            int iZ = wg4.Z(str, ':', 1, false, 4, null);
            if (iZ != -1) {
                addLenient$okhttp(str.substring(0, iZ), str.substring(iZ + 1));
                return this;
            }
            if (str.charAt(0) == ':') {
                addLenient$okhttp("", str.substring(1));
                return this;
            }
            addLenient$okhttp("", str);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addUnsafeNonAscii(String str, String str2) {
            str.getClass();
            str2.getClass();
            _HeadersCommonKt.headersCheckName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Headers build() {
            return _HeadersCommonKt.commonBuild(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String get(String str) {
            str.getClass();
            return _HeadersCommonKt.commonGet(this, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder removeAll(String str) {
            str.getClass();
            return _HeadersCommonKt.commonRemoveAll(this, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            str.getClass();
            instant.getClass();
            Date dateFrom = DesugarDate.from(instant);
            dateFrom.getClass();
            return set(str, dateFrom);
        }

        public final Builder set(String str, Date date) {
            str.getClass();
            date.getClass();
            return set(str, DateFormattingKt.toHttpDateString(date));
        }

        public final Builder set(String str, String str2) {
            str.getClass();
            str2.getClass();
            return _HeadersCommonKt.commonSet(this, str, str2);
        }

        public final Builder add(String str, String str2) {
            str.getClass();
            str2.getClass();
            return _HeadersCommonKt.commonAdd(this, str, str2);
        }

        public final Builder add(String str, Date date) {
            str.getClass();
            date.getClass();
            return add(str, DateFormattingKt.toHttpDateString(date));
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            str.getClass();
            instant.getClass();
            Date dateFrom = DesugarDate.from(instant);
            dateFrom.getClass();
            return add(str, dateFrom);
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            str.getClass();
            str2.getClass();
            return _HeadersCommonKt.commonAddLenient(this, str, str2);
        }
    }
}
