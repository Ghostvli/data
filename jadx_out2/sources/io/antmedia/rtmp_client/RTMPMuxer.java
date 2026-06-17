package io.antmedia.rtmp_client;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RTMPMuxer {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        System.loadLibrary("rtmp-jni");
    }

    public native int close();

    public native void file_close();

    public native void file_open(String str);

    public native boolean isConnected();

    public native int open(String str, int i, int i2);

    public native int read(byte[] bArr, int i, int i2);

    public native int writeAudio(byte[] bArr, int i, int i2, long j);

    public native int writeVideo(byte[] bArr, int i, int i2, long j);

    public native void write_flv_header(boolean z, boolean z2);
}
