package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB2CompletionFilter implements EnumWithValue<SMB2CompletionFilter> {
    FILE_NOTIFY_CHANGE_FILE_NAME(1),
    FILE_NOTIFY_CHANGE_DIR_NAME(2),
    FILE_NOTIFY_CHANGE_ATTRIBUTES(4),
    FILE_NOTIFY_CHANGE_SIZE(8),
    FILE_NOTIFY_CHANGE_LAST_WRITE(16),
    FILE_NOTIFY_CHANGE_LAST_ACCESS(32),
    FILE_NOTIFY_CHANGE_CREATION(64),
    FILE_NOTIFY_CHANGE_EA(128),
    FILE_NOTIFY_CHANGE_SECURITY(256),
    FILE_NOTIFY_CHANGE_STREAM_NAME(512),
    FILE_NOTIFY_CHANGE_STREAM_SIZE(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE),
    FILE_NOTIFY_CHANGE_STREAM_WRITE(2048);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    SMB2CompletionFilter(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}
