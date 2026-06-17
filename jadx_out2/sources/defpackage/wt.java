package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.i14;
import defpackage.rq2;
import defpackage.sy1;
import defpackage.wo0;
import defpackage.xy1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class wt implements gx3, i14, xy1.b, xy1.f {
    public gi A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final int f;
    public final int[] g;
    public final t41[] h;
    public final boolean[] i;
    public final xt j;
    public final i14.a k;
    public final rq2.a l;
    public final sy1 m;
    public final xy1 n;
    public final rt o;
    public final ArrayList p;
    public final List q;
    public final ex3 r;
    public final ex3[] s;
    public final ii t;
    public pt u;
    public t41 v;
    public b w;
    public long x;
    public long y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements gx3 {
        public final wt f;
        public final ex3 g;
        public final int h;
        public boolean i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(wt wtVar, ex3 ex3Var, int i) {
            this.f = wtVar;
            this.g = ex3Var;
            this.h = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void b() {
            if (this.i) {
                return;
            }
            wt.this.l.j(wt.this.g[this.h], wt.this.h[this.h], 0, null, wt.this.y);
            this.i = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public void a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            gg3.v(wt.this.i[this.h]);
            wt.this.i[this.h] = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int e(long j) throws Throwable {
            if (wt.this.K()) {
                return 0;
            }
            int I = this.g.I(j, wt.this.E);
            if (wt.this.A != null) {
                I = Math.min(I, wt.this.A.i(this.h + 1) - this.g.G());
            }
            this.g.j0(I);
            if (I > 0) {
                b();
            }
            return I;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public boolean isReady() {
            return !wt.this.K() && this.g.P(wt.this.E);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (wt.this.K()) {
                return -3;
            }
            if (wt.this.A != null && wt.this.A.i(this.h + 1) <= this.g.G()) {
                return -3;
            }
            b();
            return this.g.W(u41Var, decoderInputBuffer, i, wt.this.E);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(wt wtVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wt(int i, int[] iArr, t41[] t41VarArr, xt xtVar, i14.a aVar, j5 j5Var, long j, xo0 xo0Var, wo0.a aVar2, sy1 sy1Var, rq2.a aVar3, boolean z, long j2, eq3 eq3Var) {
        this.f = i;
        iArr = iArr == null ? new int[0] : iArr;
        this.g = iArr;
        this.h = t41VarArr == null ? new t41[0] : t41VarArr;
        this.j = xtVar;
        this.k = aVar;
        this.l = aVar3;
        this.m = sy1Var;
        this.n = eq3Var != null ? new xy1(eq3Var) : new xy1("ChunkSampleStream");
        this.o = new rt();
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        this.q = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.s = new ex3[length];
        this.i = new boolean[length];
        int i2 = length + 1;
        int[] iArr2 = new int[i2];
        ex3[] ex3VarArr = new ex3[i2];
        ex3 ex3VarM = ex3.m(j5Var, xo0Var, aVar2);
        this.r = ex3VarM;
        iArr2[0] = i;
        ex3VarArr[0] = ex3VarM;
        int i3 = 0;
        while (i3 < length) {
            ex3 ex3VarN = ex3.n(j5Var);
            this.s[i3] = ex3VarN;
            int i4 = i3 + 1;
            ex3VarArr[i4] = ex3VarN;
            iArr2[i4] = this.g[i3];
            i3 = i4;
        }
        this.t = new ii(iArr2, ex3VarArr);
        this.x = j;
        this.y = j;
        this.B = z;
        if (!z || j2 == -9223372036854775807L) {
            return;
        }
        this.B = false;
        this.C = j2 < j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void D(int i) {
        gg3.v(!this.n.j());
        int size = this.p.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (!I(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = H().h;
        gi giVarE = E(i);
        if (this.p.isEmpty()) {
            this.x = this.y;
        }
        this.E = false;
        this.l.y(this.f, giVarE.g, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean J(pt ptVar) {
        return ptVar instanceof gi;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void V() {
        this.r.Z();
        for (ex3 ex3Var : this.s) {
            ex3Var.Z();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B() {
        try {
            return this.C;
        } finally {
            this.C = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(int i) {
        int iMin = Math.min(S(i, 0), this.z);
        if (iMin > 0) {
            fy4.s1(this.p, 0, iMin);
            this.z -= iMin;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gi E(int i) {
        gi giVar = (gi) this.p.get(i);
        ArrayList arrayList = this.p;
        fy4.s1(arrayList, i, arrayList.size());
        this.z = Math.max(this.z, this.p.size());
        int i2 = 0;
        this.r.x(giVar.i(0));
        while (true) {
            ex3[] ex3VarArr = this.s;
            if (i2 >= ex3VarArr.length) {
                return giVar;
            }
            ex3 ex3Var = ex3VarArr[i2];
            i2++;
            ex3Var.x(giVar.i(i2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F(long j) {
        gg3.v(!this.n.j());
        if (K() || j == -9223372036854775807L || this.p.isEmpty()) {
            return;
        }
        gi giVarH = H();
        long j2 = giVarH.l;
        if (j2 == -9223372036854775807L) {
            j2 = giVarH.h;
        }
        if (j2 <= j) {
            return;
        }
        long jD = this.r.D();
        if (jD <= j) {
            return;
        }
        this.r.v(Math.max(j, this.r.E() + 1));
        for (ex3 ex3Var : this.s) {
            ex3Var.v(Math.max(j, ex3Var.E() + 1));
        }
        this.l.y(this.f, j, jD);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xt G() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gi H() {
        return (gi) this.p.get(r1.size() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I(int i) {
        int iG;
        gi giVar = (gi) this.p.get(i);
        if (this.r.G() > giVar.i(0)) {
            return true;
        }
        int i2 = 0;
        do {
            ex3[] ex3VarArr = this.s;
            if (i2 >= ex3VarArr.length) {
                return false;
            }
            iG = ex3VarArr[i2].G();
            i2++;
        } while (iG <= giVar.i(i2));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean K() {
        return this.x != -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L() {
        return ((!this.B && !this.C) || this.E || this.n.i()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M() {
        int iS = S(this.r.G(), this.z - 1);
        while (true) {
            int i = this.z;
            if (i > iS) {
                return;
            }
            this.z = i + 1;
            N(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N(int i) {
        gi giVar = (gi) this.p.get(i);
        t41 t41Var = giVar.d;
        if (!t41Var.equals(this.v)) {
            this.l.j(this.f, t41Var, giVar.e, giVar.f, giVar.g);
        }
        this.v = t41Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Lxy1$e;JJZ)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void j(pt ptVar, long j, long j2, boolean z) {
        this.u = null;
        this.A = null;
        ty1 ty1Var = new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, ptVar.a());
        this.m.c(ptVar.a);
        this.l.m(ty1Var, ptVar.c, this.f, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h);
        if (z) {
            return;
        }
        if (K()) {
            V();
        } else if (J(ptVar)) {
            E(this.p.size() - 1);
            if (this.p.isEmpty()) {
                this.x = this.y;
            }
        }
        this.k.j(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: l(Lxy1$e;JJ)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void l(pt ptVar, long j, long j2) {
        this.u = null;
        this.j.e(ptVar);
        ty1 ty1Var = new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, ptVar.a());
        this.m.c(ptVar.a);
        this.l.p(ty1Var, ptVar.c, this.f, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h);
        this.k.j(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Lxy1$e;JJLjava/io/IOException;I)Lxy1$c; */
    @Override // xy1.b
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public xy1.c v(pt ptVar, long j, long j2, IOException iOException, int i) {
        xy1.c cVarH;
        long jA = ptVar.a();
        boolean zJ = J(ptVar);
        int size = this.p.size() - 1;
        boolean z = (jA != 0 && zJ && I(size)) ? false : true;
        ty1 ty1Var = new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, jA);
        sy1.c cVar = new sy1.c(ty1Var, new oh2(ptVar.c, this.f, ptVar.d, ptVar.e, ptVar.f, fy4.S1(ptVar.g), fy4.S1(ptVar.h)), iOException, i);
        if (!this.j.f(ptVar, z, cVar, this.m)) {
            cVarH = null;
        } else if (z) {
            cVarH = xy1.f;
            if (zJ) {
                gg3.v(E(size) == ptVar);
                if (this.p.isEmpty()) {
                    this.x = this.y;
                }
            }
        } else {
            xz1.i("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            cVarH = null;
        }
        if (cVarH == null) {
            long jA2 = this.m.a(cVar);
            cVarH = jA2 != -9223372036854775807L ? xy1.h(false, jA2) : xy1.g;
        }
        boolean zC = cVarH.c();
        this.l.r(ty1Var, ptVar.c, this.f, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h, iOException, !zC);
        if (!zC) {
            this.u = null;
            this.m.c(ptVar.a);
            this.k.j(this);
        }
        return cVarH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: p(Lxy1$e;JJI)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void p(pt ptVar, long j, long j2, int i) {
        this.l.v(i == 0 ? new ty1(ptVar.a, ptVar.b, j) : new ty1(ptVar.a, ptVar.b, ptVar.f(), ptVar.e(), j, j2, ptVar.a()), ptVar.c, this.f, ptVar.d, ptVar.e, ptVar.f, ptVar.g, ptVar.h, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int S(int i, int i2) {
        ArrayList arrayList;
        do {
            i2++;
            int size = this.p.size();
            arrayList = this.p;
            if (i2 >= size) {
                return arrayList.size() - 1;
            }
        } while (((gi) arrayList.get(i2)).i(0) <= i);
        return i2 - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T() {
        U(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U(b bVar) {
        this.w = bVar;
        this.r.V();
        for (ex3 ex3Var : this.s) {
            ex3Var.V();
        }
        this.n.m(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W(long j) throws Throwable {
        gi giVar;
        boolean zD0;
        this.y = j;
        int i = 0;
        this.B = false;
        if (K()) {
            this.x = j;
            return;
        }
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            giVar = (gi) this.p.get(i2);
            long j2 = giVar.g;
            if (j2 == j && giVar.k == -9223372036854775807L) {
                break;
            } else {
                if (j2 > j) {
                    break;
                }
            }
        }
        giVar = null;
        if (giVar != null) {
            zD0 = this.r.c0(giVar.i(0));
        } else {
            long jC = c();
            zD0 = this.r.d0(j, jC == Long.MIN_VALUE || j < jC);
        }
        if (zD0) {
            this.z = S(this.r.G(), 0);
            ex3[] ex3VarArr = this.s;
            int length = ex3VarArr.length;
            while (i < length) {
                ex3VarArr[i].d0(j, true);
                i++;
            }
            return;
        }
        this.x = j;
        this.E = false;
        this.p.clear();
        this.z = 0;
        if (!this.n.j()) {
            this.n.g();
            V();
            return;
        }
        this.r.t();
        ex3[] ex3VarArr2 = this.s;
        int length2 = ex3VarArr2.length;
        while (i < length2) {
            ex3VarArr2[i].t();
            i++;
        }
        this.n.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a X(long j, int i) throws Throwable {
        for (int i2 = 0; i2 < this.s.length; i2++) {
            if (this.g[i2] == i) {
                gg3.v(!this.i[i2]);
                this.i[i2] = true;
                this.s[i2].d0(j, true);
                return new a(this, this.s[i2], i2);
            }
        }
        z20.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y(long j) throws Throwable {
        this.r.e0(j);
        for (ex3 ex3Var : this.s) {
            ex3Var.e0(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z(boolean z) {
        this.D = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public void a() throws IOException {
        this.n.a();
        this.r.R();
        if (this.n.j()) {
            return;
        }
        this.j.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i14
    public boolean b(j jVar) {
        List list;
        long j;
        if (this.E || this.n.j() || this.n.i()) {
            return false;
        }
        boolean zK = K();
        if (zK) {
            list = Collections.EMPTY_LIST;
            j = this.x;
        } else {
            list = this.q;
            j = H().h;
        }
        this.j.i(jVar, j, list, this.o);
        rt rtVar = this.o;
        boolean z = rtVar.b;
        pt ptVar = rtVar.a;
        rtVar.a();
        if (z) {
            this.x = -9223372036854775807L;
            this.E = true;
            return true;
        }
        if (ptVar == null) {
            return false;
        }
        this.u = ptVar;
        if (J(ptVar)) {
            gi giVar = (gi) ptVar;
            if (zK) {
                long j2 = giVar.g;
                long j3 = this.x;
                if (j2 < j3) {
                    this.r.g0(j3);
                    for (ex3 ex3Var : this.s) {
                        ex3Var.g0(this.x);
                    }
                    this.C = this.B;
                }
                this.B = false;
                this.x = -9223372036854775807L;
            }
            giVar.k(this.t);
            this.p.add(giVar);
        } else if (ptVar instanceof ak1) {
            ((ak1) ptVar).g(this.t);
        }
        this.n.n(ptVar, this, this.m.d(ptVar.c));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i14
    public long c() {
        if (K()) {
            return this.x;
        }
        if (this.E) {
            return Long.MIN_VALUE;
        }
        return H().h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long d(long j, zz3 zz3Var) {
        return this.j.d(j, zz3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public int e(long j) throws Throwable {
        if (K() || L() || this.D) {
            return 0;
        }
        int I = this.r.I(j, this.E);
        gi giVar = this.A;
        if (giVar != null) {
            I = Math.min(I, giVar.i(0) - this.r.G());
        }
        this.r.j0(I);
        M();
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i14
    public long f() {
        if (this.E) {
            return Long.MIN_VALUE;
        }
        if (K()) {
            return this.x;
        }
        long jMax = this.y;
        gi giVarH = H();
        if (!giVarH.h()) {
            if (this.p.size() > 1) {
                giVarH = (gi) this.p.get(r2.size() - 2);
            } else {
                giVarH = null;
            }
        }
        if (giVarH != null) {
            jMax = Math.max(jMax, giVarH.h);
        }
        return Math.max(jMax, this.r.D());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i14
    public void g(long j) {
        if (this.n.i() || K()) {
            return;
        }
        if (!this.n.j()) {
            int iH = this.j.h(j, this.q);
            if (iH < this.p.size()) {
                D(iH);
            }
            if (this.r.M()) {
                this.E = true;
                return;
            }
            return;
        }
        pt ptVar = (pt) gg3.q(this.u);
        if (!(J(ptVar) && I(this.p.size() - 1)) && this.j.g(j, ptVar, this.q)) {
            this.n.f();
            if (J(ptVar)) {
                this.A = (gi) ptVar;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.f
    public void i() {
        this.r.X();
        for (ex3 ex3Var : this.s) {
            ex3Var.X();
        }
        this.j.release();
        b bVar = this.w;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i14
    public boolean isLoading() {
        return this.n.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public boolean isReady() {
        return !K() && this.r.P(this.E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (K() || L() || this.D) {
            return -3;
        }
        gi giVar = this.A;
        if (giVar != null && giVar.i(0) <= this.r.G()) {
            return -3;
        }
        M();
        return this.r.W(u41Var, decoderInputBuffer, i, this.E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(long j, boolean z) {
        if (K()) {
            return;
        }
        int iB = this.r.B();
        this.r.s(j, z, true);
        int iB2 = this.r.B();
        if (iB2 > iB) {
            long jC = this.r.C();
            int i = 0;
            while (true) {
                ex3[] ex3VarArr = this.s;
                if (i >= ex3VarArr.length) {
                    break;
                }
                ex3VarArr[i].s(jC, z, this.i[i]);
                i++;
            }
        }
        C(iB2);
    }
}
