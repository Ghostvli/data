package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class po4 extends CancellationException {
    public final transient ln1 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public po4(String str, ln1 ln1Var) {
        super(str);
        this.f = ln1Var;
    }

    public po4(String str) {
        this(str, null);
    }
}
