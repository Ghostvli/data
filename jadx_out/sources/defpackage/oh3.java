package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class oh3 extends ir0 {
    public oh3(mr0 mr0Var, hr0 hr0Var, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(hr0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = hr0Var.c + (j * ((long) hr0Var.e));
        this.a = mr0Var.y(byteBufferAllocate, j2);
        this.b = mr0Var.u(byteBufferAllocate, 8 + j2);
        this.c = mr0Var.u(byteBufferAllocate, 16 + j2);
        this.d = mr0Var.u(byteBufferAllocate, j2 + 40);
    }
}
