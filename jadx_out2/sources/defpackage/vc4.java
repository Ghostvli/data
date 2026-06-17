package defpackage;

import defpackage.xs2;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vc4 extends c74 {
    public final r73 a = new r73();
    public final q73 b = new q73();
    public yo4 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c74
    public xs2 b(at2 at2Var, ByteBuffer byteBuffer) {
        yo4 yo4Var = this.c;
        if (yo4Var == null || at2Var.f != yo4Var.f()) {
            yo4 yo4Var2 = new yo4(at2Var.timeUs);
            this.c = yo4Var2;
            yo4Var2.a(at2Var.timeUs - at2Var.f);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.a.d0(bArrArray, iLimit);
        this.b.o(bArrArray, iLimit);
        this.b.r(39);
        long jH = (((long) this.b.h(1)) << 32) | ((long) this.b.h(32));
        this.b.r(20);
        int iH = this.b.h(12);
        int iH2 = this.b.h(8);
        this.a.g0(14);
        xs2.a aVarD = iH2 != 0 ? iH2 != 255 ? iH2 != 4 ? iH2 != 5 ? iH2 != 6 ? null : jo4.d(this.a, jH, this.c) : wc4.d(this.a, jH, this.c) : yc4.d(this.a) : xg3.d(this.a, iH, jH) : new xc4();
        return aVarD == null ? new xs2(new xs2.a[0]) : new xs2(aVarD);
    }
}
