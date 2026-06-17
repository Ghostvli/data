package org.mozilla.javascript;

import defpackage.bo;
import defpackage.jl;
import defpackage.z20;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import org.mozilla.javascript.AbstractEcmaObjectOperations;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.ScriptRuntime;

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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public EntrySet() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Object, Object>> iterator() {
            return new Iterator<Map.Entry<Object, Object>>() { // from class: org.mozilla.javascript.NativeObject.EntrySet.1
                Object[] ids;
                Object key = null;
                int index = 0;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                {
                    this.ids = NativeObject.this.getIds();
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
                @Override // java.util.Iterator
                public Map.Entry<Object, Object> next() {
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    final Object obj = objArr[i];
                    this.key = obj;
                    final Object obj2 = NativeObject.this.get(obj);
                    return new Map.Entry<Object, Object>() { // from class: org.mozilla.javascript.NativeObject.EntrySet.1.1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.Map.Entry
                        public Object getKey() {
                            return obj;
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.Map.Entry
                        public Object getValue() {
                            return obj2;
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            Object obj3 = obj;
                            int iHashCode = obj3 == null ? 0 : obj3.hashCode();
                            Object obj4 = obj2;
                            return iHashCode ^ (obj4 != null ? obj4.hashCode() : 0);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.Map.Entry
                        public Object setValue(Object obj3) {
                            throw new UnsupportedOperationException();
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public String toString() {
                            return String.valueOf(obj) + "=" + String.valueOf(obj2);
                        }
                    };
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class KeySet extends AbstractSet<Object> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public KeySet() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return NativeObject.this.containsKey(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: org.mozilla.javascript.NativeObject.KeySet.1
                Object[] ids;
                int index = 0;
                Object key;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                {
                    this.ids = NativeObject.this.getIds();
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class ValueCollection extends AbstractCollection<Object> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ValueCollection() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: org.mozilla.javascript.NativeObject.ValueCollection.1
                Object[] ids;
                int index = 0;
                Object key;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                {
                    this.ids = NativeObject.this.getIds();
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Scriptable getCompatibleObject(Context context, Scriptable scriptable, Object obj) {
        return context.getLanguageVersion() >= 200 ? ScriptableObject.ensureScriptable(ScriptRuntime.toObject(context, scriptable, obj)) : ScriptableObject.ensureScriptable(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Scriptable scriptable, boolean z) {
        new NativeObject().exportAsJSClass(12, scriptable, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isEnumerable(int i, Object obj) {
        if (obj instanceof ScriptableObject) {
            try {
                return (((ScriptableObject) obj).getAttributes(i) & 2) == 0;
            } catch (RhinoException unused) {
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void j(Scriptable scriptable, Object obj, Object obj2) {
        if (obj instanceof Integer) {
            scriptable.put(((Integer) obj).intValue(), scriptable, obj2);
        } else if ((obj instanceof Symbol) && (scriptable instanceof SymbolScriptable)) {
            ((SymbolScriptable) scriptable).put((Symbol) obj, scriptable, obj2);
        } else {
            scriptable.put(ScriptRuntime.toString(obj), scriptable, obj2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return new EntrySet();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:527:0x0168 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v32, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v37, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v62, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v63, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v64, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v65, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
    /* JADX DEBUG: Multi-variable search result rejected for r1v66, resolved type: org.mozilla.javascript.ScriptRuntime$StringIdOrIndex */
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
    */
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        int i;
        int i2;
        Object obj;
        ScriptRuntime.StringIdOrIndex stringIdOrIndex;
        ?? r1;
        Object getterOrSetter;
        Scriptable prototype;
        if (!idFunctionObject.hasTag(OBJECT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        z = false;
        z = false;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        boolean z2 = false;
        switch (iMethodId) {
            case ConstructorId_groupBy /* -23 */:
                Map<Object, List<Object>> mapGroupBy = AbstractEcmaObjectOperations.groupBy(context, scriptable, idFunctionObject, objArr.length < 1 ? Undefined.instance : objArr[0], objArr.length < 2 ? Undefined.instance : objArr[1], AbstractEcmaObjectOperations.KEY_COERCION.PROPERTY);
                NativeObject nativeObject = (NativeObject) context.newObject(scriptable);
                nativeObject.setPrototype(null);
                for (Map.Entry<Object, List<Object>> entry : mapGroupBy.entrySet()) {
                    Object objNewArray = context.newArray(scriptable, entry.getValue().toArray());
                    ScriptableObject scriptableObject = (ScriptableObject) context.newObject(scriptable);
                    Object obj2 = Boolean.TRUE;
                    scriptableObject.put("enumerable", scriptableObject, obj2);
                    scriptableObject.put("configurable", scriptableObject, obj2);
                    scriptableObject.put(ES6Iterator.VALUE_PROPERTY, scriptableObject, objNewArray);
                    nativeObject.defineOwnProperty(context, entry.getKey(), scriptableObject);
                }
                return nativeObject;
            case ConstructorId_hasOwn /* -22 */:
                return Boolean.valueOf(AbstractEcmaObjectOperations.hasOwnProperty(context, objArr.length < 1 ? Undefined.instance : objArr[0], objArr.length < 2 ? Undefined.instance : objArr[1]));
            case ConstructorId_values /* -21 */:
                Scriptable compatibleObject = getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]);
                Object[] ids = compatibleObject.getIds();
                int i3 = 0;
                for (Object obj3 : ids) {
                    if (obj3 instanceof Integer) {
                        int iIntValue = ((Integer) obj3).intValue();
                        if (compatibleObject.has(iIntValue, compatibleObject) && isEnumerable(iIntValue, compatibleObject)) {
                            i = i3 + 1;
                            ids[i3] = compatibleObject.get(iIntValue, compatibleObject);
                            i3 = i;
                        }
                    } else {
                        String string = ScriptRuntime.toString(obj3);
                        if (compatibleObject.has(string, compatibleObject) && isEnumerable(string, compatibleObject)) {
                            i = i3 + 1;
                            ids[i3] = compatibleObject.get(string, compatibleObject);
                            i3 = i;
                        }
                    }
                }
                if (i3 != ids.length) {
                    ids = Arrays.copyOf(ids, i3);
                }
                return context.newArray(scriptable, ids);
            case ConstructorId_fromEntries /* -20 */:
                Scriptable compatibleObject2 = getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]);
                final Scriptable scriptableNewObject = context.newObject(scriptable);
                ScriptRuntime.loadFromIterable(context, scriptable, compatibleObject2, new BiConsumer() { // from class: dz2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj4, Object obj5) {
                        NativeObject.j(scriptableNewObject, obj4, obj5);
                    }
                });
                return scriptableNewObject;
            case ConstructorId_entries /* -19 */:
                Scriptable compatibleObject3 = getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]);
                Object[] ids2 = compatibleObject3.getIds();
                int i4 = 0;
                for (int i5 = 0; i5 < ids2.length; i5++) {
                    Object obj4 = ids2[i5];
                    if (obj4 instanceof Integer) {
                        int iIntValue2 = ((Integer) obj4).intValue();
                        if (compatibleObject3.has(iIntValue2, compatibleObject3) && isEnumerable(iIntValue2, compatibleObject3)) {
                            i2 = i4 + 1;
                            ids2[i4] = context.newArray(scriptable, new Object[]{ScriptRuntime.toString(ids2[i5]), compatibleObject3.get(iIntValue2, compatibleObject3)});
                            i4 = i2;
                        }
                    } else {
                        String string2 = ScriptRuntime.toString(obj4);
                        if (compatibleObject3.has(string2, compatibleObject3) && isEnumerable(string2, compatibleObject3)) {
                            i2 = i4 + 1;
                            ids2[i4] = context.newArray(scriptable, new Object[]{string2, compatibleObject3.get(string2, compatibleObject3)});
                            i4 = i2;
                        }
                    }
                }
                if (i4 != ids2.length) {
                    ids2 = Arrays.copyOf(ids2, i4);
                }
                return context.newArray(scriptable, ids2);
            case ConstructorId_setPrototypeOf /* -18 */:
                if (objArr.length < 2) {
                    throw ScriptRuntime.typeErrorById("msg.method.missing.parameter", "Object.setPrototypeOf", "2", Integer.toString(objArr.length));
                }
                Object obj5 = objArr[1];
                Scriptable scriptableEnsureScriptable = obj5 == null ? null : ScriptableObject.ensureScriptable(obj5);
                if (scriptableEnsureScriptable instanceof Symbol) {
                    throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(scriptableEnsureScriptable));
                }
                Object obj6 = objArr[0];
                if (context.getLanguageVersion() >= 200) {
                    ScriptRuntimeES6.requireObjectCoercible(context, obj6, idFunctionObject);
                }
                if (!(obj6 instanceof ScriptableObject)) {
                    return obj6;
                }
                ScriptableObject scriptableObject2 = (ScriptableObject) obj6;
                if (!scriptableObject2.isExtensible()) {
                    throw ScriptRuntime.typeErrorById("msg.not.extensible", new Object[0]);
                }
                for (Scriptable prototype2 = scriptableEnsureScriptable; prototype2 != null; prototype2 = prototype2.getPrototype()) {
                    if (prototype2 == scriptableObject2) {
                        throw ScriptRuntime.typeErrorById("msg.object.cyclic.prototype", scriptableObject2.getClass().getSimpleName());
                    }
                }
                scriptableObject2.setPrototype(scriptableEnsureScriptable);
                return scriptableObject2;
            case ConstructorId_is /* -17 */:
                return ScriptRuntime.wrapBoolean(ScriptRuntime.same(objArr.length < 1 ? Undefined.instance : objArr[0], objArr.length < 2 ? Undefined.instance : objArr[1]));
            case ConstructorId_assign /* -16 */:
                Scriptable object = objArr.length > 0 ? ScriptRuntime.toObject(context, scriptable, objArr[0]) : ScriptRuntime.toObject(context, scriptable, Undefined.instance);
                for (int i6 = 1; i6 < objArr.length; i6++) {
                    Object obj7 = objArr[i6];
                    if (obj7 != null && !Undefined.isUndefined(obj7)) {
                        Scriptable object2 = ScriptRuntime.toObject(context, scriptable, objArr[i6]);
                        for (Object obj8 : object2.getIds()) {
                            if (obj8 instanceof Integer) {
                                int iIntValue3 = ((Integer) obj8).intValue();
                                if (object2.has(iIntValue3, object2) && isEnumerable(iIntValue3, object2)) {
                                    AbstractEcmaObjectOperations.put(context, object, iIntValue3, object2.get(iIntValue3, object2), true);
                                }
                            } else {
                                String string3 = ScriptRuntime.toString(obj8);
                                if (object2.has(string3, object2) && isEnumerable(string3, object2)) {
                                    AbstractEcmaObjectOperations.put(context, object, string3, object2.get(string3, object2), true);
                                }
                            }
                        }
                    }
                }
                return object;
            case ConstructorId_getOwnPropertySymbols /* -15 */:
                Object[] ids3 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getIds(true, true);
                ArrayList arrayList = new ArrayList();
                for (Object obj9 : ids3) {
                    if (obj9 instanceof Symbol) {
                        arrayList.add(obj9);
                    }
                }
                return context.newArray(scriptable, arrayList.toArray());
            case ConstructorId_freeze /* -14 */:
                Object obj10 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if ((context.getLanguageVersion() < 200 || (obj10 instanceof ScriptableObject)) && !AbstractEcmaObjectOperations.setIntegrityLevel(context, obj10, AbstractEcmaObjectOperations.INTEGRITY_LEVEL.FROZEN)) {
                    throw ScriptRuntime.typeError("Object is not freezable");
                }
                return obj10;
            case ConstructorId_seal /* -13 */:
                Object obj11 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if ((context.getLanguageVersion() < 200 || (obj11 instanceof ScriptableObject)) && !AbstractEcmaObjectOperations.setIntegrityLevel(context, obj11, AbstractEcmaObjectOperations.INTEGRITY_LEVEL.SEALED)) {
                    throw ScriptRuntime.typeError("Object is not sealable");
                }
                return obj11;
            case ConstructorId_isFrozen /* -12 */:
                Object obj12 = objArr.length < 1 ? Undefined.instance : objArr[0];
                return (context.getLanguageVersion() < 200 || (obj12 instanceof ScriptableObject)) ? Boolean.valueOf(AbstractEcmaObjectOperations.testIntegrityLevel(context, obj12, AbstractEcmaObjectOperations.INTEGRITY_LEVEL.FROZEN)) : Boolean.TRUE;
            case ConstructorId_isSealed /* -11 */:
                Object obj13 = objArr.length < 1 ? Undefined.instance : objArr[0];
                return (context.getLanguageVersion() < 200 || (obj13 instanceof ScriptableObject)) ? Boolean.valueOf(AbstractEcmaObjectOperations.testIntegrityLevel(context, obj13, AbstractEcmaObjectOperations.INTEGRITY_LEVEL.SEALED)) : Boolean.TRUE;
            case ConstructorId_create /* -10 */:
                Object obj14 = objArr.length < 1 ? Undefined.instance : objArr[0];
                Scriptable scriptableEnsureScriptable2 = obj14 == null ? null : ScriptableObject.ensureScriptable(obj14);
                NativeObject nativeObject2 = new NativeObject();
                nativeObject2.setParentScope(scriptable);
                nativeObject2.setPrototype(scriptableEnsureScriptable2);
                if (objArr.length > 1 && !Undefined.isUndefined(objArr[1])) {
                    nativeObject2.defineOwnProperties(context, ScriptableObject.ensureScriptableObject(Context.toObject(objArr[1], scriptable)));
                }
                return nativeObject2;
            case ConstructorId_defineProperties /* -9 */:
                ScriptableObject scriptableObjectEnsureScriptableObject = ScriptableObject.ensureScriptableObject(objArr.length < 1 ? Undefined.instance : objArr[0]);
                scriptableObjectEnsureScriptableObject.defineOwnProperties(context, ScriptableObject.ensureScriptableObject(Context.toObject(objArr.length < 2 ? Undefined.instance : objArr[1], scriptable)));
                return scriptableObjectEnsureScriptableObject;
            case ConstructorId_preventExtensions /* -8 */:
                Object obj15 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj15 instanceof ScriptableObject)) {
                    return obj15;
                }
                ScriptableObject scriptableObjectEnsureScriptableObject2 = ScriptableObject.ensureScriptableObject(obj15);
                if (scriptableObjectEnsureScriptableObject2.preventExtensions()) {
                    return scriptableObjectEnsureScriptableObject2;
                }
                throw ScriptRuntime.typeError("Object.preventExtensions is not allowed");
            case ConstructorId_isExtensible /* -7 */:
                Object obj16 = objArr.length < 1 ? Undefined.instance : objArr[0];
                return (context.getLanguageVersion() < 200 || (obj16 instanceof ScriptableObject)) ? Boolean.valueOf(ScriptableObject.ensureScriptableObject(obj16).isExtensible()) : Boolean.FALSE;
            case ConstructorId_defineProperty /* -6 */:
                ScriptableObject scriptableObjectEnsureScriptableObject3 = ScriptableObject.ensureScriptableObject(objArr.length < 1 ? Undefined.instance : objArr[0]);
                scriptableObjectEnsureScriptableObject3.defineOwnProperty(context, objArr.length < 2 ? Undefined.instance : objArr[1], ScriptableObject.ensureScriptableObject(objArr.length < 3 ? Undefined.instance : objArr[2]));
                return scriptableObjectEnsureScriptableObject3;
            case ConstructorId_getOwnPropertyDescriptors /* -5 */:
                ScriptableObject scriptableObjectEnsureScriptableObject4 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]));
                ScriptableObject scriptableObject3 = (ScriptableObject) context.newObject(scriptable);
                for (Object obj17 : scriptableObjectEnsureScriptableObject4.getIds(true, true)) {
                    Object ownPropertyDescriptor = scriptableObjectEnsureScriptableObject4.getOwnPropertyDescriptor(context, obj17);
                    if (ownPropertyDescriptor != null) {
                        if (obj17 instanceof Symbol) {
                            scriptableObject3.put((Symbol) obj17, scriptableObject3, ownPropertyDescriptor);
                        } else if (obj17 instanceof Integer) {
                            scriptableObject3.put(((Integer) obj17).intValue(), scriptableObject3, ownPropertyDescriptor);
                        } else {
                            scriptableObject3.put(ScriptRuntime.toString(obj17), scriptableObject3, ownPropertyDescriptor);
                        }
                    }
                }
                return scriptableObject3;
            case ConstructorId_getOwnPropertyDescriptor /* -4 */:
                ScriptableObject ownPropertyDescriptor2 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getOwnPropertyDescriptor(context, objArr.length < 2 ? Undefined.instance : objArr[1]);
                return ownPropertyDescriptor2 == null ? Undefined.instance : ownPropertyDescriptor2;
            case ConstructorId_getOwnPropertyNames /* -3 */:
                Object[] ids4 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getIds(true, false);
                for (int i7 = 0; i7 < ids4.length; i7++) {
                    ids4[i7] = ScriptRuntime.toString(ids4[i7]);
                }
                return context.newArray(scriptable, ids4);
            case ConstructorId_keys /* -2 */:
                Object[] ids5 = getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]).getIds();
                for (int i8 = 0; i8 < ids5.length; i8++) {
                    ids5[i8] = ScriptRuntime.toString(ids5[i8]);
                }
                return context.newArray(scriptable, ids5);
            case -1:
                return getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]).getPrototype();
            case 0:
            default:
                jl.a(String.valueOf(iMethodId));
                return null;
            case 1:
                return scriptable2 != null ? idFunctionObject.construct(context, scriptable, objArr) : (objArr.length == 0 || (obj = objArr[0]) == null || Undefined.isUndefined(obj)) ? context.newObject(scriptable) : ScriptRuntime.toObject(context, scriptable, objArr[0]);
            case 2:
                if (!context.hasFeature(4)) {
                    return ScriptRuntime.defaultObjectToString(scriptable2);
                }
                String strDefaultObjectToSource = ScriptRuntime.defaultObjectToSource(context, scriptable, scriptable2, objArr);
                int length = strDefaultObjectToSource.length();
                if (length == 0 || strDefaultObjectToSource.charAt(0) != '(') {
                    return strDefaultObjectToSource;
                }
                int i9 = length - 1;
                return strDefaultObjectToSource.charAt(i9) == ')' ? strDefaultObjectToSource.substring(1, i9) : strDefaultObjectToSource;
            case 3:
                if (scriptable2 == null) {
                    throw ScriptRuntime.notFunctionError(null);
                }
                Object property = ScriptableObject.getProperty(scriptable2, "toString");
                if (property instanceof Callable) {
                    return ((Callable) property).call(context, scriptable, scriptable2, ScriptRuntime.emptyArgs);
                }
                throw ScriptRuntime.notFunctionError(property);
            case 4:
                if (context.getLanguageVersion() < 180 || !(scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    return scriptable2;
                }
                throw ScriptRuntime.typeErrorById("msg." + (scriptable2 == null ? "null" : "undef") + ".to.object", new Object[0]);
            case 5:
                if (context.getLanguageVersion() < 180 || !(scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    return Boolean.valueOf(AbstractEcmaObjectOperations.hasOwnProperty(context, scriptable2, objArr.length < 1 ? Undefined.instance : objArr[0]));
                }
                throw ScriptRuntime.typeErrorById("msg." + (scriptable2 == null ? "null" : "undef") + ".to.object", new Object[0]);
            case 6:
                if (context.getLanguageVersion() >= 180 && (scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    throw ScriptRuntime.typeErrorById("msg." + (scriptable2 == null ? "null" : "undef") + ".to.object", new Object[0]);
                }
                Object obj18 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (obj18 instanceof Symbol) {
                    Symbol symbol = (Symbol) obj18;
                    if (((SymbolScriptable) scriptable2).has(symbol, scriptable2)) {
                        boolean zIsEnumerable = isEnumerable(symbol, scriptable2);
                        r1 = symbol;
                        break;
                    }
                    return ScriptRuntime.wrapBoolean(z2);
                }
                stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(obj18);
                try {
                    String str = stringIdOrIndex.stringId;
                    if (str == null) {
                        boolean zHas = scriptable2.has(stringIdOrIndex.index, scriptable2);
                        stringIdOrIndex = stringIdOrIndex;
                        if (zHas) {
                            boolean zIsEnumerable2 = isEnumerable(stringIdOrIndex.index, scriptable2);
                            stringIdOrIndex = stringIdOrIndex;
                            if (zIsEnumerable2) {
                                r1 = stringIdOrIndex;
                            }
                        }
                    } else {
                        stringIdOrIndex = stringIdOrIndex;
                        if (scriptable2.has(str, scriptable2)) {
                            boolean zIsEnumerable3 = isEnumerable(stringIdOrIndex.stringId, scriptable2);
                            r1 = stringIdOrIndex;
                            stringIdOrIndex = stringIdOrIndex;
                            if (zIsEnumerable3) {
                            }
                        }
                    }
                    break;
                } catch (EvaluatorException e) {
                    String message = e.getMessage();
                    String string4 = stringIdOrIndex.stringId;
                    if (string4 == null) {
                        string4 = Integer.toString(stringIdOrIndex.index);
                    }
                    if (!message.startsWith(ScriptRuntime.getMessageById("msg.prop.not.found", string4))) {
                        throw e;
                    }
                }
                return ScriptRuntime.wrapBoolean(z2);
                z2 = true;
                stringIdOrIndex = r1;
                return ScriptRuntime.wrapBoolean(z2);
            case 7:
                if (context.getLanguageVersion() >= 180 && (scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    throw ScriptRuntime.typeErrorById("msg." + (scriptable2 == null ? "null" : "undef") + ".to.object", new Object[0]);
                }
                if (objArr.length != 0) {
                    Object obj19 = objArr[0];
                    if (obj19 instanceof Scriptable) {
                        Scriptable prototype3 = (Scriptable) obj19;
                        while (true) {
                            prototype3 = prototype3.getPrototype();
                            if (prototype3 == scriptable2) {
                                z = true;
                            } else if (prototype3 == null) {
                            }
                        }
                    }
                }
                return ScriptRuntime.wrapBoolean(z);
            case 8:
                return ScriptRuntime.defaultObjectToSource(context, scriptable, scriptable2, objArr);
            case 9:
            case 10:
                if (objArr.length < 2 || !(objArr[1] instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(objArr.length >= 2 ? objArr[1] : Undefined.instance);
                }
                if (!(scriptable2 instanceof ScriptableObject)) {
                    throw Context.reportRuntimeErrorById("msg.extend.scriptable", scriptable2 != null ? scriptable2.getClass().getName() : "null", String.valueOf(objArr[0]));
                }
                ScriptableObject scriptableObject4 = (ScriptableObject) scriptable2;
                ScriptRuntime.StringIdOrIndex stringIdOrIndex2 = ScriptRuntime.toStringIdOrIndex(objArr[0]);
                String str2 = stringIdOrIndex2.stringId;
                scriptableObject4.setGetterOrSetter(str2, str2 != null ? 0 : stringIdOrIndex2.index, (Callable) objArr[1], iMethodId == 10);
                if (scriptableObject4 instanceof NativeArray) {
                    ((NativeArray) scriptableObject4).setDenseOnly(false);
                }
                return Undefined.instance;
            case 11:
            case 12:
                if (objArr.length < 1 || !(scriptable2 instanceof ScriptableObject)) {
                    return Undefined.instance;
                }
                ScriptableObject scriptableObject5 = (ScriptableObject) scriptable2;
                ScriptRuntime.StringIdOrIndex stringIdOrIndex3 = ScriptRuntime.toStringIdOrIndex(objArr[0]);
                int i10 = stringIdOrIndex3.stringId != null ? 0 : stringIdOrIndex3.index;
                boolean z3 = iMethodId == 12;
                while (true) {
                    getterOrSetter = scriptableObject5.getGetterOrSetter(stringIdOrIndex3.stringId, i10, this, z3);
                    if (getterOrSetter == null && (prototype = scriptableObject5.getPrototype()) != null && (prototype instanceof ScriptableObject)) {
                        scriptableObject5 = (ScriptableObject) prototype;
                    }
                }
                return getterOrSetter != null ? getterOrSetter : Undefined.instance;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Object";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public Set<Object> keySet() {
        return new KeySet();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return ScriptRuntime.defaultObjectToString(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
