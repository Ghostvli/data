package defpackage;

import defpackage.ki4;
import defpackage.t41;
import defpackage.yz3;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ef implements hz0 {
    public final r73 a;
    public final c b;
    public final boolean c;
    public final ki4.a d;
    public int e;
    public mz0 f;
    public ff g;
    public long h;
    public vt[] i;
    public long j;
    public vt k;
    public int l;
    public long m;
    public long n;
    public int o;
    public boolean p;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements yz3 {
        public final long a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(long j) {
            this.a = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.yz3
        public boolean e() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.yz3
        public yz3.a g(long j) {
            yz3.a aVarI = ef.this.i[0].i(j);
            for (int i = 1; i < ef.this.i.length; i++) {
                yz3.a aVarI2 = ef.this.i[i].i(j);
                if (aVarI2.a.b < aVarI.a.b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.yz3
        public long i() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public int a;
        public int b;
        public int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(r73 r73Var) {
            this.a = r73Var.D();
            this.b = r73Var.D();
            this.c = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(r73 r73Var) throws r83 {
            a(r73Var);
            if (this.a == 1414744396) {
                this.c = r73Var.D();
            } else {
                throw r83.a("LIST expected, found: " + this.a, null);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ef(int i, ki4.a aVar) {
        this.d = aVar;
        this.c = (i & 1) == 0;
        this.a = new r73(12);
        this.b = new c();
        this.f = new g33();
        this.i = new vt[0];
        this.m = -1L;
        this.n = -1L;
        this.l = -1;
        this.h = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(jz0 jz0Var) {
        if ((jz0Var.getPosition() & 1) == 1) {
            jz0Var.q(1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.j = -1L;
        this.k = null;
        for (vt vtVar : this.i) {
            vtVar.o(j);
        }
        if (j != 0) {
            this.e = 6;
        } else if (this.i.length == 0) {
            this.e = 0;
        } else {
            this.e = 3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.e = 0;
        if (this.c) {
            mz0Var = new li4(mz0Var, this.d);
        }
        this.f = mz0Var;
        this.j = -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        if (o(jz0Var, yf3Var)) {
            return 1;
        }
        switch (this.e) {
            case 0:
                if (!e(jz0Var)) {
                    throw r83.a("AVI Header List not found", null);
                }
                jz0Var.q(12);
                this.e = 1;
                return 0;
            case 1:
                jz0Var.readFully(this.a.f(), 0, 12);
                this.a.f0(0);
                this.b.b(this.a);
                c cVar = this.b;
                if (cVar.c == 1819436136) {
                    this.l = cVar.b;
                    this.e = 2;
                    return 0;
                }
                throw r83.a("hdrl expected, found: " + this.b.c, null);
            case 2:
                int i = this.l - 4;
                r73 r73Var = new r73(i);
                jz0Var.readFully(r73Var.f(), 0, i);
                j(r73Var);
                this.e = 3;
                return 0;
            case 3:
                if (this.m != -1) {
                    long position = jz0Var.getPosition();
                    long j = this.m;
                    if (position != j) {
                        this.j = j;
                        return 0;
                    }
                }
                jz0Var.s(this.a.f(), 0, 12);
                jz0Var.p();
                this.a.f0(0);
                this.b.a(this.a);
                int iD = this.a.D();
                int i2 = this.b.a;
                if (i2 == 1179011410) {
                    jz0Var.q(12);
                    return 0;
                }
                if (i2 != 1414744396 || iD != 1769369453) {
                    this.j = jz0Var.getPosition() + ((long) this.b.b) + 8;
                    return 0;
                }
                long position2 = jz0Var.getPosition();
                this.m = position2;
                this.n = position2 + ((long) this.b.b) + 8;
                if (!this.p) {
                    if (((ff) gg3.q(this.g)).a()) {
                        this.e = 4;
                        this.j = this.n;
                        return 0;
                    }
                    this.f.u(new yz3.b(this.h));
                    this.p = true;
                }
                this.j = jz0Var.getPosition() + 12;
                this.e = 6;
                return 0;
            case 4:
                jz0Var.readFully(this.a.f(), 0, 8);
                this.a.f0(0);
                int iD2 = this.a.D();
                int iD3 = this.a.D();
                if (iD2 == 829973609) {
                    this.e = 5;
                    this.o = iD3;
                } else {
                    this.j = jz0Var.getPosition() + ((long) iD3);
                }
                return 0;
            case 5:
                r73 r73Var2 = new r73(this.o);
                jz0Var.readFully(r73Var2.f(), 0, this.o);
                k(r73Var2);
                this.e = 6;
                this.j = this.m;
                return 0;
            case 6:
                return n(jz0Var);
            default:
                throw new AssertionError();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        jz0Var.s(this.a.f(), 0, 12);
        this.a.f0(0);
        if (this.a.D() != 1179011410) {
            return false;
        }
        this.a.g0(4);
        return this.a.D() == 541677121;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final vt i(int i) {
        for (vt vtVar : this.i) {
            if (vtVar.j(i)) {
                return vtVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(r73 r73Var) throws r83 {
        zt1 zt1VarC = zt1.c(1819436136, r73Var);
        if (zt1VarC.getType() != 1819436136) {
            throw r83.a("Unexpected header list type " + zt1VarC.getType(), null);
        }
        ff ffVar = (ff) zt1VarC.b(ff.class);
        if (ffVar == null) {
            throw r83.a("AviHeader not found", null);
        }
        this.g = ffVar;
        this.h = ((long) ffVar.c) * ((long) ffVar.a);
        ArrayList arrayList = new ArrayList();
        pw4 it = zt1VarC.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            df dfVar = (df) it.next();
            if (dfVar.getType() == 1819440243) {
                int i2 = i + 1;
                vt vtVarM = m((zt1) dfVar, i);
                if (vtVarM != null) {
                    arrayList.add(vtVarM);
                }
                i = i2;
            }
        }
        this.i = (vt[]) arrayList.toArray(new vt[0]);
        this.f.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(r73 r73Var) {
        int i;
        long jL = l(r73Var);
        while (true) {
            if (r73Var.a() < 16) {
                break;
            }
            int iD = r73Var.D();
            int iD2 = r73Var.D();
            long jD = ((long) r73Var.D()) + jL;
            r73Var.g0(4);
            vt vtVarI = i(iD);
            if (vtVarI != null) {
                vtVarI.b(jD, (iD2 & 16) == 16);
            }
        }
        for (vt vtVar : this.i) {
            vtVar.c();
        }
        this.p = true;
        int length = this.i.length;
        mz0 mz0Var = this.f;
        if (length == 0) {
            mz0Var.u(new yz3.b(this.h));
        } else {
            mz0Var.u(new b(this.h));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long l(r73 r73Var) {
        if (r73Var.a() < 16) {
            return 0L;
        }
        int iG = r73Var.g();
        r73Var.g0(8);
        long jD = r73Var.D();
        long j = this.m;
        long j2 = jD <= j ? j + 8 : 0L;
        r73Var.f0(iG);
        return j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final vt m(zt1 zt1Var, int i) {
        gf gfVar = (gf) zt1Var.b(gf.class);
        ve4 ve4Var = (ve4) zt1Var.b(ve4.class);
        if (gfVar == null) {
            xz1.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (ve4Var == null) {
            xz1.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = gfVar.a();
        t41 t41Var = ve4Var.a;
        t41.b bVarB = t41Var.b();
        bVarB.j0(i);
        int i2 = gfVar.f;
        if (i2 != 0) {
            bVarB.p0(i2);
        }
        df4 df4Var = (df4) zt1Var.b(df4.class);
        if (df4Var != null) {
            bVarB.m0(df4Var.a);
        }
        int iK = nt2.k(t41Var.p);
        if (iK != 1 && iK != 2) {
            return null;
        }
        gr4 gr4VarE = this.f.e(i, iK);
        gr4VarE.g(bVarB.Q());
        gr4VarE.e(jA);
        this.h = Math.max(this.h, jA);
        return new vt(i, gfVar, gr4VarE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n(jz0 jz0Var) {
        if (jz0Var.getPosition() >= this.n) {
            return -1;
        }
        vt vtVar = this.k;
        if (vtVar == null) {
            h(jz0Var);
            jz0Var.s(this.a.f(), 0, 12);
            this.a.f0(0);
            int iD = this.a.D();
            r73 r73Var = this.a;
            if (iD == 1414744396) {
                r73Var.f0(8);
                jz0Var.q(this.a.D() != 1769369453 ? 8 : 12);
                jz0Var.p();
                return 0;
            }
            int iD2 = r73Var.D();
            if (iD == 1263424842) {
                this.j = jz0Var.getPosition() + ((long) iD2) + 8;
                return 0;
            }
            jz0Var.q(8);
            jz0Var.p();
            vt vtVarI = i(iD);
            if (vtVarI == null) {
                this.j = jz0Var.getPosition() + ((long) iD2);
                return 0;
            }
            vtVarI.n(iD2);
            this.k = vtVarI;
        } else if (vtVar.m(jz0Var)) {
            this.k = null;
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(jz0 jz0Var, yf3 yf3Var) {
        boolean z;
        if (this.j != -1) {
            long position = jz0Var.getPosition();
            long j = this.j;
            if (j < position || j > 262144 + position) {
                yf3Var.a = j;
                z = true;
            } else {
                jz0Var.q((int) (j - position));
                z = false;
            }
        } else {
            z = false;
        }
        this.j = -1L;
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }
}
