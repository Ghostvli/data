package com.hierynomus.ntlm.messages;

import com.hierynomus.protocol.Packet;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmPacket implements Packet<Buffer.PlainBuffer> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: read(Lcom/hierynomus/protocol/commons/buffer/Buffer;)V */
    @Override // com.hierynomus.protocol.Packet
    public void read(Buffer.PlainBuffer plainBuffer) {
        throw new UnsupportedOperationException("Not implemented by base class");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: write(Lcom/hierynomus/protocol/commons/buffer/Buffer;)V */
    @Override // com.hierynomus.protocol.Packet
    public void write(Buffer.PlainBuffer plainBuffer) {
        throw new UnsupportedOperationException("Not implemented by base class");
    }
}
