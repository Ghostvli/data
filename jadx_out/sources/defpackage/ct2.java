package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ct2 extends wk4 {
    public static ct2 h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new ct2());
    }

    public static ct2 i(ByteBuffer byteBuffer, ct2 ct2Var) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return ct2Var.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public ct2 f(int i, ByteBuffer byteBuffer) {
        g(i, byteBuffer);
        return this;
    }

    public void g(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public bt2 j(bt2 bt2Var, int i) {
        int iB = b(6);
        if (iB != 0) {
            return bt2Var.f(a(d(iB) + (i * 4)), this.b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.b.getInt(iB + this.a);
        }
        return 0;
    }
}
