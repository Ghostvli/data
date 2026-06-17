package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.concurrent.AFuture;
import com.hierynomus.protocol.commons.concurrent.CancellableFuture;
import com.hierynomus.protocol.commons.concurrent.Promise;
import com.hierynomus.smb.SMBPacket;
import com.hierynomus.smbj.common.SMBRuntimeException;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Request {
    private long asyncId;
    private final UUID cancelId;
    private final long messageId;
    private SMBPacket<?, ?> packet;
    private final Promise<SMB2Packet, SMBRuntimeException> promise;
    private final Date timestamp = new Date();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Request(SMBPacket<?, ?> sMBPacket, long j, UUID uuid) {
        this.packet = sMBPacket;
        this.messageId = j;
        this.cancelId = uuid;
        this.promise = new Promise<>(String.valueOf(j), SMBRuntimeException.Wrapper);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getAsyncId() {
        return this.asyncId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UUID getCancelId() {
        return this.cancelId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <T extends SMB2Packet> AFuture<T> getFuture(CancellableFuture.CancelCallback cancelCallback) {
        return new CancellableFuture(this.promise.future(), cancelCallback);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getMessageId() {
        return this.messageId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMBPacket<?, ?> getPacket() {
        return this.packet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Promise<SMB2Packet, SMBRuntimeException> getPromise() {
        return this.promise;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Date getTimestamp() {
        return this.timestamp;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAsyncId(long j) {
        this.asyncId = j;
    }
}
