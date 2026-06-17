package org.mozilla.javascript;

import defpackage.e04;
import defpackage.z20;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.mozilla.javascript.ES6Generator;
import org.mozilla.javascript.Interpreter;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.Debugger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Interpreter extends Icode implements Evaluator {
    private static final int EXCEPTION_COST = 100;
    static final int EXCEPTION_HANDLER_SLOT = 2;
    static final int EXCEPTION_LOCAL_SLOT = 4;
    static final int EXCEPTION_SCOPE_SLOT = 5;
    static final int EXCEPTION_SLOT_SIZE = 6;
    static final int EXCEPTION_TRY_END_SLOT = 1;
    static final int EXCEPTION_TRY_START_SLOT = 0;
    static final int EXCEPTION_TYPE_SLOT = 3;
    private static final int INVOCATION_COST = 100;
    private static final Object undefined = Undefined.instance;
    InterpreterData itsData;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ContinuationJump implements Serializable {
        private static final long serialVersionUID = 7687739156004308247L;
        CallFrame branchFrame;
        CallFrame capturedFrame;
        Object result;
        double resultDbl;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ContinuationJump(NativeContinuation nativeContinuation, CallFrame callFrame) {
            CallFrame callFrame2 = (CallFrame) nativeContinuation.getImplementation();
            this.capturedFrame = callFrame2;
            if (callFrame2 == null || callFrame == null) {
                this.branchFrame = null;
                return;
            }
            int i = callFrame2.frameIndex - callFrame.frameIndex;
            if (i != 0) {
                if (i < 0) {
                    i = -i;
                } else {
                    callFrame = callFrame2;
                    callFrame2 = callFrame;
                }
                do {
                    callFrame = callFrame.parentFrame;
                    i--;
                } while (i != 0);
                if (callFrame.frameIndex != callFrame2.frameIndex) {
                    Kit.codeBug();
                }
                callFrame = callFrame2;
                callFrame2 = callFrame;
            }
            while (!Objects.equals(callFrame2, callFrame) && callFrame2 != null) {
                callFrame2 = callFrame2.parentFrame;
                callFrame = callFrame.parentFrame;
            }
            this.branchFrame = callFrame2;
            if (callFrame2 == null || callFrame2.frozen) {
                return;
            }
            Kit.codeBug();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ContinueLoop extends NewState {
        private final CallFrame frame;
        private final int indexReg;
        private final int stackTop;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private ContinueLoop(CallFrame callFrame, int i, int i2) {
            super();
            this.frame = callFrame;
            this.stackTop = i;
            this.indexReg = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object] */
        public static /* bridge */ /* synthetic */ CallFrame a(ContinueLoop continueLoop) {
            return continueLoop.frame;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object] */
        public static /* bridge */ /* synthetic */ int b(ContinueLoop continueLoop) {
            return continueLoop.indexReg;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object] */
        public static /* bridge */ /* synthetic */ int c(ContinueLoop continueLoop) {
            return continueLoop.stackTop;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class GeneratorState {
        int operation;
        RuntimeException returnedException;
        Object value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public GeneratorState(int i, Object obj) {
            this.operation = i;
            this.value = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class NewThrowable extends NewState {
        private final Object throwable;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private NewThrowable(Object obj) {
            super();
            this.throwable = obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object] */
        public static /* bridge */ /* synthetic */ Object a(NewThrowable newThrowable) {
            return newThrowable.throwable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class StateContinue extends NewState {
        private final CallFrame frame;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private StateContinue(CallFrame callFrame) {
            super();
            this.frame = callFrame;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object] */
        public static /* bridge */ /* synthetic */ CallFrame a(StateContinue stateContinue) {
            return stateContinue.frame;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void addInstructionCount(Context context, CallFrame callFrame, int i) {
        int i2 = context.instructionCount + (callFrame.pc - callFrame.pcPrevBranch) + i;
        context.instructionCount = i2;
        if (i2 > context.instructionThreshold) {
            context.observeInstructionCount(i2);
            context.instructionCount = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int bytecodeSpan(int i) {
        if (i != -84 && i != -83 && i != -73 && i != -72 && i != -61 && i != -28 && i != 55) {
            if (i == 62) {
                return 2;
            }
            if (i != 78) {
                if (i != -26 && i != -25) {
                    if (i != 5 && i != 6 && i != 7) {
                        switch (i) {
                            case -70:
                            case -69:
                                break;
                            case -68:
                                return 2;
                            default:
                                switch (i) {
                                    case -56:
                                    case -55:
                                        break;
                                    case -54:
                                        return 5;
                                    case -53:
                                        return 3;
                                    case -52:
                                        return 2;
                                    default:
                                        switch (i) {
                                            case -47:
                                                return 5;
                                            case -46:
                                                return 3;
                                            default:
                                                switch (i) {
                                                    case -34:
                                                        break;
                                                    case -33:
                                                        return 5;
                                                    case -32:
                                                    case -31:
                                                        return 3;
                                                    default:
                                                        switch (i) {
                                                            case -11:
                                                            case -10:
                                                            case -9:
                                                            case -8:
                                                            case -7:
                                                                return 2;
                                                            case -6:
                                                                break;
                                                            default:
                                                                if (Icode.validBytecode(i)) {
                                                                    return 1;
                                                                }
                                                                throw Kit.codeBug();
                                                        }
                                                        break;
                                                }
                                            case -45:
                                                return 2;
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                } else {
                    return 5;
                }
            }
        }
        return 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeContinuation captureContinuation(Context context, CallFrame callFrame, boolean z) {
        Object[] objArr;
        NativeContinuation nativeContinuation = new NativeContinuation();
        ScriptRuntime.setObjectProtoAndParent(nativeContinuation, ScriptRuntime.getTopCallScope(context));
        CallFrame callFrame2 = callFrame;
        CallFrame callFrame3 = callFrame2;
        while (callFrame2 != null && !callFrame2.frozen) {
            callFrame2.frozen = true;
            int i = callFrame2.savedStackTop + 1;
            while (true) {
                objArr = callFrame2.stack;
                if (i == objArr.length) {
                    break;
                }
                objArr[i] = null;
                callFrame2.stackAttributes[i] = 0;
                i++;
            }
            int i2 = callFrame2.savedCallOp;
            if (i2 == 43 || i2 == -85) {
                objArr[callFrame2.savedStackTop] = null;
            } else if (i2 != 30) {
                Kit.codeBug();
            }
            callFrame3 = callFrame2;
            callFrame2 = callFrame2.parentFrame;
        }
        if (z) {
            while (true) {
                CallFrame callFrame4 = callFrame3.parentFrame;
                if (callFrame4 == null) {
                    break;
                }
                callFrame3 = callFrame4;
            }
            if (!callFrame3.isContinuationsTopFrame) {
                e04.a("Cannot capture continuation from JavaScript code not called directly by executeScriptWithContinuations or callFunctionWithContinuations");
                return null;
            }
        }
        nativeContinuation.initImplementation(callFrame);
        return nativeContinuation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static CallFrame captureFrameForGenerator(CallFrame callFrame) {
        callFrame.frozen = true;
        CallFrame callFrameCloneFrozen = callFrame.cloneFrozen();
        callFrame.frozen = false;
        callFrameCloneFrozen.parentFrame = null;
        callFrameCloneFrozen.frameIndex = 0;
        return callFrameCloneFrozen;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean compareIdata(InterpreterData interpreterData, InterpreterData interpreterData2) {
        return interpreterData == interpreterData2 || Objects.equals(getRawSource(interpreterData), getRawSource(interpreterData2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void doAdd(Object[] objArr, double[] dArr, int i, Context context) {
        boolean z;
        double d;
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            d = dArr[i2];
            if (obj2 == uniqueTag) {
                dArr[i] = dArr[i] + d;
                return;
            }
            z = true;
        } else {
            if (obj2 != uniqueTag) {
                if ((obj2 instanceof Scriptable) || (obj instanceof Scriptable)) {
                    objArr[i] = ScriptRuntime.add(obj2, obj, context);
                    return;
                }
                if (obj2 instanceof CharSequence) {
                    if (obj instanceof CharSequence) {
                        objArr[i] = new ConsString((CharSequence) obj2, (CharSequence) obj);
                        return;
                    } else {
                        objArr[i] = new ConsString((CharSequence) obj2, ScriptRuntime.toCharSequence(obj));
                        return;
                    }
                }
                if (obj instanceof CharSequence) {
                    objArr[i] = new ConsString(ScriptRuntime.toCharSequence(obj2), (CharSequence) obj);
                    return;
                }
                Number numeric = obj2 instanceof Number ? (Number) obj2 : ScriptRuntime.toNumeric(obj2);
                Number numeric2 = obj instanceof Number ? (Number) obj : ScriptRuntime.toNumeric(obj);
                boolean z2 = numeric instanceof BigInteger;
                if (z2 && (numeric2 instanceof BigInteger)) {
                    objArr[i] = ((BigInteger) numeric).add((BigInteger) numeric2);
                    return;
                } else {
                    if (z2 || (numeric2 instanceof BigInteger)) {
                        throw ScriptRuntime.typeErrorById("msg.cant.convert.to.number", "BigInt");
                    }
                    objArr[i] = uniqueTag;
                    dArr[i] = numeric.doubleValue() + numeric2.doubleValue();
                    return;
                }
            }
            obj2 = obj;
            z = false;
            d = dArr[i];
        }
        if (obj2 instanceof Scriptable) {
            Object objWrapNumber = ScriptRuntime.wrapNumber(d);
            if (!z) {
                Object obj3 = obj2;
                obj2 = objWrapNumber;
                objWrapNumber = obj3;
            }
            objArr[i] = ScriptRuntime.add(obj2, objWrapNumber, context);
            return;
        }
        if (obj2 instanceof CharSequence) {
            String strNumberToString = ScriptRuntime.numberToString(d, 10);
            if (z) {
                objArr[i] = new ConsString((CharSequence) obj2, strNumberToString);
                return;
            } else {
                objArr[i] = new ConsString(strNumberToString, (CharSequence) obj2);
                return;
            }
        }
        Number numeric3 = obj2 instanceof Number ? (Number) obj2 : ScriptRuntime.toNumeric(obj2);
        if (numeric3 instanceof BigInteger) {
            throw ScriptRuntime.typeErrorById("msg.cant.convert.to.number", "BigInt");
        }
        objArr[i] = uniqueTag;
        dArr[i] = numeric3.doubleValue() + d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doArithmetic(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        Number numberExponentiate;
        Number numberStack_numeric = stack_numeric(callFrame, i2 - 1);
        Number numberStack_numeric2 = stack_numeric(callFrame, i2);
        int i3 = i2 - 1;
        if (i != 81) {
            switch (i) {
                case 22:
                    numberExponentiate = ScriptRuntime.subtract(numberStack_numeric, numberStack_numeric2);
                    break;
                case 23:
                    numberExponentiate = ScriptRuntime.multiply(numberStack_numeric, numberStack_numeric2);
                    break;
                case 24:
                    numberExponentiate = ScriptRuntime.divide(numberStack_numeric, numberStack_numeric2);
                    break;
                case 25:
                    numberExponentiate = ScriptRuntime.remainder(numberStack_numeric, numberStack_numeric2);
                    break;
                default:
                    numberExponentiate = null;
                    break;
            }
        } else {
            numberExponentiate = ScriptRuntime.exponentiate(numberStack_numeric, numberStack_numeric2);
        }
        if (numberExponentiate instanceof BigInteger) {
            objArr[i3] = numberExponentiate;
            return i3;
        }
        objArr[i3] = UniqueTag.DOUBLE_MARK;
        dArr[i3] = numberExponentiate.doubleValue();
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doBitNOT(CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        Number numberBitwiseNOT = ScriptRuntime.bitwiseNOT(stack_numeric(callFrame, i));
        if (numberBitwiseNOT instanceof BigInteger) {
            objArr[i] = numberBitwiseNOT;
            return i;
        }
        objArr[i] = UniqueTag.DOUBLE_MARK;
        dArr[i] = numberBitwiseNOT.doubleValue();
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doBitOp(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        Number numberLeftShift;
        Number numberStack_numeric = stack_numeric(callFrame, i2 - 1);
        Number numberStack_numeric2 = stack_numeric(callFrame, i2);
        int i3 = i2 - 1;
        if (i == 18) {
            numberLeftShift = ScriptRuntime.leftShift(numberStack_numeric, numberStack_numeric2);
        } else if (i != 19) {
            switch (i) {
                case 9:
                    numberLeftShift = ScriptRuntime.bitwiseOR(numberStack_numeric, numberStack_numeric2);
                    break;
                case 10:
                    numberLeftShift = ScriptRuntime.bitwiseXOR(numberStack_numeric, numberStack_numeric2);
                    break;
                case 11:
                    numberLeftShift = ScriptRuntime.bitwiseAND(numberStack_numeric, numberStack_numeric2);
                    break;
                default:
                    numberLeftShift = null;
                    break;
            }
        } else {
            numberLeftShift = ScriptRuntime.signedRightShift(numberStack_numeric, numberStack_numeric2);
        }
        if (numberLeftShift instanceof BigInteger) {
            objArr[i3] = numberLeftShift;
            return i3;
        }
        objArr[i3] = UniqueTag.DOUBLE_MARK;
        dArr[i3] = numberLeftShift.doubleValue();
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
    
        r15 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final NewState doCallByteCode(Context context, CallFrame callFrame, boolean z, int i, int i2, int i3) {
        CallFrame callFrame2;
        double[] dArr;
        Scriptable scriptable;
        Callable callable;
        Object[] objArr;
        Scriptable scriptable2;
        CallFrame callFrame3;
        CallFrame callFrame4 = callFrame;
        Object[] objArr2 = callFrame4.stack;
        double[] dArr2 = callFrame4.sDbl;
        if (z) {
            context.instructionCount += 100;
        }
        int i4 = i2 - (i3 + 1);
        Callable callable2 = (Callable) objArr2[i4];
        Scriptable scriptable3 = (Scriptable) objArr2[i4 + 1];
        Scriptable homeObject = callable2 instanceof BaseFunction ? ((BaseFunction) callable2).getHomeObject() : null;
        if (i == -85) {
            scriptable3 = callFrame4.thisObj;
        }
        if (i == 76) {
            objArr2[i4] = ScriptRuntime.callRef(callable2, scriptable3, getArgsArray(objArr2, dArr2, i4 + 2, i3), context);
            return new ContinueLoop(callFrame4, i4, i3);
        }
        Scriptable topLevelScope = callFrame4.scope;
        if (callFrame4.useActivation) {
            topLevelScope = ScriptableObject.getTopLevelScope(topLevelScope);
        }
        int i5 = i3;
        Object[] objArrEnsureStackLength = objArr2;
        double[] dArr3 = dArr2;
        Callable target = callable2;
        while (true) {
            if (!(target instanceof ArrowFunction)) {
                if (target instanceof LambdaConstructor) {
                    break;
                }
                if (target instanceof LambdaFunction) {
                    target = ((LambdaFunction) target).getTarget();
                } else if (target instanceof BoundFunction) {
                    BoundFunction boundFunction = (BoundFunction) target;
                    Callable targetFunction = boundFunction.getTargetFunction();
                    Scriptable callThis = boundFunction.getCallThis(context, topLevelScope);
                    Object[] boundArgs = boundFunction.getBoundArgs();
                    int length = boundArgs.length;
                    if (length > 0) {
                        objArrEnsureStackLength = callFrame4.ensureStackLength(length + i4 + 2 + i5);
                        dArr3 = callFrame4.sDbl;
                        int i6 = i4 + 2;
                        int i7 = i6 + length;
                        System.arraycopy(objArrEnsureStackLength, i6, objArrEnsureStackLength, i7, i5);
                        System.arraycopy(dArr3, i6, dArr3, i7, i5);
                        System.arraycopy(boundArgs, 0, objArrEnsureStackLength, i6, length);
                        i5 += length;
                    }
                    target = targetFunction;
                    scriptable3 = callThis;
                } else {
                    if (target instanceof IdFunctionObject) {
                        IdFunctionObject idFunctionObject = (IdFunctionObject) target;
                        if (!BaseFunction.isApplyOrCall(idFunctionObject)) {
                            break;
                        }
                        Callable callable3 = ScriptRuntime.getCallable(scriptable3);
                        int i8 = i4 + 2;
                        Scriptable applyThis = getApplyThis(context, objArrEnsureStackLength, dArr3, i8, i5, callable3, callFrame4);
                        callFrame2 = callFrame4;
                        if (BaseFunction.isApply(idFunctionObject)) {
                            Object[] applyArguments = i5 < 2 ? ScriptRuntime.emptyArgs : ScriptRuntime.getApplyArguments(context, objArrEnsureStackLength[i4 + 3]);
                            int length2 = applyArguments.length;
                            Object[] objArrEnsureStackLength2 = callFrame2.ensureStackLength(length2 + i4 + 2);
                            double[] dArr4 = callFrame2.sDbl;
                            System.arraycopy(applyArguments, 0, objArrEnsureStackLength2, i8, length2);
                            objArrEnsureStackLength = objArrEnsureStackLength2;
                            i5 = length2;
                            dArr3 = dArr4;
                        } else if (i5 > 0) {
                            if (i5 > 1) {
                                int i9 = i4 + 3;
                                int i10 = i5 - 1;
                                System.arraycopy(objArrEnsureStackLength, i9, objArrEnsureStackLength, i8, i10);
                                System.arraycopy(dArr3, i9, dArr3, i8, i10);
                            }
                            i5--;
                        }
                        target = callable3;
                        scriptable3 = applyThis;
                    } else {
                        callFrame2 = callFrame4;
                        if (target instanceof ScriptRuntime.NoSuchMethodShim) {
                            ScriptRuntime.NoSuchMethodShim noSuchMethodShim = (ScriptRuntime.NoSuchMethodShim) target;
                            objArrEnsureStackLength = callFrame2.ensureStackLength(i4 + 4);
                            dArr3 = callFrame2.sDbl;
                            int i11 = i4 + 2;
                            Object[] argsArray = getArgsArray(objArrEnsureStackLength, dArr3, i11, i5);
                            Callable callable4 = noSuchMethodShim.noSuchMethodMethod;
                            objArrEnsureStackLength[i11] = noSuchMethodShim.methodName;
                            objArrEnsureStackLength[i4 + 3] = context.newArray(topLevelScope, argsArray);
                            target = callable4;
                            i5 = 2;
                        } else if (target == null) {
                            throw ScriptRuntime.notFunctionError(null, null);
                        }
                    }
                    callFrame4 = callFrame2;
                }
            } else {
                ArrowFunction arrowFunction = (ArrowFunction) target;
                Callable targetFunction2 = arrowFunction.getTargetFunction();
                Scriptable callThis2 = arrowFunction.getCallThis(context);
                homeObject = arrowFunction.getBoundHomeObject();
                target = targetFunction2;
                scriptable3 = callThis2;
            }
        }
        if (target instanceof InterpretedFunction) {
            callable = target;
            Scriptable scriptable4 = homeObject;
            int i12 = i5;
            Object[] objArr3 = objArrEnsureStackLength;
            scriptable2 = topLevelScope;
            InterpretedFunction interpretedFunction = (InterpretedFunction) callable;
            if (callFrame2.fnOrScript.securityDomain == interpretedFunction.securityDomain) {
                if (i == -62) {
                    CallFrame callFrame5 = callFrame2.parentFrame;
                    exitFrame(context, callFrame2, null);
                    callFrame3 = callFrame5;
                } else {
                    callFrame3 = callFrame2;
                }
                CallFrame callFrameInitFrame = initFrame(context, scriptable2, scriptable3, scriptable4, objArr3, dArr3, i4 + 2, i12, interpretedFunction, callFrame3);
                if (i != -62) {
                    callFrame2.savedStackTop = i4;
                    callFrame2.savedCallOp = i;
                }
                return new StateContinue(callFrameInitFrame);
            }
            Scriptable scriptable5 = scriptable3;
            dArr = dArr3;
            scriptable = scriptable5;
            objArr = objArr3;
            i5 = i12;
        } else {
            Scriptable scriptable6 = scriptable3;
            dArr = dArr3;
            scriptable = scriptable6;
            callable = target;
            objArr = objArrEnsureStackLength;
            scriptable2 = topLevelScope;
        }
        if (callable instanceof NativeContinuation) {
            ContinuationJump continuationJump = new ContinuationJump((NativeContinuation) callable, callFrame2);
            if (i5 == 0) {
                continuationJump.result = undefined;
            } else {
                int i13 = i4 + 2;
                continuationJump.result = objArr[i13];
                continuationJump.resultDbl = dArr[i13];
            }
            return new NewThrowable(continuationJump);
        }
        if ((callable instanceof IdFunctionObject) && NativeContinuation.isContinuationConstructor((IdFunctionObject) callable)) {
            callFrame2.stack[i4] = captureContinuation(context, callFrame2.parentFrame, false);
            return new ContinueLoop(callFrame2, i4, i5);
        }
        context.lastInterpreterFrame = callFrame2;
        callFrame2.savedCallOp = i;
        callFrame2.savedStackTop = i4;
        objArr[i4] = callable.call(context, scriptable2, scriptable, getArgsArray(objArr, dArr, i4 + 2, i5));
        return new ContinueLoop(callFrame2, i4, i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doCallSpecial(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, byte[] bArr, int i2, boolean z) {
        int i3;
        int i4 = callFrame.pc;
        int i5 = bArr[i4] & 255;
        boolean z2 = bArr[i4 + 1] != 0;
        int index = getIndex(bArr, i4 + 2);
        if (z2) {
            i3 = i - i2;
            Object objWrapNumber = objArr[i3];
            if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
                objWrapNumber = ScriptRuntime.wrapNumber(dArr[i3]);
            }
            objArr[i3] = ScriptRuntime.newSpecial(context, objWrapNumber, getArgsArray(objArr, dArr, i3 + 1, i2), callFrame.scope, i5);
        } else {
            i3 = i - (i2 + 1);
            objArr[i3] = ScriptRuntime.callSpecial(context, (Callable) objArr[i3], (Scriptable) objArr[i3 + 1], getArgsArray(objArr, dArr, i3 + 2, i2), callFrame.scope, callFrame.thisObj, i5, callFrame.idata.itsSourceFile, index, z);
        }
        callFrame.pc += 4;
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doCompare(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        boolean zCompare;
        Number numberValueOf;
        Number numberStack_numeric;
        int i3 = i2 - 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i3];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            numberValueOf = Double.valueOf(dArr[i2]);
            numberStack_numeric = stack_numeric(callFrame, i3);
        } else {
            if (obj2 != uniqueTag) {
                zCompare = ScriptRuntime.compare(obj2, obj, i);
                objArr[i3] = ScriptRuntime.wrapBoolean(zCompare);
                return i3;
            }
            Number numeric = ScriptRuntime.toNumeric(obj);
            Double dValueOf = Double.valueOf(dArr[i3]);
            numberValueOf = numeric;
            numberStack_numeric = dValueOf;
        }
        zCompare = ScriptRuntime.compare(numberStack_numeric, numberValueOf, i);
        objArr[i3] = ScriptRuntime.wrapBoolean(zCompare);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doDelName(Context context, CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        Object objWrapNumber = objArr[i2];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 - 1;
        Object objWrapNumber2 = objArr[i3];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.delete(objWrapNumber2, objWrapNumber, context, callFrame.scope, i == 0);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doElemIncDec(Context context, CallFrame callFrame, byte[] bArr, Object[] objArr, double[] dArr, int i) {
        Object objWrapNumber = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i2 = i - 1;
        Object objWrapNumber2 = objArr[i2];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        objArr[i2] = ScriptRuntime.elemIncrDecr(objWrapNumber2, objWrapNumber, context, callFrame.scope, bArr[callFrame.pc]);
        callFrame.pc++;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean doEquals(Object[] objArr, double[] dArr, int i) {
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        return obj == uniqueTag ? obj2 == uniqueTag ? dArr[i] == dArr[i2] : ScriptRuntime.eqNumber(dArr[i2], obj2) : obj2 == uniqueTag ? ScriptRuntime.eqNumber(dArr[i], obj) : ScriptRuntime.eq(obj2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doGetElem(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        int i2 = i - 1;
        Object objWrapNumber = objArr[i2];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        Object obj = objArr[i];
        objArr[i2] = obj != uniqueTag ? ScriptRuntime.getObjectElem(objWrapNumber, obj, context, callFrame.scope) : ScriptRuntime.getObjectIndex(objWrapNumber, dArr[i], context, callFrame.scope);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doGetElemSuper(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        int i2 = i - 1;
        Object obj = objArr[i2];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            Kit.codeBug();
        }
        Object obj2 = objArr[i];
        objArr[i2] = obj2 != uniqueTag ? ScriptRuntime.getSuperElem(obj, obj2, context, callFrame.scope, callFrame.thisObj) : ScriptRuntime.getSuperIndex(obj, dArr[i], context, callFrame.scope, callFrame.thisObj);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doGetVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int i2) {
        int i3 = i + 1;
        if (!callFrame.useActivation) {
            objArr[i3] = objArr2[i2];
            dArr[i3] = dArr2[i2];
            return i3;
        }
        String str = callFrame.idata.argNames[i2];
        Scriptable scriptable = callFrame.scope;
        objArr[i3] = scriptable.get(str, scriptable);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doInOrInstanceof(Context context, int i, Object[] objArr, double[] dArr, int i2) {
        Object objWrapNumber = objArr[i2];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 - 1;
        Object objWrapNumber2 = objArr[i3];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.wrapBoolean(i == 57 ? ScriptRuntime.in(objWrapNumber2, objWrapNumber, context) : ScriptRuntime.instanceOf(objWrapNumber2, objWrapNumber, context));
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doRefMember(Context context, Object[] objArr, double[] dArr, int i, int i2) {
        Object objWrapNumber = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object objWrapNumber2 = objArr[i3];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.memberRef(objWrapNumber2, objWrapNumber, context, i2);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doRefNsMember(Context context, Object[] objArr, double[] dArr, int i, int i2) {
        Object objWrapNumber = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object objWrapNumber2 = objArr[i3];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        int i4 = i - 2;
        Object objWrapNumber3 = objArr[i4];
        if (objWrapNumber3 == uniqueTag) {
            objWrapNumber3 = ScriptRuntime.wrapNumber(dArr[i4]);
        }
        objArr[i4] = ScriptRuntime.memberRef(objWrapNumber3, objWrapNumber2, objWrapNumber, context, i2);
        return i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doRefNsName(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, int i2) {
        Object objWrapNumber = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object objWrapNumber2 = objArr[i3];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.nameRef(objWrapNumber2, objWrapNumber, context, callFrame.scope, i2);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doSetConstVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        if (!callFrame.useActivation) {
            int i3 = iArr[i2];
            if ((i3 & 1) == 0) {
                throw Context.reportRuntimeErrorById("msg.var.redecl", callFrame.idata.argNames[i2]);
            }
            if ((i3 & 8) != 0) {
                objArr2[i2] = objArr[i];
                iArr[i2] = i3 & (-9);
                dArr2[i2] = dArr[i];
            }
            return i;
        }
        Object objWrapNumber = objArr[i];
        if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        String str = callFrame.idata.argNames[i2];
        Scriptable scriptable = callFrame.scope;
        if (!(scriptable instanceof ConstProperties)) {
            throw Kit.codeBug();
        }
        ((ConstProperties) scriptable).putConst(str, scriptable, objWrapNumber);
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doSetElem(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        int i2 = i - 2;
        Object objWrapNumber = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        Object obj = objWrapNumber;
        Object objWrapNumber2 = objArr[i2];
        if (objWrapNumber2 == uniqueTag) {
            objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        Object obj2 = objWrapNumber2;
        int i3 = i - 1;
        Object obj3 = objArr[i3];
        objArr[i2] = obj3 != uniqueTag ? ScriptRuntime.setObjectElem(obj2, obj3, obj, context, callFrame.scope) : ScriptRuntime.setObjectIndex(obj2, dArr[i3], obj, context, callFrame.scope);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doSetElemSuper(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        int i2 = i - 2;
        Object objWrapNumber = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (objWrapNumber == uniqueTag) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        Object obj = objWrapNumber;
        Object obj2 = objArr[i2];
        if (obj2 == uniqueTag) {
            Kit.codeBug();
        }
        int i3 = i - 1;
        Object obj3 = objArr[i3];
        objArr[i2] = obj3 != uniqueTag ? ScriptRuntime.setSuperElem(obj2, obj3, obj, context, callFrame.scope, callFrame.thisObj) : ScriptRuntime.setSuperIndex(obj2, dArr[i3], obj, context, callFrame.scope, callFrame.thisObj);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doSetVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        if (!callFrame.useActivation) {
            if ((iArr[i2] & 1) == 0) {
                objArr2[i2] = objArr[i];
                dArr2[i2] = dArr[i];
            }
            return i;
        }
        Object objWrapNumber = objArr[i];
        if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
            objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
        }
        String str = callFrame.idata.argNames[i2];
        Scriptable scriptable = callFrame.scope;
        scriptable.put(str, scriptable, objWrapNumber);
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean doShallowEquals(Object[] objArr, double[] dArr, int i) {
        double dDoubleValue;
        double dDoubleValue2;
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj != uniqueTag) {
            if (obj2 != uniqueTag) {
                return ScriptRuntime.shallowEq(obj2, obj);
            }
            dDoubleValue = dArr[i];
            if ((obj instanceof Number) && !(obj instanceof BigInteger)) {
                dDoubleValue2 = ((Number) obj).doubleValue();
            }
        }
        dDoubleValue2 = dArr[i2];
        if (obj2 == uniqueTag) {
            dDoubleValue = dArr[i];
        } else {
            if (!(obj2 instanceof Number) || (obj2 instanceof BigInteger)) {
                return false;
            }
            dDoubleValue = ((Number) obj2).doubleValue();
        }
        return dDoubleValue == dDoubleValue2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int doVarIncDec(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        double dDoubleValue;
        boolean z;
        int i3 = i + 1;
        InterpreterData interpreterData = callFrame.idata;
        byte b = interpreterData.itsICode[callFrame.pc];
        if (callFrame.useActivation) {
            objArr[i3] = ScriptRuntime.nameIncrDecr(callFrame.scope, interpreterData.argNames[i2], context, b);
        } else {
            Object obj = objArr2[i2];
            UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
            BigInteger bigInteger = null;
            if (obj == uniqueTag) {
                dDoubleValue = dArr2[i2];
            } else {
                Number numeric = ScriptRuntime.toNumeric(obj);
                if (numeric instanceof BigInteger) {
                    bigInteger = (BigInteger) numeric;
                    dDoubleValue = 0.0d;
                } else {
                    dDoubleValue = numeric.doubleValue();
                }
            }
            if (bigInteger == null) {
                double d = (b & 1) == 0 ? 1.0d + dDoubleValue : dDoubleValue - 1.0d;
                z = (b & 2) != 0;
                if ((iArr[i2] & 1) == 0) {
                    if (obj != uniqueTag) {
                        objArr2[i2] = uniqueTag;
                    }
                    dArr2[i2] = d;
                    objArr[i3] = uniqueTag;
                    if (!z) {
                        dDoubleValue = d;
                    }
                    dArr[i3] = dDoubleValue;
                } else if (!z || obj == uniqueTag) {
                    objArr[i3] = uniqueTag;
                    if (!z) {
                        dDoubleValue = d;
                    }
                    dArr[i3] = dDoubleValue;
                } else {
                    objArr[i3] = obj;
                }
            } else {
                BigInteger bigIntegerAdd = (b & 1) == 0 ? bigInteger.add(BigInteger.ONE) : bigInteger.subtract(BigInteger.ONE);
                z = (b & 2) != 0;
                if ((iArr[i2] & 1) == 0) {
                    objArr2[i2] = bigIntegerAdd;
                    if (!z) {
                        bigInteger = bigIntegerAdd;
                    }
                    objArr[i3] = bigInteger;
                } else if (!z || obj == uniqueTag) {
                    if (!z) {
                        bigInteger = bigIntegerAdd;
                    }
                    objArr[i3] = bigInteger;
                } else {
                    objArr[i3] = obj;
                }
            }
        }
        callFrame.pc++;
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void dumpICode(InterpreterData interpreterData) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void enterFrame(Context context, CallFrame callFrame, Object[] objArr, boolean z) {
        CallFrame callFrame2;
        boolean z2 = callFrame.idata.itsNeedsActivation;
        boolean z3 = callFrame.debuggerFrame != null;
        if (z2 || z3) {
            Scriptable parentScope = callFrame.scope;
            if (parentScope == null) {
                Kit.codeBug();
            } else if (z) {
                while (parentScope instanceof NativeWith) {
                    parentScope = parentScope.getParentScope();
                    if (parentScope == null || ((callFrame2 = callFrame.parentFrame) != null && callFrame2.scope == parentScope)) {
                        Kit.codeBug();
                        break;
                    }
                }
            }
            if (z3) {
                callFrame.debuggerFrame.onEnter(context, parentScope, callFrame.thisObj, objArr);
            }
            if (z2) {
                ScriptRuntime.enterActivationFunction(context, parentScope);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void exitFrame(Context context, CallFrame callFrame, Object obj) {
        if (callFrame.idata.itsNeedsActivation) {
            ScriptRuntime.exitActivationFunction(context);
        }
        DebugFrame debugFrame = callFrame.debuggerFrame;
        if (debugFrame != null) {
            try {
                if (obj instanceof Throwable) {
                    debugFrame.onExit(context, true, obj);
                    return;
                }
                ContinuationJump continuationJump = (ContinuationJump) obj;
                Object objWrapNumber = continuationJump == null ? callFrame.result : continuationJump.result;
                if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
                    objWrapNumber = ScriptRuntime.wrapNumber(continuationJump == null ? callFrame.resultDbl : continuationJump.resultDbl);
                }
                callFrame.debuggerFrame.onExit(context, false, objWrapNumber);
            } catch (Throwable th) {
                System.err.println("RHINO USAGE WARNING: onExit terminated with exception");
                th.printStackTrace(System.err);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object freezeGenerator(Context context, CallFrame callFrame, int i, GeneratorState generatorState, boolean z) {
        if (generatorState.operation == 2) {
            throw ScriptRuntime.typeErrorById("msg.yield.closing", new Object[0]);
        }
        callFrame.frozen = true;
        callFrame.result = callFrame.stack[i];
        callFrame.resultDbl = callFrame.sDbl[i];
        callFrame.savedStackTop = i;
        callFrame.pc--;
        ScriptRuntime.exitActivationFunction(context);
        Object objWrapNumber = callFrame.result;
        if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
            objWrapNumber = ScriptRuntime.wrapNumber(callFrame.resultDbl);
        }
        return z ? new ES6Generator.YieldStarResult(objWrapNumber) : objWrapNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Scriptable getApplyThis(Context context, Object[] objArr, double[] dArr, int i, int i2, Callable callable, CallFrame callFrame) {
        Object objWrapNumber = null;
        Scriptable objectOrNull = null;
        if (!(callable instanceof InterpretedFunction)) {
            if (i2 != 0 && (objWrapNumber = objArr[i]) == UniqueTag.DOUBLE_MARK) {
                objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
            }
            return ScriptRuntime.getApplyOrCallThis(context, callFrame.scope, objWrapNumber, i2);
        }
        if (i2 != 0) {
            Object objWrapNumber2 = objArr[i];
            if (objWrapNumber2 == UniqueTag.DOUBLE_MARK) {
                objWrapNumber2 = ScriptRuntime.wrapNumber(dArr[i]);
            }
            objectOrNull = ScriptRuntime.toObjectOrNull(context, objWrapNumber2, callFrame.scope);
        }
        return objectOrNull == null ? ScriptRuntime.getTopCallScope(context) : objectOrNull;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] getArgsArray(Object[] objArr, double[] dArr, int i, int i2) {
        if (i2 == 0) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] objArr2 = new Object[i2];
        int i3 = 0;
        while (i3 != i2) {
            Object objWrapNumber = objArr[i];
            if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
                objWrapNumber = ScriptRuntime.wrapNumber(dArr[i]);
            }
            objArr2[i3] = objWrapNumber;
            i3++;
            i++;
        }
        return objArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Scriptable getCurrentFrameHomeObject(CallFrame callFrame) {
        Scriptable scriptable = callFrame.scope;
        if (scriptable instanceof NativeCall) {
            return ((NativeCall) scriptable).getHomeObject();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getExceptionHandler(CallFrame callFrame, boolean z) {
        int[] iArr = callFrame.idata.itsExceptionTable;
        int i = -1;
        if (iArr == null) {
            return -1;
        }
        int i2 = callFrame.pc - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 != iArr.length; i5 += 6) {
            int i6 = iArr[i5];
            int i7 = iArr[i5 + 1];
            if (i6 <= i2 && i2 < i7 && (!z || iArr[i5 + 3] == 1)) {
                if (i < 0) {
                    i = i5;
                    i4 = i6;
                    i3 = i7;
                } else if (i3 >= i7) {
                    if (i4 > i6) {
                        Kit.codeBug();
                    }
                    if (i3 == i7) {
                        Kit.codeBug();
                    }
                    i = i5;
                    i4 = i6;
                    i3 = i7;
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] getLineNumbers(InterpreterData interpreterData) {
        HashSet hashSet = new HashSet();
        byte[] bArr = interpreterData.itsICode;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 != length) {
            byte b = bArr[i2];
            int iBytecodeSpan = bytecodeSpan(b);
            if (b == -31) {
                if (iBytecodeSpan != 3) {
                    Kit.codeBug();
                }
                hashSet.add(Integer.valueOf(getIndex(bArr, i2 + 1)));
            }
            i2 += iBytecodeSpan;
        }
        int[] iArr = new int[hashSet.size()];
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getRawSource(InterpreterData interpreterData) {
        String str = interpreterData.rawSource;
        if (str == null) {
            return null;
        }
        return str.substring(interpreterData.rawSourceStart, interpreterData.rawSourceEnd);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int getShort(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | (bArr[i] << 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static CallFrame initFrame(Context context, Scriptable scriptable, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr, double[] dArr, int i, int i2, InterpretedFunction interpretedFunction, CallFrame callFrame) {
        CallFrame callFrame2 = new CallFrame(context, scriptable2, interpretedFunction, callFrame);
        callFrame2.initializeArgs(context, scriptable, objArr, dArr, i, i2, scriptable3);
        enterFrame(context, callFrame2, objArr, false);
        return callFrame2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static void initFunction(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, int i) {
        InterpretedFunction interpretedFunctionCreateFunction = InterpretedFunction.createFunction(context, scriptable, interpretedFunction, i);
        ScriptRuntime.initFunction(context, scriptable, interpretedFunctionCreateFunction, interpretedFunctionCreateFunction.idata.itsFunctionType, interpretedFunction.idata.evalScriptFlag);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object interpret(InterpretedFunction interpretedFunction, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!ScriptRuntime.hasTopCall(context)) {
            Kit.codeBug();
        }
        Object obj = context.interpreterSecurityDomain;
        Object obj2 = interpretedFunction.securityDomain;
        if (obj != obj2) {
            context.interpreterSecurityDomain = obj2;
            try {
                return interpretedFunction.securityController.callWithDomain(obj2, context, interpretedFunction, scriptable, scriptable2, objArr);
            } finally {
                context.interpreterSecurityDomain = obj;
            }
        }
        CallFrame callFrameInitFrame = initFrame(context, scriptable, scriptable2, interpretedFunction.getHomeObject(), objArr, null, 0, objArr.length, interpretedFunction, null);
        callFrameInitFrame.isContinuationsTopFrame = context.isContinuationsTopCall;
        context.isContinuationsTopCall = false;
        return interpretLoop(context, callFrameInitFrame, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type update failed for variable: r39v0 ??, new type: org.mozilla.javascript.Context
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 68061. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
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
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
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
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
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
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:72)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static java.lang.Object interpretLoop(org.mozilla.javascript.Context r39, org.mozilla.javascript.Interpreter.CallFrame r40, java.lang.Object r41) {
        /*
            r1 = r39
            r0 = r41
            org.mozilla.javascript.UniqueTag r11 = org.mozilla.javascript.UniqueTag.DOUBLE_MARK
            int r2 = r1.instructionThreshold
            r13 = 1
            if (r2 == 0) goto Ld
            r14 = r13
            goto Le
        Ld:
            r14 = 0
        Le:
            java.lang.Object r2 = r1.lastInterpreterFrame
            if (r2 == 0) goto L24
            java.util.Deque<java.lang.Object> r2 = r1.previousInterpreterInvocations
            if (r2 != 0) goto L1d
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            r1.previousInterpreterInvocations = r2
        L1d:
            java.util.Deque<java.lang.Object> r2 = r1.previousInterpreterInvocations
            java.lang.Object r3 = r1.lastInterpreterFrame
            r2.push(r3)
        L24:
            r15 = 0
            if (r0 == 0) goto L41
            boolean r2 = r0 instanceof org.mozilla.javascript.Interpreter.GeneratorState
            if (r2 == 0) goto L37
            org.mozilla.javascript.Interpreter$GeneratorState r0 = (org.mozilla.javascript.Interpreter.GeneratorState) r0
            java.lang.Object[] r2 = org.mozilla.javascript.ScriptRuntime.emptyArgs
            r3 = r40
            enterFrame(r1, r3, r2, r13)
            r7 = r0
            r0 = r15
            goto L44
        L37:
            r3 = r40
            boolean r2 = r0 instanceof org.mozilla.javascript.Interpreter.ContinuationJump
            if (r2 != 0) goto L43
            org.mozilla.javascript.Kit.codeBug()
            goto L43
        L41:
            r3 = r40
        L43:
            r7 = r15
        L44:
            r16 = 0
            r18 = -1
            r2 = r0
            r4 = r15
            r5 = r4
            r19 = r5
            r20 = r16
            r0 = r18
        L51:
            if (r2 == 0) goto L6a
            org.mozilla.javascript.Interpreter$CallFrame r3 = processThrowable(r1, r2, r3, r0, r14)     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r2 = r3.throwable     // Catch: java.lang.Throwable -> L5e
            r3.throwable = r15     // Catch: java.lang.Throwable -> L5e
        L5b:
            r22 = r2
            goto L74
        L5e:
            r0 = move-exception
            r15 = r7
            r32 = r13
            r36 = r14
            r41 = 100
        L66:
            r33 = 0
            goto L1828
        L6a:
            if (r7 != 0) goto L5b
            boolean r6 = r3.frozen     // Catch: java.lang.Throwable -> L5e
            if (r6 == 0) goto L5b
            org.mozilla.javascript.Kit.codeBug()     // Catch: java.lang.Throwable -> L5e
            goto L5b
        L74:
            java.lang.Object[] r2 = r3.stack     // Catch: java.lang.Throwable -> L181f
            double[] r6 = r3.sDbl     // Catch: java.lang.Throwable -> L181f
            org.mozilla.javascript.Interpreter$CallFrame r8 = r3.varSource     // Catch: java.lang.Throwable -> L181f
            r41 = 100
            java.lang.Object[] r9 = r8.stack     // Catch: java.lang.Throwable -> L1818
            r23 = r7
            double[] r7 = r8.sDbl     // Catch: java.lang.Throwable -> L1814
            int[] r8 = r8.stackAttributes     // Catch: java.lang.Throwable -> L1814
            org.mozilla.javascript.InterpreterData r10 = r3.idata     // Catch: java.lang.Throwable -> L1814
            r31 = r15
            byte[] r15 = r10.itsICode     // Catch: java.lang.Throwable -> L1814
            r32 = r13
            java.lang.String[] r13 = r10.itsStringTable     // Catch: java.lang.Throwable -> L180b
            java.math.BigInteger[] r10 = r10.itsBigIntTable     // Catch: java.lang.Throwable -> L180b
            int r12 = r3.savedStackTop     // Catch: java.lang.Throwable -> L180b
            r1.lastInterpreterFrame = r3     // Catch: java.lang.Throwable -> L180b
            r34 = r3
            r3 = r2
            r2 = r34
            r34 = r5
            r5 = r12
            r12 = r4
            r4 = r6
            r6 = r0
        L9f:
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L1802
            int r1 = r0 + 1
            r2.pc = r1     // Catch: java.lang.Throwable -> L17f7
            r35 = r13
            r13 = r15[r0]     // Catch: java.lang.Throwable -> L17f7
            r25 = r3
            r3 = 170(0xaa, float:2.38E-43)
            if (r13 == r3) goto L17ca
            r26 = 3
            r3 = 4
            switch(r13) {
                case -86: goto L17ab;
                case -85: goto L1710;
                case -84: goto L16e4;
                case -83: goto L16b5;
                case -82: goto L1685;
                case -81: goto L165f;
                case -80: goto L163c;
                case -79: goto L1618;
                case -78: goto L15f7;
                case -77: goto L15de;
                case -76: goto L15c5;
                case -75: goto L1593;
                case -74: goto L156e;
                case -73: goto L1523;
                case -72: goto L149d;
                case -71: goto L1480;
                case -70: goto L145b;
                case -69: goto L140a;
                case -68: goto L13e6;
                default: goto Lb5;
            }
        Lb5:
            switch(r13) {
                case -66: goto L13ba;
                case -65: goto L138b;
                case -64: goto L135a;
                case -63: goto L133f;
                case -62: goto L1328;
                case -61: goto L12f1;
                case -60: goto L12c8;
                case -59: goto L12ab;
                case -58: goto L128c;
                case -57: goto L1264;
                case -56: goto L122d;
                case -55: goto L11f8;
                case -54: goto L11da;
                case -53: goto L11bb;
                case -52: goto L119e;
                case -51: goto L1189;
                case -50: goto L1174;
                case -49: goto L115f;
                case -48: goto L1148;
                case -47: goto L112d;
                case -46: goto L1111;
                case -45: goto L10f4;
                case -44: goto L10e0;
                case -43: goto L10d4;
                case -42: goto L10c4;
                case -41: goto L10b4;
                case -40: goto L10a4;
                case -39: goto L1093;
                case -38: goto L105e;
                case -37: goto L103e;
                case -36: goto L1011;
                case -35: goto Lff0;
                case -34: goto Lfa3;
                case -33: goto Lf81;
                case -32: goto Lf50;
                case -31: goto Lf24;
                case -30: goto Leda;
                case -29: goto Lea8;
                case -28: goto Le84;
                case -27: goto Le74;
                case -26: goto Le4a;
                case -25: goto Le0f;
                case -24: goto Ldea;
                case -23: goto Ld92;
                case -22: goto Ld67;
                case -21: goto Ld30;
                case -20: goto Ld03;
                case -19: goto Lcde;
                case -18: goto Lcb3;
                case -17: goto Lc7c;
                case -16: goto Lc4f;
                case -15: goto Lc2a;
                case -14: goto Lc0d;
                case -13: goto Lbf4;
                case -12: goto Lbcb;
                case -11: goto Lb96;
                case -10: goto Lb61;
                case -9: goto Lb30;
                case -8: goto Lb0a;
                case -7: goto Lad9;
                case -6: goto Laa8;
                case -5: goto La91;
                case -4: goto La7d;
                case -3: goto La4f;
                case -2: goto La2c;
                case -1: goto La15;
                case 0: goto L9e0;
                default: goto Lb8;
            }
        Lb8:
            switch(r13) {
                case 2: goto L9b9;
                case 3: goto L99a;
                case 4: goto L97a;
                case 5: goto L957;
                case 6: goto L937;
                case 7: goto L8fc;
                case 8: goto L8b3;
                case 9: goto L898;
                case 10: goto L898;
                case 11: goto L898;
                case 12: goto L86e;
                case 13: goto L86e;
                case 14: goto L853;
                case 15: goto L853;
                case 16: goto L853;
                case 17: goto L853;
                case 18: goto L898;
                case 19: goto L898;
                case 20: goto L815;
                case 21: goto L7fa;
                case 22: goto L7e0;
                case 23: goto L7e0;
                case 24: goto L7e0;
                case 25: goto L7e0;
                case 26: goto L7be;
                case 27: goto L7a2;
                case 28: goto L784;
                case 29: goto L73d;
                case 30: goto L65e;
                case 31: goto L648;
                case 32: goto L62b;
                case 33: goto L60c;
                case 34: goto L5ed;
                case 35: goto L5af;
                case 36: goto L5af;
                case 37: goto L580;
                case 38: goto L53c;
                case 39: goto L52d;
                case 40: goto L51e;
                case 41: goto L50f;
                case 42: goto L500;
                case 43: goto L4e9;
                case 44: goto L4d4;
                case 45: goto L4bd;
                case 46: goto L4ae;
                case 47: goto L49f;
                case 48: goto L48e;
                case 49: goto L47d;
                case 50: goto L46c;
                case 51: goto L44c;
                case 52: goto L44c;
                case 53: goto L431;
                case 54: goto L41c;
                case 55: goto L3fa;
                case 56: goto L3e2;
                case 57: goto L3d3;
                case 58: goto L3d3;
                case 59: goto L3b6;
                case 60: goto L398;
                case 61: goto L37c;
                case 62: goto L345;
                case 63: goto L309;
                case 64: goto L309;
                case 65: goto L309;
                case 66: goto L309;
                case 67: goto L2de;
                case 68: goto L2de;
                case 69: goto L2cc;
                case 70: goto L2bf;
                case 71: goto L2a8;
                case 72: goto L266;
                case 73: goto L250;
                case 74: goto L22c;
                case 75: goto L216;
                case 76: goto L4e9;
                case 77: goto L1f8;
                case 78: goto L1e1;
                case 79: goto L1bf;
                case 80: goto L8b3;
                case 81: goto L7e0;
                case 82: goto L1a4;
                case 83: goto L18f;
                case 84: goto L17a;
                case 85: goto L16b;
                case 86: goto L15c;
                case 87: goto L125;
                case 88: goto Lff;
                case 89: goto Lf4;
                default: goto Lbb;
            }
        Lbb:
            org.mozilla.javascript.InterpreterData r0 = r2.idata     // Catch: java.lang.Throwable -> Le3
            dumpICode(r0)     // Catch: java.lang.Throwable -> Le3
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Le3
            int r1 = r2.pc     // Catch: java.lang.Throwable -> Le3
            int r1 = r1 + (-1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le3
            r3.<init>()     // Catch: java.lang.Throwable -> Le3
            java.lang.String r4 = "Unknown icode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> Le3
            r3.append(r13)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r4 = " @ pc : "
            r3.append(r4)     // Catch: java.lang.Throwable -> Le3
            r3.append(r1)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Le3
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Le3
            throw r0     // Catch: java.lang.Throwable -> Le3
        Le3:
            r0 = move-exception
            r33 = 0
            r1 = r39
            r3 = r2
            r4 = r12
            r36 = r14
            r2 = r22
            r15 = r23
        Lf0:
            r5 = r34
            goto L1828
        Lf4:
            int r5 = r5 + 1
            r25[r5] = r34     // Catch: java.lang.Throwable -> Le3
            r1 = r39
            r3 = r25
        Lfc:
            r13 = r35
            goto L9f
        Lff:
            r1 = r39
            r3 = r25
            int r5 = doRefNsName(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L116
            r0 = r3
            r29 = r8
            r8 = r6
            r6 = r2
            r2 = r1
            r1 = r4
        L10e:
            r3 = r0
            r4 = r1
        L110:
            r1 = r2
            r2 = r6
            r6 = r8
        L113:
            r8 = r29
            goto Lfc
        L116:
            r0 = move-exception
            r6 = r2
            r2 = r1
        L119:
            r3 = r6
            r4 = r12
        L11b:
            r36 = r14
        L11d:
            r2 = r22
            r15 = r23
        L121:
            r5 = r34
            goto L66
        L125:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r4 != r11) goto L13d
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r4 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r4)     // Catch: java.lang.Throwable -> L13a
            goto L13d
        L13a:
            r0 = move-exception
        L13b:
            r1 = r2
            goto L119
        L13d:
            org.mozilla.javascript.Scriptable r5 = r6.scope     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Ref r4 = org.mozilla.javascript.ScriptRuntime.nameRef(r4, r2, r5, r8)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
        L145:
            r40 = r6
            r6 = r2
            r2 = r40
            r24 = r0
            r25 = r1
            r5 = r3
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r40 = 2
            goto L1558
        L15c:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doRefNsMember(r2, r0, r1, r3, r8)     // Catch: java.lang.Throwable -> L13a
            goto L10e
        L16b:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doRefMember(r2, r0, r1, r3, r8)     // Catch: java.lang.Throwable -> L13a
            goto L10e
        L17a:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r4 == r11) goto L145
            java.lang.String r4 = org.mozilla.javascript.ScriptRuntime.escapeTextValue(r4, r2)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
            goto L145
        L18f:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r4 == r11) goto L145
            java.lang.String r4 = org.mozilla.javascript.ScriptRuntime.escapeAttributeValue(r4, r2)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
            goto L145
        L1a4:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r4 != r11) goto L1b8
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r4 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r4)     // Catch: java.lang.Throwable -> L13a
        L1b8:
            java.lang.Object r4 = org.mozilla.javascript.ScriptRuntime.setDefaultNamespace(r4, r2)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
            goto L145
        L1bf:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            org.mozilla.javascript.Scriptable r4 = getCurrentFrameHomeObject(r6)     // Catch: java.lang.Throwable -> L13a
            if (r4 != 0) goto L1d7
            int r5 = r3 + 1
            java.lang.Object r3 = org.mozilla.javascript.Undefined.instance     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r3     // Catch: java.lang.Throwable -> L13a
            goto L10e
        L1d7:
            int r5 = r3 + 1
            org.mozilla.javascript.Scriptable r3 = r4.getPrototype()     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r3     // Catch: java.lang.Throwable -> L13a
            goto L10e
        L1e1:
            r29 = r8
            r40 = 2
            r8 = r6
            r28 = r7
            r27 = r9
            r3 = r13
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r6 = r39
            r25 = r4
            goto L1538
        L1f8:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r4 != r11) goto L20c
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r4 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r4)     // Catch: java.lang.Throwable -> L13a
        L20c:
            org.mozilla.javascript.Scriptable r5 = r6.scope     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Ref r4 = org.mozilla.javascript.ScriptRuntime.specialRef(r4, r12, r2, r5)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
            goto L145
        L216:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Ref r4 = (org.mozilla.javascript.Ref) r4     // Catch: java.lang.Throwable -> L13a
            java.lang.Object r4 = org.mozilla.javascript.ScriptRuntime.refDel(r4, r2)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
            goto L145
        L22c:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r4 != r11) goto L240
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r4 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r4)     // Catch: java.lang.Throwable -> L13a
        L240:
            int r5 = r3 + (-1)
            r3 = r0[r5]     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Ref r3 = (org.mozilla.javascript.Ref) r3     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Scriptable r13 = r6.scope     // Catch: java.lang.Throwable -> L13a
            java.lang.Object r3 = org.mozilla.javascript.ScriptRuntime.refSet(r3, r4, r2, r13)     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r3     // Catch: java.lang.Throwable -> L13a
            goto L10e
        L250:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Ref r4 = (org.mozilla.javascript.Ref) r4     // Catch: java.lang.Throwable -> L13a
            java.lang.Object r4 = org.mozilla.javascript.ScriptRuntime.refGet(r4, r2)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r4     // Catch: java.lang.Throwable -> L13a
            goto L145
        L266:
            r1 = r4
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch: java.lang.Throwable -> L13a
            int r5 = r3 + (-1)
            r5 = r0[r5]     // Catch: java.lang.Throwable -> L13a
            int[] r5 = (int[]) r5     // Catch: java.lang.Throwable -> L13a
            int r13 = r3 + (-2)
            r13 = r0[r13]     // Catch: java.lang.Throwable -> L13a
            java.lang.Object[] r13 = (java.lang.Object[]) r13     // Catch: java.lang.Throwable -> L13a
            int r25 = r3 + (-3)
            r3 = r0[r25]     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Scriptable r3 = (org.mozilla.javascript.Scriptable) r3     // Catch: java.lang.Throwable -> L13a
            r26 = r0
            r0 = r3
            r3 = r5
            org.mozilla.javascript.Scriptable r5 = r6.scope     // Catch: java.lang.Throwable -> L13a
            r38 = r13
            r13 = r1
            r1 = r38
            r38 = r4
            r4 = r2
            r2 = r38
            org.mozilla.javascript.ScriptRuntime.fillObjectLiteral(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2a4
            r2 = r4
            r1 = r2
            r2 = r6
            r6 = r8
            r4 = r13
            r5 = r25
        L2a0:
            r3 = r26
            goto L113
        L2a4:
            r0 = move-exception
            r2 = r4
            goto L13b
        L2a8:
            r29 = r8
            r27 = r9
            r9 = r29
            r40 = 2
            r8 = r6
            r28 = r7
            r3 = r13
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
        L2bb:
            r6 = r39
            goto L1070
        L2bf:
            r8 = r6
            r36 = r14
            r15 = r23
            r1 = r31
            r40 = 2
            r6 = r39
            goto L14db
        L2cc:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            org.mozilla.javascript.InterpretedFunction r1 = r6.fnOrScript     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
        L2db:
            r3 = r0
            goto L110
        L2de:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r1 = r6.localShift     // Catch: java.lang.Throwable -> L13a
            int r1 = r1 + r8
            r5 = r0[r1]     // Catch: java.lang.Throwable -> L13a
            int r3 = r3 + 1
            r8 = 67
            if (r13 != r8) goto L2f7
            java.lang.Boolean r5 = org.mozilla.javascript.ScriptRuntime.enumNext(r5, r2)     // Catch: java.lang.Throwable -> L13a
            goto L2fb
        L2f7:
            java.lang.Object r5 = org.mozilla.javascript.ScriptRuntime.enumId(r5, r2)     // Catch: java.lang.Throwable -> L13a
        L2fb:
            r0[r3] = r5     // Catch: java.lang.Throwable -> L13a
            r5 = r6
            r6 = r1
            r1 = r2
            r2 = r5
            r5 = r3
            r8 = r29
            r13 = r35
        L306:
            r3 = r0
            goto L9f
        L309:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r1 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r1 != r11) goto L31c
            r25 = r4[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r1 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r25)     // Catch: java.lang.Throwable -> L13a
        L31c:
            int r5 = r3 + (-1)
            int r3 = r6.localShift     // Catch: java.lang.Throwable -> L13a
            int r3 = r3 + r8
            r8 = 63
            if (r13 != r8) goto L327
            r8 = 0
            goto L335
        L327:
            r8 = 64
            if (r13 != r8) goto L32e
            r8 = r32
            goto L335
        L32e:
            r8 = 66
            if (r13 != r8) goto L334
            r8 = 6
            goto L335
        L334:
            r8 = 2
        L335:
            org.mozilla.javascript.Scriptable r13 = r6.scope     // Catch: java.lang.Throwable -> L13a
            java.lang.Object r1 = org.mozilla.javascript.ScriptRuntime.enumInit(r1, r2, r13, r8)     // Catch: java.lang.Throwable -> L13a
            r0[r3] = r1     // Catch: java.lang.Throwable -> L13a
            r1 = r2
            r2 = r6
            r8 = r29
            r13 = r35
            r6 = r3
            goto L306
        L345:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + (-1)
            int r13 = r6.localShift     // Catch: java.lang.Throwable -> L13a
            int r8 = r8 + r13
            org.mozilla.javascript.InterpreterData r13 = r6.idata     // Catch: java.lang.Throwable -> L13a
            byte[] r13 = r13.itsICode     // Catch: java.lang.Throwable -> L13a
            r1 = r13[r1]     // Catch: java.lang.Throwable -> L13a
            if (r1 == 0) goto L35e
            r1 = r32
            goto L35f
        L35e:
            r1 = 0
        L35f:
            r3 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Throwable -> L13a
            if (r1 != 0) goto L368
            r1 = r31
            goto L36c
        L368:
            r1 = r0[r8]     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Scriptable r1 = (org.mozilla.javascript.Scriptable) r1     // Catch: java.lang.Throwable -> L13a
        L36c:
            org.mozilla.javascript.Scriptable r13 = r6.scope     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Scriptable r1 = org.mozilla.javascript.ScriptRuntime.newCatchScope(r3, r1, r12, r2, r13)     // Catch: java.lang.Throwable -> L13a
            r0[r8] = r1     // Catch: java.lang.Throwable -> L13a
            int r1 = r6.pc     // Catch: java.lang.Throwable -> L13a
            int r1 = r1 + 1
            r6.pc = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L37c:
            r29 = r8
            r8 = r6
            r40 = 2
            r6 = r39
            r28 = r7
            r30 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r26 = r5
            r23 = r2
            r25 = r4
            goto L124f
        L398:
            r29 = r8
            r8 = r6
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r29
            r29 = r8
            r26 = r5
            r23 = r2
            r25 = r4
            goto L1216
        L3b6:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            int r1 = r6.localShift     // Catch: java.lang.Throwable -> L13a
            int r1 = r1 + r8
            r3 = r0[r1]     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r3     // Catch: java.lang.Throwable -> L13a
            r25 = r4[r1]     // Catch: java.lang.Throwable -> L13a
            r4[r5] = r25     // Catch: java.lang.Throwable -> L13a
            r3 = r6
            r6 = r1
            r1 = r2
            r2 = r3
            r3 = r0
            goto L113
        L3d3:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doInOrInstanceof(r2, r13, r0, r4, r3)     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L3e2:
            r8 = r6
            r0 = r25
            r6 = r2
            r2 = r39
            int r1 = r6.localShift     // Catch: java.lang.Throwable -> L13a
            int r1 = r1 + r8
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L13a
            r1 = r2
        L3ee:
            r2 = r6
            r4 = r12
            r36 = r14
            r15 = r23
        L3f4:
            r5 = r34
        L3f6:
            r33 = 0
            goto L182b
        L3fa:
            r6 = r2
            r3 = r5
            r0 = r25
            r2 = r39
            r0 = r0[r3]     // Catch: java.lang.Throwable -> L13a
            if (r0 != r11) goto L40a
            r0 = r4[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> L13a
        L40a:
            int r1 = r6.pc     // Catch: java.lang.Throwable -> L13a
            int r1 = getIndex(r15, r1)     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.JavaScriptException r3 = new org.mozilla.javascript.JavaScriptException     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.InterpreterData r4 = r6.idata     // Catch: java.lang.Throwable -> L13a
            java.lang.String r4 = r4.itsSourceFile     // Catch: java.lang.Throwable -> L13a
            r3.<init>(r0, r4, r1)     // Catch: java.lang.Throwable -> L13a
            r1 = r2
            r0 = r3
            goto L3ee
        L41c:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Scriptable r1 = org.mozilla.javascript.ScriptRuntime.bind(r2, r1, r12)     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L431:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            org.mozilla.javascript.InterpreterData r1 = r6.idata     // Catch: java.lang.Throwable -> L13a
            java.lang.Object[] r1 = r1.itsRegExpLiterals     // Catch: java.lang.Throwable -> L13a
            r1 = r1[r8]     // Catch: java.lang.Throwable -> L13a
            int r5 = r3 + 1
            org.mozilla.javascript.Scriptable r3 = r6.scope     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.Scriptable r1 = org.mozilla.javascript.ScriptRuntime.wrapRegExp(r2, r3, r1)     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L44c:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + (-1)
            boolean r1 = doShallowEquals(r0, r4, r5)     // Catch: java.lang.Throwable -> L13a
            r3 = 52
            if (r13 != r3) goto L462
            r3 = r32
            goto L463
        L462:
            r3 = 0
        L463:
            r1 = r1 ^ r3
            java.lang.Boolean r1 = org.mozilla.javascript.ScriptRuntime.wrapBoolean(r1)     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L46c:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L47d:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L48e:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            org.mozilla.javascript.Scriptable r1 = r6.thisObj     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L49f:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            r0[r5] = r31     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L4ae:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            r0[r5] = r12     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L4bd:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            r0[r5] = r11     // Catch: java.lang.Throwable -> L13a
            org.mozilla.javascript.InterpreterData r1 = r6.idata     // Catch: java.lang.Throwable -> L13a
            double[] r1 = r1.itsDoubleTable     // Catch: java.lang.Throwable -> L13a
            r25 = r1[r8]     // Catch: java.lang.Throwable -> L13a
            r4[r5] = r25     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L4d4:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r3 + 1
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> L13a
            java.lang.Object r1 = org.mozilla.javascript.ScriptRuntime.name(r2, r1, r12)     // Catch: java.lang.Throwable -> L13a
            r0[r5] = r1     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L4e9:
            r28 = r7
            r29 = r8
            r27 = r9
            r3 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r1 = r39
            r25 = r4
            r4 = r13
            goto L1723
        L500:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doSetElemSuper(r2, r6, r0, r4, r3)     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L50f:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doSetElem(r2, r6, r0, r4, r3)     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L51e:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doGetElemSuper(r2, r6, r0, r4, r3)     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L52d:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = doGetElem(r2, r6, r0, r4, r3)     // Catch: java.lang.Throwable -> L13a
            goto L2db
        L53c:
            r3 = r5
            r29 = r8
            r0 = r25
            r8 = r6
            r6 = r2
            r2 = r39
            r1 = r0[r3]     // Catch: java.lang.Throwable -> L57d
            if (r1 != r11) goto L54f
            r25 = r4[r3]     // Catch: java.lang.Throwable -> L13a
            java.lang.Number r1 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r25)     // Catch: java.lang.Throwable -> L13a
        L54f:
            int r13 = r3 + (-1)
            r3 = r0
            r0 = r3[r13]     // Catch: java.lang.Throwable -> L57d
            if (r0 != r11) goto L559
            org.mozilla.javascript.Kit.codeBug()     // Catch: java.lang.Throwable -> L13a
        L559:
            r25 = r4
            org.mozilla.javascript.Scriptable r4 = r6.scope     // Catch: java.lang.Throwable -> L57d
            org.mozilla.javascript.Scriptable r5 = r6.thisObj     // Catch: java.lang.Throwable -> L57d
            r26 = r3
            r3 = r2
            r2 = r1
            r1 = r12
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.setSuperProp(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L57a
            r2 = r3
            r26[r13] = r0     // Catch: java.lang.Throwable -> L574
            r12 = r1
            r1 = r2
            r2 = r6
            r6 = r8
            r5 = r13
        L570:
            r4 = r25
            goto L2a0
        L574:
            r0 = move-exception
        L575:
            r4 = r1
            r1 = r2
        L577:
            r3 = r6
            goto L11b
        L57a:
            r0 = move-exception
            r2 = r3
            goto L575
        L57d:
            r0 = move-exception
            r1 = r12
            goto L575
        L580:
            r3 = r5
            r29 = r8
            r1 = r12
            r26 = r25
            r25 = r4
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r26[r3]     // Catch: java.lang.Throwable -> L574
            if (r0 != r11) goto L596
            r4 = r25[r3]     // Catch: java.lang.Throwable -> L574
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r4)     // Catch: java.lang.Throwable -> L574
        L596:
            int r5 = r3 + (-1)
            r3 = r26[r5]     // Catch: java.lang.Throwable -> L574
            if (r3 != r11) goto L5a2
            r3 = r25[r5]     // Catch: java.lang.Throwable -> L574
            java.lang.Number r3 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> L574
        L5a2:
            org.mozilla.javascript.Scriptable r4 = r6.scope     // Catch: java.lang.Throwable -> L574
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.setObjectProp(r3, r1, r0, r2, r4)     // Catch: java.lang.Throwable -> L574
            r26[r5] = r0     // Catch: java.lang.Throwable -> L574
            r12 = r1
            r1 = r2
            r2 = r6
            r6 = r8
            goto L570
        L5af:
            r3 = r5
            r29 = r8
            r1 = r12
            r26 = r25
            r25 = r4
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r26[r3]     // Catch: java.lang.Throwable -> L574
            if (r0 != r11) goto L5c2
            org.mozilla.javascript.Kit.codeBug()     // Catch: java.lang.Throwable -> L574
        L5c2:
            r5 = r3
            org.mozilla.javascript.Scriptable r3 = r6.scope     // Catch: java.lang.Throwable -> L574
            org.mozilla.javascript.Scriptable r4 = r6.thisObj     // Catch: java.lang.Throwable -> L574
            r12 = 36
            if (r13 != r12) goto L5cf
            r12 = r5
            r5 = r32
            goto L5d1
        L5cf:
            r12 = r5
            r5 = 0
        L5d1:
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.getSuperProp(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L574
            r26[r12] = r0     // Catch: java.lang.Throwable -> L574
        L5d7:
            r40 = r6
            r6 = r2
            r2 = r40
            r28 = r7
            r27 = r9
            r5 = r12
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r26
            r40 = 2
            r12 = r1
            goto L1558
        L5ed:
            r29 = r8
            r1 = r12
            r26 = r25
            r25 = r4
            r12 = r5
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r26[r12]     // Catch: java.lang.Throwable -> L574
            if (r0 != r11) goto L603
            r3 = r25[r12]     // Catch: java.lang.Throwable -> L574
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> L574
        L603:
            org.mozilla.javascript.Scriptable r3 = r6.scope     // Catch: java.lang.Throwable -> L574
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.getObjectPropNoWarn(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L574
            r26[r12] = r0     // Catch: java.lang.Throwable -> L574
            goto L5d7
        L60c:
            r29 = r8
            r1 = r12
            r26 = r25
            r25 = r4
            r12 = r5
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r26[r12]     // Catch: java.lang.Throwable -> L574
            if (r0 != r11) goto L622
            r3 = r25[r12]     // Catch: java.lang.Throwable -> L574
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> L574
        L622:
            org.mozilla.javascript.Scriptable r3 = r6.scope     // Catch: java.lang.Throwable -> L574
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.getObjectProp(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L574
            r26[r12] = r0     // Catch: java.lang.Throwable -> L574
            goto L5d7
        L62b:
            r29 = r8
            r1 = r12
            r26 = r25
            r25 = r4
            r12 = r5
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r26[r12]     // Catch: java.lang.Throwable -> L574
            if (r0 != r11) goto L641
            r3 = r25[r12]     // Catch: java.lang.Throwable -> L574
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> L574
        L641:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.typeof(r0)     // Catch: java.lang.Throwable -> L574
            r26[r12] = r0     // Catch: java.lang.Throwable -> L574
            goto L5d7
        L648:
            r29 = r8
            r1 = r12
            r26 = r25
            r8 = r6
            r3 = r13
            r13 = 2
            r6 = r5
            r5 = r4
            r4 = r26
            r27 = r9
            r25 = r15
            r15 = r23
            r1 = r39
            goto L9fa
        L65e:
            r29 = r8
            r1 = r12
            r26 = r25
            r25 = r4
            r12 = r5
            r8 = r6
            r6 = r2
            r2 = r39
            if (r14 == 0) goto L672
            int r0 = r2.instructionCount     // Catch: java.lang.Throwable -> L574
            int r0 = r0 + 100
            r2.instructionCount = r0     // Catch: java.lang.Throwable -> L574
        L672:
            int r0 = r12 - r8
            r3 = r26[r0]     // Catch: java.lang.Throwable -> L6e7
            boolean r4 = r3 instanceof org.mozilla.javascript.InterpretedFunction     // Catch: java.lang.Throwable -> L6e7
            if (r4 == 0) goto L6ef
            r27 = r9
            r9 = r3
            org.mozilla.javascript.InterpretedFunction r9 = (org.mozilla.javascript.InterpretedFunction) r9     // Catch: java.lang.Throwable -> L6e7
            org.mozilla.javascript.InterpretedFunction r4 = r6.fnOrScript     // Catch: java.lang.Throwable -> L6e7
            java.lang.Object r4 = r4.securityDomain     // Catch: java.lang.Throwable -> L6e7
            java.lang.Object r5 = r9.securityDomain     // Catch: java.lang.Throwable -> L6e7
            if (r4 != r5) goto L6d8
            org.mozilla.javascript.Scriptable r3 = r6.scope     // Catch: java.lang.Throwable -> L6cf
            org.mozilla.javascript.Scriptable r3 = r9.createObject(r2, r3)     // Catch: java.lang.Throwable -> L6cf
            org.mozilla.javascript.Scriptable r2 = r6.scope     // Catch: java.lang.Throwable -> L6c5
            int r7 = r0 + 1
            r4 = r3
            r24 = 2
            r15 = r41
            r12 = r1
            r10 = r6
            r6 = r25
            r5 = r26
            r1 = r39
            org.mozilla.javascript.Interpreter$CallFrame r2 = initFrame(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6c2
            r4 = r5
            r6 = r10
            r4[r0] = r3     // Catch: java.lang.Throwable -> L6b9
            r6.savedStackTop = r0     // Catch: java.lang.Throwable -> L6b9
            r6.savedCallOp = r13     // Catch: java.lang.Throwable -> L6b9
            r3 = r2
            r0 = r8
            r4 = r12
            r2 = r22
            r7 = r23
            r15 = r31
            r13 = r32
            r5 = r34
            goto L51
        L6b9:
            r0 = move-exception
        L6ba:
            r3 = r6
            r4 = r12
        L6bc:
            r36 = r14
            r41 = r15
            goto L11d
        L6c2:
            r0 = move-exception
            r6 = r10
            goto L6ba
        L6c5:
            r0 = move-exception
            r24 = 2
            r15 = r41
            r12 = r1
            r1 = r39
            goto L119
        L6cf:
            r0 = move-exception
            r15 = r41
            r12 = r1
            r1 = r2
        L6d4:
            r24 = 2
            goto L119
        L6d8:
            r12 = r1
            r1 = r2
            r5 = r25
            r4 = r26
            r9 = 13
            r24 = 2
            r25 = r15
            r15 = r41
            goto L6f2
        L6e7:
            r0 = move-exception
            r15 = r41
            r12 = r1
            r1 = r2
            r9 = 13
            goto L6d4
        L6ef:
            r27 = r9
            goto L6d8
        L6f2:
            boolean r2 = r3 instanceof org.mozilla.javascript.Constructable     // Catch: java.lang.Throwable -> L6b9
            if (r2 != 0) goto L703
            if (r3 != r11) goto L6fe
            r2 = r5[r0]     // Catch: java.lang.Throwable -> L6b9
            java.lang.Number r3 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r2)     // Catch: java.lang.Throwable -> L6b9
        L6fe:
            java.lang.RuntimeException r0 = org.mozilla.javascript.ScriptRuntime.notFunctionError(r3)     // Catch: java.lang.Throwable -> L6b9
            throw r0     // Catch: java.lang.Throwable -> L6b9
        L703:
            org.mozilla.javascript.Constructable r3 = (org.mozilla.javascript.Constructable) r3     // Catch: java.lang.Throwable -> L6b9
            boolean r2 = r3 instanceof org.mozilla.javascript.IdFunctionObject     // Catch: java.lang.Throwable -> L6b9
            if (r2 == 0) goto L71e
            r2 = r3
            org.mozilla.javascript.IdFunctionObject r2 = (org.mozilla.javascript.IdFunctionObject) r2     // Catch: java.lang.Throwable -> L6b9
            boolean r2 = org.mozilla.javascript.NativeContinuation.isContinuationConstructor(r2)     // Catch: java.lang.Throwable -> L6b9
            if (r2 == 0) goto L71e
            java.lang.Object[] r2 = r6.stack     // Catch: java.lang.Throwable -> L6b9
            org.mozilla.javascript.Interpreter$CallFrame r3 = r6.parentFrame     // Catch: java.lang.Throwable -> L6b9
            r13 = 0
            org.mozilla.javascript.NativeContinuation r3 = captureContinuation(r1, r3, r13)     // Catch: java.lang.Throwable -> L6b9
            r2[r0] = r3     // Catch: java.lang.Throwable -> L6b9
            goto L72c
        L71e:
            int r2 = r0 + 1
            java.lang.Object[] r2 = getArgsArray(r4, r5, r2, r8)     // Catch: java.lang.Throwable -> L6b9
            org.mozilla.javascript.Scriptable r13 = r6.scope     // Catch: java.lang.Throwable -> L6b9
            org.mozilla.javascript.Scriptable r2 = r3.construct(r1, r13, r2)     // Catch: java.lang.Throwable -> L6b9
            r4[r0] = r2     // Catch: java.lang.Throwable -> L6b9
        L72c:
            r3 = r4
            r4 = r5
            r2 = r6
            r6 = r8
            r41 = r15
        L732:
            r15 = r25
            r9 = r27
            r8 = r29
            r13 = r35
            r5 = r0
            goto L9f
        L73d:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            java.lang.Number r0 = stack_numeric(r6, r12)     // Catch: java.lang.Throwable -> L776
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.negate(r0)     // Catch: java.lang.Throwable -> L776
            boolean r3 = r0 instanceof java.math.BigInteger     // Catch: java.lang.Throwable -> L776
            if (r3 == 0) goto L77b
            r4[r12] = r0     // Catch: java.lang.Throwable -> L776
        L760:
            r28 = r7
            r36 = r14
            r41 = r15
        L766:
            r15 = r23
            r40 = r24
            r7 = r25
            r24 = r4
            r25 = r5
            r5 = r12
            r12 = r2
            r2 = r6
        L773:
            r6 = r1
            goto L1558
        L776:
            r0 = move-exception
            r4 = r2
            r3 = r6
            goto L6bc
        L77b:
            r4[r12] = r11     // Catch: java.lang.Throwable -> L776
            double r36 = r0.doubleValue()     // Catch: java.lang.Throwable -> L776
            r5[r12] = r36     // Catch: java.lang.Throwable -> L776
            goto L760
        L784:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            double r36 = stack_double(r6, r12)     // Catch: java.lang.Throwable -> L776
            r4[r12] = r11     // Catch: java.lang.Throwable -> L776
            r5[r12] = r36     // Catch: java.lang.Throwable -> L776
            goto L760
        L7a2:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = doBitNOT(r6, r4, r5, r12)     // Catch: java.lang.Throwable -> L776
        L7bb:
            r12 = r2
            goto L72c
        L7be:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            boolean r0 = stack_boolean(r6, r12)     // Catch: java.lang.Throwable -> L776
            r0 = r0 ^ 1
            java.lang.Boolean r0 = org.mozilla.javascript.ScriptRuntime.wrapBoolean(r0)     // Catch: java.lang.Throwable -> L776
            r4[r12] = r0     // Catch: java.lang.Throwable -> L776
            goto L760
        L7e0:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = doArithmetic(r6, r13, r4, r5, r12)     // Catch: java.lang.Throwable -> L776
            goto L7bb
        L7fa:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = r12 + (-1)
            doAdd(r4, r5, r0, r1)     // Catch: java.lang.Throwable -> L776
            goto L7bb
        L815:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = r12 + (-1)
            double r36 = stack_double(r6, r0)     // Catch: java.lang.Throwable -> L776
            int r0 = stack_int32(r6, r12)     // Catch: java.lang.Throwable -> L776
            r0 = r0 & 31
            int r3 = r12 + (-1)
            r4[r3] = r11     // Catch: java.lang.Throwable -> L776
            long r12 = org.mozilla.javascript.ScriptRuntime.toUint32(r36)     // Catch: java.lang.Throwable -> L776
            long r12 = r12 >>> r0
            double r12 = (double) r12     // Catch: java.lang.Throwable -> L776
            r5[r3] = r12     // Catch: java.lang.Throwable -> L776
            r41 = r5
            r5 = r3
            r3 = r4
            r4 = r41
            r12 = r2
            r2 = r6
            r6 = r8
            r41 = r15
        L84d:
            r15 = r25
            r9 = r27
            goto L113
        L853:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = doCompare(r6, r13, r4, r5, r12)     // Catch: java.lang.Throwable -> L776
            goto L7bb
        L86e:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = r12 + (-1)
            boolean r3 = doEquals(r4, r5, r0)     // Catch: java.lang.Throwable -> L776
            if (r13 != r9) goto L88e
            r12 = r32
            goto L88f
        L88e:
            r12 = 0
        L88f:
            r3 = r3 ^ r12
            java.lang.Boolean r3 = org.mozilla.javascript.ScriptRuntime.wrapBoolean(r3)     // Catch: java.lang.Throwable -> L776
            r4[r0] = r3     // Catch: java.lang.Throwable -> L776
            goto L7bb
        L898:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            int r0 = doBitOp(r6, r13, r4, r5, r12)     // Catch: java.lang.Throwable -> L776
            goto L7bb
        L8b3:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r9 = 13
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r15 = r41
            r0 = r4[r12]     // Catch: java.lang.Throwable -> L8f8
            if (r0 != r11) goto L8d2
            r36 = r5[r12]     // Catch: java.lang.Throwable -> L776
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r36)     // Catch: java.lang.Throwable -> L776
        L8d2:
            int r3 = r12 + (-1)
            r12 = r4[r3]     // Catch: java.lang.Throwable -> L8f8
            org.mozilla.javascript.Scriptable r12 = (org.mozilla.javascript.Scriptable) r12     // Catch: java.lang.Throwable -> L8f8
            org.mozilla.javascript.Scriptable r9 = r6.scope
            r41 = r15
            r15 = 8
            if (r13 != r15) goto L8e9
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.setName(r12, r0, r1, r9, r2)     // Catch: java.lang.Throwable -> L8e5
            goto L8ed
        L8e5:
            r0 = move-exception
        L8e6:
            r4 = r2
            goto L577
        L8e9:
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.strictSetName(r12, r0, r1, r9, r2)     // Catch: java.lang.Throwable -> L8e5
        L8ed:
            r4[r3] = r0     // Catch: java.lang.Throwable -> L8e5
        L8ef:
            r9 = r5
            r5 = r3
            r3 = r4
            r4 = r9
            r12 = r2
            r2 = r6
            r6 = r8
            goto L84d
        L8f8:
            r0 = move-exception
            r41 = r15
            goto L8e6
        L8fc:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            int r0 = r12 + (-1)
            boolean r3 = stack_boolean(r6, r12)     // Catch: java.lang.Throwable -> L8e5
            if (r3 == 0) goto L922
            int r3 = r6.pc     // Catch: java.lang.Throwable -> L8e5
            int r3 = r3 + 2
            r6.pc = r3     // Catch: java.lang.Throwable -> L8e5
        L91b:
            r12 = r2
            r3 = r4
            r4 = r5
            r2 = r6
            r6 = r8
            goto L732
        L922:
            r12 = r2
            r2 = r6
            r28 = r7
            r36 = r14
            r15 = r23
            r40 = r24
            r7 = r25
            r33 = 0
            r24 = r4
            r25 = r5
            r5 = r0
            goto L1772
        L937:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            int r0 = r12 + (-1)
            boolean r3 = stack_boolean(r6, r12)     // Catch: java.lang.Throwable -> L8e5
            if (r3 != 0) goto L922
            int r3 = r6.pc     // Catch: java.lang.Throwable -> L8e5
            int r3 = r3 + 2
            r6.pc = r3     // Catch: java.lang.Throwable -> L8e5
            goto L91b
        L957:
            r29 = r8
            r24 = 2
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r33 = 0
            r1 = r39
            r25 = r5
            r28 = r7
            r27 = r9
            r5 = r12
            r36 = r14
            r7 = r15
            r15 = r23
            r40 = r24
            r12 = r2
            r24 = r4
            r2 = r6
            goto L1772
        L97a:
            r24 = 2
            r1 = r39
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r0 = r4[r12]     // Catch: java.lang.Throwable -> L8e5
            r6.result = r0     // Catch: java.lang.Throwable -> L8e5
            r3 = r5[r12]     // Catch: java.lang.Throwable -> L8e5
            r6.resultDbl = r3     // Catch: java.lang.Throwable -> L8e5
            r12 = r2
            r2 = r6
            r36 = r14
            r15 = r23
            r40 = r24
            r6 = r1
        L996:
            r1 = r31
            goto L14db
        L99a:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            org.mozilla.javascript.Scriptable r0 = r6.scope     // Catch: java.lang.Throwable -> L8e5
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.leaveWith(r0)     // Catch: java.lang.Throwable -> L8e5
            r6.scope = r0     // Catch: java.lang.Throwable -> L8e5
            r28 = r7
            r36 = r14
            goto L766
        L9b9:
            r24 = 2
            r1 = r39
            r29 = r8
            r27 = r9
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r25 = r15
            r0 = r4[r12]     // Catch: java.lang.Throwable -> L8e5
            if (r0 != r11) goto L9d4
            r36 = r5[r12]     // Catch: java.lang.Throwable -> L8e5
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r36)     // Catch: java.lang.Throwable -> L8e5
        L9d4:
            int r3 = r12 + (-1)
            org.mozilla.javascript.Scriptable r9 = r6.scope     // Catch: java.lang.Throwable -> L8e5
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.enterWith(r0, r1, r9)     // Catch: java.lang.Throwable -> L8e5
            r6.scope = r0     // Catch: java.lang.Throwable -> L8e5
            goto L8ef
        L9e0:
            r29 = r8
            r24 = 2
            r8 = r6
            r6 = r2
            r2 = r12
            r12 = r5
            r5 = r4
            r4 = r25
            r1 = r12
            r12 = r2
            r2 = r6
            r6 = r1
            r3 = r13
            r13 = r24
            r27 = r9
            r25 = r15
            r1 = r39
            r15 = r23
        L9fa:
            int r0 = doDelName(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La08
            r3 = r4
            r4 = r5
        La00:
            r1 = r39
            r5 = r0
        La03:
            r6 = r8
            r23 = r15
            goto L84d
        La08:
            r0 = move-exception
            r33 = 0
            r1 = r39
            r3 = r2
            r4 = r12
            r36 = r14
        La11:
            r2 = r22
            goto Lf0
        La15:
            r29 = r8
            r27 = r9
            r3 = r25
            r13 = 2
            r8 = r6
            r25 = r15
            r15 = r23
            int r0 = r5 + 1
            r1 = r3[r5]     // Catch: java.lang.Throwable -> La08
            r3[r0] = r1     // Catch: java.lang.Throwable -> La08
            r5 = r4[r5]     // Catch: java.lang.Throwable -> La08
            r4[r0] = r5     // Catch: java.lang.Throwable -> La08
            goto La00
        La2c:
            r29 = r8
            r27 = r9
            r3 = r25
            r13 = 2
            r8 = r6
            r25 = r15
            r15 = r23
            int r0 = r5 + 1
            int r1 = r5 + (-1)
            r6 = r3[r1]     // Catch: java.lang.Throwable -> La08
            r3[r0] = r6     // Catch: java.lang.Throwable -> La08
            r23 = r4[r1]     // Catch: java.lang.Throwable -> La08
            r4[r0] = r23     // Catch: java.lang.Throwable -> La08
            int r0 = r5 + 2
            r1 = r3[r5]     // Catch: java.lang.Throwable -> La08
            r3[r0] = r1     // Catch: java.lang.Throwable -> La08
            r5 = r4[r5]     // Catch: java.lang.Throwable -> La08
            r4[r0] = r5     // Catch: java.lang.Throwable -> La08
            goto La00
        La4f:
            r29 = r8
            r27 = r9
            r3 = r25
            r13 = 2
            r8 = r6
            r25 = r15
            r15 = r23
            r0 = r3[r5]     // Catch: java.lang.Throwable -> La08
            int r1 = r5 + (-1)
            r6 = r3[r1]     // Catch: java.lang.Throwable -> La08
            r3[r5] = r6     // Catch: java.lang.Throwable -> La08
            r3[r1] = r0     // Catch: java.lang.Throwable -> La08
            r23 = r4[r5]     // Catch: java.lang.Throwable -> La08
            r36 = r4[r1]     // Catch: java.lang.Throwable -> La08
            r4[r5] = r36     // Catch: java.lang.Throwable -> La08
            r4[r1] = r23     // Catch: java.lang.Throwable -> La08
            r6 = r39
            r24 = r3
            r28 = r7
        La73:
            r40 = r13
            r36 = r14
            r7 = r25
            r25 = r4
            goto L1558
        La7d:
            r29 = r8
            r27 = r9
            r3 = r25
            r13 = 2
            r8 = r6
            r25 = r15
            r15 = r23
            r3[r5] = r31     // Catch: java.lang.Throwable -> La08
        La8b:
            int r5 = r5 + (-1)
            r1 = r39
            goto La03
        La91:
            r29 = r8
            r27 = r9
            r3 = r25
            r13 = 2
            r8 = r6
            r25 = r15
            r15 = r23
            r0 = r3[r5]     // Catch: java.lang.Throwable -> La08
            r2.result = r0     // Catch: java.lang.Throwable -> La08
            r0 = r4[r5]     // Catch: java.lang.Throwable -> La08
            r2.resultDbl = r0     // Catch: java.lang.Throwable -> La08
            r3[r5] = r31     // Catch: java.lang.Throwable -> La08
            goto La8b
        Laa8:
            r29 = r8
            r27 = r9
            r3 = r25
            r13 = 2
            r8 = r6
            r25 = r15
            r15 = r23
            int r0 = r5 + (-1)
            boolean r1 = stack_boolean(r2, r5)     // Catch: java.lang.Throwable -> La08
            if (r1 != 0) goto Lac3
            int r1 = r2.pc     // Catch: java.lang.Throwable -> La08
            int r1 = r1 + r13
            r2.pc = r1     // Catch: java.lang.Throwable -> La08
            goto La00
        Lac3:
            int r5 = r5 + (-2)
            r3[r0] = r31     // Catch: java.lang.Throwable -> La08
            r33 = 0
            r1 = r39
            r24 = r3
            r28 = r7
            r40 = r13
            r36 = r14
            r7 = r25
            r25 = r4
            goto L1772
        Lad9:
            r1 = r9
            r9 = r6
            r6 = r1
            r13 = 2
            r1 = r39
            r3 = r25
            r25 = r15
            r15 = r23
            int r5 = doVarIncDec(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lb00
            r27 = r9
            r9 = r8
            r8 = r27
            r27 = r6
            r28 = r7
            r6 = r1
        Laf3:
            r1 = r6
            r6 = r8
            r8 = r9
            r23 = r15
            r15 = r25
            r9 = r27
            r7 = r28
            goto Lfc
        Lb00:
            r0 = move-exception
            r6 = r1
        Lb02:
            r3 = r2
        Lb03:
            r4 = r12
            r36 = r14
        Lb06:
            r2 = r22
            goto L121
        Lb0a:
            r13 = 2
            r28 = r7
            r27 = r9
            r3 = r25
            r9 = r8
            r25 = r15
            r15 = r23
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r0 = r2.scope     // Catch: java.lang.Throwable -> Lb2c
            r1 = r25[r1]     // Catch: java.lang.Throwable -> Lb2c
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.nameIncrDecr(r0, r12, r6, r1)     // Catch: java.lang.Throwable -> Lb2c
            r3[r5] = r0     // Catch: java.lang.Throwable -> Lb2c
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lb2c
            int r0 = r0 + 1
            r2.pc = r0     // Catch: java.lang.Throwable -> Lb2c
            goto Laf3
        Lb2c:
            r0 = move-exception
            r3 = r2
            r1 = r6
            goto Lb03
        Lb30:
            r13 = 2
            r28 = r7
            r27 = r9
            r3 = r25
            r9 = r8
            r25 = r15
            r15 = r23
            r8 = r6
            r6 = r39
            r0 = r3[r5]     // Catch: java.lang.Throwable -> Lb2c
            if (r0 != r11) goto Lb49
            r0 = r4[r5]     // Catch: java.lang.Throwable -> Lb2c
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lb2c
        Lb49:
            org.mozilla.javascript.Scriptable r1 = r2.scope     // Catch: java.lang.Throwable -> Lb2c
            int r7 = r2.pc     // Catch: java.lang.Throwable -> Lb2c
            r7 = r25[r7]     // Catch: java.lang.Throwable -> Lb2c
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.propIncrDecr(r0, r12, r6, r1, r7)     // Catch: java.lang.Throwable -> Lb2c
            r3[r5] = r0     // Catch: java.lang.Throwable -> Lb2c
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lb2c
            int r0 = r0 + 1
            r2.pc = r0     // Catch: java.lang.Throwable -> Lb2c
            r24 = r3
            r29 = r9
            goto La73
        Lb61:
            r13 = 2
            r1 = r39
            r28 = r7
            r27 = r9
            r3 = r15
            r15 = r23
            r9 = r8
            r8 = r6
            r6 = r5
            r5 = r4
            r4 = r25
            int r0 = doElemIncDec(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb90
            r6 = r2
            r7 = r3
            r24 = r4
            r25 = r5
            r2 = r1
            r5 = r0
        Lb7d:
            r1 = r2
        Lb7e:
            r2 = r6
            r6 = r8
            r8 = r9
            r23 = r15
            r3 = r24
            r4 = r25
        Lb87:
            r9 = r27
            r13 = r35
        Lb8b:
            r15 = r7
            r7 = r28
            goto L9f
        Lb90:
            r0 = move-exception
            r6 = r2
            r2 = r1
        Lb93:
            r3 = r6
            goto Lb03
        Lb96:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Ref r0 = (org.mozilla.javascript.Ref) r0     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Scriptable r3 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            r1 = r7[r1]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.refIncrDecr(r0, r2, r3, r1)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            int r0 = r6.pc     // Catch: java.lang.Throwable -> Lbc8
            int r0 = r0 + 1
            r6.pc = r0     // Catch: java.lang.Throwable -> Lbc8
        Lbbb:
            r40 = r6
            r6 = r2
            r2 = r40
        Lbc0:
            r29 = r9
            r40 = r13
            r36 = r14
            goto L1558
        Lbc8:
            r0 = move-exception
            r1 = r2
            goto Lb93
        Lbcb:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r0 = r6.localShift     // Catch: java.lang.Throwable -> Lbc8
            int r0 = r0 + r8
            r1 = r24[r0]     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Scriptable r1 = (org.mozilla.javascript.Scriptable) r1     // Catch: java.lang.Throwable -> Lbc8
            r6.scope = r1     // Catch: java.lang.Throwable -> Lbc8
        Lbe5:
            r1 = r2
            r2 = r6
            r8 = r9
            r23 = r15
            r3 = r24
            r4 = r25
        Lbee:
            r9 = r27
            r13 = r35
        Lbf2:
            r6 = r0
            goto Lb8b
        Lbf4:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r0 = r6.localShift     // Catch: java.lang.Throwable -> Lbc8
            int r0 = r0 + r8
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lbc8
            goto Lbe5
        Lc0d:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r0 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.typeofName(r0, r12)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Lc2a:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r0 = r5 + 1
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Callable r1 = org.mozilla.javascript.ScriptRuntime.getNameFunctionAndThis(r12, r2, r1)     // Catch: java.lang.Throwable -> Lbc8
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lbc8
            int r5 = r5 + 2
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Lc4f:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            if (r0 != r11) goto Lc6a
            r0 = r25[r5]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lbc8
        Lc6a:
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Callable r0 = org.mozilla.javascript.ScriptRuntime.getPropFunctionAndThis(r0, r12, r2, r1)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Lc7c:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r0 = r5 + (-1)
            r1 = r24[r0]     // Catch: java.lang.Throwable -> Lbc8
            if (r1 != r11) goto Lc99
            r3 = r25[r0]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r1 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> Lbc8
        Lc99:
            r3 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            if (r3 != r11) goto Lca3
            r3 = r25[r5]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r3 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> Lbc8
        Lca3:
            org.mozilla.javascript.Scriptable r4 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Callable r1 = org.mozilla.javascript.ScriptRuntime.getElemFunctionAndThis(r1, r3, r2, r4)     // Catch: java.lang.Throwable -> Lbc8
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lbbb
        Lcb3:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            if (r0 != r11) goto Lcce
            r0 = r25[r5]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lbc8
        Lcce:
            org.mozilla.javascript.Callable r0 = org.mozilla.javascript.ScriptRuntime.getValueFunctionAndThis(r0, r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Lcde:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r0 = r5 + 1
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Callable r1 = org.mozilla.javascript.ScriptRuntime.getNameFunctionAndThisOptional(r12, r2, r1)     // Catch: java.lang.Throwable -> Lbc8
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lbc8
            int r5 = r5 + 2
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Ld03:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            if (r0 != r11) goto Ld1e
            r0 = r25[r5]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lbc8
        Ld1e:
            org.mozilla.javascript.Scriptable r1 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Callable r0 = org.mozilla.javascript.ScriptRuntime.getPropFunctionAndThisOptional(r0, r12, r2, r1)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Ld30:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            int r0 = r5 + (-1)
            r1 = r24[r0]     // Catch: java.lang.Throwable -> Lbc8
            if (r1 != r11) goto Ld4d
            r3 = r25[r0]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r1 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> Lbc8
        Ld4d:
            r3 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            if (r3 != r11) goto Ld57
            r3 = r25[r5]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r3 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)     // Catch: java.lang.Throwable -> Lbc8
        Ld57:
            org.mozilla.javascript.Scriptable r4 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Callable r1 = org.mozilla.javascript.ScriptRuntime.getElemFunctionAndThisOptional(r1, r3, r2, r4)     // Catch: java.lang.Throwable -> Lbc8
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lbbb
        Ld67:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lbc8
            if (r0 != r11) goto Ld82
            r0 = r25[r5]     // Catch: java.lang.Throwable -> Lbc8
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lbc8
        Ld82:
            org.mozilla.javascript.Callable r0 = org.mozilla.javascript.ScriptRuntime.getValueFunctionAndThisOptional(r0, r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r2)     // Catch: java.lang.Throwable -> Lbc8
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lbc8
            goto Lb7d
        Ld92:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r39
            org.mozilla.javascript.Scriptable r0 = r6.scope     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.InterpretedFunction r1 = r6.fnOrScript     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.InterpretedFunction r0 = org.mozilla.javascript.InterpretedFunction.createFunction(r2, r0, r1, r8)     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.InterpreterData r1 = r0.idata     // Catch: java.lang.Throwable -> Lbc8
            int r1 = r1.itsFunctionType     // Catch: java.lang.Throwable -> Lbc8
            if (r1 != r3) goto Lde0
            r26 = r5
            org.mozilla.javascript.Scriptable r5 = getCurrentFrameHomeObject(r6)     // Catch: java.lang.Throwable -> Lbc8
            int r23 = r26 + 1
            r3 = r0
            org.mozilla.javascript.ArrowFunction r0 = new org.mozilla.javascript.ArrowFunction     // Catch: java.lang.Throwable -> Lbc8
            org.mozilla.javascript.Scriptable r2 = r6.scope     // Catch: java.lang.Throwable -> Lddb
            org.mozilla.javascript.Scriptable r4 = r6.thisObj     // Catch: java.lang.Throwable -> Lddb
            r1 = r39
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Ldd8
            r24[r23] = r0     // Catch: java.lang.Throwable -> Ldd8
            r2 = r6
            r6 = r8
            r8 = r9
            r5 = r23
            r3 = r24
            r4 = r25
            r9 = r27
            r13 = r35
            r23 = r15
            goto Lb8b
        Ldd8:
            r0 = move-exception
            goto Lb93
        Lddb:
            r0 = move-exception
            r1 = r39
            goto Lb93
        Lde0:
            r3 = r0
            r1 = r2
            r26 = r5
            int r5 = r26 + 1
            r24[r5] = r3     // Catch: java.lang.Throwable -> Ldd8
            goto Lb7e
        Ldea:
            r13 = 2
            r1 = r39
            r26 = r5
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            org.mozilla.javascript.Scriptable r0 = r6.scope     // Catch: java.lang.Throwable -> Ldd8
            org.mozilla.javascript.InterpretedFunction r2 = r6.fnOrScript     // Catch: java.lang.Throwable -> Ldd8
            initFunction(r1, r0, r2, r8)     // Catch: java.lang.Throwable -> Ldd8
            r2 = r6
            r29 = r9
            r40 = r13
            r36 = r14
            r5 = r26
            goto L773
        Le0f:
            r13 = 2
            r1 = r39
            r26 = r5
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r9 = r8
            r8 = r6
            r6 = r2
            if (r14 == 0) goto Le2a
            int r0 = r1.instructionCount     // Catch: java.lang.Throwable -> Ldd8
            int r0 = r0 + 100
            r1.instructionCount = r0     // Catch: java.lang.Throwable -> Ldd8
        Le2a:
            r3 = r7
            r7 = r8
            r8 = 0
            r2 = r6
            r4 = r25
            r5 = r26
            r6 = r3
            r3 = r24
            int r5 = doCallSpecial(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Le47
            r8 = r7
            r23 = r15
            r7 = r28
            r13 = r35
            r15 = r6
            r6 = r8
            r8 = r9
            r9 = r27
            goto L9f
        Le47:
            r0 = move-exception
            goto Lb02
        Le4a:
            r13 = 2
            r1 = r39
            r28 = r7
            r27 = r9
            r3 = r25
            r9 = r8
            r8 = r6
            r6 = r15
            r15 = r23
            if (r14 == 0) goto Le60
            int r0 = r1.instructionCount     // Catch: java.lang.Throwable -> Le47
            int r0 = r0 + 100
            r1.instructionCount = r0     // Catch: java.lang.Throwable -> Le47
        Le60:
            r7 = r8
            r8 = 1
            int r5 = doCallSpecial(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb00
            r24 = r3
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            r23 = r15
            r3 = r24
            goto Lb87
        Le74:
            r13 = 2
            r8 = r6
            r15 = r23
            r6 = r39
            java.lang.Object r0 = org.mozilla.javascript.Interpreter.undefined     // Catch: java.lang.Throwable -> Lb2c
            r2.result = r0     // Catch: java.lang.Throwable -> Lb2c
            r40 = r13
            r36 = r14
            goto L996
        Le84:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            r24[r5] = r11     // Catch: java.lang.Throwable -> Lb2c
            int r0 = r0 + 3
            double r0 = (double) r0     // Catch: java.lang.Throwable -> Lb2c
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lb2c
            r25 = r4
            r1 = r6
            r29 = r9
            r40 = r13
            r36 = r14
        Lea4:
            r33 = 0
            goto L1772
        Lea8:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r0 = r2.emptyStackTop     // Catch: java.lang.Throwable -> Lb2c
            int r1 = r0 + 1
            if (r5 != r1) goto Led1
            int r0 = r2.localShift     // Catch: java.lang.Throwable -> Lb2c
            int r0 = r0 + r8
            r1 = r24[r5]     // Catch: java.lang.Throwable -> Lb2c
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lb2c
            r25 = r4[r5]     // Catch: java.lang.Throwable -> Lb2c
            r4[r0] = r25     // Catch: java.lang.Throwable -> Lb2c
            int r5 = r5 + (-1)
            r1 = r6
            r8 = r9
            r23 = r15
        Lecd:
            r3 = r24
            goto Lbee
        Led1:
            if (r5 == r0) goto Led6
            org.mozilla.javascript.Kit.codeBug()     // Catch: java.lang.Throwable -> Lb2c
        Led6:
            r25 = r4
            goto Lbc0
        Leda:
            r13 = 2
            r28 = r7
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            if (r14 == 0) goto Leee
            r1 = 0
            addInstructionCount(r6, r2, r1)     // Catch: java.lang.Throwable -> Lb2c
        Leee:
            int r0 = r2.localShift     // Catch: java.lang.Throwable -> Lf1e
            int r0 = r0 + r8
            r1 = r24[r0]     // Catch: java.lang.Throwable -> Lf1e
            if (r1 == r11) goto Lefc
            r0 = r1
            r1 = r6
            r4 = r12
            r36 = r14
            goto L3f4
        Lefc:
            r40 = r13
            r36 = r14
            r13 = r4[r0]     // Catch: java.lang.Throwable -> Lf0a
            int r1 = (int) r13     // Catch: java.lang.Throwable -> Lf0a
            r2.pc = r1     // Catch: java.lang.Throwable -> Lf0a
            if (r36 == 0) goto Lf10
            r2.pcPrevBranch = r1     // Catch: java.lang.Throwable -> Lf0a
            goto Lf10
        Lf0a:
            r0 = move-exception
        Lf0b:
            r3 = r2
            r1 = r6
            r4 = r12
            goto Lb06
        Lf10:
            r1 = r6
            r8 = r9
            r23 = r15
            r3 = r24
        Lf16:
            r9 = r27
        Lf18:
            r13 = r35
            r14 = r36
            goto Lbf2
        Lf1e:
            r0 = move-exception
            r40 = r13
            r36 = r14
            goto Lf0b
        Lf24:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r2.pcSourceLineStart = r1     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.debug.DebugFrame r0 = r2.debuggerFrame     // Catch: java.lang.Throwable -> Lf0a
            if (r0 == 0) goto Lf44
            int r0 = getIndex(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.debug.DebugFrame r1 = r2.debuggerFrame     // Catch: java.lang.Throwable -> Lf0a
            r1.onLineChange(r6, r0)     // Catch: java.lang.Throwable -> Lf0a
        Lf44:
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
        Lf4a:
            r25 = r4
            r29 = r9
            goto L1558
        Lf50:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            r24[r5] = r11     // Catch: java.lang.Throwable -> Lf0a
            int r0 = getShort(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            double r0 = (double) r0     // Catch: java.lang.Throwable -> Lf0a
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
        Lf72:
            r1 = r6
            r6 = r8
        Lf74:
            r8 = r9
            r23 = r15
            r3 = r24
            r9 = r27
        Lf7b:
            r13 = r35
            r14 = r36
            goto Lb8b
        Lf81:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            r24[r5] = r11     // Catch: java.lang.Throwable -> Lf0a
            int r0 = getInt(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            double r0 = (double) r0     // Catch: java.lang.Throwable -> Lf0a
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + r3
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        Lfa3:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            org.mozilla.javascript.InterpreterData r3 = r2.idata     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r3 = r3.literalIds     // Catch: java.lang.Throwable -> Lf0a
            r3 = r3[r8]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> Lf0a
            r1 = r7[r1]     // Catch: java.lang.Throwable -> Lf0a
            if (r1 == 0) goto Lfc3
            r1 = r32
            goto Lfc4
        Lfc3:
            r1 = 0
        Lfc4:
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r5 + 1
            org.mozilla.javascript.Scriptable r13 = r2.scope     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r13 = r6.newObject(r13)     // Catch: java.lang.Throwable -> Lf0a
            r24[r0] = r13     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r5 + 2
            if (r1 == 0) goto Lfdc
            int r1 = r3.length     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r1)     // Catch: java.lang.Throwable -> Lf0a
            goto Lfdd
        Lfdc:
            r1 = r3
        Lfdd:
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r5 + 3
            int r1 = r3.length     // Catch: java.lang.Throwable -> Lf0a
            int[] r1 = new int[r1]     // Catch: java.lang.Throwable -> Lf0a
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lf0a
            int r5 = r5 + 4
            int r0 = r3.length     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            r4[r5] = r16     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        Lff0:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r0 = r5 + 1
            int[] r1 = new int[r8]     // Catch: java.lang.Throwable -> Lf0a
            r24[r0] = r1     // Catch: java.lang.Throwable -> Lf0a
            int r5 = r5 + 2
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            r4[r5] = r16     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L1011:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            if (r0 != r11) goto L102c
            r0 = r4[r5]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lf0a
        L102c:
            int r5 = r5 + (-1)
            r13 = r4[r5]     // Catch: java.lang.Throwable -> Lf0a
            int r1 = (int) r13     // Catch: java.lang.Throwable -> Lf0a
            r3 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> Lf0a
            r3[r1] = r0     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r1 + 1
            double r0 = (double) r1     // Catch: java.lang.Throwable -> Lf0a
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L103e:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.InterpretedFunction r0 = (org.mozilla.javascript.InterpretedFunction) r0     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r5 + (-4)
            r1 = r24[r1]     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r1 = (org.mozilla.javascript.Scriptable) r1     // Catch: java.lang.Throwable -> Lf0a
            r0.setHomeObject(r1)     // Catch: java.lang.Throwable -> Lf0a
            goto Lf4a
        L105e:
            r27 = r9
            r9 = r8
            r40 = 2
            r28 = r7
            r3 = r13
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r8 = r6
            goto L2bb
        L1070:
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> Lf0a
            int r5 = r5 + (-1)
            r1 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            int[] r1 = (int[]) r1     // Catch: java.lang.Throwable -> Lf0a
            r1 = -38
            if (r3 != r1) goto L1087
            org.mozilla.javascript.InterpreterData r1 = r2.idata     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r1 = r1.literalIds     // Catch: java.lang.Throwable -> Lf0a
            r1 = r1[r8]     // Catch: java.lang.Throwable -> Lf0a
            int[] r1 = (int[]) r1     // Catch: java.lang.Throwable -> Lf0a
            goto L1089
        L1087:
            r1 = r31
        L1089:
            org.mozilla.javascript.Scriptable r3 = r2.scope     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.newArrayLiteral(r0, r1, r6, r3)     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L1093:
            r28 = r7
            r27 = r9
            r24 = r25
            r40 = 2
            r1 = r39
            r3 = r24
            r13 = r35
            r6 = 0
            goto L9f
        L10a4:
            r28 = r7
            r27 = r9
            r24 = r25
            r40 = 2
            r1 = r39
            r3 = r24
            r6 = r32
            goto Lfc
        L10b4:
            r28 = r7
            r27 = r9
            r24 = r25
            r40 = 2
            r1 = r39
            r6 = r40
        L10c0:
            r3 = r24
            goto Lfc
        L10c4:
            r28 = r7
            r27 = r9
            r24 = r25
            r40 = 2
            r1 = r39
            r3 = r24
            r6 = r26
            goto Lfc
        L10d4:
            r28 = r7
            r27 = r9
            r24 = r25
            r40 = 2
            r1 = r39
            r6 = r3
            goto L10c0
        L10e0:
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r0 = 5
            r1 = r6
            goto Lecd
        L10f4:
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r1 = r7[r1]     // Catch: java.lang.Throwable -> Lf0a
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            r3 = r6
            r6 = r1
            r1 = r3
            goto Lf74
        L1111:
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            int r0 = getIndex(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r1 + 2
            r2.pc = r1     // Catch: java.lang.Throwable -> Lf0a
            goto Lf10
        L112d:
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            int r0 = getInt(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r1 + r3
            r2.pc = r1     // Catch: java.lang.Throwable -> Lf0a
            goto Lf10
        L1148:
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r9 = r8
            r8 = r6
            r6 = r39
            r12 = r35[r33]     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L115f:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r12 = r35[r32]     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L1174:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r12 = r35[r40]     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L1189:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r12 = r35[r26]     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L119e:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            r1 = r7[r1]     // Catch: java.lang.Throwable -> Lf0a
            r1 = r1 & 255(0xff, float:3.57E-43)
            r12 = r35[r1]     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L11bb:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r0 = getIndex(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            r12 = r35[r0]     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L11da:
            r40 = 2
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            r8 = r6
            r6 = r39
            int r0 = getInt(r7, r1)     // Catch: java.lang.Throwable -> Lf0a
            r12 = r35[r0]     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + r3
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            goto Lf72
        L11f8:
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r9 = r8
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            r0 = r7[r1]     // Catch: java.lang.Throwable -> Lf0a
            r29 = r0
            r23 = r2
            r25 = r4
            r26 = r5
        L1216:
            int r5 = doGetVar(r23, r24, r25, r26, r27, r28, r29)     // Catch: java.lang.Throwable -> L1228
            r2 = r23
            r3 = r24
            r4 = r25
            r0 = r29
            r1 = r6
            r8 = r9
            r23 = r15
            goto Lf16
        L1228:
            r0 = move-exception
            r2 = r23
            goto Lf0b
        L122d:
            r40 = 2
            r6 = r39
            r28 = r7
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r3 = r25
            r9 = r8
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            r0 = r7[r1]     // Catch: java.lang.Throwable -> Lf0a
            r30 = r0
            r24 = r3
            r29 = r9
            r23 = r2
            r25 = r4
            r26 = r5
        L124f:
            int r5 = doSetVar(r23, r24, r25, r26, r27, r28, r29, r30)     // Catch: java.lang.Throwable -> L1228
            r2 = r23
            r0 = r30
        L1257:
            r1 = r6
            r23 = r15
            r3 = r24
            r4 = r25
            r9 = r27
            r8 = r29
            goto Lf18
        L1264:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            java.lang.Object r0 = org.mozilla.javascript.Interpreter.undefined     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
        L127e:
            r1 = r6
            r6 = r8
            r23 = r15
            r3 = r24
            r4 = r25
            r9 = r27
            r8 = r29
            goto Lf7b
        L128c:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            r33 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r33)     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            goto L127e
        L12ab:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            int r5 = r5 + 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r32)     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            goto L127e
        L12c8:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            if (r0 != r11) goto L12e6
            r0 = r25[r5]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lf0a
        L12e6:
            int r5 = r5 + (-1)
            org.mozilla.javascript.Scriptable r1 = r2.scope     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.enterDotQuery(r0, r1)     // Catch: java.lang.Throwable -> Lf0a
            r2.scope = r0     // Catch: java.lang.Throwable -> Lf0a
            goto L127e
        L12f1:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            boolean r0 = stack_boolean(r2, r5)     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r1 = r2.scope     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.updateDotQuery(r0, r1)     // Catch: java.lang.Throwable -> Lf0a
            if (r0 == 0) goto L1323
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r0 = r2.scope     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.leaveDotQuery(r0)     // Catch: java.lang.Throwable -> Lf0a
            r2.scope = r0     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r2.pc     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            goto L1558
        L1323:
            int r5 = r5 + (-1)
            r1 = r6
            goto Lea4
        L1328:
            r28 = r7
            r29 = r8
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r25 = r4
            r33 = 0
        L1339:
            r1 = r39
            r4 = r13
            r3 = r14
            goto L1723
        L133f:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            int r0 = r2.localShift     // Catch: java.lang.Throwable -> Lf0a
            int r0 = r0 + r8
            r24[r0] = r31     // Catch: java.lang.Throwable -> Lf0a
            goto L1257
        L135a:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r5 + (-1)
            r3 = r25[r1]     // Catch: java.lang.Throwable -> Lf0a
            int r3 = (int) r3     // Catch: java.lang.Throwable -> Lf0a
            r4 = r24[r1]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch: java.lang.Throwable -> Lf0a
            r4[r3] = r0     // Catch: java.lang.Throwable -> Lf0a
            int r5 = r5 + (-2)
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            int[] r0 = (int[]) r0     // Catch: java.lang.Throwable -> Lf0a
            r0[r3] = r18     // Catch: java.lang.Throwable -> Lf0a
            int r3 = r3 + 1
            double r3 = (double) r3     // Catch: java.lang.Throwable -> Lf0a
            r25[r1] = r3     // Catch: java.lang.Throwable -> Lf0a
        L1388:
            r5 = r1
            goto L127e
        L138b:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            int r1 = r5 + (-1)
            r3 = r25[r1]     // Catch: java.lang.Throwable -> Lf0a
            int r3 = (int) r3     // Catch: java.lang.Throwable -> Lf0a
            r4 = r24[r1]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch: java.lang.Throwable -> Lf0a
            r4[r3] = r0     // Catch: java.lang.Throwable -> Lf0a
            int r5 = r5 + (-2)
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            int[] r0 = (int[]) r0     // Catch: java.lang.Throwable -> Lf0a
            r0[r3] = r32     // Catch: java.lang.Throwable -> Lf0a
            int r3 = r3 + 1
            double r3 = (double) r3     // Catch: java.lang.Throwable -> Lf0a
            r25[r1] = r3     // Catch: java.lang.Throwable -> Lf0a
            goto L1388
        L13ba:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            if (r0 != r11) goto L13d8
            r0 = r25[r5]     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> Lf0a
        L13d8:
            int r5 = r5 + (-1)
            r1 = r24[r5]     // Catch: java.lang.Throwable -> Lf0a
            org.mozilla.javascript.Scriptable r1 = (org.mozilla.javascript.Scriptable) r1     // Catch: java.lang.Throwable -> Lf0a
            java.lang.Object r0 = org.mozilla.javascript.ScriptRuntime.setConst(r1, r0, r6, r12)     // Catch: java.lang.Throwable -> Lf0a
            r24[r5] = r0     // Catch: java.lang.Throwable -> Lf0a
            goto L127e
        L13e6:
            r40 = 2
            r6 = r39
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> Lf0a
            r0 = r7[r1]     // Catch: java.lang.Throwable -> Lf0a
            r30 = r0
            r1 = r6
            r23 = r2
            r26 = r5
            r33 = 0
            goto L17e4
        L140a:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r3 = r13
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            boolean r1 = r2.frozen     // Catch: java.lang.Throwable -> L1442
            if (r1 != 0) goto L1538
            r2.pc = r0     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.Interpreter$CallFrame r0 = captureFrameForGenerator(r2)     // Catch: java.lang.Throwable -> L1442
            r1 = r32
            r0.frozen = r1     // Catch: java.lang.Throwable -> L1442
            int r1 = r6.getLanguageVersion()     // Catch: java.lang.Throwable -> L1442
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 < r3) goto L144e
            org.mozilla.javascript.ES6Generator r1 = new org.mozilla.javascript.ES6Generator     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.Scriptable r3 = r2.scope     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.InterpretedFunction r4 = r0.fnOrScript     // Catch: java.lang.Throwable -> L1442
            r1.<init>(r3, r4, r0)     // Catch: java.lang.Throwable -> L1442
            r2.result = r1     // Catch: java.lang.Throwable -> L1442
            goto L996
        L1442:
            r0 = move-exception
        L1443:
            r3 = r2
            r1 = r6
            r4 = r12
            r2 = r22
            r5 = r34
            r32 = 1
            goto L66
        L144e:
            org.mozilla.javascript.NativeGenerator r1 = new org.mozilla.javascript.NativeGenerator     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.Scriptable r3 = r2.scope     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.InterpretedFunction r4 = r0.fnOrScript     // Catch: java.lang.Throwable -> L1442
            r1.<init>(r3, r4, r0)     // Catch: java.lang.Throwable -> L1442
            r2.result = r1     // Catch: java.lang.Throwable -> L1442
            goto L996
        L145b:
            r40 = 2
            r8 = r6
            r36 = r14
            r7 = r15
            r15 = r23
            r3 = r32
            r6 = r39
            r2.frozen = r3     // Catch: java.lang.Throwable -> L1442
            int r0 = getIndex(r7, r1)     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.JavaScriptException r1 = new org.mozilla.javascript.JavaScriptException     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.Scriptable r3 = r2.scope     // Catch: java.lang.Throwable -> L1442
            java.lang.Object r3 = org.mozilla.javascript.NativeIterator.getStopIterationObject(r3)     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.InterpreterData r4 = r2.idata     // Catch: java.lang.Throwable -> L1442
            java.lang.String r4 = r4.itsSourceFile     // Catch: java.lang.Throwable -> L1442
            r1.<init>(r3, r4, r0)     // Catch: java.lang.Throwable -> L1442
            r15.returnedException = r1     // Catch: java.lang.Throwable -> L1442
            goto L996
        L1480:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
            org.mozilla.javascript.debug.DebugFrame r0 = r2.debuggerFrame     // Catch: java.lang.Throwable -> L1442
            if (r0 == 0) goto L1558
            r0.onDebuggerStatement(r6)     // Catch: java.lang.Throwable -> L1442
            goto L1558
        L149d:
            r40 = 2
            r8 = r6
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r1 = r32
            r6 = r39
            r25 = r4
            r2.frozen = r1     // Catch: java.lang.Throwable -> L1442
            r0 = r24[r5]     // Catch: java.lang.Throwable -> L1442
            r2.result = r0     // Catch: java.lang.Throwable -> L1442
            r0 = r25[r5]     // Catch: java.lang.Throwable -> L1442
            r2.resultDbl = r0     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.NativeIterator$StopIteration r0 = new org.mozilla.javascript.NativeIterator$StopIteration     // Catch: java.lang.Throwable -> L1442
            java.lang.Object r1 = r2.result     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.UniqueTag r3 = org.mozilla.javascript.UniqueTag.DOUBLE_MARK     // Catch: java.lang.Throwable -> L1442
            if (r1 != r3) goto L14c5
            double r3 = r2.resultDbl     // Catch: java.lang.Throwable -> L1442
            java.lang.Double r1 = java.lang.Double.valueOf(r3)     // Catch: java.lang.Throwable -> L1442
        L14c5:
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L1442
            int r1 = r2.pc     // Catch: java.lang.Throwable -> L1442
            int r1 = getIndex(r7, r1)     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.JavaScriptException r3 = new org.mozilla.javascript.JavaScriptException     // Catch: java.lang.Throwable -> L1442
            org.mozilla.javascript.InterpreterData r4 = r2.idata     // Catch: java.lang.Throwable -> L1442
            java.lang.String r4 = r4.itsSourceFile     // Catch: java.lang.Throwable -> L1442
            r3.<init>(r0, r4, r1)     // Catch: java.lang.Throwable -> L1442
            r15.returnedException = r3     // Catch: java.lang.Throwable -> L1442
            goto L996
        L14db:
            exitFrame(r6, r2, r1)     // Catch: java.lang.Throwable -> L1442
            java.lang.Object r1 = r2.result     // Catch: java.lang.Throwable -> L1442
            double r3 = r2.resultDbl     // Catch: java.lang.Throwable -> L151e
            org.mozilla.javascript.Interpreter$CallFrame r2 = r2.parentFrame     // Catch: java.lang.Throwable -> L14f0
            if (r2 == 0) goto L1518
            boolean r0 = r2.frozen     // Catch: java.lang.Throwable -> L14f0
            if (r0 == 0) goto L1502
            org.mozilla.javascript.Interpreter$CallFrame r0 = r2.cloneFrozen()     // Catch: java.lang.Throwable -> L14f0
            r2 = r0
            goto L1502
        L14f0:
            r0 = move-exception
            r19 = r1
            r20 = r3
            r1 = r6
            r4 = r12
            r5 = r34
            r32 = 1
            r33 = 0
            r3 = r2
        L14fe:
            r2 = r22
            goto L1828
        L1502:
            setCallResult(r2, r1, r3)     // Catch: java.lang.Throwable -> L14f0
            r20 = r3
            r1 = r6
            r0 = r8
            r4 = r12
            r7 = r15
            r5 = r34
            r14 = r36
            r13 = 1
            r15 = 0
            r19 = 0
            r3 = r2
            r2 = r22
            goto L51
        L1518:
            r0 = r1
            r1 = r6
            r2 = r22
            goto L18eb
        L151e:
            r0 = move-exception
            r19 = r1
            goto L1443
        L1523:
            r40 = 2
            r28 = r7
            r29 = r8
            r27 = r9
            r3 = r13
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            r6 = r39
        L1538:
            boolean r0 = r2.frozen     // Catch: java.lang.Throwable -> L1442
            if (r0 != 0) goto L1548
            r0 = -73
            if (r3 != r0) goto L1542
            r13 = 1
            goto L1543
        L1542:
            r13 = 0
        L1543:
            java.lang.Object r0 = freezeGenerator(r6, r2, r5, r15, r13)     // Catch: java.lang.Throwable -> L1442
            return r0
        L1548:
            java.lang.Object r0 = thawGenerator(r2, r5, r15, r3)     // Catch: java.lang.Throwable -> L1442
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND     // Catch: java.lang.Throwable -> L1442
            if (r0 == r1) goto L1558
            r1 = r6
            r4 = r12
            r5 = r34
            r32 = 1
            goto L3f6
        L1558:
            r1 = r6
            r6 = r8
            r23 = r15
            r3 = r24
            r4 = r25
            r9 = r27
            r8 = r29
            r13 = r35
            r14 = r36
            r31 = 0
            r32 = 1
            goto Lb8b
        L156e:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            r34 = r10[r33]     // Catch: java.lang.Throwable -> L1587
            goto L1558
        L1587:
            r0 = move-exception
            r3 = r2
            r1 = r6
            r4 = r12
            r2 = r22
            r5 = r34
            r32 = 1
            goto L1828
        L1593:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            r34 = r10[r32]     // Catch: java.lang.Throwable -> L15bf
        L15ab:
            r1 = r6
        L15ac:
            r6 = r8
            r23 = r15
            r3 = r24
            r4 = r25
        L15b3:
            r9 = r27
            r8 = r29
            r13 = r35
            r14 = r36
            r31 = 0
            goto Lb8b
        L15bf:
            r0 = move-exception
            r3 = r2
            r1 = r6
        L15c2:
            r4 = r12
            goto La11
        L15c5:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            r34 = r10[r40]     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L15de:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            r34 = r10[r26]     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L15f7:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            r1 = r7[r1]     // Catch: java.lang.Throwable -> L15bf
            r1 = r1 & 255(0xff, float:3.57E-43)
            r34 = r10[r1]     // Catch: java.lang.Throwable -> L15bf
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L1618:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            int r0 = getIndex(r7, r1)     // Catch: java.lang.Throwable -> L15bf
            r34 = r10[r0]     // Catch: java.lang.Throwable -> L15bf
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L15bf
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L163c:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            int r0 = getInt(r7, r1)     // Catch: java.lang.Throwable -> L15bf
            r34 = r10[r0]     // Catch: java.lang.Throwable -> L15bf
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L15bf
            int r0 = r0 + r3
            r2.pc = r0     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L165f:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            org.mozilla.javascript.InterpreterData r0 = r2.idata     // Catch: java.lang.Throwable -> L15bf
            java.lang.Object[] r0 = r0.itsTemplateLiterals     // Catch: java.lang.Throwable -> L15bf
            int r5 = r5 + 1
            org.mozilla.javascript.Scriptable r1 = r2.scope     // Catch: java.lang.Throwable -> L15bf
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.getTemplateLiteralCallSite(r6, r1, r0, r8)     // Catch: java.lang.Throwable -> L15bf
            r24[r5] = r0     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L1685:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            r0 = r24[r5]     // Catch: java.lang.Throwable -> L15bf
            if (r0 != r11) goto L16a5
            r0 = r25[r5]     // Catch: java.lang.Throwable -> L15bf
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)     // Catch: java.lang.Throwable -> L15bf
        L16a5:
            int r1 = r5 + (-1)
            int r5 = r5 + (-3)
            r3 = r24[r5]     // Catch: java.lang.Throwable -> L15bf
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> L15bf
            r4 = r25[r1]     // Catch: java.lang.Throwable -> L15bf
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L15bf
            r3[r4] = r0     // Catch: java.lang.Throwable -> L15bf
            r5 = r1
            goto L15ab
        L16b5:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            java.lang.Object[] r0 = r2.stack     // Catch: java.lang.Throwable -> L15bf
            r0 = r0[r5]     // Catch: java.lang.Throwable -> L15bf
            int r5 = r5 + (-1)
            if (r0 == 0) goto L16e1
            boolean r0 = org.mozilla.javascript.Undefined.isUndefined(r0)     // Catch: java.lang.Throwable -> L15bf
            if (r0 != 0) goto L16e1
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L15bf
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L16e1:
            r1 = r6
            goto L1772
        L16e4:
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            r8 = r6
            r6 = r39
            java.lang.Object[] r0 = r2.stack     // Catch: java.lang.Throwable -> L15bf
            r0 = r0[r5]     // Catch: java.lang.Throwable -> L15bf
            int r5 = r5 + (-1)
            if (r0 == 0) goto L1708
            boolean r0 = org.mozilla.javascript.Undefined.isUndefined(r0)     // Catch: java.lang.Throwable -> L15bf
            if (r0 == 0) goto L16e1
        L1708:
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L15bf
            int r0 = r0 + 2
            r2.pc = r0     // Catch: java.lang.Throwable -> L15bf
            goto L15ab
        L1710:
            r28 = r7
            r29 = r8
            r27 = r9
            r7 = r15
            r15 = r23
            r24 = r25
            r40 = 2
            r33 = 0
            r25 = r4
            goto L1339
        L1723:
            org.mozilla.javascript.Interpreter$NewState r0 = doCallByteCode(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L17a7
            r36 = r3
            r8 = r6
            boolean r3 = r0 instanceof org.mozilla.javascript.Interpreter.ContinueLoop     // Catch: java.lang.Throwable -> L1744
            if (r3 == 0) goto L1748
            org.mozilla.javascript.Interpreter$ContinueLoop r0 = (org.mozilla.javascript.Interpreter.ContinueLoop) r0     // Catch: java.lang.Throwable -> L1744
            org.mozilla.javascript.Interpreter$CallFrame r2 = org.mozilla.javascript.Interpreter.ContinueLoop.a(r0)     // Catch: java.lang.Throwable -> L1744
            java.lang.Object[] r3 = r2.stack     // Catch: java.lang.Throwable -> L1744
            double[] r4 = r2.sDbl     // Catch: java.lang.Throwable -> L1744
            int r5 = org.mozilla.javascript.Interpreter.ContinueLoop.c(r0)     // Catch: java.lang.Throwable -> L1744
            int r6 = org.mozilla.javascript.Interpreter.ContinueLoop.b(r0)     // Catch: java.lang.Throwable -> L1744
        L1740:
            r23 = r15
            goto L15b3
        L1744:
            r0 = move-exception
        L1745:
            r3 = r2
            goto L15c2
        L1748:
            boolean r3 = r0 instanceof org.mozilla.javascript.Interpreter.StateContinue     // Catch: java.lang.Throwable -> L1744
            if (r3 == 0) goto L1760
            org.mozilla.javascript.Interpreter$StateContinue r0 = (org.mozilla.javascript.Interpreter.StateContinue) r0     // Catch: java.lang.Throwable -> L1744
            org.mozilla.javascript.Interpreter$CallFrame r3 = org.mozilla.javascript.Interpreter.StateContinue.a(r0)     // Catch: java.lang.Throwable -> L1744
            r0 = r8
            r4 = r12
            r7 = r15
            r2 = r22
            r13 = r32
            r5 = r34
        L175b:
            r14 = r36
            r15 = 0
            goto L51
        L1760:
            boolean r3 = r0 instanceof org.mozilla.javascript.Interpreter.NewThrowable     // Catch: java.lang.Throwable -> L1744
            if (r3 == 0) goto L176f
            org.mozilla.javascript.Interpreter$NewThrowable r0 = (org.mozilla.javascript.Interpreter.NewThrowable) r0     // Catch: java.lang.Throwable -> L1744
            java.lang.Object r0 = org.mozilla.javascript.Interpreter.NewThrowable.a(r0)     // Catch: java.lang.Throwable -> L1744
            r4 = r12
            r5 = r34
            goto L182b
        L176f:
            org.mozilla.javascript.Kit.codeBug()     // Catch: java.lang.Throwable -> L1744
        L1772:
            if (r36 == 0) goto L1779
            r13 = r40
            addInstructionCount(r1, r2, r13)     // Catch: java.lang.Throwable -> L1744
        L1779:
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L1744
            int r0 = getShort(r7, r0)     // Catch: java.lang.Throwable -> L1744
            if (r0 == 0) goto L1789
            int r3 = r2.pc     // Catch: java.lang.Throwable -> L1744
            int r0 = r0 + (-1)
            int r3 = r3 + r0
            r2.pc = r3     // Catch: java.lang.Throwable -> L1744
            goto L179f
        L1789:
            org.mozilla.javascript.InterpreterData r0 = r2.idata     // Catch: java.lang.Throwable -> L1744
            java.util.Map<java.lang.Integer, java.lang.Integer> r0 = r0.longJumps     // Catch: java.lang.Throwable -> L1744
            int r3 = r2.pc     // Catch: java.lang.Throwable -> L1744
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L1744
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L1744
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L1744
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L1744
            r2.pc = r0     // Catch: java.lang.Throwable -> L1744
        L179f:
            if (r36 == 0) goto L15ac
            int r0 = r2.pc     // Catch: java.lang.Throwable -> L1744
            r2.pcPrevBranch = r0     // Catch: java.lang.Throwable -> L1744
            goto L15ac
        L17a7:
            r0 = move-exception
            r36 = r3
            goto L1745
        L17ab:
            r33 = 0
            r1 = r39
            r28 = r7
            r29 = r8
            r27 = r9
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r25 = r4
            r8 = r6
            int r5 = r5 + (-1)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L1744
            r24[r5] = r0     // Catch: java.lang.Throwable -> L1744
            org.mozilla.javascript.ScriptRuntime.throwDeleteOnSuperPropertyNotAllowed()     // Catch: java.lang.Throwable -> L1744
            goto L15ac
        L17ca:
            r1 = r39
            r28 = r7
            r29 = r8
            r36 = r14
            r7 = r15
            r15 = r23
            r24 = r25
            r8 = r6
            r25 = r4
            r30 = r8
            r27 = r9
            r33 = 0
            r23 = r2
            r26 = r5
        L17e4:
            int r5 = doSetConstVar(r23, r24, r25, r26, r27, r28, r29, r30)     // Catch: java.lang.Throwable -> L17f2
            r2 = r23
            r3 = r24
            r4 = r25
            r6 = r30
            goto L1740
        L17f2:
            r0 = move-exception
            r2 = r23
            goto L1745
        L17f7:
            r0 = move-exception
            r33 = 0
            r1 = r39
            r36 = r14
            r15 = r23
            goto L1745
        L1802:
            r0 = move-exception
            r36 = r14
            r15 = r23
            r33 = 0
            goto L1745
        L180b:
            r0 = move-exception
        L180c:
            r36 = r14
            r15 = r23
        L1810:
            r33 = 0
            goto L14fe
        L1814:
            r0 = move-exception
            r32 = r13
            goto L180c
        L1818:
            r0 = move-exception
            r15 = r7
            r32 = r13
            r36 = r14
            goto L1810
        L181f:
            r0 = move-exception
            r15 = r7
            r32 = r13
            r36 = r14
            r41 = 100
            goto L1810
        L1828:
            if (r2 != 0) goto L1922
            r2 = r3
        L182b:
            if (r0 != 0) goto L1830
            org.mozilla.javascript.Kit.codeBug()
        L1830:
            if (r15 == 0) goto L183f
            int r3 = r15.operation
            r13 = 2
            if (r3 != r13) goto L183f
            java.lang.Object r3 = r15.value
            if (r0 != r3) goto L183f
        L183b:
            r10 = r32
        L183d:
            r3 = 0
            goto L1883
        L183f:
            boolean r3 = r0 instanceof org.mozilla.javascript.JavaScriptException
            if (r3 == 0) goto L1846
        L1843:
            r3 = 0
            r10 = 2
            goto L1883
        L1846:
            boolean r3 = r0 instanceof org.mozilla.javascript.EcmaError
            if (r3 == 0) goto L184b
            goto L1843
        L184b:
            boolean r3 = r0 instanceof org.mozilla.javascript.EvaluatorException
            if (r3 == 0) goto L1850
            goto L1843
        L1850:
            boolean r3 = r0 instanceof org.mozilla.javascript.ContinuationPending
            if (r3 == 0) goto L1857
        L1854:
            r10 = r33
            goto L183d
        L1857:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L1865
            r9 = 13
            boolean r3 = r1.hasFeature(r9)
            if (r3 == 0) goto L183b
        L1863:
            r10 = 2
            goto L183d
        L1865:
            r9 = 13
            boolean r3 = r0 instanceof java.lang.Error
            if (r3 == 0) goto L1872
            boolean r3 = r1.hasFeature(r9)
            if (r3 == 0) goto L1854
            goto L1863
        L1872:
            boolean r3 = r0 instanceof org.mozilla.javascript.Interpreter.ContinuationJump
            if (r3 == 0) goto L187c
            r3 = r0
            org.mozilla.javascript.Interpreter$ContinuationJump r3 = (org.mozilla.javascript.Interpreter.ContinuationJump) r3
            r10 = r32
            goto L1883
        L187c:
            boolean r3 = r1.hasFeature(r9)
            if (r3 == 0) goto L183b
            goto L1863
        L1883:
            if (r36 == 0) goto L1894
            r6 = r41
            addInstructionCount(r1, r2, r6)     // Catch: java.lang.Error -> L188b java.lang.RuntimeException -> L1890
            goto L1894
        L188b:
            r0 = move-exception
            r13 = r33
            r3 = 0
            goto L1895
        L1890:
            r0 = move-exception
            r13 = r32
            goto L1895
        L1894:
            r13 = r10
        L1895:
            org.mozilla.javascript.debug.DebugFrame r6 = r2.debuggerFrame
            if (r6 == 0) goto L18ac
            boolean r7 = r0 instanceof java.lang.RuntimeException
            if (r7 == 0) goto L18ac
            r7 = r0
            java.lang.RuntimeException r7 = (java.lang.RuntimeException) r7
            r6.onExceptionThrown(r1, r7)     // Catch: java.lang.Throwable -> L18a4
            goto L18ac
        L18a4:
            r0 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            r13 = r33
            r3 = 0
            goto L18b1
        L18ac:
            r38 = r2
            r2 = r0
            r0 = r38
        L18b1:
            r6 = 2
            if (r13 == 0) goto L18c8
            if (r13 == r6) goto L18b9
            r7 = r32
            goto L18bb
        L18b9:
            r7 = r33
        L18bb:
            int r7 = getExceptionHandler(r0, r7)
            if (r7 < 0) goto L18c8
            r3 = r0
            r0 = r7
            r7 = r15
        L18c4:
            r13 = r32
            goto L175b
        L18c8:
            exitFrame(r1, r0, r2)
            org.mozilla.javascript.Interpreter$CallFrame r0 = r0.parentFrame
            if (r0 != 0) goto L1917
            if (r3 == 0) goto L18e7
            org.mozilla.javascript.Interpreter$CallFrame r6 = r3.branchFrame
            if (r6 == 0) goto L18d8
            org.mozilla.javascript.Kit.codeBug()
        L18d8:
            org.mozilla.javascript.Interpreter$CallFrame r6 = r3.capturedFrame
            if (r6 == 0) goto L18e1
        L18dc:
            r3 = r0
            r7 = r15
            r0 = r18
            goto L18c4
        L18e1:
            java.lang.Object r0 = r3.result
            double r3 = r3.resultDbl
            r2 = 0
            goto L18eb
        L18e7:
            r0 = r19
            r3 = r20
        L18eb:
            java.util.Deque<java.lang.Object> r5 = r1.previousInterpreterInvocations
            if (r5 == 0) goto L18fe
            int r5 = r5.size()
            if (r5 == 0) goto L18fe
            java.util.Deque<java.lang.Object> r5 = r1.previousInterpreterInvocations
            java.lang.Object r5 = r5.pop()
            r1.lastInterpreterFrame = r5
            goto L1903
        L18fe:
            r5 = 0
            r1.lastInterpreterFrame = r5
            r1.previousInterpreterInvocations = r5
        L1903:
            if (r2 == 0) goto L190f
            boolean r0 = r2 instanceof java.lang.RuntimeException
            if (r0 == 0) goto L190c
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            throw r2
        L190c:
            java.lang.Error r2 = (java.lang.Error) r2
            throw r2
        L190f:
            if (r0 == r11) goto L1912
            goto L1916
        L1912:
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)
        L1916:
            return r0
        L1917:
            if (r3 == 0) goto L18b1
            org.mozilla.javascript.Interpreter$CallFrame r7 = r3.branchFrame
            boolean r7 = java.util.Objects.equals(r7, r0)
            if (r7 == 0) goto L18b1
            goto L18dc
        L1922:
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
            defpackage.z20.a()
            r31 = 0
            return r31
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static CallFrame processThrowable(Context context, Object obj, CallFrame callFrame, int i, boolean z) {
        if (i >= 0) {
            if (callFrame.frozen) {
                callFrame = callFrame.cloneFrozen();
            }
            int[] iArr = callFrame.idata.itsExceptionTable;
            int i2 = iArr[i + 2];
            callFrame.pc = i2;
            if (z) {
                callFrame.pcPrevBranch = i2;
            }
            callFrame.savedStackTop = callFrame.emptyStackTop;
            int i3 = callFrame.localShift;
            int i4 = iArr[i + 5] + i3;
            int i5 = i3 + iArr[i + 4];
            Object[] objArr = callFrame.stack;
            callFrame.scope = (Scriptable) objArr[i4];
            objArr[i5] = obj;
        } else {
            ContinuationJump continuationJump = (ContinuationJump) obj;
            if (!Objects.equals(continuationJump.branchFrame, callFrame)) {
                Kit.codeBug();
            }
            if (continuationJump.capturedFrame == null) {
                Kit.codeBug();
            }
            CallFrame callFrame2 = continuationJump.capturedFrame;
            int i6 = callFrame2.frameIndex + 1;
            CallFrame callFrame3 = continuationJump.branchFrame;
            if (callFrame3 != null) {
                i6 -= callFrame3.frameIndex;
            }
            CallFrame[] callFrameArr = null;
            int i7 = 0;
            for (int i8 = 0; i8 != i6; i8++) {
                if (!callFrame2.frozen) {
                    Kit.codeBug();
                }
                if (callFrame2.useActivation) {
                    if (callFrameArr == null) {
                        callFrameArr = new CallFrame[i6 - i8];
                    }
                    callFrameArr[i7] = callFrame2;
                    i7++;
                }
                callFrame2 = callFrame2.parentFrame;
            }
            while (i7 != 0) {
                i7--;
                enterFrame(context, callFrameArr[i7], ScriptRuntime.emptyArgs, true);
            }
            callFrame = continuationJump.capturedFrame.cloneFrozen();
            setCallResult(callFrame, continuationJump.result, continuationJump.resultDbl);
        }
        callFrame.throwable = null;
        return callFrame;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object restartContinuation(NativeContinuation nativeContinuation, Context context, Scriptable scriptable, Object[] objArr) {
        if (!ScriptRuntime.hasTopCall(context)) {
            return ScriptRuntime.doTopCall(nativeContinuation, context, scriptable, null, objArr, context.isTopLevelStrict);
        }
        Object obj = objArr.length == 0 ? Undefined.instance : objArr[0];
        if (((CallFrame) nativeContinuation.getImplementation()) == null) {
            return obj;
        }
        ContinuationJump continuationJump = new ContinuationJump(nativeContinuation, null);
        continuationJump.result = obj;
        return interpretLoop(context, null, continuationJump);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        CallFrame callFrame = (CallFrame) obj;
        GeneratorState generatorState = new GeneratorState(i, obj2);
        if (i == 2) {
            try {
                return interpretLoop(context, callFrame, generatorState);
            } catch (RuntimeException e) {
                if (e == obj2) {
                    return Undefined.instance;
                }
                throw e;
            }
        }
        Object objInterpretLoop = interpretLoop(context, callFrame, generatorState);
        RuntimeException runtimeException = generatorState.returnedException;
        if (runtimeException == null) {
            return objInterpretLoop;
        }
        throw runtimeException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void setCallResult(CallFrame callFrame, Object obj, double d) {
        int i = callFrame.savedCallOp;
        if (i == 43 || i == -85) {
            Object[] objArr = callFrame.stack;
            int i2 = callFrame.savedStackTop;
            objArr[i2] = obj;
            callFrame.sDbl[i2] = d;
        } else if (i != 30) {
            Kit.codeBug();
        } else if (obj instanceof Scriptable) {
            callFrame.stack[callFrame.savedStackTop] = obj;
        }
        callFrame.savedCallOp = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean stack_boolean(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        if (Boolean.TRUE.equals(obj)) {
            return true;
        }
        if (Boolean.FALSE.equals(obj)) {
            return false;
        }
        if (obj == UniqueTag.DOUBLE_MARK) {
            double d = callFrame.sDbl[i];
            return (Double.isNaN(d) || d == 0.0d) ? false : true;
        }
        if (obj == null || obj == Undefined.instance) {
            return false;
        }
        if (obj instanceof BigInteger) {
            return !obj.equals(BigInteger.ZERO);
        }
        if (!(obj instanceof Number)) {
            return ScriptRuntime.toBoolean(obj);
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        return (Double.isNaN(dDoubleValue) || dDoubleValue == 0.0d) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static double stack_double(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        return obj != UniqueTag.DOUBLE_MARK ? ScriptRuntime.toNumber(obj) : callFrame.sDbl[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int stack_int32(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        return obj == UniqueTag.DOUBLE_MARK ? ScriptRuntime.toInt32(callFrame.sDbl[i]) : ScriptRuntime.toInt32(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Number stack_numeric(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        return obj != UniqueTag.DOUBLE_MARK ? ScriptRuntime.toNumeric(obj) : Double.valueOf(callFrame.sDbl[i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object thawGenerator(CallFrame callFrame, int i, GeneratorState generatorState, int i2) {
        callFrame.frozen = false;
        int index = getIndex(callFrame.idata.itsICode, callFrame.pc);
        callFrame.pc += 2;
        int i3 = generatorState.operation;
        if (i3 == 1) {
            return new JavaScriptException(generatorState.value, callFrame.idata.itsSourceFile, index);
        }
        if (i3 == 2) {
            return generatorState.value;
        }
        if (i3 != 0) {
            throw Kit.codeBug();
        }
        if (i2 == 78 || i2 == -73) {
            callFrame.stack[i] = generatorState.value;
        }
        return Scriptable.NOT_FOUND;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        CallFrame[] callFrameArr;
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.lastInterpreterFrame == null) {
            rhinoException.interpreterStackInfo = null;
            rhinoException.interpreterLineData = null;
            return;
        }
        Deque<Object> deque = currentContext.previousInterpreterInvocations;
        if (deque == null || deque.size() == 0) {
            callFrameArr = new CallFrame[1];
        } else {
            int size = currentContext.previousInterpreterInvocations.size();
            if (currentContext.previousInterpreterInvocations.peek() == currentContext.lastInterpreterFrame) {
                size--;
            }
            callFrameArr = new CallFrame[size + 1];
            ArrayList arrayList = new ArrayList(currentContext.previousInterpreterInvocations);
            Collections.reverse(arrayList);
            arrayList.toArray(callFrameArr);
        }
        callFrameArr[callFrameArr.length - 1] = (CallFrame) currentContext.lastInterpreterFrame;
        int i = 0;
        for (int i2 = 0; i2 != callFrameArr.length; i2++) {
            i += callFrameArr[i2].frameIndex + 1;
        }
        int[] iArr = new int[i];
        int length = callFrameArr.length;
        while (length != 0) {
            length--;
            for (CallFrame callFrame = callFrameArr[length]; callFrame != null; callFrame = callFrame.parentFrame) {
                i--;
                iArr[i] = callFrame.pcSourceLineStart;
            }
        }
        if (i != 0) {
            Kit.codeBug();
        }
        rhinoException.interpreterStackInfo = callFrameArr;
        rhinoException.interpreterLineData = iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        InterpreterData interpreterDataCompile = new CodeGenerator().compile(compilerEnvirons, scriptNode, str, z);
        this.itsData = interpreterDataCompile;
        return interpreterDataCompile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (obj != this.itsData) {
            Kit.codeBug();
        }
        return InterpretedFunction.createFunction(context, scriptable, this.itsData, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        if (obj != this.itsData) {
            Kit.codeBug();
        }
        return InterpretedFunction.createScript(this.itsData, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        char cCharAt;
        StringBuilder sb = new StringBuilder(str.length() + 1000);
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        CallFrame[] callFrameArr = (CallFrame[]) rhinoException.interpreterStackInfo;
        int[] iArr = rhinoException.interpreterLineData;
        int length = callFrameArr.length;
        int length2 = iArr.length;
        int i = 0;
        while (length != 0) {
            length--;
            int iIndexOf = str.indexOf("org.mozilla.javascript.Interpreter.interpretLoop", i);
            if (iIndexOf < 0) {
                break;
            }
            int i2 = iIndexOf + 48;
            while (i2 != str.length() && (cCharAt = str.charAt(i2)) != '\n' && cCharAt != '\r') {
                i2++;
            }
            sb.append((CharSequence) str, i, i2);
            for (CallFrame callFrame = callFrameArr[length]; callFrame != null; callFrame = callFrame.parentFrame) {
                if (length2 == 0) {
                    Kit.codeBug();
                }
                length2--;
                InterpreterData interpreterData = callFrame.idata;
                sb.append(systemProperty);
                sb.append("\tat script");
                String str2 = interpreterData.itsName;
                if (str2 != null && str2.length() != 0) {
                    sb.append('.');
                    sb.append(interpreterData.itsName);
                }
                sb.append('(');
                sb.append(interpreterData.itsSourceFile);
                int i3 = iArr[length2];
                if (i3 >= 0) {
                    sb.append(':');
                    sb.append(getIndex(interpreterData.itsICode, i3));
                }
                sb.append(')');
            }
            i = i2;
        }
        sb.append(str.substring(i));
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        ScriptStackElement[][] scriptStackElements = getScriptStackElements(rhinoException);
        ArrayList arrayList = new ArrayList(scriptStackElements.length);
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        for (ScriptStackElement[] scriptStackElementArr : scriptStackElements) {
            StringBuilder sb = new StringBuilder();
            for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
                scriptStackElement.renderJavaStyle(sb);
                sb.append(systemProperty);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ScriptStackElement[][] getScriptStackElements(RhinoException rhinoException) {
        if (rhinoException.interpreterStackInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CallFrame[] callFrameArr = (CallFrame[]) rhinoException.interpreterStackInfo;
        int[] iArr = rhinoException.interpreterLineData;
        int length = callFrameArr.length;
        int length2 = iArr.length;
        while (length != 0) {
            length--;
            CallFrame callFrame = callFrameArr[length];
            ArrayList arrayList2 = new ArrayList();
            while (callFrame != null) {
                if (length2 == 0) {
                    Kit.codeBug();
                }
                length2--;
                InterpreterData interpreterData = callFrame.idata;
                String str = interpreterData.itsSourceFile;
                int i = iArr[length2];
                int index = i >= 0 ? getIndex(interpreterData.itsICode, i) : -1;
                String str2 = interpreterData.itsName;
                String str3 = (str2 == null || str2.length() == 0) ? null : interpreterData.itsName;
                callFrame = callFrame.parentFrame;
                arrayList2.add(new ScriptStackElement(str, str3, index));
            }
            arrayList.add((ScriptStackElement[]) arrayList2.toArray(new ScriptStackElement[0]));
        }
        return (ScriptStackElement[][]) arrayList.toArray(new ScriptStackElement[arrayList.size()][]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        CallFrame callFrame = (CallFrame) context.lastInterpreterFrame;
        InterpreterData interpreterData = callFrame.idata;
        int i = callFrame.pcSourceLineStart;
        if (i >= 0) {
            iArr[0] = getIndex(interpreterData.itsICode, i);
        } else {
            iArr[0] = 0;
        }
        return interpreterData.itsSourceFile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        ((InterpretedFunction) script).idata.evalScriptFlag = true;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class NewState {
        private NewState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CallFrame implements Cloneable, Serializable {
        private static final long serialVersionUID = -2843792508994958978L;
        final DebugFrame debuggerFrame;
        final int emptyStackTop;
        final InterpretedFunction fnOrScript;
        int frameIndex;
        boolean frozen;
        final InterpreterData idata;
        boolean isContinuationsTopFrame;
        final int localShift;
        CallFrame parentFrame;
        int pc;
        int pcPrevBranch;
        int pcSourceLineStart;
        Object result;
        double resultDbl;
        double[] sDbl;
        int savedCallOp;
        int savedStackTop;
        Scriptable scope;
        Object[] stack;
        int[] stackAttributes;
        final Scriptable thisObj;
        Object throwable;
        final boolean useActivation;
        final CallFrame varSource;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CallFrame(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, CallFrame callFrame) {
            InterpreterData interpreterData = interpretedFunction.idata;
            this.idata = interpreterData;
            Debugger debugger = context.debugger;
            DebugFrame frame = debugger != null ? debugger.getFrame(context, interpreterData) : null;
            this.debuggerFrame = frame;
            this.useActivation = frame != null || interpreterData.itsNeedsActivation;
            int i = interpreterData.itsMaxVars;
            int i2 = (interpreterData.itsMaxLocals + i) - 1;
            this.emptyStackTop = i2;
            this.fnOrScript = interpretedFunction;
            this.varSource = this;
            this.localShift = i;
            this.thisObj = scriptable;
            this.parentFrame = callFrame;
            int i3 = callFrame != null ? callFrame.frameIndex + 1 : 0;
            this.frameIndex = i3;
            if (i3 > context.getMaximumInterpreterStackDepth()) {
                throw Context.reportRuntimeError("Exceeded maximum stack depth");
            }
            this.result = Undefined.instance;
            this.pcSourceLineStart = interpreterData.firstLinePC;
            this.savedStackTop = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Boolean b(CallFrame callFrame, Object obj, EqualObjectGraphs equalObjectGraphs) {
            callFrame.getClass();
            return equals(callFrame, (CallFrame) obj, equalObjectGraphs);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public Boolean equalsInTopScope(final Object obj) {
            return (Boolean) EqualObjectGraphs.withThreadLocal(new java.util.function.Function() { // from class: org.mozilla.javascript.d
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return Interpreter.CallFrame.b(this.a, obj, (EqualObjectGraphs) obj2);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private boolean fieldsEqual(CallFrame callFrame, EqualObjectGraphs equalObjectGraphs) {
            return this.frameIndex == callFrame.frameIndex && this.pc == callFrame.pc && Interpreter.compareIdata(this.idata, callFrame.idata) && equalObjectGraphs.equalGraphs(this.varSource.stack, callFrame.varSource.stack) && Arrays.equals(this.varSource.sDbl, callFrame.varSource.sDbl) && equalObjectGraphs.equalGraphs(this.thisObj, callFrame.thisObj) && equalObjectGraphs.equalGraphs(this.fnOrScript, callFrame.fnOrScript) && equalObjectGraphs.equalGraphs(this.scope, callFrame.scope);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private boolean isStrictTopFrame() {
            while (true) {
                CallFrame callFrame = this.parentFrame;
                if (callFrame == null) {
                    return this.idata.isStrict;
                }
                this = callFrame;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CallFrame cloneFrozen() {
            if (!this.frozen) {
                Kit.codeBug();
            }
            try {
                CallFrame callFrame = (CallFrame) clone();
                callFrame.stack = (Object[]) this.stack.clone();
                callFrame.stackAttributes = (int[]) this.stackAttributes.clone();
                callFrame.sDbl = (double[]) this.sDbl.clone();
                callFrame.frozen = false;
                return callFrame;
            } catch (CloneNotSupportedException unused) {
                z20.a();
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object[] ensureStackLength(int i) {
            Object[] objArr = this.stack;
            if (i > objArr.length) {
                this.stack = Arrays.copyOf(objArr, i);
                this.sDbl = Arrays.copyOf(this.sDbl, i);
            }
            return this.stack;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        public boolean equals(final Object obj) {
            if (!(obj instanceof CallFrame)) {
                return false;
            }
            Context contextEnter = Context.enter();
            try {
                if (ScriptRuntime.hasTopCall(contextEnter)) {
                    boolean zBooleanValue = equalsInTopScope(obj).booleanValue();
                    if (contextEnter != null) {
                        contextEnter.close();
                    }
                    return zBooleanValue;
                }
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(this.scope);
                boolean zBooleanValue2 = ((Boolean) ScriptRuntime.doTopCall(new Callable() { // from class: org.mozilla.javascript.e
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // org.mozilla.javascript.Callable
                    public final Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                        return this.f.equalsInTopScope(obj);
                    }
                }, contextEnter, topLevelScope, topLevelScope, ScriptRuntime.emptyArgs, isStrictTopFrame())).booleanValue();
                if (contextEnter != null) {
                    contextEnter.close();
                }
                return zBooleanValue2;
            } finally {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            int iIcodeHashCode = 0;
            int i = 0;
            while (true) {
                iIcodeHashCode = (((iIcodeHashCode * 31) + this.pc) * 31) + this.idata.icodeHashCode();
                this = this.parentFrame;
                if (this == null) {
                    break;
                }
                int i2 = i + 1;
                if (i >= 8) {
                    break;
                }
                i = i2;
            }
            return iIcodeHashCode;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void initializeArgs(Context context, Scriptable scriptable, Object[] objArr, double[] dArr, int i, int i2, Scriptable scriptable2) {
            Object[] objArr2;
            double[] dArr2;
            int i3;
            InterpreterData interpreterData;
            InterpreterData interpreterData2;
            Object[] objArr3;
            if (this.useActivation) {
                if (dArr != null) {
                    objArr = Interpreter.getArgsArray(objArr, dArr, i, i2);
                }
                dArr2 = null;
                objArr2 = objArr;
                i3 = 0;
            } else {
                objArr2 = objArr;
                dArr2 = dArr;
                i3 = i;
            }
            if (this.idata.itsFunctionType != 0) {
                Scriptable parentScope = this.fnOrScript.getParentScope();
                this.scope = parentScope;
                if (this.useActivation) {
                    InterpreterData interpreterData3 = this.idata;
                    int i4 = interpreterData3.itsFunctionType;
                    InterpretedFunction interpretedFunction = this.fnOrScript;
                    if (i4 == 4) {
                        this.scope = ScriptRuntime.createArrowFunctionActivation(interpretedFunction, context, parentScope, objArr2, interpreterData3.isStrict, interpreterData3.argsHasRest, scriptable2);
                    } else {
                        this.scope = ScriptRuntime.createFunctionActivation(interpretedFunction, context, parentScope, objArr2, interpreterData3.isStrict, interpreterData3.argsHasRest, scriptable2);
                    }
                }
            } else {
                this.scope = scriptable;
                InterpretedFunction interpretedFunction2 = this.fnOrScript;
                ScriptRuntime.initScript(interpretedFunction2, this.thisObj, context, scriptable, interpretedFunction2.idata.evalScriptFlag);
            }
            InterpreterData interpreterData4 = this.idata;
            if (interpreterData4.itsNestedFunctions != null) {
                if (interpreterData4.itsFunctionType != 0 && !interpreterData4.itsNeedsActivation) {
                    Kit.codeBug();
                }
                int i5 = 0;
                while (true) {
                    InterpreterData[] interpreterDataArr = this.idata.itsNestedFunctions;
                    if (i5 >= interpreterDataArr.length) {
                        break;
                    }
                    if (interpreterDataArr[i5].itsFunctionType == 1) {
                        Interpreter.initFunction(context, this.scope, this.fnOrScript, i5);
                    }
                    i5++;
                }
            }
            InterpreterData interpreterData5 = this.idata;
            int i6 = interpreterData5.itsMaxFrameArray;
            if (i6 != this.emptyStackTop + interpreterData5.itsMaxStack + 1) {
                Kit.codeBug();
            }
            this.stack = new Object[i6];
            this.stackAttributes = new int[i6];
            this.sDbl = new double[i6];
            int paramAndVarCount = this.idata.getParamAndVarCount();
            int i7 = 0;
            while (true) {
                interpreterData = this.idata;
                if (i7 >= paramAndVarCount) {
                    break;
                }
                if (interpreterData.getParamOrVarConst(i7)) {
                    this.stackAttributes[i7] = 13;
                }
                i7++;
            }
            int i8 = interpreterData.argCount;
            if (i8 > i2) {
                i8 = i2;
            }
            System.arraycopy(objArr2, i3, this.stack, 0, i8);
            if (dArr2 != null) {
                System.arraycopy(dArr2, i3, this.sDbl, 0, i8);
            }
            while (true) {
                interpreterData2 = this.idata;
                if (i8 == interpreterData2.itsMaxVars) {
                    break;
                }
                this.stack[i8] = Undefined.instance;
                i8++;
            }
            if (interpreterData2.argsHasRest) {
                int i9 = interpreterData2.argCount;
                int i10 = i9 - 1;
                if (i2 >= i9) {
                    int i11 = i2 - i10;
                    objArr3 = new Object[i11];
                    int i12 = i3 + i10;
                    for (int i13 = 0; i13 != i11; i13++) {
                        Object objWrapNumber = objArr2[i12];
                        if (objWrapNumber == UniqueTag.DOUBLE_MARK) {
                            objWrapNumber = ScriptRuntime.wrapNumber(dArr2[i12]);
                        }
                        objArr3[i13] = objWrapNumber;
                        i12++;
                    }
                } else {
                    objArr3 = ScriptRuntime.emptyArgs;
                }
                this.stack[i10] = context.newArray(this.scope, objArr3);
            }
        }

        private static Boolean equals(CallFrame callFrame, CallFrame callFrame2, EqualObjectGraphs equalObjectGraphs) {
            while (callFrame != callFrame2) {
                if (callFrame != null && callFrame2 != null) {
                    if (!callFrame.fieldsEqual(callFrame2, equalObjectGraphs)) {
                        return Boolean.FALSE;
                    }
                    callFrame = callFrame.parentFrame;
                    callFrame2 = callFrame2.parentFrame;
                } else {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    public static NativeContinuation captureContinuation(Context context) {
        Object obj = context.lastInterpreterFrame;
        if (obj != null && (obj instanceof CallFrame)) {
            return captureContinuation(context, (CallFrame) obj, true);
        }
        e04.a("Interpreter frames not found");
        return null;
    }
}
