package com.hierynomus.mssmb2.messages;

import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2GlobalCapability;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB3EncryptionCipher;
import com.hierynomus.mssmb2.SMB3HashAlgorithm;
import com.hierynomus.mssmb2.messages.negotiate.SMB2EncryptionCapabilities;
import com.hierynomus.mssmb2.messages.negotiate.SMB2NegotiateContext;
import com.hierynomus.mssmb2.messages.negotiate.SMB2PreauthIntegrityCapabilities;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2NegotiateRequest extends SMB2Packet {
    private Set<SMB2GlobalCapability> capabilities;
    private UUID clientGuid;
    private boolean clientSigningRequired;
    private Set<SMB2Dialect> dialects;
    private List<SMB2NegotiateContext> negotiateContextList;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2NegotiateRequest(Set<SMB2Dialect> set, UUID uuid, boolean z, Set<SMB2GlobalCapability> set2, byte[] bArr) {
        super(36, SMB2Dialect.UNKNOWN, SMB2MessageCommandCode.SMB2_NEGOTIATE, 0L, 0L);
        this.dialects = set;
        this.clientGuid = uuid;
        this.clientSigningRequired = z;
        this.capabilities = set2;
        this.negotiateContextList = buildNegotiateContextList(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<SMB2NegotiateContext> buildNegotiateContextList(byte[] bArr) {
        if (!this.dialects.contains(SMB2Dialect.SMB_3_1_1)) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SMB2PreauthIntegrityCapabilities(Arrays.asList(SMB3HashAlgorithm.SHA_512), bArr));
        if (this.capabilities.contains(SMB2GlobalCapability.SMB2_GLOBAL_CAP_ENCRYPTION)) {
            arrayList.add(new SMB2EncryptionCapabilities(Arrays.asList(SMB3EncryptionCipher.AES_128_GCM, SMB3EncryptionCipher.AES_128_CCM)));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void putCapabilities(SMBBuffer sMBBuffer) {
        if (SMB2Dialect.supportsSmb3x(this.dialects)) {
            sMBBuffer.putUInt32(EnumWithValue.EnumUtils.toLong(this.capabilities));
        } else {
            sMBBuffer.putReserved4();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void putDialects(SMBBuffer sMBBuffer) {
        Iterator<SMB2Dialect> it = this.dialects.iterator();
        while (it.hasNext()) {
            sMBBuffer.putUInt16(it.next().getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void putNegotiateContextList(SMBBuffer sMBBuffer) {
        int i;
        if (this.dialects.contains(SMB2Dialect.SMB_3_1_1)) {
            for (int i2 = 0; i2 < this.negotiateContextList.size(); i2++) {
                int iWrite = this.negotiateContextList.get(i2).write(sMBBuffer);
                if (i2 < this.negotiateContextList.size() - 1 && (i = iWrite % 8) != 0) {
                    sMBBuffer.putReserved(8 - i);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void putNegotiateContextOrStartTime(SMBBuffer sMBBuffer) {
        if (!this.dialects.contains(SMB2Dialect.SMB_3_1_1)) {
            sMBBuffer.putReserved(8);
            return;
        }
        sMBBuffer.putUInt32(this.structureSize + 64 + (this.dialects.size() * 2) + (8 - ((this.structureSize + (this.dialects.size() * 2)) % 8)));
        sMBBuffer.putUInt16(this.negotiateContextList.size());
        sMBBuffer.putReserved2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int securityMode() {
        return this.clientSigningRequired ? 2 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<SMB2NegotiateContext> getNegotiateContextList() {
        return this.negotiateContextList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void writeTo(SMBBuffer sMBBuffer) {
        sMBBuffer.putUInt16(this.structureSize);
        sMBBuffer.putUInt16(this.dialects.size());
        sMBBuffer.putUInt16(securityMode());
        sMBBuffer.putReserved(2);
        putCapabilities(sMBBuffer);
        MsDataTypes.putGuid(this.clientGuid, sMBBuffer);
        putNegotiateContextOrStartTime(sMBBuffer);
        putDialects(sMBBuffer);
        int size = (this.structureSize + (this.dialects.size() * 2)) % 8;
        if (size > 0) {
            sMBBuffer.putReserved(8 - size);
        }
        putNegotiateContextList(sMBBuffer);
    }
}
