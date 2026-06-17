package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.ex3;
import defpackage.gr4;
import defpackage.i14;
import defpackage.ne1;
import defpackage.rq2;
import defpackage.sy1;
import defpackage.t41;
import defpackage.wo0;
import defpackage.xi1;
import defpackage.xs2;
import defpackage.xy1;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kf1 implements xy1.b, xy1.f, i14, mz0, ex3.d {
    public static final Set e0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public d[] A;
    public int[] B;
    public Set C;
    public SparseIntArray D;
    public gr4 E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public int J;
    public t41 K;
    public t41 L;
    public boolean M;
    public er4 N;
    public Set O;
    public int[] P;
    public int Q;
    public boolean R;
    public boolean[] S;
    public boolean[] T;
    public long U;
    public long V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public long Z;
    public boolean a0;
    public long b0;
    public oo0 c0;
    public se1 d0;
    public final String f;
    public final int g;
    public final b h;
    public final ne1 i;
    public final j5 j;
    public final t41 k;
    public final xo0 l;
    public final wo0.a m;
    public final sy1 n;
    public final xy1 o;
    public final rq2.a p;
    public final int q;
    public final ne1.b r;
    public final ArrayList s;
    public final List t;
    public final Runnable u;
    public final Runnable v;
    public final Handler w;
    public final ArrayList x;
    public final Map y;
    public pt z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b extends i14.a {
        void i();

        void l(Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements gr4 {
        public static final t41 g = new t41.b().A0("application/id3").Q();
        public static final t41 h = new t41.b().A0("application/x-emsg").Q();
        public final ev0 a = new ev0();
        public final gr4 b;
        public final t41 c;
        public t41 d;
        public byte[] e;
        public int f;

        public c(gr4 gr4Var, int i) {
            this.b = gr4Var;
            if (i == 1) {
                this.c = g;
            } else {
                if (i != 3) {
                    defpackage.b.a("Unknown metadataType: ", i);
                    throw null;
                }
                this.c = h;
            }
            this.e = new byte[0];
            this.f = 0;
        }

        @Override // defpackage.gr4
        public void b(long j, int i, int i2, int i3, gr4.a aVar) {
            gg3.q(this.d);
            r73 r73VarJ = j(i2, i3);
            if (!Objects.equals(this.d.p, this.c.p)) {
                if (!"application/x-emsg".equals(this.d.p)) {
                    xz1.i("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.d.p);
                    return;
                } else {
                    dv0 dv0VarC = this.a.c(r73VarJ);
                    if (!h(dv0VarC)) {
                        xz1.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.c.p, dv0VarC.a()));
                        return;
                    }
                    r73VarJ = new r73((byte[]) gg3.q(dv0VarC.c()));
                }
            }
            int iA = r73VarJ.a();
            this.b.a(r73VarJ, iA);
            this.b.b(j, i, iA, 0, aVar);
        }

        @Override // defpackage.gr4
        public void c(r73 r73Var, int i, int i2) {
            i(this.f + i);
            r73Var.u(this.e, this.f, i);
            this.f += i;
        }

        @Override // defpackage.gr4
        public int f(x90 x90Var, int i, boolean z, int i2) throws EOFException {
            i(this.f + i);
            int i3 = x90Var.read(this.e, this.f, i);
            if (i3 != -1) {
                this.f += i3;
                return i3;
            }
            if (z) {
                return -1;
            }
            ll.a();
            return 0;
        }

        @Override // defpackage.gr4
        public void g(t41 t41Var) {
            this.d = t41Var;
            this.b.g(this.c);
        }

        public final boolean h(dv0 dv0Var) {
            t41 t41VarA = dv0Var.a();
            return t41VarA != null && Objects.equals(this.c.p, t41VarA.p);
        }

        public final void i(int i) {
            byte[] bArr = this.e;
            if (bArr.length < i) {
                this.e = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        public final r73 j(int i, int i2) {
            int i3 = this.f - i2;
            r73 r73Var = new r73(Arrays.copyOfRange(this.e, i3 - i, i3));
            byte[] bArr = this.e;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.f = i2;
            return r73Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends ex3 {
        public final Map J;
        public oo0 K;

        public d(j5 j5Var, xo0 xo0Var, wo0.a aVar, Map map) {
            super(j5Var, xo0Var, aVar);
            this.J = map;
        }

        @Override // defpackage.ex3
        public t41 A(t41 t41Var) {
            oo0 oo0Var;
            oo0 oo0Var2 = this.K;
            if (oo0Var2 == null) {
                oo0Var2 = t41Var.t;
            }
            if (oo0Var2 != null && (oo0Var = (oo0) this.J.get(oo0Var2.h)) != null) {
                oo0Var2 = oo0Var;
            }
            xs2 xs2VarM0 = m0(t41Var.l);
            if (oo0Var2 != t41Var.t || xs2VarM0 != t41Var.l) {
                t41Var = t41Var.b().d0(oo0Var2).s0(xs2VarM0).Q();
            }
            return super.A(t41Var);
        }

        @Override // defpackage.ex3, defpackage.gr4
        public void b(long j, int i, int i2, int i3, gr4.a aVar) {
            super.b(j, i, i2, i3, aVar);
        }

        public final xs2 m0(xs2 xs2Var) {
            if (xs2Var == null) {
                return null;
            }
            int iJ = xs2Var.j();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= iJ) {
                    i2 = -1;
                    break;
                }
                xs2.a aVarE = xs2Var.e(i2);
                if ((aVarE instanceof wg3) && "com.apple.streaming.transportStreamTimestamp".equals(((wg3) aVarE).b)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return xs2Var;
            }
            if (iJ == 1) {
                return null;
            }
            xs2.a[] aVarArr = new xs2.a[iJ - 1];
            while (i < iJ) {
                if (i != i2) {
                    aVarArr[i < i2 ? i : i - 1] = xs2Var.e(i);
                }
                i++;
            }
            return new xs2(aVarArr);
        }

        public void n0(oo0 oo0Var) {
            this.K = oo0Var;
            N();
        }

        public void o0(se1 se1Var) {
            k0(se1Var.k);
        }
    }

    public kf1(String str, int i, b bVar, ne1 ne1Var, Map map, j5 j5Var, long j, t41 t41Var, xo0 xo0Var, wo0.a aVar, sy1 sy1Var, rq2.a aVar2, int i2, eq3 eq3Var) {
        this.f = str;
        this.g = i;
        this.h = bVar;
        this.i = ne1Var;
        this.y = map;
        this.j = j5Var;
        this.k = t41Var;
        this.l = xo0Var;
        this.m = aVar;
        this.n = sy1Var;
        this.p = aVar2;
        this.q = i2;
        this.o = eq3Var != null ? new xy1(eq3Var) : new xy1("Loader:HlsSampleStreamWrapper");
        this.r = new ne1.b();
        this.B = new int[0];
        Set set = e0;
        this.C = new HashSet(set.size());
        this.D = new SparseIntArray(set.size());
        this.A = new d[0];
        this.T = new boolean[0];
        this.S = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        this.t = Collections.unmodifiableList(arrayList);
        this.x = new ArrayList();
        this.u = new Runnable() { // from class: gf1
            @Override // java.lang.Runnable
            public final void run() {
                this.f.X();
            }
        };
        this.v = new Runnable() { // from class: hf1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f.h0();
            }
        };
        this.w = fy4.E();
        this.U = j;
        this.V = j;
        this.Z = Long.MIN_VALUE;
    }

    public static wl0 E(int i, int i2) {
        xz1.i("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new wl0();
    }

    public static t41 H(t41 t41Var, t41 t41Var2, boolean z) {
        String strD;
        String strG;
        if (t41Var == null) {
            return t41Var2;
        }
        int iK = nt2.k(t41Var2.p);
        int iY = fy4.Y(t41Var.k, iK);
        String str = t41Var.k;
        if (iY == 1) {
            strD = fy4.Z(str, iK);
            strG = nt2.g(strD);
        } else {
            strD = nt2.d(str, t41Var2.p);
            strG = t41Var2.p;
        }
        t41.b bVarV = t41Var2.b().k0(t41Var.a).m0(t41Var.b).n0(t41Var.c).o0(t41Var.d).C0(t41Var.e).y0(t41Var.f).T(z ? t41Var.h : -1).u0(z ? t41Var.i : -1).V(strD);
        if (iK == 2) {
            bVarV.H0(t41Var.w).i0(t41Var.x).g0(t41Var.A);
        }
        if (strG != null) {
            bVarV.A0(strG);
        }
        int i = t41Var.H;
        if (i != -1 && iK == 1) {
            bVarV.U(i);
        }
        xs2 xs2VarB = t41Var.l;
        if (xs2VarB != null) {
            xs2 xs2Var = t41Var2.l;
            if (xs2Var != null) {
                xs2VarB = xs2Var.b(xs2VarB);
            }
            bVarV.s0(xs2VarB);
        }
        return bVarV.Q();
    }

    public static boolean L(t41 t41Var, t41 t41Var2) {
        String str = t41Var.p;
        String str2 = t41Var2.p;
        int iK = nt2.k(str);
        if (iK != 3) {
            return iK == nt2.k(str2);
        }
        if (Objects.equals(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || t41Var.M == t41Var2.M;
        }
        return false;
    }

    public static int O(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public static boolean R(pt ptVar) {
        return ptVar instanceof se1;
    }

    private boolean S() {
        return this.V != -9223372036854775807L;
    }

    public int A(int i) {
        z();
        gg3.q(this.P);
        int i2 = this.P[i];
        if (i2 == -1) {
            return this.O.contains(this.N.b(i)) ? -3 : -2;
        }
        boolean[] zArr = this.S;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public final void B() {
        t41 t41Var;
        int length = this.A.length;
        int i = -2;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = ((t41) gg3.q(this.A[i3].J())).p;
            int i4 = nt2.t(str) ? 2 : nt2.o(str) ? 1 : nt2.s(str) ? 3 : -2;
            if (O(i4) > O(i)) {
                i2 = i3;
                i = i4;
            } else if (i4 == i && i2 != -1) {
                i2 = -1;
            }
            i3++;
        }
        br4 br4VarN = this.i.n();
        int i5 = br4VarN.a;
        this.Q = -1;
        this.P = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.P[i6] = i6;
        }
        br4[] br4VarArr = new br4[length];
        int i7 = 0;
        while (i7 < length) {
            t41 t41Var2 = (t41) gg3.q(this.A[i7].J());
            if (i7 == i2) {
                t41[] t41VarArr = new t41[i5];
                for (int i8 = 0; i8 < i5; i8++) {
                    t41 t41VarC = br4VarN.c(i8);
                    if (i == 1 && (t41Var = this.k) != null) {
                        t41VarC = t41VarC.m(t41Var);
                    }
                    t41VarArr[i8] = i5 == 1 ? t41Var2.m(t41VarC) : H(t41VarC, t41Var2, true);
                }
                br4VarArr[i7] = new br4(this.f, t41VarArr);
                this.Q = i7;
            } else {
                t41 t41Var3 = (i == 2 && nt2.o(t41Var2.p)) ? this.k : null;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f);
                sb.append(":muxed:");
                sb.append(i7 < i2 ? i7 : i7 - 1);
                br4VarArr[i7] = new br4(sb.toString(), H(t41Var3, t41Var2, false).b().w0(this.f).Q());
            }
            i7++;
        }
        this.N = G(br4VarArr);
        gg3.v(this.O == null);
        this.O = Collections.EMPTY_SET;
    }

    public final boolean C(int i) {
        int i2 = i;
        while (true) {
            int size = this.s.size();
            ArrayList arrayList = this.s;
            if (i2 >= size) {
                se1 se1Var = (se1) arrayList.get(i);
                for (int i3 = 0; i3 < this.A.length; i3++) {
                    if (this.A[i3].G() > se1Var.o(i3)) {
                        return false;
                    }
                }
                return true;
            }
            if (((se1) arrayList.get(i2)).y()) {
                return false;
            }
            i2++;
        }
    }

    public void D() {
        if (this.I) {
            return;
        }
        b(new j.b().f(this.U).d());
    }

    public final ex3 F(int i, int i2) {
        int length = this.A.length;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        d dVar = new d(this.j, this.l, this.m, this.y);
        dVar.g0(this.U);
        if (z) {
            dVar.n0(this.c0);
        }
        dVar.f0(this.b0);
        se1 se1Var = this.d0;
        if (se1Var != null) {
            dVar.o0(se1Var);
        }
        dVar.i0(this);
        int i3 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.B, i3);
        this.B = iArrCopyOf;
        iArrCopyOf[length] = i;
        this.A = (d[]) fy4.g1(this.A, dVar);
        boolean[] zArrCopyOf = Arrays.copyOf(this.T, i3);
        this.T = zArrCopyOf;
        zArrCopyOf[length] = z;
        this.R |= z;
        this.C.add(Integer.valueOf(i2));
        this.D.append(i2, length);
        if (O(i2) > O(this.F)) {
            this.G = length;
            this.F = i2;
        }
        this.S = Arrays.copyOf(this.S, i3);
        return dVar;
    }

    public final er4 G(br4[] br4VarArr) {
        for (int i = 0; i < br4VarArr.length; i++) {
            br4 br4Var = br4VarArr[i];
            t41[] t41VarArr = new t41[br4Var.a];
            for (int i2 = 0; i2 < br4Var.a; i2++) {
                t41 t41VarC = br4Var.c(i2);
                t41VarArr[i2] = t41VarC.c(this.l.d(t41VarC));
            }
            br4VarArr[i] = new br4(br4Var.b, t41VarArr);
        }
        return new er4(br4VarArr);
    }

    public final void I(int i) {
        gg3.v(!this.o.j());
        while (true) {
            if (i >= this.s.size()) {
                i = -1;
                break;
            } else if (C(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = M().h;
        se1 se1VarJ = J(i);
        if (this.s.isEmpty()) {
            this.V = this.U;
        } else {
            ((se1) km1.d(this.s)).r();
        }
        this.Y = false;
        this.p.y(this.F, se1VarJ.g, j);
    }

    public final se1 J(int i) {
        se1 se1Var = (se1) this.s.get(i);
        ArrayList arrayList = this.s;
        fy4.s1(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.A.length; i2++) {
            this.A[i2].x(se1Var.o(i2));
        }
        return se1Var;
    }

    public final boolean K(se1 se1Var) {
        int i = se1Var.k;
        int length = this.A.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.S[i2] && this.A[i2].U() == i) {
                return false;
            }
        }
        return true;
    }

    public final se1 M() {
        return (se1) this.s.get(r1.size() - 1);
    }

    public final gr4 N(int i, int i2) {
        gg3.d(e0.contains(Integer.valueOf(i2)));
        int i3 = this.D.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.C.add(Integer.valueOf(i2))) {
            this.B[i3] = i;
        }
        return this.B[i3] == i ? this.A[i3] : E(i, i2);
    }

    public final boolean P() {
        int i = 0;
        if (!this.H || this.Z == Long.MIN_VALUE) {
            return false;
        }
        boolean zM = true;
        while (true) {
            d[] dVarArr = this.A;
            if (i >= dVarArr.length) {
                return zM;
            }
            if (this.S[i] && (this.T[i] || !this.R)) {
                zM &= dVarArr[i].M();
            }
            i++;
        }
    }

    public final void Q(se1 se1Var) {
        this.d0 = se1Var;
        this.K = se1Var.d;
        this.V = -9223372036854775807L;
        this.s.add(se1Var);
        xi1.a aVarM = xi1.m();
        for (d dVar : this.A) {
            aVarM.a(Integer.valueOf(dVar.K()));
        }
        se1Var.q(this, aVarM.k());
        for (d dVar2 : this.A) {
            dVar2.o0(se1Var);
            if (se1Var.y()) {
                dVar2.l0();
            }
        }
    }

    public boolean T(int i) {
        return !S() && this.A[i].P(this.Y);
    }

    public boolean U() {
        return this.F == 2;
    }

    public final void V() {
        int i = this.N.a;
        int[] iArr = new int[i];
        this.P = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                d[] dVarArr = this.A;
                if (i3 >= dVarArr.length) {
                    break;
                }
                if (L((t41) gg3.q(dVarArr[i3].J()), this.N.b(i2).c(0))) {
                    this.P[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((ff1) it.next()).b();
        }
    }

    public final void W(se1 se1Var) {
        if (this.s.isEmpty()) {
            return;
        }
        if (!M().s()) {
            I(this.s.size() - 1);
        }
        if (se1Var.n && se1Var.y()) {
            for (int size = this.s.size() - 1; size >= 0; size--) {
                long j = ((se1) this.s.get(size)).g;
                long j2 = se1Var.g;
                if (j < j2) {
                    return;
                }
                if (j == j2 && C(size)) {
                    I(size);
                    se1Var.k();
                    return;
                }
            }
        }
    }

    public final void X() {
        if (!this.M && this.P == null && this.H) {
            for (d dVar : this.A) {
                if (dVar.J() == null) {
                    return;
                }
            }
            if (this.N != null) {
                V();
                return;
            }
            B();
            r0();
            this.h.i();
        }
    }

    public void Y() {
        this.o.a();
        this.i.s();
    }

    public void Z(int i) {
        Y();
        this.A[i].R();
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void j(pt ptVar, long j, long j2, boolean z) {
        this.z = null;
        ty1 ty1Var = new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, ptVar.a());
        this.n.c(ptVar.a);
        this.p.m(ty1Var, ptVar.c, this.g, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h);
        if (z) {
            return;
        }
        if (S() || this.J == 0) {
            l0();
        }
        if (this.J > 0) {
            this.h.j(this);
        }
    }

    @Override // defpackage.i14
    public boolean b(j jVar) {
        List list;
        long j;
        long j2;
        if (this.Y || this.o.j() || this.o.i()) {
            return false;
        }
        if (S()) {
            List list2 = Collections.EMPTY_LIST;
            long j3 = this.V;
            for (d dVar : this.A) {
                dVar.g0(this.V);
            }
            list = list2;
            j = j3;
            j2 = j;
        } else {
            List list3 = this.t;
            se1 se1VarM = M();
            long jP = (se1VarM.h() && se1VarM.s()) ? se1VarM.p() : Math.max(this.U, se1VarM.g);
            long jMax = this.U;
            if (this.H) {
                for (d dVar2 : this.A) {
                    jMax = Math.max(jMax, dVar2.E());
                }
            }
            list = list3;
            j = jP;
            j2 = jMax;
        }
        this.r.a();
        this.i.h(jVar, j, j2, list, this.I || !list.isEmpty(), this.r);
        ne1.b bVar = this.r;
        boolean z = bVar.b;
        pt ptVar = bVar.a;
        Uri uri = bVar.c;
        if (z) {
            this.V = -9223372036854775807L;
            this.Y = true;
            return true;
        }
        if (ptVar == null) {
            if (uri != null) {
                this.h.l(uri);
            }
            return false;
        }
        if (R(ptVar)) {
            se1 se1Var = (se1) ptVar;
            W(se1Var);
            Q(se1Var);
        }
        this.z = ptVar;
        this.o.n(ptVar, this, this.n.d(ptVar.c));
        return true;
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void l(pt ptVar, long j, long j2) {
        this.z = null;
        this.i.v(ptVar);
        ty1 ty1Var = new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, ptVar.a());
        this.n.c(ptVar.a);
        this.p.p(ty1Var, ptVar.c, this.g, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h);
        if (this.I) {
            this.h.j(this);
        } else {
            b(new j.b().f(this.U).d());
        }
    }

    @Override // defpackage.i14
    public long c() {
        if (S()) {
            return this.V;
        }
        if (this.Y) {
            return Long.MIN_VALUE;
        }
        return M().h;
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public xy1.c v(pt ptVar, long j, long j2, IOException iOException, int i) {
        xy1.c cVarH;
        int i2;
        boolean zR = R(ptVar);
        if (zR && !((se1) ptVar).s() && (iOException instanceof og1) && ((i2 = ((og1) iOException).i) == 410 || i2 == 404)) {
            return xy1.d;
        }
        long jA = ptVar.a();
        ty1 ty1Var = new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, jA);
        sy1.c cVar = new sy1.c(ty1Var, new oh2(ptVar.c, this.g, ptVar.d, ptVar.e, ptVar.f, fy4.S1(ptVar.g), fy4.S1(ptVar.h)), iOException, i);
        boolean zU = this.i.u(ptVar, this.n.b(this.i.a(ptVar), cVar));
        if (zU) {
            if (zR && jA == 0) {
                ArrayList arrayList = this.s;
                gg3.v(((se1) arrayList.remove(arrayList.size() - 1)) == ptVar);
                if (this.s.isEmpty()) {
                    this.V = this.U;
                } else {
                    ((se1) km1.d(this.s)).r();
                }
            }
            cVarH = xy1.f;
        } else {
            long jA2 = this.n.a(cVar);
            cVarH = jA2 != -9223372036854775807L ? xy1.h(false, jA2) : xy1.g;
        }
        xy1.c cVar2 = cVarH;
        boolean zC = cVar2.c();
        this.p.r(ty1Var, ptVar.c, this.g, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h, iOException, !zC);
        if (!zC) {
            this.z = null;
            this.n.c(ptVar.a);
        }
        if (zU) {
            if (!this.I) {
                b(new j.b().f(this.U).d());
                return cVar2;
            }
            this.h.j(this);
        }
        return cVar2;
    }

    public long d(long j, zz3 zz3Var) {
        return this.i.e(j, zz3Var);
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void p(pt ptVar, long j, long j2, int i) {
        this.p.v(i == 0 ? new ty1(ptVar.a, ptVar.b, j) : new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, ptVar.a()), ptVar.c, this.g, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h, i);
    }

    @Override // defpackage.mz0
    public gr4 e(int i, int i2) {
        gr4 gr4VarF;
        if (!e0.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                gr4[] gr4VarArr = this.A;
                if (i3 >= gr4VarArr.length) {
                    gr4VarF = null;
                    break;
                }
                if (this.B[i3] == i) {
                    gr4VarF = gr4VarArr[i3];
                    break;
                }
                i3++;
            }
        } else {
            gr4VarF = N(i, i2);
        }
        if (gr4VarF == null) {
            if (this.a0) {
                return E(i, i2);
            }
            gr4VarF = F(i, i2);
        }
        if (i2 != 5) {
            return gr4VarF;
        }
        if (this.E == null) {
            this.E = new c(gr4VarF, this.q);
        }
        return this.E;
    }

    public void e0() {
        this.C.clear();
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    @Override // defpackage.i14
    public long f() {
        /*
            r6 = this;
            boolean r0 = r6.Y
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r6.S()
            if (r0 == 0) goto L10
            long r0 = r6.V
            return r0
        L10:
            long r0 = r6.U
            se1 r2 = r6.M()
            boolean r3 = r2.h()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList r2 = r6.s
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList r2 = r6.s
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            se1 r2 = (defpackage.se1) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r6.H
            if (r2 == 0) goto L55
            kf1$d[] r6 = r6.A
            int r2 = r6.length
            r3 = 0
        L46:
            if (r3 >= r2) goto L55
            r4 = r6[r3]
            long r4 = r4.D()
            long r0 = java.lang.Math.max(r0, r4)
            int r3 = r3 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kf1.f():long");
    }

    public boolean f0(Uri uri, sy1.c cVar, boolean z) {
        sy1.b bVarB;
        if (!this.i.t(uri)) {
            return false;
        }
        if (z) {
            bVarB = null;
        } else {
            bVarB = this.n.b(this.i.b(uri), cVar);
        }
        return this.i.w(uri, bVarB);
    }

    @Override // defpackage.i14
    public void g(long j) {
        if (this.o.i() || S()) {
            return;
        }
        if (this.o.j()) {
            gg3.q(this.z);
            if (this.i.B(j, this.z, this.t)) {
                this.o.f();
                return;
            }
            return;
        }
        int size = this.t.size();
        while (size > 0 && this.i.f((se1) this.t.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.t.size()) {
            I(size);
        }
        int iK = this.i.k(j, this.t);
        if (iK < this.s.size()) {
            I(iK);
        }
        if (P()) {
            this.Y = true;
        }
    }

    public void g0() {
        if (this.s.isEmpty()) {
            return;
        }
        final se1 se1Var = (se1) km1.d(this.s);
        int iF = this.i.f(se1Var);
        if (iF == 1) {
            if (se1Var.s()) {
                return;
            }
            se1Var.x(this.i.l(se1Var));
        } else if (iF == 0) {
            this.w.post(new Runnable() { // from class: if1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.h.l(se1Var.m);
                }
            });
        } else if (iF == 2 && !this.Y && this.o.j()) {
            this.o.f();
        }
    }

    public final void h0() throws Throwable {
        for (d dVar : this.A) {
            dVar.e0(this.Z);
        }
        this.H = true;
        X();
    }

    @Override // xy1.f
    public void i() {
        for (d dVar : this.A) {
            dVar.X();
        }
    }

    public void i0(br4[] br4VarArr, int i, int... iArr) {
        this.N = G(br4VarArr);
        this.O = new HashSet();
        for (int i2 : iArr) {
            this.O.add(this.N.b(i2));
        }
        this.Q = i;
        Handler handler = this.w;
        final b bVar = this.h;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: jf1
            @Override // java.lang.Runnable
            public final void run() {
                bVar.i();
            }
        });
        r0();
    }

    @Override // defpackage.i14
    public boolean isLoading() {
        return this.o.j();
    }

    public int j0(int i, u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (S()) {
            return -3;
        }
        int i3 = 0;
        if (!this.s.isEmpty()) {
            int i4 = 0;
            while (i4 < this.s.size() - 1 && K((se1) this.s.get(i4))) {
                i4++;
            }
            fy4.s1(this.s, 0, i4);
            se1 se1Var = (se1) this.s.get(0);
            t41 t41Var = se1Var.d;
            if (!t41Var.equals(this.L)) {
                this.p.j(this.g, t41Var, se1Var.e, se1Var.f, se1Var.g);
            }
            this.L = t41Var;
        }
        if (!this.s.isEmpty() && !((se1) this.s.get(0)).s()) {
            return -3;
        }
        int iW = this.A[i].W(u41Var, decoderInputBuffer, i2, this.Y);
        if (iW == -5) {
            t41 t41VarM = (t41) gg3.q(u41Var.b);
            if (i == this.G) {
                int iE = ll1.e(this.A[i].U());
                while (i3 < this.s.size() && ((se1) this.s.get(i3)).k != iE) {
                    i3++;
                }
                t41VarM = t41VarM.m(i3 < this.s.size() ? ((se1) this.s.get(i3)).d : (t41) gg3.q(this.K));
            }
            u41Var.b = t41VarM;
        }
        return iW;
    }

    public void k0() {
        if (this.I) {
            for (d dVar : this.A) {
                dVar.V();
            }
        }
        this.i.x();
        this.o.m(this);
        this.w.removeCallbacksAndMessages(null);
        this.M = true;
        this.x.clear();
    }

    public final void l0() {
        for (d dVar : this.A) {
            dVar.a0(this.W);
        }
        this.W = false;
    }

    public void m() throws r83 {
        Y();
        if (this.Y && !this.I) {
            throw r83.a("Loading finished before preparation is complete.", null);
        }
    }

    public final boolean m0(long j, se1 se1Var) throws Throwable {
        boolean zD0;
        int length = this.A.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            d dVar = this.A[i];
            if (se1Var != null) {
                zD0 = dVar.c0(se1Var.o(i));
            } else {
                long jC = c();
                if (jC != Long.MIN_VALUE && j >= jC) {
                    z = false;
                }
                zD0 = dVar.d0(j, z);
            }
            if (!zD0 && (this.T[i] || !this.R)) {
                break;
            }
            i++;
        }
        return false;
    }

    public boolean n0(long j, boolean z) {
        se1 se1Var;
        this.U = j;
        if (S()) {
            this.V = j;
            return true;
        }
        if (this.i.p()) {
            for (int i = 0; i < this.s.size(); i++) {
                se1Var = (se1) this.s.get(i);
                if (se1Var.g == j) {
                    break;
                }
            }
            se1Var = null;
        } else {
            se1Var = null;
        }
        if (this.H && !z && !this.s.isEmpty() && m0(j, se1Var)) {
            return false;
        }
        this.V = j;
        this.Y = false;
        this.s.clear();
        if (this.o.j()) {
            if (this.H) {
                for (d dVar : this.A) {
                    dVar.t();
                }
            }
            this.o.f();
        } else {
            this.o.g();
            l0();
        }
        return true;
    }

    @Override // defpackage.mz0
    public void o() {
        this.a0 = true;
        this.w.post(this.v);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o0(defpackage.jy0[] r14, boolean[] r15, defpackage.gx3[] r16, boolean[] r17, long r18, boolean r20) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kf1.o0(jy0[], boolean[], gx3[], boolean[], long, boolean):boolean");
    }

    public void p0(oo0 oo0Var) {
        if (Objects.equals(this.c0, oo0Var)) {
            return;
        }
        this.c0 = oo0Var;
        int i = 0;
        while (true) {
            d[] dVarArr = this.A;
            if (i >= dVarArr.length) {
                return;
            }
            if (this.T[i]) {
                dVarArr[i].n0(oo0Var);
            }
            i++;
        }
    }

    public void q0(long j) throws Throwable {
        this.Z = j;
        if (this.H) {
            for (d dVar : this.A) {
                dVar.e0(j);
            }
        }
    }

    public final void r0() {
        this.I = true;
    }

    public er4 s() {
        z();
        return this.N;
    }

    public void s0(boolean z) {
        this.i.z(z);
    }

    public void t(long j, boolean z) {
        if (!this.H || S()) {
            return;
        }
        int length = this.A.length;
        for (int i = 0; i < length; i++) {
            this.A[i].s(j, z, this.S[i]);
        }
    }

    public void t0(long j) {
        if (this.b0 != j) {
            this.b0 = j;
            for (d dVar : this.A) {
                dVar.f0(j);
            }
        }
    }

    @Override // defpackage.mz0
    public void u(yz3 yz3Var) {
    }

    public int u0(int i, long j) throws Throwable {
        if (S()) {
            return 0;
        }
        d dVar = this.A[i];
        int I = dVar.I(j, this.Y);
        se1 se1Var = (se1) km1.e(this.s, null);
        if (se1Var != null && !se1Var.s()) {
            I = Math.min(I, se1Var.o(i) - dVar.G());
        }
        dVar.j0(I);
        return I;
    }

    public void v0(int i) {
        z();
        gg3.q(this.P);
        int i2 = this.P[i];
        if (i2 >= 0) {
            gg3.v(this.S[i2]);
            this.S[i2] = false;
        }
    }

    @Override // ex3.d
    public void w(t41 t41Var) {
        this.w.post(this.u);
    }

    public final void w0(gx3[] gx3VarArr) {
        this.x.clear();
        for (gx3 gx3Var : gx3VarArr) {
            if (gx3Var != null) {
                this.x.add((ff1) gx3Var);
            }
        }
    }

    public final void z() {
        gg3.v(this.I);
        gg3.q(this.N);
        gg3.q(this.O);
    }
}
