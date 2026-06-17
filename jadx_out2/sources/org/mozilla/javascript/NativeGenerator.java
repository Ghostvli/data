package org.mozilla.javascript;

import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeGenerator extends IdScriptableObject {
    public static final int GENERATOR_CLOSE = 2;
    public static final int GENERATOR_SEND = 0;
    private static final Object GENERATOR_TAG = "Generator";
    public static final int GENERATOR_THROW = 1;
    private static final int Id___iterator__ = 5;
    private static final int Id_close = 1;
    private static final int Id_next = 2;
    private static final int Id_send = 3;
    private static final int Id_throw = 4;
    private static final int MAX_PROTOTYPE_ID = 5;
    private static final long serialVersionUID = 1645892441041347273L;
    private boolean firstTime = true;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private boolean locked;
    private Object savedState;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class GeneratorClosedException extends RuntimeException {
        private static final long serialVersionUID = 2561315658662379681L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NativeGenerator init(ScriptableObject scriptableObject, boolean z) {
        NativeGenerator nativeGenerator = new NativeGenerator();
        if (scriptableObject != null) {
            nativeGenerator.setParentScope(scriptableObject);
            nativeGenerator.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        nativeGenerator.activatePrototypeMap(5);
        if (z) {
            nativeGenerator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, nativeGenerator);
        }
        return nativeGenerator;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object resume(Context context, Scriptable scriptable, int i, Object obj) throws Throwable {
        if (this.savedState == null) {
            if (i == 2) {
                return Undefined.instance;
            }
            if (i != 1) {
                obj = NativeIterator.getStopIterationObject(scriptable);
            }
            throw new JavaScriptException(obj, this.lineSource, this.lineNumber);
        }
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                try {
                    synchronized (this) {
                        try {
                            if (this.locked) {
                                throw ScriptRuntime.typeErrorById("msg.already.exec.gen", new Object[0]);
                            }
                            this.locked = true;
                            Object objResumeGenerator = this.function.resumeGenerator(context, scriptable, i, this.savedState, obj);
                            synchronized (this) {
                                this.locked = false;
                            }
                            if (i == 2) {
                                this.savedState = null;
                            }
                            return objResumeGenerator;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (GeneratorClosedException unused) {
                Object obj2 = Undefined.instance;
                synchronized (this) {
                    this.locked = false;
                }
                if (i == 2) {
                    this.savedState = null;
                }
                return obj2;
            } catch (RhinoException e) {
                e = e;
                RhinoException rhinoException = e;
                this.lineNumber = rhinoException.lineNumber();
                this.lineSource = rhinoException.lineSource();
                this.savedState = null;
                throw rhinoException;
            }
        } catch (GeneratorClosedException unused2) {
            Object obj22 = Undefined.instance;
            synchronized (this) {
            }
        } catch (RhinoException e2) {
            e = e2;
            RhinoException rhinoException2 = e;
            this.lineNumber = rhinoException2.lineNumber();
            this.lineSource = rhinoException2.lineSource();
            this.savedState = null;
            throw rhinoException2;
        } catch (Throwable th4) {
            th = th4;
            Throwable th5 = th;
            synchronized (this) {
                this.locked = false;
            }
            if (i != 2) {
                throw th5;
            }
            this.savedState = null;
            throw th5;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        NativeGenerator nativeGenerator = (NativeGenerator) IdScriptableObject.ensureType(scriptable2, NativeGenerator.class, idFunctionObject);
        if (iMethodId == 1) {
            return nativeGenerator.resume(context, scriptable, 2, new GeneratorClosedException());
        }
        if (iMethodId == 2) {
            nativeGenerator.firstTime = false;
            return nativeGenerator.resume(context, scriptable, 0, Undefined.instance);
        }
        if (iMethodId == 3) {
            Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
            if (!nativeGenerator.firstTime || obj.equals(Undefined.instance)) {
                return nativeGenerator.resume(context, scriptable, 0, obj);
            }
            throw ScriptRuntime.typeErrorById("msg.send.newborn", new Object[0]);
        }
        if (iMethodId == 4) {
            return nativeGenerator.resume(context, scriptable, 1, objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (iMethodId == 5) {
            return scriptable2;
        }
        jl.a(String.valueOf(iMethodId));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "__iterator__":
                return 5;
            case "next":
                return 2;
            case "send":
                return 3;
            case "close":
                return 1;
            case "throw":
                return 4;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        if (i == 1) {
            str = "close";
        } else if (i != 2) {
            if (i == 3) {
                str = "send";
            } else if (i == 4) {
                str = "throw";
            } else {
                if (i != 5) {
                    jl.a(String.valueOf(i));
                    return;
                }
                str = NativeIterator.ITERATOR_PROPERTY_NAME;
            }
            i2 = 0;
        } else {
            str = ES6Iterator.NEXT_METHOD;
        }
        initPrototypeMethod(GENERATOR_TAG, i, str, i2);
    }

    private NativeGenerator() {
    }
}
