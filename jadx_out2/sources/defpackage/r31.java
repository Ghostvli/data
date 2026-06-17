package defpackage;

import defpackage.yz3;
import org.mozilla.javascript.Context;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r31 implements hz0 {
    public static final pz0 q = new pz0() { // from class: q31
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: FILLED_NEW_ARRAY (wrap:r31:0x0002: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:3) call: r31.<init>():void type: CONSTRUCTOR) (LINE:7) elemType: hz0 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new r31()};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.f = mz0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        if (this.n) {
            return;
        }
        this.f.u(new yz3.b(-9223372036854775807L));
        this.n = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long i() {
        if (this.h) {
            return this.i + this.m;
        }
        if (this.e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(jz0 jz0Var) {
        boolean zA;
        boolean z;
        long jI = i();
        int i = this.k;
        if (i == 8 && this.o != null) {
            h();
            zA = this.o.a(j(jz0Var), jI);
        } else if (i == 9 && this.p != null) {
            h();
            zA = this.p.a(j(jz0Var), jI);
        } else {
            if (i != 18 || this.n) {
                jz0Var.q(this.l);
                zA = false;
                z = false;
                if (!this.h && zA) {
                    this.h = true;
                    this.i = this.e.d() != -9223372036854775807L ? -this.m : 0L;
                }
                this.j = 4;
                this.g = 2;
                return z;
            }
            zA = this.e.a(j(jz0Var), jI);
            long jD = this.e.d();
            if (jD != -9223372036854775807L) {
                this.f.u(new mj1(this.e.e(), this.e.f(), jD));
                this.n = true;
            }
        }
        z = true;
        if (!this.h) {
            this.h = true;
            this.i = this.e.d() != -9223372036854775807L ? -this.m : 0L;
        }
        this.j = 4;
        this.g = 2;
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(jz0 jz0Var) {
        jz0Var.q(this.j);
        this.j = 0;
        this.g = 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }
}
