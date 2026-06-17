package org.json;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JSONML {
    /* JADX WARN: Code restructure failed: missing block: B:115:0x019b, code lost:
    
        throw r9.syntaxError("Reserved attribute.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01a4, code lost:
    
        r7 = r9.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01aa, code lost:
    
        if ((r7 instanceof java.lang.String) == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01ac, code lost:
    
        r7 = (java.lang.String) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01b2, code lost:
    
        if (r12.isKeepStrings() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01b5, code lost:
    
        r7 = org.json.XML.stringToValue(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01c4, code lost:
    
        throw r9.syntaxError("Missing value");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013f A[RETURN] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object parse(org.json.XMLTokener r9, boolean r10, org.json.JSONArray r11, org.json.JSONMLParserConfiguration r12, int r13) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONML.parse(org.json.XMLTokener, boolean, org.json.JSONArray, org.json.JSONMLParserConfiguration, int):java.lang.Object");
    }

    public static JSONArray toJSONArray(String str) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, JSONMLParserConfiguration.ORIGINAL, 0);
    }

    public static JSONObject toJSONObject(String str) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, false, 0);
    }

    public static String toString(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        String strOptString = jSONObject.optString("tagName");
        if (strOptString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(strOptString);
        String strEscape = XML.escape(strOptString);
        sb.append('<');
        sb.append(strEscape);
        for (String str : jSONObject.keySet()) {
            if (!"tagName".equals(str) && !"childNodes".equals(str)) {
                XML.noSpace(str);
                Object objOpt = jSONObject.opt(str);
                if (objOpt != null) {
                    sb.append(' ');
                    sb.append(XML.escape(str));
                    sb.append("=\"");
                    sb.append(XML.escape(objOpt.toString()));
                    sb.append('\"');
                }
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childNodes");
        if (jSONArrayOptJSONArray == null) {
            sb.append("/>");
        } else {
            sb.append('>');
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArrayOptJSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                    } else {
                        sb.append(obj.toString());
                    }
                }
            }
            sb.append("</");
            sb.append(strEscape);
            sb.append('>');
        }
        return sb.toString();
    }

    public static JSONObject toJSONObject(String str, boolean z) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, z, 0);
    }

    public static JSONObject toJSONObject(String str, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, false, 0);
    }

    public static JSONArray toJSONArray(String str, boolean z) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, z, 0);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener, boolean z) {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, z, 0);
    }

    public static JSONArray toJSONArray(String str, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener, JSONMLParserConfiguration jSONMLParserConfiguration) {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, jSONMLParserConfiguration, 0);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener, boolean z) {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, z, 0);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, false, 0);
    }

    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray, boolean z2, int i) {
        return parse(xMLTokener, z, jSONArray, z2 ? JSONMLParserConfiguration.KEEP_STRINGS : JSONMLParserConfiguration.ORIGINAL, i);
    }

    public static String toString(JSONArray jSONArray) {
        int i;
        StringBuilder sb = new StringBuilder("<");
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String strEscape = XML.escape(string);
        sb.append(strEscape);
        Object objOpt = jSONArray.opt(1);
        if (objOpt instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) objOpt;
            for (String str : jSONObject.keySet()) {
                Object objOpt2 = jSONObject.opt(str);
                XML.noSpace(str);
                if (objOpt2 != null) {
                    sb.append(' ');
                    sb.append(XML.escape(str));
                    sb.append("=\"");
                    sb.append(XML.escape(objOpt2.toString()));
                    sb.append('\"');
                }
            }
            i = 2;
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            sb.append("/>");
        } else {
            sb.append('>');
            do {
                Object obj = jSONArray.get(i);
                i++;
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                    } else {
                        sb.append(obj.toString());
                    }
                }
            } while (i < length);
            sb.append("</");
            sb.append(strEscape);
            sb.append('>');
        }
        return sb.toString();
    }
}
