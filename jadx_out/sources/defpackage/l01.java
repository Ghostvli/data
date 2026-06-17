package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public enum l01 {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");

    public final String f;

    l01(String str) {
        this.f = str;
    }

    public String b() {
        return ".temp" + this.f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f;
    }
}
