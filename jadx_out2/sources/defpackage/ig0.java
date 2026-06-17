package defpackage;

import defpackage.sy1;
import defpackage.xy1;
import java.io.FileNotFoundException;
import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ig0 implements sy1 {
    public final int a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ig0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sy1
    public long a(sy1.c cVar) {
        if (e(cVar.c)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.d - 1) * 1000, 5000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sy1
    public sy1.b b(sy1.a aVar, sy1.c cVar) {
        if (!f(cVar.c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new sy1.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new sy1.b(2, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sy1
    public int d(int i) {
        int i2 = this.a;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e(Throwable th) {
        while (th != null) {
            if (g(th)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f(IOException iOException) {
        if (!(iOException instanceof og1)) {
            return false;
        }
        int i = ((og1) iOException).i;
        return i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g(Throwable th) {
        if ((th instanceof r83) || (th instanceof FileNotFoundException) || (th instanceof kg1) || (th instanceof xy1.h)) {
            return true;
        }
        return (th instanceof ga0) && ((ga0) th).f == 2008;
    }

    public ig0() {
        this(-1);
    }
}
