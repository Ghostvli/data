package org.mozilla.javascript;

import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ES6Iterator extends IdScriptableObject {
    public static final String DONE_PROPERTY = "done";
    private static final int Id_next = 1;
    private static final int MAX_PROTOTYPE_ID = 3;
    public static final String NEXT_METHOD = "next";
    public static final String RETURN_METHOD = "return";
    public static final String RETURN_PROPERTY = "return";
    private static final int SymbolId_iterator = 2;
    private static final int SymbolId_toStringTag = 3;
    public static final String VALUE_PROPERTY = "value";
    private static final long serialVersionUID = 2438373029140003950L;
    protected boolean exhausted = false;
    private String tag;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ES6Iterator(Scriptable scriptable, String str) {
        this.tag = str;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((IdScriptableObject) ScriptableObject.getTopScopeValue(topLevelScope, str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(ScriptableObject scriptableObject, boolean z, IdScriptableObject idScriptableObject, String str) {
        if (scriptableObject != null) {
            idScriptableObject.setParentScope(scriptableObject);
            idScriptableObject.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        idScriptableObject.activatePrototypeMap(3);
        if (z) {
            idScriptableObject.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(str, idScriptableObject);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable makeIteratorResult(Context context, Scriptable scriptable, Boolean bool, Object obj) {
        Scriptable scriptableNewObject = context.newObject(scriptable);
        ScriptableObject.putProperty(scriptableNewObject, VALUE_PROPERTY, obj);
        ScriptableObject.putProperty(scriptableNewObject, DONE_PROPERTY, bool);
        return scriptableNewObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getTag())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        ES6Iterator eS6Iterator = (ES6Iterator) IdScriptableObject.ensureType(scriptable2, ES6Iterator.class, idFunctionObject);
        if (iMethodId == 1) {
            return eS6Iterator.next(context, scriptable);
        }
        if (iMethodId == 2) {
            return eS6Iterator;
        }
        jl.a(String.valueOf(iMethodId));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 2;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 3 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTag() {
        return this.tag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        if (i == 1) {
            initPrototypeMethod(getTag(), i, NEXT_METHOD, 0);
            return;
        }
        if (i == 2) {
            initPrototypeMethod(getTag(), i, SymbolKey.ITERATOR, "[Symbol.iterator]", 3);
        } else if (i == 3) {
            initPrototypeValue(3, SymbolKey.TO_STRING_TAG, getClassName(), 3);
        } else {
            jl.a(String.valueOf(i));
        }
    }

    public abstract boolean isDone(Context context, Scriptable scriptable);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object next(Context context, Scriptable scriptable) {
        Object objNextValue = Undefined.instance;
        boolean z = isDone(context, scriptable) || this.exhausted;
        if (z) {
            this.exhausted = true;
        } else {
            objNextValue = nextValue(context, scriptable);
        }
        return makeIteratorResult(context, scriptable, Boolean.valueOf(z), objNextValue);
    }

    public abstract Object nextValue(Context context, Scriptable scriptable);

    public static Scriptable makeIteratorResult(Context context, Scriptable scriptable, Boolean bool) {
        return makeIteratorResult(context, scriptable, bool, Undefined.instance);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        return NEXT_METHOD.equals(str) ? 1 : 0;
    }

    public ES6Iterator() {
    }
}
