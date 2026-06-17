package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ct4 implements Cloneable {
    public zs4 f = i33.b();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ct4 clone() {
        try {
            return (ct4) super.clone();
        } catch (CloneNotSupportedException e) {
            wg1.a(e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zs4 b() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (obj instanceof ct4) {
            return iy4.e(this.f, ((ct4) obj).f);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        zs4 zs4Var = this.f;
        if (zs4Var != null) {
            return zs4Var.hashCode();
        }
        return 0;
    }
}
