package defpackage;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q90 implements wq1 {
    public final wq1 b;
    public final wq1 c;

    public q90(wq1 wq1Var, wq1 wq1Var2) {
        this.b = wq1Var;
        this.c = wq1Var2;
    }

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof q90) {
            q90 q90Var = (q90) obj;
            if (this.b.equals(q90Var.b) && this.c.equals(q90Var.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.wq1
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
