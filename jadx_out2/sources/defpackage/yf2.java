package defpackage;

import androidx.media3.exoplayer.rtsp.h;
import defpackage.zi1;
import java.util.HashMap;
import java.util.Objects;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yf2 {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final zi1 i;
    public final c j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final String a;
        public final int b;
        public final String c;
        public final int d;
        public final HashMap e = new HashMap();
        public int f = -1;
        public String g;
        public String h;
        public String i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, int i, String str2, int i2) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static String k(int i, String str, int i2, int i3) {
            return fy4.M("%d %s/%d/%d", Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static String l(int i) {
            gg3.d(i < 96);
            if (i == 0) {
                return k(0, "PCMU", 8000, 1);
            }
            if (i == 8) {
                return k(8, "PCMA", 8000, 1);
            }
            if (i == 10) {
                return k(10, "L16", 44100, 2);
            }
            if (i == 11) {
                return k(11, "L16", 44100, 1);
            }
            bo1.a("Unsupported static paylod type ", i);
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b i(String str, String str2) {
            this.e.put(str, str2);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public yf2 j() {
            try {
                return new yf2(this, zi1.c(this.e), this.e.containsKey("rtpmap") ? c.a((String) fy4.l((String) this.e.get("rtpmap"))) : c.a(l(this.d)));
            } catch (r83 e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b m(int i) {
            this.f = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b n(String str) {
            this.h = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b o(String str) {
            this.i = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b p(String str) {
            this.g = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, String str, int i2, int i3) {
            this.a = i;
            this.b = str;
            this.c = i2;
            this.d = i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c a(String str) {
            String[] strArrH1 = fy4.H1(str, " ");
            gg3.d(strArrH1.length == 2);
            int iH = h.h(strArrH1[0]);
            String[] strArrG1 = fy4.G1(strArrH1[1].trim(), ServiceReference.DELIMITER);
            gg3.d(strArrG1.length >= 2);
            return new c(iH, strArrG1[0], h.h(strArrG1[1]), strArrG1.length == 3 ? h.h(strArrG1[2]) : -1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.a == cVar.a && this.b.equals(cVar.b) && this.c == cVar.c && this.d == cVar.d) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return ((((((217 + this.a) * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yf2(b bVar, zi1 zi1Var, c cVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.f = bVar.g;
        this.g = bVar.h;
        this.e = bVar.f;
        this.h = bVar.i;
        this.i = zi1Var;
        this.j = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zi1 a() {
        String str = (String) this.i.get("fmtp");
        if (str == null) {
            return zi1.j();
        }
        String[] strArrH1 = fy4.H1(str, " ");
        gg3.e(strArrH1.length == 2, str);
        String[] strArrSplit = strArrH1[1].split(";\\s?", 0);
        zi1.a aVar = new zi1.a();
        for (String str2 : strArrSplit) {
            String[] strArrH12 = fy4.H1(str2, "=");
            aVar.g(strArrH12[0], strArrH12[1]);
        }
        return aVar.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && yf2.class == obj.getClass()) {
            yf2 yf2Var = (yf2) obj;
            if (this.a.equals(yf2Var.a) && this.b == yf2Var.b && this.c.equals(yf2Var.c) && this.d == yf2Var.d && this.e == yf2Var.e && this.i.equals(yf2Var.i) && this.j.equals(yf2Var.j) && Objects.equals(this.f, yf2Var.f) && Objects.equals(this.g, yf2Var.g) && Objects.equals(this.h, yf2Var.h)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int iHashCode = (((((((((((((217 + this.a.hashCode()) * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        String str = this.f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.h;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }
}
