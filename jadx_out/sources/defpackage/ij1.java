package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ij1 implements s94 {
    public static final ij1 b = new ij1(true);
    public static final ij1 c = new ij1(false);
    public final boolean a;

    public ij1(boolean z) {
        this.a = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IncorrectFragmentation{expected=");
        sb.append(!this.a);
        sb.append("}");
        return sb.toString();
    }
}
