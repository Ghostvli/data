package org.mozilla.javascript;

import defpackage.cz3;
import defpackage.d04;
import defpackage.jl;
import defpackage.wg1;
import defpackage.zy3;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.mozilla.javascript.AccessorSlot;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Slot;
import org.mozilla.javascript.SlotMap;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;
import org.mozilla.javascript.annotations.JSGetter;
import org.mozilla.javascript.annotations.JSSetter;
import org.mozilla.javascript.annotations.JSStaticFunction;
import org.mozilla.javascript.debug.DebuggableObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ScriptableObject implements Scriptable, SymbolScriptable, Serializable, DebuggableObject, ConstProperties {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONST = 13;
    public static final int DONTENUM = 2;
    public static final int EMPTY = 0;
    private static final Method GET_ARRAY_LENGTH;
    private static final Comparator<Object> KEY_COMPARATOR;
    public static final int PERMANENT = 4;
    public static final int READONLY = 1;
    public static final int UNINITIALIZED_CONST = 8;
    private static final long serialVersionUID = 2829861078851942586L;
    private volatile Map<Object, Object> associatedValues;
    private transient ExternalArrayData externalData;
    private boolean isExtensible;
    private boolean isSealed;
    private Scriptable parentScopeObject;
    private Scriptable prototypeObject;
    private transient SlotMapContainer slotMap;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class KeyComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = 6411335891523988149L;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (!(obj instanceof Integer)) {
                return obj2 instanceof Integer ? 1 : 0;
            }
            if (obj2 instanceof Integer) {
                return ((Integer) obj).compareTo((Integer) obj2);
            }
            return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        try {
            GET_ARRAY_LENGTH = ScriptableObject.class.getMethod("getExternalArrayLength", null);
            KEY_COMPARATOR = new KeyComparator();
        } catch (NoSuchMethodException e) {
            wg1.a(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        this.isExtensible = true;
        this.isSealed = false;
        if (scriptable == null) {
            d04.a();
            throw null;
        }
        this.parentScopeObject = scriptable;
        this.prototypeObject = scriptable2;
        this.slotMap = createSlotMap(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:200:0x008c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0102 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T extends Scriptable> BaseFunction buildClassCtor(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InvocationTargetException {
        Constructor<?> constructor;
        Class<T> cls2;
        Scriptable classPrototype;
        Annotation annotation;
        String str;
        HashSet hashSet;
        String str2;
        int i;
        String strDefineClass;
        BaseFunction baseFunction;
        Object prototypeProperty;
        Method[] methodList = FunctionObject.getMethodList(cls);
        int length = methodList.length;
        int i2 = 0;
        while (true) {
            int i3 = 3;
            int i4 = 2;
            int i5 = 1;
            if (i2 >= length) {
                Constructor<?>[] constructors = cls.getConstructors();
                int length2 = constructors.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        constructor = null;
                        break;
                    }
                    constructor = constructors[i6];
                    if (constructor.getParameterTypes().length == 0) {
                        break;
                    }
                    i6++;
                }
                if (constructor == null) {
                    throw Context.reportRuntimeErrorById("msg.zero.arg.ctor", cls.getName());
                }
                Scriptable scriptable2 = (Scriptable) constructor.newInstance(ScriptRuntime.emptyArgs);
                String className = scriptable2.getClassName();
                Object property = getProperty(getTopLevelScope(scriptable), className);
                if (!(property instanceof BaseFunction) || (prototypeProperty = (baseFunction = (BaseFunction) property).getPrototypeProperty()) == null) {
                    cls2 = cls;
                } else {
                    cls2 = cls;
                    if (cls2.equals(prototypeProperty.getClass())) {
                        return baseFunction;
                    }
                }
                if (z2) {
                    Class<? super T> superclass = cls2.getSuperclass();
                    classPrototype = (!ScriptRuntime.ScriptableClass.isAssignableFrom(superclass) || Modifier.isAbstract(superclass.getModifiers()) || (strDefineClass = defineClass(scriptable, extendsScriptable(superclass), z, z2)) == null) ? null : getClassPrototype(scriptable, strDefineClass);
                }
                if (classPrototype == null) {
                    classPrototype = getObjectPrototype(scriptable);
                }
                scriptable2.setPrototype(classPrototype);
                Member memberFindAnnotatedMember = findAnnotatedMember(methodList, JSConstructor.class);
                Member memberFindAnnotatedMember2 = memberFindAnnotatedMember;
                if (memberFindAnnotatedMember == null) {
                    memberFindAnnotatedMember2 = findAnnotatedMember(constructors, JSConstructor.class);
                }
                String str3 = "jsConstructor";
                Member memberFindSingleMethod = memberFindAnnotatedMember2;
                if (memberFindAnnotatedMember2 == null) {
                    memberFindSingleMethod = FunctionObject.findSingleMethod(methodList, "jsConstructor");
                }
                if (memberFindSingleMethod == null) {
                    if (constructors.length == 1) {
                        memberFindSingleMethod = constructors[0];
                    } else {
                        memberFindSingleMethod = memberFindSingleMethod;
                        if (constructors.length == 2) {
                            if (constructors[0].getParameterTypes().length == 0) {
                                memberFindSingleMethod = constructors[1];
                            } else {
                                memberFindSingleMethod = memberFindSingleMethod;
                                if (constructors[1].getParameterTypes().length == 0) {
                                    memberFindSingleMethod = constructors[0];
                                }
                            }
                        }
                    }
                    if (memberFindSingleMethod == null) {
                        throw Context.reportRuntimeErrorById("msg.ctor.multiple.parms", cls2.getName());
                    }
                }
                FunctionObject functionObject = new FunctionObject(className, memberFindSingleMethod, scriptable);
                if (functionObject.isVarArgsMethod()) {
                    throw Context.reportRuntimeErrorById("msg.varargs.ctor", memberFindSingleMethod.getName());
                }
                functionObject.initAsConstructor(scriptable, scriptable2, 7);
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                int length3 = methodList.length;
                int i7 = 0;
                Method method = null;
                while (i7 < length3) {
                    int i8 = i5;
                    Method method2 = methodList[i7];
                    if (method2 == memberFindSingleMethod) {
                        str = str3;
                        i = i4;
                        hashSet = hashSet2;
                    } else {
                        String name = method2.getName();
                        int i9 = i4;
                        if (name.equals("finishInit")) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (parameterTypes.length == i3) {
                                Class<?> cls3 = parameterTypes[0];
                                Class<Scriptable> cls4 = ScriptRuntime.ScriptableClass;
                                if (cls3 == cls4 && parameterTypes[i8] == FunctionObject.class && parameterTypes[i9] == cls4 && Modifier.isStatic(method2.getModifiers())) {
                                    str = str3;
                                    method = method2;
                                } else if (name.indexOf(36) == -1 && !name.equals(str3)) {
                                    if (method2.isAnnotationPresent(JSFunction.class)) {
                                        annotation = method2.getAnnotation(JSFunction.class);
                                    } else if (method2.isAnnotationPresent(JSStaticFunction.class)) {
                                        annotation = method2.getAnnotation(JSStaticFunction.class);
                                    } else if (method2.isAnnotationPresent(JSGetter.class)) {
                                        annotation = method2.getAnnotation(JSGetter.class);
                                    } else {
                                        if (!method2.isAnnotationPresent(JSSetter.class)) {
                                            annotation = null;
                                        }
                                        str = str3;
                                    }
                                    str = str3;
                                    if (annotation == null) {
                                        str2 = "jsFunction_";
                                        if (!name.startsWith("jsFunction_")) {
                                            if (name.startsWith("jsStaticFunction_")) {
                                                str2 = "jsStaticFunction_";
                                            } else if (name.startsWith("jsGet_")) {
                                                str2 = "jsGet_";
                                            }
                                        }
                                        hashSet = hashSet2;
                                    } else {
                                        hashSet = hashSet2;
                                        str2 = null;
                                    }
                                    int i10 = ((annotation instanceof JSStaticFunction) || Objects.equals(str2, "jsStaticFunction_")) ? i8 : 0;
                                    HashSet hashSet4 = i10 != 0 ? hashSet : hashSet3;
                                    int i11 = i10;
                                    String propertyName = getPropertyName(name, str2, annotation);
                                    if (hashSet4.contains(propertyName)) {
                                        throw Context.reportRuntimeErrorById("duplicate.defineClass.name", name, propertyName);
                                    }
                                    hashSet4.add(propertyName);
                                    if ((annotation instanceof JSGetter) || Objects.equals(str2, "jsGet_")) {
                                        i = i9;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeErrorById("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        Method methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, (Object) null, method2, methodFindSetterMethod, (methodFindSetterMethod != null ? 0 : i8) | 6);
                                    } else {
                                        if (i11 != 0 && !Modifier.isStatic(method2.getModifiers())) {
                                            throw Context.reportRuntimeError("jsStaticFunction must be used with static method.");
                                        }
                                        FunctionObject functionObject2 = new FunctionObject(propertyName, method2, scriptable2);
                                        if (functionObject2.isVarArgsConstructor()) {
                                            throw Context.reportRuntimeErrorById("msg.varargs.fun", memberFindSingleMethod.getName());
                                        }
                                        i = i9;
                                        defineProperty(i11 != 0 ? functionObject : scriptable2, propertyName, functionObject2, i);
                                        if (z) {
                                            functionObject2.sealObject();
                                        }
                                    }
                                } else {
                                    str = str3;
                                }
                                hashSet = hashSet2;
                                i = i9;
                            }
                        }
                    }
                    i7++;
                    hashSet2 = hashSet;
                    str3 = str;
                    i4 = i;
                    i5 = i8;
                    i3 = 3;
                }
                if (method != null) {
                    method.invoke(null, scriptable, functionObject, scriptable2);
                }
                if (z) {
                    functionObject.sealObject();
                    if (scriptable2 instanceof ScriptableObject) {
                        ((ScriptableObject) scriptable2).sealObject();
                    }
                }
                return functionObject;
            }
            Method method3 = methodList[i2];
            if (method3.getName().equals("init")) {
                Class<?>[] parameterTypes2 = method3.getParameterTypes();
                if (parameterTypes2.length == 3 && parameterTypes2[0] == ScriptRuntime.ContextClass && parameterTypes2[1] == ScriptRuntime.ScriptableClass && parameterTypes2[2] == Boolean.TYPE && Modifier.isStatic(method3.getModifiers())) {
                    method3.invoke(null, Context.getContext(), scriptable, z ? Boolean.TRUE : Boolean.FALSE);
                    return null;
                }
                if (parameterTypes2.length == 1 && parameterTypes2[0] == ScriptRuntime.ScriptableClass && Modifier.isStatic(method3.getModifiers())) {
                    method3.invoke(null, scriptable);
                    return null;
                }
            }
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ScriptableObject buildDataDescriptor(Scriptable scriptable, Object obj, int i) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        nativeObject.defineProperty(ES6Iterator.VALUE_PROPERTY, obj, 0);
        nativeObject.setCommonDescriptorProperties(i, true);
        return nativeObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Slot c(ScriptableObject scriptableObject, boolean z, Object obj, ScriptableObject scriptableObject2, Object obj2, Object obj3, Object obj4, boolean z2, Object obj5, Object obj6, Object obj7, Object obj8, int i, Slot slot) {
        int iApplyDescriptorToAttributeBitset;
        Slot slot2;
        AccessorSlot accessorSlot;
        if (z) {
            scriptableObject.checkPropertyChangeForSlot(obj, slot, scriptableObject2);
        } else {
            scriptableObject.getClass();
        }
        if (slot == null) {
            slot2 = new Slot(obj8, i, 0);
            iApplyDescriptorToAttributeBitset = scriptableObject.applyDescriptorToAttributeBitset(7, obj2, obj3, obj4);
        } else {
            iApplyDescriptorToAttributeBitset = scriptableObject.applyDescriptorToAttributeBitset(slot.getAttributes(), obj2, obj3, obj4);
            slot2 = slot;
        }
        if (z2) {
            if (slot2 instanceof AccessorSlot) {
                accessorSlot = (AccessorSlot) slot2;
            } else {
                accessorSlot = new AccessorSlot(slot2);
                slot2 = accessorSlot;
            }
            Object obj9 = Scriptable.NOT_FOUND;
            if (obj5 != obj9) {
                accessorSlot.getter = new AccessorSlot.FunctionGetter(obj5);
            }
            if (obj6 != obj9) {
                accessorSlot.setter = new AccessorSlot.FunctionSetter(obj6);
            }
            accessorSlot.value = Undefined.instance;
        } else {
            if (!slot2.isValueSlot() && isDataDescriptor(scriptableObject2)) {
                slot2 = new Slot(slot2);
            }
            if (obj7 != Scriptable.NOT_FOUND) {
                slot2.value = obj7;
            } else if (slot == null) {
                slot2.value = Undefined.instance;
            }
        }
        slot2.setAttributes(iApplyDescriptorToAttributeBitset);
        return slot2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object callMethod(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Object property = getProperty(scriptable, str);
        if (!(property instanceof Function)) {
            throw ScriptRuntime.notFunctionError(scriptable, str);
        }
        Function function = (Function) property;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        return context != null ? function.call(context, topLevelScope, scriptable, objArr) : Context.call(null, function, topLevelScope, scriptable, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void checkNotSealed(Object obj, int i) {
        if (isSealed()) {
            throw Context.reportRuntimeErrorById("msg.modify.sealed", obj != null ? obj.toString() : Integer.toString(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Slot checkSlotRemoval(Object obj, int i, Slot slot) {
        if (slot == null || (slot.getAttributes() & 4) == 0) {
            return null;
        }
        if (Context.getContext().isStrictMode()) {
            throw ScriptRuntime.typeErrorById("msg.delete.property.with.configurable.false", obj);
        }
        return slot;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void checkValidAttributes(int i) {
        if ((i & (-16)) == 0) {
            return;
        }
        jl.a(String.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private LambdaAccessorSlot createLambdaAccessorSlot(Object obj, int i, java.util.function.Function<Scriptable, Object> function, BiConsumer<Scriptable, Object> biConsumer, int i2) {
        LambdaAccessorSlot lambdaAccessorSlot = new LambdaAccessorSlot(obj, i);
        lambdaAccessorSlot.setGetter(this, function);
        lambdaAccessorSlot.setSetter(this, biConsumer);
        lambdaAccessorSlot.setAttributes(i2);
        return lambdaAccessorSlot;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static SlotMapContainer createSlotMap(int i) {
        Context currentContext = Context.getCurrentContext();
        return (currentContext == null || !currentContext.hasFeature(17)) ? new SlotMapContainer(i) : new ThreadSafeSlotMapContainer(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ LambdaAccessorSlot d(ScriptableObject scriptableObject, Context context, String str, LambdaAccessorSlot lambdaAccessorSlot, ScriptableObject scriptableObject2, Object obj, int i, Slot slot) {
        if (slot != null) {
            return scriptableObject.replaceExistingLambdaSlot(context, str, slot, lambdaAccessorSlot);
        }
        scriptableObject.checkPropertyChangeForSlot(str, null, scriptableObject2);
        return lambdaAccessorSlot;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static <T extends Scriptable> String defineClass(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InvocationTargetException {
        BaseFunction baseFunctionBuildClassCtor = buildClassCtor(scriptable, cls, z, z2);
        if (baseFunctionBuildClassCtor == null) {
            return null;
        }
        String className = baseFunctionBuildClassCtor.getClassPrototype().getClassName();
        defineProperty(scriptable, className, baseFunctionBuildClassCtor, 2);
        return className;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void defineConstProperty(Scriptable scriptable, String str) {
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        } else {
            defineProperty(scriptable, str, Undefined.instance, 13);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean deleteProperty(Scriptable scriptable, Symbol symbol) {
        Scriptable base = getBase(scriptable, symbol);
        if (base == null) {
            return true;
        }
        ensureSymbolScriptable(base).delete(symbol);
        return !r0.has(symbol, scriptable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static AccessorSlot ensureAccessorSlot(Object obj, int i, Slot slot) {
        return slot == null ? new AccessorSlot(obj, i) : slot instanceof AccessorSlot ? (AccessorSlot) slot : new AccessorSlot(slot);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static LambdaSlot ensureLambdaSlot(Object obj, int i, Slot slot) {
        return slot == null ? new LambdaSlot(obj, i) : slot instanceof LambdaSlot ? (LambdaSlot) slot : new LambdaSlot(slot);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static LazyLoadSlot ensureLazySlot(Object obj, int i, Slot slot) {
        return slot == null ? new LazyLoadSlot(obj, i) : slot instanceof LazyLoadSlot ? (LazyLoadSlot) slot : new LazyLoadSlot(slot);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable ensureScriptable(Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ScriptableObject ensureScriptableObject(Object obj) {
        if (obj instanceof ScriptableObject) {
            return (ScriptableObject) obj;
        }
        if (obj instanceof Delegator) {
            return (ScriptableObject) ((Delegator) obj).getDelegee();
        }
        throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ScriptableObject ensureScriptableObjectButNotSymbol(Object obj) {
        if (obj instanceof Symbol) {
            throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(obj));
        }
        return ensureScriptableObject(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SymbolScriptable ensureSymbolScriptable(Object obj) {
        if (obj instanceof SymbolScriptable) {
            return (SymbolScriptable) obj;
        }
        throw ScriptRuntime.typeErrorById("msg.object.not.symbolscriptable", ScriptRuntime.typeof(obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends Scriptable> Class<T> extendsScriptable(Class<?> cls) {
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.reflect.Method */
    /* JADX WARN: Multi-variable type inference failed */
    private static Member findAnnotatedMember(AccessibleObject[] accessibleObjectArr, Class<? extends Annotation> cls) {
        for (Method method : accessibleObjectArr) {
            if (method.isAnnotationPresent(cls)) {
                return method;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Method findSetterMethod(Method[] methodArr, String str, String str2) {
        String str3 = "set" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        for (Method method : methodArr) {
            JSSetter jSSetter = (JSSetter) method.getAnnotation(JSSetter.class);
            if (jSSetter != null && (str.equals(jSSetter.value()) || ("".equals(jSSetter.value()) && str3.equals(method.getName())))) {
                return method;
            }
        }
        String str4 = str2 + str;
        for (Method method2 : methodArr) {
            if (str4.equals(method2.getName())) {
                return method2;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable getArrayPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Array);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Slot getAttributeSlot(String str, int i) {
        Slot slotQuery = this.slotMap.query(str, i);
        if (slotQuery != null) {
            return slotQuery;
        }
        if (str == null) {
            str = Integer.toString(i);
        }
        throw Context.reportRuntimeErrorById("msg.prop.not.found", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Scriptable getBase(Scriptable scriptable, Symbol symbol) {
        Scriptable prototype = scriptable;
        while (!ensureSymbolScriptable(prototype).has(symbol, scriptable)) {
            prototype = prototype.getPrototype();
            if (prototype == null) {
                return prototype;
            }
        }
        return prototype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable getClassPrototype(Scriptable scriptable, String str) {
        Object prototypeProperty;
        Object property = getProperty(getTopLevelScope(scriptable), str);
        if (!(property instanceof BaseFunction)) {
            if (property instanceof Scriptable) {
                Scriptable scriptable2 = (Scriptable) property;
                prototypeProperty = scriptable2.get("prototype", scriptable2);
            }
            return null;
        }
        prototypeProperty = ((BaseFunction) property).getPrototypeProperty();
        if (prototypeProperty instanceof Scriptable) {
            return (Scriptable) prototypeProperty;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object getDefaultValue(Scriptable scriptable, Class<?> cls) {
        Context context = null;
        for (int i = 0; i < 2; i++) {
            boolean z = true;
            if (cls != ScriptRuntime.StringClass ? i != 1 : i != 0) {
                z = false;
            }
            Object property = getProperty(scriptable, z ? "toString" : "valueOf");
            if (property instanceof Function) {
                Function function = (Function) property;
                if (context == null) {
                    context = Context.getContext();
                }
                Object objCall = function.call(context, function.getParentScope(), scriptable, ScriptRuntime.emptyArgs);
                if (objCall != null) {
                    if ((objCall instanceof Scriptable) && cls != ScriptRuntime.ScriptableClass && cls != ScriptRuntime.FunctionClass) {
                        if (z && (objCall instanceof Wrapper)) {
                            objCall = ((Wrapper) objCall).unwrap();
                            if (objCall instanceof String) {
                            }
                        }
                    }
                    return objCall;
                }
                continue;
            }
        }
        throw ScriptRuntime.typeErrorById("msg.default.value", cls == null ? "undefined" : cls.getName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable getFunctionPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Function);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable getGeneratorFunctionPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.GeneratorFunction);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable getObjectPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Object);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object getPropWalkingPrototypeChain(Scriptable scriptable, Scriptable scriptable2, Symbol symbol) {
        Object obj;
        do {
            obj = ensureSymbolScriptable(scriptable).get(symbol, scriptable2);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable = scriptable.getPrototype();
        } while (scriptable != null);
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object getProperty(Scriptable scriptable, String str) {
        return getPropWalkingPrototypeChain(scriptable, str, scriptable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object[] getPropertyIds(Scriptable scriptable) {
        if (scriptable == null) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] ids = scriptable.getIds();
        HashSet hashSet = null;
        while (true) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                break;
            }
            Object[] ids2 = scriptable.getIds();
            if (ids2.length != 0) {
                if (hashSet == null) {
                    if (ids.length == 0) {
                        ids = ids2;
                    } else {
                        hashSet = new HashSet();
                        for (int i = 0; i != ids.length; i++) {
                            hashSet.add(ids[i]);
                        }
                        ids = null;
                    }
                }
                for (int i2 = 0; i2 != ids2.length; i2++) {
                    hashSet.add(ids2[i2]);
                }
            }
        }
        return hashSet != null ? hashSet.toArray() : ids;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String getPropertyName(String str, String str2, Annotation annotation) {
        String strValue;
        if (str2 != null) {
            return str.substring(str2.length());
        }
        if (annotation instanceof JSGetter) {
            strValue = ((JSGetter) annotation).value();
            if ((strValue == null || strValue.length() == 0) && str.length() > 3 && str.startsWith("get")) {
                strValue = str.substring(3);
                if (Character.isUpperCase(strValue.charAt(0))) {
                    if (strValue.length() == 1) {
                        strValue = strValue.toLowerCase(Locale.ROOT);
                    } else if (!Character.isUpperCase(strValue.charAt(1))) {
                        strValue = Character.toLowerCase(strValue.charAt(0)) + strValue.substring(1);
                    }
                }
            }
        } else {
            strValue = annotation instanceof JSFunction ? ((JSFunction) annotation).value() : annotation instanceof JSStaticFunction ? ((JSStaticFunction) annotation).value() : null;
        }
        return (strValue == null || strValue.length() == 0) ? str : strValue;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object getSuperProperty(Scriptable scriptable, Scriptable scriptable2, String str) {
        return getPropWalkingPrototypeChain(scriptable, str, scriptable2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable getTopLevelScope(Scriptable scriptable) {
        while (true) {
            Scriptable parentScope = scriptable.getParentScope();
            if (parentScope == null) {
                return scriptable;
            }
            scriptable = parentScope;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object getTopScopeValue(Scriptable scriptable, Object obj) {
        Object associatedValue;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        do {
            if ((topLevelScope instanceof ScriptableObject) && (associatedValue = ((ScriptableObject) topLevelScope).getAssociatedValue(obj)) != null) {
                return associatedValue;
            }
            topLevelScope = topLevelScope.getPrototype();
        } while (topLevelScope != null);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static <T> T getTypedProperty(Scriptable scriptable, int i, Class<T> cls) {
        Object property = getProperty(scriptable, i);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean hasProperty(Scriptable scriptable, String str) {
        return getBase(scriptable, str) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isAccessorDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, "get") || hasProperty(scriptableObject, "set");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isDataDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, ES6Iterator.VALUE_PROPERTY) || hasProperty(scriptableObject, "writable");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isFalse(Object obj) {
        return !isTrue(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isGenericDescriptor(ScriptableObject scriptableObject) {
        return (isDataDescriptor(scriptableObject) || isAccessorDescriptor(scriptableObject)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isTrue(Object obj) {
        return obj != Scriptable.NOT_FOUND && ScriptRuntime.toBoolean(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean putConstImpl(String str, int i, Scriptable scriptable, Object obj, int i2) {
        Slot slotQuery;
        if (!this.isExtensible && Context.getContext().isStrictMode()) {
            throw ScriptRuntime.typeErrorById("msg.not.extensible", new Object[0]);
        }
        if (this != scriptable) {
            slotQuery = this.slotMap.query(str, i);
            if (slotQuery == null) {
                return false;
            }
        } else {
            if (isExtensible()) {
                checkNotSealed(str, i);
                Slot slotModify = this.slotMap.modify(str, i, 13);
                int attributes = slotModify.getAttributes();
                if ((attributes & 1) == 0) {
                    throw Context.reportRuntimeErrorById("msg.var.redecl", str);
                }
                if ((attributes & 8) != 0) {
                    slotModify.value = obj;
                    if (i2 != 8) {
                        slotModify.setAttributes(attributes & (-9));
                    }
                }
                return true;
            }
            slotQuery = this.slotMap.query(str, i);
            if (slotQuery == null) {
                return true;
            }
        }
        return slotQuery.setValue(obj, this, scriptable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void putConstProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        if (base instanceof ConstProperties) {
            ((ConstProperties) base).putConst(str, scriptable, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean putImpl(Object obj, int i, Scriptable scriptable, Object obj2, boolean z) {
        Slot slotModify;
        if (this != scriptable) {
            slotModify = this.slotMap.query(obj, i);
            if (!this.isExtensible && ((slotModify == null || (!(slotModify instanceof AccessorSlot) && (slotModify.getAttributes() & 1) != 0)) && z)) {
                throw ScriptRuntime.typeErrorById("msg.not.extensible", new Object[0]);
            }
            if (slotModify == null) {
                return false;
            }
        } else if (this.isExtensible) {
            if (this.isSealed) {
                checkNotSealed(obj, i);
            }
            slotModify = this.slotMap.modify(obj, i, 0);
        } else {
            slotModify = this.slotMap.query(obj, i);
            if ((slotModify == null || !((slotModify instanceof AccessorSlot) || (slotModify.getAttributes() & 1) == 0)) && z) {
                throw ScriptRuntime.typeErrorById("msg.not.extensible", new Object[0]);
            }
            if (slotModify == null) {
                return true;
            }
        }
        return slotModify.setValue(obj2, this, scriptable, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void putProperty(Scriptable scriptable, Symbol symbol, Object obj) {
        Scriptable base = getBase(scriptable, symbol);
        if (base == null) {
            base = scriptable;
        }
        ensureSymbolScriptable(base).put(symbol, scriptable, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void putSuperProperty(Scriptable scriptable, Scriptable scriptable2, Symbol symbol, Object obj) {
        ensureSymbolScriptable(scriptable).put(symbol, scriptable2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        this.slotMap = createSlotMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.slotMap.add((Slot) objectInputStream.readObject());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void redefineProperty(Scriptable scriptable, String str, boolean z) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return;
        }
        if ((base instanceof ConstProperties) && ((ConstProperties) base).isConst(str)) {
            throw ScriptRuntime.typeErrorById("msg.const.redecl", str);
        }
        if (z) {
            throw ScriptRuntime.typeErrorById("msg.var.redecl", str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private LambdaAccessorSlot replaceExistingLambdaSlot(Context context, String str, Slot slot, LambdaAccessorSlot lambdaAccessorSlot) {
        LambdaAccessorSlot lambdaAccessorSlot2 = slot instanceof LambdaAccessorSlot ? (LambdaAccessorSlot) slot : new LambdaAccessorSlot(slot);
        lambdaAccessorSlot2.replaceWith(lambdaAccessorSlot);
        checkPropertyChangeForSlot(str, slot, lambdaAccessorSlot2.buildPropertyDescriptor(context));
        return lambdaAccessorSlot2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        long lock = this.slotMap.readLock();
        try {
            int iDirtySize = this.slotMap.dirtySize();
            if (iDirtySize == 0) {
                objectOutputStream.writeInt(0);
            } else {
                objectOutputStream.writeInt(iDirtySize);
                Iterator<Slot> it = this.slotMap.iterator();
                while (it.hasNext()) {
                    objectOutputStream.writeObject(it.next());
                }
            }
            this.slotMap.unlockRead(lock);
        } catch (Throwable th) {
            this.slotMap.unlockRead(lock);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addLazilyInitializedValue(String str, int i, LazilyLoadedCtor lazilyLoadedCtor, int i2) {
        if (str != null && i != 0) {
            jl.a(str);
            return;
        }
        checkNotSealed(str, i);
        LazyLoadSlot lazyLoadSlot = (LazyLoadSlot) this.slotMap.compute(str, i, new SlotMap.SlotComputer() { // from class: az3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.SlotMap.SlotComputer
            public final Slot compute(Object obj, int i3, Slot slot) {
                return ScriptableObject.ensureLazySlot(obj, i3, slot);
            }
        });
        lazyLoadSlot.setAttributes(i2);
        lazyLoadSlot.value = lazilyLoadedCtor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int applyDescriptorToAttributeBitset(int i, Object obj, Object obj2, Object obj3) {
        Object obj4 = Scriptable.NOT_FOUND;
        if (obj != obj4) {
            i = ScriptRuntime.toBoolean(obj) ? i & (-3) : i | 2;
        }
        if (obj2 != obj4) {
            i = ScriptRuntime.toBoolean(obj2) ? i & (-2) : i | 1;
        }
        return obj3 != obj4 ? ScriptRuntime.toBoolean(obj3) ? i & (-5) : i | 4 : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized Object associateValue(Object obj, Object obj2) {
        Map map;
        try {
            if (obj2 == null) {
                throw new IllegalArgumentException();
            }
            map = this.associatedValues;
            if (map == null) {
                map = new HashMap();
                this.associatedValues = map;
            }
        } catch (Throwable th) {
            throw th;
        }
        return Kit.initHash(map, obj, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean avoidObjectDetection() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void checkPropertyChangeForSlot(Object obj, Slot slot, ScriptableObject scriptableObject) {
        if (slot == null) {
            if (!isExtensible()) {
                throw ScriptRuntime.typeErrorById("msg.not.extensible", new Object[0]);
            }
            return;
        }
        if ((slot.getAttributes() & 4) != 0) {
            if (isTrue(getProperty(scriptableObject, "configurable"))) {
                throw ScriptRuntime.typeErrorById("msg.change.configurable.false.to.true", obj);
            }
            if (((slot.getAttributes() & 2) == 0) != isTrue(getProperty(scriptableObject, "enumerable"))) {
                throw ScriptRuntime.typeErrorById("msg.change.enumerable.with.configurable.false", obj);
            }
            boolean zIsDataDescriptor = isDataDescriptor(scriptableObject);
            boolean zIsAccessorDescriptor = isAccessorDescriptor(scriptableObject);
            if (zIsDataDescriptor || zIsAccessorDescriptor) {
                if (zIsDataDescriptor) {
                    if ((slot.getAttributes() & 1) != 0) {
                        if (isTrue(getProperty(scriptableObject, "writable"))) {
                            throw ScriptRuntime.typeErrorById("msg.change.writable.false.to.true.with.configurable.false", obj);
                        }
                        if (!sameValue(getProperty(scriptableObject, ES6Iterator.VALUE_PROPERTY), slot.value)) {
                            throw ScriptRuntime.typeErrorById("msg.change.value.with.writable.false", obj);
                        }
                        return;
                    }
                    return;
                }
                if (!zIsAccessorDescriptor || !(slot instanceof AccessorSlot)) {
                    throw ScriptRuntime.typeErrorById("msg.change.property.data.to.accessor.with.configurable.false", obj);
                }
                AccessorSlot accessorSlot = (AccessorSlot) slot;
                if (!accessorSlot.isSameSetterFunction(getProperty(scriptableObject, "set"))) {
                    throw ScriptRuntime.typeErrorById("msg.change.setter.with.configurable.false", obj);
                }
                if (!accessorSlot.isSameGetterFunction(getProperty(scriptableObject, "get"))) {
                    throw ScriptRuntime.typeErrorById("msg.change.getter.with.configurable.false", obj);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void checkPropertyDefinition(ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, "get");
        Object obj = Scriptable.NOT_FOUND;
        if (property != obj && property != Undefined.instance && !(property instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(property);
        }
        Object property2 = getProperty(scriptableObject, "set");
        if (property2 != obj && property2 != Undefined.instance && !(property2 instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(property2);
        }
        if (isDataDescriptor(scriptableObject) && isAccessorDescriptor(scriptableObject)) {
            throw ScriptRuntime.typeErrorById("msg.both.data.and.accessor.desc", new Object[0]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ConstProperties
    public void defineConst(String str, Scriptable scriptable) {
        if (putConstImpl(str, 0, scriptable, Undefined.instance, 8)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void defineFunctionProperties(String[] strArr, Class<?> cls, int i) {
        Method[] methodList = FunctionObject.getMethodList(cls);
        for (String str : strArr) {
            Method methodFindSingleMethod = FunctionObject.findSingleMethod(methodList, str);
            if (methodFindSingleMethod == null) {
                throw Context.reportRuntimeErrorById("msg.method.not.found", str, cls.getName());
            }
            defineProperty(str, new FunctionObject(str, methodFindSingleMethod, this), i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void defineOwnProperties(Context context, ScriptableObject scriptableObject) {
        Object[] ids = scriptableObject.getIds(false, true);
        ScriptableObject[] scriptableObjectArr = new ScriptableObject[ids.length];
        int length = ids.length;
        for (int i = 0; i < length; i++) {
            ScriptableObject scriptableObjectEnsureScriptableObject = ensureScriptableObject(ScriptRuntime.getObjectElem((Scriptable) scriptableObject, ids[i], context));
            checkPropertyDefinition(scriptableObjectEnsureScriptableObject);
            scriptableObjectArr[i] = scriptableObjectEnsureScriptableObject;
        }
        int length2 = ids.length;
        for (int i2 = 0; i2 < length2; i2++) {
            defineOwnProperty(context, ids[i2], scriptableObjectArr[i2]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean defineOwnProperty(Context context, final Object obj, final ScriptableObject scriptableObject, final boolean z) {
        int i;
        Object obj2;
        int i2 = 0;
        if (obj instanceof Symbol) {
            i = 0;
            obj2 = obj;
        } else {
            ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(obj);
            String str = stringIdOrIndex.stringId;
            if (str == null) {
                i2 = stringIdOrIndex.index;
                str = null;
            }
            i = i2;
            obj2 = str;
        }
        final Object property = getProperty(scriptableObject, "enumerable");
        final Object property2 = getProperty(scriptableObject, "writable");
        final Object property3 = getProperty(scriptableObject, "configurable");
        final Object property4 = getProperty(scriptableObject, "get");
        final Object property5 = getProperty(scriptableObject, "set");
        final Object property6 = getProperty(scriptableObject, ES6Iterator.VALUE_PROPERTY);
        final boolean zIsAccessorDescriptor = isAccessorDescriptor(scriptableObject);
        this.slotMap.compute(obj2, i, new SlotMap.SlotComputer() { // from class: yy3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.SlotMap.SlotComputer
            public final Slot compute(Object obj3, int i3, Slot slot) {
                return ScriptableObject.c(this.a, z, obj, scriptableObject, property, property2, property3, zIsAccessorDescriptor, property4, property5, property6, obj3, i3, slot);
            }
        });
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void defineProperty(String str, Object obj, Method method, Method method2, int i) {
        MemberBox memberBox;
        boolean z;
        boolean z2;
        String str2;
        Class<?> cls;
        Class<?> cls2 = Void.TYPE;
        MemberBox memberBox2 = null;
        str = null;
        String str3 = null;
        if (method != null) {
            memberBox = new MemberBox(method);
            if (Modifier.isStatic(method.getModifiers())) {
                memberBox.delegateTo = cls2;
                z2 = true;
            } else {
                boolean z3 = obj != null;
                memberBox.delegateTo = obj;
                z2 = z3;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 0) {
                str2 = z2 ? "msg.obj.getter.parms" : null;
                if (str2 != null) {
                    throw Context.reportRuntimeErrorById(str2, method.toString());
                }
            } else {
                if (parameterTypes.length != 1 || (((cls = parameterTypes[0]) != ScriptRuntime.ScriptableClass && cls != ScriptRuntime.ScriptableObjectClass) || !z2)) {
                    str2 = "msg.bad.getter.parms";
                }
                if (str2 != null) {
                }
            }
        } else {
            memberBox = null;
        }
        if (method2 != null) {
            if (method2.getReturnType() != cls2) {
                throw Context.reportRuntimeErrorById("msg.setter.return", method2.toString());
            }
            MemberBox memberBox3 = new MemberBox(method2);
            if (Modifier.isStatic(method2.getModifiers())) {
                memberBox3.delegateTo = cls2;
                z = true;
            } else {
                boolean z4 = obj != null;
                memberBox3.delegateTo = obj;
                z = z4;
            }
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            if (parameterTypes2.length == 1) {
                if (z) {
                    str3 = "msg.setter2.expected";
                }
            } else if (parameterTypes2.length == 2) {
                Class<?> cls3 = parameterTypes2[0];
                if (cls3 != ScriptRuntime.ScriptableClass && cls3 != ScriptRuntime.ScriptableObjectClass) {
                    str3 = "msg.setter2.parms";
                } else if (!z) {
                    str3 = "msg.setter1.parms";
                }
            } else {
                str3 = "msg.setter.parms";
            }
            if (str3 != null) {
                throw Context.reportRuntimeErrorById(str3, method2.toString());
            }
            memberBox2 = memberBox3;
        }
        AccessorSlot accessorSlot = (AccessorSlot) this.slotMap.compute(str, 0, new cz3());
        accessorSlot.setAttributes(i);
        if (memberBox != null) {
            accessorSlot.getter = new AccessorSlot.MemberBoxGetter(memberBox);
        }
        if (memberBox2 != null) {
            accessorSlot.setter = new AccessorSlot.MemberBoxSetter(memberBox2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        checkNotSealed(str, 0);
        this.slotMap.compute(str, 0, new zy3());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object equivalentValues(Object obj) {
        return this == obj ? Boolean.TRUE : Scriptable.NOT_FOUND;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object get(Object obj) {
        Object obj2 = obj instanceof String ? get((String) obj, this) : obj instanceof Symbol ? get((Symbol) obj, this) : obj instanceof Number ? get(((Number) obj).intValue(), this) : null;
        if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
            return null;
        }
        return obj2 instanceof Wrapper ? ((Wrapper) obj2).unwrap() : obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.debug.DebuggableObject
    public Object[] getAllIds() {
        return getIds(true, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object getAssociatedValue(Object obj) {
        Map<Object, Object> map = this.associatedValues;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getAttributes(String str) {
        return getAttributeSlot(str, 0).getAttributes();
    }

    @Override // org.mozilla.javascript.Scriptable
    public abstract String getClassName();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExternalArrayData getExternalArrayData() {
        return this.externalData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getExternalArrayLength() {
        ExternalArrayData externalArrayData = this.externalData;
        return Integer.valueOf(externalArrayData == null ? 0 : externalArrayData.getArrayLength());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getGetterOrSetter(String str, int i, Scriptable scriptable, boolean z) {
        if (str != null && i != 0) {
            jl.a(str);
            return null;
        }
        Slot slotQuery = this.slotMap.query(str, i);
        if (slotQuery == null) {
            return null;
        }
        Function setterFunction = z ? slotQuery.getSetterFunction(str, scriptable) : slotQuery.getGetterFunction(str, scriptable);
        return setterFunction == null ? Undefined.instance : setterFunction;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object[] getIds(boolean z, boolean z2) {
        Object[] objArr;
        ExternalArrayData externalArrayData = this.externalData;
        int arrayLength = externalArrayData == null ? 0 : externalArrayData.getArrayLength();
        if (arrayLength == 0) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            objArr = new Object[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                objArr[i] = Integer.valueOf(i);
            }
        }
        if (this.slotMap.isEmpty()) {
            return objArr;
        }
        long lock = this.slotMap.readLock();
        try {
            int i2 = arrayLength;
            for (Slot slot : this.slotMap) {
                if (z || (slot.getAttributes() & 2) == 0) {
                    if (z2 || !(slot.name instanceof Symbol)) {
                        if (i2 == arrayLength) {
                            Object[] objArr2 = new Object[this.slotMap.dirtySize() + arrayLength];
                            if (objArr != null) {
                                System.arraycopy(objArr, 0, objArr2, 0, arrayLength);
                            }
                            objArr = objArr2;
                        }
                        int i3 = i2 + 1;
                        Object objValueOf = slot.name;
                        if (objValueOf == null) {
                            objValueOf = Integer.valueOf(slot.indexOrHash);
                        }
                        objArr[i2] = objValueOf;
                        i2 = i3;
                    }
                }
            }
            this.slotMap.unlockRead(lock);
            if (i2 != objArr.length + arrayLength) {
                Object[] objArr3 = new Object[i2];
                System.arraycopy(objArr, 0, objArr3, 0, i2);
                objArr = objArr3;
            }
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(16)) {
                Arrays.sort(objArr, KEY_COMPARATOR);
            }
            return objArr;
        } catch (Throwable th) {
            this.slotMap.unlockRead(lock);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        Slot slotQuerySlot = querySlot(context, obj);
        if (slotQuerySlot == null) {
            return null;
        }
        return slotQuerySlot.getPropertyDescriptor(context, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parentScopeObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return this.prototypeObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "object";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        ExternalArrayData externalArrayData = this.externalData;
        return externalArrayData != null ? i < externalArrayData.getArrayLength() : this.slotMap.query(null, i) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return ScriptRuntime.jsDelegatesTo(scriptable, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ConstProperties
    public boolean isConst(String str) {
        Slot slotQuery = this.slotMap.query(str, 0);
        return slotQuery != null && (slotQuery.getAttributes() & 5) == 5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return this.slotMap.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isExtensible() {
        return this.isExtensible;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isGetterOrSetter(String str, int i, boolean z) {
        Slot slotQuery = this.slotMap.query(str, i);
        return slotQuery != null && slotQuery.isSetterSlot();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isSealed() {
        return this.isSealed;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean preventExtensions() {
        this.isExtensible = false;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            if (i >= externalArrayData.getArrayLength()) {
                throw new JavaScriptException(ScriptRuntime.newNativeError(Context.getCurrentContext(), this, TopLevel.NativeErrors.RangeError, new Object[]{"External array index out of bounds "}), null, 0);
            }
            this.externalData.setArrayElement(i, obj);
        } else {
            if (putOwnProperty(i, scriptable, obj, Context.isCurrentContextStrict())) {
                return;
            }
            if (scriptable == this) {
                throw Kit.codeBug();
            }
            scriptable.put(i, scriptable, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ConstProperties
    public void putConst(String str, Scriptable scriptable, Object obj) {
        if (putConstImpl(str, 0, scriptable, obj, 1)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).putConst(str, scriptable, obj);
        } else {
            scriptable.put(str, scriptable, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean putOwnProperty(String str, Scriptable scriptable, Object obj, boolean z) {
        return putImpl(str, 0, scriptable, obj, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Slot querySlot(Context context, Object obj) {
        if (obj instanceof Symbol) {
            return this.slotMap.query(obj, 0);
        }
        ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(obj);
        String str = stringIdOrIndex.stringId;
        SlotMapContainer slotMapContainer = this.slotMap;
        return str == null ? slotMapContainer.query(null, stringIdOrIndex.index) : slotMapContainer.query(str, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean sameValue(Object obj, Object obj2) {
        Object obj3 = Scriptable.NOT_FOUND;
        if (obj == obj3) {
            return true;
        }
        if (obj2 == obj3) {
            obj2 = Undefined.instance;
        }
        if ((obj2 instanceof Number) && (obj instanceof Number)) {
            double dDoubleValue = ((Number) obj2).doubleValue();
            double dDoubleValue2 = ((Number) obj).doubleValue();
            if (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2)) {
                return true;
            }
            if (dDoubleValue == 0.0d && Double.doubleToLongBits(dDoubleValue) != Double.doubleToLongBits(dDoubleValue2)) {
                return false;
            }
        }
        return ScriptRuntime.shallowEq(obj2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void sealObject() {
        ArrayList<Slot> arrayList = new ArrayList();
        while (!this.isSealed) {
            for (Slot slot : arrayList) {
                Object obj = slot.value;
                if (obj instanceof LazilyLoadedCtor) {
                    LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj;
                    try {
                        lazilyLoadedCtor.init();
                    } finally {
                        slot.value = lazilyLoadedCtor.getValue();
                    }
                }
            }
            arrayList.clear();
            long lock = this.slotMap.readLock();
            try {
                for (Slot slot2 : this.slotMap) {
                    if (slot2.value instanceof LazilyLoadedCtor) {
                        arrayList.add(slot2);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.isSealed = true;
                }
                this.slotMap.unlockRead(lock);
            } catch (Throwable th) {
                this.slotMap.unlockRead(lock);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAttributes(int i, int i2) {
        checkNotSealed(null, i);
        this.slotMap.modify(null, i, 0).setAttributes(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCommonDescriptorProperties(int i, boolean z) {
        if (z) {
            defineProperty("writable", Boolean.valueOf((i & 1) == 0), 0);
        }
        defineProperty("enumerable", Boolean.valueOf((i & 2) == 0), 0);
        defineProperty("configurable", Boolean.valueOf((i & 4) == 0), 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setExternalArrayData(ExternalArrayData externalArrayData) {
        this.externalData = externalArrayData;
        if (externalArrayData == null) {
            delete(Name.LENGTH);
        } else {
            defineProperty(Name.LENGTH, (Object) null, GET_ARRAY_LENGTH, (Method) null, 3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGetterOrSetter(Object obj, int i, Callable callable, boolean z) {
        AccessorSlot accessorSlot;
        if (obj != null && i != 0) {
            throw new IllegalArgumentException(obj.toString());
        }
        checkNotSealed(obj, i);
        boolean zIsExtensible = isExtensible();
        SlotMapContainer slotMapContainer = this.slotMap;
        if (zIsExtensible) {
            accessorSlot = (AccessorSlot) slotMapContainer.compute(obj, i, new cz3());
        } else {
            Slot slotQuery = slotMapContainer.query(obj, i);
            if (!(slotQuery instanceof AccessorSlot)) {
                return;
            } else {
                accessorSlot = (AccessorSlot) slotQuery;
            }
        }
        if ((accessorSlot.getAttributes() & 1) != 0) {
            throw Context.reportRuntimeErrorById("msg.modify.readonly", obj);
        }
        if (z) {
            if (callable instanceof Function) {
                accessorSlot.setter = new AccessorSlot.FunctionSetter(callable);
            } else {
                accessorSlot.setter = null;
            }
        } else if (callable instanceof Function) {
            accessorSlot.getter = new AccessorSlot.FunctionGetter(callable);
        } else {
            accessorSlot.getter = null;
        }
        accessorSlot.value = Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parentScopeObject = scriptable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototypeObject = scriptable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        return this.slotMap.size();
    }

    public static Object getProperty(Scriptable scriptable, Symbol symbol) {
        return getPropWalkingPrototypeChain(scriptable, scriptable, symbol);
    }

    public static Object getSuperProperty(Scriptable scriptable, Scriptable scriptable2, Symbol symbol) {
        return getPropWalkingPrototypeChain(scriptable, scriptable2, symbol);
    }

    public static Object getProperty(Scriptable scriptable, int i) {
        return getPropWalkingPrototypeChain(scriptable, i, scriptable);
    }

    public static Object getSuperProperty(Scriptable scriptable, Scriptable scriptable2, int i) {
        return getPropWalkingPrototypeChain(scriptable, i, scriptable2);
    }

    public static void putSuperProperty(Scriptable scriptable, Scriptable scriptable2, String str, Object obj) {
        scriptable.put(str, scriptable2, obj);
    }

    public static void putSuperProperty(Scriptable scriptable, Scriptable scriptable2, int i, Object obj) {
        scriptable.put(i, scriptable2, obj);
    }

    public static boolean hasProperty(Scriptable scriptable, int i) {
        return getBase(scriptable, i) != null;
    }

    @Deprecated
    public final int getAttributes(int i, Scriptable scriptable) {
        return getAttributes(i);
    }

    public static boolean hasProperty(Scriptable scriptable, Symbol symbol) {
        return getBase(scriptable, symbol) != null;
    }

    @Deprecated
    public final int getAttributes(String str, Scriptable scriptable) {
        return getAttributes(str);
    }

    public boolean putOwnProperty(int i, Scriptable scriptable, Object obj, boolean z) {
        return putImpl(null, i, scriptable, obj, z);
    }

    public int getAttributes(int i) {
        return getAttributeSlot(null, i).getAttributes();
    }

    public boolean putOwnProperty(Symbol symbol, Scriptable scriptable, Object obj, boolean z) {
        return putImpl(symbol, 0, scriptable, obj, z);
    }

    public int getAttributes(Symbol symbol) {
        return getAttributeSlot(symbol).getAttributes();
    }

    public static void putProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        base.put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        checkNotSealed(null, i);
        this.slotMap.compute(null, i, new zy3());
    }

    @Deprecated
    public void setAttributes(int i, Scriptable scriptable, int i2) {
        setAttributes(i, i2);
    }

    public void setAttributes(String str, int i) {
        checkNotSealed(str, 0);
        this.slotMap.modify(str, 0, 0).setAttributes(i);
    }

    public static void putProperty(Scriptable scriptable, int i, Object obj) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            base = scriptable;
        }
        base.put(i, scriptable, obj);
    }

    public void delete(Symbol symbol) {
        checkNotSealed(symbol, 0);
        this.slotMap.compute(symbol, 0, new zy3());
    }

    public static <T> T getTypedProperty(Scriptable scriptable, String str, Class<T> cls) {
        Object property = getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static Scriptable getBase(Scriptable scriptable, int i) {
        Scriptable prototype = scriptable;
        while (!prototype.has(i, scriptable)) {
            prototype = prototype.getPrototype();
            if (prototype == null) {
                return prototype;
            }
        }
        return prototype;
    }

    @Deprecated
    public final void setAttributes(String str, Scriptable scriptable, int i) {
        setAttributes(str, i);
    }

    private static Object getPropWalkingPrototypeChain(Scriptable scriptable, String str, Scriptable scriptable2) {
        Object obj;
        do {
            obj = scriptable.get(str, scriptable2);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable = scriptable.getPrototype();
        } while (scriptable != null);
        return obj;
    }

    public void setAttributes(Symbol symbol, int i) {
        checkNotSealed(symbol, 0);
        this.slotMap.modify(symbol, 0, 0).setAttributes(i);
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls, boolean z) throws IllegalAccessException, InvocationTargetException {
        defineClass(scriptable, cls, z, false);
    }

    public static boolean deleteProperty(Scriptable scriptable, int i) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            return true;
        }
        base.delete(i);
        return !base.has(i, scriptable);
    }

    public static Scriptable getBase(Scriptable scriptable, String str) {
        Scriptable prototype = scriptable;
        while (!prototype.has(str, scriptable)) {
            prototype = prototype.getPrototype();
            if (prototype == null) {
                return prototype;
            }
        }
        return prototype;
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls) throws IllegalAccessException, InvocationTargetException {
        defineClass(scriptable, cls, false, false);
    }

    private static Object getPropWalkingPrototypeChain(Scriptable scriptable, int i, Scriptable scriptable2) {
        Object obj;
        do {
            obj = scriptable.get(i, scriptable2);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable = scriptable.getPrototype();
        } while (scriptable != null);
        return obj;
    }

    public static boolean deleteProperty(Scriptable scriptable, String str) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return true;
        }
        base.delete(str);
        return !base.has(str, scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.slotMap.query(str, 0) != null;
    }

    public boolean has(Symbol symbol, Scriptable scriptable) {
        return this.slotMap.query(symbol, 0) != null;
    }

    public ScriptableObject() {
        this.isExtensible = true;
        this.isSealed = false;
        this.slotMap = createSlotMap(0);
    }

    private Slot getAttributeSlot(Symbol symbol) {
        Slot slotQuery = this.slotMap.query(symbol, 0);
        if (slotQuery != null) {
            return slotQuery;
        }
        throw Context.reportRuntimeErrorById("msg.prop.not.found", symbol);
    }

    public static Object callMethod(Scriptable scriptable, String str, Object[] objArr) {
        return callMethod(null, scriptable, str, objArr);
    }

    @Deprecated
    public Object getGetterOrSetter(String str, int i, boolean z) {
        return getGetterOrSetter(str, i, this, z);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            if (i < externalArrayData.getArrayLength()) {
                return this.externalData.getArrayElement(i);
            }
            return Scriptable.NOT_FOUND;
        }
        Slot slotQuery = this.slotMap.query(null, i);
        if (slotQuery == null) {
            return Scriptable.NOT_FOUND;
        }
        return slotQuery.getValue(scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (putOwnProperty(str, scriptable, obj, Context.isCurrentContextStrict())) {
            return;
        }
        if (scriptable != this) {
            scriptable.put(str, scriptable, obj);
            return;
        }
        throw Kit.codeBug();
    }

    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        if (putOwnProperty(symbol, scriptable, obj, Context.isCurrentContextStrict())) {
            return;
        }
        if (scriptable != this) {
            ensureSymbolScriptable(scriptable).put(symbol, scriptable, obj);
            return;
        }
        throw Kit.codeBug();
    }

    public Object get(Symbol symbol, Scriptable scriptable) {
        Slot slotQuery = this.slotMap.query(symbol, 0);
        if (slotQuery == null) {
            return Scriptable.NOT_FOUND;
        }
        return slotQuery.getValue(scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Slot slotQuery = this.slotMap.query(str, 0);
        if (slotQuery == null) {
            return Scriptable.NOT_FOUND;
        }
        return slotQuery.getValue(scriptable);
    }

    public boolean defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        checkPropertyDefinition(scriptableObject);
        return defineOwnProperty(context, obj, scriptableObject, true);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return getDefaultValue(this, cls);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return getIds(false, false);
    }

    public void defineProperty(Symbol symbol, Object obj, int i) {
        checkNotSealed(symbol, 0);
        put(symbol, this, obj);
        setAttributes(symbol, i);
    }

    public static void defineProperty(Scriptable scriptable, String str, Object obj, int i) {
        if (!(scriptable instanceof ScriptableObject)) {
            scriptable.put(str, scriptable, obj);
        } else {
            ((ScriptableObject) scriptable).defineProperty(str, obj, i);
        }
    }

    public void defineProperty(Scriptable scriptable, String str, int i, Callable callable, int i2, int i3) {
        LambdaFunction lambdaFunction = new LambdaFunction(scriptable, str, i, callable);
        lambdaFunction.setStandardPropertyAttributes(i3);
        defineProperty(str, lambdaFunction, i2);
    }

    public void defineProperty(String str, Class<?> cls, int i) {
        int length = str.length();
        if (length != 0) {
            char[] cArr = new char[length + 3];
            str.getChars(0, length, cArr, 3);
            cArr[3] = Character.toUpperCase(cArr[3]);
            cArr[0] = 'g';
            cArr[1] = 'e';
            cArr[2] = 't';
            String str2 = new String(cArr);
            cArr[0] = 's';
            String str3 = new String(cArr);
            Method[] methodList = FunctionObject.getMethodList(cls);
            Method methodFindSingleMethod = FunctionObject.findSingleMethod(methodList, str2);
            Method methodFindSingleMethod2 = FunctionObject.findSingleMethod(methodList, str3);
            if (methodFindSingleMethod2 == null) {
                i |= 1;
            }
            int i2 = i;
            if (methodFindSingleMethod2 == null) {
                methodFindSingleMethod2 = null;
            }
            defineProperty(str, (Object) null, methodFindSingleMethod, methodFindSingleMethod2, i2);
            return;
        }
        d04.a();
    }

    public void defineProperty(String str, Object obj, int i) {
        checkNotSealed(str, 0);
        put(str, this, obj);
        setAttributes(str, i);
    }

    public void defineProperty(String str, Supplier<Object> supplier, Consumer<Object> consumer, int i) {
        LambdaSlot lambdaSlot = (LambdaSlot) this.slotMap.compute(str, 0, new SlotMap.SlotComputer() { // from class: dz3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.SlotMap.SlotComputer
            public final Slot compute(Object obj, int i2, Slot slot) {
                return ScriptableObject.ensureLambdaSlot(obj, i2, slot);
            }
        });
        lambdaSlot.setAttributes(i);
        lambdaSlot.getter = supplier;
        lambdaSlot.setter = consumer;
    }

    public void defineProperty(final Context context, final String str, java.util.function.Function<Scriptable, Object> function, BiConsumer<Scriptable, Object> biConsumer, int i) {
        if (function == null && biConsumer == null) {
            throw ScriptRuntime.typeError("at least one of {getter, setter} is required");
        }
        final LambdaAccessorSlot lambdaAccessorSlotCreateLambdaAccessorSlot = createLambdaAccessorSlot(str, 0, function, biConsumer, i);
        final ScriptableObject scriptableObjectBuildPropertyDescriptor = lambdaAccessorSlotCreateLambdaAccessorSlot.buildPropertyDescriptor(context);
        checkPropertyDefinition(scriptableObjectBuildPropertyDescriptor);
        this.slotMap.compute(str, 0, new SlotMap.SlotComputer() { // from class: bz3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.SlotMap.SlotComputer
            public final Slot compute(Object obj, int i2, Slot slot) {
                return ScriptableObject.d(this.a, context, str, lambdaAccessorSlotCreateLambdaAccessorSlot, scriptableObjectBuildPropertyDescriptor, obj, i2, slot);
            }
        });
    }
}
