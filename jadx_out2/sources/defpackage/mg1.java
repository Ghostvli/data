package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mg1 extends ga0 {
    public final ja0 g;
    public final int h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mg1(ja0 ja0Var, int i, int i2) {
        super(a(i, i2));
        this.g = ja0Var;
        this.h = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static mg1 b(IOException iOException, ja0 ja0Var, int i) {
        String message = iOException.getMessage();
        int i2 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !xa.f(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i2 == 2007 ? new kg1(iOException, ja0Var) : new mg1(iOException, ja0Var, i2, i);
    }

    public mg1(String str, ja0 ja0Var, int i, int i2) {
        super(str, a(i, i2));
        this.g = ja0Var;
        this.h = i2;
    }

    public mg1(IOException iOException, ja0 ja0Var, int i, int i2) {
        super(iOException, a(i, i2));
        this.g = ja0Var;
        this.h = i2;
    }

    public mg1(String str, IOException iOException, ja0 ja0Var, int i, int i2) {
        super(str, iOException, a(i, i2));
        this.g = ja0Var;
        this.h = i2;
    }
}
