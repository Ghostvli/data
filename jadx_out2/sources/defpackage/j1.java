package defpackage;

import defpackage.wt4;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 implements hz0 {
    public static final pz0 d = new pz0() { // from class: i1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pz0
        public final hz0[] d() {
            return j1.g();
        }
    };
    public final k1 a = new k1("audio/ac3");
    public final r73 b = new r73(2786);
    public boolean c;

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: FILLED_NEW_ARRAY (wrap:j1:0x0002: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:3) call: j1.<init>():void type: CONSTRUCTOR) (LINE:7) elemType: hz0 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new j1()};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.c = false;
        this.a.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a.f(mz0Var, new wt4.d(0, 1));
        mz0Var.o();
        mz0Var.u(new yz3.b(-9223372036854775807L));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        int i = jz0Var.read(this.b.f(), 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.b.f0(0);
        this.b.e0(i);
        if (!this.c) {
            this.a.e(0L, 4);
            this.c = true;
        }
        this.a.a(this.b);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        r73 r73Var = new r73(10);
        int i = 0;
        while (true) {
            jz0Var.s(r73Var.f(), 0, 10);
            r73Var.f0(0);
            if (r73Var.T() != 4801587) {
                break;
            }
            r73Var.g0(3);
            int iP = r73Var.P();
            i += iP + 10;
            jz0Var.m(iP);
        }
        jz0Var.p();
        jz0Var.m(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            jz0Var.s(r73Var.f(), 0, 6);
            r73Var.f0(0);
            if (r73Var.Y() != 2935) {
                jz0Var.p();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                jz0Var.m(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iG = l1.g(r73Var.f());
                if (iG == -1) {
                    return false;
                }
                jz0Var.m(iG - 6);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }
}
