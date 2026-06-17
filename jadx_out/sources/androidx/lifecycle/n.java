package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import defpackage.as0;
import defpackage.bt1;
import defpackage.we0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements bt1 {
    public static final b n = new b(null);
    public static final n o = new n();
    public int f;
    public int g;
    public Handler j;
    public boolean h = true;
    public boolean i = true;
    public final j k = new j(this);
    public final Runnable l = new Runnable() { // from class: ah3
        @Override // java.lang.Runnable
        public final void run() {
            n.a(this.f);
        }
    };
    public final p.a m = new d();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final a a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activity.getClass();
            activityLifecycleCallbacks.getClass();
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends as0 {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends as0 {
            final /* synthetic */ n this$0;

            public a(n nVar) {
                this.this$0 = nVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                activity.getClass();
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                activity.getClass();
                this.this$0.f();
            }
        }

        public c() {
        }

        @Override // defpackage.as0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activity.getClass();
            if (Build.VERSION.SDK_INT < 29) {
                p.g.b(activity).f(n.this.m);
            }
        }

        @Override // defpackage.as0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            activity.getClass();
            n.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.getClass();
            a.a(activity, new a(n.this));
        }

        @Override // defpackage.as0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            activity.getClass();
            n.this.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements p.a {
        public d() {
        }

        @Override // androidx.lifecycle.p.a
        public void a() {
        }

        @Override // androidx.lifecycle.p.a
        public void b() {
            n.this.f();
        }

        @Override // androidx.lifecycle.p.a
        public void c() {
            n.this.e();
        }
    }

    public static void a(n nVar) {
        nVar.i();
        nVar.j();
    }

    public final void d() {
        int i = this.g - 1;
        this.g = i;
        if (i == 0) {
            Handler handler = this.j;
            handler.getClass();
            handler.postDelayed(this.l, 700L);
        }
    }

    public final void e() {
        int i = this.g + 1;
        this.g = i;
        if (i == 1) {
            if (this.h) {
                this.k.h(g.a.ON_RESUME);
                this.h = false;
            } else {
                Handler handler = this.j;
                handler.getClass();
                handler.removeCallbacks(this.l);
            }
        }
    }

    public final void f() {
        int i = this.f + 1;
        this.f = i;
        if (i == 1 && this.i) {
            this.k.h(g.a.ON_START);
            this.i = false;
        }
    }

    public final void g() {
        this.f--;
        j();
    }

    @Override // defpackage.bt1
    public g getLifecycle() {
        return this.k;
    }

    public final void h(Context context) {
        context.getClass();
        this.j = new Handler();
        this.k.h(g.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void i() {
        if (this.g == 0) {
            this.h = true;
            this.k.h(g.a.ON_PAUSE);
        }
    }

    public final void j() {
        if (this.f == 0 && this.h) {
            this.k.h(g.a.ON_STOP);
            this.i = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public /* synthetic */ b(we0 we0Var) {
            this();
        }

        public final bt1 a() {
            return n.o;
        }

        public final void b(Context context) {
            context.getClass();
            n.o.h(context);
        }

        public b() {
        }
    }
}
