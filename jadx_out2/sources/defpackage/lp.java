package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class lp {
    public static lp e;
    public Handler a;
    public HandlerThread b;
    public int c = 0;
    public final Object d = new Object();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lp d() {
        if (e == null) {
            e = new lp();
        }
        return e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        synchronized (this.d) {
            try {
                if (this.a == null) {
                    if (this.c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.b = handlerThread;
                    handlerThread.start();
                    this.a = new Handler(this.b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        synchronized (this.d) {
            try {
                int i = this.c - 1;
                this.c = i;
                if (i == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(Runnable runnable) {
        synchronized (this.d) {
            a();
            this.a.post(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Runnable runnable) {
        synchronized (this.d) {
            this.c++;
            c(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        synchronized (this.d) {
            this.b.quit();
            this.b = null;
            this.a = null;
        }
    }
}
