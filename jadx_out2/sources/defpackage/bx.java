package defpackage;

import android.os.Bundle;
import java.util.Arrays;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bx {
    public static final bx h = new b().d(1).c(2).e(3).a();
    public static final bx i = new b().d(1).c(1).e(2).a();
    public static final String j = fy4.N0(0);
    public static final String k = fy4.N0(1);
    public static final String l = fy4.N0(2);
    public static final String m = fy4.N0(3);
    public static final String n = fy4.N0(4);
    public static final String o = fy4.N0(5);
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    public final int e;
    public final int f;
    public int g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bx(int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = bArr;
        this.e = i5;
        this.f = i6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b(int i2) {
        if (i2 == -1) {
            return "NA";
        }
        return i2 + "bit Chroma";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(int i2) {
        if (i2 == -1) {
            return "Unset color range";
        }
        if (i2 == 1) {
            return "Full range";
        }
        if (i2 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(int i2) {
        if (i2 == -1) {
            return "Unset color space";
        }
        if (i2 == 6) {
            return "BT2020";
        }
        if (i2 == 1) {
            return "BT709";
        }
        if (i2 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String e(int i2) {
        if (i2 == -1) {
            return "Unset color transfer";
        }
        if (i2 == 10) {
            return "Gamma 2.2";
        }
        if (i2 == 1) {
            return "Linear";
        }
        if (i2 == 2) {
            return "sRGB";
        }
        if (i2 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i2 == 6) {
            return "ST2084 PQ";
        }
        if (i2 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bx f(Bundle bundle) {
        return new bx(bundle.getInt(j, -1), bundle.getInt(k, -1), bundle.getInt(l, -1), bundle.getByteArray(m), bundle.getInt(n, -1), bundle.getInt(o, -1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(bx bxVar) {
        if (bxVar == null) {
            return true;
        }
        int i2 = bxVar.a;
        if (i2 != -1 && i2 != 1 && i2 != 2) {
            return false;
        }
        int i3 = bxVar.b;
        if (i3 != -1 && i3 != 2) {
            return false;
        }
        int i4 = bxVar.c;
        if ((i4 != -1 && i4 != 3) || bxVar.d != null) {
            return false;
        }
        int i5 = bxVar.f;
        if (i5 != -1 && i5 != 8) {
            return false;
        }
        int i6 = bxVar.e;
        return i6 == -1 || i6 == 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int l(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String m(int i2) {
        if (i2 == -1) {
            return "NA";
        }
        return i2 + "bit Luma";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b a() {
        return new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bx.class == obj.getClass()) {
            bx bxVar = (bx) obj;
            if (this.a == bxVar.a && this.b == bxVar.b && this.c == bxVar.c && Arrays.equals(this.d, bxVar.d) && this.e == bxVar.e && this.f == bxVar.f) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        return (this.e == -1 || this.f == -1) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h() {
        return (this.a == -1 || this.b == -1 || this.c == -1) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        if (this.g == 0) {
            this.g = ((((((((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d)) * 31) + this.e) * 31) + this.f;
        }
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j() {
        return g() || h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle n() {
        Bundle bundle = new Bundle();
        bundle.putInt(j, this.a);
        bundle.putInt(k, this.b);
        bundle.putInt(l, this.c);
        bundle.putByteArray(m, this.d);
        bundle.putInt(n, this.e);
        bundle.putInt(o, this.f);
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String o() {
        String str;
        String strM = h() ? fy4.M("%s/%s/%s", d(this.a), c(this.b), e(this.c)) : "NA/NA/NA";
        if (g()) {
            str = this.e + ServiceReference.DELIMITER + this.f;
        } else {
            str = "NA/NA";
        }
        return strM + ServiceReference.DELIMITER + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(d(this.a));
        sb.append(", ");
        sb.append(c(this.b));
        sb.append(", ");
        sb.append(e(this.c));
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(", ");
        sb.append(m(this.e));
        sb.append(", ");
        sb.append(b(this.f));
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public int a;
        public int b;
        public int c;
        public byte[] d;
        public int e;
        public int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(bx bxVar) {
            this.a = bxVar.a;
            this.b = bxVar.b;
            this.c = bxVar.c;
            this.d = bxVar.d;
            this.e = bxVar.e;
            this.f = bxVar.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public bx a() {
            return new bx(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(int i) {
            this.f = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(int i) {
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(int i) {
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(int i) {
            this.c = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b g(int i) {
            this.e = i;
            return this;
        }

        public b() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.e = -1;
            this.f = -1;
        }
    }
}
