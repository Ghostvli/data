package defpackage;

import defpackage.dx2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cf {
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
    public final float k;
    public final String l;

    public cf(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, String str) {
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
        this.k = f;
        this.l = str;
    }

    public static byte[] a(r73 r73Var) {
        int iY = r73Var.Y();
        int iG = r73Var.g();
        r73Var.g0(iY);
        return gv.k(r73Var.f(), iG, iY);
    }

    public static cf b(r73 r73Var) throws r83 {
        String strG;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        int i8;
        try {
            r73Var.g0(4);
            int iQ = (r73Var.Q() & 3) + 1;
            if (iQ == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iQ2 = r73Var.Q() & 31;
            for (int i9 = 0; i9 < iQ2; i9++) {
                arrayList.add(a(r73Var));
            }
            int iQ3 = r73Var.Q();
            for (int i10 = 0; i10 < iQ3; i10++) {
                arrayList.add(a(r73Var));
            }
            if (iQ2 > 0) {
                dx2.m mVarD = dx2.D((byte[]) arrayList.get(0), dx2.a.length, ((byte[]) arrayList.get(0)).length);
                int i11 = mVarD.f;
                int i12 = mVarD.g;
                int i13 = mVarD.i + 8;
                int i14 = mVarD.j + 8;
                int i15 = mVarD.q;
                int i16 = mVarD.r;
                int i17 = mVarD.s;
                int i18 = mVarD.t;
                float f2 = mVarD.h;
                strG = gv.g(mVarD.a, mVarD.b, mVarD.c);
                i5 = i17;
                i6 = i18;
                f = f2;
                i4 = i14;
                i7 = i15;
                i8 = i16;
                i = i11;
                i2 = i12;
                i3 = i13;
            } else {
                strG = null;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = 16;
                f = 1.0f;
                i7 = -1;
                i8 = -1;
            }
            return new cf(arrayList, iQ, i, i2, i3, i4, i7, i8, i5, i6, f, strG);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw r83.a("Error parsing AVC config", e);
        }
    }
}
