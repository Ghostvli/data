package org.jupnp.http;

import j$.net.URLDecoder;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import org.jupnp.http.Query;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Query {
    protected final Map<String, List<String>> parameters;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Query(String str) {
        String strDecode;
        this.parameters = new LinkedHashMap();
        if (str == null) {
            return;
        }
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf == -1) {
                strDecode = null;
            } else {
                String strSubstring = str2.substring(0, iIndexOf);
                Charset charset = StandardCharsets.UTF_8;
                String strDecode2 = URLDecoder.decode(strSubstring, charset);
                strDecode = URLDecoder.decode(str2.substring(iIndexOf + 1), charset);
                str2 = strDecode2;
            }
            this.parameters.computeIfAbsent(str2, new Function() { // from class: hj3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Query.a((String) obj);
                }
            }).add(strDecode);
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.util.ArrayList.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List a(String str) {
        return new ArrayList();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.util.ArrayList.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List b(String str) {
        return new ArrayList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Query newInstance(Map<String, List<String>> map) {
        Query query = new Query();
        query.parameters.putAll(map);
        return query;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Query cloneAndAdd(String str, String... strArr) {
        HashMap map = new HashMap(getMapWithLists());
        ((List) map.computeIfAbsent(str, new Function() { // from class: gj3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Query.b((String) obj);
            }
        })).addAll(Arrays.asList(strArr));
        return newInstance(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String get(String str) {
        List<String> list = this.parameters.get(str);
        return (list == null || list.isEmpty()) ? "" : list.get(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String[]> getMap() {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, List<String>> entry : this.parameters.entrySet()) {
            List<String> value = entry.getValue();
            treeMap.put(entry.getKey(), value == null ? null : (String[]) value.toArray(new String[value.size()]));
        }
        return treeMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, List<String>> getMapWithLists() {
        return Collections.unmodifiableMap(this.parameters);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Enumeration<String> getNames() {
        return Collections.enumeration(this.parameters.keySet());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String[] getValues(String str) {
        List<String> list = this.parameters.get(str);
        if (list == null) {
            return null;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<String> getValuesAsList(String str) {
        if (this.parameters.containsKey(str)) {
            return Collections.unmodifiableList(this.parameters.get(str));
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : this.parameters.entrySet()) {
            for (String str : entry.getValue()) {
                if (str != null && !str.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public Query(Map<String, String[]> map) {
        this.parameters = new LinkedHashMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            this.parameters.put(entry.getKey(), Arrays.asList(entry.getValue() != null ? entry.getValue() : new String[0]));
        }
    }

    public Query(URL url) {
        this(url.getQuery());
    }

    public Query() {
        this.parameters = new LinkedHashMap();
    }
}
