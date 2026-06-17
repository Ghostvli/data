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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        try {
            System.loadLibrary("avif_android");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private AvifDecoder(ByteBuffer byteBuffer, int i) {
        this.decoder = createDecoder(byteBuffer, byteBuffer.remaining(), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AvifDecoder create(ByteBuffer byteBuffer, int i) {
        AvifDecoder avifDecoder = new AvifDecoder(byteBuffer, i);
        if (avifDecoder.decoder == 0) {
            return null;
        }
        return avifDecoder;
    }

    private native long createDecoder(ByteBuffer byteBuffer, int i, int i2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean decode(ByteBuffer byteBuffer, int i, Bitmap bitmap) {
        return decode(byteBuffer, i, bitmap, 0);
    }

    public static native boolean decode(ByteBuffer byteBuffer, int i, Bitmap bitmap, int i2);

    private native void destroyDecoder(long j);

    public static native boolean getInfo(ByteBuffer byteBuffer, int i, Info info);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isAvifImage(ByteBuffer byteBuffer) {
        return isAvifImage(byteBuffer, byteBuffer.remaining());
    }

    private static native boolean isAvifImage(ByteBuffer byteBuffer, int i);

    private native int nextFrame(long j, Bitmap bitmap);

    private native int nextFrameIndex(long j);

    private native int nthFrame(long j, int i, Bitmap bitmap);

    public static native String resultToString(int i);

    public static native String versionString();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean getAlphaPresent() {
        return this.alphaPresent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getDepth() {
        return this.depth;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getFrameCount() {
        return this.frameCount;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public double[] getFrameDurations() {
        return this.frameDurations;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getHeight() {
        return this.height;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRepetitionCount() {
        return this.repetitionCount;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWidth() {
        return this.width;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int nextFrame(Bitmap bitmap) {
        return nextFrame(this.decoder, bitmap);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int nextFrameIndex() {
        return nextFrameIndex(this.decoder);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int nthFrame(int i, Bitmap bitmap) {
        return nthFrame(this.decoder, i, bitmap);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
