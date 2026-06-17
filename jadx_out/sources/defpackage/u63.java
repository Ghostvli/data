package defpackage;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class u63 implements wq1 {
    public final la b = new qo();

    public static void f(s63 s63Var, Object obj, MessageDigest messageDigest) {
        s63Var.g(obj, messageDigest);
    }

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); i++) {
            f((s63) this.b.f(i), this.b.j(i), messageDigest);
        }
    }

    public Object c(s63 s63Var) {
        return this.b.containsKey(s63Var) ? this.b.get(s63Var) : s63Var.c();
    }

    public void d(u63 u63Var) {
        this.b.g(u63Var.b);
    }

    public u63 e(s63 s63Var, Object obj) {
        this.b.put(s63Var, obj);
        return this;
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof u63) {
            return this.b.equals(((u63) obj).b);
        }
        return false;
    }

    @Override // defpackage.wq1
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }
}
