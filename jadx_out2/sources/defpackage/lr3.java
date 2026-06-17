package defpackage;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import defpackage.d10;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lr3 implements ComponentCallbacks2, zs1 {
    public static final qr3 r = (qr3) qr3.k0(Bitmap.class).P();
    public static final qr3 s = (qr3) qr3.k0(r91.class).P();
    public static final qr3 t = (qr3) ((qr3) qr3.l0(zl0.c).W(ug3.LOW)).e0(true);
    public final com.bumptech.glide.a f;
    public final Context g;
    public final xs1 h;
    public final sr3 i;
    public final nr3 j;
    public final tl4 k;
    public final Runnable l;
    public final d10 m;
    public final CopyOnWriteArrayList n;
    public qr3 o;
    public boolean p;
    public boolean q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            lr3 lr3Var = lr3.this;
            lr3Var.h.b(lr3Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends y60 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(View view) {
            super(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rl4
        public void d(Object obj, ys4 ys4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rl4
        public void j(Drawable drawable) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.y60
        public void n(Drawable drawable) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements d10.a {
        public final sr3 a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(sr3 sr3Var) {
            this.a = sr3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // d10.a
        public void a(boolean z) {
            if (z) {
                synchronized (lr3.this) {
                    this.a.e();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lr3(com.bumptech.glide.a aVar, xs1 xs1Var, nr3 nr3Var, sr3 sr3Var, e10 e10Var, Context context) {
        this.k = new tl4();
        a aVar2 = new a();
        this.l = aVar2;
        this.f = aVar;
        this.h = xs1Var;
        this.j = nr3Var;
        this.i = sr3Var;
        this.g = context;
        d10 d10VarA = e10Var.a(context.getApplicationContext(), new c(sr3Var));
        this.m = d10VarA;
        aVar.o(this);
        if (iy4.r()) {
            iy4.w(aVar2);
        } else {
            xs1Var.b(this);
        }
        xs1Var.b(d10VarA);
        this.n = new CopyOnWriteArrayList(aVar.i().c());
        z(aVar.i().d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void A(rl4 rl4Var, yq3 yq3Var) {
        this.k.g(rl4Var);
        this.i.g(yq3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized boolean B(rl4 rl4Var) {
        yq3 yq3VarL = rl4Var.l();
        if (yq3VarL == null) {
            return true;
        }
        if (!this.i.a(yq3VarL)) {
            return false;
        }
        this.k.n(rl4Var);
        rl4Var.f(null);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(rl4 rl4Var) {
        boolean zB = B(rl4Var);
        yq3 yq3VarL = rl4Var.l();
        if (zB || this.f.p(rl4Var) || yq3VarL == null) {
            return;
        }
        rl4Var.f(null);
        yq3VarL.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zs1
    public synchronized void b() {
        y();
        this.k.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br3 c(Class cls) {
        return new br3(this.f, this, cls, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br3 e() {
        return c(Bitmap.class).a(r);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br3 g() {
        return c(Drawable.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zs1
    public synchronized void h() {
        this.k.h();
        p();
        this.i.b();
        this.h.a(this);
        this.h.a(this.m);
        iy4.x(this.l);
        this.f.s(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(rl4 rl4Var) {
        if (rl4Var == null) {
            return;
        }
        C(rl4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(View view) {
        n(new b(view));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zs1
    public synchronized void onStop() {
        try {
            this.k.onStop();
            if (this.q) {
                p();
            } else {
                x();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.p) {
            w();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void p() {
        try {
            Iterator it = this.k.e().iterator();
            while (it.hasNext()) {
                n((rl4) it.next());
            }
            this.k.c();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List q() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized qr3 r() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ct4 s(Class cls) {
        return this.f.i().e(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br3 t(Object obj) {
        return g().z0(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.i + ", treeNode=" + this.j + "}";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br3 u(String str) {
        return g().A0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void v() {
        this.i.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void w() {
        v();
        Iterator it = this.j.a().iterator();
        while (it.hasNext()) {
            ((lr3) it.next()).v();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void x() {
        this.i.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void y() {
        this.i.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void z(qr3 qr3Var) {
        this.o = (qr3) ((qr3) qr3Var.clone()).b();
    }

    public lr3(com.bumptech.glide.a aVar, xs1 xs1Var, nr3 nr3Var, Context context) {
        this(aVar, xs1Var, nr3Var, new sr3(), aVar.g(), context);
    }
}
