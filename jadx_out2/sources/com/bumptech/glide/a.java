package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import defpackage.e04;
import defpackage.e10;
import defpackage.e42;
import defpackage.fg3;
import defpackage.iy4;
import defpackage.kk;
import defpackage.la1;
import defpackage.lr3;
import defpackage.ma;
import defpackage.mr3;
import defpackage.qr3;
import defpackage.ri1;
import defpackage.rl4;
import defpackage.s9;
import defpackage.sr2;
import defpackage.tr2;
import defpackage.up3;
import defpackage.us0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a implements ComponentCallbacks2 {
    public static volatile a p;
    public static volatile boolean q;
    public final us0 f;
    public final kk g;
    public final sr2 h;
    public final c i;
    public final ma j;
    public final mr3 k;
    public final e10 l;
    public final InterfaceC0051a n;
    public final List m = new ArrayList();
    public tr2 o = tr2.NORMAL;

    /* JADX INFO: renamed from: com.bumptech.glide.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface InterfaceC0051a {
        qr3 build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(Context context, us0 us0Var, sr2 sr2Var, kk kkVar, ma maVar, mr3 mr3Var, e10 e10Var, int i, InterfaceC0051a interfaceC0051a, Map map, List list, List list2, s9 s9Var, d dVar) {
        this.f = us0Var;
        this.g = kkVar;
        this.j = maVar;
        this.h = sr2Var;
        this.k = mr3Var;
        this.l = e10Var;
        this.n = interfaceC0051a;
        this.i = new c(context, maVar, e.d(this, list2, s9Var), new ri1(), interfaceC0051a, map, list, us0Var, dVar, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (q) {
            e04.a("Glide has been called recursively, this is probably an internal library error!");
            return;
        }
        q = true;
        try {
            m(context, generatedAppGlideModule);
        } finally {
            q = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a c(Context context) {
        if (p == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (a.class) {
                try {
                    if (p == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } finally {
                }
            }
        }
        return p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException e) {
            q(e);
            return null;
        } catch (InstantiationException e2) {
            q(e2);
            return null;
        } catch (NoSuchMethodException e3) {
            q(e3);
            return null;
        } catch (InvocationTargetException e4) {
            q(e4);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static mr3 l(Context context) {
        fg3.f(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new b(), generatedAppGlideModule);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void n(Context context, b bVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List listB = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listB = new e42(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set setD = generatedAppGlideModule.d();
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                la1 la1Var = (la1) it.next();
                if (setD.contains(la1Var.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + la1Var);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listB.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + ((la1) it2.next()).getClass());
            }
        }
        bVar.e(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator it3 = listB.iterator();
        while (it3.hasNext()) {
            ((la1) it3.next()).a(applicationContext, bVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, bVar);
        }
        a aVarA = bVar.a(applicationContext, listB, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(aVarA);
        p = aVarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lr3 t(Context context) {
        return l(context).h(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lr3 u(View view) {
        return l(view.getContext()).i(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        iy4.b();
        this.h.b();
        this.g.b();
        this.j.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ma e() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kk f() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e10 g() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Context h() {
        return this.i.getBaseContext();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c i() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public up3 j() {
        return this.i.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mr3 k() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(lr3 lr3Var) {
        synchronized (this.m) {
            try {
                if (this.m.contains(lr3Var)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.m.add(lr3Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        r(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p(rl4 rl4Var) {
        synchronized (this.m) {
            try {
                Iterator it = this.m.iterator();
                while (it.hasNext()) {
                    if (((lr3) it.next()).B(rl4Var)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(int i) {
        iy4.b();
        synchronized (this.m) {
            try {
                Iterator it = this.m.iterator();
                while (it.hasNext()) {
                    ((lr3) it.next()).onTrimMemory(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.h.a(i);
        this.g.a(i);
        this.j.a(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(lr3 lr3Var) {
        synchronized (this.m) {
            try {
                if (!this.m.contains(lr3Var)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.m.remove(lr3Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
