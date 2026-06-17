package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v9 {
    public static volatile v9 d;
    public static final Object e = new Object();
    public final Context c;
    public final Set b = new HashSet();
    public final Map a = new HashMap();

    public v9(Context context) {
        this.c = context.getApplicationContext();
    }

    public static v9 e(Context context) {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new v9(context);
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public void a(Bundle bundle) {
        String string = this.c.getString(qm3.a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (bk1.class.isAssignableFrom(cls)) {
                            this.b.add(cls);
                        }
                    }
                }
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new ae4(e2);
            }
        }
    }

    public void b(Class cls) {
        try {
            try {
                dq4.a("Startup");
                a(this.c.getPackageManager().getProviderInfo(new ComponentName(this.c, (Class<?>) cls), 128).metaData);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new ae4(e2);
            }
        } finally {
            dq4.b();
        }
    }

    public Object c(Class cls) {
        Object objD;
        synchronized (e) {
            try {
                objD = this.a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public final Object d(Class cls, Set set) {
        Object objCreate;
        if (dq4.d()) {
            try {
                dq4.a(cls.getSimpleName());
            } finally {
                dq4.b();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.a.containsKey(cls)) {
            objCreate = this.a.get(cls);
        } else {
            set.add(cls);
            try {
                bk1 bk1Var = (bk1) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listDependencies = bk1Var.dependencies();
                if (!listDependencies.isEmpty()) {
                    for (Class cls2 : listDependencies) {
                        if (!this.a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objCreate = bk1Var.create(this.c);
                set.remove(cls);
                this.a.put(cls, objCreate);
            } catch (Throwable th) {
                throw new ae4(th);
            }
        }
        return objCreate;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.b.contains(cls);
    }
}
