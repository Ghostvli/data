package org.json;

import defpackage.jl;
import defpackage.om1;
import defpackage.wg1;
import j$.net.URLDecoder;
import j$.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JSONPointer {
    private static final String ENCODING = "utf-8";
    private final List<String> refTokens;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JSONPointer(String str) {
        String strSubstring;
        if (str == null) {
            om1.a("pointer cannot be null");
            throw null;
        }
        if (str.isEmpty() || str.equals("#")) {
            this.refTokens = Collections.EMPTY_LIST;
            return;
        }
        if (str.startsWith("#/")) {
            try {
                strSubstring = URLDecoder.decode(str.substring(2), ENCODING);
            } catch (UnsupportedEncodingException e) {
                wg1.a(e);
                throw null;
            }
        } else {
            if (!str.startsWith(ServiceReference.DELIMITER)) {
                jl.a("a JSON pointer should start with '/' or '#/'");
                throw null;
            }
            strSubstring = str.substring(1);
        }
        this.refTokens = new ArrayList();
        int i = -1;
        while (true) {
            int i2 = i + 1;
            int iIndexOf = strSubstring.indexOf(47, i2);
            if (i2 == iIndexOf || i2 == strSubstring.length()) {
                this.refTokens.add("");
            } else if (iIndexOf >= 0) {
                this.refTokens.add(unescape(strSubstring.substring(i2, iIndexOf)));
            } else {
                this.refTokens.add(unescape(strSubstring.substring(i2)));
            }
            if (iIndexOf < 0) {
                return;
            } else {
                i = iIndexOf;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Builder builder() {
        return new Builder();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String escape(String str) {
        return str.replace("~", "~0").replace(ServiceReference.DELIMITER, "~1");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object readByIndexToken(Object obj, String str) {
        try {
            int i = Integer.parseInt(str);
            JSONArray jSONArray = (JSONArray) obj;
            if (i >= jSONArray.length()) {
                throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", str, Integer.valueOf(jSONArray.length())));
            }
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
                throw new JSONPointerException("Error reading value at index position " + i, e);
            }
        } catch (NumberFormatException e2) {
            throw new JSONPointerException(String.format("%s is not an array index", str), e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String unescape(String str) {
        return str.replace("~1", ServiceReference.DELIMITER).replace("~0", "~");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object queryFrom(Object obj) {
        if (this.refTokens.isEmpty()) {
            return obj;
        }
        for (String str : this.refTokens) {
            if (obj instanceof JSONObject) {
                obj = ((JSONObject) obj).opt(unescape(str));
            } else {
                if (!(obj instanceof JSONArray)) {
                    throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", obj, str));
                }
                obj = readByIndexToken(obj, str);
            }
        }
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (String str : this.refTokens) {
            sb.append('/');
            sb.append(escape(str));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toURIFragment() {
        try {
            StringBuilder sb = new StringBuilder("#");
            for (String str : this.refTokens) {
                sb.append('/');
                sb.append(URLEncoder.encode(str, ENCODING));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            wg1.a(e);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Builder {
        private final List<String> refTokens = new ArrayList();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builder append(String str) {
            if (str != null) {
                this.refTokens.add(str);
                return this;
            }
            om1.a("token cannot be null");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public JSONPointer build() {
            return new JSONPointer(this.refTokens);
        }

        public Builder append(int i) {
            this.refTokens.add(String.valueOf(i));
            return this;
        }
    }

    public JSONPointer(List<String> list) {
        this.refTokens = new ArrayList(list);
    }
}
