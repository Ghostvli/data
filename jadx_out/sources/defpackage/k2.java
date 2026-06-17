package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class k2 extends x20 {
    public a f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        UNKNOWN,
        VIOLATION
    }

    public k2(String str) {
        super(str);
        this.f = a.UNKNOWN;
    }

    public k2(String str, a aVar) {
        super(str);
        a aVar2 = a.UNKNOWN;
        this.f = aVar;
    }
}
