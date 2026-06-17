package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface er3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        public final boolean f;

        a(boolean z) {
            this.f = z;
        }

        public boolean b() {
            return this.f;
        }
    }

    boolean a();

    void b(yq3 yq3Var);

    void c(yq3 yq3Var);

    boolean e(yq3 yq3Var);

    boolean f(yq3 yq3Var);

    boolean g(yq3 yq3Var);

    er3 getRoot();
}
