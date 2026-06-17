package defpackage;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class sr3 {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());
    public final Set b = new HashSet();
    public boolean c;

    public boolean a(yq3 yq3Var) {
        boolean z = true;
        if (yq3Var == null) {
            return true;
        }
        boolean zRemove = this.a.remove(yq3Var);
        if (!this.b.remove(yq3Var) && !zRemove) {
            z = false;
        }
        if (z) {
            yq3Var.clear();
        }
        return z;
    }

    public void b() {
        Iterator it = iy4.k(this.a).iterator();
        while (it.hasNext()) {
            a((yq3) it.next());
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        for (yq3 yq3Var : iy4.k(this.a)) {
            if (yq3Var.isRunning() || yq3Var.j()) {
                yq3Var.clear();
                this.b.add(yq3Var);
            }
        }
    }

    public void d() {
        this.c = true;
        for (yq3 yq3Var : iy4.k(this.a)) {
            if (yq3Var.isRunning()) {
                yq3Var.pause();
                this.b.add(yq3Var);
            }
        }
    }

    public void e() {
        for (yq3 yq3Var : iy4.k(this.a)) {
            if (!yq3Var.j() && !yq3Var.h()) {
                yq3Var.clear();
                if (this.c) {
                    this.b.add(yq3Var);
                } else {
                    yq3Var.i();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (yq3 yq3Var : iy4.k(this.a)) {
            if (!yq3Var.j() && !yq3Var.isRunning()) {
                yq3Var.i();
            }
        }
        this.b.clear();
    }

    public void g(yq3 yq3Var) {
        this.a.add(yq3Var);
        if (!this.c) {
            yq3Var.i();
            return;
        }
        yq3Var.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(yq3Var);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
