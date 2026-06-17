package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.exoplayer.j;
import defpackage.df1;
import defpackage.kf1;
import defpackage.mi2;
import defpackage.rq2;
import defpackage.sy1;
import defpackage.t41;
import defpackage.wo0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ve1 implements mi2, df1.b {
    public er4 A;
    public int E;
    public i14 F;
    public final pe1 f;
    public final df1 g;
    public final oe1 h;
    public final hs4 i;
    public final xo0 j;
    public final wo0.a k;
    public final sy1 l;
    public final rq2.a m;
    public final j5 n;
    public final qy q;
    public final boolean r;
    public final int s;
    public final boolean t;
    public final ie3 u;
    public final long w;
    public final xi4 x;
    public mi2.a y;
    public int z;
    public final kf1.b v = new b();
    public final IdentityHashMap o = new IdentityHashMap();
    public final zo4 p = new zo4();
    public kf1[] B = new kf1[0];
    public kf1[] C = new kf1[0];
    public int[][] D = new int[0][];
    public long G = Long.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements kf1.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: j(Li14;)V */
        @Override // i14.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(kf1 kf1Var) {
            ve1.this.y.j(ve1.this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kf1.b
        public void i() {
            if (ve1.j(ve1.this) > 0) {
                return;
            }
            int i = 0;
            for (kf1 kf1Var : ve1.this.B) {
                i += kf1Var.s().a;
            }
            br4[] br4VarArr = new br4[i];
            int i2 = 0;
            for (kf1 kf1Var2 : ve1.this.B) {
                int i3 = kf1Var2.s().a;
                int i4 = 0;
                while (i4 < i3) {
                    br4VarArr[i2] = kf1Var2.s().b(i4);
                    i4++;
                    i2++;
                }
            }
            ve1.this.A = new er4(br4VarArr);
            ve1.this.y.e(ve1.this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kf1.b
        public void l(Uri uri) {
            ve1.this.g.o(uri);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ve1(pe1 pe1Var, df1 df1Var, oe1 oe1Var, hs4 hs4Var, ev evVar, xo0 xo0Var, wo0.a aVar, sy1 sy1Var, rq2.a aVar2, j5 j5Var, qy qyVar, boolean z, int i, boolean z2, ie3 ie3Var, long j, xi4 xi4Var) {
        this.f = pe1Var;
        this.g = df1Var;
        this.h = oe1Var;
        this.i = hs4Var;
        this.j = xo0Var;
        this.k = aVar;
        this.l = sy1Var;
        this.m = aVar2;
        this.n = j5Var;
        this.q = qyVar;
        this.r = z;
        this.s = i;
        this.t = z2;
        this.u = ie3Var;
        this.w = j;
        this.x = xi4Var;
        this.F = qyVar.empty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t41 A(t41 t41Var, t41 t41Var2, boolean z) {
        xs2 xs2Var;
        int i;
        String str;
        String str2;
        List list;
        int i2;
        int i3;
        String str3;
        xi1 xi1VarU = xi1.u();
        if (t41Var2 != null) {
            str2 = t41Var2.k;
            xs2Var = t41Var2.l;
            i2 = t41Var2.H;
            i = t41Var2.e;
            i3 = t41Var2.f;
            str = t41Var2.d;
            str3 = t41Var2.b;
            list = t41Var2.c;
        } else {
            String strZ = fy4.Z(t41Var.k, 1);
            xs2Var = t41Var.l;
            if (z) {
                i2 = t41Var.H;
                i = t41Var.e;
                i3 = t41Var.f;
                str = t41Var.d;
                str3 = t41Var.b;
                str2 = strZ;
                list = t41Var.c;
            } else {
                i = 0;
                str = null;
                str2 = strZ;
                list = xi1VarU;
                i2 = -1;
                i3 = 0;
                str3 = null;
            }
        }
        return new t41.b().k0(t41Var.a).m0(str3).n0(list).X(t41Var.o).A0(nt2.g(str2)).V(str2).s0(xs2Var).T(z ? t41Var.h : -1).u0(z ? t41Var.i : -1).U(i2).C0(i).y0(i3).o0(str).Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map B(List list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            oo0 oo0VarW = (oo0) list.get(i);
            String str = oo0VarW.h;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                oo0 oo0Var = (oo0) arrayList.get(i2);
                if (TextUtils.equals(oo0Var.h, str)) {
                    oo0VarW = oo0VarW.w(oo0Var);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            map.put(str, oo0VarW);
        }
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t41 C(t41 t41Var) {
        String strZ = fy4.Z(t41Var.k, 2);
        return new t41.b().k0(t41Var.a).m0(t41Var.b).n0(t41Var.c).X(t41Var.o).A0(nt2.g(strZ)).V(strZ).s0(t41Var.l).T(t41Var.h).u0(t41Var.i).H0(t41Var.w).i0(t41Var.x).g0(t41Var.A).C0(t41Var.e).y0(t41Var.f).W(t41Var.F).Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int j(ve1 ve1Var) {
        int i = ve1Var.z - 1;
        ve1Var.z = i;
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D() {
        this.g.s(this);
        for (kf1 kf1Var : this.B) {
            kf1Var.k0();
        }
        this.y = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // df1.b
    public void a() {
        for (kf1 kf1Var : this.B) {
            kf1Var.g0();
        }
        this.y.j(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        if (this.A != null) {
            return this.F.b(jVar);
        }
        for (kf1 kf1Var : this.B) {
            kf1Var.D();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return this.F.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        for (kf1 kf1Var : this.C) {
            if (kf1Var.U()) {
                return kf1Var.d(j, zz3Var);
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // df1.b
    public boolean e(Uri uri, sy1.c cVar, boolean z) {
        boolean zF0 = false;
        for (kf1 kf1Var : this.B) {
            zF0 |= kf1Var.f0(uri, cVar, z);
        }
        this.y.j(this);
        return zF0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return this.F.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        this.F.g(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long h(long j) throws Throwable {
        this.G = j;
        for (kf1 kf1Var : this.B) {
            kf1Var.q0(j);
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.F.isLoading();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8  */
    @Override // defpackage.mi2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[jy0VarArr.length];
        int[] iArr2 = new int[jy0VarArr.length];
        for (int i = 0; i < jy0VarArr.length; i++) {
            gx3 gx3Var = gx3VarArr[i];
            iArr[i] = gx3Var == null ? -1 : ((Integer) this.o.get(gx3Var)).intValue();
            iArr2[i] = -1;
            jy0 jy0Var = jy0VarArr[i];
            if (jy0Var != null) {
                br4 br4VarC = jy0Var.c();
                int i2 = 0;
                while (true) {
                    kf1[] kf1VarArr = this.B;
                    if (i2 >= kf1VarArr.length) {
                        break;
                    }
                    if (kf1VarArr[i2].s().d(br4VarC) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.o.clear();
        int length = jy0VarArr.length;
        gx3[] gx3VarArr2 = new gx3[length];
        gx3[] gx3VarArr3 = new gx3[jy0VarArr.length];
        jy0[] jy0VarArr2 = new jy0[jy0VarArr.length];
        kf1[] kf1VarArr2 = new kf1[this.B.length];
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (i3 < this.B.length) {
            for (int i5 = 0; i5 < jy0VarArr.length; i5++) {
                jy0 jy0Var2 = null;
                gx3VarArr3[i5] = iArr[i5] == i3 ? gx3VarArr[i5] : null;
                if (iArr2[i5] == i3) {
                    jy0Var2 = jy0VarArr[i5];
                }
                jy0VarArr2[i5] = jy0Var2;
            }
            kf1 kf1Var = this.B[i3];
            int[] iArr3 = iArr;
            int i6 = i3;
            int i7 = i4;
            boolean zO0 = kf1Var.o0(jy0VarArr2, zArr, gx3VarArr3, zArr2, j, z);
            boolean z2 = false;
            for (int i8 = 0; i8 < jy0VarArr.length; i8++) {
                gx3 gx3Var2 = gx3VarArr3[i8];
                if (iArr2[i8] == i6) {
                    gg3.q(gx3Var2);
                    gx3VarArr2[i8] = gx3Var2;
                    this.o.put(gx3Var2, Integer.valueOf(i6));
                    z2 = true;
                } else if (iArr3[i8] == i6) {
                    gg3.v(gx3Var2 == null);
                }
            }
            if (z2) {
                kf1VarArr2[i7] = kf1Var;
                i4 = i7 + 1;
                if (i7 == 0) {
                    kf1Var.s0(true);
                    if (!zO0) {
                        kf1[] kf1VarArr3 = this.C;
                        if (kf1VarArr3.length == 0 || kf1Var != kf1VarArr3[0]) {
                            this.p.b();
                            z = true;
                        }
                    }
                } else {
                    kf1Var.s0(i6 < this.E);
                }
            } else {
                i4 = i7;
            }
            i3 = i6 + 1;
            iArr = iArr3;
        }
        System.arraycopy(gx3VarArr2, 0, gx3VarArr, 0, length);
        kf1[] kf1VarArr4 = (kf1[]) fy4.i1(kf1VarArr2, i4);
        this.C = kf1VarArr4;
        xi1 xi1VarQ = xi1.q(kf1VarArr4);
        this.F = this.q.a(xi1VarQ, ru1.i(xi1VarQ, new p81() { // from class: ue1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((kf1) obj).s().c();
            }
        }));
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void m() throws r83 {
        for (kf1 kf1Var : this.B) {
            kf1Var.m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long n(long j) {
        kf1[] kf1VarArr = this.C;
        if (kf1VarArr.length > 0) {
            boolean zN0 = kf1VarArr[0].n0(j, false);
            int i = 1;
            while (true) {
                kf1[] kf1VarArr2 = this.C;
                if (i >= kf1VarArr2.length) {
                    break;
                }
                kf1VarArr2[i].n0(j, zN0);
                i++;
            }
            if (zN0) {
                this.p.b();
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long q() {
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) throws Throwable {
        this.y = aVar;
        this.g.t(this);
        x(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public er4 s() {
        return (er4) gg3.q(this.A);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        for (kf1 kf1Var : this.C) {
            kf1Var.t(j, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(long j, List list, List list2, List list3, Map map) throws Throwable {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) gg3.q(((ef1) list.get(i)).a.c);
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (Objects.equals(str, ((ef1) list.get(i2)).a.c)) {
                        ef1 ef1Var = (ef1) list.get(i2);
                        t41 t41Var = ef1Var.a.a;
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(ef1Var);
                        arrayList2.add(t41Var);
                        z &= fy4.Y(t41Var.k, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                kf1 kf1VarZ = z(str2, 1, (ef1[]) arrayList.toArray((ef1[]) fy4.m(new ef1[0])), (t41[]) arrayList2.toArray(new t41[0]), null, Collections.EMPTY_LIST, map, j);
                list3.add(ll1.n(arrayList3));
                list2.add(kf1VarZ);
                if (this.r && z) {
                    kf1VarZ.i0(new br4[]{new br4(str2, (t41[]) arrayList2.toArray(new t41[0])), new br4(str2.concat(":id3"), new t41.b().k0("ID3").A0("application/id3").w0(str2).Q())}, 0, 1);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(List list, List list2, t41 t41Var, List list3, long j, List list4, List list5, Map map) throws Throwable {
        int i;
        boolean z;
        boolean z2;
        int size = list.size();
        int[] iArr = new int[size];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            t41 t41Var2 = ((ef1) list.get(i4)).a.a;
            if (t41Var2.x > 0 || fy4.Z(t41Var2.k, 2) != null) {
                iArr[i4] = 2;
                i2++;
            } else if (fy4.Z(t41Var2.k, 1) != null) {
                iArr[i4] = 1;
                i3++;
            } else {
                iArr[i4] = -1;
            }
        }
        if (i2 > 0) {
            i = i2;
            z2 = false;
            z = true;
        } else if (i3 < size) {
            i = size - i3;
            z = false;
            z2 = true;
        } else {
            i = size;
            z = false;
            z2 = false;
        }
        ef1[] ef1VarArr = new ef1[i];
        boolean z3 = z2;
        t41[] t41VarArr = new t41[i];
        int[] iArr2 = new int[i];
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            if ((!z || iArr[i6] == 2) && (!z3 || iArr[i6] != 1)) {
                ef1 ef1Var = (ef1) list.get(i6);
                ef1VarArr[i5] = ef1Var;
                t41VarArr[i5] = ef1Var.a.a;
                iArr2[i5] = i6;
                i5++;
            }
        }
        String str = t41VarArr[0].k;
        int iY = fy4.Y(str, 2);
        int iY2 = fy4.Y(str, 1);
        boolean z4 = (iY2 == 1 || (iY2 == 0 && list2.isEmpty())) && iY <= 1 && iY2 + iY > 0;
        kf1 kf1VarZ = z("main", (z || iY2 <= 0) ? 0 : 1, ef1VarArr, t41VarArr, t41Var, list3, map, j);
        list4.add(kf1VarZ);
        list5.add(iArr2);
        if (this.r && z4) {
            ArrayList arrayList = new ArrayList();
            if (iY > 0) {
                t41[] t41VarArr2 = new t41[i];
                for (int i7 = 0; i7 < i; i7++) {
                    t41VarArr2[i7] = C(t41VarArr[i7]);
                }
                arrayList.add(new br4("main", t41VarArr2));
                if (iY2 > 0 && (t41Var != null || list2.isEmpty())) {
                    arrayList.add(new br4("main:audio", A(t41VarArr[0], t41Var, false).b().w0("main").Q()));
                }
                if (list3 != null) {
                    for (int i8 = 0; i8 < list3.size(); i8++) {
                        arrayList.add(new br4("main:cc:" + i8, this.f.d((t41) list3.get(i8)).b().w0("main").Q()));
                    }
                }
            } else {
                t41[] t41VarArr3 = new t41[i];
                for (int i9 = 0; i9 < i; i9++) {
                    t41VarArr3[i9] = A(t41VarArr[i9], t41Var, true);
                }
                arrayList.add(new br4("main", t41VarArr3));
            }
            br4 br4Var = new br4("main:id3", new t41.b().k0("ID3").A0("application/id3").w0("main").Q());
            arrayList.add(br4Var);
            kf1VarZ.i0((br4[]) arrayList.toArray(new br4[0]), 0, arrayList.indexOf(br4Var));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(long j) throws Throwable {
        ve1 ve1Var;
        List list;
        long j2;
        kf1[] kf1VarArr;
        ze1 ze1Var = (ze1) gg3.q(this.g.k());
        Map mapB = this.t ? B(ze1Var.m) : Collections.EMPTY_MAP;
        List list2 = (List) gg3.q(this.g.g(0));
        List list3 = (List) gg3.q(this.g.g(2));
        List list4 = (List) gg3.q(this.g.g(3));
        boolean zIsEmpty = list2.isEmpty();
        this.z = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (zIsEmpty) {
            ve1Var = this;
            list = list3;
            j2 = j;
        } else {
            ve1Var = this;
            ve1Var.w(list2, list3, ze1Var.j, ze1Var.k, j, arrayList, arrayList2, mapB);
            list = list3;
            j2 = j;
            arrayList = arrayList;
            arrayList2 = arrayList2;
            mapB = mapB;
        }
        ve1Var.v(j2, list, arrayList, arrayList2, mapB);
        ve1Var.E = arrayList.size();
        ve1Var.y(j2, list4, arrayList, arrayList2, mapB);
        ve1Var.B = (kf1[]) arrayList.toArray(new kf1[0]);
        ve1Var.D = (int[][]) arrayList2.toArray(new int[0][]);
        ve1Var.z = ve1Var.B.length;
        int i = 0;
        while (true) {
            int i2 = ve1Var.E;
            kf1VarArr = ve1Var.B;
            if (i >= i2) {
                break;
            }
            kf1VarArr[i].s0(true);
            i++;
        }
        for (kf1 kf1Var : kf1VarArr) {
            kf1Var.D();
        }
        ve1Var.C = ve1Var.B;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(long j, List list, List list2, List list3, Map map) throws Throwable {
        List list4 = list;
        ArrayList arrayList = new ArrayList(list4.size());
        ArrayList arrayList2 = new ArrayList(list4.size());
        ArrayList arrayList3 = new ArrayList(list4.size());
        HashSet hashSet = new HashSet();
        int i = 0;
        int i2 = 0;
        while (i2 < list4.size()) {
            String str = (String) gg3.q(((ef1) list4.get(i2)).a.c);
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                for (int i3 = i; i3 < list4.size(); i3++) {
                    if (Objects.equals(str, ((ef1) list4.get(i3)).a.c)) {
                        ef1 ef1Var = (ef1) list4.get(i3);
                        arrayList3.add(Integer.valueOf(i3));
                        arrayList.add(ef1Var);
                        arrayList2.add(ef1Var.a.a);
                    }
                }
                String str2 = "subtitle:" + str;
                t41[] t41VarArr = (t41[]) arrayList2.toArray(new t41[i]);
                kf1 kf1VarZ = z(str2, 3, (ef1[]) arrayList.toArray((ef1[]) fy4.m(new ef1[i])), t41VarArr, null, xi1.u(), map, j);
                list3.add(ll1.n(arrayList3));
                list2.add(kf1VarZ);
                int length = t41VarArr.length;
                t41[] t41VarArr2 = new t41[length];
                for (int i4 = i; i4 < length; i4++) {
                    t41VarArr2[i4] = this.f.d(t41VarArr[i4]);
                }
                i = 0;
                kf1VarZ.i0(new br4[]{new br4(str2, t41VarArr2)}, 0, new int[0]);
            }
            i2++;
            list4 = list;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final kf1 z(String str, int i, ef1[] ef1VarArr, t41[] t41VarArr, t41 t41Var, List list, Map map, long j) throws Throwable {
        ne1 ne1Var = new ne1(this.f, this.g, ef1VarArr, t41VarArr, this.h, this.i, this.p, this.w, list, this.u, null);
        kf1.b bVar = this.v;
        j5 j5Var = this.n;
        xo0 xo0Var = this.j;
        wo0.a aVar = this.k;
        sy1 sy1Var = this.l;
        rq2.a aVar2 = this.m;
        int i2 = this.s;
        xi4 xi4Var = this.x;
        kf1 kf1Var = new kf1(str, i, bVar, ne1Var, map, j5Var, j, t41Var, xo0Var, aVar, sy1Var, aVar2, i2, xi4Var != null ? (eq3) xi4Var.get() : null);
        kf1Var.q0(this.G);
        return kf1Var;
    }
}
