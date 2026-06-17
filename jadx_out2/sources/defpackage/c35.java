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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Handler handler, c35 c35Var) {
            this.a = c35Var != null ? (Handler) gg3.q(handler) : null;
            this.b = c35Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void d(a aVar, gb0 gb0Var) {
            aVar.getClass();
            gb0Var.c();
            ((c35) fy4.l(aVar.b)).g(gb0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: r25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).f(str, j, j2);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void m(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: w25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).e(str);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n(final gb0 gb0Var) {
            gb0Var.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b35
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        c35.a.d(this.f, gb0Var);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void o(final int i, final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).l(i, j);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void p(final gb0 gb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: z25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).h(gb0Var);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q(final t41 t41Var, final lb0 lb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: a35
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).p(t41Var, lb0Var);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r(final Object obj) {
            if (this.a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.a.post(new Runnable() { // from class: u25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).n(obj, jElapsedRealtime);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s(final long j, final int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: y25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).w(j, i);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void t(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: v25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).r(exc);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void u(final b bVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((c35) fy4.l(this.f.b)).a(bVar);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void v(final e35 e35Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: t25
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
