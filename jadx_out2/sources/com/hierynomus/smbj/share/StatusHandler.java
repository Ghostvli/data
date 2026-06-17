package com.hierynomus.smbj.share;

import com.hierynomus.mserref.NtStatus;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface StatusHandler {
    public static final StatusHandler SUCCESS = new StatusHandler() { // from class: com.hierynomus.smbj.share.StatusHandler.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_SUCCESS.getValue();
        }
    };

    boolean isSuccess(long j);
}
