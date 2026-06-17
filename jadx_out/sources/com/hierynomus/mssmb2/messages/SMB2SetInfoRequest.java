package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.SecurityInformation;
import com.hierynomus.msfscc.FileInformationClass;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2SetInfoRequest extends SMB2Packet {
    private final byte[] buffer;
    private final SMB2FileId fileId;
    private final FileInformationClass fileInfoClass;
    private final SMB2InfoType infoType;
    private final Set<SecurityInformation> securityInformation;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SMB2InfoType implements EnumWithValue<SMB2InfoType> {
        SMB2_0_INFO_FILE(1),
        SMB2_0_INFO_FILESYSTEM(2),
        SMB2_0_INFO_SECURITY(3),
        SMB2_0_INFO_QUOTA(4);

        private long value;

        SMB2InfoType(long j) {
            this.value = j;
        }

        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    public SMB2SetInfoRequest(SMB2Dialect sMB2Dialect, long j, long j2, SMB2InfoType sMB2InfoType, SMB2FileId sMB2FileId, FileInformationClass fileInformationClass, Set<SecurityInformation> set, byte[] bArr) {
        super(33, sMB2Dialect, SMB2MessageCommandCode.SMB2_SET_INFO, j, j2);
        this.fileId = sMB2FileId;
        this.infoType = sMB2InfoType;
        this.fileInfoClass = fileInformationClass;
        this.buffer = bArr == null ? new byte[0] : bArr;
        this.securityInformation = set;
    }

    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putByte((byte) this.infoType.getValue());
        sMBBuffer.putByte(this.fileInfoClass == null ? (byte) 0 : (byte) r0.getValue());
        sMBBuffer.putUInt32(this.buffer.length);
        sMBBuffer.putUInt16(96);
        sMBBuffer.putReserved2();
        Set<SecurityInformation> set = this.securityInformation;
        sMBBuffer.putUInt32(set == null ? 0L : EnumWithValue.EnumUtils.toLong(set));
        this.fileId.write(sMBBuffer);
        sMBBuffer.putRawBytes(this.buffer);
    }
}
