package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m33 extends su0 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends m33 {
        @Override // defpackage.su0
        public int e() {
            return 4;
        }

        @Override // defpackage.m33
        public boolean k(l33 l33Var) {
            return fg4.j(l33Var.F());
        }

        public String toString() {
            return ":blank";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends m33 {
        public final String a;

        public b(String str) {
            this.a = z33.a(fg4.t(str));
        }

        @Override // defpackage.su0
        public int e() {
            return 6;
        }

        @Override // defpackage.m33
        public boolean k(l33 l33Var) {
            return z33.a(l33Var.F()).contains(this.a);
        }

        public String toString() {
            return String.format(":contains(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends m33 {
        public final Class a;
        public final String b;

        public c(Class cls, String str) {
            this.a = cls;
            this.b = "::" + str;
        }

        @Override // defpackage.su0
        public int e() {
            return 1;
        }

        @Override // defpackage.m33
        public boolean k(l33 l33Var) {
            return this.a.isInstance(l33Var);
        }

        public String toString() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends m33 {
        public final sp3 a;

        public d(sp3 sp3Var) {
            this.a = sp3Var;
        }

        @Override // defpackage.su0
        public int e() {
            return 8;
        }

        @Override // defpackage.m33
        public boolean k(l33 l33Var) {
            return this.a.c(l33Var.F()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.a);
        }
    }

    @Override // defpackage.su0
    public boolean f(br0 br0Var, br0 br0Var2) {
        return k(br0Var2);
    }

    @Override // defpackage.su0
    public boolean g(br0 br0Var, ms1 ms1Var) {
        return k(ms1Var);
    }

    @Override // defpackage.su0
    public boolean j() {
        return true;
    }

    public abstract boolean k(l33 l33Var);
}
