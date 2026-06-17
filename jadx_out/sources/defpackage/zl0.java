package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zl0 {
    public static final zl0 a = new a();
    public static final zl0 b = new b();
    public static final zl0 c = new c();
    public static final zl0 d = new d();
    public static final zl0 e = new e();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends zl0 {
        @Override // defpackage.zl0
        public boolean a() {
            return true;
        }

        @Override // defpackage.zl0
        public boolean b() {
            return true;
        }

        @Override // defpackage.zl0
        public boolean c(ba0 ba0Var) {
            return ba0Var == ba0.REMOTE;
        }

        @Override // defpackage.zl0
        public boolean d(boolean z, ba0 ba0Var, ms0 ms0Var) {
            return (ba0Var == ba0.RESOURCE_DISK_CACHE || ba0Var == ba0.MEMORY_CACHE) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends zl0 {
        @Override // defpackage.zl0
        public boolean a() {
            return false;
        }

        @Override // defpackage.zl0
        public boolean b() {
            return false;
        }

        @Override // defpackage.zl0
        public boolean c(ba0 ba0Var) {
            return false;
        }

        @Override // defpackage.zl0
        public boolean d(boolean z, ba0 ba0Var, ms0 ms0Var) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends zl0 {
        @Override // defpackage.zl0
        public boolean a() {
            return true;
        }

        @Override // defpackage.zl0
        public boolean b() {
            return false;
        }

        @Override // defpackage.zl0
        public boolean c(ba0 ba0Var) {
            return (ba0Var == ba0.DATA_DISK_CACHE || ba0Var == ba0.MEMORY_CACHE) ? false : true;
        }

        @Override // defpackage.zl0
        public boolean d(boolean z, ba0 ba0Var, ms0 ms0Var) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends zl0 {
        @Override // defpackage.zl0
        public boolean a() {
            return false;
        }

        @Override // defpackage.zl0
        public boolean b() {
            return true;
        }

        @Override // defpackage.zl0
        public boolean c(ba0 ba0Var) {
            return false;
        }

        @Override // defpackage.zl0
        public boolean d(boolean z, ba0 ba0Var, ms0 ms0Var) {
            return (ba0Var == ba0.RESOURCE_DISK_CACHE || ba0Var == ba0.MEMORY_CACHE) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends zl0 {
        @Override // defpackage.zl0
        public boolean a() {
            return true;
        }

        @Override // defpackage.zl0
        public boolean b() {
            return true;
        }

        @Override // defpackage.zl0
        public boolean c(ba0 ba0Var) {
            return ba0Var == ba0.REMOTE;
        }

        @Override // defpackage.zl0
        public boolean d(boolean z, ba0 ba0Var, ms0 ms0Var) {
            return ((z && ba0Var == ba0.DATA_DISK_CACHE) || ba0Var == ba0.LOCAL) && ms0Var == ms0.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(ba0 ba0Var);

    public abstract boolean d(boolean z, ba0 ba0Var, ms0 ms0Var);
}
