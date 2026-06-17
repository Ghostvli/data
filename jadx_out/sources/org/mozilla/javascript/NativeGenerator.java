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

    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }

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

    /* JADX WARN: Removed duplicated region for block: B:76:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object resume(org.mozilla.javascript.Context r12, org.mozilla.javascript.Scriptable r13, int r14, java.lang.Object r15) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.savedState
            r1 = 1
            r2 = 2
            if (r0 != 0) goto L1c
            if (r14 != r2) goto Lb
            java.lang.Object r11 = org.mozilla.javascript.Undefined.instance
            return r11
        Lb:
            if (r14 != r1) goto Le
            goto L12
        Le:
            java.lang.Object r15 = org.mozilla.javascript.NativeIterator.getStopIterationObject(r13)
        L12:
            org.mozilla.javascript.JavaScriptException r12 = new org.mozilla.javascript.JavaScriptException
            java.lang.String r13 = r11.lineSource
            int r11 = r11.lineNumber
            r12.<init>(r15, r13, r11)
            throw r12
        L1c:
            r3 = 0
            r4 = 0
            monitor-enter(r11)     // Catch: java.lang.Throwable -> L45 org.mozilla.javascript.RhinoException -> L48 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L4b
            boolean r0 = r11.locked     // Catch: java.lang.Throwable -> L4d
            if (r0 != 0) goto L51
            r11.locked = r1     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L4d
            org.mozilla.javascript.NativeFunction r5 = r11.function     // Catch: java.lang.Throwable -> L45 org.mozilla.javascript.RhinoException -> L48 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L4b
            java.lang.Object r9 = r11.savedState     // Catch: java.lang.Throwable -> L45 org.mozilla.javascript.RhinoException -> L48 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L4b
            r6 = r12
            r7 = r13
            r8 = r14
            r10 = r15
            java.lang.Object r12 = r5.resumeGenerator(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L3f org.mozilla.javascript.RhinoException -> L42 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L6e
            monitor-enter(r11)
            r11.locked = r4     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L3b
            if (r8 != r2) goto L3a
            r11.savedState = r3
        L3a:
            return r12
        L3b:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L3b
            throw r12
        L3f:
            r0 = move-exception
        L40:
            r12 = r0
            goto L7d
        L42:
            r0 = move-exception
        L43:
            r12 = r0
            goto L5f
        L45:
            r0 = move-exception
            r8 = r14
            goto L40
        L48:
            r0 = move-exception
            r8 = r14
            goto L43
        L4b:
            r8 = r14
            goto L6e
        L4d:
            r0 = move-exception
            r8 = r14
        L4f:
            r12 = r0
            goto L5d
        L51:
            r8 = r14
            java.lang.String r12 = "msg.already.exec.gen"
            java.lang.Object[] r13 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5b
            org.mozilla.javascript.EcmaError r12 = org.mozilla.javascript.ScriptRuntime.typeErrorById(r12, r13)     // Catch: java.lang.Throwable -> L5b
            throw r12     // Catch: java.lang.Throwable -> L5b
        L5b:
            r0 = move-exception
            goto L4f
        L5d:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L5b
            throw r12     // Catch: java.lang.Throwable -> L3f org.mozilla.javascript.RhinoException -> L42 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L6e
        L5f:
            int r13 = r12.lineNumber()     // Catch: java.lang.Throwable -> L3f
            r11.lineNumber = r13     // Catch: java.lang.Throwable -> L3f
            java.lang.String r13 = r12.lineSource()     // Catch: java.lang.Throwable -> L3f
            r11.lineSource = r13     // Catch: java.lang.Throwable -> L3f
            r11.savedState = r3     // Catch: java.lang.Throwable -> L3f
            throw r12     // Catch: java.lang.Throwable -> L3f
        L6e:
            java.lang.Object r12 = org.mozilla.javascript.Undefined.instance     // Catch: java.lang.Throwable -> L3f
            monitor-enter(r11)
            r11.locked = r4     // Catch: java.lang.Throwable -> L79
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L79
            if (r8 != r2) goto L78
            r11.savedState = r3
        L78:
            return r12
        L79:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L79
            throw r12
        L7d:
            monitor-enter(r11)
            r11.locked = r4     // Catch: java.lang.Throwable -> L86
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L86
            if (r8 != r2) goto L85
            r11.savedState = r3
        L85:
            throw r12
        L86:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L86
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGenerator.resume(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, int, java.lang.Object):java.lang.Object");
    }

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

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

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
