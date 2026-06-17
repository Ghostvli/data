package com.google.android.material.carousel;

import com.google.android.material.carousel.a;
import com.google.android.material.carousel.c;
import defpackage.iq;
import defpackage.k7;
import defpackage.r62;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public final c a;
    public final List b;
    public final List c;
    public final float[] d;
    public final float[] e;
    public final float f;
    public final float g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.EnumC0063a.values().length];
            a = iArr;
            try {
                iArr[a.EnumC0063a.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public d(c cVar, List list, List list2) {
        this.a = cVar;
        this.b = Collections.unmodifiableList(list);
        this.c = Collections.unmodifiableList(list2);
        float f = ((c) list.get(list.size() - 1)).d().a - cVar.d().a;
        this.f = f;
        float f2 = cVar.k().a - ((c) list2.get(list2.size() - 1)).k().a;
        this.g = f2;
        this.d = m(f, list, true);
        this.e = m(f2, list2, false);
    }

    public static int b(c cVar, float f) {
        for (int iJ = cVar.j(); iJ < cVar.h().size(); iJ++) {
            if (f == ((c.C0064c) cVar.h().get(iJ)).c) {
                return iJ;
            }
        }
        return cVar.h().size() - 1;
    }

    public static int c(c cVar) {
        for (int i = 0; i < cVar.h().size(); i++) {
            if (!((c.C0064c) cVar.h().get(i)).e) {
                return i;
            }
        }
        return -1;
    }

    public static int d(c cVar, float f) {
        for (int iC = cVar.c() - 1; iC >= 0; iC--) {
            if (f == ((c.C0064c) cVar.h().get(iC)).c) {
                return iC;
            }
        }
        return 0;
    }

    public static int e(c cVar) {
        for (int size = cVar.h().size() - 1; size >= 0; size--) {
            if (!((c.C0064c) cVar.h().get(size)).e) {
                return size;
            }
        }
        return -1;
    }

    public static d f(iq iqVar, c cVar, float f, float f2, float f3, a.EnumC0063a enumC0063a) {
        return new d(cVar, p(iqVar, cVar, f, f2, enumC0063a), n(iqVar, cVar, f, f3, enumC0063a));
    }

    public static float[] m(float f, List list, boolean z) {
        int size = list.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            c cVar = (c) list.get(i2);
            c cVar2 = (c) list.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i2] + ((z ? cVar2.d().a - cVar.d().a : cVar.k().a - cVar2.k().a) / f);
            i++;
        }
        return fArr;
    }

    public static List n(iq iqVar, c cVar, float f, float f2, a.EnumC0063a enumC0063a) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        int iE = e(cVar);
        int iA = iqVar.z() ? iqVar.a() : iqVar.d();
        if (!r(iqVar, cVar) && iE != -1) {
            int iJ = iE - cVar.j();
            float f3 = cVar.d().b - (cVar.d().d / 2.0f);
            if (iJ <= 0 && cVar.i().f > 0.0f) {
                arrayList.add(x(cVar, (f3 - cVar.i().f) - f2, iA));
                return arrayList;
            }
            float f4 = 0.0f;
            int i = 0;
            while (i < iJ) {
                c cVar2 = (c) arrayList.get(arrayList.size() - 1);
                int i2 = iE - i;
                float f5 = f4 + ((c.C0064c) cVar.h().get(i2)).f;
                int i3 = i2 + 1;
                int i4 = iA;
                c cVarT = t(cVar2, iE, i3 < cVar.h().size() ? d(cVar2, ((c.C0064c) cVar.h().get(i3)).c) + 1 : 0, f3 - f5, cVar.c() + i + 1, cVar.j() + i + 1, i4);
                if (i == iJ - 1 && f2 > 0.0f) {
                    cVarT = u(cVarT, f2, i4, false, f, enumC0063a);
                    i4 = i4;
                }
                arrayList.add(cVarT);
                i++;
                iA = i4;
                f4 = f5;
            }
        } else if (f2 > 0.0f) {
            arrayList.add(u(cVar, f2, iA, false, f, enumC0063a));
        }
        return arrayList;
    }

    public static float[] o(List list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        int i = 1;
        while (i < size) {
            float f3 = fArr[i];
            if (f <= f3) {
                return new float[]{k7.b(0.0f, 1.0f, f2, f3, f), i - 1, i};
            }
            i++;
            f2 = f3;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    public static List p(iq iqVar, c cVar, float f, float f2, a.EnumC0063a enumC0063a) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        int iC = c(cVar);
        int iA = iqVar.z() ? iqVar.a() : iqVar.d();
        if (!q(cVar) && iC != -1) {
            int iC2 = cVar.c() - iC;
            float f3 = cVar.d().b - (cVar.d().d / 2.0f);
            if (iC2 <= 0 && cVar.b().f > 0.0f) {
                arrayList.add(x(cVar, f3 + cVar.b().f + f2, iA));
                return arrayList;
            }
            float f4 = 0.0f;
            for (int i = 0; i < iC2; i++) {
                c cVar2 = (c) arrayList.get(arrayList.size() - 1);
                int i2 = iC + i;
                int size = cVar.h().size() - 1;
                f4 += ((c.C0064c) cVar.h().get(i2)).f;
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    size = b(cVar2, ((c.C0064c) cVar.h().get(i3)).c) - 1;
                }
                int i4 = iA;
                c cVarT = t(cVar2, iC, size, f3 + f4, (cVar.c() - i) - 1, (cVar.j() - i) - 1, i4);
                iA = i4;
                if (i == iC2 - 1 && f2 > 0.0f) {
                    cVarT = u(cVarT, f2, iA, true, f, enumC0063a);
                }
                arrayList.add(cVarT);
            }
        } else if (f2 > 0.0f) {
            arrayList.add(u(cVar, f2, iA, true, f, enumC0063a));
        }
        return arrayList;
    }

    public static boolean q(c cVar) {
        return cVar.b().b - (cVar.b().d / 2.0f) >= 0.0f && cVar.b() == cVar.e();
    }

    public static boolean r(iq iqVar, c cVar) {
        int iD = iqVar.d();
        if (iqVar.z()) {
            iD = iqVar.a();
        }
        return cVar.i().b + (cVar.i().d / 2.0f) <= ((float) iD) && cVar.i() == cVar.l();
    }

    public static c s(List list, float f, float[] fArr) {
        float[] fArrO = o(list, f, fArr);
        return c.o((c) list.get((int) fArrO[1]), (c) list.get((int) fArrO[2]), fArrO[0]);
    }

    public static c t(c cVar, int i, int i2, float f, int i3, int i4, int i5) {
        ArrayList arrayList = new ArrayList(cVar.h());
        arrayList.add(i2, (c.C0064c) arrayList.remove(i));
        c.b bVar = new c.b(cVar.g(), i5);
        int i6 = 0;
        while (i6 < arrayList.size()) {
            c.C0064c c0064c = (c.C0064c) arrayList.get(i6);
            float f2 = c0064c.d;
            bVar.e(f + (f2 / 2.0f), c0064c.c, f2, i6 >= i3 && i6 <= i4, c0064c.e, c0064c.f);
            f += c0064c.d;
            i6++;
        }
        return bVar.i();
    }

    public static c u(c cVar, float f, int i, boolean z, float f2, a.EnumC0063a enumC0063a) {
        return a.a[enumC0063a.ordinal()] != 1 ? w(cVar, f, i, z) : v(cVar, f, i, z, f2);
    }

    public static c v(c cVar, float f, int i, boolean z, float f2) {
        ArrayList arrayList = new ArrayList(cVar.h());
        c.b bVar = new c.b(cVar.g(), i);
        float fM = f / cVar.m();
        float f3 = z ? f : 0.0f;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            c.C0064c c0064c = (c.C0064c) arrayList.get(i2);
            if (c0064c.e) {
                bVar.e(c0064c.b, c0064c.c, c0064c.d, false, true, c0064c.f);
            } else {
                boolean z2 = i2 >= cVar.c() && i2 <= cVar.j();
                float f4 = c0064c.d - fM;
                float fB = com.google.android.material.carousel.a.b(f4, cVar.g(), f2);
                float f5 = (f4 / 2.0f) + f3;
                float fAbs = Math.abs(f5 - c0064c.b);
                bVar.f(f5, fB, f4, z2, false, c0064c.f, z ? fAbs : 0.0f, z ? 0.0f : fAbs);
                f3 += f4;
            }
            i2++;
        }
        return bVar.i();
    }

    public static c w(c cVar, float f, int i, boolean z) {
        ArrayList arrayList = new ArrayList(cVar.h());
        c.b bVar = new c.b(cVar.g(), i);
        boolean z2 = true;
        int size = z ? 0 : arrayList.size() - 1;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            c.C0064c c0064c = (c.C0064c) arrayList.get(i2);
            if (c0064c.e && i2 == size) {
                bVar.e(c0064c.b, c0064c.c, c0064c.d, false, true, c0064c.f);
            } else {
                float f2 = c0064c.b;
                float f3 = z ? f2 + f : f2 - f;
                float f4 = z ? f : 0.0f;
                float f5 = z ? 0.0f : f;
                boolean z3 = (i2 < cVar.c() || i2 > cVar.j()) ? false : z2;
                float f6 = f3;
                float f7 = c0064c.c;
                float f8 = c0064c.d;
                bVar.f(f6, f7, f8, z3, c0064c.e, Math.abs(z ? Math.max(0.0f, ((f8 / 2.0f) + f6) - i) : Math.min(0.0f, f6 - (f8 / 2.0f))), f4, f5);
            }
            i2++;
            z2 = true;
        }
        return bVar.i();
    }

    public static c x(c cVar, float f, int i) {
        return t(cVar, 0, 0, f, cVar.c(), cVar.j(), i);
    }

    public final c a(List list, float f, float[] fArr) {
        float[] fArrO = o(list, f, fArr);
        return fArrO[0] >= 0.5f ? (c) list.get((int) fArrO[2]) : (c) list.get((int) fArrO[1]);
    }

    public c g() {
        return this.a;
    }

    public c h() {
        return (c) this.c.get(r1.size() - 1);
    }

    public Map i(int i, int i2, int i3, boolean z) {
        float fG = this.a.g();
        HashMap map = new HashMap();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            int i6 = z ? (i - i4) - 1 : i4;
            if (i6 * fG * (z ? -1 : 1) > i3 - this.g || i4 >= i - this.c.size()) {
                Integer numValueOf = Integer.valueOf(i6);
                List list = this.c;
                map.put(numValueOf, (c) list.get(r62.b(i5, 0, list.size() - 1)));
                i5++;
            }
            i4++;
        }
        int i7 = 0;
        for (int i8 = i - 1; i8 >= 0; i8--) {
            int i9 = z ? (i - i8) - 1 : i8;
            if (i9 * fG * (z ? -1 : 1) < i2 + this.f || i8 < this.b.size()) {
                Integer numValueOf2 = Integer.valueOf(i9);
                List list2 = this.b;
                map.put(numValueOf2, (c) list2.get(r62.b(i7, 0, list2.size() - 1)));
                i7++;
            }
        }
        return map;
    }

    public c j(float f, float f2, float f3) {
        return k(f, f2, f3, false);
    }

    public c k(float f, float f2, float f3, boolean z) {
        float fB;
        List list;
        float[] fArr;
        float f4 = this.f + f2;
        float f5 = f3 - this.g;
        float f6 = l().b().g;
        float f7 = h().b().h;
        if (this.f == f6) {
            f4 += f6;
        }
        if (this.g == f7) {
            f5 -= f7;
        }
        if (f < f4) {
            fB = k7.b(1.0f, 0.0f, f2, f4, f);
            list = this.b;
            fArr = this.d;
        } else {
            if (f <= f5) {
                return this.a;
            }
            fB = k7.b(0.0f, 1.0f, f5, f3, f);
            list = this.c;
            fArr = this.e;
        }
        return z ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    public c l() {
        return (c) this.b.get(r1.size() - 1);
    }
}
