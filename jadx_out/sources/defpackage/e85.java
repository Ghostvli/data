package defpackage;

import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e85 {
    public final List a;
    public final int b;
    public final String c;
    public final int d;

    public e85(List list, int i, String str, int i2) {
        this.a = list;
        this.b = i;
        this.c = str;
        this.d = i2;
    }

    public static e85 a(r73 r73Var) throws r83 {
        String str;
        int iQ;
        int iQ2;
        int i;
        int i2;
        int i3;
        try {
            if (r73Var.z() != 0) {
                throw r83.a("Unsupported VVC version", null);
            }
            int iQ3 = r73Var.Q();
            int i4 = 1;
            int i5 = ((iQ3 >> 1) & 3) + 1;
            str = "L";
            if ((iQ3 & 1) != 0) {
                r73Var.g0(1);
                int iQ4 = (r73Var.Q() >> 4) & 7;
                iQ = (r73Var.Q() >> 5) & 7;
                int iQ5 = r73Var.Q() & 63;
                int iQ6 = r73Var.Q();
                i = (iQ6 >> 1) & 127;
                str = (iQ6 & 1) != 0 ? "H" : "L";
                iQ2 = r73Var.Q();
                r73Var.g0(iQ5);
                if (iQ4 > 1) {
                    int iQ7 = r73Var.Q();
                    for (int i6 = 0; i6 < iQ4 - 1; i6++) {
                        if (((iQ7 >> (7 - i6)) & 1) != 0) {
                            r73Var.g0(1);
                        }
                    }
                }
                r73Var.g0(r73Var.Q() * 4);
                r73Var.g0(6);
            } else {
                iQ = 0;
                iQ2 = 0;
                i = 0;
            }
            int iQ8 = r73Var.Q();
            int iG = r73Var.g();
            int i7 = 0;
            int i8 = 0;
            while (true) {
                i2 = 12;
                i3 = 13;
                if (i7 >= iQ8) {
                    break;
                }
                int iQ9 = r73Var.Q() & 31;
                int iY = (iQ9 == 13 || iQ9 == 12) ? 1 : r73Var.Y();
                for (int i9 = 0; i9 < iY; i9++) {
                    int iY2 = r73Var.Y();
                    i8 += iY2 + 4;
                    r73Var.g0(iY2);
                }
                i7++;
            }
            r73Var.f0(iG);
            byte[] bArr = new byte[i8];
            int i10 = 0;
            int i11 = 0;
            while (i10 < iQ8) {
                int iQ10 = r73Var.Q() & 31;
                int iY3 = (iQ10 == i3 || iQ10 == i2) ? i4 : r73Var.Y();
                for (int i12 = 0; i12 < iY3; i12++) {
                    int iY4 = r73Var.Y();
                    System.arraycopy(dx2.a, 0, bArr, i11, 4);
                    int i13 = i11 + 4;
                    r73Var.u(bArr, i13, iY4);
                    i11 = i13 + iY4;
                }
                i10++;
                i4 = 1;
                i2 = 12;
                i3 = 13;
            }
            return new e85(xi1.w(bArr), i5, String.format(Locale.US, "vvc1.%d.%s%d", Integer.valueOf(i), str, Integer.valueOf(iQ2)), iQ + 8);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw r83.a("Error parsing VVC configuration", e);
        }
    }
}
