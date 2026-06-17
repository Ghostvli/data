package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e52 {
    public final a a;
    public final q6 b;
    public final l6 c;
    public final boolean d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public e52(a aVar, q6 q6Var, l6 l6Var, boolean z) {
        this.a = aVar;
        this.b = q6Var;
        this.c = l6Var;
        this.d = z;
    }

    public a a() {
        return this.a;
    }

    public q6 b() {
        return this.b;
    }

    public l6 c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
