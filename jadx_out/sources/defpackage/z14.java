package defpackage;

import android.net.Uri;
import defpackage.xi1;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z14 {
    public final zi1 a;
    public final xi1 b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final Uri g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final HashMap a = new HashMap();
        public final xi1.a b = new xi1.a();
        public int c = -1;
        public String d;
        public String e;
        public String f;
        public Uri g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;

        public b m(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }

        public b n(yf2 yf2Var) {
            this.b.a(yf2Var);
            return this;
        }

        public z14 o() {
            return new z14(this);
        }

        public b p(int i) {
            this.c = i;
            return this;
        }

        public b q(String str) {
            this.h = str;
            return this;
        }

        public b r(String str) {
            this.k = str;
            return this;
        }

        public b s(String str) {
            this.i = str;
            return this;
        }

        public b t(String str) {
            this.e = str;
            return this;
        }

        public b u(String str) {
            this.l = str;
            return this;
        }

        public b v(String str) {
            this.j = str;
            return this;
        }

        public b w(String str) {
            this.d = str;
            return this;
        }

        public b x(String str) {
            this.f = str;
            return this;
        }

        public b y(Uri uri) {
            this.g = uri;
            return this;
        }
    }

    public z14(b bVar) {
        this.a = zi1.c(bVar.a);
        this.b = bVar.b.k();
        this.c = (String) fy4.l(bVar.d);
        this.d = (String) fy4.l(bVar.e);
        this.e = (String) fy4.l(bVar.f);
        this.g = bVar.g;
        this.h = bVar.h;
        this.f = bVar.c;
        this.i = bVar.i;
        this.j = bVar.k;
        this.k = bVar.l;
        this.l = bVar.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z14.class == obj.getClass()) {
            z14 z14Var = (z14) obj;
            if (this.f == z14Var.f && this.a.equals(z14Var.a) && this.b.equals(z14Var.b) && Objects.equals(this.d, z14Var.d) && Objects.equals(this.c, z14Var.c) && Objects.equals(this.e, z14Var.e) && Objects.equals(this.l, z14Var.l) && Objects.equals(this.g, z14Var.g) && Objects.equals(this.j, z14Var.j) && Objects.equals(this.k, z14Var.k) && Objects.equals(this.h, z14Var.h) && Objects.equals(this.i, z14Var.i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((217 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f) * 31;
        String str4 = this.l;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Uri uri = this.g;
        int iHashCode6 = (iHashCode5 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str5 = this.j;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.k;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.i;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }
}
