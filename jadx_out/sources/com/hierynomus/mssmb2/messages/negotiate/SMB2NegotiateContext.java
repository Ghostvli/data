package com.hierynomus.mssmb2.messages.negotiate;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SMBRuntimeException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SMB2NegotiateContext {
    private SMB2NegotiateContextType negotiateContextType;

    /* JADX INFO: renamed from: com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$mssmb2$messages$negotiate$SMB2NegotiateContextType;

        static {
            int[] iArr = new int[SMB2NegotiateContextType.values().length];
            $SwitchMap$com$hierynomus$mssmb2$messages$negotiate$SMB2NegotiateContextType = iArr;
            try {
                iArr[SMB2NegotiateContextType.SMB2_PREAUTH_INTEGRITY_CAPABILITIES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$messages$negotiate$SMB2NegotiateContextType[SMB2NegotiateContextType.SMB2_ENCRYPTION_CAPABILITIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$messages$negotiate$SMB2NegotiateContextType[SMB2NegotiateContextType.SMB2_COMPRESSION_CAPABILITIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$messages$negotiate$SMB2NegotiateContextType[SMB2NegotiateContextType.SMB2_NETNAME_NEGOTIATE_CONTEXT_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SMB2NegotiateContext(SMB2NegotiateContextType sMB2NegotiateContextType) {
        this.negotiateContextType = sMB2NegotiateContextType;
    }

    public static SMB2NegotiateContext factory(SMBBuffer sMBBuffer) {
        int uInt16 = sMBBuffer.readUInt16();
        SMB2NegotiateContextType sMB2NegotiateContextType = (SMB2NegotiateContextType) EnumWithValue.EnumUtils.valueOf(uInt16, SMB2NegotiateContextType.class, null);
        int i = AnonymousClass1.$SwitchMap$com$hierynomus$mssmb2$messages$negotiate$SMB2NegotiateContextType[sMB2NegotiateContextType.ordinal()];
        if (i == 1) {
            return new SMB2PreauthIntegrityCapabilities().read(sMBBuffer);
        }
        if (i == 2) {
            return new SMB2EncryptionCapabilities().read(sMBBuffer);
        }
        if (i == 3) {
            return new SMB2CompressionCapabilities().read(sMBBuffer);
        }
        if (i == 4) {
            return new SMB2NetNameNegotiateContextId().read(sMBBuffer);
        }
        throw new SMBRuntimeException("Unknown SMB2NegotiateContextType encountered: " + uInt16 + " / " + sMB2NegotiateContextType);
    }

    private int readContextHeader(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        int uInt16 = sMBBuffer.readUInt16();
        sMBBuffer.skip(4);
        return uInt16;
    }

    private void writeContextHeader(SMBBuffer sMBBuffer, int i) {
        sMBBuffer.putUInt16((int) this.negotiateContextType.getValue());
        sMBBuffer.putUInt16(i);
        sMBBuffer.putReserved4();
    }

    public SMB2NegotiateContextType getNegotiateContextType() {
        return this.negotiateContextType;
    }

    public final SMB2NegotiateContext read(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        int contextHeader = readContextHeader(sMBBuffer);
        readContext(sMBBuffer, contextHeader);
        int i = contextHeader % 8;
        int i2 = i == 0 ? 0 : 8 - i;
        if (i2 > 0 && sMBBuffer.available() >= i2) {
            sMBBuffer.skip(i2);
        }
        return this;
    }

    public void readContext(SMBBuffer sMBBuffer, int i) {
        throw new UnsupportedOperationException("Should be implemented by specific message type");
    }

    public final int write(SMBBuffer sMBBuffer) {
        SMBBuffer sMBBuffer2 = new SMBBuffer();
        int iWriteContext = writeContext(sMBBuffer2);
        writeContextHeader(sMBBuffer, iWriteContext);
        sMBBuffer.putBuffer(sMBBuffer2);
        return iWriteContext + 8;
    }

    public int writeContext(SMBBuffer sMBBuffer) {
        throw new UnsupportedOperationException("Should be implemented by specific SMB2NegotiateContext");
    }
}
