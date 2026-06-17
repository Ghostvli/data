package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xr2 {
    public final Runnable a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final Map c = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final g a;
        public i b;

        public a(g gVar, i iVar) {
            this.a = gVar;
            this.b = iVar;
            gVar.a(iVar);
        }

        public void a() {
            this.a.c(this.b);
            this.b = null;
        }
    }

    public xr2(Runnable runnable) {
        this.a = runnable;
    }

    public static /* synthetic */ void a(xr2 xr2Var, g.b bVar, ds2 ds2Var, bt1 bt1Var, g.a aVar) {
        xr2Var.getClass();
        if (aVar == g.a.f(bVar)) {
            xr2Var.b(ds2Var);
            return;
        }
        if (aVar == g.a.ON_DESTROY) {
            xr2Var.h(ds2Var);
        } else if (aVar == g.a.b(bVar)) {
            xr2Var.b.remove(ds2Var);
            xr2Var.a.run();
        }
    }

    public void b(ds2 ds2Var) {
        this.b.add(ds2Var);
        this.a.run();
    }

    public void c(final ds2 ds2Var, bt1 bt1Var, final g.b bVar) {
        g lifecycle = bt1Var.getLifecycle();
        a aVar = (a) this.c.remove(ds2Var);
        if (aVar != null) {
            aVar.a();
        }
        this.c.put(ds2Var, new a(lifecycle, new i() { // from class: wr2
            @Override // androidx.lifecycle.i
            public final void c(bt1 bt1Var2, g.a aVar2) {
                xr2.a(this.f, bVar, ds2Var, bt1Var2, aVar2);
            }
        }));
    }

    public void d(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((ds2) it.next()).w(menu, menuInflater);
        }
    }

    public void e(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((ds2) it.next()).r(menu);
        }
    }

    public boolean f(MenuItem menuItem) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((ds2) it.next()).f(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void g(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((ds2) it.next()).x(menu);
        }
    }

    public void h(ds2 ds2Var) {
        this.b.remove(ds2Var);
        a aVar = (a) this.c.remove(ds2Var);
        if (aVar != null) {
            aVar.a();
        }
        this.a.run();
    }
}
