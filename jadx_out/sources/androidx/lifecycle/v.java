package androidx.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.g;
import defpackage.bt1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class v {
    public final j a;
    public final Handler b;
    public a c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Runnable {
        public final j f;
        public final g.a g;
        public boolean h;

        public a(j jVar, g.a aVar) {
            jVar.getClass();
            aVar.getClass();
            this.f = jVar;
            this.g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h) {
                return;
            }
            this.f.h(this.g);
            this.h = true;
        }
    }

    public v(bt1 bt1Var) {
        bt1Var.getClass();
        this.a = new j(bt1Var);
        this.b = new Handler(Looper.getMainLooper());
    }

    public g a() {
        return this.a;
    }

    public void b() {
        f(g.a.ON_START);
    }

    public void c() {
        f(g.a.ON_CREATE);
    }

    public void d() {
        f(g.a.ON_STOP);
        f(g.a.ON_DESTROY);
    }

    public void e() {
        f(g.a.ON_START);
    }

    public final void f(g.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.a, aVar);
        this.c = aVar3;
        this.b.postAtFrontOfQueue(aVar3);
    }
}
