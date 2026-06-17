package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ds extends zg {
    public int[] i;
    public int[] j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    @Override // defpackage.yc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) gg3.q(this.j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferO = o(((iLimit - iPosition) / this.b.d) * this.c.d);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                int iW = (fy4.W(this.b.c) * i) + iPosition;
                int i2 = this.b.c;
                if (i2 == 2) {
                    byteBufferO.putShort(byteBuffer.getShort(iW));
                } else if (i2 == 3) {
                    byteBufferO.put(byteBuffer.get(iW));
                } else if (i2 == 4) {
                    byteBufferO.putFloat(byteBuffer.getFloat(iW));
                } else if (i2 == 21) {
                    fy4.q1(byteBufferO, fy4.m0(byteBuffer, iW));
                } else if (i2 == 22) {
                    byteBufferO.putInt(byteBuffer.getInt(iW));
                } else if (i2 != 268435456) {
                    if (i2 != 1342177280) {
                        if (i2 != 1610612736) {
                            if (i2 != 1879048192) {
                                jr1.a("Unexpected encoding: ", this.b.c);
                                return;
                            }
                            byteBufferO.putDouble(byteBuffer.getDouble(iW));
                        }
                    }
                }
            }
            iPosition += this.b.d;
        }
        byteBuffer.position(iLimit);
        byteBufferO.flip();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public yc.a j(yc.a aVar) throws yc.c {
        int[] iArr = this.i;
        if (iArr == null) {
            return yc.a.e;
        }
        if (!fy4.R0(aVar.c)) {
            throw new yc.c(aVar);
        }
        boolean z = aVar.b != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= aVar.b) {
                throw new yc.c("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", aVar);
            }
            z |= i2 != i;
            i++;
        }
        return z ? new yc.a(aVar.a, iArr.length, aVar.c) : yc.a.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public void l(yc.b bVar) {
        this.j = this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public void n() {
        this.j = null;
        this.i = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(int[] iArr) {
        this.i = iArr;
    }
}
