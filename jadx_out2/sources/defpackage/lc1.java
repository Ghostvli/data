package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class lc1 extends Handler implements ag3 {
    public final ka3 f;
    public final int g;
    public final uu0 h;
    public boolean i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lc1(uu0 uu0Var, Looper looper, int i) {
        super(looper);
        this.h = uu0Var;
        this.g = i;
        this.f = new ka3();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ag3
    public void a(sh4 sh4Var, Object obj) {
        ja3 ja3VarA = ja3.a(sh4Var, obj);
        synchronized (this) {
            try {
                this.f.a(ja3VarA);
                if (!this.i) {
                    this.i = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new wu0("Could not send handler message");
                    }
                }
            } finally {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                ja3 ja3VarB = this.f.b();
                if (ja3VarB == null) {
                    synchronized (this) {
                        ja3VarB = this.f.b();
                        if (ja3VarB == null) {
                            this.i = false;
                            return;
                        }
                    }
                }
                this.h.h(ja3VarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.g);
            if (!sendMessage(obtainMessage())) {
                throw new wu0("Could not send handler message");
            }
            this.i = true;
        } catch (Throwable th) {
            this.i = false;
            throw th;
        }
    }
}
