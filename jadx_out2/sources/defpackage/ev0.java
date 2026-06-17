package defpackage;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ev0 extends c74 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c74
    public xs2 b(at2 at2Var, ByteBuffer byteBuffer) {
        return new xs2(c(new r73(byteBuffer.array(), byteBuffer.limit())));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dv0 c(r73 r73Var) {
        return new dv0((String) gg3.q(r73Var.K()), (String) gg3.q(r73Var.K()), r73Var.J(), r73Var.J(), Arrays.copyOfRange(r73Var.f(), r73Var.g(), r73Var.j()));
    }
}
