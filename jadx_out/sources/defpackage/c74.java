package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c74 implements ys2 {
    @Override // defpackage.ys2
    public final xs2 a(at2 at2Var) {
        ByteBuffer byteBuffer = (ByteBuffer) gg3.q(at2Var.data);
        gg3.d(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return b(at2Var, byteBuffer);
    }

    public abstract xs2 b(at2 at2Var, ByteBuffer byteBuffer);
}
