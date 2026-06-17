package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class sk1 extends qk1 {
    public static final a j = new a(null);
    public static final sk1 k = new sk1(1, 0);

    public sk1(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // defpackage.qk1
    public boolean equals(Object obj) {
        if (!(obj instanceof sk1)) {
            return false;
        }
        if (isEmpty() && ((sk1) obj).isEmpty()) {
            return true;
        }
        sk1 sk1Var = (sk1) obj;
        return b() == sk1Var.b() && c() == sk1Var.c();
    }

    public Integer g() {
        return Integer.valueOf(c());
    }

    @Override // defpackage.qk1
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + c();
    }

    @Override // defpackage.qk1
    public boolean isEmpty() {
        return b() > c();
    }

    public Integer j() {
        return Integer.valueOf(b());
    }

    @Override // defpackage.qk1
    public String toString() {
        return b() + ".." + c();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final sk1 a() {
            return sk1.k;
        }

        public a() {
        }
    }
}
