package com.hierynomus.mssmb2.messages.negotiate;

import com.hierynomus.mssmb2.SMB3HashAlgorithm;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import defpackage.e04;
import defpackage.r14;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2PreauthIntegrityCapabilities extends SMB2NegotiateContext {
    public static final int DEFAULT_SALT_LENGTH = 32;
    private List<SMB3HashAlgorithm> hashAlgorithms;
    private byte[] salt;

    public SMB2PreauthIntegrityCapabilities(List<SMB3HashAlgorithm> list, byte[] bArr) {
        super(SMB2NegotiateContextType.SMB2_PREAUTH_INTEGRITY_CAPABILITIES);
        this.hashAlgorithms = list;
        this.salt = (byte[]) bArr.clone();
    }

    public List<SMB3HashAlgorithm> getHashAlgorithms() {
        return this.hashAlgorithms;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    @Override // com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext
    public void readContext(SMBBuffer sMBBuffer, int i) {
        int uInt16 = sMBBuffer.readUInt16();
        int uInt162 = sMBBuffer.readUInt16();
        for (int i2 = 0; i2 < uInt16; i2++) {
            int uInt163 = sMBBuffer.readUInt16();
            SMB3HashAlgorithm sMB3HashAlgorithm = (SMB3HashAlgorithm) EnumWithValue.EnumUtils.valueOf(uInt163, SMB3HashAlgorithm.class, null);
            if (sMB3HashAlgorithm == null) {
                r14.a("Unknown SMB3HashAlgorithm with value '%d'", new Object[]{Integer.valueOf(uInt163)});
                return;
            }
            this.hashAlgorithms.add(sMB3HashAlgorithm);
        }
        this.salt = sMBBuffer.readRawBytes(uInt162);
    }

    @Override // com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext
    public int writeContext(SMBBuffer sMBBuffer) {
        List<SMB3HashAlgorithm> list = this.hashAlgorithms;
        if (list == null) {
            e04.a("There should be at least 1 hash algorithm provided");
            return 0;
        }
        if (this.salt == null) {
            e04.a("A salt should be provided");
            return 0;
        }
        sMBBuffer.putUInt16(list.size());
        sMBBuffer.putUInt16(this.salt.length);
        Iterator<SMB3HashAlgorithm> it = this.hashAlgorithms.iterator();
        while (it.hasNext()) {
            sMBBuffer.putUInt16((int) it.next().getValue());
        }
        sMBBuffer.putRawBytes(this.salt);
        return (this.hashAlgorithms.size() * 2) + 4 + this.salt.length;
    }

    public SMB2PreauthIntegrityCapabilities() {
        super(SMB2NegotiateContextType.SMB2_PREAUTH_INTEGRITY_CAPABILITIES);
        this.hashAlgorithms = new ArrayList();
    }
}
