package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vn3 {
    public final long a;
    public final long b;
    public final String c;
    public int d;

    public vn3(String str, long j, long j2) {
        this.c = str == null ? "" : str;
        this.a = j;
        this.b = j2;
    }

    public vn3 a(vn3 vn3Var, String str) {
        String strC = c(str);
        vn3 vn3Var2 = null;
        if (vn3Var != null && strC.equals(vn3Var.c(str))) {
            long j = this.b;
            if (j != -1) {
                long j2 = this.a;
                if (j2 + j == vn3Var.a) {
                    long j3 = vn3Var.b;
                    return new vn3(strC, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = vn3Var.b;
            if (j4 != -1) {
                long j5 = vn3Var.a;
                if (j5 + j4 == this.a) {
                    vn3Var2 = new vn3(strC, j5, j != -1 ? j4 + j : -1L);
                }
            }
        }
        return vn3Var2;
    }

    public Uri b(String str) {
        return kx4.g(str, this.c);
    }

    public String c(String str) {
        return kx4.f(str, this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vn3.class == obj.getClass()) {
            vn3 vn3Var = (vn3) obj;
            if (this.a == vn3Var.a && this.b == vn3Var.b && this.c.equals(vn3Var.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = ((((527 + ((int) this.a)) * 31) + ((int) this.b)) * 31) + this.c.hashCode();
        }
        return this.d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.c + ", start=" + this.a + ", length=" + this.b + ")";
    }
}
