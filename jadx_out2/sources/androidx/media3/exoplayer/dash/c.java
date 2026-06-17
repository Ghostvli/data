package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.exoplayer.dash.a;
import androidx.media3.exoplayer.dash.d;
import androidx.media3.exoplayer.j;
import defpackage.aa0;
import defpackage.ak1;
import defpackage.bz1;
import defpackage.dj;
import defpackage.ev;
import defpackage.fj;
import defpackage.fv;
import defpackage.fy4;
import defpackage.g90;
import defpackage.gg3;
import defpackage.hi;
import defpackage.hs4;
import defpackage.ie3;
import defpackage.j20;
import defpackage.ja0;
import defpackage.jy0;
import defpackage.k74;
import defpackage.ki4;
import defpackage.kx4;
import defpackage.m90;
import defpackage.n90;
import defpackage.nm;
import defpackage.nt2;
import defpackage.o90;
import defpackage.og1;
import defpackage.oj;
import defpackage.pt;
import defpackage.qt;
import defpackage.rt;
import defpackage.st;
import defpackage.sy1;
import defpackage.t41;
import defpackage.tq3;
import defpackage.v72;
import defpackage.vn3;
import defpackage.w72;
import defpackage.y3;
import defpackage.zi1;
import defpackage.zz3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c implements androidx.media3.exoplayer.dash.a {
    public final bz1 a;
    public final fj b;
    public final int[] c;
    public final int d;
    public final aa0 e;
    public final long f;
    public final int g;
    public final d.c h;
    public final b[] i;
    public jy0 j;
    public g90 k;
    public int l;
    public IOException m;
    public boolean n;
    public long o = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final qt a;
        public final tq3 b;
        public final dj c;
        public final m90 d;
        public final long e;
        public final long f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(long j, tq3 tq3Var, dj djVar, qt qtVar, long j2, m90 m90Var) {
            this.e = j;
            this.b = tq3Var;
            this.c = djVar;
            this.f = j2;
            this.a = qtVar;
            this.d = m90Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(long j, tq3 tq3Var) throws oj {
            long jF;
            long jF2;
            m90 m90VarL = this.b.l();
            m90 m90VarL2 = tq3Var.l();
            if (m90VarL == null) {
                return new b(j, tq3Var, this.c, this.a, this.f, m90VarL);
            }
            if (!m90VarL.g()) {
                return new b(j, tq3Var, this.c, this.a, this.f, m90VarL2);
            }
            long jI = m90VarL.i(j);
            if (jI == 0) {
                return new b(j, tq3Var, this.c, this.a, this.f, m90VarL2);
            }
            gg3.q(m90VarL2);
            long jH = m90VarL.h();
            long jA = m90VarL.a(jH);
            long j2 = jI + jH;
            long j3 = j2 - 1;
            long jA2 = m90VarL.a(j3) + m90VarL.b(j3, j);
            long jH2 = m90VarL2.h();
            long jA3 = m90VarL2.a(jH2);
            long j4 = this.f;
            if (jA2 == jA3) {
                jF = j2 - jH2;
            } else {
                if (jA2 < jA3) {
                    throw new oj();
                }
                if (jA3 < jA) {
                    jF2 = j4 - (m90VarL2.f(jA, j) - jH);
                    return new b(j, tq3Var, this.c, this.a, jF2, m90VarL2);
                }
                jF = m90VarL.f(jA3, j) - jH2;
            }
            jF2 = j4 + jF;
            return new b(j, tq3Var, this.c, this.a, jF2, m90VarL2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(m90 m90Var) {
            return new b(this.e, this.b, this.c, this.a, this.f, m90Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(dj djVar) {
            return new b(this.e, this.b, djVar, this.a, this.f, this.d);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long e(long j) {
            return ((m90) gg3.q(this.d)).c(this.e, j) + this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long f() {
            return ((m90) gg3.q(this.d)).h() + this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long g(long j) {
            return (e(j) + ((m90) gg3.q(this.d)).j(this.e, j)) - 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long h() {
            return ((m90) gg3.q(this.d)).i(this.e);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long i(long j) {
            return k(j) + ((m90) gg3.q(this.d)).b(j - this.f, this.e);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long j(long j) {
            return ((m90) gg3.q(this.d)).f(j, this.e) + this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long k(long j) {
            return ((m90) gg3.q(this.d)).a(j - this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public vn3 l(long j) {
            return ((m90) gg3.q(this.d)).e(j - this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean m(long j, long j2) {
            return ((m90) gg3.q(this.d)).g() || j2 == -9223372036854775807L || i(j) <= j2;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.dash.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0018c extends hi {
        public final b e;
        public final long f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0018c(b bVar, long j, long j2, long j3) {
            super(j, j2);
            this.e = bVar;
            this.f = j3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w72
        public long a() {
            c();
            return this.e.k(d());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w72
        public long b() {
            c();
            return this.e.i(d());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c(qt.a aVar, bz1 bz1Var, g90 g90Var, fj fjVar, int i, int[] iArr, jy0 jy0Var, int i2, aa0 aa0Var, long j, int i3, boolean z, List list, d.c cVar, ie3 ie3Var, ev evVar) {
        this.a = bz1Var;
        this.k = g90Var;
        this.b = fjVar;
        this.c = iArr;
        this.j = jy0Var;
        int i4 = i2;
        this.d = i4;
        this.e = aa0Var;
        this.l = i;
        this.f = j;
        this.g = i3;
        d.c cVar2 = cVar;
        this.h = cVar2;
        long jG = g90Var.g(i);
        ArrayList arrayListO = o();
        this.i = new b[jy0Var.length()];
        int i5 = 0;
        while (i5 < this.i.length) {
            tq3 tq3Var = (tq3) arrayListO.get(jy0Var.i(i5));
            dj djVarJ = fjVar.j(tq3Var.c);
            b[] bVarArr = this.i;
            dj djVar = djVarJ == null ? (dj) tq3Var.c.get(0) : djVarJ;
            qt qtVarE = aVar.e(i4, tq3Var.b, z, list, cVar2, ie3Var);
            long j2 = jG;
            int i6 = i5;
            bVarArr[i6] = new b(j2, tq3Var, djVar, qtVarE, 0L, tq3Var.l());
            i5 = i6 + 1;
            i4 = i2;
            jG = j2;
            cVar2 = cVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void a() throws IOException {
        IOException iOException = this.m;
        if (iOException != null) {
            throw iOException;
        }
        this.a.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.dash.a
    public void b(jy0 jy0Var) {
        this.j = jy0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.dash.a
    public void c(g90 g90Var, int i) {
        try {
            this.k = g90Var;
            this.l = i;
            long jG = g90Var.g(i);
            ArrayList arrayListO = o();
            for (int i2 = 0; i2 < this.i.length; i2++) {
                tq3 tq3Var = (tq3) arrayListO.get(this.j.i(i2));
                b[] bVarArr = this.i;
                bVarArr[i2] = bVarArr[i2].b(jG, tq3Var);
            }
        } catch (oj e) {
            this.m = e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public long d(long j, zz3 zz3Var) {
        b[] bVarArr = this.i;
        int length = bVarArr.length;
        int i = 0;
        while (i < length) {
            b bVar = bVarArr[i];
            if (bVar.d != null) {
                long jH = bVar.h();
                if (jH != 0) {
                    long j2 = bVar.j(j);
                    long jK = bVar.k(j2);
                    return zz3Var.a(j, jK, (jK >= j || (jH != -1 && j2 >= (bVar.f() + jH) - 1)) ? jK : bVar.k(j2 + 1));
                }
            }
            i++;
            zz3Var = zz3Var;
            j = j;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void e(pt ptVar) {
        st stVarB;
        if (ptVar instanceof ak1) {
            int iE = this.j.e(((ak1) ptVar).d);
            b bVar = this.i[iE];
            if (bVar.d == null && (stVarB = ((qt) gg3.q(bVar.a)).b()) != null) {
                this.i[iE] = bVar.c(new o90(stVarB, bVar.b.d));
            }
        }
        d.c cVar = this.h;
        if (cVar != null) {
            cVar.j(ptVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public boolean f(pt ptVar, boolean z, sy1.c cVar, sy1 sy1Var) {
        sy1.b bVarB;
        if (!z) {
            return false;
        }
        d.c cVar2 = this.h;
        if (cVar2 != null && cVar2.k(ptVar)) {
            return true;
        }
        if (!this.k.d && (ptVar instanceof v72)) {
            IOException iOException = cVar.c;
            if ((iOException instanceof og1) && ((og1) iOException).i == 404) {
                b bVar = this.i[this.j.e(ptVar.d)];
                long jH = bVar.h();
                if (jH != -1 && jH != 0) {
                    if (((v72) ptVar).g() > (bVar.f() + jH) - 1) {
                        this.n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.i[this.j.e(ptVar.d)];
        dj djVarJ = this.b.j(bVar2.b.c);
        if (djVarJ != null && !bVar2.c.equals(djVarJ)) {
            return true;
        }
        sy1.a aVarK = k(this.j, bVar2.b.c);
        if ((aVarK.a(2) || aVarK.a(1)) && (bVarB = sy1Var.b(aVarK, cVar)) != null && aVarK.a(bVarB.a)) {
            int i = bVarB.a;
            if (i == 2) {
                jy0 jy0Var = this.j;
                return jy0Var.n(jy0Var.e(ptVar.d), bVarB.b);
            }
            if (i == 1) {
                this.b.e(bVar2.c, bVarB.b);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public boolean g(long j, pt ptVar, List list) {
        if (this.m != null) {
            return false;
        }
        return this.j.f(j, ptVar, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public int h(long j, List list) {
        return (this.m != null || this.j.length() < 2) ? list.size() : this.j.j(j, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void i(j jVar, long j, List list, rt rtVar) {
        boolean z;
        w72[] w72VarArr;
        long j2;
        int i;
        int i2;
        c cVar;
        v72 v72Var;
        c cVar2 = this;
        if (cVar2.m != null) {
            return;
        }
        long j3 = jVar.a;
        long j4 = j - j3;
        long jC1 = fy4.c1(cVar2.k.a) + fy4.c1(cVar2.k.d(cVar2.l).b) + j;
        d.c cVar3 = cVar2.h;
        if (cVar3 == null || !cVar3.i(jC1)) {
            long jC12 = fy4.c1(fy4.q0(cVar2.f));
            long jN = cVar2.n(jC12);
            boolean z2 = true;
            v72 v72Var2 = list.isEmpty() ? null : (v72) list.get(list.size() - 1);
            int length = cVar2.j.length();
            w72[] w72VarArr2 = new w72[length];
            int i3 = 0;
            while (i3 < length) {
                b bVar = cVar2.i[i3];
                if (bVar.d == null) {
                    w72VarArr2[i3] = w72.a;
                    cVar = cVar2;
                    v72Var = v72Var2;
                    z = z2;
                    w72VarArr = w72VarArr2;
                    j2 = j4;
                    i2 = length;
                    i = i3;
                } else {
                    w72[] w72VarArr3 = w72VarArr2;
                    long jE = bVar.e(jC12);
                    z = z2;
                    w72VarArr = w72VarArr3;
                    v72 v72Var3 = v72Var2;
                    long jG = bVar.g(jC12);
                    j2 = j4;
                    i = i3;
                    i2 = length;
                    long jP = cVar2.p(bVar, v72Var3, j, jE, jG);
                    cVar = cVar2;
                    v72Var = v72Var3;
                    if (jP < jE) {
                        w72VarArr[i] = w72.a;
                    } else {
                        w72VarArr[i] = new C0018c(cVar.s(i), jP, jG, jN);
                    }
                }
                i3 = i + 1;
                cVar2 = cVar;
                length = i2;
                v72Var2 = v72Var;
                w72VarArr2 = w72VarArr;
                z2 = z;
                j4 = j2;
            }
            c cVar4 = cVar2;
            v72 v72Var4 = v72Var2;
            boolean z3 = z2;
            cVar4.j.b(j3, j4, cVar4.l(jC12, j3), list, w72VarArr2);
            int iD = cVar4.j.d();
            cVar4.o = SystemClock.elapsedRealtime();
            b bVarS = cVar4.s(iD);
            qt qtVar = bVarS.a;
            if (qtVar != null) {
                tq3 tq3Var = bVarS.b;
                vn3 vn3VarN = qtVar.d() == null ? tq3Var.n() : null;
                vn3 vn3VarM = bVarS.d == null ? tq3Var.m() : null;
                if (vn3VarN != null || vn3VarM != null) {
                    rtVar.a = cVar4.q(bVarS, cVar4.e, cVar4.j.l(), cVar4.j.m(), cVar4.j.p(), vn3VarN, vn3VarM, null);
                    return;
                }
            }
            long j5 = bVarS.e;
            g90 g90Var = cVar4.k;
            boolean z4 = (g90Var.d && cVar4.l == g90Var.e() + (-1)) ? z3 : false;
            boolean z5 = (z4 && j5 == -9223372036854775807L) ? false : z3;
            if (bVarS.h() == 0) {
                rtVar.b = z5;
                return;
            }
            long jE2 = bVarS.e(jC12);
            long jG2 = bVarS.g(jC12);
            if (z4) {
                long jI = bVarS.i(jG2);
                z5 &= jI + (jI - bVarS.k(jG2)) >= j5 ? z3 : false;
            }
            boolean z6 = z5;
            long jP2 = cVar4.p(bVarS, v72Var4, j, jE2, jG2);
            if (jP2 < jE2) {
                cVar4.m = new oj();
                return;
            }
            if (jP2 > jG2 || (cVar4.n && jP2 >= jG2)) {
                rtVar.b = z6;
                return;
            }
            if (z6 && bVarS.k(jP2) >= j5) {
                rtVar.b = z3;
                return;
            }
            int iMin = (int) Math.min(cVar4.g, (jG2 - jP2) + 1);
            if (j5 != -9223372036854775807L) {
                while (iMin > 1 && bVarS.k((((long) iMin) + jP2) - 1) >= j5) {
                    iMin--;
                }
            }
            rtVar.a = cVar4.r(bVarS, cVar4.e, cVar4.d, cVar4.j.l(), cVar4.j.m(), cVar4.j.p(), jP2, iMin, list.isEmpty() ? j : -9223372036854775807L, jN, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sy1.a k(jy0 jy0Var, List list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = jy0Var.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (jy0Var.a(i2, jElapsedRealtime)) {
                i++;
            }
        }
        int iF = fj.f(list);
        return new sy1.a(iF, iF - this.b.g(list), length, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long l(long j, long j2) {
        if (!this.k.d || this.i[0].h() == 0) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(n(j), this.i[0].i(this.i[0].g(j))) - j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Pair m(long j, vn3 vn3Var, b bVar) {
        long j2 = j + 1;
        if (j2 >= bVar.h()) {
            return null;
        }
        vn3 vn3VarL = bVar.l(j2);
        String strA = kx4.a(vn3Var.b(bVar.c.a), vn3VarL.b(bVar.c.a));
        String str = vn3VarL.a + "-";
        if (vn3VarL.b != -1) {
            str = str + (vn3VarL.a + vn3VarL.b);
        }
        return new Pair(strA, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long n(long j) {
        g90 g90Var = this.k;
        long j2 = g90Var.a;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - fy4.c1(j2 + g90Var.d(this.l).b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ArrayList o() {
        List list = this.k.d(this.l).c;
        ArrayList arrayList = new ArrayList();
        for (int i : this.c) {
            arrayList.addAll(((y3) list.get(i)).c);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long p(b bVar, v72 v72Var, long j, long j2, long j3) {
        return v72Var != null ? v72Var.g() : fy4.t(bVar.j(j), j2, j3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pt q(b bVar, aa0 aa0Var, t41 t41Var, int i, Object obj, vn3 vn3Var, vn3 vn3Var2, fv.a aVar) {
        vn3 vn3Var3 = vn3Var;
        tq3 tq3Var = bVar.b;
        if (vn3Var3 != null) {
            vn3 vn3VarA = vn3Var3.a(vn3Var2, bVar.c.a);
            if (vn3VarA != null) {
                vn3Var3 = vn3VarA;
            }
        } else {
            vn3Var3 = (vn3) gg3.q(vn3Var2);
        }
        return new ak1(aa0Var, n90.a(tq3Var, bVar.c.a, vn3Var3, 0, zi1.j()), t41Var, i, obj, bVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pt r(b bVar, aa0 aa0Var, int i, t41 t41Var, int i2, Object obj, long j, int i3, long j2, long j3, fv.a aVar) {
        tq3 tq3Var = bVar.b;
        long jK = bVar.k(j);
        vn3 vn3VarL = bVar.l(j);
        if (bVar.a == null) {
            int i4 = 8;
            long jI = bVar.i(j);
            if (bVar.m(j, j3)) {
                i4 = 0;
            }
            return new k74(aa0Var, n90.a(tq3Var, bVar.c.a, vn3VarL, i4, zi1.j()), t41Var, i2, obj, jK, jI, j, i, t41Var);
        }
        int i5 = 8;
        int i6 = 1;
        int i7 = 1;
        while (i6 < i3) {
            vn3 vn3VarA = vn3VarL.a(bVar.l(j + ((long) i6)), bVar.c.a);
            if (vn3VarA == null) {
                break;
            }
            i7++;
            i6++;
            vn3VarL = vn3VarA;
        }
        long j4 = (j + ((long) i7)) - 1;
        int i8 = i7;
        long jI2 = bVar.i(j4);
        long j5 = bVar.e;
        if (j5 == -9223372036854775807L || j5 > jI2) {
            j5 = -9223372036854775807L;
        }
        if (bVar.m(j4, j3)) {
            i5 = 0;
        }
        ja0 ja0VarA = n90.a(tq3Var, bVar.c.a, vn3VarL, i5, zi1.j());
        long j6 = -tq3Var.d;
        if (nt2.q(t41Var.p)) {
            j6 += jK;
        }
        return new j20(aa0Var, ja0VarA, t41Var, i2, obj, jK, jI2, j2, j5, j, i8, j6, bVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void release() {
        for (b bVar : this.i) {
            qt qtVar = bVar.a;
            if (qtVar != null) {
                qtVar.release();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final b s(int i) {
        b bVar = this.i[i];
        dj djVarJ = this.b.j(bVar.b.c);
        if (djVarJ == null || djVarJ.equals(bVar.c)) {
            return bVar;
        }
        b bVarD = bVar.d(djVarJ);
        this.i[i] = bVarD;
        return bVarD;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements a.InterfaceC0017a {
        public final aa0.a a;
        public final int b;
        public final qt.a c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(qt.a aVar, aa0.a aVar2, int i) {
            this.c = aVar;
            this.a = aVar2;
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0017a
        public t41 d(t41 t41Var) {
            return this.c.d(t41Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0017a
        public androidx.media3.exoplayer.dash.a e(bz1 bz1Var, g90 g90Var, fj fjVar, int i, int[] iArr, jy0 jy0Var, int i2, long j, boolean z, List list, d.c cVar, hs4 hs4Var, ie3 ie3Var, ev evVar) {
            aa0 aa0VarB = this.a.b();
            if (hs4Var != null) {
                aa0VarB.f(hs4Var);
            }
            return new c(this.c, bz1Var, g90Var, fjVar, i, iArr, jy0Var, i2, aa0VarB, j, this.b, z, list, cVar, ie3Var, evVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Z)Landroidx/media3/exoplayer/dash/a$a; */
        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0017a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a b(boolean z) {
            this.c.b(z);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: c(I)Landroidx/media3/exoplayer/dash/a$a; */
        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0017a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a c(int i) {
            this.c.c(i);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Lki4$a;)Landroidx/media3/exoplayer/dash/a$a; */
        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0017a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(ki4.a aVar) {
            this.c.a(aVar);
            return this;
        }

        public a(aa0.a aVar, int i) {
            this(new nm.c(), aVar, i);
        }

        public a(aa0.a aVar) {
            this(aVar, 1);
        }
    }
}
