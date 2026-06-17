package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n81 {
    public final Executor a;
    public final Function0 b;
    public final Object c;
    public int d;
    public boolean e;
    public boolean f;
    public final List g;
    public final Runnable h;

    public n81(Executor executor, Function0 function0) {
        executor.getClass();
        function0.getClass();
        this.a = executor;
        this.b = function0;
        this.c = new Object();
        this.g = new ArrayList();
        this.h = new Runnable() { // from class: m81
            @Override // java.lang.Runnable
            public final void run() {
                n81.a(this.f);
            }
        };
    }

    public static void a(n81 n81Var) {
        n81Var.getClass();
        synchronized (n81Var.c) {
            try {
                n81Var.e = false;
                if (n81Var.d == 0 && !n81Var.f) {
                    n81Var.b.invoke();
                    n81Var.b();
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.c) {
            try {
                this.f = true;
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.g.clear();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.c) {
            z = this.f;
        }
        return z;
    }
}
