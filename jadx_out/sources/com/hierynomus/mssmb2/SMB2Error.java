package com.hierynomus.mssmb2;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2Error {
    private List<SMB2ErrorData> errorData = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface SMB2ErrorData {
    }

    private void readErrorContext(SMB2PacketHeader sMB2PacketHeader, SMBBuffer sMBBuffer, int i) throws Buffer.BufferException {
        for (int i2 = 0; i2 < i; i2++) {
            sMBBuffer.readUInt32AsInt();
            sMBBuffer.skip(4);
            readErrorData(sMB2PacketHeader, sMBBuffer);
        }
    }

    private void readErrorData(SMB2PacketHeader sMB2PacketHeader, SMBBuffer sMBBuffer) {
        long statusCode = sMB2PacketHeader.getStatusCode();
        if (statusCode == NtStatus.STATUS_BUFFER_TOO_SMALL.getValue()) {
            this.errorData.add(new BufferTooSmallError().read(sMBBuffer));
        } else if (statusCode == NtStatus.STATUS_STOPPED_ON_SYMLINK.getValue()) {
            this.errorData.add(new SymbolicLinkError().read(sMBBuffer));
        }
    }

    public List<SMB2ErrorData> getErrorData() {
        return this.errorData;
    }

    public SMB2Error read(SMB2PacketHeader sMB2PacketHeader, SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        byte b = sMBBuffer.readByte();
        sMBBuffer.skip(1);
        int uInt32AsInt = sMBBuffer.readUInt32AsInt();
        if (b > 0) {
            readErrorContext(sMB2PacketHeader, sMBBuffer, b);
            return this;
        }
        if (uInt32AsInt > 0) {
            readErrorData(sMB2PacketHeader, sMBBuffer);
            return this;
        }
        if (uInt32AsInt == 0 && sMBBuffer.available() > 0) {
            sMBBuffer.skip(1);
        }
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class BufferTooSmallError implements SMB2ErrorData {
        private long requiredBufferLength;

        public long getRequiredBufferLength() {
            return this.requiredBufferLength;
        }

        public BufferTooSmallError read(SMBBuffer sMBBuffer) {
            this.requiredBufferLength = sMBBuffer.readUInt32();
            return this;
        }

        private BufferTooSmallError() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class SymbolicLinkError implements SMB2ErrorData {
        private boolean absolute;
        private String printName;
        private String substituteName;
        private int unparsedPathLength;

        /* JADX INFO: Access modifiers changed from: private */
        public SymbolicLinkError read(SMBBuffer sMBBuffer) throws Buffer.BufferException {
            int iRpos = sMBBuffer.rpos() + sMBBuffer.readUInt32AsInt();
            sMBBuffer.skip(4);
            sMBBuffer.skip(4);
            sMBBuffer.skip(2);
            this.unparsedPathLength = sMBBuffer.readUInt16();
            int uInt16 = sMBBuffer.readUInt16();
            int uInt162 = sMBBuffer.readUInt16();
            int uInt163 = sMBBuffer.readUInt16();
            int uInt164 = sMBBuffer.readUInt16();
            this.absolute = sMBBuffer.readUInt32() == 0;
            this.substituteName = readOffsettedString(sMBBuffer, uInt16, uInt162);
            this.printName = readOffsettedString(sMBBuffer, uInt163, uInt164);
            sMBBuffer.rpos(iRpos);
            return this;
        }

        private String readOffsettedString(SMBBuffer sMBBuffer, int i, int i2) {
            String string;
            int iRpos = sMBBuffer.rpos();
            if (i2 > 0) {
                sMBBuffer.rpos(i + iRpos);
                string = sMBBuffer.readString(Charsets.UTF_16, i2 / 2);
            } else {
                string = null;
            }
            sMBBuffer.rpos(iRpos);
            return string;
        }

        public String getPrintName() {
            return this.printName;
        }

        public String getSubstituteName() {
            return this.substituteName;
        }

        public int getUnparsedPathLength() {
            return this.unparsedPathLength;
        }

        public boolean isAbsolute() {
            return this.absolute;
        }

        private SymbolicLinkError() {
        }
    }
}
