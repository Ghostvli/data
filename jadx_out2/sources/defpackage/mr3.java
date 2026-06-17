package defpackage;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mr3 implements Handler.Callback {
    public static final b k = new a();
    public volatile lr3 f;
    public final b g;
    public final la h = new la();
    public final t71 i;
    public final et1 j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // mr3.b
        public lr3 a(com.bumptech.glide.a aVar, xs1 xs1Var, nr3 nr3Var, Context context) {
            return new lr3(aVar, xs1Var, nr3Var, context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        lr3 a(com.bumptech.glide.a aVar, xs1 xs1Var, nr3 nr3Var, Context context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mr3(b bVar) {
        bVar = bVar == null ? k : bVar;
        this.g = bVar;
        this.j = new et1(bVar);
        this.i = b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(Activity activity) {
        if (activity.isDestroyed()) {
            jl.a("You cannot start a load for a destroyed activity");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t71 b() {
        return (qc1.f && qc1.e) ? new p11() : new vm0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(Collection collection, Map map) {
        if (collection == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            p51 p51Var = (p51) it.next();
            if (p51Var != null && p51Var.B0() != null) {
                map.put(p51Var.B0(), p51Var);
                d(p51Var.T().w0(), map);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean k(Context context) {
        Activity activityC = c(context);
        return activityC == null || !activityC.isFinishing();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p51 e(View view, u51 u51Var) {
        this.h.clear();
        d(u51Var.n1().w0(), this.h);
        View viewFindViewById = u51Var.findViewById(R.id.content);
        p51 p51Var = null;
        while (!view.equals(viewFindViewById) && (p51Var = (p51) this.h.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.h.clear();
        return p51Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lr3 f(p51 p51Var) {
        fg3.f(p51Var.U(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (iy4.r()) {
            return h(p51Var.U().getApplicationContext());
        }
        if (p51Var.O() != null) {
            this.i.a(p51Var.O());
        }
        k61 k61VarT = p51Var.T();
        Context contextU = p51Var.U();
        return this.j.b(contextU, com.bumptech.glide.a.c(contextU.getApplicationContext()), p51Var.getLifecycle(), k61VarT, p51Var.N0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lr3 g(u51 u51Var) {
        if (iy4.r()) {
            return h(u51Var.getApplicationContext());
        }
        a(u51Var);
        this.i.a(u51Var);
        boolean zK = k(u51Var);
        return this.j.b(u51Var, com.bumptech.glide.a.c(u51Var.getApplicationContext()), u51Var.getLifecycle(), u51Var.n1(), zK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lr3 h(Context context) {
        if (context == null) {
            jl.a("You cannot start a load on a null Context");
            return null;
        }
        if (iy4.s() && !(context instanceof Application)) {
            if (context instanceof u51) {
                return g((u51) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return h(contextWrapper.getBaseContext());
                }
            }
        }
        return j(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lr3 i(View view) {
        if (iy4.r()) {
            return h(view.getContext().getApplicationContext());
        }
        fg3.e(view);
        fg3.f(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityC = c(view.getContext());
        if (activityC == null) {
            return h(view.getContext().getApplicationContext());
        }
        if (!(activityC instanceof u51)) {
            return h(view.getContext().getApplicationContext());
        }
        u51 u51Var = (u51) activityC;
        p51 p51VarE = e(view, u51Var);
        return p51VarE != null ? f(p51VarE) : g(u51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lr3 j(Context context) {
        if (this.f == null) {
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.f = this.g.a(com.bumptech.glide.a.c(context.getApplicationContext()), new z9(), new hs0(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f;
    }
}
