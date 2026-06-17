package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class bu2 {
    public static final bu2 a = new bu2();
    public static final a b = new a(null, null, null);
    public static a c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final a a(hh hhVar) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), hhVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), hhVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = b;
            c = aVar2;
            return aVar2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String b(hh hhVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        hhVar.getClass();
        a aVarA = c;
        if (aVarA == null) {
            aVarA = a(hhVar);
        }
        if (aVarA != b && (method = aVarA.a) != null && (objInvoke = method.invoke(hhVar.getClass(), null)) != null && (method2 = aVarA.b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = aVarA.c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
