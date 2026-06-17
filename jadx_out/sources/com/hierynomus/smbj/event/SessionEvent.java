package com.hierynomus.smbj.event;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
abstract class SessionEvent implements SMBEvent {
    private long sessionId;

    public SessionEvent(long j) {
        this.sessionId = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.sessionId == ((SessionEvent) obj).sessionId;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        long j = this.sessionId;
        return (int) (j ^ (j >>> 32));
    }
}
