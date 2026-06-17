package okhttp3.internal;

import defpackage.fu4;
import defpackage.i73;
import defpackage.jl;
import defpackage.ka;
import defpackage.ow;
import defpackage.qh3;
import defpackage.sg4;
import defpackage.tw;
import defpackage.ua;
import defpackage.wg4;
import defpackage.zs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class _HeadersCommonKt {
    private static final String charCode(char c) {
        String string = Integer.toString(c, zs.a(16));
        string.getClass();
        return string.length() < 2 ? "0".concat(string) : string;
    }

    public static final Headers.Builder commonAdd(Headers.Builder builder, String str, String str2) {
        builder.getClass();
        str.getClass();
        str2.getClass();
        headersCheckName(str);
        headersCheckValue(str2, str);
        commonAddLenient(builder, str, str2);
        return builder;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder builder, Headers headers) {
        builder.getClass();
        headers.getClass();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            commonAddLenient(builder, headers.name(i), headers.value(i));
        }
        return builder;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder builder, String str, String str2) {
        builder.getClass();
        str.getClass();
        str2.getClass();
        builder.getNamesAndValues$okhttp().add(str);
        builder.getNamesAndValues$okhttp().add(wg4.O0(str2).toString());
        return builder;
    }

    public static final Headers commonBuild(Headers.Builder builder) {
        builder.getClass();
        return new Headers((String[]) builder.getNamesAndValues$okhttp().toArray(new String[0]));
    }

    public static final boolean commonEquals(Headers headers, Object obj) {
        headers.getClass();
        return (obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues$okhttp(), ((Headers) obj).getNamesAndValues$okhttp());
    }

    public static final String commonGet(Headers.Builder builder, String str) {
        builder.getClass();
        str.getClass();
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int iB = qh3.b(size, 0, -2);
        if (iB > size) {
            return null;
        }
        while (!sg4.y(str, builder.getNamesAndValues$okhttp().get(size), true)) {
            if (size == iB) {
                return null;
            }
            size -= 2;
        }
        return builder.getNamesAndValues$okhttp().get(size + 1);
    }

    public static final int commonHashCode(Headers headers) {
        headers.getClass();
        return Arrays.hashCode(headers.getNamesAndValues$okhttp());
    }

    public static final String commonHeadersGet(String[] strArr, String str) {
        strArr.getClass();
        str.getClass();
        int length = strArr.length - 2;
        int iB = qh3.b(length, 0, -2);
        if (iB > length) {
            return null;
        }
        while (!sg4.y(str, strArr[length], true)) {
            if (length == iB) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public static final Headers commonHeadersOf(String... strArr) {
        strArr.getClass();
        if (strArr.length % 2 != 0) {
            jl.a("Expected alternating header names and values");
            return null;
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        int length = strArr2.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (strArr2[i2] == null) {
                jl.a("Headers cannot be null");
                return null;
            }
            strArr2[i2] = wg4.O0(strArr[i2]).toString();
        }
        int iB = qh3.b(0, strArr2.length - 1, 2);
        if (iB >= 0) {
            while (true) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                headersCheckName(str);
                headersCheckValue(str2, str);
                if (i == iB) {
                    break;
                }
                i += 2;
            }
        }
        return new Headers(strArr2);
    }

    public static final Iterator<i73> commonIterator(Headers headers) {
        headers.getClass();
        int size = headers.size();
        i73[] i73VarArr = new i73[size];
        for (int i = 0; i < size; i++) {
            i73VarArr[i] = fu4.a(headers.name(i), headers.value(i));
        }
        return ka.a(i73VarArr);
    }

    public static final String commonName(Headers headers, int i) {
        headers.getClass();
        String str = (String) ua.B(headers.getNamesAndValues$okhttp(), i * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    public static final Headers.Builder commonNewBuilder(Headers headers) {
        headers.getClass();
        Headers.Builder builder = new Headers.Builder();
        tw.x(builder.getNamesAndValues$okhttp(), headers.getNamesAndValues$okhttp());
        return builder;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder builder, String str) {
        builder.getClass();
        str.getClass();
        int i = 0;
        while (i < builder.getNamesAndValues$okhttp().size()) {
            if (sg4.y(str, builder.getNamesAndValues$okhttp().get(i), true)) {
                builder.getNamesAndValues$okhttp().remove(i);
                builder.getNamesAndValues$okhttp().remove(i);
                i -= 2;
            }
            i += 2;
        }
        return builder;
    }

    public static final Headers.Builder commonSet(Headers.Builder builder, String str, String str2) {
        builder.getClass();
        str.getClass();
        str2.getClass();
        headersCheckName(str);
        headersCheckValue(str2, str);
        builder.removeAll(str);
        commonAddLenient(builder, str, str2);
        return builder;
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        map.getClass();
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String string = wg4.O0(key).toString();
            String string2 = wg4.O0(value).toString();
            headersCheckName(string);
            headersCheckValue(string2, string);
            strArr[i] = string;
            strArr[i + 1] = string2;
            i += 2;
        }
        return new Headers(strArr);
    }

    public static final String commonToString(Headers headers) {
        headers.getClass();
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            String strValue = headers.value(i);
            sb.append(strName);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final String commonValue(Headers headers, int i) {
        headers.getClass();
        String str = (String) ua.B(headers.getNamesAndValues$okhttp(), (i * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    public static final List<String> commonValues(Headers headers, String str) {
        headers.getClass();
        str.getClass();
        int size = headers.size();
        List<String> listUnmodifiableList = null;
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (sg4.y(str, headers.name(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i));
            }
        }
        if (arrayList != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            listUnmodifiableList.getClass();
        }
        return listUnmodifiableList == null ? ow.j() : listUnmodifiableList;
    }

    public static final void headersCheckName(String str) {
        str.getClass();
        if (str.length() <= 0) {
            jl.a("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(cCharAt) + " at " + i + " in header name: " + str).toString());
            }
        }
    }

    public static final void headersCheckValue(String str, String str2) {
        str.getClass();
        str2.getClass();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                sb.append(charCode(cCharAt));
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(str2);
                sb.append(" value");
                sb.append(_UtilCommonKt.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }
}
