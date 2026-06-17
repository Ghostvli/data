package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v93 {
    public static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && i3 < i4) {
            c(byteBufferOrder, (int) ((((long) b(byteBuffer, i)) * ((long) i3)) / ((long) i4)), i);
            if (byteBuffer.position() == iPosition + i2) {
                i3++;
                iPosition = byteBuffer.position();
            }
        }
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    public static int b(ByteBuffer byteBuffer, int i) {
        if (i == 2) {
            return ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
        }
        if (i == 3) {
            return (byteBuffer.get() & 255) << 24;
        }
        if (i == 4) {
            float fR = fy4.r(byteBuffer.getFloat(), -1.0f, 1.0f);
            return fR < 0.0f ? (int) ((-fR) * (-2.1474836E9f)) : (int) (fR * 2.1474836E9f);
        }
        if (i == 21) {
            return ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
        }
        if (i == 22) {
            return ((byteBuffer.get() & 255) << 24) | (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
        }
        if (i == 268435456) {
            return ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 24);
        }
        if (i == 1342177280) {
            return ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
        }
        if (i == 1610612736) {
            return (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 8);
        }
        if (i == 1879048192) {
            double dQ = fy4.q(byteBuffer.getDouble(), -1.0d, 1.0d);
            return dQ < 0.0d ? (int) ((-dQ) * (-2.147483648E9d)) : (int) (dQ * 2.147483647E9d);
        }
        z20.a();
        return 0;
    }

    public static void c(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 == 2) {
            byteBuffer.put((byte) (i >> 16));
            byteBuffer.put((byte) (i >> 24));
            return;
        }
        if (i2 == 3) {
            byteBuffer.put((byte) (i >> 24));
            return;
        }
        if (i2 == 4) {
            if (i < 0) {
                byteBuffer.putFloat((-i) / (-2.1474836E9f));
                return;
            } else {
                byteBuffer.putFloat(i / 2.1474836E9f);
                return;
            }
        }
        if (i2 == 21) {
            byteBuffer.put((byte) (i >> 8));
            byteBuffer.put((byte) (i >> 16));
            byteBuffer.put((byte) (i >> 24));
            return;
        }
        if (i2 == 22) {
            byteBuffer.put((byte) i);
            byteBuffer.put((byte) (i >> 8));
            byteBuffer.put((byte) (i >> 16));
            byteBuffer.put((byte) (i >> 24));
            return;
        }
        if (i2 == 268435456) {
            byteBuffer.put((byte) (i >> 24));
            byteBuffer.put((byte) (i >> 16));
            return;
        }
        if (i2 == 1342177280) {
            byteBuffer.put((byte) (i >> 24));
            byteBuffer.put((byte) (i >> 16));
            byteBuffer.put((byte) (i >> 8));
        } else {
            if (i2 == 1610612736) {
                byteBuffer.put((byte) (i >> 24));
                byteBuffer.put((byte) (i >> 16));
                byteBuffer.put((byte) (i >> 8));
                byteBuffer.put((byte) i);
                return;
            }
            if (i2 != 1879048192) {
                z20.a();
            } else if (i < 0) {
                byteBuffer.putDouble((-i) / (-2.147483648E9d));
            } else {
                byteBuffer.putDouble(((double) i) / 2.147483647E9d);
            }
        }
    }
}
