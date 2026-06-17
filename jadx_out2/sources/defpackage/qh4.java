package defpackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class qh4 {
    public static final Map d = new ConcurrentHashMap();
    public static final a[] e = new a[4];
    public List a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final List a = new ArrayList();
        public final Map b = new HashMap();
        public final Map c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class e;
        public Class f;
        public boolean g;
        public nh4 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a(Method method, Class cls) {
            Object objPut = this.b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!b((Method) objPut, cls)) {
                    z20.a();
                    return false;
                }
                this.b.put(cls, this);
            }
            return b(method, cls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean b(Method method, Class cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String string = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.c.put(string, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(string, cls2);
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(Class cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e() {
            this.a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qh4(List list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.c = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List a(Class cls) {
        Map map = d;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        List listC = this.c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            map.put(cls, listC);
            return listC;
        }
        throw new wu0("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List b(Class cls) {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f != null) {
            nh4 nh4VarF = f(aVarG);
            aVarG.h = nh4VarF;
            if (nh4VarF != null) {
                for (ph4 ph4Var : nh4VarF.a()) {
                    if (aVarG.a(ph4Var.a, ph4Var.c)) {
                        aVarG.a.add(ph4Var);
                    }
                }
            } else {
                d(aVarG);
            }
            aVarG.d();
        }
        return e(aVarG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List c(Class cls) {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f != null) {
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(a aVar) {
        Method[] methods;
        try {
            try {
                methods = aVar.f.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = aVar.f.getMethods();
                aVar.g = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        lh4 lh4Var = (lh4) method.getAnnotation(lh4.class);
                        if (lh4Var != null) {
                            Class<?> cls = parameterTypes[0];
                            if (aVar.a(method, cls)) {
                                aVar.a.add(new ph4(method, cls, lh4Var.threadMode(), lh4Var.priority(), lh4Var.sticky()));
                            }
                        }
                    } else if (this.b && method.isAnnotationPresent(lh4.class)) {
                        throw new wu0("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.b && method.isAnnotationPresent(lh4.class)) {
                    throw new wu0((method.getDeclaringClass().getName() + "." + method.getName()).concat(" is a illegal @Subscribe method: must be public, non-static, and non-abstract"));
                }
            }
        } catch (LinkageError e2) {
            String strConcat = "Could not inspect methods of ".concat(aVar.f.getName());
            throw new wu0(this.c ? strConcat.concat(". Please consider using EventBus annotation processor to avoid reflection.") : strConcat.concat(". Please make this class visible to EventBus annotation processor to avoid reflection."), e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.e();
        synchronized (e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    a[] aVarArr = e;
                    if (aVarArr[i] == null) {
                        aVarArr[i] = aVar;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final nh4 f(a aVar) {
        nh4 nh4Var = aVar.h;
        if (nh4Var != null && nh4Var.b() != null) {
            nh4 nh4VarB = aVar.h.b();
            if (aVar.f == nh4VarB.c()) {
                return nh4VarB;
            }
        }
        List list = this.a;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            nh4 nh4VarA = ((oh4) it.next()).a(aVar.f);
            if (nh4VarA != null) {
                return nh4VarA;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final a g() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                try {
                    a[] aVarArr = e;
                    a aVar = aVarArr[i];
                    if (aVar != null) {
                        aVarArr[i] = null;
                        return aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a();
        }
    }
}
