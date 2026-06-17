package org.mozilla.javascript.typedarrays;

import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ByteIo {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static short doReadInt16(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = bArr[i] & 255;
            i3 = (bArr[i + 1] & 255) << 8;
        } else {
            i2 = (bArr[i] & 255) << 8;
            i3 = bArr[i + 1] & 255;
        }
        return (short) (i3 | i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void doWriteInt16(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            bArr[i] = (byte) (i2 & 255);
            bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
        } else {
            bArr[i] = (byte) ((i2 >>> 8) & 255);
            bArr[i + 1] = (byte) (i2 & 255);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Float readFloat32(byte[] bArr, int i, boolean z) {
        return Float.valueOf(Float.intBitsToFloat((int) readUint32Primitive(bArr, i, z)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Double readFloat64(byte[] bArr, int i, boolean z) {
        return Double.valueOf(Double.longBitsToDouble(readUint64Primitive(bArr, i, z)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Short readInt16(byte[] bArr, int i, boolean z) {
        return Short.valueOf(doReadInt16(bArr, i, z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer readInt32(byte[] bArr, int i, boolean z) {
        if (z) {
            return Integer.valueOf(((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16));
        }
        return Integer.valueOf((bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Byte readInt8(byte[] bArr, int i) {
        return Byte.valueOf(bArr[i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer readUint16(byte[] bArr, int i, boolean z) {
        return Integer.valueOf(doReadInt16(bArr, i, z) & 65535);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object readUint32(byte[] bArr, int i, boolean z) {
        return Long.valueOf(readUint32Primitive(bArr, i, z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long readUint32Primitive(byte[] bArr, int i, boolean z) {
        long j;
        if (z) {
            j = ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 2]) & 255) << 16) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8);
        } else {
            j = (((long) bArr[i + 3]) & 255) | ((((long) bArr[i + 1]) & 255) << 16) | ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 2]) & 255) << 8);
        }
        return j & 4294967295L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long readUint64Primitive(byte[] bArr, int i, boolean z) {
        if (z) {
            return ((((long) bArr[i + 7]) & 255) << 56) | ((((long) bArr[i + 2]) & 255) << 16) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer readUint8(byte[] bArr, int i) {
        return Integer.valueOf(bArr[i] & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeFloat32(byte[] bArr, int i, double d, boolean z) {
        writeUint32(bArr, i, Float.floatToIntBits((float) d), z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeFloat64(byte[] bArr, int i, double d, boolean z) {
        writeUint64(bArr, i, Double.doubleToLongBits(d), z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeInt16(byte[] bArr, int i, int i2, boolean z) {
        doWriteInt16(bArr, i, i2, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeInt32(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            bArr[i] = (byte) (i2 & 255);
            bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
            bArr[i + 2] = (byte) ((i2 >>> 16) & 255);
            bArr[i + 3] = (byte) ((i2 >>> 24) & 255);
            return;
        }
        bArr[i] = (byte) ((i2 >>> 24) & 255);
        bArr[i + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i + 3] = (byte) (i2 & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeInt8(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeUint16(byte[] bArr, int i, int i2, boolean z) {
        doWriteInt16(bArr, i, i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeUint32(byte[] bArr, int i, long j, boolean z) {
        if (z) {
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >>> 8) & 255);
            bArr[i + 2] = (byte) ((j >>> 16) & 255);
            bArr[i + 3] = (byte) ((j >>> 24) & 255);
            return;
        }
        bArr[i] = (byte) ((j >>> 24) & 255);
        bArr[i + 1] = (byte) ((j >>> 16) & 255);
        bArr[i + 2] = (byte) ((j >>> 8) & 255);
        bArr[i + 3] = (byte) (j & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeUint64(byte[] bArr, int i, long j, boolean z) {
        if (z) {
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >>> 8) & 255);
            bArr[i + 2] = (byte) ((j >>> 16) & 255);
            bArr[i + 3] = (byte) ((j >>> 24) & 255);
            bArr[i + 4] = (byte) ((j >>> 32) & 255);
            bArr[i + 5] = (byte) ((j >>> 40) & 255);
            bArr[i + 6] = (byte) ((j >>> 48) & 255);
            bArr[i + 7] = (byte) ((j >>> 56) & 255);
            return;
        }
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeUint8(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
    }
}
