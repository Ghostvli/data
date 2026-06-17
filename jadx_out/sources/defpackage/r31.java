package defpackage;

import defpackage.yz3;
import org.mozilla.javascript.Context;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r31 implements hz0 {
    public static final pz0 q = new pz0() { // from class: q31
        @Override // defpackage.pz0
        public final hz0[] d() {
            return r31.g();
        }
    };
    public mz0 f;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public rd o;
    public h35 p;
    public final r73 a = new r73(4);
    public final r73 b = new r73(9);
    public final r73 c = new r73(11);
    public final r73 d = new r73();
    public final xy3 e = new xy3();
    public int g = 1;

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new r31()};
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.f = mz0Var;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        gg3.q(this.f);
        while (true) {
            int i = this.g;
            if (i != 1) {
                if (i == 2) {
                    n(jz0Var);
                } else if (i != 3) {
                    if (i != 4) {
                        z20.a();
                        return 0;
                    }
                    if (l(jz0Var)) {
                        return 0;
                    }
                } else if (!m(jz0Var)) {
                    return -1;
                }
            } else if (!k(jz0Var)) {
                return -1;
            }
        }
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        jz0Var.s(this.a.f(), 0, 3);
        this.a.f0(0);
        if (this.a.T() != 4607062) {
            return false;
        }
        jz0Var.s(this.a.f(), 0, 2);
        this.a.f0(0);
        if ((this.a.Y() & Context.VERSION_ECMASCRIPT) != 0) {
            return false;
        }
        jz0Var.s(this.a.f(), 0, 4);
        this.a.f0(0);
        int iZ = this.a.z();
        jz0Var.p();
        jz0Var.m(iZ);
        jz0Var.s(this.a.f(), 0, 4);
        this.a.f0(0);
        return this.a.z() == 0;
    }

    public final void h() {
        if (this.n) {
            return;
        }
        this.f.u(new yz3.b(-9223372036854775807L));
        this.n = true;
    }

    public final long i() {
        if (this.h) {
            return this.i + this.m;
        }
        if (this.e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.m;
    }

    public final r73 j(jz0 jz0Var) {
        int i = this.l;
        int iB = this.d.b();
        r73 r73Var = this.d;
        if (i > iB) {
            r73Var.d0(new byte[Math.max(r73Var.b() * 2, this.l)], 0);
        } else {
            r73Var.f0(0);
        }
        this.d.e0(this.l);
        jz0Var.readFully(this.d.f(), 0, this.l);
        return this.d;
    }

    public final boolean k(jz0 jz0Var) {
        if (!jz0Var.d(this.b.f(), 0, 9, true)) {
            return false;
        }
        this.b.f0(0);
        this.b.g0(4);
        int iQ = this.b.Q();
        boolean z = (iQ & 4) != 0;
        boolean z2 = (iQ & 1) != 0;
        if (z && this.o == null) {
            this.o = new rd(this.f.e(8, 1));
        }
        if (z2 && this.p == null) {
            this.p = new h35(this.f.e(9, 2));
        }
        this.f.o();
        this.j = this.b.z() - 5;
        this.g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(defpackage.jz0 r10) {
        /*
            r9 = this;
            long r0 = r9.i()
            int r2 = r9.k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            rd r3 = r9.o
            if (r3 == 0) goto L23
            r9.h()
            rd r2 = r9.o
            r73 r10 = r9.j(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            h35 r3 = r9.p
            if (r3 == 0) goto L39
            r9.h()
            h35 r2 = r9.p
            r73 r10 = r9.j(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.n
            if (r2 != 0) goto L6e
            xy3 r2 = r9.e
            r73 r10 = r9.j(r10)
            boolean r10 = r2.a(r10, r0)
            xy3 r0 = r9.e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            mz0 r2 = r9.f
            mj1 r3 = new mj1
            xy3 r7 = r9.e
            long[] r7 = r7.e()
            xy3 r8 = r9.e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.u(r3)
            r9.n = r6
            goto L21
        L6e:
            int r0 = r9.l
            r10.q(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.h = r6
            xy3 r10 = r9.e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.i = r1
        L8f:
            r10 = 4
            r9.j = r10
            r10 = 2
            r9.g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r31.l(jz0):boolean");
    }

    public final boolean m(jz0 jz0Var) {
        if (!jz0Var.d(this.c.f(), 0, 11, true)) {
            return false;
        }
        this.c.f0(0);
        this.k = this.c.Q();
        this.l = this.c.T();
        this.m = this.c.T();
        this.m = (((long) (this.c.Q() << 24)) | this.m) * 1000;
        this.c.g0(3);
        this.g = 4;
        return true;
    }

    public final void n(jz0 jz0Var) {
        jz0Var.q(this.j);
        this.j = 0;
        this.g = 3;
    }

    @Override // defpackage.hz0
    public void release() {
    }
}
