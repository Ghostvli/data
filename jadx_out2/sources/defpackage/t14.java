package defpackage;

import com.fongmi.android.tv.service.PlaybackService;
import com.github.catvod.Proxy;
import com.github.catvod.utils.Util;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t14 {
    public volatile PlaybackService a;
    public volatile gx2 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile t14 a = new t14();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t14 b() {
        return a.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String c() {
        return e(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String d(String str) {
        return e(true) + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String e(boolean z) {
        StringBuilder sb = new StringBuilder("http://");
        sb.append(z ? "127.0.0.1" : Util.getIp());
        sb.append(":");
        sb.append(Proxy.getPort());
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PlaybackService f() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void g() {
        if (this.b != null) {
            this.b.stop();
        }
        this.a = null;
        this.b = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(PlaybackService playbackService) {
        this.a = playbackService;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void i() {
        if (this.b != null) {
            return;
        }
        for (int i = 9978; i < 9999; i++) {
            try {
                this.b = new gx2(i);
                this.b.start(500);
                Proxy.set(i);
                break;
            } catch (Throwable unused) {
                this.b = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j() {
        ul4.c(new Runnable() { // from class: s14
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.g();
            }
        });
    }
}
