package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.SecurityInformation;
import com.hierynomus.msfscc.FileInformationClass;
import com.hierynomus.msfscc.FileSystemInformationClass;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import defpackage.d;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2QueryInfoRequest extends SMB2Packet {
    private static final long MAX_OUTPUT_BUFFER_LENGTH = 65536;
    private final SMB2FileId fileId;
    private final FileInformationClass fileInformationClass;
    private final FileSystemInformationClass fileSystemInformationClass;
    private final SMB2QueryInfoType infoType;
    private final byte[] inputBuffer;
    private final Set<SecurityInformation> securityInformation;

    /* JADX INFO: renamed from: com.hierynomus.mssmb2.messages.SMB2QueryInfoRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$mssmb2$messages$SMB2QueryInfoRequest$SMB2QueryInfoType;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[SMB2QueryInfoType.values().length];
            $SwitchMap$com$hierynomus$mssmb2$messages$SMB2QueryInfoRequest$SMB2QueryInfoType = iArr;
            try {
                iArr[SMB2QueryInfoType.SMB2_0_INFO_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$messages$SMB2QueryInfoRequest$SMB2QueryInfoType[SMB2QueryInfoType.SMB2_0_INFO_FILESYSTEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$messages$SMB2QueryInfoRequest$SMB2QueryInfoType[SMB2QueryInfoType.SMB2_0_INFO_SECURITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$messages$SMB2QueryInfoRequest$SMB2QueryInfoType[SMB2QueryInfoType.SMB2_0_INFO_QUOTA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SMB2QueryInfoType implements EnumWithValue<SMB2QueryInfoType> {
        SMB2_0_INFO_FILE(1),
        SMB2_0_INFO_FILESYSTEM(2),
        SMB2_0_INFO_SECURITY(3),
        SMB2_0_INFO_QUOTA(4);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        SMB2QueryInfoType(long j) {
            this.value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2QueryInfoRequest(SMB2Dialect sMB2Dialect, long j, long j2, SMB2FileId sMB2FileId, SMB2QueryInfoType sMB2QueryInfoType, FileInformationClass fileInformationClass, FileSystemInformationClass fileSystemInformationClass, byte[] bArr, Set<SecurityInformation> set) {
        super(41, sMB2Dialect, SMB2MessageCommandCode.SMB2_QUERY_INFO, j, j2);
        this.infoType = sMB2QueryInfoType;
        this.fileInformationClass = fileInformationClass;
        this.fileSystemInformationClass = fileSystemInformationClass;
        this.inputBuffer = bArr;
        this.securityInformation = set;
        this.fileId = sMB2FileId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putByte((byte) this.infoType.getValue());
        int i = AnonymousClass1.$SwitchMap$com$hierynomus$mssmb2$messages$SMB2QueryInfoRequest$SMB2QueryInfoType[this.infoType.ordinal()];
        char c = 'h';
        if (i != 1) {
            if (i == 2) {
                sMBBuffer.putByte((byte) this.fileSystemInformationClass.getValue());
                sMBBuffer.putUInt32(MAX_OUTPUT_BUFFER_LENGTH);
                sMBBuffer.putUInt16(0);
                sMBBuffer.putReserved2();
                sMBBuffer.putUInt32(0L);
                sMBBuffer.putUInt32(0L);
                sMBBuffer.putUInt32(0L);
                this.fileId.write(sMBBuffer);
            } else if (i == 3) {
                sMBBuffer.putByte((byte) 0);
                sMBBuffer.putUInt32(MAX_OUTPUT_BUFFER_LENGTH);
                sMBBuffer.putUInt16(0);
                sMBBuffer.putReserved2();
                sMBBuffer.putUInt32(0L);
                sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.securityInformation));
                sMBBuffer.putUInt32(0L);
                this.fileId.write(sMBBuffer);
            } else {
                if (i != 4) {
                    d.a("Unknown SMB2QueryInfoType: ", this.infoType);
                    return;
                }
                sMBBuffer.putByte((byte) 0);
                sMBBuffer.putUInt32(MAX_OUTPUT_BUFFER_LENGTH);
                sMBBuffer.putUInt16(0);
                sMBBuffer.putReserved2();
                sMBBuffer.putUInt32(this.inputBuffer.length);
                sMBBuffer.putUInt32(0L);
                sMBBuffer.putUInt32(0L);
                this.fileId.write(sMBBuffer);
            }
            c = 0;
        } else {
            sMBBuffer.putByte((byte) this.fileInformationClass.getValue());
            sMBBuffer.putUInt32(MAX_OUTPUT_BUFFER_LENGTH);
            if (this.fileInformationClass == FileInformationClass.FileFullEaInformation) {
                sMBBuffer.putUInt16(0);
                sMBBuffer.putReserved2();
                sMBBuffer.putUInt32(this.inputBuffer.length);
            } else {
                sMBBuffer.putUInt16(0);
                sMBBuffer.putReserved2();
                sMBBuffer.putUInt32(0L);
                c = 0;
            }
            sMBBuffer.putUInt32(0L);
            sMBBuffer.putUInt32(0L);
            this.fileId.write(sMBBuffer);
        }
        if (c > 0) {
            sMBBuffer.putRawBytes(this.inputBuffer);
        }
    }
}
