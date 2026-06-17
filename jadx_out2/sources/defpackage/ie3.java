package defpackage;

import android.media.metrics.LogSessionId;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ie3 {
    public static final ie3 c = new ie3("");
    public static final ie3 d = new ie3("preload");
    public final String a;
    public final a b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public LogSessionId a = LogSessionId.LOG_SESSION_ID_NONE;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(LogSessionId logSessionId) {
            gg3.v(this.a.equals(LogSessionId.LOG_SESSION_ID_NONE));
            this.a = logSessionId;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ie3(String str) {
        this.a = str;
        this.b = Build.VERSION.SDK_INT >= 31 ? new a() : null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized LogSessionId a() {
        return ((a) gg3.q(this.b)).a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void b(LogSessionId logSessionId) {
        ((a) gg3.q(this.b)).a(logSessionId);
    }
}
