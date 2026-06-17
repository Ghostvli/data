package androidx.media3.exoplayer.smoothstreaming;

import androidx.media3.exoplayer.j;
import androidx.media3.exoplayer.smoothstreaming.b;
import defpackage.br4;
import defpackage.bz1;
import defpackage.eq3;
import defpackage.er4;
import defpackage.ev;
import defpackage.fd4;
import defpackage.gg3;
import defpackage.gx3;
import defpackage.hs4;
import defpackage.i14;
import defpackage.j5;
import defpackage.jy0;
import defpackage.mi2;
import defpackage.p81;
import defpackage.qy;
import defpackage.rq2;
import defpackage.ru1;
import defpackage.sy1;
import defpackage.t41;
import defpackage.wo0;
import defpackage.wt;
import defpackage.xi4;
import defpackage.xo0;
import defpackage.zz3;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements mi2, i14.a {
    public final b.a f;
    public final hs4 g;
    public final bz1 h;
    public final xo0 i;
    public final wo0.a j;
    public final sy1 k;
    public final rq2.a l;
    public final j5 m;
    public final er4 n;
    public final qy o;
    public final xi4 p;
    public mi2.a q;
    public fd4 r;
    public i14 t;
    public wt[] s = u(0);
    public long u = Long.MIN_VALUE;

    public c(fd4 fd4Var, b.a aVar, hs4 hs4Var, qy qyVar, ev evVar, xo0 xo0Var, wo0.a aVar2, sy1 sy1Var, rq2.a aVar3, bz1 bz1Var, j5 j5Var, xi4 xi4Var) {
        this.r = fd4Var;
        this.f = aVar;
        this.g = hs4Var;
        this.h = bz1Var;
        this.i = xo0Var;
        this.j = aVar2;
        this.k = sy1Var;
        this.l = aVar3;
        this.m = j5Var;
        this.o = qyVar;
        this.p = xi4Var;
        this.n = p(fd4Var, xo0Var, aVar);
        this.t = qyVar.empty();
    }

    public static er4 p(fd4 fd4Var, xo0 xo0Var, b.a aVar) {
        br4[] br4VarArr = new br4[fd4Var.f.length];
        int i = 0;
        while (true) {
            fd4.b[] bVarArr = fd4Var.f;
            if (i >= bVarArr.length) {
                return new er4(br4VarArr);
            }
            t41[] t41VarArr = bVarArr[i].j;
            t41[] t41VarArr2 = new t41[t41VarArr.length];
            for (int i2 = 0; i2 < t41VarArr.length; i2++) {
                t41 t41Var = t41VarArr[i2];
                t41VarArr2[i2] = aVar.d(t41Var.b().Y(xo0Var.d(t41Var)).Q());
            }
            br4VarArr[i] = new br4(Integer.toString(i), t41VarArr2);
            i++;
        }
    }

    private static wt[] u(int i) {
        return new wt[i];
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        return this.t.b(jVar);
    }

    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return this.t.c();
    }

    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        for (wt wtVar : this.s) {
            if (wtVar.f == 2) {
                return wtVar.d(j, zz3Var);
            }
        }
        return j;
    }

    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return this.t.f();
    }

    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        this.t.g(j);
    }

    @Override // defpackage.mi2
    public long h(long j) throws Throwable {
        this.u = j;
        for (wt wtVar : this.s) {
            wtVar.Y(j);
        }
        return j;
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.t.isLoading();
    }

    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) throws Throwable {
        jy0 jy0Var;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jy0VarArr.length; i++) {
            gx3 gx3Var = gx3VarArr[i];
            if (gx3Var != null) {
                wt wtVar = (wt) gx3Var;
                if (jy0VarArr[i] == null || !zArr[i]) {
                    wtVar.T();
                    gx3VarArr[i] = null;
                } else {
                    ((b) wtVar.G()).b((jy0) gg3.q(jy0VarArr[i]));
                    arrayList.add(wtVar);
                }
            }
            if (gx3VarArr[i] == null && (jy0Var = jy0VarArr[i]) != null) {
                wt wtVarO = o(jy0Var, j);
                arrayList.add(wtVarO);
                gx3VarArr[i] = wtVarO;
                zArr2[i] = true;
            }
        }
        wt[] wtVarArrU = u(arrayList.size());
        this.s = wtVarArrU;
        arrayList.toArray(wtVarArrU);
        this.t = this.o.a(arrayList, ru1.i(arrayList, new p81() { // from class: hd4
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return xi1.w(Integer.valueOf(((wt) obj).f));
            }
        }));
        return j;
    }

    @Override // defpackage.mi2
    public void m() {
        this.h.a();
    }

    @Override // defpackage.mi2
    public long n(long j) throws Throwable {
        for (wt wtVar : this.s) {
            wtVar.W(j);
        }
        return j;
    }

    public final wt o(jy0 jy0Var, long j) throws Throwable {
        int iD = this.n.d(jy0Var.c());
        b bVarC = this.f.c(this.h, this.r, iD, jy0Var, this.g, null);
        int i = this.r.f[iD].a;
        j5 j5Var = this.m;
        xo0 xo0Var = this.i;
        wo0.a aVar = this.j;
        sy1 sy1Var = this.k;
        rq2.a aVar2 = this.l;
        xi4 xi4Var = this.p;
        wt wtVar = new wt(i, null, null, bVarC, this, j5Var, j, xo0Var, aVar, sy1Var, aVar2, false, -9223372036854775807L, xi4Var != null ? (eq3) xi4Var.get() : null);
        wtVar.Y(this.u);
        return wtVar;
    }

    @Override // defpackage.mi2
    public long q() {
        return -9223372036854775807L;
    }

    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.q = aVar;
        aVar.e(this);
    }

    @Override // defpackage.mi2
    public er4 s() {
        return this.n;
    }

    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        for (wt wtVar : this.s) {
            wtVar.t(j, z);
        }
    }

    @Override // i14.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void j(wt wtVar) {
        ((mi2.a) gg3.q(this.q)).j(this);
    }

    public void w() {
        for (wt wtVar : this.s) {
            wtVar.T();
        }
        this.q = null;
    }

    public void x(fd4 fd4Var) {
        this.r = fd4Var;
        for (wt wtVar : this.s) {
            ((b) wtVar.G()).j(fd4Var);
        }
        ((mi2.a) gg3.q(this.q)).j(this);
    }
}
