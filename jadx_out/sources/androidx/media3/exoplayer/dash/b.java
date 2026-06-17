package androidx.media3.exoplayer.dash;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.exoplayer.dash.a;
import androidx.media3.exoplayer.dash.d;
import androidx.media3.exoplayer.j;
import defpackage.br4;
import defpackage.bz1;
import defpackage.er4;
import defpackage.ev;
import defpackage.fj;
import defpackage.fy4;
import defpackage.g90;
import defpackage.gx3;
import defpackage.hs4;
import defpackage.hv0;
import defpackage.i14;
import defpackage.ie3;
import defpackage.ir4;
import defpackage.is0;
import defpackage.iv0;
import defpackage.j5;
import defpackage.jy0;
import defpackage.ll1;
import defpackage.m90;
import defpackage.mi2;
import defpackage.na3;
import defpackage.nt2;
import defpackage.p81;
import defpackage.qy;
import defpackage.rj0;
import defpackage.rq2;
import defpackage.ru1;
import defpackage.sy1;
import defpackage.t41;
import defpackage.tq3;
import defpackage.v42;
import defpackage.wo0;
import defpackage.wt;
import defpackage.xi1;
import defpackage.xi4;
import defpackage.xo0;
import defpackage.y3;
import defpackage.zz3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements mi2, i14.a, wt.b {
    public static final Pattern I = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern J = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public i14 A;
    public g90 B;
    public int C;
    public List D;
    public long F;
    public long G;
    public boolean H;
    public final int f;
    public final a.InterfaceC0017a g;
    public final hs4 h;
    public final xo0 i;
    public final sy1 j;
    public final fj k;
    public final long l;
    public final bz1 m;
    public final j5 n;
    public final er4 o;
    public final a[] p;
    public final qy q;
    public final d r;
    public final rq2.a t;
    public final wo0.a u;
    public final ie3 v;
    public final xi4 w;
    public mi2.a x;
    public boolean E = true;
    public wt[] y = L(0);
    public hv0[] z = new hv0[0];
    public final IdentityHashMap s = new IdentityHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int[] a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final xi1 h;

        public a(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, xi1 xi1Var) {
            this.b = i;
            this.a = iArr;
            this.c = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.d = i6;
            this.h = xi1Var;
        }

        public static a a(int[] iArr, int i, xi1 xi1Var) {
            return new a(3, 1, iArr, i, -1, -1, -1, xi1Var);
        }

        public static a b(int[] iArr, int i) {
            return new a(5, 1, iArr, i, -1, -1, -1, xi1.u());
        }

        public static a c(int i) {
            return new a(5, 2, new int[0], -1, -1, -1, i, xi1.u());
        }

        public static a d(int i, int[] iArr, int i2, int i3, int i4) {
            return new a(i, 0, iArr, i2, i3, i4, -1, xi1.u());
        }
    }

    public b(int i, g90 g90Var, fj fjVar, int i2, a.InterfaceC0017a interfaceC0017a, hs4 hs4Var, ev evVar, xo0 xo0Var, wo0.a aVar, sy1 sy1Var, rq2.a aVar2, long j, bz1 bz1Var, j5 j5Var, qy qyVar, d.b bVar, ie3 ie3Var, xi4 xi4Var) {
        this.f = i;
        this.B = g90Var;
        this.k = fjVar;
        this.C = i2;
        this.g = interfaceC0017a;
        this.h = hs4Var;
        this.i = xo0Var;
        this.u = aVar;
        this.j = sy1Var;
        this.t = aVar2;
        this.l = j;
        this.m = bz1Var;
        this.n = j5Var;
        this.q = qyVar;
        this.v = ie3Var;
        this.w = xi4Var;
        this.r = new d(g90Var, bVar, j5Var);
        this.A = qyVar.empty();
        na3 na3VarD = g90Var.d(i2);
        List list = na3VarD.d;
        this.D = list;
        Pair pairX = x(xo0Var, interfaceC0017a, na3VarD.c, list);
        this.o = (er4) pairX.first;
        this.p = (a[]) pairX.second;
        this.G = Long.MIN_VALUE;
    }

    public static rj0 A(List list, String str) {
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if (str.equals(rj0Var.a)) {
                return rj0Var;
            }
        }
        return null;
    }

    public static rj0 B(List list) {
        return A(list, "http://dashif.org/guidelines/trickmode");
    }

    public static t41[] C(List list, int[] iArr) {
        for (int i : iArr) {
            y3 y3Var = (y3) list.get(i);
            List list2 = ((y3) list.get(i)).d;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                rj0 rj0Var = (rj0) list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(rj0Var.a)) {
                    return N(rj0Var, I, new t41.b().A0("application/cea-608").k0(y3Var.a + ":cea608").Q());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(rj0Var.a)) {
                    return N(rj0Var, J, new t41.b().A0("application/cea-708").k0(y3Var.a + ":cea708").Q());
                }
            }
        }
        return new t41[0];
    }

    public static long D(long j, g90 g90Var, int i, int[] iArr) {
        m90 m90VarL = ((tq3) ((y3) g90Var.d(i).c.get(iArr[0])).c.get(0)).l();
        if (m90VarL == null) {
            return -9223372036854775807L;
        }
        return m90VarL.a(m90VarL.f(j, g90Var.g(i)));
    }

    public static int[][] E(List list) {
        rj0 rj0VarZ;
        Integer num;
        int size = list.size();
        HashMap mapI = v42.i(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i = 0; i < size; i++) {
            mapI.put(Long.valueOf(((y3) list.get(i)).a), Integer.valueOf(i));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i));
            arrayList.add(arrayList2);
            sparseArray.put(i, arrayList2);
        }
        for (int i2 = 0; i2 < size; i2++) {
            y3 y3Var = (y3) list.get(i2);
            rj0 rj0VarB = B(y3Var.e);
            if (rj0VarB == null) {
                rj0VarB = B(y3Var.f);
            }
            int iIntValue = (rj0VarB == null || (num = (Integer) mapI.get(Long.valueOf(Long.parseLong(rj0VarB.b)))) == null || !y(y3Var, (y3) list.get(num.intValue()))) ? i2 : num.intValue();
            if (iIntValue == i2 && (rj0VarZ = z(y3Var.f)) != null) {
                for (String str : fy4.G1(rj0VarZ.b, ",")) {
                    Integer num2 = (Integer) mapI.get(Long.valueOf(Long.parseLong(str)));
                    if (num2 != null && y(y3Var, (y3) list.get(num2.intValue()))) {
                        iIntValue = Math.min(iIntValue, num2.intValue());
                    }
                }
            }
            if (iIntValue != i2) {
                List list2 = (List) sparseArray.get(i2);
                List list3 = (List) sparseArray.get(iIntValue);
                list3.addAll(list2);
                sparseArray.put(i2, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i3 = 0; i3 < size2; i3++) {
            int[] iArrN = ll1.n((Collection) arrayList.get(i3));
            iArr[i3] = iArrN;
            Arrays.sort(iArrN);
        }
        return iArr;
    }

    public static boolean H(List list, int[] iArr) {
        for (int i : iArr) {
            List list2 = ((y3) list.get(i)).c;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!((tq3) list2.get(i2)).e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int I(int i, List list, int[][] iArr, boolean[] zArr, t41[][] t41VarArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (H(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            t41[] t41VarArrC = C(list, iArr[i3]);
            t41VarArr[i3] = t41VarArrC;
            if (t41VarArrC.length != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static void K(a.InterfaceC0017a interfaceC0017a, t41[] t41VarArr) {
        for (int i = 0; i < t41VarArr.length; i++) {
            t41VarArr[i] = interfaceC0017a.d(t41VarArr[i]);
        }
    }

    public static wt[] L(int i) {
        return new wt[i];
    }

    public static t41[] N(rj0 rj0Var, Pattern pattern, t41 t41Var) {
        String str = rj0Var.b;
        if (str == null) {
            return new t41[]{t41Var};
        }
        String[] strArrG1 = fy4.G1(str, ";");
        t41[] t41VarArr = new t41[strArrG1.length];
        for (int i = 0; i < strArrG1.length; i++) {
            Matcher matcher = pattern.matcher(strArrG1[i]);
            if (!matcher.matches()) {
                return new t41[]{t41Var};
            }
            int i2 = Integer.parseInt(matcher.group(1));
            t41VarArr[i] = t41Var.b().k0(t41Var.a + ":" + i2).R(i2).o0(matcher.group(2)).Q();
        }
        return t41VarArr;
    }

    public static boolean p(g90 g90Var, int i, int[] iArr, ir4 ir4Var) {
        List list = g90Var.d(i).c;
        xi1.a aVarM = xi1.m();
        for (int i2 : iArr) {
            aVarM.j(((y3) list.get(i2)).c);
        }
        xi1 xi1VarK = aVarM.k();
        for (int i3 = 0; i3 < ir4Var.length(); i3++) {
            t41 t41Var = ((tq3) xi1VarK.get(ir4Var.i(i3))).b;
            if (!nt2.a(t41Var.p, t41Var.k)) {
                return false;
            }
        }
        return true;
    }

    public static void u(List list, br4[] br4VarArr, a[] aVarArr, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            iv0 iv0Var = (iv0) list.get(i2);
            br4VarArr[i] = new br4(iv0Var.a() + ":" + i2, new t41.b().k0(iv0Var.a()).A0("application/x-emsg").Q());
            aVarArr[i] = a.c(i2);
            i2++;
            i++;
        }
    }

    public static int v(xo0 xo0Var, a.InterfaceC0017a interfaceC0017a, List list, int[][] iArr, int i, boolean[] zArr, t41[][] t41VarArr, br4[] br4VarArr, a[] aVarArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int[] iArr2 = iArr[i4];
            ArrayList arrayList = new ArrayList();
            for (int i6 : iArr2) {
                arrayList.addAll(((y3) list.get(i6)).c);
            }
            int size = arrayList.size();
            t41[] t41VarArr2 = new t41[size];
            for (int i7 = 0; i7 < size; i7++) {
                t41 t41Var = ((tq3) arrayList.get(i7)).b;
                t41VarArr2[i7] = t41Var.b().Y(xo0Var.d(t41Var)).Q();
            }
            y3 y3Var = (y3) list.get(iArr2[0]);
            long j = y3Var.a;
            String string = j != -1 ? Long.toString(j) : "unset:" + i4;
            int i8 = i5 + 1;
            if (zArr[i4]) {
                i2 = i5 + 2;
            } else {
                i2 = i8;
                i8 = -1;
            }
            if (t41VarArr[i4].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            K(interfaceC0017a, t41VarArr2);
            br4VarArr[i5] = new br4(string, t41VarArr2);
            aVarArr[i5] = a.d(y3Var.b, iArr2, i5, i8, i2);
            if (i8 != -1) {
                String str = string + ":emsg";
                br4VarArr[i8] = new br4(str, new t41.b().k0(str).A0("application/x-emsg").w0(string).Q());
                aVarArr[i8] = a.b(iArr2, i5);
            }
            if (i2 != -1) {
                String str2 = string + ":cc";
                aVarArr[i2] = a.a(iArr2, i5, xi1.q(t41VarArr[i4]));
                K(interfaceC0017a, t41VarArr[i4]);
                int i9 = 0;
                while (true) {
                    t41[] t41VarArr3 = t41VarArr[i4];
                    if (i9 >= t41VarArr3.length) {
                        break;
                    }
                    t41VarArr3[i9] = t41VarArr3[i9].b().w0(string).Q();
                    i9++;
                }
                br4VarArr[i2] = new br4(str2, t41VarArr[i4]);
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    public static Pair x(xo0 xo0Var, a.InterfaceC0017a interfaceC0017a, List list, List list2) {
        int[][] iArrE = E(list);
        int length = iArrE.length;
        boolean[] zArr = new boolean[length];
        t41[][] t41VarArr = new t41[length][];
        int I2 = I(length, list, iArrE, zArr, t41VarArr) + length + list2.size();
        br4[] br4VarArr = new br4[I2];
        a[] aVarArr = new a[I2];
        u(list2, br4VarArr, aVarArr, v(xo0Var, interfaceC0017a, list, iArrE, length, zArr, t41VarArr, br4VarArr, aVarArr));
        return Pair.create(new er4(br4VarArr), aVarArr);
    }

    public static boolean y(y3 y3Var, y3 y3Var2) {
        if (y3Var.b != y3Var2.b) {
            return false;
        }
        if (y3Var.c.isEmpty() || y3Var2.c.isEmpty()) {
            return true;
        }
        t41 t41Var = ((tq3) y3Var.c.get(0)).b;
        t41 t41Var2 = ((tq3) y3Var2.c.get(0)).b;
        return Objects.equals(t41Var.d, t41Var2.d) && (t41Var.f & (-16385)) == (t41Var2.f & (-16385));
    }

    public static rj0 z(List list) {
        return A(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    public final int F(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.p[i2].e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.p[i5].c == 0) {
                return i4;
            }
        }
        return -1;
    }

    public final int[] G(jy0[] jy0VarArr) {
        int[] iArr = new int[jy0VarArr.length];
        for (int i = 0; i < jy0VarArr.length; i++) {
            jy0 jy0Var = jy0VarArr[i];
            if (jy0Var != null) {
                iArr[i] = this.o.d(jy0Var.c());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    public final boolean J() {
        for (wt wtVar : this.y) {
            if (wtVar.L()) {
                return true;
            }
        }
        return false;
    }

    @Override // i14.a
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void j(wt wtVar) {
        this.x.j(this);
    }

    public void O() {
        this.r.o();
        for (wt wtVar : this.y) {
            wtVar.U(this);
        }
        this.x = null;
    }

    public final void P(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr) {
        for (int i = 0; i < jy0VarArr.length; i++) {
            if (jy0VarArr[i] == null || !zArr[i]) {
                gx3 gx3Var = gx3VarArr[i];
                if (gx3Var instanceof wt) {
                    ((wt) gx3Var).U(this);
                } else if (gx3Var instanceof wt.a) {
                    ((wt.a) gx3Var).c();
                }
                gx3VarArr[i] = null;
            }
        }
    }

    public final void Q(jy0[] jy0VarArr, gx3[] gx3VarArr, int[] iArr) {
        boolean z;
        for (int i = 0; i < jy0VarArr.length; i++) {
            gx3 gx3Var = gx3VarArr[i];
            if ((gx3Var instanceof is0) || (gx3Var instanceof wt.a)) {
                int iF = F(i, iArr);
                if (iF == -1) {
                    z = gx3VarArr[i] instanceof is0;
                } else {
                    gx3 gx3Var2 = gx3VarArr[i];
                    z = (gx3Var2 instanceof wt.a) && ((wt.a) gx3Var2).f == gx3VarArr[iF];
                }
                if (!z) {
                    gx3 gx3Var3 = gx3VarArr[i];
                    if (gx3Var3 instanceof wt.a) {
                        ((wt.a) gx3Var3).c();
                    }
                    gx3VarArr[i] = null;
                }
            }
        }
    }

    public final void R(jy0[] jy0VarArr, gx3[] gx3VarArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < jy0VarArr.length; i++) {
            jy0 jy0Var = jy0VarArr[i];
            if (jy0Var != null) {
                gx3 gx3Var = gx3VarArr[i];
                if (gx3Var == null) {
                    zArr[i] = true;
                    a aVar = this.p[iArr[i]];
                    int i2 = aVar.c;
                    if (i2 == 0) {
                        gx3VarArr[i] = w(aVar, jy0Var, j);
                    } else if (i2 == 2) {
                        gx3VarArr[i] = new hv0((iv0) this.D.get(aVar.d), jy0Var.c().c(0), this.B.d);
                    }
                } else if (gx3Var instanceof wt) {
                    ((androidx.media3.exoplayer.dash.a) ((wt) gx3Var).G()).b(jy0Var);
                }
            }
        }
        for (int i3 = 0; i3 < jy0VarArr.length; i3++) {
            if (gx3VarArr[i3] == null && jy0VarArr[i3] != null) {
                a aVar2 = this.p[iArr[i3]];
                if (aVar2.c == 1) {
                    int iF = F(i3, iArr);
                    if (iF == -1) {
                        gx3VarArr[i3] = new is0();
                    } else {
                        gx3VarArr[i3] = ((wt) gx3VarArr[iF]).X(j, aVar2.b);
                    }
                }
            }
        }
    }

    public final void S(boolean z) {
        this.H = z;
        for (wt wtVar : this.y) {
            wtVar.Z(z);
        }
    }

    public final boolean T() {
        boolean zB = false;
        for (wt wtVar : this.y) {
            zB |= wtVar.B();
        }
        return zB;
    }

    public void U(g90 g90Var, int i) {
        this.B = g90Var;
        this.C = i;
        this.r.q(g90Var);
        wt[] wtVarArr = this.y;
        if (wtVarArr != null) {
            for (wt wtVar : wtVarArr) {
                ((androidx.media3.exoplayer.dash.a) wtVar.G()).c(g90Var, i);
            }
            this.x.j(this);
        }
        this.D = g90Var.d(i).d;
        for (hv0 hv0Var : this.z) {
            Iterator it = this.D.iterator();
            while (true) {
                if (it.hasNext()) {
                    iv0 iv0Var = (iv0) it.next();
                    if (iv0Var.a().equals(hv0Var.b())) {
                        hv0Var.d(iv0Var, g90Var.d && i == g90Var.e() - 1);
                    }
                }
            }
        }
    }

    @Override // wt.b
    public synchronized void a(wt wtVar) {
        d.c cVar = (d.c) this.s.remove(wtVar);
        if (cVar != null) {
            cVar.o();
        }
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        return this.A.b(jVar);
    }

    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return this.A.c();
    }

    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        for (wt wtVar : this.y) {
            if (wtVar.f == 2) {
                return wtVar.d(j, zz3Var);
            }
        }
        return j;
    }

    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return this.A.f();
    }

    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        for (wt wtVar : this.y) {
            if (!wtVar.isLoading()) {
                wtVar.F(this.B.g(this.C));
            }
        }
        this.A.g(j);
    }

    @Override // defpackage.mi2
    public long h(long j) throws Throwable {
        this.G = j;
        for (wt wtVar : this.y) {
            wtVar.Y(j);
        }
        return j;
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.A.isLoading();
    }

    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        int[] iArrG = G(jy0VarArr);
        P(jy0VarArr, zArr, gx3VarArr);
        Q(jy0VarArr, gx3VarArr, iArrG);
        R(jy0VarArr, gx3VarArr, zArr2, j, iArrG);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (gx3 gx3Var : gx3VarArr) {
            if (gx3Var instanceof wt) {
                arrayList.add((wt) gx3Var);
            } else if (gx3Var instanceof hv0) {
                arrayList2.add((hv0) gx3Var);
            }
        }
        wt[] wtVarArrL = L(arrayList.size());
        this.y = wtVarArrL;
        arrayList.toArray(wtVarArrL);
        hv0[] hv0VarArr = new hv0[arrayList2.size()];
        this.z = hv0VarArr;
        arrayList2.toArray(hv0VarArr);
        this.A = this.q.a(arrayList, ru1.i(arrayList, new p81() { // from class: j90
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return xi1.w(Integer.valueOf(((wt) obj).f));
            }
        }));
        if (this.E) {
            this.E = false;
            this.F = j;
            if (J()) {
                S(true);
            }
        }
        return j;
    }

    @Override // defpackage.mi2
    public void m() {
        this.m.a();
    }

    @Override // defpackage.mi2
    public long n(long j) throws Throwable {
        for (wt wtVar : this.y) {
            wtVar.W(j);
        }
        for (hv0 hv0Var : this.z) {
            hv0Var.c(j);
        }
        return j;
    }

    @Override // defpackage.mi2
    public long q() {
        if (!this.H) {
            return -9223372036854775807L;
        }
        boolean zT = T();
        if (!J()) {
            S(false);
        }
        if (zT) {
            return this.F;
        }
        return -9223372036854775807L;
    }

    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.x = aVar;
        aVar.e(this);
    }

    @Override // defpackage.mi2
    public er4 s() {
        return this.o;
    }

    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        for (wt wtVar : this.y) {
            wtVar.t(j, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.wt w(androidx.media3.exoplayer.dash.b.a r27, defpackage.jy0 r28, long r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.b.w(androidx.media3.exoplayer.dash.b$a, jy0, long):wt");
    }
}
