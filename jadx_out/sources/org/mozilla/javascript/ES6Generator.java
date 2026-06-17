package org.mozilla.javascript;

import defpackage.jl;
import java.util.Objects;
import org.mozilla.javascript.NativeGenerator;
import org.mozilla.javascript.NativeIterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ES6Generator extends IdScriptableObject {
    private static final Object GENERATOR_TAG = "Generator";
    private static final int Id_next = 1;
    private static final int Id_return = 2;
    private static final int Id_throw = 3;
    private static final int MAX_PROTOTYPE_ID = 4;
    private static final int SymbolId_iterator = 4;
    private static final long serialVersionUID = 1645892441041347273L;
    private Object delegee;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private Object savedState;
    private State state = State.SUSPENDED_START;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum State {
        SUSPENDED_START,
        SUSPENDED_YIELD,
        EXECUTING,
        COMPLETED
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class YieldStarResult {
        private Object result;

        public YieldStarResult(Object obj) {
            this.result = obj;
        }

        public Object getResult() {
            return this.result;
        }
    }

    public ES6Generator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((ES6Generator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }

    private Object callReturnOptionally(Context context, Scriptable scriptable, Object obj) {
        Object obj2 = Undefined.instance;
        Object[] objArr = obj2.equals(obj) ? ScriptRuntime.emptyArgs : new Object[]{obj};
        Object objectPropNoWarn = ScriptRuntime.getObjectPropNoWarn(this.delegee, "return", context, scriptable);
        if (obj2.equals(objectPropNoWarn)) {
            return null;
        }
        if (objectPropNoWarn instanceof Callable) {
            return ((Callable) objectPropNoWarn).call(context, scriptable, ScriptableObject.ensureScriptable(this.delegee), objArr);
        }
        throw ScriptRuntime.typeErrorById("msg.isnt.function", "return", ScriptRuntime.typeof(objectPropNoWarn));
    }

    public static ES6Generator init(ScriptableObject scriptableObject, boolean z) {
        ES6Generator eS6Generator = new ES6Generator();
        if (scriptableObject != null) {
            eS6Generator.setParentScope(scriptableObject);
            eS6Generator.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        eS6Generator.activatePrototypeMap(4);
        if (z) {
            eS6Generator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, eS6Generator);
        }
        return eS6Generator;
    }

    private Scriptable resumeAbruptLocal(Context context, Scriptable scriptable, int i, Object obj) {
        Object objWrapException;
        Object obj2;
        State state = this.state;
        State state2 = State.EXECUTING;
        if (state == state2) {
            throw ScriptRuntime.typeErrorById("msg.generator.executing", new Object[0]);
        }
        if (state == State.SUSPENDED_START) {
            this.state = State.COMPLETED;
        }
        Scriptable scriptableMakeIteratorResult = ES6Iterator.makeIteratorResult(context, scriptable, Boolean.FALSE);
        State state3 = this.state;
        State state4 = State.COMPLETED;
        if (state3 == state4) {
            if (i == 1) {
                throw new JavaScriptException(obj, this.lineSource, this.lineNumber);
            }
            ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
            return scriptableMakeIteratorResult;
        }
        this.state = state2;
        if (i == 2) {
            if (!(obj instanceof NativeGenerator.GeneratorClosedException)) {
                objWrapException = new NativeGenerator.GeneratorClosedException();
                obj2 = objWrapException;
            }
            obj2 = obj;
        } else {
            if (obj instanceof JavaScriptException) {
                objWrapException = ((JavaScriptException) obj).getValue();
            } else {
                if (obj instanceof RhinoException) {
                    objWrapException = ScriptRuntime.wrapException((Throwable) obj, scriptable, context);
                }
                obj2 = obj;
            }
            obj2 = objWrapException;
        }
        try {
            try {
                try {
                    ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.VALUE_PROPERTY, this.function.resumeGenerator(context, scriptable, i, this.savedState, obj2));
                    State state5 = State.SUSPENDED_YIELD;
                    this.state = state5;
                    if (state5 == state4) {
                        this.delegee = null;
                        ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                        return scriptableMakeIteratorResult;
                    }
                } catch (NativeGenerator.GeneratorClosedException unused) {
                    this.state = State.COMPLETED;
                    this.delegee = null;
                    ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                    return scriptableMakeIteratorResult;
                }
            } catch (JavaScriptException e) {
                State state6 = State.COMPLETED;
                this.state = state6;
                if (!(e.getValue() instanceof NativeIterator.StopIteration)) {
                    this.lineNumber = e.lineNumber();
                    this.lineSource = e.lineSource();
                    if (e.getValue() instanceof RhinoException) {
                        throw ((RhinoException) e.getValue());
                    }
                    throw e;
                }
                ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.VALUE_PROPERTY, ((NativeIterator.StopIteration) e.getValue()).getValue());
                if (this.state == state6) {
                    this.delegee = null;
                    ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                }
            } catch (RhinoException e2) {
                this.state = State.COMPLETED;
                this.lineNumber = e2.lineNumber();
                this.lineSource = e2.lineSource();
                throw e2;
            }
            return scriptableMakeIteratorResult;
        } finally {
        }
    }

    private Scriptable resumeDelegee(Context context, Scriptable scriptable, Object obj) {
        try {
            Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(ScriptRuntime.getPropFunctionAndThis(this.delegee, ES6Iterator.NEXT_METHOD, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), Undefined.instance.equals(obj) ? ScriptRuntime.emptyArgs : new Object[]{obj}));
            if (!ScriptRuntime.isIteratorDone(context, scriptableEnsureScriptable)) {
                return scriptableEnsureScriptable;
            }
            this.delegee = null;
            return resumeLocal(context, scriptable, ScriptableObject.getProperty(scriptableEnsureScriptable, ES6Iterator.VALUE_PROPERTY));
        } catch (RhinoException e) {
            this.delegee = null;
            return this.resumeAbruptLocal(context, scriptable, 1, e);
        }
    }

    private Scriptable resumeDelegeeReturn(Context context, Scriptable scriptable, Object obj) {
        try {
            Object objCallReturnOptionally = callReturnOptionally(context, scriptable, obj);
            if (objCallReturnOptionally == null) {
                this.delegee = null;
                return resumeAbruptLocal(context, scriptable, 2, obj);
            }
            if (!ScriptRuntime.isIteratorDone(context, objCallReturnOptionally)) {
                return ScriptableObject.ensureScriptable(objCallReturnOptionally);
            }
            this.delegee = null;
            return resumeAbruptLocal(context, scriptable, 2, ScriptRuntime.getObjectPropNoWarn(objCallReturnOptionally, ES6Iterator.VALUE_PROPERTY, context, scriptable));
        } catch (RhinoException e) {
            this.delegee = null;
            return resumeAbruptLocal(context, scriptable, 1, e);
        }
    }

    private Scriptable resumeDelegeeThrow(Context context, Scriptable scriptable, Object obj) {
        boolean z = false;
        try {
            Object objCall = ScriptRuntime.getPropFunctionAndThis(this.delegee, "throw", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{obj});
            if (!ScriptRuntime.isIteratorDone(context, objCall)) {
                return ScriptableObject.ensureScriptable(objCall);
            }
            try {
                try {
                    callReturnOptionally(context, scriptable, Undefined.instance);
                    this.delegee = null;
                    return resumeLocal(context, scriptable, ScriptRuntime.getObjectProp(objCall, ES6Iterator.VALUE_PROPERTY, context, scriptable));
                } finally {
                }
            } catch (RhinoException e) {
                e = e;
                z = true;
            }
        } catch (RhinoException e2) {
            e = e2;
        }
        if (!z) {
            try {
                this.callReturnOptionally(context, scriptable, Undefined.instance);
            } catch (RhinoException e3) {
                return this.resumeAbruptLocal(context, scriptable, 1, e3);
            } finally {
            }
        }
        this.delegee = null;
        return this.resumeAbruptLocal(context, scriptable, 1, e);
    }

    private Scriptable resumeLocal(Context context, Scriptable scriptable, Object obj) {
        State state = this.state;
        State state2 = State.COMPLETED;
        if (state == state2) {
            return ES6Iterator.makeIteratorResult(context, scriptable, Boolean.TRUE);
        }
        State state3 = State.EXECUTING;
        if (state == state3) {
            throw ScriptRuntime.typeErrorById("msg.generator.executing", new Object[0]);
        }
        Scriptable scriptableMakeIteratorResult = ES6Iterator.makeIteratorResult(context, scriptable, Boolean.FALSE);
        this.state = state3;
        try {
            try {
                try {
                    Object objResumeGenerator = this.function.resumeGenerator(context, scriptable, 0, this.savedState, obj);
                    if (!(objResumeGenerator instanceof YieldStarResult)) {
                        ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.VALUE_PROPERTY, objResumeGenerator);
                        if (this.state == state2) {
                            ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                            return scriptableMakeIteratorResult;
                        }
                        this.state = State.SUSPENDED_YIELD;
                        return scriptableMakeIteratorResult;
                    }
                    State state4 = State.SUSPENDED_YIELD;
                    this.state = state4;
                    try {
                        this.delegee = ScriptRuntime.callIterator(((YieldStarResult) objResumeGenerator).getResult(), context, scriptable);
                        try {
                            Scriptable scriptableResumeDelegee = resumeDelegee(context, scriptable, Undefined.instance);
                            this.state = state3;
                            if (ScriptRuntime.isIteratorDone(context, scriptableResumeDelegee)) {
                                this.state = state2;
                            }
                            if (this.state == state2) {
                                ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                                return scriptableResumeDelegee;
                            }
                            this.state = state4;
                            return scriptableResumeDelegee;
                        } catch (Throwable th) {
                            this.state = State.EXECUTING;
                            throw th;
                        }
                    } catch (RhinoException e) {
                        Scriptable scriptableResumeAbruptLocal = resumeAbruptLocal(context, scriptable, 1, e);
                        if (this.state == State.COMPLETED) {
                            ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                        } else {
                            this.state = State.SUSPENDED_YIELD;
                        }
                        return scriptableResumeAbruptLocal;
                    }
                } catch (NativeGenerator.GeneratorClosedException unused) {
                    this.state = State.COMPLETED;
                    ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                    return scriptableMakeIteratorResult;
                }
            } catch (JavaScriptException e2) {
                State state5 = State.COMPLETED;
                this.state = state5;
                if (e2.getValue() instanceof NativeIterator.StopIteration) {
                    ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.VALUE_PROPERTY, ((NativeIterator.StopIteration) e2.getValue()).getValue());
                    if (this.state == state5) {
                        ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                    } else {
                        this.state = State.SUSPENDED_YIELD;
                    }
                    return scriptableMakeIteratorResult;
                }
                this.lineNumber = e2.lineNumber();
                this.lineSource = e2.lineSource();
                if (e2.getValue() instanceof RhinoException) {
                    throw ((RhinoException) e2.getValue());
                }
                throw e2;
            } catch (RhinoException e3) {
                this.lineNumber = e3.lineNumber();
                this.lineSource = e3.lineSource();
                throw e3;
            }
        } catch (Throwable th2) {
            if (this.state == State.COMPLETED) {
                ScriptableObject.putProperty(scriptableMakeIteratorResult, ES6Iterator.DONE_PROPERTY, Boolean.TRUE);
                throw th2;
            }
            this.state = State.SUSPENDED_YIELD;
            throw th2;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        ES6Generator eS6Generator = (ES6Generator) IdScriptableObject.ensureType(scriptable2, ES6Generator.class, idFunctionObject);
        Object obj = objArr.length >= 1 ? objArr[0] : Undefined.instance;
        if (iMethodId == 1) {
            return eS6Generator.delegee == null ? eS6Generator.resumeLocal(context, scriptable, obj) : eS6Generator.resumeDelegee(context, scriptable, obj);
        }
        if (iMethodId == 2) {
            return eS6Generator.delegee == null ? eS6Generator.resumeAbruptLocal(context, scriptable, 2, obj) : eS6Generator.resumeDelegeeReturn(context, scriptable, obj);
        }
        if (iMethodId == 3) {
            return eS6Generator.delegee == null ? eS6Generator.resumeAbruptLocal(context, scriptable, 1, obj) : eS6Generator.resumeDelegeeThrow(context, scriptable, obj);
        }
        if (iMethodId == 4) {
            return scriptable2;
        }
        jl.a(String.valueOf(iMethodId));
        return null;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 4) {
            str2 = ES6Iterator.NEXT_METHOD;
            i = 1;
        } else if (length == 5) {
            str2 = "throw";
            i = 3;
        } else if (length == 6) {
            str2 = "return";
            i = 2;
        } else {
            str2 = null;
            i = 0;
        }
        if (Objects.equals(str2, str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        if (i == 4) {
            initPrototypeMethod(GENERATOR_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        if (i == 1) {
            str = ES6Iterator.NEXT_METHOD;
        } else if (i == 2) {
            str = "return";
        } else {
            if (i != 3) {
                jl.a(String.valueOf(i));
                return;
            }
            str = "throw";
        }
        initPrototypeMethod(GENERATOR_TAG, i, str, 1);
    }

    private ES6Generator() {
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 4 : 0;
    }
}
