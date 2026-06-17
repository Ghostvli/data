package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum AvId implements EnumWithValue<AvId> {
    MsvAvEOL(0),
    MsvAvNbComputerName(1),
    MsvAvNbDomainName(2),
    MsvAvDnsComputerName(3),
    MsvAvDnsDomainName(4),
    MsvAvDnsTreeName(5),
    MsvAvFlags(6),
    MsvAvTimestamp(7),
    MsvAvSingleHost(8),
    MsvAvTargetName(9),
    MsvAvChannelBindings(10);

    private final long value;

    AvId(long j) {
        this.value = j;
    }

    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}
