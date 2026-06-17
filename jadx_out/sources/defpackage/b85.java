package defpackage;

import defpackage.ph2;
import defpackage.xs2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b85 implements xs2.a {
    public final String a;
    public final String b;

    public b85(String str, String str2) {
        this.a = xa.g(str);
        this.b = str2;
    }

    @Override // xs2.a
    public void b(ph2.b bVar) {
        String str = this.a;
        str.getClass();
        switch (str) {
            case "TOTALTRACKS":
                Integer numP = ll1.p(this.b);
                if (numP != null) {
                    bVar.u0(numP);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numP2 = ll1.p(this.b);
                if (numP2 != null) {
                    bVar.t0(numP2);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer numP3 = ll1.p(this.b);
                if (numP3 != null) {
                    bVar.v0(numP3);
                    break;
                }
                break;
            case "ALBUM":
                bVar.R(this.b);
                break;
            case "GENRE":
                bVar.e0(this.b);
                break;
            case "TITLE":
                bVar.s0(this.b);
                break;
            case "DESCRIPTION":
                bVar.Y(this.b);
                break;
            case "DISCNUMBER":
                Integer numP4 = ll1.p(this.b);
                if (numP4 != null) {
                    bVar.Z(numP4);
                    break;
                }
                break;
            case "ALBUMARTIST":
                bVar.Q(this.b);
                break;
            case "ARTIST":
                bVar.S(this.b);
                break;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b85.class == obj.getClass()) {
            b85 b85Var = (b85) obj;
            if (this.a.equals(b85Var.a) && this.b.equals(b85Var.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "VC: " + this.a + "=" + this.b;
    }
}
