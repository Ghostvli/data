package com.hierynomus.mssmb2.messages.negotiate;

import com.hierynomus.mssmb2.SMB3EncryptionCipher;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import defpackage.e04;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2EncryptionCapabilities extends SMB2NegotiateContext {
    private List<SMB3EncryptionCipher> cipherList;

    public SMB2EncryptionCapabilities() {
        super(SMB2NegotiateContextType.SMB2_ENCRYPTION_CAPABILITIES);
        this.cipherList = new ArrayList();
    }

    public List<SMB3EncryptionCipher> getCipherList() {
        return this.cipherList;
    }

    @Override // com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext
    public void readContext(SMBBuffer sMBBuffer, int i) {
        int uInt16 = sMBBuffer.readUInt16();
        for (int i2 = 0; i2 < uInt16; i2++) {
            this.cipherList.add((SMB3EncryptionCipher) EnumWithValue.EnumUtils.valueOf(sMBBuffer.readUInt16(), SMB3EncryptionCipher.class, null));
        }
    }

    @Override // com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext
    public int writeContext(SMBBuffer sMBBuffer) {
        List<SMB3EncryptionCipher> list = this.cipherList;
        if (list == null || list.isEmpty()) {
            e04.a("Cannot serialize an empty or null cipherList");
            return 0;
        }
        sMBBuffer.putUInt16(this.cipherList.size());
        Iterator<SMB3EncryptionCipher> it = this.cipherList.iterator();
        while (it.hasNext()) {
            sMBBuffer.putUInt16((int) it.next().getValue());
        }
        return (this.cipherList.size() * 2) + 2;
    }

    public SMB2EncryptionCapabilities(List<SMB3EncryptionCipher> list) {
        super(SMB2NegotiateContextType.SMB2_ENCRYPTION_CAPABILITIES);
        this.cipherList = list;
    }
}
