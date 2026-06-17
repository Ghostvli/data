package defpackage;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ep {
    public static final String n = "ep";
    public lp a;
    public kp b;
    public fp c;
    public Handler d;
    public nm0 e;
    public Handler h;
    public boolean f = false;
    public boolean g = true;
    public jp i = new jp();
    public Runnable j = new a();
    public Runnable k = new b();
    public Runnable l = new c();
    public Runnable m = new d();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(ep.n, "Opening camera");
                ep.this.c.l();
            } catch (Exception e) {
                ep.this.q(e);
                Log.e(ep.n, "Failed to open camera", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(ep.n, "Configuring camera");
                ep.this.c.e();
                if (ep.this.d != null) {
                    ep.this.d.obtainMessage(R.id.zxing_prewiew_size_ready, ep.this.o()).sendToTarget();
                }
            } catch (Exception e) {
                ep.this.q(e);
                Log.e(ep.n, "Failed to configure camera", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(ep.n, "Starting preview");
                ep.this.c.s(ep.this.b);
                ep.this.c.u();
            } catch (Exception e) {
                ep.this.q(e);
                Log.e(ep.n, "Failed to start preview", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(ep.n, "Closing camera");
                ep.this.c.v();
                ep.this.c.d();
            } catch (Exception e) {
                Log.e(ep.n, "Failed to close camera", e);
            }
            ep.this.g = true;
            ep.this.d.sendEmptyMessage(R.id.zxing_camera_closed);
            ep.this.a.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ep(Context context) {
        ly4.a();
        this.a = lp.d();
        fp fpVar = new fp(context);
        this.c = fpVar;
        fpVar.o(this.i);
        this.h = new Handler();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(final ep epVar, final pg3 pg3Var) {
        if (epVar.f) {
            epVar.a.c(new Runnable() { // from class: dp
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.c.m(pg3Var);
                }
            });
        } else {
            Log.d(n, "Camera is closed, not requesting preview");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        ly4.a();
        if (this.f) {
            this.a.c(this.m);
        } else {
            this.g = true;
        }
        this.f = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m() {
        ly4.a();
        z();
        this.a.c(this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nm0 n() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c94 o() {
        return this.c.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(Exception exc) {
        Handler handler = this.d;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r() {
        ly4.a();
        this.f = true;
        this.g = false;
        this.a.e(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(final pg3 pg3Var) {
        this.h.post(new Runnable() { // from class: bp
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                ep.c(this.f, pg3Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(jp jpVar) {
        if (this.f) {
            return;
        }
        this.i = jpVar;
        this.c.o(jpVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u(nm0 nm0Var) {
        this.e = nm0Var;
        this.c.q(nm0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(Handler handler) {
        this.d = handler;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w(kp kpVar) {
        this.b = kpVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x(final boolean z) {
        ly4.a();
        if (this.f) {
            this.a.c(new Runnable() { // from class: cp
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.c.t(z);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y() {
        ly4.a();
        z();
        this.a.c(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z() {
        if (this.f) {
            return;
        }
        e04.a("CameraInstance is not open");
    }
}
