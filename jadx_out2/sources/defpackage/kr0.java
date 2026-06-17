package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class kr0 extends hr0 {
    public final mr0 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kr0(boolean z, mr0 mr0Var) {
        this.a = z;
        this.j = mr0Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = mr0Var.t(byteBufferAllocate, 16L);
        this.c = mr0Var.y(byteBufferAllocate, 28L);
        this.d = mr0Var.y(byteBufferAllocate, 32L);
        this.e = mr0Var.t(byteBufferAllocate, 42L);
        this.f = mr0Var.t(byteBufferAllocate, 44L);
        this.g = mr0Var.t(byteBufferAllocate, 46L);
        this.h = mr0Var.t(byteBufferAllocate, 48L);
        this.i = mr0Var.t(byteBufferAllocate, 50L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hr0
    public gr0 a(long j, int i) {
        return new bq0(this.j, this, j, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hr0
    public ir0 b(long j) {
        return new nh3(this.j, this, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hr0
    public jr0 c(int i) {
        return new tz3(this.j, this, i);
    }
}
