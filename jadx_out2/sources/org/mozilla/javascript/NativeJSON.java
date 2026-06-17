package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import okhttp3.internal.url._UrlKt;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeJSON;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.json.JsonParser;
import org.mozilla.javascript.xml.XMLObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSON extends ScriptableObject {
    private static final String JSON_TAG = "JSON";
    private static final int MAX_STRINGIFY_GAP_LENGTH = 10;
    private static final long serialVersionUID = -4567599697595654984L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class StringifyState {
        Context cx;
        String gap;
        String indent;
        Object[] propertyList;
        Callable replacer;
        Scriptable scope;
        ArrayDeque<Object> stack = new ArrayDeque<>();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public StringifyState(Context context, Scriptable scriptable, String str, String str2, Callable callable, Object[] objArr) {
            this.cx = context;
            this.scope = scriptable;
            this.indent = str;
            this.gap = str2;
            this.replacer = callable;
            this.propertyList = objArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private NativeJSON() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Scriptable scriptable, boolean z) {
        NativeJSON nativeJSON = new NativeJSON();
        nativeJSON.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJSON.setParentScope(scriptable);
        nativeJSON.defineProperty(scriptable, "parse", 2, new Callable() { // from class: yy2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeJSON.parse(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeJSON.defineProperty(scriptable, "stringify", 3, new Callable() { // from class: zy2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeJSON.stringify(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeJSON.defineProperty("toSource", JSON_TAG, 7);
        nativeJSON.defineProperty(SymbolKey.TO_STRING_TAG, JSON_TAG, 3);
        ScriptableObject.defineProperty(scriptable, JSON_TAG, nativeJSON, 2);
        if (z) {
            nativeJSON.sealObject();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isLeadingSurrogate(char c) {
        return c >= 55296 && c <= 56319;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isObjectArrayLike(Object obj) {
        if (obj instanceof NativeArray) {
            return true;
        }
        if (!(obj instanceof NativeJavaObject)) {
            return false;
        }
        Object objUnwrap = ((NativeJavaObject) obj).unwrap();
        return (objUnwrap instanceof Collection) || objUnwrap.getClass().isArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isTrailingSurrogate(char c) {
        return c >= 56320 && c <= 57343;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String ja(Scriptable scriptable, StringifyState stringifyState) {
        Object objUnwrap;
        Object obj;
        String str;
        Object[] objArr = null;
        if (scriptable instanceof Wrapper) {
            objUnwrap = ((Wrapper) scriptable).unwrap();
            obj = objUnwrap;
        } else {
            objUnwrap = scriptable;
            obj = null;
        }
        if (stringifyState.stack.contains(objUnwrap)) {
            throw ScriptRuntime.typeErrorById("msg.cyclic.value", objUnwrap.getClass().getName());
        }
        stringifyState.stack.push(objUnwrap);
        String str2 = stringifyState.indent;
        stringifyState.indent = str2 + stringifyState.gap;
        ArrayList arrayList = new ArrayList();
        if (obj != null) {
            int i = 0;
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                Object[] objArr2 = new Object[length];
                while (i < length) {
                    objArr2[i] = Context.javaToJS(Array.get(obj, i), stringifyState.scope, stringifyState.cx);
                    i++;
                }
                objArr = objArr2;
            } else if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                objArr = new Object[collection.size()];
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    objArr[i] = Context.javaToJS(it.next(), stringifyState.scope, stringifyState.cx);
                    i++;
                }
            }
            if (objArr != null) {
                scriptable = stringifyState.cx.newArray(stringifyState.scope, objArr);
            }
        }
        long length2 = ((NativeArray) scriptable).getLength();
        long j = 0;
        while (j < length2) {
            Object objStr = j > 2147483647L ? str(Long.toString(j), scriptable, stringifyState) : str(Integer.valueOf((int) j), scriptable, stringifyState);
            if (objStr == Undefined.instance) {
                arrayList.add("null");
            } else {
                arrayList.add(objStr);
            }
            j++;
        }
        if (arrayList.isEmpty()) {
            str = _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        } else if (stringifyState.gap.length() == 0) {
            str = "[" + join(arrayList, ",") + "]";
        } else {
            String strJoin = join(arrayList, ",\n" + stringifyState.indent);
            str = "[\n" + stringifyState.indent + strJoin + "\n" + str2 + "]";
        }
        stringifyState.stack.pop();
        stringifyState.indent = str2;
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object javaToJSON(Object obj, StringifyState stringifyState) {
        Object objJavaToJS = Context.javaToJS(stringifyState.cx.getJavaToJSONConverter().apply(obj), stringifyState.scope, stringifyState.cx);
        NativeObject nativeObject = new NativeObject();
        nativeObject.setParentScope(stringifyState.scope);
        nativeObject.setPrototype(ScriptableObject.getObjectPrototype(stringifyState.scope));
        nativeObject.defineProperty("", objJavaToJS, 0);
        return str("", nativeObject, stringifyState);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String jo(Scriptable scriptable, StringifyState stringifyState) {
        Object obj;
        Object objUnwrap;
        String str;
        String string;
        int i;
        if (scriptable instanceof Wrapper) {
            objUnwrap = ((Wrapper) scriptable).unwrap();
            obj = objUnwrap;
        } else {
            obj = null;
            objUnwrap = scriptable;
        }
        if (stringifyState.stack.contains(objUnwrap)) {
            throw ScriptRuntime.typeErrorById("msg.cyclic.value", objUnwrap.getClass().getName());
        }
        stringifyState.stack.push(objUnwrap);
        if (obj instanceof Map) {
            scriptable = stringifyState.cx.newObject(stringifyState.scope);
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (!(entry.getKey() instanceof Symbol)) {
                    Object objJavaToJS = Context.javaToJS(entry.getValue(), stringifyState.scope, stringifyState.cx);
                    if (entry.getKey() instanceof String) {
                        string = (String) entry.getKey();
                        i = 5;
                    } else {
                        string = entry.getKey().toString();
                        i = 0;
                    }
                    try {
                        ScriptableObject.defineProperty(scriptable, string, objJavaToJS, i);
                    } catch (EcmaError unused) {
                    }
                }
            }
        }
        String str2 = stringifyState.indent;
        stringifyState.indent = str2 + stringifyState.gap;
        Object[] ids = stringifyState.propertyList;
        if (ids == null) {
            ids = scriptable.getIds();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : ids) {
            Object objStr = str(obj2, scriptable, stringifyState);
            if (objStr != Undefined.instance) {
                String strConcat = quote(obj2.toString()) + ":";
                if (stringifyState.gap.length() > 0) {
                    strConcat = strConcat.concat(" ");
                }
                arrayList.add(strConcat.concat(String.valueOf(objStr)));
            }
        }
        if (arrayList.isEmpty()) {
            str = "{}";
        } else if (stringifyState.gap.length() == 0) {
            str = "{" + join(arrayList, ",") + "}";
        } else {
            str = "{\n" + stringifyState.indent + join(arrayList, ",\n" + stringifyState.indent) + "\n" + str2 + "}";
        }
        stringifyState.stack.pop();
        stringifyState.indent = str2;
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String join(Collection<Object> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<Object> it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(it.next().toString());
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object parse(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        String string = ScriptRuntime.toString(objArr, 0);
        Object obj = objArr.length > 1 ? objArr[1] : null;
        return obj instanceof Callable ? parse(context, scriptable, string, (Callable) obj) : parse(context, scriptable, string);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String quote(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        int length = str.length();
        int i = 0;
        char c = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (!isLeadingSurrogate(cCharAt) || i >= length - 1 || !isTrailingSurrogate(str.charAt(i + 1))) {
                            if (isTrailingSurrogate(cCharAt) && isLeadingSurrogate(c)) {
                                sb.append(c);
                                sb.append(cCharAt);
                            } else if (cCharAt < ' ' || isLeadingSurrogate(cCharAt) || isTrailingSurrogate(cCharAt)) {
                                sb.append("\\u");
                                sb.append(String.format("%04x", Integer.valueOf(cCharAt)));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
            i++;
            c = cCharAt;
        }
        sb.append('\"');
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object str(Object obj, Scriptable scriptable, StringifyState stringifyState) {
        int iIntValue;
        Object property;
        String string;
        Object obj2 = null;
        if (obj instanceof String) {
            string = (String) obj;
            property = ScriptableObject.getProperty(scriptable, string);
            iIntValue = 0;
        } else {
            iIntValue = ((Number) obj).intValue();
            property = ScriptableObject.getProperty(scriptable, iIntValue);
            string = null;
        }
        if (property instanceof Scriptable) {
            Scriptable scriptable2 = (Scriptable) property;
            if (ScriptableObject.hasProperty(scriptable2, "toJSON")) {
                if (ScriptableObject.getProperty(scriptable2, "toJSON") instanceof Callable) {
                    Context context = stringifyState.cx;
                    if (string == null) {
                        string = Integer.toString(iIntValue);
                    }
                    property = ScriptableObject.callMethod(context, scriptable2, "toJSON", new Object[]{string});
                }
            } else if (property instanceof BigInteger) {
                Scriptable object = ScriptRuntime.toObject(stringifyState.cx, stringifyState.scope, property);
                if (ScriptableObject.hasProperty(object, "toJSON") && (ScriptableObject.getProperty(object, "toJSON") instanceof Callable)) {
                    Context context2 = stringifyState.cx;
                    if (string == null) {
                        string = Integer.toString(iIntValue);
                    }
                    property = ScriptableObject.callMethod(context2, object, "toJSON", new Object[]{string});
                }
            }
        }
        Callable callable = stringifyState.replacer;
        if (callable != null) {
            property = callable.call(stringifyState.cx, stringifyState.scope, scriptable, new Object[]{obj, property});
        }
        if (ScriptRuntime.isSymbol(property)) {
            return Undefined.instance;
        }
        if (property instanceof NativeNumber) {
            property = Double.valueOf(ScriptRuntime.toNumber(property));
        } else if (property instanceof NativeString) {
            property = ScriptRuntime.toString(property);
        } else if (property instanceof NativeBoolean) {
            property = ((NativeBoolean) property).getDefaultValue(ScriptRuntime.BooleanClass);
        } else if (stringifyState.cx.getLanguageVersion() >= 200 && (property instanceof NativeBigInt)) {
            property = ((NativeBigInt) property).getDefaultValue(ScriptRuntime.BigIntegerClass);
        } else if (property instanceof NativeJavaObject) {
            Object objUnwrap = ((NativeJavaObject) property).unwrap();
            if (!(objUnwrap instanceof Map) && !(objUnwrap instanceof Collection) && !objUnwrap.getClass().isArray()) {
                obj2 = objUnwrap;
                property = obj2;
            }
        } else if (property instanceof XMLObject) {
            property = property.toString();
        }
        if (property == null) {
            return "null";
        }
        if (property.equals(Boolean.TRUE)) {
            return "true";
        }
        if (property.equals(Boolean.FALSE)) {
            return "false";
        }
        if (property instanceof CharSequence) {
            return quote(property.toString());
        }
        if (!(property instanceof Number)) {
            return obj2 != null ? javaToJSON(property, stringifyState) : (!(property instanceof Scriptable) || (property instanceof Callable)) ? Undefined.instance : isObjectArrayLike(property) ? ja((Scriptable) property, stringifyState) : jo((Scriptable) property, stringifyState);
        }
        if (property instanceof BigInteger) {
            throw ScriptRuntime.typeErrorById("msg.json.cant.serialize", "BigInt");
        }
        double dDoubleValue = ((Number) property).doubleValue();
        return (Double.isNaN(dDoubleValue) || dDoubleValue == Double.POSITIVE_INFINITY || dDoubleValue == Double.NEGATIVE_INFINITY) ? "null" : ScriptRuntime.toString(property);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object stringify(Context context, Scriptable scriptable, Object obj, Object obj2, Object obj3) {
        Callable callable;
        Object[] objArr;
        String str;
        String strSubstring;
        if (obj2 instanceof Callable) {
            callable = (Callable) obj2;
            objArr = null;
        } else if (obj2 instanceof NativeArray) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            NativeArray nativeArray = (NativeArray) obj2;
            Iterator<Integer> it = nativeArray.getIndexIds().iterator();
            while (it.hasNext()) {
                Object obj4 = nativeArray.get(it.next().intValue(), nativeArray);
                if (obj4 instanceof String) {
                    linkedHashSet.add(obj4);
                } else if ((obj4 instanceof Number) || (obj4 instanceof NativeString) || (obj4 instanceof NativeNumber)) {
                    linkedHashSet.add(ScriptRuntime.toString(obj4));
                }
            }
            Object[] objArr2 = new Object[linkedHashSet.size()];
            Iterator it2 = linkedHashSet.iterator();
            int i = 0;
            while (it2.hasNext()) {
                ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(it2.next());
                int i2 = i + 1;
                Object objValueOf = stringIdOrIndex.stringId;
                if (objValueOf == null) {
                    objValueOf = Integer.valueOf(stringIdOrIndex.index);
                }
                objArr2[i] = objValueOf;
                i = i2;
            }
            objArr = objArr2;
            callable = null;
        } else {
            callable = null;
            objArr = null;
        }
        Object objValueOf2 = obj3 instanceof NativeNumber ? Double.valueOf(ScriptRuntime.toNumber(obj3)) : obj3 instanceof NativeString ? ScriptRuntime.toString(obj3) : obj3;
        if (objValueOf2 instanceof Number) {
            int iMin = Math.min(10, (int) ScriptRuntime.toInteger(objValueOf2));
            strSubstring = iMin > 0 ? repeat(' ', iMin) : "";
        } else {
            if (!(objValueOf2 instanceof String)) {
                str = "";
                StringifyState stringifyState = new StringifyState(context, scriptable, "", str, callable, objArr);
                NativeObject nativeObject = new NativeObject();
                nativeObject.setParentScope(scriptable);
                nativeObject.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
                nativeObject.defineProperty("", obj, 0);
                return str("", nativeObject, stringifyState);
            }
            strSubstring = (String) objValueOf2;
            if (strSubstring.length() > 10) {
                strSubstring = strSubstring.substring(0, 10);
            }
        }
        str = strSubstring;
        StringifyState stringifyState2 = new StringifyState(context, scriptable, "", str, callable, objArr);
        NativeObject nativeObject2 = new NativeObject();
        nativeObject2.setParentScope(scriptable);
        nativeObject2.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeObject2.defineProperty("", obj, 0);
        return str("", nativeObject2, stringifyState2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object walk(Context context, Scriptable scriptable, Callable callable, Scriptable scriptable2, Object obj) {
        Object obj2 = obj instanceof Number ? scriptable2.get(((Number) obj).intValue(), scriptable2) : scriptable2.get((String) obj, scriptable2);
        if (obj2 instanceof Scriptable) {
            Scriptable scriptable3 = (Scriptable) obj2;
            if (scriptable3 instanceof NativeArray) {
                long length = ((NativeArray) scriptable3).getLength();
                for (long j = 0; j < length; j++) {
                    if (j > 2147483647L) {
                        String string = Long.toString(j);
                        Object objWalk = walk(context, scriptable, callable, scriptable3, string);
                        if (objWalk == Undefined.instance) {
                            scriptable3.delete(string);
                        } else {
                            scriptable3.put(string, scriptable3, objWalk);
                        }
                    } else {
                        int i = (int) j;
                        Object objWalk2 = walk(context, scriptable, callable, scriptable3, Integer.valueOf(i));
                        if (objWalk2 == Undefined.instance) {
                            scriptable3.delete(i);
                        } else {
                            scriptable3.put(i, scriptable3, objWalk2);
                        }
                    }
                }
            } else {
                for (Object obj3 : scriptable3.getIds()) {
                    Object objWalk3 = walk(context, scriptable, callable, scriptable3, obj3);
                    if (objWalk3 == Undefined.instance) {
                        if (obj3 instanceof Number) {
                            scriptable3.delete(((Number) obj3).intValue());
                        } else {
                            scriptable3.delete((String) obj3);
                        }
                    } else if (obj3 instanceof Number) {
                        scriptable3.put(((Number) obj3).intValue(), scriptable3, objWalk3);
                    } else {
                        scriptable3.put((String) obj3, scriptable3, objWalk3);
                    }
                }
            }
        }
        return callable.call(context, scriptable, scriptable2, new Object[]{obj, obj2});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return JSON_TAG;
    }

    private static Object parse(Context context, Scriptable scriptable, String str) {
        try {
            return new JsonParser(context, scriptable).parseValue(str);
        } catch (JsonParser.ParseException e) {
            throw ScriptRuntime.constructError("SyntaxError", e.getMessage());
        }
    }

    public static Object parse(Context context, Scriptable scriptable, String str, Callable callable) {
        Object obj = parse(context, scriptable, str);
        Scriptable scriptableNewObject = context.newObject(scriptable);
        scriptableNewObject.put("", scriptableNewObject, obj);
        return walk(context, scriptable, callable, scriptableNewObject, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0018 A[PHI: r6
      0x0018: PHI (r6v2 java.lang.Object) = (r6v1 java.lang.Object), (r6v5 java.lang.Object) binds: [B:3:0x0004, B:5:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object stringify(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Object obj2 = Undefined.instance;
        if (objArr.length > 0) {
            obj2 = objArr[0];
            if (objArr.length > 1) {
                Object obj3 = objArr[1];
                obj = objArr.length > 2 ? objArr[2] : null;
                obj = obj3;
            } else {
                obj = null;
            }
        }
        return stringify(context, scriptable, obj2, obj, obj);
    }
}
