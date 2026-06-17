package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jh4 extends IllegalStateException {
    public final int f;
    public final int g;

    public jh4(int i, int i2) {
        super(a(i, i2));
        this.f = i;
        this.g = i2;
    }

    public static String a(int i, int i2) {
        if (i == 0) {
            return "Player stuck buffering and not loading for " + i2 + " ms";
        }
        if (i == 1) {
            return "Player stuck buffering with no progress for " + i2 + " ms";
        }
        if (i == 2) {
            return "Player stuck playing with no progress for " + i2 + " ms";
        }
        if (i == 3) {
            return "Player stuck playing without ending for " + i2 + " ms";
        }
        if (i != 4) {
            z20.a();
            return null;
        }
        return "Player stuck suppressed for " + i2 + " ms";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && jh4.class == obj.getClass()) {
            jh4 jh4Var = (jh4) obj;
            if (this.f == jh4Var.f && this.g == jh4Var.g) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f) * 31) + this.g;
    }
}
