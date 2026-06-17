package org.mozilla.javascript;

import defpackage.bo;
import defpackage.jl;
import defpackage.z20;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeObject extends IdScriptableObject implements Map {
    private static final int ConstructorId_assign = -16;
    private static final int ConstructorId_create = -10;
    private static final int ConstructorId_defineProperties = -9;
    private static final int ConstructorId_defineProperty = -6;
    private static final int ConstructorId_entries = -19;
    private static final int ConstructorId_freeze = -14;
    private static final int ConstructorId_fromEntries = -20;
    private static final int ConstructorId_getOwnPropertyDescriptor = -4;
    private static final int ConstructorId_getOwnPropertyDescriptors = -5;
    private static final int ConstructorId_getOwnPropertyNames = -3;
    private static final int ConstructorId_getOwnPropertySymbols = -15;
    private static final int ConstructorId_getPrototypeOf = -1;
    private static final int ConstructorId_groupBy = -23;
    private static final int ConstructorId_hasOwn = -22;
    private static final int ConstructorId_is = -17;
    private static final int ConstructorId_isExtensible = -7;
    private static final int ConstructorId_isFrozen = -12;
    private static final int ConstructorId_isSealed = -11;
    private static final int ConstructorId_keys = -2;
    private static final int ConstructorId_preventExtensions = -8;
    private static final int ConstructorId_seal = -13;
    private static final int ConstructorId_setPrototypeOf = -18;
    private static final int ConstructorId_values = -21;
    private static final int Id___defineGetter__ = 9;
    private static final int Id___defineSetter__ = 10;
    private static final int Id___lookupGetter__ = 11;
    private static final int Id___lookupSetter__ = 12;
    private static final int Id_constructor = 1;
    private static final int Id_hasOwnProperty = 5;
    private static final int Id_isPrototypeOf = 7;
    private static final int Id_propertyIsEnumerable = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 8;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 4;
    private static final int MAX_PROTOTYPE_ID = 12;
    private static final Object OBJECT_TAG = "Object";
    private static final long serialVersionUID = -6345305608474346996L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class EntrySet extends AbstractSet<Map.Entry<Object, Object>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Object, Object>> iterator() {
            return new Iterator<Map.Entry<Object, Object>>() { // from class: org.mozilla.javascript.NativeObject.EntrySet.1
                Object[] ids;
                Object key = null;
                int index = 0;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Map.Entry<Object, Object> next() {
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    final Object obj = objArr[i];
                    this.key = obj;
                    final Object obj2 = NativeObject.this.get(obj);
                    return new Map.Entry<Object, Object>() { // from class: org.mozilla.javascript.NativeObject.EntrySet.1.1
                        @Override // java.util.Map.Entry
                        public boolean equals(Object obj3) {
                            if (!(obj3 instanceof Map.Entry)) {
                                return false;
                            }
                            Map.Entry entry = (Map.Entry) obj3;
                            Object obj4 = obj;
                            if (obj4 != null ? obj4.equals(entry.getKey()) : entry.getKey() == null) {
                                Object obj5 = obj2;
                                if (obj5 == null) {
                                    if (entry.getValue() == null) {
                                        return true;
                                    }
                                } else if (obj5.equals(entry.getValue())) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override // java.util.Map.Entry
                        public Object getKey() {
                            return obj;
                        }

                        @Override // java.util.Map.Entry
                        public Object getValue() {
                            return obj2;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            Object obj3 = obj;
                            int iHashCode = obj3 == null ? 0 : obj3.hashCode();
                            Object obj4 = obj2;
                            return iHashCode ^ (obj4 != null ? obj4.hashCode() : 0);
                        }

                        @Override // java.util.Map.Entry
                        public Object setValue(Object obj3) {
                            throw new UnsupportedOperationException();
                        }

                        public String toString() {
                            return String.valueOf(obj) + "=" + String.valueOf(obj2);
                        }
                    };
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj == null) {
                        z20.a();
                    } else {
                        NativeObject.this.remove(obj);
                        this.key = null;
                    }
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class KeySet extends AbstractSet<Object> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return NativeObject.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: org.mozilla.javascript.NativeObject.KeySet.1
                Object[] ids;
                int index = 0;
                Object key;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Object next() {
                    try {
                        Object[] objArr = this.ids;
                        int i = this.index;
                        this.index = i + 1;
                        Object obj = objArr[i];
                        this.key = obj;
                        return obj;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        this.key = null;
                        bo.a();
                        return null;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj == null) {
                        z20.a();
                    } else {
                        NativeObject.this.remove(obj);
                        this.key = null;
                    }
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class ValueCollection extends AbstractCollection<Object> {
        public ValueCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: org.mozilla.javascript.NativeObject.ValueCollection.1
                Object[] ids;
                int index = 0;
                Object key;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Object next() {
                    NativeObject nativeObject = NativeObject.this;
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    Object obj = objArr[i];
                    this.key = obj;
                    return nativeObject.get(obj);
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj == null) {
                        z20.a();
                    } else {
                        NativeObject.this.remove(obj);
                        this.key = null;
                    }
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return NativeObject.this.size();
        }
    }

    private static Scriptable getCompatibleObject(Context context, Scriptable scriptable, Object obj) {
        return context.getLanguageVersion() >= 200 ? ScriptableObject.ensureScriptable(ScriptRuntime.toObject(context, scriptable, obj)) : ScriptableObject.ensureScriptable(obj);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeObject().exportAsJSClass(12, scriptable, z);
    }

    private boolean isEnumerable(int i, Object obj) {
        if (obj instanceof ScriptableObject) {
            try {
                return (((ScriptableObject) obj).getAttributes(i) & 2) == 0;
            } catch (RhinoException unused) {
            }
        }
        return true;
    }

    public static /* synthetic */ void j(Scriptable scriptable, Object obj, Object obj2) {
        if (obj instanceof Integer) {
            scriptable.put(((Integer) obj).intValue(), scriptable, obj2);
        } else if ((obj instanceof Symbol) && (scriptable instanceof SymbolScriptable)) {
            ((SymbolScriptable) scriptable).put((Symbol) obj, scriptable, obj2);
        } else {
            scriptable.put(ScriptRuntime.toString(obj), scriptable, obj2);
        }
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return has((String) obj, this);
        }
        if (obj instanceof Number) {
            return has(((Number) obj).intValue(), this);
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Iterator<Object> it = values().iterator();
        while (it.hasNext()) {
            if (Objects.equals(obj, it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return new EntrySet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0160, code lost:
    
        if (r0 != false) goto L109;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r19, org.mozilla.javascript.Context r20, org.mozilla.javascript.Scriptable r21, org.mozilla.javascript.Scriptable r22, java.lang.Object[] r23) {
        /*
            Method dump skipped, instruction units count: 1902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeObject.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = OBJECT_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "getPrototypeOf", 1);
        if (Context.getCurrentContext().version >= 200) {
            addIdFunctionProperty(idFunctionObject, obj, ConstructorId_setPrototypeOf, "setPrototypeOf", 2);
            addIdFunctionProperty(idFunctionObject, obj, ConstructorId_entries, "entries", 1);
            addIdFunctionProperty(idFunctionObject, obj, ConstructorId_fromEntries, "fromEntries", 1);
            addIdFunctionProperty(idFunctionObject, obj, ConstructorId_values, "values", 1);
            addIdFunctionProperty(idFunctionObject, obj, ConstructorId_hasOwn, "hasOwn", 1);
        }
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_keys, "keys", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_getOwnPropertyNames, "getOwnPropertyNames", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_getOwnPropertySymbols, "getOwnPropertySymbols", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_getOwnPropertyDescriptor, "getOwnPropertyDescriptor", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_getOwnPropertyDescriptors, "getOwnPropertyDescriptors", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_defineProperty, "defineProperty", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isExtensible, "isExtensible", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_preventExtensions, "preventExtensions", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_defineProperties, "defineProperties", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_create, "create", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isSealed, "isSealed", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isFrozen, "isFrozen", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_seal, "seal", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_freeze, "freeze", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_assign, "assign", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_is, "is", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_groupBy, "groupBy", 2);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "toLocaleString":
                return 3;
            case "hasOwnProperty":
                return 5;
            case "toSource":
                return 8;
            case "toString":
                return 2;
            case "constructor":
                return 1;
            case "isPrototypeOf":
                return 7;
            case "propertyIsEnumerable":
                return 6;
            case "valueOf":
                return 4;
            case "__lookupSetter__":
                return 12;
            case "__lookupGetter__":
                return 11;
            case "__defineSetter__":
                return 10;
            case "__defineGetter__":
                return 9;
            default:
                return 0;
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Object";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 2:
                str = "toString";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 3:
                str = "toLocaleString";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 4:
                str = "valueOf";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 5:
                str = "hasOwnProperty";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 6:
                str = "propertyIsEnumerable";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 7:
                str = "isPrototypeOf";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 8:
                str = "toSource";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 9:
                str2 = "__defineGetter__";
                i2 = 2;
                str = str2;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 10:
                str2 = "__defineSetter__";
                i2 = 2;
                str = str2;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 11:
                str = "__lookupGetter__";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            case 12:
                str = "__lookupSetter__";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                break;
            default:
                jl.a(String.valueOf(i));
                break;
        }
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        Object obj2 = get(obj);
        if (obj instanceof String) {
            delete((String) obj);
            return obj2;
        }
        if (obj instanceof Number) {
            delete(((Number) obj).intValue());
        }
        return obj2;
    }

    public String toString() {
        return ScriptRuntime.defaultObjectToString(this);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return new ValueCollection();
    }

    private boolean isEnumerable(String str, Object obj) {
        if (obj instanceof ScriptableObject) {
            try {
                return (((ScriptableObject) obj).getAttributes(str) & 2) == 0;
            } catch (RhinoException unused) {
            }
        }
        return true;
    }

    private boolean isEnumerable(Symbol symbol, Object obj) {
        if (obj instanceof ScriptableObject) {
            try {
                return (((ScriptableObject) obj).getAttributes(symbol) & 2) == 0;
            } catch (RhinoException unused) {
            }
        }
        return true;
    }
}
