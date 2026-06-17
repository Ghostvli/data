package com.hierynomus.mssmb2;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.smbj.common.SMBRuntimeException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBApiException extends SMBRuntimeException {
    private final SMB2MessageCommandCode failedCommand;
    private long statusCode;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMBApiException(SMB2PacketHeader sMB2PacketHeader, String str) {
        super(str);
        this.statusCode = sMB2PacketHeader.getStatusCode();
        this.failedCommand = sMB2PacketHeader.getMessage();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2MessageCommandCode getFailedCommand() {
        return this.failedCommand;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format("%s (0x%08x): %s", getStatus().name(), Long.valueOf(this.statusCode), super.getMessage());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtStatus getStatus() {
        return NtStatus.valueOf(this.statusCode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getStatusCode() {
        return this.statusCode;
    }

    public SMBApiException(long j, SMB2MessageCommandCode sMB2MessageCommandCode, String str, Throwable th) {
        super(str, th);
        this.statusCode = j;
        this.failedCommand = sMB2MessageCommandCode;
    }

    public SMBApiException(long j, SMB2MessageCommandCode sMB2MessageCommandCode, Throwable th) {
        super(th);
        this.statusCode = j;
        this.failedCommand = sMB2MessageCommandCode;
    }

    public SMBApiException(SMB2PacketHeader sMB2PacketHeader, String str, Throwable th) {
        super(str, th);
        this.statusCode = sMB2PacketHeader.getStatusCode();
        this.failedCommand = sMB2PacketHeader.getMessage();
    }
}
