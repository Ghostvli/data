package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar;
import defpackage.h8;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h8 {
    public static c f = new c(new d());
    public static int g = -100;
    public static jz1 h = null;
    public static jz1 i = null;
    public static Boolean j = null;
    public static boolean k = false;
    public static final na l = new na();
    public static final Object m = new Object();
    public static final Object n = new Object();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements Executor {
        public final Object f = new Object();
        public final Queue g = new ArrayDeque();
        public final Executor h;
        public Runnable i;

        public c(Executor executor) {
            this.h = executor;
        }

        public static /* synthetic */ void a(c cVar, Runnable runnable) {
            cVar.getClass();
            try {
                runnable.run();
            } finally {
                cVar.b();
            }
        }

        public void b() {
            synchronized (this.f) {
                try {
                    Runnable runnable = (Runnable) this.g.poll();
                    this.i = runnable;
                    if (runnable != null) {
                        this.h.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f) {
                try {
                    this.g.add(new Runnable() { // from class: i8
                        @Override // java.lang.Runnable
                        public final void run() {
                            h8.c.a(this.f, runnable);
                        }
                    });
                    if (this.i == null) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static void D(h8 h8Var) {
        synchronized (m) {
            E(h8Var);
        }
    }

    public static void E(h8 h8Var) {
        synchronized (m) {
            try {
                Iterator it = l.iterator();
                while (it.hasNext()) {
                    h8 h8Var2 = (h8) ((WeakReference) it.next()).get();
                    if (h8Var2 == h8Var || h8Var2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void N(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (k().e()) {
                    String strB = x9.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(strB));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    public static void O(final Context context) {
        if (u(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (k) {
                    return;
                }
                f.execute(new Runnable() { // from class: g8
                    @Override // java.lang.Runnable
                    public final void run() {
                        h8.c(context);
                    }
                });
                return;
            }
            synchronized (n) {
                try {
                    jz1 jz1Var = h;
                    if (jz1Var == null) {
                        if (i == null) {
                            i = jz1.b(x9.b(context));
                        }
                        if (i.e()) {
                        } else {
                            h = i;
                        }
                    } else if (!jz1Var.equals(i)) {
                        jz1 jz1Var2 = h;
                        i = jz1Var2;
                        x9.a(context, jz1Var2.g());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ void c(Context context) {
        N(context);
        k = true;
    }

    public static void d(h8 h8Var) {
        synchronized (m) {
            E(h8Var);
            l.add(new WeakReference(h8Var));
        }
    }

    public static h8 h(Activity activity, b8 b8Var) {
        return new j8(activity, b8Var);
    }

    public static h8 i(Dialog dialog, b8 b8Var) {
        return new j8(dialog, b8Var);
    }

    public static jz1 k() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object objO = o();
            if (objO != null) {
                return jz1.h(b.a(objO));
            }
        } else {
            jz1 jz1Var = h;
            if (jz1Var != null) {
                return jz1Var;
            }
        }
        return jz1.d();
    }

    public static int m() {
        return g;
    }

    public static Object o() {
        Context contextL;
        Iterator it = l.iterator();
        while (it.hasNext()) {
            h8 h8Var = (h8) ((WeakReference) it.next()).get();
            if (h8Var != null && (contextL = h8Var.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    public static jz1 q() {
        return h;
    }

    public static boolean u(Context context) {
        if (j == null) {
            try {
                Bundle bundle = w9.a(context).metaData;
                if (bundle != null) {
                    j = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                j = Boolean.FALSE;
            }
        }
        return j.booleanValue();
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C();

    public abstract boolean F(int i2);

    public abstract void G(int i2);

    public abstract void H(View view);

    public abstract void I(View view, ViewGroup.LayoutParams layoutParams);

    public void J(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void K(Toolbar toolbar);

    public abstract void L(int i2);

    public abstract void M(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i2);

    public abstract Context l();

    public abstract int n();

    public abstract MenuInflater p();

    public abstract q2 r();

    public abstract void s();

    public abstract void t();

    public abstract void v(Configuration configuration);

    public abstract void w(Bundle bundle);

    public abstract void x();

    public abstract void y(Bundle bundle);

    public abstract void z();
}
