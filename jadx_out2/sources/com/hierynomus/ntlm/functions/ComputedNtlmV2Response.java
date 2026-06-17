package com.hierynomus.ntlm.functions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ComputedNtlmV2Response {
    private byte[] lmResponse;
    private byte[] ntResponse;
    private byte[] sessionBaseKey;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ComputedNtlmV2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.ntResponse = bArr;
        this.lmResponse = bArr2;
        this.sessionBaseKey = bArr3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getLmResponse() {
        return this.lmResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getNtResponse() {
        return this.ntResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getSessionBaseKey() {
        return this.sessionBaseKey;
    }
}
