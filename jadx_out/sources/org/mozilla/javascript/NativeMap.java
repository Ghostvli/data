package org.mozilla.javascript;

import defpackage.jl;
import defpackage.nl;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.mozilla.javascript.AbstractEcmaObjectOperations;
import org.mozilla.javascript.Hashtable;
import org.mozilla.javascript.NativeCollectionIterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeMap extends IdScriptableObject {
    private static final int ConstructorId_groupBy = -1;
    static final String ITERATOR_TAG = "Map Iterator";
    private static final int Id_clear = 6;
    private static final int Id_constructor = 1;
    private static final int Id_delete = 4;
    private static final int Id_entries = 9;
    private static final int Id_forEach = 10;
    private static final int Id_get = 3;
    private static final int Id_has = 5;
    private static final int Id_keys = 7;
    private static final int Id_set = 2;
    private static final int Id_values = 8;
    private static final Object MAP_TAG = "Map";
    private static final int MAX_PROTOTYPE_ID = 12;
    private static final int SymbolId_getSize = 11;
    private static final int SymbolId_toStringTag = 12;
    private static final long serialVersionUID = 1171922614280016891L;
    private final Hashtable entries = new Hashtable();
    private boolean instanceOfMap = false;

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeMap nativeMap = new NativeMap();
        IdFunctionObject idFunctionObjectExportAsJSClass = nativeMap.exportAsJSClass(12, scriptable, false);
        ScriptableObject scriptableObject = (ScriptableObject) context.newObject(scriptable);
        scriptableObject.put("enumerable", scriptableObject, Boolean.FALSE);
        scriptableObject.put("configurable", scriptableObject, Boolean.TRUE);
        scriptableObject.put("get", scriptableObject, nativeMap.get(NativeSet.GETSIZE, nativeMap));
        nativeMap.defineOwnProperty(context, "size", scriptableObject);
        ScriptRuntimeES6.addSymbolSpecies(context, scriptable, idFunctionObjectExportAsJSClass);
        if (z) {
            nativeMap.sealObject();
        }
    }

    private Object js_clear() {
        this.entries.clear();
        return Undefined.instance;
    }

    private Object js_delete(Object obj) {
        return Boolean.valueOf(this.entries.deleteEntry(obj));
    }

    private Object js_forEach(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (!(obj instanceof Callable)) {
            throw ScriptRuntime.typeErrorById("msg.isnt.function", obj, ScriptRuntime.typeof(obj));
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
            callable.call(context, scriptable, objectOrNull, new Object[]{entry.value, entry.key, this});
        }
        return Undefined.instance;
    }

    private Object js_get(Object obj) {
        Hashtable.Entry entry = this.entries.getEntry(obj);
        return entry == null ? Undefined.instance : entry.value;
    }

    private Object js_getSize() {
        return Integer.valueOf(this.entries.size());
    }

    private Object js_has(Object obj) {
        return Boolean.valueOf(this.entries.has(obj));
    }

    private Object js_iterator(Scriptable scriptable, NativeCollectionIterator.Type type) {
        return new NativeCollectionIterator(scriptable, ITERATOR_TAG, type, this.entries.iterator());
    }

    private Object js_set(Object obj, Object obj2) {
        if ((obj instanceof Number) && ((Number) obj).doubleValue() == ScriptRuntime.negativeZero) {
            obj = ScriptRuntime.zeroObj;
        }
        this.entries.put(obj, obj2);
        return this;
    }

    public static Object key(Object[] objArr) {
        if (objArr.length <= 0) {
            return Undefined.instance;
        }
        Object obj = objArr[0];
        return obj instanceof Delegator ? ((Delegator) obj).getDelegee() : obj;
    }

    public static void loadFromIterable(final Context context, final Scriptable scriptable, final ScriptableObject scriptableObject, Object obj) {
        if (obj != null) {
            Object obj2 = Undefined.instance;
            if (obj2.equals(obj) || obj2.equals(ScriptRuntime.callIterator(obj, context, scriptable))) {
                return;
            }
            final Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(ScriptableObject.getClassPrototype(scriptable, scriptableObject.getClassName()), "set", context, scriptable);
            ScriptRuntime.lastStoredScriptable(context);
            ScriptRuntime.loadFromIterable(context, scriptable, obj, new BiConsumer() { // from class: cz2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj3, Object obj4) {
                    propFunctionAndThis.call(context, scriptable, scriptableObject, new Object[]{obj3, obj4});
                }
            });
        }
    }

    private static NativeMap realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        NativeMap nativeMap = (NativeMap) IdScriptableObject.ensureType(scriptable, NativeMap.class, idFunctionObject);
        if (nativeMap.instanceOfMap) {
            return nativeMap;
        }
        throw ScriptRuntime.typeErrorById("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(MAP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        switch (idFunctionObject.methodId()) {
            case -1:
                Map<Object, List<Object>> mapGroupBy = AbstractEcmaObjectOperations.groupBy(context, scriptable, idFunctionObject, objArr.length < 1 ? Undefined.instance : objArr[0], objArr.length < 2 ? Undefined.instance : objArr[1], AbstractEcmaObjectOperations.KEY_COERCION.COLLECTION);
                NativeMap nativeMap = (NativeMap) context.newObject(scriptable, "Map");
                for (Map.Entry<Object, List<Object>> entry : mapGroupBy.entrySet()) {
                    nativeMap.entries.put(entry.getKey(), context.newArray(scriptable, entry.getValue().toArray()));
                }
                return nativeMap;
            case 0:
            default:
                nl.a("Map.prototype has no method: ", idFunctionObject.getFunctionName());
                return null;
            case 1:
                if (scriptable2 != null) {
                    throw ScriptRuntime.typeErrorById("msg.no.new", "Map");
                }
                NativeMap nativeMap2 = new NativeMap();
                nativeMap2.instanceOfMap = true;
                if (objArr.length > 0) {
                    loadFromIterable(context, scriptable, nativeMap2, key(objArr));
                }
                return nativeMap2;
            case 2:
                return realThis(scriptable2, idFunctionObject).js_set(key(objArr), objArr.length > 1 ? objArr[1] : Undefined.instance);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_get(key(objArr));
            case 4:
                return realThis(scriptable2, idFunctionObject).js_delete(key(objArr));
            case 5:
                return realThis(scriptable2, idFunctionObject).js_has(key(objArr));
            case 6:
                return realThis(scriptable2, idFunctionObject).js_clear();
            case 7:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.KEYS);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.VALUES);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.BOTH);
            case 10:
                return realThis(scriptable2, idFunctionObject).js_forEach(context, scriptable, objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
            case 11:
                return realThis(scriptable2, idFunctionObject).js_getSize();
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, MAP_TAG, -1, "groupBy", 2);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "entries":
                return 9;
            case "constructor":
                return 1;
            case "delete":
                return 4;
            case "values":
                return 8;
            case "forEach":
                return 10;
            case "get":
                return 3;
            case "has":
                return 5;
            case "set":
                return 2;
            case "keys":
                return 7;
            case "clear":
                return 6;
            default:
                return 0;
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Map";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        int i2;
        if (i == 11) {
            initPrototypeMethod(MAP_TAG, i, NativeSet.GETSIZE, "get size", 0);
            return;
        }
        if (i == 12) {
            initPrototypeValue(12, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        int i3 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                str3 = str;
                i2 = 0;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 2:
                i3 = 2;
                str2 = "set";
                i2 = i3;
                str3 = str2;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 3:
                str2 = "get";
                i2 = i3;
                str3 = str2;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 4:
                str2 = "delete";
                i2 = i3;
                str3 = str2;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 5:
                str2 = "has";
                i2 = i3;
                str3 = str2;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 6:
                str = "clear";
                str3 = str;
                i2 = 0;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 7:
                str = "keys";
                str3 = str;
                i2 = 0;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 8:
                str = "values";
                str3 = str;
                i2 = 0;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 9:
                str = "entries";
                str3 = str;
                i2 = 0;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            case 10:
                str2 = "forEach";
                i2 = i3;
                str3 = str2;
                initPrototypeMethod(MAP_TAG, i, str3, (String) null, i2);
                break;
            default:
                jl.a(String.valueOf(i));
                break;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (NativeSet.GETSIZE.equals(symbol)) {
            return 11;
        }
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 9;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 12 : 0;
    }
}
