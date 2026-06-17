package com.hierynomus.ntlm.functions;

import com.hierynomus.ntlm.messages.NtlmChallenge;
import com.hierynomus.ntlm.messages.TargetInfo;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import com.hierynomus.security.SecurityProvider;
import defpackage.qa;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmV2Functions {
    private Random random;
    private SecurityProvider securityProvider;

    public NtlmV2Functions(Random random, SecurityProvider securityProvider) {
        this.random = random;
        this.securityProvider = securityProvider;
    }

    public byte[] LMOWFv2(String str, String str2, String str3) {
        return NTOWFv2(str, str2, str3);
    }

    public byte[] NTOWFv2(String str, String str2, String str3) {
        return NtlmFunctions.hmac_md5(this.securityProvider, NtlmFunctions.md4(this.securityProvider, NtlmFunctions.unicode(str)), NtlmFunctions.unicode(str2.toUpperCase()), NtlmFunctions.unicode(str3));
    }

    public ComputedNtlmV2Response computeResponse(String str, String str2, char[] cArr, NtlmChallenge ntlmChallenge, long j, TargetInfo targetInfo) {
        byte[] bArr = new byte[8];
        this.random.nextBytes(bArr);
        byte[] bArrNTOWFv2 = NTOWFv2(String.valueOf(cArr), str, str2);
        byte[] lmV2Response = getLmV2Response(LMOWFv2(String.valueOf(cArr), str, str2), ntlmChallenge.getServerChallenge(), bArr);
        byte[] ntV2Response = getNtV2Response(bArrNTOWFv2, ntlmChallenge.getServerChallenge(), bArr, j, targetInfo);
        return new ComputedNtlmV2Response(ntV2Response, lmV2Response, getSessionBaseKey(bArrNTOWFv2, qa.d(ntV2Response, 0, 16)));
    }

    public byte[] getLmV2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Buffer.PlainBuffer plainBuffer = new Buffer.PlainBuffer(Endian.LE);
        plainBuffer.putRawBytes(NtlmFunctions.hmac_md5(this.securityProvider, bArr, bArr2, bArr3));
        plainBuffer.putRawBytes(bArr3);
        return plainBuffer.getCompactData();
    }

    public byte[] getNtV2Response(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, TargetInfo targetInfo) {
        byte[] bArrNtResponseTemp = ntResponseTemp(bArr3, j, targetInfo);
        byte[] bArrNtProofStr = ntProofStr(bArr, bArr2, bArrNtResponseTemp);
        byte[] bArr4 = new byte[bArrNtProofStr.length + bArrNtResponseTemp.length];
        System.arraycopy(bArrNtProofStr, 0, bArr4, 0, bArrNtProofStr.length);
        System.arraycopy(bArrNtResponseTemp, 0, bArr4, bArrNtProofStr.length, bArrNtResponseTemp.length);
        return bArr4;
    }

    public byte[] getSessionBaseKey(byte[] bArr, byte[] bArr2) {
        return NtlmFunctions.hmac_md5(this.securityProvider, bArr, bArr2);
    }

    public byte[] kxKey(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return bArr;
    }

    public byte[] ntProofStr(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return NtlmFunctions.hmac_md5(this.securityProvider, bArr, bArr2, bArr3);
    }

    public byte[] ntResponseTemp(byte[] bArr, long j, TargetInfo targetInfo) {
        Buffer.PlainBuffer plainBuffer = new Buffer.PlainBuffer(Endian.LE);
        plainBuffer.putByte((byte) 1);
        plainBuffer.putByte((byte) 1);
        plainBuffer.putUInt16(0);
        plainBuffer.putUInt32(0L);
        plainBuffer.putLong(j);
        plainBuffer.putRawBytes(bArr);
        plainBuffer.putUInt32(0L);
        if (targetInfo != null) {
            targetInfo.writeTo(plainBuffer);
        }
        plainBuffer.putUInt32(0L);
        return plainBuffer.getCompactData();
    }
}
