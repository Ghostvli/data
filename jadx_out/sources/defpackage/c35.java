package defpackage;

import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.exoplayer.b;
import defpackage.c35;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface c35 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Handler a;
        public final c35 b;

        public a(Handler handler, c35 c35Var) {
            this.a = c35Var != null ? (Handler) gg3.q(handler) : null;
            this.b = c35Var;
        }

        public static /* synthetic */ void d(a aVar, gb0 gb0Var) {
            aVar.getClass();
            gb0Var.c();
            ((c35) fy4.l(aVar.b)).g(gb0Var);
        }

        public void l(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: r25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).f(str, j, j2);
                    }
                });
            }
        }

        public void m(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: w25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).e(str);
                    }
                });
            }
        }

        public void n(final gb0 gb0Var) {
            gb0Var.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b35
                    @Override // java.lang.Runnable
                    public final void run() {
                        c35.a.d(this.f, gb0Var);
                    }
                });
            }
        }

        public void o(final int i, final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).l(i, j);
                    }
                });
            }
        }

        public void p(final gb0 gb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: z25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).h(gb0Var);
                    }
                });
            }
        }

        public void q(final t41 t41Var, final lb0 lb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: a35
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).p(t41Var, lb0Var);
                    }
                });
            }
        }

        public void r(final Object obj) {
            if (this.a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.a.post(new Runnable() { // from class: u25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).n(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void s(final long j, final int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: y25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).w(j, i);
                    }
                });
            }
        }

        public void t(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: v25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).r(exc);
                    }
                });
            }
        }

        public void u(final b bVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).a(bVar);
                    }
                });
            }
        }

        public void v(final e35 e35Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: t25
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).onVideoSizeChanged(e35Var);
                    }
                });
            }
        }
    }

    void a(b bVar);

    void e(String str);

    void f(String str, long j, long j2);

    void g(gb0 gb0Var);

    void h(gb0 gb0Var);

    void l(int i, long j);

    void n(Object obj, long j);

    void onVideoSizeChanged(e35 e35Var);

    void p(t41 t41Var, lb0 lb0Var);

    void r(Exception exc);

    void w(long j, int i);
}
