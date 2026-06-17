package defpackage;

import android.os.Handler;
import androidx.media3.exoplayer.b;
import defpackage.od;
import defpackage.pd;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface od {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Handler a;
        public final od b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Handler handler, od odVar) {
            this.a = odVar != null ? (Handler) gg3.q(handler) : null;
            this.b = odVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void d(a aVar, gb0 gb0Var) {
            aVar.getClass();
            gb0Var.c();
            ((od) fy4.l(aVar.b)).i(gb0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void A(final boolean z) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ld
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).onSkipSilenceEnabledChanged(z);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void B(final int i, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: cd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).t(i, j, j2);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void o(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ad
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).q(exc);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void p(final b bVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: nd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).x(bVar);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q(final int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: md
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).onAudioSessionIdChanged(i);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void r(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: jd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).d(exc);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s(final pd.a aVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).c(aVar);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void t(final pd.a aVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ed
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).b(aVar);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void u(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: fd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).k(str, j, j2);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void v(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: gd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).j(str);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void w(final gb0 gb0Var) {
            gb0Var.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: bd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        od.a.d(this.f, gb0Var);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void x(final gb0 gb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: hd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).u(gb0Var);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void y(final t41 t41Var, final lb0 lb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: kd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).m(t41Var, lb0Var);
                    }
                });
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void z(final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: dd
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).o(j);
                    }
                });
            }
        }
    }

    void b(pd.a aVar);

    void c(pd.a aVar);

    void d(Exception exc);

    void i(gb0 gb0Var);

    void j(String str);

    void k(String str, long j, long j2);

    void m(t41 t41Var, lb0 lb0Var);

    void o(long j);

    void onAudioSessionIdChanged(int i);

    void onSkipSilenceEnabledChanged(boolean z);

    void q(Exception exc);

    void t(int i, long j, long j2);

    void u(gb0 gb0Var);

    void x(b bVar);
}
