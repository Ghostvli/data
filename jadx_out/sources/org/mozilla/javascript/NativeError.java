package org.mozilla.javascript;

import defpackage.jl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final class NativeError extends IdScriptableObject {
    private static final int ConstructorId_captureStackTrace = -1;
    public static final int DEFAULT_STACK_LIMIT = -1;
    private static final Object ERROR_TAG = "Error";
    private static final int Id_constructor = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final String STACK_HIDE_KEY = "_stackHide";
    private static final String STACK_TAG = "stack";
    private static final long serialVersionUID = -5338413581437645187L;
    private Object stack;
    private RhinoException stackProvider;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ProtoProps implements Serializable {
        static final String KEY = "_ErrorPrototypeProps";
        private static final long serialVersionUID = 1907180507775337939L;
        Function prepareStackTrace;
        int stackTraceLimit;

        private ProtoProps() {
            this.stackTraceLimit = -1;
        }

        public Object getPrepareStackTrace() {
            Function function = this.prepareStackTrace;
            return function == null ? Undefined.instance : function;
        }

        public Object getStackTraceLimit() {
            int i = this.stackTraceLimit;
            return i >= 0 ? Integer.valueOf(i) : Double.valueOf(Double.POSITIVE_INFINITY);
        }

        public void setPrepareStackTrace(Object obj) {
            if (obj == null || Undefined.isUndefined(obj)) {
                this.prepareStackTrace = null;
            } else if (obj instanceof Function) {
                this.prepareStackTrace = (Function) obj;
            }
        }

        public void setStackTraceLimit(Object obj) {
            double number = Context.toNumber(obj);
            if (Double.isNaN(number) || Double.isInfinite(number)) {
                this.stackTraceLimit = -1;
            } else {
                this.stackTraceLimit = (int) number;
            }
        }
    }

    private Object callPrepareStack(Function function, ScriptStackElement[] scriptStackElementArr) {
        Context currentContext = Context.getCurrentContext();
        Object[] objArr = new Object[scriptStackElementArr.length];
        for (int i = 0; i < scriptStackElementArr.length; i++) {
            NativeCallSite nativeCallSite = (NativeCallSite) currentContext.newObject(this, "CallSite");
            nativeCallSite.setElement(scriptStackElementArr[i]);
            objArr[i] = nativeCallSite;
        }
        return function.call(currentContext, function, this, new Object[]{this, currentContext.newArray(this, objArr)});
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeError nativeError = new NativeError();
        ScriptableObject.putProperty(nativeError, "name", "Error");
        ScriptableObject.putProperty(nativeError, "message", "");
        ScriptableObject.putProperty(nativeError, "fileName", "");
        ScriptableObject.putProperty((Scriptable) nativeError, "lineNumber", (Object) 0);
        nativeError.setAttributes("name", 2);
        nativeError.setAttributes("message", 2);
        nativeError.exportAsJSClass(3, scriptable, z);
        NativeCallSite.init(nativeError, z);
    }

    public static void installCause(NativeObject nativeObject, NativeError nativeError) {
        Object property = ScriptableObject.getProperty(nativeObject, "cause");
        if (property != Scriptable.NOT_FOUND) {
            ScriptableObject.putProperty(nativeError, "cause", property);
            nativeError.setAttributes("cause", 2);
        }
    }

    private static void js_captureStackTrace(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        ScriptableObject scriptableObject = (ScriptableObject) ScriptRuntime.toObject(context, scriptable, objArr[0]);
        Scriptable scriptable3 = objArr.length > 1 ? (Function) ScriptRuntime.toObjectOrNull(context, objArr[1], scriptable) : null;
        NativeError nativeError = (NativeError) context.newObject(scriptable2, "Error");
        nativeError.setStackProvider(new EvaluatorException("[object Object]"));
        if (scriptable3 != null && (obj = scriptable3.get("name", scriptable3)) != null && !Undefined.isUndefined(obj)) {
            nativeError.associateValue(STACK_HIDE_KEY, Context.toString(obj));
        }
        scriptableObject.defineProperty(STACK_TAG, nativeError.get(STACK_TAG), 2);
    }

    private static String js_toSource(Context context, Scriptable scriptable, Scriptable scriptable2) {
        int int32;
        Object property = ScriptableObject.getProperty(scriptable2, "name");
        Object property2 = ScriptableObject.getProperty(scriptable2, "message");
        Object property3 = ScriptableObject.getProperty(scriptable2, "fileName");
        Object property4 = ScriptableObject.getProperty(scriptable2, "lineNumber");
        StringBuilder sb = new StringBuilder("(new ");
        Object obj = Scriptable.NOT_FOUND;
        if (property == obj) {
            property = Undefined.instance;
        }
        sb.append(ScriptRuntime.toString(property));
        sb.append("(");
        if (property2 != obj || property3 != obj || property4 != obj) {
            if (property2 == obj) {
                property2 = "";
            }
            sb.append(ScriptRuntime.uneval(context, scriptable, property2));
            if (property3 != obj || property4 != obj) {
                sb.append(", ");
                if (property3 == obj) {
                    property3 = "";
                }
                sb.append(ScriptRuntime.uneval(context, scriptable, property3));
                if (property4 != obj && (int32 = ScriptRuntime.toInt32(property4)) != 0) {
                    sb.append(", ");
                    sb.append(ScriptRuntime.toString(int32));
                }
            }
        }
        sb.append("))");
        return sb.toString();
    }

    private static Object js_toString(Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(scriptable, "name");
        Object obj = Scriptable.NOT_FOUND;
        String string = (property == obj || Undefined.isUndefined(property)) ? "Error" : ScriptRuntime.toString(property);
        Object property2 = ScriptableObject.getProperty(scriptable, "message");
        String string2 = (property2 == obj || Undefined.isUndefined(property2)) ? "" : ScriptRuntime.toString(property2);
        if (string.isEmpty()) {
            return string2;
        }
        if (string2.isEmpty()) {
            return string;
        }
        return string + ": " + string2;
    }

    public static NativeError make(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        NativeError nativeErrorMakeProto = makeProto(scriptable, idFunctionObject);
        int length = objArr.length;
        if (length >= 1) {
            if (!Undefined.isUndefined(objArr[0])) {
                ScriptableObject.putProperty(nativeErrorMakeProto, "message", ScriptRuntime.toString(objArr[0]));
                nativeErrorMakeProto.setAttributes("message", 2);
            }
            if (length >= 2) {
                Object obj = objArr[1];
                if (obj instanceof NativeObject) {
                    installCause((NativeObject) obj, nativeErrorMakeProto);
                } else {
                    ScriptableObject.putProperty(nativeErrorMakeProto, "fileName", ScriptRuntime.toString(obj));
                    if (length >= 3) {
                        ScriptableObject.putProperty(nativeErrorMakeProto, "lineNumber", Integer.valueOf(ScriptRuntime.toInt32(objArr[2])));
                    }
                }
            }
        }
        nativeErrorMakeProto.setStackProvider(new EvaluatorException(""));
        return nativeErrorMakeProto;
    }

    public static NativeError makeAggregate(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        NativeError nativeErrorMakeProto = makeProto(scriptable, idFunctionObject);
        int length = objArr.length;
        if (length < 1) {
            throw ScriptRuntime.typeErrorById("msg.iterable.expected", new Object[0]);
        }
        if (length >= 2) {
            if (!Undefined.isUndefined(objArr[1])) {
                ScriptableObject.putProperty(nativeErrorMakeProto, "message", ScriptRuntime.toString(objArr[1]));
                nativeErrorMakeProto.setAttributes("message", 2);
            }
            if (length >= 3) {
                Object obj = objArr[2];
                if (obj instanceof NativeObject) {
                    installCause((NativeObject) obj, nativeErrorMakeProto);
                } else {
                    ScriptableObject.putProperty(nativeErrorMakeProto, "fileName", ScriptRuntime.toString(obj));
                    if (length >= 4) {
                        ScriptableObject.putProperty(nativeErrorMakeProto, "lineNumber", Integer.valueOf(ScriptRuntime.toInt32(objArr[3])));
                    }
                }
            }
        }
        IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, ScriptRuntime.callIterator(objArr[0], context, scriptable));
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = iteratorLikeIterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            nativeErrorMakeProto.defineProperty("errors", context.newArray(scriptable, arrayList.toArray()), 2);
            iteratorLikeIterable.close();
            nativeErrorMakeProto.setStackProvider(new EvaluatorException(""));
            return nativeErrorMakeProto;
        } catch (Throwable th) {
            try {
                iteratorLikeIterable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static NativeError makeProto(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        Scriptable scriptable2 = (Scriptable) idFunctionObject.get("prototype", idFunctionObject);
        NativeError nativeError = new NativeError();
        nativeError.setPrototype(scriptable2);
        nativeError.setParentScope(scriptable);
        return nativeError;
    }

    private static NativeError realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        return (NativeError) IdScriptableObject.ensureType(scriptable, NativeError.class, idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ERROR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == -1) {
            js_captureStackTrace(context, scriptable, scriptable2, objArr);
            return Undefined.instance;
        }
        if (iMethodId == 1) {
            return make(context, scriptable, idFunctionObject, objArr);
        }
        if (iMethodId == 2) {
            return (scriptable2 == scriptable || !(scriptable2 instanceof NativeObject)) ? js_toString(realThis(scriptable2, idFunctionObject)) : js_toString(scriptable2);
        }
        if (iMethodId == 3) {
            return js_toSource(context, scriptable, scriptable2);
        }
        jl.a(String.valueOf(iMethodId));
        return null;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, ERROR_TAG, -1, "captureStackTrace", 2);
        final ProtoProps protoProps = new ProtoProps();
        associateValue("_ErrorPrototypeProps", protoProps);
        idFunctionObject.defineProperty("stackTraceLimit", new Supplier() { // from class: org.mozilla.javascript.i
            @Override // java.util.function.Supplier
            public final Object get() {
                return protoProps.getStackTraceLimit();
            }
        }, new Consumer() { // from class: org.mozilla.javascript.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                protoProps.setStackTraceLimit(obj);
            }
        }, 0);
        idFunctionObject.defineProperty("prepareStackTrace", new Supplier() { // from class: org.mozilla.javascript.k
            @Override // java.util.function.Supplier
            public final Object get() {
                return protoProps.getPrepareStackTrace();
            }
        }, new Consumer() { // from class: org.mozilla.javascript.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                protoProps.setPrepareStackTrace(obj);
            }
        }, 0);
        super.fillConstructorProperties(idFunctionObject);
    }

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
            default:
                return 0;
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Error";
    }

    public Object getStackDelegated() {
        int i;
        Function function;
        Object obj = this.stack;
        if (obj != null) {
            return obj;
        }
        if (this.stackProvider == null) {
            return Scriptable.NOT_FOUND;
        }
        ProtoProps protoProps = (ProtoProps) ((NativeError) getPrototype()).getAssociatedValue("_ErrorPrototypeProps");
        if (protoProps != null) {
            i = protoProps.stackTraceLimit;
            function = protoProps.prepareStackTrace;
        } else {
            i = -1;
            function = null;
        }
        ScriptStackElement[] scriptStack = this.stackProvider.getScriptStack(i, (String) getAssociatedValue(STACK_HIDE_KEY));
        Object stackTrace = function == null ? RhinoException.formatStackTrace(scriptStack, this.stackProvider.details()) : callPrepareStack(function, scriptStack);
        this.stack = stackTrace;
        return stackTrace;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        int i2;
        String str;
        if (i != 1) {
            i2 = 0;
            if (i == 2) {
                str = "toString";
            } else {
                if (i != 3) {
                    jl.a(String.valueOf(i));
                    return;
                }
                str = "toSource";
            }
        } else {
            i2 = 1;
            str = "constructor";
        }
        initPrototypeMethod(ERROR_TAG, i, str, i2);
    }

    public void setStackDelegated(Object obj) {
        this.stackProvider = null;
        this.stack = obj;
    }

    public void setStackProvider(RhinoException rhinoException) {
        if (this.stackProvider == null) {
            defineProperty(STACK_TAG, new Supplier() { // from class: org.mozilla.javascript.g
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.a.getStackDelegated();
                }
            }, new Consumer() { // from class: org.mozilla.javascript.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.setStackDelegated(obj);
                }
            }, 2);
        }
        this.stackProvider = rhinoException;
    }

    public String toString() {
        Object objJs_toString = js_toString(this);
        return objJs_toString instanceof String ? (String) objJs_toString : super.toString();
    }
}
