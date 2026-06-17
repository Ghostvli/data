package org.mozilla.javascript.optimizer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import jdk.dynalink.StandardNamespace;
import jdk.dynalink.StandardOperation;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.GuardingDynamicLinker;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.LinkerServices;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class DefaultLinker implements GuardingDynamicLinker {
    static final boolean DEBUG;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        String property = System.getProperty("RHINO_DEBUG_LINKER");
        if (property == null) {
            property = System.getenv("RHINO_DEBUG_LINKER");
        }
        DEBUG = Boolean.parseBoolean(property);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static MethodHandle bindStringParameter(MethodHandles.Lookup lookup, MethodType methodType, Class<?> cls, String str, int i, String str2) {
        return MethodHandles.insertArguments(lookup.findStatic(cls, str, methodType.insertParameterTypes(i, String.class)), i, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private GuardedInvocation getInvocation(MethodHandles.Lookup lookup, MethodType methodType, ParsedOperation parsedOperation) {
        if (parsedOperation.isNamespace(StandardNamespace.PROPERTY)) {
            return getPropertyInvocation(lookup, methodType, parsedOperation);
        }
        if (parsedOperation.isNamespace(RhinoNamespace.NAME)) {
            return getNameInvocation(lookup, methodType, parsedOperation);
        }
        if (parsedOperation.isNamespace(RhinoNamespace.MATH)) {
            return getMathInvocation(lookup, methodType, parsedOperation);
        }
        throw new UnsupportedOperationException(parsedOperation.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private GuardedInvocation getMathInvocation(MethodHandles.Lookup lookup, MethodType methodType, ParsedOperation parsedOperation) {
        MethodHandle methodHandleFindStatic = parsedOperation.isOperation(RhinoOperation.ADD) ? lookup.findStatic(ScriptRuntime.class, "add", methodType) : parsedOperation.isOperation(RhinoOperation.TONUMBER) ? lookup.findStatic(ScriptRuntime.class, "toNumber", methodType) : parsedOperation.isOperation(RhinoOperation.TONUMERIC) ? lookup.findStatic(ScriptRuntime.class, "toNumeric", methodType) : parsedOperation.isOperation(RhinoOperation.TOBOOLEAN) ? lookup.findStatic(ScriptRuntime.class, "toBoolean", methodType) : parsedOperation.isOperation(RhinoOperation.TOINT32) ? lookup.findStatic(ScriptRuntime.class, "toInt32", methodType) : parsedOperation.isOperation(RhinoOperation.TOUINT32) ? lookup.findStatic(ScriptRuntime.class, "toUint32", methodType) : parsedOperation.isOperation(RhinoOperation.EQ) ? lookup.findStatic(ScriptRuntime.class, "eq", methodType) : parsedOperation.isOperation(RhinoOperation.SHALLOWEQ) ? lookup.findStatic(ScriptRuntime.class, "shallowEq", methodType) : parsedOperation.isOperation(RhinoOperation.COMPARE_GT) ? makeCompare(lookup, 16) : parsedOperation.isOperation(RhinoOperation.COMPARE_LT) ? makeCompare(lookup, 14) : parsedOperation.isOperation(RhinoOperation.COMPARE_GE) ? makeCompare(lookup, 17) : parsedOperation.isOperation(RhinoOperation.COMPARE_LE) ? makeCompare(lookup, 15) : null;
        if (methodHandleFindStatic != null) {
            return new GuardedInvocation(methodHandleFindStatic);
        }
        throw new UnsupportedOperationException(parsedOperation.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private GuardedInvocation getNameInvocation(MethodHandles.Lookup lookup, MethodType methodType, ParsedOperation parsedOperation) {
        String name = parsedOperation.getName();
        MethodHandle methodHandlePermuteArguments = parsedOperation.isOperation(RhinoOperation.BIND) ? MethodHandles.permuteArguments(MethodHandles.insertArguments(lookup.findStatic(ScriptRuntime.class, "bind", MethodType.methodType(Scriptable.class, Context.class, Scriptable.class, String.class)), 2, name), methodType, 1, 0) : parsedOperation.isOperation(StandardOperation.GET) ? MethodHandles.permuteArguments(MethodHandles.insertArguments(lookup.findStatic(ScriptRuntime.class, "name", MethodType.methodType(Object.class, Context.class, Scriptable.class, String.class)), 2, name), methodType, 1, 0) : parsedOperation.isOperation(RhinoOperation.GETWITHTHIS) ? MethodHandles.permuteArguments(MethodHandles.insertArguments(lookup.findStatic(ScriptRuntime.class, "getNameFunctionAndThis", MethodType.methodType(Callable.class, String.class, Context.class, Scriptable.class)), 0, name), methodType, 1, 0) : parsedOperation.isOperation(RhinoOperation.GETWITHTHISOPTIONAL) ? MethodHandles.permuteArguments(MethodHandles.insertArguments(lookup.findStatic(ScriptRuntime.class, "getNameFunctionAndThisOptional", MethodType.methodType(Callable.class, String.class, Context.class, Scriptable.class)), 0, name), methodType, 1, 0) : parsedOperation.isOperation(StandardOperation.SET) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "setName", 4, name) : parsedOperation.isOperation(RhinoOperation.SETSTRICT) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "strictSetName", 4, name) : parsedOperation.isOperation(RhinoOperation.SETCONST) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "setConst", 3, name) : null;
        if (methodHandlePermuteArguments != null) {
            return new GuardedInvocation(methodHandlePermuteArguments);
        }
        throw new UnsupportedOperationException(parsedOperation.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private GuardedInvocation getPropertyInvocation(MethodHandles.Lookup lookup, MethodType methodType, ParsedOperation parsedOperation) {
        MethodHandle methodHandleBindStringParameter = parsedOperation.isOperation(StandardOperation.GET) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "getObjectProp", 1, parsedOperation.getName()) : parsedOperation.isOperation(RhinoOperation.GETNOWARN) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "getObjectPropNoWarn", 1, parsedOperation.getName()) : parsedOperation.isOperation(RhinoOperation.GETSUPER) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "getSuperProp", 1, parsedOperation.getName()) : parsedOperation.isOperation(RhinoOperation.GETWITHTHIS) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "getPropFunctionAndThis", 1, parsedOperation.getName()) : parsedOperation.isOperation(RhinoOperation.GETWITHTHISOPTIONAL) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "getPropFunctionAndThisOptional", 1, parsedOperation.getName()) : parsedOperation.isOperation(StandardOperation.SET) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "setObjectProp", 1, parsedOperation.getName()) : parsedOperation.isOperation(RhinoOperation.SETSUPER) ? bindStringParameter(lookup, methodType, ScriptRuntime.class, "setSuperProp", 1, parsedOperation.getName()) : parsedOperation.isOperation(RhinoOperation.GETELEMENT) ? lookup.findStatic(ScriptRuntime.class, "getObjectElem", methodType) : parsedOperation.isOperation(RhinoOperation.GETELEMENTSUPER) ? lookup.findStatic(ScriptRuntime.class, "getSuperElem", methodType) : parsedOperation.isOperation(RhinoOperation.GETINDEX) ? lookup.findStatic(ScriptRuntime.class, "getObjectIndex", methodType) : parsedOperation.isOperation(RhinoOperation.SETELEMENT) ? lookup.findStatic(ScriptRuntime.class, "setObjectElem", methodType) : parsedOperation.isOperation(RhinoOperation.SETELEMENTSUPER) ? lookup.findStatic(ScriptRuntime.class, "setSuperElem", methodType) : parsedOperation.isOperation(RhinoOperation.SETINDEX) ? lookup.findStatic(ScriptRuntime.class, "setObjectIndex", methodType) : null;
        if (methodHandleBindStringParameter != null) {
            return new GuardedInvocation(methodHandleBindStringParameter);
        }
        throw new UnsupportedOperationException(parsedOperation.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private MethodHandle makeCompare(MethodHandles.Lookup lookup, int i) {
        return MethodHandles.insertArguments(lookup.findStatic(ScriptRuntime.class, "compare", MethodType.methodType(Boolean.TYPE, Object.class, Object.class, Integer.TYPE)), 2, Integer.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GuardedInvocation getGuardedInvocation(LinkRequest linkRequest, LinkerServices linkerServices) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = linkRequest.getCallSiteDescriptor().getMethodType();
        ParsedOperation parsedOperation = new ParsedOperation(linkRequest.getCallSiteDescriptor().getOperation());
        GuardedInvocation invocation = getInvocation(lookup, methodType, parsedOperation);
        if (DEBUG) {
            String simpleName = linkRequest.getReceiver() == null ? "null" : linkRequest.getReceiver().getClass().getSimpleName();
            String simpleName2 = (linkRequest.getArguments().length <= 1 || linkRequest.getArguments()[1] == null) ? "" : linkRequest.getArguments()[1].getClass().getSimpleName();
            System.out.println(String.valueOf(parsedOperation) + "(" + simpleName + ", " + simpleName2 + "): default link");
        }
        return invocation;
    }
}
