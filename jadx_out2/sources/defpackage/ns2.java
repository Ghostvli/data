package defpackage;

import defpackage.fg2;
import defpackage.jq2;
import defpackage.no4;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ns2 extends oy {
    public static final fg2 C = new fg2.c().e("MergingMediaSource").a();
    public c A;
    public boolean B;
    public final boolean p;
    public final boolean q;
    public final jq2[] r;
    public final List s;
    public final no4[] t;
    public final ArrayList u;
    public final qy v;
    public final Map w;
    public final dw2 x;
    public int y;
    public long[][] z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends i51 {
        public final long[] f;
        public final long[] g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(no4 no4Var, Map map) {
            super(no4Var);
            int iV = no4Var.v();
            this.g = new long[no4Var.v()];
            no4.d dVar = new no4.d();
            for (int i = 0; i < iV; i++) {
                this.g[i] = no4Var.t(i, dVar).m;
            }
            int iO = no4Var.o();
            this.f = new long[iO];
            no4.b bVar = new no4.b();
            for (int i2 = 0; i2 < iO; i2++) {
                no4Var.m(i2, bVar, true);
                long jLongValue = ((Long) gg3.q((Long) map.get(bVar.b))).longValue();
                long[] jArr = this.f;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.d : jLongValue;
                jArr[i2] = jLongValue;
                long j = bVar.d;
                if (j != -9223372036854775807L) {
                    long[] jArr2 = this.g;
                    int i3 = bVar.c;
                    jArr2[i3] = jArr2[i3] - (j - jLongValue);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            super.m(i, bVar, z);
            bVar.d = this.f[i];
            return bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        @Override // defpackage.i51, defpackage.no4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public no4.d u(int i, no4.d dVar, long j) {
            long jMin;
            super.u(i, dVar, j);
            long j2 = this.g[i];
            dVar.m = j2;
            if (j2 != -9223372036854775807L) {
                long j3 = dVar.l;
                jMin = j3 == -9223372036854775807L ? dVar.l : Math.min(j3, j2);
            }
            dVar.l = jMin;
            return dVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends IOException {
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final jq2.b a;
        public final mi2 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(jq2.b bVar, mi2 mi2Var) {
            this.a = bVar;
            this.b = mi2Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ns2(boolean z, boolean z2, qy qyVar, jq2... jq2VarArr) {
        this.p = z;
        this.q = z2;
        this.r = jq2VarArr;
        this.v = qyVar;
        this.u = new ArrayList(Arrays.asList(jq2VarArr));
        this.y = -1;
        this.s = new ArrayList(jq2VarArr.length);
        for (int i = 0; i < jq2VarArr.length; i++) {
            this.s.add(new ArrayList());
        }
        this.t = new no4[jq2VarArr.length];
        this.z = new long[0][];
        this.w = new HashMap();
        this.x = ew2.a().a().e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oy, defpackage.ji
    public void E(hs4 hs4Var) {
        super.E(hs4Var);
        for (int i = 0; i < this.r.length; i++) {
            O(Integer.valueOf(i), this.r[i]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oy, defpackage.ji
    public void G() {
        super.G();
        Arrays.fill(this.t, (Object) null);
        this.y = -1;
        this.A = null;
        this.u.clear();
        Collections.addAll(this.u, this.r);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P() {
        no4.b bVar = new no4.b();
        for (int i = 0; i < this.y; i++) {
            long j = -this.t[0].l(i, bVar).p();
            int i2 = 1;
            while (true) {
                no4[] no4VarArr = this.t;
                if (i2 < no4VarArr.length) {
                    this.z[i][i2] = j - (-no4VarArr[i2].l(i, bVar).p());
                    i2++;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: K(Ljava/lang/Object;Ljq2$b;)Ljq2$b; */
    @Override // defpackage.oy
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public jq2.b K(Integer num, jq2.b bVar) {
        List list = (List) this.s.get(num.intValue());
        for (int i = 0; i < list.size(); i++) {
            if (((d) list.get(i)).a.equals(bVar)) {
                return ((d) ((List) this.s.get(0)).get(i)).a;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: N(Ljava/lang/Object;Ljq2;Lno4;)V */
    @Override // defpackage.oy
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void N(Integer num, jq2 jq2Var, no4 no4Var) {
        if (this.A != null) {
            return;
        }
        if (this.y == -1) {
            this.y = no4Var.o();
        } else if (no4Var.o() != this.y) {
            this.A = new c(0);
            return;
        }
        if (this.z.length == 0) {
            this.z = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.y, this.t.length);
        }
        this.u.remove(jq2Var);
        this.t[num.intValue()] = no4Var;
        if (this.u.isEmpty()) {
            if (this.p) {
                P();
            }
            no4 bVar = this.t[0];
            if (this.q) {
                S();
                bVar = new b(bVar, this.w);
            }
            F(bVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S() {
        no4[] no4VarArr;
        no4.b bVar = new no4.b();
        for (int i = 0; i < this.y; i++) {
            int i2 = 0;
            long j = Long.MIN_VALUE;
            while (true) {
                no4VarArr = this.t;
                if (i2 >= no4VarArr.length) {
                    break;
                }
                long jL = no4VarArr[i2].l(i, bVar).l();
                if (jL != -9223372036854775807L) {
                    long j2 = jL + this.z[i][i2];
                    if (j == Long.MIN_VALUE || j2 < j) {
                        j = j2;
                    }
                }
                i2++;
            }
            Object objS = no4VarArr[0].s(i);
            this.w.put(objS, Long.valueOf(j));
            Iterator it = this.x.get(objS).iterator();
            while (it.hasNext()) {
                ((wu) it.next()).B(0L, j);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        jq2[] jq2VarArr = this.r;
        return jq2VarArr.length > 0 && jq2VarArr[0].a(fg2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        int length = this.r.length;
        mi2[] mi2VarArr = new mi2[length];
        int iH = this.t[0].h(bVar.a);
        for (int i = 0; i < length; i++) {
            jq2.b bVarA = bVar.a(this.t[i].s(iH));
            mi2VarArr[i] = this.r[i].d(bVarA, j5Var, j - this.z[iH][i]);
            ((List) this.s.get(i)).add(new d(bVarA, mi2VarArr[i]));
        }
        ms2 ms2Var = new ms2(this.v, this.z[iH], mi2VarArr);
        if (!this.q) {
            return ms2Var;
        }
        wu wuVar = new wu(ms2Var, false, 0L, ((Long) gg3.q((Long) this.w.get(bVar.a))).longValue(), this.B);
        this.x.put(bVar.a, wuVar);
        return wuVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public fg2 i() {
        jq2[] jq2VarArr = this.r;
        return jq2VarArr.length > 0 ? jq2VarArr[0].i() : C;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oy, defpackage.jq2
    public void m() throws c {
        c cVar = this.A;
        if (cVar != null) {
            throw cVar;
        }
        super.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void q(fg2 fg2Var) {
        this.r[0].q(fg2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        if (this.q) {
            wu wuVar = (wu) mi2Var;
            Iterator it = this.x.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((wu) entry.getValue()).equals(wuVar)) {
                    this.x.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            mi2Var = wuVar.f;
        }
        ms2 ms2Var = (ms2) mi2Var;
        for (int i = 0; i < this.r.length; i++) {
            List list = (List) this.s.get(i);
            mi2 mi2VarO = ms2Var.o(i);
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                if (((d) list.get(i2)).b.equals(mi2VarO)) {
                    list.remove(i2);
                    break;
                }
                i2++;
            }
            this.r[i].s(ms2Var.o(i));
        }
    }

    public ns2(boolean z, jq2... jq2VarArr) {
        this(z, false, jq2VarArr);
    }

    public ns2(boolean z, boolean z2, jq2... jq2VarArr) {
        this(z, z2, new te0(), jq2VarArr);
    }

    public ns2(jq2... jq2VarArr) {
        this(false, jq2VarArr);
    }
}
