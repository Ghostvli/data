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
        public a() {
        }

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
        public b() {
        }

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
        public c() {
        }

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
        public d() {
        }

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

    public ep(Context context) {
        ly4.a();
        this.a = lp.d();
        fp fpVar = new fp(context);
        this.c = fpVar;
        fpVar.o(this.i);
        this.h = new Handler();
    }

    public static /* synthetic */ void c(final ep epVar, final pg3 pg3Var) {
        if (epVar.f) {
            epVar.a.c(new Runnable() { // from class: dp
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.c.m(pg3Var);
                }
            });
        } else {
            Log.d(n, "Camera is closed, not requesting preview");
        }
    }

    public void l() {
        ly4.a();
        if (this.f) {
            this.a.c(this.m);
        } else {
            this.g = true;
        }
        this.f = false;
    }

    public void m() {
        ly4.a();
        z();
        this.a.c(this.k);
    }

    public nm0 n() {
        return this.e;
    }

    public final c94 o() {
        return this.c.h();
    }

    public boolean p() {
        return this.g;
    }

    public final void q(Exception exc) {
        Handler handler = this.d;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public void r() {
        ly4.a();
        this.f = true;
        this.g = false;
        this.a.e(this.j);
    }

    public void s(final pg3 pg3Var) {
        this.h.post(new Runnable() { // from class: bp
            @Override // java.lang.Runnable
            public final void run() {
                ep.c(this.f, pg3Var);
            }
        });
    }

    public void t(jp jpVar) {
        if (this.f) {
            return;
        }
        this.i = jpVar;
        this.c.o(jpVar);
    }

    public void u(nm0 nm0Var) {
        this.e = nm0Var;
        this.c.q(nm0Var);
    }

    public void v(Handler handler) {
        this.d = handler;
    }

    public void w(kp kpVar) {
        this.b = kpVar;
    }

    public void x(final boolean z) {
        ly4.a();
        if (this.f) {
            this.a.c(new Runnable() { // from class: cp
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.c.t(z);
                }
            });
        }
    }

    public void y() {
        ly4.a();
        z();
        this.a.c(this.l);
    }

    public final void z() {
        if (this.f) {
            return;
        }
        e04.a("CameraInstance is not open");
    }
}
