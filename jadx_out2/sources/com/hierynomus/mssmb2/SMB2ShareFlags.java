package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB2ShareFlags implements EnumWithValue<SMB2ShareFlags> {
    SMB2_SHAREFLAG_MANUAL_CACHING(0),
    SMB2_SHAREFLAG_AUTO_CACHING(16),
    SMB2_SHAREFLAG_VDO_CACHING(32),
    SMB2_SHAREFLAG_NO_CACHING(48),
    SMB2_SHAREFLAG_DFS(1),
    SMB2_SHAREFLAG_DFS_ROOT(2),
    SMB2_SHAREFLAG_RESTRICT_EXCLUSIVE_OPENS(256),
    SMB2_SHAREFLAG_FORCE_SHARED_DELETE(512),
    SMB2_SHAREFLAG_ALLOW_NAMESPACE_CACHING(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE),
    SMB2_SHAREFLAG_ACCESS_BASED_DIRECTORY_ENUM(2048),
    SMB2_SHAREFLAG_FORCE_LEVELII_OPLOCK(4096),
    SMB2_SHAREFLAG_ENABLE_HASH_V1(8192),
    SMB2_SHAREFLAG_ENABLE_HASH_V2(Http2Stream.EMIT_BUFFER_SIZE),
    SMB2_SHAREFLAG_ENCRYPT_DATA(32768),
    SMB2_SHAREFLAG_IDENTITY_REMOTING(262144);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    SMB2ShareFlags(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}
