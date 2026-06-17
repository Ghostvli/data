package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class je4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends je4 {
        public volatile boolean a;

        public b() {
            super();
        }

        @Override // defpackage.je4
        public void b(boolean z) {
            this.a = z;
        }

        @Override // defpackage.je4
        public void c() {
            if (this.a) {
                e04.a("Already released");
            }
        }
    }

    public static je4 a() {
        return new b();
    }

    public abstract void b(boolean z);

    public abstract void c();

    public je4() {
    }
}
