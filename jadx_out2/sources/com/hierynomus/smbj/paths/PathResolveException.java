package com.hierynomus.smbj.paths;

import com.hierynomus.mserref.NtStatus;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PathResolveException extends Exception {
    private final long status;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PathResolveException(Throwable th) {
        super(th);
        this.status = NtStatus.STATUS_OTHER.getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtStatus getStatus() {
        return NtStatus.valueOf(this.status);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getStatusCode() {
        return this.status;
    }

    public PathResolveException(long j, String str) {
        super(str);
        this.status = j;
    }

    public PathResolveException(long j) {
        this.status = j;
    }
}
