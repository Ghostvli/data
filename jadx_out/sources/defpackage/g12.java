package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g12 {
    public static final g12 b = new g12();
    public final f32 a = new f32(20);

    public static g12 b() {
        return b;
    }

    public f12 a(String str) {
        if (str == null) {
            return null;
        }
        return (f12) this.a.d(str);
    }

    public void c(String str, f12 f12Var) {
        if (str == null) {
            return;
        }
        this.a.e(str, f12Var);
    }
}
