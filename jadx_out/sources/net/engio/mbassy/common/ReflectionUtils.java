package net.engio.mbassy.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReflectionUtils {
    public static void collectInterfaces(Class cls, Collection<Class> collection) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            collection.add(cls2);
            collectInterfaces(cls2, collection);
        }
    }

    public static boolean containsOverridingMethod(Method[] methodArr, Method method) {
        for (Method method2 : methodArr) {
            if (isOverriddenBy(method, method2)) {
                return true;
            }
        }
        return false;
    }

    private static <A extends Annotation> A getAnnotation(AnnotatedElement annotatedElement, Class<A> cls, Set<AnnotatedElement> set) {
        if (set.contains(annotatedElement)) {
            return null;
        }
        set.add(annotatedElement);
        A a = (A) annotatedElement.getAnnotation(cls);
        if (a != null) {
            return a;
        }
        for (Annotation annotation : annotatedElement.getAnnotations()) {
            A a2 = (A) getAnnotation(annotation.annotationType(), cls, set);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public static void getMethods(IPredicate<Method> iPredicate, Class<?> cls, ArrayList<Method> arrayList) {
        try {
            for (Method method : cls.getDeclaredMethods()) {
                if (iPredicate.apply(method)) {
                    arrayList.add(method);
                }
            }
        } catch (Exception unused) {
        }
        if (cls.equals(Object.class)) {
            return;
        }
        getMethods(iPredicate, cls.getSuperclass(), arrayList);
    }

    public static Method getOverridingMethod(Method method, Class cls) {
        while (!cls.equals(method.getDeclaringClass())) {
            try {
                return cls.getDeclaredMethod(method.getName(), method.getParameterTypes());
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Class[] getSuperTypes(Class cls) {
        ArrayList arrayList = new ArrayList();
        collectInterfaces(cls, arrayList);
        while (!cls.equals(Object.class) && !cls.isInterface()) {
            arrayList.add(cls.getSuperclass());
            cls = cls.getSuperclass();
            collectInterfaces(cls, arrayList);
        }
        Class[] clsArr = new Class[arrayList.size()];
        arrayList.toArray(clsArr);
        return clsArr;
    }

    private static boolean isOverriddenBy(Method method, Method method2) {
        if (method.getDeclaringClass().equals(method2.getDeclaringClass()) || !method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()) || !method.getName().equals(method2.getName())) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?>[] parameterTypes2 = method2.getParameterTypes();
        for (int i = 0; i < parameterTypes2.length; i++) {
            if (!parameterTypes[i].equals(parameterTypes2[i])) {
                return false;
            }
        }
        return true;
    }

    public static Method[] getMethods(IPredicate<Method> iPredicate, Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        getMethods(iPredicate, cls, arrayList);
        Method[] methodArr = new Method[arrayList.size()];
        arrayList.toArray(methodArr);
        return methodArr;
    }

    public static <A extends Annotation> A getAnnotation(AnnotatedElement annotatedElement, Class<A> cls) {
        return (A) getAnnotation(annotatedElement, cls, new HashSet());
    }
}
