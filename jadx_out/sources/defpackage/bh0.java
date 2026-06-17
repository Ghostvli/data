package defpackage;

import android.util.Base64;
import defpackage.bd3;
import defpackage.jq2;
import defpackage.no4;
import defpackage.p5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bh0 implements bd3 {
    public static final xi4 i = new xi4() { // from class: ah0
        @Override // defpackage.xi4
        public final Object get() {
            return bh0.m();
        }
    };
    public static final Random j = new Random();
    public final no4.d a;
    public final no4.b b;
    public final HashMap c;
    public final xi4 d;
    public bd3.a e;
    public no4 f;
    public String g;
    public long h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a {
        public final String a;
        public int b;
        public long c;
        public jq2.b d;
        public boolean e;
        public boolean f;

        public a(String str, int i, jq2.b bVar) {
            this.a = str;
            this.b = i;
            this.c = bVar == null ? -1L : bVar.d;
            if (bVar == null || !bVar.c()) {
                return;
            }
            this.d = bVar;
        }

        public boolean i(int i, jq2.b bVar) {
            if (bVar != null) {
                long j = bVar.d;
                if (j != -1) {
                    jq2.b bVar2 = this.d;
                    return bVar2 == null ? !bVar.c() && bVar.d == this.c : j == bVar2.d && bVar.b == bVar2.b && bVar.c == bVar2.c;
                }
            }
            return i == this.b;
        }

        public boolean j(p5.a aVar) {
            jq2.b bVar = aVar.d;
            if (bVar == null) {
                return this.b != aVar.c;
            }
            long j = this.c;
            if (j == -1) {
                return false;
            }
            if (bVar.d > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int iH = aVar.b.h(bVar.a);
            int iH2 = aVar.b.h(this.d.a);
            jq2.b bVar2 = aVar.d;
            if (bVar2.d < this.d.d || iH < iH2) {
                return false;
            }
            if (iH > iH2) {
                return true;
            }
            boolean zC = bVar2.c();
            jq2.b bVar3 = aVar.d;
            if (!zC) {
                int i = bVar3.e;
                return i == -1 || i > this.d.b;
            }
            int i2 = bVar3.b;
            int i3 = bVar3.c;
            jq2.b bVar4 = this.d;
            int i4 = bVar4.b;
            return i2 > i4 || (i2 == i4 && i3 > bVar4.c);
        }

        public void k(int i, jq2.b bVar) {
            if (this.c != -1 || i != this.b || bVar == null || bVar.d < bh0.this.n()) {
                return;
            }
            this.c = bVar.d;
        }

        public final int l(no4 no4Var, no4 no4Var2, int i) {
            if (i >= no4Var.v()) {
                if (i < no4Var2.v()) {
                    return i;
                }
                return -1;
            }
            no4Var.t(i, bh0.this.a);
            for (int i2 = bh0.this.a.n; i2 <= bh0.this.a.o; i2++) {
                int iH = no4Var2.h(no4Var.s(i2));
                if (iH != -1) {
                    return no4Var2.l(iH, bh0.this.b).c;
                }
            }
            return -1;
        }

        public boolean m(no4 no4Var, no4 no4Var2) {
            int iL = l(no4Var, no4Var2, this.b);
            this.b = iL;
            if (iL == -1) {
                return false;
            }
            jq2.b bVar = this.d;
            return bVar == null || no4Var2.h(bVar.a) != -1;
        }
    }

    public bh0(xi4 xi4Var) {
        this.d = xi4Var;
        this.a = new no4.d();
        this.b = new no4.b();
        this.c = new HashMap();
        this.f = no4.a;
        this.h = -1L;
    }

    public static String m() {
        byte[] bArr = new byte[12];
        j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // defpackage.bd3
    public synchronized String a() {
        return this.g;
    }

    @Override // defpackage.bd3
    public synchronized String b(no4 no4Var, jq2.b bVar) {
        return o(no4Var.n(bVar.a, this.b).c, bVar).a;
    }

    @Override // defpackage.bd3
    public synchronized void c(p5.a aVar, int i2) {
        try {
            gg3.q(this.e);
            boolean z = i2 == 0;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.j(aVar)) {
                    it.remove();
                    boolean zEquals = aVar2.a.equals(this.g);
                    if (zEquals) {
                        l(aVar2);
                    }
                    if (aVar2.e) {
                        this.e.p(aVar, aVar2.a, z && zEquals && aVar2.f);
                    }
                }
            }
            p(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.bd3
    public synchronized void d(p5.a aVar) {
        bd3.a aVar2;
        try {
            String str = this.g;
            if (str != null) {
                l((a) gg3.q((a) this.c.get(str)));
            }
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar3 = (a) it.next();
                it.remove();
                if (aVar3.e && (aVar2 = this.e) != null) {
                    aVar2.p(aVar, aVar3.a, false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.bd3
    public synchronized void e(p5.a aVar) {
        try {
            gg3.q(this.e);
            no4 no4Var = this.f;
            this.f = aVar.b;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (!aVar2.m(no4Var, this.f) || aVar2.j(aVar)) {
                    it.remove();
                    if (aVar2.a.equals(this.g)) {
                        l(aVar2);
                    }
                    if (aVar2.e) {
                        this.e.p(aVar, aVar2.a, false);
                    }
                }
            }
            p(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.bd3
    public synchronized void f(p5.a aVar) {
        gg3.q(this.e);
        if (aVar.b.w()) {
            return;
        }
        jq2.b bVar = aVar.d;
        if (bVar != null) {
            long j2 = bVar.d;
            if (j2 != -1 && j2 < n()) {
                return;
            }
            a aVar2 = (a) this.c.get(this.g);
            if (aVar2 != null && aVar2.c == -1 && aVar2.b != aVar.c) {
                return;
            }
        }
        a aVarO = o(aVar.c, aVar.d);
        if (this.g == null) {
            this.g = aVarO.a;
        }
        jq2.b bVar2 = aVar.d;
        if (bVar2 != null && bVar2.c()) {
            jq2.b bVar3 = aVar.d;
            jq2.b bVar4 = new jq2.b(bVar3.a, bVar3.d, bVar3.b);
            a aVarO2 = o(aVar.c, bVar4);
            if (!aVarO2.e) {
                aVarO2.e = true;
                aVar.b.n(aVar.d.a, this.b);
                this.e.f(new p5.a(aVar.a, aVar.b, aVar.c, bVar4, Math.max(0L, fy4.S1(this.b.g(aVar.d.b)) + this.b.o()), aVar.f, aVar.g, aVar.h, aVar.i, aVar.j), aVarO2.a);
            }
        }
        if (!aVarO.e) {
            aVarO.e = true;
            this.e.f(aVar, aVarO.a);
        }
        if (aVarO.a.equals(this.g) && !aVarO.f) {
            aVarO.f = true;
            this.e.F(aVar, aVarO.a);
        }
    }

    @Override // defpackage.bd3
    public void g(bd3.a aVar) {
        this.e = aVar;
    }

    public final void l(a aVar) {
        if (aVar.c != -1 && aVar.e) {
            this.h = aVar.c;
        }
        this.g = null;
    }

    public final long n() {
        a aVar = (a) this.c.get(this.g);
        return (aVar == null || aVar.c == -1) ? this.h + 1 : aVar.c;
    }

    public final a o(int i2, jq2.b bVar) {
        a aVar = null;
        long j2 = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            aVar2.k(i2, bVar);
            if (aVar2.i(i2, bVar)) {
                long j3 = aVar2.c;
                if (j3 == -1 || j3 < j2) {
                    aVar = aVar2;
                    j2 = j3;
                } else if (j3 == j2 && ((a) fy4.l(aVar)).d != null && aVar2.d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = (String) this.d.get();
        a aVar3 = new a(str, i2, bVar);
        this.c.put(str, aVar3);
        return aVar3;
    }

    public final void p(p5.a aVar) {
        if (aVar.b.w()) {
            String str = this.g;
            if (str != null) {
                l((a) gg3.q((a) this.c.get(str)));
                return;
            }
            return;
        }
        a aVar2 = (a) this.c.get(this.g);
        a aVarO = o(aVar.c, aVar.d);
        this.g = aVarO.a;
        f(aVar);
        jq2.b bVar = aVar.d;
        if (bVar == null || !bVar.c()) {
            return;
        }
        if (aVar2 != null && aVar2.c == aVar.d.d && aVar2.d != null && aVar2.d.b == aVar.d.b && aVar2.d.c == aVar.d.c) {
            return;
        }
        jq2.b bVar2 = aVar.d;
        this.e.X(aVar, o(aVar.c, new jq2.b(bVar2.a, bVar2.d)).a, aVarO.a);
    }

    public bh0() {
        this(i);
    }
}
