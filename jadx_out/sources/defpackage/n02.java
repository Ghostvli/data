package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n02 {
    public static volatile int a;
    public static volatile jw3 e;
    public static final xh4 b = new xh4();
    public static final bx2 c = new bx2();
    public static boolean d = my4.d("slf4j.detectLoggerNameMismatch");
    public static final String[] f = {"2.0"};

    public static final void b() {
        try {
            List listH = h();
            x(listH);
            if (listH == null || listH.isEmpty()) {
                a = 4;
                sq3.h("No SLF4J providers were found.");
                sq3.h("Defaulting to no-operation (NOP) logger implementation");
                sq3.h("See https://www.slf4j.org/codes.html#noProviders for further details.");
                w(g());
            } else {
                e = (jw3) listH.get(0);
                e.a();
                a = 3;
                v(listH);
            }
            s();
        } catch (Exception e2) {
            f(e2);
            l02.a("Unexpected initialization failure", e2);
        }
    }

    public static void c(wh4 wh4Var, int i) {
        if (wh4Var.c().D()) {
            d(i);
        } else {
            if (wh4Var.c().E()) {
                return;
            }
            e();
        }
    }

    public static void d(int i) {
        sq3.h("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        sq3.h("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        sq3.h("See also https://www.slf4j.org/codes.html#replay");
    }

    public static void e() {
        sq3.h("The following set of substitute loggers may have been accessed");
        sq3.h("during the initialization phase. Logging calls during this");
        sq3.h("phase were not honored. However, subsequent logging calls to these");
        sq3.h("loggers will work as normally expected.");
        sq3.h("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    public static void f(Throwable th) {
        a = 2;
        sq3.b("Failed to instantiate SLF4J LoggerFactory", th);
    }

    public static Set g() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = n02.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
            return linkedHashSet;
        } catch (IOException e2) {
            sq3.b("Error getting resources from path", e2);
            return linkedHashSet;
        }
    }

    public static List h() {
        ArrayList arrayList = new ArrayList();
        ClassLoader classLoader = n02.class.getClassLoader();
        jw3 jw3VarP = p(classLoader);
        if (jw3VarP != null) {
            arrayList.add(jw3VarP);
            return arrayList;
        }
        Iterator it = n(classLoader).iterator();
        while (it.hasNext()) {
            y(arrayList, it);
        }
        return arrayList;
    }

    public static void i() {
        xh4 xh4Var = b;
        synchronized (xh4Var) {
            try {
                xh4Var.d().e();
                for (uh4 uh4Var : xh4Var.d().d()) {
                    uh4Var.H(l(uh4Var.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ih1 j() {
        return m().b();
    }

    public static j02 k(Class cls) {
        Class clsA;
        j02 j02VarL = l(cls.getName());
        if (d && (clsA = my4.a()) != null && q(cls, clsA)) {
            sq3.h(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", j02VarL.getName(), clsA.getName()));
            sq3.h("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return j02VarL;
    }

    public static j02 l(String str) {
        return j().a(str);
    }

    public static jw3 m() {
        if (a == 0) {
            synchronized (n02.class) {
                try {
                    if (a == 0) {
                        a = 1;
                        r();
                    }
                } finally {
                }
            }
        }
        int i = a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            e04.a("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
            return null;
        }
        if (i == 3) {
            return e;
        }
        if (i == 4) {
            return c;
        }
        e04.a("Unreachable code");
        return null;
    }

    public static ServiceLoader n(final ClassLoader classLoader) {
        return System.getSecurityManager() == null ? ServiceLoader.load(jw3.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: m02
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(jw3.class, classLoader);
            }
        });
    }

    public static boolean o(List list) {
        return list.size() > 1;
    }

    public static jw3 p(ClassLoader classLoader) {
        String property = System.getProperty("slf4j.provider");
        if (property != null && !property.isEmpty()) {
            try {
                sq3.d(String.format("Attempting to load provider \"%s\" specified via \"%s\" system property", property, "slf4j.provider"));
                return (jw3) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e2) {
                sq3.b(String.format("Specified SLF4JServiceProvider (%s) does not implement SLF4JServiceProvider interface", property), e2);
                return null;
            } catch (ClassNotFoundException e3) {
                e = e3;
                sq3.b(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (IllegalAccessException e4) {
                e = e4;
                sq3.b(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (InstantiationException e5) {
                e = e5;
                sq3.b(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (NoSuchMethodException e6) {
                e = e6;
                sq3.b(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (InvocationTargetException e7) {
                e = e7;
                sq3.b(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            }
        }
        return null;
    }

    public static boolean q(Class cls, Class cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    public static final void r() {
        b();
        if (a == 3) {
            z();
        }
    }

    public static void s() {
        i();
        t();
        b.d().b();
    }

    public static void t() {
        LinkedBlockingQueue linkedBlockingQueueC = b.d().c();
        int size = linkedBlockingQueueC.size();
        ArrayList<wh4> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (wh4 wh4Var : arrayList) {
                u(wh4Var);
                int i2 = i + 1;
                if (i == 0) {
                    c(wh4Var, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    public static void u(wh4 wh4Var) {
        if (wh4Var == null) {
            return;
        }
        uh4 uh4VarC = wh4Var.c();
        String name = uh4VarC.getName();
        if (uh4VarC.F()) {
            e04.a("Delegate logger cannot be null at this state.");
            return;
        }
        if (uh4VarC.E()) {
            return;
        }
        if (!uh4VarC.D()) {
            sq3.h(name);
        } else if (uh4VarC.x(wh4Var.b())) {
            uh4VarC.G(wh4Var);
        }
    }

    public static void v(List list) {
        if (list.isEmpty() || !o(list)) {
            return;
        }
        sq3.d("Actual provider is of type [" + list.get(0) + "]");
    }

    public static void w(Set set) {
        if (set.isEmpty()) {
            return;
        }
        sq3.h("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sq3.h("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        sq3.h("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void x(List list) {
        if (o(list)) {
            sq3.h("Class path contains multiple SLF4J providers.");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sq3.h("Found provider [" + ((jw3) it.next()) + "]");
            }
            sq3.h("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static void y(List list, Iterator it) {
        try {
            list.add((jw3) it.next());
        } catch (ServiceConfigurationError e2) {
            sq3.a("A service provider failed to instantiate:\n" + e2.getMessage());
        }
    }

    public static final void z() {
        try {
            String strC = e.c();
            boolean z = false;
            for (String str : f) {
                if (strC.startsWith(str)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            sq3.h("The requested version " + strC + " by your slf4j provider is not compatible with " + Arrays.asList(f).toString());
            sq3.h("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (Throwable th) {
            sq3.b("Unexpected problem occurred during version sanity check", th);
        }
    }
}
