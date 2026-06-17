package com.hierynomus.mssmb2.messages;

import com.hierynomus.msfscc.FileInformationClass;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2MultiCreditPacket;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2QueryDirectoryRequest extends SMB2MultiCreditPacket {
    private final SMB2FileId fileId;
    private final long fileIndex;
    private FileInformationClass fileInformationClass;
    private final Set<SMB2QueryDirectoryFlags> flags;
    private final String searchPattern;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SMB2QueryDirectoryFlags implements EnumWithValue<SMB2QueryDirectoryFlags> {
        SMB2_RESTART_SCANS(1),
        SMB2_RETURN_SINGLE_ENTRY(2),
        SMB2_INDEX_SPECIFIED(4),
        SMB2_REOPEN(16);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        SMB2QueryDirectoryFlags(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2QueryDirectoryRequest(SMB2Dialect sMB2Dialect, long j, long j2, SMB2FileId sMB2FileId, FileInformationClass fileInformationClass, Set<SMB2QueryDirectoryFlags> set, long j3, String str, int i) {
        super(33, sMB2Dialect, SMB2MessageCommandCode.SMB2_QUERY_DIRECTORY, j, j2, i);
        this.fileInformationClass = fileInformationClass;
        this.flags = set;
        this.fileIndex = j3;
        this.fileId = sMB2FileId;
        this.searchPattern = str == null ? "*" : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putByte((byte) this.fileInformationClass.getValue());
        sMBBuffer.putByte((byte) EnumWithValue.EnumUtils.toLong(this.flags));
        sMBBuffer.putUInt32(this.fileIndex);
        this.fileId.write(sMBBuffer);
        sMBBuffer.putUInt16(96);
        sMBBuffer.putUInt16(this.searchPattern.length() * 2);
        sMBBuffer.putUInt32(Math.min(getMaxPayloadSize(), getCreditsAssigned() * 65536));
        sMBBuffer.putString(this.searchPattern);
    }
}
