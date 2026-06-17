package org.mozilla.javascript;

import defpackage.jl;
import defpackage.nl;
import java.util.Iterator;
import org.mozilla.javascript.Hashtable;
import org.mozilla.javascript.NativeCollectionIterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeSet extends IdScriptableObject {
    static final String ITERATOR_TAG = "Set Iterator";
    private static final int Id_add = 2;
    private static final int Id_clear = 5;
    private static final int Id_constructor = 1;
    private static final int Id_delete = 3;
    private static final int Id_entries = 7;
    private static final int Id_forEach = 8;
    private static final int Id_has = 4;
    private static final int Id_keys = 6;
    private static final int Id_values = 6;
    private static final int MAX_PROTOTYPE_ID = 10;
    private static final int SymbolId_getSize = 9;
    private static final int SymbolId_toStringTag = 10;
    private static final long serialVersionUID = -8442212766987072986L;
    private final Hashtable entries = new Hashtable();
    private boolean instanceOfSet = false;
    private static final Object SET_TAG = "Set";
    static final SymbolKey GETSIZE = new SymbolKey("[Symbol.getSize]");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeSet nativeSet = new NativeSet();
        IdFunctionObject idFunctionObjectExportAsJSClass = nativeSet.exportAsJSClass(10, scriptable, false);
        ScriptableObject scriptableObject = (ScriptableObject) context.newObject(scriptable);
        scriptableObject.put("enumerable", scriptableObject, Boolean.FALSE);
        scriptableObject.put("configurable", scriptableObject, Boolean.TRUE);
        scriptableObject.put("get", scriptableObject, nativeSet.get(GETSIZE, nativeSet));
        nativeSet.defineOwnProperty(context, "size", scriptableObject);
        ScriptRuntimeES6.addSymbolSpecies(context, scriptable, idFunctionObjectExportAsJSClass);
        if (z) {
            nativeSet.sealObject();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_add(Object obj) {
        if ((obj instanceof Number) && ((Number) obj).doubleValue() == ScriptRuntime.negativeZero) {
            obj = ScriptRuntime.zeroObj;
        }
        this.entries.put(obj, obj);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_clear() {
        this.entries.clear();
        return Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_delete(Object obj) {
        return Boolean.valueOf(this.entries.deleteEntry(obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_forEach(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (!(obj instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Callable callable = (Callable) obj;
        boolean zIsStrictMode = context.isStrictMode();
        for (Hashtable.Entry entry : this.entries) {
            Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj2, scriptable);
            if (objectOrNull == null && !zIsStrictMode) {
                objectOrNull = scriptable;
            }
            if (objectOrNull == null) {
                objectOrNull = Undefined.SCRIPTABLE_UNDEFINED;
            }
            Object obj3 = entry.value;
            callable.call(context, scriptable, objectOrNull, new Object[]{obj3, obj3, this});
        }
        return Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_getSize() {
        return Integer.valueOf(this.entries.size());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_has(Object obj) {
        return Boolean.valueOf(this.entries.has(obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object js_iterator(Scriptable scriptable, NativeCollectionIterator.Type type) {
        return new NativeCollectionIterator(scriptable, ITERATOR_TAG, type, this.entries.iterator());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void loadFromIterable(Context context, Scriptable scriptable, ScriptableObject scriptableObject, Object obj) {
        if (obj != null) {
            Object obj2 = Undefined.instance;
            if (obj2.equals(obj)) {
                return;
            }
            Object objCallIterator = ScriptRuntime.callIterator(obj, context, scriptable);
            if (obj2.equals(objCallIterator)) {
                return;
            }
            Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(ScriptableObject.ensureScriptableObject(context.newObject(scriptable, scriptableObject.getClassName())).getPrototype(), "add", context, scriptable);
            ScriptRuntime.lastStoredScriptable(context);
            IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, objCallIterator);
            try {
                Iterator<Object> it = iteratorLikeIterable.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == Scriptable.NOT_FOUND) {
                        next = Undefined.instance;
                    }
                    propFunctionAndThis.call(context, scriptable, scriptableObject, new Object[]{next});
                }
                iteratorLikeIterable.close();
            } catch (Throwable th) {
                try {
                    iteratorLikeIterable.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeSet realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        NativeSet nativeSet = (NativeSet) IdScriptableObject.ensureType(scriptable, NativeSet.class, idFunctionObject);
        if (nativeSet.instanceOfSet) {
            return nativeSet;
        }
        throw ScriptRuntime.typeErrorById("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(SET_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        switch (idFunctionObject.methodId()) {
            case 1:
                if (scriptable2 != null) {
                    throw ScriptRuntime.typeErrorById("msg.no.new", "Set");
                }
                NativeSet nativeSet = new NativeSet();
                nativeSet.instanceOfSet = true;
                if (objArr.length > 0) {
                    loadFromIterable(context, scriptable, nativeSet, NativeMap.key(objArr));
                }
                return nativeSet;
            case 2:
                return realThis(scriptable2, idFunctionObject).js_add(NativeMap.key(objArr));
            case 3:
                return realThis(scriptable2, idFunctionObject).js_delete(NativeMap.key(objArr));
            case 4:
                return realThis(scriptable2, idFunctionObject).js_has(NativeMap.key(objArr));
            case 5:
                return realThis(scriptable2, idFunctionObject).js_clear();
            case 6:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.VALUES);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.BOTH);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_forEach(context, scriptable, NativeMap.key(objArr), objArr.length > 1 ? objArr[1] : Undefined.instance);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getSize();
            default:
                nl.a("Set.prototype has no method: ", idFunctionObject.getFunctionName());
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "entries":
                return 7;
            case "constructor":
                return 1;
            case "delete":
                return 3;
            case "values":
                return 6;
            case "forEach":
                return 8;
            case "add":
                return 2;
            case "has":
                return 4;
            case "keys":
                return 6;
            case "clear":
                return 5;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Set";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2;
        String str3;
        if (i == 9) {
            initPrototypeMethod(SET_TAG, i, GETSIZE, "get size", 0);
            return;
        }
        if (i == 10) {
            initPrototypeValue(10, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                i2 = 0;
                str3 = str;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 2:
                str2 = "add";
                str3 = str2;
                i2 = 1;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 3:
                str2 = "delete";
                str3 = str2;
                i2 = 1;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 4:
                str2 = "has";
                str3 = str2;
                i2 = 1;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 5:
                str = "clear";
                i2 = 0;
                str3 = str;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 6:
                str = "values";
                i2 = 0;
                str3 = str;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 7:
                str = "entries";
                i2 = 0;
                str3 = str;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            case 8:
                str2 = "forEach";
                str3 = str2;
                i2 = 1;
                initPrototypeMethod(SET_TAG, i, str3, (String) null, i2);
                break;
            default:
                jl.a(String.valueOf(i));
                break;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (GETSIZE.equals(symbol)) {
            return 9;
        }
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 6;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 10 : 0;
    }
}
