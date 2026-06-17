package org.mozilla.javascript.optimizer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.LinkerServices;
import jdk.dynalink.linker.TypeBasedGuardingDynamicLinker;
import jdk.dynalink.linker.support.Guards;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class DoubleLinker implements TypeBasedGuardingDynamicLinker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object add(Object obj, Object obj2, Context context) {
        return Double.valueOf(((Double) obj).doubleValue() + ((Double) obj2).doubleValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object addInt(Object obj, Object obj2, Context context) {
        return Double.valueOf(((Double) obj).doubleValue() + ((double) ((Integer) obj2).intValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareGE(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() >= ((Double) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareGEInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() >= ((Integer) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareGT(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() > ((Double) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareGTInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() > ((Integer) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareLE(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() <= ((Double) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareLEInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() <= ((Integer) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareLT(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() < ((Double) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean compareLTInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() < ((Integer) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean eq(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() == ((Double) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean eqInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() == ((Integer) obj2).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean testAdd(Object obj, Object obj2, Context context) {
        return (obj instanceof Double) && (obj2 instanceof Double);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean testAddInt(Object obj, Object obj2, Context context) {
        return (obj instanceof Double) && (obj2 instanceof Integer);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean testTwo(Object obj, Object obj2) {
        return (obj instanceof Double) && (obj2 instanceof Double);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean testTwoInt(Object obj, Object obj2) {
        return (obj instanceof Double) && (obj2 instanceof Integer);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean toBoolean(Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        return (Double.isNaN(dDoubleValue) || dDoubleValue == 0.0d) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int toInt32(Object obj) {
        return ScriptRuntime.toInt32(((Double) obj).doubleValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static double toNumber(Object obj) {
        return ((Double) obj).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Number toNumeric(Object obj) {
        return (Double) obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static long toUint32(Object obj) {
        return ScriptRuntime.toUint32(((Double) obj).doubleValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean canLinkType(Class<?> cls) {
        return Double.class.equals(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuardedInvocation getGuardedInvocation(LinkRequest linkRequest, LinkerServices linkerServices) throws IllegalAccessException, NoSuchMethodException {
        MethodHandle methodHandleFindStatic;
        MethodHandle instanceOfGuard;
        if (linkRequest.isCallSiteUnstable()) {
            return null;
        }
        ParsedOperation parsedOperation = new ParsedOperation(linkRequest.getCallSiteDescriptor().getOperation());
        if (parsedOperation.isNamespace(RhinoNamespace.MATH)) {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodType methodType = linkRequest.getCallSiteDescriptor().getMethodType();
            Object obj = linkRequest.getArguments().length > 1 ? linkRequest.getArguments()[1] : null;
            RhinoOperation rhinoOperation = RhinoOperation.ADD;
            boolean zIsOperation = parsedOperation.isOperation(rhinoOperation);
            Class<?> cls = Boolean.TYPE;
            if (zIsOperation && (obj instanceof Double)) {
                methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "add", methodType);
                instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testAdd", methodType.changeReturnType(cls));
            } else if (parsedOperation.isOperation(rhinoOperation) && (obj instanceof Integer)) {
                methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "addInt", methodType);
                instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testAddInt", methodType.changeReturnType(cls));
            } else {
                RhinoOperation rhinoOperation2 = RhinoOperation.EQ;
                RhinoOperation rhinoOperation3 = RhinoOperation.SHALLOWEQ;
                if (parsedOperation.isOperation(rhinoOperation2, rhinoOperation3) && (obj instanceof Double)) {
                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "eq", methodType);
                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwo", methodType);
                } else if (parsedOperation.isOperation(rhinoOperation2, rhinoOperation3) && (obj instanceof Integer)) {
                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "eqInt", methodType);
                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwoInt", methodType);
                } else {
                    RhinoOperation rhinoOperation4 = RhinoOperation.COMPARE_LT;
                    if (parsedOperation.isOperation(rhinoOperation4) && (obj instanceof Double)) {
                        methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareLT", methodType);
                        instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwo", methodType);
                    } else {
                        RhinoOperation rhinoOperation5 = RhinoOperation.COMPARE_GT;
                        if (parsedOperation.isOperation(rhinoOperation5) && (obj instanceof Double)) {
                            methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareGT", methodType);
                            instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwo", methodType);
                        } else {
                            RhinoOperation rhinoOperation6 = RhinoOperation.COMPARE_LE;
                            if (parsedOperation.isOperation(rhinoOperation6) && (obj instanceof Double)) {
                                methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareLE", methodType);
                                instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwo", methodType);
                            } else {
                                RhinoOperation rhinoOperation7 = RhinoOperation.COMPARE_GE;
                                if (parsedOperation.isOperation(rhinoOperation7) && (obj instanceof Double)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareGE", methodType);
                                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwo", methodType);
                                } else if (parsedOperation.isOperation(rhinoOperation4) && (obj instanceof Integer)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareLTInt", methodType);
                                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwoInt", methodType);
                                } else if (parsedOperation.isOperation(rhinoOperation5) && (obj instanceof Integer)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareGTInt", methodType);
                                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwoInt", methodType);
                                } else if (parsedOperation.isOperation(rhinoOperation6) && (obj instanceof Integer)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareLEInt", methodType);
                                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwoInt", methodType);
                                } else if (parsedOperation.isOperation(rhinoOperation7) && (obj instanceof Integer)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "compareGEInt", methodType);
                                    instanceOfGuard = lookup.findStatic(DoubleLinker.class, "testTwoInt", methodType);
                                } else if (parsedOperation.isOperation(RhinoOperation.TOBOOLEAN)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "toBoolean", methodType);
                                    instanceOfGuard = Guards.getInstanceOfGuard(Double.class);
                                } else if (parsedOperation.isOperation(RhinoOperation.TONUMBER)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "toNumber", methodType);
                                    instanceOfGuard = Guards.getInstanceOfGuard(Double.class);
                                } else if (parsedOperation.isOperation(RhinoOperation.TONUMERIC)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "toNumeric", methodType);
                                    instanceOfGuard = Guards.getInstanceOfGuard(Double.class);
                                } else if (parsedOperation.isOperation(RhinoOperation.TOINT32)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "toInt32", methodType);
                                    instanceOfGuard = Guards.getInstanceOfGuard(Double.class);
                                } else if (parsedOperation.isOperation(RhinoOperation.TOUINT32)) {
                                    methodHandleFindStatic = lookup.findStatic(DoubleLinker.class, "toUint32", methodType);
                                    instanceOfGuard = Guards.getInstanceOfGuard(Double.class);
                                } else {
                                    methodHandleFindStatic = null;
                                    instanceOfGuard = null;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (methodHandleFindStatic == null) {
            return null;
        }
        if (DefaultLinker.DEBUG) {
            System.out.println(String.valueOf(parsedOperation).concat(" double operation"));
        }
        return new GuardedInvocation(methodHandleFindStatic, instanceOfGuard);
    }
}
