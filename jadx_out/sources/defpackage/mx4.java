package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mx4 extends yh1 {
    public final String b;
    public final String c;

    public mx4(String str, String str2, String str3) {
        super(str);
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && mx4.class == obj.getClass()) {
            mx4 mx4Var = (mx4) obj;
            if (this.a.equals(mx4Var.a) && Objects.equals(this.b, mx4Var.b) && Objects.equals(this.c, mx4Var.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.a.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // defpackage.yh1
    public String toString() {
        return this.a + ": url=" + this.c;
    }
}
