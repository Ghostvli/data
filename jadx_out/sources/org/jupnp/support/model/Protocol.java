package org.jupnp.support.model;

import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum Protocol {
    ALL("*"),
    HTTP_GET("http-get"),
    RTSP_RTP_UDP("rtsp-rtp-udp"),
    INTERNAL("internal"),
    IEC61883("iec61883"),
    XBMC_GET("xbmc-get"),
    OTHER("other");

    private static final j02 LOGGER = n02.k(Protocol.class);
    private final String protocolString;

    Protocol(String str) {
        this.protocolString = str;
    }

    public static Protocol value(String str) {
        for (Protocol protocol : values()) {
            if (protocol.toString().equals(str)) {
                return protocol;
            }
        }
        LOGGER.c("Unsupported OTHER protocol string: {}", str);
        return OTHER;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocolString;
    }
}
