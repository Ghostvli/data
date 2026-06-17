package com.hierynomus.protocol.transport;

import com.hierynomus.protocol.PacketData;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface PacketFactory<D extends PacketData<?>> {
    boolean canHandle(byte[] bArr);

    D read(byte[] bArr);
}
