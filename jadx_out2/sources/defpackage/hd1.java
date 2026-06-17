package defpackage;

import defpackage.dx2;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hd1 {
    public final List a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final float n;
    public final int o;
    public final String p;
    public final dx2.k q;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hd1(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, String str, dx2.k kVar) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
        this.j = i9;
        this.k = i10;
        this.l = i11;
        this.m = i12;
        this.n = f;
        this.o = i13;
        this.p = str;
        this.q = kVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hd1 a(r73 r73Var) {
        return b(r73Var, false, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hd1 b(r73 r73Var, boolean z, dx2.k kVar) throws r83 {
        boolean z2;
        int i;
        dx2.g gVarU;
        int i2;
        try {
            if (z) {
                r73Var.g0(4);
            } else {
                r73Var.g0(21);
            }
            int iQ = r73Var.Q() & 3;
            int iQ2 = r73Var.Q();
            int iG = r73Var.g();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                z2 = true;
                if (i4 >= iQ2) {
                    break;
                }
                r73Var.g0(1);
                int iY = r73Var.Y();
                for (int i6 = 0; i6 < iY; i6++) {
                    int iY2 = r73Var.Y();
                    i5 += iY2 + 4;
                    r73Var.g0(iY2);
                }
                i4++;
            }
            r73Var.f0(iG);
            byte[] bArr = new byte[i5];
            dx2.k kVar2 = kVar;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            float f = 1.0f;
            String strI = null;
            int i19 = 0;
            int i20 = 0;
            while (i19 < iQ2) {
                int iQ3 = r73Var.Q() & 63;
                int iY3 = r73Var.Y();
                int i21 = i3;
                dx2.k kVarZ = kVar2;
                while (i21 < iY3) {
                    int iY4 = r73Var.Y();
                    boolean z3 = z2;
                    byte[] bArr2 = dx2.a;
                    int i22 = iQ;
                    System.arraycopy(bArr2, i3, bArr, i20, bArr2.length);
                    int length = i20 + bArr2.length;
                    System.arraycopy(r73Var.f(), r73Var.g(), bArr, length, iY4);
                    if (iQ3 == 32 && i21 == 0) {
                        kVarZ = dx2.z(bArr, length, length + iY4);
                        i = iQ2;
                    } else {
                        if (iQ3 == 33 && i21 == 0) {
                            dx2.h hVarV = dx2.v(bArr, length, length + iY4, kVarZ);
                            i7 = hVarV.b + 1;
                            i8 = hVarV.h;
                            int i23 = hVarV.i;
                            int i24 = hVarV.j;
                            i = iQ2;
                            int i25 = hVarV.k;
                            i12 = hVarV.e + 8;
                            i13 = hVarV.f + 8;
                            int i26 = hVarV.n;
                            int i27 = hVarV.o;
                            int i28 = hVarV.p;
                            float f2 = hVarV.l;
                            int i29 = hVarV.m;
                            dx2.c cVar = hVarV.c;
                            if (cVar != null) {
                                i2 = i29;
                                strI = gv.i(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, cVar.f);
                            } else {
                                i2 = i29;
                            }
                            f = f2;
                            i18 = i2;
                            i15 = i27;
                            i16 = i28;
                            i11 = i25;
                            i14 = i26;
                            i10 = i24;
                            i9 = i23;
                        } else {
                            i = iQ2;
                            if (iQ3 == 39 && i21 == 0 && (gVarU = dx2.u(bArr, length, length + iY4)) != null && kVarZ != null) {
                                i3 = 0;
                                i17 = gVarU.d == ((dx2.a) kVarZ.b.get(0)).b ? 4 : 5;
                            }
                        }
                        i3 = 0;
                    }
                    i20 = length + iY4;
                    r73Var.g0(iY4);
                    i21++;
                    z2 = z3;
                    iQ = i22;
                    iQ2 = i;
                }
                i19++;
                kVar2 = kVarZ;
            }
            return new hd1(i5 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iQ + 1, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, f, i18, strI, kVar2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw r83.a("Error parsing".concat(z ? "L-HEVC config" : "HEVC config"), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hd1 c(r73 r73Var, dx2.k kVar) {
        return b(r73Var, true, kVar);
    }
}
