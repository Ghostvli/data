package org.json;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JSONML {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:190:0x01b9 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v4, resolved type: java.lang.Object */
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
    */
    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray, JSONMLParserConfiguration jSONMLParserConfiguration, int i) {
        String str;
        Object objStringToValue;
        loop0: while (xMLTokener.more()) {
            Object objNextContent = xMLTokener.nextContent();
            if (objNextContent == XML.LT) {
                Object objNextToken = xMLTokener.nextToken();
                if (objNextToken instanceof Character) {
                    if (objNextToken == XML.SLASH) {
                        Object objNextToken2 = xMLTokener.nextToken();
                        if (objNextToken2 instanceof String) {
                            if (xMLTokener.nextToken() == XML.GT) {
                                return objNextToken2;
                            }
                            throw xMLTokener.syntaxError("Misshaped close tag");
                        }
                        throw new JSONException("Expected a closing name instead of '" + objNextToken2 + "'.");
                    }
                    if (objNextToken == XML.BANG) {
                        char next = xMLTokener.next();
                        if (next == '-') {
                            if (xMLTokener.next() == '-') {
                                xMLTokener.skipPast("-->");
                            } else {
                                xMLTokener.back();
                            }
                        } else if (next != '[') {
                            int i2 = 1;
                            do {
                                Object objNextMeta = xMLTokener.nextMeta();
                                if (objNextMeta == null) {
                                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                                }
                                if (objNextMeta == XML.LT) {
                                    i2++;
                                } else if (objNextMeta == XML.GT) {
                                    i2--;
                                }
                            } while (i2 > 0);
                        } else {
                            if (!xMLTokener.nextToken().equals("CDATA") || xMLTokener.next() != '[') {
                                throw xMLTokener.syntaxError("Expected 'CDATA['");
                            }
                            if (jSONArray != null) {
                                jSONArray.put(xMLTokener.nextCDATA());
                            }
                        }
                    } else {
                        if (objNextToken != XML.QUEST) {
                            throw xMLTokener.syntaxError("Misshaped tag");
                        }
                        xMLTokener.skipPast("?>");
                    }
                } else {
                    if (!(objNextToken instanceof String)) {
                        throw xMLTokener.syntaxError("Bad tagName '" + objNextToken + "'.");
                    }
                    String str2 = (String) objNextToken;
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        jSONArray2.put(str2);
                        if (jSONArray != null) {
                            jSONArray.put(jSONArray2);
                        }
                    } else {
                        jSONObject.put("tagName", str2);
                        if (jSONArray != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    while (true) {
                        Object objNextToken3 = null;
                        while (true) {
                            if (objNextToken3 == null) {
                                objNextToken3 = xMLTokener.nextToken();
                            }
                            if (objNextToken3 == null) {
                                throw xMLTokener.syntaxError("Misshaped tag");
                            }
                            if (objNextToken3 instanceof String) {
                                str = (String) objNextToken3;
                                if (!z && ("tagName".equals(str) || "childNode".equals(str))) {
                                    break loop0;
                                }
                                Object objNextToken4 = xMLTokener.nextToken();
                                if (objNextToken4 == XML.EQ) {
                                    break;
                                }
                                jSONObject.accumulate(str, "");
                                objNextToken3 = objNextToken4;
                            } else {
                                if (z && jSONObject.length() > 0) {
                                    jSONArray2.put(jSONObject);
                                }
                                if (objNextToken3 == XML.SLASH) {
                                    if (xMLTokener.nextToken() != XML.GT) {
                                        throw xMLTokener.syntaxError("Misshaped tag");
                                    }
                                    if (jSONArray == null) {
                                        return z ? jSONArray2 : jSONObject;
                                    }
                                } else {
                                    if (objNextToken3 != XML.GT) {
                                        throw xMLTokener.syntaxError("Misshaped tag");
                                    }
                                    if (i == jSONMLParserConfiguration.getMaxNestingDepth()) {
                                        throw xMLTokener.syntaxError("Maximum nesting depth of " + jSONMLParserConfiguration.getMaxNestingDepth() + " reached");
                                    }
                                    String str3 = (String) parse(xMLTokener, z, jSONArray2, jSONMLParserConfiguration, i + 1);
                                    if (str3 == null) {
                                        continue;
                                    } else {
                                        if (!str3.equals(str2)) {
                                            throw xMLTokener.syntaxError("Mismatched '" + str2 + "' and '" + str3 + "'");
                                        }
                                        if (!z && jSONArray2.length() > 0) {
                                            jSONObject.put("childNodes", jSONArray2);
                                        }
                                        if (jSONArray == null) {
                                            if (z) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        jSONObject.accumulate(str, objStringToValue);
                    }
                }
            } else if (jSONArray != null) {
                if (objNextContent instanceof String) {
                    String str4 = (String) objNextContent;
                    objNextContent = jSONMLParserConfiguration.isKeepStrings() ? XML.unescape(str4) : XML.stringToValue(str4);
                }
                jSONArray.put(objNextContent);
            }
        }
        throw xMLTokener.syntaxError("Bad XML");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static JSONArray toJSONArray(String str) {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, JSONMLParserConfiguration.ORIGINAL, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static JSONObject toJSONObject(String str) {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, false, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
