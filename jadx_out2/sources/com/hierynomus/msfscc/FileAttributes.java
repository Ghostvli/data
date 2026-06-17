package com.hierynomus.msfscc;

import com.hierynomus.protocol.commons.EnumWithValue;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum FileAttributes implements EnumWithValue<FileAttributes> {
    FILE_ATTRIBUTE_ARCHIVE(32),
    FILE_ATTRIBUTE_COMPRESSED(2048),
    FILE_ATTRIBUTE_DIRECTORY(16),
    FILE_ATTRIBUTE_ENCRYPTED(Http2Stream.EMIT_BUFFER_SIZE),
    FILE_ATTRIBUTE_HIDDEN(2),
    FILE_ATTRIBUTE_NORMAL(128),
    FILE_ATTRIBUTE_NOT_CONTENT_INDEXED(8192),
    FILE_ATTRIBUTE_OFFLINE(4096),
    FILE_ATTRIBUTE_READONLY(1),
    FILE_ATTRIBUTE_REPARSE_POINT(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE),
    FILE_ATTRIBUTE_SPARSE_FILE(512),
    FILE_ATTRIBUTE_SYSTEM(4),
    FILE_ATTRIBUTE_TEMPORARY(256),
    FILE_ATTRIBUTE_INTEGRITY_STREAM(32768),
    FILE_ATTRIBUTE_NO_SCRUB_DATA(131072);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    FileAttributes(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}
