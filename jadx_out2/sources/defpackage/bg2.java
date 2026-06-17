package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bg2 extends IOException {
    public final ja0 f;
    public final Uri g;
    public final Map h;
    public final long i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bg2(ja0 ja0Var, Uri uri, Map map, long j, Throwable th) {
        super(th);
        this.f = ja0Var;
        this.g = uri;
        this.h = map;
        this.i = j;
    }
}
