package org.jupnp.support.model.dlna;

import com.hierynomus.protocol.commons.buffer.Buffer;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum DLNAFlags {
    SENDER_PACED(Integer.MIN_VALUE),
    TIME_BASED_SEEK(Buffer.MAX_SIZE),
    BYTE_BASED_SEEK(536870912),
    FLAG_PLAY_CONTAINER(268435456),
    S0_INCREASE(134217728),
    SN_INCREASE(67108864),
    RTSP_PAUSE(33554432),
    STREAMING_TRANSFER_MODE(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE),
    INTERACTIVE_TRANSFERT_MODE(8388608),
    BACKGROUND_TRANSFERT_MODE(4194304),
    CONNECTION_STALL(2097152),
    DLNA_V15(1048576);

    private final int code;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    DLNAFlags(int i) {
        this.code = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DLNAFlags valueOf(int i) {
        for (DLNAFlags dLNAFlags : values()) {
            if (dLNAFlags.getCode() == i) {
                return dLNAFlags;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCode() {
        return this.code;
    }
}
