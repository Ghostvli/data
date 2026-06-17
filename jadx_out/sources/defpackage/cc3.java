package defpackage;

import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cc3 {
    public final Object a;
    public Looper b;
    public HandlerThread c;
    public int d;

    public cc3(Looper looper) {
        this.a = new Object();
        this.b = looper;
        this.c = null;
        this.d = 0;
    }

    public Looper a() {
        Looper looper;
        synchronized (this.a) {
            try {
                if (this.b == null) {
                    gg3.v(this.d == 0 && this.c == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.c = handlerThread;
                    handlerThread.start();
                    this.b = this.c.getLooper();
                }
                this.d++;
                looper = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void b() {
        HandlerThread handlerThread;
        synchronized (this.a) {
            try {
                gg3.v(this.d > 0);
                int i = this.d - 1;
                this.d = i;
                if (i == 0 && (handlerThread = this.c) != null) {
                    handlerThread.quit();
                    this.c = null;
                    this.b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public cc3() {
        this(null);
    }
}
