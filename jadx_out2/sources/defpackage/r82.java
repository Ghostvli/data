package defpackage;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r82 extends b82 {
    public final int i;
    public final boolean j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r82(Throwable th, c82 c82Var, Surface surface) {
        super(th, c82Var);
        this.i = System.identityHashCode(surface);
        this.j = surface == null || surface.isValid();
    }
}
