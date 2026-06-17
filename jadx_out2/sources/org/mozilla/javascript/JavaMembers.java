package org.mozilla.javascript;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessControlContext;
import java.security.AllPermission;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;
import okhttp3.internal.url._UrlKt;
import org.mozilla.javascript.ClassCache;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class JavaMembers {
    private static final boolean STRICT_REFLECTIVE_ACCESS = isModularJava();
    private static final Permission allPermission = new AllPermission();
    private Class<?> cl;
    NativeJavaMethod ctors;
    private Map<String, FieldAndMethods> fieldAndMethods;
    private Map<String, Object> members;
    private Map<String, FieldAndMethods> staticFieldAndMethods;
    private Map<String, Object> staticMembers;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JavaMembers(Scriptable scriptable, Class<?> cls, boolean z) {
        Context contextEnterContext = ContextFactory.getGlobal().enterContext();
        try {
            ClassShutter classShutter = contextEnterContext.getClassShutter();
            if (classShutter != null && !classShutter.visibleToScripts(cls.getName())) {
                throw Context.reportRuntimeErrorById("msg.access.prohibited", cls.getName());
            }
            this.members = new HashMap();
            this.staticMembers = new HashMap();
            this.cl = cls;
            reflect(contextEnterContext, scriptable, z, contextEnterContext.hasFeature(13));
            contextEnterContext.close();
        } catch (Throwable th) {
            if (contextEnterContext != null) {
                try {
                    contextEnterContext.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static JavaMembers createJavaMembers(Scriptable scriptable, Class<?> cls, boolean z) {
        return STRICT_REFLECTIVE_ACCESS ? new JavaMembers_jdk11(scriptable, cls, z) : new JavaMembers(scriptable, cls, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void discoverAccessibleMethods(Class<?> cls, Map<MethodSignature, Method> map, boolean z, boolean z2) {
        if (Modifier.isPublic(cls.getModifiers()) || z2) {
            try {
                if (!z && !z2) {
                    discoverPublicMethods(cls, map);
                    return;
                }
                while (cls != null) {
                    try {
                        for (Method method : cls.getDeclaredMethods()) {
                            int modifiers = method.getModifiers();
                            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || z2) {
                                Method methodRegisterMethod = registerMethod(map, method);
                                if (z2 && !methodRegisterMethod.isAccessible()) {
                                    methodRegisterMethod.setAccessible(true);
                                }
                            }
                        }
                        for (Class<?> cls2 : cls.getInterfaces()) {
                            discoverAccessibleMethods(cls2, map, z, z2);
                        }
                        cls = cls.getSuperclass();
                    } catch (SecurityException unused) {
                        discoverPublicMethods(cls, map);
                        return;
                    }
                }
                return;
            } catch (SecurityException unused2) {
                Context.reportWarning("Could not discover accessible methods of class " + cls.getName() + " due to lack of privileges, attemping superclasses/interfaces.");
            }
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            discoverAccessibleMethods(cls3, map, z, z2);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            discoverAccessibleMethods(superclass, map, z, z2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static MemberBox extractGetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if (memberBox.argTypes.length == 0 && (!z || memberBox.isStatic())) {
                if (memberBox.method().getReturnType() != Void.TYPE) {
                    return memberBox;
                }
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static MemberBox extractSetMethod(Class<?> cls, MemberBox[] memberBoxArr, boolean z) {
        for (int i = 1; i <= 2; i++) {
            for (MemberBox memberBox : memberBoxArr) {
                if (!z || memberBox.isStatic()) {
                    Class<?>[] clsArr = memberBox.argTypes;
                    if (clsArr.length != 1) {
                        continue;
                    } else if (i != 1) {
                        if (i != 2) {
                            Kit.codeBug();
                        }
                        if (clsArr[0].isAssignableFrom(cls)) {
                            return memberBox;
                        }
                    } else if (clsArr[0] == cls) {
                        return memberBox;
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private MemberBox findExplicitFunction(String str, boolean z) {
        MemberBox[] memberBoxArr;
        int iIndexOf = str.indexOf(40);
        if (iIndexOf < 0) {
            return null;
        }
        Map<String, Object> map = z ? this.staticMembers : this.members;
        if (z && iIndexOf == 0) {
            memberBoxArr = this.ctors.methods;
        } else {
            String strSubstring = str.substring(0, iIndexOf);
            Object obj = map.get(strSubstring);
            if (!z && obj == null) {
                obj = this.staticMembers.get(strSubstring);
            }
            memberBoxArr = obj instanceof NativeJavaMethod ? ((NativeJavaMethod) obj).methods : null;
        }
        if (memberBoxArr != null) {
            for (MemberBox memberBox : memberBoxArr) {
                String strLiveConnectSignature = liveConnectSignature(memberBox.argTypes);
                if (strLiveConnectSignature.length() + iIndexOf == str.length() && str.regionMatches(iIndexOf, strLiveConnectSignature, 0, strLiveConnectSignature.length())) {
                    return memberBox;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static MemberBox findGetter(boolean z, Map<String, Object> map, String str, String str2) {
        Object obj = map.get(str.concat(str2));
        if (obj instanceof NativeJavaMethod) {
            return extractGetMethod(((NativeJavaMethod) obj).methods, z);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Constructor<?>[] getAccessibleConstructors(boolean z) {
        Class<?> cls;
        if (z && (cls = this.cl) != ScriptRuntime.ClassClass) {
            try {
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                AccessibleObject.setAccessible(declaredConstructors, true);
                return declaredConstructors;
            } catch (SecurityException unused) {
                Context.reportWarning("Could not access constructor  of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        return this.cl.getConstructors();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Field[] getAccessibleFields(boolean z, boolean z2) {
        if (z2 || z) {
            try {
                ArrayList arrayList = new ArrayList();
                Class<?> superclass = this.cl;
                while (true) {
                    if (superclass == null) {
                        return (Field[]) arrayList.toArray(new Field[0]);
                    }
                    for (Field field : superclass.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (z2 || Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            arrayList.add(field);
                        }
                    }
                    superclass = superclass.getSuperclass();
                }
            } catch (SecurityException unused) {
            }
        }
        return this.cl.getFields();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object getExplicitFunction(Scriptable scriptable, String str, Object obj, boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        MemberBox memberBoxFindExplicitFunction = findExplicitFunction(str, z);
        if (memberBoxFindExplicitFunction == null) {
            return null;
        }
        Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(scriptable);
        if (memberBoxFindExplicitFunction.isCtor()) {
            NativeJavaConstructor nativeJavaConstructor = new NativeJavaConstructor(memberBoxFindExplicitFunction);
            nativeJavaConstructor.setPrototype(functionPrototype);
            map.put(str, nativeJavaConstructor);
            return nativeJavaConstructor;
        }
        Object obj2 = map.get(memberBoxFindExplicitFunction.getName());
        if (!(obj2 instanceof NativeJavaMethod) || ((NativeJavaMethod) obj2).methods.length <= 1) {
            return obj2;
        }
        NativeJavaMethod nativeJavaMethod = new NativeJavaMethod(memberBoxFindExplicitFunction, str);
        nativeJavaMethod.setPrototype(functionPrototype);
        map.put(str, nativeJavaMethod);
        return nativeJavaMethod;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Method getMoreConcreteMethod(Method method, Method method2) {
        return (!method.getReturnType().equals(method2.getReturnType()) && method.getReturnType().isAssignableFrom(method2.getReturnType())) ? method2 : method;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object getSecurityContext() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            return null;
        }
        Object securityContext = securityManager.getSecurityContext();
        if (securityContext instanceof AccessControlContext) {
            try {
                ((AccessControlContext) securityContext).checkPermission(allPermission);
                return null;
            } catch (SecurityException unused) {
            }
        }
        return securityContext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isModularJava() {
        try {
            Class.class.getMethod("getModule", null);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String javaSignature(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        int i = 0;
        do {
            i++;
            cls = cls.getComponentType();
        } while (cls.isArray());
        String name = cls.getName();
        if (i == 1) {
            return name.concat(_UrlKt.PATH_SEGMENT_ENCODE_SET_URI);
        }
        StringBuilder sb = new StringBuilder(name.length() + (i * 2));
        sb.append(name);
        while (i != 0) {
            i--;
            sb.append(_UrlKt.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String liveConnectSignature(Class<?>[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i != length; i++) {
            if (i != 0) {
                sb.append(',');
            }
            sb.append(javaSignature(clsArr[i]));
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static JavaMembers lookupClass(Scriptable scriptable, Class<?> cls, Class<?> cls2, boolean z) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<ClassCache.CacheKey, JavaMembers> classCacheMap = classCache.getClassCacheMap();
        Object securityContext = getSecurityContext();
        Class<?> cls3 = cls;
        while (true) {
            JavaMembers javaMembers = classCacheMap.get(new ClassCache.CacheKey(cls3, securityContext));
            if (javaMembers != null) {
                if (cls3 != cls) {
                    classCacheMap.put(new ClassCache.CacheKey(cls, securityContext), javaMembers);
                }
                return javaMembers;
            }
            try {
                JavaMembers javaMembersCreateJavaMembers = createJavaMembers(classCache.getAssociatedScope(), cls3, z);
                if (classCache.isCachingEnabled()) {
                    classCacheMap.put(new ClassCache.CacheKey(cls3, securityContext), javaMembersCreateJavaMembers);
                    if (cls3 != cls) {
                        classCacheMap.put(new ClassCache.CacheKey(cls, securityContext), javaMembersCreateJavaMembers);
                    }
                }
                return javaMembersCreateJavaMembers;
            } catch (SecurityException e) {
                if (cls2 == null || !cls2.isInterface()) {
                    Class<?> superclass = cls3.getSuperclass();
                    if (superclass == null) {
                        if (!cls3.isInterface()) {
                            throw e;
                        }
                        superclass = ScriptRuntime.ObjectClass;
                    }
                    cls3 = superclass;
                } else {
                    cls3 = cls2;
                    cls2 = null;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void reflect(Context context, Scriptable scriptable, boolean z, boolean z2) {
        int i;
        String lowerCase;
        Object obj;
        MemberBox memberBoxFindGetter;
        Object obj2;
        NativeJavaMethod nativeJavaMethod;
        MemberBox[] memberBoxArr;
        ArrayList arrayList;
        for (Method method : discoverAccessibleMethods(this.cl, z, z2)) {
            Map<String, Object> map = Modifier.isStatic(method.getModifiers()) ? this.staticMembers : this.members;
            String name = method.getName();
            Object obj3 = map.get(name);
            if (obj3 == null) {
                map.put(name, method);
            } else {
                if (obj3 instanceof ArrayList) {
                    arrayList = (ArrayList) obj3;
                } else {
                    if (!(obj3 instanceof Method)) {
                        Kit.codeBug();
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(obj3);
                    map.put(name, arrayList2);
                    arrayList = arrayList2;
                }
                arrayList.add(method);
            }
        }
        int i2 = 0;
        while (true) {
            i = 2;
            if (i2 == 2) {
                break;
            }
            for (Map.Entry entry : (i2 == 0 ? this.staticMembers : this.members).entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Method) {
                    memberBoxArr = new MemberBox[]{new MemberBox((Method) value)};
                } else {
                    ArrayList arrayList3 = (ArrayList) value;
                    int size = arrayList3.size();
                    if (size < 2) {
                        Kit.codeBug();
                    }
                    MemberBox[] memberBoxArr2 = new MemberBox[size];
                    for (int i3 = 0; i3 != size; i3++) {
                        memberBoxArr2[i3] = new MemberBox((Method) arrayList3.get(i3));
                    }
                    memberBoxArr = memberBoxArr2;
                }
                NativeJavaMethod nativeJavaMethod2 = new NativeJavaMethod(memberBoxArr);
                if (scriptable != null) {
                    ScriptRuntime.setFunctionProtoAndParent(nativeJavaMethod2, context, scriptable, false);
                }
                entry.setValue(nativeJavaMethod2);
            }
            i2++;
        }
        for (Field field : getAccessibleFields(z, z2)) {
            String name2 = field.getName();
            try {
                boolean zIsStatic = Modifier.isStatic(field.getModifiers());
                Map<String, Object> map2 = zIsStatic ? this.staticMembers : this.members;
                Object obj4 = map2.get(name2);
                if (obj4 == null) {
                    map2.put(name2, field);
                } else if (obj4 instanceof NativeJavaMethod) {
                    FieldAndMethods fieldAndMethods = new FieldAndMethods(scriptable, ((NativeJavaMethod) obj4).methods, field);
                    Map<String, FieldAndMethods> map3 = zIsStatic ? this.staticFieldAndMethods : this.fieldAndMethods;
                    if (map3 == null) {
                        map3 = new HashMap<>();
                        if (zIsStatic) {
                            this.staticFieldAndMethods = map3;
                        } else {
                            this.fieldAndMethods = map3;
                        }
                    }
                    map3.put(name2, fieldAndMethods);
                    map2.put(name2, fieldAndMethods);
                } else if (!(obj4 instanceof Field)) {
                    Kit.codeBug();
                } else if (((Field) obj4).getDeclaringClass().isAssignableFrom(field.getDeclaringClass())) {
                    map2.put(name2, field);
                }
            } catch (SecurityException unused) {
                Context.reportWarning("Could not access field " + name2 + " of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        int i4 = 0;
        while (i4 != i) {
            boolean z3 = i4 == 0;
            Map<String, Object> map4 = z3 ? this.staticMembers : this.members;
            Map<? extends String, ? extends Object> map5 = new HashMap<>();
            for (String str : map4.keySet()) {
                boolean zStartsWith = str.startsWith("get");
                boolean zStartsWith2 = str.startsWith("set");
                boolean zStartsWith3 = str.startsWith("is");
                if (zStartsWith || zStartsWith3 || zStartsWith2) {
                    String strSubstring = str.substring(zStartsWith3 ? i : 3);
                    if (strSubstring.length() != 0) {
                        char cCharAt = strSubstring.charAt(0);
                        if (Character.isUpperCase(cCharAt)) {
                            if (strSubstring.length() == 1) {
                                lowerCase = strSubstring.toLowerCase(Locale.ROOT);
                            } else if (!Character.isUpperCase(strSubstring.charAt(1))) {
                                lowerCase = Character.toLowerCase(cCharAt) + strSubstring.substring(1);
                            }
                            if (!map5.containsKey(lowerCase)) {
                                memberBoxFindGetter = findGetter(z3, map4, "get", strSubstring);
                                if (memberBoxFindGetter == null) {
                                }
                                obj2 = map4.get("set".concat(strSubstring));
                                MemberBox memberBox = null;
                                if (obj2 instanceof NativeJavaMethod) {
                                }
                                map5.put(lowerCase, new BeanProperty(memberBoxFindGetter, memberBox, nativeJavaMethod));
                            }
                        } else {
                            lowerCase = strSubstring;
                            if (!map5.containsKey(lowerCase) && ((obj = map4.get(lowerCase)) == null || (z2 && (obj instanceof Member) && Modifier.isPrivate(((Member) obj).getModifiers())))) {
                                memberBoxFindGetter = findGetter(z3, map4, "get", strSubstring);
                                if (memberBoxFindGetter == null) {
                                    memberBoxFindGetter = findGetter(z3, map4, "is", strSubstring);
                                }
                                obj2 = map4.get("set".concat(strSubstring));
                                MemberBox memberBox2 = null;
                                if (obj2 instanceof NativeJavaMethod) {
                                    nativeJavaMethod = null;
                                } else {
                                    nativeJavaMethod = (NativeJavaMethod) obj2;
                                    MemberBox memberBoxExtractSetMethod = memberBoxFindGetter != null ? extractSetMethod(memberBoxFindGetter.method().getReturnType(), nativeJavaMethod.methods, z3) : extractSetMethod(nativeJavaMethod.methods, z3);
                                    if (nativeJavaMethod.methods.length <= 1) {
                                        nativeJavaMethod = null;
                                    }
                                    memberBox2 = memberBoxExtractSetMethod;
                                }
                                map5.put(lowerCase, new BeanProperty(memberBoxFindGetter, memberBox2, nativeJavaMethod));
                            }
                        }
                    }
                }
                i = 2;
            }
            map4.putAll(map5);
            i4++;
            i = 2;
        }
        Constructor<?>[] accessibleConstructors = getAccessibleConstructors(z2);
        MemberBox[] memberBoxArr3 = new MemberBox[accessibleConstructors.length];
        for (int i5 = 0; i5 != accessibleConstructors.length; i5++) {
            memberBoxArr3[i5] = new MemberBox(accessibleConstructors[i5]);
        }
        this.ctors = new NativeJavaMethod(memberBoxArr3, this.cl.getSimpleName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Method registerMethod(Map<MethodSignature, Method> map, Method method) {
        return map.merge(new MethodSignature(method), method, new BiFunction() { // from class: org.mozilla.javascript.f
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return JavaMembers.getMoreConcreteMethod((Method) obj, (Method) obj2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void discoverPublicMethods(Class<?> cls, Map<MethodSignature, Method> map) {
        for (Method method : cls.getMethods()) {
            registerMethod(map, method);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object get(Scriptable scriptable, String str, Object obj, boolean z) {
        Object objInvoke;
        Class<?> type;
        Object explicitFunction = (z ? this.staticMembers : this.members).get(str);
        if (!z && explicitFunction == null) {
            explicitFunction = this.staticMembers.get(str);
        }
        if (explicitFunction == null && (explicitFunction = getExplicitFunction(scriptable, str, obj, z)) == null) {
            return Scriptable.NOT_FOUND;
        }
        if (explicitFunction instanceof Scriptable) {
            return explicitFunction;
        }
        Context context = Context.getContext();
        try {
            if (explicitFunction instanceof BeanProperty) {
                BeanProperty beanProperty = (BeanProperty) explicitFunction;
                MemberBox memberBox = beanProperty.getter;
                if (memberBox == null) {
                    return Scriptable.NOT_FOUND;
                }
                objInvoke = memberBox.invoke(obj, Context.emptyArgs);
                type = beanProperty.getter.method().getReturnType();
            } else {
                Field field = (Field) explicitFunction;
                if (z) {
                    obj = null;
                }
                objInvoke = field.get(obj);
                type = field.getType();
            }
            return context.getWrapFactory().wrap(context, ScriptableObject.getTopLevelScope(scriptable), objInvoke, type);
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, FieldAndMethods> getFieldAndMethodsObjects(Scriptable scriptable, Object obj, boolean z) {
        Map<String, FieldAndMethods> map = z ? this.staticFieldAndMethods : this.fieldAndMethods;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap(map.size());
        for (FieldAndMethods fieldAndMethods : map.values()) {
            FieldAndMethods fieldAndMethods2 = new FieldAndMethods(scriptable, fieldAndMethods.methods, fieldAndMethods.field);
            fieldAndMethods2.javaObject = obj;
            map2.put(fieldAndMethods.field.getName(), fieldAndMethods2);
        }
        return map2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object[] getIds(boolean z) {
        return (z ? this.staticMembers : this.members).keySet().toArray(new Object[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean has(String str, boolean z) {
        return ((z ? this.staticMembers : this.members).get(str) == null && findExplicitFunction(str, z) == null) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void put(Scriptable scriptable, String str, Object obj, Object obj2, boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        Object obj3 = map.get(str);
        if (!z && obj3 == null) {
            obj3 = this.staticMembers.get(str);
        }
        if (obj3 == null) {
            throw reportMemberNotFound(str);
        }
        if (obj3 instanceof FieldAndMethods) {
            obj3 = ((FieldAndMethods) map.get(str)).field;
        }
        if (!(obj3 instanceof BeanProperty)) {
            if (!(obj3 instanceof Field)) {
                throw Context.reportRuntimeErrorById(obj3 == null ? "msg.java.internal.private" : "msg.java.method.assign", str);
            }
            Field field = (Field) obj3;
            try {
                field.set(obj, Context.jsToJava(obj2, field.getType()));
                return;
            } catch (IllegalAccessException e) {
                if ((field.getModifiers() & 16) == 0) {
                    throw Context.throwAsScriptRuntimeEx(e);
                }
                return;
            } catch (IllegalArgumentException unused) {
                throw Context.reportRuntimeErrorById("msg.java.internal.field.type", obj2.getClass().getName(), field, obj.getClass().getName());
            }
        }
        BeanProperty beanProperty = (BeanProperty) obj3;
        MemberBox memberBox = beanProperty.setter;
        if (memberBox == null) {
            throw reportMemberNotFound(str);
        }
        NativeJavaMethod nativeJavaMethod = beanProperty.setters;
        if (nativeJavaMethod != null && obj2 != null) {
            nativeJavaMethod.call(Context.getContext(), ScriptableObject.getTopLevelScope(scriptable), scriptable, new Object[]{obj2});
            return;
        }
        try {
            beanProperty.setter.invoke(obj, new Object[]{Context.jsToJava(obj2, memberBox.argTypes[0])});
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RuntimeException reportMemberNotFound(String str) {
        return Context.reportRuntimeErrorById("msg.java.member.not.found", this.cl.getName(), str);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class MethodSignature {
        private final Class<?>[] args;
        private final String name;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public MethodSignature(Method method) {
            this(method.getName(), method.getParameterTypes());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (obj instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) obj;
                if (methodSignature.name.equals(this.name) && Arrays.equals(this.args, methodSignature.args)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return this.args.length ^ this.name.hashCode();
        }

        private MethodSignature(String str, Class<?>[] clsArr) {
            this.name = str;
            this.args = clsArr;
        }
    }

    private static MemberBox extractSetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if ((!z || memberBox.isStatic()) && memberBox.method().getReturnType() == Void.TYPE && memberBox.argTypes.length == 1) {
                return memberBox;
            }
        }
        return null;
    }

    public JavaMembers(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    private Method[] discoverAccessibleMethods(Class<?> cls, boolean z, boolean z2) {
        HashMap map = new HashMap();
        discoverAccessibleMethods(cls, map, z, z2);
        return (Method[]) map.values().toArray(new Method[0]);
    }
}
