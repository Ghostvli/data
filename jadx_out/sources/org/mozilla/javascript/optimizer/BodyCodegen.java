package org.mozilla.javascript.optimizer;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.e04;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class BodyCodegen {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ECMAERROR_EXCEPTION = 2;
    private static final int EVALUATOR_EXCEPTION = 1;
    private static final int EXCEPTION_MAX = 5;
    private static final int FINALLY_EXCEPTION = 4;
    static final int GENERATOR_START = 0;
    static final int GENERATOR_TERMINATE = -1;
    static final int GENERATOR_YIELD_START = 1;
    private static final int JAVASCRIPT_EXCEPTION = 0;
    private static final int MAX_LOCALS = 1024;
    private static final String SIGNATURE_CALL0 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
    private static final String SIGNATURE_CALL1 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
    private static final String SIGNATURE_CALL2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
    private static final String SIGNATURE_CALLN = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
    private static final int THROWABLE_EXCEPTION = 3;
    private int argsLocal;
    ClassFileWriter cfw;
    Codegen codegen;
    CompilerEnvirons compilerEnv;
    private int contextLocal;
    private int enterAreaStartLabel;
    private int epilogueLabel;
    private Map<Node, FinallyReturnPoint> finallys;
    private int firstFreeLocal;
    private OptFunctionNode fnCurrent;
    private int funObjLocal;
    private int generatorStateLocal;
    private int generatorSwitch;
    private boolean hasVarsInRegs;
    private boolean inDirectCallFunction;
    private boolean inLocalBlock;
    private boolean isGenerator;
    private boolean itsForcedObjectParameters;
    private int itsLineNumber;
    private int itsOneArgArray;
    private int itsZeroArgArray;
    private ArrayList<Node> literals;
    private int[] locals;
    private int localsMax;
    private int operationLocal;
    private int popvLocal;
    private int savedCodeOffset;
    private int savedHomeObjectLocal;
    ScriptNode scriptOrFn;
    public int scriptOrFnIndex;
    private int thisObjLocal;
    private int[] varRegisters;
    private int variableObjectLocal;
    private ExceptionManager exceptionManager = new ExceptionManager();
    private int maxLocals = 0;
    private int maxStack = 0;
    private int unnestedYieldCount = 0;
    private IdentityHashMap<Node, String> unnestedYields = new IdentityHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class ExceptionManager {
        private ArrayDeque<ExceptionInfo> exceptionInfo = new ArrayDeque<>();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class ExceptionInfo {
            Node finallyBlock;
            int[] handlerLabels = new int[5];
            int[] exceptionStarts = new int[5];
            Node currentFinally = null;

            public ExceptionInfo(Jump jump, Node node) {
                this.finallyBlock = node;
            }
        }

        public ExceptionManager() {
        }

        private void endCatch(ExceptionInfo exceptionInfo, int i, int i2) {
            int i3 = exceptionInfo.exceptionStarts[i];
            if (i3 == 0) {
                e04.a("bad exception start");
            } else if (BodyCodegen.this.cfw.m0(i3) != BodyCodegen.this.cfw.m0(i2)) {
                BodyCodegen.this.cfw.z(exceptionInfo.exceptionStarts[i], i2, exceptionInfo.handlerLabels[i], BodyCodegen.exceptionTypeToName(i));
            }
        }

        private ExceptionInfo getTop() {
            return this.exceptionInfo.getLast();
        }

        public void addHandler(int i, int i2, int i3) {
            ExceptionInfo top = getTop();
            top.handlerLabels[i] = i2;
            top.exceptionStarts[i] = i3;
        }

        public void markInlineFinallyEnd(Node node, int i) {
            Iterator<ExceptionInfo> itDescendingIterator = this.exceptionInfo.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                ExceptionInfo next = itDescendingIterator.next();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (next.handlerLabels[i2] != 0 && next.currentFinally == node) {
                        next.exceptionStarts[i2] = i;
                        next.currentFinally = null;
                    }
                }
                if (next.finallyBlock == node) {
                    return;
                }
            }
        }

        public void markInlineFinallyStart(Node node, int i) {
            Iterator<ExceptionInfo> itDescendingIterator = this.exceptionInfo.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                ExceptionInfo next = itDescendingIterator.next();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (next.handlerLabels[i2] != 0 && next.currentFinally == null) {
                        endCatch(next, i2, i);
                        next.exceptionStarts[i2] = 0;
                        next.currentFinally = node;
                    }
                }
                if (next.finallyBlock == node) {
                    return;
                }
            }
        }

        public void popExceptionInfo() {
            this.exceptionInfo.removeLast();
        }

        public void pushExceptionInfo(Jump jump) {
            this.exceptionInfo.add(new ExceptionInfo(jump, BodyCodegen.getFinallyAtTarget(jump.getFinally())));
        }

        public int removeHandler(int i, int i2) {
            ExceptionInfo top = getTop();
            int i3 = top.handlerLabels[i];
            if (i3 == 0) {
                return 0;
            }
            endCatch(top, i, i2);
            top.handlerLabels[i] = 0;
            return i3;
        }

        public void setHandlers(int[] iArr, int i) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    addHandler(i2, i3, i);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class FinallyReturnPoint {
        public List<Integer> jsrPoints = new ArrayList();
        public int tableLabel = 0;
    }

    private void addDoubleWrap() {
        addOptRuntimeInvoke("wrapDouble", "(D)Ljava/lang/Double;");
    }

    private void addDynamicInvoke(String str, String str2) {
        this.cfw.G(str, str2, Bootstrapper.BOOTSTRAP_HANDLE, new Object[0]);
    }

    private void addGoto(Node node, int i) {
        this.cfw.s(i, getTargetLabel(node));
    }

    private void addGotoWithReturn(Node node) {
        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
        this.cfw.L(finallyReturnPoint.jsrPoints.size());
        addGoto(node, Token.LET);
        this.cfw.r(87);
        int iQ = this.cfw.q();
        this.cfw.r0(iQ);
        finallyReturnPoint.jsrPoints.add(Integer.valueOf(iQ));
    }

    private void addInstructionCount(int i) {
        this.cfw.v(this.contextLocal);
        this.cfw.Q(i);
        addScriptRuntimeInvoke("addInstructionCount", "(Lorg/mozilla/javascript/Context;I)V");
    }

    private void addJumpedBooleanWrap(int i, int i2) {
        this.cfw.r0(i2);
        int iQ = this.cfw.q();
        this.cfw.u(Token.ARROW, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        this.cfw.s(Token.LET, iQ);
        this.cfw.r0(i);
        this.cfw.u(Token.ARROW, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        this.cfw.r0(iQ);
        this.cfw.a0(-1);
    }

    private void addLoadProperty(Node node, Node node2, Object[] objArr, int i) {
        int i2 = 0;
        if (i == 0) {
            addNewObjectArray(0);
            addNewObjectArray(0);
            return;
        }
        if (this.isGenerator) {
            while (i2 < i) {
                addLoadPropertyId(node, objArr, i2);
                addLoadPropertyValue(node, node2);
                node2 = node2.getNext();
                i2++;
            }
            int i3 = this.firstFreeLocal;
            int i4 = i3 + 1;
            int i5 = this.localsMax;
            this.firstFreeLocal = i3 + 2;
            this.localsMax = i5 + 2;
            addNewObjectArray(i);
            this.cfw.w(i3);
            addNewObjectArray(i);
            this.cfw.w(i4);
            while (true) {
                i--;
                ClassFileWriter classFileWriter = this.cfw;
                if (i < 0) {
                    classFileWriter.v(i3);
                    this.cfw.v(i4);
                    return;
                }
                classFileWriter.v(i4);
                this.cfw.r(95);
                this.cfw.L(i);
                this.cfw.r(95);
                this.cfw.r(83);
                this.cfw.v(i3);
                this.cfw.r(95);
                this.cfw.L(i);
                this.cfw.r(95);
                this.cfw.r(83);
            }
        } else {
            addNewObjectArray(i);
            addNewObjectArray(i);
            while (true) {
                ClassFileWriter classFileWriter2 = this.cfw;
                if (i2 >= i) {
                    classFileWriter2.r(95);
                    return;
                }
                classFileWriter2.r(92);
                this.cfw.L(i2);
                addLoadPropertyId(node, objArr, i2);
                this.cfw.r(83);
                this.cfw.L(i2);
                addLoadPropertyValue(node, node2);
                this.cfw.r(83);
                node2 = node2.getNext();
                i2++;
            }
        }
    }

    private void addLoadPropertyId(Node node, Object[] objArr, int i) {
        Object obj = objArr[i];
        if (obj instanceof Node) {
            generateExpression(((Node) obj).getFirstChild(), node);
            return;
        }
        boolean z = obj instanceof String;
        ClassFileWriter classFileWriter = this.cfw;
        if (z) {
            classFileWriter.S((String) obj);
        } else {
            classFileWriter.Q(((Integer) obj).intValue());
            addScriptRuntimeInvoke("wrapInt", "(I)Ljava/lang/Integer;");
        }
    }

    private void addLoadPropertyValue(Node node, Node node2) {
        int type = node2.getType();
        if (type == 165 || type == 166 || type == 177) {
            generateExpression(node2.getFirstChild(), node);
        } else {
            generateExpression(node2, node);
        }
    }

    private void addNewObjectArray(int i) {
        if (i != 0) {
            this.cfw.Q(i);
            this.cfw.t(189, "java/lang/Object");
            return;
        }
        int i2 = this.itsZeroArgArray;
        ClassFileWriter classFileWriter = this.cfw;
        if (i2 >= 0) {
            classFileWriter.v(i2);
        } else {
            classFileWriter.u(Token.ARROW, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        }
    }

    private void addObjectToDouble() {
        addDynamicInvoke("MATH:TONUMBER", Signatures.MATH_TO_NUMBER);
    }

    private void addObjectToNumeric() {
        addDynamicInvoke("MATH:TONUMERIC", Signatures.MATH_TO_NUMERIC);
    }

    private void addOptRuntimeInvoke(String str, String str2) {
        this.cfw.F(Token.DOTDOTDOT, "org/mozilla/javascript/optimizer/OptRuntime", str, str2);
    }

    private void addScriptRuntimeInvoke(String str, String str2) {
        this.cfw.F(Token.DOTDOTDOT, "org.mozilla.javascript.ScriptRuntime", str, str2);
    }

    private static int countArguments(Node node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.getNext();
        }
        return i;
    }

    private void dcpLoadAsNumber(int i) {
        this.cfw.v(i);
        this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iQ = this.cfw.q();
        this.cfw.s(Token.GET, iQ);
        int iO0 = this.cfw.o0();
        this.cfw.v(i);
        addObjectToDouble();
        int iQ2 = this.cfw.q();
        this.cfw.s(Token.LET, iQ2);
        this.cfw.s0(iQ, iO0);
        this.cfw.x(i + 1);
        this.cfw.r0(iQ2);
    }

    private void dcpLoadAsObject(int i) {
        this.cfw.v(i);
        this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iQ = this.cfw.q();
        this.cfw.s(Token.GET, iQ);
        int iO0 = this.cfw.o0();
        this.cfw.v(i);
        int iQ2 = this.cfw.q();
        this.cfw.s(Token.LET, iQ2);
        this.cfw.s0(iQ, iO0);
        this.cfw.x(i + 1);
        addDoubleWrap();
        this.cfw.r0(iQ2);
    }

    private void decReferenceWordLocal(int i) {
        this.locals[i] = r1[i] - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String exceptionTypeToName(int i) {
        if (i == 0) {
            return "org/mozilla/javascript/JavaScriptException";
        }
        if (i == 1) {
            return "org/mozilla/javascript/EvaluatorException";
        }
        if (i == 2) {
            return "org/mozilla/javascript/EcmaError";
        }
        if (i == 3) {
            return "java/lang/Throwable";
        }
        if (i == 4) {
            return null;
        }
        throw Kit.codeBug();
    }

    private Node findNestedYield(Node node) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if (firstChild.getType() == 78 || firstChild.getType() == 179) {
                return firstChild;
            }
            Node nodeFindNestedYield = findNestedYield(firstChild);
            if (nodeFindNestedYield != null) {
                return nodeFindNestedYield;
            }
        }
        return null;
    }

    private void finishGetElemGeneration(Node node, Node node2) {
        generateExpression(node2.getNext(), node);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        if (node.getIntProp(31, 0) == 1) {
            this.cfw.v(this.thisObjLocal);
            addDynamicInvoke("PROP:GETELEMENTSUPER", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Ljava/lang/Object;");
        } else if (node.getIntProp(8, -1) != -1) {
            addDynamicInvoke("PROP:GETINDEX", Signatures.PROP_GET_INDEX);
        } else {
            addDynamicInvoke("PROP:GETELEMENT", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        }
    }

    private void finishGetPropGeneration(Node node, Node node2) {
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        if (node.getIntProp(31, 0) == 1) {
            this.cfw.v(this.thisObjLocal);
            this.cfw.L(node.getType() == 34 ? 1 : 0);
            addDynamicInvoke("PROP:GETSUPER:" + node2.getString(), Signatures.PROP_GET_SUPER);
            return;
        }
        if (node.getType() == 34) {
            addDynamicInvoke("PROP:GETNOWARN:" + node2.getString(), "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
            return;
        }
        addDynamicInvoke("PROP:GET:" + node2.getString(), "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void finishGetRefGeneration() {
        this.cfw.v(this.contextLocal);
        addScriptRuntimeInvoke("refGet", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
    }

    private void finishRefSpecialGeneration(Node node) {
        this.cfw.S((String) node.getProp(17));
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addScriptRuntimeInvoke("specialRef", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Ref;");
    }

    private void genSimpleCompare(int i, int i2, int i3) {
        if (i2 == -1) {
            throw Codegen.badTree();
        }
        switch (i) {
            case 14:
                this.cfw.r(Token.USE_STACK);
                this.cfw.s(Token.LOCAL_BLOCK, i2);
                break;
            case 15:
                this.cfw.r(Token.USE_STACK);
                this.cfw.s(Token.COLONCOLON, i2);
                break;
            case 16:
                this.cfw.r(Token.TYPEOFNAME);
                this.cfw.s(Token.DOTDOT, i2);
                break;
            case 17:
                this.cfw.r(Token.TYPEOFNAME);
                this.cfw.s(Token.SET_REF_OP, i2);
                break;
            default:
                throw Codegen.badTree();
        }
        if (i3 != -1) {
            this.cfw.s(Token.LET, i3);
        }
    }

    private void generateActivationExit() {
        if (this.fnCurrent == null || this.hasVarsInRegs) {
            throw Kit.codeBug();
        }
        this.cfw.v(this.contextLocal);
        addScriptRuntimeInvoke("exitActivationFunction", "(Lorg/mozilla/javascript/Context;)V");
    }

    private void generateArrayLiteralFactory(Node node, int i) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i;
        initBodyGeneration();
        int i2 = this.firstFreeLocal;
        int i3 = i2 + 1;
        this.firstFreeLocal = i3;
        this.argsLocal = i2;
        this.localsMax = i3;
        this.cfw.G0(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitArrayLiteral(node, node.getFirstChild(), true);
        this.cfw.r(Token.GENEXPR);
        this.cfw.H0((short) (this.localsMax + 1));
    }

    private void generateCallArgArray(Node node, Node node2, boolean z) {
        int i;
        int iCountArguments = countArguments(node2);
        if (iCountArguments != 1 || (i = this.itsOneArgArray) < 0) {
            addNewObjectArray(iCountArguments);
        } else {
            this.cfw.v(i);
        }
        for (int i2 = 0; i2 != iCountArguments; i2++) {
            if (!this.isGenerator) {
                this.cfw.r(89);
                this.cfw.Q(i2);
            }
            if (z) {
                int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
                if (iNodeIsDirectCallParameter >= 0) {
                    dcpLoadAsObject(iNodeIsDirectCallParameter);
                } else {
                    generateExpression(node2, node);
                    if (node2.getIntProp(8, -1) == 0) {
                        addDoubleWrap();
                    }
                }
            } else {
                generateExpression(node2, node);
            }
            if (this.isGenerator) {
                short newWordLocal = getNewWordLocal();
                this.cfw.w(newWordLocal);
                this.cfw.t(192, "[Ljava/lang/Object;");
                this.cfw.r(89);
                this.cfw.Q(i2);
                this.cfw.v(newWordLocal);
                releaseWordLocal(newWordLocal);
            }
            this.cfw.r(83);
            node2 = node2.getNext();
        }
    }

    private void generateCatchBlock(int i, short s, int i2, int i3, int i4) {
        if (i4 == 0) {
            i4 = this.cfw.q();
        }
        this.cfw.q0(i4);
        this.cfw.w(i3);
        this.cfw.v(s);
        this.cfw.w(this.variableObjectLocal);
        this.cfw.s(Token.LET, i2);
    }

    private void generateCheckForThrowOrClose(int i, boolean z, int i2) {
        int iQ = this.cfw.q();
        int iQ2 = this.cfw.q();
        this.cfw.r0(iQ);
        this.cfw.v(this.argsLocal);
        generateThrowJavaScriptException();
        this.cfw.r0(iQ2);
        this.cfw.v(this.argsLocal);
        this.cfw.t(192, "java/lang/Throwable");
        this.cfw.r(191);
        if (i != -1) {
            this.cfw.r0(i);
        }
        if (!z) {
            this.cfw.t0(this.generatorSwitch, i2);
        }
        this.cfw.C(this.operationLocal);
        this.cfw.L(2);
        this.cfw.s(Token.XML, iQ2);
        this.cfw.C(this.operationLocal);
        this.cfw.L(1);
        this.cfw.s(Token.XML, iQ);
    }

    private void generateEpilogue() {
        ClassFileWriter classFileWriter;
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.isGenerator) {
            Map<Node, int[]> liveLocals = ((FunctionNode) this.scriptOrFn).getLiveLocals();
            if (liveLocals != null) {
                for (Node node : ((FunctionNode) this.scriptOrFn).getResumptionPoints()) {
                    int[] iArr = liveLocals.get(node);
                    if (iArr != null) {
                        this.cfw.t0(this.generatorSwitch, getNextGeneratorState(node));
                        generateGetGeneratorLocalsState();
                        int i = 0;
                        while (true) {
                            int length = iArr.length;
                            classFileWriter = this.cfw;
                            if (i >= length) {
                                break;
                            }
                            classFileWriter.r(89);
                            this.cfw.L(i);
                            this.cfw.r(50);
                            this.cfw.w(iArr[i]);
                            i++;
                        }
                        classFileWriter.r(87);
                        this.cfw.s(Token.LET, getTargetLabel(node));
                    }
                }
            }
            Map<Node, FinallyReturnPoint> map = this.finallys;
            if (map != null) {
                for (Map.Entry<Node, FinallyReturnPoint> entry : map.entrySet()) {
                    if (entry.getKey().getType() == 138) {
                        FinallyReturnPoint value = entry.getValue();
                        this.cfw.s0(value.tableLabel, 1);
                        int iW = this.cfw.W(0, value.jsrPoints.size() - 1);
                        this.cfw.v0(iW);
                        int i2 = 0;
                        for (int i3 = 0; i3 < value.jsrPoints.size(); i3++) {
                            this.cfw.t0(iW, i2);
                            this.cfw.s(Token.LET, value.jsrPoints.get(i3).intValue());
                            i2++;
                        }
                    }
                }
            }
        }
        int i4 = this.epilogueLabel;
        if (i4 != -1) {
            this.cfw.r0(i4);
        }
        if (this.isGenerator) {
            if (((FunctionNode) this.scriptOrFn).getResumptionPoints() != null) {
                this.cfw.v0(this.generatorSwitch);
            }
            generateSetGeneratorResumptionPoint(-1);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.generatorStateLocal);
            addOptRuntimeInvoke("throwStopIteration", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            Codegen.pushUndefined(this.cfw);
            this.cfw.r(Token.GENEXPR);
            return;
        }
        if (this.hasVarsInRegs) {
            this.cfw.r(Token.GENEXPR);
            return;
        }
        if (this.fnCurrent == null) {
            this.cfw.v(this.popvLocal);
            this.cfw.r(Token.GENEXPR);
            return;
        }
        generateActivationExit();
        this.cfw.r(Token.GENEXPR);
        int iQ = this.cfw.q();
        this.cfw.q0(iQ);
        short newWordLocal = getNewWordLocal();
        this.cfw.w(newWordLocal);
        generateActivationExit();
        this.cfw.v(newWordLocal);
        releaseWordLocal(newWordLocal);
        this.cfw.r(191);
        this.cfw.z(this.enterAreaStartLabel, this.epilogueLabel, iQ, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:136:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0688  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void generateExpression(org.mozilla.javascript.Node r19, org.mozilla.javascript.Node r20) {
        /*
            Method dump skipped, instruction units count: 2048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BodyCodegen.generateExpression(org.mozilla.javascript.Node, org.mozilla.javascript.Node):void");
    }

    private void generateFunctionAndThisObj(Node node, Node node2) {
        int type = node.getType();
        boolean z = node2.getIntProp(30, 0) == 1;
        int type2 = node.getType();
        if (type2 != 33) {
            if (type2 == 34) {
                throw Kit.codeBug();
            }
            if (type2 != 39) {
                if (type2 != 44) {
                    generateExpression(node, node2);
                    this.cfw.v(this.contextLocal);
                    addScriptRuntimeInvoke(z ? "getValueFunctionAndThisOptional" : "getValueFunctionAndThis", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;");
                    return;
                }
                String string = node.getString();
                this.cfw.v(this.variableObjectLocal);
                this.cfw.v(this.contextLocal);
                addDynamicInvoke("NAME:" + (z ? "GETWITHTHISOPTIONAL" : "GETWITHTHIS") + ":" + string, Signatures.NAME_GET_THIS);
                return;
            }
        }
        Node firstChild = node.getFirstChild();
        generateExpression(firstChild, node);
        Node next = firstChild.getNext();
        if (type != 33) {
            generateExpression(next, node);
            if (node.getIntProp(8, -1) != -1) {
                addDoubleWrap();
            }
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            addScriptRuntimeInvoke(z ? "getElemFunctionAndThisOptional" : "getElemFunctionAndThis", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;");
            return;
        }
        String string2 = next.getString();
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addDynamicInvoke("PROP:" + (z ? "GETWITHTHISOPTIONAL" : "GETWITHTHIS") + ":" + string2, Signatures.PROP_GET_THIS);
    }

    private void generateGenerator() {
        this.cfw.G0(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        initBodyGeneration();
        int i = this.firstFreeLocal;
        int i2 = i + 1;
        this.firstFreeLocal = i2;
        this.argsLocal = i;
        this.localsMax = i2;
        if (this.fnCurrent != null) {
            this.cfw.v(this.funObjLocal);
            this.cfw.F(Token.NULLISH_COALESCING, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.w(this.variableObjectLocal);
        }
        this.cfw.v(this.funObjLocal);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        this.cfw.v(this.argsLocal);
        this.cfw.T(this.scriptOrFn.isInStrictMode());
        this.cfw.T(this.scriptOrFn.hasRestParameter());
        this.cfw.O();
        this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/BaseFunction", "getHomeObject", "()Lorg/mozilla/javascript/Scriptable;");
        addScriptRuntimeInvoke("createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;ZZLorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.w(this.variableObjectLocal);
        this.cfw.t(Token.LAST_TOKEN, this.codegen.mainClassName);
        this.cfw.r(89);
        this.cfw.v(this.variableObjectLocal);
        this.cfw.v(this.contextLocal);
        this.cfw.Q(this.scriptOrFnIndex);
        this.cfw.F(Token.TAGGED_TEMPLATE_LITERAL, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        generateNestedFunctionInits();
        this.cfw.v(this.variableObjectLocal);
        this.cfw.v(this.thisObjLocal);
        this.cfw.L(this.maxLocals);
        this.cfw.L(this.maxStack);
        addOptRuntimeInvoke("createNativeGenerator", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;II)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.r(Token.GENEXPR);
        this.cfw.H0((short) (this.localsMax + 1));
    }

    private void generateGetGeneratorLocalsState() {
        this.cfw.v(this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorLocalsState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateGetGeneratorResumptionPoint() {
        this.cfw.v(this.generatorStateLocal);
        this.cfw.u(180, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    private void generateGetGeneratorStackState() {
        this.cfw.v(this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorStackState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateIfJump(Node node, Node node2, int i, int i2) {
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 26) {
            generateIfJump(firstChild, node, i2, i);
            return;
        }
        if (type != 51 && type != 52) {
            if (type != 57 && type != 58) {
                if (type == 117 || type == 118) {
                    int iQ = this.cfw.q();
                    if (type == 118) {
                        generateIfJump(firstChild, node, iQ, i2);
                    } else {
                        generateIfJump(firstChild, node, i, iQ);
                    }
                    this.cfw.r0(iQ);
                    generateIfJump(firstChild.getNext(), node, i, i2);
                    return;
                }
                switch (type) {
                    case 12:
                    case 13:
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        generateExpression(node, node2);
                        addDynamicInvoke("MATH:TOBOOLEAN", Signatures.MATH_TO_BOOLEAN);
                        this.cfw.s(Token.SETELEM_OP, i);
                        this.cfw.s(Token.LET, i2);
                        break;
                }
                return;
            }
            visitIfJumpRelOp(node, firstChild, i, i2);
            return;
        }
        visitIfJumpEqOp(node, firstChild, i, i2);
    }

    private void generateIntegerUnwrap() {
        this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, "java/lang/Integer", "intValue", "()I");
    }

    private void generateIntegerWrap() {
        this.cfw.F(Token.DOTDOTDOT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    }

    private void generateLocalYieldPoint(Node node, boolean z) {
        ClassFileWriter classFileWriter;
        ClassFileWriter classFileWriter2;
        int iO0 = this.cfw.o0();
        int i = this.maxStack;
        if (i <= iO0) {
            i = iO0;
        }
        this.maxStack = i;
        if (iO0 != 0) {
            generateGetGeneratorStackState();
            int i2 = 0;
            while (true) {
                classFileWriter2 = this.cfw;
                if (i2 >= iO0) {
                    break;
                }
                classFileWriter2.r(90);
                this.cfw.r(95);
                this.cfw.L(i2);
                this.cfw.r(95);
                this.cfw.r(83);
                i2++;
            }
            classFileWriter2.r(87);
        }
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else {
            Codegen.pushUndefined(this.cfw);
        }
        if (node.getType() == 179) {
            this.cfw.t(Token.LAST_TOKEN, "org/mozilla/javascript/ES6Generator$YieldStarResult");
            this.cfw.r(90);
            this.cfw.r(95);
            this.cfw.F(Token.TAGGED_TEMPLATE_LITERAL, "org/mozilla/javascript/ES6Generator$YieldStarResult", "<init>", "(Ljava/lang/Object;)V");
        }
        int nextGeneratorState = getNextGeneratorState(node);
        generateSetGeneratorResumptionPoint(nextGeneratorState);
        boolean zGenerateSaveLocals = generateSaveLocals(node);
        this.cfw.r(Token.GENEXPR);
        generateCheckForThrowOrClose(getTargetLabel(node), zGenerateSaveLocals, nextGeneratorState);
        if (iO0 != 0) {
            generateGetGeneratorStackState();
            while (true) {
                iO0--;
                classFileWriter = this.cfw;
                if (iO0 < 0) {
                    break;
                }
                classFileWriter.r(89);
                this.cfw.L(iO0);
                this.cfw.r(50);
                this.cfw.r(95);
            }
            classFileWriter.r(87);
        }
        if (z) {
            this.cfw.v(this.argsLocal);
        }
    }

    private void generateNestedFunctionInits() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, i);
            if (optFunctionNode.fnode.getFunctionType() == 1) {
                visitFunction(optFunctionNode, 1);
            }
        }
    }

    private void generateObjectLiteralFactory(Node node, int i) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i;
        initBodyGeneration();
        int i2 = this.firstFreeLocal;
        int i3 = i2 + 1;
        this.firstFreeLocal = i3;
        this.argsLocal = i2;
        this.localsMax = i3;
        this.cfw.G0(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitObjectLiteral(node, node.getFirstChild(), true);
        this.cfw.r(Token.GENEXPR);
        this.cfw.H0((short) (this.localsMax + 1));
    }

    private void generatePrologue() {
        String str;
        int newWordLocal;
        if (this.inDirectCallFunction) {
            int paramCount = this.scriptOrFn.getParamCount();
            if (this.firstFreeLocal != 4) {
                Kit.codeBug();
            }
            for (int i = 0; i != paramCount; i++) {
                int[] iArr = this.varRegisters;
                int i2 = this.firstFreeLocal;
                iArr[i] = i2;
                this.firstFreeLocal = i2 + 3;
            }
            if (!this.fnCurrent.getParameterNumberContext()) {
                this.itsForcedObjectParameters = true;
                for (int i3 = 0; i3 != paramCount; i3++) {
                    int i4 = this.varRegisters[i3];
                    this.cfw.v(i4);
                    this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    int iQ = this.cfw.q();
                    this.cfw.s(Token.SET, iQ);
                    this.cfw.x(i4 + 1);
                    addDoubleWrap();
                    this.cfw.w(i4);
                    this.cfw.r0(iQ);
                }
            }
        }
        if (this.fnCurrent != null) {
            this.cfw.v(this.funObjLocal);
            this.cfw.F(Token.NULLISH_COALESCING, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.w(this.variableObjectLocal);
        }
        int i5 = this.firstFreeLocal;
        int i6 = i5 + 1;
        this.firstFreeLocal = i6;
        this.argsLocal = i5;
        this.localsMax = i6;
        if (this.isGenerator) {
            int i7 = i5 + 2;
            this.firstFreeLocal = i7;
            this.operationLocal = i6;
            this.localsMax = i7;
            this.cfw.v(this.thisObjLocal);
            int i8 = this.firstFreeLocal;
            int i9 = i8 + 1;
            this.firstFreeLocal = i9;
            this.generatorStateLocal = i8;
            this.localsMax = i9;
            this.cfw.t(192, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState");
            this.cfw.r(89);
            this.cfw.w(this.generatorStateLocal);
            this.cfw.u(180, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "thisObj", "Lorg/mozilla/javascript/Scriptable;");
            this.cfw.w(this.thisObjLocal);
            if (this.epilogueLabel == -1) {
                this.epilogueLabel = this.cfw.q();
            }
            List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
            if (resumptionPoints != null) {
                generateGetGeneratorResumptionPoint();
                this.generatorSwitch = this.cfw.W(0, resumptionPoints.size());
                generateCheckForThrowOrClose(-1, false, 0);
            }
        }
        if (this.fnCurrent == null) {
            if (this.scriptOrFn.getRegexpCount() != 0) {
                this.cfw.v(this.contextLocal);
                this.cfw.F(Token.DOTDOTDOT, this.codegen.mainClassName, "_reInit", "(Lorg/mozilla/javascript/Context;)V");
            }
            if (this.scriptOrFn.getTemplateLiteralCount() != 0) {
                this.cfw.F(Token.DOTDOTDOT, this.codegen.mainClassName, "_qInit", "()V");
            }
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            saveCurrentCodeOffset();
        }
        if (this.isGenerator) {
            return;
        }
        boolean z = this.hasVarsInRegs;
        ScriptNode scriptNode = this.scriptOrFn;
        if (z) {
            int paramCount2 = scriptNode.getParamCount();
            if (paramCount2 > 0 && !this.inDirectCallFunction) {
                boolean zHasRestParameter = this.scriptOrFn.hasRestParameter();
                ClassFileWriter classFileWriter = this.cfw;
                if (zHasRestParameter) {
                    classFileWriter.v(this.contextLocal);
                    this.cfw.v(this.variableObjectLocal);
                    this.cfw.v(this.argsLocal);
                    this.cfw.Q(paramCount2);
                    addScriptRuntimeInvoke("padAndRestArguments", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;I)[Ljava/lang/Object;");
                    this.cfw.w(this.argsLocal);
                } else {
                    classFileWriter.v(this.argsLocal);
                    this.cfw.r(190);
                    this.cfw.Q(paramCount2);
                    int iQ2 = this.cfw.q();
                    this.cfw.s(Token.XMLEND, iQ2);
                    this.cfw.v(this.argsLocal);
                    this.cfw.Q(paramCount2);
                    addScriptRuntimeInvoke("padArguments", "([Ljava/lang/Object;I)[Ljava/lang/Object;");
                    this.cfw.w(this.argsLocal);
                    this.cfw.r0(iQ2);
                }
            }
            int paramCount3 = this.fnCurrent.fnode.getParamCount();
            int paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount();
            boolean[] paramAndVarConst = this.fnCurrent.fnode.getParamAndVarConst();
            int i10 = -1;
            for (int i11 = 0; i11 != paramAndVarCount; i11++) {
                if (i11 < paramCount3) {
                    if (this.inDirectCallFunction) {
                        newWordLocal = -1;
                    } else {
                        newWordLocal = getNewWordLocal();
                        this.cfw.v(this.argsLocal);
                        this.cfw.Q(i11);
                        this.cfw.r(50);
                        this.cfw.w(newWordLocal);
                    }
                } else if (this.fnCurrent.isNumberVar(i11)) {
                    newWordLocal = getNewWordPairLocal(paramAndVarConst[i11]);
                    this.cfw.P(0.0d);
                    this.cfw.y(newWordLocal);
                } else {
                    newWordLocal = getNewWordLocal(paramAndVarConst[i11]);
                    ClassFileWriter classFileWriter2 = this.cfw;
                    if (i10 == -1) {
                        Codegen.pushUndefined(classFileWriter2);
                        i10 = newWordLocal;
                    } else {
                        classFileWriter2.v(i10);
                    }
                    this.cfw.w(newWordLocal);
                }
                if (newWordLocal >= 0) {
                    if (paramAndVarConst[i11]) {
                        this.cfw.Q(0);
                        this.cfw.D((this.fnCurrent.isNumberVar(i11) ? 2 : 1) + newWordLocal);
                    }
                    this.varRegisters[i11] = newWordLocal;
                }
                if (this.compilerEnv.isGenerateDebugInfo()) {
                    String paramOrVarName = this.fnCurrent.fnode.getParamOrVarName(i11);
                    String str2 = this.fnCurrent.isNumberVar(i11) ? SardineUtil.DEFAULT_NAMESPACE_PREFIX : "Ljava/lang/Object;";
                    int iL0 = this.cfw.l0();
                    if (newWordLocal < 0) {
                        newWordLocal = this.varRegisters[i11];
                    }
                    this.cfw.Z(paramOrVarName, str2, iL0, newWordLocal);
                }
            }
            return;
        }
        boolean z2 = (scriptNode instanceof FunctionNode) && ((FunctionNode) scriptNode).getFunctionType() == 4;
        OptFunctionNode optFunctionNode = this.fnCurrent;
        ClassFileWriter classFileWriter3 = this.cfw;
        if (optFunctionNode != null) {
            classFileWriter3.v(this.funObjLocal);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.argsLocal);
            this.cfw.T(this.scriptOrFn.isInStrictMode());
            this.cfw.T(this.scriptOrFn.hasRestParameter());
            ClassFileWriter classFileWriter4 = this.cfw;
            if (z2) {
                int iQ3 = classFileWriter4.q();
                int iQ4 = this.cfw.q();
                this.cfw.v(this.variableObjectLocal);
                this.cfw.t(193, "org/mozilla/javascript/NativeCall");
                this.cfw.s(Token.SETPROP_OP, iQ3);
                this.cfw.v(this.variableObjectLocal);
                this.cfw.t(192, "org/mozilla/javascript/NativeCall");
                this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/NativeCall", "getHomeObject", "()Lorg/mozilla/javascript/Scriptable;");
                this.cfw.s(Token.LET, iQ4);
                this.cfw.r0(iQ3);
                this.cfw.r(1);
                this.cfw.r0(iQ4);
            } else {
                classFileWriter4.O();
                this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/BaseFunction", "getHomeObject", "()Lorg/mozilla/javascript/Scriptable;");
            }
            addScriptRuntimeInvoke(z2 ? "createArrowFunctionActivation" : "createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;ZZLorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
            this.cfw.w(this.variableObjectLocal);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            addScriptRuntimeInvoke("enterActivationFunction", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V");
            str = "activation";
        } else {
            classFileWriter3.v(this.funObjLocal);
            this.cfw.v(this.thisObjLocal);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.Q(0);
            addScriptRuntimeInvoke("initScript", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Z)V");
            str = "global";
        }
        this.enterAreaStartLabel = this.cfw.q();
        this.epilogueLabel = this.cfw.q();
        this.cfw.r0(this.enterAreaStartLabel);
        generateNestedFunctionInits();
        if (this.compilerEnv.isGenerateDebugInfo()) {
            ClassFileWriter classFileWriter5 = this.cfw;
            classFileWriter5.Z(str, "Lorg/mozilla/javascript/Scriptable;", classFileWriter5.l0(), this.variableObjectLocal);
        }
        OptFunctionNode optFunctionNode2 = this.fnCurrent;
        if (optFunctionNode2 == null) {
            this.popvLocal = getNewWordLocal();
            Codegen.pushUndefined(this.cfw);
            this.cfw.w(this.popvLocal);
            int endLineno = this.scriptOrFn.getEndLineno();
            if (endLineno != -1) {
                this.cfw.J((short) endLineno);
                return;
            }
            return;
        }
        if (optFunctionNode2.itsContainsCalls0) {
            this.itsZeroArgArray = getNewWordLocal();
            this.cfw.u(Token.ARROW, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
            this.cfw.w(this.itsZeroArgArray);
        }
        if (this.fnCurrent.itsContainsCalls1) {
            this.itsOneArgArray = getNewWordLocal();
            this.cfw.Q(1);
            this.cfw.t(189, "java/lang/Object");
            this.cfw.w(this.itsOneArgArray);
        }
    }

    private boolean generateSaveLocals(Node node) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.firstFreeLocal; i3++) {
            if (this.locals[i3] != 0) {
                i2++;
            }
        }
        if (i2 == 0) {
            ((FunctionNode) this.scriptOrFn).addLiveLocals(node, null);
            return false;
        }
        int i4 = this.maxLocals;
        if (i4 <= i2) {
            i4 = i2;
        }
        this.maxLocals = i4;
        int[] iArr = new int[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < this.firstFreeLocal; i6++) {
            if (this.locals[i6] != 0) {
                iArr[i5] = i6;
                i5++;
            }
        }
        ((FunctionNode) this.scriptOrFn).addLiveLocals(node, iArr);
        generateGetGeneratorLocalsState();
        while (true) {
            ClassFileWriter classFileWriter = this.cfw;
            if (i >= i2) {
                classFileWriter.r(87);
                return true;
            }
            classFileWriter.r(89);
            this.cfw.L(i);
            this.cfw.v(iArr[i]);
            this.cfw.r(83);
            i++;
        }
    }

    private void generateSetGeneratorResumptionPoint(int i) {
        this.cfw.v(this.generatorStateLocal);
        this.cfw.L(i);
        this.cfw.u(Token.TEMPLATE_CHARS, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    private void generateSetGeneratorReturnValue() {
        this.cfw.v(this.generatorStateLocal);
        this.cfw.r(95);
        addOptRuntimeInvoke("setGeneratorReturnValue", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }

    private void generateStatement(Node node) {
        updateLineNumber(node);
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 55) {
            generateExpression(firstChild, node);
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            generateThrowJavaScriptException();
            return;
        }
        if (type == 56) {
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            this.cfw.v(getLocalBlockRegister(node));
            this.cfw.r(191);
            return;
        }
        if (type != 70) {
            if (type == 90) {
                visitTryCatchFinally((Jump) node, firstChild);
                return;
            }
            int i = 1;
            if (type == 122) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, node.getExistingIntProp(1));
                int functionType = optFunctionNode.fnode.getFunctionType();
                if (functionType == 3) {
                    visitFunction(optFunctionNode, functionType);
                    return;
                } else {
                    if (functionType != 1) {
                        throw Codegen.badTree();
                    }
                    return;
                }
            }
            if (type == 127) {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    addInstructionCount();
                }
                visitSwitch((Jump) node, firstChild);
                return;
            }
            if (type != 136) {
                if (type == 138) {
                    if (this.isGenerator) {
                        if (this.compilerEnv.isGenerateObserverCount()) {
                            saveCurrentCodeOffset();
                        }
                        this.cfw.C0((short) 1);
                        short newWordLocal = getNewWordLocal();
                        int iQ = this.cfw.q();
                        int iQ2 = this.cfw.q();
                        this.cfw.r0(iQ);
                        generateIntegerWrap();
                        this.cfw.w(newWordLocal);
                        while (firstChild != null) {
                            generateStatement(firstChild);
                            firstChild = firstChild.getNext();
                        }
                        this.cfw.v(newWordLocal);
                        this.cfw.t(192, "java/lang/Integer");
                        generateIntegerUnwrap();
                        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
                        int iQ3 = this.cfw.q();
                        finallyReturnPoint.tableLabel = iQ3;
                        this.cfw.s(Token.LET, iQ3);
                        this.cfw.C0((short) 0);
                        releaseWordLocal(newWordLocal);
                        this.cfw.r0(iQ2);
                        return;
                    }
                    return;
                }
                if (type != 141) {
                    if (type == 155) {
                        boolean z = this.inLocalBlock;
                        this.inLocalBlock = true;
                        short newWordLocal2 = getNewWordLocal();
                        if (this.isGenerator) {
                            this.cfw.r(1);
                            this.cfw.w(newWordLocal2);
                        }
                        node.putIntProp(2, newWordLocal2);
                        while (firstChild != null) {
                            generateStatement(firstChild);
                            firstChild = firstChild.getNext();
                        }
                        releaseWordLocal(newWordLocal2);
                        node.removeProp(2);
                        this.inLocalBlock = z;
                        return;
                    }
                    if (type != 174) {
                        switch (type) {
                            case 2:
                                generateExpression(firstChild, node);
                                this.cfw.v(this.contextLocal);
                                this.cfw.v(this.variableObjectLocal);
                                addScriptRuntimeInvoke("enterWith", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                this.cfw.w(this.variableObjectLocal);
                                incReferenceWordLocal(this.variableObjectLocal);
                                return;
                            case 3:
                                this.cfw.v(this.variableObjectLocal);
                                addScriptRuntimeInvoke("leaveWith", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                this.cfw.w(this.variableObjectLocal);
                                decReferenceWordLocal(this.variableObjectLocal);
                                return;
                            case 4:
                                break;
                            default:
                                switch (type) {
                                    case Token.CATCH_SCOPE /* 62 */:
                                        this.cfw.C0((short) 0);
                                        int localBlockRegister = getLocalBlockRegister(node);
                                        int existingIntProp = node.getExistingIntProp(14);
                                        String string = firstChild.getType() == 44 ? firstChild.getString() : null;
                                        generateExpression(firstChild.getNext(), node);
                                        ClassFileWriter classFileWriter = this.cfw;
                                        if (existingIntProp == 0) {
                                            classFileWriter.r(1);
                                        } else {
                                            classFileWriter.v(localBlockRegister);
                                        }
                                        ClassFileWriter classFileWriter2 = this.cfw;
                                        if (string != null) {
                                            classFileWriter2.S(string);
                                        } else {
                                            classFileWriter2.r(1);
                                        }
                                        this.cfw.v(this.contextLocal);
                                        this.cfw.v(this.variableObjectLocal);
                                        addScriptRuntimeInvoke("newCatchScope", "(Ljava/lang/Throwable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                        this.cfw.w(localBlockRegister);
                                        return;
                                    case Token.ENUM_INIT_KEYS /* 63 */:
                                    case 64:
                                    case Token.ENUM_INIT_ARRAY /* 65 */:
                                    case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
                                        generateExpression(firstChild, node);
                                        this.cfw.v(this.contextLocal);
                                        this.cfw.v(this.variableObjectLocal);
                                        if (type == 63) {
                                            i = 0;
                                        } else if (type != 64) {
                                            i = type == 66 ? 6 : 2;
                                        }
                                        this.cfw.Q(i);
                                        addScriptRuntimeInvoke("enumInit", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                                        this.cfw.w(getLocalBlockRegister(node));
                                        return;
                                    default:
                                        switch (type) {
                                            case Token.BLOCK /* 143 */:
                                            case Token.LABEL /* 144 */:
                                            case Token.LOOP /* 146 */:
                                            case 150:
                                                break;
                                            case Token.TARGET /* 145 */:
                                                if (this.compilerEnv.isGenerateObserverCount()) {
                                                    addInstructionCount();
                                                }
                                                this.cfw.r0(getTargetLabel(node));
                                                if (this.compilerEnv.isGenerateObserverCount()) {
                                                    saveCurrentCodeOffset();
                                                    return;
                                                }
                                                return;
                                            case Token.EXPR_VOID /* 147 */:
                                                if (firstChild.getType() == 61) {
                                                    visitSetVar(firstChild, firstChild.getFirstChild(), false);
                                                    return;
                                                }
                                                if (firstChild.getType() == 170) {
                                                    visitSetConstVar(firstChild, firstChild.getFirstChild(), false);
                                                    return;
                                                }
                                                if (firstChild.getType() == 78 || firstChild.getType() == 179) {
                                                    generateYieldPoint(firstChild, false);
                                                    return;
                                                }
                                                generateExpression(firstChild, node);
                                                int intProp = node.getIntProp(8, -1);
                                                ClassFileWriter classFileWriter3 = this.cfw;
                                                if (intProp != -1) {
                                                    classFileWriter3.r(88);
                                                    return;
                                                } else {
                                                    classFileWriter3.r(87);
                                                    return;
                                                }
                                            case Token.EXPR_RESULT /* 148 */:
                                                generateExpression(firstChild, node);
                                                if (this.popvLocal < 0) {
                                                    this.popvLocal = getNewWordLocal();
                                                }
                                                this.cfw.w(this.popvLocal);
                                                return;
                                            case Token.JSR /* 149 */:
                                                break;
                                            default:
                                                throw Codegen.badTree();
                                        }
                                        break;
                                }
                            case 5:
                            case 6:
                            case 7:
                                if (this.compilerEnv.isGenerateObserverCount()) {
                                    addInstructionCount();
                                }
                                visitGoto((Jump) node, type, firstChild);
                                return;
                        }
                    } else {
                        return;
                    }
                }
            }
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount(1);
            }
            while (firstChild != null) {
                generateStatement(firstChild);
                firstChild = firstChild.getNext();
            }
            return;
        }
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else if (type == 4) {
            Codegen.pushUndefined(this.cfw);
        } else {
            int i2 = this.popvLocal;
            if (i2 < 0) {
                throw Codegen.badTree();
            }
            this.cfw.v(i2);
        }
        if (this.isGenerator) {
            generateSetGeneratorReturnValue();
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.epilogueLabel == -1) {
            if (!this.hasVarsInRegs) {
                throw Codegen.badTree();
            }
            this.epilogueLabel = this.cfw.q();
        }
        this.cfw.s(Token.LET, this.epilogueLabel);
    }

    private void generateThrowJavaScriptException() {
        this.cfw.t(Token.LAST_TOKEN, "org/mozilla/javascript/JavaScriptException");
        this.cfw.r(90);
        this.cfw.r(95);
        this.cfw.S(this.scriptOrFn.getSourceName());
        this.cfw.Q(this.itsLineNumber);
        this.cfw.F(Token.TAGGED_TEMPLATE_LITERAL, "org/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
        this.cfw.r(191);
    }

    private void generateYieldPoint(Node node, boolean z) {
        if (this.unnestedYields.containsKey(node)) {
            if (z) {
                String str = this.unnestedYields.get(node);
                this.cfw.v(this.variableObjectLocal);
                this.cfw.v(this.contextLocal);
                this.cfw.v(this.variableObjectLocal);
                addDynamicInvoke("PROP:GETNOWARN:" + str, "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
                return;
            }
            return;
        }
        Node nodeFindNestedYield = findNestedYield(node);
        if (nodeFindNestedYield != null) {
            generateYieldPoint(nodeFindNestedYield, true);
            String str2 = "__nested__yield__" + this.unnestedYieldCount;
            this.unnestedYieldCount++;
            this.cfw.v(this.variableObjectLocal);
            this.cfw.r(95);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            addDynamicInvoke("PROP:SET:".concat(str2), "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
            this.cfw.r(87);
            this.unnestedYields.put(nodeFindNestedYield, str2);
        }
        generateLocalYieldPoint(node, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node getFinallyAtTarget(Node node) {
        Node next;
        if (node == null) {
            return null;
        }
        if (node.getType() == 138) {
            return node;
        }
        if (node.getType() == 145 && (next = node.getNext()) != null && next.getType() == 138) {
            return next;
        }
        throw Kit.codeBug("bad finally target");
    }

    private static int getLocalBlockRegister(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private short getNewWordIntern(int i) {
        int i2;
        int[] iArr = this.locals;
        int i3 = this.firstFreeLocal;
        if (i > 1) {
            loop0: while (true) {
                if (i3 + i > 1024) {
                    i3 = -1;
                    break;
                }
                i2 = 0;
                while (i2 < i) {
                    if (iArr[i3 + i2] != 0) {
                        break;
                    }
                    i2++;
                }
                break loop0;
                i3 += i2 + 1;
            }
        }
        if (i3 != -1) {
            iArr[i3] = 1;
            if (i > 1) {
                iArr[i3 + 1] = 1;
            }
            if (i > 2) {
                iArr[i3 + 2] = 1;
            }
            if (i3 != this.firstFreeLocal) {
                return (short) i3;
            }
            for (int i4 = i + i3; i4 < 1024; i4++) {
                if (iArr[i4] == 0) {
                    short s = (short) i4;
                    this.firstFreeLocal = s;
                    if (this.localsMax < s) {
                        this.localsMax = s;
                    }
                    return (short) i3;
                }
            }
        }
        throw Context.reportRuntimeError("Program too complex (out of locals)");
    }

    private short getNewWordLocal(boolean z) {
        return getNewWordIntern(z ? 2 : 1);
    }

    private short getNewWordPairLocal(boolean z) {
        return getNewWordIntern(z ? 3 : 2);
    }

    private int getNextGeneratorState(Node node) {
        return ((FunctionNode) this.scriptOrFn).getResumptionPoints().indexOf(node) + 1;
    }

    private int getTargetLabel(Node node) {
        int iLabelId = node.labelId();
        if (iLabelId != -1) {
            return iLabelId;
        }
        int iQ = this.cfw.q();
        node.labelId(iQ);
        return iQ;
    }

    private void incReferenceWordLocal(int i) {
        int[] iArr = this.locals;
        iArr[i] = iArr[i] + 1;
    }

    private void initBodyGeneration() {
        int paramAndVarCount;
        this.varRegisters = null;
        if (this.scriptOrFn.getType() == 122) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn);
            this.fnCurrent = optFunctionNode;
            boolean zRequiresActivation = optFunctionNode.fnode.requiresActivation();
            this.hasVarsInRegs = !zRequiresActivation;
            if (!zRequiresActivation && (paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount()) != 0) {
                this.varRegisters = new int[paramAndVarCount];
            }
            boolean zIsTargetOfDirectCall = this.fnCurrent.isTargetOfDirectCall();
            this.inDirectCallFunction = zIsTargetOfDirectCall;
            if (zIsTargetOfDirectCall && !this.hasVarsInRegs) {
                Codegen.badTree();
            }
        } else {
            this.fnCurrent = null;
            this.hasVarsInRegs = false;
            this.inDirectCallFunction = false;
        }
        this.locals = new int[1024];
        this.funObjLocal = 0;
        this.contextLocal = 1;
        this.variableObjectLocal = 2;
        this.thisObjLocal = 3;
        this.localsMax = 4;
        this.firstFreeLocal = 4;
        this.popvLocal = -1;
        this.argsLocal = -1;
        this.itsZeroArgArray = -1;
        this.itsOneArgArray = -1;
        this.epilogueLabel = -1;
        this.enterAreaStartLabel = -1;
        this.generatorStateLocal = -1;
        this.savedHomeObjectLocal = -1;
    }

    private void inlineFinally(Node node, int i, int i2) {
        Node finallyAtTarget = getFinallyAtTarget(node);
        finallyAtTarget.resetTargets();
        this.exceptionManager.markInlineFinallyStart(finallyAtTarget, i);
        for (Node firstChild = finallyAtTarget.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            generateStatement(firstChild);
        }
        this.exceptionManager.markInlineFinallyEnd(finallyAtTarget, i2);
    }

    private static boolean isArithmeticNode(Node node) {
        int type = node.getType();
        return type == 22 || type == 25 || type == 24 || type == 23;
    }

    private int nodeIsDirectCallParameter(Node node) {
        if (node.getType() != 60 || !this.inDirectCallFunction || this.itsForcedObjectParameters) {
            return -1;
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        if (this.fnCurrent.isParameter(varIndex)) {
            return this.varRegisters[varIndex];
        }
        return -1;
    }

    private void pushThisFromLastScriptable() {
        this.cfw.v(this.contextLocal);
        addScriptRuntimeInvoke("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void releaseWordLocal(int i) {
        if (i < this.firstFreeLocal) {
            this.firstFreeLocal = i;
        }
        this.locals[i] = 0;
    }

    private void saveCurrentCodeOffset() {
        this.savedCodeOffset = this.cfw.l0();
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        this.itsLineNumber = lineno;
        if (lineno == -1) {
            return;
        }
        this.cfw.J((short) lineno);
    }

    private boolean varIsDirectCallParameter(int i) {
        return this.fnCurrent.isParameter(i) && this.inDirectCallFunction && !this.itsForcedObjectParameters;
    }

    private void visitArithmetic(Node node, int i, Node node2, Node node3) {
        if (node.getIntProp(8, -1) != -1) {
            generateExpression(node2, node);
            generateExpression(node2.getNext(), node);
            switch (i) {
                case 22:
                    this.cfw.r(103);
                    return;
                case 23:
                    this.cfw.r(Token.ASSIGN_URSH);
                    return;
                case 24:
                    this.cfw.r(Token.ASSIGN_DIV);
                    return;
                case 25:
                    this.cfw.r(Token.HOOK);
                    return;
                default:
                    throw Kit.codeBug(Token.typeToName(i));
            }
        }
        generateExpression(node2, node);
        if (!isArithmeticNode(node2)) {
            addObjectToNumeric();
        }
        generateExpression(node2.getNext(), node);
        if (!isArithmeticNode(node2.getNext())) {
            addObjectToNumeric();
        }
        switch (i) {
            case 22:
                addScriptRuntimeInvoke("subtract", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                return;
            case 23:
                addScriptRuntimeInvoke("multiply", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                return;
            case 24:
                addScriptRuntimeInvoke("divide", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                return;
            case 25:
                addScriptRuntimeInvoke("remainder", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                return;
            default:
                throw Kit.codeBug(Token.typeToName(i));
        }
    }

    private void visitArrayLiteral(Node node, Node node2, boolean z) {
        int iCountArguments = countArguments(node2);
        if (!z && ((iCountArguments > 10 || this.cfw.l0() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new ArrayList<>();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.v(this.funObjLocal);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            this.cfw.v(this.argsLocal);
            this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        int i = 0;
        if (this.isGenerator) {
            for (int i2 = 0; i2 != iCountArguments; i2++) {
                generateExpression(node2, node);
                node2 = node2.getNext();
            }
            addNewObjectArray(iCountArguments);
            while (i != iCountArguments) {
                this.cfw.r(90);
                this.cfw.r(95);
                this.cfw.Q((iCountArguments - i) - 1);
                this.cfw.r(95);
                this.cfw.r(83);
                i++;
            }
        } else {
            addNewObjectArray(iCountArguments);
            while (i != iCountArguments) {
                this.cfw.r(89);
                this.cfw.Q(i);
                generateExpression(node2, node);
                this.cfw.r(83);
                node2 = node2.getNext();
                i++;
            }
        }
        int[] iArr = (int[]) node.getProp(11);
        ClassFileWriter classFileWriter = this.cfw;
        if (iArr == null) {
            classFileWriter.r(1);
            this.cfw.r(3);
        } else {
            classFileWriter.S(OptRuntime.encodeIntArray(iArr));
            this.cfw.Q(iArr.length);
        }
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addOptRuntimeInvoke("newArrayLiteral", "([Ljava/lang/Object;Ljava/lang/String;ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitBitNot(Node node, Node node2) {
        int intProp = node.getIntProp(8, -1);
        generateExpression(node2, node);
        if (intProp == -1) {
            addObjectToNumeric();
            addScriptRuntimeInvoke("bitwiseNOT", "(Ljava/lang/Number;)Ljava/lang/Number;");
        } else {
            addScriptRuntimeInvoke("toInt32", "(D)I");
            this.cfw.Q(-1);
            this.cfw.r(130);
            this.cfw.r(Token.VAR);
        }
    }

    private void visitBitOp(Node node, int i, Node node2) {
        int intProp = node.getIntProp(8, -1);
        generateExpression(node2, node);
        if (i == 20) {
            addDynamicInvoke("MATH:TOUINT32", Signatures.MATH_TO_UINT32);
            generateExpression(node2.getNext(), node);
            addDynamicInvoke("MATH:TOINT32", Signatures.MATH_TO_INT32);
            this.cfw.Q(31);
            this.cfw.r(126);
            this.cfw.r(Token.IF);
            this.cfw.r(Token.FINALLY);
            addDoubleWrap();
            return;
        }
        if (intProp == -1) {
            addObjectToNumeric();
            generateExpression(node2.getNext(), node);
            addObjectToNumeric();
            if (i == 18) {
                addScriptRuntimeInvoke("leftShift", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                return;
            }
            if (i == 19) {
                addScriptRuntimeInvoke("signedRightShift", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                return;
            }
            switch (i) {
                case 9:
                    addScriptRuntimeInvoke("bitwiseOR", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                    return;
                case 10:
                    addScriptRuntimeInvoke("bitwiseXOR", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                    return;
                case 11:
                    addScriptRuntimeInvoke("bitwiseAND", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
                    return;
                default:
                    throw Kit.codeBug(Token.typeToName(i));
            }
        }
        addScriptRuntimeInvoke("toInt32", "(D)I");
        generateExpression(node2.getNext(), node);
        addScriptRuntimeInvoke("toInt32", "(D)I");
        if (i == 18) {
            this.cfw.r(120);
        } else if (i != 19) {
            switch (i) {
                case 9:
                    this.cfw.r(128);
                    break;
                case 10:
                    this.cfw.r(130);
                    break;
                case 11:
                    this.cfw.r(126);
                    break;
                default:
                    throw Kit.codeBug(Token.typeToName(i));
            }
        } else {
            this.cfw.r(Token.FUNCTION);
        }
        this.cfw.r(Token.VAR);
    }

    private void visitDotQuery(Node node, Node node2) {
        updateLineNumber(node);
        generateExpression(node2, node);
        this.cfw.v(this.variableObjectLocal);
        addScriptRuntimeInvoke("enterDotQuery", "(Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.w(this.variableObjectLocal);
        this.cfw.r(1);
        int iQ = this.cfw.q();
        this.cfw.r0(iQ);
        this.cfw.r(87);
        generateExpression(node2.getNext(), node);
        addDynamicInvoke("MATH:TOBOOLEAN", Signatures.MATH_TO_BOOLEAN);
        this.cfw.v(this.variableObjectLocal);
        addScriptRuntimeInvoke("updateDotQuery", "(ZLorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        this.cfw.r(89);
        this.cfw.s(198, iQ);
        this.cfw.v(this.variableObjectLocal);
        addScriptRuntimeInvoke("leaveDotQuery", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.w(this.variableObjectLocal);
    }

    private void visitExponentiation(Node node, Node node2, Node node3) {
        if (node.getIntProp(8, -1) != -1) {
            generateExpression(node2, node);
            generateExpression(node2.getNext(), node);
            this.cfw.F(Token.DOTDOTDOT, "java/lang/Math", "pow", "(DD)D");
            return;
        }
        generateExpression(node2, node);
        generateExpression(node2.getNext(), node);
        short newWordLocal = getNewWordLocal();
        this.cfw.w(newWordLocal);
        addObjectToNumeric();
        this.cfw.v(newWordLocal);
        addObjectToNumeric();
        addScriptRuntimeInvoke("exponentiate", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;");
    }

    private void visitFunction(OptFunctionNode optFunctionNode, int i) {
        int index = this.codegen.getIndex(optFunctionNode.fnode);
        this.cfw.t(Token.LAST_TOKEN, this.codegen.mainClassName);
        this.cfw.r(89);
        this.cfw.v(this.variableObjectLocal);
        this.cfw.v(this.contextLocal);
        this.cfw.Q(index);
        this.cfw.F(Token.TAGGED_TEMPLATE_LITERAL, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        if (i == 4) {
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            addOptRuntimeInvoke("bindThis", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Function;");
        }
        if (optFunctionNode.fnode.isMethodDefinition()) {
            this.cfw.r(89);
            this.cfw.v(this.savedHomeObjectLocal);
            this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/BaseFunction", "setHomeObject", "(Lorg/mozilla/javascript/Scriptable;)V");
        }
        if (i == 2 || i == 4) {
            return;
        }
        this.cfw.Q(i);
        this.cfw.v(this.variableObjectLocal);
        this.cfw.v(this.contextLocal);
        addOptRuntimeInvoke("initFunction", "(Lorg/mozilla/javascript/NativeFunction;ILorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;)V");
    }

    private void visitGetProp(Node node, Node node2) {
        generateExpression(node2, node);
        if (node.getIntProp(30, 0) != 1) {
            finishGetPropGeneration(node, node2.getNext());
            return;
        }
        int iQ = this.cfw.q();
        int iQ2 = this.cfw.q();
        this.cfw.r(89);
        addOptRuntimeInvoke("isNullOrUndefined", Signatures.MATH_TO_BOOLEAN);
        this.cfw.s(Token.SETPROP_OP, iQ);
        this.cfw.r(87);
        this.cfw.u(Token.ARROW, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
        this.cfw.s(Token.LET, iQ2);
        this.cfw.r0(iQ);
        finishGetPropGeneration(node, node2.getNext());
        this.cfw.r0(iQ2);
    }

    private void visitGetVar(Node node) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        int i = this.varRegisters[varIndex];
        if (varIsDirectCallParameter(varIndex)) {
            if (node.getIntProp(8, -1) != -1) {
                dcpLoadAsNumber(i);
                return;
            } else {
                dcpLoadAsObject(i);
                return;
            }
        }
        boolean zIsNumberVar = this.fnCurrent.isNumberVar(varIndex);
        ClassFileWriter classFileWriter = this.cfw;
        if (zIsNumberVar) {
            classFileWriter.x(i);
        } else {
            classFileWriter.v(i);
        }
    }

    private void visitGoto(Jump jump, int i, Node node) {
        Node node2 = jump.target;
        if (i != 6 && i != 7) {
            if (i != 149) {
                addGoto(node2, Token.LET);
                return;
            } else if (this.isGenerator) {
                addGotoWithReturn(node2);
                return;
            } else {
                inlineFinally(node2);
                return;
            }
        }
        if (node == null) {
            throw Codegen.badTree();
        }
        int targetLabel = getTargetLabel(node2);
        int iQ = this.cfw.q();
        if (i == 6) {
            generateIfJump(node, jump, targetLabel, iQ);
        } else {
            generateIfJump(node, jump, iQ, targetLabel);
        }
        this.cfw.r0(iQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7 A[PHI: r1
      0x00e7: PHI (r1v2 java.lang.String) = (r1v1 java.lang.String), (r1v7 java.lang.String) binds: [B:33:0x00d0, B:37:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void visitIfJumpEqOp(org.mozilla.javascript.Node r17, org.mozilla.javascript.Node r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BodyCodegen.visitIfJumpEqOp(org.mozilla.javascript.Node, org.mozilla.javascript.Node, int, int):void");
    }

    private void visitIfJumpRelOp(Node node, Node node2, int i, int i2) {
        String str;
        if (i == -1 || i2 == -1) {
            throw Codegen.badTree();
        }
        int type = node.getType();
        Node next = node2.getNext();
        if (type == 58 || type == 57) {
            generateExpression(node2, node);
            generateExpression(next, node);
            this.cfw.v(this.contextLocal);
            addScriptRuntimeInvoke(type == 58 ? "instanceOf" : "in", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Z");
            this.cfw.s(Token.SETELEM_OP, i);
            this.cfw.s(Token.LET, i2);
            return;
        }
        int intProp = node.getIntProp(8, -1);
        int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
        int iNodeIsDirectCallParameter2 = nodeIsDirectCallParameter(next);
        if (intProp != -1) {
            if (intProp != 2) {
                generateExpression(node2, node);
            } else if (iNodeIsDirectCallParameter != -1) {
                dcpLoadAsNumber(iNodeIsDirectCallParameter);
            } else {
                generateExpression(node2, node);
                addObjectToDouble();
            }
            if (intProp != 1) {
                generateExpression(next, node);
            } else if (iNodeIsDirectCallParameter2 != -1) {
                dcpLoadAsNumber(iNodeIsDirectCallParameter2);
            } else {
                generateExpression(next, node);
                addObjectToDouble();
            }
            genSimpleCompare(type, i, i2);
            return;
        }
        if (iNodeIsDirectCallParameter == -1 || iNodeIsDirectCallParameter2 == -1) {
            generateExpression(node2, node);
            generateExpression(next, node);
        } else {
            int iO0 = this.cfw.o0();
            int iQ = this.cfw.q();
            this.cfw.v(iNodeIsDirectCallParameter);
            this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            this.cfw.s(Token.SET, iQ);
            this.cfw.x(iNodeIsDirectCallParameter + 1);
            dcpLoadAsNumber(iNodeIsDirectCallParameter2);
            genSimpleCompare(type, i, i2);
            if (iO0 != this.cfw.o0()) {
                throw Codegen.badTree();
            }
            this.cfw.r0(iQ);
            int iQ2 = this.cfw.q();
            this.cfw.v(iNodeIsDirectCallParameter2);
            this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            this.cfw.s(Token.SET, iQ2);
            this.cfw.v(iNodeIsDirectCallParameter);
            addObjectToDouble();
            this.cfw.x(iNodeIsDirectCallParameter2 + 1);
            genSimpleCompare(type, i, i2);
            if (iO0 != this.cfw.o0()) {
                throw Codegen.badTree();
            }
            this.cfw.r0(iQ2);
            this.cfw.v(iNodeIsDirectCallParameter);
            this.cfw.v(iNodeIsDirectCallParameter2);
        }
        switch (type) {
            case 14:
                str = "MATH:COMPARELT";
                break;
            case 15:
                str = "MATH:COMPARELE";
                break;
            case 16:
                str = "MATH:COMPAREGT";
                break;
            case 17:
                str = "MATH:COMPAREGE";
                break;
            default:
                throw Kit.codeBug();
        }
        addDynamicInvoke(str, "(Ljava/lang/Object;Ljava/lang/Object;)Z");
        this.cfw.s(Token.SETELEM_OP, i);
        this.cfw.s(Token.LET, i2);
    }

    private void visitIncDec(Node node) {
        int existingIntProp = node.getExistingIntProp(13);
        Node firstChild = node.getFirstChild();
        if (firstChild.getIntProp(31, 0) == 1) {
            visitSuperIncDec(node, firstChild, existingIntProp);
            return;
        }
        int type = firstChild.getType();
        if (type == 33) {
            Node firstChild2 = firstChild.getFirstChild();
            generateExpression(firstChild2, node);
            generateExpression(firstChild2.getNext(), node);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.Q(existingIntProp);
            addScriptRuntimeInvoke("propIncrDecr", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
            return;
        }
        if (type == 34) {
            throw Kit.codeBug();
        }
        if (type == 39) {
            Node firstChild3 = firstChild.getFirstChild();
            generateExpression(firstChild3, node);
            generateExpression(firstChild3.getNext(), node);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.Q(existingIntProp);
            if (firstChild3.getNext().getIntProp(8, -1) != -1) {
                addOptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                return;
            } else {
                addScriptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                return;
            }
        }
        if (type == 44) {
            this.cfw.v(this.variableObjectLocal);
            this.cfw.S(firstChild.getString());
            this.cfw.v(this.contextLocal);
            this.cfw.Q(existingIntProp);
            addScriptRuntimeInvoke("nameIncrDecr", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
            return;
        }
        if (type != 60) {
            if (type != 73) {
                Codegen.badTree();
                return;
            }
            generateExpression(firstChild.getFirstChild(), node);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.Q(existingIntProp);
            addScriptRuntimeInvoke("refIncrDecr", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
            return;
        }
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        boolean z = (existingIntProp & 2) != 0;
        int varIndex = this.fnCurrent.getVarIndex(firstChild);
        int i = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (node.getIntProp(8, -1) != -1) {
                this.cfw.x(i + (varIsDirectCallParameter(varIndex) ? 1 : 0));
                if (z) {
                    return;
                }
                this.cfw.P(1.0d);
                int i2 = existingIntProp & 1;
                ClassFileWriter classFileWriter = this.cfw;
                if (i2 == 0) {
                    classFileWriter.r(99);
                    return;
                } else {
                    classFileWriter.r(103);
                    return;
                }
            }
            if (varIsDirectCallParameter(varIndex)) {
                dcpLoadAsObject(i);
            } else {
                this.cfw.v(i);
            }
            if (z) {
                this.cfw.r(89);
                addObjectToDouble();
                this.cfw.r(88);
                return;
            }
            addObjectToDouble();
            this.cfw.P(1.0d);
            int i3 = existingIntProp & 1;
            ClassFileWriter classFileWriter2 = this.cfw;
            if (i3 == 0) {
                classFileWriter2.r(99);
            } else {
                classFileWriter2.r(103);
            }
            addDoubleWrap();
            return;
        }
        if (node.getIntProp(8, -1) != -1) {
            boolean zVarIsDirectCallParameter = varIsDirectCallParameter(varIndex);
            ClassFileWriter classFileWriter3 = this.cfw;
            int i4 = i + (zVarIsDirectCallParameter ? 1 : 0);
            classFileWriter3.x(i4);
            if (z) {
                this.cfw.r(92);
            }
            this.cfw.P(1.0d);
            int i5 = existingIntProp & 1;
            ClassFileWriter classFileWriter4 = this.cfw;
            if (i5 == 0) {
                classFileWriter4.r(99);
            } else {
                classFileWriter4.r(103);
            }
            if (!z) {
                this.cfw.r(92);
            }
            this.cfw.y(i4);
            return;
        }
        if (varIsDirectCallParameter(varIndex)) {
            dcpLoadAsObject(i);
        } else {
            this.cfw.v(i);
        }
        addObjectToDouble();
        if (z) {
            this.cfw.r(92);
        }
        this.cfw.P(1.0d);
        int i6 = existingIntProp & 1;
        ClassFileWriter classFileWriter5 = this.cfw;
        if (i6 == 0) {
            classFileWriter5.r(99);
        } else {
            classFileWriter5.r(103);
        }
        addDoubleWrap();
        if (!z) {
            this.cfw.r(89);
        }
        this.cfw.w(i);
        if (z) {
            addDoubleWrap();
        }
    }

    private void visitObjectLiteral(Node node, Node node2, boolean z) {
        Object[] objArr = (Object[]) node.getProp(12);
        int length = objArr == null ? 0 : objArr.length;
        if (!z && ((length > 10 || this.cfw.l0() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new ArrayList<>();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.v(this.funObjLocal);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            this.cfw.v(this.argsLocal);
            this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        this.cfw.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/Context", "newObject", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.r(89);
        short newWordLocal = getNewWordLocal();
        this.savedHomeObjectLocal = newWordLocal;
        this.cfw.w(newWordLocal);
        this.cfw.r(89);
        addLoadProperty(node, node2, objArr, length);
        Node next = node2;
        for (int i = 0; i != length; i++) {
            int type = next.getType();
            if (type == 165 || type == 166) {
                this.cfw.Q(length);
                this.cfw.s(188, 10);
                for (int i2 = 0; i2 != length; i2++) {
                    this.cfw.r(89);
                    this.cfw.Q(i2);
                    int type2 = node2.getType();
                    if (type2 == 165) {
                        this.cfw.r(2);
                    } else {
                        ClassFileWriter classFileWriter = this.cfw;
                        if (type2 == 166) {
                            classFileWriter.r(4);
                        } else {
                            classFileWriter.r(3);
                        }
                    }
                    this.cfw.r(79);
                    node2 = node2.getNext();
                }
                this.cfw.v(this.contextLocal);
                this.cfw.v(this.variableObjectLocal);
                addScriptRuntimeInvoke("fillObjectLiteral", "(Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V");
            }
            next = next.getNext();
        }
        this.cfw.r(1);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addScriptRuntimeInvoke("fillObjectLiteral", "(Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V");
    }

    private void visitOptimizedCall(Node node, OptFunctionNode optFunctionNode, int i, Node node2) {
        short newWordLocal = 0;
        if (node.getIntProp(31, 0) == 1) {
            Kit.codeBug();
        }
        Node next = node2.getNext();
        String str = this.codegen.mainClassName;
        if (i == 30) {
            generateExpression(node2, node);
        } else {
            generateFunctionAndThisObj(node2, node);
            pushThisFromLastScriptable();
            newWordLocal = getNewWordLocal();
            this.cfw.w(newWordLocal);
        }
        int iQ = this.cfw.q();
        int iQ2 = this.cfw.q();
        this.cfw.r(89);
        this.cfw.t(193, str);
        this.cfw.s(Token.SETPROP_OP, iQ2);
        this.cfw.t(192, str);
        this.cfw.r(89);
        this.cfw.u(180, str, "_id", "I");
        this.cfw.Q(this.codegen.getIndex(optFunctionNode.fnode));
        this.cfw.s(160, iQ2);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        ClassFileWriter classFileWriter = this.cfw;
        if (i == 30) {
            classFileWriter.r(1);
        } else {
            classFileWriter.v(newWordLocal);
        }
        for (Node next2 = next; next2 != null; next2 = next2.getNext()) {
            int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(next2);
            if (iNodeIsDirectCallParameter >= 0) {
                this.cfw.v(iNodeIsDirectCallParameter);
                this.cfw.x(iNodeIsDirectCallParameter + 1);
            } else if (next2.getIntProp(8, -1) == 0) {
                this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                generateExpression(next2, node);
            } else {
                generateExpression(next2, node);
                this.cfw.P(0.0d);
            }
        }
        this.cfw.u(Token.ARROW, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        ClassFileWriter classFileWriter2 = this.cfw;
        Codegen codegen = this.codegen;
        String str2 = codegen.mainClassName;
        FunctionNode functionNode = optFunctionNode.fnode;
        classFileWriter2.F(Token.DOTDOTDOT, str2, i == 30 ? codegen.getDirectCtorName(functionNode) : codegen.getBodyMethodName(functionNode), this.codegen.getBodyMethodSignature(optFunctionNode.fnode));
        this.cfw.s(Token.LET, iQ);
        this.cfw.r0(iQ2);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        if (i != 30) {
            this.cfw.v(newWordLocal);
            releaseWordLocal(newWordLocal);
        }
        generateCallArgArray(node, next, true);
        if (i == 30) {
            addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        } else {
            this.cfw.F(Token.NULLISH_COALESCING, "org/mozilla/javascript/Callable", "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
        this.cfw.r0(iQ);
    }

    private void visitSetConst(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.v(this.contextLocal);
        addDynamicInvoke("NAME:SETCONST:" + string, Signatures.NAME_SET_CONST);
    }

    private void visitSetConstVar(Node node, Node node2, boolean z) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        int i = this.varRegisters[varIndex];
        int iQ = this.cfw.q();
        int iQ2 = this.cfw.q();
        ClassFileWriter classFileWriter = this.cfw;
        if (z2) {
            int i2 = i + 2;
            classFileWriter.C(i2);
            this.cfw.s(Token.SETELEM_OP, iQ2);
            int iO0 = this.cfw.o0();
            this.cfw.Q(1);
            this.cfw.D(i2);
            this.cfw.y(i);
            ClassFileWriter classFileWriter2 = this.cfw;
            if (z) {
                classFileWriter2.x(i);
                this.cfw.s0(iQ2, iO0);
            } else {
                classFileWriter2.s(Token.LET, iQ);
                this.cfw.s0(iQ2, iO0);
                this.cfw.r(88);
            }
        } else {
            int i3 = i + 1;
            classFileWriter.C(i3);
            this.cfw.s(Token.SETELEM_OP, iQ2);
            int iO02 = this.cfw.o0();
            this.cfw.Q(1);
            this.cfw.D(i3);
            this.cfw.w(i);
            ClassFileWriter classFileWriter3 = this.cfw;
            if (z) {
                classFileWriter3.v(i);
                this.cfw.s0(iQ2, iO02);
            } else {
                classFileWriter3.s(Token.LET, iQ);
                this.cfw.s0(iQ2, iO02);
                this.cfw.r(87);
            }
        }
        this.cfw.r0(iQ);
    }

    private void visitSetElem(int i, Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 154) {
            this.cfw.r(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        boolean z = node.getIntProp(8, -1) != -1;
        boolean z2 = node.getIntProp(31, 0) == 1;
        if (i == 154) {
            if (z2) {
                this.cfw.r(90);
                this.cfw.v(this.contextLocal);
                this.cfw.v(this.variableObjectLocal);
                this.cfw.v(this.thisObjLocal);
                addDynamicInvoke("PROP:GETELEMENTSUPER", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Ljava/lang/Object;");
            } else {
                ClassFileWriter classFileWriter = this.cfw;
                if (z) {
                    classFileWriter.r(93);
                    this.cfw.v(this.contextLocal);
                    this.cfw.v(this.variableObjectLocal);
                    addDynamicInvoke("PROP:GETINDEX", Signatures.PROP_GET_INDEX);
                } else {
                    classFileWriter.r(90);
                    this.cfw.v(this.contextLocal);
                    this.cfw.v(this.variableObjectLocal);
                    addDynamicInvoke("PROP:GETELEMENT", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
                }
            }
        }
        generateExpression(next2, node);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        if (z2) {
            this.cfw.v(this.thisObjLocal);
            addDynamicInvoke("PROP:SETELEMENTSUPER", Signatures.PROP_SET_ELEMENT_SUPER);
        } else if (z) {
            addDynamicInvoke("PROP:SETINDEX", Signatures.PROP_SET_INDEX);
        } else {
            addDynamicInvoke("PROP:SETELEMENT", Signatures.PROP_SET_ELEMENT);
        }
    }

    private void visitSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addDynamicInvoke("NAME:SET:" + string, "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void visitSetProp(int i, Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 153) {
            this.cfw.r(89);
            finishGetPropGeneration(node, next);
        }
        generateExpression(next.getNext(), node);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        if (node.getIntProp(31, 0) != 1) {
            addDynamicInvoke("PROP:SET:" + next.getString(), "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
            return;
        }
        this.cfw.v(this.thisObjLocal);
        addDynamicInvoke("PROP:SETSUPER:" + next.getString(), "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Ljava/lang/Object;");
    }

    private void visitSetVar(Node node, Node node2, boolean z) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        int i = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (z) {
                return;
            }
            ClassFileWriter classFileWriter = this.cfw;
            if (z2) {
                classFileWriter.r(88);
                return;
            } else {
                classFileWriter.r(87);
                return;
            }
        }
        if (varIsDirectCallParameter(varIndex)) {
            if (!z2) {
                if (z) {
                    this.cfw.r(89);
                }
                this.cfw.w(i);
                return;
            }
            if (z) {
                this.cfw.r(92);
            }
            this.cfw.v(i);
            this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            int iQ = this.cfw.q();
            int iQ2 = this.cfw.q();
            this.cfw.s(Token.GET, iQ);
            int iO0 = this.cfw.o0();
            addDoubleWrap();
            this.cfw.w(i);
            this.cfw.s(Token.LET, iQ2);
            this.cfw.s0(iQ, iO0);
            this.cfw.y(i + 1);
            this.cfw.r0(iQ2);
            return;
        }
        boolean zIsNumberVar = this.fnCurrent.isNumberVar(varIndex);
        if (!z2) {
            if (zIsNumberVar) {
                Kit.codeBug();
            }
            this.cfw.w(i);
            if (z) {
                this.cfw.v(i);
                return;
            }
            return;
        }
        if (zIsNumberVar) {
            this.cfw.y(i);
            if (z) {
                this.cfw.x(i);
                return;
            }
            return;
        }
        if (z) {
            this.cfw.r(92);
        }
        addDoubleWrap();
        this.cfw.w(i);
    }

    private void visitSpecialCall(Node node, int i, int i2, Node node2) {
        String str;
        String str2;
        this.cfw.v(this.contextLocal);
        if (i == 30) {
            generateExpression(node2, node);
        } else {
            generateFunctionAndThisObj(node2, node);
            pushThisFromLastScriptable();
        }
        generateCallArgArray(node, node2.getNext(), false);
        if (i == 30) {
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            this.cfw.Q(i2);
            str = "newObjectSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Ljava/lang/Object;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else {
            boolean z = node.getIntProp(30, 0) == 1;
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            this.cfw.Q(i2);
            String sourceName = this.scriptOrFn.getSourceName();
            ClassFileWriter classFileWriter = this.cfw;
            if (sourceName == null) {
                sourceName = "";
            }
            classFileWriter.S(sourceName);
            this.cfw.Q(this.itsLineNumber);
            this.cfw.T(z);
            str = "callSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;ILjava/lang/String;IZ)Ljava/lang/Object;";
        }
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardCall(Node node, Node node2) {
        String str;
        if (node.getType() != 43) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        int type = node2.getType();
        boolean z = node.getIntProp(30, 0) == 1;
        int intProp = node.getIntProp(31, 0);
        String str2 = SIGNATURE_CALL2;
        String str3 = "call2";
        Integer numValueOf = null;
        if (intProp == 1) {
            int iCountArguments = countArguments(next);
            generateFunctionAndThisObj(node2, node);
            this.cfw.v(this.contextLocal);
            this.cfw.F(Token.DOTDOTDOT, "org/mozilla/javascript/ScriptRuntime", "discardLastStoredScriptable", "(Lorg/mozilla/javascript/Context;)V");
            this.cfw.v(this.thisObjLocal);
            if (iCountArguments == 0) {
                str2 = SIGNATURE_CALL0;
                str3 = "call0";
            } else if (iCountArguments == 1) {
                generateExpression(next, node);
                str2 = SIGNATURE_CALL1;
                str3 = "call1";
            } else if (iCountArguments == 2) {
                generateExpression(next, node);
                generateExpression(next.getNext(), node);
            } else {
                generateCallArgArray(node, next, false);
                str2 = SIGNATURE_CALLN;
                str3 = "callN";
            }
        } else if (next != null) {
            boolean z2 = z;
            if (type == 44) {
                String string = node2.getString();
                if (z2) {
                    this.cfw.v(this.variableObjectLocal);
                    this.cfw.v(this.contextLocal);
                    addDynamicInvoke("NAME:GETWITHTHISOPTIONAL:" + string, Signatures.NAME_GET_THIS);
                    int iQ = this.cfw.q();
                    numValueOf = Integer.valueOf(iQ);
                    int iQ2 = this.cfw.q();
                    this.cfw.r(89);
                    addOptRuntimeInvoke("isNullOrUndefined", Signatures.MATH_TO_BOOLEAN);
                    this.cfw.s(Token.SETPROP_OP, iQ2);
                    this.cfw.r(87);
                    this.cfw.u(Token.ARROW, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
                    this.cfw.s(Token.LET, iQ);
                    this.cfw.r0(iQ2);
                    pushThisFromLastScriptable();
                    generateCallArgArray(node, next, false);
                    str2 = SIGNATURE_CALLN;
                    str3 = "callN";
                } else {
                    generateCallArgArray(node, next, false);
                    this.cfw.S(string);
                    str3 = "callName";
                    str2 = "([Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                }
            } else {
                int iCountArguments2 = countArguments(next);
                generateFunctionAndThisObj(node2, node);
                if (z2) {
                    int iQ3 = this.cfw.q();
                    numValueOf = Integer.valueOf(iQ3);
                    int iQ4 = this.cfw.q();
                    str = SIGNATURE_CALL2;
                    this.cfw.r(89);
                    addOptRuntimeInvoke("isNullOrUndefined", Signatures.MATH_TO_BOOLEAN);
                    this.cfw.s(Token.SETPROP_OP, iQ4);
                    this.cfw.r(87);
                    this.cfw.u(Token.ARROW, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
                    this.cfw.s(Token.LET, iQ3);
                    this.cfw.r0(iQ4);
                    this.cfw.t(192, "org/mozilla/javascript/Callable");
                } else {
                    str = SIGNATURE_CALL2;
                }
                pushThisFromLastScriptable();
                if (iCountArguments2 == 1) {
                    generateExpression(next, node);
                    str2 = SIGNATURE_CALL1;
                    str3 = "call1";
                } else if (iCountArguments2 == 2) {
                    generateExpression(next, node);
                    generateExpression(next.getNext(), node);
                    str2 = str;
                } else {
                    generateCallArgArray(node, next, false);
                    str2 = SIGNATURE_CALLN;
                    str3 = "callN";
                }
            }
        } else if (type == 44) {
            this.cfw.S(node2.getString());
            str3 = z ? "callName0Optional" : "callName0";
            str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else if (type == 33) {
            Node firstChild = node2.getFirstChild();
            generateExpression(firstChild, node);
            this.cfw.S(firstChild.getNext().getString());
            str3 = z ? "callProp0Optional" : "callProp0";
            str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            if (type == 34) {
                throw Kit.codeBug();
            }
            generateFunctionAndThisObj(node2, node);
            pushThisFromLastScriptable();
            str3 = z ? "call0Optional" : "call0";
            str2 = SIGNATURE_CALL0;
        }
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addOptRuntimeInvoke(str3, str2);
        if (numValueOf != null) {
            this.cfw.r0(numValueOf.intValue());
        }
    }

    private void visitStandardNew(Node node, Node node2) {
        if (node.getType() != 30) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        generateExpression(node2, node);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        generateCallArgArray(node, next, false);
        addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitStrictSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        addDynamicInvoke("NAME:SETSTRICT:" + string, "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void visitSuperIncDec(Node node, Node node2, int i) {
        Node firstChild = node2.getFirstChild();
        generateExpression(firstChild, node);
        this.cfw.r(89);
        int type = node2.getType();
        if (type == 33) {
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            this.cfw.L(0);
            addDynamicInvoke("PROP:GETSUPER:" + node2.getFirstChild().getNext().getString(), Signatures.PROP_GET_SUPER);
        } else if (type != 39) {
            Codegen.badTree();
        } else {
            generateExpression(firstChild.getNext(), node);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            addDynamicInvoke("PROP:GETELEMENTSUPER", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Ljava/lang/Object;");
        }
        int i2 = i & 2;
        if (i2 != 0) {
            this.cfw.r(95);
            this.cfw.r(92);
            this.cfw.r(87);
        }
        addObjectToDouble();
        this.cfw.P(1.0d);
        int i3 = i & 1;
        ClassFileWriter classFileWriter = this.cfw;
        if (i3 == 0) {
            classFileWriter.r(99);
        } else {
            classFileWriter.r(103);
        }
        addDoubleWrap();
        int type2 = node2.getType();
        if (type2 == 33) {
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            addDynamicInvoke("PROP:SETSUPER:" + node2.getFirstChild().getNext().getString(), "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Ljava/lang/Object;");
        } else if (type2 == 39) {
            generateExpression(firstChild.getNext(), node);
            this.cfw.r(95);
            this.cfw.v(this.contextLocal);
            this.cfw.v(this.variableObjectLocal);
            this.cfw.v(this.thisObjLocal);
            addDynamicInvoke("PROP:SETELEMENTSUPER", Signatures.PROP_SET_ELEMENT_SUPER);
        }
        if (i2 != 0) {
            this.cfw.r(87);
        }
    }

    private void visitSwitch(Jump jump, Node node) {
        generateExpression(node, jump);
        short newWordLocal = getNewWordLocal();
        this.cfw.w(newWordLocal);
        for (Jump jump2 = (Jump) node.getNext(); jump2 != null; jump2 = (Jump) jump2.getNext()) {
            if (jump2.getType() != 128) {
                throw Codegen.badTree();
            }
            generateExpression(jump2.getFirstChild(), jump2);
            this.cfw.v(newWordLocal);
            addDynamicInvoke("MATH:SHALLOWEQ", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
            addGoto(jump2.target, Token.SETELEM_OP);
        }
        releaseWordLocal(newWordLocal);
    }

    private void visitTemplateLiteral(Node node) {
        int existingIntProp = node.getExistingIntProp(27);
        this.cfw.v(this.contextLocal);
        this.cfw.v(this.variableObjectLocal);
        ClassFileWriter classFileWriter = this.cfw;
        Codegen codegen = this.codegen;
        classFileWriter.u(Token.ARROW, codegen.mainClassName, codegen.getTemplateLiteralName(this.scriptOrFn), "[Ljava/lang/Object;");
        this.cfw.Q(existingIntProp);
        this.cfw.F(Token.DOTDOTDOT, "org/mozilla/javascript/ScriptRuntime", "getTemplateLiteralCallSite", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;I)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitTryCatchFinally(Jump jump, Node node) {
        int i;
        BodyCodegen bodyCodegen = this;
        short newWordLocal = bodyCodegen.getNewWordLocal();
        bodyCodegen.cfw.v(bodyCodegen.variableObjectLocal);
        bodyCodegen.cfw.w(newWordLocal);
        int iQ = bodyCodegen.cfw.q();
        bodyCodegen.cfw.s0(iQ, 0);
        Node node2 = jump.target;
        Node node3 = jump.getFinally();
        int[] iArr = new int[5];
        bodyCodegen.exceptionManager.pushExceptionInfo(jump);
        if (node2 != null) {
            iArr[0] = bodyCodegen.cfw.q();
            iArr[1] = bodyCodegen.cfw.q();
            iArr[2] = bodyCodegen.cfw.q();
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(13)) {
                iArr[3] = bodyCodegen.cfw.q();
            }
        }
        if (node3 != null) {
            iArr[4] = bodyCodegen.cfw.q();
        }
        bodyCodegen.exceptionManager.setHandlers(iArr, iQ);
        if (bodyCodegen.isGenerator && node3 != null) {
            FinallyReturnPoint finallyReturnPoint = new FinallyReturnPoint();
            if (bodyCodegen.finallys == null) {
                bodyCodegen.finallys = new HashMap();
            }
            bodyCodegen.finallys.put(node3, finallyReturnPoint);
            bodyCodegen.finallys.put(node3.getNext(), finallyReturnPoint);
        }
        for (Node next = node; next != null; next = next.getNext()) {
            if (next == node2) {
                int targetLabel = bodyCodegen.getTargetLabel(node2);
                bodyCodegen.exceptionManager.removeHandler(0, targetLabel);
                bodyCodegen.exceptionManager.removeHandler(1, targetLabel);
                bodyCodegen.exceptionManager.removeHandler(2, targetLabel);
                bodyCodegen.exceptionManager.removeHandler(3, targetLabel);
            }
            bodyCodegen.generateStatement(next);
        }
        int iQ2 = bodyCodegen.cfw.q();
        bodyCodegen.cfw.s(Token.LET, iQ2);
        int localBlockRegister = getLocalBlockRegister(jump);
        if (node2 != null) {
            int iLabelId = node2.labelId();
            i = localBlockRegister;
            bodyCodegen.generateCatchBlock(0, newWordLocal, iLabelId, i, iArr[0]);
            generateCatchBlock(1, newWordLocal, iLabelId, i, iArr[1]);
            generateCatchBlock(2, newWordLocal, iLabelId, i, iArr[2]);
            Context currentContext2 = Context.getCurrentContext();
            if (currentContext2 == null || !currentContext2.hasFeature(13)) {
                bodyCodegen = this;
            } else {
                bodyCodegen = this;
                bodyCodegen.generateCatchBlock(3, newWordLocal, iLabelId, i, iArr[3]);
            }
        } else {
            i = localBlockRegister;
        }
        if (node3 != null) {
            int iQ3 = bodyCodegen.cfw.q();
            int iQ4 = bodyCodegen.cfw.q();
            bodyCodegen.cfw.q0(iQ3);
            if (!bodyCodegen.isGenerator) {
                bodyCodegen.cfw.r0(iArr[4]);
            }
            bodyCodegen.cfw.w(i);
            bodyCodegen.cfw.v(newWordLocal);
            bodyCodegen.cfw.w(bodyCodegen.variableObjectLocal);
            int iLabelId2 = node3.labelId();
            if (bodyCodegen.isGenerator) {
                bodyCodegen.addGotoWithReturn(node3);
            } else {
                bodyCodegen.inlineFinally(node3, iArr[4], iQ4);
            }
            bodyCodegen.cfw.v(i);
            if (bodyCodegen.isGenerator) {
                bodyCodegen.cfw.t(192, "java/lang/Throwable");
            }
            bodyCodegen.cfw.r(191);
            bodyCodegen.cfw.r0(iQ4);
            if (bodyCodegen.isGenerator) {
                bodyCodegen.cfw.z(iQ, iLabelId2, iQ3, null);
            }
        }
        bodyCodegen.releaseWordLocal(newWordLocal);
        bodyCodegen.cfw.r0(iQ2);
        if (bodyCodegen.isGenerator) {
            return;
        }
        bodyCodegen.exceptionManager.popExceptionInfo();
    }

    private void visitTypeofname(Node node) {
        int indexForNameNode;
        if (!this.hasVarsInRegs || (indexForNameNode = this.fnCurrent.fnode.getIndexForNameNode(node)) < 0) {
            this.cfw.v(this.variableObjectLocal);
            this.cfw.S(node.getString());
            addScriptRuntimeInvoke("typeofName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/String;");
            return;
        }
        if (this.fnCurrent.isNumberVar(indexForNameNode)) {
            this.cfw.S("number");
            return;
        }
        if (!varIsDirectCallParameter(indexForNameNode)) {
            this.cfw.v(this.varRegisters[indexForNameNode]);
            addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
            return;
        }
        int i = this.varRegisters[indexForNameNode];
        this.cfw.v(i);
        this.cfw.u(Token.ARROW, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iQ = this.cfw.q();
        this.cfw.s(Token.GET, iQ);
        int iO0 = this.cfw.o0();
        this.cfw.v(i);
        addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
        int iQ2 = this.cfw.q();
        this.cfw.s(Token.LET, iQ2);
        this.cfw.s0(iQ, iO0);
        this.cfw.S("number");
        this.cfw.r0(iQ2);
    }

    public void generateBodyCode() {
        this.isGenerator = Codegen.isGenerator(this.scriptOrFn);
        initBodyGeneration();
        if (this.isGenerator) {
            String str = "(" + this.codegen.mainClassSignature + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;";
            this.cfw.G0(this.codegen.getBodyMethodName(this.scriptOrFn) + "_gen", str, (short) 10);
        } else {
            this.cfw.G0(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        }
        generatePrologue();
        OptFunctionNode optFunctionNode = this.fnCurrent;
        Node lastChild = this.scriptOrFn;
        if (optFunctionNode != null) {
            lastChild = lastChild.getLastChild();
        }
        generateStatement(lastChild);
        generateEpilogue();
        this.cfw.H0((short) (this.localsMax + 1));
        if (this.isGenerator) {
            generateGenerator();
        }
        if (this.literals != null) {
            for (int i = 0; i < this.literals.size(); i++) {
                Node node = this.literals.get(i);
                int type = node.getType();
                if (type == 71) {
                    generateArrayLiteralFactory(node, i + 1);
                } else if (type != 72) {
                    Kit.codeBug(Token.typeToName(type));
                } else {
                    generateObjectLiteralFactory(node, i + 1);
                }
            }
        }
    }

    private short getNewWordLocal() {
        return getNewWordIntern(1);
    }

    private void addInstructionCount() {
        addInstructionCount(Math.max(this.cfw.l0() - this.savedCodeOffset, 1));
    }

    private void inlineFinally(Node node) {
        int iQ = this.cfw.q();
        int iQ2 = this.cfw.q();
        this.cfw.r0(iQ);
        inlineFinally(node, iQ, iQ2);
        this.cfw.r0(iQ2);
    }
}
