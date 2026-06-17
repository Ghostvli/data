package com.hierynomus.msfscc.fsctl;

import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FsCtlPipeWaitRequest {
    private String name;
    private long timeout;
    private boolean timeoutSpecified;
    private final TimeUnit timeoutUnit;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FsCtlPipeWaitRequest(String str, long j, TimeUnit timeUnit, boolean z) {
        this.name = str;
        this.timeout = j;
        this.timeoutUnit = timeUnit;
        this.timeoutSpecified = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTimeout() {
        return this.timeout;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TimeUnit getTimeoutUnit() {
        return this.timeoutUnit;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void write(Buffer<?> buffer) {
        buffer.putUInt64(this.timeoutSpecified ? this.timeoutUnit.toMillis(this.timeout) / 100 : 0L);
        int iWpos = buffer.wpos();
        buffer.putUInt32(0L);
        buffer.putBoolean(this.timeoutSpecified);
        buffer.putByte((byte) 0);
        long jWpos = buffer.wpos();
        buffer.putString(this.name, Charsets.UTF_16);
        int iWpos2 = buffer.wpos();
        buffer.wpos(iWpos);
        buffer.putUInt32(((long) iWpos2) - jWpos);
        buffer.wpos(iWpos2);
    }
}
