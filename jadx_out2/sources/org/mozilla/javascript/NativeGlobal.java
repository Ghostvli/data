package org.mozilla.javascript;

import java.io.Serializable;
import okio.Utf8;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.xml.XMLLib;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeGlobal implements Serializable, IdFunctionCall {
    private static final Object FTAG = "Global";
    private static final int INVALID_UTF8 = Integer.MAX_VALUE;
    private static final int Id_decodeURI = 1;
    private static final int Id_decodeURIComponent = 2;
    private static final int Id_encodeURI = 3;
    private static final int Id_encodeURIComponent = 4;
    private static final int Id_escape = 5;
    private static final int Id_eval = 6;
    private static final int Id_isFinite = 7;
    private static final int Id_isNaN = 8;
    private static final int Id_isXMLName = 9;
    private static final int Id_new_AggregateError = 15;
    private static final int Id_new_CommonError = 14;
    private static final int Id_parseFloat = 10;
    private static final int Id_parseInt = 11;
    private static final int Id_unescape = 12;
    private static final int Id_uneval = 13;
    private static final int LAST_SCOPE_FUNCTION_ID = 13;
    private static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    static final long serialVersionUID = 6080442165748707530L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable, String str3, int i, int i2, String str4) {
        return ScriptRuntime.constructError(str, str2, str3, i, str4, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[PHI: r6 r8
      0x0040: PHI (r6v5 int) = (r6v1 int), (r6v2 int) binds: [B:16:0x003e, B:62:0x00d0] A[DONT_GENERATE, DONT_INLINE]
      0x0040: PHI (r8v22 int) = (r8v2 int), (r8v10 int) binds: [B:16:0x003e, B:62:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String decode(String str, boolean z) {
        int i;
        int i2;
        char c;
        int length = str.length();
        char[] cArr = null;
        int i3 = 0;
        int i4 = 0;
        while (i3 != length) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '%') {
                if (cArr != null) {
                    cArr[i4] = cCharAt;
                    i4++;
                }
                i3++;
            } else {
                if (cArr == null) {
                    cArr = new char[length];
                    str.getChars(0, i3, cArr, 0);
                    i4 = i3;
                }
                int i5 = i3 + 3;
                if (i5 > length) {
                    throw uriError();
                }
                int iUnHex = unHex(str.charAt(i3 + 1), str.charAt(i3 + 2));
                if (iUnHex < 0) {
                    throw uriError();
                }
                if ((iUnHex & 128) != 0) {
                    if ((iUnHex & 192) == 128) {
                        throw uriError();
                    }
                    if ((iUnHex & 32) == 0) {
                        iUnHex &= 31;
                        i = 1;
                        i2 = 128;
                    } else if ((iUnHex & 16) == 0) {
                        iUnHex &= 15;
                        i = 2;
                        i2 = 2048;
                    } else if ((iUnHex & 8) == 0) {
                        iUnHex &= 7;
                        i = 3;
                        i2 = 65536;
                    } else if ((iUnHex & 4) == 0) {
                        iUnHex &= 3;
                        i = 4;
                        i2 = 2097152;
                    } else {
                        if ((iUnHex & 2) != 0) {
                            throw uriError();
                        }
                        iUnHex &= 1;
                        i = 5;
                        i2 = 67108864;
                    }
                    if ((i * 3) + i5 > length) {
                        throw uriError();
                    }
                    for (int i6 = 0; i6 != i; i6++) {
                        if (str.charAt(i5) != '%') {
                            throw uriError();
                        }
                        int iUnHex2 = unHex(str.charAt(i5 + 1), str.charAt(i5 + 2));
                        if (iUnHex2 < 0 || (iUnHex2 & 192) != 128) {
                            throw uriError();
                        }
                        iUnHex = (iUnHex << 6) | (iUnHex2 & 63);
                        i5 += 3;
                    }
                    if (iUnHex < i2 || (iUnHex >= 55296 && iUnHex <= 57343)) {
                        iUnHex = INVALID_UTF8;
                    } else if (iUnHex == 65534 || iUnHex == 65535) {
                        iUnHex = Utf8.REPLACEMENT_CODE_POINT;
                    }
                    if (iUnHex >= 65536) {
                        int i7 = iUnHex - 65536;
                        if (i7 > 1048575) {
                            throw uriError();
                        }
                        char c2 = (char) ((i7 >>> 10) + 55296);
                        char c3 = (char) ((i7 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        cArr[i4] = c2;
                        c = c3;
                        i4++;
                    } else {
                        c = (char) iUnHex;
                    }
                    if (!z || URI_DECODE_RESERVED.indexOf(c) < 0) {
                        cArr[i4] = c;
                        i4++;
                    } else {
                        while (i3 != i5) {
                            cArr[i4] = str.charAt(i3);
                            i3++;
                            i4++;
                        }
                    }
                    i3 = i5;
                }
            }
        }
        return cArr == null ? str : new String(cArr, 0, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x008c */
    private static String encode(String str, boolean z) {
        int length = str.length();
        StringBuilder sb = null;
        byte[] bArr = null;
        int i = 0;
        while (i != length) {
            char cCharAt = str.charAt(i);
            sb = sb;
            if (!encodeUnescaped(cCharAt, z)) {
                if (sb == null) {
                    StringBuilder sb2 = new StringBuilder(length + 3);
                    sb2.append(str);
                    sb2.setLength(i);
                    bArr = new byte[6];
                    sb = sb2;
                }
                if (56320 <= cCharAt && cCharAt <= 57343) {
                    throw uriError();
                }
                int i2 = cCharAt;
                if (cCharAt >= 55296) {
                    i2 = cCharAt;
                    if (56319 >= cCharAt) {
                        i++;
                        if (i == length) {
                            throw uriError();
                        }
                        char cCharAt2 = str.charAt(i);
                        if (56320 > cCharAt2 || cCharAt2 > 57343) {
                            throw uriError();
                        }
                        i2 = ((cCharAt - 55296) << 10) + (cCharAt2 - Utf8.LOG_SURROGATE_HEADER) + 65536;
                    }
                }
                int iOneUcs4ToUtf8Char = oneUcs4ToUtf8Char(bArr, i2);
                for (int i3 = 0; i3 < iOneUcs4ToUtf8Char; i3++) {
                    byte b = bArr[i3];
                    sb.append('%');
                    sb.append(toHexChar((b & 255) >>> 4));
                    sb.append(toHexChar(b & 15));
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i++;
            sb = sb;
        }
        return sb == null ? str : sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean encodeUnescaped(char c, boolean z) {
        if (('A' > c || c > 'Z') && (('a' > c || c > 'z') && (('0' > c || c > '9') && "-_.!~*'()".indexOf(c) < 0))) {
            return z && URI_DECODE_RESERVED.indexOf(c) >= 0;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void init(Context context, Scriptable scriptable, boolean z) {
        String str;
        String str2;
        int i;
        NativeGlobal nativeGlobal = new NativeGlobal();
        for (int i2 = 1; i2 <= 13; i2++) {
            switch (i2) {
                case 1:
                    str = "decodeURI";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                        idFunctionObject.sealObject();
                    }
                    idFunctionObject.exportAsScopeProperty();
                    break;
                case 2:
                    str = "decodeURIComponent";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject2 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject2.exportAsScopeProperty();
                    break;
                case 3:
                    str = "encodeURI";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject22 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject22.exportAsScopeProperty();
                    break;
                case 4:
                    str = "encodeURIComponent";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject222.exportAsScopeProperty();
                    break;
                case 5:
                    str = "escape";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject2222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject2222.exportAsScopeProperty();
                    break;
                case 6:
                    str = "eval";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject22222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject22222.exportAsScopeProperty();
                    break;
                case 7:
                    str = "isFinite";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject222222.exportAsScopeProperty();
                    break;
                case 8:
                    str = "isNaN";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject2222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject2222222.exportAsScopeProperty();
                    break;
                case 9:
                    str = "isXMLName";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject22222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject22222222.exportAsScopeProperty();
                    break;
                case 10:
                    str = "parseFloat";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject222222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject222222222.exportAsScopeProperty();
                    break;
                case 11:
                    str2 = "parseInt";
                    i = 2;
                    IdFunctionObject idFunctionObject2222222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject2222222222.exportAsScopeProperty();
                    break;
                case 12:
                    str = "unescape";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject22222222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject22222222222.exportAsScopeProperty();
                    break;
                case 13:
                    str = "uneval";
                    str2 = str;
                    i = 1;
                    IdFunctionObject idFunctionObject222222222222 = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
                    if (z) {
                    }
                    idFunctionObject222222222222.exportAsScopeProperty();
                    break;
                default:
                    throw Kit.codeBug();
            }
        }
        Scriptable scriptable2 = scriptable;
        ScriptableObject.defineProperty(scriptable2, "NaN", ScriptRuntime.NaNobj, 7);
        ScriptableObject.defineProperty(scriptable2, "Infinity", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        ScriptableObject.defineProperty(scriptable2, "undefined", Undefined.instance, 7);
        ScriptableObject.defineProperty(scriptable2, "globalThis", scriptable2, 2);
        Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(ScriptableObject.getProperty(scriptable2, "Error"));
        Scriptable scriptableEnsureScriptable2 = ScriptableObject.ensureScriptable(ScriptableObject.getProperty(scriptableEnsureScriptable, "prototype"));
        TopLevel.NativeErrors[] nativeErrorsArrValues = TopLevel.NativeErrors.values();
        int length = nativeErrorsArrValues.length;
        int i3 = 0;
        while (i3 < length) {
            TopLevel.NativeErrors nativeErrors = nativeErrorsArrValues[i3];
            if (nativeErrors != TopLevel.NativeErrors.Error) {
                String strName = nativeErrors.name();
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable2);
                NativeError nativeErrorMakeProto = NativeError.makeProto(topLevelScope, (IdFunctionObject) TopLevel.getBuiltinCtor(context, topLevelScope, TopLevel.Builtins.Error));
                nativeErrorMakeProto.defineProperty("name", strName, 2);
                nativeErrorMakeProto.defineProperty("message", "", 2);
                IdFunctionObject idFunctionObject3 = nativeErrors == TopLevel.NativeErrors.AggregateError ? new IdFunctionObject(nativeGlobal, FTAG, 15, strName, 2, scriptable2) : new IdFunctionObject(nativeGlobal, FTAG, 14, strName, 1, scriptable);
                idFunctionObject3.markAsConstructor(nativeErrorMakeProto);
                idFunctionObject3.setPrototype(scriptableEnsureScriptable);
                nativeErrorMakeProto.put("constructor", nativeErrorMakeProto, idFunctionObject3);
                nativeErrorMakeProto.setAttributes("constructor", 2);
                nativeErrorMakeProto.setPrototype(scriptableEnsureScriptable2);
                if (z) {
                    nativeErrorMakeProto.sealObject();
                    idFunctionObject3.sealObject();
                }
                idFunctionObject3.setAttributes("name", 3);
                idFunctionObject3.setAttributes(Name.LENGTH, 3);
                idFunctionObject3.exportAsScopeProperty();
            }
            i3++;
            scriptable2 = scriptable;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isEvalFunction(Object obj) {
        if (!(obj instanceof IdFunctionObject)) {
            return false;
        }
        IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
        return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r11 & (-8)) == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object js_escape(Object[] objArr) {
        int i;
        int i2;
        String string = ScriptRuntime.toString(objArr, 0);
        if (objArr.length > 1) {
            double number = ScriptRuntime.toNumber(objArr[1]);
            if (!Double.isNaN(number)) {
                i = (int) number;
                if (i == number) {
                }
            }
            throw Context.reportRuntimeErrorById("msg.bad.esc.mask", new Object[0]);
        }
        i = 7;
        int length = string.length();
        StringBuilder sb = null;
        for (int i3 = 0; i3 != length; i3++) {
            char cCharAt = string.charAt(i3);
            if (i == 0 || ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'Z') && !((cCharAt >= 'a' && cCharAt <= 'z') || cCharAt == '@' || cCharAt == '*' || cCharAt == '_' || cCharAt == '-' || cCharAt == '.' || ((i & 4) != 0 && (cCharAt == '/' || cCharAt == '+')))))) {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(string);
                    sb.setLength(i3);
                }
                if (cCharAt < 256) {
                    i2 = 2;
                    if (cCharAt == ' ' && i == 2) {
                        sb.append('+');
                    } else {
                        sb.append('%');
                    }
                } else {
                    sb.append('%');
                    sb.append('u');
                    i2 = 4;
                }
                for (int i4 = (i2 - 1) * 4; i4 >= 0; i4 -= 4) {
                    int i5 = (cCharAt >> i4) & 15;
                    sb.append((char) (i5 < 10 ? i5 + 48 : i5 + 55));
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb == null ? string : sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object js_eval(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        return ScriptRuntime.evalSpecial(context, topLevelScope, topLevelScope, objArr, "eval code", 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object js_parseFloat(Object[] objArr) {
        int i;
        if (objArr.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        boolean z = false;
        String string = ScriptRuntime.toString(objArr[0]);
        int length = string.length();
        for (int i2 = 0; i2 != length; i2++) {
            char cCharAt = string.charAt(i2);
            if (!ScriptRuntime.isStrWhiteSpaceChar(cCharAt)) {
                if (cCharAt == '+' || cCharAt == '-') {
                    int i3 = i2 + 1;
                    if (i3 == length) {
                        return ScriptRuntime.NaNobj;
                    }
                    i = i3;
                    cCharAt = string.charAt(i3);
                } else {
                    i = i2;
                }
                if (cCharAt == 'I') {
                    if (i + 8 > length || !string.regionMatches(i, "Infinity", 0, 8)) {
                        return ScriptRuntime.NaNobj;
                    }
                    return ScriptRuntime.wrapNumber(string.charAt(i2) == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                int i4 = -1;
                int i5 = -1;
                while (true) {
                    if (i < length) {
                        char cCharAt2 = string.charAt(i);
                        if (cCharAt2 != '+') {
                            if (cCharAt2 == 'E' || cCharAt2 == 'e') {
                                if (i4 == -1 && i != length - 1) {
                                    i4 = i;
                                    i++;
                                }
                            } else if (cCharAt2 != '-') {
                                if (cCharAt2 != '.') {
                                    switch (cCharAt2) {
                                        case '0':
                                        case Token.FALSE /* 49 */:
                                        case '2':
                                        case Token.SHEQ /* 51 */:
                                        case Token.SHNE /* 52 */:
                                        case Token.REGEXP /* 53 */:
                                        case Token.BINDNAME /* 54 */:
                                        case Token.THROW /* 55 */:
                                        case Token.RETHROW /* 56 */:
                                        case Token.IN /* 57 */:
                                            if (i4 != -1) {
                                                z = true;
                                            }
                                            break;
                                    }
                                    i++;
                                } else if (i5 == -1) {
                                    i5 = i;
                                    i++;
                                }
                            }
                        }
                        if (i4 == i - 1) {
                            if (i == length - 1) {
                                i--;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                if (i4 == -1 || z) {
                    i4 = i;
                }
                try {
                    return Double.valueOf(string.substring(i2, i4));
                } catch (NumberFormatException unused) {
                    return ScriptRuntime.NaNobj;
                }
            }
        }
        return ScriptRuntime.NaNobj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[PHI: r0
      0x002e: PHI (r0v1 boolean) = (r0v0 boolean), (r0v3 boolean) binds: [B:13:0x0025, B:17:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object js_parseInt(Context context, Object[] objArr) {
        char cCharAt;
        char cCharAt2;
        String string = ScriptRuntime.toString(objArr, 0);
        int int32 = ScriptRuntime.toInt32(objArr, 1);
        int length = string.length();
        if (length == 0) {
            return ScriptRuntime.NaNobj;
        }
        int i = 0;
        do {
            cCharAt = string.charAt(i);
            if (!ScriptRuntime.isStrWhiteSpaceChar(cCharAt)) {
                break;
            }
            i++;
        } while (i < length);
        if (cCharAt == '+') {
            i++;
        } else {
            z = cCharAt == '-';
            if (z) {
            }
        }
        int i2 = 16;
        if (int32 == 0) {
            int32 = -1;
        } else {
            if (int32 < 2 || int32 > 36) {
                return ScriptRuntime.NaNobj;
            }
            if (int32 == 16 && length - i > 1 && string.charAt(i) == '0' && ((cCharAt2 = string.charAt(i + 1)) == 'x' || cCharAt2 == 'X')) {
                i += 2;
            }
        }
        if (int32 != -1) {
            i2 = int32;
        } else if (length - i <= 1 || string.charAt(i) != '0') {
            i2 = 10;
        } else {
            int i3 = i + 1;
            char cCharAt3 = string.charAt(i3);
            if (cCharAt3 == 'x' || cCharAt3 == 'X') {
                i += 2;
            } else if ('0' <= cCharAt3 && cCharAt3 <= '9' && (context == null || context.getLanguageVersion() < 150)) {
                i2 = 8;
                i = i3;
            }
        }
        double dStringPrefixToNumber = ScriptRuntime.stringPrefixToNumber(string, i, i2);
        if (z) {
            dStringPrefixToNumber = -dStringPrefixToNumber;
        }
        return ScriptRuntime.wrapNumber(dStringPrefixToNumber);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object js_unescape(Object[] objArr) {
        int i;
        String string = ScriptRuntime.toString(objArr, 0);
        int iIndexOf = string.indexOf(37);
        if (iIndexOf < 0) {
            return string;
        }
        int length = string.length();
        char[] charArray = string.toCharArray();
        int i2 = iIndexOf;
        while (iIndexOf != length) {
            char c = charArray[iIndexOf];
            int i3 = iIndexOf + 1;
            if (c != '%' || i3 == length) {
                iIndexOf = i3;
            } else {
                if (charArray[i3] == 'u') {
                    i = iIndexOf + 2;
                    iIndexOf += 6;
                } else {
                    iIndexOf += 3;
                    i = i3;
                }
                if (iIndexOf <= length) {
                    int iXDigitToInt = 0;
                    while (i != iIndexOf) {
                        iXDigitToInt = Kit.xDigitToInt(charArray[i], iXDigitToInt);
                        i++;
                    }
                    if (iXDigitToInt >= 0) {
                        c = (char) iXDigitToInt;
                    }
                }
            }
            charArray[i2] = c;
            i2++;
        }
        return new String(charArray, 0, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int oneUcs4ToUtf8Char(byte[] bArr, int i) {
        if ((i & (-128)) == 0) {
            bArr[0] = (byte) i;
            return 1;
        }
        int i2 = i >>> 11;
        int i3 = 2;
        while (i2 != 0) {
            i2 >>>= 5;
            i3++;
        }
        int i4 = i3;
        while (true) {
            i4--;
            if (i4 <= 0) {
                bArr[0] = (byte) ((256 - (1 << (8 - i3))) + i);
                return i3;
            }
            bArr[i4] = (byte) ((i & 63) | 128);
            i >>>= 6;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static char toHexChar(int i) {
        if ((i >> 4) != 0) {
            Kit.codeBug();
        }
        return (char) (i < 10 ? i + 48 : i + 55);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int unHex(char c) {
        if ('A' <= c && c <= 'F') {
            return c - '7';
        }
        if ('a' <= c && c <= 'f') {
            return c - 'W';
        }
        if ('0' > c || c > '9') {
            return -1;
        }
        return c - '0';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessageById("msg.bad.uri", new Object[0]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG)) {
            int iMethodId = idFunctionObject.methodId();
            switch (iMethodId) {
                case 1:
                case 2:
                    return decode(ScriptRuntime.toString(objArr, 0), iMethodId == 1);
                case 3:
                case 4:
                    return encode(ScriptRuntime.toString(objArr, 0), iMethodId == 3);
                case 5:
                    return js_escape(objArr);
                case 6:
                    return js_eval(context, scriptable, objArr);
                case 7:
                    return objArr.length < 1 ? Boolean.FALSE : NativeNumber.isFinite(objArr[0]);
                case 8:
                    return ScriptRuntime.wrapBoolean(objArr.length >= 1 ? Double.isNaN(ScriptRuntime.toNumber(objArr[0])) : true);
                case 9:
                    return ScriptRuntime.wrapBoolean(XMLLib.extractFromScope(scriptable).isXMLName(context, objArr.length == 0 ? Undefined.instance : objArr[0]));
                case 10:
                    return js_parseFloat(objArr);
                case 11:
                    return js_parseInt(context, objArr);
                case 12:
                    return js_unescape(objArr);
                case 13:
                    return ScriptRuntime.uneval(context, scriptable, objArr.length != 0 ? objArr[0] : Undefined.instance);
                case 14:
                    return NativeError.make(context, scriptable, idFunctionObject, objArr);
                case 15:
                    return NativeError.makeAggregate(context, scriptable, idFunctionObject, objArr);
            }
        }
        throw idFunctionObject.unknown();
    }

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable) {
        return ScriptRuntime.constructError(str, str2);
    }

    private static int unHex(char c, char c2) {
        int iUnHex = unHex(c);
        int iUnHex2 = unHex(c2);
        if (iUnHex < 0 || iUnHex2 < 0) {
            return -1;
        }
        return (iUnHex << 4) | iUnHex2;
    }
}
