package org.jupnp.util;

import defpackage.jl;
import defpackage.pp3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Reflections {
    public static boolean canAccessField(Field field) {
        boolean zIsAccessible = field.isAccessible();
        try {
            field.setAccessible(true);
            field.setAccessible(zIsAccessible);
            return true;
        } catch (SecurityException unused) {
            field.setAccessible(zIsAccessible);
            return false;
        } catch (Throwable th) {
            field.setAccessible(zIsAccessible);
            throw th;
        }
    }

    public static Class classForName(String str) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(str);
        } catch (Exception unused) {
            return Class.forName(str);
        }
    }

    public static String decapitalize(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty() || (str.length() > 1 && Character.isUpperCase(str.charAt(1)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object get(Field field, Object obj) {
        boolean zCanAccessField = canAccessField(field);
        try {
            try {
                field.setAccessible(true);
                return field.get(obj);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Could not get field value by reflection: " + toString(field) + " on: " + obj.getClass().getName(), e);
            }
        } finally {
            field.setAccessible(zCanAccessField);
        }
    }

    public static Object getAndWrap(Field field, Object obj) {
        boolean zCanAccessField = canAccessField(field);
        try {
            try {
                field.setAccessible(true);
                return get(field, obj);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new IllegalArgumentException("exception setting: " + field.getName(), e);
            }
        } finally {
            field.setAccessible(zCanAccessField);
        }
    }

    public static Class<?> getClass(Type type) {
        Class<?> cls;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof GenericArrayType) || (cls = getClass(((GenericArrayType) type).getGenericComponentType())) == null) {
            return null;
        }
        return Array.newInstance(cls, 0).getClass();
    }

    public static Class getCollectionElementType(Type type) {
        if (!(type instanceof ParameterizedType)) {
            jl.a("collection type not parameterized");
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 0) {
            jl.a("no type arguments for collection type");
            return null;
        }
        Type rawType = actualTypeArguments.length == 1 ? actualTypeArguments[0] : actualTypeArguments[1];
        if (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        jl.a("type argument not a class");
        return null;
    }

    public static Field getField(Class cls, String str) {
        while (cls != null && cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static List<Field> getFields(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(cls2)) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Method getGetterMethod(Class cls, String str) {
        while (cls != null && cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                String name = method.getName();
                if (method.getParameterTypes().length == 0) {
                    if (name.startsWith("get")) {
                        if (decapitalize(name.substring(3)).equals(str)) {
                            return method;
                        }
                    } else if (name.startsWith("is") && decapitalize(name.substring(2)).equals(str)) {
                        return method;
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Class getMapKeyType(Type type) {
        if (!(type instanceof ParameterizedType)) {
            jl.a("collection type not parameterized");
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 0) {
            jl.a("no type arguments for collection type");
            return null;
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            return (Class) type2;
        }
        jl.a("type argument not a class");
        return null;
    }

    public static Method getMethod(Class cls, String str) {
        for (Class superclass = cls; superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, null);
            } catch (NoSuchMethodException unused) {
            }
        }
        pp3.a("No such method: ", cls.getName(), ".", str);
        return null;
    }

    public static String getMethodPropertyName(String str) {
        if (str.startsWith("get")) {
            return decapitalize(str.substring(3));
        }
        if (str.startsWith("is")) {
            return decapitalize(str.substring(2));
        }
        if (str.startsWith("set")) {
            return decapitalize(str.substring(3));
        }
        return null;
    }

    public static List<Method> getMethods(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(cls2)) {
                    arrayList.add(method);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Method getSetterMethod(Class cls, String str) {
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (name.startsWith("set") && method.getParameterTypes().length == 1 && decapitalize(name.substring(3)).equals(str)) {
                return method;
            }
        }
        pp3.a("no such setter method: ", cls.getName(), ".", str);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<Class<?>> getTypeArguments(Class<T> cls, Class<? extends T> cls2) {
        int i;
        HashMap map = new HashMap();
        while (true) {
            i = 0;
            if (getClass(cls2).equals(cls)) {
                break;
            }
            if (cls2 instanceof Class) {
                cls2 = ((Class) cls2).getGenericSuperclass();
            } else {
                ParameterizedType parameterizedType = (ParameterizedType) cls2;
                Class cls3 = (Class) parameterizedType.getRawType();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                TypeVariable<Class<T>>[] typeParameters = cls3.getTypeParameters();
                while (i < actualTypeArguments.length) {
                    map.put(typeParameters[i], actualTypeArguments[i]);
                    i++;
                }
                if (!cls3.equals(cls)) {
                    cls2 = (Class<? extends T>) cls3.getGenericSuperclass();
                }
            }
        }
        Type[] typeParameters2 = cls2 instanceof Class ? ((Class) cls2).getTypeParameters() : ((ParameterizedType) cls2).getActualTypeArguments();
        ArrayList arrayList = new ArrayList();
        int length = typeParameters2.length;
        while (i < length) {
            Type type = typeParameters2[i];
            while (map.containsKey(type)) {
                type = (Type) map.get(type);
            }
            arrayList.add(getClass(type));
            i++;
        }
        return arrayList;
    }

    private static boolean instanceOf(Class cls, String str) {
        if (str.equals(cls.getName())) {
            return true;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        boolean zInstanceOf = false;
        for (int i = 0; i < interfaces.length && !zInstanceOf; i++) {
            zInstanceOf = instanceOf(interfaces[i], str);
        }
        return zInstanceOf;
    }

    public static Object invoke(Method method, Object obj, Object... objArr) throws Exception {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalArgumentException e) {
            String str = "Could not invoke method by reflection: " + toString(method);
            if (objArr != null && objArr.length > 0) {
                str = str + " with parameters: (" + toClassNameString(", ", objArr) + ")";
            }
            throw new IllegalArgumentException(str + " on: " + obj.getClass().getName(), e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof Exception) {
                throw ((Exception) e2.getCause());
            }
            throw e2;
        }
    }

    public static Object invokeAndWrap(Method method, Object obj, Object... objArr) {
        try {
            return invoke(method, obj, objArr);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            throw new RuntimeException("exception invoking: " + method.getName(), e);
        }
    }

    public static boolean isClassAvailable(String str) {
        try {
            classForName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isInstanceOf(Class cls, String str) {
        if (str == null) {
            jl.a("name cannot be null");
            return false;
        }
        while (cls != Object.class) {
            if (instanceOf(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    public static void set(Field field, Object obj, Object obj2) {
        String strConcat;
        boolean zCanAccessField = canAccessField(field);
        try {
            try {
                field.setAccessible(true);
                field.set(obj, obj2);
            } catch (IllegalArgumentException e) {
                String str = "Could not set field value by reflection: " + toString(field) + " on: " + field.getDeclaringClass().getName();
                if (obj2 == null) {
                    strConcat = str.concat(" with null value");
                } else {
                    strConcat = str + " with value: " + String.valueOf(obj2.getClass());
                }
                throw new IllegalArgumentException(strConcat, e);
            }
        } finally {
            field.setAccessible(zCanAccessField);
        }
    }

    public static void setAndWrap(Field field, Object obj, Object obj2) {
        boolean zCanAccessField = canAccessField(field);
        try {
            try {
                field.setAccessible(true);
                set(field, obj, obj2);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new IllegalArgumentException("exception setting: " + field.getName(), e);
            }
        } finally {
            field.setAccessible(zCanAccessField);
        }
    }

    public static String toClassNameString(String str, Object... objArr) {
        if (objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(str);
            if (obj == null) {
                sb.append("null");
            } else {
                sb.append(obj.getClass().getName());
            }
        }
        return sb.substring(str.length());
    }

    public static String toString(Member member) {
        return unqualify(member.getDeclaringClass().getName()) + "." + member.getName();
    }

    public static String unqualify(String str, char c) {
        return str.substring(str.lastIndexOf(c) + 1);
    }

    public static String unqualify(String str) {
        return unqualify(str, '.');
    }

    public static Method getMethod(Annotation annotation, String str) {
        try {
            return annotation.annotationType().getMethod(str, null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
