package org.mozilla.javascript.regexp;

import defpackage.jl;
import defpackage.z20;
import org.jupnp.model.ServiceReference;
import org.mozilla.javascript.AbstractEcmaObjectOperations;
import org.mozilla.javascript.Constructable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ScriptRuntimeES6;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Symbol;
import org.mozilla.javascript.SymbolKey;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.Undefined;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeRegExp extends IdScriptableObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_compile = 1;
    private static final int Id_dotAll = 7;
    private static final int Id_exec = 4;
    private static final int Id_flags = 3;
    private static final int Id_global = 4;
    private static final int Id_ignoreCase = 5;
    private static final int Id_lastIndex = 1;
    private static final int Id_multiline = 6;
    private static final int Id_prefix = 6;
    private static final int Id_source = 2;
    private static final int Id_sticky = 8;
    private static final int Id_test = 5;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    public static final int JSREG_DOTALL = 8;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int JSREG_STICKY = 16;
    public static final int MATCH = 1;
    private static final int MAX_INSTANCE_ID = 8;
    private static final int MAX_PROTOTYPE_ID = 9;
    public static final int PREFIX = 2;
    private static final Object REGEXP_TAG = new Object();
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_END = 57;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    private static final int SymbolId_match = 7;
    private static final int SymbolId_matchAll = 8;
    private static final int SymbolId_search = 9;
    public static final int TEST = 0;
    private static final boolean debug = false;
    private static final long serialVersionUID = 4965263491464903264L;
    Object lastIndex;
    private int lastIndexAttr;
    private RECompiled re;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NativeRegExp(Scriptable scriptable, RECompiled rECompiled) {
        Integer num = ScriptRuntime.zeroObj;
        this.lastIndex = num;
        this.lastIndexAttr = 6;
        this.re = rECompiled;
        setLastIndex(num);
        ScriptRuntime.setBuiltinProtoAndParent(this, scriptable, TopLevel.Builtins.RegExp);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void addCharacterRangeToCharSet(RECharSet rECharSet, char c, char c2) {
        int i = c / '\b';
        int i2 = c2 / '\b';
        if (c2 >= rECharSet.length || c > c2) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        char c3 = (char) (c & 7);
        char c4 = (char) (c2 & 7);
        byte[] bArr = rECharSet.bits;
        if (i == i2) {
            bArr[i] = (byte) (bArr[i] | ((byte) ((255 >> (7 - (c4 - c3))) << c3)));
            return;
        }
        bArr[i] = (byte) (((byte) (255 << c3)) | bArr[i]);
        while (true) {
            i++;
            byte[] bArr2 = rECharSet.bits;
            if (i >= i2) {
                bArr2[i2] = (byte) (bArr2[i2] | ((byte) (255 >> (7 - c4))));
                return;
            }
            bArr2[i] = -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void addCharacterToCharSet(RECharSet rECharSet, char c) {
        int i = c / '\b';
        if (c >= rECharSet.length) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        byte[] bArr = rECharSet.bits;
        bArr[i] = (byte) (((byte) (1 << (c & 7))) | bArr[i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw Kit.codeBug();
        }
        if (i2 > 65535) {
            throw Context.reportRuntimeError("Too complex regexp");
        }
        bArr[i] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) i2;
        return i + 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void appendFlags(StringBuilder sb) {
        if ((this.re.flags & 1) != 0) {
            sb.append('g');
        }
        if ((this.re.flags & 2) != 0) {
            sb.append('i');
        }
        if ((this.re.flags & 4) != 0) {
            sb.append('m');
        }
        if ((this.re.flags & 8) != 0) {
            sb.append('s');
        }
        if ((this.re.flags & 16) != 0) {
            sb.append('y');
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        long[] jArr = rEGlobalData.parens;
        if (jArr == null || i >= jArr.length) {
            return false;
        }
        int iParensIndex = rEGlobalData.parensIndex(i);
        if (iParensIndex == -1) {
            return true;
        }
        int iParensLength = rEGlobalData.parensLength(i);
        int i3 = rEGlobalData.cp;
        if (i3 + iParensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i4 = 0; i4 < iParensLength; i4++) {
                char cCharAt = str.charAt(iParensIndex + i4);
                char cCharAt2 = str.charAt(rEGlobalData.cp + i4);
                if (cCharAt != cCharAt2 && upcase(cCharAt) != upcase(cCharAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(iParensIndex, str, i3, iParensLength)) {
            return false;
        }
        rEGlobalData.cp += iParensLength;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x00de */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:97:0x0016 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x0016 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:30:0x004f
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static boolean calculateBitmapSize(org.mozilla.javascript.regexp.CompilerState r11, org.mozilla.javascript.regexp.RENode r12, char[] r13, int r14, int r15) {
        /*
            r0 = 0
            r12.bmsize = r0
            r1 = 1
            r12.sense = r1
            if (r14 != r15) goto L9
            return r1
        L9:
            char r2 = r13[r14]
            r3 = 94
            if (r2 != r3) goto L13
            int r14 = r14 + 1
            r12.sense = r0
        L13:
            r2 = r0
            r3 = r2
            r4 = r3
        L16:
            if (r14 == r15) goto Lf4
            char r5 = r13[r14]
            r6 = 92
            r7 = 2
            if (r5 != r6) goto Lbe
            int r5 = r14 + 1
            int r8 = r14 + 2
            char r5 = r13[r5]
            r9 = 68
            r10 = 65536(0x10000, float:9.1835E-41)
            if (r5 == r9) goto Lbb
            r9 = 83
            if (r5 == r9) goto Lbb
            r9 = 87
            if (r5 == r9) goto Lbb
            r9 = 102(0x66, float:1.43E-43)
            if (r5 == r9) goto Lb8
            r9 = 110(0x6e, float:1.54E-43)
            if (r5 == r9) goto Lb5
            switch(r5) {
                case 48: goto L8d;
                case 49: goto L8d;
                case 50: goto L8d;
                case 51: goto L8d;
                case 52: goto L8d;
                case 53: goto L8d;
                case 54: goto L8d;
                case 55: goto L8d;
                default: goto L3e;
            }
        L3e:
            switch(r5) {
                case 98: goto L8a;
                case 99: goto L77;
                case 100: goto L6f;
                default: goto L41;
            }
        L41:
            switch(r5) {
                case 114: goto L6c;
                case 115: goto Lbb;
                case 116: goto L69;
                case 117: goto L4c;
                case 118: goto L49;
                case 119: goto Lbb;
                case 120: goto L47;
                default: goto L44;
            }
        L44:
            r14 = r8
            goto Lc0
        L47:
            r14 = r7
            goto L4d
        L49:
            r5 = 11
            goto L44
        L4c:
            r14 = 4
        L4d:
            r5 = r0
            r9 = r5
        L4f:
            if (r5 >= r14) goto L67
            if (r8 >= r15) goto L67
            int r10 = r8 + 1
            char r8 = r13[r8]
            int r9 = org.mozilla.javascript.Kit.xDigitToInt(r8, r9)
            if (r9 >= 0) goto L63
            int r5 = r5 + 1
            int r8 = r10 - r5
            r5 = r6
            goto L44
        L63:
            int r5 = r5 + 1
            r8 = r10
            goto L4f
        L67:
            r5 = r9
            goto L44
        L69:
            r5 = 9
            goto L44
        L6c:
            r5 = 13
            goto L44
        L6f:
            if (r3 == 0) goto L74
            r12.bmsize = r10
            return r1
        L74:
            r5 = 57
            goto L44
        L77:
            if (r8 >= r15) goto L86
            char r5 = r13[r8]
            boolean r5 = isControlLetter(r5)
            if (r5 == 0) goto L86
            int r14 = r14 + 3
            char r5 = r13[r8]
            goto L88
        L86:
            int r14 = r14 + 1
        L88:
            r5 = r6
            goto Lc0
        L8a:
            r5 = 8
            goto L44
        L8d:
            int r5 = r5 + (-48)
            char r6 = r13[r8]
            r9 = 48
            if (r9 > r6) goto L44
            r10 = 55
            if (r6 > r10) goto L44
            int r8 = r14 + 3
            int r5 = r5 * 8
            int r6 = r6 + (-48)
            int r5 = r5 + r6
            char r6 = r13[r8]
            if (r9 > r6) goto L44
            if (r6 > r10) goto L44
            int r8 = r14 + 4
            int r9 = r5 * 8
            int r6 = r6 + (-48)
            int r9 = r9 + r6
            r6 = 255(0xff, float:3.57E-43)
            if (r9 > r6) goto Lb2
            goto L67
        Lb2:
            int r8 = r14 + 3
            goto L44
        Lb5:
            r5 = 10
            goto L44
        Lb8:
            r5 = 12
            goto L44
        Lbb:
            r12.bmsize = r10
            return r1
        Lbe:
            int r14 = r14 + 1
        Lc0:
            if (r3 == 0) goto Lce
            if (r4 <= r5) goto Lcc
            java.lang.String r11 = "msg.bad.range"
            java.lang.String r12 = ""
            reportError(r11, r12)
            return r0
        Lcc:
            r3 = r0
            goto Lde
        Lce:
            int r6 = r15 + (-1)
            if (r14 >= r6) goto Lde
            char r6 = r13[r14]
            r8 = 45
            if (r6 != r8) goto Lde
            int r14 = r14 + 1
            char r4 = (char) r5
            r3 = r1
            goto L16
        Lde:
            int r6 = r11.flags
            r6 = r6 & r7
            if (r6 == 0) goto Lef
            char r5 = (char) r5
            char r6 = upcase(r5)
            char r5 = downcase(r5)
            if (r6 < r5) goto Lef
            r5 = r6
        Lef:
            if (r5 <= r2) goto L16
            r2 = r5
            goto L16
        Lf4:
            int r2 = r2 + r1
            r12.bmsize = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.calculateBitmapSize(org.mozilla.javascript.regexp.CompilerState, org.mozilla.javascript.regexp.RENode, char[], int, int):boolean");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c) {
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c >> 3;
        int i2 = rECharSet.length;
        boolean z = true;
        if (i2 != 0 && c < i2 && (rECharSet.bits[i] & (1 << (c & 7))) != 0) {
            z = false;
        }
        return rECharSet.sense ^ z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static RECompiled compileRE(Context context, String str, String str2, boolean z) {
        int i;
        int i2;
        RECompiled rECompiled = new RECompiled(str);
        int length = str.length();
        if (str2 != null) {
            i = 0;
            for (int i3 = 0; i3 < str2.length(); i3++) {
                char cCharAt = str2.charAt(i3);
                if (cCharAt == 'g') {
                    i2 = 1;
                } else if (cCharAt == 'i') {
                    i2 = 2;
                } else if (cCharAt == 'm') {
                    i2 = 4;
                } else if (cCharAt == 's') {
                    i2 = 8;
                } else if (cCharAt == 'y') {
                    i2 = 16;
                } else {
                    reportError("msg.invalid.re.flag", String.valueOf(cCharAt));
                    i2 = 0;
                }
                if ((i & i2) != 0) {
                    reportError("msg.invalid.re.flag", String.valueOf(cCharAt));
                }
                i |= i2;
            }
        } else {
            i = 0;
        }
        rECompiled.flags = i;
        CompilerState compilerState = new CompilerState(context, rECompiled.source, length, i);
        if (z && length > 0) {
            RENode rENode = new RENode(REOP_FLAT);
            compilerState.result = rENode;
            rENode.chr = compilerState.cpbegin[0];
            rENode.length = length;
            rENode.flatIndex = 0;
            compilerState.progLength += 5;
        } else {
            if (!parseDisjunction(compilerState)) {
                return null;
            }
            if (compilerState.maxBackReference > compilerState.parenCount) {
                compilerState = new CompilerState(context, rECompiled.source, length, i);
                compilerState.backReferenceLimit = compilerState.parenCount;
                if (!parseDisjunction(compilerState)) {
                    return null;
                }
            }
        }
        rECompiled.program = new byte[compilerState.progLength + 1];
        int i4 = compilerState.classCount;
        if (i4 != 0) {
            rECompiled.classList = new RECharSet[i4];
            rECompiled.classCount = i4;
        }
        int iEmitREBytecode = emitREBytecode(compilerState, rECompiled, 0, compilerState.result);
        byte[] bArr = rECompiled.program;
        bArr[iEmitREBytecode] = REOP_END;
        rECompiled.parenCount = compilerState.parenCount;
        byte b = bArr[0];
        if (b == 2) {
            rECompiled.anchorCh = ANCHOR_BOL;
            return rECompiled;
        }
        if (b != 31) {
            switch (b) {
                case 14:
                case 16:
                    rECompiled.anchorCh = rECompiled.source[getIndex(bArr, 1)];
                    break;
                case 15:
                case 17:
                    rECompiled.anchorCh = (char) (bArr[1] & 255);
                    break;
                case 18:
                case 19:
                    rECompiled.anchorCh = (char) getIndex(bArr, 1);
                    break;
            }
            return null;
        }
        RENode rENode2 = compilerState.result;
        if (rENode2.kid.op == 2 && rENode2.kid2.op == 2) {
            rECompiled.anchorCh = ANCHOR_BOL;
        }
        return rECompiled;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void doFlat(CompilerState compilerState, char c) {
        RENode rENode = new RENode(REOP_FLAT);
        compilerState.result = rENode;
        rENode.chr = c;
        rENode.length = 1;
        rENode.flatIndex = -1;
        compilerState.progLength += 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static char downcase(char c) {
        if (c >= 128) {
            char lowerCase = Character.toLowerCase(c);
            if (lowerCase >= 128) {
                return lowerCase;
            }
        } else if ('A' <= c && c <= 'Z') {
            return (char) (c + ' ');
        }
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int emitREBytecode(org.mozilla.javascript.regexp.CompilerState r9, org.mozilla.javascript.regexp.RECompiled r10, int r11, org.mozilla.javascript.regexp.RENode r12) {
        /*
            byte[] r0 = r10.program
        L2:
            if (r12 == 0) goto L1c6
            int r1 = r11 + 1
            byte r2 = r12.op
            r0[r11] = r2
            r3 = 1
            if (r2 == r3) goto L1c2
            r4 = 22
            if (r2 == r4) goto L1a1
            r4 = 25
            r5 = -1
            if (r2 == r4) goto L137
            r4 = 29
            if (r2 == r4) goto L11d
            r4 = 31
            if (r2 == r4) goto Lf6
            r4 = 13
            if (r2 == r4) goto Lee
            r4 = 14
            if (r2 == r4) goto L7d
            r4 = 41
            if (r2 == r4) goto L6b
            r4 = 42
            if (r2 == r4) goto L57
            switch(r2) {
                case 53: goto L34;
                case 54: goto L34;
                case 55: goto L34;
                default: goto L31;
            }
        L31:
            r11 = r1
            goto L1c2
        L34:
            r4 = 54
            if (r2 != r4) goto L39
            goto L3a
        L39:
            r3 = 0
        L3a:
            char r2 = r12.chr
            if (r3 == 0) goto L42
            char r2 = upcase(r2)
        L42:
            addIndex(r0, r1, r2)
            int r1 = r11 + 3
            int r2 = r12.index
            if (r3 == 0) goto L50
            char r2 = (char) r2
            char r2 = upcase(r2)
        L50:
            addIndex(r0, r1, r2)
            int r1 = r11 + 5
            goto Lf6
        L57:
            int r11 = r11 + 3
            org.mozilla.javascript.regexp.RENode r2 = r12.kid
            int r11 = emitREBytecode(r9, r10, r11, r2)
            int r2 = r11 + 1
            r3 = 44
            r0[r11] = r3
            resolveForwardJump(r0, r1, r2)
        L68:
            r11 = r2
            goto L1c2
        L6b:
            int r11 = r11 + 3
            org.mozilla.javascript.regexp.RENode r2 = r12.kid
            int r11 = emitREBytecode(r9, r10, r11, r2)
            int r2 = r11 + 1
            r3 = 43
            r0[r11] = r3
            resolveForwardJump(r0, r1, r2)
            goto L68
        L7d:
            int r2 = r12.flatIndex
            if (r2 == r5) goto L9c
        L81:
            org.mozilla.javascript.regexp.RENode r2 = r12.next
            if (r2 == 0) goto L9c
            byte r6 = r2.op
            if (r6 != r4) goto L9c
            int r6 = r12.flatIndex
            int r7 = r12.length
            int r6 = r6 + r7
            int r8 = r2.flatIndex
            if (r6 != r8) goto L9c
            int r6 = r2.length
            int r7 = r7 + r6
            r12.length = r7
            org.mozilla.javascript.regexp.RENode r2 = r2.next
            r12.next = r2
            goto L81
        L9c:
            int r2 = r12.flatIndex
            if (r2 == r5) goto Lbd
            int r5 = r12.length
            if (r5 <= r3) goto Lbd
            int r3 = r9.flags
            r3 = r3 & 2
            if (r3 == 0) goto Laf
            r3 = 16
            r0[r11] = r3
            goto Lb1
        Laf:
            r0[r11] = r4
        Lb1:
            int r11 = addIndex(r0, r1, r2)
            int r1 = r12.length
            int r11 = addIndex(r0, r11, r1)
            goto L1c2
        Lbd:
            char r2 = r12.chr
            r3 = 256(0x100, float:3.59E-43)
            if (r2 >= r3) goto Ld9
            int r3 = r9.flags
            r3 = r3 & 2
            if (r3 == 0) goto Lce
            r3 = 17
            r0[r11] = r3
            goto Ld2
        Lce:
            r3 = 15
            r0[r11] = r3
        Ld2:
            int r11 = r11 + 2
            byte r2 = (byte) r2
            r0[r1] = r2
            goto L1c2
        Ld9:
            int r3 = r9.flags
            r3 = r3 & 2
            if (r3 == 0) goto Le4
            r3 = 19
            r0[r11] = r3
            goto Le8
        Le4:
            r3 = 18
            r0[r11] = r3
        Le8:
            int r11 = addIndex(r0, r1, r2)
            goto L1c2
        Lee:
            int r11 = r12.parenIndex
            int r11 = addIndex(r0, r1, r11)
            goto L1c2
        Lf6:
            org.mozilla.javascript.regexp.RENode r11 = r12.kid2
            int r2 = r1 + 2
            org.mozilla.javascript.regexp.RENode r3 = r12.kid
            int r2 = emitREBytecode(r9, r10, r2, r3)
            int r3 = r2 + 1
            r4 = 32
            r0[r2] = r4
            int r2 = r2 + 3
            resolveForwardJump(r0, r1, r2)
            int r11 = emitREBytecode(r9, r10, r2, r11)
            int r1 = r11 + 1
            r0[r11] = r4
            int r11 = r11 + 3
            resolveForwardJump(r0, r3, r11)
            resolveForwardJump(r0, r1, r11)
            goto L1c2
        L11d:
            int r11 = r12.parenIndex
            int r11 = addIndex(r0, r1, r11)
            org.mozilla.javascript.regexp.RENode r1 = r12.kid
            int r11 = emitREBytecode(r9, r10, r11, r1)
            int r1 = r11 + 1
            r2 = 30
            r0[r11] = r2
            int r11 = r12.parenIndex
            int r11 = addIndex(r0, r1, r11)
            goto L1c2
        L137:
            int r2 = r12.min
            if (r2 != 0) goto L14b
            int r4 = r12.max
            if (r4 != r5) goto L14b
            boolean r2 = r12.greedy
            if (r2 == 0) goto L146
            r2 = 26
            goto L148
        L146:
            r2 = 45
        L148:
            r0[r11] = r2
            goto L182
        L14b:
            if (r2 != 0) goto L15d
            int r4 = r12.max
            if (r4 != r3) goto L15d
            boolean r2 = r12.greedy
            if (r2 == 0) goto L158
            r2 = 28
            goto L15a
        L158:
            r2 = 47
        L15a:
            r0[r11] = r2
            goto L182
        L15d:
            if (r2 != r3) goto L16f
            int r4 = r12.max
            if (r4 != r5) goto L16f
            boolean r2 = r12.greedy
            if (r2 == 0) goto L16a
            r2 = 27
            goto L16c
        L16a:
            r2 = 46
        L16c:
            r0[r11] = r2
            goto L182
        L16f:
            boolean r4 = r12.greedy
            if (r4 != 0) goto L177
            r4 = 48
            r0[r11] = r4
        L177:
            int r11 = addIndex(r0, r1, r2)
            int r1 = r12.max
            int r1 = r1 + r3
            int r1 = addIndex(r0, r11, r1)
        L182:
            int r11 = r12.parenCount
            int r11 = addIndex(r0, r1, r11)
            int r1 = r12.parenIndex
            int r11 = addIndex(r0, r11, r1)
            int r1 = r11 + 2
            org.mozilla.javascript.regexp.RENode r2 = r12.kid
            int r1 = emitREBytecode(r9, r10, r1, r2)
            int r2 = r1 + 1
            r3 = 49
            r0[r1] = r3
            resolveForwardJump(r0, r11, r2)
            goto L68
        L1a1:
            boolean r2 = r12.sense
            if (r2 != 0) goto L1a9
            r2 = 23
            r0[r11] = r2
        L1a9:
            int r11 = r12.index
            int r11 = addIndex(r0, r1, r11)
            org.mozilla.javascript.regexp.RECharSet[] r1 = r10.classList
            int r2 = r12.index
            org.mozilla.javascript.regexp.RECharSet r3 = new org.mozilla.javascript.regexp.RECharSet
            int r4 = r12.bmsize
            int r5 = r12.startIndex
            int r6 = r12.kidlen
            boolean r7 = r12.sense
            r3.<init>(r4, r5, r6, r7)
            r1[r2] = r3
        L1c2:
            org.mozilla.javascript.regexp.RENode r12 = r12.next
            goto L2
        L1c6:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.emitREBytecode(org.mozilla.javascript.regexp.CompilerState, org.mozilla.javascript.regexp.RECompiled, int, org.mozilla.javascript.regexp.RENode):int");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String escapeRegExp(Object obj) {
        String string = ScriptRuntime.toString(obj);
        StringBuilder sb = null;
        int i = 0;
        for (int iIndexOf = string.indexOf(47); iIndexOf > -1; iIndexOf = string.indexOf(47, iIndexOf + 1)) {
            if (iIndexOf == i || string.charAt(iIndexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) string, i, iIndexOf);
                sb.append("\\/");
                i = iIndexOf + 1;
            }
        }
        if (sb == null) {
            return string;
        }
        sb.append((CharSequence) string, i, string.length());
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x038a A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type update failed for variable: r3v0 byte[], new type: byte[]
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11761. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:572)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:591)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:572)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:591)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:572)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:591)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:72)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Type update failed for variable: r3v0 byte[], new type: byte[]
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11761. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:572)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:591)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:572)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:591)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:572)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayGetListener(TypeUpdate.java:591)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:72)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToForceImmutableTypes(FixTypesVisitor.java:946)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean executeREBytecode(org.mozilla.javascript.Context r19, org.mozilla.javascript.regexp.REGlobalData r20, java.lang.String r21, int r22) {
        /*
            r0 = r20
            r5 = r22
            org.mozilla.javascript.regexp.RECompiled r1 = r0.regexp
            byte[] r3 = r1.program
            r7 = 0
            r2 = r3[r7]
            int r1 = r1.anchorCh
            r8 = 1
            r4 = 1
            if (r1 >= 0) goto L3b
            boolean r1 = reopIsSimple(r2)
            if (r1 == 0) goto L3b
        L17:
            int r1 = r0.cp
            if (r1 > r5) goto L37
            r6 = 1
            r1 = r21
            int r6 = simpleMatch(r0, r1, r2, r3, r4, r5, r6)
            if (r6 < 0) goto L2a
            int r4 = r6 + 1
            r2 = r3[r6]
            r1 = r8
            goto L38
        L2a:
            int r1 = r0.skipped
            int r1 = r1 + r8
            r0.skipped = r1
            int r1 = r0.cp
            int r1 = r1 + r8
            r0.cp = r1
            r5 = r22
            goto L17
        L37:
            r1 = r7
        L38:
            if (r1 != 0) goto L3b
            return r7
        L3b:
            int r1 = r19.getInstructionObserverThreshold()
            if (r1 == 0) goto L43
            r9 = r8
            goto L44
        L43:
            r9 = r7
        L44:
            r10 = 57
            r12 = r7
            r13 = r12
            r11 = r10
        L49:
            if (r9 == 0) goto L52
            r1 = 5
            r14 = r19
            org.mozilla.javascript.ScriptRuntime.addInstructionCount(r14, r1)
            goto L54
        L52:
            r14 = r19
        L54:
            boolean r1 = reopIsSimple(r2)
            if (r1 == 0) goto L74
            r6 = 1
            r1 = r21
            r5 = r22
            int r2 = simpleMatch(r0, r1, r2, r3, r4, r5, r6)
            r15 = r4
            r1 = r5
            if (r2 < 0) goto L69
            r4 = r8
            goto L6a
        L69:
            r4 = r7
        L6a:
            if (r4 == 0) goto L6d
            r15 = r2
        L6d:
            r13 = r4
            r16 = r8
        L70:
            r4 = r15
            r15 = r3
            goto L302
        L74:
            r1 = r22
            r15 = r4
            if (r2 == r10) goto L444
            r4 = 51
            r5 = 52
            r6 = -1
            r16 = r8
            switch(r2) {
                case 25: goto L266;
                case 26: goto L266;
                case 27: goto L266;
                case 28: goto L266;
                case 29: goto L3c4;
                case 30: goto L3a9;
                case 31: goto L355;
                case 32: goto L345;
                default: goto L83;
            }
        L83:
            r8 = 44
            switch(r2) {
                case 41: goto L2d7;
                case 42: goto L285;
                case 43: goto L26f;
                case 44: goto L26f;
                case 45: goto L266;
                case 46: goto L266;
                case 47: goto L266;
                case 48: goto L266;
                case 49: goto L25f;
                default: goto L88;
            }
        L88:
            switch(r2) {
                case 51: goto L17c;
                case 52: goto Ld5;
                case 53: goto L92;
                case 54: goto L92;
                case 55: goto L92;
                default: goto L8b;
            }
        L8b:
            java.lang.String r0 = "invalid bytecode"
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug(r0)
            throw r0
        L92:
            int r4 = getIndex(r3, r15)
            char r4 = (char) r4
            int r5 = r15 + 2
            int r5 = getIndex(r3, r5)
            char r5 = (char) r5
            int r6 = r15 + 4
            int r8 = r0.cp
            if (r8 != r1) goto La9
        La4:
            r15 = r3
            r4 = r6
            r13 = r7
            goto L302
        La9:
            r15 = r21
            char r8 = r15.charAt(r8)
            r10 = 55
            if (r2 != r10) goto Lc2
            if (r8 == r4) goto Lcf
            org.mozilla.javascript.regexp.RECompiled r2 = r0.regexp
            org.mozilla.javascript.regexp.RECharSet[] r2 = r2.classList
            r2 = r2[r5]
            boolean r2 = classMatcher(r0, r2, r8)
            if (r2 != 0) goto Lcf
            goto La4
        Lc2:
            r10 = 54
            if (r2 != r10) goto Lca
            char r8 = upcase(r8)
        Lca:
            if (r8 == r4) goto Lcf
            if (r8 == r5) goto Lcf
            goto La4
        Lcf:
            r4 = r6
        Ld0:
            r18 = r12
            r12 = r11
            goto L358
        Ld5:
            org.mozilla.javascript.regexp.REProgState r8 = popProgState(r0)
            if (r13 != 0) goto L11f
            int r2 = r8.max
            if (r2 == r6) goto Le7
            if (r2 <= 0) goto Le2
            goto Le7
        Le2:
            int r12 = r8.continuationPc
            int r11 = r8.continuationOp
            goto L70
        Le7:
            int r1 = r8.min
            r4 = r3
            int r3 = r0.cp
            r10 = r5
            int r5 = r8.continuationOp
            r11 = r6
            int r6 = r8.continuationPc
            r8 = r4
            r4 = 0
            r12 = r10
            r10 = r11
            r11 = r8
            pushProgState(r0, r1, r2, r3, r4, r5, r6)
            int r1 = getIndex(r11, r15)
            int r4 = r15 + 2
            int r2 = getIndex(r11, r4)
            int r4 = r15 + 6
            r3 = r7
        L107:
            if (r3 >= r1) goto L111
            int r5 = r2 + r3
            r0.setParens(r5, r10, r7)
            int r3 = r3 + 1
            goto L107
        L111:
            int r1 = r15 + 7
            r2 = r11[r4]
        L115:
            r4 = r1
        L116:
            r3 = r11
            r11 = r12
            r12 = r15
        L119:
            r8 = r16
        L11b:
            r10 = 57
            goto L49
        L11f:
            r11 = r3
            r12 = r5
            r10 = r6
            int r1 = r8.min
            if (r1 != 0) goto L136
            int r2 = r0.cp
            int r3 = r8.index
            if (r2 != r3) goto L136
            int r12 = r8.continuationPc
            int r1 = r8.continuationOp
            r13 = r7
            r4 = r15
        L132:
            r15 = r11
        L133:
            r11 = r1
            goto L302
        L136:
            int r2 = r8.max
            if (r1 == 0) goto L13c
            int r1 = r1 + (-1)
        L13c:
            if (r2 == r10) goto L140
            int r2 = r2 + (-1)
        L140:
            int r3 = r0.cp
            int r5 = r8.continuationOp
            int r6 = r8.continuationPc
            r4 = 0
            pushProgState(r0, r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L163
            int r1 = getIndex(r11, r15)
            int r4 = r15 + 2
            int r2 = getIndex(r11, r4)
            int r4 = r15 + 6
            r3 = r7
        L159:
            if (r3 >= r1) goto L177
            int r5 = r2 + r3
            r0.setParens(r5, r10, r7)
            int r3 = r3 + 1
            goto L159
        L163:
            int r4 = r8.continuationPc
            int r1 = r8.continuationOp
            pushBackTrackState(r0, r12, r15)
            popProgState(r0)
            int r2 = r15 + 4
            int r3 = getOffset(r11, r2)
            int r2 = r2 + r3
            r12 = r1
            r15 = r4
            r4 = r2
        L177:
            int r1 = r4 + 1
            r2 = r11[r4]
            goto L115
        L17c:
            r11 = r3
            r10 = r6
        L17e:
            org.mozilla.javascript.regexp.REProgState r8 = popProgState(r0)
            if (r13 != 0) goto L196
            int r1 = r8.min
            if (r1 != 0) goto L18a
            r13 = r16
        L18a:
            int r12 = r8.continuationPc
            int r1 = r8.continuationOp
            int r4 = r15 + 4
            int r2 = getOffset(r11, r4)
            int r4 = r4 + r2
            goto L132
        L196:
            int r1 = r8.min
            if (r1 != 0) goto L1b1
            int r2 = r0.cp
            int r3 = r8.index
            if (r2 == r3) goto L1a4
            int r2 = r8.max
            if (r2 != 0) goto L1b1
        L1a4:
            int r12 = r8.continuationPc
            int r1 = r8.continuationOp
            int r4 = r15 + 4
            int r2 = getOffset(r11, r4)
            int r4 = r4 + r2
            r13 = r7
            goto L132
        L1b1:
            int r2 = r8.max
            if (r1 == 0) goto L1b7
            int r1 = r1 + (-1)
        L1b7:
            r12 = r1
            if (r2 == r10) goto L1bc
            int r2 = r2 + (-1)
        L1bc:
            r17 = r2
            if (r17 != 0) goto L1d0
            int r12 = r8.continuationPc
            int r1 = r8.continuationOp
            int r4 = r15 + 4
            int r2 = getOffset(r11, r4)
            int r4 = r4 + r2
            r15 = r11
            r13 = r16
            goto L133
        L1d0:
            int r1 = r15 + 6
            r2 = r11[r1]
            int r3 = r0.cp
            boolean r5 = reopIsSimple(r2)
            if (r5 == 0) goto L20e
            r1 = r4
            int r4 = r15 + 7
            r6 = 1
            r5 = r11
            r11 = r3
            r3 = r5
            r5 = r22
            r13 = r1
            r1 = r21
            int r2 = simpleMatch(r0, r1, r2, r3, r4, r5, r6)
            r0 = r3
            if (r2 >= 0) goto L206
            if (r12 != 0) goto L1f4
            r1 = r16
            goto L1f5
        L1f4:
            r1 = r7
        L1f5:
            int r12 = r8.continuationPc
            int r11 = r8.continuationOp
            int r4 = r15 + 4
            int r2 = getOffset(r0, r4)
            int r4 = r4 + r2
            r15 = r0
            r13 = r1
            r0 = r20
            goto L302
        L206:
            r18 = r13
            r13 = r2
            r2 = r18
            r18 = r16
            goto L214
        L20e:
            r2 = r4
            r0 = r11
            r11 = r3
            r18 = r13
            r13 = r1
        L214:
            int r5 = r8.continuationOp
            int r6 = r8.continuationPc
            r4 = 0
            r3 = r11
            r1 = r12
            r11 = r0
            r12 = r2
            r2 = r17
            r0 = r20
            pushProgState(r0, r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L247
            int r4 = r8.continuationOp
            int r5 = r8.continuationPc
            r1 = 51
            r0 = r20
            r2 = r15
            pushBackTrackState(r0, r1, r2, r3, r4, r5)
            int r1 = getIndex(r11, r15)
            int r4 = r15 + 2
            int r2 = getIndex(r11, r4)
            r3 = r7
        L23d:
            if (r3 >= r1) goto L249
            int r4 = r2 + r3
            r0.setParens(r4, r10, r7)
            int r3 = r3 + 1
            goto L23d
        L247:
            r0 = r20
        L249:
            r2 = r11[r13]
            r1 = 49
            if (r2 == r1) goto L25a
            int r4 = r13 + 1
            r3 = r11
            r11 = r12
            r12 = r15
            r8 = r16
            r13 = r18
            goto L11b
        L25a:
            r4 = r12
            r13 = r18
            goto L17e
        L25f:
            r2 = r11
            r4 = r12
            r8 = r16
            r13 = r8
            goto L49
        L266:
            r1 = r4
            r4 = r5
            r10 = r6
            r5 = r11
            r18 = r12
            r11 = r3
            goto L3d9
        L26f:
            org.mozilla.javascript.regexp.REProgState r1 = popProgState(r0)
            int r4 = r1.index
            r0.cp = r4
            org.mozilla.javascript.regexp.REBackTrackData r4 = r1.backTrack
            r0.backTrackStackTop = r4
            int r12 = r1.continuationPc
            int r11 = r1.continuationOp
            if (r2 != r8) goto L70
            r13 = r13 ^ 1
            goto L70
        L285:
            int r1 = getIndex(r3, r15)
            int r10 = r15 + r1
            int r4 = r15 + 2
            r1 = r4
            int r4 = r15 + 3
            r2 = r3[r1]
            boolean r1 = reopIsSimple(r2)
            if (r1 == 0) goto L2b2
            r6 = 0
            r1 = r21
            r5 = r22
            int r6 = simpleMatch(r0, r1, r2, r3, r4, r5, r6)
            r15 = r2
            r17 = r4
            if (r6 < 0) goto L2b0
            r1 = r3[r6]
            if (r1 != r8) goto L2b0
            r15 = r3
            r13 = r7
            r4 = r17
            goto L302
        L2b0:
            r4 = r3
            goto L2b6
        L2b2:
            r15 = r2
            r17 = r4
            goto L2b0
        L2b6:
            int r3 = r0.cp
            r1 = r4
            org.mozilla.javascript.regexp.REBackTrackData r4 = r0.backTrackStackTop
            r2 = r1
            r1 = 0
            r5 = r2
            r2 = 0
            r6 = r11
            r11 = r5
            r5 = r6
            r6 = r12
            pushProgState(r0, r1, r2, r3, r4, r5, r6)
            r12 = r5
            r18 = r6
            pushBackTrackState(r0, r8, r10)
            r3 = r11
            r11 = r12
            r2 = r15
            r8 = r16
            r4 = r17
        L2d3:
            r12 = r18
            goto L11b
        L2d7:
            r18 = r12
            r12 = r11
            r11 = r3
            int r1 = getIndex(r11, r15)
            int r8 = r15 + r1
            int r4 = r15 + 2
            r1 = r4
            int r4 = r15 + 3
            r2 = r11[r1]
            boolean r1 = reopIsSimple(r2)
            if (r1 == 0) goto L32a
            r6 = 0
            r1 = r21
            r5 = r22
            r3 = r11
            int r6 = simpleMatch(r0, r1, r2, r3, r4, r5, r6)
            r10 = r2
            r15 = r3
            r11 = r4
            if (r6 >= 0) goto L32d
            r13 = r7
            r4 = r11
            r11 = r12
            r12 = r18
        L302:
            if (r13 != 0) goto L324
            org.mozilla.javascript.regexp.REBackTrackData r1 = r0.backTrackStackTop
            if (r1 == 0) goto L323
            org.mozilla.javascript.regexp.REBackTrackData r2 = r1.previous
            r0.backTrackStackTop = r2
            long[] r2 = r1.parens
            r0.parens = r2
            int r2 = r1.cp
            r0.cp = r2
            org.mozilla.javascript.regexp.REProgState r2 = r1.stateStackTop
            r0.stateStackTop = r2
            int r11 = r1.continuationOp
            int r12 = r1.continuationPc
            int r4 = r1.pc
            int r2 = r1.op
        L320:
            r3 = r15
            goto L119
        L323:
            return r7
        L324:
            int r1 = r4 + 1
            r2 = r15[r4]
            r4 = r1
            goto L320
        L32a:
            r10 = r2
            r15 = r11
            r11 = r4
        L32d:
            int r3 = r0.cp
            org.mozilla.javascript.regexp.REBackTrackData r4 = r0.backTrackStackTop
            r1 = 0
            r2 = 0
            r5 = r12
            r6 = r18
            pushProgState(r0, r1, r2, r3, r4, r5, r6)
            r1 = 43
            pushBackTrackState(r0, r1, r8)
            r2 = r10
            r4 = r11
            r11 = r12
            r3 = r15
        L342:
            r8 = r16
            goto L2d3
        L345:
            r18 = r12
            r12 = r11
            int r1 = getOffset(r3, r15)
            int r4 = r15 + r1
            int r1 = r4 + 1
            r2 = r3[r4]
            r4 = r1
            goto L2d3
        L355:
            r4 = r15
            goto Ld0
        L358:
            int r1 = getOffset(r3, r4)
            int r8 = r4 + r1
            int r1 = r4 + 2
            int r4 = r4 + 3
            r2 = r3[r1]
            int r10 = r0.cp
            boolean r1 = reopIsSimple(r2)
            if (r1 == 0) goto L38a
            r6 = 1
            r1 = r21
            r5 = r22
            int r2 = simpleMatch(r0, r1, r2, r3, r4, r5, r6)
            r11 = r3
            if (r2 >= 0) goto L381
            int r4 = r8 + 1
            r2 = r11[r8]
            r0 = r20
            r3 = r11
            r11 = r12
            goto L342
        L381:
            int r0 = r2 + 1
            r1 = r11[r2]
            r13 = r0
            r6 = r1
            r15 = r16
            goto L38e
        L38a:
            r11 = r3
            r6 = r2
            r15 = r13
            r13 = r4
        L38e:
            int r2 = r8 + 1
            r1 = r11[r8]
            r0 = r20
            r3 = r10
            r4 = r12
            r5 = r18
            pushBackTrackState(r0, r1, r2, r3, r4, r5)
            r5 = r4
            r2 = r6
            r3 = r11
            r4 = r13
            r13 = r15
            r8 = r16
            r12 = r18
        L3a4:
            r10 = 57
            r11 = r5
            goto L49
        L3a9:
            r5 = r11
            r18 = r12
            r11 = r3
            int r1 = getIndex(r11, r15)
            int r4 = r15 + 2
            int r2 = r0.parensIndex(r1)
            int r3 = r0.cp
            int r3 = r3 - r2
            r0.setParens(r1, r2, r3)
            int r1 = r15 + 3
            r2 = r11[r4]
            r4 = r1
            r3 = r11
            goto L3a4
        L3c4:
            r5 = r11
            r18 = r12
            r11 = r3
            int r1 = getIndex(r11, r15)
            int r4 = r15 + 2
            int r2 = r0.cp
            r0.setParens(r1, r2, r7)
            int r1 = r15 + 3
            r2 = r11[r4]
            r4 = r1
            goto L3a4
        L3d9:
            switch(r2) {
                case 25: goto L400;
                case 26: goto L3fa;
                case 27: goto L3f3;
                case 28: goto L3ec;
                default: goto L3dc;
            }
        L3dc:
            switch(r2) {
                case 45: goto L3ea;
                case 46: goto L3e8;
                case 47: goto L3e6;
                case 48: goto L3e4;
                default: goto L3df;
            }
        L3df:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L3e4:
            r2 = r7
            goto L402
        L3e6:
            r2 = r7
            goto L3ee
        L3e8:
            r2 = r7
            goto L3f5
        L3ea:
            r2 = r7
            goto L3fc
        L3ec:
            r2 = r16
        L3ee:
            r8 = r2
            r3 = r7
            r2 = r16
            goto L413
        L3f3:
            r2 = r16
        L3f5:
            r8 = r2
            r2 = r10
            r3 = r16
            goto L413
        L3fa:
            r2 = r16
        L3fc:
            r8 = r2
            r3 = r7
            r2 = r10
            goto L413
        L400:
            r2 = r16
        L402:
            int r3 = getOffset(r11, r15)
            int r6 = r15 + 2
            int r6 = getOffset(r11, r6)
            int r6 = r6 + (-1)
            int r8 = r15 + 4
            r15 = r8
            r8 = r2
            r2 = r6
        L413:
            int r6 = r0.cp
            r12 = r4
            r4 = 0
            r10 = r12
            r12 = r1
            r1 = r3
            r3 = r6
            r6 = r18
            pushProgState(r0, r1, r2, r3, r4, r5, r6)
            if (r8 == 0) goto L428
            pushBackTrackState(r0, r12, r15)
            int r1 = r15 + 6
            goto L43e
        L428:
            if (r1 == 0) goto L42e
            int r1 = r15 + 6
            r12 = r10
            goto L43e
        L42e:
            pushBackTrackState(r0, r10, r15)
            popProgState(r0)
            int r15 = r15 + 4
            int r1 = getOffset(r11, r15)
            int r1 = r1 + r15
            r12 = r5
            r15 = r18
        L43e:
            int r4 = r1 + 1
            r2 = r11[r1]
            goto L116
        L444:
            r16 = r8
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.executeREBytecode(org.mozilla.javascript.Context, org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int):boolean");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            char cCharAt = str.charAt(rEGlobalData.cp + i4);
            if (c != cCharAt && upcase(c) != upcase(cCharAt)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.cp + i4)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getDecimalValue(char c, CompilerState compilerState, String str) {
        int i = compilerState.cp;
        char[] cArr = compilerState.cpbegin;
        int i2 = c - '0';
        boolean z = false;
        while (true) {
            int i3 = compilerState.cp;
            if (i3 == compilerState.cpend) {
                break;
            }
            char c2 = cArr[i3];
            if (!isDigit(c2)) {
                break;
            }
            if (!z && (i2 = (i2 * 10) + (c2 - '0')) >= 65535) {
                i2 = 65535;
                z = true;
            }
            compilerState.cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i, compilerState.cp - i));
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static RegExpImpl getImpl(Context context) {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeRegExp nativeRegExpWithLanguageVersion = NativeRegExpInstantiator.withLanguageVersion(context.getLanguageVersion());
        nativeRegExpWithLanguageVersion.re = compileRE(context, "", null, false);
        nativeRegExpWithLanguageVersion.activatePrototypeMap(9);
        nativeRegExpWithLanguageVersion.setParentScope(scriptable);
        nativeRegExpWithLanguageVersion.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExpWithLanguageVersion.defineProperty("constructor", nativeRegExpCtor, 2);
        ScriptRuntime.setFunctionProtoAndParent(nativeRegExpCtor, context, scriptable);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExpWithLanguageVersion);
        if (z) {
            nativeRegExpWithLanguageVersion.sealObject();
            nativeRegExpCtor.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "RegExp", nativeRegExpCtor, 2);
        ScriptRuntimeES6.addSymbolSpecies(context, scriptable, nativeRegExpCtor);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isControlLetter(char c) {
        if ('a' > c || c > 'z') {
            return 'A' <= c && c <= 'Z';
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isLineTerm(char c) {
        return ScriptRuntime.isJSLineTerminator(c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isWord(char c) {
        if ('a' > c || c > 'z') {
            return ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_SymbolMatchAll(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!ScriptRuntime.isObject(scriptable2)) {
            throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(scriptable2));
        }
        String string = ScriptRuntime.toString(objArr.length > 0 ? objArr[0] : Undefined.instance);
        Constructable constructableSpeciesConstructor = AbstractEcmaObjectOperations.speciesConstructor(context, scriptable2, ScriptRuntime.getExistingCtor(context, ScriptableObject.getTopLevelScope(scriptable), getClassName()));
        String string2 = ScriptRuntime.toString(ScriptRuntime.getObjectProp(scriptable2, "flags", context));
        Scriptable scriptableConstruct = constructableSpeciesConstructor.construct(context, scriptable, new Object[]{scriptable2, string2});
        ScriptRuntime.setObjectProp(scriptableConstruct, "lastIndex", (Object) Long.valueOf(ScriptRuntime.toLength(ScriptRuntime.getObjectProp(scriptable2, "lastIndex", context))), context);
        return new NativeRegExpStringIterator(scriptable, scriptableConstruct, string, string2.indexOf(103) != -1, (string2.indexOf(Token.OR) == -1 && string2.indexOf(Token.AND) == -1) ? false : true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object js_exec(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return realThis(scriptable2, "exec").execSub(context, scriptable, objArr, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean matchRegExp(Context context, REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        int i3 = rECompiled.parenCount;
        if (i3 != 0) {
            rEGlobalData.parens = new long[i3];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        rEGlobalData.multiline = z || (rECompiled.flags & 4) != 0;
        rEGlobalData.regexp = rECompiled;
        int i4 = rECompiled.anchorCh;
        int i5 = i;
        while (i5 <= i2) {
            if (i4 >= 0) {
                while (i5 != i2) {
                    char cCharAt = str.charAt(i5);
                    if (cCharAt != i4 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(cCharAt) != upcase((char) i4))) {
                        if ((rEGlobalData.regexp.flags & 16) != 0) {
                            return false;
                        }
                        i5++;
                    }
                }
                return false;
            }
            rEGlobalData.cp = i5;
            rEGlobalData.skipped = i5 - i;
            for (int i6 = 0; i6 < rECompiled.parenCount; i6++) {
                rEGlobalData.parens[i6] = -1;
            }
            boolean zExecuteREBytecode = executeREBytecode(context, rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (zExecuteREBytecode) {
                return true;
            }
            if (i4 == ANCHOR_BOL && !rEGlobalData.multiline) {
                rEGlobalData.skipped = i2;
                return false;
            }
            if ((rEGlobalData.regexp.flags & 16) != 0) {
                return false;
            }
            i5 = rEGlobalData.skipped + i + 1;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0033, code lost:
    
        r5.result = new org.mozilla.javascript.regexp.RENode((byte) 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        r5.result = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean parseAlternative(CompilerState compilerState) {
        char c;
        char[] cArr = compilerState.cpbegin;
        RENode rENode = null;
        RENode rENode2 = null;
        while (true) {
            int i = compilerState.cp;
            if (i == compilerState.cpend || (c = cArr[i]) == '|' || (compilerState.parenNesting != 0 && c == ')')) {
                break;
            }
            if (!parseTerm(compilerState)) {
                return false;
            }
            RENode rENode3 = compilerState.result;
            if (rENode == null) {
                rENode = rENode3;
                rENode2 = rENode;
            } else {
                rENode2.next = rENode3;
            }
            while (true) {
                RENode rENode4 = rENode2.next;
                if (rENode4 != null) {
                    rENode2 = rENode4;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean parseDisjunction(CompilerState compilerState) {
        int i;
        int i2;
        if (!parseAlternative(compilerState)) {
            return false;
        }
        char[] cArr = compilerState.cpbegin;
        int i3 = compilerState.cp;
        if (i3 != cArr.length && cArr[i3] == '|') {
            compilerState.cp = i3 + 1;
            RENode rENode = new RENode(REOP_ALT);
            rENode.kid = compilerState.result;
            if (!parseDisjunction(compilerState)) {
                return false;
            }
            RENode rENode2 = compilerState.result;
            rENode.kid2 = rENode2;
            compilerState.result = rENode;
            RENode rENode3 = rENode.kid;
            byte b = rENode3.op;
            if (b == 14 && rENode2.op == 14) {
                rENode.op = (compilerState.flags & 2) == 0 ? REOP_ALTPREREQ : REOP_ALTPREREQi;
                rENode.chr = rENode3.chr;
                rENode.index = rENode2.chr;
                compilerState.progLength += 13;
            } else if (b == 22 && (i2 = rENode3.index) < 256 && rENode2.op == 14 && (compilerState.flags & 2) == 0) {
                rENode.op = REOP_ALTPREREQ2;
                rENode.chr = rENode2.chr;
                rENode.index = i2;
                compilerState.progLength += 13;
            } else if (b == 14 && rENode2.op == 22 && (i = rENode2.index) < 256 && (compilerState.flags & 2) == 0) {
                rENode.op = REOP_ALTPREREQ2;
                rENode.chr = rENode3.chr;
                rENode.index = i;
                compilerState.progLength += 13;
            } else {
                compilerState.progLength += 9;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:204:0x0164 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143  */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33, types: [int] */
    /* JADX WARN: Type inference failed for: r3v34, types: [int] */
    /* JADX WARN: Type inference failed for: r3v38, types: [char] */
    /* JADX WARN: Type inference failed for: r3v62 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean parseTerm(CompilerState compilerState) {
        boolean z;
        boolean z2;
        char c;
        char c2;
        int i;
        char c3;
        int iXDigitToInt;
        RENode rENode;
        char c4;
        char[] cArr = compilerState.cpbegin;
        int i2 = compilerState.cp;
        int i3 = i2 + 1;
        compilerState.cp = i3;
        char c5 = cArr[i2];
        int i4 = compilerState.parenCount;
        if (c5 == '$') {
            compilerState.result = new RENode(REOP_EOL);
            compilerState.progLength++;
            return true;
        }
        if (c5 != '.') {
            if (c5 == '?') {
                z = false;
            } else {
                if (c5 == '^') {
                    compilerState.result = new RENode((byte) 2);
                    compilerState.progLength++;
                    return true;
                }
                char c6 = '\\';
                z = false;
                if (c5 != '[') {
                    int i5 = 4;
                    if (c5 != '\\') {
                        switch (c5) {
                            case '(':
                                if (i2 + 2 < compilerState.cpend && cArr[i3] == '?' && ((c4 = cArr[i2 + 2]) == '=' || c4 == '!' || c4 == ':')) {
                                    compilerState.cp = i2 + 3;
                                    if (c4 == '=') {
                                        rENode = new RENode(REOP_ASSERT);
                                        compilerState.progLength += 4;
                                    } else if (c4 == '!') {
                                        rENode = new RENode(REOP_ASSERT_NOT);
                                        compilerState.progLength += 4;
                                    } else {
                                        rENode = null;
                                    }
                                } else {
                                    rENode = new RENode(REOP_LPAREN);
                                    compilerState.progLength += 6;
                                    int i6 = compilerState.parenCount;
                                    compilerState.parenCount = i6 + 1;
                                    rENode.parenIndex = i6;
                                }
                                compilerState.parenNesting++;
                                if (!parseDisjunction(compilerState)) {
                                    return false;
                                }
                                int i7 = compilerState.cp;
                                if (i7 == compilerState.cpend || cArr[i7] != ')') {
                                    reportError("msg.unterm.paren", "");
                                    return false;
                                }
                                compilerState.cp = i7 + 1;
                                compilerState.parenNesting--;
                                if (rENode != null) {
                                    rENode.kid = compilerState.result;
                                    compilerState.result = rENode;
                                }
                                break;
                                break;
                            case Token.SETELEM /* 41 */:
                                reportError("msg.re.unmatched.right.paren", "");
                                return false;
                            case Token.SETELEM_SUPER /* 42 */:
                            case Token.CALL /* 43 */:
                                break;
                            default:
                                RENode rENode2 = new RENode(REOP_FLAT);
                                compilerState.result = rENode2;
                                rENode2.chr = c5;
                                rENode2.length = 1;
                                rENode2.flatIndex = compilerState.cp - 1;
                                compilerState.progLength += 3;
                                break;
                        }
                    } else {
                        int i8 = compilerState.cpend;
                        if (i3 >= i8) {
                            reportError("msg.trail.backslash", "");
                            return false;
                        }
                        int i9 = i2 + 2;
                        compilerState.cp = i9;
                        char c7 = cArr[i3];
                        if (c7 == 'B') {
                            compilerState.result = new RENode(REOP_WNONBDRY);
                            compilerState.progLength++;
                            return true;
                        }
                        if (c7 == 'D') {
                            compilerState.result = new RENode(REOP_NONDIGIT);
                            compilerState.progLength++;
                        } else if (c7 == 'S') {
                            compilerState.result = new RENode(REOP_NONSPACE);
                            compilerState.progLength++;
                        } else if (c7 == 'W') {
                            compilerState.result = new RENode(REOP_NONALNUM);
                            compilerState.progLength++;
                        } else if (c7 == 'f') {
                            doFlat(compilerState, '\f');
                        } else if (c7 != 'n') {
                            switch (c7) {
                                case '0':
                                    reportWarning(compilerState.cx, "msg.bad.backref", "");
                                    int i10 = 0;
                                    while (i10 < 32) {
                                        int i11 = compilerState.cp;
                                        if (i11 >= compilerState.cpend || (c = cArr[i11]) < '0' || c > '7') {
                                            doFlat(compilerState, (char) i10);
                                        } else {
                                            compilerState.cp = i11 + 1;
                                            i10 = (i10 * 8) + (c - '0');
                                        }
                                        break;
                                    }
                                    doFlat(compilerState, (char) i10);
                                    break;
                                case Token.FALSE /* 49 */:
                                case '2':
                                case Token.SHEQ /* 51 */:
                                case Token.SHNE /* 52 */:
                                case Token.REGEXP /* 53 */:
                                case Token.BINDNAME /* 54 */:
                                case Token.THROW /* 55 */:
                                case Token.RETHROW /* 56 */:
                                case Token.IN /* 57 */:
                                    int i12 = i2 + 1;
                                    int decimalValue = getDecimalValue(c7, compilerState, "msg.overlarge.backref");
                                    if (decimalValue > compilerState.backReferenceLimit) {
                                        reportWarning(compilerState.cx, "msg.bad.backref", "");
                                    }
                                    if (decimalValue <= compilerState.backReferenceLimit) {
                                        RENode rENode3 = new RENode(REOP_BACKREF);
                                        compilerState.result = rENode3;
                                        rENode3.parenIndex = decimalValue - 1;
                                        compilerState.progLength += 3;
                                        if (compilerState.maxBackReference < decimalValue) {
                                            compilerState.maxBackReference = decimalValue;
                                        }
                                    } else {
                                        compilerState.cp = i12;
                                        if (c7 < '8') {
                                            compilerState.cp = i2 + 2;
                                            int i13 = c7 - '0';
                                            while (i13 < 32) {
                                                int i14 = compilerState.cp;
                                                if (i14 >= compilerState.cpend || (c2 = cArr[i14]) < '0' || c2 > '7') {
                                                    doFlat(compilerState, (char) i13);
                                                } else {
                                                    compilerState.cp = i14 + 1;
                                                    i13 = (i13 * 8) + (c2 - '0');
                                                }
                                                break;
                                            }
                                            doFlat(compilerState, (char) i13);
                                        } else {
                                            doFlat(compilerState, '\\');
                                        }
                                    }
                                    break;
                                default:
                                    switch (c7) {
                                        case Token.COMMA /* 98 */:
                                            compilerState.result = new RENode((byte) 4);
                                            compilerState.progLength++;
                                            return true;
                                        case 'c':
                                            if (i9 >= i8 || !isControlLetter(cArr[i9])) {
                                                compilerState.cp--;
                                            } else {
                                                int i15 = compilerState.cp;
                                                compilerState.cp = i15 + 1;
                                                c6 = (char) (cArr[i15] & 31);
                                            }
                                            doFlat(compilerState, c6);
                                            break;
                                        case 'd':
                                            compilerState.result = new RENode(REOP_DIGIT);
                                            compilerState.progLength++;
                                            break;
                                        default:
                                            switch (c7) {
                                                case 'r':
                                                    doFlat(compilerState, '\r');
                                                    break;
                                                case Token.HOOK /* 115 */:
                                                    compilerState.result = new RENode(REOP_SPACE);
                                                    compilerState.progLength++;
                                                    break;
                                                case Token.COLON /* 116 */:
                                                    doFlat(compilerState, '\t');
                                                    break;
                                                case Token.OR /* 117 */:
                                                    i = 0;
                                                    c3 = 0;
                                                    while (true) {
                                                        if (i < i5) {
                                                            int i16 = compilerState.cp;
                                                            if (i16 < compilerState.cpend) {
                                                                compilerState.cp = i16 + 1;
                                                                iXDigitToInt = Kit.xDigitToInt(cArr[i16], c3);
                                                                if (iXDigitToInt < 0) {
                                                                    int i17 = compilerState.cp - (i + 2);
                                                                    compilerState.cp = i17 + 1;
                                                                    c3 = cArr[i17];
                                                                } else {
                                                                    i++;
                                                                    c3 = iXDigitToInt;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    doFlat(compilerState, (char) c3);
                                                    break;
                                                case Token.AND /* 118 */:
                                                    doFlat(compilerState, (char) 11);
                                                    break;
                                                case Token.INC /* 119 */:
                                                    compilerState.result = new RENode(REOP_ALNUM);
                                                    compilerState.progLength++;
                                                    break;
                                                case 'x':
                                                    i5 = 2;
                                                    i = 0;
                                                    c3 = 0;
                                                    while (true) {
                                                        if (i < i5) {
                                                        }
                                                        i++;
                                                        c3 = iXDigitToInt;
                                                    }
                                                    doFlat(compilerState, (char) c3);
                                                    break;
                                                default:
                                                    RENode rENode4 = new RENode(REOP_FLAT);
                                                    compilerState.result = rENode4;
                                                    rENode4.chr = c7;
                                                    rENode4.length = 1;
                                                    rENode4.flatIndex = compilerState.cp - 1;
                                                    compilerState.progLength += 3;
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            doFlat(compilerState, '\n');
                        }
                    }
                } else {
                    RENode rENode5 = new RENode(REOP_CLASS);
                    compilerState.result = rENode5;
                    int i18 = compilerState.cp;
                    rENode5.startIndex = i18;
                    while (true) {
                        int i19 = compilerState.cp;
                        if (i19 == compilerState.cpend) {
                            reportError("msg.unterm.class", "");
                            return false;
                        }
                        char c8 = cArr[i19];
                        if (c8 == '\\') {
                            compilerState.cp = i19 + 1;
                        } else if (c8 == ']') {
                            RENode rENode6 = compilerState.result;
                            rENode6.kidlen = i19 - i18;
                            int i20 = compilerState.classCount;
                            compilerState.classCount = i20 + 1;
                            rENode6.index = i20;
                            compilerState.cp = i19 + 1;
                            if (!calculateBitmapSize(compilerState, rENode6, cArr, i18, i19)) {
                                return false;
                            }
                            compilerState.progLength += 3;
                        }
                        compilerState.cp++;
                    }
                }
            }
            reportError("msg.bad.quant", String.valueOf(cArr[i2]));
            return z;
        }
        z = false;
        compilerState.result = new RENode(REOP_DOT);
        compilerState.progLength++;
        RENode rENode7 = compilerState.result;
        int i21 = compilerState.cp;
        if (i21 == compilerState.cpend) {
            return true;
        }
        char c9 = cArr[i21];
        int decimalValue2 = -1;
        if (c9 == '*') {
            RENode rENode8 = new RENode(REOP_QUANT);
            compilerState.result = rENode8;
            rENode8.min = 0;
            rENode8.max = -1;
            compilerState.progLength += 8;
        } else if (c9 == '+') {
            RENode rENode9 = new RENode(REOP_QUANT);
            compilerState.result = rENode9;
            rENode9.min = 1;
            rENode9.max = -1;
            compilerState.progLength += 8;
        } else {
            if (c9 != '?') {
                if (c9 != '{') {
                    z2 = z;
                } else {
                    int i22 = i21 + 1;
                    compilerState.cp = i22;
                    if (i22 < cArr.length) {
                        char c10 = cArr[i22];
                        if (isDigit(c10)) {
                            compilerState.cp++;
                            int decimalValue3 = getDecimalValue(c10, compilerState, "msg.overlarge.min");
                            int i23 = compilerState.cp;
                            if (i23 >= cArr.length) {
                                z2 = z;
                                if (!z2) {
                                    compilerState.cp = i21;
                                }
                            } else {
                                char c11 = cArr[i23];
                                if (c11 == ',') {
                                    int i24 = i23 + 1;
                                    compilerState.cp = i24;
                                    if (i24 < cArr.length) {
                                        c11 = cArr[i24];
                                        if (isDigit(c11)) {
                                            int i25 = compilerState.cp + 1;
                                            compilerState.cp = i25;
                                            if (i25 < cArr.length) {
                                                decimalValue2 = getDecimalValue(c11, compilerState, "msg.overlarge.max");
                                                c11 = cArr[compilerState.cp];
                                                if (decimalValue3 > decimalValue2) {
                                                    throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessageById("msg.max.lt.min", Integer.valueOf(decimalValue2), Integer.valueOf(decimalValue3)));
                                                }
                                            }
                                        }
                                    } else {
                                        decimalValue2 = decimalValue3;
                                    }
                                    if (c11 == '}') {
                                        RENode rENode10 = new RENode(REOP_QUANT);
                                        compilerState.result = rENode10;
                                        rENode10.min = decimalValue3;
                                        rENode10.max = decimalValue2;
                                        compilerState.progLength += 12;
                                        z2 = true;
                                    }
                                    if (!z2) {
                                    }
                                }
                            }
                        }
                    }
                }
                if (z2) {
                    return true;
                }
                int i26 = compilerState.cp;
                int i27 = i26 + 1;
                compilerState.cp = i27;
                RENode rENode11 = compilerState.result;
                rENode11.kid = rENode7;
                rENode11.parenIndex = i4;
                rENode11.parenCount = compilerState.parenCount - i4;
                if (i27 >= compilerState.cpend || cArr[i27] != '?') {
                    rENode11.greedy = true;
                } else {
                    compilerState.cp = i26 + 2;
                    rENode11.greedy = false;
                }
                return true;
            }
            RENode rENode12 = new RENode(REOP_QUANT);
            compilerState.result = rENode12;
            rENode12.min = z ? 1 : 0;
            rENode12.max = 1;
            compilerState.progLength += 8;
        }
        z2 = true;
        if (z2) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            try {
                if (!rECharSet.converted) {
                    processCharSetImpl(rEGlobalData, rECharSet);
                    rECharSet.converted = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0056. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0059. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:40:0x0081
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static void processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData r17, org.mozilla.javascript.regexp.RECharSet r18) {
        /*
            r0 = r17
            r1 = r18
            int r2 = r1.startIndex
            int r3 = r1.strlength
            int r3 = r3 + r2
            int r4 = r1.length
            int r4 = r4 + 7
            r5 = 8
            int r4 = r4 / r5
            byte[] r4 = new byte[r4]
            r1.bits = r4
            if (r2 != r3) goto L18
            goto L1be
        L18:
            org.mozilla.javascript.regexp.RECompiled r4 = r0.regexp
            char[] r4 = r4.source
            char r4 = r4[r2]
            r6 = 94
            r7 = 0
            if (r4 != r6) goto L25
            int r2 = r2 + 1
        L25:
            r4 = r7
            r6 = r4
        L27:
            if (r2 == r3) goto L1be
            org.mozilla.javascript.regexp.RECompiled r8 = r0.regexp
            char[] r8 = r8.source
            char r9 = r8[r2]
            r10 = 92
            r11 = 2
            r12 = 45
            r13 = 1
            if (r9 != r10) goto L167
            int r9 = r2 + 1
            int r14 = r2 + 2
            char r9 = r8[r9]
            r15 = 68
            if (r9 == r15) goto L152
            r15 = 83
            if (r9 == r15) goto L13a
            r15 = 87
            if (r9 == r15) goto L11d
            r15 = 102(0x66, float:1.43E-43)
            if (r9 == r15) goto L119
            r15 = 110(0x6e, float:1.54E-43)
            if (r9 == r15) goto L115
            r15 = 48
            switch(r9) {
                case 48: goto Lec;
                case 49: goto Lec;
                case 50: goto Lec;
                case 51: goto Lec;
                case 52: goto Lec;
                case 53: goto Lec;
                case 54: goto Lec;
                case 55: goto Lec;
                default: goto L56;
            }
        L56:
            switch(r9) {
                case 98: goto Le9;
                case 99: goto Lcd;
                case 100: goto Lc1;
                default: goto L59;
            }
        L59:
            switch(r9) {
                case 114: goto Lbe;
                case 115: goto La6;
                case 116: goto La3;
                case 117: goto L7e;
                case 118: goto L7b;
                case 119: goto L61;
                case 120: goto L5f;
                default: goto L5c;
            }
        L5c:
            r2 = r14
            goto L169
        L5f:
            r2 = r11
            goto L7f
        L61:
            if (r4 == 0) goto L67
            addCharacterToCharSet(r1, r12)
            r4 = r7
        L67:
            int r2 = r1.length
            int r2 = r2 - r13
        L6a:
            if (r2 < 0) goto L79
            char r8 = (char) r2
            boolean r9 = isWord(r8)
            if (r9 == 0) goto L76
            addCharacterToCharSet(r1, r8)
        L76:
            int r2 = r2 + (-1)
            goto L6a
        L79:
            r2 = r14
            goto L27
        L7b:
            r9 = 11
            goto L5c
        L7e:
            r2 = 4
        L7f:
            r8 = r7
            r9 = r8
        L81:
            if (r8 >= r2) goto La0
            if (r14 >= r3) goto La0
            org.mozilla.javascript.regexp.RECompiled r15 = r0.regexp
            char[] r15 = r15.source
            int r16 = r14 + 1
            char r14 = r15[r14]
            int r14 = toASCIIHexDigit(r14)
            if (r14 >= 0) goto L98
            int r8 = r8 + 1
            int r14 = r16 - r8
            goto La1
        L98:
            int r9 = r9 << 4
            r9 = r9 | r14
            int r8 = r8 + 1
            r14 = r16
            goto L81
        La0:
            r10 = r9
        La1:
            char r9 = (char) r10
            goto L5c
        La3:
            r9 = 9
            goto L5c
        La6:
            if (r4 == 0) goto Lac
            addCharacterToCharSet(r1, r12)
            r4 = r7
        Lac:
            int r2 = r1.length
            int r2 = r2 - r13
        Laf:
            if (r2 < 0) goto L79
            boolean r8 = isREWhiteSpace(r2)
            if (r8 == 0) goto Lbb
            char r8 = (char) r2
            addCharacterToCharSet(r1, r8)
        Lbb:
            int r2 = r2 + (-1)
            goto Laf
        Lbe:
            r9 = 13
            goto L5c
        Lc1:
            if (r4 == 0) goto Lc7
            addCharacterToCharSet(r1, r12)
            r4 = r7
        Lc7:
            r2 = 57
            addCharacterRangeToCharSet(r1, r15, r2)
            goto L79
        Lcd:
            if (r14 >= r3) goto Le4
            char r8 = r8[r14]
            boolean r8 = isControlLetter(r8)
            if (r8 == 0) goto Le4
            org.mozilla.javascript.regexp.RECompiled r8 = r0.regexp
            char[] r8 = r8.source
            int r2 = r2 + 3
            char r8 = r8[r14]
            r8 = r8 & 31
            char r9 = (char) r8
            goto L169
        Le4:
            int r2 = r2 + 1
            r9 = r10
            goto L169
        Le9:
            r9 = r5
            goto L5c
        Lec:
            int r9 = r9 + (-48)
            char r10 = r8[r14]
            if (r15 > r10) goto L112
            r5 = 55
            if (r10 > r5) goto L112
            int r14 = r2 + 3
            int r9 = r9 * 8
            int r10 = r10 + (-48)
            int r9 = r9 + r10
            char r8 = r8[r14]
            if (r15 > r8) goto L112
            if (r8 > r5) goto L112
            int r14 = r2 + 4
            int r5 = r9 * 8
            int r8 = r8 + (-48)
            int r5 = r5 + r8
            r8 = 255(0xff, float:3.57E-43)
            if (r5 > r8) goto L110
            r9 = r5
            goto L112
        L110:
            int r14 = r2 + 3
        L112:
            char r9 = (char) r9
            goto L5c
        L115:
            r9 = 10
            goto L5c
        L119:
            r9 = 12
            goto L5c
        L11d:
            if (r4 == 0) goto L123
            addCharacterToCharSet(r1, r12)
            r4 = r7
        L123:
            int r2 = r1.length
            int r2 = r2 - r13
        L126:
            if (r2 < 0) goto L135
            char r5 = (char) r2
            boolean r8 = isWord(r5)
            if (r8 != 0) goto L132
            addCharacterToCharSet(r1, r5)
        L132:
            int r2 = r2 + (-1)
            goto L126
        L135:
            r2 = r14
        L136:
            r5 = 8
            goto L27
        L13a:
            if (r4 == 0) goto L140
            addCharacterToCharSet(r1, r12)
            r4 = r7
        L140:
            int r2 = r1.length
            int r2 = r2 - r13
        L143:
            if (r2 < 0) goto L135
            boolean r5 = isREWhiteSpace(r2)
            if (r5 != 0) goto L14f
            char r5 = (char) r2
            addCharacterToCharSet(r1, r5)
        L14f:
            int r2 = r2 + (-1)
            goto L143
        L152:
            if (r4 == 0) goto L158
            addCharacterToCharSet(r1, r12)
            r4 = r7
        L158:
            r2 = 47
            addCharacterRangeToCharSet(r1, r7, r2)
            int r2 = r1.length
            int r2 = r2 - r13
            char r2 = (char) r2
            r5 = 58
            addCharacterRangeToCharSet(r1, r5, r2)
            goto L135
        L167:
            int r2 = r2 + 1
        L169:
            org.mozilla.javascript.regexp.RECompiled r5 = r0.regexp
            if (r4 == 0) goto L195
            int r4 = r5.flags
            r4 = r4 & r11
            if (r4 == 0) goto L190
            r4 = r6
        L173:
            if (r4 > r9) goto L193
            addCharacterToCharSet(r1, r4)
            char r5 = upcase(r4)
            char r8 = downcase(r4)
            if (r4 == r5) goto L185
            addCharacterToCharSet(r1, r5)
        L185:
            if (r4 == r8) goto L18a
            addCharacterToCharSet(r1, r8)
        L18a:
            int r4 = r4 + 1
            char r4 = (char) r4
            if (r4 != 0) goto L173
            goto L193
        L190:
            addCharacterRangeToCharSet(r1, r6, r9)
        L193:
            r4 = r7
            goto L136
        L195:
            int r5 = r5.flags
            r5 = r5 & r11
            if (r5 == 0) goto L1a9
            char r5 = upcase(r9)
            addCharacterToCharSet(r1, r5)
            char r5 = downcase(r9)
            addCharacterToCharSet(r1, r5)
            goto L1ac
        L1a9:
            addCharacterToCharSet(r1, r9)
        L1ac:
            int r5 = r3 + (-1)
            if (r2 >= r5) goto L136
            org.mozilla.javascript.regexp.RECompiled r5 = r0.regexp
            char[] r5 = r5.source
            char r5 = r5[r2]
            if (r5 != r12) goto L136
            int r2 = r2 + 1
            r6 = r9
            r4 = r13
            goto L136
        L1be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData, org.mozilla.javascript.regexp.RECharSet):void");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, rEGlobalData.cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeRegExp realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        return realThis(scriptable, idFunctionObject.getFunctionName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean reopIsSimple(int i) {
        return i >= 1 && i <= 23;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void reportError(String str, String str2) {
        throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessageById(str, str2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void reportWarning(Context context, String str, String str2) {
        if (context.hasFeature(11)) {
            Context.reportWarning(ScriptRuntime.getMessageById(str, str2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw Kit.codeBug();
        }
        addIndex(bArr, i, i2 - i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setLastIndex(Object obj) {
        if ((this.lastIndexAttr & 1) != 0) {
            throw ScriptRuntime.typeErrorById("msg.modify.readonly", "lastIndex");
        }
        this.lastIndex = obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[PHI: r7
      0x002d: PHI (r7v9 int) = 
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v5 int)
      (r7v7 int)
      (r7v7 int)
      (r7v8 int)
      (r7v8 int)
      (r7v10 int)
      (r7v10 int)
     binds: [B:105:0x01bc, B:107:0x01c8, B:99:0x01ab, B:101:0x01b5, B:67:0x0147, B:71:0x0159, B:63:0x0134, B:65:0x013e, B:59:0x0121, B:61:0x012b, B:55:0x010e, B:57:0x0118, B:51:0x00fb, B:53:0x0105, B:47:0x00e8, B:49:0x00f2, B:43:0x00d5, B:45:0x00df, B:34:0x008e, B:20:0x005b, B:22:0x0061, B:13:0x0039, B:17:0x0049, B:7:0x0014, B:9:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0183 A[PHI: r5
      0x0183: PHI (r5v10 boolean) = (r5v5 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:95:0x01a4, B:80:0x0176, B:82:0x0180] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int simpleMatch(REGlobalData rEGlobalData, String str, int i, byte[] bArr, int i2, int i3, boolean z) {
        boolean z2;
        int i4;
        char cCharAt;
        int i5 = rEGlobalData.cp;
        boolean zBackrefMatcher = true;
        switch (i) {
            case 1:
                if (zBackrefMatcher) {
                    rEGlobalData.cp = i5;
                    return -1;
                }
                if (!z) {
                    rEGlobalData.cp = i5;
                }
                return i2;
            case 2:
                if (i5 != 0 && (!rEGlobalData.multiline || !isLineTerm(str.charAt(i5 - 1)))) {
                    zBackrefMatcher = false;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 3:
                if (i5 != i3 && (!rEGlobalData.multiline || !isLineTerm(str.charAt(i5)))) {
                }
                if (zBackrefMatcher) {
                }
                break;
            case 4:
                z2 = i5 == 0 || !isWord(str.charAt(i5 + (-1)));
                int i6 = rEGlobalData.cp;
                if (i6 < i3 && isWord(str.charAt(i6))) {
                    zBackrefMatcher = false;
                }
                zBackrefMatcher ^= z2;
                if (zBackrefMatcher) {
                }
                break;
            case 5:
                z2 = i5 == 0 || !isWord(str.charAt(i5 + (-1)));
                int i7 = rEGlobalData.cp;
                if (i7 >= i3 || !isWord(str.charAt(i7))) {
                }
                zBackrefMatcher ^= z2;
                if (zBackrefMatcher) {
                }
                break;
            case 6:
                if (i5 != i3 && ((rEGlobalData.regexp.flags & 8) != 0 || !isLineTerm(str.charAt(i5)))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 7:
                if (i5 != i3 && isDigit(str.charAt(i5))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 8:
                if (i5 != i3 && !isDigit(str.charAt(i5))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 9:
                if (i5 != i3 && isWord(str.charAt(i5))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 10:
                if (i5 != i3 && !isWord(str.charAt(i5))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 11:
                if (i5 != i3 && isREWhiteSpace(str.charAt(i5))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 12:
                if (i5 != i3 && !isREWhiteSpace(str.charAt(i5))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 13:
                int index = getIndex(bArr, i2);
                i2 += 2;
                zBackrefMatcher = backrefMatcher(rEGlobalData, index, str, i3);
                if (zBackrefMatcher) {
                }
                break;
            case 14:
                int index2 = getIndex(bArr, i2);
                int index3 = getIndex(bArr, i2 + 2);
                i2 += 4;
                zBackrefMatcher = flatNMatcher(rEGlobalData, index2, index3, str, i3);
                if (zBackrefMatcher) {
                }
                break;
            case 15:
                i4 = i2 + 1;
                char c = (char) (bArr[i2] & 255);
                if (i5 != i3 && str.charAt(i5) == c) {
                    rEGlobalData.cp++;
                    i2 = i4;
                    if (zBackrefMatcher) {
                    }
                }
                i2 = i4;
                zBackrefMatcher = false;
                if (zBackrefMatcher) {
                }
                break;
            case 16:
                int index4 = getIndex(bArr, i2);
                int index5 = getIndex(bArr, i2 + 2);
                i2 += 4;
                zBackrefMatcher = flatNIMatcher(rEGlobalData, index4, index5, str, i3);
                if (zBackrefMatcher) {
                }
                break;
            case 17:
                i4 = i2 + 1;
                char c2 = (char) (bArr[i2] & 255);
                if (i5 != i3) {
                    char cCharAt2 = str.charAt(i5);
                    if (c2 == cCharAt2 || upcase(c2) == upcase(cCharAt2)) {
                        rEGlobalData.cp++;
                    } else {
                        zBackrefMatcher = false;
                    }
                    i2 = i4;
                    if (zBackrefMatcher) {
                    }
                }
                i2 = i4;
                zBackrefMatcher = false;
                if (zBackrefMatcher) {
                }
                break;
            case 18:
                char index6 = (char) getIndex(bArr, i2);
                i2 += 2;
                int i8 = rEGlobalData.cp;
                if (i8 != i3 && str.charAt(i8) == index6) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 19:
                char index7 = (char) getIndex(bArr, i2);
                i2 += 2;
                int i9 = rEGlobalData.cp;
                if (i9 != i3 && (index7 == (cCharAt = str.charAt(i9)) || upcase(index7) == upcase(cCharAt))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
            case 20:
            case 21:
            default:
                throw Kit.codeBug();
            case 22:
            case 23:
                int index8 = getIndex(bArr, i2);
                i2 += 2;
                int i10 = rEGlobalData.cp;
                if (i10 != i3 && classMatcher(rEGlobalData, rEGlobalData.regexp.classList[index8], str.charAt(i10))) {
                    rEGlobalData.cp++;
                }
                if (zBackrefMatcher) {
                }
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 > i2 || i2 > 102) {
            return -1;
        }
        return i2 - 87;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static char upcase(char c) {
        if (c >= 128) {
            char upperCase = Character.toUpperCase(c);
            if (upperCase >= 128) {
                return upperCase;
            }
        } else if ('a' <= c && c <= 'z') {
            return (char) (c - ' ');
        }
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Scriptable compile(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        Object obj2;
        if (objArr.length >= 1) {
            Object obj3 = objArr[0];
            if ((obj3 instanceof NativeRegExp) && (objArr.length == 1 || objArr[1] == Undefined.instance)) {
                this.re = ((NativeRegExp) obj3).re;
            } else {
                String str = (objArr.length == 0 || (obj2 = objArr[0]) == Undefined.instance) ? "" : obj2 instanceof NativeRegExp ? new String(((NativeRegExp) obj2).re.source) : escapeRegExp(obj2);
                String string = (objArr.length <= 1 || (obj = objArr[1]) == Undefined.instance) ? null : ScriptRuntime.toString(obj);
                if (objArr.length > 0 && (objArr[0] instanceof NativeRegExp) && string != null && context.getLanguageVersion() < 200) {
                    throw ScriptRuntime.typeErrorById("msg.bad.regexp.compile", new Object[0]);
                }
                this.re = compileRE(context, str, string, false);
            }
        }
        setLastIndex(ScriptRuntime.zeroObj);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(REGEXP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return realThis(scriptable2, idFunctionObject).compile(context, scriptable, objArr);
            case 2:
                if (scriptable2 == scriptable || !(scriptable2 instanceof NativeObject)) {
                    return realThis(scriptable2, idFunctionObject).toString();
                }
                Object obj = scriptable2.get("source", scriptable2);
                Object obj2 = Scriptable.NOT_FOUND;
                String strEscapeRegExp = obj.equals(obj2) ? "undefined" : escapeRegExp(obj);
                Object obj3 = scriptable2.get("flags", scriptable2);
                return ServiceReference.DELIMITER + strEscapeRegExp + ServiceReference.DELIMITER + (obj3.equals(obj2) ? "undefined" : obj3.toString());
            case 3:
                return realThis(scriptable2, idFunctionObject).toString();
            case 4:
                return js_exec(context, scriptable, scriptable2, objArr);
            case 5:
                Object objExecSub = realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 0);
                Boolean bool = Boolean.TRUE;
                return bool.equals(objExecSub) ? bool : Boolean.FALSE;
            case 6:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 2);
            case 7:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 8:
                return js_SymbolMatchAll(context, scriptable, scriptable2, objArr);
            case 9:
                Scriptable scriptable3 = (Scriptable) realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
                if (scriptable3 == null) {
                    return -1;
                }
                return scriptable3.get("index", scriptable3);
            default:
                jl.a(String.valueOf(iMethodId));
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object execSub(Context context, Scriptable scriptable, Object[] objArr, int i) {
        String string;
        RegExpImpl impl = getImpl(context);
        if (objArr.length == 0) {
            string = impl.input;
            if (string == null) {
                string = ScriptRuntime.toString(Undefined.instance);
            }
        } else {
            string = ScriptRuntime.toString(objArr[0]);
        }
        String str = string;
        int i2 = this.re.flags;
        boolean z = ((i2 & 1) == 0 && (i2 & 16) == 0) ? false : true;
        double d = 0.0d;
        if (z) {
            double integer = ScriptRuntime.toInteger(this.lastIndex);
            if (integer < 0.0d || str.length() < integer) {
                setLastIndex(ScriptRuntime.zeroObj);
                return null;
            }
            d = integer;
        }
        Object objExecuteRegExp = executeRegExp(context, scriptable, impl, str, new int[]{(int) d}, i);
        if (z) {
            if (objExecuteRegExp != null && objExecuteRegExp != Undefined.instance) {
                setLastIndex(Double.valueOf(r5[0]));
                return objExecuteRegExp;
            }
            setLastIndex(ScriptRuntime.zeroObj);
        }
        return objExecuteRegExp;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object executeRegExp(Context context, Scriptable scriptable, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Context context2;
        Scriptable scriptable2;
        Object obj;
        NativeRegExp nativeRegExp = this;
        REGlobalData rEGlobalData = new REGlobalData();
        int i2 = iArr[0];
        int length = str.length();
        int i3 = i2 > length ? length : i2;
        SubString subString = null;
        if (!matchRegExp(context, rEGlobalData, nativeRegExp.re, str, i3, length, regExpImpl.multiline)) {
            if (i != 2) {
                return null;
            }
            return Undefined.instance;
        }
        int i4 = rEGlobalData.cp;
        iArr[0] = i4;
        int i5 = i4 - (rEGlobalData.skipped + i3);
        int i6 = i4 - i5;
        if (i == 0) {
            scriptable2 = null;
            obj = Boolean.TRUE;
            context2 = context;
        } else {
            context2 = context;
            Scriptable scriptableNewArray = context2.newArray(scriptable, 0);
            scriptableNewArray.put(0, scriptableNewArray, str.substring(i6, i6 + i5));
            scriptable2 = scriptableNewArray;
            obj = scriptableNewArray;
        }
        int i7 = nativeRegExp.re.parenCount;
        if (i7 == 0) {
            regExpImpl.parens = null;
            regExpImpl.lastParen = new SubString();
        } else {
            regExpImpl.parens = new SubString[i7];
            int i8 = 0;
            while (i8 < nativeRegExp.re.parenCount) {
                int iParensIndex = rEGlobalData.parensIndex(i8);
                if (iParensIndex != -1) {
                    subString = new SubString(str, iParensIndex, rEGlobalData.parensLength(i8));
                    regExpImpl.parens[i8] = subString;
                    if (i != 0) {
                        scriptable2.put(i8 + 1, scriptable2, subString.toString());
                    }
                } else if (i != 0) {
                    scriptable2.put(i8 + 1, scriptable2, Undefined.instance);
                }
                i8++;
                nativeRegExp = this;
            }
            regExpImpl.lastParen = subString;
        }
        if (i != 0) {
            scriptable2.put("index", scriptable2, Integer.valueOf(rEGlobalData.skipped + i3));
            scriptable2.put("input", scriptable2, str);
        }
        if (regExpImpl.lastMatch == null) {
            regExpImpl.lastMatch = new SubString();
            regExpImpl.leftContext = new SubString();
            regExpImpl.rightContext = new SubString();
        }
        SubString subString2 = regExpImpl.lastMatch;
        subString2.str = str;
        subString2.index = i6;
        subString2.length = i5;
        regExpImpl.leftContext.str = str;
        int languageVersion = context2.getLanguageVersion();
        SubString subString3 = regExpImpl.leftContext;
        if (languageVersion == 120) {
            subString3.index = i3;
            subString3.length = rEGlobalData.skipped;
        } else {
            subString3.index = 0;
            subString3.length = i3 + rEGlobalData.skipped;
        }
        SubString subString4 = regExpImpl.rightContext;
        subString4.str = str;
        subString4.index = i4;
        subString4.length = length - i4;
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        int i;
        str.getClass();
        i = 6;
        int i2 = 7;
        switch (str) {
            case "dotAll":
                i = 7;
                break;
            case "global":
                i = 4;
                break;
            case "multiline":
                break;
            case "source":
                i = 2;
                break;
            case "sticky":
                i = 8;
                break;
            case "flags":
                i = 3;
                break;
            case "ignoreCase":
                i = 5;
                break;
            case "lastIndex":
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return super.findInstanceIdInfo(str);
        }
        switch (i) {
            case 1:
                i2 = this.lastIndexAttr;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                z20.a();
                return 0;
        }
        return IdScriptableObject.instanceIdInfo(i2, i);
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
            case "prefix":
                return 6;
            case "exec":
                return 4;
            case "test":
                return 5;
            case "compile":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getFlags() {
        return this.re.flags;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        switch (i) {
            case 1:
                return "lastIndex";
            case 2:
                return "source";
            case 3:
                return "flags";
            case 4:
                return "global";
            case 5:
                return "ignoreCase";
            case 6:
                return "multiline";
            case 7:
                return "dotAll";
            case 8:
                return "sticky";
            default:
                return super.getInstanceIdName(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        switch (i) {
            case 1:
                return this.lastIndex;
            case 2:
                return new String(this.re.source);
            case 3:
                StringBuilder sb = new StringBuilder();
                appendFlags(sb);
                return sb.toString();
            case 4:
                return ScriptRuntime.wrapBoolean((this.re.flags & 1) != 0);
            case 5:
                return ScriptRuntime.wrapBoolean((this.re.flags & 2) != 0);
            case 6:
                return ScriptRuntime.wrapBoolean((this.re.flags & 4) != 0);
            case 7:
                return ScriptRuntime.wrapBoolean((this.re.flags & 8) != 0);
            case 8:
                return ScriptRuntime.wrapBoolean((this.re.flags & 16) != 0);
            default:
                return super.getInstanceIdValue(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return "object";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        if (i == 7) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.MATCH, "[Symbol.match]", 1);
        }
        if (i == 8) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.MATCH_ALL, "[Symbol.matchAll]", 1);
            return;
        }
        if (i == 9) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.SEARCH, "[Symbol.search]", 1);
            return;
        }
        int i2 = 0;
        int i3 = 1;
        switch (i) {
            case 1:
                i2 = 2;
                str = "compile";
                String str3 = str;
                i3 = i2;
                str2 = str3;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                break;
            case 2:
                str = "toString";
                String str32 = str;
                i3 = i2;
                str2 = str32;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                break;
            case 3:
                str = "toSource";
                String str322 = str;
                i3 = i2;
                str2 = str322;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                break;
            case 4:
                str2 = "exec";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                break;
            case 5:
                str2 = "test";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                break;
            case 6:
                str2 = "prefix";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                break;
            default:
                jl.a(String.valueOf(i));
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lastIndexAttr = i2;
        } else {
            super.setInstanceIdAttributes(i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        switch (i) {
            case 1:
                setLastIndex(obj);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                super.setInstanceIdValue(i, obj);
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        char[] cArr = this.re.source;
        if (cArr.length != 0) {
            sb.append(cArr);
        } else {
            sb.append("(?:)");
        }
        sb.append('/');
        appendFlags(sb);
        return sb.toString();
    }

    private static NativeRegExp realThis(Scriptable scriptable, String str) {
        return (NativeRegExp) IdScriptableObject.ensureType(scriptable, NativeRegExp.class, str);
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, i2, i3, i4);
    }

    public NativeRegExp() {
        this.lastIndex = ScriptRuntime.zeroObj;
        this.lastIndexAttr = 6;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (SymbolKey.MATCH.equals(symbol)) {
            return 7;
        }
        if (SymbolKey.MATCH_ALL.equals(symbol)) {
            return 8;
        }
        return SymbolKey.SEARCH.equals(symbol) ? 9 : 0;
    }
}
