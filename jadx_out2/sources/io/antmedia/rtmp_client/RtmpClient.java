package io.antmedia.rtmp_client;

import com.hierynomus.msdtyp.FileTime;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RtmpClient {
    public long a = 0;
    public int b = FileTime.NANO100_TO_MILLI;
    public int c = FileTime.NANO100_TO_MILLI;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends IOException {
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i) {
            super("RTMP error: " + i);
            this.f = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        System.loadLibrary("rtmp-jni");
    }

    private native long nativeAlloc();

    private native void nativeClose(long j);

    private native boolean nativeIsConnected(long j);

    private native int nativeOpen(String str, boolean z, long j, int i, int i2);

    private native int nativePause(boolean z, long j);

    private native int nativeRead(byte[] bArr, int i, int i2, long j);

    private native int nativeWrite(byte[] bArr, int i, int i2, long j);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a() {
        nativeClose(this.a);
        this.a = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(String str, boolean z) throws a {
        long jNativeAlloc = nativeAlloc();
        this.a = jNativeAlloc;
        if (jNativeAlloc == 0) {
            throw new a(-2);
        }
        int iNativeOpen = nativeOpen(str, z, jNativeAlloc, this.b, this.c);
        if (iNativeOpen == 0) {
            return;
        }
        this.a = 0L;
        throw new a(iNativeOpen);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(byte[] bArr, int i, int i2) throws a {
        int iNativeRead = nativeRead(bArr, i, i2, this.a);
        if (iNativeRead >= 0 || iNativeRead == -1) {
            return iNativeRead;
        }
        throw new a(iNativeRead);
    }
}
