package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum rs1 {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    public final int f;
    public final String g;

    rs1(int i, String str) {
        this.f = i;
        this.g = str;
    }

    public int b() {
        return this.f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.g;
    }
}
