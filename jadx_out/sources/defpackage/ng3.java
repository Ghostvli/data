package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ng3 extends t63 {
    public final Object f;

    public ng3(Object obj) {
        this.f = obj;
    }

    @Override // defpackage.t63
    public boolean b() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ng3) {
            return this.f.equals(((ng3) obj).f);
        }
        return false;
    }

    public int hashCode() {
        return this.f.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f + ")";
    }
}
