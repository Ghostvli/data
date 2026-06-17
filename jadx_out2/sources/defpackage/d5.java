package defpackage;

import defpackage.wt4;
import defpackage.yz3;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d5 implements hz0 {
    public static final pz0 m = new pz0() { // from class: c5
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pz0
        public final hz0[] d() {
            return d5.g();
        }
    };
    public final int a;
    public final e5 b;
    public final r73 c;
    public final r73 d;
    public final q73 e;
    public mz0 f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d5(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = new e5(true, "audio/mp4a-latm");
        this.c = new r73(2048);
        this.i = -1;
        this.h = -1L;
        r73 r73Var = new r73(10);
        this.d = r73Var;
        this.e = new q73(r73Var.f());
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: FILLED_NEW_ARRAY (wrap:d5:0x0002: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:3) call: d5.<init>():void type: CONSTRUCTOR) (LINE:7) elemType: hz0 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new d5()};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int i(int i, long j) {
        return (int) ((((long) i) * 8000000) / j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private yz3 j(long j, boolean z) {
        return new g10(j, this.h, i(this.i, this.b.k()), this.i, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.k = false;
        this.b.c();
        this.g = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.f = mz0Var;
        this.b.f(mz0Var, new wt4.d(0, 1));
        mz0Var.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        gg3.q(this.f);
        long length = jz0Var.getLength();
        int i = this.a;
        if ((i & 2) != 0 || ((i & 1) != 0 && length != -1)) {
            h(jz0Var);
        }
        int i2 = jz0Var.read(this.c.f(), 0, 2048);
        boolean z = i2 == -1;
        k(length, z);
        if (z) {
            return -1;
        }
        this.c.f0(0);
        this.c.e0(i2);
        if (!this.k) {
            this.b.e(this.g, 4);
            this.k = true;
        }
        this.b.a(this.c);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        int iL = l(jz0Var);
        int i = iL;
        int i2 = 0;
        int i3 = 0;
        do {
            jz0Var.s(this.d.f(), 0, 2);
            this.d.f0(0);
            if (e5.m(this.d.Y())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                jz0Var.s(this.d.f(), 0, 4);
                this.e.p(14);
                int iH = this.e.h(13);
                if (iH <= 6) {
                    i++;
                    jz0Var.p();
                    jz0Var.m(i);
                } else {
                    jz0Var.m(iH - 6);
                    i3 += iH;
                }
            } else {
                i++;
                jz0Var.p();
                jz0Var.m(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iL < 8192);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(jz0 jz0Var) throws r83 {
        int iH;
        if (this.j) {
            return;
        }
        this.i = -1;
        jz0Var.p();
        long j = 0;
        if (jz0Var.getPosition() == 0) {
            l(jz0Var);
        }
        int i = 0;
        int i2 = 0;
        do {
            try {
                if (!jz0Var.j(this.d.f(), 0, 2, true)) {
                    break;
                }
                this.d.f0(0);
                if (!e5.m(this.d.Y())) {
                    break;
                }
                if (!jz0Var.j(this.d.f(), 0, 4, true)) {
                    break;
                }
                this.e.p(14);
                iH = this.e.h(13);
                if (iH <= 6) {
                    this.j = true;
                    throw r83.a("Malformed ADTS stream", null);
                }
                j += (long) iH;
                i2++;
                if (i2 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (jz0Var.r(iH - 6, true));
        i = i2;
        jz0Var.p();
        if (i > 0) {
            this.i = (int) (j / ((long) i));
        } else {
            this.i = -1;
        }
        this.j = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(long j, boolean z) {
        if (this.l) {
            return;
        }
        boolean z2 = (this.a & 1) != 0 && this.i > 0;
        if (z2 && this.b.k() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.b.k() == -9223372036854775807L) {
            this.f.u(new yz3.b(-9223372036854775807L));
        } else {
            this.f.u(j(j, (this.a & 2) != 0));
        }
        this.l = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int l(jz0 jz0Var) {
        int i = 0;
        while (true) {
            jz0Var.s(this.d.f(), 0, 10);
            this.d.f0(0);
            if (this.d.T() != 4801587) {
                break;
            }
            this.d.g0(3);
            int iP = this.d.P();
            i += iP + 10;
            jz0Var.m(iP);
        }
        jz0Var.p();
        jz0Var.m(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }

    public d5() {
        this(0);
    }
}
