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

        public a(Handler handler, od odVar) {
            this.a = odVar != null ? (Handler) gg3.q(handler) : null;
            this.b = odVar;
        }

        public static /* synthetic */ void d(a aVar, gb0 gb0Var) {
            aVar.getClass();
            gb0Var.c();
            ((od) fy4.l(aVar.b)).i(gb0Var);
        }

        public void A(final boolean z) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ld
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).onSkipSilenceEnabledChanged(z);
                    }
                });
            }
        }

        public void B(final int i, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: cd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).t(i, j, j2);
                    }
                });
            }
        }

        public void o(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).q(exc);
                    }
                });
            }
        }

        public void p(final b bVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: nd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).x(bVar);
                    }
                });
            }
        }

        public void q(final int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: md
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).onAudioSessionIdChanged(i);
                    }
                });
            }
        }

        public void r(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: jd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).d(exc);
                    }
                });
            }
        }

        public void s(final pd.a aVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).c(aVar);
                    }
                });
            }
        }

        public void t(final pd.a aVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ed
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).b(aVar);
                    }
                });
            }
        }

        public void u(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: fd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).k(str, j, j2);
                    }
                });
            }
        }

        public void v(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: gd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).j(str);
                    }
                });
            }
        }

        public void w(final gb0 gb0Var) {
            gb0Var.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: bd
                    @Override // java.lang.Runnable
                    public final void run() {
                        od.a.d(this.f, gb0Var);
                    }
                });
            }
        }

        public void x(final gb0 gb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: hd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).u(gb0Var);
                    }
                });
            }
        }

        public void y(final t41 t41Var, final lb0 lb0Var) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: kd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((od) fy4.l(this.f.b)).m(t41Var, lb0Var);
                    }
                });
            }
        }

        public void z(final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: dd
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
