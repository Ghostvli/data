package defpackage;

import androidx.lifecycle.a;
import androidx.lifecycle.b;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gt1 {
    public static final gt1 a = new gt1();
    public static final Map b = new HashMap();
    public static final Map c = new HashMap();

    public static final String c(String str) {
        str.getClass();
        return sg4.G(str, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final i f(Object obj) {
        obj.getClass();
        boolean z = obj instanceof i;
        boolean z2 = obj instanceof hg0;
        if (z && z2) {
            return new c((hg0) obj, (i) obj);
        }
        if (z2) {
            return new c((hg0) obj, null);
        }
        if (z) {
            return (i) obj;
        }
        Class<?> cls = obj.getClass();
        gt1 gt1Var = a;
        if (gt1Var.d(cls) != 2) {
            return new o(obj);
        }
        Object obj2 = c.get(cls);
        obj2.getClass();
        List list = (List) obj2;
        if (list.size() == 1) {
            gt1Var.a((Constructor) list.get(0), obj);
            return new w(null);
        }
        int size = list.size();
        d[] dVarArr = new d[size];
        for (int i = 0; i < size; i++) {
            a.a((Constructor) list.get(i), obj);
            dVarArr[i] = null;
        }
        return new b(dVarArr);
    }

    public final d a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            objNewInstance.getClass();
            w82.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e) {
            wg1.a(e);
            return null;
        } catch (InstantiationException e2) {
            wg1.a(e2);
            return null;
        } catch (InvocationTargetException e3) {
            wg1.a(e3);
            return null;
        }
    }

    public final Constructor b(Class cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            name.getClass();
            if (name.length() != 0) {
                canonicalName.getClass();
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            canonicalName.getClass();
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Constructor<?> declaredConstructor = Class.forName(strC).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            wg1.a(e);
            return null;
        }
    }

    public final int d(Class cls) {
        Map map = b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && at1.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            c.put(cls, nw.d(constructorB));
            return 2;
        }
        if (a.c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            superclass.getClass();
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = c.get(superclass);
            obj.getClass();
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        interfaces.getClass();
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                cls2.getClass();
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = c.get(cls2);
                obj2.getClass();
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        c.put(cls, arrayList);
        return 2;
    }
}
