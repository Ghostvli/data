package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a61 {
    public static final x64 a = new x64();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return p51.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        x64 x64Var = a;
        x64 x64Var2 = (x64) x64Var.get(classLoader);
        if (x64Var2 == null) {
            x64Var2 = new x64();
            x64Var.put(classLoader, x64Var2);
        }
        Class cls = (Class) x64Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        x64Var2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            n51.a(str, ": make sure class is a valid subclass of Fragment", e);
            return null;
        } catch (ClassNotFoundException e2) {
            n51.a(str, ": make sure class name exists", e2);
            return null;
        }
    }

    public abstract p51 a(ClassLoader classLoader, String str);
}
