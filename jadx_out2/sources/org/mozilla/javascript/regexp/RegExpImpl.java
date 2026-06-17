package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.LazilyLoadedCtor;
import org.mozilla.javascript.RegExpProxy;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RegExpImpl implements RegExpProxy {
    protected String input;
    protected SubString lastMatch;
    protected SubString lastParen;
    protected SubString leftContext;
    protected boolean multiline;
    protected SubString[] parens;
    protected SubString rightContext;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeRegExp createRegExp(Context context, Scriptable scriptable, Object[] objArr, int i, boolean z) {
        Object obj;
        String string;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        if (objArr.length == 0 || (obj = objArr[0]) == Undefined.instance) {
            return NativeRegExpInstantiator.withLanguageVersionScopeCompiled(context.getLanguageVersion(), topLevelScope, NativeRegExp.compileRE(context, "", "", false));
        }
        if (obj instanceof NativeRegExp) {
            return (NativeRegExp) obj;
        }
        String string2 = ScriptRuntime.toString(obj);
        if (i < objArr.length) {
            objArr[0] = string2;
            string = ScriptRuntime.toString(objArr[i]);
        } else {
            string = null;
        }
        return NativeRegExpInstantiator.withLanguageVersionScopeCompiled(context.getLanguageVersion(), topLevelScope, NativeRegExp.compileRE(context, string2, string, z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void do_replace(GlobData globData, Context context, RegExpImpl regExpImpl) {
        int i;
        StringBuilder sb = globData.charBuf;
        String str = globData.repstr;
        int iIndexOf = globData.dollar;
        int i2 = 0;
        if (iIndexOf != -1) {
            int[] iArr = new int[1];
            int i3 = 0;
            do {
                sb.append((CharSequence) str, i3, iIndexOf);
                SubString subStringInterpretDollar = interpretDollar(context, regExpImpl, str, iIndexOf, iArr);
                if (subStringInterpretDollar != null) {
                    int i4 = subStringInterpretDollar.length;
                    if (i4 > 0) {
                        String str2 = subStringInterpretDollar.str;
                        int i5 = subStringInterpretDollar.index;
                        sb.append((CharSequence) str2, i5, i4 + i5);
                    }
                    int i6 = iArr[0];
                    int i7 = iIndexOf + i6;
                    i = iIndexOf + i6;
                    i3 = i7;
                } else {
                    i3 = iIndexOf;
                    i = iIndexOf + 1;
                }
                iIndexOf = str.indexOf(36, i);
            } while (iIndexOf >= 0);
            i2 = i3;
        }
        int length = str.length();
        if (length > i2) {
            sb.append((CharSequence) str, i2, length);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int find_split(Context context, Scriptable scriptable, String str, String str2, int i, RegExpProxy regExpProxy, Scriptable scriptable2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int iIndexOf;
        int i2 = iArr[0];
        int length = str.length();
        if (i == 120 && scriptable2 == null && str2.length() == 1 && str2.charAt(0) == ' ') {
            if (i2 == 0) {
                while (i2 < length && Character.isWhitespace(str.charAt(i2))) {
                    i2++;
                }
                iArr[0] = i2;
            }
            if (i2 == length) {
                return -1;
            }
            while (i2 < length && !Character.isWhitespace(str.charAt(i2))) {
                i2++;
            }
            int i3 = i2;
            while (i3 < length && Character.isWhitespace(str.charAt(i3))) {
                i3++;
            }
            iArr2[0] = i3 - i2;
            return i2;
        }
        if (i2 > length) {
            return -1;
        }
        if (scriptable2 != null) {
            return regExpProxy.find_split(context, scriptable, str, str2, scriptable2, iArr, iArr2, zArr, strArr);
        }
        if (i != 0 && i < 130 && length == 0) {
            return -1;
        }
        if (str2.length() != 0) {
            int i4 = iArr[0];
            return (i4 < length && (iIndexOf = str.indexOf(str2, i4)) != -1) ? iIndexOf : length;
        }
        if (i != 120) {
            if (i2 == length) {
                return -1;
            }
            return i2 + 1;
        }
        if (i2 != length) {
            return i2 + 1;
        }
        iArr2[0] = 1;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SubString interpretDollar(Context context, RegExpImpl regExpImpl, String str, int i, int[] iArr) {
        int length;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (str.charAt(i) != '$') {
            Kit.codeBug();
        }
        int languageVersion = context.getLanguageVersion();
        if ((languageVersion != 0 && languageVersion <= 140 && i > 0 && str.charAt(i - 1) == '\\') || (i2 = i + 1) >= (length = str.length())) {
            return null;
        }
        char cCharAt = str.charAt(i2);
        if (!NativeRegExp.isDigit(cCharAt)) {
            iArr[0] = 2;
            if (cCharAt == '$') {
                return new SubString("$");
            }
            if (cCharAt == '+') {
                return regExpImpl.lastParen;
            }
            if (cCharAt != '`') {
                if (cCharAt == '&') {
                    return regExpImpl.lastMatch;
                }
                if (cCharAt != '\'') {
                    return null;
                }
                return regExpImpl.rightContext;
            }
            if (languageVersion == 120) {
                SubString subString = regExpImpl.leftContext;
                subString.index = 0;
                subString.length = regExpImpl.lastMatch.index;
            }
            return regExpImpl.leftContext;
        }
        if (languageVersion != 0 && languageVersion <= 140) {
            if (cCharAt != '0') {
                i3 = i;
                i4 = 0;
                while (true) {
                    i3++;
                    if (i3 >= length) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i3);
                    if (!NativeRegExp.isDigit(cCharAt2) || (i6 = (i4 * 10) + (cCharAt2 - '0')) < i4) {
                        break;
                    }
                    i4 = i6;
                }
            } else {
                return null;
            }
        } else {
            SubString[] subStringArr = regExpImpl.parens;
            int length2 = subStringArr == null ? 0 : subStringArr.length;
            int i7 = cCharAt - '0';
            if (i7 > length2) {
                return null;
            }
            int i8 = i + 2;
            if (i8 < length) {
                char cCharAt3 = str.charAt(i8);
                if (!NativeRegExp.isDigit(cCharAt3) || (i5 = (i7 * 10) + (cCharAt3 - '0')) > length2) {
                    i3 = i8;
                    i4 = i7;
                } else {
                    i3 = i + 3;
                    i4 = i5;
                }
                if (i4 == 0) {
                    return null;
                }
            }
        }
        iArr[0] = i3 - i;
        return regExpImpl.getParenSubString(i4 - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object matchOrReplace(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RegExpImpl regExpImpl, GlobData globData, NativeRegExp nativeRegExp) {
        GlobData globData2 = globData;
        String str = globData2.str;
        boolean z = (nativeRegExp.getFlags() & 1) != 0;
        globData2.global = z;
        int[] iArr = {0};
        int i = globData2.mode;
        if (i == 4) {
            Object objExecuteRegExp = nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, 0);
            if (objExecuteRegExp == null || !objExecuteRegExp.equals(Boolean.TRUE)) {
                return -1;
            }
            return Integer.valueOf(regExpImpl.leftContext.length);
        }
        if (!z) {
            return nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, i == 2 ? 0 : 1);
        }
        NativeRegExp nativeRegExp2 = nativeRegExp;
        nativeRegExp2.lastIndex = ScriptRuntime.zeroObj;
        Object obj = null;
        int i2 = 0;
        while (iArr[0] <= str.length()) {
            Object objExecuteRegExp2 = nativeRegExp2.executeRegExp(context, scriptable, regExpImpl, str, iArr, 0);
            String str2 = str;
            int[] iArr2 = iArr;
            if (objExecuteRegExp2 != null && objExecuteRegExp2.equals(Boolean.TRUE)) {
                int i3 = globData2.mode;
                if (i3 == 1) {
                    match_glob(globData2, context, scriptable, i2, regExpImpl);
                } else {
                    if (i3 != 2 && i3 != 3) {
                        Kit.codeBug();
                    }
                    SubString subString = regExpImpl.lastMatch;
                    int i4 = globData2.leftIndex;
                    int i5 = subString.index;
                    globData2.leftIndex = subString.length + i5;
                    replace_glob(globData2, context, scriptable, regExpImpl, i4, i5 - i4);
                }
                if (regExpImpl.lastMatch.length == 0) {
                    if (iArr2[0] != str2.length()) {
                        iArr2[0] = iArr2[0] + 1;
                    }
                }
                i2++;
                globData2 = globData;
                nativeRegExp2 = nativeRegExp;
                obj = objExecuteRegExp2;
                str = str2;
                iArr = iArr2;
            }
            return objExecuteRegExp2;
        }
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void match_glob(GlobData globData, Context context, Scriptable scriptable, int i, RegExpImpl regExpImpl) {
        if (globData.arrayobj == null) {
            globData.arrayobj = context.newArray(scriptable, 0);
        }
        String string = regExpImpl.lastMatch.toString();
        Scriptable scriptable2 = globData.arrayobj;
        scriptable2.put(i, scriptable2, string);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void replace_glob(GlobData globData, Context context, Scriptable scriptable, RegExpImpl regExpImpl, int i, int i2) {
        int length;
        String string;
        int i3;
        if (globData.lambda != null) {
            SubString[] subStringArr = regExpImpl.parens;
            int length2 = subStringArr == null ? 0 : subStringArr.length;
            Object[] objArr = new Object[length2 + 3];
            objArr[0] = regExpImpl.lastMatch.toString();
            for (int i4 = 0; i4 < length2; i4++) {
                SubString subString = subStringArr[i4];
                if (subString != null) {
                    objArr[i4 + 1] = subString.toString();
                } else {
                    objArr[i4 + 1] = Undefined.instance;
                }
            }
            objArr[length2 + 1] = Integer.valueOf(regExpImpl.leftContext.length);
            objArr[length2 + 2] = globData.str;
            if (regExpImpl != ScriptRuntime.getRegExpProxy(context)) {
                Kit.codeBug();
            }
            RegExpImpl regExpImpl2 = new RegExpImpl();
            regExpImpl2.multiline = regExpImpl.multiline;
            regExpImpl2.input = regExpImpl.input;
            ScriptRuntime.setRegExpProxy(context, regExpImpl2);
            try {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
                string = ScriptRuntime.toString(globData.lambda.call(context, topLevelScope, topLevelScope, objArr));
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                length = string.length();
            } catch (Throwable th) {
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                throw th;
            }
        } else {
            length = globData.repstr.length();
            int iIndexOf = globData.dollar;
            if (iIndexOf >= 0) {
                int[] iArr = new int[1];
                do {
                    SubString subStringInterpretDollar = interpretDollar(context, regExpImpl, globData.repstr, iIndexOf, iArr);
                    if (subStringInterpretDollar != null) {
                        int i5 = subStringInterpretDollar.length;
                        int i6 = iArr[0];
                        length += i5 - i6;
                        i3 = iIndexOf + i6;
                    } else {
                        i3 = iIndexOf + 1;
                    }
                    iIndexOf = globData.repstr.indexOf(36, i3);
                } while (iIndexOf >= 0);
            }
            string = null;
        }
        int i7 = length + i2 + regExpImpl.rightContext.length;
        StringBuilder sb = globData.charBuf;
        if (sb == null) {
            sb = new StringBuilder(i7);
            globData.charBuf = sb;
        } else {
            sb.ensureCapacity(sb.length() + i7);
        }
        sb.append((CharSequence) regExpImpl.leftContext.str, i, i2 + i);
        if (globData.lambda != null) {
            sb.append(string);
        } else {
            do_replace(globData, context, regExpImpl);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011d  */
    @Override // org.mozilla.javascript.RegExpProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object action(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, int i) {
        String string;
        NativeRegExp nativeRegExpCreateRegExp;
        String string2;
        Function function;
        RegExpImpl regExpImpl;
        int iIndexOf;
        int i2;
        RegExpImpl regExpImpl2;
        GlobData globData = new GlobData();
        globData.mode = i;
        globData.str = ScriptRuntime.toString(scriptable2);
        if (i == 1) {
            Object objMatchOrReplace = matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, createRegExp(context, scriptable, objArr, context.getLanguageVersion() < 160 ? 1 : Integer.MAX_VALUE, false));
            Scriptable scriptable3 = globData.arrayobj;
            return scriptable3 == null ? objMatchOrReplace : scriptable3;
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                return matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, createRegExp(context, scriptable, objArr, context.getLanguageVersion() < 160 ? 1 : Integer.MAX_VALUE, false));
            }
            throw Kit.codeBug();
        }
        boolean z = objArr.length > 0 && (objArr[0] instanceof NativeRegExp);
        if (context.getLanguageVersion() < 160) {
            z |= objArr.length > 2;
        }
        if (z) {
            nativeRegExpCreateRegExp = createRegExp(context, scriptable, objArr, 2, true);
            if (3 == i && (nativeRegExpCreateRegExp.getFlags() & 1) == 0) {
                throw ScriptRuntime.typeError("replaceAll must be called with a global RegExp");
            }
            string = null;
        } else {
            string = ScriptRuntime.toString(objArr.length < 1 ? Undefined.instance : objArr[0]);
            nativeRegExpCreateRegExp = null;
        }
        Object obj = objArr.length < 2 ? Undefined.instance : objArr[1];
        if (!(obj instanceof Function) || (context.getLanguageVersion() >= 200 && (obj instanceof NativeRegExp))) {
            string2 = ScriptRuntime.toString(obj);
            function = null;
        } else {
            function = (Function) obj;
            string2 = null;
        }
        globData.lambda = function;
        globData.repstr = string2;
        globData.dollar = string2 == null ? -1 : string2.indexOf(36);
        globData.charBuf = null;
        globData.leftIndex = 0;
        if (!z) {
            regExpImpl = this;
            String str = globData.str;
            int length = str.length();
            int length2 = string.length();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                if (!string.isEmpty()) {
                    iIndexOf = str.indexOf(string, i3);
                } else if (i4 == -1) {
                    i2 = 0;
                    if (i2 == -1) {
                        regExpImpl.parens = null;
                        regExpImpl.lastParen = null;
                        regExpImpl.leftContext = new SubString(str, 0, i2);
                        regExpImpl.lastMatch = new SubString(str, i2, length2);
                        int i5 = i2 + length2;
                        regExpImpl.rightContext = new SubString(str, i5, (length - i2) - length2);
                        int i6 = i3;
                        GlobData globData2 = globData;
                        regExpImpl2 = this;
                        replace_glob(globData2, context, scriptable, regExpImpl2, i6, i2 - i6);
                        globData = globData2;
                        if (i != 3) {
                            break;
                        }
                        regExpImpl = regExpImpl2;
                        i4 = i2;
                        i3 = i5;
                    } else if (globData.charBuf == null) {
                        return str;
                    }
                } else {
                    iIndexOf = i3 < length ? i3 + 1 : -1;
                }
                i2 = iIndexOf;
                if (i2 == -1) {
                }
            }
            SubString subString = regExpImpl2.rightContext;
            StringBuilder sb = globData.charBuf;
            String str2 = subString.str;
            int i7 = subString.index;
            sb.append((CharSequence) str2, i7, subString.length + i7);
            return globData.charBuf.toString();
        }
        NativeRegExp nativeRegExp = nativeRegExpCreateRegExp;
        regExpImpl = this;
        Object objMatchOrReplace2 = matchOrReplace(context, scriptable, scriptable2, objArr, regExpImpl, globData, nativeRegExp);
        if (globData.charBuf == null) {
            if (globData.global || objMatchOrReplace2 == null || !Boolean.TRUE.equals(objMatchOrReplace2)) {
                return globData.str;
            }
            SubString subString2 = regExpImpl.leftContext;
            replace_glob(globData, context, scriptable, this, subString2.index, subString2.length);
            globData = globData;
            regExpImpl = this;
        }
        regExpImpl2 = regExpImpl;
        SubString subString3 = regExpImpl2.rightContext;
        StringBuilder sb2 = globData.charBuf;
        String str22 = subString3.str;
        int i72 = subString3.index;
        sb2.append((CharSequence) str22, i72, subString3.length + i72);
        return globData.charBuf.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.RegExpProxy
    public Object compileRegExp(Context context, String str, String str2) {
        return NativeRegExp.compileRE(context, str, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SubString getParenSubString(int i) {
        SubString subString;
        SubString[] subStringArr = this.parens;
        return (subStringArr == null || i >= subStringArr.length || (subString = subStringArr[i]) == null) ? new SubString() : subString;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.RegExpProxy
    public boolean isRegExp(Scriptable scriptable) {
        return scriptable instanceof NativeRegExp;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    @Override // org.mozilla.javascript.RegExpProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object js_split(Context context, Scriptable scriptable, String str, Object[] objArr) {
        long j;
        Object obj;
        RegExpProxy regExpProxy;
        Scriptable scriptable2;
        String string;
        int i = 0;
        Scriptable scriptableNewArray = context.newArray(scriptable, 0);
        boolean z = objArr.length > 1 && objArr[1] != Undefined.instance;
        long length = 0;
        if (!z) {
            j = length;
            if (objArr.length < 1) {
            }
            scriptableNewArray.put(0, scriptableNewArray, str);
            return scriptableNewArray;
        }
        long uint32 = ScriptRuntime.toUint32(objArr[1]);
        if (uint32 != 0) {
            if (uint32 <= str.length()) {
                j = uint32;
                if (objArr.length < 1) {
                }
                scriptableNewArray.put(0, scriptableNewArray, str);
                return scriptableNewArray;
            }
            length = ((long) str.length()) + 1;
            j = length;
            if (objArr.length < 1 && (obj = objArr[0]) != Undefined.instance) {
                int[] iArr = new int[1];
                if (obj instanceof Scriptable) {
                    regExpProxy = ScriptRuntime.getRegExpProxy(context);
                    if (regExpProxy != null) {
                        scriptable2 = (Scriptable) objArr[0];
                        if (!regExpProxy.isRegExp(scriptable2)) {
                            scriptable2 = null;
                        }
                    }
                } else {
                    regExpProxy = null;
                    scriptable2 = null;
                }
                if (scriptable2 == null) {
                    string = ScriptRuntime.toString(objArr[0]);
                    iArr[0] = string.length();
                } else {
                    string = null;
                }
                int[] iArr2 = {0};
                boolean[] zArr = {false};
                String[][] strArr = {null};
                int languageVersion = context.getLanguageVersion();
                RegExpProxy regExpProxy2 = regExpProxy;
                boolean z2 = z;
                String str2 = string;
                Context context2 = context;
                Scriptable scriptable3 = scriptable;
                while (true) {
                    int iFind_split = find_split(context2, scriptable3, str, str2, languageVersion, regExpProxy2, scriptable2, iArr2, iArr, zArr, strArr);
                    if (iFind_split >= 0 && ((!z2 || i < j) && iFind_split <= str.length())) {
                        scriptableNewArray.put(i, scriptableNewArray, str.length() == 0 ? str : str.substring(iArr2[0], iFind_split));
                        i++;
                        if (scriptable2 != null && zArr[0]) {
                            int length2 = strArr[0].length;
                            int i2 = 0;
                            while (i2 < length2) {
                                int i3 = length2;
                                int i4 = i2;
                                if (z2 && i >= j) {
                                    break;
                                }
                                scriptableNewArray.put(i, scriptableNewArray, strArr[0][i4]);
                                i++;
                                i2 = i4 + 1;
                                length2 = i3;
                            }
                            zArr[0] = false;
                        }
                        int i5 = iFind_split + iArr[0];
                        iArr2[0] = i5;
                        if (languageVersion < 130 && languageVersion != 0 && !z2 && i5 == str.length()) {
                            break;
                        }
                        context2 = context;
                        scriptable3 = scriptable;
                    } else {
                        break;
                    }
                }
            } else {
                scriptableNewArray.put(0, scriptableNewArray, str);
                return scriptableNewArray;
            }
        }
        return scriptableNewArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.RegExpProxy
    public void register(ScriptableObject scriptableObject, boolean z) {
        NativeRegExpStringIterator.init(scriptableObject, z);
        new LazilyLoadedCtor(scriptableObject, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp", z, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.RegExpProxy
    public Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return NativeRegExpInstantiator.withLanguageVersionScopeCompiled(context.getLanguageVersion(), scriptable, (RECompiled) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        r1 = r1 - r6;
     */
    @Override // org.mozilla.javascript.RegExpProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int find_split(Context context, Scriptable scriptable, String str, String str2, Scriptable scriptable2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int i;
        int i2 = iArr[0];
        int length = str.length();
        int languageVersion = context.getLanguageVersion();
        NativeRegExp nativeRegExp = (NativeRegExp) scriptable2;
        while (true) {
            int i3 = iArr[0];
            iArr[0] = i2;
            if (!Boolean.TRUE.equals(nativeRegExp.executeRegExp(context, scriptable, this, str, iArr, 0))) {
                iArr[0] = i3;
                iArr2[0] = 1;
                zArr[0] = false;
                return length;
            }
            i = iArr[0];
            iArr[0] = i3;
            zArr[0] = true;
            int i4 = this.lastMatch.length;
            iArr2[0] = i4;
            if (i4 != 0 || i != iArr[0]) {
                break;
            }
            if (i != length) {
                i2 = i + 1;
            } else if (languageVersion == 120) {
                iArr2[0] = 1;
            } else {
                i = -1;
            }
        }
        SubString[] subStringArr = this.parens;
        int length2 = subStringArr == null ? 0 : subStringArr.length;
        strArr[0] = new String[length2];
        for (int i5 = 0; i5 < length2; i5++) {
            strArr[0][i5] = getParenSubString(i5).toString();
        }
        return i;
    }
}
