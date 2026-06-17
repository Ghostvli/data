package androidx.media3.exoplayer;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.p;
import defpackage.gg3;
import defpackage.gx3;
import defpackage.ie3;
import defpackage.jq2;
import defpackage.jq3;
import defpackage.no4;
import defpackage.t41;
import defpackage.u41;
import defpackage.x72;
import defpackage.zu;
import defpackage.zv0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements o, p {
    public final int g;
    public jq3 i;
    public int j;
    public ie3 k;
    public zu l;
    public int m;
    public gx3 n;
    public t41[] o;
    public long p;
    public long q;
    public boolean s;
    public boolean t;
    public jq2.b v;
    public p.a w;
    public final Object f = new Object();
    public final u41 h = new u41();
    public long r = Long.MIN_VALUE;
    public no4 u = no4.a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(int i) {
        this.g = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public int E() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.n.b
    public void F(int i, Object obj) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final gx3 G() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void H() {
        ((gx3) gg3.q(this.n)).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final long I() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final boolean L() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public x72 N() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zv0 P(Throwable th, t41 t41Var, int i) {
        return Q(th, t41Var, false, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zv0 Q(Throwable th, t41 t41Var, boolean z, int i) {
        int iO;
        if (t41Var == null || this.t) {
            iO = 4;
        } else {
            this.t = true;
            try {
                iO = p.O(a(t41Var));
            } catch (zv0 unused) {
                iO = 4;
            } finally {
                this.t = false;
            }
        }
        return zv0.k(th, getName(), U(), t41Var, iO, this.v, z, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final zu R() {
        return (zu) gg3.q(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final jq3 S() {
        return (jq3) gg3.q(this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final u41 T() {
        this.h.a();
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int U() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long V() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final jq2.b W() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ie3 X() {
        return (ie3) gg3.q(this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final t41[] Y() {
        return (t41[]) gg3.q(this.o);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long Z() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final no4 a0() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean b0() {
        return j() ? this.s : ((gx3) gg3.q(this.n)).isReady();
    }

    public abstract void c0();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public final int d() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d0(boolean z, boolean z2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void disable() {
        gg3.v(this.m == 1);
        this.h.a();
        this.m = 0;
        this.n = null;
        this.o = null;
        this.s = false;
        c0();
        this.v = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void f(no4 no4Var) {
        if (Objects.equals(this.u, no4Var)) {
            return;
        }
        this.u = no4Var;
        m0(no4Var);
    }

    public abstract void f0(long j, boolean z, boolean z2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final int getState() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public final void h() {
        synchronized (this.f) {
            this.w = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h0() {
        p.a aVar;
        synchronized (this.f) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final boolean j() {
        return this.r == Long.MIN_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l0(t41[] t41VarArr, long j, long j2, jq2.b bVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void m(jq3 jq3Var, t41[] t41VarArr, gx3 gx3Var, long j, boolean z, boolean z2, long j2, long j3, jq2.b bVar) {
        gg3.v(this.m == 0);
        this.i = jq3Var;
        this.v = bVar;
        this.m = 1;
        d0(z, z2);
        o(t41VarArr, gx3Var, j2, j3, bVar);
        o0(j2, z, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m0(no4 no4Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n0(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int iO = ((gx3) gg3.q(this.n)).o(u41Var, decoderInputBuffer, i);
        if (iO != -4) {
            if (iO == -5) {
                t41 t41Var = (t41) gg3.q(u41Var.b);
                if (t41Var.u != Long.MAX_VALUE) {
                    u41Var.b = t41Var.b().E0(t41Var.u + this.p).Q();
                }
            }
            return iO;
        }
        if (decoderInputBuffer.isEndOfStream()) {
            this.r = Long.MIN_VALUE;
            return this.s ? -4 : -3;
        }
        long j = decoderInputBuffer.timeUs + this.p;
        decoderInputBuffer.timeUs = j;
        this.r = Math.max(this.r, j);
        return iO;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void o(t41[] t41VarArr, gx3 gx3Var, long j, long j2, jq2.b bVar) {
        gg3.v(!this.s);
        this.n = gx3Var;
        this.v = bVar;
        if (this.r == Long.MIN_VALUE) {
            this.r = j;
        }
        this.o = t41VarArr;
        this.p = j2;
        l0(t41VarArr, j, j2, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o0(long j, boolean z, boolean z2) {
        this.s = false;
        this.q = j;
        this.r = j;
        if (!z2) {
            z2 = p0(j) != 0;
        }
        f0(j, z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p0(long j) {
        return ((gx3) gg3.q(this.n)).e(j - this.p);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void q() {
        this.s = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void release() {
        gg3.v(this.m == 0);
        g0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void reset() {
        gg3.v(this.m == 0);
        this.h.a();
        i0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void start() {
        gg3.v(this.m == 1);
        this.m = 2;
        j0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void stop() {
        gg3.v(this.m == 2);
        this.m = 1;
        k0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void t(long j, boolean z) {
        o0(j, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final void w(int i, ie3 ie3Var, zu zuVar) {
        this.j = i;
        this.k = ie3Var;
        this.l = zuVar;
        e0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final p x() {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public final void y(p.a aVar) {
        synchronized (this.f) {
            this.w = aVar;
        }
    }
}
