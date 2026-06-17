package org.mozilla.javascript;

import defpackage.jl;
import defpackage.nl;
import java.text.Collator;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import okio.Utf8;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.TopLevel;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final class NativeString extends IdScriptableObject {
    private static final int ConstructorId_charAt = -5;
    private static final int ConstructorId_charCodeAt = -6;
    private static final int ConstructorId_concat = -14;
    private static final int ConstructorId_equalsIgnoreCase = -30;
    private static final int ConstructorId_fromCharCode = -1;
    private static final int ConstructorId_fromCodePoint = -2;
    private static final int ConstructorId_indexOf = -7;
    private static final int ConstructorId_lastIndexOf = -8;
    private static final int ConstructorId_localeCompare = -35;
    private static final int ConstructorId_match = -31;
    private static final int ConstructorId_raw = -3;
    private static final int ConstructorId_replace = -33;
    private static final int ConstructorId_replaceAll = -34;
    private static final int ConstructorId_search = -32;
    private static final int ConstructorId_slice = -15;
    private static final int ConstructorId_split = -9;
    private static final int ConstructorId_substr = -13;
    private static final int ConstructorId_substring = -10;
    private static final int ConstructorId_toLocaleLowerCase = -36;
    private static final int ConstructorId_toLowerCase = -11;
    private static final int ConstructorId_toUpperCase = -12;
    private static final int Id_anchor = 28;
    private static final int Id_at = 52;
    private static final int Id_big = 21;
    private static final int Id_blink = 22;
    private static final int Id_bold = 16;
    private static final int Id_charAt = 5;
    private static final int Id_charCodeAt = 6;
    private static final int Id_codePointAt = 46;
    private static final int Id_concat = 14;
    private static final int Id_constructor = 1;
    private static final int Id_endsWith = 43;
    private static final int Id_equals = 29;
    private static final int Id_equalsIgnoreCase = 30;
    private static final int Id_fixed = 18;
    private static final int Id_fontcolor = 26;
    private static final int Id_fontsize = 25;
    private static final int Id_includes = 41;
    private static final int Id_indexOf = 7;
    private static final int Id_isWellFormed = 53;
    private static final int Id_italics = 17;
    private static final int Id_lastIndexOf = 8;
    private static final int Id_length = 1;
    private static final int Id_link = 27;
    private static final int Id_localeCompare = 35;
    private static final int Id_match = 31;
    private static final int Id_matchAll = 55;
    private static final int Id_normalize = 44;
    private static final int Id_padEnd = 48;
    private static final int Id_padStart = 47;
    private static final int Id_repeat = 45;
    private static final int Id_replace = 33;
    private static final int Id_replaceAll = 34;
    private static final int Id_search = 32;
    private static final int Id_slice = 15;
    private static final int Id_small = 20;
    private static final int Id_split = 9;
    private static final int Id_startsWith = 42;
    private static final int Id_strike = 19;
    private static final int Id_sub = 24;
    private static final int Id_substr = 13;
    private static final int Id_substring = 10;
    private static final int Id_sup = 23;
    private static final int Id_toLocaleLowerCase = 36;
    private static final int Id_toLocaleUpperCase = 37;
    private static final int Id_toLowerCase = 11;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_toUpperCase = 12;
    private static final int Id_toWellFormed = 54;
    private static final int Id_trim = 38;
    private static final int Id_trimEnd = 51;
    private static final int Id_trimLeft = 39;
    private static final int Id_trimRight = 40;
    private static final int Id_trimStart = 50;
    private static final int Id_valueOf = 4;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 55;
    private static final Object STRING_TAG = "String";
    private static final int SymbolId_iterator = 49;
    private static final long serialVersionUID = 920268368584188687L;
    private CharSequence string;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NativeString(CharSequence charSequence) {
        this.string = charSequence;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope != null) {
            this = parentScope;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, this, TopLevel.Builtins.Object);
        nativeObject.defineProperty(ES6Iterator.VALUE_PROPERTY, obj, 0);
        Boolean bool = Boolean.FALSE;
        nativeObject.defineProperty("writable", bool, 0);
        nativeObject.defineProperty("enumerable", Boolean.TRUE, 0);
        nativeObject.defineProperty("configurable", bool, 0);
        return nativeObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Scriptable scriptable, boolean z) {
        new NativeString("").exportAsJSClass(55, scriptable, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String js_concat(String str, Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.concat(ScriptRuntime.toString(objArr[0]));
        }
        int length2 = str.length();
        String[] strArr = new String[length];
        for (int i = 0; i != length; i++) {
            String string = ScriptRuntime.toString(objArr[i]);
            strArr[i] = string;
            length2 += string.length();
        }
        StringBuilder sb = new StringBuilder(length2);
        sb.append(str);
        for (int i2 = 0; i2 != length; i2++) {
            sb.append(strArr[i2]);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int js_indexOf(int i, String str, Object[] objArr) {
        int length;
        String string = ScriptRuntime.toString(objArr, 0);
        double integer = ScriptRuntime.toInteger(objArr, 1);
        if (i != 42 && i != 43 && string.length() == 0) {
            return integer > ((double) str.length()) ? str.length() : (int) integer;
        }
        if (i != 42 && i != 43 && integer > str.length()) {
            return -1;
        }
        if (integer < 0.0d) {
            integer = 0.0d;
        } else {
            if (integer > str.length()) {
                length = str.length();
            } else if (i == 43 && (Double.isNaN(integer) || integer > str.length())) {
                length = str.length();
            }
            integer = length;
        }
        if (43 != i) {
            return i == 42 ? str.startsWith(string, (int) integer) ? 0 : -1 : str.indexOf(string, (int) integer);
        }
        if (objArr.length == 0 || objArr.length == 1 || (objArr.length == 2 && objArr[1] == Undefined.instance)) {
            integer = str.length();
        }
        return str.substring(0, (int) integer).endsWith(string) ? 0 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int js_lastIndexOf(String str, Object[] objArr) {
        String string = ScriptRuntime.toString(objArr, 0);
        double number = ScriptRuntime.toNumber(objArr, 1);
        if (Double.isNaN(number) || number > str.length()) {
            number = str.length();
        } else if (number < 0.0d) {
            number = 0.0d;
        }
        return str.lastIndexOf(string, (int) number);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v4 java.lang.String, still in use, count: 2, list:
          (r7v4 java.lang.String) from 0x002a: INVOKE (r7v4 java.lang.String) VIRTUAL call: java.lang.String.length():int A[MD:():int (c), WRAPPED] (LINE:43)
          (r7v4 java.lang.String) from 0x0033: PHI (r7v2 java.lang.String) = (r7v4 java.lang.String) binds: [B:10:0x002e] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:126)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    private static java.lang.String js_pad(org.mozilla.javascript.Context r4, org.mozilla.javascript.Scriptable r5, org.mozilla.javascript.IdFunctionObject r6, java.lang.Object[] r7, boolean r8) {
        /*
            java.lang.Object r4 = org.mozilla.javascript.ScriptRuntimeES6.requireObjectCoercible(r4, r5, r6)
            java.lang.String r4 = org.mozilla.javascript.ScriptRuntime.toString(r4)
            r5 = 0
            long r0 = org.mozilla.javascript.ScriptRuntime.toLength(r7, r5)
            int r6 = r4.length()
            long r2 = (long) r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 > 0) goto L17
            goto L30
        L17:
            int r6 = r7.length
            r2 = 2
            if (r6 < r2) goto L31
            r6 = 1
            r2 = r7[r6]
            boolean r2 = org.mozilla.javascript.Undefined.isUndefined(r2)
            if (r2 != 0) goto L31
            r7 = r7[r6]
            java.lang.String r7 = org.mozilla.javascript.ScriptRuntime.toString(r7)
            int r2 = r7.length()
            if (r2 >= r6) goto L33
        L30:
            return r4
        L31:
            java.lang.String r7 = " "
        L33:
            int r6 = r4.length()
            long r2 = (long) r6
            long r0 = r0 - r2
            int r6 = (int) r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L3f:
            r0.append(r7)
            int r1 = r0.length()
            if (r1 < r6) goto L3f
            r0.setLength(r6)
            if (r8 == 0) goto L55
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            return r4
        L55:
            java.lang.StringBuilder r4 = r0.insert(r5, r4)
            java.lang.String r4 = r4.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.js_pad(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.IdFunctionObject, java.lang.Object[], boolean):java.lang.String");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static CharSequence js_raw(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.getObjectProp(ScriptRuntime.toObject(context, scriptable, objArr.length > 0 ? objArr[0] : Undefined.instance), "raw", context));
        long lengthProperty = NativeArray.getLengthProperty(context, object);
        if (lengthProperty > 2147483647L) {
            throw ScriptRuntime.rangeError("raw.length > 2147483647");
        }
        int i2 = (int) lengthProperty;
        if (i2 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(ScriptRuntime.toString(ScriptRuntime.getObjectIndex(object, i, context)));
            i++;
            if (i == i2) {
                return sb;
            }
            if (objArr.length > i) {
                sb.append(ScriptRuntime.toString(objArr[i]));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String js_repeat(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        String string = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable, idFunctionObject));
        double integer = ScriptRuntime.toInteger(objArr, 0);
        if (integer < 0.0d || integer == Double.POSITIVE_INFINITY) {
            throw ScriptRuntime.rangeError("Invalid count value");
        }
        if (integer == 0.0d || string.length() == 0) {
            return "";
        }
        long length = ((long) string.length()) * ((long) integer);
        if (integer > 2.147483647E9d || length > 2147483647L) {
            throw ScriptRuntime.rangeError("Invalid size or count value");
        }
        StringBuilder sb = new StringBuilder((int) length);
        sb.append(string);
        int i = (int) integer;
        int i2 = 1;
        while (i2 <= i / 2) {
            sb.append((CharSequence) sb);
            i2 *= 2;
        }
        if (i2 < i) {
            sb.append(sb.substring(0, string.length() * (i - i2)));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[PHI: r6
      0x003f: PHI (r6v4 double) = (r6v3 double), (r6v5 double) binds: [B:26:0x0044, B:22:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static CharSequence js_slice(CharSequence charSequence, Object[] objArr) {
        Object obj;
        double d = 0.0d;
        double integer = objArr.length < 1 ? 0.0d : ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        if (integer < 0.0d) {
            integer += (double) length;
            if (integer < 0.0d) {
                integer = 0.0d;
            }
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length < 2 || (obj = objArr[1]) == Undefined.instance) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(obj);
            if (integer2 < 0.0d) {
                integer2 += (double) length;
                if (integer2 >= 0.0d) {
                    d = integer2;
                }
                if (d < integer) {
                    d = integer;
                }
            } else {
                d = length;
                if (integer2 <= d) {
                }
                if (d < integer) {
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static CharSequence js_substr(CharSequence charSequence, Object[] objArr) {
        if (objArr.length < 1) {
            return charSequence;
        }
        double integer = ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        if (integer < 0.0d) {
            integer += (double) length;
            if (integer < 0.0d) {
                integer = 0.0d;
            }
        } else {
            double d = length;
            if (integer > d) {
                integer = d;
            }
        }
        double d2 = length;
        if (objArr.length > 1) {
            Object obj = objArr[1];
            if (!Undefined.isUndefined(obj)) {
                double integer2 = ScriptRuntime.toInteger(obj);
                double d3 = (integer2 >= 0.0d ? integer2 : 0.0d) + integer;
                if (d3 <= d2) {
                    d2 = d3;
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static CharSequence js_substring(Context context, CharSequence charSequence, Object[] objArr) {
        Object obj;
        int length = charSequence.length();
        double integer = ScriptRuntime.toInteger(objArr, 0);
        double d = 0.0d;
        if (integer < 0.0d) {
            integer = 0.0d;
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length <= 1 || (obj = objArr[1]) == Undefined.instance) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(obj);
            if (integer2 >= 0.0d) {
                d = length;
                if (integer2 <= d) {
                    d = integer2;
                }
            }
            if (d < integer) {
                if (context.getLanguageVersion() != 120) {
                    double d3 = d;
                    d = integer;
                    integer = d3;
                } else {
                    d = integer;
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeString realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        return (NativeString) IdScriptableObject.ensureType(scriptable, NativeString.class, idFunctionObject);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String tagify(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, String str, String str2, Object[] objArr) {
        String string = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable, idFunctionObject));
        StringBuilder sb = new StringBuilder("<");
        sb.append(str);
        if (str2 != null && str2.length() > 0) {
            String strReplace = ScriptRuntime.toString(objArr, 0).replace("\"", "&quot;");
            sb.append(' ');
            sb.append(str2);
            sb.append("=\"");
            sb.append(strReplace);
            sb.append('\"');
        }
        sb.append('>');
        sb.append(string);
        sb.append("</");
        sb.append(str);
        sb.append('>');
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object;
        int i;
        RegExpProxy regExpProxy;
        if (!idFunctionObject.hasTag(STRING_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        Scriptable scriptable3 = scriptable2;
        Object[] objArr2 = objArr;
        while (iMethodId != ConstructorId_raw) {
            String str = "";
            int i2 = 1;
            int i3 = 0;
            if (iMethodId == ConstructorId_fromCodePoint) {
                int length = objArr2.length;
                if (length < 1) {
                    return "";
                }
                int[] iArr = new int[length];
                for (int i4 = 0; i4 != length; i4++) {
                    Object obj = objArr2[i4];
                    int int32 = ScriptRuntime.toInt32(obj);
                    if (!ScriptRuntime.eqNumber(ScriptRuntime.toNumber(obj), Integer.valueOf(int32)) || !Character.isValidCodePoint(int32)) {
                        throw ScriptRuntime.rangeError("Invalid code point " + ScriptRuntime.toString(obj));
                    }
                    iArr[i4] = int32;
                }
                return new String(iArr, 0, length);
            }
            if (iMethodId == -1) {
                int length2 = objArr2.length;
                if (length2 < 1) {
                    return "";
                }
                char[] cArr = new char[length2];
                while (i3 != length2) {
                    cArr[i3] = ScriptRuntime.toUint16(objArr2[i3]);
                    i3++;
                }
                return new String(cArr);
            }
            switch (iMethodId) {
                case ConstructorId_toLocaleLowerCase /* -36 */:
                case ConstructorId_localeCompare /* -35 */:
                case ConstructorId_replaceAll /* -34 */:
                case ConstructorId_replace /* -33 */:
                case ConstructorId_search /* -32 */:
                case ConstructorId_match /* -31 */:
                case ConstructorId_equalsIgnoreCase /* -30 */:
                    break;
                default:
                    switch (iMethodId) {
                        case ConstructorId_slice /* -15 */:
                        case ConstructorId_concat /* -14 */:
                        case ConstructorId_substr /* -13 */:
                        case ConstructorId_toUpperCase /* -12 */:
                        case ConstructorId_toLowerCase /* -11 */:
                        case ConstructorId_substring /* -10 */:
                        case ConstructorId_split /* -9 */:
                        case ConstructorId_lastIndexOf /* -8 */:
                        case ConstructorId_indexOf /* -7 */:
                        case ConstructorId_charCodeAt /* -6 */:
                        case ConstructorId_charAt /* -5 */:
                            break;
                        default:
                            switch (iMethodId) {
                                case 1:
                                    CharSequence charSequence = str;
                                    if (objArr2.length != 0) {
                                        charSequence = (!ScriptRuntime.isSymbol(objArr2[0]) || scriptable3 == null) ? ScriptRuntime.toCharSequence(objArr2[0]) : objArr2[0].toString();
                                    }
                                    return scriptable3 == null ? new NativeString(charSequence) : charSequence instanceof String ? charSequence : charSequence.toString();
                                case 2:
                                case 4:
                                    CharSequence charSequence2 = realThis(scriptable3, idFunctionObject).string;
                                    return charSequence2 instanceof String ? charSequence2 : charSequence2.toString();
                                case 3:
                                    return "(new String(\"" + ScriptRuntime.escapeString(realThis(scriptable3, idFunctionObject).string.toString()) + "\"))";
                                case 5:
                                case 6:
                                    CharSequence charSequence3 = ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    double integer = ScriptRuntime.toInteger(objArr2, 0);
                                    if (integer < 0.0d || integer >= charSequence3.length()) {
                                        return iMethodId == 5 ? "" : ScriptRuntime.NaNobj;
                                    }
                                    char cCharAt = charSequence3.charAt((int) integer);
                                    return iMethodId == 5 ? String.valueOf(cCharAt) : ScriptRuntime.wrapInt(cCharAt);
                                case 7:
                                    return ScriptRuntime.wrapInt(js_indexOf(7, ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2));
                                case 8:
                                    return ScriptRuntime.wrapInt(js_lastIndexOf(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2));
                                case 9:
                                    return ScriptRuntime.checkRegExpProxy(context).js_split(context, scriptable, ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2);
                                case 10:
                                    return js_substring(context, ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2);
                                case 11:
                                    return ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)).toLowerCase(Locale.ROOT);
                                case 12:
                                    return ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)).toUpperCase(Locale.ROOT);
                                case 13:
                                    return js_substr(ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2);
                                case 14:
                                    return js_concat(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2);
                                case 15:
                                    return js_slice(ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), objArr2);
                                case 16:
                                    return tagify(context, scriptable3, idFunctionObject, "b", null, null);
                                case 17:
                                    return tagify(context, scriptable3, idFunctionObject, "i", null, null);
                                case 18:
                                    return tagify(context, scriptable3, idFunctionObject, "tt", null, null);
                                case 19:
                                    return tagify(context, scriptable3, idFunctionObject, "strike", null, null);
                                case 20:
                                    return tagify(context, scriptable3, idFunctionObject, "small", null, null);
                                case 21:
                                    return tagify(context, scriptable3, idFunctionObject, "big", null, null);
                                case 22:
                                    return tagify(context, scriptable3, idFunctionObject, "blink", null, null);
                                case 23:
                                    return tagify(context, scriptable3, idFunctionObject, "sup", null, null);
                                case 24:
                                    return tagify(context, scriptable3, idFunctionObject, "sub", null, null);
                                case 25:
                                    return tagify(context, scriptable3, idFunctionObject, "font", "size", objArr2);
                                case 26:
                                    return tagify(context, scriptable3, idFunctionObject, "font", "color", objArr2);
                                case 27:
                                    return tagify(context, scriptable3, idFunctionObject, "a", "href", objArr2);
                                case 28:
                                    return tagify(context, scriptable3, idFunctionObject, "a", "name", objArr2);
                                case 29:
                                case 30:
                                    String string = ScriptRuntime.toString(scriptable3);
                                    String string2 = ScriptRuntime.toString(objArr2, 0);
                                    return ScriptRuntime.wrapBoolean(iMethodId == 29 ? string.equals(string2) : string.equalsIgnoreCase(string2));
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                    if (iMethodId != 31) {
                                        if (iMethodId == 32) {
                                            i2 = 4;
                                        } else if (iMethodId == 33) {
                                            i2 = 2;
                                        } else {
                                            i = 3;
                                        }
                                        i = i2;
                                    } else {
                                        i = i2;
                                    }
                                    ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject);
                                    return ScriptRuntime.checkRegExpProxy(context).action(context, scriptable, scriptable3, objArr2, i);
                                case 35:
                                    String string3 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    Collator collator = Collator.getInstance(context.getLocale());
                                    collator.setStrength(3);
                                    collator.setDecomposition(1);
                                    return ScriptRuntime.wrapNumber(collator.compare(string3, ScriptRuntime.toString(objArr2, 0)));
                                case 36:
                                    String string4 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    Locale locale = context.getLocale();
                                    if (objArr2.length > 0 && context.hasFeature(22)) {
                                        locale = new Locale(ScriptRuntime.toString(objArr2[0]));
                                    }
                                    return string4.toLowerCase(locale);
                                case 37:
                                    String string5 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    Locale locale2 = context.getLocale();
                                    if (objArr2.length > 0 && context.hasFeature(22)) {
                                        locale2 = new Locale(ScriptRuntime.toString(objArr2[0]));
                                    }
                                    return string5.toUpperCase(locale2);
                                case 38:
                                    String string6 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    char[] charArray = string6.toCharArray();
                                    while (i3 < charArray.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[i3])) {
                                        i3++;
                                    }
                                    int length3 = charArray.length;
                                    while (length3 > i3 && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[length3 - 1])) {
                                        length3--;
                                    }
                                    return string6.substring(i3, length3);
                                case 39:
                                case 50:
                                    String string7 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    char[] charArray2 = string7.toCharArray();
                                    while (i3 < charArray2.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray2[i3])) {
                                        i3++;
                                    }
                                    return string7.substring(i3, charArray2.length);
                                case 40:
                                case 51:
                                    String string8 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    char[] charArray3 = string8.toCharArray();
                                    int length4 = charArray3.length;
                                    while (length4 > 0 && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray3[length4 - 1])) {
                                        length4--;
                                    }
                                    return string8.substring(0, length4);
                                case 41:
                                case 42:
                                case 43:
                                    String string9 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    if (objArr2.length > 0 && (regExpProxy = ScriptRuntime.getRegExpProxy(context)) != null) {
                                        Object obj2 = objArr2[0];
                                        if (obj2 instanceof Scriptable) {
                                            Scriptable scriptable4 = (Scriptable) obj2;
                                            if (regExpProxy.isRegExp(scriptable4) && ScriptableObject.isTrue(ScriptableObject.getProperty(scriptable4, SymbolKey.MATCH))) {
                                                throw ScriptRuntime.typeErrorById("msg.first.arg.not.regexp", String.class.getSimpleName(), idFunctionObject.getFunctionName());
                                            }
                                        }
                                    }
                                    int iJs_indexOf = js_indexOf(iMethodId, string9, objArr2);
                                    if (iMethodId == 41) {
                                        return Boolean.valueOf(iJs_indexOf != -1);
                                    }
                                    if (iMethodId == 42) {
                                        return Boolean.valueOf(iJs_indexOf == 0);
                                    }
                                    if (iMethodId == 43) {
                                        return Boolean.valueOf(iJs_indexOf != -1);
                                    }
                                    break;
                                case 44:
                                    if (objArr2.length == 0 || Undefined.isUndefined(objArr2[0])) {
                                        return Normalizer.normalize(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), Normalizer.Form.NFC);
                                    }
                                    String string10 = ScriptRuntime.toString(objArr2, 0);
                                    Normalizer.Form form = Normalizer.Form.NFD;
                                    if (!form.name().equals(string10)) {
                                        form = Normalizer.Form.NFKC;
                                        if (!form.name().equals(string10)) {
                                            form = Normalizer.Form.NFKD;
                                            if (!form.name().equals(string10)) {
                                                form = Normalizer.Form.NFC;
                                                if (!form.name().equals(string10)) {
                                                    throw ScriptRuntime.rangeError("The normalization form should be one of 'NFC', 'NFD', 'NFKC', 'NFKD'.");
                                                }
                                            }
                                        }
                                    }
                                    return Normalizer.normalize(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), form);
                                case 45:
                                    return js_repeat(context, scriptable3, idFunctionObject, objArr2);
                                case 46:
                                    String string11 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    double integer2 = ScriptRuntime.toInteger(objArr2, 0);
                                    return (integer2 < 0.0d || integer2 >= ((double) string11.length())) ? Undefined.instance : Integer.valueOf(string11.codePointAt((int) integer2));
                                case 47:
                                case 48:
                                    break;
                                case 49:
                                    return new NativeStringIterator(scriptable, ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                case 52:
                                    String string12 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    Object obj3 = objArr2.length >= 1 ? objArr2[0] : Undefined.instance;
                                    int length5 = string12.length();
                                    int integer3 = (int) ScriptRuntime.toInteger(obj3);
                                    if (integer3 < 0) {
                                        integer3 += length5;
                                    }
                                    return (integer3 < 0 || integer3 >= length5) ? Undefined.instance : string12.substring(integer3, integer3 + 1);
                                case 53:
                                    CharSequence charSequence4 = ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    int length6 = charSequence4.length();
                                    boolean z = false;
                                    for (int i5 = 0; i5 < length6; i5++) {
                                        char cCharAt2 = charSequence4.charAt(i5);
                                        if (NativeJSON.isLeadingSurrogate(cCharAt2)) {
                                            if (z) {
                                                return Boolean.FALSE;
                                            }
                                            z = true;
                                        } else if (NativeJSON.isTrailingSurrogate(cCharAt2)) {
                                            if (!z) {
                                                return Boolean.FALSE;
                                            }
                                            z = false;
                                        } else if (z) {
                                            return Boolean.FALSE;
                                        }
                                    }
                                    return Boolean.valueOf(!z);
                                case 54:
                                    CharSequence charSequence5 = ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    HashMap map = new HashMap();
                                    int length7 = charSequence5.length();
                                    int i6 = -1;
                                    int i7 = 0;
                                    char c = 0;
                                    while (i7 < length7) {
                                        char cCharAt3 = charSequence5.charAt(i7);
                                        if (NativeJSON.isLeadingSurrogate(c) && NativeJSON.isTrailingSurrogate(cCharAt3)) {
                                            Integer numValueOf = Integer.valueOf(i7 - 1);
                                            Boolean bool = Boolean.TRUE;
                                            map.put(numValueOf, bool);
                                            map.put(Integer.valueOf(i7), bool);
                                        } else if (NativeJSON.isLeadingSurrogate(cCharAt3) || NativeJSON.isTrailingSurrogate(cCharAt3)) {
                                            map.put(Integer.valueOf(i7), Boolean.FALSE);
                                            if (i6 == -1) {
                                                i6 = i7;
                                            }
                                        }
                                        i7++;
                                        c = cCharAt3;
                                    }
                                    if (map.isEmpty()) {
                                        return charSequence5.toString();
                                    }
                                    StringBuilder sb = new StringBuilder(charSequence5.subSequence(0, i6));
                                    while (i6 < length7) {
                                        char cCharAt4 = charSequence5.charAt(i6);
                                        Boolean bool2 = (Boolean) map.get(Integer.valueOf(i6));
                                        if (bool2 == null || bool2.booleanValue()) {
                                            sb.append(cCharAt4);
                                        } else {
                                            sb.append(Utf8.REPLACEMENT_CHARACTER);
                                        }
                                        i6++;
                                    }
                                    return sb.toString();
                                case Token.THROW /* 55 */:
                                    Object objRequireObjectCoercible = ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject);
                                    Object obj4 = objArr2.length > 0 ? objArr2[0] : Undefined.instance;
                                    RegExpProxy regExpProxyCheckRegExpProxy = ScriptRuntime.checkRegExpProxy(context);
                                    if (obj4 != null && !Undefined.isUndefined(obj4)) {
                                        if ((obj4 instanceof Scriptable) && regExpProxyCheckRegExpProxy.isRegExp((Scriptable) obj4)) {
                                            Object objectProp = ScriptRuntime.getObjectProp(obj4, "flags", context, scriptable);
                                            ScriptRuntimeES6.requireObjectCoercible(context, objectProp, idFunctionObject);
                                            if (!ScriptRuntime.toString(objectProp).contains("g")) {
                                                throw ScriptRuntime.typeErrorById("msg.str.match.all.no.global.flag", new Object[0]);
                                            }
                                        }
                                        SymbolKey symbolKey = SymbolKey.MATCH_ALL;
                                        Object objectElem = ScriptRuntime.getObjectElem(obj4, symbolKey, context, scriptable);
                                        if (objectElem != null && !Undefined.isUndefined(objectElem)) {
                                            if (objectElem instanceof Callable) {
                                                return ((Callable) objectElem).call(context, scriptable, ScriptRuntime.toObject(scriptable, obj4), new Object[]{objRequireObjectCoercible});
                                            }
                                            throw ScriptRuntime.notFunctionError(obj4, objectElem, symbolKey.getName());
                                        }
                                    }
                                    String string13 = ScriptRuntime.toString(objRequireObjectCoercible);
                                    String string14 = str;
                                    if (!Undefined.isUndefined(obj4)) {
                                        string14 = ScriptRuntime.toString(obj4);
                                    }
                                    Scriptable scriptableWrapRegExp = regExpProxyCheckRegExpProxy.wrapRegExp(context, scriptable, regExpProxyCheckRegExpProxy.compileRegExp(context, string14, "g"));
                                    SymbolKey symbolKey2 = SymbolKey.MATCH_ALL;
                                    Object objectElem2 = ScriptRuntime.getObjectElem(scriptableWrapRegExp, symbolKey2, context, scriptable);
                                    if (objectElem2 instanceof Callable) {
                                        return ((Callable) objectElem2).call(context, scriptable, scriptableWrapRegExp, new Object[]{string13});
                                    }
                                    throw ScriptRuntime.notFunctionError(scriptableWrapRegExp, objectElem2, symbolKey2.getName());
                                default:
                                    nl.a("String.prototype has no method: ", idFunctionObject.getFunctionName());
                                    return null;
                            }
                            return js_pad(context, scriptable3, idFunctionObject, objArr2, iMethodId == 47);
                    }
                    while (iMethodId != ConstructorId_raw) {
                    }
                    break;
            }
            if (objArr2.length > 0) {
                object = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.toCharSequence(objArr2[0]));
                int length8 = objArr2.length - 1;
                Object[] objArr3 = new Object[length8];
                System.arraycopy(objArr2, 1, objArr3, 0, length8);
                objArr2 = objArr3;
            } else {
                object = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.toCharSequence(scriptable3));
            }
            scriptable3 = object;
            iMethodId = -iMethodId;
        }
        return js_raw(context, scriptable, objArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = STRING_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "fromCharCode", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_fromCodePoint, "fromCodePoint", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_raw, "raw", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_charAt, "charAt", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_charCodeAt, "charCodeAt", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_indexOf, "indexOf", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_lastIndexOf, "lastIndexOf", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_split, "split", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_substring, "substring", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toLowerCase, "toLowerCase", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toUpperCase, "toUpperCase", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_substr, "substr", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_concat, "concat", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_slice, "slice", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_equalsIgnoreCase, "equalsIgnoreCase", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_match, "match", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_search, "search", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_replace, "replace", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_replaceAll, "replaceAll", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_localeCompare, "localeCompare", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toLocaleLowerCase, "toLocaleLowerCase", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return str.equals(Name.LENGTH) ? IdScriptableObject.instanceIdInfo(7, 1) : super.findInstanceIdInfo(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "toSource":
                return 3;
            case "toString":
                return 2;
            case "constructor":
                return 1;
            case "startsWith":
                return 42;
            case "fontcolor":
                return 26;
            case "toLocaleLowerCase":
                return 36;
            case "anchor":
                return 28;
            case "charAt":
                return 5;
            case "concat":
                return 14;
            case "codePointAt":
                return 46;
            case "equals":
                return 29;
            case "replaceAll":
                return 34;
            case "toLowerCase":
                return 11;
            case "trimEnd":
                return 51;
            case "padEnd":
                return 48;
            case "repeat":
                return 45;
            case "search":
                return 32;
            case "strike":
                return 19;
            case "substr":
                return 13;
            case "toLocaleUpperCase":
                return 37;
            case "trimRight":
                return 40;
            case "trimStart":
                return 50;
            case "lastIndexOf":
                return 8;
            case "toUpperCase":
                return 12;
            case "at":
                return 52;
            case "big":
                return 21;
            case "sub":
                return 24;
            case "sup":
                return 23;
            case "bold":
                return 16;
            case "link":
                return 27;
            case "trim":
                return 38;
            case "includes":
                return 41;
            case "blink":
                return 22;
            case "fixed":
                return 18;
            case "match":
                return 31;
            case "slice":
                return 15;
            case "small":
                return 20;
            case "split":
                return 9;
            case "valueOf":
                return 4;
            case "normalize":
                return 44;
            case "equalsIgnoreCase":
                return 30;
            case "matchAll":
                return 55;
            case "fontsize":
                return 25;
            case "charCodeAt":
                return 6;
            case "substring":
                return 10;
            case "padStart":
                return 47;
            case "isWellFormed":
                return 53;
            case "toWellFormed":
                return 54;
            case "localeCompare":
                return 35;
            case "replace":
                return 33;
            case "trimLeft":
                return 39;
            case "endsWith":
                return 43;
            case "indexOf":
                return 7;
            case "italics":
                return 17;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return (i < 0 || i >= this.string.length()) ? super.get(i, scriptable) : String.valueOf(this.string.charAt(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        return (i < 0 || i >= this.string.length()) ? super.getAttributes(i) : Context.getContext().getLanguageVersion() < 200 ? 7 : 5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "String";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.getLanguageVersion() < 200) {
            return super.getIds(z, z2);
        }
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = new Object[ids.length + this.string.length()];
        int i = 0;
        while (i < this.string.length()) {
            objArr[i] = Integer.valueOf(i);
            i++;
        }
        System.arraycopy(ids, 0, objArr, i, ids.length);
        return objArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i == 1 ? Name.LENGTH : super.getInstanceIdName(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapInt(this.string.length()) : super.getInstanceIdValue(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLength() {
        return this.string.length();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int i;
        if (!(obj instanceof Symbol) && context != null && context.getLanguageVersion() >= 200) {
            ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(obj);
            if (stringIdOrIndex.stringId == null && (i = stringIdOrIndex.index) >= 0 && i < this.string.length()) {
                return defaultIndexPropertyDescriptor(String.valueOf(this.string.charAt(stringIdOrIndex.index)));
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (i < 0 || i >= this.string.length()) {
            return super.has(i, scriptable);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        if (i == 49) {
            initPrototypeMethod(STRING_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
        }
        switch (i) {
            case 1:
                str = "constructor";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 2:
                str2 = "toString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 3:
                str2 = "toSource";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 4:
                str2 = "valueOf";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 5:
                str = "charAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 6:
                str = "charCodeAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 7:
                str = "indexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 8:
                str = "lastIndexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 9:
                str3 = "split";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 10:
                str3 = "substring";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 11:
                str2 = "toLowerCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 12:
                str2 = "toUpperCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 13:
                str3 = "substr";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 14:
                str = "concat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 15:
                str3 = "slice";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 16:
                str2 = "bold";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 17:
                str2 = "italics";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 18:
                str2 = "fixed";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 19:
                str2 = "strike";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 20:
                str2 = "small";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 21:
                str2 = "big";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 22:
                str2 = "blink";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 23:
                str2 = "sup";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 24:
                str2 = "sub";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 25:
                str2 = "fontsize";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 26:
                str2 = "fontcolor";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 27:
                str2 = "link";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 28:
                str2 = "anchor";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 29:
                str = "equals";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 30:
                str = "equalsIgnoreCase";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 31:
                str = "match";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 32:
                str = "search";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 33:
                str3 = "replace";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 34:
                str3 = "replaceAll";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 35:
                str = "localeCompare";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 36:
                str2 = "toLocaleLowerCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 37:
                str2 = "toLocaleUpperCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 38:
                str2 = "trim";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 39:
                str2 = "trimLeft";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 40:
                str2 = "trimRight";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 41:
                str = "includes";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 42:
                str = "startsWith";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 43:
                str = "endsWith";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 44:
                str2 = "normalize";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 45:
                str = "repeat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 46:
                str = "codePointAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 47:
                str = "padStart";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 48:
                str = "padEnd";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 49:
            default:
                jl.a(String.valueOf(i));
                break;
            case 50:
                str2 = "trimStart";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 51:
                str2 = "trimEnd";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 52:
                str = "at";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 53:
                str2 = "isWellFormed";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case 54:
                str2 = "toWellFormed";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
            case Token.THROW /* 55 */:
                str = "matchAll";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.string.length()) {
            super.put(i, scriptable, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence toCharSequence() {
        return this.string;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        CharSequence charSequence = this.string;
        return charSequence instanceof String ? (String) charSequence : charSequence.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 49 : 0;
    }
}
