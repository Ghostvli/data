package org.aomedia.avif.android;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvifDecoder {
    private boolean alphaPresent;
    private long decoder;
    private int depth;
    private int frameCount;
    private double[] frameDurations;
    private int height;
    private int repetitionCount;
    private int width;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Info {
        public boolean alphaPresent;
        public int depth;
        public int height;
        public int width;
    }

    static {
        try {
            System.loadLibrary("avif_android");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private AvifDecoder(ByteBuffer byteBuffer, int i) {
        this.decoder = createDecoder(byteBuffer, byteBuffer.remaining(), i);
    }

    public static AvifDecoder create(ByteBuffer byteBuffer, int i) {
        AvifDecoder avifDecoder = new AvifDecoder(byteBuffer, i);
        if (avifDecoder.decoder == 0) {
            return null;
        }
        return avifDecoder;
    }

    private native long createDecoder(ByteBuffer byteBuffer, int i, int i2);

    public static boolean decode(ByteBuffer byteBuffer, int i, Bitmap bitmap) {
        return decode(byteBuffer, i, bitmap, 0);
    }

    public static native boolean decode(ByteBuffer byteBuffer, int i, Bitmap bitmap, int i2);

    private native void destroyDecoder(long j);

    public static native boolean getInfo(ByteBuffer byteBuffer, int i, Info info);

    public static boolean isAvifImage(ByteBuffer byteBuffer) {
        return isAvifImage(byteBuffer, byteBuffer.remaining());
    }

    private static native boolean isAvifImage(ByteBuffer byteBuffer, int i);

    private native int nextFrame(long j, Bitmap bitmap);

    private native int nextFrameIndex(long j);

    private native int nthFrame(long j, int i, Bitmap bitmap);

    public static native String resultToString(int i);

    public static native String versionString();

    public boolean getAlphaPresent() {
        return this.alphaPresent;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public double[] getFrameDurations() {
        return this.frameDurations;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRepetitionCount() {
        return this.repetitionCount;
    }

    public int getWidth() {
        return this.width;
    }

    public int nextFrame(Bitmap bitmap) {
        return nextFrame(this.decoder, bitmap);
    }

    public int nextFrameIndex() {
        return nextFrameIndex(this.decoder);
    }

    public int nthFrame(int i, Bitmap bitmap) {
        return nthFrame(this.decoder, i, bitmap);
    }

    public void release() {
        long j = this.decoder;
        if (j != 0) {
            destroyDecoder(j);
        }
        this.decoder = 0L;
    }

    public static AvifDecoder create(ByteBuffer byteBuffer) {
        return create(byteBuffer, 1);
    }
}
