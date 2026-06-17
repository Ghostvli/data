package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import defpackage.jq2;
import defpackage.no4;
import defpackage.xi1;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wy extends oy {
    public final xi1 p;
    public final IdentityHashMap q;
    public Handler r;
    public boolean s;
    public fg2 t;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final xi1.a a = xi1.m();
        public int b;
        public fg2 c;

        public b a(jq2 jq2Var, long j) {
            gg3.q(jq2Var);
            gg3.w(((jq2Var instanceof xh3) && j == -9223372036854775807L) ? false : true, "Progressive media source must define an initial placeholder duration.");
            xi1.a aVar = this.a;
            int i = this.b;
            this.b = i + 1;
            aVar.a(new d(jq2Var, i, fy4.c1(j)));
            return this;
        }

        public wy b() {
            gg3.e(this.b > 0, "Must add at least one source to the concatenation.");
            if (this.c == null) {
                this.c = fg2.c(Uri.EMPTY);
            }
            return new wy(this.c, this.a.k());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends no4 {
        public final fg2 e;
        public final xi1 f;
        public final xi1 g;
        public final xi1 h;
        public final boolean i;
        public final boolean j;
        public final long k;
        public final long l;
        public final Object m;

        public c(fg2 fg2Var, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, boolean z, boolean z2, long j, long j2, Object obj) {
            this.e = fg2Var;
            this.f = xi1Var;
            this.g = xi1Var2;
            this.h = xi1Var3;
            this.i = z;
            this.j = z2;
            this.k = j;
            this.l = j2;
            this.m = obj;
        }

        private int z(int i) {
            return fy4.i(this.g, Integer.valueOf(i + 1), false, false);
        }

        public final long A(no4.b bVar, int i) {
            if (bVar.d == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return (i == this.h.size() + (-1) ? this.k : ((Long) this.h.get(i + 1)).longValue()) - ((Long) this.h.get(i)).longValue();
        }

        @Override // defpackage.no4
        public int h(Object obj) {
            if (!(obj instanceof Pair) || !(((Pair) obj).first instanceof Integer)) {
                return -1;
            }
            int iU = wy.U(obj);
            int iH = ((no4) this.f.get(iU)).h(wy.W(obj));
            if (iH == -1) {
                return -1;
            }
            return ((Integer) this.g.get(iU)).intValue() + iH;
        }

        @Override // defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            int iZ = z(i);
            ((no4) this.f.get(iZ)).m(i - ((Integer) this.g.get(iZ)).intValue(), bVar, z);
            bVar.c = 0;
            bVar.e = ((Long) this.h.get(i)).longValue();
            bVar.d = A(bVar, i);
            if (z) {
                bVar.b = wy.a0(iZ, gg3.q(bVar.b));
            }
            return bVar;
        }

        @Override // defpackage.no4
        public no4.b n(Object obj, no4.b bVar) {
            int iU = wy.U(obj);
            Object objW = wy.W(obj);
            no4 no4Var = (no4) this.f.get(iU);
            int iIntValue = ((Integer) this.g.get(iU)).intValue() + no4Var.h(objW);
            no4Var.n(objW, bVar);
            bVar.c = 0;
            bVar.e = ((Long) this.h.get(iIntValue)).longValue();
            bVar.d = A(bVar, iIntValue);
            bVar.b = obj;
            return bVar;
        }

        @Override // defpackage.no4
        public int o() {
            return this.h.size();
        }

        @Override // defpackage.no4
        public Object s(int i) {
            int iZ = z(i);
            return wy.a0(iZ, ((no4) this.f.get(iZ)).s(i - ((Integer) this.g.get(iZ)).intValue()));
        }

        @Override // defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            return dVar.h(no4.d.q, this.e, this.m, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.i, this.j, null, this.l, this.k, 0, o() - 1, -((Long) this.h.get(0)).longValue());
        }

        @Override // defpackage.no4
        public int v() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final i52 a;
        public final int b;
        public final long c;
        public final HashMap d = new HashMap();
        public int e;

        public d(jq2 jq2Var, int i, long j) {
            this.a = new i52(jq2Var, false);
            this.b = i;
            this.c = j;
        }
    }

    public wy(fg2 fg2Var, xi1 xi1Var) {
        this.t = fg2Var;
        this.p = xi1Var;
        this.q = new IdentityHashMap();
    }

    public static int U(Object obj) {
        return ((Integer) ((Pair) obj).first).intValue();
    }

    public static int V(long j, int i) {
        return (int) (j % ((long) i));
    }

    public static Object W(Object obj) {
        return ((Pair) obj).second;
    }

    public static long X(long j, int i, int i2) {
        return (j * ((long) i)) + ((long) i2);
    }

    public static Object a0(int i, Object obj) {
        return Pair.create(Integer.valueOf(i), obj);
    }

    public static long c0(long j, int i) {
        return j / ((long) i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d0(Message message) {
        if (message.what == 1) {
            h0();
        }
        return true;
    }

    @Override // defpackage.oy, defpackage.ji
    public void B() {
    }

    @Override // defpackage.oy, defpackage.ji
    public void E(hs4 hs4Var) {
        super.E(hs4Var);
        this.r = new Handler(new Handler.Callback() { // from class: vy
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f.d0(message);
            }
        });
        for (int i = 0; i < this.p.size(); i++) {
            O(Integer.valueOf(i), ((d) this.p.get(i)).a);
        }
        g0();
    }

    @Override // defpackage.oy, defpackage.ji
    public void G() {
        super.G();
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.r = null;
        }
        this.s = false;
    }

    public final void T() {
        for (int i = 0; i < this.p.size(); i++) {
            d dVar = (d) this.p.get(i);
            if (dVar.e == 0) {
                I(Integer.valueOf(dVar.b));
            }
        }
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public jq2.b K(Integer num, jq2.b bVar) {
        if (num.intValue() != V(bVar.d, this.p.size())) {
            return null;
        }
        return bVar.a(a0(num.intValue(), bVar.a)).b(c0(bVar.d, this.p.size()));
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public long L(Integer num, long j, jq2.b bVar) {
        Long l;
        return (j == -9223372036854775807L || bVar == null || bVar.c() || (l = (Long) ((d) this.p.get(num.intValue())).d.get(bVar.a)) == null) ? j : j + fy4.S1(l.longValue());
    }

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        return true;
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public int M(Integer num, int i) {
        return 0;
    }

    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        d dVar = (d) this.p.get(U(bVar.a));
        jq2.b bVarB = bVar.a(W(bVar.a)).b(X(bVar.d, this.p.size(), dVar.b));
        J(Integer.valueOf(dVar.b));
        dVar.e++;
        long jLongValue = bVar.c() ? 0L : ((Long) gg3.q((Long) dVar.d.get(bVarB.a))).longValue();
        io4 io4Var = new io4(dVar.a.d(bVarB, j5Var, j - jLongValue), jLongValue);
        this.q.put(io4Var, dVar);
        T();
        return io4Var;
    }

    public final c e0() {
        xi1.a aVar;
        xi1.a aVar2;
        int i;
        long j;
        long j2;
        no4.d dVar;
        boolean z;
        wy wyVar = this;
        no4.d dVar2 = new no4.d();
        no4.b bVar = new no4.b();
        xi1.a aVarM = xi1.m();
        xi1.a aVarM2 = xi1.m();
        xi1.a aVarM3 = xi1.m();
        int size = wyVar.p.size();
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i2 = 0;
        Object obj = null;
        int iO = 0;
        boolean z5 = false;
        boolean z6 = false;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (i2 < size) {
            d dVar3 = (d) wyVar.p.get(i2);
            no4 no4VarC0 = dVar3.a.c0();
            gg3.e(no4VarC0.w() ^ z2, "Can't concatenate empty child Timeline.");
            aVarM.a(no4VarC0);
            aVarM2.a(Integer.valueOf(iO));
            iO += no4VarC0.o();
            int i3 = 0;
            while (i3 < no4VarC0.v()) {
                no4VarC0.t(i3, dVar2);
                if (!z5) {
                    z5 = z2;
                    obj = dVar2.d;
                }
                z3 = (z3 && Objects.equals(obj, dVar2.d)) ? z2 : false;
                no4 no4Var = no4VarC0;
                long j6 = dVar2.m;
                if (j6 == -9223372036854775807L) {
                    j6 = dVar3.c;
                    if (j6 == -9223372036854775807L) {
                        return null;
                    }
                }
                j3 += j6;
                if (dVar3.b == 0 && i3 == 0) {
                    aVar = aVarM;
                    aVar2 = aVarM2;
                    j4 = dVar2.l;
                    j5 = -dVar2.p;
                } else {
                    aVar = aVarM;
                    aVar2 = aVarM2;
                }
                z4 &= dVar2.h || dVar2.k;
                z6 |= dVar2.i;
                int i4 = dVar2.n;
                while (i4 <= dVar2.o) {
                    aVarM3.a(Long.valueOf(j5));
                    no4 no4Var2 = no4Var;
                    no4Var2.m(i4, bVar, true);
                    xi1.a aVar3 = aVarM3;
                    long j7 = bVar.d;
                    if (j7 == -9223372036854775807L) {
                        gg3.e(dVar2.n == dVar2.o, "Can't apply placeholder duration to multiple periods with unknown duration in a single window.");
                        j7 = dVar2.p + j6;
                    }
                    if (i4 != dVar2.n || ((dVar3.b == 0 && i3 == 0) || j7 == -9223372036854775807L)) {
                        i = i4;
                        j = j7;
                        j2 = 0;
                    } else {
                        i = i4;
                        j2 = -dVar2.p;
                        j = j7 + j2;
                    }
                    Object objQ = gg3.q(bVar.b);
                    int i5 = i;
                    if (dVar3.e == 0 || !dVar3.d.containsKey(objQ)) {
                        dVar = dVar2;
                    } else {
                        dVar = dVar2;
                        if (!((Long) dVar3.d.get(objQ)).equals(Long.valueOf(j2))) {
                            z = false;
                        }
                        gg3.e(z, "Can't handle windows with changing offset in first period.");
                        dVar3.d.put(objQ, Long.valueOf(j2));
                        j5 += j;
                        i4 = i5 + 1;
                        aVarM3 = aVar3;
                        no4Var = no4Var2;
                        dVar2 = dVar;
                    }
                    z = true;
                    gg3.e(z, "Can't handle windows with changing offset in first period.");
                    dVar3.d.put(objQ, Long.valueOf(j2));
                    j5 += j;
                    i4 = i5 + 1;
                    aVarM3 = aVar3;
                    no4Var = no4Var2;
                    dVar2 = dVar;
                }
                i3++;
                aVarM = aVar;
                aVarM2 = aVar2;
                no4VarC0 = no4Var;
                z2 = true;
            }
            i2++;
            wyVar = this;
            z2 = true;
        }
        return new c(i(), aVarM.k(), aVarM2.k(), aVarM3.k(), z4, z6, j3, j4, z3 ? obj : null);
    }

    @Override // defpackage.oy
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void N(Integer num, jq2 jq2Var, no4 no4Var) {
        g0();
    }

    public final void g0() {
        if (this.s) {
            return;
        }
        ((Handler) gg3.q(this.r)).obtainMessage(1).sendToTarget();
        this.s = true;
    }

    public final void h0() {
        this.s = false;
        c cVarE0 = e0();
        if (cVarE0 != null) {
            F(cVarE0);
        }
    }

    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.t;
    }

    @Override // defpackage.jq2
    public no4 o() {
        return e0();
    }

    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.t = fg2Var;
    }

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((d) gg3.q((d) this.q.remove(mi2Var))).a.s(((io4) mi2Var).a());
        r0.e--;
        if (this.q.isEmpty()) {
            return;
        }
        T();
    }
}
