package defpackage;

import defpackage.wt4;
import defpackage.yz3;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 implements hz0 {
    public static final pz0 d = new pz0() { // from class: m1
        @Override // defpackage.pz0
        public final hz0[] d() {
            return n1.g();
        }
    };
    public final o1 a = new o1("audio/ac4");
    public final r73 b = new r73(Http2.INITIAL_MAX_FRAME_SIZE);
    public boolean c;

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new n1()};
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.c = false;
        this.a.c();
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a.f(mz0Var, new wt4.d(0, 1));
        mz0Var.o();
        mz0Var.u(new yz3.b(-9223372036854775807L));
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        int i = jz0Var.read(this.b.f(), 0, Http2.INITIAL_MAX_FRAME_SIZE);
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
            jz0Var.s(r73Var.f(), 0, 7);
            r73Var.f0(0);
            int iY = r73Var.Y();
            if (iY == 44096 || iY == 44097) {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iH = p1.h(r73Var.f(), iY);
                if (iH == -1) {
                    return false;
                }
                jz0Var.m(iH - 7);
            } else {
                jz0Var.p();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                jz0Var.m(i3);
                i2 = 0;
            }
        }
    }

    @Override // defpackage.hz0
    public void release() {
    }
}
