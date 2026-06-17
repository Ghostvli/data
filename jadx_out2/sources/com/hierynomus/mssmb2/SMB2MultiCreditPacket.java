package com.hierynomus.mssmb2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2MultiCreditPacket extends SMB2Packet {
    private int maxPayloadSize;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2MultiCreditPacket(int i, SMB2Dialect sMB2Dialect, SMB2MessageCommandCode sMB2MessageCommandCode, long j, long j2, int i2) {
        super(i, sMB2Dialect, sMB2MessageCommandCode, j, j2);
        this.maxPayloadSize = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public int getMaxPayloadSize() {
        return this.maxPayloadSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPayloadSize() {
        return Math.min(this.maxPayloadSize, getCreditsAssigned() * 65536);
    }
}
