package org.jupnp.http;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.HTTP;
import org.jupnp.http.Headers;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Headers implements Map<String, List<String>> {
    static final byte CR = 13;
    static final byte LF = 10;
    final Map<String, List<String>> map;
    private boolean normalizeHeaders;

    public Headers(ByteArrayInputStream byteArrayInputStream) {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
        StringBuilder sb = new StringBuilder(Buffer.DEFAULT_SIZE);
        Headers headers = new Headers();
        String line = readLine(sb, byteArrayInputStream);
        if (!line.isEmpty()) {
            String str = null;
            do {
                char cCharAt = line.charAt(0);
                if (str == null || !(cCharAt == ' ' || cCharAt == '\t')) {
                    String[] strArrSplitHeader = splitHeader(line);
                    headers.add(strArrSplitHeader[0], strArrSplitHeader[1]);
                    str = strArrSplitHeader[0];
                } else {
                    List<String> list = headers.get((Object) str);
                    int size = list.size() - 1;
                    list.set(size, list.get(size) + line.trim());
                }
                sb.delete(0, sb.length());
                line = readLine(sb, byteArrayInputStream);
            } while (!line.isEmpty());
        }
        putAll(headers);
    }

    public static /* synthetic */ List a(String str) {
        return new LinkedList();
    }

    private String normalize(String str) {
        if (!this.normalizeHeaders) {
            return str;
        }
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        if (c >= 'a' && c <= 'z') {
            charArray[0] = (char) (c - ' ');
        }
        int length = str.length();
        for (int i = 1; i < length; i++) {
            char c2 = charArray[i];
            if (c2 >= 'A' && c2 <= 'Z') {
                charArray[i] = (char) (c2 + ' ');
            }
        }
        return new String(charArray);
    }

    public static String readLine(StringBuilder sb, ByteArrayInputStream byteArrayInputStream) {
        while (true) {
            int i = byteArrayInputStream.read();
            if (i == -1) {
                break;
            }
            char c = (char) i;
            if (c == '\r') {
                if (((char) byteArrayInputStream.read()) == '\n') {
                    break;
                }
                sb.append(c);
            } else {
                if (c == '\n') {
                    break;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void add(String str, String str2) {
        this.map.computeIfAbsent(normalize(str), new Function() { // from class: bd1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Headers.a((String) obj);
            }
        }).add(str2);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return obj != null && (obj instanceof String) && this.map.containsKey(normalize((String) obj));
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, List<String>>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    public int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    @Override // java.util.Map
    public List<String> get(Object obj) {
        return this.map.get(normalize((String) obj));
    }

    public String getFirstHeader(String str) {
        List<String> list = this.map.get(normalize(str));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public List<String> put(String str, List<String> list) {
        return this.map.put(normalize(str), list);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends List<String>> map) {
        for (Map.Entry<? extends String, ? extends List<String>> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public List<String> remove(Object obj) {
        return this.map.remove(normalize((String) obj));
    }

    public void set(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        put(str, (List<String>) linkedList);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    public String[] splitHeader(String str) {
        char cCharAt;
        int iFindNonWhitespace = findNonWhitespace(str, 0);
        int i = iFindNonWhitespace;
        while (i < str.length() && (cCharAt = str.charAt(i)) != ':' && !Character.isWhitespace(cCharAt)) {
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            if (str.charAt(i2) == ':') {
                i2++;
                break;
            }
            i2++;
        }
        int iFindNonWhitespace2 = findNonWhitespace(str, i2);
        int iFindEndOfString = findEndOfString(str);
        return new String[]{str.substring(iFindNonWhitespace, i), (str.length() < iFindNonWhitespace2 || str.length() < iFindEndOfString || iFindNonWhitespace2 >= iFindEndOfString) ? null : str.substring(iFindNonWhitespace2, iFindEndOfString)};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(512);
        for (Map.Entry<String, List<String>> entry : entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(HTTP.CRLF);
        }
        return sb.toString();
    }

    @Override // java.util.Map
    public Collection<List<String>> values() {
        return this.map.values();
    }

    public static String readLine(ByteArrayInputStream byteArrayInputStream) {
        return readLine(new StringBuilder(Buffer.DEFAULT_SIZE), byteArrayInputStream);
    }

    public Headers(Map<String, List<String>> map) {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
        putAll(map);
    }

    public Headers() {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
    }

    public Headers(boolean z) {
        this.map = new HashMap(32);
        this.normalizeHeaders = z;
    }
}
