package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gp4 extends zg {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    @Override // defpackage.yc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.b.c;
        if (i2 == 3) {
            i *= 2;
        } else if (i2 == 4) {
            i /= 2;
        } else {
            if (i2 != 21) {
                if (i2 != 22) {
                    if (i2 != 268435456) {
                        if (i2 != 1342177280) {
                            if (i2 != 1610612736) {
                                if (i2 != 1879048192) {
                                    z20.a();
                                    return;
                                }
                                i /= 4;
                            }
                        }
                    }
                }
            }
            i /= 3;
            i *= 2;
        }
        ByteBuffer byteBufferO = o(i);
        int i3 = this.b.c;
        if (i3 == 3) {
            while (iPosition < iLimit) {
                byteBufferO.put((byte) 0);
                byteBufferO.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i3 == 4) {
            while (iPosition < iLimit) {
                short sR = (short) (fy4.r(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                byteBufferO.put((byte) (sR & 255));
                byteBufferO.put((byte) ((sR >> 8) & 255));
                iPosition += 4;
            }
        } else if (i3 == 21) {
            while (iPosition < iLimit) {
                byteBufferO.put(byteBuffer.get(iPosition + 1));
                byteBufferO.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i3 == 22) {
            while (iPosition < iLimit) {
                byteBufferO.put(byteBuffer.get(iPosition + 2));
                byteBufferO.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        } else if (i3 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferO.put(byteBuffer.get(iPosition + 1));
                byteBufferO.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i3 == 1342177280) {
            while (iPosition < iLimit) {
                byteBufferO.put(byteBuffer.get(iPosition + 1));
                byteBufferO.put(byteBuffer.get(iPosition));
                iPosition += 3;
            }
        } else if (i3 == 1610612736) {
            while (iPosition < iLimit) {
                byteBufferO.put(byteBuffer.get(iPosition + 1));
                byteBufferO.put(byteBuffer.get(iPosition));
                iPosition += 4;
            }
        } else {
            if (i3 != 1879048192) {
                z20.a();
                return;
            }
            while (iPosition < iLimit) {
                short sQ = (short) (fy4.q(byteBuffer.getDouble(iPosition), -1.0d, 1.0d) * 32767.0d);
                byteBufferO.put((byte) (sQ & 255));
                byteBufferO.put((byte) ((sQ >> 8) & 255));
                iPosition += 8;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferO.flip();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public yc.a j(yc.a aVar) throws yc.c {
        int i = aVar.c;
        if (i == 3 || i == 2 || i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4 || i == 1879048192) {
            return i != 2 ? new yc.a(aVar.a, aVar.b, 2) : yc.a.e;
        }
        throw new yc.c(aVar);
    }
}
