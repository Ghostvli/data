package defpackage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import defpackage.fa1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hb3 extends Surface {
    public static int i;
    public static boolean j;
    public final boolean f;
    public final b g;
    public boolean h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends HandlerThread implements Handler.Callback {
        public eq0 f;
        public Handler g;
        public Error h;
        public RuntimeException i;
        public hb3 j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public hb3 a(int i) {
            boolean z;
            start();
            this.g = new Handler(getLooper(), this);
            this.f = new eq0(this.g);
            synchronized (this) {
                z = false;
                this.g.obtainMessage(1, i, 0).sendToTarget();
                while (this.j == null && this.i == null && this.h == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.i;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.h;
            if (error == null) {
                return (hb3) gg3.q(this.j);
            }
            throw error;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b(int i) throws fa1.a {
            gg3.q(this.f);
            this.f.h(i);
            this.j = new hb3(this, this.f.g(), i != 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            gg3.q(this.g);
            this.g.sendEmptyMessage(2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d() {
            gg3.q(this.f);
            this.f.i();
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (fa1.a e) {
                    xz1.e("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                    this.i = new IllegalStateException(e);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    xz1.e("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.h = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e3) {
                    xz1.e("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.i = e3;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hb3(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.g = bVar;
        this.f = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(Context context) {
        try {
            if (fa1.n(context)) {
                return fa1.o() ? 1 : 2;
            }
            return 0;
        } catch (fa1.a e) {
            xz1.d("PlaceholderSurface", "Failed to determine secure mode due to GL error: " + e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized boolean d(Context context) {
        try {
            if (!j) {
                i = c(context);
                j = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return i != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hb3 s(Context context, boolean z) {
        gg3.v(!z || d(context));
        return new b().a(z ? i : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.g) {
            try {
                if (!this.h) {
                    this.g.c();
                    this.h = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
