package org.jupnp.util;

import defpackage.jl;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MimeType {
    public static final String WILDCARD = "*";
    private Map<String, String> parameters;
    private String subtype;
    private String type;

    public MimeType(String str, String str2, Map<String, String> map) {
        this.type = str == null ? "*" : str;
        this.subtype = str2 == null ? "*" : str2;
        if (map == null) {
            this.parameters = Collections.EMPTY_MAP;
            return;
        }
        TreeMap treeMap = new TreeMap(new Comparator() { // from class: lt2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((String) obj).compareToIgnoreCase((String) obj2);
            }
        });
        treeMap.putAll(map);
        this.parameters = Collections.unmodifiableMap(treeMap);
    }

    public static int getEnd(String str, int i) {
        int iIndexOf = str.indexOf(61, i);
        int iIndexOf2 = str.indexOf(59, i);
        return (iIndexOf == -1 && iIndexOf2 == -1) ? str.length() : iIndexOf == -1 ? iIndexOf2 : iIndexOf2 == -1 ? iIndexOf : Math.min(iIndexOf, iIndexOf2);
    }

    public static int readParamsIntoMap(Map<String, String> map, String str, int i) {
        int end = getEnd(str, i);
        String strTrim = str.substring(i, end).trim();
        if (end < str.length() && str.charAt(end) == '=') {
            end++;
        }
        StringBuilder sb = new StringBuilder(str.length() - end);
        boolean z = false;
        boolean z2 = false;
        while (end < str.length()) {
            char cCharAt = str.charAt(end);
            if (cCharAt != '\"') {
                if (cCharAt != ';') {
                    if (cCharAt != '\\') {
                        sb.append(cCharAt);
                    } else if (z) {
                        sb.append(cCharAt);
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    if (!z2) {
                        map.put(strTrim, sb.toString().trim());
                        return end + 1;
                    }
                    sb.append(cCharAt);
                }
            } else if (z) {
                sb.append(cCharAt);
                z = false;
            } else {
                z2 = !z2;
            }
            end++;
        }
        map.put(strTrim, sb.toString().trim());
        return end;
    }

    public static MimeType valueOf(String str) {
        String strTrim;
        String strTrim2;
        String strTrim3 = null;
        if (str == null) {
            jl.a("String value is null");
            return null;
        }
        int iIndexOf = str.indexOf(";");
        if (iIndexOf > -1) {
            strTrim = str.substring(iIndexOf + 1).trim();
            str = str.substring(0, iIndexOf);
        } else {
            strTrim = null;
        }
        String[] strArrSplit = str.split(ServiceReference.DELIMITER);
        if (strArrSplit.length < 2 && str.equals("*")) {
            strTrim2 = "*";
            strTrim3 = strTrim2;
        } else if (strArrSplit.length == 2) {
            strTrim3 = strArrSplit[0].trim();
            strTrim2 = strArrSplit[1].trim();
        } else {
            if (strArrSplit.length != 2) {
                jl.a("Error parsing string: ".concat(str));
                return null;
            }
            strTrim2 = null;
        }
        if (strTrim == null || strTrim.isEmpty()) {
            return new MimeType(strTrim3, strTrim2);
        }
        HashMap map = new HashMap();
        for (int paramsIntoMap = 0; paramsIntoMap < strTrim.length(); paramsIntoMap = readParamsIntoMap(map, strTrim, paramsIntoMap)) {
        }
        return new MimeType(strTrim3, strTrim2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MimeType mimeType = (MimeType) obj;
        return Objects.equals(this.parameters, mimeType.parameters) && this.subtype.equalsIgnoreCase(mimeType.subtype) && this.type.equalsIgnoreCase(mimeType.type);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.type.toLowerCase().hashCode() * 31) + this.subtype.toLowerCase().hashCode()) * 31;
        Map<String, String> map = this.parameters;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public boolean isCompatible(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        if (this.type.equals("*") || mimeType.type.equals("*")) {
            return true;
        }
        if (this.type.equalsIgnoreCase(mimeType.type) && (this.subtype.equals("*") || mimeType.subtype.equals("*"))) {
            return true;
        }
        return this.type.equalsIgnoreCase(mimeType.type) && this.subtype.equalsIgnoreCase(mimeType.subtype);
    }

    public boolean isWildcardSubtype() {
        return getSubtype().equals("*");
    }

    public boolean isWildcardType() {
        return getType().equals("*");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toStringNoParameters());
        if (getParameters() != null || !getParameters().isEmpty()) {
            for (String str : getParameters().keySet()) {
                sb.append(";");
                sb.append(str);
                sb.append("=\"");
                sb.append(getParameters().get(str));
                sb.append("\"");
            }
        }
        return sb.toString();
    }

    public String toStringNoParameters() {
        return getType() + ServiceReference.DELIMITER + getSubtype();
    }

    public MimeType() {
        this("*", "*");
    }

    public MimeType(String str, String str2) {
        this(str, str2, Collections.EMPTY_MAP);
    }
}
