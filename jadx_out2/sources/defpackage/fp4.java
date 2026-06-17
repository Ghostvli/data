package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fp4 extends zg {
    public static final int i = Float.floatToIntBits(Float.NaN);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void p(int i2, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (iFloatToIntBits == i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public void f(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferO;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i3 = this.b.c;
        if (i3 == 2) {
            byteBufferO = o(i2 * 2);
            while (iPosition < iLimit) {
                p(((byteBuffer.get(iPosition) & 255) << 16) | ((byteBuffer.get(iPosition + 1) & 255) << 24), byteBufferO);
                iPosition += 2;
            }
        } else if (i3 == 1342177280) {
            byteBufferO = o((i2 / 3) * 4);
            while (iPosition < iLimit) {
                p(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferO);
                iPosition += 3;
            }
        } else if (i3 == 1610612736) {
            byteBufferO = o(i2);
            while (iPosition < iLimit) {
                p((byteBuffer.get(iPosition + 3) & 255) | ((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferO);
                iPosition += 4;
            }
        } else if (i3 == 1879048192) {
            byteBufferO = o(i2 / 2);
            while (iPosition < iLimit) {
                byteBufferO.putFloat((float) byteBuffer.getDouble(iPosition));
                iPosition += 8;
            }
        } else if (i3 == 21) {
            byteBufferO = o((i2 / 3) * 4);
            while (iPosition < iLimit) {
                p(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferO);
                iPosition += 3;
            }
        } else {
            if (i3 != 22) {
                z20.a();
                return;
            }
            byteBufferO = o(i2);
            while (iPosition < iLimit) {
                p((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferO);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferO.flip();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public yc.a j(yc.a aVar) throws yc.c {
        int i2 = aVar.c;
        if (fy4.Q0(i2) || i2 == 2) {
            return i2 != 4 ? new yc.a(aVar.a, aVar.b, 4) : yc.a.e;
        }
        throw new yc.c(aVar);
    }
}
