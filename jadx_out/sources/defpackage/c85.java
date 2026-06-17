package defpackage;

import defpackage.d85;
import defpackage.ef4;
import defpackage.t41;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c85 extends ef4 {
    public a n;
    public int o;
    public boolean p;
    public d85.c q;
    public d85.a r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final d85.c a;
        public final d85.a b;
        public final byte[] c;
        public final d85.b[] d;
        public final int e;

        public a(d85.c cVar, d85.a aVar, byte[] bArr, d85.b[] bVarArr, int i) {
            this.a = cVar;
            this.b = aVar;
            this.c = bArr;
            this.d = bVarArr;
            this.e = i;
        }
    }

    public static void n(r73 r73Var, long j) {
        if (r73Var.b() < r73Var.j() + 4) {
            r73Var.c0(Arrays.copyOf(r73Var.f(), r73Var.j() + 4));
        } else {
            r73Var.e0(r73Var.j() + 4);
        }
        byte[] bArrF = r73Var.f();
        bArrF[r73Var.j() - 4] = (byte) (j & 255);
        bArrF[r73Var.j() - 3] = (byte) ((j >>> 8) & 255);
        bArrF[r73Var.j() - 2] = (byte) ((j >>> 16) & 255);
        bArrF[r73Var.j() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static int o(byte b, a aVar) {
        boolean z = aVar.d[p(b, aVar.e, 1)].a;
        d85.c cVar = aVar.a;
        return !z ? cVar.g : cVar.h;
    }

    public static int p(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean r(r73 r73Var) {
        try {
            return d85.o(1, r73Var, true);
        } catch (r83 unused) {
            return false;
        }
    }

    @Override // defpackage.ef4
    public void e(long j) {
        super.e(j);
        this.p = j != 0;
        d85.c cVar = this.q;
        this.o = cVar != null ? cVar.g : 0;
    }

    @Override // defpackage.ef4
    public long f(r73 r73Var) {
        if ((r73Var.f()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(r73Var.f()[0], (a) gg3.q(this.n));
        long j = this.p ? (this.o + iO) / 4 : 0;
        n(r73Var, j);
        this.p = true;
        this.o = iO;
        return j;
    }

    @Override // defpackage.ef4
    public boolean i(r73 r73Var, long j, ef4.b bVar) throws r83 {
        if (this.n != null) {
            gg3.q(bVar.a);
            return false;
        }
        a aVarQ = q(r73Var);
        this.n = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        d85.c cVar = aVarQ.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.j);
        arrayList.add(aVarQ.c);
        bVar.a = new t41.b().X("audio/ogg").A0("audio/vorbis").T(cVar.e).u0(cVar.d).U(cVar.b).B0(cVar.c).l0(arrayList).s0(d85.d(xi1.q(aVarQ.b.b))).Q();
        return true;
    }

    @Override // defpackage.ef4
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    public a q(r73 r73Var) throws r83 {
        d85.c cVar = this.q;
        if (cVar == null) {
            this.q = d85.l(r73Var);
            return null;
        }
        d85.a aVar = this.r;
        if (aVar == null) {
            this.r = d85.j(r73Var);
            return null;
        }
        byte[] bArr = new byte[r73Var.j()];
        System.arraycopy(r73Var.f(), 0, bArr, 0, r73Var.j());
        return new a(cVar, aVar, bArr, d85.m(r73Var, cVar.b), d85.b(r4.length - 1));
    }
}
