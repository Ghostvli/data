package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.k;
import defpackage.bc3;
import defpackage.gg3;
import defpackage.jq2;
import defpackage.mc1;
import defpackage.mi2;
import defpackage.ni2;
import defpackage.no4;
import defpackage.o5;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final o5 c;
    public final mc1 d;
    public final k.a e;
    public long f;
    public int g;
    public boolean h;
    public ExoPlayer.c i;
    public k j;
    public k k;
    public k l;
    public k m;
    public k n;
    public int o;
    public Object p;
    public long q;
    public final no4.b a = new no4.b();
    public final no4.d b = new no4.d();
    public List r = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l(o5 o5Var, mc1 mc1Var, k.a aVar, ExoPlayer.c cVar) {
        this.c = o5Var;
        this.d = mc1Var;
        this.e = aVar;
        this.i = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean H(no4.b bVar) {
        int iD = bVar.d();
        if (iD != 0 && ((iD != 1 || !bVar.s(0)) && bVar.t(bVar.q()))) {
            long j = 0;
            if (bVar.f(0L) == -1) {
                if (bVar.d == 0) {
                    return true;
                }
                int i = iD - (bVar.s(iD + (-1)) ? 2 : 1);
                for (int i2 = 0; i2 <= i; i2++) {
                    j += bVar.j(i2);
                }
                if (bVar.d <= j) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jq2.b P(no4 no4Var, Object obj, long j, long j2, no4.d dVar, no4.b bVar) {
        no4Var.n(obj, bVar);
        no4Var.t(bVar.c, dVar);
        for (int iH = no4Var.h(obj); H(bVar) && iH <= dVar.o; iH++) {
            no4Var.m(iH, bVar, true);
            obj = gg3.q(bVar.b);
        }
        no4Var.n(obj, bVar);
        int iF = bVar.f(j);
        return iF == -1 ? new jq2.b(obj, j2, bVar.e(j)) : new jq2.b(obj, iF, bVar.m(iF), j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean U(no4 no4Var, int i, long j, no4.d dVar) {
        if (j != -9223372036854775807L) {
            return false;
        }
        no4Var.t(i, dVar);
        return dVar.i && !dVar.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean A(Object obj, no4 no4Var) {
        int iD = no4Var.n(obj, this.a).d();
        int iQ = this.a.q();
        if (iD <= 0 || !this.a.t(iQ)) {
            return false;
        }
        return iD > 1 || this.a.g(iQ) != Long.MIN_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(no4 no4Var) {
        k kVar;
        l lVar;
        if (this.i.a == -9223372036854775807L || (kVar = this.m) == null) {
            M();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Pair pairI = i(no4Var, kVar.h.a.a, 0L);
        if (pairI == null || no4Var.t(no4Var.n(pairI.first, this.a).c, this.b).g()) {
            lVar = this;
        } else {
            long jS = S(pairI.first);
            if (jS == -1) {
                jS = this.f;
                this.f = 1 + jS;
            }
            lVar = this;
            ni2 ni2VarR = lVar.r(no4Var, pairI.first, ((Long) pairI.second).longValue(), jS);
            k kVarO = lVar.O(ni2VarR);
            if (kVarO == null) {
                kVarO = lVar.e.a(ni2VarR, (kVar.m() + kVar.h.f) - ni2VarR.b);
            }
            arrayList.add(kVarO);
        }
        lVar.L(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean C(jq2.b bVar) {
        return !bVar.c() && bVar.e == -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean D(no4 no4Var, jq2.b bVar, boolean z) {
        int iH = no4Var.h(bVar.a);
        return !no4Var.t(no4Var.l(iH, this.a).c, this.b).i && no4Var.x(iH, this.a, this.b, this.g, this.h) && z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E(no4 no4Var, jq2.b bVar) {
        if (C(bVar)) {
            return no4Var.t(no4Var.n(bVar.a, this.a).c, this.b).o == no4Var.h(bVar.a);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean F(mi2 mi2Var) {
        k kVar = this.m;
        return kVar != null && kVar.a == mi2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean G(mi2 mi2Var) {
        k kVar = this.n;
        return kVar != null && kVar.a == mi2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I() {
        k kVar = this.n;
        if (kVar == null || kVar.t()) {
            this.n = null;
            for (int i = 0; i < this.r.size(); i++) {
                k kVar2 = (k) this.r.get(i);
                if (!kVar2.t()) {
                    this.n = kVar2;
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J() {
        final xi1.a aVarM = xi1.m();
        for (k kVarK = this.j; kVarK != null; kVarK = kVarK.k()) {
            aVarM.a(kVarK.h.a);
        }
        k kVar = this.k;
        final jq2.b bVar = kVar == null ? null : kVar.h.a;
        this.d.d(new Runnable() { // from class: oi2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.c.N0(aVarM.k(), bVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K(long j) {
        k kVar = this.m;
        if (kVar != null) {
            kVar.w(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(List list) {
        for (int i = 0; i < this.r.size(); i++) {
            ((k) this.r.get(i)).x();
        }
        this.r = list;
        this.n = null;
        I();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M() {
        if (this.r.isEmpty()) {
            return;
        }
        L(new ArrayList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int N(k kVar) {
        gg3.q(kVar);
        int i = 0;
        if (kVar.equals(this.m)) {
            return 0;
        }
        this.m = kVar;
        while (kVar.k() != null) {
            kVar = (k) gg3.q(kVar.k());
            if (kVar == this.k) {
                k kVar2 = this.j;
                this.k = kVar2;
                this.l = kVar2;
                i = 3;
            }
            if (kVar == this.l) {
                this.l = this.k;
                i |= 2;
            }
            kVar.x();
            this.o--;
        }
        ((k) gg3.q(this.m)).A(null);
        J();
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final k O(ni2 ni2Var) {
        for (int i = 0; i < this.r.size(); i++) {
            if (((k) this.r.get(i)).d(ni2Var)) {
                return (k) this.r.remove(i);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jq2.b Q(no4 no4Var, Object obj, long j) {
        long jR = R(no4Var, obj);
        no4Var.n(obj, this.a);
        no4Var.t(this.a.c, this.b);
        boolean z = false;
        for (int iH = no4Var.h(obj); iH >= this.b.n; iH--) {
            no4Var.m(iH, this.a, true);
            boolean z2 = this.a.d() > 0;
            z |= z2;
            no4.b bVar = this.a;
            if (bVar.f(bVar.d) != -1) {
                obj = gg3.q(this.a.b);
            }
            if (z && (!z2 || this.a.d != 0)) {
                break;
            }
        }
        return P(no4Var, obj, j, jR, this.b, this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long R(no4 no4Var, Object obj) {
        int iH;
        int i = no4Var.n(obj, this.a).c;
        Object obj2 = this.p;
        if (obj2 != null && (iH = no4Var.h(obj2)) != -1 && no4Var.l(iH, this.a).c == i) {
            return this.q;
        }
        for (k kVarK = this.j; kVarK != null; kVarK = kVarK.k()) {
            if (kVarK.b.equals(obj)) {
                return kVarK.h.a.d;
            }
        }
        for (k kVarK2 = this.j; kVarK2 != null; kVarK2 = kVarK2.k()) {
            int iH2 = no4Var.h(kVarK2.b);
            if (iH2 != -1 && no4Var.l(iH2, this.a).c == i) {
                return kVarK2.h.a.d;
            }
        }
        long jS = S(obj);
        if (jS != -1) {
            return jS;
        }
        long j = this.f;
        this.f = 1 + j;
        if (this.j == null) {
            this.p = obj;
            this.q = j;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long S(Object obj) {
        for (int i = 0; i < this.r.size(); i++) {
            k kVar = (k) this.r.get(i);
            if (kVar.b.equals(obj)) {
                return kVar.h.a.d;
            }
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean T() {
        k kVar = this.m;
        if (kVar != null) {
            return !kVar.h.k && kVar.s() && this.m.h.f != -9223372036854775807L && this.o < 100;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int V(no4 no4Var) {
        no4 no4Var2;
        k kVarK = this.j;
        if (kVarK == null) {
            return 0;
        }
        int iH = no4Var.h(kVarK.b);
        while (true) {
            no4Var2 = no4Var;
            iH = no4Var2.j(iH, this.a, this.b, this.g, this.h);
            while (((k) gg3.q(kVarK)).k() != null && !kVarK.h.i) {
                kVarK = kVarK.k();
            }
            k kVarK2 = kVarK.k();
            if (iH == -1 || kVarK2 == null || no4Var2.h(kVarK2.b) != iH) {
                break;
            }
            kVarK = kVarK2;
            no4Var = no4Var2;
        }
        int iN = N(kVarK);
        kVarK.h = z(no4Var2, kVarK.h);
        return iN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W(no4 no4Var, ExoPlayer.c cVar) {
        this.i = cVar;
        B(no4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int X(no4 no4Var, long j, long j2, long j3) {
        ni2 ni2VarB;
        boolean z;
        k kVarK = this.j;
        k kVar = null;
        while (kVarK != null) {
            ni2 ni2Var = kVarK.h;
            if (kVar == null) {
                ni2VarB = z(no4Var, ni2Var);
            } else {
                ni2 ni2VarL = l(no4Var, kVar, j);
                if (ni2VarL == null || !f(ni2Var, ni2VarL)) {
                    return N(kVar);
                }
                long j4 = ni2Var.b;
                ni2VarB = j4 != ni2VarL.b ? ni2VarL.b(j4, ni2Var.c) : ni2VarL;
            }
            kVarK.h = ni2VarB.a(ni2Var.d);
            if (ni2Var.f != ni2VarB.f) {
                kVarK.E();
                long j5 = ni2VarB.f;
                long jD = j5 == -9223372036854775807L ? Long.MAX_VALUE : kVarK.D(j5);
                boolean z2 = kVarK == this.k && !kVarK.h.h && (j2 == Long.MIN_VALUE || j2 >= jD);
                boolean z3 = kVarK == this.l && (j3 == Long.MIN_VALUE || j3 >= jD);
                int iN = N(kVarK);
                if (iN != 0) {
                    return iN;
                }
                long j6 = ni2Var.f;
                if (j6 == -9223372036854775807L && ni2Var.e == Long.MIN_VALUE) {
                    long j7 = ni2VarB.e;
                    if (j7 != -9223372036854775807L && j7 != Long.MIN_VALUE) {
                        z = true;
                    }
                } else {
                    z = false;
                }
                int i = (!z2 || (j6 == -9223372036854775807L && !z)) ? 0 : 1;
                return z3 ? i | 2 : i;
            }
            kVar = kVarK;
            kVarK = kVarK.k();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int Y(no4 no4Var, int i) {
        this.g = i;
        return V(no4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int Z(no4 no4Var, boolean z) {
        this.h = z;
        return V(no4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k b() {
        k kVar = this.j;
        if (kVar == null) {
            return null;
        }
        if (kVar == this.k) {
            this.k = kVar.k();
        }
        k kVar2 = this.j;
        if (kVar2 == this.l) {
            this.l = kVar2.k();
        }
        this.j.x();
        int i = this.o - 1;
        this.o = i;
        if (i == 0) {
            this.m = null;
            k kVar3 = this.j;
            this.p = kVar3.b;
            this.q = kVar3.h.a.d;
        }
        this.j = this.j.k();
        J();
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k c() {
        this.l = ((k) gg3.q(this.l)).k();
        J();
        return (k) gg3.q(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k d() {
        k kVar = this.l;
        k kVar2 = this.k;
        if (kVar == kVar2) {
            this.l = ((k) gg3.q(kVar2)).k();
        }
        this.k = ((k) gg3.q(this.k)).k();
        J();
        return (k) gg3.q(this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean f(ni2 ni2Var, ni2 ni2Var2) {
        if (!ni2Var.a.equals(ni2Var2.a)) {
            return false;
        }
        long j = ni2Var.b;
        long j2 = ni2Var2.b;
        if (j == j2) {
            return true;
        }
        long j3 = ni2Var.c;
        if (j3 != -9223372036854775807L) {
            long j4 = ni2Var2.c;
            if (j4 != -9223372036854775807L) {
                if (Math.abs((j2 - j4) - (j - j3)) < 5000000) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        if (this.o == 0) {
            return;
        }
        k kVarK = (k) gg3.q(this.j);
        this.p = kVarK.b;
        this.q = kVarK.h.a.d;
        while (kVarK != null) {
            kVarK.x();
            kVarK = kVarK.k();
        }
        this.j = null;
        this.m = null;
        this.k = null;
        this.l = null;
        this.o = 0;
        J();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k h(ni2 ni2Var) {
        k kVar = this.m;
        long jM = kVar == null ? 1000000000000L : (kVar.m() + this.m.h.f) - ni2Var.b;
        k kVarO = O(ni2Var);
        if (kVarO == null) {
            kVarO = this.e.a(ni2Var, jM);
        } else {
            kVarO.h = ni2Var;
            kVarO.B(jM);
        }
        k kVar2 = this.m;
        if (kVar2 != null) {
            kVar2.A(kVarO);
        } else {
            this.j = kVarO;
            this.k = kVarO;
            this.l = kVarO;
        }
        this.p = null;
        this.m = kVarO;
        this.o++;
        J();
        return kVarO;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Pair i(no4 no4Var, Object obj, long j) {
        int iK = no4Var.k(no4Var.n(obj, this.a).c, this.g, this.h);
        if (iK != -1) {
            return no4Var.q(this.b, this.a, iK, -9223372036854775807L, j);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 j(bc3 bc3Var) {
        return o(bc3Var.a, bc3Var.b, bc3Var.c, bc3Var.s, -9223372036854775807L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 k(no4 no4Var, k kVar, long j) {
        Object obj;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        ni2 ni2Var = kVar.h;
        int iJ = no4Var.j(no4Var.h(ni2Var.a.a), this.a, this.b, this.g, this.h);
        if (iJ == -1) {
            return null;
        }
        int i = no4Var.m(iJ, this.a, true).c;
        Object objQ = gg3.q(this.a.b);
        long j8 = ni2Var.a.d;
        if (no4Var.t(i, this.b).n == iJ) {
            no4.b bVar = this.a;
            long jMax = U(no4Var, bVar.c, bVar.d, this.b) ? Math.max(0L, j) : -9223372036854775807L;
            Pair pairQ = no4Var.q(this.b, this.a, i, -9223372036854775807L, jMax);
            if (pairQ == null) {
                return null;
            }
            Object obj2 = pairQ.first;
            long jLongValue = ((Long) pairQ.second).longValue();
            k kVarK = kVar.k();
            if (kVarK == null || !kVarK.b.equals(obj2)) {
                long jS = S(obj2);
                if (jS == -1) {
                    jS = this.f;
                    this.f = 1 + jS;
                }
                j8 = jS;
            } else {
                j8 = kVarK.h.a.d;
            }
            obj = obj2;
            j2 = jLongValue;
            j3 = -9223372036854775807L;
            j4 = jMax;
        } else {
            obj = objQ;
            j2 = 0;
            j3 = 0;
            j4 = -9223372036854775807L;
        }
        jq2.b bVarP = P(no4Var, obj, j2, j8, this.b, this.a);
        if (j3 == -9223372036854775807L || ni2Var.d == -9223372036854775807L) {
            j5 = j2;
            j6 = j4;
            j7 = j3;
        } else {
            boolean zA = A(ni2Var.a.a, no4Var);
            if (bVarP.c() && zA) {
                j5 = j2;
                j7 = ni2Var.d;
                j6 = j4;
            } else {
                if (zA) {
                    j2 = ni2Var.d;
                }
                j5 = j2;
                j6 = j4;
                j7 = j3;
            }
        }
        return o(no4Var, bVarP, j7, j5, j6);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 l(no4 no4Var, k kVar, long j) {
        ni2 ni2Var = kVar.h;
        long jM = (kVar.m() + ni2Var.f) - j;
        return ni2Var.i ? k(no4Var, kVar, jM) : m(no4Var, kVar, jM);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 m(no4 no4Var, k kVar, long j) {
        no4 no4Var2;
        long j2;
        ni2 ni2Var = kVar.h;
        jq2.b bVar = ni2Var.a;
        no4Var.n(bVar.a, this.a);
        boolean z = ni2Var.h;
        if (!bVar.c()) {
            int i = bVar.e;
            if (i != -1 && this.a.s(i)) {
                return k(no4Var, kVar, j);
            }
            int iM = this.a.m(bVar.e);
            boolean z2 = this.a.t(bVar.e) && this.a.i(bVar.e, iM) == 3;
            if (iM == this.a.b(bVar.e) || z2) {
                return q(no4Var, bVar.a, s(no4Var, bVar.a, bVar.e), -9223372036854775807L, ni2Var.f, bVar.d, false);
            }
            return p(no4Var, bVar.a, bVar.e, iM, ni2Var.f, bVar.d, z);
        }
        int i2 = bVar.b;
        int iB = this.a.b(i2);
        if (iB == -1) {
            return null;
        }
        int iN = this.a.n(i2, bVar.c);
        if (iN < iB) {
            return p(no4Var, bVar.a, i2, iN, ni2Var.d, bVar.d, z);
        }
        long jLongValue = ni2Var.d;
        if (jLongValue == -9223372036854775807L) {
            no4.b bVar2 = this.a;
            long jMax = U(no4Var, bVar2.c, bVar2.d, this.b) ? Math.max(0L, j) : -9223372036854775807L;
            no4.d dVar = this.b;
            no4.b bVar3 = this.a;
            no4Var2 = no4Var;
            Pair pairQ = no4Var2.q(dVar, bVar3, bVar3.c, -9223372036854775807L, jMax);
            if (pairQ == null) {
                return null;
            }
            jLongValue = ((Long) pairQ.second).longValue();
            j2 = jMax;
        } else {
            no4Var2 = no4Var;
            j2 = -9223372036854775807L;
        }
        return q(no4Var2, bVar.a, Math.max(s(no4Var2, bVar.a, bVar.b), jLongValue), j2, ni2Var.d, bVar.d, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k n() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 o(no4 no4Var, jq2.b bVar, long j, long j2, long j3) {
        no4Var.n(bVar.a, this.a);
        boolean zC = bVar.c();
        Object obj = bVar.a;
        return zC ? p(no4Var, obj, bVar.b, bVar.c, j, bVar.d, false) : q(no4Var, obj, j2, j3, j, bVar.d, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 p(no4 no4Var, Object obj, int i, int i2, long j, long j2, boolean z) {
        jq2.b bVar = new jq2.b(obj, i, i2, j2);
        long jC = no4Var.n(bVar.a, this.a).c(bVar.b, bVar.c);
        long jH = i2 == this.a.m(i) ? this.a.h() : 0L;
        boolean zT = this.a.t(bVar.b);
        if (jC != -9223372036854775807L && jH >= jC) {
            jH = Math.max(0L, jC - 1);
        }
        return new ni2(bVar, jH, -9223372036854775807L, j, -9223372036854775807L, jC, z, zT, false, false, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ni2 q(no4 no4Var, Object obj, long j, long j2, long j3, long j4, boolean z) {
        boolean z2;
        long j5;
        long jG;
        long j6;
        long jMax;
        no4Var.n(obj, this.a);
        int iE = this.a.e(j);
        no4.b bVar = this.a;
        int i = 1;
        if (iE == -1) {
            if (bVar.d() > 0) {
                no4.b bVar2 = this.a;
                z2 = bVar2.t(bVar2.q());
            }
        } else if (bVar.t(iE)) {
            long jG2 = this.a.g(iE);
            no4.b bVar3 = this.a;
            if (jG2 == bVar3.d && bVar3.r(iE)) {
                z2 = true;
                iE = -1;
            }
        }
        jq2.b bVar4 = new jq2.b(obj, j4, iE);
        boolean zC = C(bVar4);
        boolean zE = E(no4Var, bVar4);
        boolean zD = D(no4Var, bVar4, zC);
        boolean z3 = (iE == -1 || !this.a.t(iE) || this.a.s(iE)) ? false : true;
        boolean z4 = iE != -1 && this.a.s(iE) && this.a.t(iE);
        if (iE != -1 && !z4) {
            jG = this.a.g(iE);
        } else {
            if (!z2) {
                j5 = -9223372036854775807L;
                j6 = (j5 != -9223372036854775807L || j5 == Long.MIN_VALUE) ? this.a.d : j5;
                if (j6 != -9223372036854775807L || j < j6) {
                    jMax = j;
                } else {
                    if (!zD && z2) {
                        i = 0;
                    }
                    jMax = Math.max(0L, j6 - ((long) i));
                }
                return new ni2(bVar4, jMax, j2, j3, j5, j6, z, z3, zC, zE, zD);
            }
            jG = this.a.d;
        }
        j5 = jG;
        if (j5 != -9223372036854775807L) {
        }
        if (j6 != -9223372036854775807L) {
            jMax = j;
        }
        return new ni2(bVar4, jMax, j2, j3, j5, j6, z, z3, zC, zE, zD);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ni2 r(no4 no4Var, Object obj, long j, long j2) {
        jq2.b bVarP = P(no4Var, obj, j, j2, this.b, this.a);
        boolean zC = bVarP.c();
        Object obj2 = bVarP.a;
        return zC ? p(no4Var, obj2, bVarP.b, bVarP.c, j, bVarP.d, false) : q(no4Var, obj2, j, -9223372036854775807L, -9223372036854775807L, bVarP.d, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long s(no4 no4Var, Object obj, int i) {
        no4Var.n(obj, this.a);
        long jG = this.a.g(i);
        no4.b bVar = this.a;
        return jG == Long.MIN_VALUE ? bVar.d : jG + bVar.j(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ni2 t(long j, bc3 bc3Var) {
        k kVar = this.m;
        return kVar == null ? j(bc3Var) : l(bc3Var.a, kVar, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k u() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k v(mi2 mi2Var) {
        for (int i = 0; i < this.r.size(); i++) {
            k kVar = (k) this.r.get(i);
            if (kVar.a == mi2Var) {
                return kVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k w() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k x() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k y() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ni2 z(no4 no4Var, ni2 ni2Var) {
        long jL;
        long j;
        boolean zT;
        int i;
        jq2.b bVar = ni2Var.a;
        boolean zC = C(bVar);
        boolean zE = E(no4Var, bVar);
        boolean zD = D(no4Var, bVar, zC);
        no4Var.n(ni2Var.a.a, this.a);
        long jG = (bVar.c() || (i = bVar.e) == -1) ? -9223372036854775807L : this.a.g(i);
        if (bVar.c()) {
            jL = this.a.c(bVar.b, bVar.c);
        } else {
            if (jG != -9223372036854775807L && jG != Long.MIN_VALUE) {
                j = jG;
                if (bVar.c()) {
                    int i2 = bVar.e;
                    zT = i2 != -1 && this.a.t(i2);
                } else {
                    zT = this.a.t(bVar.b);
                }
                return new ni2(bVar, ni2Var.b, ni2Var.c, ni2Var.d, jG, j, ni2Var.g, zT, zC, zE, zD);
            }
            jL = this.a.l();
        }
        j = jL;
        if (bVar.c()) {
        }
        return new ni2(bVar, ni2Var.b, ni2Var.c, ni2Var.d, jG, j, ni2Var.g, zT, zC, zE, zD);
    }
}
