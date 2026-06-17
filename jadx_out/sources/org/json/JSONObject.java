package org.json;

import defpackage.la5;
import defpackage.om1;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JSONObject {
    private final Map<String, Object> map;
    static final Pattern NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?");
    public static final Object NULL = new Null();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Null {
        private Null() {
        }

        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "null";
        }
    }

    public JSONObject(JSONTokener jSONTokener) {
        this();
        if (jSONTokener.nextClean() != '{') {
            throw jSONTokener.syntaxError("A JSONObject text must begin with '{'");
        }
        while (true) {
            char cNextClean = jSONTokener.nextClean();
            if (cNextClean == 0) {
                throw jSONTokener.syntaxError("A JSONObject text must end with '}'");
            }
            if (cNextClean == '}') {
                return;
            }
            String string = jSONTokener.nextSimpleValue(cNextClean).toString();
            if (jSONTokener.nextClean() != ':') {
                throw jSONTokener.syntaxError("Expected a ':' after a key");
            }
            if (string != null) {
                if (opt(string) != null) {
                    throw jSONTokener.syntaxError("Duplicate key \"" + string + "\"");
                }
                Object objNextValue = jSONTokener.nextValue();
                if (objNextValue != null) {
                    put(string, objNextValue);
                }
            }
            char cNextClean2 = jSONTokener.nextClean();
            if (cNextClean2 != ',' && cNextClean2 != ';') {
                if (cNextClean2 != '}') {
                    throw jSONTokener.syntaxError("Expected a ',' or '}'");
                }
                return;
            } else {
                if (jSONTokener.nextClean() == '}') {
                    return;
                }
                if (jSONTokener.end()) {
                    throw jSONTokener.syntaxError("A JSONObject text must end with '}'");
                }
                jSONTokener.back();
            }
        }
    }

    private static boolean digitAtIndex(String str, int i) {
        return i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9';
    }

    public static String doubleToString(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return "null";
        }
        String string = Double.toString(d);
        if (string.indexOf(46) <= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
            return string;
        }
        while (string.endsWith("0")) {
            string = string.substring(0, string.length() - 1);
        }
        return string.endsWith(".") ? string.substring(0, string.length() - 1) : string;
    }

    private static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        if (method != null && cls != null) {
            if (method.isAnnotationPresent(cls)) {
                return (A) method.getAnnotation(cls);
            }
            Class<?> declaringClass = method.getDeclaringClass();
            if (declaringClass.getSuperclass() == null) {
                return null;
            }
            for (Class<?> cls2 : declaringClass.getInterfaces()) {
                try {
                    return (A) getAnnotation(cls2.getMethod(method.getName(), method.getParameterTypes()), cls);
                } catch (NoSuchMethodException | SecurityException unused) {
                }
            }
            try {
                return (A) getAnnotation(declaringClass.getSuperclass().getMethod(method.getName(), method.getParameterTypes()), cls);
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
        }
        return null;
    }

    private static int getAnnotationDepth(Method method, Class<? extends Annotation> cls) {
        int annotationDepth;
        if (method != null && cls != null) {
            if (method.isAnnotationPresent(cls)) {
                return 1;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            if (declaringClass.getSuperclass() == null) {
                return -1;
            }
            for (Class<?> cls2 : declaringClass.getInterfaces()) {
                try {
                    annotationDepth = getAnnotationDepth(cls2.getMethod(method.getName(), method.getParameterTypes()), cls);
                } catch (NoSuchMethodException | SecurityException unused) {
                }
                if (annotationDepth > 0) {
                    return annotationDepth + 1;
                }
            }
            try {
                int annotationDepth2 = getAnnotationDepth(declaringClass.getSuperclass().getMethod(method.getName(), method.getParameterTypes()), cls);
                if (annotationDepth2 > 0) {
                    return annotationDepth2 + 1;
                }
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
        }
        return -1;
    }

    private static String getKeyNameFromMethod(Method method) {
        String strSubstring;
        int annotationDepth;
        int annotationDepth2 = getAnnotationDepth(method, JSONPropertyIgnore.class);
        if (annotationDepth2 > 0 && ((annotationDepth = getAnnotationDepth(method, JSONPropertyName.class)) < 0 || annotationDepth2 <= annotationDepth)) {
            return null;
        }
        JSONPropertyName jSONPropertyName = (JSONPropertyName) getAnnotation(method, JSONPropertyName.class);
        if (jSONPropertyName != null && jSONPropertyName.value() != null && !jSONPropertyName.value().isEmpty()) {
            return jSONPropertyName.value();
        }
        String name = method.getName();
        if (!name.startsWith("get") || name.length() <= 3) {
            if (name.startsWith("is") && name.length() > 2) {
                strSubstring = name.substring(2);
            }
            return null;
        }
        strSubstring = name.substring(3);
        if (strSubstring.length() != 0 && !Character.isLowerCase(strSubstring.charAt(0))) {
            if (strSubstring.length() == 1) {
                return strSubstring.toLowerCase(Locale.ROOT);
            }
            if (Character.isUpperCase(strSubstring.charAt(1))) {
                return strSubstring;
            }
            return strSubstring.substring(0, 1).toLowerCase(Locale.ROOT) + strSubstring.substring(1);
        }
        return null;
    }

    public static String[] getNames(Object obj) {
        Field[] fields;
        int length;
        if (obj == null || (length = (fields = obj.getClass().getFields()).length) == 0) {
            return null;
        }
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = fields[i].getName();
        }
        return strArr;
    }

    public static final void indent(Writer writer, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(32);
        }
    }

    public static boolean isDecimalNotation(String str) {
        return str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1 || "-0".equals(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isNumberSimilar(Number number, Number number2) {
        if (numberIsFinite(number) && numberIsFinite(number2)) {
            if (number.getClass().equals(number2.getClass()) && (number instanceof Comparable)) {
                return ((Comparable) number).compareTo(number2) == 0;
            }
            BigDecimal bigDecimalObjectToBigDecimal = objectToBigDecimal(number, null, false);
            BigDecimal bigDecimalObjectToBigDecimal2 = objectToBigDecimal(number2, null, false);
            if (bigDecimalObjectToBigDecimal != null && bigDecimalObjectToBigDecimal2 != null && bigDecimalObjectToBigDecimal.compareTo(bigDecimalObjectToBigDecimal2) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidMethodName(String str) {
        return ("getClass".equals(str) || "getDeclaringClass".equals(str)) ? false : true;
    }

    private static boolean numberIsFinite(Number number) {
        if (number instanceof Double) {
            Double d = (Double) number;
            if (d.isInfinite() || d.isNaN()) {
                return false;
            }
        }
        if (!(number instanceof Float)) {
            return true;
        }
        Float f = (Float) number;
        return (f.isInfinite() || f.isNaN()) ? false : true;
    }

    public static String numberToString(Number number) {
        if (number == null) {
            throw new JSONException("Null pointer");
        }
        testValidity(number);
        String string = number.toString();
        if (string.indexOf(46) <= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
            return string;
        }
        while (string.endsWith("0")) {
            string = string.substring(0, string.length() - 1);
        }
        return string.endsWith(".") ? string.substring(0, string.length() - 1) : string;
    }

    public static BigDecimal objectToBigDecimal(Object obj, BigDecimal bigDecimal, boolean z) {
        if (!NULL.equals(obj)) {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Double) || (obj instanceof Float)) {
                Number number = (Number) obj;
                if (numberIsFinite(number)) {
                    return z ? new BigDecimal(number.doubleValue()) : new BigDecimal(obj.toString());
                }
            } else {
                if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                    return new BigDecimal(((Number) obj).longValue());
                }
                try {
                    return new BigDecimal(obj.toString());
                } catch (Exception unused) {
                }
            }
        }
        return bigDecimal;
    }

    public static BigInteger objectToBigInteger(Object obj, BigInteger bigInteger) {
        if (!NULL.equals(obj)) {
            if (obj instanceof BigInteger) {
                return (BigInteger) obj;
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).toBigInteger();
            }
            if ((obj instanceof Double) || (obj instanceof Float)) {
                Number number = (Number) obj;
                if (numberIsFinite(number)) {
                    return new BigDecimal(number.doubleValue()).toBigInteger();
                }
            } else {
                if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                    return BigInteger.valueOf(((Number) obj).longValue());
                }
                try {
                    String string = obj.toString();
                    return isDecimalNotation(string) ? new BigDecimal(string).toBigInteger() : new BigInteger(string);
                } catch (Exception unused) {
                }
            }
        }
        return bigInteger;
    }

    private void populateMap(Object obj, Set<Object> set) {
        String keyNameFromMethod;
        Class<?> cls = obj.getClass();
        for (Method method : cls.getClassLoader() != null ? cls.getMethods() : cls.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers) && method.getParameterTypes().length == 0 && !method.isBridge() && method.getReturnType() != Void.TYPE && isValidMethodName(method.getName()) && (keyNameFromMethod = getKeyNameFromMethod(method)) != null && !keyNameFromMethod.isEmpty()) {
                try {
                    Object objInvoke = method.invoke(obj, null);
                    if (objInvoke == null) {
                        continue;
                    } else {
                        if (set.contains(objInvoke)) {
                            throw recursivelyDefinedObjectException(keyNameFromMethod);
                        }
                        set.add(objInvoke);
                        testValidity(objInvoke);
                        this.map.put(keyNameFromMethod, wrap(objInvoke, set));
                        set.remove(objInvoke);
                        if (objInvoke instanceof Closeable) {
                            ((Closeable) objInvoke).close();
                        }
                    }
                } catch (IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    continue;
                }
            }
        }
    }

    private static boolean potentialNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return potentialPositiveNumberStartingAtIndex(str, str.charAt(0) == '-' ? 1 : 0);
    }

    private static boolean potentialPositiveNumberStartingAtIndex(String str, int i) {
        if (i >= str.length()) {
            return false;
        }
        if (str.charAt(i) == '.') {
            i++;
        }
        return digitAtIndex(str, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.Writer quote(java.lang.String r8, java.io.Writer r9) throws java.io.IOException {
        /*
            if (r8 == 0) goto L99
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto La
            goto L99
        La:
            int r0 = r8.length()
            r1 = 34
            r9.write(r1)
            r2 = 0
            r3 = r2
            r4 = r3
        L16:
            if (r3 >= r0) goto L95
            char r5 = r8.charAt(r3)
            r6 = 12
            if (r5 == r6) goto L8c
            r6 = 13
            if (r5 == r6) goto L86
            r6 = 92
            if (r5 == r1) goto L7f
            r7 = 47
            if (r5 == r7) goto L74
            if (r5 == r6) goto L7f
            switch(r5) {
                case 8: goto L6e;
                case 9: goto L68;
                case 10: goto L62;
                default: goto L31;
            }
        L31:
            r4 = 32
            if (r5 < r4) goto L4a
            r4 = 128(0x80, float:1.8E-43)
            if (r5 < r4) goto L3d
            r4 = 160(0xa0, float:2.24E-43)
            if (r5 < r4) goto L4a
        L3d:
            r4 = 8192(0x2000, float:1.148E-41)
            if (r5 < r4) goto L46
            r4 = 8448(0x2100, float:1.1838E-41)
            if (r5 >= r4) goto L46
            goto L4a
        L46:
            r9.write(r5)
            goto L91
        L4a:
            java.lang.String r4 = "\\u"
            r9.write(r4)
            java.lang.String r4 = java.lang.Integer.toHexString(r5)
            int r6 = r4.length()
            int r6 = 4 - r6
            java.lang.String r7 = "0000"
            r9.write(r7, r2, r6)
            r9.write(r4)
            goto L91
        L62:
            java.lang.String r4 = "\\n"
            r9.write(r4)
            goto L91
        L68:
            java.lang.String r4 = "\\t"
            r9.write(r4)
            goto L91
        L6e:
            java.lang.String r4 = "\\b"
            r9.write(r4)
            goto L91
        L74:
            r7 = 60
            if (r4 != r7) goto L7b
            r9.write(r6)
        L7b:
            r9.write(r5)
            goto L91
        L7f:
            r9.write(r6)
            r9.write(r5)
            goto L91
        L86:
            java.lang.String r4 = "\\r"
            r9.write(r4)
            goto L91
        L8c:
            java.lang.String r4 = "\\f"
            r9.write(r4)
        L91:
            int r3 = r3 + 1
            r4 = r5
            goto L16
        L95:
            r9.write(r1)
            return r9
        L99:
            java.lang.String r8 = "\"\""
            r9.write(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONObject.quote(java.lang.String, java.io.Writer):java.io.Writer");
    }

    private static JSONException recursivelyDefinedObjectException(String str) {
        return new JSONException("JavaBean object contains recursively defined member variable of key " + quote(str));
    }

    private static String removeLeadingZerosOfNumber(String str) {
        if (str.equals("-")) {
            return str;
        }
        int i = str.charAt(0) == '-' ? 1 : 0;
        for (int i2 = i; i2 < str.length(); i2++) {
            if (str.charAt(i2) != '0') {
                return i != 0 ? "-".concat(str.substring(i2)) : str.substring(i2);
            }
        }
        return i != 0 ? "-0" : "0";
    }

    public static Number stringToNumber(String str) {
        String strConcat = str.startsWith(".") ? "0".concat(str) : str;
        if (strConcat.startsWith("-.")) {
            strConcat = "-0.".concat(strConcat.substring(2));
        }
        char cCharAt = strConcat.charAt(0);
        if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '-') {
            la5.a(str);
            return null;
        }
        if (isDecimalNotation(strConcat)) {
            try {
                try {
                    BigDecimal bigDecimal = new BigDecimal(strConcat);
                    return (cCharAt == '-' && BigDecimal.ZERO.compareTo(bigDecimal) == 0) ? Double.valueOf(-0.0d) : bigDecimal;
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strConcat);
                    if (!dValueOf.isNaN() && !dValueOf.isInfinite()) {
                        return dValueOf;
                    }
                    throw new NumberFormatException("val [" + str + "] is not a valid number.");
                }
            } catch (NumberFormatException unused2) {
                la5.a(str);
                return null;
            }
            la5.a(str);
            return null;
        }
        String strRemoveLeadingZerosOfNumber = removeLeadingZerosOfNumber(str);
        char cCharAt2 = strRemoveLeadingZerosOfNumber.charAt(0);
        if (cCharAt2 == '0' && strRemoveLeadingZerosOfNumber.length() > 1) {
            char cCharAt3 = strRemoveLeadingZerosOfNumber.charAt(1);
            if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                la5.a(str);
                return null;
            }
        } else if (cCharAt2 == '-' && strRemoveLeadingZerosOfNumber.length() > 2) {
            char cCharAt4 = strRemoveLeadingZerosOfNumber.charAt(1);
            char cCharAt5 = strRemoveLeadingZerosOfNumber.charAt(2);
            if (cCharAt4 == '0' && cCharAt5 >= '0' && cCharAt5 <= '9') {
                la5.a(str);
                return null;
            }
        }
        BigInteger bigInteger = new BigInteger(strRemoveLeadingZerosOfNumber);
        return bigInteger.bitLength() <= 31 ? Integer.valueOf(bigInteger.intValue()) : bigInteger.bitLength() <= 63 ? Long.valueOf(bigInteger.longValue()) : bigInteger;
    }

    public static Object stringToValue(String str) {
        if ("".equals(str)) {
            return str;
        }
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(str)) {
            return NULL;
        }
        if (!potentialNumber(str)) {
            return str;
        }
        try {
            return stringToNumber(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void testValidity(Object obj) {
        if ((obj instanceof Number) && !numberIsFinite((Number) obj)) {
            throw new JSONException("JSON does not allow non-finite numbers.");
        }
    }

    public static String valueToString(Object obj) {
        return JSONWriter.valueToString(obj);
    }

    private static Object wrap(Object obj, Set<Object> set) {
        try {
            Object obj2 = NULL;
            if (obj2.equals(obj)) {
                return obj2;
            }
            if ((obj instanceof JSONObject) || (obj instanceof JSONArray) || obj2.equals(obj) || (obj instanceof JSONString) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof BigInteger) || (obj instanceof BigDecimal) || (obj instanceof Enum)) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection<?>) obj);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map<?, ?>) obj);
            }
            Package r0 = obj.getClass().getPackage();
            String name = r0 != null ? r0.getName() : "";
            if (!name.startsWith("java.") && !name.startsWith("javax.") && obj.getClass().getClassLoader() != null) {
                return set != null ? new JSONObject(obj, set) : new JSONObject(obj);
            }
            return obj.toString();
        } catch (JSONException e) {
            throw e;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Writer writeValue(Writer writer, Object obj, int i, int i2) {
        if (obj == null || obj.equals(null)) {
            writer.write("null");
            return writer;
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                writer.write(jSONString != null ? jSONString.toString() : quote(obj.toString()));
                return writer;
            } catch (Exception e) {
                throw new JSONException(e);
            }
        }
        if (obj instanceof Number) {
            String strNumberToString = numberToString((Number) obj);
            if (NUMBER_PATTERN.matcher(strNumberToString).matches()) {
                writer.write(strNumberToString);
                return writer;
            }
            quote(strNumberToString, writer);
            return writer;
        }
        if (obj instanceof Boolean) {
            writer.write(obj.toString());
            return writer;
        }
        if (obj instanceof Enum) {
            writer.write(quote(((Enum) obj).name()));
            return writer;
        }
        if (obj instanceof JSONObject) {
            ((JSONObject) obj).write(writer, i, i2);
            return writer;
        }
        if (obj instanceof JSONArray) {
            ((JSONArray) obj).write(writer, i, i2);
            return writer;
        }
        if (obj instanceof Map) {
            new JSONObject((Map<?, ?>) obj).write(writer, i, i2);
            return writer;
        }
        if (obj instanceof Collection) {
            new JSONArray((Collection<?>) obj).write(writer, i, i2);
            return writer;
        }
        if (obj.getClass().isArray()) {
            new JSONArray(obj).write(writer, i, i2);
            return writer;
        }
        quote(obj.toString(), writer);
        return writer;
    }

    private static JSONException wrongValueFormatException(String str, String str2, Object obj, Throwable th) {
        if (obj == null) {
            return new JSONException("JSONObject[" + quote(str) + "] is not a " + str2 + " (null).", th);
        }
        if ((obj instanceof Map) || (obj instanceof Iterable) || (obj instanceof JSONObject)) {
            return new JSONException("JSONObject[" + quote(str) + "] is not a " + str2 + " (" + obj.getClass() + ").", th);
        }
        return new JSONException("JSONObject[" + quote(str) + "] is not a " + str2 + " (" + obj.getClass() + " : " + obj + ").", th);
    }

    public JSONObject accumulate(String str, Object obj) {
        testValidity(obj);
        Object objOpt = opt(str);
        if (objOpt == null) {
            if (obj instanceof JSONArray) {
                obj = new JSONArray().put(obj);
            }
            put(str, obj);
            return this;
        }
        if (objOpt instanceof JSONArray) {
            ((JSONArray) objOpt).put(obj);
            return this;
        }
        put(str, new JSONArray().put(objOpt).put(obj));
        return this;
    }

    public JSONObject append(String str, Object obj) {
        testValidity(obj);
        Object objOpt = opt(str);
        if (objOpt == null) {
            put(str, new JSONArray().put(obj));
            return this;
        }
        if (!(objOpt instanceof JSONArray)) {
            throw wrongValueFormatException(str, "JSONArray", null, null);
        }
        put(str, ((JSONArray) objOpt).put(obj));
        return this;
    }

    public void clear() {
        this.map.clear();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public Object get(String str) {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        Object objOpt = opt(str);
        if (objOpt != null) {
            return objOpt;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] not found.");
    }

    public BigDecimal getBigDecimal(String str) {
        Object obj = get(str);
        BigDecimal bigDecimalObjectToBigDecimal = objectToBigDecimal(obj, null);
        if (bigDecimalObjectToBigDecimal != null) {
            return bigDecimalObjectToBigDecimal;
        }
        throw wrongValueFormatException(str, "BigDecimal", obj, null);
    }

    public BigInteger getBigInteger(String str) {
        Object obj = get(str);
        BigInteger bigIntegerObjectToBigInteger = objectToBigInteger(obj, null);
        if (bigIntegerObjectToBigInteger != null) {
            return bigIntegerObjectToBigInteger;
        }
        throw wrongValueFormatException(str, "BigInteger", obj, null);
    }

    public boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z = obj instanceof String;
        if (z && ((String) obj).equalsIgnoreCase("false")) {
            return false;
        }
        if (obj.equals(Boolean.TRUE)) {
            return true;
        }
        if (z && ((String) obj).equalsIgnoreCase("true")) {
            return true;
        }
        throw wrongValueFormatException(str, "Boolean", obj, null);
    }

    public double getDouble(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(str, "double", obj, e);
        }
    }

    public <E extends Enum<E>> E getEnum(Class<E> cls, String str) {
        E e = (E) optEnum(cls, str);
        if (e != null) {
            return e;
        }
        throw wrongValueFormatException(str, "enum of type " + quote(cls.getSimpleName()), opt(str), null);
    }

    public float getFloat(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(str, "float", obj, e);
        }
    }

    public int getInt(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(str, "int", obj, e);
        }
    }

    public JSONArray getJSONArray(String str) {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw wrongValueFormatException(str, "JSONArray", obj, null);
    }

    public JSONObject getJSONObject(String str) {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw wrongValueFormatException(str, "JSONObject", obj, null);
    }

    public long getLong(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(str, "long", obj, e);
        }
    }

    public Class<? extends Map> getMapType() {
        return this.map.getClass();
    }

    public Number getNumber(String str) {
        Object obj = get(str);
        try {
            return obj instanceof Number ? (Number) obj : stringToNumber(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(str, "number", obj, e);
        }
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw wrongValueFormatException(str, "string", obj, null);
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }

    public JSONObject increment(String str) {
        Object objOpt = opt(str);
        if (objOpt == null) {
            put(str, 1);
            return this;
        }
        if (objOpt instanceof Integer) {
            put(str, ((Integer) objOpt).intValue() + 1);
            return this;
        }
        if (objOpt instanceof Long) {
            put(str, ((Long) objOpt).longValue() + 1);
            return this;
        }
        if (objOpt instanceof BigInteger) {
            put(str, ((BigInteger) objOpt).add(BigInteger.ONE));
            return this;
        }
        if (objOpt instanceof Float) {
            put(str, ((Float) objOpt).floatValue() + 1.0f);
            return this;
        }
        if (objOpt instanceof Double) {
            put(str, ((Double) objOpt).doubleValue() + 1.0d);
            return this;
        }
        if (objOpt instanceof BigDecimal) {
            put(str, ((BigDecimal) objOpt).add(BigDecimal.ONE));
            return this;
        }
        throw new JSONException("Unable to increment [" + quote(str) + "].");
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean isNull(String str) {
        return NULL.equals(opt(str));
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Iterator<String> keys() {
        return keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        if (this.map.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection<?>) this.map.keySet());
    }

    public Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    public BigDecimal optBigDecimal(String str, BigDecimal bigDecimal) {
        return objectToBigDecimal(opt(str), bigDecimal);
    }

    public BigInteger optBigInteger(String str, BigInteger bigInteger) {
        return objectToBigInteger(opt(str), bigInteger);
    }

    public boolean optBoolean(String str, boolean z) {
        Object objOpt = opt(str);
        if (NULL.equals(objOpt)) {
            return z;
        }
        if (objOpt instanceof Boolean) {
            return ((Boolean) objOpt).booleanValue();
        }
        try {
            return getBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    public Boolean optBooleanObject(String str, Boolean bool) {
        Object objOpt = opt(str);
        if (!NULL.equals(objOpt)) {
            if (objOpt instanceof Boolean) {
                return (Boolean) objOpt;
            }
            try {
                return Boolean.valueOf(getBoolean(str));
            } catch (Exception unused) {
            }
        }
        return bool;
    }

    public double optDouble(String str, double d) {
        Number numberOptNumber = optNumber(str);
        return numberOptNumber == null ? d : numberOptNumber.doubleValue();
    }

    public Double optDoubleObject(String str, Double d) {
        Number numberOptNumber = optNumber(str);
        return numberOptNumber == null ? d : Double.valueOf(numberOptNumber.doubleValue());
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, String str, E e) {
        Object objOpt;
        try {
            objOpt = opt(str);
        } catch (IllegalArgumentException | NullPointerException unused) {
        }
        return NULL.equals(objOpt) ? e : cls.isAssignableFrom(objOpt.getClass()) ? (E) objOpt : (E) Enum.valueOf(cls, objOpt.toString());
    }

    public float optFloat(String str, float f) {
        Number numberOptNumber = optNumber(str);
        return numberOptNumber == null ? f : numberOptNumber.floatValue();
    }

    public Float optFloatObject(String str, Float f) {
        Number numberOptNumber = optNumber(str);
        return numberOptNumber == null ? f : Float.valueOf(numberOptNumber.floatValue());
    }

    public int optInt(String str, int i) {
        Number numberOptNumber = optNumber(str, null);
        return numberOptNumber == null ? i : numberOptNumber.intValue();
    }

    public Integer optIntegerObject(String str, Integer num) {
        Number numberOptNumber = optNumber(str, null);
        return numberOptNumber == null ? num : Integer.valueOf(numberOptNumber.intValue());
    }

    public JSONArray optJSONArray(String str, JSONArray jSONArray) {
        Object objOpt = opt(str);
        return objOpt instanceof JSONArray ? (JSONArray) objOpt : jSONArray;
    }

    public JSONObject optJSONObject(String str, JSONObject jSONObject) {
        Object objOpt = opt(str);
        return objOpt instanceof JSONObject ? (JSONObject) objOpt : jSONObject;
    }

    public long optLong(String str, long j) {
        Number numberOptNumber = optNumber(str, null);
        return numberOptNumber == null ? j : numberOptNumber.longValue();
    }

    public Long optLongObject(String str, Long l) {
        Number numberOptNumber = optNumber(str, null);
        return numberOptNumber == null ? l : Long.valueOf(numberOptNumber.longValue());
    }

    public Number optNumber(String str, Number number) {
        Object objOpt = opt(str);
        if (!NULL.equals(objOpt)) {
            if (objOpt instanceof Number) {
                return (Number) objOpt;
            }
            try {
                return stringToNumber(objOpt.toString());
            } catch (Exception unused) {
            }
        }
        return number;
    }

    public Object optQuery(String str) {
        return optQuery(new JSONPointer(str));
    }

    public String optString(String str, String str2) {
        Object objOpt = opt(str);
        return NULL.equals(objOpt) ? str2 : objOpt.toString();
    }

    public JSONObject put(String str, Object obj) {
        if (str == null) {
            om1.a("Null key.");
            return null;
        }
        if (obj == null) {
            remove(str);
            return this;
        }
        testValidity(obj);
        this.map.put(str, obj);
        return this;
    }

    public JSONObject putOnce(String str, Object obj) {
        if (str == null || obj == null) {
            return this;
        }
        if (opt(str) == null) {
            return put(str, obj);
        }
        throw new JSONException("Duplicate key \"" + str + "\"");
    }

    public JSONObject putOpt(String str, Object obj) {
        return (str == null || obj == null) ? this : put(str, obj);
    }

    public Object query(String str) {
        return query(new JSONPointer(str));
    }

    public Object remove(String str) {
        return this.map.remove(str);
    }

    public boolean similar(Object obj) {
        try {
            if (!(obj instanceof JSONObject) || !keySet().equals(((JSONObject) obj).keySet())) {
                return false;
            }
            for (Map.Entry<String, Object> entry : entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Object obj2 = ((JSONObject) obj).get(key);
                if (value != obj2) {
                    if (value == null) {
                        return false;
                    }
                    if (value instanceof JSONObject) {
                        if (!((JSONObject) value).similar(obj2)) {
                            return false;
                        }
                    } else if (value instanceof JSONArray) {
                        if (!((JSONArray) value).similar(obj2)) {
                            return false;
                        }
                    } else if ((value instanceof Number) && (obj2 instanceof Number)) {
                        if (!isNumberSimilar((Number) value, (Number) obj2)) {
                            return false;
                        }
                    } else if ((value instanceof JSONString) && (obj2 instanceof JSONString)) {
                        if (!((JSONString) value).toJSONString().equals(((JSONString) obj2).toJSONString())) {
                            return false;
                        }
                    } else if (!value.equals(obj2)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public JSONArray toJSONArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.isEmpty()) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONArray2.put(opt(jSONArray.getString(i)));
        }
        return jSONArray2;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        for (Map.Entry<String, Object> entry : entrySet()) {
            map.put(entry.getKey(), (entry.getValue() == null || NULL.equals(entry.getValue())) ? null : entry.getValue() instanceof JSONObject ? ((JSONObject) entry.getValue()).toMap() : entry.getValue() instanceof JSONArray ? ((JSONArray) entry.getValue()).toList() : entry.getValue());
        }
        return map;
    }

    public String toString(int i) {
        return write(new StringWriter(), i, 0).toString();
    }

    public Writer write(Writer writer, int i, int i2) {
        try {
            int length = length();
            writer.write(Token.EXPORT);
            if (length == 1) {
                Map.Entry<String, Object> next = entrySet().iterator().next();
                String key = next.getKey();
                writer.write(quote(key));
                writer.write(58);
                if (i > 0) {
                    writer.write(32);
                }
                try {
                    writeValue(writer, next.getValue(), i, i2);
                } catch (Exception e) {
                    throw new JSONException("Unable to write JSONObject value for key: " + key, e);
                }
            } else if (length != 0) {
                int i3 = i2 + i;
                boolean z = false;
                for (Map.Entry<String, Object> entry : entrySet()) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    indent(writer, i3);
                    String key2 = entry.getKey();
                    writer.write(quote(key2));
                    writer.write(58);
                    if (i > 0) {
                        writer.write(32);
                    }
                    try {
                        writeValue(writer, entry.getValue(), i, i3);
                        z = true;
                    } catch (Exception e2) {
                        throw new JSONException("Unable to write JSONObject value for key: " + key2, e2);
                    }
                }
                if (i > 0) {
                    writer.write(10);
                }
                indent(writer, i2);
            }
            writer.write(Token.IF);
            return writer;
        } catch (IOException e3) {
            throw new JSONException(e3);
        }
    }

    public Object optQuery(JSONPointer jSONPointer) {
        try {
            return jSONPointer.queryFrom(this);
        } catch (JSONPointerException unused) {
            return null;
        }
    }

    public Object query(JSONPointer jSONPointer) {
        return jSONPointer.queryFrom(this);
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public float optFloat(String str) {
        return optFloat(str, Float.NaN);
    }

    public JSONArray optJSONArray(String str) {
        return optJSONArray(str, null);
    }

    public JSONObject optJSONObject(String str) {
        return optJSONObject(str, null);
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public long optLong(String str) {
        return optLong(str, 0L);
    }

    public String toString() {
        try {
            return toString(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public Double optDoubleObject(String str) {
        return optDoubleObject(str, Double.valueOf(Double.NaN));
    }

    public Float optFloatObject(String str) {
        return optFloatObject(str, Float.valueOf(Float.NaN));
    }

    public Integer optIntegerObject(String str) {
        return optIntegerObject(str, 0);
    }

    public Long optLongObject(String str) {
        return optLongObject(str, 0L);
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public JSONObject put(String str, Collection<?> collection) {
        return put(str, new JSONArray(collection));
    }

    public JSONObject put(String str, double d) {
        return put(str, Double.valueOf(d));
    }

    public JSONObject put(String str, float f) {
        return put(str, Float.valueOf(f));
    }

    public JSONObject put(String str, int i) {
        return put(str, Integer.valueOf(i));
    }

    public JSONObject put(String str, long j) {
        return put(str, Long.valueOf(j));
    }

    public JSONObject put(String str, Map<?, ?> map) {
        return put(str, new JSONObject(map));
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public Boolean optBooleanObject(String str) {
        return optBooleanObject(str, Boolean.FALSE);
    }

    public Number optNumber(String str) {
        return optNumber(str, null);
    }

    public JSONObject put(String str, boolean z) {
        return put(str, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public static String[] getNames(JSONObject jSONObject) {
        if (jSONObject.isEmpty()) {
            return null;
        }
        return (String[]) jSONObject.keySet().toArray(new String[jSONObject.length()]);
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, String str) {
        return (E) optEnum(cls, str, null);
    }

    public static BigDecimal objectToBigDecimal(Object obj, BigDecimal bigDecimal) {
        return objectToBigDecimal(obj, bigDecimal, true);
    }

    private void populateMap(Object obj) {
        populateMap(obj, Collections.newSetFromMap(new IdentityHashMap()));
    }

    public JSONObject(JSONObject jSONObject, String... strArr) {
        this(strArr.length);
        for (String str : strArr) {
            try {
                putOnce(str, jSONObject.opt(str));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject() {
        this.map = new HashMap();
    }

    public JSONObject(Map<?, ?> map) {
        if (map == null) {
            this.map = new HashMap();
            return;
        }
        this.map = new HashMap(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Object value = entry.getValue();
                if (value != null) {
                    testValidity(value);
                    this.map.put(String.valueOf(entry.getKey()), wrap(value));
                }
            } else {
                om1.a("Null key.");
                throw null;
            }
        }
    }

    public JSONObject(Object obj) {
        this();
        populateMap(obj);
    }

    public static String quote(String str) {
        try {
            return quote(str, new StringWriter()).toString();
        } catch (IOException unused) {
            return "";
        }
    }

    private JSONObject(Object obj, Set<Object> set) {
        this();
        populateMap(obj, set);
    }

    public JSONObject(Object obj, String... strArr) {
        this(strArr.length);
        Class<?> cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(String str) {
        this(new JSONTokener(str));
    }

    public JSONObject(String str, Locale locale) {
        this();
        ResourceBundle bundle = ResourceBundle.getBundle(str, locale, Thread.currentThread().getContextClassLoader());
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String strNextElement = keys.nextElement();
            if (strNextElement != null) {
                String str2 = strNextElement;
                String[] strArrSplit = str2.split("\\.");
                int length = strArrSplit.length - 1;
                JSONObject jSONObject = this;
                for (int i = 0; i < length; i++) {
                    String str3 = strArrSplit[i];
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str3);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObject.put(str3, jSONObjectOptJSONObject);
                    }
                    jSONObject = jSONObjectOptJSONObject;
                }
                jSONObject.put(strArrSplit[length], bundle.getString(str2));
            }
        }
    }

    public JSONObject(int i) {
        this.map = new HashMap(i);
    }

    public static Object wrap(Object obj) {
        return wrap(obj, null);
    }

    public Writer write(Writer writer) {
        return write(writer, 0, 0);
    }
}
