package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xf {
    public final mc1 a;
    public final mc1 b;
    public final a c;
    public Object d;
    public Object e;
    public int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(Object obj, Object obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xf(Object obj, Looper looper, Looper looper2, zu zuVar, a aVar) {
        this.a = zuVar.c(looper, null);
        this.b = zuVar.c(looper2, null);
        this.d = obj;
        this.e = obj;
        this.c = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(final xf xfVar, p81 p81Var) {
        final Object objApply = p81Var.apply(xfVar.e);
        xfVar.e = objApply;
        xfVar.f(new Runnable() { // from class: wf
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                xf.c(this.f, objApply);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(xf xfVar, Object obj) {
        if (xfVar.f == 0) {
            xfVar.i(obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(xf xfVar, Object obj) {
        int i = xfVar.f - 1;
        xfVar.f = i;
        if (i == 0) {
            xfVar.i(obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object d() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == this.b.n()) {
            return this.d;
        }
        gg3.v(looperMyLooper == this.a.n());
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Runnable runnable) {
        if (this.a.n().getThread().isAlive()) {
            this.a.d(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(Runnable runnable) {
        if (this.b.n().getThread().isAlive()) {
            this.b.d(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(final Object obj) {
        this.e = obj;
        f(new Runnable() { // from class: uf
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                xf.b(this.f, obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(p81 p81Var, final p81 p81Var2) {
        gg3.v(Looper.myLooper() == this.b.n());
        this.f++;
        e(new Runnable() { // from class: vf
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                xf.a(this.f, p81Var2);
            }
        });
        i(p81Var.apply(this.d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(Object obj) {
        Object obj2 = this.d;
        this.d = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.c.a(obj2, obj);
    }
}
