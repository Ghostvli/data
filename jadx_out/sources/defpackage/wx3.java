package defpackage;

import android.app.Application;
import androidx.lifecycle.q;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wx3 {
    public static final List a = ow.m(Application.class, q.class);
    public static final List b = nw.d(q.class);

    public static final Constructor c(Class cls, List list) {
        cls.getClass();
        list.getClass();
        Constructor<?>[] constructors = cls.getConstructors();
        constructors.getClass();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            parameterTypes.getClass();
            List listL = ua.L(parameterTypes);
            if (il1.a(list, listL)) {
                return constructor;
            }
            if (list.size() == listL.size() && listL.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final c45 d(Class cls, Constructor constructor, Object... objArr) {
        cls.getClass();
        constructor.getClass();
        objArr.getClass();
        try {
            return (c45) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            wo3.a("Failed to access ", cls, e);
            return null;
        } catch (InstantiationException e2) {
            xo3.a("A ", cls, " cannot be instantiated.", e2);
            return null;
        } catch (InvocationTargetException e3) {
            cx4.a("An exception happened in constructor of " + cls, e3.getCause());
            return null;
        }
    }
}
