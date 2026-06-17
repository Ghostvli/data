package com.hierynomus.mssmb2;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smb.SMBHeader;
import com.hierynomus.smbj.common.Check;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2CompressionTransformHeader implements SMBHeader {
    private static final byte[] COMPRESSED_PROTOCOL_ID = {-4, 83, 77, 66};
    private SMB3CompressionAlgorithm compressionAlgorithm;
    private int headerStartPosition;
    private int messageEndPosition;
    private int offset;
    private int originalCompressedSegmentSize;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isCompressed(byte[] bArr) {
        return Arrays.equals(COMPRESSED_PROTOCOL_ID, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB3CompressionAlgorithm getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public int getHeaderStartPosition() {
        return this.headerStartPosition;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public int getMessageEndPosition() {
        return this.messageEndPosition;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getOffset() {
        return this.offset;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getOriginalCompressedSegmentSize() {
        return this.originalCompressedSegmentSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public void readFrom(Buffer<?> buffer) throws Buffer.BufferException {
        this.headerStartPosition = buffer.rpos();
        Check.ensureEquals(buffer.readRawBytes(4), COMPRESSED_PROTOCOL_ID, "Could not find SMB2 Packet header");
        this.originalCompressedSegmentSize = buffer.readUInt32AsInt();
        SMB3CompressionAlgorithm sMB3CompressionAlgorithm = (SMB3CompressionAlgorithm) EnumWithValue.EnumUtils.valueOf(buffer.readUInt16(), SMB3CompressionAlgorithm.class, null);
        this.compressionAlgorithm = sMB3CompressionAlgorithm;
        Check.ensure((sMB3CompressionAlgorithm == null || sMB3CompressionAlgorithm == SMB3CompressionAlgorithm.NONE) ? false : true, "The CompressionAlgorithm field of the SMB2_COMPRESSION_TRANSFORM_HEADER should contain a valid value.");
        buffer.skip(2);
        this.offset = buffer.readUInt32AsInt();
        this.messageEndPosition = buffer.wpos();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smb.SMBHeader
    public void writeTo(SMBBuffer sMBBuffer) {
    }
}
