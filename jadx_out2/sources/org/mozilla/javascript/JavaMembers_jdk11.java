package org.mozilla.javascript;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import org.mozilla.javascript.JavaMembers;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class JavaMembers_jdk11 extends JavaMembers {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JavaMembers_jdk11(Scriptable scriptable, Class<?> cls, boolean z) {
        super(scriptable, cls, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (isExportedClass(r0) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r7 = r0.getMethod(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x000c, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        r0 = r0.getSuperclass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Method findAccessibleMethod(Method method) {
        Class<?> declaringClass = method.getDeclaringClass();
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        loop0: while (true) {
            Class<?>[] interfaces = declaringClass.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                try {
                    method = interfaces[i].getMethod(name, parameterTypes);
                    break loop0;
                } catch (NoSuchMethodException unused) {
                    i++;
                }
            }
        }
        return method;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isExportedClass(Class<?> cls) {
        String name;
        Package r0 = cls.getPackage();
        if (r0 != null) {
            name = r0.getName();
        } else {
            if (!Proxy.isProxyClass(cls)) {
                return true;
            }
            String name2 = cls.getName();
            name = name2.substring(0, name2.lastIndexOf(46));
        }
        try {
            try {
                Object objInvoke = cls.getClass().getMethod("getModule", null).invoke(cls, null);
                return ((Boolean) objInvoke.getClass().getMethod("isExported", String.class).invoke(objInvoke, name)).booleanValue();
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        } catch (NoSuchMethodException unused2) {
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.JavaMembers
    public void discoverPublicMethods(Class<?> cls, Map<JavaMembers.MethodSignature, Method> map) {
        if (isExportedClass(cls)) {
            super.discoverPublicMethods(cls, map);
            return;
        }
        for (Method method : cls.getMethods()) {
            JavaMembers.registerMethod(map, findAccessibleMethod(method));
        }
    }
}
