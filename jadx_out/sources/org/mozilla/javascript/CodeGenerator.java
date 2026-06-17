package org.mozilla.javascript;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import okhttp3.internal.http2.Settings;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.TemplateCharacters;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class CodeGenerator extends Icode {
    private static final int ECF_TAIL = 1;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private CompilerEnvirons compilerEnv;
    private int doubleTableTop;
    private int exceptionTableTop;
    private long[] fixupTable;
    private int fixupTableTop;
    private int iCodeTop;
    private InterpreterData itsData;
    private boolean itsInFunctionFlag;
    private boolean itsInTryFlag;
    private int[] labelTable;
    private int labelTableTop;
    private int localTop;
    private ScriptNode scriptOrFn;
    private int stackDepth;
    private int lineNumber = -1;
    private final HashMap<String, Integer> strings = new HashMap<>();
    private final HashMap<BigInteger, Integer> bigInts = new HashMap<>();
    private final ArrayList<Object> literalIds = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class CompleteOptionalCallJump {
        private final int afterLabel;
        private final int putArgsAndDoCallLabel;

        public CompleteOptionalCallJump(int i, int i2) {
            this.putArgsAndDoCallLabel = i;
            this.afterLabel = i2;
        }
    }

    public static /* synthetic */ boolean a(Object obj) {
        return obj instanceof Node;
    }

    private void addBackwardGoto(int i, int i2) {
        int i3 = this.iCodeTop;
        if (i3 <= i2) {
            throw Kit.codeBug();
        }
        addGotoOp(i);
        resolveGoto(i3, i2);
    }

    private void addBigInt(BigInteger bigInteger) {
        int iIntValue = this.bigInts.getOrDefault(bigInteger, -1).intValue();
        if (iIntValue == -1) {
            iIntValue = this.bigInts.size();
            this.bigInts.put(bigInteger, Integer.valueOf(iIntValue));
        }
        if (iIntValue < 4) {
            addIcode((-74) - iIntValue);
        } else if (iIntValue <= 255) {
            addIcode(-78);
            addUint8(iIntValue);
        } else if (iIntValue <= 65535) {
            addIcode(-79);
            addUint16(iIntValue);
        } else {
            addIcode(-80);
            addInt(iIntValue);
        }
        addToken(89);
    }

    private void addExceptionHandler(int i, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = this.exceptionTableTop;
        int[] iArr = this.itsData.itsExceptionTable;
        if (iArr == null) {
            if (i6 != 0) {
                Kit.codeBug();
            }
            iArr = new int[12];
            this.itsData.itsExceptionTable = iArr;
        } else if (iArr.length == i6) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.itsData.itsExceptionTable = iArr2;
            iArr = iArr2;
        }
        iArr[i6] = i;
        iArr[i6 + 1] = i2;
        iArr[i6 + 2] = i3;
        iArr[i6 + 3] = z ? 1 : 0;
        iArr[i6 + 4] = i4;
        iArr[i6 + 5] = i5;
        this.exceptionTableTop = i6 + 6;
    }

    private void addGoto(Node node, int i) {
        int targetLabel = getTargetLabel(node);
        if (targetLabel >= this.labelTableTop) {
            Kit.codeBug();
        }
        int i2 = this.labelTable[targetLabel];
        if (i2 != -1) {
            addBackwardGoto(i, i2);
            return;
        }
        int i3 = this.iCodeTop;
        addGotoOp(i);
        int i4 = this.fixupTableTop;
        long[] jArr = this.fixupTable;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.fixupTable = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.fixupTable = jArr2;
            }
        }
        this.fixupTableTop = i4 + 1;
        this.fixupTable[i4] = (((long) targetLabel) << 32) | ((long) i3);
    }

    private void addGotoOp(int i) {
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        if (i2 + 3 > bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(3);
        }
        bArrIncreaseICodeCapacity[i2] = (byte) i;
        this.iCodeTop = i2 + 3;
    }

    private void addIcode(int i) {
        if (!Icode.validIcode(i)) {
            throw Kit.codeBug();
        }
        addUint8(i & 255);
    }

    private void addIndexOp(int i, int i2) {
        addIndexPrefix(i2);
        if (Icode.validIcode(i)) {
            addIcode(i);
        } else {
            addToken(i);
        }
    }

    private void addIndexPrefix(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        if (i < 6) {
            addIcode((-39) - i);
            return;
        }
        if (i <= 255) {
            addIcode(-45);
            addUint8(i);
        } else if (i <= 65535) {
            addIcode(-46);
            addUint16(i);
        } else {
            addIcode(-47);
            addInt(i);
        }
    }

    private void addInt(int i) {
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        int i3 = i2 + 4;
        if (i3 > bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(4);
        }
        bArrIncreaseICodeCapacity[i2] = (byte) (i >>> 24);
        bArrIncreaseICodeCapacity[i2 + 1] = (byte) (i >>> 16);
        bArrIncreaseICodeCapacity[i2 + 2] = (byte) (i >>> 8);
        bArrIncreaseICodeCapacity[i2 + 3] = (byte) i;
        this.iCodeTop = i3;
    }

    private void addStringOp(int i, String str) {
        addStringPrefix(str);
        if (Icode.validIcode(i)) {
            addIcode(i);
        } else {
            addToken(i);
        }
    }

    private void addStringPrefix(String str) {
        int iIntValue = this.strings.getOrDefault(str, -1).intValue();
        if (iIntValue == -1) {
            iIntValue = this.strings.size();
            this.strings.put(str, Integer.valueOf(iIntValue));
        }
        if (iIntValue < 4) {
            addIcode((-48) - iIntValue);
            return;
        }
        if (iIntValue <= 255) {
            addIcode(-52);
            addUint8(iIntValue);
        } else if (iIntValue <= 65535) {
            addIcode(-53);
            addUint16(iIntValue);
        } else {
            addIcode(-54);
            addInt(iIntValue);
        }
    }

    private void addToken(int i) {
        if (!Icode.validTokenCode(i)) {
            throw Kit.codeBug();
        }
        addUint8(i);
    }

    private void addUint16(int i) {
        if (((-65536) & i) != 0) {
            throw Kit.codeBug();
        }
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        int i3 = i2 + 2;
        if (i3 > bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(2);
        }
        bArrIncreaseICodeCapacity[i2] = (byte) (i >>> 8);
        bArrIncreaseICodeCapacity[i2 + 1] = (byte) i;
        this.iCodeTop = i3;
    }

    private void addUint8(int i) {
        if ((i & (-256)) != 0) {
            throw Kit.codeBug();
        }
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        if (i2 == bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(1);
        }
        bArrIncreaseICodeCapacity[i2] = (byte) i;
        this.iCodeTop = i2 + 1;
    }

    private void addVarOp(int i, int i2) {
        if (i != -7) {
            if (i == 170) {
                if (i2 >= 128) {
                    addIndexOp(-67, i2);
                    return;
                } else {
                    addIcode(-68);
                    addUint8(i2);
                    return;
                }
            }
            if (i != 60 && i != 61) {
                throw Kit.codeBug();
            }
            if (i2 < 128) {
                addIcode(i == 60 ? -55 : -56);
                addUint8(i2);
                return;
            }
        }
        addIndexOp(i, i2);
    }

    private int allocLocal() {
        int i = this.localTop;
        int i2 = i + 1;
        this.localTop = i2;
        InterpreterData interpreterData = this.itsData;
        if (i2 > interpreterData.itsMaxLocals) {
            interpreterData.itsMaxLocals = i2;
        }
        return i;
    }

    private static RuntimeException badTree(Node node) {
        throw new RuntimeException(node.toString());
    }

    private CompleteOptionalCallJump completeOptionalCallJump() {
        addIcode(-1);
        stackChange(1);
        int i = this.iCodeTop;
        addGotoOp(-84);
        stackChange(-1);
        addIcode(-4);
        addIcode(-4);
        addStringOp(44, "undefined");
        int i2 = this.iCodeTop;
        addGotoOp(5);
        return new CompleteOptionalCallJump(i, i2);
    }

    private void finishGetElemGeneration(Node node) {
        visitExpression(node, 0);
        addToken(39);
        stackChange(-1);
    }

    private void fixLabelGotos() {
        for (int i = 0; i < this.fixupTableTop; i++) {
            long j = this.fixupTable[i];
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            int i4 = this.labelTable[i2];
            if (i4 == -1) {
                throw Kit.codeBug();
            }
            resolveGoto(i3, i4);
        }
        this.fixupTableTop = 0;
    }

    private CompleteOptionalCallJump generateCallFunAndThis(Node node, boolean z) {
        int type = node.getType();
        if (type != 33 && type != 39) {
            if (type != 44) {
                visitExpression(node, 0);
                if (z) {
                    addIcode(-22);
                    stackChange(1);
                    return completeOptionalCallJump();
                }
                addIcode(-18);
                stackChange(1);
                return null;
            }
            String string = node.getString();
            if (z) {
                addStringOp(-19, string);
                stackChange(2);
                return completeOptionalCallJump();
            }
            addStringOp(-15, string);
            stackChange(2);
            return null;
        }
        Node firstChild = node.getFirstChild();
        visitExpression(firstChild, 0);
        Node next = firstChild.getNext();
        if (type != 33) {
            visitExpression(next, 0);
            if (z) {
                addIcode(-21);
                return completeOptionalCallJump();
            }
            addIcode(-17);
            return null;
        }
        String string2 = next.getString();
        if (z) {
            addStringOp(-20, string2);
            stackChange(1);
            return completeOptionalCallJump();
        }
        addStringOp(-16, string2);
        stackChange(1);
        return null;
    }

    private void generateFunctionICode() {
        this.itsInFunctionFlag = true;
        FunctionNode functionNode = (FunctionNode) this.scriptOrFn;
        this.itsData.itsFunctionType = functionNode.getFunctionType();
        this.itsData.itsNeedsActivation = functionNode.requiresActivation();
        if (functionNode.getFunctionName() != null) {
            this.itsData.itsName = functionNode.getName();
        }
        if (functionNode.isGenerator()) {
            addIcode(-69);
            addUint16(functionNode.getBaseLineno() & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        }
        if (functionNode.isInStrictMode()) {
            this.itsData.isStrict = true;
        }
        if (functionNode.isES6Generator()) {
            this.itsData.isES6Generator = true;
        }
        generateICodeFromTree(functionNode.getLastChild());
    }

    private void generateICodeFromTree(Node node) {
        generateNestedFunctions();
        generateRegExpLiterals();
        generateTemplateLiterals();
        visitStatement(node, 0);
        fixLabelGotos();
        if (this.itsData.itsFunctionType == 0) {
            addToken(70);
        }
        byte[] bArr = this.itsData.itsICode;
        int length = bArr.length;
        int i = this.iCodeTop;
        if (length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            this.itsData.itsICode = bArr2;
        }
        int size = this.strings.size();
        InterpreterData interpreterData = this.itsData;
        if (size == 0) {
            interpreterData.itsStringTable = null;
        } else {
            interpreterData.itsStringTable = new String[this.strings.size()];
            for (Map.Entry<String, Integer> entry : this.strings.entrySet()) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                if (this.itsData.itsStringTable[iIntValue] != null) {
                    Kit.codeBug();
                }
                this.itsData.itsStringTable[iIntValue] = key;
            }
        }
        int i2 = this.doubleTableTop;
        InterpreterData interpreterData2 = this.itsData;
        if (i2 == 0) {
            interpreterData2.itsDoubleTable = null;
        } else {
            double[] dArr = interpreterData2.itsDoubleTable;
            if (dArr.length != i2) {
                double[] dArr2 = new double[i2];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                this.itsData.itsDoubleTable = dArr2;
            }
        }
        int size2 = this.bigInts.size();
        InterpreterData interpreterData3 = this.itsData;
        if (size2 == 0) {
            interpreterData3.itsBigIntTable = null;
        } else {
            interpreterData3.itsBigIntTable = new BigInteger[this.bigInts.size()];
            for (Map.Entry<BigInteger, Integer> entry2 : this.bigInts.entrySet()) {
                BigInteger key2 = entry2.getKey();
                int iIntValue2 = entry2.getValue().intValue();
                if (this.itsData.itsBigIntTable[iIntValue2] != null) {
                    Kit.codeBug();
                }
                this.itsData.itsBigIntTable[iIntValue2] = key2;
            }
        }
        int i3 = this.exceptionTableTop;
        if (i3 != 0) {
            int[] iArr = this.itsData.itsExceptionTable;
            if (iArr.length != i3) {
                int[] iArr2 = new int[i3];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.itsData.itsExceptionTable = iArr2;
            }
        }
        this.itsData.itsMaxVars = this.scriptOrFn.getParamAndVarCount();
        InterpreterData interpreterData4 = this.itsData;
        interpreterData4.itsMaxFrameArray = interpreterData4.itsMaxVars + interpreterData4.itsMaxLocals + interpreterData4.itsMaxStack;
        interpreterData4.argNames = this.scriptOrFn.getParamAndVarNames();
        this.itsData.argIsConst = this.scriptOrFn.getParamAndVarConst();
        this.itsData.argCount = this.scriptOrFn.getParamCount();
        this.itsData.argsHasRest = this.scriptOrFn.hasRestParameter();
        this.itsData.argsHasDefaults = this.scriptOrFn.getDefaultParams() != null;
        this.itsData.rawSourceStart = this.scriptOrFn.getRawSourceStart();
        this.itsData.rawSourceEnd = this.scriptOrFn.getRawSourceEnd();
        if (this.literalIds.size() != 0) {
            this.itsData.literalIds = this.literalIds.toArray();
        }
    }

    private void generateNestedFunctions() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        if (functionCount == 0) {
            return;
        }
        InterpreterData[] interpreterDataArr = new InterpreterData[functionCount];
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = this.scriptOrFn.getFunctionNode(i);
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.compilerEnv = this.compilerEnv;
            codeGenerator.scriptOrFn = functionNode;
            codeGenerator.itsData = new InterpreterData(this.itsData);
            codeGenerator.generateFunctionICode();
            interpreterDataArr[i] = codeGenerator.itsData;
            AstNode parent = functionNode.getParent();
            if (!(parent instanceof AstRoot) && !(parent instanceof Scope) && !(parent instanceof Block)) {
                codeGenerator.itsData.declaredAsFunctionExpression = true;
            }
        }
        this.itsData.itsNestedFunctions = interpreterDataArr;
    }

    private void generateRegExpLiterals() {
        int regexpCount = this.scriptOrFn.getRegexpCount();
        if (regexpCount == 0) {
            return;
        }
        Context context = Context.getContext();
        RegExpProxy regExpProxyCheckRegExpProxy = ScriptRuntime.checkRegExpProxy(context);
        Object[] objArr = new Object[regexpCount];
        for (int i = 0; i != regexpCount; i++) {
            objArr[i] = regExpProxyCheckRegExpProxy.compileRegExp(context, this.scriptOrFn.getRegexpString(i), this.scriptOrFn.getRegexpFlags(i));
        }
        this.itsData.itsRegExpLiterals = objArr;
    }

    private void generateTemplateLiterals() {
        int templateLiteralCount = this.scriptOrFn.getTemplateLiteralCount();
        if (templateLiteralCount == 0) {
            return;
        }
        Object[] objArr = new Object[templateLiteralCount];
        for (int i = 0; i != templateLiteralCount; i++) {
            List<TemplateCharacters> templateLiteralStrings = this.scriptOrFn.getTemplateLiteralStrings(i);
            String[] strArr = new String[templateLiteralStrings.size() * 2];
            int i2 = 0;
            for (TemplateCharacters templateCharacters : templateLiteralStrings) {
                int i3 = i2 + 1;
                strArr[i2] = templateCharacters.getValue();
                i2 += 2;
                strArr[i3] = templateCharacters.getRawValue();
            }
            objArr[i] = strArr;
        }
        this.itsData.itsTemplateLiterals = objArr;
    }

    private int getDoubleIndex(double d) {
        int i = this.doubleTableTop;
        InterpreterData interpreterData = this.itsData;
        if (i == 0) {
            interpreterData.itsDoubleTable = new double[64];
        } else {
            double[] dArr = interpreterData.itsDoubleTable;
            if (dArr.length == i) {
                double[] dArr2 = new double[i * 2];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                this.itsData.itsDoubleTable = dArr2;
            }
        }
        this.itsData.itsDoubleTable[i] = d;
        this.doubleTableTop = i + 1;
        return i;
    }

    private static int getLocalBlockRef(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private int getTargetLabel(Node node) {
        int iLabelId = node.labelId();
        if (iLabelId != -1) {
            return iLabelId;
        }
        int i = this.labelTableTop;
        int[] iArr = this.labelTable;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.labelTable = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.labelTable = iArr2;
            }
        }
        this.labelTableTop = i + 1;
        this.labelTable[i] = -1;
        node.labelId(i);
        return i;
    }

    private byte[] increaseICodeCapacity(int i) {
        byte[] bArr = this.itsData.itsICode;
        int length = bArr.length;
        int i2 = this.iCodeTop;
        int i3 = i + i2;
        if (i3 <= length) {
            throw Kit.codeBug();
        }
        int i4 = length * 2;
        if (i3 <= i4) {
            i3 = i4;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.itsData.itsICode = bArr2;
        return bArr2;
    }

    private void markTargetLabel(Node node) {
        int targetLabel = getTargetLabel(node);
        if (this.labelTable[targetLabel] != -1) {
            Kit.codeBug();
        }
        this.labelTable[targetLabel] = this.iCodeTop;
    }

    private void releaseLocal(int i) {
        int i2 = this.localTop - 1;
        this.localTop = i2;
        if (i != i2) {
            Kit.codeBug();
        }
    }

    private void resolveForwardGoto(int i) {
        int i2 = this.iCodeTop;
        if (i2 < i + 3) {
            throw Kit.codeBug();
        }
        resolveGoto(i, i2);
    }

    private void resolveGoto(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0 && i3 <= 2) {
            throw Kit.codeBug();
        }
        int i4 = i + 1;
        if (i3 != ((short) i3)) {
            InterpreterData interpreterData = this.itsData;
            if (interpreterData.longJumps == null) {
                interpreterData.longJumps = new HashMap();
            }
            this.itsData.longJumps.put(Integer.valueOf(i4), Integer.valueOf(i2));
            i3 = 0;
        }
        byte[] bArr = this.itsData.itsICode;
        bArr[i4] = (byte) (i3 >> 8);
        bArr[i + 2] = (byte) i3;
    }

    private void stackChange(int i) {
        int i2 = this.stackDepth;
        if (i <= 0) {
            this.stackDepth = i2 + i;
            return;
        }
        int i3 = i2 + i;
        InterpreterData interpreterData = this.itsData;
        if (i3 > interpreterData.itsMaxStack) {
            interpreterData.itsMaxStack = i3;
        }
        this.stackDepth = i3;
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        if (lineno == this.lineNumber || lineno < 0) {
            return;
        }
        InterpreterData interpreterData = this.itsData;
        if (interpreterData.firstLinePC < 0) {
            interpreterData.firstLinePC = lineno;
        }
        this.lineNumber = lineno;
        addIcode(-31);
        addUint16(lineno & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
    }

    private void visitArrayComprehension(Node node, Node node2, Node node3) {
        visitStatement(node2, this.stackDepth);
        visitExpression(node3, 0);
    }

    private void visitArrayLiteral(Node node, Node node2) {
        int i = 0;
        for (Node next = node2; next != null; next = next.getNext()) {
            i++;
        }
        addIndexOp(-35, i);
        stackChange(2);
        while (node2 != null) {
            visitLiteralValue(node2);
            node2 = node2.getNext();
        }
        int[] iArr = (int[]) node.getProp(11);
        if (iArr == null) {
            addToken(71);
        } else {
            int size = this.literalIds.size();
            this.literalIds.add(iArr);
            addIndexOp(-38, size);
        }
        stackChange(-1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e1 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void visitExpression(org.mozilla.javascript.Node r18, int r19) {
        /*
            Method dump skipped, instruction units count: 1652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.CodeGenerator.visitExpression(org.mozilla.javascript.Node, int):void");
    }

    private void visitIncDec(Node node, Node node2) {
        int existingIntProp = node.getExistingIntProp(13);
        int type = node2.getType();
        if (node2.getIntProp(31, 0) == 1) {
            visitSuperIncDec(node, node2, type, existingIntProp);
            return;
        }
        if (type == 33) {
            Node firstChild = node2.getFirstChild();
            visitExpression(firstChild, 0);
            addStringOp(-9, firstChild.getNext().getString());
            addUint8(existingIntProp);
            return;
        }
        if (type == 39) {
            Node firstChild2 = node2.getFirstChild();
            visitExpression(firstChild2, 0);
            visitExpression(firstChild2.getNext(), 0);
            addIcode(-10);
            addUint8(existingIntProp);
            stackChange(-1);
            return;
        }
        if (type == 44) {
            addStringOp(-8, node2.getString());
            addUint8(existingIntProp);
            stackChange(1);
        } else {
            if (type != 60) {
                if (type != 73) {
                    throw badTree(node);
                }
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-11);
                addUint8(existingIntProp);
                return;
            }
            if (this.itsData.itsNeedsActivation) {
                Kit.codeBug();
            }
            addVarOp(-7, this.scriptOrFn.getIndexForNameNode(node2));
            addUint8(existingIntProp);
            stackChange(1);
        }
    }

    private void visitLiteral(Node node, Node node2) {
        int type = node.getType();
        if (type == 71) {
            visitArrayLiteral(node, node2);
        } else {
            if (type != 72) {
                throw badTree(node);
            }
            visitObjectLiteral(node, node2);
        }
    }

    private void visitLiteralValue(Node node) {
        int type = node.getType();
        if (type == 165) {
            visitExpression(node.getFirstChild(), 0);
            addIcode(-64);
        } else if (type == 166) {
            visitExpression(node.getFirstChild(), 0);
            addIcode(-65);
        } else if (type == 177) {
            visitExpression(node.getFirstChild(), 0);
            addIcode(-36);
        } else {
            visitExpression(node, 0);
            addIcode(-36);
        }
        stackChange(-1);
    }

    private void visitObjectLiteral(Node node, Node node2) {
        Object[] objArr = (Object[]) node.getProp(12);
        int i = (objArr == null || !Arrays.stream(objArr).anyMatch(new Predicate() { // from class: org.mozilla.javascript.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CodeGenerator.a(obj);
            }
        })) ? 0 : 1;
        int size = this.literalIds.size();
        this.literalIds.add(objArr);
        addIndexOp(-34, size);
        addUint8(i);
        stackChange(4);
        int i2 = 0;
        while (node2 != null) {
            Object obj = objArr == null ? null : objArr[i2];
            if (obj instanceof Node) {
                visitExpression(((Node) obj).first, 0);
                addIcode(-82);
                stackChange(-1);
            }
            visitLiteralValue(node2);
            node2 = node2.getNext();
            i2++;
        }
        addToken(72);
        stackChange(-3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0193 A[LOOP:0: B:75:0x0191->B:76:0x0193, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void visitStatement(org.mozilla.javascript.Node r13, int r14) {
        /*
            Method dump skipped, instruction units count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.CodeGenerator.visitStatement(org.mozilla.javascript.Node, int):void");
    }

    private void visitSuperIncDec(Node node, Node node2, int i, int i2) {
        Node firstChild = node2.getFirstChild();
        visitExpression(firstChild, 0);
        if (i == 33) {
            addStringOp(35, firstChild.getNext().getString());
        } else {
            if (i != 39) {
                throw badTree(node);
            }
            visitExpression(firstChild.getNext(), 0);
            addToken(40);
            stackChange(-1);
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            addIcode(-1);
            stackChange(1);
        }
        addToken(79);
        stackChange(1);
        addIcode(-3);
        addIcode(-59);
        stackChange(1);
        if ((i2 & 1) == 0) {
            addToken(21);
        } else {
            addToken(22);
        }
        stackChange(-1);
        if (i == 33) {
            addStringOp(38, firstChild.getNext().getString());
            stackChange(-1);
        } else if (i == 39) {
            visitExpression(firstChild.getNext(), 0);
            addToken(42);
            stackChange(-2);
        }
        if (i3 != 0) {
            addIcode(-4);
            stackChange(-1);
        }
    }

    private void visitTemplateLiteral(Node node) {
        addIndexOp(-81, node.getExistingIntProp(27));
        stackChange(1);
    }

    public InterpreterData compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        this.compilerEnv = compilerEnvirons;
        new NodeTransformer().transform(scriptNode, compilerEnvirons);
        if (z) {
            this.scriptOrFn = scriptNode.getFunctionNode(0);
        } else {
            this.scriptOrFn = scriptNode;
        }
        InterpreterData interpreterData = new InterpreterData(compilerEnvirons.getLanguageVersion(), this.scriptOrFn.getSourceName(), str, this.scriptOrFn.isInStrictMode());
        this.itsData = interpreterData;
        interpreterData.topLevel = true;
        if (z) {
            generateFunctionICode();
        } else {
            generateICodeFromTree(this.scriptOrFn);
        }
        return this.itsData;
    }
}
