package defpackage;

import androidx.media3.exoplayer.j;
import defpackage.mi2;
import defpackage.t41;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ms2 implements mi2, mi2.a {
    public final mi2[] f;
    public final boolean[] g;
    public final qy i;
    public mi2.a l;
    public er4 m;
    public i14 o;
    public final ArrayList j = new ArrayList();
    public final HashMap k = new HashMap();
    public final IdentityHashMap h = new IdentityHashMap();
    public mi2[] n = new mi2[0];

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends k51 {
        public final br4 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(jy0 jy0Var, br4 br4Var) {
            super(jy0Var);
            this.b = br4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ir4
        public br4 c() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ir4
        public int e(t41 t41Var) {
            return t().s(this.b.d(t41Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.k51
        public boolean equals(Object obj) {
            if (super.equals(obj) && (obj instanceof a)) {
                return this.b.equals(((a) obj).b);
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ir4
        public t41 h(int i) {
            return this.b.c(t().i(i));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.k51
        public int hashCode() {
            return (super.hashCode() * 31) + this.b.hashCode();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jy0
        public t41 l() {
            return this.b.c(t().k());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ms2(qy qyVar, long[] jArr, mi2... mi2VarArr) {
        this.i = qyVar;
        this.f = mi2VarArr;
        this.o = qyVar.empty();
        this.g = new boolean[mi2VarArr.length];
        for (int i = 0; i < mi2VarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.g[i] = true;
                this.f[i] = new io4(mi2VarArr[i], j);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        if (this.j.isEmpty()) {
            return this.o.b(jVar);
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            ((mi2) this.j.get(i)).b(jVar);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return this.o.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        mi2[] mi2VarArr = this.n;
        return (mi2VarArr.length > 0 ? mi2VarArr[0] : this.f[0]).d(j, zz3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // mi2.a
    public void e(mi2 mi2Var) {
        this.j.remove(mi2Var);
        if (!this.j.isEmpty()) {
            return;
        }
        int i = 0;
        for (mi2 mi2Var2 : this.f) {
            i += mi2Var2.s().a;
        }
        br4[] br4VarArr = new br4[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            mi2[] mi2VarArr = this.f;
            if (i2 >= mi2VarArr.length) {
                this.m = new er4(br4VarArr);
                ((mi2.a) gg3.q(this.l)).e(this);
                return;
            }
            er4 er4VarS = mi2VarArr[i2].s();
            int i4 = er4VarS.a;
            int i5 = 0;
            while (i5 < i4) {
                br4 br4VarB = er4VarS.b(i5);
                t41[] t41VarArr = new t41[br4VarB.a];
                for (int i6 = 0; i6 < br4VarB.a; i6++) {
                    t41 t41VarC = br4VarB.c(i6);
                    t41.b bVarB = t41VarC.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    sb.append(":");
                    String str = t41VarC.a;
                    if (str == null) {
                        str = "";
                    }
                    sb.append(str);
                    bVarB.k0(sb.toString());
                    if (t41VarC.n != null) {
                        bVarB.w0(i2 + ":" + t41VarC.n);
                    }
                    t41VarArr[i6] = bVarB.Q();
                }
                br4 br4Var = new br4(i2 + ":" + br4VarB.b, t41VarArr);
                this.k.put(br4Var, br4VarB);
                br4VarArr[i3] = br4Var;
                i5++;
                i3++;
            }
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return this.o.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        this.o.g(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long h(long j) {
        boolean z = true;
        for (mi2 mi2Var : this.f) {
            z &= mi2Var.h(j) == j;
        }
        if (z) {
            return j;
        }
        return Long.MIN_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.o.isLoading();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[jy0VarArr.length];
        int[] iArr2 = new int[jy0VarArr.length];
        int i = 0;
        for (int i2 = 0; i2 < jy0VarArr.length; i2++) {
            gx3 gx3Var = gx3VarArr[i2];
            Integer num = gx3Var == null ? null : (Integer) this.h.get(gx3Var);
            iArr[i2] = num == null ? -1 : num.intValue();
            jy0 jy0Var = jy0VarArr[i2];
            if (jy0Var != null) {
                String str = jy0Var.c().b;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
        }
        this.h.clear();
        int length = jy0VarArr.length;
        gx3[] gx3VarArr2 = new gx3[length];
        gx3[] gx3VarArr3 = new gx3[jy0VarArr.length];
        jy0[] jy0VarArr2 = new jy0[jy0VarArr.length];
        ArrayList arrayList = new ArrayList(this.f.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.f.length) {
            for (int i4 = i; i4 < jy0VarArr.length; i4++) {
                gx3VarArr3[i4] = iArr[i4] == i3 ? gx3VarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    jy0 jy0Var2 = (jy0) gg3.q(jy0VarArr[i4]);
                    jy0VarArr2[i4] = new a(jy0Var2, (br4) gg3.q((br4) this.k.get(jy0Var2.c())));
                } else {
                    jy0VarArr2[i4] = null;
                }
            }
            int i5 = i3;
            long jK = this.f[i3].k(jy0VarArr2, zArr, gx3VarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jK;
            } else if (jK != j2) {
                e04.a("Children enabled at different positions.");
                return 0L;
            }
            boolean z = false;
            for (int i6 = 0; i6 < jy0VarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    gx3 gx3Var2 = (gx3) gg3.q(gx3VarArr3[i6]);
                    gx3VarArr2[i6] = gx3VarArr3[i6];
                    this.h.put(gx3Var2, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    gg3.v(gx3VarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.f[i5]);
            }
            i3 = i5 + 1;
            i = 0;
        }
        int i7 = i;
        System.arraycopy(gx3VarArr2, i7, gx3VarArr, i7, length);
        this.n = (mi2[]) arrayList.toArray(new mi2[i7]);
        this.o = this.i.a(arrayList, ru1.i(arrayList, new p81() { // from class: ls2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((mi2) obj).s().c();
            }
        }));
        return j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void m() {
        for (mi2 mi2Var : this.f) {
            mi2Var.m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long n(long j) {
        long jN = this.n[0].n(j);
        int i = 1;
        while (true) {
            mi2[] mi2VarArr = this.n;
            if (i >= mi2VarArr.length) {
                return jN;
            }
            if (mi2VarArr[i].n(jN) != jN) {
                e04.a("Unexpected child seekToUs result.");
                return 0L;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mi2 o(int i) {
        boolean z = this.g[i];
        mi2[] mi2VarArr = this.f;
        return z ? ((io4) mi2VarArr[i]).a() : mi2VarArr[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Li14;)V */
    @Override // i14.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void j(mi2 mi2Var) {
        ((mi2.a) gg3.q(this.l)).j(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        r7 = r10;
     */
    @Override // defpackage.mi2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long q() {
        long j;
        mi2 mi2Var;
        mi2[] mi2VarArr = this.n;
        int length = mi2VarArr.length;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        int i = 0;
        while (i < length) {
            mi2 mi2Var2 = mi2VarArr[i];
            long jQ = mi2Var2.q();
            if (jQ == j2) {
                j = j2;
                if (j3 != j && mi2Var2.n(j3) != j3) {
                    e04.a("Unexpected child seekToUs result.");
                    return 0L;
                }
            } else if (j3 == j2) {
                mi2[] mi2VarArr2 = this.n;
                int length2 = mi2VarArr2.length;
                int i2 = 0;
                while (true) {
                    j = j2;
                    if (i2 >= length2 || (mi2Var = mi2VarArr2[i2]) == mi2Var2) {
                        break;
                    }
                    if (mi2Var.n(jQ) != jQ) {
                        e04.a("Unexpected child seekToUs result.");
                        return 0L;
                    }
                    i2++;
                    j2 = j;
                }
            } else {
                j = j2;
                if (jQ != j3) {
                    e04.a("Conflicting discontinuities.");
                    return 0L;
                }
            }
            i++;
            j2 = j;
        }
        return j3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.l = aVar;
        Collections.addAll(this.j, this.f);
        for (mi2 mi2Var : this.f) {
            mi2Var.r(this, j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public er4 s() {
        return (er4) gg3.q(this.m);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        for (mi2 mi2Var : this.n) {
            mi2Var.t(j, z);
        }
    }
}
