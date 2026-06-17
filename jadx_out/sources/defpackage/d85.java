package defpackage;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d85 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String a;
        public final String[] b;
        public final int c;

        public a(String str, String[] strArr, int i) {
            this.a = str;
            this.b = strArr;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;

        public b(boolean z, int i, int i2, int i3) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int[] a(int i) {
        if (i == 3) {
            return new int[]{0, 2, 1};
        }
        if (i == 5) {
            return new int[]{0, 2, 1, 3, 4};
        }
        if (i == 6) {
            return new int[]{0, 2, 1, 5, 3, 4};
        }
        if (i == 7) {
            return new int[]{0, 2, 1, 6, 5, 3, 4};
        }
        if (i != 8) {
            return null;
        }
        return new int[]{0, 2, 1, 7, 5, 6, 3, 4};
    }

    public static int b(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static long c(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static xs2 d(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String[] strArrH1 = fy4.H1(str, "=");
            if (strArrH1.length != 2) {
                xz1.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (strArrH1[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(cb3.d(new r73(Base64.decode(strArrH1[1], 0))));
                } catch (RuntimeException e) {
                    xz1.j("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new b85(strArrH1[0], strArrH1[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new xs2(arrayList);
    }

    public static xi1 e(byte[] bArr) {
        r73 r73Var = new r73(bArr);
        r73Var.g0(1);
        int i = 0;
        while (r73Var.a() > 0 && r73Var.q() == 255) {
            i += 255;
            r73Var.g0(1);
        }
        int iQ = i + r73Var.Q();
        int i2 = 0;
        while (r73Var.a() > 0 && r73Var.q() == 255) {
            i2 += 255;
            r73Var.g0(1);
        }
        int iQ2 = i2 + r73Var.Q();
        byte[] bArr2 = new byte[iQ];
        int iG = r73Var.g();
        System.arraycopy(bArr, iG, bArr2, 0, iQ);
        int i3 = iG + iQ + iQ2;
        int length = bArr.length - i3;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i3, bArr3, 0, length);
        return xi1.x(bArr2, bArr3);
    }

    public static void f(a85 a85Var) throws r83 {
        int iD = a85Var.d(6) + 1;
        for (int i = 0; i < iD; i++) {
            int iD2 = a85Var.d(16);
            if (iD2 == 0) {
                a85Var.e(8);
                a85Var.e(16);
                a85Var.e(16);
                a85Var.e(6);
                a85Var.e(8);
                int iD3 = a85Var.d(4) + 1;
                for (int i2 = 0; i2 < iD3; i2++) {
                    a85Var.e(8);
                }
            } else {
                if (iD2 != 1) {
                    throw r83.a("floor type greater than 1 not decodable: " + iD2, null);
                }
                int iD4 = a85Var.d(5);
                int[] iArr = new int[iD4];
                int i3 = -1;
                for (int i4 = 0; i4 < iD4; i4++) {
                    int iD5 = a85Var.d(4);
                    iArr[i4] = iD5;
                    if (iD5 > i3) {
                        i3 = iD5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = a85Var.d(3) + 1;
                    int iD6 = a85Var.d(2);
                    if (iD6 > 0) {
                        a85Var.e(8);
                    }
                    for (int i7 = 0; i7 < (1 << iD6); i7++) {
                        a85Var.e(8);
                    }
                }
                a85Var.e(2);
                int iD7 = a85Var.d(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < iD4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        a85Var.e(iD7);
                        i9++;
                    }
                }
            }
        }
    }

    public static void g(int i, a85 a85Var) throws r83 {
        int iD = a85Var.d(6) + 1;
        for (int i2 = 0; i2 < iD; i2++) {
            int iD2 = a85Var.d(16);
            if (iD2 != 0) {
                xz1.d("VorbisUtil", "mapping type other than 0 not supported: " + iD2);
            } else {
                int iD3 = a85Var.c() ? a85Var.d(4) + 1 : 1;
                if (a85Var.c()) {
                    int iD4 = a85Var.d(8) + 1;
                    for (int i3 = 0; i3 < iD4; i3++) {
                        int i4 = i - 1;
                        a85Var.e(b(i4));
                        a85Var.e(b(i4));
                    }
                }
                if (a85Var.d(2) != 0) {
                    throw r83.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iD3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        a85Var.e(4);
                    }
                }
                for (int i6 = 0; i6 < iD3; i6++) {
                    a85Var.e(8);
                    a85Var.e(8);
                    a85Var.e(8);
                }
            }
        }
    }

    public static b[] h(a85 a85Var) {
        int iD = a85Var.d(6) + 1;
        b[] bVarArr = new b[iD];
        for (int i = 0; i < iD; i++) {
            bVarArr[i] = new b(a85Var.c(), a85Var.d(16), a85Var.d(16), a85Var.d(8));
        }
        return bVarArr;
    }

    public static void i(a85 a85Var) throws r83 {
        int iD = a85Var.d(6) + 1;
        for (int i = 0; i < iD; i++) {
            if (a85Var.d(16) > 2) {
                throw r83.a("residueType greater than 2 is not decodable", null);
            }
            a85Var.e(24);
            a85Var.e(24);
            a85Var.e(24);
            int iD2 = a85Var.d(6) + 1;
            a85Var.e(8);
            int[] iArr = new int[iD2];
            for (int i2 = 0; i2 < iD2; i2++) {
                iArr[i2] = ((a85Var.c() ? a85Var.d(5) : 0) * 8) + a85Var.d(3);
            }
            for (int i3 = 0; i3 < iD2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        a85Var.e(8);
                    }
                }
            }
        }
    }

    public static a j(r73 r73Var) {
        return k(r73Var, true, true);
    }

    public static a k(r73 r73Var, boolean z, boolean z2) throws r83 {
        if (z) {
            o(3, r73Var, false);
        }
        String strN = r73Var.N((int) r73Var.G());
        int length = strN.length();
        long jG = r73Var.G();
        String[] strArr = new String[(int) jG];
        int length2 = length + 15;
        for (int i = 0; i < jG; i++) {
            String strN2 = r73Var.N((int) r73Var.G());
            strArr[i] = strN2;
            length2 = length2 + 4 + strN2.length();
        }
        if (z2 && (r73Var.Q() & 1) == 0) {
            throw r83.a("framing bit expected to be set", null);
        }
        return new a(strN, strArr, length2 + 1);
    }

    public static c l(r73 r73Var) throws r83 {
        o(1, r73Var, false);
        int iH = r73Var.H();
        int iQ = r73Var.Q();
        int iH2 = r73Var.H();
        int iD = r73Var.D();
        if (iD <= 0) {
            iD = -1;
        }
        int iD2 = r73Var.D();
        if (iD2 <= 0) {
            iD2 = -1;
        }
        int iD3 = r73Var.D();
        if (iD3 <= 0) {
            iD3 = -1;
        }
        int iQ2 = r73Var.Q();
        return new c(iH, iQ, iH2, iD, iD2, iD3, (int) Math.pow(2.0d, iQ2 & 15), (int) Math.pow(2.0d, (iQ2 & 240) >> 4), (r73Var.Q() & 1) > 0, Arrays.copyOf(r73Var.f(), r73Var.j()));
    }

    public static b[] m(r73 r73Var, int i) throws r83 {
        o(5, r73Var, false);
        int iQ = r73Var.Q() + 1;
        a85 a85Var = new a85(r73Var.f());
        a85Var.e(r73Var.g() * 8);
        for (int i2 = 0; i2 < iQ; i2++) {
            n(a85Var);
        }
        int iD = a85Var.d(6) + 1;
        for (int i3 = 0; i3 < iD; i3++) {
            if (a85Var.d(16) != 0) {
                throw r83.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        f(a85Var);
        i(a85Var);
        g(i, a85Var);
        b[] bVarArrH = h(a85Var);
        if (a85Var.c()) {
            return bVarArrH;
        }
        throw r83.a("framing bit after modes not set as expected", null);
    }

    public static void n(a85 a85Var) throws r83 {
        if (a85Var.d(24) != 5653314) {
            throw r83.a("expected code book to start with [0x56, 0x43, 0x42] at " + a85Var.b(), null);
        }
        int iD = a85Var.d(16);
        int iD2 = a85Var.d(24);
        int iD3 = 0;
        if (a85Var.c()) {
            a85Var.e(5);
            while (iD3 < iD2) {
                iD3 += a85Var.d(b(iD2 - iD3));
            }
        } else {
            boolean zC = a85Var.c();
            while (iD3 < iD2) {
                if (!zC) {
                    a85Var.e(5);
                } else if (a85Var.c()) {
                    a85Var.e(5);
                }
                iD3++;
            }
        }
        int iD4 = a85Var.d(4);
        if (iD4 > 2) {
            throw r83.a("lookup type greater than 2 not decodable: " + iD4, null);
        }
        if (iD4 == 1 || iD4 == 2) {
            a85Var.e(32);
            a85Var.e(32);
            int iD5 = a85Var.d(4) + 1;
            a85Var.e(1);
            a85Var.e((int) ((iD4 == 1 ? iD != 0 ? c(iD2, iD) : 0L : ((long) iD) * ((long) iD2)) * ((long) iD5)));
        }
    }

    public static boolean o(int i, r73 r73Var, boolean z) throws r83 {
        if (r73Var.a() < 7) {
            if (z) {
                return false;
            }
            throw r83.a("too short header: " + r73Var.a(), null);
        }
        if (r73Var.Q() != i) {
            if (z) {
                return false;
            }
            throw r83.a("expected header type " + Integer.toHexString(i), null);
        }
        if (r73Var.Q() == 118 && r73Var.Q() == 111 && r73Var.Q() == 114 && r73Var.Q() == 98 && r73Var.Q() == 105 && r73Var.Q() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw r83.a("expected characters 'vorbis'", null);
    }
}
