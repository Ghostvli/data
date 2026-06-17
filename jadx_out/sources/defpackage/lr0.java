package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lr0 extends hr0 {
    public final mr0 j;

    public lr0(boolean z, mr0 mr0Var) {
        this.a = z;
        this.j = mr0Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = mr0Var.t(byteBufferAllocate, 16L);
        this.c = mr0Var.u(byteBufferAllocate, 32L);
        this.d = mr0Var.u(byteBufferAllocate, 40L);
        this.e = mr0Var.t(byteBufferAllocate, 54L);
        this.f = mr0Var.t(byteBufferAllocate, 56L);
        this.g = mr0Var.t(byteBufferAllocate, 58L);
        this.h = mr0Var.t(byteBufferAllocate, 60L);
        this.i = mr0Var.t(byteBufferAllocate, 62L);
    }

    @Override // defpackage.hr0
    public gr0 a(long j, int i) {
        return new cq0(this.j, this, j, i);
    }

    @Override // defpackage.hr0
    public ir0 b(long j) {
        return new oh3(this.j, this, j);
    }

    @Override // defpackage.hr0
    public jr0 c(int i) {
        return new uz3(this.j, this, i);
    }
}
