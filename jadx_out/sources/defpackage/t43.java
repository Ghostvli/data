package defpackage;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t43 implements wq1 {
    public final Object b;

    public t43(Object obj) {
        this.b = fg3.e(obj);
    }

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(wq1.a));
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof t43) {
            return this.b.equals(((t43) obj).b);
        }
        return false;
    }

    @Override // defpackage.wq1
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
