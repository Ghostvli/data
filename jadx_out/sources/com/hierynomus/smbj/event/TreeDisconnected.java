package com.hierynomus.smbj.event;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TreeDisconnected extends SessionEvent {
    private long treeId;

    public TreeDisconnected(long j, long j2) {
        super(j);
        this.treeId = j2;
    }

    @Override // com.hierynomus.smbj.event.SessionEvent
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.hierynomus.smbj.event.SessionEvent
    public /* bridge */ /* synthetic */ long getSessionId() {
        return super.getSessionId();
    }

    public long getTreeId() {
        return this.treeId;
    }

    @Override // com.hierynomus.smbj.event.SessionEvent
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }
}
